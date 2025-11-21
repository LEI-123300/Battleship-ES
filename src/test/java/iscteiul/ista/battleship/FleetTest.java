package iscteiul.ista.battleship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FleetTest {

    private Fleet fleet;

    @BeforeEach
    void setUp() {
        fleet = new Fleet();
    }

    @Test
    @DisplayName("Deve inicializar a frota vazia")
    void testNewFleetIsEmpty(){
        assertTrue(fleet.getShips().isEmpty(), "A frota deve estar vazia");
    }

    @Test
    @DisplayName("Deve adicionar um navio válido com sucesso")
    void testAddValidShip(){
        Position pos = new Position(0, 0);
        IShip ship = new Barge(Compass.NORTH, pos);
        boolean added = fleet.addShip(ship);
        assertTrue(added, "Deve retornar true quando se insere um navio válido");
        assertEquals(1, fleet.getShips().size(), "A frota deve ter 1 navio");
        assertEquals(ship, fleet.shipAt(pos), "O navio deve ser encontrado na posição onde foi colocado");
    }
    @Test
    @DisplayName("Não deve adicionar navio fora dos limites do tabuleiro")
    void testAddShipOutOfBounds() {
        Position pos = new Position(10, 10);
        IShip ship = new Barge(Compass.NORTH, pos);
        boolean added = fleet.addShip(ship);
        assertFalse(added, "Não deve aceitar navios fora do tabuleiro");
        assertTrue(fleet.getShips().isEmpty(), "A frota deve continuar vazia");
    }

    @Test
    @DisplayName("Não deve adicionar navios sobrepostos ou adjacentes (Colisão)")
    void testAddShipCollision() {
        Position pos1 = new Position(5, 5);
        IShip ship1 = new Barge(Compass.NORTH, pos1);
        fleet.addShip(ship1);
        IShip shipOnTop = new Barge(Compass.NORTH, new Position(5, 5));
        boolean addedOnTop = fleet.addShip(shipOnTop);
        assertFalse(addedOnTop, "Não deve permitir navios sobrepostos");
        IShip shipAdjacent = new Barge(Compass.NORTH, new Position(5, 6));
        boolean addedAdjacent = fleet.addShip(shipAdjacent);
        assertFalse(addedAdjacent, "Não deve permitir navios encostados (tooCloseTo)");
        assertEquals(1, fleet.getShips().size(), "A frota só deve ter o primeiro navio");
    }

    @Test
    @DisplayName("Deve listar navios por categoria")
    void testGetShipsLike() {
        fleet.addShip(new Barge(Compass.NORTH, new Position(0, 0)));
        fleet.addShip(new Barge(Compass.NORTH, new Position(2, 2)));
        fleet.addShip(new Frigate(Compass.NORTH, new Position(5, 5))); // Fragata é diferente de Barca
        List<IShip> barges = fleet.getShipsLike("Barca");
        assertEquals(2, barges.size(), "Deve encontrar 2 Barcas");
    }

    @Test
    @DisplayName("Deve gerir navios flutuantes vs afundados")
    void testFloatingShips() {
        Position pos = new Position(0, 0);
        IShip ship = new Barge(Compass.NORTH, pos); // Tamanho 1
        fleet.addShip(ship);
        assertEquals(1, fleet.getFloatingShips().size());
        ship.shoot(pos);
        assertTrue(fleet.getFloatingShips().isEmpty(), "Não deve haver navios flutuantes após serem afundados");
        assertEquals(1, fleet.getShips().size(), "O navio continua na frota, mesmo afundado");
    }

    @Test
    @DisplayName("Verificação de Capacidade Máxima da Frota")
    void testFleetCapacity() {
        // Adiciona 10 navios garantindo que nao se tocam
        for (int i = 0; i < 5; i++) {
            fleet.addShip(new Barge(Compass.NORTH, new Position(0, i * 2)));
        }
        for (int i = 0; i < 5; i++) {
            fleet.addShip(new Barge(Compass.NORTH, new Position(2, i * 2)));
        }
        assertEquals(10, fleet.getShips().size(), "Deve ter 10 navios na frota");
        boolean added11 = fleet.addShip(new Barge(Compass.NORTH, new Position(4, 0)));
        assertFalse(added11, "Não deve permitir adicionar mais que o limite da frota (10)");
    }

    @Test
    @DisplayName("Deve conseguir adicionar navios de tipos diferentes")
    void testAddAllShipTypes() {
        fleet.addShip(new Caravel(Compass.NORTH, new Position(0,0)));
        fleet.addShip(new Carrack(Compass.NORTH, new Position(2,2)));
        fleet.addShip(new Galleon(Compass.NORTH, new Position(5,5)));
        assertEquals(3, fleet.getShips().size());
    }

    @Test
    @DisplayName("Verificação dos métodos print")
    void testPrintMethods() {
        fleet.addShip(new Barge(Compass.NORTH, new Position(0,0)));

        assertDoesNotThrow(() -> fleet.printStatus());
        assertDoesNotThrow(() -> fleet.printFloatingShips());
    }

    @Test
    @DisplayName("Deve retornar null quando procura navio em posição vazia")
    void testShipAtEmptyPosition() {
        assertNull(fleet.shipAt(new Position(0, 0)), "Deve retornar null se não houver navio lá");
    }

    @Test
    @DisplayName("Não deve adicionar navios com coordenadas negativas (Limites Inferiores)")
    void testAddShipNegativeCoordinates() {
        assertFalse(fleet.addShip(new Barge(Compass.NORTH, new Position(-1, 0))), "Não deve aceitar linhas negativas");
        assertFalse(fleet.addShip(new Barge(Compass.NORTH, new Position(0, -1))), "Não deve aceitar colunas negativas");
    }

    @Test
    @DisplayName("Verifica impressão de categoria inexistente")
    void testPrintCategoryEmpty() {
        fleet.addShip(new Barge(Compass.NORTH, new Position(0,0)));
        assertDoesNotThrow(() -> fleet.printShipsByCategory("Submarino"));
    }

    @Test
    @DisplayName("Não deve adicionar navios com coordenadas negativas")
    void testAddShipNegative() {
        assertFalse(fleet.addShip(new Barge(Compass.NORTH, new Position(-1, 0))));
        assertFalse(fleet.addShip(new Barge(Compass.NORTH, new Position(0, -1))));
    }

    @Test
    @DisplayName("Não deve adicionar navio abaixo do limite inferior (Bottom > 9)")
    void testAddShipBottomOutOfBounds() {
        Position pos = new Position(10, 5);
        IShip ship = new Barge(Compass.NORTH, pos);
        assertFalse(fleet.addShip(ship));
    }
}