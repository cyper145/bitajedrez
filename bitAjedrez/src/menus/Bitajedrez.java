package menus;

import bitajedrez.Color;
import bitajedrez.Jugador;
import bitajedrez.Marca;
import bitajedrez.Partida;
import bitajedrez.Posicion;
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
        
        //Comienza la partida, esto pondrá las piezas en el tablero
        partida.empezarPartida();
        
        while(!partida.finPartida()){
        //Mostramos los jugadores:
        Bitutil.borra();
        partida.getTablero().limpiaMarcas();
        
        System.out.print("Juega con Blancas: ");
        System.out.println(partida.getJugador(Color.blancas).getNombre());
        System.out.print("Juega con Negras: ");
        System.out.println(partida.getJugador(Color.negras).getNombre());
        System.out.println("---------------------------\n");
        
        //Pintamos el tablero
        System.out.println(partida.getTablero().salidaTxt());
        
        //Mostramos de quien es el turno
        Jugador jugadorTurno=partida.getJugadorTurno();
        
        System.out.print("El turno es de ");
        System.out.print(jugadorTurno.getNombre());
        System.out.println(" que juega con " + jugadorTurno.getColor());
        
        //Pedimos casilla de la pieza que vamos a mover para coger la pieza
        String casillaDesde="";
        boolean error=false;
        Pieza pieza=null;
        do{
            error=false;
            casillaDesde=Bitutil.dameCasilla("Qué pieza quiere mover? ");
            if(casillaDesde==null){
                //Si la casilla no es válida error=true
                error=true;
                System.out.println("Debe introducir letra-numero (Ej. D6) ");
            }else{
                //Vemos qué pieza es la que está ahí
                pieza=partida.getTablero().getPiezaEnCasilla(casillaDesde);
                if(pieza==null){
                    error=true;
                    System.out.println("No hay ninguna pieza ahí");
                }else{
                    if(jugadorTurno.tienePieza(pieza)){
                        System.out.println("Pieza "+pieza.toString()+" seleccionada!");
                    }else{
                        error=true;
                        System.out.println("Esa pieza no le pertenece al jugador");
                    }
                }
            }
        } while (error);
        
        //Marcamos el tablero con dicha pieza
        partida.getTablero().marcaCasilla(pieza,Marca.seleccionado);
        //Borramos pantalla
        Bitutil.borra();
        
        //Pintamos de nuevo
        System.out.println(partida.getTablero().salidaTxt());
        //Mostramos instrucciones
        System.out.print("El jugador ");
        System.out.print(jugadorTurno.getNombre());
        System.out.print(" que juega con " + jugadorTurno.getColor());
        System.out.println(" debe decidir la casilla para "+pieza.toString());
        
        //Pedimos la casilla donde queremos mover
        String casillaHacia="";
        do{
            error=false;
            casillaHacia=Bitutil.dameCasilla("A donde la quieres mover? ");
            if(casillaHacia==null){
                //Si la casilla no es válida error=true
                error=true;
                System.out.println("Debe introducir letra-numero (Ej. D6) ");
            }else{
                boolean exito=partida.getTablero().muevePieza(pieza,casillaHacia);
                error=!exito; //Error y el Exito son lo contrario
            }
        } while (error);
        
        //Despues de mover cambiamos el turno
        partida.turnoSiguiente();
        
        }

        //Fin de la partida
        System.out.println("FIN DE LA PARTIDA");
        
    }
}
