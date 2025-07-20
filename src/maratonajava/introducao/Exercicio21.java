package academy.devdojo.maratonajava.introducao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercicio21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //exercicio 10
        listaNumeroCrescente(scanner);

        // exercicio 9
        verificandoMaiorDaLista(scanner);

        //exercicio 8
        calculandoVotos(scanner);

        //exercicio 7
        invertendoValores(scanner);

        //exercico 6
        calcularIMC(scanner);

        //exercicio 5
        calculandoNotasJuizes(scanner);

        //exercico 4
        calculandoImpostoSalario(scanner);

        //exercicio 3
        calculandoSalario(scanner);

        // exercicio 2
        conversaoCambial(scanner);

        // exercicio 1
        ler3Numeros(scanner);


    }
    public static void listaNumeroCrescente(Scanner scanner){
        List<Integer> listaNumeros = new ArrayList<>();
        while (true){
            try {
                String addNumero;
                do {
                    System.out.print("Quer adicionar um número ?(sim|não):");
                    addNumero = scanner.nextLine().trim();
                }while (!addNumero.equalsIgnoreCase("sim") && !addNumero.equalsIgnoreCase("não"));
                if (addNumero.equalsIgnoreCase("sim")){
                    System.out.print("Digite um número positivo:");
                    int numero = Integer.parseInt(scanner.nextLine().trim());
                    if (numero < 0){
                        System.out.println("Número inválido.");
                        continue;
                    }
                    listaNumeros.add(numero);
                }else {
                    Collections.sort(listaNumeros);
                    System.out.println("Lista ordem crescente:"+listaNumeros);
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }

        }
    }


    public static void verificandoMaiorDaLista(Scanner scanner){
        List<Integer> listaNumeros = new ArrayList<>();
        int maiorNumero = Integer.MIN_VALUE;
        while (true){
            try {
                String addNumero;
                do {
                    System.out.print("Quer adicionar um número ?(sim|não):");
                    addNumero = scanner.nextLine().trim();
                }while (!addNumero.equalsIgnoreCase("sim") && !addNumero.equalsIgnoreCase("não"));
                if (addNumero.equalsIgnoreCase("sim")){
                    System.out.print("Digite um número positivo:");
                    int numero = Integer.parseInt(scanner.nextLine().trim());
                    if (numero < 0){
                        System.out.println("Número inválido.");
                        continue;
                    }
                    listaNumeros.add(numero);
                }else {
                    for (Integer numeros : listaNumeros) {
                        if (numeros > maiorNumero){
                            maiorNumero = numeros;
                        }
                    }
                    System.out.println("Maior número da lista:"+maiorNumero);
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }

        }
    }

    public static void calculandoVotos(Scanner scanner){
        while (true){
            try {
                System.out.print("Total de eleitores da cidade:");
                int totalEleitores = Integer.parseInt(scanner.nextLine().trim());
                if (totalEleitores < 0){
                    System.out.println("Valor inválido.");
                    return;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void invertendoValores(Scanner scanner){
        int a = 10;
        int b = 20;
        int ab = a;
        a = b;
        b = ab;

        System.out.println("A:"+a);
        System.out.println("B:"+b);

    }


    public static void calcularIMC(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a altura:");
                double altura = Double.parseDouble(scanner.nextLine().trim());
                if (altura < 0 || altura > 2.30){
                    System.out.println("Valor inválido. Tente novamente.");
                    continue;
                }
                System.out.print("Digite o peso:");
                double peso = Double.parseDouble(scanner.nextLine().trim());
                if (peso < 0 || peso > 230){
                    System.out.println("Valor inválido. Tente novamente.");
                    continue;
                }
                double calculoIMC = peso / (altura*altura);
                System.out.println("IMC:"+df.format(calculoIMC));
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }


    public static void calculandoNotasJuizes(Scanner scanner){
        double[] notas = new double[6];
        double maiorNota = Double.NEGATIVE_INFINITY;
        double menorNota = Double.POSITIVE_INFINITY;
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(i+1)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine().trim());
                    if (notas[i] < 0 || notas[i] > 10){
                        System.out.println("Nota não pode ser menor que 0 ou maior que 10.");
                        return;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite uma nota válida.");
                }
            }
        }
        double soma = 0;
        for (double nota : notas) {
            soma+= nota;
            if (nota > maiorNota){
                maiorNota = nota;
            }
            if (nota < menorNota){
                menorNota = nota;
            }
        }
        double media = (soma - (maiorNota+menorNota)) / (notas.length - 2);
        System.out.println("Média final:"+df.format(media));
    }


    public static void calculandoImpostoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o salário:R$");
                double salario = Double.parseDouble(scanner.nextLine().trim());
                if (salario < 0){
                    System.out.println("Salário inválido.");
                    return;
                }
                if (salario <= 499.99){
                    double impostoFaixa1 = salario * 0.05;
                    System.out.println("Salário:"+df.format(impostoFaixa1));
                } else if (salario <= 999.99) {
                    double impostoFaixa2 = salario * 0.10;
                    System.out.print("Salário:R$"+df.format(impostoFaixa2));
                } else if (salario <= 1499.99) {
                    double impostoFaixa3 = salario * 0.15;
                    System.out.println("Salário:R$"+df.format(impostoFaixa3));
                } else if (salario <= 1999.99) {
                    double impostoFaixa4 = salario * 0.20;
                    System.out.println("Salário:R$"+df.format(impostoFaixa4));
                }else {
                    double impostoFaixa5 = salario * 0.25;
                    System.out.println("Salário:R$"+df.format(impostoFaixa5));
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void calculandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor da hora:R$");
                double valorHora = Double.parseDouble(scanner.nextLine().trim());
                if (valorHora < 0){
                    System.out.println("Valor inválido.");
                    return;
                }
                System.out.print("Horas trabalhadas:");
                double horas = Double.parseDouble(scanner.nextLine().trim());
                if (horas < 0 ){
                    System.out.println("Valor inválido.");
                    return;
                }
                if (horas <= 220){
                    double calculoSalario = horas * valorHora;
                    System.out.println("Salário:R$"+df.format(calculoSalario));
                }else {
                    double calculoHoraExtra = (horas - 220) * ((valorHora * 0.5) + valorHora);
                    double salarioHoraExtra = (220 * valorHora) + calculoHoraExtra;
                    System.out.println("Salário:R$"+df.format(salarioHoraExtra));
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }


    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void conversaoCambial(Scanner scanner){
        while (true){
            double taxaDolar = 2.40;
            try {
                System.out.print("Digite valor em reais a ser convertido:R$");
                double reais = Double.parseDouble(scanner.nextLine().trim());
                if (reais < 0 ){
                    System.out.println("Valor inválido.");
                    return;
                }
                double conversaoDolar = reais / taxaDolar;
                System.out.println("R$"+reais+" convertido para dolar U$:"+df.format(conversaoDolar));
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void ler3Numeros(Scanner scanner){
        int maiorNumero = Integer.MIN_VALUE;
        int numero = 0;
        for (int i = 0; i < 3; i++) {
            while (true){
                try {
                    System.out.print("Digite o "+(i+1)+"ª número:");
                    numero = Integer.parseInt(scanner.nextLine().trim());
                    if (numero < 0) {
                        System.out.println("Número inválido.");
                        return;
                    }
                    if (numero > maiorNumero){
                        maiorNumero = numero;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um número válido.");
                }
            }
        }

        System.out.println("Maior número é:"+maiorNumero);
    }

}
