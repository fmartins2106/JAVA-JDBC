package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.util.Random;

public class Aula6ExercicioOperadoresCondicionais11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//cadastro de pessoas
        System.out.println("Vamos cadastrar pessoas");
        int pessoasMais18 = 0;
        int homensCadastrados = 0;
        int mulheresMenos20 = 0;
        while (true){
            System.out.print("Digite o nome:");
            String nomePessoa = scanner.nextLine();
            System.out.print("Digite a idade:");
            int idadePessoa = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o sexo [F/M]:");
            char sexoPessoa = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (sexoPessoa != 'f' && sexoPessoa !='m'){
                System.out.print("Sexo inválido. Digite o sexo novamente[f/m]:");
                sexoPessoa = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (idadePessoa>=18){
                pessoasMais18++;
            }
            if (sexoPessoa =='m'){
                homensCadastrados++;
            }
            if (sexoPessoa=='f' && idadePessoa<=20){
                mulheresMenos20++;
            }
            System.out.print("Quer cadastrar mais alguma pessoa?[S/N]:");
            String novaPessoa = scanner.nextLine().trim().toLowerCase();
            while (!novaPessoa.equals("s") && !novaPessoa.equals("n")){
                System.out.print("Erro, digite S ou N. Quer cadastrar outra pessoa?[s/n]:");
                novaPessoa = scanner.nextLine().trim().toLowerCase();
            }
            if (novaPessoa.equals("n")){
                System.out.printf("Total de pessoas com mais de 18 anos:%d%n",pessoasMais18);
                System.out.printf("Total de homens cadastrados:%d%n",homensCadastrados);
                System.out.printf("Total de mulheres com menos de 20 anos:%d%n",mulheresMenos20);
                break;
            }

        }

////        calculo compra em uma loja
//        System.out.println("Vamos verificar o total da compra.");
//        double maisBarato = Double.POSITIVE_INFINITY;
//        double total = 0;
//        double maisMil = 0;
//        String nomeMaisBarato = "";
//        while (true){
//            System.out.print("Digite o nome do produto:");
//            String nomeProduto = scanner.nextLine();
//            System.out.print("Digite o valor do produto:");
//            double valorProduto = scanner.nextDouble();
//            scanner.nextLine();
//            if (valorProduto!=0){
//                total+=valorProduto;
//            }
//            if (valorProduto>=1000){
//                maisMil++;
//            }
//            if (valorProduto<maisBarato){
//                maisBarato=valorProduto;
//                nomeMaisBarato = nomeProduto;
//            }
//            System.out.print("Quer continuar?[S/N]:");
//            String soun = scanner.nextLine().trim().toLowerCase();
//            while (!soun.equals("s") && !soun.equals("n")){
//                System.out.println("Digite S ou N para continuar...");
//                System.out.print("Quer continuar?[S/N]:");
//                soun = scanner.nextLine().trim().toLowerCase();
//            }
//            if (soun.equals("n")){
//                System.out.printf("O total da compra:R$%.2f%n",total);
//                System.out.printf("Foram comprados %.2f com mais de R$1000 reais%n",maisMil);
//                System.out.printf("O produto de menor valor foi:%s, valor de R$%.2f%n",nomeMaisBarato,maisBarato);
//                break;
//            }
//        }
//
//
//
////        Calculo caixa eletronico
//        System.out.println("Vamos fazer um programa de caixa eletronico");
//        System.out.print("Quanto gostaria de sacar?:");
//        int saque = scanner.nextInt();
//        int ced = 50;
//        int totalced=0;
//        int valor = saque;
//        while (true){
//            if (valor>=ced){
//                valor-=ced;
//                totalced++;
//            }else {
//                System.out.println("Total de "+totalced+" de R$"+ced);
//                if (ced==50){
//                    ced=20;
//                } else if (ced==20) {
//                    ced=10;
//                } else if (ced==10) {
//                    ced=1;
//                }
//                totalced=0;
//                if (valor<=0){
//                    break;
//                }
//            }
//        }
//
//
//
//
//        System.out.println("Vamos verificar o maior, menor, quantidade e média da lista");
//        int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE, quant = 0, soma = 0;
//        String resp = "s";
//        while (resp.equalsIgnoreCase("s")){
//            System.out.print("Digite um número:");
//            int numero = scanner.nextInt();
//            scanner.nextLine();
//            soma+=numero;
//            quant++;
//            if (numero > maior){
//                maior = numero;
//            }
//            if (numero < menor){
//                menor = numero;
//            }
//            System.out.print("Quer continuar?[S/N]:");
//            resp = scanner.nextLine();
//        }
//        if (quant !=0){
//            float media = soma/quant;
//            System.out.println("A quantidade é:"+quant+" e a média é:"+media);
//            System.out.print("O maior é:"+maior+" e o menor é:"+menor);
//        }
       scanner.close();
    }
}


