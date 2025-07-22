package jdbcCrud.repository;

import jdbcCrud.connection.ConnectionFactory;
import jdbcCrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {

    public static List<Producer> findByNamePrepareStatiment(String name){
        log.info("Finding producer by name '{}'", name);
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE ?";
        List<Producer> producers = new ArrayList<>();
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = createdPreparedStatement(connection,sql,name);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producer producer = Producer.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (SQLException e){
            log.error("Error while trying to find producers by name", e);
            e.printStackTrace();
        }
        return producers;
    }

    private static PreparedStatement createdPreparedStatement(Connection connection, String sql, String name) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,String.format("%%%s%%",name));
        return ps;
    }

}
