package iscteiul.ista.battleship;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BargeTest {

    //O objetivo é testar se o barco tem tamanho = 1
    @Test
    @DisplayName("Tamanho do Barge deve ser 1")
    void testBargeSize() {
        Barge b = new Barge(Compass.EAST, new Position(0,0));
        assertEquals(1, b.getSize());
    }

    @Test
    @DisplayName("O Barge ocupa apenas a poisção incial")
    void testBargePosition(){
        Position p = new Position(3, 5);
        Barge b = new Barge(Compass.NORTH, p);
        assertEquals(1, b.getPositions().size());
        assertEquals(p, b.getPositions().get(0));
    }

    @Test
    @DisplayName("Tiro acerta")
    void testHit() {
        Barge b = new Barge(Compass.SOUTH, new Position(2,2));
        b.shoot(new Position(2,2)); // HIT
        assertTrue(b.getPositions().get(0).isHit());
    }

    @Test
    @DisplayName("Tiro Falha")
    void testMIss() {
        Barge b = new Barge(Compass.SOUTH, new Position(2,2));
        b.shoot(new Position(3,3)); // MISS
        assertFalse(b.getPositions().get(0).isHit());
    }


}