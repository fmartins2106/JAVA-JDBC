package jdbcCrud.test;

import jdbcCrud.servico.AnimeService;
import jdbcCrud.servico.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        int op = 0;
        while (true){
            menu();
            op = Integer.parseInt(SCANNER.nextLine().trim());
            switch (op){
                case 0:
                    return;
                case 1:
                    producerMenu();
                    op = Integer.parseInt(SCANNER.nextLine().trim());
                    ProducerService.menu(op);
                    break;
                case 2:
                    animeMenu();
                    op = Integer.parseInt(SCANNER.nextLine().trim());
                    AnimeService.menu(op);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void producerMenu(){
        System.out.println("Type the number of your operation");
        System.out.println("1. Search for producer.");
        System.out.println("2. Delete producer.");
        System.out.println("3. Save producer.");
        System.out.println("4. Update producer.");
        System.out.println("9. Go back.");
    }

    private static void menu(){
        System.out.println("Type the number of your operation");
        System.out.println("1. Producer");
        System.out.println("2. Anime");
        System.out.println("0. Exit");
    }

    private static void animeMenu(){
        System.out.println("Type the number of your operation");
        System.out.println("1. Search for anime.");
        System.out.println("2. Delete anime.");
        System.out.println("3. Save anime.");
        System.out.println("4. Update anime.");
        System.out.println("9. Go back.");
    }

}
