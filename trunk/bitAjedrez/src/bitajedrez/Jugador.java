package bitajedrez;

import java.util.ArrayList;
import java.util.List;
import piezas.*;

public class Jugador {

    private String nombre;
    private Color color; //Blanca o Negra
    List<Pieza> listPieza;

    public Jugador(String nombre, Color color) {
        listPieza=new ArrayList();
        this.nombre = nombre;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void colocaPiezas(Tablero tablero) {
        //Vemos qué fila es delante y detrás según el color que juega
        int delante = (this.color == Color.blanco) ? 1 : 6;
        int detras = (this.color == Color.blanco) ? 0 : 7;

        //Linea de peones
        /*
        for (int i = 0; i < 8; i++) {
            Pieza peon = new Peon(this.color);
            listPieza.add(peon);
            tablero.setPiezaEnCasilla(delante, i, peon);
        }
*/
        //Torre Izquierda
        Pieza torreI = new Torre(this.color);
        listPieza.add(torreI);
        tablero.setPiezaEnCasilla(detras, 0, torreI);

        //Caballo Izquierda
        Pieza caballoI = new Caballo(this.color);
        listPieza.add(caballoI);
        tablero.setPiezaEnCasilla(detras, 1, caballoI);

        //Alfil Izquierda
        Pieza alfilI = new Alfil(this.color);
        listPieza.add(alfilI);
        tablero.setPiezaEnCasilla(detras, 2, alfilI);

        //Dama
        Pieza dama = new Dama(this.color);
        listPieza.add(dama);
        tablero.setPiezaEnCasilla(detras, 3, dama);

        //Rey
        Pieza rey = new Rey(this.color);
        listPieza.add(rey);
        tablero.setPiezaEnCasilla(detras, 4, rey);
        
        //Alfil Derecha
        Pieza alfilD = new Alfil(this.color);
        listPieza.add(alfilD);
        tablero.setPiezaEnCasilla(detras, 5, alfilD);
        
        //Caballo Derecha
        Pieza caballoD = new Caballo(this.color);
        listPieza.add(caballoD);
        tablero.setPiezaEnCasilla(detras, 6, caballoD);
        
        //Torre Derecha
        Pieza torreD = new Torre(this.color);
        listPieza.add(torreD);
        tablero.setPiezaEnCasilla(detras, 7, torreD);
        
    }
}
