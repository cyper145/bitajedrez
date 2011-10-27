package menus;

import bitajedrez.Color;
import bitajedrez.Jugador;
import bitajedrez.Partida;
import piezas.*;

public class Bitajedrez {

    public static void main(String[] args) {
        //Creamos la partida
        Partida partida=new Partida();
        
        //Creamos unos jugadores
        Jugador jugador1=new Jugador("Manuel", Color.blancas);
        Jugador jugador2=new Jugador("Espinete", Color.negras);
        
        //Añadimos los jugadores a la partida
        partida.agregarJugador(jugador1);
        partida.agregarJugador(jugador2);
        
        //Cada jugador coloca sus piezas en el tablero
        partida.colocaPiezas();
        
        //Comienzan las blancas
        partida.setJugadorTurno(partida.getJugador(Color.blancas));
        
        //Mostramos los jugadores:
        System.out.print("Juega con Blancas: ");
        System.out.println(partida.getJugador(Color.blancas).getNombre());
        System.out.print("Juega con Negras: ");
        System.out.println(partida.getJugador(Color.negras).getNombre());

        
        //Pintamos el tablero
        System.out.println(partida.getTablero().muestraTxt());
        
        //Mostramos de quien es el turno
        System.out.print("El turno es de ");
        System.out.print(partida.getJugadorTurno().getNombre());
        System.out.println(" que juega con " + partida.getJugadorTurno().getColor());
        
        //Pedimos casilla de la pieza que vamos a mover
        String casillaDesde;
        do{
            casillaDesde=Bitutil.dameCasilla("Qué pieza quiere mover? ");
            if(casillaDesde==null){
                System.out.println("Debe introducir letra-numero (Ej. D6) ");
            }
        } while (casillaDesde==null);
        
        //Vemos qué pieza es la que está ahí
        Pieza pieza=partida.getTablero().getPiezaEnCasilla(casillaDesde);
        
        System.out.println("Pieza "+pieza.toString()+" seleccionada!");
        
        //Marcamos el tablero con dicha pieza
        partida.getTablero().marca(pieza);
        
        //Pintamos de nuevo
        System.out.println(partida.getTablero().muestraTxt());
        
    }
}
