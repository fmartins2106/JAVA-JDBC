package jdbcCrud.servico;

import jdbcCrud.dominio.Anime;
import jdbcCrud.dominio.Producer;
import jdbcCrud.repository.AnimeRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AnimeService {
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
        List<Anime> animes = AnimeRepository.findByNamePrepareStatiment(name);
        animes.forEach(anime-> System.out.printf("[%d] -%s\n", anime.getId(), anime.getName()));
    }

    private static void delete() {
        findByName();
        System.out.println("Type the ID of the anime you want to delete:");
        int id = Integer.parseInt(SCANNER.nextLine().trim());
        System.out.println("Are you sure ? s/n:");
        String choice = SCANNER.nextLine().trim();
        if ("s".equalsIgnoreCase(choice)) {
            AnimeRepository.delete(id);
        }
    }

    private static void save() {
        System.out.println("Type of the name of anime");
        String name = SCANNER.nextLine().trim();
        System.out.println("Type of the number of episodes");
        int episodes = Integer.parseInt(SCANNER.nextLine().trim());
        System.out.println("Type the id of the producer");
        Integer producerId = Integer.parseInt(SCANNER.nextLine().trim());
        Anime anime = Anime.builder()
                .episodes(episodes)
                .name(name)
                .producer(Producer.builder().id(producerId).build())
                .build();
        AnimeRepository.save(anime);
    }

    private static void update(){
        System.out.println("Type the ud of the object you want to update:");
        Optional<Anime> animeOptional = AnimeRepository.findById(Integer.parseInt(SCANNER.nextLine().trim()));
        if (animeOptional.isEmpty()){
            System.out.println("Anime not found.");
            return;
        }
        Anime animeFromDb = animeOptional.get();
        System.out.println("Anime found"+animeFromDb);
        System.out.println("Type the new name or enter to keep the same.");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? animeFromDb.getName() : name;

        System.out.println("Type the new number of episodes or enter to keep the same.");
        int episodes = Integer.parseInt(SCANNER.nextLine());
        Anime animeToUpdate = Anime.builder()
                .id(animeFromDb.getId())
                .episodes(episodes)
                .producer(animeFromDb.getProducer())
                .name(name)
                .build();
        AnimeRepository.update(animeToUpdate);
    }


}
