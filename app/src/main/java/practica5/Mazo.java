package practica5;
import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private final ArrayList<Carta> cartas;

    //constructor para crear y llenar mi mazo de cartas
    public Mazo() {
        cartas=new ArrayList<>();
        llenarMazo();
    }

    //metodo para llenar el mazo de cartas
    private void llenarMazo() {
        String[] PALOS = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        for (String palo : PALOS) {
            for (int i = 1; i <= 13; i++) {
                Figura figura = Figura.NO;
                if (i == 1) {
                    figura = Figura.A;
                } else if (i == 11) {
                    figura = Figura.J;
                } else if (i == 12) {
                    figura = Figura.Q;
                } else if (i == 13) {
                    figura = Figura.K;
                }
                Carta carta = new Carta(figura, palo, i);
                cartas.add(carta);
            }
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void barajarCartas(){
        Collections.shuffle(cartas);
    }

    public void mostrarCartas(){
        for(Carta carta: cartas){
            System.out.println("Figura: "+carta.getFigura()+", Palo: "+carta.getPalo()+", Valor: "+carta.getValor());
        }
    }

    //reiniciar el mazo de cartas usa de nuevo lo que se hizo en el constructor solo que primero limpio el arreglo
    public void reiniciarCartas(){
        cartas.clear();
        llenarMazo();
    }
    
    //metodo para repartir cartas (tambien se puede usara para sacar una especifica de la pila)
    public Carta repartirCarta(){
        if(cartas.isEmpty()){
            return null;
        }
        return cartas.remove(0);
    }

    //repartir cartas en general a los jugadores 
    public void repartirCartas(ArrayList<Jugador> jugadores, int cartasPorJugador) {
        if (jugadores == null || jugadores.isEmpty() || cartasPorJugador <= 0) {
            return;
        }
        for (int ronda = 0; ronda < cartasPorJugador; ronda++) {
            for (Jugador jugador : jugadores) {
                Carta carta = repartirCarta();
                if (carta == null) {
                    System.out.println("No hay más cartas en el mazo para repartir.");
                    return;
                }
                jugador.recibirCarta(carta);
            }
        }
    }

    //metodo para anyadir cartas a la pila
    public void agregarACima(Carta carta){
        cartas.add(0,carta);
    }

    public int cantidadCartas() {
        return cartas.size();
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }
}
