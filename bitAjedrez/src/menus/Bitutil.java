package menus;

import java.util.Scanner;

public class Bitutil {

    public static String dameCadena(String mensaje) {
        String cadena;
        Scanner scan = new Scanner(System.in);

        System.out.print(mensaje);
        cadena = scan.nextLine();
        return cadena;
    }


    public static int dameEntero(String mensaje) {
        int numero;
        String respuesta;
        respuesta = dameCadena(mensaje);
        if (respuesta.length() == 0) {
            return 0;
        }
        try {
            numero = Integer.parseInt(respuesta);
        } catch (NumberFormatException a) {
            return 0;
        }
        return numero;
    }

    /**
     * Pide una casilla del tablero que será una tecla y un número
     * @param mensaje El mensaje que se mostrará
     * @return Devuelve un String con una letra minúscula y un número 1-8
     */
    public static String dameCasilla(String mensaje) {
        String respuesta;
        respuesta = dameCadena(mensaje);
        
        //Si no mide 2 está mal
        if (respuesta.length() != 2) {
            return null;
        }
        
        //Ponemos en minúsculas
        respuesta=respuesta.toLowerCase();
        
        //Lo primero debe tener un codigo ASCII entre 97 y 104 inclusives
        char caracter=respuesta.charAt(0);
        if((int)caracter<97 || (int)caracter>104){
            return null;
        }
        
        //Lo segundo debe tener un codigo ASCII entre 49 y 56 inclusives
        caracter=respuesta.charAt(1);
        if((int)caracter<49 || (int)caracter>56){
            return null;
        }
        
        //Si hemos llegado hasta aquí, es que está todo bien
        return respuesta;
    }

}
