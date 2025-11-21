package iscteiul.ista.battleship;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GalleonTest {

    @Test
    @DisplayName("O tamanho do galeão tem de ser 5")
    void testGalleonSize() {

        Galleon g = new Galleon(Compass.NORTH, new Position(0, 0));
        assertEquals(5, g.getSize());

    }

    @Test
    @DisplayName("Posições corretas para NORTH")
    void testPositionsNorth() {

        Galleon g = new Galleon(Compass.NORTH, new Position(2, 3));

        assertEquals(new Position(2, 3), g.getPositions().get(0));
        assertEquals(new Position(2, 4), g.getPositions().get(1));
        assertEquals(new Position(2, 5), g.getPositions().get(2));
        assertEquals(new Position(3, 4), g.getPositions().get(3));
        assertEquals(new Position(4, 4), g.getPositions().get(4));

    }

    @Test
    @DisplayName("Posições corretas para SOUTH")
    void testPositionsSouth() {

        Galleon g = new Galleon(Compass.SOUTH, new Position(1, 1));

        assertEquals(new Position(1, 1), g.getPositions().get(0));
        assertEquals(new Position(2, 1), g.getPositions().get(1));
        assertEquals(new Position(3, 0), g.getPositions().get(2));
        assertEquals(new Position(3, 1), g.getPositions().get(3));
        assertEquals(new Position(3, 2), g.getPositions().get(4));

    }

    @Test
    @DisplayName("Posições corretas para EAST")
    void testPositionsEast() {

        Galleon g = new Galleon(Compass.EAST, new Position(3, 3));

        assertEquals(new Position(3, 3), g.getPositions().get(0));
        assertEquals(new Position(4, 1), g.getPositions().get(1));
        assertEquals(new Position(4, 2), g.getPositions().get(2));
        assertEquals(new Position(4, 3), g.getPositions().get(3));
        assertEquals(new Position(5, 3), g.getPositions().get(4));

    }

    @Test
    @DisplayName("Posições corretas para WEST")
    void testPositionsWest() {

        Galleon g = new Galleon(Compass.WEST, new Position(3, 3));

        assertEquals(new Position(3, 3), g.getPositions().get(0));
        assertEquals(new Position(4, 3), g.getPositions().get(1));
        assertEquals(new Position(4, 4), g.getPositions().get(2));
        assertEquals(new Position(4, 5), g.getPositions().get(3));
        assertEquals(new Position(5, 3), g.getPositions().get(4));

    }

    @Test
    @DisplayName("Tiro acerta nas 5 posições")
    void testHitsGalleon() {

        Galleon g = new Galleon(Compass.EAST, new Position(3, 3));

        g.shoot(new Position(3, 3));
        g.shoot(new Position(4, 1));
        g.shoot(new Position(4, 2));
        g.shoot(new Position(4, 3));
        g.shoot(new Position(5, 3));

        assertTrue(g.getPositions().get(0).isHit());
        assertTrue(g.getPositions().get(1).isHit());
        assertTrue(g.getPositions().get(2).isHit());
        assertTrue(g.getPositions().get(3).isHit());
        assertTrue(g.getPositions().get(4).isHit());

    }

    @Test
    @DisplayName("Tiro falhado")
    void testMissGalleon() {

        Galleon g = new Galleon(Compass.EAST, new Position(0, 0));

        g.shoot(new Position(99, 99));

        assertFalse(g.getPositions().get(0).isHit());
        assertFalse(g.getPositions().get(1).isHit());
        assertFalse(g.getPositions().get(2).isHit());
        assertFalse(g.getPositions().get(3).isHit());
        assertFalse(g.getPositions().get(4).isHit());

    }

}
