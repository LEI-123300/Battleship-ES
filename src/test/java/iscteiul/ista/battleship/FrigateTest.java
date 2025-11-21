package iscteiul.ista.battleship;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

    public class FrigateTest {

        @Test
        @DisplayName("O tamanho da fragata tem de ser 4")
        void testFrigateSize() {

            Frigate f = new Frigate(Compass.NORTH, new Position(0,0));
            assertEquals(4, f.getSize());

        }

        @Test
        @DisplayName("Posições corretas para NORTH")
        void testPositionsNorth() {

            Frigate f = new Frigate(Compass.NORTH, new Position(4,4));

            assertEquals(new Position(4,4), f.getPositions().get(0));
            assertEquals(new Position(5,4), f.getPositions().get(1));
            assertEquals(new Position(6,4), f.getPositions().get(2));
            assertEquals(new Position(7,4), f.getPositions().get(3));

        }

        @Test
        @DisplayName("Posições corretas para EAST")
        void testEastPositions() {

            Frigate f = new Frigate(Compass.EAST, new Position(1,1));

            assertEquals(new Position(1,1), f.getPositions().get(0));
            assertEquals(new Position(1,2), f.getPositions().get(1));
            assertEquals(new Position(1,3), f.getPositions().get(2));
            assertEquals(new Position(1,4), f.getPositions().get(3));

        }

        @Test
        @DisplayName("Tiro acerta nas 4 posições")
        void testHit() {

            Frigate f = new Frigate(Compass.EAST, new Position(1,1));

            f.shoot(new Position(1,1));
            f.shoot(new Position(1,2));
            f.shoot(new Position(1,3));
            f.shoot(new Position(1,4));

            assertTrue(f.getPositions().get(0).isHit());
            assertTrue(f.getPositions().get(1).isHit());
            assertTrue(f.getPositions().get(2).isHit());
            assertTrue(f.getPositions().get(3).isHit());

        }

        @Test
        @DisplayName("Tiro falhado")
        void testMiss() {

            Frigate f = new Frigate(Compass.SOUTH, new Position(0,0));

            f.shoot(new Position(99,99));

            assertFalse(f.getPositions().get(0).isHit());
            assertFalse(f.getPositions().get(1).isHit());
            assertFalse(f.getPositions().get(2).isHit());
            assertFalse(f.getPositions().get(3).isHit());

        }
    }