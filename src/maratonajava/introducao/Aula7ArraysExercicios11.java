package academy.devdojo.maratonajava.introducao;


import javax.swing.*;
import java.util.*;


public class Aula7ArraysExercicios11 {
    public static void main(String[] args) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


//        calculando media
        calculandoMedia(scanner);

//        jogo advinhação
        jogoAdvinhacao(scanner, random);

//jogo pedra, papel e tesoura
        jogoPedraPapelTesoura(scanner, random);

//        posição Numeros
        posicaoNumeros(scanner);


//        array de numeros
        arrayNumeros(scanner);


//        lista reversa
        listaReversa(scanner);

//        verificando a expressão
        verificandoExpressao(scanner);

//        verificando tabela brasileirão
        tabelaBrasileirao();

//        verificando letra A na frase metodo2
        verificandoLetraANaFreaseMetodo2(scanner);

//        analisando nomes
        vogaisDosNomes();

        //        analisando frase
        analisandoFrase(scanner);
        scanner.close();
    }




    public static void jogoPedraPapelTesoura(Scanner scanner, Random random) throws InterruptedException{
        while (true){
            int jogador =0;
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            while (true){
                System.out.print("Digite uma das opções acima:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=3){
                        break;
                    }else {
                        System.out.println("Digite um número válido.");
                    }
                }else {
                    System.out.println("ERRO! Digite uma das opções acima.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.println("Processando...");
            Thread.sleep(600);
            int computador = random.nextInt(3)+1;
            System.out.println("Computador"+computador);
            if (jogador==computador){
                System.out.println("JOGADOR:"+jogoJoKePo(jogador)+" | COMPUTADOR:"+jogoJoKePo(computador)+" | RESULTADO: DEU EMPATE!!!");
            } else if (jogador==1 && computador==3 ||
                        jogador==2 && computador==1 ||
                        jogador==3 && computador==2) {
                System.out.println("JOGADOR:"+jogoJoKePo(jogador)+" | COMPUTADOR:"+jogoJoKePo(computador)+" | RESULTADO: VOCÊ VENCEU!!!");
            }else {
                System.out.println("JOGADOR:"+jogoJoKePo(jogador)+" | COMPUTADOR:"+jogoJoKePo(computador)+" | RESULTADO: VOCÊ PERDEU!!!");
            }
            System.out.print("Quer jogar novamente?(sim/não):");
            String jogarNovamente = scanner.nextLine().trim().toLowerCase();
            while (!jogarNovamente.equals("sim") && !jogarNovamente.equals("não")){
                System.out.print("ERRO, Digite apenas sim ou não:");
                jogarNovamente = scanner.nextLine().trim().toLowerCase();
            }
            if (jogarNovamente.equals("não")){
                System.out.println(">>.Finalizando programa.");
                break;
            }
        }
    }

    public static String jogoJoKePo(int escolha){
        switch (escolha){
            case 1: return "PEDRA";
            case 2: return "PAPEL";
            case 3: return "TESOURA";
        }
        return "";
    }

    public static void posicaoNumeros(Scanner scanner){
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        for (int n=0;n<6;n++){
            while (true){
                System.out.print("Digite um número "+(n+1)+"º número:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (listaNumeros.contains(numeros)){
                        System.out.println("Número repetido, digite outro número.");
                        continue;
                    }else {
                        if (listaNumeros.isEmpty() || numeros >= listaNumeros.get(listaNumeros.size()-1)){
                            listaNumeros.add(numeros);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos = 0;
                            while (pos < listaNumeros.size()){
                                if (numeros <= listaNumeros.get(pos)){
                                    listaNumeros.add(pos, numeros);
                                    System.out.println("Adicionado na posição:"+pos);
                                    break;
                                }
                                pos++;
                            }
                        }
                    }
                    break;
                }else {
                    System.out.println("ERRO!Digite um número válido.");
                    scanner.next();
                }
            }
        }
        System.out.println("A lista:"+listaNumeros);
    }


    public static void jogoAdvinhacao(Scanner scanner, Random random) throws InterruptedException{
        int computador = random.nextInt(10)+1;
        int contTentativas=0;
        int jogador = 0;
        while (true){
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=10){
                        contTentativas++;
                        break;
                    }else {
                        System.out.println("ERRO!Digite um número entre 1 e 10.");
                    }
                }else {
                    System.out.println("ERRO!Digite um valor válido.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.println(">>>Processando....");
            Thread.sleep((600));
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digite um número maior.");
                }else {
                    System.out.println("Digite um número menor");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("Parabéns, você acertou.");
                System.out.println("Você precisou de "+contTentativas+" tentativas parar acertar.");
                String jogarNovamente;
                do {
                    System.out.print("Quer jogar novamente?(sim/não):");
                    jogarNovamente = scanner.nextLine().trim().toLowerCase();
                }while (!jogarNovamente.equals("sim") && !jogarNovamente.equals("não"));
                if (jogarNovamente.equals("não")){
                    System.out.println("Finalizando...");
                    break;
                }else {
                    contTentativas=0;
                    computador= random.nextInt(10)+1;
                }
            }
        }
    }


    public static void arrayNumeros(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int maiorLista = Integer.MIN_VALUE, menorLista=Integer.MAX_VALUE, soma=0, contNumeros=0, posMaior =0, posMenor=0;
        for(int n=0;n< arrayNumeros.length;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número:");
                if (scanner.hasNextInt()){
                    arrayNumeros[n] = scanner.nextInt();
                    soma+=arrayNumeros[n];
                    contNumeros++;
                    boolean numeroRepetido = false;
                    for (int i=0;i<n;i++){
                        if (arrayNumeros[n]==arrayNumeros[i]){
                            numeroRepetido = true;
                            break;
                        }
                    }
                    if (numeroRepetido){
                        System.out.println("Número repetido, tente outro!!!");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Erro!Digite um número válido.");
                    scanner.next();
                }

            }
            if (arrayNumeros[n]>maiorLista){
                maiorLista=arrayNumeros[n];
                posMaior=n;
            }
            if (arrayNumeros[n]<menorLista){
                menorLista=arrayNumeros[n];
                posMenor=n;
            }
        }
        float media =(float) soma/contNumeros;
        System.out.println("A lista:"+Arrays.toString(arrayNumeros));
        System.out.println("A média:"+media);
        System.out.println("O maior da Lista:"+maiorLista+" | posição:"+posMaior);
        System.out.println("p menor da lista:"+menorLista+" | posição:"+posMenor);
    }


    public static void calculandoMedia(Scanner scanner){
        while (true){
            int contNotas = 0;
            float notas = 0, somaNotas=0;
            while (true){
                System.out.print("Digite uma nota:");
                if (scanner.hasNextFloat()){
                    notas = scanner.nextFloat();
                    if (notas>=1 && notas<=10){
                        somaNotas+=notas;
                        contNotas++;
                    }else {
                        System.out.println("Erro, digite um número de 1 a 10!");
                        continue;
                    }
                }else {
                    System.out.println("ERRO! Digite um número real.");
                    scanner.next();
                    continue;
                }
                scanner.nextLine();
                String adicionarOutraNota;
                do {
                    System.out.print("Quer adicionar outra nota?(sim/não):");
                    adicionarOutraNota = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarOutraNota.equals("sim") && !adicionarOutraNota.equals("não"));
                if (adicionarOutraNota.equals("não")){
                    float media = somaNotas/contNotas;
                    System.out.println("Sua média:"+media);
                    break;
                }
            }
            String calcularOutraMedia;

            do {
                System.out.print("Quer calcular outra média?(sim/não):");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }while (!calcularOutraMedia.equals("sim") && !calcularOutraMedia.equals("não"));
            if (calcularOutraMedia.equals("não")){
                System.out.println(">>>Finalizando o programa....");
                break;
            }
        }
    }


    public static void listaReversa(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            System.out.print("Digite um número:");
            if (scanner.hasNextInt()){
                int numeros = scanner.nextInt();
                if (lista.contains(numeros)){
                    System.out.println("Número repetido, digite outro número.");
                    continue;
                }else {
                    lista.add(numeros);
                }
            }else {
                System.out.println("ERRO!Digite um número válido.");
                scanner.next();
                continue;
            }
           scanner.nextLine();
            String adicionarOutroNumero;
            do {
                System.out.print("Quer adicionar outro número?:");
                adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
            }while (!adicionarOutroNumero.equals("sim") && !adicionarOutroNumero.equals("não"));
            if (adicionarOutroNumero.equals("não")){
                Collections.sort(lista);
                Collections.reverse(lista);
                System.out.println("A lista:"+lista);
                break;
            }
        }

    }


    public static void verificandoExpressao(Scanner scanner){
        Stack<Character> pilhaParenteses = new Stack<>();
        System.out.print("Digite uma exprressão:");
        String expressao = scanner.nextLine().trim();
        for (char parenteses : expressao.toCharArray()){
            if (parenteses=='('){
                pilhaParenteses.push(parenteses);
            }else {
                if (parenteses==')'){
                    if (!pilhaParenteses.isEmpty()){
                        pilhaParenteses.pop();
                    }else {
                        System.out.println("Sua expressão está incorreta.");
                        return;
                    }
                }
            }
        }
        if (pilhaParenteses.isEmpty()){
            System.out.println("Sua expressão está correta.");
        }else {
            System.out.println("Sua expressão está incorreta.");
        }
    }

    public static void tabelaBrasileirao(){
        String[] times = {
                "Botafogo", "Palmeiras", "Internacional", "Fortaleza", "Flamengo",
                "São Paulo", "Bahia", "Corinthians", "Cruzeiro", "Vasco da Gama",
                "Atlético-MG", "EC Vitória", "Juventude", "Grêmio", "Athletico-PR",
                "Fluminense", "Criciúma", "Bragantino", "Cuiabá", "Atlético-GO"
        };

        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("A tabela do brasileirão:"+ Arrays.toString(times));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiros da tabela:"+Arrays.toString(Arrays.copyOfRange(times, 1,5)));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os quatro últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times,times.length-4,times.length)));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        String[] listaOrdenada = times.clone();
        Arrays.sort(listaOrdenada);
        System.out.println("A tabela em ordem alfabética:"+Arrays.toString(listaOrdenada));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        int posicaoBragantino =0;
        for (int i=0;i<times.length;i++){
            if (times[i].equals("Bragantino")){
                posicaoBragantino=i+1;
            }
        }
        System.out.println("Posição do Bragantino:"+posicaoBragantino);
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
    }

    public static void verificandoLetraANaFreaseMetodo2(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (char letras : frase.toCharArray()){
            if ("a".indexOf(letras)!=-1){
                contagem++;

            }
        }
        System.out.println("A letra A apareceu:"+contagem+" vezes na frase:"+frase);
    }


    public static void vogaisDosNomes(){
        String[] vogaisNomes = {"maria","pedro","joana","ana","fernando"};
        for (String nomes : vogaisNomes){
            System.out.print("\nNo nome:"+nomes+" temos as vogais:");
            for (char vogais : nomes.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(vogais))!=-1){
                    System.out.print(vogais+" ");
                }
            }
        }
    }

    public static void analisandoFrase (Scanner scanner){
        int contagem=0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (int i=0;i<frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu:"+contagem+" vezes na frase:"+frase);
        int primeiroA = frase.indexOf("a");
        int ultimoA = frase.lastIndexOf("a");
        if (primeiroA >0 && ultimoA>0){
            System.out.println("O primeiro A apareceu na posição:"+primeiroA);
            System.out.println("O último A apareceu na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu na frase.");
        }
    }






}
