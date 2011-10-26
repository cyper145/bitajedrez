package bitajedrez;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Partida {
    List<Jugador> listJugador;      //Lista de jugadores, (2 jugadores como máximo)
    private Tablero tablero;        //Tablero para poder jugar
    private Jugador jugadorTurno;   //Jugador de la lista que tiene el turno
    
    public Partida() {
        listJugador=new ArrayList();
    }
    
    /**
     * Agrega un Jugador a la partida en el caso de que sea posible.
     * En caso de que no pueda agregarse porque ya esté llena o el color
     * elegido por el jugador ya esté cogido, devolverá false.
     * @param jugador
     * @return 
     */
    public boolean agregarJugador(Jugador jugador){
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
    
    /**
     * Devuelve el jugador que pertenece a la partida y usa el color indicado
     * @param color
     * @return 
     */
    public Jugador getJugador(String color){
        //Iterador para comprobar los jugadores
        Iterator iterator=listJugador.iterator();
        
        //Cuando encontremos un jugador con el color indicado lo devolvemos
        while(iterator.hasNext()){
            Jugador jugador=(Jugador) iterator.next();
            if(jugador.getColor().equals(color)){
                return jugador;
            }
        }
        
        //Si no hemos encontrado un jugador con dicho color, devolvemos null
        return null;
    }
    
    /**
     * Asigna el jugador que tiene el turno para mover
     */
    public void asignarTurno(Jugador jugador) {
        this.jugadorTurno=jugador;
    }

}
