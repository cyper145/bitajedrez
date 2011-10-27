package bitajedrez;

import piezas.*;

public class Tablero {

    Casilla casilla[][];

    /**
     * Esto crea un tablero vacio de 8x8 casillas
     */
    public Tablero() {
        casilla = new Casilla[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casilla[i][j] = new Casilla();
            }
        }
    }

    /**
     * Devuelve la pieza que hay en la casilla seleccionada por fila y columna
     * En caso de que no haya nada en esa casilla, se devuelve null
     * @param fila int
     * @param columna int
     * @return Pieza o null si no hay nada
     */
    public Pieza getPiezaEnCasilla(int fila, int columna) {
        Pieza pieza = null;
        pieza = casilla[fila][columna].getPieza();
        return pieza;
    }

    public boolean setPiezaEnCasilla(int fila, int columna, Pieza pieza) {
        boolean resultado;
        resultado = casilla[fila][columna].setPieza(pieza);
        return resultado;
    }

    @Override
    public String toString() {
        String respuesta = "";
        for (int fila = 7; fila >= 0; fila--) {
            respuesta += "(" + (fila + 1) + ":";
            for (int columna = 0; columna < 8; columna++) {
                Pieza pieza = null;
                pieza = casilla[fila][columna].getPieza();
                if (pieza == null) {
                    respuesta += ".";
                } else {
                    respuesta += pieza.toString();
                }
            }
            respuesta += ")";
        }
        return respuesta;
    }

    public String muestraTxt() {
        String respuesta = "";
        respuesta += "   A   B   C   D   E   F   G   H   \n";
        respuesta += " +---+---+---+---+---+---+---+---+ \n";
        for (int fila = 7; fila >= 0; fila--) {
            respuesta += "" + (fila + 1) + "| ";
            for (int columna = 0; columna < 8; columna++) {
                Pieza pieza = null;
                pieza = casilla[fila][columna].getPieza();
                if (pieza == null) {
                    respuesta += " ";
                } else {
                    respuesta += pieza.toString();
                }
                respuesta += " | ";
            }
            respuesta += "" + (fila + 1) + "\n";
            respuesta += " +---+---+---+---+---+---+---+---+ \n";
        }
        respuesta += "   A   B   C   D   E   F   G   H   \n";

        return respuesta;

    }
}
