package JDCB.test;

import JDCB.dominio.Producer;
import JDCB.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest02 {

    public static void main(String[] args) {


        Producer producerToUpdate = Producer.builder().id(2).name("Good Boy").build();
        ProducerServiceRowSet.updateCachRowSet(producerToUpdate);
        log.info("__________________________________________________________________");
//        List<Producer> producers = ProducerRepositoryRowSet.findByNameJdbcRowSet("");
//        log.info(producers);


    }




}
