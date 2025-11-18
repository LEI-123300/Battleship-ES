package iscteiul.ista;

import iscteiul.ista.battleship.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes Unitários da Classe Position (JUnit 6)")
class PositionTest {

    @Test
    @DisplayName("Deve inicializar corretamente as coordenadas e estado padrão")
    void testConstructorAndGetters() {
        Position pos = new Position(5, 10);

        assertAll("Estado Inicial",
                () -> assertEquals(5, pos.getRow(), "A linha deve corresponder ao valor do construtor"),
                () -> assertEquals(10, pos.getColumn(), "A coluna deve corresponder ao valor do construtor"),
                () -> assertFalse(pos.isOccupied(), "A posição não deve iniciar ocupada"),
                () -> assertFalse(pos.isHit(), "A posição não deve iniciar atingida")
        );
    }

    @Test
    @DisplayName("Deve validar a igualdade lógica entre posições")
    void testEquals() {
        Position p1 = new Position(3, 4);
        Position p2 = new Position(3, 4);
        Position p3 = new Position(5, 6);

        assertEquals(p1, p2, "Posições com as mesmas coordenadas devem ser iguais");
        assertNotEquals(p1, p3, "Posições com coordenadas diferentes não devem ser iguais");
        assertNotEquals(p1, null, "A posição não deve ser igual a null");
    }

    @Test
    @DisplayName("Deve atualizar o estado ao ocupar e atirar")
    void testStateMutation() {
        Position pos = new Position(1, 1);

        pos.occupy();
        assertTrue(pos.isOccupied(), "isOccupied() deve retornar true após occupy()");

        pos.shoot();
        assertTrue(pos.isHit(), "isHit() deve retornar true após shoot()");
    }

    @Test
    @DisplayName("Deve verificar adjacência corretamente")
    void testAdjacency() {
        Position center = new Position(5, 5);

        // Adjacentes (Distância <= 1 em qualquer eixo)
        assertAll("Posições Adjacentes",
                () -> assertTrue(center.isAdjacentTo(new Position(4, 5)), "Norte"),
                () -> assertTrue(center.isAdjacentTo(new Position(6, 5)), "Sul"),
                () -> assertTrue(center.isAdjacentTo(new Position(5, 4)), "Oeste"),
                () -> assertTrue(center.isAdjacentTo(new Position(5, 6)), "Este"),
                () -> assertTrue(center.isAdjacentTo(new Position(6, 6)), "Diagonal"),
                () -> assertTrue(center.isAdjacentTo(center), "Própria posição")
        );

        // Não Adjacentes
        assertAll("Posições Distantes",
                () -> assertFalse(center.isAdjacentTo(new Position(3, 5)), "Distante verticalmente"),
                () -> assertFalse(center.isAdjacentTo(new Position(5, 7)), "Distante horizontalmente")
        );
    }

    @Test
    @DisplayName("ToString deve conter informações de linha e coluna")
    void testToString() {
        Position pos = new Position(8, 9);
        String output = pos.toString();
        assertTrue(output.contains("8") && output.contains("9"),
                "A representação textual deve conter os valores das coordenadas");
    }


}