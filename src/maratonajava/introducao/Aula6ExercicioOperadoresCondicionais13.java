package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.time.LocalDate;

public class Aula6ExercicioOperadoresCondicionais13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while (true) {
            System.out.print("Digite um número:");
            int jogador = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Você quer PAR ou IMPAR?[Digite P ou I]:");
            String pi = scanner.nextLine().trim().toLowerCase();
            while (!pi.equals("p") && !pi.equals("i")) {
                System.out.print("ERRO! Digite P ou I para continuar!. Você quer Par(P) ou Impar(I)?:");
                pi = scanner.nextLine().trim().toLowerCase();
            }
            int computador = random.nextInt(10) + 1;
            int soma = computador + jogador;
            if (soma % 2 == 0 && pi.equals("p")) {
                System.out.printf("Você Escolheu %s, jogou %d e computador jogo %d = %d você ganhou!%n", pi, jogador, computador, soma);
            } else if (soma % 2 != 0 && pi.equals("i")) {
                System.out.printf("Você escolheu %s, jogou %d e computador jogou %d = %d você ganhou%n", pi, jogador, computador, soma);
            } else if (soma % 2 == 0 && pi.equals("i")) {
                System.out.printf("Você escolheu %s, jogou %d e computador jogou %d = %d você perdeu!%n", pi, jogador, computador, soma);
            } else if (soma % 2 != 0 && pi.equals("p")) {
                System.out.printf("Você escolheu %s, jogou %d e computador jogou %d = %d você perdeu!%n", pi, jogador, computador, soma);
            }
            System.out.print("Quer jogar novamente? (S/N): ");
            String jogarNovamente = scanner.nextLine().trim().toLowerCase();
            if (!jogarNovamente.equals("s")) {
                break;
            }
        }
    }
}

////cadastro de pessoas
//        int totalHomens = 0;
//        int mulheresMenos20 = 0;
//        int totalMaior18 = 0;
//        System.out.println("Vamos cadastrar pessoas!");
//        while (true){
//            System.out.print("nome:");
//            String nomes = scanner.nextLine();
//            System.out.print("Idade:");
//            int idadePessoa = scanner.nextInt();
//            scanner.nextLine();
//            System.out.print("Sexo?[M/F]:");
//            char sexoPessoa = scanner.nextLine().trim().toLowerCase().charAt(0);
//            while (sexoPessoa !='f' && sexoPessoa !='m'){
//                System.out.println("ERRO! Digite M ou F para cadastrar o sexo!");
//                System.out.print("Sexo?:");
//                sexoPessoa = scanner.nextLine().trim().toLowerCase().charAt(0);
//            }
//            System.out.print("Quer continuar?[S/N]:");
//            String seguir = scanner.nextLine().trim().toLowerCase();
//            while (!seguir.equals("s") && !seguir.equals("n")){
//                System.out.print("ERRO! Digite S ou não para continuar!, Quer continuar?:");
//                seguir = scanner.nextLine().trim().toLowerCase();
//            }
//            if (idadePessoa>=18){
//                totalMaior18++;
//            }
//            if (sexoPessoa=='m'){
//                totalHomens++;
//            }
//            if (sexoPessoa=='f' && idadePessoa<=20){
//                mulheresMenos20++;
//            }
//            if (seguir.equals("n")){
//                System.out.printf("O total de pessoas maior de idade:%d%n",totalMaior18);
//                System.out.printf("Pessoas sexo Masculino:%d%n",totalHomens);
//                System.out.printf("Mulheres com menos de 20 anos:%d%n",mulheresMenos20);
//                break;
//            }
//        }
//
//
//// analise compra em uma loja
//        System.out.println("Vamos verificar a sua compra");
//        double totalCompra = 0;
//        int totalMaisMil = 0;
//        double menorValor = Double.POSITIVE_INFINITY;
//        String menorNomeProduto = "";
//        while (true){
//            System.out.print("Digite o nome do produto:");
//            String nomeProduto = scanner.nextLine();
//            System.out.print("Digite o valor do produto:R$");
//            double valorProduto = scanner.nextDouble();
//            scanner.nextLine();
//            if (valorProduto>0){
//                totalCompra+=valorProduto;
//            }
//            if (valorProduto>=1000){
//                totalMaisMil++;
//            }
//            if (valorProduto < menorValor){
//                menorValor=valorProduto;
//                menorNomeProduto=nomeProduto;
//            }
//            System.out.print("Quer continuar?[s/n]:");
//            String continuar = scanner.nextLine().trim().toLowerCase();
//            while (!continuar.equals("s") && !continuar.equals("n")){
//                System.out.println("Erro, digite S ou N para continuar!");
//                System.out.print("Quer continuar?:");
//                continuar = scanner.nextLine().trim().toLowerCase();
//            }
//            if (continuar.equals("n")){
//                System.out.println("O total da compra:R$"+totalCompra);
//                System.out.println("Compras acima de R$1000: "+totalMaisMil);
//                System.out.println("Menor produto comprado:"+menorNomeProduto+" de R$"+menorValor);
//                break;
//            }
//        }
//
//
////        exercicio caixa eletronico
//        System.out.println("Vamos simular um caixa eletrônico");
//        System.out.print("Digite quando quer sacar:R$");
//        int saque = scanner.nextInt();
//        int total= saque;
//        int ced = 50;
//        int totalced = 0;
//        while (true){
//            if (saque>=ced){
//                saque-=ced;
//                totalced++;
//            }else {
//                if (totalced>0){
//                    System.out.println("Total de "+totalced+" de R$"+ced);
//                }if (ced==50){
//                    ced=20;
//                } else if (ced==20) {
//                    ced=10;
//                } else if (ced==10) {
//                    ced=5;
//                } else if (ced==5) {
//                    ced=1;
//                }
//                totalced=0;
//                if (total<=0){
//                    break;
//                }
//            }
//        }
//    }
//}
