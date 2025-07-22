package JDCB.repository;

import JDCB.conn.ConnectionFactory;
import JDCB.dominio.Producer;
import JDCB.listener.CustomRowSetListener;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {

    public static List<Producer> findByNameJdbcRowSet(String name){
        String sql = "SELECT * FROM anime_store.sp_get_find_by_name(?);";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setString(1,String.format("%%%s%%",name));
            jrs.execute(); //Usando somente para buscar dados, não pode ser usando para inserir dados.
            while (jrs.next()){
                Producer producer = Producer.builder()
                        .id(jrs.getInt("id"))
                        .name(jrs.getString("name"))
                        .build();
                producers.add(producer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producers;
    }


//    public static void updateJdbcRowSet(Producer producer){
//        String sql = "UPDATE anime_store.producer SET name = ? WHERE(id = ?)";
//        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
//            jrs.setCommand(sql);
//            jrs.setString(1,producer.getName());
//            jrs.setInt(2,producer.getId());
//            jrs.execute(); //Usando somente para buscar dados, não pode ser usando para inserir dados.
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }

    public static void updateJdbcRowSet(Producer producer){
        String sql = "SELECT * FROM anime_store.producer WHERE(id = ?)";
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            jrs.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            jrs.setCommand(sql);
            jrs.setInt(1,producer.getId());
            jrs.execute();
            if (!jrs.next()) return;
            jrs.updateString("name",producer.getName());
            jrs.updateRow(); // <--- ESSENCIAL: aplica a alteração no banco
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateCacheRowSet(Producer producer){
        String sql = "SELECT * FROM anime_store.producer WHERE(id = ?)";
        try (CachedRowSet crs = ConnectionFactory.getCacheRowSet();
        Connection connection = ConnectionFactory.getConnection()){
            connection.setAutoCommit(false);

            crs.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            crs.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            crs.setCommand(sql);
            crs.setInt(1,producer.getId());
            crs.addRowSetListener(new CustomRowSetListener());

            crs.execute(connection);

            if (!crs.next()) return;

            crs.updateString("name",producer.getName());
            crs.updateRow(); // <--- ESSENCIAL: aplica a alteração no banco

            crs.acceptChanges(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
