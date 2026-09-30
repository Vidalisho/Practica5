package practica5;

import practica6.Square;
import practica6.Circle;
import practica6.Triangle;

public class Visualizador {

    //posiciones iniciales de cada figura
    private static final int SQUARE_X = 60, SQUARE_Y = 50;
    private static final int CIRCLE_X = 20, CIRCLE_Y = 60;
    private static final int TRIANGLE_X = 50, TRIANGLE_Y = 15;

    private static final int ANCHO = 90;

    public static void carta(Carta c, Posicion p) {
        int x = p.getX();
        int y = p.getY();

        //orilla y fondo de la carta
        dibujarCuadro(x, y, ANCHO, "black");
        dibujarCuadro(x + 2, y + 2, ANCHO - 4, "white");

        // Color y figura segun el palo
        String color = esRojo(c.getPalo()) ? "red" : "black";

        // Mostrar el valor como figuras pequeñas (A = 1, J = 11, Q = 12, K = 13)
        int cantidad = c.getValor();
        int columnas = 5;
        for (int i = 0; i < cantidad; i++) {
            int fx = x + 8 + (i % columnas) * 16;
            int fy = y + 8 + (i / columnas) * 16;
            dibujarSimbolo(c.getPalo(), fx, fy, color);
        }
    }

    private static boolean esRojo(String palo) {
        return palo.equals("Corazones") || palo.equals("Diamantes");
    }

    private static void dibujarCuadro(int x, int y, int lado, String color) {
        Square s = new Square();
        s.changeSize(lado);
        s.changeColor(color);
        s.moveHorizontal(x - SQUARE_X);
        s.moveVertical(y - SQUARE_Y);
        s.makeVisible();
    }

    private static void dibujarSimbolo(String palo, int x, int y, String color) {
        switch (palo) {
            case "Corazones":   //circulo
                Circle circ = new Circle();
                circ.changeSize(12);
                circ.changeColor(color);
                circ.moveHorizontal(x - CIRCLE_X);
                circ.moveVertical(y - CIRCLE_Y);
                circ.makeVisible();
                break;
            case "Diamantes":   //triangulo rojo
                Triangle tri = new Triangle();
                tri.changeSize(12, 12);
                tri.changeColor(color);
                tri.moveHorizontal(x - TRIANGLE_X);
                tri.moveVertical(y - TRIANGLE_Y);
                tri.makeVisible();
                break;
            default:            //treboles y Picas: cuadrado negro
                Square sq = new Square();
                sq.changeSize(12);
                sq.changeColor(color);
                sq.moveHorizontal(x - SQUARE_X);
                sq.moveVertical(y - SQUARE_Y);
                sq.makeVisible();
                break;
        }
    }
}