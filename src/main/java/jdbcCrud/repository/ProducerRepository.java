package jdbcCrud.repository;

import jdbcCrud.connection.ConnectionFactory;
import jdbcCrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class ProducerRepository {

    public static List<Producer> findByNamePrepareStatiment(String name) {
        log.info("Finding producer by name '{}'", name);
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE ?";
        List<Producer> producers = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatement(connection, sql, name);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producer producer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find producers by name", e);
            e.printStackTrace();
        }
        return producers;
    }

    private static PreparedStatement createdPreparedStatement(Connection connection, String sql, String name) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }

    public static void delete(int id) {
        String sql = "delete from anime_store.producer where id = ?;";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatementDelete(connection, sql, id)) {
            ps.execute();
            log.info("Deleted producer '{}' from the database", id);
        } catch (SQLException e) {
            log.error("error while trying to delete producer '{}'", id, e);
            e.printStackTrace();
        }
    }

    private static PreparedStatement createdPreparedStatementDelete(Connection connection, String sql, int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }


    public static void save(Producer producer){
        log.info("Saving producer by name '{}'", producer);
        try(Connection connection = JDCB.conn.ConnectionFactory.getConnection();
            PreparedStatement ps = preparedStatementSave(connection,producer)){
            ps.execute();
        }catch (SQLException e){
            log.error("error while trying to save producer '{}'",producer.getId(),e);
            e.printStackTrace();
        }
    }

    private static PreparedStatement preparedStatementSave(Connection connection, Producer producer) throws SQLException{
        String sql = "insert into anime_store.producer (name) values (?);";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,producer.getName());
        return ps;
    }

    public static Optional<Producer> findById(Integer id) {
        log.info("Finding producer by ID '{}'", id);
        String sql = "SELECT * FROM anime_store.producer WHERE ID = ?";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatementFindById(connection, sql, id);
             ResultSet rs = ps.executeQuery()) {
            if (!rs.next()) return Optional.empty();
            return Optional.of(Producer                    .builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build());
        } catch (SQLException e) {
            log.error("Error while trying to find producers by name", e);
            e.printStackTrace();
        }
        return Optional.empty();

    }

    private static PreparedStatement createdPreparedStatementFindById(Connection connection, String sql, Integer id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }


    public static void update(Producer producer){
        log.info("Updating producer '{}'",producer);
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = createdPreparedStatementUpdated(connection,producer)){
            ps.execute();
            log.info("Updated producer '{}' from the database",producer.getId());
        }catch (SQLException e){
            log.error("error while trying to update producer '{}'",producer.getId(),e);
            e.printStackTrace();
        }
    }

    private static PreparedStatement createdPreparedStatementUpdated(Connection connection, Producer producer) throws SQLException{
        String sql = "UPDATE anime_store.producer SET name = ? WHERE(id = ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,producer.getName());
        ps.setInt(2, producer.getId());
        return ps;
    }

}
