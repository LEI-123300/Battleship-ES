package iscteiul.ista.battleship;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CaravelTest {
    
    @Test
    @DisplayName("O tamanho da Caravel tem de ser 2")
    void testCaravelSize() {
        Caravel c = new Caravel(Compass.EAST, new Position(0,0));
        assertEquals(2, c.getSize());
    }

    @Test
    @DisplayName("Caravel -> orientação SOUTH ocupa (r,c) e (r+1,c)")
    void testPositionsSouth() {
        Caravel c = new Caravel(Compass.SOUTH, new Position(5,4));

        assertEquals(new Position(5,4), c.getPositions().get(0));
        assertEquals(new Position(6,4), c.getPositions().get(1));
    }

    @Test
    @DisplayName("Caravel EAST ocupa (r,c) e (r,c+1)")
    void testEastPositions() {
        Caravel c = new Caravel(Compass.EAST, new Position(2,3));

        assertEquals(new Position(2,3), c.getPositions().get(0));
        assertEquals(new Position(2,4), c.getPositions().get(1));
    }

    @Test
    void testHitsCaravel() {
        Caravel c = new Caravel(Compass.EAST, new Position(2,2));

        c.shoot(new Position(2,2)); 
        c.shoot(new Position(2,3));

        assertTrue(c.getPositions().get(0).isHit());
        assertTrue(c.getPositions().get(1).isHit());
    }

    @Test
    @DisplayName("tiro falhado não afeta nenhuma posição")
    void testMissCaravel() {
        Caravel c = new Caravel(Compass.EAST, new Position(1,1));

        c.shoot(new Position(10,10));

        assertFalse(c.getPositions().get(0).isHit());
        assertFalse(c.getPositions().get(1).isHit());
    }
}
