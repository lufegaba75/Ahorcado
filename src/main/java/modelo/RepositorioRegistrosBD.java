package modelo;

import controlador.conexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioRegistrosBD implements Repositorio<RegistroBD> {

    static String[] seleccion = new String[2];

    private Connection getConnection() throws SQLException {
        return conexionBD.getInstance();
    }

    public RepositorioRegistrosBD() {
    }

    public static int obtenerId() {
        int id = (int) (Math.random() * 431);
        return id;
    }
    @Override
    public String[] registroPorId(int id) {

        try (PreparedStatement stmt = getConnection().
                prepareStatement("SELECT registros.nombre,categorias.categoria FROM categorias INNER JOIN registros" +
                        " ON registros.id_categoria=categorias.id WHERE registros.id = ?")){
            stmt.setLong(1,id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    seleccion[0] = rs.getString("nombre");
                    seleccion[1] = rs.getString("categoria");
                            //new RegistroBD(rs.getString("nombre"), rs.getString("categoria"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seleccion;
    }

    public String nombrePorId(String[] matriz) {
        return matriz[0];
    }

    public String categoriaPorId(String[] matriz) {
        return matriz[1];
    }
}
