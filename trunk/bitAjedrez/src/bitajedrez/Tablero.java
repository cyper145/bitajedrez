package bitajedrez;

import piezas.*;

public class Tablero {

    Casilla arrayCasilla[][];

    /**
     * Esto crea un tablero vacio de 8x8 casillas
     */
    public Tablero() {
        arrayCasilla = new Casilla[8][8];
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                arrayCasilla[fila][columna] = new Casilla(fila, columna);
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
        pieza = arrayCasilla[fila][columna].getPieza();
        return pieza;
    }

    public Pieza getPiezaEnCasilla(String posicion) {
        int fila = (int) posicion.charAt(1) - 49;
        int columna = (int) posicion.charAt(0) - 97;
        Pieza pieza = null;
        pieza = getPiezaEnCasilla(fila, columna);
        return pieza;
    }

    public Pieza getPiezaEnCasilla(Casilla casilla) {
        Pieza pieza = null;
        pieza = casilla.getPieza();
        return pieza;
    }

    /**
     * Coloca una pieza en la casilla seleccionada por fila y columna
     * En caso de que no haya nada en esa casilla, se devuelve null
     * @param fila int
     * @param columna int
     * @param pieza que queremos colocar, para quitar la pieza debe usarse
     * el metodo quitaPiezaEnCasilla, no se puede usar null
     * @return 
     */
    public boolean setPiezaEnCasilla(int fila, int columna, Pieza pieza) {
        boolean resultado;
        resultado = arrayCasilla[fila][columna].setPieza(pieza);
        return resultado;
    }

    public boolean setPiezaEnCasilla(String posicion, Pieza pieza) {
        boolean resultado;
        int fila = (int) posicion.charAt(1) - 49;
        int columna = (int) posicion.charAt(0) - 97;
        resultado = setPiezaEnCasilla(fila, columna, pieza);
        return resultado;
    }

    public boolean setPiezaEnCasilla(Casilla casilla, Pieza pieza) {
        boolean resultado;
        resultado = casilla.setPieza(pieza);
        return resultado;
    }

    /**
     * Quita una pieza del tablero en la posición seleccionada por fila y columna.
     * La pieza quitada es devuelta para poder colocar en otro sitio si es necesario.
     * @param fila
     * @param columna
     * @return pieza que hemos quitado o null si no había nada.
     */
    public Pieza quitaPiezaEnCasilla(int fila, int columna) {
        Pieza piezaQuitada = null;
        piezaQuitada = arrayCasilla[fila][columna].quitaPieza();
        return piezaQuitada;
    }

    public Pieza quitaPiezaEnCasilla(String posicion) {
        int fila = (int) posicion.charAt(1) - 49;
        int columna = (int) posicion.charAt(0) - 97;
        Pieza piezaQuitada = null;
        piezaQuitada = quitaPiezaEnCasilla(fila, columna);
        return piezaQuitada;
    }

    public Pieza quitaPiezaEnCasilla(Casilla casilla) {
        Pieza piezaQuitada = null;
        piezaQuitada = casilla.quitaPieza();
        return piezaQuitada;
    }

    @Override
    public String toString() {
        String respuesta = "";
        for (int fila = 7; fila >= 0; fila--) {
            respuesta += "(" + (fila + 1) + ":";
            for (int columna = 0; columna < 8; columna++) {
                Pieza pieza = null;
                pieza = arrayCasilla[fila][columna].getPieza();
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

    public String salidaTxt() {
        String respuesta = "";
        respuesta += "    A   B   C   D   E   F   G   H   \n";
        respuesta += "  +---+---+---+---+---+---+---+---+ \n";
        for (int fila = 7; fila >= 0; fila--) {
            respuesta += "" + (fila + 1) + " |";
            for (int columna = 0; columna < 8; columna++) {
                Pieza pieza = null;
                if (arrayCasilla[fila][columna].getMarca() == Marca.seleccionado) {
                    respuesta += ">";
                } else {
                    respuesta += " ";
                }
                pieza = arrayCasilla[fila][columna].getPieza();
                if (pieza == null) {
                    respuesta += " ";
                } else {
                    respuesta += pieza.toString();
                }
                if (arrayCasilla[fila][columna].getMarca() == Marca.seleccionado) {
                    respuesta += "<";
                } else {
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
    public void marcaCasilla(Pieza pieza, Marca marca) {
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                if (arrayCasilla[fila][columna].getPieza() == pieza) {
                    arrayCasilla[fila][columna].setMarca(marca);
                }
            }
        }
    }

    public void marcaCasilla(Casilla casilla, Marca marca){
        casilla.setMarca(marca);
    }
    
    public void limpiaMarcas(){
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                    arrayCasilla[fila][columna].setMarca(Marca.nada);
                
            }
        }
    }
    
    public void muevePieza(Pieza pieza, Casilla casilla){
        
        
    }
    
    /**
     * Mueve la pieza seleccionada a la posicion elegida.
     */
    public boolean muevePieza(Pieza pieza, String posicionHacia) {
        boolean correcto = false;
        //Comprobamos si el movimiento es valido
        //correcto=pieza.puedeIr(this, this.getCasilla(posicionHacia));
        if(!correcto){
            return false;
        }
        int fila = (int) posicionHacia.charAt(1) - 49;
        int columna = (int) posicionHacia.charAt(0) - 97;
        Casilla casillaDesde=getCasillaConPieza(pieza);
        correcto = setPiezaEnCasilla(fila, columna, pieza);
        if (correcto) {
            quitaPiezaEnCasilla(casillaDesde);
        }
        return correcto;
    }

    /**
     * Devuelve la casilla que contiene la pieza que pasamos como parámetro.
     * Si la pieza no estuviese en el tablero devolvería null.
     * @param pieza
     * @return casilla
     */
    public Casilla getCasillaConPieza(Pieza pieza) {
        Casilla casilla = null;
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                if (getPiezaEnCasilla(fila, columna) == pieza) {
                    casilla = getCasilla(fila, columna);
                }
            }
        }
        return casilla;
    }

    /**
     * Devuelve la casilla indicada por fila y columna, del tablero
     * @param fila
     * @param columna
     * @return casilla
     */
    public Casilla getCasilla(int fila, int columna) {
        Casilla casilla = null;
        casilla = arrayCasilla[fila][columna];
        return casilla;
    }

    /**
     * Devuelve la casilla indicada por posicion, del tablero
     * @param posicion
     * @return 
     */
    public Casilla getCasilla(String posicion){
        Casilla casilla=null;
        casilla=arrayCasilla[Casilla.fila(posicion)][Casilla.columna(posicion)];
        return casilla;
    }
}
