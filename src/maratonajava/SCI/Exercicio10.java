package academy.devdojo.maratonajava.SCI;

import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        fatorial(scanner);
    }

    public static void fatorial(Scanner scanner){
        int fatorial = 0;
        System.out.print("Digite um número:");
        int numero = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 0; i < numero; i++) {
            fatorial = ((i-1) * numero );

        }
        System.out.println("Fatorial de "+numero+"! é:"+fatorial);
    }

}
