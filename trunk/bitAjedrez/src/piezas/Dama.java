package piezas;

import bitajedrez.Casilla;
import bitajedrez.Color;
import bitajedrez.Tablero;

public class Dama extends Pieza{

    public Dama(Color color) {
        super(color);
    }
    
    @Override
    public String toString() {
        return (this.getColor()==Color.blancas)?"D":"d";
    }

    @Override
    public boolean puedeIr(Tablero tablero, Casilla hacia) {
        boolean puede=false;
        
        //Cogemos la casilla donde está la pieza
        Casilla desde=tablero.getCasillaConPieza(this);
        
        int fd,cd; //Fila y Columna de la Casilla Desde
        int fh,ch; //Fila y Columna de la Casilla Hacia
        fd=desde.getFila();
        cd=desde.getColumna();
        fh=hacia.getFila();
        ch=hacia.getColumna();
        
        //0.-Comprobamos que la casilla hacia la que vamos no sea la misma que estamos
        if(desde==hacia){
            return false;
        }
        
        //1.-Comprobamos si la casilla hacia la que vamos, está ocupada
        if(hacia.getPieza()!=null){
            if(hacia.getPieza().getColor()==this.getColor()){
                //La pieza está intentando ponerse donde hay otra pieza del mismo color
                return false;
            }
        }
        
        //2.-Comprobamos si la casilla es alcanzable por el movimiento de la pieza

        puede=true;        
        
        
        return puede;
    }

}
