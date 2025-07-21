package JDCB.test;
// ou o pacote correspondente

import JDCB.service.ProducerService;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest {
    public static void main(String[] args) throws IllegalAccessException {
//        log.info("info");
//        log.warn("warn");
//        log.debug("debug");
//        log.error("error");
//        log.trace("trace");


//        Producer producer = Producer.builder().name("Studio Deen").build();

//        ProducerService.save(producer);
//
//        ProducerService.delete(13);
//
//        Producer producerToUpdate = Producer.builder().id(1).name("MADHOUSE").build();
//
//        ProducerService.update(producerToUpdate);

//        List<Producer> producers = ProducerService.findAll();
//        log.info("Producers found: '{}'",producers);
//
//        List<Producer> producers = ProducerService.findByName("MADHOUSE");
//        log.info("Producers found: '{}'",producers);

//        ProducerService.showProduceMetaData();
        ProducerService.showDriveMetaData();
//        try (Connection connection = ConnectionFactory.getConnection()) {
//            if (connection != null && !connection.isClosed()) {
//                System.out.println("Testando a conexão: OK!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}