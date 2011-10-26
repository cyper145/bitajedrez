package bitajedrez;

public class Bitajedrez {

    public static void main(String[] args) {
        //Creamos la partida
        Partida partida=new Partida();
        
        //Creamos unos jugadores
        Jugador jugador1=new Jugador("Manuel", "blanca");
        Jugador jugador2=new Jugador("Espinete", "negra");
        
        //Añadimos los jugadores a la partida
        partida.agregarJugador(jugador1);
        partida.agregarJugador(jugador2);
        
        //Comienzan las blancas
        partida.asignarTurno(partida.getJugador("blanca"));
    }
}
