package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;

public class Aula4ExercicioImc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seja vem vindo ao nosso sistema!");
        System.out.print("Informe seu nome completo:");
        String nome = scanner.nextLine();
        System.out.printf("%s, Muito Obrigado por iniciar nosso questionário!%n", nome);
        System.out.println("Vamos para as próximas perguntas !");
        System.out.print("Informe seu peso:");
        double peso = scanner.nextDouble();
        System.out.print("Informe a sua altura:");
        double altura = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Informe a sua cidade:");
        String cidade = scanner.nextLine();
        System.out.print("Digite o dia do seu nascimento:");
        int dia = scanner.nextInt();
        System.out.print("Digite o mês do nascimento:");
        int mes = scanner.nextInt();
        System.out.print("Digite o ano de nascimento:");
        int ano = scanner.nextInt();
        System.out.printf("Data de Nascimento %d/%d/%d%n", dia, mes, ano);
        System.out.println("Obrigado pelas informações!");
        System.out.println("Agora vamos calcular o IMC!");
        double imc = peso/(altura*altura);
        System.out.printf("Seu nome é %s%n", nome);
        System.out.printf("Sua cidade: %s%n",cidade);
        System.out.printf("Data de Nascimento %d/%d/%d%n", dia, mes, ano);
        System.out.printf("Seu IMC: %.2f%n", imc);
        System.out.println("Muito Obrigado!");
        scanner.close();
    }
}










