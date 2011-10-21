package bitajedrez;

import java.util.Scanner;

public class Entrada {

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

    public static int dameCasilla(String mensaje) {
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

}
