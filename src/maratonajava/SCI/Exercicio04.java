package academy.devdojo.maratonajava.SCI;

import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        somandoDoisMaiores(scanner);
    }

    public static void somandoDoisMaiores(Scanner scanner){
        System.out.print("Digite o primeiro número:");
        int n1 = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Digite o primeiro número:");
        int n2 = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Digite o primeiro número:");
        int n3 = Integer.parseInt(scanner.nextLine().trim());
        if (n1 > n3 && n2 > n3){
            int soma1 = n1+n2;
            System.out.println("Soma:"+soma1);
        } else if (n1 > n2 && n3> n2) {
            int soma2 = n1+n3;
            System.out.println("Soma:"+soma2);
        } else if (n2 > n1 && n3> n1) {
            int soma3 = n2+n3;
            System.out.println("Soma:"+soma3);
        }
    }
}
