package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;

public class Aula4ExercicioAritimetica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Vamos fazer um calculo!");
        System.out.print("Digite o primeiro número:");
        int num1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int num2 = scanner.nextInt();
        int soma = num1+num2;
        System.out.printf("%s,a sua soma de %d + %d = %d%n", nome, num1, num2, soma);
        System.out.println("Vamos fazer mais uma conta !");
        System.out.println("Agora vamos fazer uma conta de multiplicação!");
        System.out.print("Digite um número:");
        int num3 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int num4 = scanner.nextInt();
        int multi = num3*num4;
        System.out.printf("%s, a multiplicação de %d x %d = %d%n", nome, num3, num4, multi);
        System.out.println("Agora vamos para a última conta !");
        System.out.println("Agora vamos fazer um conta de divisão");
        System.out.print("Digite o primeiro número:");
        double num5 = scanner.nextDouble();
        System.out.print("Digite o segundo número:");
        double num6 = scanner.nextDouble();
        double divisao = num5/num6;
        System.out.printf("%s, a divisão de %.2f / %.2f = %.2f%n", nome, num5,num6,divisao);
        scanner.close();
    }
}



