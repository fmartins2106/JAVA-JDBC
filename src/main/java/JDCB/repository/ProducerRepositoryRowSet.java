package JDCB.repository;

import JDCB.conn.ConnectionFactory;
import JDCB.dominio.Producer;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProducerRepositoryRowSet {

    public static List<Producer> findByNameJdbcRowSet(String name){
        String sql = "SELECT * FROM anime_store.sp_get_find_by_name(?);";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()){
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
}
