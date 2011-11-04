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
        tablero=new Tablero();
    }
    
    /**
     * Agrega un Jugador a la partida en el caso de que sea posible.
     * En caso de que no pueda agregarse porque ya esté llena o el color
     * elegido por el jugador ya esté cogido, devolverá false.
     * @param jugador
     * @return true o false dependiendo del éxito de la operación
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
    public Jugador getJugador(Color color){
        //Iterador para recorrer la lista de jugadores
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
     * Devuelve el jugador que tiene el turno en la partida
     * TODO: debería devolver null si la partida no ha comenzado aún
     * @return Jugador
     */
    public Jugador getJugadorTurno() {
        return jugadorTurno;
    }

    /**
     * Establece el jugador al que se le entregará el turno de la partida
     * TODO: devolver algo según si funcionó o no
     * @param jugadorTurno 
     */
    public void setJugadorTurno(Jugador jugadorTurno) {
        this.jugadorTurno = jugadorTurno;
    }

    /**
     * Devuleve el Objeto Tablero en el que se desarrolla la partida
     * @return 
     */
    public Tablero getTablero() {
        return tablero;
    }

    /**
     * Asigna un tablero a la partida
     * @param tablero 
     */
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    /**
     * Realiza las comprobaciones necesarias para ver si se puede empezar la partida
     * pide a cada jugador que coloque sus fichas en el tablero y da el turno al
     * jugador que juega con blancas.
     */
    public void empezarPartida(){
        Iterator iterator=listJugador.iterator();
        
        //Cada jugador coloca sus piezas en el tablero
        while(iterator.hasNext()){
            Jugador jugador=(Jugador) iterator.next();
            jugador.colocaPiezas(tablero);
        }
        
        //Da el turno al jugador que juega con blancas
        setJugadorTurno(getJugador(Color.blancas));
    }
    
    /**
     * Devuelve un boolean indicando si la partida ha terminado o si se puede
     * seguir moviendo piezas.
     */
    public boolean finPartida(){
        //Falta por hacer esto.
        return false;
        //Quizas sería mejor devolver el jugador que ha ganado o null si no ha acabado
    }

    public void turnoSiguiente(){
        if(jugadorTurno==listJugador.get(0)){
            jugadorTurno=listJugador.get(1);
        }else{
            jugadorTurno=listJugador.get(0);
        }
    }

}
