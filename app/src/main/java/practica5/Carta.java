package practica5;

public class Carta{
    private Figura figura; //se utilizo el enum de figura
    private String palo;
    private int valor;

    public Carta(Figura figura, String palo, int valor){
        this.figura=figura;
        this.palo=palo;
        this.valor=valor;
    }

    //setter y getters
    public Figura getFigura(){
        return figura;
    }
    public void setFigura(Figura figura){
        this.figura=figura;
    }

    public String getPalo(){
        return palo;
    }
    public void setPalo(String palo){
        this.palo=palo;
    }

    public int getValor(){
        return valor;
    }
    public void setValor(int valor){
        this.valor=valor;
    }
}