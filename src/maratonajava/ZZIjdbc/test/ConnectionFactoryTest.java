package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.connection.ConnectionFactory;
import java.sql.Connection;

public class ConnectionFactoryTest {
    public static void main(String[] args) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            if (connection != null && !connection.isClosed()) {
                System.out.println("Testando a conexão: OK!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
