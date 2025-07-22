package JDCB.test;

import JDCB.dominio.Producer;
import JDCB.service.ProducerService;

import java.util.List;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {
        Producer producer1 = Producer.builder().name("Toei Animantion").build();
        Producer producer2 = Producer.builder().name("White foz").build();
        Producer producer3 = Producer.builder().name("Studio Guibli").build();
        ProducerService.saveTransaction(List.of(producer1,producer2,producer3));

    }
}
