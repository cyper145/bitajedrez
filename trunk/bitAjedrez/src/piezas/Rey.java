package piezas;

import bitajedrez.Color;

public class Rey extends Pieza{

    public Rey(Color color) {
        super(color);
    }
    
    @Override
    public String toString() {
        return (this.getColor()==Color.blancas)?"R":"r";
    }
    
    
}
