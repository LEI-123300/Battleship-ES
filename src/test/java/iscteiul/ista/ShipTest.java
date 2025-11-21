package iscteiul.ista;

import iscteiul.ista.battleship.Compass;
import iscteiul.ista.battleship.IPosition;
import iscteiul.ista.battleship.Position;
import iscteiul.ista.battleship.Ship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes Genéricos da Classe Abstrata Ship (JUnit 6)")
class ShipTest {

    // Classe concreta 'Stub' para testar a lógica da classe abstrata Ship
    static class StubShip extends Ship {
        public StubShip(Compass bearing, IPosition pos) {
            super("stub-ship", bearing, pos);
            // Simula um barco de tamanho 3 alinhado verticalmente para sul
            // Posições: (Row, Col), (Row+1, Col), (Row+2, Col)
            this.positions.add(pos);
            this.positions.add(new Position(pos.getRow() + 1, pos.getColumn()));
            this.positions.add(new Position(pos.getRow() + 2, pos.getColumn()));
        }

        @Override
        public Integer getSize() {
            return positions.size();
        }
    }

    private Ship ship;
    private Position startPos;

    @BeforeEach
    void setUp() {
        startPos = new Position(2, 2); // Posição inicial
        ship = new StubShip(Compass.SOUTH, startPos);
    }

    @Test
    @DisplayName("Deve instanciar com categoria, rumo e posição corretos")
    void testInitialization() {
        assertAll("Propriedades do Navio",
                () -> assertEquals("stub-ship", ship.getCategory()),
                () -> assertEquals(Compass.SOUTH, ship.getBearing()),
                () -> assertEquals(startPos, ship.getPosition()),
                () -> assertEquals(3, ship.getSize())
        );
    }

    @Test
    @DisplayName("Deve determinar se ainda flutua corretamente")
    void testStillFloating() {
        assertTrue(ship.stillFloating(), "O barco deve flutuar se intacto");

        // Atingir primeira parte
        ship.getPositions().get(0).shoot();
        assertTrue(ship.stillFloating(), "Deve flutuar se parcialmente atingido");

        // Atingir restantes partes
        ship.getPositions().get(1).shoot();
        ship.getPositions().get(2).shoot();
        assertFalse(ship.stillFloating(), "Deve afundar (false) quando todas as posições forem atingidas");
    }

    @Test
    @DisplayName("Deve calcular os limites geométricos (Bounding Box)")
    void testBoundaries() {
        // O barco ocupa (2,2), (3,2), (4,2)
        assertAll("Limites Geométricos",
                () -> assertEquals(2, ship.getTopMostPos(), "Topo"),
                () -> assertEquals(4, ship.getBottomMostPos(), "Fundo"),
                () -> assertEquals(2, ship.getLeftMostPos(), "Esquerda"),
                () -> assertEquals(2, ship.getRightMostPos(), "Direita")
        );
    }

    @Test
    @DisplayName("Deve verificar colisão/proximidade com outro navio")
    void testTooCloseToShip() {
        // Navio Stub em (2,2), (3,2), (4,2)

        // Criar navio adjacente em (2,3)
        Ship closeShip = new StubShip(Compass.SOUTH, new Position(2, 3));
        assertTrue(ship.tooCloseTo(closeShip), "Deve detetar navio adjacente (demasiado perto)");

        // Criar navio distante em (10,10)
        Ship farShip = new StubShip(Compass.SOUTH, new Position(10, 10));
        assertFalse(ship.tooCloseTo(farShip), "Não deve detetar proximidade com navio distante");
    }

    @Test
    @DisplayName("Deve processar tiro numa posição ocupada")
    void testShoot() {
        Position target = new Position(3, 2); // Meio do barco

        // Verifica pré-condição
        assertFalse(ship.getPositions().get(1).isHit());

        // Ação
        ship.shoot(target);

        // Verifica pós-condição no estado interno das posições do barco
        assertTrue(ship.getPositions().get(1).isHit(), "A posição interna do barco deve ficar marcada como atingida");
    }

    @Test
    @DisplayName("Factory method buildShip deve criar instâncias válidas")
    void testFactoryMethod() {
        // Teste simples para garantir que a factory não devolve null para tipos conhecidos
        // Nota: Requer que as subclasses (Barge, Caravel, etc.) existam no classpath
        assertNotNull(Ship.buildShip("barca", Compass.NORTH, startPos));
        assertNull(Ship.buildShip("submarino_inexistente", Compass.NORTH, startPos));
    }
}