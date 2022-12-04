package modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioRegistrosBD implements Repositorio<RegistroBD>{

    private Connection getConnection() throws SQLException {
        return ConexionBD.connection.getInstance();
    }

    @Override
    public RegistroBD porId() {
        RegistroBD registro = null;
        int id = (int)(Math.random()*214);
        try (PreparedStatement stmt = getConnection().
                prepareStatement("SELECT paisnombre FROM pais WHERE id = ?")){
            stmt.setLong(1,id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    registro = new RegistroBD(rs.getString("paisnombre"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;

    }
}
