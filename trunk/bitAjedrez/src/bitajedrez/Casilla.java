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

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }
        
}
