package academy.devdojo.maratonajava.introducao;


import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;


public class Aula6ExercicioOperadocesCondicionais {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        ArrayList<Double> lista = new ArrayList<>();
        System.out.println("Vamos verificar o maior e o menor peso");
        for (int i=1;i<=5;i++){
            System.out.print("Digite o "+i+"° pessoa:");
            double peso = scanner.nextDouble();
            lista.add(peso);
        }
        double maior = Collections.max(lista);
        double menor = Collections.min(lista);
        System.out.println("O maior peso da lista foi:"+maior+"Kg");
        System.out.println("O menor peso da lista foi:"+menor+"Kg");

// exercicio se a pessoa é maior ou menor de idade
        int totalMaior = 0;
        int totalMenor = 0;
        int anoAtual = java.time.Year.now().getValue();
        for (int i=1; i<=7; i++) {
            System.out.print("Em que ano a "+i+"° pessoa nasceu?:");
            int anoNascimento = scanner.nextInt();
            int idade = anoAtual-anoNascimento;
            if (idade<18){
                totalMaior++;
            }else{
                totalMenor++;
            }
        }
        System.out.println("Ao todo tivemos "+totalMaior+" pessoas maiores de idade");
        System.out.println("Ao todo tivemos" +totalMenor+" pessoas menores de idade");
    }
}
