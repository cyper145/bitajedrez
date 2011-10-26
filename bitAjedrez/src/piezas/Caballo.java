package piezas;

import bitajedrez.Color;

public class Caballo extends Pieza{

    public Caballo(Color color) {
        super(color);
    }
    
    @Override
    public String toString() {
        return (this.getColor()==Color.blanco)?"C":"c";
    }
    
    
}
