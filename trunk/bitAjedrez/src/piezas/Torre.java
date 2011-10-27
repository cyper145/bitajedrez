package piezas;

import bitajedrez.Color;

public class Torre extends Pieza{

    public Torre(Color color) {
        super(color);
    }
    
    @Override
    public String toString() {
        return (this.getColor()==Color.blancas)?"T":"t";
    }
    
}
