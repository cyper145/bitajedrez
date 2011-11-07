package menus;

import bitajedrez.Casilla;
import bitajedrez.Color;
import bitajedrez.Jugador;
import bitajedrez.Marca;
import bitajedrez.Partida;
import excepciones.ExMovimiento;
import excepciones.ExSeleccion;
import piezas.*;

public class Bitajedrez {

    public static void main(String[] args) {

        //Creamos la partida
        Partida partida = new Partida();

        //Creamos unos jugadores
        Jugador jugador1 = new Jugador("Manuel", Color.blancas);
        Jugador jugador2 = new Jugador("Espinete", Color.negras);

        //Añadimos los jugadores a la partida
        partida.agregarJugador(jugador1);
        partida.agregarJugador(jugador2);

        //Comienza la partida, esto pondrá las piezas en el tablero
        partida.empezarPartida();

        while (!partida.finPartida()) {
            String stringCasilla = "";
            Casilla casillaDesde = null;
            Casilla casillaHacia = null;
            Pieza pieza = null;

            //Borramos pantalla y pintamos el tablero
            Bitutil.borra();
            partida.limpiaMarcas();
            System.out.println(partida.getTablero().salidaTxt());

            //Pedimos casilla de la pieza que vamos a mover para coger la pieza
            stringCasilla = Bitutil.dameCasilla("[" + partida.getJugadorTurno().getNombre() + ":" + partida.getJugadorTurno().getColor() + "] Casilla origen? ");
            casillaDesde = partida.getTablero().getCasilla(stringCasilla);

            //Marcamos el tablero con dicha pieza
            Bitutil.borra();
            casillaDesde.setMarca(Marca.seleccionado);
            System.out.println(partida.getTablero().salidaTxt());

            //Pedimos casilla de la pieza que vamos a mover para coger la pieza
            stringCasilla = Bitutil.dameCasilla("[" + partida.getJugadorTurno().getNombre() + ":" + partida.getJugadorTurno().getColor() + "] Casilla destino? ");
            casillaHacia = partida.getTablero().getCasilla(stringCasilla);

            try {
                partida.mueve(casillaDesde, casillaHacia);
                //Despues de mover cambiamos el turno
                partida.turnoSiguiente();
            } catch (ExSeleccion ex) {
                System.out.println(ex.toString());
            } catch (ExMovimiento ex) {
                System.out.println(ex.toString());
            }

        }

        //Fin de la partida
        System.out.println("FIN DE LA PARTIDA");

    }
}
