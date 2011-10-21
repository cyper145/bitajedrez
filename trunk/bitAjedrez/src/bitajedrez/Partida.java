package bitajedrez;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    List<Jugador> listJugador;
    private Tablero tablero;

    public Partida() {
        listJugador=new ArrayList();
    }
    
    public boolean introducirJugador(Jugador jugador){
        //Comprobamos si la partida está llena
        if(listJugador.size()==2){
            return false;
        }
        //Comprobamos que si ya hay un jugador, el otro usa el otro color
        if(listJugador.size()==1){
            if(listJugador.get(0).getColor().equals(jugador.getColor())){
                return false;
            }
        }
        //Introducimos al jugador en la partida
        return listJugador.add(jugador);
    }
    
    
    
}
