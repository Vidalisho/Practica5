package practica5;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MazoTest {

    private Mazo mazo;

    @BeforeEach
    void setUp() {
        mazo = new Mazo();
    }

    @Test
    void mazoInicialTiene52Cartas() {
        assertEquals(52, mazo.getCartas().size());
        assertEquals(52, mazo.cantidadCartas());
    }

    @Test
    void barajarNoCambiaLaCantidadDeCartas() {
        mazo.barajarCartas();
        assertEquals(52, mazo.cantidadCartas());
    }

    @Test
    void repartirCartaReduceElMazoEnUno() {
        Carta carta = mazo.repartirCarta();
        assertNotNull(carta);
        assertEquals(51, mazo.cantidadCartas());
    }

    @Test
    void repartirCartaDeMazoVacioRegresaNull() {
        for (int i = 0; i < 52; i++) {
            mazo.repartirCarta();
        }
        assertTrue(mazo.estaVacio());
        assertNull(mazo.repartirCarta());
    }

    @Test
    void agregarACimaAumentaElMazoYQuedaHastaArriba() {
        Carta carta = mazo.repartirCarta();
        mazo.agregarACima(carta);
        assertEquals(52, mazo.cantidadCartas());
        assertEquals(carta, mazo.getCartas().get(0));
    }

    @Test
    void reiniciarCartasRegresaElMazoA52Cartas() {
        mazo.repartirCarta();
        mazo.repartirCarta();
        mazo.reiniciarCartas();
        assertEquals(52, mazo.cantidadCartas());
    }

    @Test
    void repartirCartasAJugadoresLesDaLaCantidadCorrecta() {
        Jugador j1 = new Jugador("Ana");
        Jugador j2 = new Jugador("Luis");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(j1);
        jugadores.add(j2);

        mazo.repartirCartas(jugadores, 5);

        assertEquals(5, j1.cantidadCartas());
        assertEquals(5, j2.cantidadCartas());
        assertEquals(42, mazo.cantidadCartas());
    }

    @Test
    void repartirCartasSeDetieneSiElMazoSeQuedaSinCartas() {
        Jugador j1 = new Jugador("Ana");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(j1);

        mazo.repartirCartas(jugadores, 100); // más cartas de las que existen

        assertEquals(52, j1.cantidadCartas());
        assertTrue(mazo.estaVacio());
    }
}
