package academy.devdojo.maratonajava.introducao;

import java.awt.font.FontRenderContext;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Aula7ArraysExercicios2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        maior e menor do array;
        maiorMenordoArray(scanner);


//        sorteando a sequencia de apresentação
        sequenciaApresentacao(scanner);

//        sorteando uma pessoa
        sorteandoUmPessoa(scanner,random);

//        calculo tabuada
        calculandoTabuada(scanner);

//        caixa eletronico
        caixaEletronico(scanner);

//        soma, media, maior e menor de um array
        calculandoArray(scanner);

//        verificando o maior e o menor do arrays
        arraysMaiorEmenor(scanner);

//        separando vogais
        seprandoVogais();

//        analisando as letras a
        fraseComLetraA(scanner);

//        analisando o seu nome
        analisandoNome(scanner);
    }

    public static void maiorMenordoArray(Scanner scanner){
        int maiorArray = Integer.MIN_VALUE, menorArray = Integer.MAX_VALUE;
        int posMaior = 0, posMenor = 0;
        int[] listaNumeros = new int[6];
        for (int n=0;n<listaNumeros.length;n++){
            System.out.print("Digite o "+(n+1)+"º número:");
            listaNumeros[n] = scanner.nextInt();
            if (listaNumeros[n]>maiorArray){
                maiorArray=listaNumeros[n];
                posMaior=n;
            }
            if (listaNumeros[n]<menorArray){
                menorArray=listaNumeros[n];
                posMenor=n;
            }
        }
        System.out.println("O maior número foi: "+maiorArray+" e está na posição:"+posMaior);
        System.out.println("O menor número foi "+menorArray+" e está na posição:"+posMenor);

    }

    public static void sequenciaApresentacao(Scanner scanner){
        System.out.println("Vamos sortear a sequência de apresentação");
        ArrayList<String> listaNomesApresentacao = new ArrayList<>();
        while (true){
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            listaNomesApresentacao.add(nome);
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            Collections.shuffle(listaNomesApresentacao);
            if (continuar.equals("n")){
                System.out.println("A sequência de apresentação:"+listaNomesApresentacao);
                break;
            }
        }
    }


    public static void sorteandoUmPessoa(Scanner scanner, Random random){
        System.out.println("Vamos sortear uma pessoa");
        ArrayList<String> listaPessoas = new ArrayList<>();
        while (true){
            System.out.print("Nome:");
            String nomePessoa = scanner.nextLine();
            System.out.print("Quer adicionar outra pessoa?[S/N]:");
            String adicionar = scanner.nextLine().trim().toLowerCase();
            while (!adicionar.equals("n") && !adicionar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                adicionar = scanner.nextLine().trim().toLowerCase();
            }
            listaPessoas.add(nomePessoa);
            if (adicionar.equals("n")){
                int sorteio = random.nextInt(listaPessoas.size());
                String nomeSorteado = listaPessoas.get(sorteio);
                System.out.println("A pessoa escolhida foi:"+nomeSorteado);
                break;
            }
        }
    }

    public static void calculandoTabuada(Scanner scanner){
        while (true){
            int tabuada = -1;
            while (true){
                System.out.print("Digite um número(-1 ou menor para parar):");
                if (scanner.hasNextInt()){
                    tabuada = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            if (tabuada<=-1){
                System.out.println(">>>>>FINALIZANDO O PROGRAMA....");
                break;
            }else {
                for (int i=0;i<=10;i++){
                    System.out.printf("%d x %d = %d%n",tabuada,i,tabuada*i);
                }
            }

        }
    }

    public static void caixaEletronico(Scanner scanner){
        System.out.print("Digite quanto quer sacar:R$");
        int saque = scanner.nextInt();
        int valor = saque;
        int ced = 50;
        int totalced = 0;
        while (true){
            if (valor>=ced){
                valor-=ced;
                totalced++;
            }else {
                if (totalced>0){
                    System.out.printf("Total de %d cédulas de R$%d%n",totalced,ced);
                }
                if (ced==50){
                    ced=20;
                } else if (ced==20) {
                    ced=10;
                } else if (ced==10) {
                    ced=5;
                } else if (ced==5) {
                    ced=1;
                }
                totalced=0;
                if (valor<=0){
                    break;
                }
            }
        }
    }

    public static void calculandoArray(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int soma = 0, maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        for (int n=0;n<arrayNumeros.length;n++){
            System.out.print("Digite o "+(n+1)+"º número da lista:");
            arrayNumeros[n] = scanner.nextInt();
            if (arrayNumeros[n]>0){
                soma+=arrayNumeros[n];
            }
            if (arrayNumeros[n]>maiorNumero){
                maiorNumero=arrayNumeros[n];
            }
            if (arrayNumeros[n]<menorNumero){
                menorNumero=arrayNumeros[n];
            }

        }
        float media =(float) soma/ Arrays.stream(arrayNumeros).count();
        System.out.println("O maior da lista:"+maiorNumero);
        System.out.println("O menor da lista:"+menorNumero);
        System.out.println("A média:"+media);
        System.out.println("A soma:"+soma);
    }


    public static void arraysMaiorEmenor(Scanner scanner){
        int maiorArray = Integer.MIN_VALUE, menorArray = Integer.MAX_VALUE;
        int posMaior = 0, posMenor = 0;
        int[] arrayNumeros = new int[6];
        for (int n=0;n<arrayNumeros.length;n++){
            System.out.print("Digite o "+(n+1)+"º número:");
            arrayNumeros[n] = scanner.nextInt();
            if (arrayNumeros[n]>maiorArray){
                maiorArray=arrayNumeros[n];
                posMaior=n;
            }
            if (arrayNumeros[n]< menorArray){
                menorArray = arrayNumeros[n];
                posMenor=n;
            }
        }
        System.out.println("O maior da lista foi:"+maiorArray+" e está na posição:"+posMaior);
        System.out.println("O menor da lista foi:"+menorArray+" e está na posição:"+posMenor);

    }

    public static void seprandoVogais(){
        String[] arrayFrutas = {"abacaxi","laranja","uva","tangerina","cacau","banana","framboesa"};
        for (String fruta : arrayFrutas){
            System.out.print("\nNa palavra"+fruta+" temos as vogais:");
            for (char letras : fruta.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(letras))!=-1){
                    System.out.print(letras+" ");
                }
            }
        }
    }

    public static void fraseComLetraA(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim();
        for (int i=0;i<frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu:"+contagem+"x");
        int primeiroA = frase.indexOf("a");
        if (primeiroA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
        }else {
            System.out.println("A letra A não apareceu nesta frase!");
        }
        int ultimoA = frase.lastIndexOf("a");
        if (ultimoA>0){
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu nesta frase!");
        }
    }


    public static void analisandoNome(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine().trim();
        String[] arrayNome = nomeCompleto.split(" ");
        System.out.println("Seu primeiro nome é:"+arrayNome[0]);
        System.out.println("seu último nome:"+ arrayNome[arrayNome.length-1]);
        System.out.println("Seu nome em letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("Seu nome em letras maiusculas:"+nomeCompleto.toUpperCase());
        System.out.println("Seu primeiro nome tem:"+arrayNome[0].length()+" letras");
        System.out.println("seu último nome tem:"+arrayNome[arrayNome.length-1].length()+" letras");
    }


}
