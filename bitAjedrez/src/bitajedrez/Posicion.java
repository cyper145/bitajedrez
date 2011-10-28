package bitajedrez;

public class Posicion{
    //char letra;
    //int numero;
    String posicion;
    int fila;
    int columna;

    public Posicion(String posicion) {
        //Fila y columna
        this.fila = (int) posicion.charAt(1) - 49;
        this.columna = (int) posicion.charAt(0) - 97;
        //Posicion tipo E4
        this.posicion = posicion;
    }

    public Posicion(int fila, int columna) {
        //Fila y columna
        this.fila = fila;
        this.columna = columna;
        //Posicion tipo E4
        this.posicion=""+(char)(this.columna+97);
        this.posicion+=(char)(this.fila+49);
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    
    

}
