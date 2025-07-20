package JDCB.repository;

import JDCB.ConnectionFactory;
import JDCB.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class ProducerRepository {
    public static void save(Producer producer){
        String sql = "insert into anime_store.producer(name) values ('%s');".formatted(producer.getName());
        try(Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement()){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Database rows affected{}",rowsAffected);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
