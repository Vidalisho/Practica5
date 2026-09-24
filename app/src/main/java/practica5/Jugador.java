package practica5;
import java.util.ArrayList;

public class Jugador {
    public String nombre;
    private ArrayList<Carta> mano;

    public Jugador(String nombre){
        this.nombre=nombre;
        mano=new ArrayList<>();
    }

    public void recibirCarta(Carta carta) {
        if (carta != null) {
            mano.add(carta);
        }
    }

    public boolean deshacerseDeCarta(Carta carta) {
        return mano.remove(carta);
    }

    public Carta deshacerseDeCarta(int indice) {
        if (indice < 0 || indice >= mano.size()) {
            return null;
        }
        return mano.remove(indice);
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public int cantidadCartas() {
        return mano.size();
    }

    public void mostrarInfo(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Mano:");
        for(Carta hand : mano){
            System.out.println(hand);
        }
    }
}
