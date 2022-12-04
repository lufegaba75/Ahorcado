package controlador;

import modelo.RegistroBD;
import modelo.Repositorio;
import modelo.RepositorioRegistrosBD;
import modelo.Solucion;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Solucion sol;
        try (Connection conn = conexionBD.getInstance()){
            Repositorio<RegistroBD> repositorio = new RepositorioRegistrosBD() {
            };
            sol = new Solucion(repositorio.registroPorId(RepositorioRegistrosBD.obtenerId()));
            System.out.println("¿Qué " + sol.getCategoria() + " soy?");
            System.out.println(sol.getSolucionOculta());
            Metodos.contador = 6;
            do {
                Metodos.realizarTurno(sol);
            }while (Metodos.contador>0);
            Metodos.sc.close();
            if(!Metodos.resuelto){
                System.out.println("Has perdido!!!");
            }
            System.out.println("La respuesta era: " + sol.getTextoSolucion());
            System.out.println("FIN DEL JUEGO");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}