package iscteiul.ista.battleship;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarrackTest {
   
    @Test
    @DisplayName("O tamanho da Caravel tem de ser 2")
    void testCarrackSize() {
        Carrack c = new Carrack(Compass.NORTH, new Position(0,0));
        assertEquals(3, c.getSize());
    }

    @Test
    @DisplayName("posições corretas em orientação NORTH")
    void testPositionsNorth() {
        Carrack c = new Carrack(Compass.NORTH, new Position(4,4));

        assertEquals(new Position(4,4), c.getPositions().get(0));
        assertEquals(new Position(5,4), c.getPositions().get(1));
        assertEquals(new Position(6,4), c.getPositions().get(2));
    }

    @Test
    @DisplayName("Carrack EAST ocupa (r,c), (r,c+1), (r,c+2)")
    void testEastPositions() {
        Carrack c = new Carrack(Compass.EAST, new Position(1,1));

        assertEquals(new Position(1,1), c.getPositions().get(0));
        assertEquals(new Position(1,2), c.getPositions().get(1));
        assertEquals(new Position(1,3), c.getPositions().get(2));
    }   

    @Test
    @DisplayName("shoot acerta nas 3 posições")
    void testHitsCarrack() {
        Carrack c = new Carrack(Compass.EAST, new Position(1,1));

        c.shoot(new Position(1,1));
        c.shoot(new Position(1,2));
        c.shoot(new Position(1,3));

        assertTrue(c.getPositions().get(0).isHit());
        assertTrue(c.getPositions().get(1).isHit());
        assertTrue(c.getPositions().get(2).isHit());
    }

    @Test
    @DisplayName("tiro falhado não afeta nenhuma posição")
    void testMissCarack() {
        Carrack c = new Carrack(Compass.SOUTH, new Position(0,0));

        c.shoot(new Position(99,99));

        assertFalse(c.getPositions().get(0).isHit());
        assertFalse(c.getPositions().get(1).isHit());
        assertFalse(c.getPositions().get(2).isHit());
    }
}