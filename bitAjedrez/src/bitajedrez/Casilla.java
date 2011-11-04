package bitajedrez;

import piezas.Pieza;

public class Casilla {
    private int fila;
    private int columna;
    private Pieza pieza;
    private Marca marca;

    public Casilla(int fila, int columna) {
        this.fila=fila;
        this.columna=columna;
        this.pieza=null;
        this.marca=Marca.nada;
    }

    /**
     * Obtiene la pieza que se encuentra en dicha casilla. Si no hay ninguna
     * pieza, devolverá null.
     * @return 
     */
    public Pieza getPieza() {
        return pieza;
    }

    /**
     * Coloca una pieza en una casilla. Si la casilla estaba ocupada no lo hace
     * y devuelve false
     * @param pieza
     * @return true si se coloca y false si está ocupada y no se coloca
     */
    public boolean setPieza(Pieza pieza) {
        if(pieza!=null){
            this.pieza = pieza;
            return true;
        }
        return false;
    }

    public Pieza quitaPieza(){
        Pieza piezaQuitada=null;
        piezaQuitada=this.pieza;
        this.pieza=null; //Quitamos la pieza
        return piezaQuitada;
    }
    
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
        
}
