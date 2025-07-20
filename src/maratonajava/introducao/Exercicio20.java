package academy.devdojo.maratonajava.introducao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercicio20 {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //exercicio10
        listarOrdemCrescente(scanner);

        //exercicio 9
        maiorNumeroLista(scanner);

        //exercicio 8
        calculandoVotos(scanner);

        //exercicio 7
        trocandoValores();

        // exercicio 6
        calculoIMC(scanner);

        // exericicio 5
        validarNotasJuizes(scanner);

        //exercicio 4
        calcularImposto(scanner);

        //exercicio 3
        calculandoSalario(scanner);

        //exericio 2
        conversaoCambial(scanner);

        // exericio 1
        ler3Numeros(scanner);

    }

    public static void listarOrdemCrescente(Scanner scanner){
        List<Integer> listaNumeros = new ArrayList<>();
        while (true){
            try {
                String addNumero = "";
                do {
                    System.out.print("Quer adicionar um número?(sim|não):");
                    addNumero = scanner.nextLine().trim();
                }while (!addNumero.equalsIgnoreCase("sim") && !addNumero.equalsIgnoreCase("não"));
                if (addNumero.equalsIgnoreCase("não")){
                    Collections.sort(listaNumeros);
                    System.out.println("Lista em ordem crescente:"+listaNumeros);
                    break;
                }
                System.out.print("Digite um número:");
                int numero = Integer.parseInt(scanner.nextLine().trim());
                listaNumeros.add(numero);
                continue;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static void maiorNumeroLista(Scanner scanner){
        List<Integer> listaNumeros = new ArrayList<>();
        int maiorNumero = Integer.MIN_VALUE;
        while (true){
            try {
                String addNumero = "";
                do {
                    System.out.print("Quer adicionar um número?(sim|não):");
                    addNumero = scanner.nextLine().trim();
                }while (!addNumero.equalsIgnoreCase("sim") && !addNumero.equalsIgnoreCase("não"));
                if (addNumero.equalsIgnoreCase("não")){
                    for (Integer numeros : listaNumeros) {
                        if (numeros > maiorNumero){
                            maiorNumero = numeros;
                        }
                    }
                    System.out.println("Maior número da lista:"+maiorNumero);
                    break;
                }
                System.out.print("Digite um número:");
                int numero = Integer.parseInt(scanner.nextLine().trim());
                listaNumeros.add(numero);
                continue;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static void calculandoVotos(Scanner scanner){
        while (true){
            try {
                System.out.print("Total de eleitores:");
                int totalEleitores = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Votos válidos:");
                int votosValidos = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Votos em branco:");
                int votosBranco = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Votos nulos:");
                int votosNulos = Integer.parseInt(scanner.nextLine().trim());

                if ((votosNulos+votosBranco+votosValidos) > totalEleitores){
                    System.out.println("ERRO. A soma de votos válidos, nulos e branco não pode ser maior que Totais de eleitores.");
                    return;
                }
                double percentualVotosValidos = ((double) votosValidos / totalEleitores) * 100;
                System.out.println("Total de votos válidos:"+df.format(percentualVotosValidos)+"%");

                double percentualVotosNulos = ((double) votosNulos / totalEleitores) * 100;
                System.out.println("Total de votos válidos:"+df.format(percentualVotosNulos)+"%");

                double percentualVotosBranco = ((double) votosBranco / totalEleitores) * 100;
                System.out.println("Total de votos válidos:"+df.format(percentualVotosBranco)+"%");

                double percentualNaoVotantes = ((double) (totalEleitores - (votosNulos+votosBranco+votosValidos)) / totalEleitores) * 100;
                System.out.println("Pessoas que não votaram:"+df.format(percentualNaoVotantes)+"%");
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }


    public static void trocandoValores(){
        int a = 10;
        int b = 20;
        int ab = a;
        a = b;
        b = ab;
        System.out.println("A:"+a);
        System.out.println("B:"+b);
    }

    public static void calculoIMC(Scanner scanner){
        while (true){
            try {
                System.out.print("Peso:");
                double peso = Double.parseDouble(scanner.nextLine().trim());
                if (peso < 0 || peso > 230){
                    System.out.println("Peso inválido.");
                    return;
                }
                try {
                    System.out.print("Altura:");
                    double altura = Double.parseDouble(scanner.nextLine().trim());
                    if (altura < 0 || altura > 2.30){
                        System.out.println("Altura inválida.");
                        return;
                    }
                    double calculoIMC = peso / (altura * altura);
                    System.out.println("IMC:"+df.format(calculoIMC));
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }




    public static void validarNotasJuizes(Scanner scanner){
        double[] notas = new double[6];
        double menorNota = Double.POSITIVE_INFINITY;
        double maiorNota = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(i+1)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine().trim());
                    if ( notas[i] < 0 || notas[i] > 10){
                        System.out.println("Nota inválida.");
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
            soma += nota;
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

    public static void calcularImposto(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine().trim());
                if ( salario < 0){
                    System.out.println("Salário inválido.");
                    return;
                }
                if (salario <= 499.99){
                    double impostoFaixa1 = salario * 0.05;
                    System.out.println("Imposto sobre salário:R$"+df.format(impostoFaixa1));
                } else if (salario <= 999.99) {
                    double impostoFaixa2 = salario * 0.10;
                    System.out.println("Imposto sobre salário:R$"+df.format(impostoFaixa2));
                } else if (salario <= 1499.99) {
                    double impostoFaixa3 = salario * 0.15;
                    System.out.println("Imposto sobre salário:R$"+df.format(impostoFaixa3));
                } else if (salario <= 1999.99) {
                    double impostoFaixa4 = salario * 0.20;
                    System.out.println("Imposto sobre salário:R$"+df.format(impostoFaixa4));
                }else {
                    double impostoFaixa5 = salario * 0.25;
                    System.out.println("Imposto sobre salário:R$"+df.format(impostoFaixa5));
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void calculandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor hora:R$");
                double valorHora = Double.parseDouble(scanner.nextLine().trim());
                if (valorHora < 0){
                    System.out.println("Valor inválido.");
                    return;
                }
                try {
                    System.out.print("Digite quantidade de horas trabalhadas:");
                    int horas = Integer.parseInt(scanner.nextLine().trim());
                    if (horas < 0){
                        System.out.println("Horas inválidas.");
                        return;
                    }
                    if (horas <= 220){
                        double salario = valorHora * horas;
                        System.out.println("Salário:R$"+df.format(salario));
                    }else {
                        double horasExtras = (horas - 220) * ((valorHora * 0.5) + valorHora);
                        double salarioComHorasExtra = ((220 * valorHora) + horasExtras);
                        System.out.println("Salário:R$"+df.format(salarioComHorasExtra));
                    }
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digie um valor válido.");
            }
        }
    }

    public static void  conversaoCambial(Scanner scanner){
        double taxaCambio = 2.40;
        while (true){
            try {
                System.out.print("Digite valor a ser convertido em dolar:R$");
                int reais = Integer.parseInt(scanner.nextLine().trim());
                if (reais < 0){
                    System.out.println("Valor inválido.");
                    return;
                }
                double conversaoDolar = reais / taxaCambio;
                System.out.println("R$"+reais+" convertido para dolar:R$"+df.format(conversaoDolar));

            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void ler3Numeros(Scanner scanner){
        int numero = 0;
        int maiorNumero = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            while (true){
                try {
                    System.out.print("Digite o "+(i+1)+"ª número:");
                    numero = Integer.parseInt(scanner.nextLine().trim());
                    if (numero > maiorNumero){
                        maiorNumero = numero;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um número válido.");
                }
            }
        }
        System.out.println("O maior número foi:"+maiorNumero);
    }

}
