package academy.devdojo.maratonajava.introducao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercicios18 {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // lista ordem crescente
        ordemCrescente(scanner);

        //ler maior numero
        lerMaiornumero(scanner);

        //numero eleitores.
        calcularNumeroEleitores(scanner);

        //troca valores
        trocaValores(scanner);

        // calculoIMC
        calculoIMC(scanner);

        //calculando notas juizes.4

        calculandoNotasJuizes(scanner);

        //calculoImpostDeRenda
        calculoImpostoDeRenda(scanner);

        // calcularSalario
        calcularSalario(scanner);

        //conversaoCambial
        conversaoCambial(scanner);

        // algoritimo ler 3 números.
        lerTresNumeros(scanner);
    }

    public static void ordemCrescente(Scanner scanner){
        List<Integer> listaNumeros = new ArrayList<>();
        int numero = 0;
        while (true){
            String addNumero;
            do {
                System.out.print("Quer adicionar um número?(sim/não):");
                addNumero = scanner.nextLine().trim();
            }while (!addNumero.equalsIgnoreCase("sim") && !addNumero.equalsIgnoreCase("não"));
            if (addNumero.equalsIgnoreCase("sim")){
                System.out.print("Digite um número:");
                numero = scanner.nextInt();
                listaNumeros.add(numero);
                scanner.nextLine();
            }else {
                Collections.sort(listaNumeros);
                System.out.println("Lista na ordem crescente:"+listaNumeros);
                break;
            }
        }

    }

    public static void lerMaiornumero(Scanner scanner){
        int maiorNumero = Integer.MIN_VALUE;
        int numero = 0;
        while (true){
            String addNumero;
            do {
                System.out.print("Quer adicionar um número?(sim/não):");
                addNumero = scanner.nextLine().trim();
            }while (!addNumero.equalsIgnoreCase("sim") && !addNumero.equalsIgnoreCase("não"));
            if (addNumero.equalsIgnoreCase("sim")){
                System.out.print("Digite um número:");
                numero = scanner.nextInt();
                scanner.nextLine();
            }else {
                System.out.println("Maior número:"+df.format(maiorNumero));
                break;
            }
            if (numero > maiorNumero){
                maiorNumero = numero;
            }

        }
    }


    public static void calcularNumeroEleitores(Scanner scanner){
        System.out.print("Número total de eleitores:");
        double totalEleitores = scanner.nextInt();
        System.out.print("Votos válidos:");
        double votosValidos = scanner.nextInt();
        System.out.print("Votos nulos:");
        double votosNulos = scanner.nextInt();
        System.out.print("Votos em branco:");
        double votosBrancos = scanner.nextInt();
       if ((votosBrancos+votosNulos+votosValidos) > totalEleitores){
           System.out.println("ERRO. Soma dos votos branco, nulos e válidos não pode ser maior que número total de eleitores.");
           return;
       }
        System.out.println("Resultado das eleições:");
        double percentualVotosValidos = (votosValidos / totalEleitores) * 100;
        System.out.println("Total de votos válidos:"+df.format(percentualVotosValidos)+"%");
        double percentualVotosNulos = (votosNulos / totalEleitores) * 100;
        System.out.println("Total votos nulos:"+df.format(percentualVotosNulos)+"%");
        double percentualVotosBrancos = (votosBrancos / totalEleitores) * 100;
        System.out.println("Total votos em branco:"+df.format(percentualVotosBrancos)+"%");
        double totalNaoVotantes = totalEleitores -(votosBrancos+votosValidos+votosNulos);
        double percentualNaoVotante = (totalNaoVotantes / totalEleitores) * 100;
        System.out.println("Total não votante:"+df.format(percentualNaoVotante)+"%");

    }


    public static void trocaValores(Scanner scanner){
        int a = 10;
        int b = 20;

        int ab = a;
        a = b;
        b = ab;

        System.out.println("A:"+a);
        System.out.println("B:"+b);
    }

    public static void calculoIMC(Scanner scanner){
        System.out.print("Altura:");
        double altura = scanner.nextDouble();
        System.out.print("Peso:");
        double peso = scanner.nextDouble();
        double imc = peso / (altura *2);
        System.out.println("IMC:"+df.format(imc));
    }

    public static void calculandoNotasJuizes(Scanner scanner){
        double maiorNota = Double.NEGATIVE_INFINITY;
        double menorNota = Double.POSITIVE_INFINITY;
        double[] notas = new double[6];
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(1+i)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (notas[i] < 0 || notas[i] > 10){
                        System.out.println("Nota inválida. Digite uma nota entre 0 e 10.");
                        continue;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite uma nota válida.");
                }
            }
        }
        double soma = 0;
        for (double nota : notas) {
            soma+=nota;
            if (nota > maiorNota){
                maiorNota = nota;
            }
            if (nota < menorNota){
                menorNota = nota;
            }
        }
        double media = (soma - (maiorNota+menorNota)) / (notas.length-2);
        System.out.println("Média nota:"+df.format(media));
    }


    public static void calculoImpostoDeRenda(Scanner scanner){
        System.out.print("Digite o seu salário:R$");
        double salario = scanner.nextDouble();
        if (salario <= 499.99){
            double impostoFaixa1 = salario * 0.05;
            System.out.println("Imposto:R$"+df.format(impostoFaixa1));
        } else if (salario <= 999.99) {
            double impostoFaixa2 = salario * 0.10;
            System.out.println("Imposto:R$"+df.format(impostoFaixa2));
        } else if (salario <= 1499.99) {
            double impostoFaixa3 = salario * 0.15;
            System.out.println("Imposto:R$"+df.format(impostoFaixa3));
        } else if (salario <= 1999.99) {
            double impostoFaixa4 = salario * 0.20;
            System.out.println("Imposto:R$"+df.format(impostoFaixa4));
        }else {
            double impostoFaixa5 = salario * 0.25;
            System.out.println("Imposto:R$"+df.format(impostoFaixa5));
        }
    }


    public static void calcularSalario(Scanner scanner){
        System.out.print("Valor da hora:R$");
        double valorHora = scanner.nextDouble();
        System.out.print("Quantidades de horas trabalhada:");
        int horas = scanner.nextInt();

        if (horas < 220){
            double salario = valorHora * horas;
            System.out.println("Salário:R$"+df.format(salario));
            return;
        }
        double salarioMais220h = (((horas - 220) * ((valorHora *.5) + valorHora)) + 220*valorHora);
        System.out.println("Salário:R$"+df.format(salarioMais220h));
    }


    public static void conversaoCambial(Scanner scanner){
        double taxaDollar = 2.40;
        System.out.print("Digite o valor em reais:R$");
        double reais = scanner.nextDouble();
        double conversaoDolar = reais / taxaDollar;
        System.out.println("R$"+reais+" convertido para dolar a taxa de R$"+taxaDollar+" fica:R$"+df.format(conversaoDolar));
    }


    public static void lerTresNumeros(Scanner scanner){
        int maiorNumero = Integer.MIN_VALUE;
        int numero = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o "+(i+1)+"ª número:");
            numero = scanner.nextInt();

        }
        if (numero > maiorNumero){
            maiorNumero = numero;
        }

        System.out.println("Maior número:"+maiorNumero);
    }
}
