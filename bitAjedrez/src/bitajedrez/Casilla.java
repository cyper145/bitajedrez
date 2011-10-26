package bitajedrez;

import piezas.Pieza;

public class Casilla {
    private Pieza pieza;

    public Casilla() {
        this.pieza=null;
    }

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
        if(pieza==null){
            this.pieza = pieza;
            return true;
        }
        return false;
    }
        
}
