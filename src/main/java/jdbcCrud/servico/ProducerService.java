package jdbcCrud.servico;

import jdbcCrud.dominio.Producer;
import jdbcCrud.repository.ProducerRepository;

import java.util.List;
import java.util.Scanner;

public class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void buildMenu(int op){
        switch (op){
            case 1: findByName();
            break;
            default: throw new IllegalArgumentException("Not a value option.");
        }
    }

    private static void findByName(){
        System.out.println("Type of name or empty to all");
        String name = SCANNER.nextLine();
        List<Producer> producers = ProducerRepository.findByNamePrepareStatiment(name);
        for (int i = 0; i < producers.size(); i++) {
            Producer producer = producers.get(i);
            System.out.printf("[%d] - ID:%d %s\n", i, producer.getId(),producer.getName());
        }
    }

    

}
