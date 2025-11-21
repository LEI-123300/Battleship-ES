package iscteiul.ista.battleship;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompassTest {

    @Test
    @DisplayName("Testar propriedades do Enum (getDirection, toString e values)")
    void testEnumProperties() {
        Compass[] values = Compass.values();
        assertEquals(5, values.length, "O Enum deve ter 5 constantes");

        assertEquals(Compass.NORTH, Compass.valueOf("NORTH"));
        assertEquals(Compass.UNKNOWN, Compass.valueOf("UNKNOWN"));

        assertEquals('n', Compass.NORTH.getDirection());
        assertEquals("n", Compass.NORTH.toString());

        assertEquals('s', Compass.SOUTH.getDirection());
        assertEquals("s", Compass.SOUTH.toString());

        assertEquals('e', Compass.EAST.getDirection());
        assertEquals("e", Compass.EAST.toString());

        assertEquals('o', Compass.WEST.getDirection());
        assertEquals("o", Compass.WEST.toString());

        assertEquals('u', Compass.UNKNOWN.getDirection());
        assertEquals("u", Compass.UNKNOWN.toString());
    }

    @Test
    @DisplayName("Testar charToCompass (100% Branch Coverage no Switch)")
    void testCharToCompassSwitch() {

        assertEquals(Compass.NORTH, Compass.charToCompass('n'));

        assertEquals(Compass.SOUTH, Compass.charToCompass('s'));

        assertEquals(Compass.EAST, Compass.charToCompass('e'));

        assertEquals(Compass.WEST, Compass.charToCompass('o'));

        assertEquals(Compass.UNKNOWN, Compass.charToCompass('x')); // Letra inválida
        assertEquals(Compass.UNKNOWN, Compass.charToCompass('u')); // O próprio 'u' cai no default ou caso específico se existisse
        assertEquals(Compass.UNKNOWN, Compass.charToCompass(' ')); // Espaço
    }
}