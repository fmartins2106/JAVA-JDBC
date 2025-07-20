package academy.devdojo.maratonajava.SCI;

import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        caloriasConsumidas(scanner);
    }

    public static void caloriasConsumidas(Scanner scanner){
        int pacote = 40 ;
        int porcoes = 300 * 10;
        System.out.print("Quantos biscoitos você comeu ?:");
        int resultado = Integer.parseInt(scanner.nextLine().trim());
        int calculoCalorias = porcoes / 40;
        System.out.println("Você consumiu "+resultado+", o que equivale a "+(calculoCalorias*resultado)+" calorias.");
    }
}
