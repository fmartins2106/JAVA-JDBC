package JDCB.service;

import JDCB.dominio.Producer;
import JDCB.repository.ProducerRepository;

import java.util.List;

public class ProducerService {

    public static void save(Producer producer) {
        ProducerRepository.save(producer);
    }

    public static void delete(Integer id) {
        validacaoID(id);
        ProducerRepository.delete(id);
    }

    public static void update(Producer producer){
        validacaoID(producer.getId());
        ProducerRepository.update(producer);
    }

    public static List<Producer> findAll(){
        return ProducerRepository.findAll();
    }

    public static List<Producer> findByName(String name){
        return ProducerRepository.findByName(name);
    }

    public static void showProduceMetaData(){
        ProducerRepository.showProduceMetaData();
    }

    public static void showDriveMetaData(){
        ProducerRepository.showDriveMetaData();
    }


    private static void validacaoID(Integer id){
        if (id == null || id <= 0){
            throw new IllegalArgumentException("Invalid value for id.");
        }
    }

    public static List<Producer> findByNameUpdateToUpper(String name){
        return ProducerRepository.findByNameUpdateToUpper(name);
    }

    public static List<Producer> findByNameAndInsertWhenNotFound(String name){
        return ProducerRepository.findByNameAndInsertWhenNotFound(name);
    }

    public static void findByNameAndDelete(String name){
        ProducerRepository.findByNameAndDelete(name);
    }

    public static List<Producer> findByNamePrepareStatiment(String name){
        return ProducerRepository.findByNamePrepareStatiment(name);
    }

    public static void updatePreparedStatement(Producer producer){
        validacaoID(producer.getId());
        ProducerRepository.updatePreparedStatement(producer);
    }

    public static List<Producer> findByNameCallableStatement(String name){
        return ProducerRepository.findByNameCallableStatement(name);
    }




}
