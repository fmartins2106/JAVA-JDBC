package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;


public class Aula6ExercicioOperadoresCondicionais10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double barato = Double.POSITIVE_INFINITY;
        double totalCompra = 0;
        int mais = 0;
        String nomeMaisBarato = "";
        while (true) {
            System.out.print("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine();
            System.out.print("Digite o valor do produto:R$");
            double valorProduto = scanner.nextDouble();
            totalCompra += valorProduto;
            if (valorProduto >= 1000.00) {
                mais++;
            }
            if (valorProduto < barato) {
                barato = valorProduto;
                nomeMaisBarato = nomeProduto;
            }
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            String novo = scanner.nextLine().trim().toLowerCase();
            while (!novo.equals("s") && !novo.equals("n")) {
                System.out.println("Resposta invalida. Quer continuar?[S/N]?:");
                novo = scanner.nextLine().trim().toLowerCase();
            }
            if (novo.equals("n")) {
                System.out.printf("O valor total da compra foi:R$%.2f%n", totalCompra);
                System.out.printf("Temos %d produtos custando mais de R$1000.00", mais);
                System.out.printf("O menor intem da compra foi:%s com valor de R$:%.2f%n", nomeMaisBarato, barato);
                break;
            }


// progorama saque
            System.out.print("Quanto gostaria de sacar?R$:");
            int valor1 = scanner.nextInt();
            int total = valor1;
            int ced = 50;
            int totalced = 0;
            while (true) {
                if (total >= ced) {
                    total = total - ced;
                    totalced++;
                } else {
                    if (totalced > 0) {
                        System.out.println("O total de notas " + totalced + " cédulas de R$" + ced);
                    }
                    if (ced == 50) {
                        ced = 20;
                    } else if (ced == 20) {
                        ced = 10;
                    } else if (ced == 10) {
                        ced = 1;
                    }
                    totalced = 0;
                    if (total == 0) {
                        break;
                    }

                }

            }


//        soma  usando o while
            int somaValores = 0;
            while (true) {
                System.out.print("Digite um número:");
                int numeroAdd = scanner.nextInt();
                if (numeroAdd == 999) {
                    System.out.println("Finalizando.");
                    break;
                } else {
                    somaValores += numeroAdd;
                }
            }
            System.out.println("Os valores somados:" + somaValores);


// maior, menor, quantidade e soma;

            int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE, somaNumeros = 0, quantNumeros = 0;
            String resposta = "s";
            while (resposta.equalsIgnoreCase("s")) {
                System.out.print("Digite um número:");
                int todosNumeros = scanner.nextInt();
                somaNumeros += todosNumeros;
                quantNumeros++;
                if (todosNumeros > maiorNumero) {
                    maiorNumero = todosNumeros;
                }
                if (todosNumeros < menorNumero) {
                    menorNumero = todosNumeros;
                }
                System.out.print("Quer continuar?[S/N]:");
                resposta = scanner.next();
            }
            if (quantNumeros > 0) {
                float mediaNumeros = somaNumeros / quantNumeros;
                System.out.println("A quantidade:" + quantNumeros + " e a média " + mediaNumeros);
                System.out.println("O maior:" + maiorNumero + " e o menor:" + menorNumero);
            } else {
                System.out.println("Não foram adicionados números na lista!");
            }


//        digitar numeros e somar os numeros digitiados.
            int somaN = 0;
            int contN = 0;
            while (true) {
                System.out.print("Digite um número:");
                int numeros = scanner.nextInt();
                if (numeros == 999) {
                    System.out.println("Lista finalizada!");
                    break;
                } else {
                    somaN += numeros;
                    contN++;
                }
            }
            System.out.println("A soma é igual:" + somaN + " e a quantidade:" + contN);

//        exercicio com while, quantidade, media, maior e menor
            int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE, soma = 0, quant = 0;
            String resp = "s";
            while (resp.equalsIgnoreCase("s")) {
                System.out.print("Digite um número:");
                int numero = scanner.nextInt();
                soma += numero;
                quant++;
                if (numero > maior) {
                    maior = numero;
                }
                if (numero < menor) {
                    menor = numero;
                }
                System.out.print("Quer continuar?[S/N]:");
                resp = scanner.next();
            }
            if (quant != 0) {
                float media = soma / quant;
                System.out.println("A quantidade é: " + quant + " e a média é: " + media);
                System.out.println("O maior é: " + maior + " e o menor: " + menor);
            } else {
                System.out.println("Não foram adicionados números.");
            }
            scanner.close();
        }
    }
}


