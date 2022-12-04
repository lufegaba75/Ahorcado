package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBD {

    private final static String url = "jdbc:mysql://localhost:3306/RegistrosAhorcado?serverTimezone=UTC";
    private final static String username = "root";
    private final static String password = "";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}
