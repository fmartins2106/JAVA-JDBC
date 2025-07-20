package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;
public class Aula4Exercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o seu nome:");
        String nome = scanner.nextLine();
        System.out.print("Digite o seu sobrenome:");
        String sobrenome = scanner.nextLine();
        System.out.printf("Seja vem vindo ao nosso sistema %s %s !%n", nome, sobrenome);
        scanner.close();
    }
}


















