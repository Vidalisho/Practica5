package practica5;
import java.util.ArrayList;

public class Juego {
    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        System.out.println("Mazo inicial:");
        mazo.mostrarCartas();
        System.out.println("\nCantidad de cartas en el mazo: " + mazo.cantidadCartas());

        mazo.barajarCartas();
        System.out.println("\nMazo barajado:");
        mazo.mostrarCartas();

        Jugador jugador1=new Jugador("Esteban");
        Jugador jugador2=new Jugador("Vidal");
        ArrayList<Jugador> jugadores=new ArrayList<>();
        jugadores.add(jugador1); jugadores.add(jugador2);
        
        int cartasPorJugador=5;
        mazo.repartirCartas(jugadores, cartasPorJugador);
        System.out.println("\nCartas repartidas a los jugadores:");
        for(Jugador jugador:jugadores){
            jugador.mostrarInfo();
            System.out.println();
        }
        System.out.println("Cartas restantes en el mazo: " + mazo.cantidadCartas());


        Carta cartaDescartada = jugador1.deshacerseDeCarta(0);
        if (cartaDescartada != null) {
            System.out.println("\n" + jugador1.nombre + " se deshace de la carta: " + cartaDescartada);
            mazo.agregarACima(cartaDescartada);
        }

        System.out.println("Estado del mazo:");
        mazo.mostrarCartas();
        System.out.println("Cartas en el mazo: " + mazo.cantidadCartas());

        mazo.reiniciarCartas();
        System.out.println("\nMazo reiniciado");
        mazo.mostrarCartas();
        System.out.println("Cartas en el mazo: " + mazo.cantidadCartas());
    }
    
}
