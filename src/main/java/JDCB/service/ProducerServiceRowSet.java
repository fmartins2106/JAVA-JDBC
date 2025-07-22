package JDCB.service;

import JDCB.dominio.Producer;
import JDCB.repository.ProducerRepositoryRowSet;

import java.util.List;

public class ProducerServiceRowSet {

    public static List<Producer> findByNameJdbcRowSet(String name){
        return ProducerRepositoryRowSet.findByNameJdbcRowSet(name);
    }

    public static void updateJdbcRowSet(Producer producer){
        ProducerRepositoryRowSet.updateJdbcRowSet(producer);
    }

    public static void updateCachRowSet(Producer producer){
        ProducerRepositoryRowSet.updateCacheRowSet(producer);
    }


}
