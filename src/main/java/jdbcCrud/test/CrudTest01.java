package jdbcCrud.test;

import jdbcCrud.servico.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        int op = 0;
        while (true){
            producerMenu();
            op = Integer.parseInt(SCANNER.nextLine().trim());
            if (op == 0) break;
            ProducerService.buildMenu(op);
        }
    }

    private static void producerMenu(){
        System.out.println("Type the number of yout operation");
        System.out.println("1. Search for producer.");
        System.out.println("0. Exit.");
    }

}
