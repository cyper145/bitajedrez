package bitajedrez;

import piezas.Pieza;

public class Casilla {

    private int fila;
    private int columna;
    private Pieza pieza;
    private Marca marca;

    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.pieza = null;
        this.marca = Marca.nada;
    }

    /**
     * Obtiene la pieza que se encuentra en dicha casilla. Si no hay ninguna
     * pieza, devolverá null.
     * @return 
     */
    public Pieza getPieza() {
        return pieza;
    }

    /**
     * Coloca una pieza en una casilla. Si en vez de una pieza le pasamos null,
     * no lo hace y devuelve false
     * @param pieza
     * @return true si se coloca y false si está ocupada y no se coloca
     */
    public boolean setPieza(Pieza pieza) {
        if (pieza != null) {
            this.pieza = pieza;
            return true;
        }
        return false;
    }

    /**
     * Quita la pieza que hubiese en la casilla y la devuelve para poder colocarla
     * en otro sitio si es necesario. Si no había pieza devuelve null.
     * @return 
     */
    public Pieza quitaPieza() {
        Pieza piezaQuitada = null;
        piezaQuitada = this.pieza;
        this.pieza = null; //Quitamos la pieza
        return piezaQuitada;
    }

    /**
     * Obtiene el tipo de marca que tiene la casilla
     * @return 
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * Establece el tipo de marca que tendrá la casilla
     * @param marca 
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * Devuelve la posicion de la casilla en formato letra-número
     * @return String
     */
    public String getPosicion() {
        String posicion;
        posicion=""+(char)(this.columna+97);
        posicion+=(char)(this.fila+49);
        return posicion;
    }

    /**
     * Método estático para obtener el número de fila a partir de una posición
     * en formato letra-número
     * @param posicion
     * @return fila
     */
    public static int fila(String posicion) {
        int fila;
        fila = (int) posicion.charAt(1) - 49;
        return fila;
    }

    /**
     * Método estático para obtener el número de columna a partir de una posición
     * en formato letra-número
     * @param posicion
     * @return columna
     */
    public static int columna(String posicion) {
        int columna;
        columna = (int) posicion.charAt(0) - 97;
        return columna;
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }


}
