package academy.devdojo.maratonajava.SCI;

import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        trocandoVariaveis(scanner);
    }

    public static void trocandoVariaveis(Scanner scanner){
        int a = 4;
        int b = 7;
        int ab = a;
        a=b;
        b=ab;
        System.out.println("A:"+a);
        System.out.println("B:"+b);

    }

}
