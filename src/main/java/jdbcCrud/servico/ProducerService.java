package jdbcCrud.servico;

import jdbcCrud.dominio.Producer;
import jdbcCrud.repository.ProducerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
            default -> throw new IllegalArgumentException("Not a value option.");
        }
    }

    private static void findByName() {
        System.out.println("Type of name or empty to all");
        String name = SCANNER.nextLine();
        List<Producer> producers = ProducerRepository.findByNamePrepareStatiment(name);
        producers.forEach(producer-> System.out.printf("[%d] -%s\n", producer.getId(), producer.getName()));
    }

    private static void delete() {
        findByName();
        System.out.println("Type the ID of the producer you want to delete:");
        int id = Integer.parseInt(SCANNER.nextLine().trim());
        System.out.println("Are you sure ? s/n:");
        String choice = SCANNER.nextLine().trim();
        if ("s".equalsIgnoreCase(choice)) {
            ProducerRepository.delete(id);
        }
    }

    private static void save() {
        System.out.println("Type of the name of producer");
        String name = SCANNER.nextLine().trim();
        Producer producer = Producer.builder().name(name).build();
        ProducerRepository.save(producer);
    }

    private static void update(){
        System.out.println("Type the ud of the object you want to update:");
        Optional<Producer> producerOptional = ProducerRepository.findById(Integer.parseInt(SCANNER.nextLine().trim()));
        if (producerOptional.isEmpty()){
            System.out.println("Producer not found.");
            return;
        }
        Producer producerFromDb = producerOptional.get();
        System.out.println("Producer found"+producerFromDb);
        System.out.println("Type the new name or enter to keep the same.");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? producerFromDb.getName() : name;
        Producer producerToUpdate = Producer.builder()
                .id(producerFromDb.getId())
                .name(name)
                .build();
        ProducerRepository.update(producerToUpdate);
    }


}
