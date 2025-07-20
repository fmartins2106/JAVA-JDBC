package academy.devdojo.maratonajava.SCI;

import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        conversaoIdade(scanner);
    }

    public static void conversaoIdade(Scanner scanner) {
        int ano = 365;
        int mes = 30;
        System.out.print("Digite quantos anos:");
        ano = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Digite quantos meses:");
        mes = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Digite quantos dias:");
        int dia = Integer.parseInt(scanner.nextLine().trim());
        int calculoTotalIdade = (ano * 365) + (mes * 30) + dia;
        System.out.println("Sua idade em dias:" + calculoTotalIdade);
    }
}
