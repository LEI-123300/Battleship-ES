package iscteiul.ista.battleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("Deve testar igualdade de posições")
    void testEquals() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(1, 2);
        Position p3 = new Position(3, 4);

        assertEquals(p1, p1, "Deve ser igual a si próprio");
        assertEquals(p1, p2, "Deve ser igual a outra posição com as mesmas coordenadas");
        assertNotEquals(p1, p3, "Deve ser diferente de coordenadas diferentes");
        assertNotEquals(p1, null, "Deve ser diferente de null");
        assertNotEquals(p1, "String", "Deve ser diferente de outra classe");
    }

    @Test
    @DisplayName("Deve formatar toString corretamente")
    void testToString() {
        Position p = new Position(5, 5);
        assertNotNull(p.toString());
        assertFalse(p.toString().isEmpty());
    }
}