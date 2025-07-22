package JDCB.conn;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/minha_base";
        String username = "fmartins";
        String password = "masterkey";
//        try {
//            // Carrega o driver explicitamente (pode ajudar com o erro "No suitable driver")
//            Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Conexão aberta com sucesso!");
        return connection;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Driver PostgreSQL não encontrado", e);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Erro ao conectar ao banco", e);
//        }
    }

    public static JdbcRowSet getJdbcRowSet() throws SQLException{
        String url = "jdbc:postgresql://localhost:5433/minha_base";
        String username = "fmartins";
        String password = "masterkey";
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        jdbcRowSet.setUrl(url);
        jdbcRowSet.setUsername(username);
        jdbcRowSet.setPassword(password);
        return jdbcRowSet;
    }

    public static CachedRowSet getCacheRowSet() throws SQLException{
        String url = "jdbc:postgresql://localhost:5433/minha_base";
        String username = "fmartins";
        String password = "masterkey";
        CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(username);
        cachedRowSet.setPassword(password);
        return cachedRowSet;
    }




}