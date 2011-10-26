package bitajedrez;

import piezas.Pieza;

public class Tablero {
    Casilla casilla[][];

    /**
     * Esto crea un tablero vacio de 8x8 casillas
     */
    public Tablero() {
        casilla=new Casilla[8][8];
    }

    /**
     * Devuelve la pieza que hay en la casilla seleccionada por fila y columna
     * En caso de que no haya nada en esa casilla, se devuelve null
     * @param fila int
     * @param columna int
     * @return Pieza o null si no hay nada
     */
    public Pieza getPiezaEnCasilla(int fila, int columna) {
        Pieza pieza=null;
        pieza=casilla[fila][columna].getPieza();
        return pieza;
    }

    public void setPiezaEnCasilla(int fila, int columna, Pieza pieza) {
        //boolean resultado;
        
        System.out.println(casilla[fila][columna].getPieza());
                
        //return resultado;
    }

    @Override
    public String toString() {
        String respuesta="";
        for(int i=7;i>=0;i++){
            for(int j=0;j<8;j++){
                respuesta+=casilla[i][j].getPieza().toString();
            }
            respuesta+="\n";
        }

        return respuesta;
    }
    

    
            
}
