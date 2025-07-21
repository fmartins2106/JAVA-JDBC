package JDCB.repository;

import JDCB.conn.ConnectionFactory;
import JDCB.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public static void update(Producer producer){
        String sql = "UPDATE anime_store.producer SET name = '%s' WHERE(id = '%d');"
                .formatted(producer.getName(),producer.getId());
        try(Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement()){
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Update producer '{}' from the database,rows affected '{}'",producer.getId(),rowsAffected);
        }catch (SQLException e){
            log.error("error while trying to update producer '{}'",producer.getId(),e);
            e.printStackTrace();
        }
    }

    public static List<Producer> findAll(){
        log.info("Finding all producers");
        String sql = "SELECT id, name from anime_store.producer;";
        List<Producer> producers =new ArrayList<>();
        try(Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Producer producer = Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        }catch (SQLException e){
            log.error("error while trying to find all producer",e);
            e.printStackTrace();
        }
        return producers;
    }


    public static List<Producer> findByName(String name){
        log.info("Finding all producers by name like '{}'", name);
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE ?";
        List<Producer> producers = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%"); // adiciona o % para LIKE

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()){
                    Producer producer = Producer.builder()
                            .id(rs.getInt("id"))
                            .name(rs.getString("name"))
                            .build();
                    producers.add(producer);
                }
            }
        } catch (SQLException e){
            log.error("Error while trying to find producers by name", e);
            e.printStackTrace();
        }
        return producers;
    }


    public static void showProduceMetaData(){
        log.info("Showing all producers");
        String sql = "SELECT * from anime_store.producer;";
        try(Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();
            log.info("Columsn count '{}'",columnCount);
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name '{}'",rsMetaData.getTableName(i));
                log.info("Column name '{}'",rsMetaData.getColumnName(i));
                log.info("Column size '{}'",rsMetaData.getColumnDisplaySize(i));
                log.info("Column type '{}'",rsMetaData.getColumnTypeName(i));
            }
        }catch (SQLException e){
            log.error("error while trying to find all producer",e);
        }
    }

    public static void showDriveMetaData(){
        log.info("Showing Driive Metadata");
        String sql = "SELECT * from anime_store.producer;";
        try(Connection connection = ConnectionFactory.getConnection()){
            DatabaseMetaData metaData = connection.getMetaData();
            if (metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)){
                log.info("Supports TYPE_FORWARD_ONLY");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE)){
                    log.info("Supports CONCUR_UPDATABLE");
                }
            }
            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)){
                log.info("Supports TYPE_SCROLL_INSENSITIVE");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)){
                    log.info("Supports CONCUR_UPDATABLE");
                }
            }
            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)){
                log.info("Supports TYPE_SCROLL_SENSITIVE");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)){
                    log.info("Supports CONCUR_UPDATABLE");
                }
            }
        }catch (SQLException e){
            log.error("error while trying to find all producer",e);
        }
    }

//    public static void update(Producer producer) {
//        String sql = "UPDATE anime_store.producer SET name = ? WHERE id = ?";
//        try (Connection connection = ConnectionFactory.getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql)) {
//
//            ps.setString(1, producer.getName());
//            ps.setInt(2, producer.getId());
//
//            int rowsAffected = ps.executeUpdate();
//            log.info("Updated producer '{}' in the database. Rows affected: '{}'", producer.getId(), rowsAffected);
//
//        } catch (SQLException e) {
//            log.error("Error while trying to update producer '{}'", producer.getId(), e);
//            e.printStackTrace();
//        }
//    }




}
