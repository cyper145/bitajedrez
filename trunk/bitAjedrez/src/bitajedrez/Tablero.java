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

    public Pieza getPiezaEnCasilla(String posicion) {
        int fila = (int) posicion.charAt(1) - 49;
        int columna = (int) posicion.charAt(0) - 97;
        Pieza pieza = null;
        pieza = getPiezaEnCasilla(fila, columna);
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
        respuesta += "    A   B   C   D   E   F   G   H   \n";
        respuesta += "  +---+---+---+---+---+---+---+---+ \n";
        for (int fila = 7; fila >= 0; fila--) {
            respuesta += "" + (fila + 1) + " |";
            for (int columna = 0; columna < 8; columna++) {
                Pieza pieza = null;
                if (casilla[fila][columna].getMarca() == Marca.seleccionado) {
                    respuesta += ">";
                }else{
                    respuesta += " ";
                }
                pieza = casilla[fila][columna].getPieza();
                if (pieza == null) {
                    respuesta += " ";
                } else {
                    respuesta += pieza.toString();
                }
                if (casilla[fila][columna].getMarca() == Marca.seleccionado) {
                    respuesta += "<";
                }else{
                    respuesta += " ";
                }
                respuesta += "|";
            }
            respuesta += " " + (fila + 1) + "\n";
            respuesta += "  +---+---+---+---+---+---+---+---+ \n";
        }
        respuesta += "    A   B   C   D   E   F   G   H   \n";

        return respuesta;
    }

    /**
     * Pone las marcas en en tablero según la pieza que esté seleccionada
     * y sus movimientos posibles
     * @param pieza 
     */
    public void marca(Pieza pieza) {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                if (casilla[fila][columna].getPieza() == pieza) {
                    casilla[fila][columna].setMarca(Marca.seleccionado);
                }
            }
        }
    }
}
