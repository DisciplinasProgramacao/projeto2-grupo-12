package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;


class AppTest {
    
    GrafoCompleto g;

    @BeforeEach
    void setUp() {
        g = new GrafoCompleto("Gabriel Estevão", 10);
    }

    @Test
    void testGrafoCompleto() {
        assertTrue(g.completo());
    }

    @Test
    void testAddVertice() {
       assertFalse(g.addVertice(10));
    }

    @Test
    void testTamanho() {
      assertEquals(45, g.tamanho());
    }

    @Test
    void testOrdem() {
      assertEquals(10, g.ordem());
    }

}
