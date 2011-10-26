package bitajedrez;

import java.util.List;
import piezas.*;

public class Jugador {
    private String nombre;
    private String color; //Blanca o Negra
    List <Pieza> listPieza;

    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void colocarPiezasInicio(Tablero tablero){
        
        for(int i=0;i<8;i++){
            Pieza peon=new Peon(this.color);
            
        }
    }
    
}
