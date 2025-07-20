package academy.devdojo.maratonajava.introducao;

import java.text.DecimalFormat;
import java.util.*;

public class Exercicio19 {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //exercicio10
        listaOrdemCrescente(scanner);

        //exercicio 9
        maiorNumeroDaLista(scanner);

        //exercicio 8
        calcularVotosCidade(scanner);

        //exercicio7
        trocaValores(scanner);

        // exercicio6
        calcularIMC(scanner);

        //exercicio5
        calculandoNotasJuizes(scanner);

        //exercicio4
        calcularImpostoSalario(scanner);

        //exercicio3
        calcularSalario(scanner);

        //exercicio2
        conversaoCambial(scanner);

        //exercicio 1
        lerMaior3Numeros(scanner);


    }

    public static void listaOrdemCrescente(Scanner scanner){
        List<Double> lista = new ArrayList<>();
        while (true){
            String addNumero;
            do {
                System.out.print("Quer adicionar um número?(sim|não):");
                addNumero = scanner.nextLine().trim();
            }while (!addNumero.equalsIgnoreCase("sim") && !addNumero.equalsIgnoreCase("não"));
            if (addNumero.equalsIgnoreCase("não")){
                Collections.sort(lista);
                System.out.println("Lista na ordem crescente:"+lista);
                break;
            }
            try {
                System.out.print("Digite um número:");
                double numero = Integer.parseInt(scanner.nextLine().trim());
                lista.add(numero);
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void maiorNumeroDaLista(Scanner scanner){
        List<Double> listaNumeros = new ArrayList<>();
        double maiorNumero = Double.NEGATIVE_INFINITY;
        while (true){
            String addNumero;
            do {
                System.out.print("Quer adicionar um número?(sim|não):");
                addNumero = scanner.nextLine().trim();
            }while (!addNumero.equalsIgnoreCase("sim") && !addNumero.equalsIgnoreCase("não"));
            if (addNumero.equalsIgnoreCase("não")){
                for (Double numero : listaNumeros) {
                    if (numero > maiorNumero){
                        maiorNumero = numero;
                    }
                }
                System.out.println("O maior número digitado foi:"+maiorNumero);
                break;
            }
            try {
                System.out.print("Digite um número:");
                double numero = Integer.parseInt(scanner.nextLine().trim());
                listaNumeros.add(numero);
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void calcularVotosCidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Votos totais:");
                int votosTotais = Integer.parseInt(scanner.nextLine().trim());
                System.out.print("Votos válidos:");
                int votosValidos = Integer.parseInt(scanner.nextLine().trim());
                System.out.print("Votos nulo:");
                int votosNulos = Integer.parseInt(scanner.nextLine().trim());
                System.out.print("Votos em branco:");
                int votosBrancos = Integer.parseInt(scanner.nextLine().trim());
                if ((votosBrancos+votosNulos+votosValidos) > votosTotais){
                    System.out.println("Operação negada. Votos totais não pode ser menor que soma de votos válidos, nulos e branco.");
                    continue;
                }
                double percentualVotosValidos = ((double) votosValidos / votosTotais) * 100;
                System.out.println("Votos válidos:"+df.format(percentualVotosValidos)+"%");

                double percentualVotosNulos = ((double) votosNulos / votosTotais) * 100;
                System.out.println("Votos nulos:"+df.format(percentualVotosNulos)+"%");

                double percentualVotosBrancos = ((double) votosBrancos / votosTotais) * 100 ;
                System.out.println("Votos brancos:"+df.format(percentualVotosBrancos)+"%");
                double eleitoresNaoVotantes =  ((double)(votosTotais - (votosBrancos+votosValidos+votosNulos)) / votosTotais) * 100;
                System.out.println("Não votantes:"+df.format(eleitoresNaoVotantes)+"%");
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida. Iniciando programa.");
            }
        }
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

    public static void calcularIMC(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite a altura:");
                double altura = Double.parseDouble(scanner.nextLine().trim());
                if (altura < 0 || altura > 2.50){
                    System.out.println("Altura inválida.");
                    return;
                }
                try {
                    System.out.print("Digite o peso:");
                    double peso = Double.parseDouble(scanner.nextLine().trim());
                    if (peso < 0 || peso > 230){
                        System.out.println("Peso inválido.");
                        return;
                    }
                    double imc = peso / (altura * altura);
                    System.out.println("IMC:"+df.format(imc));
                }catch (NumberFormatException e){
                    System.out.println("Digite um peso válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma altura válida.");
            }
        }
    }

    public static void calculandoNotasJuizes(Scanner scanner){
        double[] notasJuizes = new double[6];
        double maiorNota = Double.NEGATIVE_INFINITY;
        double menorNota = Double.POSITIVE_INFINITY;
        for (int i = 0; i < notasJuizes.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(1+i)+"ª nota:");
                    notasJuizes[i] = Double.parseDouble(scanner.nextLine().trim());
                    if (notasJuizes[i] < 0 || notasJuizes[i] > 10){
                        System.out.println("Nota inválida. Tente novamente.");
                        return;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite uma nota válida.");
                }
            }
        }
        double soma = 0;
        for (double notasJuize : notasJuizes) {
            soma += notasJuize;
            if (notasJuize > maiorNota){
                maiorNota = notasJuize;
            }
            if (notasJuize < menorNota){
                menorNota = notasJuize;
            }
        }
        double media = (soma - (maiorNota+menorNota)) / (notasJuizes.length - 2);
        System.out.println("Média das notas:"+df.format(media));
    }

    public static void calcularImpostoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine().trim());
                if (salario <= 499.99){
                    double impostoFaixa1 = salario * 0.5;
                    System.out.println("Imposto sobre salário:R$"+df.format(impostoFaixa1));
                } else if (salario <= 999.99) {
                    double impostoFaixa2 = salario * 0.10;
                    System.out.println("Imposto sobre salário:R$"+df.format(impostoFaixa2));
                }else if (salario <= 1499.99){
                    double impostoFaixa3 =  salario * 0.15;
                    System.out.println("Imposto sobre salário:R$"+df.format(impostoFaixa3));
                }else if (salario <= 1999.99){
                    double impostoFaixa4 = salario * 0.20;
                    System.out.println("Imposto sobre salário:R$"+df.format(impostoFaixa4));
                }else {
                    double impostoFaixa5 = salario * 0.25;
                    System.out.println("Imposto sobre salário:R$"+df.format(impostoFaixa5));
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para salário.");
            }
        }
    }

    public static void calcularSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor da hora:R$");
                double valorHora = Double.parseDouble(scanner.nextLine().trim());
                if (valorHora < 0 ){
                    System.out.println("Operação negada. Horas trabalhas não pode ser menor que zero.");
                    continue;
                }
                try {
                    System.out.print("Horas trabalhadas:");
                    int horasTrabalhadas = Integer.parseInt(scanner.nextLine().trim());
                    if (horasTrabalhadas < 0){
                        System.out.println("Operação negada. Valor hora não pode ser menor que zero.");
                        continue;
                    }
                    if (horasTrabalhadas <= 220){
                        double salarioBase = horasTrabalhadas * valorHora;
                        System.out.println("Salário:R$"+df.format(salarioBase));
                    }else {
                        double horaExtra = (horasTrabalhadas - 220) * ((valorHora * 0.5) + valorHora);
                        double salarioComHorasExtras = (220 * valorHora) + horaExtra;
                        System.out.println("Salário:R$"+df.format(salarioComHorasExtras));
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um número válido. Reiniciando o sistema.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite valores válidos.");
            }
        }
    }

    public static void conversaoCambial(Scanner scanner){
        double taxaCambio = 2.40;
        System.out.print("Digite o valor em reais para converter em dolar:R$");
        double reais = scanner.nextDouble();
        if (reais < 0){
            System.out.println("Valor inválido.");
            return;
        }
        double conversaoMoeda = reais / taxaCambio;
        System.out.println("R$" + df.format(reais) + " convertido para Dolar a taxa de R$" + df.format(taxaCambio)+ " é igual:R$"+df.format(conversaoMoeda));
    }


    public static void lerMaior3Numeros(Scanner scanner){
        scanner.nextLine();
        int maiorNumero = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            while (true){
                try {
                    System.out.print("Digite o "+(i+1)+"ª número:");
                    int numero = Integer.parseInt(scanner.nextLine().trim());
                    if (numero > maiorNumero){
                        maiorNumero = numero;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um número válido");
                }
            }
        }
        System.out.println("O maior número foi:"+maiorNumero);
    }

}
