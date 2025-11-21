package iscteiul.ista.battleship;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShipTest {

    @Test
    @DisplayName("Factory: Deve construir os navios corretos pelo nome (Cobre Switch)")
    void testBuildShipFactory() {
        Position pos = new Position(0, 0);

        IShip barge = Ship.buildShip("barca", Compass.NORTH, pos);
        assertTrue(barge instanceof Barge, "Deve criar uma Barca");

        IShip caravel = Ship.buildShip("caravela", Compass.NORTH, pos);
        assertTrue(caravel instanceof Caravel, "Deve criar uma Caravela");

        IShip carrack = Ship.buildShip("nau", Compass.NORTH, pos);
        assertTrue(carrack instanceof Carrack, "Deve criar uma Nau");

        IShip frigate = Ship.buildShip("fragata", Compass.NORTH, pos);
        assertTrue(frigate instanceof Frigate, "Deve criar uma Fragata");

        IShip galleon = Ship.buildShip("galeao", Compass.NORTH, pos);
        assertTrue(galleon instanceof Galleon, "Deve criar um Galeão");

        IShip invalid = Ship.buildShip("submarino", Compass.NORTH, pos);
        assertNull(invalid, "Deve retornar null para nomes desconhecidos");
    }

    @Test
    @DisplayName("Lógica: tooCloseTo (Navio vs Posição)")
    void testTooCloseToPosition() {
        IShip ship = new Barge(Compass.NORTH, new Position(5, 5));

        assertTrue(ship.tooCloseTo(new Position(5, 5)), "A própria posição é tooClose");
        assertTrue(ship.tooCloseTo(new Position(4, 5)), "Adjacente Norte é tooClose");

        assertFalse(ship.tooCloseTo(new Position(0, 0)), "Posição distante não é tooClose");
    }

    @Test
    @DisplayName("Lógica: tooCloseTo (Navio vs Navio)")
    void testTooCloseToOtherShip() {
        IShip ship1 = new Barge(Compass.NORTH, new Position(5, 5));
        IShip ship2 = new Barge(Compass.NORTH, new Position(5, 6));
        IShip ship3 = new Barge(Compass.NORTH, new Position(0, 0));

        assertTrue(ship1.tooCloseTo(ship2), "Navios vizinhos devem estar tooClose");

        assertFalse(ship1.tooCloseTo(ship3), "Navios distantes não devem estar tooClose");
    }

    @Test
    @DisplayName("Lógica: stillFloating")
    void testStillFloating() {
        IShip ship = new Caravel(Compass.SOUTH, new Position(0, 0));

        assertTrue(ship.stillFloating());

        ship.shoot(new Position(0, 0));
        assertTrue(ship.stillFloating());

        ship.shoot(new Position(1, 0));
        assertFalse(ship.stillFloating());
    }

    @Test
    @DisplayName("Lógica: shoot e occupies")
    void testShootLogic() {
        IShip ship = new Barge(Compass.NORTH, new Position(2, 2));

        assertTrue(ship.occupies(new Position(2, 2)));
        assertFalse(ship.occupies(new Position(3, 3)));

        ship.shoot(new Position(2, 2));
        assertFalse(ship.stillFloating());
        ship.shoot(new Position(9, 9));
    }

    @Test
    @DisplayName("Lógica: Limites (Getters)")
    void testBoundaries() {
        IShip ship = new Caravel(Compass.SOUTH, new Position(5, 5));

        assertEquals(5, ship.getTopMostPos());    // Linha mínima
        assertEquals(6, ship.getBottomMostPos()); // Linha máxima
        assertEquals(5, ship.getLeftMostPos());   // Coluna mínima
        assertEquals(5, ship.getRightMostPos());  // Coluna máxima
    }
}