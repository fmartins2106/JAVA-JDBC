package academy.devdojo.maratonajava.introducao;




import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Aula7ArraysExercicios4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Random random = new Random();


//        analisando tabela brasileirão;
        tabelaBrasileirao();


//        calculando par e impar e contando
        manipulandoParImpar(scanner);


//        calculando media das notas parte 2
        mediaNotasAlunos2(scanner);

//        calculando a media das notas
        mediaNotasAlunos(scanner);

//        caixa eletronico
        caixaEletronico(scanner);

//        media novamente
        mediaAlunos(scanner);

//        calculando mediaNotas
        mediaNotas(scanner);


//        calculando mediaNotas
        calculandoMediaNotas(scanner);



        //        soma, media, maior e menor
        verificaoNumerosArrays(scanner);

        //        analisando nomes
        analisandoNomes(scanner);

//analisando vogais
        analisandoVogais(scanner);

//        analisando frase
        analisandoFrase(scanner);
        scanner.close();
    }

    public static void mediaNotasAlunos2(Scanner scanner){
        while (true){
            float soma = 0;
            int contNumeros =0;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextFloat()){
                    float nota = scanner.nextFloat();
                    if (nota>=1 && nota<=10){
                        soma+=nota;
                        contNumeros++;
                    }else {
                        System.out.println("ERRO!Digite um valor válido");
                        continue;
                    }
                }else {
                    System.out.println("ERR0! DIGITE UM NÚMERO VÁLIDO!");
                    scanner.nextLine();
                    continue;
                }
                scanner.nextLine();
                System.out.print("Quer adicionar outra nota?(sim/não):");
                String adicionarOutraNota = scanner.nextLine().trim().toLowerCase();
                while (!adicionarOutraNota.equals("não") && !adicionarOutraNota.equals("sim")){
                    System.out.print("Digite apenas sim ou não:");
                    adicionarOutraNota = scanner.nextLine().trim().toLowerCase();
                }
                if (adicionarOutraNota.equals("não")) {
                    break;
                }
            }
            if (contNumeros>0){
                float media = soma/contNumeros;
                System.out.println("A média ficou:"+media);
            }else {
                System.out.println("Não foram cadastrados números.");
            }
            System.out.print("Deseja calcular outra média?(sim/não):");
            String calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            while (!calcularOutraMedia.equals("não") && !calcularOutraMedia.equals("sim")){
                System.out.print("Digite apenas sim ou não:");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }
            if (calcularOutraMedia.equals("não")) {
                System.out.println(">>>>Finalizando...");
                break;
            }
        }
    }




    public static void mediaNotasAlunos(Scanner scanner){
        while (true){
            float soma = 0;
            int contNumeros =0;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextFloat()){
                    float numeros = scanner.nextFloat();
                    if (numeros>=1 && numeros<=10){
                        soma+=numeros;
                        contNumeros++;
                    }else {
                        System.out.println("ERRO!Digite um número de 1 a 10!");
                        continue;
                    }
                }else {
                    System.out.println("Digite um número válido");
                    scanner.next();
                    break;
                }
                scanner.nextLine();
                System.out.print("Quer adicionar outra nota?(sim/não)");
                String outraNota = scanner.nextLine().trim().toLowerCase();
                while (!outraNota.equals("não") && !outraNota.equals("sim")){
                    System.out.print("Digite apenas sim ou não:");
                    outraNota = scanner.nextLine().trim().toLowerCase();
                }
                if (outraNota.equals("não")){
                    break;
                }
            }
            if (contNumeros>0){
                float media = soma/contNumeros;
                System.out.println("A média ficou:"+media);
            }else {
                System.out.println("Não foram adicionados números!");
            }
            System.out.print("Deseja calcular outra média ?(sim/não):");
            String outraMedia = scanner.nextLine().trim().toLowerCase();
            while (!outraMedia.equals("não") && !outraMedia.equals("sim")){
                System.out.print("Digite apenas sim ou não:");
                outraMedia = scanner.nextLine().trim().toLowerCase();
            }
            if (outraMedia.equals("não")){
                System.out.println("Finalizando...");
                break;
            }

        }
    }

    public static void caixaEletronico(Scanner scanner){
        System.out.print("Quanto quer sacar?R$");
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
                    System.out.printf("Total de %d cédulas de %d%n",totalced,ced);
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

    public static void mediaAlunos(Scanner scanner){
        while (true){
            float soma=0;
            int cont = 0;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextFloat()){
                    float numeros = scanner.nextFloat();
                    if (numeros>=1 && numeros<=10){
                        soma+=numeros;
                        cont++;
                    }else {
                        System.out.println("ERRO! Digite um valor válido");
                        continue;
                    }
                }else {
                    System.out.println("Digite um número inteiro!");
                    scanner.next();
                    continue;
                }
                scanner.nextLine();
                System.out.print("Quer adicionar outra nota?(sim/não):");
                String adicionarOutraNota = scanner.nextLine().trim().toLowerCase();
                while (!adicionarOutraNota.equals("não") && !adicionarOutraNota.equals("sim")){
                    System.out.print("Digite apenas sim ou não:");
                    adicionarOutraNota = scanner.nextLine().trim().toLowerCase();
                }
                if (adicionarOutraNota.equals("não")) {
                    break;
                }
            }
            if (cont>0){
                float media = soma/cont;
                System.out.println("A média das notas foi:"+String.format("%.2f",media));

            }else {
                System.out.println("Não foram adicionados números");
            }
            System.out.print("Deseja calcular outra média?(sim/não):");
            String calculoOutraMedia = scanner.nextLine().trim().toLowerCase();
            while (!calculoOutraMedia.equals("não") && !calculoOutraMedia.equals("sim")){
                System.out.print("Digite apenas S ou N:");
                calculoOutraMedia = scanner.nextLine().trim().toLowerCase();
            }
            if (calculoOutraMedia.equals("não")){
                System.out.println(">>Finalizando!");
                break;
            }
        }
    }









    public static void mediaNotas (Scanner scanner){
        while (true){
            float soma = 0;
            int contNumeros = 0;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextFloat()){
                    float numeros = scanner.nextFloat();
                    if (numeros >=1 && numeros <=10){
                        soma+=numeros;
                        contNumeros++;
                    }else {
                        System.out.println("ERRO! Digite um número válido");
                        continue;
                    }
                }else {
                    System.out.println("Digite um número válido");
                    scanner.next();
                    continue;
                }
                scanner.nextLine();
                System.out.print("Quer adicionar outra nota?:");
                String outraNota = scanner.nextLine().trim().toLowerCase();
                while (!outraNota.equals("n") && !outraNota.equals("sim")){
                    System.out.print("Digite apenas s ou n:");
                    outraNota = scanner.nextLine().trim().toLowerCase();
                }
                if (outraNota.equals("n")){
                    break;
                }
            }
            if (contNumeros>0){
                float media = soma/contNumeros;
                System.out.println("Sua média foi"+media);
            }else {
                System.out.println("Nenhuma nota foi adicionada!");
            }
            System.out.print("Deseja calcular outra média?(sim/não):");
            String adicionar = scanner.nextLine().trim().toLowerCase();
            while (!adicionar.equals("sim") && !adicionar.equals("não")){
                System.out.print("Digite apenas sim ou não:");
                adicionar = scanner.nextLine().trim().toLowerCase();
            }
            if (adicionar.equals("não")){
                break;
            }



        }
    }


    public static void manipulandoParImpar(Scanner scanner){
        int contPar = 0;
        int contImpar = 0;
        for (int n=0;n<5;n++){
            System.out.print("Digite um número:");
            if (scanner.hasNextInt()){
                int numeros = scanner.nextInt();
                if (numeros==0){
                    break;
                }
                if (numeros%2==0){
                    contPar++;
                }else {
                    contImpar++;
                }
            }else {
                System.out.println("Número inválido");
                scanner.next();
            }
        }
        System.out.println("Números pares:"+contPar);
        System.out.println("Números impares:"+contImpar);
    }

    public static void calculandoMediaNotas(Scanner scanner){
      while (true){
          double somaNota = 0;
          int numeroNotas =0;
          while (true){
              System.out.print("Digite um número de 1 a 10:");
              if (scanner.hasNextInt()){
                  double notas = scanner.nextDouble();
                  if (notas>=1 && notas<=10){
                      somaNota+=notas;
                      numeroNotas++;
                  }else {
                      System.out.println("ERRO! Digite um número válido.");
                      continue;
                  }
              }else {
                  System.out.println("Digite um número válido!");
                  scanner.nextInt();
                  continue;
              }
              scanner.nextLine();
              System.out.print("Quer adicionar outra nota?:");
              String adicionarNota = scanner.nextLine().trim().toLowerCase();
              while (!adicionarNota.equals("sim") && !adicionarNota.equals("não")){
                  System.out.print("Digite apenas sim ou não:");
                  adicionarNota = scanner.nextLine().trim().toLowerCase();
              }
              if (adicionarNota.equals("não")){
                  break;
              }
          }
          if (numeroNotas>0){
              double media = somaNota/numeroNotas;
              System.out.println("Sua média foi:"+media);
          }else {
              System.out.println("Nenhuma nota foi adicionada!");
          }
          System.out.print("Deseja calcular outra média?:");
          String outraMedia = scanner.nextLine().trim().toLowerCase();
          while (!outraMedia.equals("não") && !outraMedia.equals("sim")){
              System.out.print("Digite apenas sim ou não:");
              outraMedia = scanner.nextLine().trim().toLowerCase();
          }
          if (outraMedia.equals("não")){
              System.out.println(">>>Finalizando programa");
              break;
          }

      }
    }


    public static void tabelaBrasileirao(){
        String[] times = {
                "Botafogo", "Flamengo", "Palmeiras", "São Paulo", "Atlético Mineiro",
                "Internacional", "Grêmio", "Santos", "Athletico Paranaense", "Fortaleza",
                "Ceará", "Vasco da Gama", "Bahia", "Goiás", "Cruzeiro", "Bragantino",
                "Coritiba", "Atlético Goianiense", "Fluminense", "Chapecoense"
        };
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("A classificação dos times:"+Arrays.toString(times));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiros da lista:"+Arrays.toString(Arrays.copyOfRange(times,1,5)));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os últimos quatro da lista:"+Arrays.toString(Arrays.copyOfRange(times,times.length-4,times.length)));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        String[] timesOrdenados = times.clone();
        Arrays.sort(timesOrdenados);
        System.out.println("Os times em ordem alfabetica:"+ Arrays.toString(timesOrdenados));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        int posicaoChapecoense = -1;
        for (int p=0;p<times.length;p++){
            if (times[p].equals("Chapecoense")){
                posicaoChapecoense = p+1;
                break;
            }
        }
        System.out.println("Posição chapecoense:"+posicaoChapecoense);




    }

    public static void verificaoNumerosArrays(Scanner scanner){
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        int[] arrayNumero = new int[6];
        for (int n=0;n<arrayNumero.length;n++){
            System.out.print("Digite um número:");
            arrayNumero[n] = scanner.nextInt();
            if (arrayNumero[n]>0){
                soma+=arrayNumero[n];
            }
            if (arrayNumero[n]>maiorNumero){
                maiorNumero=arrayNumero[n];
            }
            if (arrayNumero[n]<menorNumero){
                menorNumero=arrayNumero[n];
            }
        }
        float media = (float) soma/ Arrays.stream(arrayNumero).count();
        System.out.println("A soma dos números digitados foi:"+soma);
        System.out.println("A média:"+media);
        System.out.println("O maior número:"+maiorNumero);
        System.out.println("O menor número:"+menorNumero);
    }


    public static void analisandoNomes(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine().trim();
        String[] nome = nomeCompleto.split(" ");
        System.out.println("O primeiro nome:"+nome[0]);
        System.out.println("O seu segundo nome:"+nome[nome.length-1]);
        System.out.println("Seu nome em letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("O seu nome em letras maiusculas:"+nomeCompleto.toUpperCase());
        System.out.println("seu primeiro nome tem:"+nome[0].length()+" letras.");
        System.out.println("Seu segundo nome tem:"+nome[nome.length-1].length()+" letras");
        System.out.println("Seu nome completo tem:"+nomeCompleto.replace(" ","").length());
    }


    public static void analisandoVogais(Scanner scanner){
        String[] listaNomes = {"maria","pedro","joana","ana","fernando"};
        for (String nomes : listaNomes){
            System.out.print("\nNo "+nomes+" temos as seguintes vogais:");
            for (char vogais: nomes.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(vogais))!=-1){
                    System.out.print(vogais+" ");
                }

            }
        }

    }

    public static void analisandoFrase(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (int f=0;f<frase.length();f++){
            if (frase.charAt(f)=='a'){
                contagem++;
            }
        }
        System.out.println("Na frase "+frase+" a letra A foi encontrada:"+contagem+"x");
        int primeiroA  = frase.indexOf("a");
        if (primeiroA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
        }else {
            System.out.println("A letra A não apareceu na frase!");
        }
        int ultimoA = frase.lastIndexOf("a");
        if (ultimoA>0){
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu na lista!");
        }
    }
}
