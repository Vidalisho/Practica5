package practica5;

public class Juego {
    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        System.out.println("Mazo inicial:");
        mazo.mostrarCartas();

        mazo.barajarCartas();
        System.out.println("\nMazo barajado:");
        mazo.mostrarCartas();

        mazo.reiniciarCartas();
        System.out.println("\nMazo reiniciado:");
        mazo.mostrarCartas();
    }
    
}
