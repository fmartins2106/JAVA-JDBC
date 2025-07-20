package JDCB;
// ou o pacote correspondente

import JDCB.dominio.Producer;
import JDCB.repository.ProducerRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest {
    public static void main(String[] args) {
//        log.info("info");
//        log.warn("warn");
//        log.debug("debug");
//        log.error("error");
//        log.trace("trace");
        Producer producer = Producer.builder().name("Studio Deen").build();
        ProducerRepository.save(producer);
//        try (Connection connection = ConnectionFactory.getConnection()) {
//            if (connection != null && !connection.isClosed()) {
//                System.out.println("Testando a conexão: OK!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}