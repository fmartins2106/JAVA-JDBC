package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

public class Aula7ArraysExercicios5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //        analisando numeros maior e menor
        analisandoNumerosArrays(scanner);

        //calculando media
        calculandoMedia(scanner);


        //        analisando o seu nome
        analisandoNome(scanner);

//        analisando vogais das palavras
        vogaisPalavras();

//        analisando numeros maior e menor
        analisandoNumerosArrays(scanner);

//calculando media
        calculandoMedia(scanner);

// analisando frase
        analisandoFraseLetraA(scanner);


//        tabuada
        tabuada(scanner);

//        caixa eletronico
        caixaEletronico(scanner);
        scanner.close();
    }

    public static void vogaisPalavras(){
        String[] arrayPalavras = {"maria","pedro","jonas","ana","fernando"};
        for(String palavras : arrayPalavras){
            System.out.print("\nNa palavra "+palavras+" temos:");
            for (char vogais : palavras.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(vogais))!=-1){
                    System.out.print(vogais+" ");
                }
            }
        }
    }
    public static void analisandoNumerosArrays(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        float soma = 0, contNumeros = 0;
        int posMaior = 0, posMenor=0;
        for (int i=0;i<arrayNumeros.length;i++){
            while (true){
                System.out.print("Digite a "+(i+1)+"º nota");
                if (scanner.hasNextInt()){
                    arrayNumeros[i] = scanner.nextInt();
                    soma+=arrayNumeros[i];
                    contNumeros++;
                    break;
                }else {
                    System.out.println("Digite um número válido!!!");
                    scanner.next();
                }
            }
            if (arrayNumeros[i]>maiorNumero){
                maiorNumero=arrayNumeros[i];
                posMaior=i;

            }
            if (arrayNumeros[i]<menorNumero){
                menorNumero=arrayNumeros[i];
                posMenor=i;
            }

        }
        float media = soma/contNumeros;
        System.out.println("O maior número:"+maiorNumero+"| está na posição:"+posMaior);
        System.out.println("O menor número:"+menorNumero+"| está na posição:"+posMenor);
        System.out.println("A média:"+media);
    }

    public static void calculandoMedia(Scanner scanner){
        while (true){
            float soma = 0;
            int contNumero = 0;
            while (true){
                System.out.print("Digite uma nota:");
                if (scanner.hasNextFloat()){
                    float nota = scanner.nextFloat();
                    if (nota>=1 && nota<=10){
                        soma+=nota;
                        contNumero++;
                    }else {
                        System.out.println("Digite um valor válido!");
                        continue;
                    }
                }else {
                    System.out.println("ERRO!Digite um valor válido!!!");
                    scanner.nextLine();
                    continue;
                }
                scanner.nextLine();
                System.out.print("Quer adicionar outra nota?(sim/não):");
                String adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                while(!adicionarOutroNumero.equals("não") && !adicionarOutroNumero.equals("sim")){
                    System.out.print("Digite apenas sim ou não:");
                    adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                }
                if (adicionarOutroNumero.equals("não")){
                    break;
                }
            }
            if (contNumero>0){
                float media =  soma/contNumero;
                System.out.println("A média:"+media);
            }else {
                System.out.println("Não foram adicionados números!");
            }
            System.out.print("Deseja calcular outra média?(sim/não):");
            String calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            while (!calcularOutraMedia.equals("não") && !calcularOutraMedia.equals("sim")){
                System.out.print("Digite apenas sim ou não:");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }
            if (calcularOutraMedia.equals("não")){
                System.out.println(">>>Finalizando....");
                break;
            }
        }


    }
    public static void analisandoFraseLetraA(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim();
        for (int f=0;f<frase.length();f++){
            if (frase.charAt(f)=='a'){
                contagem++;
            }
        }
        System.out.println("Na frase:"+frase+" a letra A apareceu:"+contagem+"x");
        int primeiroA = frase.indexOf("a");
        if (primeiroA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
        }else {
            System.out.println("A letra A não apareceu na frase.");
        }
        int ultimoA = frase.lastIndexOf("a");
        if (ultimoA>0){
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
        }
    }

    public static void analisandoNome(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nome = scanner.nextLine().trim();
        String[] avaliandoNome = nome.split(" ");
        System.out.println("Seu primeiro nome:"+avaliandoNome[0]);
        System.out.println("Seu segundo nome:"+avaliandoNome[avaliandoNome.length-1]);
        System.out.println("Seu nome completo, letras minusculas:"+nome.toLowerCase());
        System.out.println("Seu nome completo, letras maiusculas:"+nome.toUpperCase());
        System.out.println("Seu primeiro nome tem:"+avaliandoNome[0].length()+" letras");
        System.out.println("Seu segundo nome tem:"+avaliandoNome[avaliandoNome.length-1].length()+" letras");
        System.out.println("Seu nome completo tem:"+nome.replace(" ","").length()+" letras");
    }

    public static void tabuada(Scanner scanner){
        while (true){
            int tabuada = 0;
            while (true){
                System.out.print("Digite um número(999 para parar):");
                if (scanner.hasNextInt()){
                    tabuada = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERR0! Digite um valor verdadeiro!");
                    scanner.next();
                }
            }
            if (tabuada==999){
                System.out.println(">>>FINALIZANDO....");
                break;
            }else {
                for (int i=0;i<=10;i++){
                    System.out.printf("%d %d = %d%n",tabuada,i,tabuada*i);
                }
            }
        }
    }


    public static void caixaEletronico(Scanner scanner){
        System.out.print("Quanto quer sacar?:R$");
        int saque  = scanner.nextInt();
        int valor = saque;
        int totalced = 0;
        int ced = 50;
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
}
