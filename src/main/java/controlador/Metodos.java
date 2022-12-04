package controlador;

import modelo.Solucion;

import java.util.Scanner;

public class Metodos {

    public static int contador;
    public static boolean resuelto;
    static Scanner sc = new Scanner(System.in);

    public static char obtenerLetra(){
        boolean entradaCorrecta = false;
        char c = 0;
        do{
            sc.useDelimiter("\n");
            System.out.println("Introduzca una única letra");
            String aux = sc.next();
            if (aux.length() == 1) {
                if (aux.charAt(0) > 64 && aux.charAt(0) < 91){
                    c = aux.charAt(0);
                    entradaCorrecta = true;
                }else if (aux.charAt(0) > 96 && aux.charAt(0) < 123) {
                    c = (char) (aux.charAt(0) - 32);
                    entradaCorrecta = true;
                }
            }
        }while (!entradaCorrecta);

        return c;
    }

    public static String comprobarLetra(char c, Solucion sol){
        String s = sol.getTextoBD().toUpperCase();
        String oculto = sol.getSolucionOculta();
        String aux1;
        String aux2;
        boolean esta = false;
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)){
                if (i > 0 && i < s.length()-1){
                    aux1 = oculto.substring(0,i);
                    aux2 = oculto.substring(i+1);
                    oculto = aux1 + c + aux2;
                } else if (i == 0){
                    aux1 = oculto.substring(1);
                    oculto = c + aux1;
                } else {
                    aux1 = oculto.substring(0,oculto.length()-1);
                    oculto = aux1 + c;
                }
                esta = true;
            }
        }if (esta) {
            System.out.println("La letra " + c + " está en la respuesta.");
        }else{
            System.out.println("La letra " + c + " no está.");
        }
        return oculto;
    }

    public static boolean estaResuelto(String texto, Solucion sol){
        if (texto.equals(sol.getTextoSolucion()) || sol.getSolucionOculta().equals(sol.getTextoSolucion())){
            resuelto = true;
            sol.actualizarSolucionOculta(sol.getTextoSolucion());
        }
        return resuelto;
    }

    public static String resolver(){
        String respuesta;
        sc.useDelimiter("\n");
        System.out.println("Introduzca la respuesta");
        respuesta = sc.next().toUpperCase();
        return respuesta;
    }

    public static int escogerOpcion(){
        int opcion;
        boolean correcto=false;
        do{
            sc.useDelimiter("\n");
            System.out.println("Escoja una opción: ");
            System.out.println("0. si desea añadir una letra.");
            System.out.println("1. si desea resolver.");
            opcion = sc.nextInt();
            if (opcion == 0 || opcion == 1){
                correcto = true;
            }
        }while(!correcto);
        return opcion;
    }

    public static void realizarTurno(Solucion sol){
        if (contador>0 && !resuelto) {
            switch (escogerOpcion()) {
                case 0:
                    System.out.println("Ha elegido introducir una letra");
                    sol.actualizarSolucionOculta(Metodos.comprobarLetra(Metodos.obtenerLetra(), sol));
                    estaResuelto(sol.getSolucionOculta(), sol);
                    contador--;
                    System.out.println(sol.getSolucionOculta());
                    System.out.println("Le quedan " + contador + " vidas.");
                    break;
                case 1:
                    System.out.println("Ha elegido resolver");
                    if (!estaResuelto(resolver(), sol)) {
                        contador--;
                    } else {
                        System.out.println("VICTORIA");
                        contador = 0;
                    }
                    break;
                default:
                    break;
            }

        }

    }

}
