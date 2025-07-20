package academy.devdojo.maratonajava.SCI;

import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tabuada(scanner);
    }

    public static void tabuada(Scanner scanner){
        System.out.print("Digite um número de 1 a 10:");
        int numero = Integer.parseInt(scanner.nextLine().trim());
        if (numero < 0 || numero > 10){
            System.out.println("Número inválido.");
        }else {
            for (int i = 0; i < 10; i++) {
                System.out.println(numero+" x "+(i+1)+"="+((i+1)*numero));
            }

        }

    }
}
