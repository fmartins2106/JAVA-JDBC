package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;
import java.util.Collections;

public class Aula6ExercicioOperadoresCondicionais12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        cadastro de pessoas
        System.out.println("Vamos fazer cadastro de pessoas");
        int pessoasMais18 = 0;
        int homens = 0;
        int mulheresMenos20 = 0;
        while (true){
            System.out.print("Digite o seu nome:");
            String nomePessoa = scanner.nextLine();
            System.out.print("Digite a sua idade:");
            int idadePessoa = scanner.nextInt();
            scanner.nextLine();
            if (idadePessoa>=18){
                pessoasMais18++;
            }
            System.out.print("Digite o seu sexo[f/m]:");
            char sexo = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (sexo !='m' && sexo !='f'){
                System.out.println("ERRO! Digite F ou M para continuar!");
                System.out.print("Qual sexo?:");
                sexo = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (sexo=='m'){
                homens++;
            }
            if (sexo=='f' && idadePessoa<=20){
                mulheresMenos20++;            }
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")){
                System.out.println("ERRO! Digite S ou N para continuar!");
                System.out.print("Quer continuar?:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                System.out.printf("O total de pessoas maior de idade:%d%n",pessoasMais18);
                System.out.printf("O total de homens:%d%n",homens);
                System.out.printf("Mulheres com menos de 20 anos:%d%n",mulheresMenos20);
                break;
            }
        }


//        total compra
        System.out.println("Vamos verificar o total da compra");
        double totalCompra = 0;
        double pMaisBarato = Double.POSITIVE_INFINITY;
        double pMaisDeMil = 0;
        String nMenorProduto = "";
        while (true){
            System.out.print("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine();
            System.out.print("Digite o valor do produto R$:");
            double valorProduto = scanner.nextDouble();
            scanner.nextLine();
            if (valorProduto!=0){
                totalCompra+=valorProduto;
            }
            if (valorProduto>=1000){
                pMaisDeMil++;
            }
            if (valorProduto<pMaisBarato){
                pMaisBarato=valorProduto;
                nMenorProduto = nomeProduto;
            }
            System.out.print("Quer continuar?[s/n]:");
            String soun = scanner.nextLine().trim().toLowerCase();
            while (!soun.equals("s") && !soun.equals("n")){
                System.out.println("Codigo errado, Digite S ou N.");
                System.out.print("Quer continuar?[S/N]:");
                soun = scanner.nextLine().trim().toLowerCase();
            }
            if (soun.equals("n")){
                System.out.println("O total da compra R$:"+totalCompra);
                System.out.println("Foram comprados "+pMaisDeMil+" produtos com valor acima de R$1000");
                System.out.println("O menor produto foi:"+nMenorProduto+" com valor de R$"+pMaisBarato);
                break;
            }
        }







//        caixa eletronico
        System.out.println("Vamos simular uma caixa eletrônico");
        System.out.print("Quanto você quer sacar?R$:");
        int saque = scanner.nextInt();
        int total = saque;
        int totalced = 0;
        int ced = 50;
        while (true){
            if (total>=ced){
                total-=ced;
                totalced++;
            }else {
                System.out.println("Total de "+totalced+" de R$"+ced);
                if (ced==50){
                    ced=20;
                } else if (ced==20) {
                    ced=10;
                } else if (ced==10) {
                    ced=5;
                }else if (ced==5){
                    ced=1;
                }
                totalced=0;
                if (total<=0){
                    break;
                }
            }
        }
    }
}


