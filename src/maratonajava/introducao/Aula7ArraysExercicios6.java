package academy.devdojo.maratonajava.introducao;

import java.util.*;
import java.util.ArrayList;


public class Aula7ArraysExercicios6 {
    public static void main(String[] args) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        analisando media alunos
        analisandoMediaAlunos(scanner);

//        CALCULANDO MEDIA
        calculandoMediaNota(scanner);

//        jogo advinha
        jogoAdvinha(scanner,random);

// analisando frase metodo2
        verificandoLetraAnaFrase2(scanner);

        //        jogo da advinhação
        jogoAdvinhacao(scanner,random);

        //        calculando media
        calculandoMedia(scanner);

        //        verificando vogais na palavra
        vogaisNaPalavra();

        //        verificando nome
        avaliandoNome(scanner);

        // verificando vogais
        verificandoFrase(scanner);

//        contadores Numeros pares e impares
        contadorNumeroPareseImpares(scanner);

//        verificando maior e menor com arrays
        arraysNumeros(scanner);

        scanner.next();
    }

   public static void analisandoMediaAlunos(Scanner scanner) {
       ArrayList<Aluno> lista = new ArrayList<>();
       while (true) {
           System.out.print("Digite o nome do aluno:");
           String nome = scanner.nextLine().trim();
           nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
           float nota1 = 0;
           while (true) {
               try {
                   System.out.print("Digite a primeira nota:");
                   nota1 = Float.parseFloat(scanner.nextLine());
                   if (nota1 <= -1 || nota1 >= 11) {
                       System.out.println("Digite uma nota entre 0 e 10.");
                   } else {
                       break;
                   }
               } catch (NumberFormatException erro) {
                   System.out.print("Digite um número real.");
               }
           }
           float nota2 = 0;
           while (true) {
               try {
                   System.out.print("Digite a segunda nota:");
                   nota2 = Float.parseFloat(scanner.nextLine());
                   if (nota2 <= -1 || nota2 >= 11) {
                       System.out.println("Digite uma nota entre 0 e 10.");
                   } else {
                       break;
                   }
               } catch (NumberFormatException erro) {
                   System.out.println("Digite um número real.");
               }
           }
           float media = (nota1+nota2)/2;
           lista.add(new Aluno(nome, nota1,nota2,media));

           String novoAluno;
           do {
               System.out.print("Quer adicionar média de outro aluno?(sim/não):");
               novoAluno = scanner.nextLine().trim().toLowerCase();
           } while (!novoAluno.equals("sim") && !novoAluno.equals("não"));
           if (novoAluno.equals("não")) {
               break;
           }
       }
       for (int n=0;n<25;n++){
           System.out.print("=");
       }
       System.out.println();
       System.out.printf("%-4s %-10s %-8s\n","No", "Nome","Média");
       for (int n=0;n<25;n++){
           System.out.print("=");
       }
       System.out.println();
       for (int i=0;i<lista.size();i++){
           Aluno aluno = lista.get(i);
           System.out.printf("%-4d %-10s %-8.2f\n",i,aluno.getNome(), aluno.getMedia() );
       }
       while (true){
           System.out.print("Quer mostrar as notas de qual aluno?(Digite 999 para parar):");
           int opc = scanner.nextInt();
           System.out.print(">>>Finalizando o programa...");
           if (opc==999){
               break;
           }else {
               if (opc>=0 && opc<lista.size()){
                   Aluno aluno = lista.get(opc);
                   System.out.printf("As notas do %s são: %.2f e %.2f\n",aluno.getNome(), aluno.getNota1(),aluno.getNota2());
               }
           }
       }
   }

    static class Aluno{
        private String nome;
        private float nota1;
        private float nota2;
        private float media;

        public Aluno(String nome, float nota1, float nota2, float media){
            this.nome = nome;
            this.nota1 = nota1;
            this.nota2 = nota2;
            this.media = media;
        }

        public String getNome(){
            return nome;
        }

        public float getNota1() {
            return nota1;
        }
        public float getNota2(){
            return nota2;
        }

        public float getMedia() {
            return media;
        }
    }


    public static void calculandoMediaNota(Scanner scanner){
        float soma=0;
        float notas=0;
        int contNumeros = 0;
        while (true){
            while (true){
                System.out.print("Digite uma nota:");
                if (scanner.hasNextFloat()){
                    notas = scanner.nextFloat();
                    if (notas<=0 || notas>=10){
                        System.out.println("Digite um número entre 1 e 10");
                    }else {
                        soma+=notas;
                        contNumeros++;
                        break;
                    }
                }else {
                    System.out.println("Digite um número real.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            String novaNota;
            do {
                System.out.print("Quer adicionar outra nota?(sim/não):");
                novaNota = scanner.nextLine().trim().toLowerCase();
            }while (!novaNota.equals("sim") && !novaNota.equals("não"));
            if (novaNota.equals("não")){
                float media = soma/contNumeros;
                System.out.println("A media:"+String.format("%.2f",media));
                String calcularOutraMedia;
                do {
                    System.out.print("Quer calcular outra média?(sim/não):");
                    calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
                }while (!calcularOutraMedia.equals("sim") && !calcularOutraMedia.equals("não"));
                if (calcularOutraMedia.equals("não")){
                    System.out.println("Finalizando o programa..");
                    break;
                }else {
                    soma = 0;
                    contNumeros=0;

                }
            }
        }
    }

    public static void jogoAdvinha(Scanner scanner, Random random) throws InterruptedException{
        int jogador = 0;
        int computador = random.nextInt(10)+1;
        int contTentativas = 0;
        while (true){
            while (true){
                try {
                    System.out.print("Digite um número entre 1 e 10:");
                    jogador = Integer.parseInt(scanner.nextLine());
                    if (jogador<=0 || jogador>=11){
                        System.out.println("ERRO, Digite um número entre 1 e 10.");
                    }else {
                        contTentativas++;
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("ERRO.Digite um número real.");
                }
            }
            System.out.println("Processando....");
            Thread.sleep(600);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Tente um número maior....");
                }else {
                    System.out.println("Tente um número menor....");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("Você acertou!!!");
                System.out.println("Você precisou de:"+contTentativas+" jogadas para acertar.");
                String jogarNovamente;
                do {
                    System.out.print("Quer jogar novamente?(sim/não):");
                    jogarNovamente = scanner.nextLine().trim().toLowerCase();
                }while (!jogarNovamente.equals("sim") && !jogarNovamente.equals("não"));
                if (jogarNovamente.equals("não")){
                    System.out.println("Finalizando jogo....");
                    break;
                }else {
                    contTentativas=0;
                    computador = random.nextInt(10)+1;
                }
            }
        }
    }


    public static void verificandoLetraAnaFrase2(Scanner scanner){
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        int contagem=0;
        for (char letras : frase.toCharArray()){
            if ("a".indexOf(letras)!=-1){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu na frase:"+frase+", "+contagem+" vez(es).");
    }

    public static void jogoAdvinhacao(Scanner scanner, Random random) throws InterruptedException{
        System.out.println("Tente advinhar um número escolhido pelo computador.");
        int contTentativas=0;
        int computador = random.nextInt(10)+1;
        while (true){
            int jogador=0;
            while (true){
                System.out.print("Digite um número de 1 a 10:");
                if (scanner.hasNextInt()) {
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=10){
                        break;
                    }else{
                        System.out.println("Digite um númer de 1 a 10!!!");
                        continue;
                    }
                }  else {
                    System.out.println("ERRO! Digite um número válido!!!");
                    scanner.next();
                    continue;
                }
            }
            System.out.println("PROCESSANDO....");
            Thread.sleep(1000);
            contTentativas++;
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Tenten um número maior...");
                } else {
                    System.out.println("Tente um número menor...");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("Você acertou!!!");
                System.out.println("Você precisou de "+contTentativas+" para acertar.");
                break;
            }

        }
    }


    public static void contadorNumeroPareseImpares(Scanner scanner){
        ArrayList<Integer> newList = new ArrayList<>();
        int somaPar = 0, somaImpar=0;
        while (true){
            int numeros = 0;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numeros = scanner.nextInt();
                    newList.add(numeros);
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Quer adicionar outro número?(sim/não):");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("não") && !continuar.equals("sim")){
                System.out.print("Digite apenas sim ou não:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("não")){
                for (int numero : newList ){
                    if (numero%2==0){
                        somaPar++;
                    }else {
                        somaImpar++;
                    }
                }
                System.out.println("Foram digitados:"+somaPar+" números pares");
                System.out.println("Foram digitados:"+somaImpar+" números ímpares");
                break;
            }
        }
    }

    public static void arraysNumeros(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        int posMaior = 0, posMenor = 0, soma = 0, contNumeros =0;
        for (int n=0;n<arrayNumeros.length;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número:");
                if (scanner.hasNextInt()) {
                    arrayNumeros[n] = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um número válido.");
                    scanner.next();
                    continue;
                }
            }
            if (arrayNumeros[n]>maiorNumero){
                maiorNumero=arrayNumeros[n];
                posMaior=n;
            }
            if (arrayNumeros[n]<menorNumero){
                menorNumero=arrayNumeros[n];
                posMenor=n;
            }
            if (arrayNumeros[n]>0){
                soma+=arrayNumeros[n];
                contNumeros++;
            }
        }
        float media = (float ) soma/contNumeros;
        System.out.printf("A soma:%d%n",soma);
        System.out.printf("O média:%.2f%n",media);
        System.out.printf("Maior da Lista:%d e a posição é:%d%n",maiorNumero,posMaior);
        System.out.printf("O menor da lista:%d e a posição é:%d%n",menorNumero,posMenor);
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
                        System.out.println("ERRO!Digite um número de 1 a 10!");
                        continue;
                    }
                }else {
                    System.out.println("ERRO! Digite um número válido!");
                    continue;
                }
                scanner.nextLine();
                System.out.print("Quer adicionar outra nota?(sim/não):");
                String outraNota = scanner.nextLine().toLowerCase().trim();
                while (!outraNota.equals("não") && !outraNota.equals("sim")){
                    System.out.print("Digite aoenas sim ou não:");
                    outraNota = scanner.nextLine().trim().toLowerCase();
                }
                if (outraNota.equals("não")){
                    break;
                }
            }
            if (contNumero>0){
                float media = soma/contNumero;
                System.out.println("Sua média:"+media);
            }else {
                System.out.println("Não foram adicionados números.");
            }
            System.out.print("Deseja calcular outra média?(sim/não):");
            String calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            while (!calcularOutraMedia.equals("não") && !calcularOutraMedia.equals("sim")){
                System.out.print("Digite apenas sim ou não:");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }
            if (calcularOutraMedia.equals("não")){
                System.out.println(">>>Finalizando...");
                break;
            }
        }


    }

    public static void vogaisNaPalavra(){
        String[] listaFrutas = {"banana","laranja","tangerina","abacaxi","cacau","uva"};
        for (String frutas : listaFrutas ){
            System.out.print("\nNa palavra "+frutas+" temos as vogais:");
            for (char vogais : frutas.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(vogais))!=-1){
                    System.out.print(vogais+" ");
                }
            }
        }
    }


    public static void avaliandoNome(Scanner scanner){
        System.out.print("\nDigite o seu nome:");
        String nomeCompleto = scanner.nextLine().trim().toLowerCase();
        String[] nome = nomeCompleto.split(" ");
        System.out.println("O seu primeiro nome:"+nome[0]);
        System.out.println("O seu último nome:"+nome[nome.length-1]);
        System.out.println("Seu nome em letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("Seu nome em letras maiusculas:"+nomeCompleto.toUpperCase());
        System.out.println("Seu primeiro nome tem:"+nome[0].length()+" letras");
        System.out.println("Seu segundo nome tem:"+nome[nome.length-1].length());
        System.out.println("Seu nome completo tem:"+nomeCompleto.replace(" ","").length()+" letras");
    }



    public static void verificandoFrase(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine();
        for (int n=0;n<frase.length();n++){
            if (frase.charAt(n)=='a'){
                contagem++;
            }
        }
        System.out.println("Na frase "+frase+" a letra A apareceu:"+contagem+"x ");
        int primeiroA = frase.indexOf("a");
        if (primeiroA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
        }else {
            System.out.println("A letra A não aparece na frase.");
        }
        int ultimoA = frase.lastIndexOf("a");
            if (ultimoA>0){
                System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
            }else {
                System.out.println("A letra A não apareceu na frase.");
            }
        }
    }

