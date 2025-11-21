package iscteiul.ista.battleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;
    private Fleet fleet;

    @BeforeEach
    void setUp() {
        fleet = new Fleet();
        fleet.addShip(new Barge(Compass.NORTH, new Position(0, 0)));
        game = new Game(fleet);
    }

    @Test
    @DisplayName("Deve acertar num navio (HIT)")
    void testFireHit() {
        IShip hitShip = game.fire(new Position(0, 0));
        assertNotNull(hitShip, "O tiro devia ter acertado");
        assertEquals(1, game.getHits(), "Contador de hits deve ser 1");
        assertEquals("barca", hitShip.getCategory().toLowerCase(), "Deve ter acertado na barca");
    }

    @Test
    @DisplayName("Deve falhar o alvo (MISS)")
    void testFireMiss() {
        IShip hitShip = game.fire(new Position(5, 5));
        assertNull(hitShip, "O tiro devia ter falhado");
        assertEquals(0, game.getHits(), "Contador de hits deve ser 0");
        assertTrue(game.getShots().contains(new Position(5,5)));
    }

    @Test
    @DisplayName("Deve afundar o navio")
    void testSinkShip() {
        game.fire(new Position(0, 0));
        assertEquals(1, game.getSunkShips(), "Deve ter 1 navio afundado");
        assertEquals(0, game.getRemainingShips(), "Não devem sobrar navios");
    }

    @Test
    @DisplayName("Deve contar tiros repetidos")
    void testRepeatedShot() {
        Position p = new Position(2, 2);
        game.fire(p); // 1º tiro
        game.fire(p); // 2º tiro (repetido)
        assertEquals(1, game.getRepeatedShots(), "Deve contar 1 tiro repetido");
    }

    @Test
    @DisplayName("Deve rejeitar tiros fora do tabuleiro")
    void testInvalidShot() {
        game.fire(new Position(20, 20));
        assertEquals(1, game.getInvalidShots(), "Deve contar como tiro inválido");
    }

    @Test
    @DisplayName("Deve imprimir o estado do jogo (Cobertura de métodos void)")
    void testPrintMethods() {
        assertDoesNotThrow(() -> game.printValidShots());
        assertDoesNotThrow(() -> game.printFleet());
    }

    @Test
    @DisplayName("Branch Coverage: Acertar num navio SEM o afundar")
    void testHitButNotSink() {
        fleet = new Fleet();
        IShip frigate = new Frigate(Compass.NORTH, new Position(0, 0));
        fleet.addShip(frigate);
        game = new Game(fleet);
        IShip hitShip = game.fire(new Position(0, 0));

        assertNotNull(hitShip);
        assertEquals(1, game.getHits());
        assertEquals(0, game.getSunkShips(), "Não deve ter afundado ainda");
    }
}