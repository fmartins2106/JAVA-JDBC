package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;

public class Aula7Arrays1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// imprimir nomes
        arraysNomes(scanner);

//        arrays de idade
        verificandoIdade(scanner);
    }

    public static void arraysNomes(Scanner scanner){
        String[] nomes = new String[5];
        nomes[0] = "Fernando";
        nomes[1] = "Pedro";
        nomes[2] = "Maria";
        nomes[3] = "Daisy";
        nomes[4] = "Marta";
        for (int i=0;i< nomes.length;i++){
            System.out.println(nomes[i]);
        }

    }


    public static void verificandoIdade(Scanner scanner){
        int [] idade = new int[6];
        for (int i=0;i<6;i++){
            System.out.print("Digite a "+(i+1)+"º idade:");
            idade[i] = scanner.nextInt();
        }
        System.out.println("A idade na posição 1:"+idade[1]);
        System.out.println("A idade na posição 4:"+idade[4]);
        System.out.println("A idade na última posição:"+idade[idade.length-1]);
    }
}
