package jdbcCrud.repository;

import jdbcCrud.connection.ConnectionFactory;
import jdbcCrud.dominio.Anime;
import jdbcCrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class AnimeRepository {

    public static List<Anime> findByNamePrepareStatiment(String name) {
        log.info("Finding anime by name '{}'", name);
        List<Anime> animes = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatement(connection,name);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producer producer = Producer.builder()
                        .id(rs.getInt("producer_id"))
                        .name(rs.getString("producer_name"))
                        .build();
                Anime anime = Anime.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .episodes(rs.getInt("episodes"))
                        .producer(producer)
                        .build();
                animes.add(anime);
            }
        } catch (SQLException e) {
            log.error("Error while trying to find animes by name", e);
            e.printStackTrace();
        }
        return animes;
    }

    private static PreparedStatement createdPreparedStatement(Connection connection, String name) throws SQLException {
        String sql = "SELECT" +
                "    a.id," +
                "    a.name," +
                "    a.episodes," +
                "    a.producer_id," +
                "    p.name as \"Producer_name\"" +
                "from anime_store.anime a " +
                "inner join anime_store.producer p " +
                "on p.id = a.producer_id "  +
                "where a.name LIKE ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }




    public static void delete(int id) {
        String sql = "delete from anime_store.anime where id = ?;";
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatementDelete(connection, sql, id)) {
            ps.execute();
            log.info("Deleted anime '{}' from the database", id);
        } catch (SQLException e) {
            log.error("error while trying to delete anime '{}'", id, e);
            e.printStackTrace();
        }
    }

    private static PreparedStatement createdPreparedStatementDelete(Connection connection, String sql, int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }


    public static void save(Anime anime){
        log.info("Saving anime by name '{}'", anime);
        try(Connection connection = JDCB.conn.ConnectionFactory.getConnection();
            PreparedStatement ps = preparedStatementSave(connection,anime)){
            ps.execute();
        }catch (SQLException e){
            log.error("error while trying to save anime '{}'",anime.getId(),e);
            e.printStackTrace();
        }
    }

    private static PreparedStatement preparedStatementSave(Connection connection, Anime anime) throws SQLException{
        String sql = "INSERT INTO anime_store.anime(name,episodes,producer_id) values (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,anime.getName());
        ps.setInt(2,anime.getEpisodes());
        ps.setInt(3,anime.getProducer().getId());

        return ps;
    }

    public static Optional<Anime> findById(Integer id) {
        log.info("Finding anime by ID '{}'", id);
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = createdPreparedStatementFindById(connection, id);
             ResultSet rs = ps.executeQuery()) {
            if (!rs.next()) return Optional.empty();
            Producer producer = Producer.builder()
                    .id(rs.getInt("producer_id"))
                    .name(rs.getString("producer_name"))
                    .build();
            Anime anime = Anime.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .episodes(rs.getInt("episodes"))
                    .producer(producer)
                    .build();
            return Optional.of(anime);
        } catch (SQLException e) {
            log.error("Error while trying to find animes by name", e);
            e.printStackTrace();
        }
        return Optional.empty();

    }

    private static PreparedStatement createdPreparedStatementFindById(Connection connection, Integer id) throws SQLException {
        String sql = "SELECT" +
                "    a.id," +
                "    a.name," +
                "    a.episodes," +
                "    a.producer_id," +
                "    p.name as \"Producer_name\"" +
                "from anime_store.anime a " +
                "inner join anime_store.producer p " +
                "on p.id = a.producer_id " +
                "where a.id = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }


    public static void update(Anime anime){
        log.info("Updating anime '{}'",anime);
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = createdPreparedStatementUpdated(connection,anime)){
            ps.execute();
            log.info("Updated anime '{}' from the database",anime.getId());
        }catch (SQLException e){
            log.error("error while trying to update anime '{}'",anime.getId(),e);
            e.printStackTrace();
        }
    }

    private static PreparedStatement createdPreparedStatementUpdated(Connection connection, Anime anime) throws SQLException{
        String sql = "UPDATE anime_store.anime SET name = ?, episodes = ? WHERE(id = ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setInt(3, anime.getId());
        return ps;
    }

}
