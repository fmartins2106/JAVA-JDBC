package JDCB.repository;

import JDCB.conn.ConnectionFactory;
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
            log.info("Inserted producer '{}' inte the database,rows affected '{}'",producer.getName(),rowsAffected);
        }catch (SQLException e){
            log.error("error while trying to insert producer '{}'",producer.getName(),e);
            e.printStackTrace();
        }

        public static void delete(int id){
            String sql = "Delete into anime_store.producer(name) values ('%d');".formatted(id);
            try(Connection connection = ConnectionFactory.getConnection();
                Statement stmt = connection.createStatement()){
                int rowsAffected = stmt.executeUpdate(sql);
                log.info("Delete producer '{}' from the database,rows affected '{}'",id,rowsAffected);
            }catch (SQLException e){
                log.error("error while trying to delete producer '{}'",id,e);
                e.printStackTrace();
            }
        }

    }

    public static void delete(int id){
        String sql = "delete from anime_store.producer where (id = '%d');".formatted(id);
        try(Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement()){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}' from the database,rows affected '{}'",id,rowsAffected);
        }catch (SQLException e){
            log.error("error while trying to delete producer '{}'",id,e);
            e.printStackTrace();
        }
    }



}
