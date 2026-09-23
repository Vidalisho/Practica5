package practica5;
import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private ArrayList<Carta> cartas;

    //constructor para crear y llenar mi mazo de cartas
    public Mazo() {
        cartas=new ArrayList<>();

        String[] palos={"Corazones","Diamantes","Tréboles","Picas"};
        for(String palo: palos){
            for(int i=1;i<=13;i++){
                Figura figura=Figura.NO;
                if(i==1){
                    figura=Figura.A;
                }else if(i==11){
                    figura=Figura.J;
                }else if(i==12){
                    figura=Figura.Q;
                }else if(i==13){
                    figura=Figura.K;
                }
                Carta carta=new Carta(figura,palo,i);
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

    public void reiniciarCartas(){
        cartas.clear();
        String[] palos={"Corazones","Diamantes","Tréboles","Picas"};
        for(String palo: palos){
            for(int i=1;i<=13;i++){
                Figura figura=Figura.NO;
                if(i==1){
                    figura=Figura.A;
                }else if(i==11){
                    figura=Figura.J;
                }else if(i==12){
                    figura=Figura.Q;
                }else if(i==13){
                    figura=Figura.K;
                }
                Carta carta=new Carta(figura,palo,i);
                cartas.add(carta);
            }
        }
    }
}
