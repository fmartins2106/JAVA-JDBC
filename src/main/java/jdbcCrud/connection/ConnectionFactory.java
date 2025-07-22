package jdbcCrud.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/minha_base";
        String username = "fmartins";
        String password = "masterkey";
        return DriverManager.getConnection(url,username,password);
    }
}