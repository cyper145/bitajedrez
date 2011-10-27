package bitajedrez;

public class Bitajedrez {

    public static void main(String[] args) {
        //Creamos la partida
        Partida partida=new Partida();
        
        //Creamos unos jugadores
        Jugador jugador1=new Jugador("Manuel", Color.blanco);
        Jugador jugador2=new Jugador("Espinete", Color.negro);
        
        //Añadimos los jugadores a la partida
        partida.agregarJugador(jugador1);
        partida.agregarJugador(jugador2);
        
        //Cada jugador coloca sus piezas en el tablero
        partida.colocaPiezas();
        
        //Comienzan las blancas
        partida.setJugadorTurno(partida.getJugador(Color.blanco));
        
        //Mostramos los jugadores:
        System.out.println("Juega con Blancas:");
        System.out.println(partida.getJugador(Color.blanco).getNombre());
        System.out.println("Juega con Negras:");
        System.out.println(partida.getJugador(Color.negro).getNombre());

        //Mostramos de quien es el turno
        System.out.println("El turno es de:");
        System.out.println(partida.getJugadorTurno().getNombre());
        
        //Pintamos el tablero
        System.out.println(partida.getTablero().toString());
    }
}
