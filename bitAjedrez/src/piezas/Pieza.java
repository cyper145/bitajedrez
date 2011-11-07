package piezas;

import bitajedrez.Casilla;
import bitajedrez.Color;
import bitajedrez.Tablero;
import excepciones.ExMovimiento;

public abstract class Pieza {
    private Color color;

    public Pieza(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public abstract boolean puedeIr(Tablero tablero, Casilla hacia) throws ExMovimiento;
}
