package practica5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaTest {

    private Carta cartaConFigura;
    private Carta cartaNumerica;

    @BeforeEach
    void setUp() {
        cartaConFigura = new Carta(Figura.A, "Corazones", 1);
        cartaNumerica = new Carta(Figura.NO, "Diamantes", 7);
    }

    @Test
    void constructorInicializaAtributosCorrectamente() {
        assertEquals(Figura.A, cartaConFigura.getFigura());
        assertEquals("Corazones", cartaConFigura.getPalo());
        assertEquals(1, cartaConFigura.getValor());
    }

    @Test
    void settersModificanLosAtributos() {
        cartaConFigura.setFigura(Figura.K);
        cartaConFigura.setPalo("Picas");
        cartaConFigura.setValor(13);

        assertEquals(Figura.K, cartaConFigura.getFigura());
        assertEquals("Picas", cartaConFigura.getPalo());
        assertEquals(13, cartaConFigura.getValor());
    }

    @Test
    void toStringMuestraFiguraCuandoLaCartaTieneFigura() {
        assertEquals("A de Corazones", cartaConFigura.toString());
    }

    @Test
    void toStringMuestraValorCuandoLaCartaEsNumerica() {
        assertEquals("7 de Diamantes", cartaNumerica.toString());
    }
}
