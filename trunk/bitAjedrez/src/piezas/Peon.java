package piezas;

import bitajedrez.Color;

public class Peon extends Pieza{

    public Peon(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return (this.getColor()==Color.blanco)?"P":"p";
    }
    
}