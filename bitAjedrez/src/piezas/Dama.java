package piezas;

import bitajedrez.Color;

public class Dama extends Pieza{

    public Dama(Color color) {
        super(color);
    }
    
    @Override
    public String toString() {
        return (this.getColor()==Color.blanco)?"D":"d";
    }
    
}
