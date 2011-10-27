package piezas;

import bitajedrez.Color;

public class Alfil extends Pieza{

    public Alfil(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return (this.getColor()==Color.blancas)?"A":"a";
    }

    
    
    
}
