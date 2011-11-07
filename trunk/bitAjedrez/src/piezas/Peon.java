package piezas;

import bitajedrez.Casilla;
import bitajedrez.Color;
import bitajedrez.Tablero;
import excepciones.ExMovimiento;

public class Peon extends Pieza {

    public Peon(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return (this.getColor() == Color.blancas) ? "P" : "p";
    }

    @Override
    public boolean puedeIr(Tablero tablero, Casilla hacia) throws ExMovimiento {
        boolean puede = false;

        //Cogemos la casilla donde está la pieza
        Casilla desde = tablero.getCasillaConPieza(this);

        int fd, cd; //Fila y Columna de la Casilla Desde
        int fh, ch; //Fila y Columna de la Casilla Hacia
        fd = desde.getFila();
        cd = desde.getColumna();
        fh = hacia.getFila();
        ch = hacia.getColumna();

        //0.-Comprobamos que la casilla hacia la que vamos no sea la misma que estamos
        if (desde == hacia) {
            //Casilla desde y hacia iguales
            throw new ExMovimiento("Es la misma casilla");
        }

        //1.-Comprobamos si la casilla hacia la que vamos, está ocupada
        if (hacia.getPieza() != null) {
            if (hacia.getPieza().getColor() == this.getColor()) {
                //La pieza está intentando ponerse donde hay otra pieza del mismo color
                throw new ExMovimiento("Esa casilla está ocupada");
            }
        }

        //2.-Comprobamos si la casilla es alcanzable por el movimiento de la pieza
        if (this.getColor() == Color.blancas) {
            if (fh - fd == 1 || (fd == 1 && fh == 3)) {
                if (ch - cd == 1 || ch - cd == 0 || ch - cd == -1) {
                    //La casilla es alcanzable
                    puede = true;
                } else {
                    //Casilla no alcanzable horizontalemente
                    throw new ExMovimiento("Casilla No Alcanzable");
                }
            } else {
                //Casilla no alcanzable verticalmente
                throw new ExMovimiento("Casilla No Alcanzable");
            }
        } else {
            if (fh - fd == -1 || (fd == 6 && fh == 4)) {
                if (ch - cd == 1 || ch - cd == 0 || ch - cd == -1) {
                    //La casilla es alcanzable
                    puede = true;
                } else {
                    //Casilla no alcanzable horizontalemente
                    throw new ExMovimiento("Casilla No Alcanzable");
                }
            } else {
                //Casilla no alcanzable verticalmente
                throw new ExMovimiento("Casilla No Alcanzable");
            }
        }

        return puede;
    }
}