package JDCB.service;

import JDCB.dominio.Producer;
import JDCB.repository.ProducerRepository;

public class ProducerService {

    public static void save(Producer producer){
        ProducerRepository.save(producer);
    }

    public static void delete(int id) throws IllegalAccessException {
        if (id <= 0){
            throw new IllegalAccessException("Invalid value for id");
        }
        ProducerRepository.delete(id);
    }
}
