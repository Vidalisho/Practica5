package practica5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Conjunto de pruebas para la clase {@link Jugador}.
 */
class JugadorTest {

    private Jugador jugador;
    private Carta cartaA;
    private Carta cartaK;

    @BeforeEach
    void setUp() {
        jugador = new Jugador("Ana");
        cartaA = new Carta(Figura.A, "Corazones", 1);
        cartaK = new Carta(Figura.K, "Picas", 13);
    }

    @Test
    void recibirCartaAgregaLaCartaALaMano() {
        jugador.recibirCarta(cartaA);
        assertEquals(1, jugador.cantidadCartas());
        assertTrue(jugador.getMano().contains(cartaA));
    }

    @Test
    void recibirCartaNulaNoAgregaNada() {
        jugador.recibirCarta(null);
        assertEquals(0, jugador.cantidadCartas());
    }

    @Test
    void deshacerseDeCartaPorObjetoLaRemueve() {
        jugador.recibirCarta(cartaA);
        jugador.recibirCarta(cartaK);

        boolean removida = jugador.deshacerseDeCarta(cartaA);

        assertTrue(removida);
        assertEquals(1, jugador.cantidadCartas());
        assertFalse(jugador.getMano().contains(cartaA));
    }

    @Test
    void deshacerseDeCartaPorIndiceRegresaLaCartaCorrecta() {
        jugador.recibirCarta(cartaA);
        jugador.recibirCarta(cartaK);

        Carta removida = jugador.deshacerseDeCarta(0);

        assertEquals(cartaA, removida);
        assertEquals(1, jugador.cantidadCartas());
    }

    @Test
    void deshacerseDeCartaConIndiceInvalidoRegresaNull() {
        assertNull(jugador.deshacerseDeCarta(0));
        assertNull(jugador.deshacerseDeCarta(-1));
    }

    @Test
    void toStringIncluyeNombreYCartas() {
        jugador.recibirCarta(cartaA);
        String info = jugador.toString();

        assertTrue(info.contains("Ana"));
        assertTrue(info.contains("A de Corazones"));
    }

    @Test
    void toStringIndicaCuandoNoHayCartas() {
        String info = jugador.toString();
        assertTrue(info.contains("sin cartas"));
    }
}
