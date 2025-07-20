package academy.devdojo.maratonajava.introducao;




import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;

public class Aula7ArraysExercicios7 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //        AVALIANDO A EXPRESSÃO NOVAMENTE!
        verificandoAexpressão(scanner);

        //        lista adicionando na posição correta
        listaPosicao(scanner);


        //        jogo advinhação parte 2
        jogoDaAdivinhacao(scanner,random);


        //        jogo advinhação
        jogoAdvinhacao(scanner, random);

//        recalculando a media
        recalculandoMedia(scanner);

        //        adicionado na lista e marcando posicao metodo 2 again
        adicionandoLista(scanner);


// adicionando na lista e marcando posição metodo 2
        adicionandoListaMarcandoposicao(scanner);



//        verificando a expressao
        expressaoCorretaOuNao(scanner);

//        lista adicionando na posição correta
        listaPosicaoNumeros(scanner);


//        lista e ADICIONANDO NA POSIÇÃO CORRETA
        listaComPosicao(scanner);

// nvoamente avaliando a expressão
        avaliandoExpressao(scanner);




        //        jogo advinhação
        jogoAdvinhacao(scanner, random);

//        recalculando a media
        recalculandoMedia(scanner);

        //        calculando a média novamente
        calculandoMediaNovamente(scanner);

//        AVALIANDO A EXPRESSÃO NOVAMENTE!
        verificandoAexpressão(scanner);

//        avaliando a expressão
        verificandoExpressao(scanner);

//        jogando advinha Numero
        programaAdvinhaNumero(scanner,random);



//        calculando a média novamente
        calculandoMediaNovamente(scanner);

        //        calculando media
        calculandoMedia(scanner);

//        analisando tabela campeonato();
        analisandoTabelaCampeonato(scanner);


//        analisando tabela times
        tabelaBrasileirao();

//analisando frase
        analisandoFraseMetodo2(scanner);

//        analisando vogais da palavra
        verificandoVogaisPalavras();

        // analisando nome
        analisand0Nome(scanner);

//    analisando frase
        analisandoFrase(scanner);
        scanner.close();
    }

    public static void adicionandoLista(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i=0;i<6;i++){
            while (true){
                System.out.print("Digite o "+(i+1)+"º número:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (!lista.contains(numeros)){
                        if (lista.isEmpty() || numeros > lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista!");
                        }else {
                            int pos =0;
                            while (pos < lista.size()){
                                if (numeros <= lista.get(pos)){
                                    lista.add(pos, numeros);
                                    System.out.println("Adicionado na posição:"+pos);
                                    break;
                                }
                                pos++;
                            }
                        }
                        break;
                    }else{
                        System.out.println("Número já adicionado na lista!");
                        break;
                    }
                }  else {
                    System.out.println("Número inválido! tente novamente.");
                    scanner.next();
                }
            }
        }
        System.out.println("A lista:"+lista);
    }


    public static void adicionandoListaMarcandoposicao(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        int numeros = 0;
        for (int i=0;i<6;i++){
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numeros = scanner.nextInt();
                    if (!lista.contains(numeros)){
                        if (lista.isEmpty() || numeros > lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos = 0;
                            while (pos < lista.size()){
                                if (numeros <= lista.get(pos)){
                                    lista.add(pos, numeros);
                                    System.out.println("Adicioando na posição:"+pos);
                                    break;
                                }
                                pos++;
                            }
                        }
                        break;
                    }else {
                        System.out.println("Número já existe na lista, digite outro número!");
                    }
                }else {
                    System.out.println("Digite um número verdadeiro!");
                    scanner.next();
                }
            }
        }
        System.out.println("A lista:"+lista);
    }

    public static void listaPosicao(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for(int n=0;n<6;n++){
            System.out.print("Digite um número:");
            int numero = scanner.nextInt();
            if (lista.isEmpty() || numero > lista.get(lista.size()-1)){
                lista.add(numero);
                System.out.println("Adicionado na última posição:");
            }else {
                int pos = 0;
                while (pos < lista.size()){
                    if (numero <= lista.get(pos)){
                        lista.add(pos, numero);
                        System.out.println("Adicionado na posição:"+pos);
                        break;
                    }
                    pos++;
                }
            }
        }
        System.out.println("A lista ficou assim:"+lista);
    }


    public static void expressaoCorretaOuNao(Scanner scanner){
        Stack<Character> pilhaCaracter =new Stack<>();
        System.out.print("Digite uma expressão:");
        String expressao = scanner.nextLine().trim().toLowerCase();
        scanner.next();
        for(char parenteses : expressao.toCharArray()){
            if (parenteses=='('){
                pilhaCaracter.push(parenteses);
            }else {
                if (parenteses==')'){
                    if (!pilhaCaracter.isEmpty()){
                        pilhaCaracter.pop();
                    }else {
                        System.out.println("Expressão incorreta!");
                        return;
                    }
                }
            }
        }
        if (pilhaCaracter.isEmpty()){
            System.out.println("Sua expressão está correta!");
        }else {
            System.out.println("Sua expressão está incorreta.");
        }
    }


    public static void listaPosicaoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int n=0;n<6;n++){
            System.out.print("Digite um número:");
            int numero = scanner.nextInt();
            if (lista.isEmpty() || numero > lista.get(lista.size()-1)){
                lista.add(numero);
                System.out.println("Adicionado no final da lista!");
            }else {
                int pos = 0;
                while (pos < lista.size()){
                    if (numero <= lista.get(pos)){
                        lista.add(pos, numero);
                        System.out.println("Adicionado na posição:"+pos);
                        break;
                    }
                    pos++;
                }
            }
        }
        System.out.println("A lista ficou:"+lista);
    }

    public static void listaComPosicao(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int n=0;n<6;n++){
            System.out.print("Digite um número:");
            int num = scanner.nextInt();
            if (n==0 || num > lista.get(lista.size()-1)){
                lista.add(num);
                System.out.println("Adicionado no final da lista:"+num);
            }else {
                int pos = 0;
                while (pos < lista.size()){
                    if (num <= lista.get(pos)){
                        lista.add(pos, num);
                        System.out.println("Adicionado na posição:"+pos);
                        break;
                    }
                    pos++;
                }
            }
        }
        System.out.println("A lista é igual:"+lista);
    }

    public static void avaliandoExpressao(Scanner scanner){
        System.out.print("Digite uma expressão:");
        String expressao = scanner.nextLine().trim().toLowerCase();
        Stack<Character> pilhaParenteses = new Stack<>();
        for (char parenteses : expressao.toCharArray()){
            if (parenteses=='('){
                pilhaParenteses.push(parenteses);
            }else {
                if (parenteses==')'){
                    if (!pilhaParenteses.isEmpty()){
                        pilhaParenteses.pop();
                    }else {
                        System.out.println("Sua expressão está incorreta!");
                        return;
                    }
                }
            }
        }
        if (pilhaParenteses.isEmpty()){
            System.out.println("Sua expressão está correta!");
        }else {
            System.out.println("Sua epressão está incorreta!");
        }
    }



    public static void jogoDaAdivinhacao(Scanner scanner, Random random) throws InterruptedException{
        int jogador = 0;
        int computador = random.nextInt(10)+1;
        int contTentativas = 0;
        while (true){
            while (true){
                System.out.print("Digite um número de 1 a 10:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=10){
                        contTentativas++;
                        break;
                    }else {
                        System.out.println("Digite um número de 1 a 10");
                    }
                }else {
                    System.out.println("Digite um número válido!!!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.println("PROCESSANDO....");
            Thread.sleep(700);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digite um número maior!");
                }else{
                    System.out.println("Digite um número menor!");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("VOCÊ ACERTOU!!!");
                System.out.println("Você precisou de:"+contTentativas+" tentativas.");
                System.out.print("Quer jogar novamente?(sim/não):");
                String jogarNovamente = scanner.nextLine().trim().toLowerCase();
                while (!jogarNovamente.equals("não") && !jogarNovamente.equals("sim")){
                    System.out.print("Digite apenas sim ou não:");
                    jogarNovamente = scanner.nextLine().trim().toLowerCase();
                }
                if (jogarNovamente.equals("não")){
                    System.out.println("Finalizando o jogo...");
                    break;
                }else {
                    contTentativas=0;
                }
            }
        }
    }

    public static void recalculandoMedia(Scanner scanner){
        float soma = 0;
        int contNumeros = 0;
        while (true){
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextFloat()){
                    float numeros = scanner.nextFloat();
                    if (numeros>=1 && numeros<=10){
                        soma+=numeros;
                        contNumeros++;
                    }else {
                        System.out.println("Digite um número de 1 a 10.");
                        continue;
                    }
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                    continue;
                }
                scanner.nextLine();
                System.out.print("Quer adicionar outro número?(sim/não):");
                String adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                while (!adicionarOutroNumero.equals("não") && !adicionarOutroNumero.equals("sim")){
                    System.out.print("Digite apenas sim ou não:");
                    adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                }
                if (adicionarOutroNumero.equals("não")){
                    float media = soma/contNumeros;
                    System.out.println("A média:"+String.format("%.2f",media));
                    break;
                }
            }
            System.out.print("Quer calcular outra média?(sim/não):");
            String calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            while (!calcularOutraMedia.equals("não") && !calcularOutraMedia.equals("sim")){
                System.out.print("Digite apenas sim ou não:");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }
            if (calcularOutraMedia.equals("não")){
                System.out.println(">>>Finalizando o programa...");
                break;
            }
        }
    }


    public static void verificandoAexpressão(Scanner scanner){
        System.out.print("Digite uma expresão:");
        String expressao = scanner.nextLine().trim().toLowerCase();
        Stack<Character> pilhaParenteses = new Stack<>();
        for (char parenteses : expressao.toCharArray()){
            if (parenteses=='('){
                pilhaParenteses.push(parenteses);
            }else {
                if(parenteses==')'){
                    if (!pilhaParenteses.isEmpty()){
                        pilhaParenteses.pop();
                    }else {
                    System.out.println("Sua expressão está incorreta!");
                    return;
                    }
                }
            }
        }
        if (pilhaParenteses.isEmpty()){
            System.out.println("Sua expressão está correta!");
        }else {
            System.out.println("Sua expressão está incorreta!");
        }
    }

    public static void verificandoExpressao(Scanner scanner){
        System.out.print("Digite uma expressão:");
        String expresssao = scanner.nextLine();
        Stack<Character> pilha = new Stack<>();// Cria uma pilha para armazenar os parênteses de abertura
        for (char parenteses : expresssao.toCharArray()){
            if (parenteses=='('){
                pilha.push(parenteses);
            } else if (parenteses==')') {
                if (!pilha.isEmpty()){
                    pilha.pop();
                }else {
                    System.out.println("Sua expressão está incorreta!!!");
                    return;
                }
            }
        }
        if (pilha.isEmpty()){
            System.out.println("Sua expressão está correta!");
        }else {
            System.out.println("Sua expressão está incorreta!");
        }
    }

    public static void programaAdvinhaNumero(Scanner scanner, Random random) throws InterruptedException{
        int jogador = 0;
        int computador = random.nextInt(10)+1;
        int contTentativas = 0;
        while (true){
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=10){
                        contTentativas++;
                        break;
                    }else {
                        System.out.println("Digite um número de 1 a 10!");
                        continue;
                    }
                }else {
                    System.out.println("erro! Digite um número válido.");
                    scanner.next();
                    continue;
                }
            }
            scanner.nextLine();
            System.out.println("PROCESSANDO....");
            Thread.sleep(1000);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digite um valor maior!!!");
                }else {
                    System.out.println("Digite um valor menor!!!");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("VOCÊ ACERTOU!!!");
                System.out.println("Você precisou de:"+contTentativas+" tentativas.");
                System.out.print("Quer jogar novamente?(sim/não):");
                String jogarNovamente = scanner.nextLine().trim().toLowerCase();
                while (!jogarNovamente.equals("não") && !jogarNovamente.equals("sim")){
                    System.out.print("Digite apenas sim ou não:");
                    jogarNovamente = scanner.nextLine().trim().toLowerCase();
                }
                if (jogarNovamente.equals("não")){
                    System.out.println(">>>>Finalizando....");
                    break;
                }
            }

        }

    }

    public static void calculandoMediaNovamente(Scanner scanner){
        while (true){
            float soma = 0;
            int contNumeros = 0;
            while (true){
                System.out.print("Digite uma nota:");
                if (scanner.hasNextFloat()){
                    float notas = scanner.nextFloat();
                    if (notas>=1 && notas<=10){
                        soma+=notas;
                        contNumeros++;
                    }else {
                        System.out.println("Digite um número de 1 a 10!");
                        continue;
                    }
                }else {
                    System.out.println("ERRO!Digite um número válido!!!");
                    scanner.next();
                    continue;
                }
                scanner.nextLine();
                System.out.print("Quer adicionar outro número?(sim/não)?");
                String adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                while (!adicionarOutroNumero.equals("não") && !adicionarOutroNumero.equals("sim")){
                    System.out.print("Digite apenas sim ou não:");
                    adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                }
                if (adicionarOutroNumero.equals("não")){
                    float media = soma/contNumeros;
                    System.out.println("A média:"+String.format("%.2f",media));
                    break;
                }
            }
            System.out.print("Quer calcular outra média?(sim/não):");
            String calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            while (!calcularOutraMedia.equals("não") && !calcularOutraMedia.equals("sim")){
                System.out.print("Digite um número");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }
            if (calcularOutraMedia.equals("não")){
                System.out.println(">>>>Finalizando...");
                break;
            }
        }
    }

    public static void analisandoTabelaCampeonato(Scanner scanner){
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
        System.out.println("A classificação do campeonato:"+Arrays.toString(times));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiros da tabela:"+Arrays.toString(Arrays.copyOfRange(times,0,5)));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os 4 últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times,times.length-4,times.length)));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        String[] timesOrdenados = times.clone();
        Arrays.sort(timesOrdenados);
        System.out.println("A tabela em ordem alfabética:"+Arrays.toString(timesOrdenados));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        int chapecoese = 0;
        for (int p=0;p<times.length;p++){
            if (times[p].equals("Chapecoense")){
                chapecoese=p+1;
                break;
            }
        }
        System.out.println("Posição chapecoese:"+chapecoese);
    }


    public static void jogoAdvinhacao(Scanner scanner, Random random) throws InterruptedException{
        int computador = random.nextInt(10)+1;
        int jogador = 0;
        int contTentativas = 0;
        while (true){
            while (true){
                System.out.print("Digite um número de 1 a 10:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=10){
                        contTentativas++;
                        break;
                    }else {
                        System.out.println("Digite um número de 1 a 10!!!");
                    }
                }else {
                    System.out.println("ERRO! Digite apenas números inteiros.");
                    scanner.next();

                }
            }
            scanner.nextLine();
            System.out.println(">>>PROCESSANDO....");
            Thread.sleep(1000);
            if (jogador!=computador){
                if (jogador<computador) {
                    System.out.println("Digite um número MAIOR!");
                }else {
                    System.out.println("Digite um número MENOR!");
                }
            }else{
                System.out.println("Computador:"+computador);
                System.out.println("VOCÊ ACERTOU!!!");
                System.out.println("Você precisou de:"+contTentativas+" tentativas.");
                System.out.println("Quer jogar novamente?(sim/não):");
                String jogarNovamente = scanner.nextLine().trim().toLowerCase();
                while (!jogarNovamente.equals("não") && !jogarNovamente.equals("sim")){
                    System.out.println("Digite apenas sim ou não:");
                    jogarNovamente = scanner.nextLine().trim().toLowerCase();
                }
                if (jogarNovamente.equals("não")){
                    System.out.println("Finalizando programa...");
                    break;
                }
            }

        }

    }

    public static void calculandoMedia(Scanner scanner){
        while (true){
            float soma = 0;
            int contNotas = 0;
            while (true){
                System.out.print("Digite uma nota:");
                if (scanner.hasNextFloat()){
                    float nota = scanner.nextFloat();
                    if (nota>=1 && nota<=10){
                        soma+=nota;
                        contNotas++;
                    }else {
                        System.out.println("Digite uma nota de 1 a 10");
                        continue;
                    }
                }else {
                    System.out.println("ERRO, Digite um número válido.");
                    scanner.next();
                    continue;
                }
                scanner.nextLine();
                System.out.print("Quer adicionar outra nota?(sim/não)");
                String adicionarOutraNota = scanner.nextLine().trim().toLowerCase();
                while (!adicionarOutraNota.equals("não") && !adicionarOutraNota.equals("sim")){
                    System.out.print("Digite apenas sim ou não:");
                    adicionarOutraNota = scanner.nextLine().trim().toLowerCase();
                }
                if (adicionarOutraNota.equals("não")){
                    float media = soma/contNotas;
                    System.out.println("Sua média:"+String.format("%.2f",media));
                    break;
                }
            }
            System.out.print("Deseja calcular outra média?(sim/não):");
            String calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            while (!calcularOutraMedia.equals("sim") && !calcularOutraMedia.equals("não")){
                System.out.print("Digite apenas sim ou não:");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }
            if (calcularOutraMedia.equals("não")) {
                System.out.println(">>>Filalizando o programa!");
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
        System.out.println("Os cinco primeiros da tabela:"+Arrays.toString(Arrays.copyOfRange(times, 1,5)));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os 4 últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times,times.length-4,times.length)));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        Arrays.sort(times);
        System.out.println("A lista em ordem alfabética:"+Arrays.toString(times));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        int posicaoChapecoense = 0;
        for (int p=0;p<times.length;p++){
            if (times[p].equals("Chapecoense")){
                posicaoChapecoense=p+1;
                break;
            }
        }
        System.out.println("A chapecoense está na posição:"+posicaoChapecoense);
    }


    public static void analisandoFraseMetodo2(Scanner scanner){
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        String[] arrayFrase = {frase};
        int contagemA = 0;
        for (char letras : frase.toCharArray()){
            if ("a".indexOf(Character.toLowerCase(letras))!=-1){
                contagemA++;
            }
        }
        System.out.println("A letra A apareceu:"+contagemA+" vezes");
    }

    public static void verificandoVogaisPalavras(){
        String[] arrayPalavras={"banana","comida","uva","abacaxi"};
        for (String palavras : arrayPalavras){
            System.out.print("\nNa palavra "+palavras+" temos as vogais:");
            for (char vogais : palavras.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(vogais))!=-1){
                    System.out.print(vogais+" ");
                }
            }
        }
    }

    public static void analisand0Nome(Scanner scanner){
        System.out.print("Digite o seu nome:");
        String nomeCompleto = scanner.nextLine();
        String[] arrayNome = nomeCompleto.split(" ");
        System.out.println("Seu primeiro nome:"+arrayNome[0]);
        System.out.println("Seu segundo nome:"+arrayNome[arrayNome.length-1]);
        System.out.println("Seu nome em letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("Seu nome em letras maiusculas:"+nomeCompleto.toUpperCase());
        System.out.println("Seu primeiro nome tem:"+arrayNome[0].length()+" letras");
        System.out.println("Seu segundo nome tem:"+arrayNome[arrayNome.length-1].length());
        System.out.println("Seu nome completo tem:"+nomeCompleto.replace(" ","").length());
    }

    public static void analisandoFrase(Scanner scanner){
        int contagem=0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (int i=0;i<frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu na frase "+frase+":"+contagem+" vezes.");
        int primeiroA = frase.indexOf("a");
        int ultimooA = frase.lastIndexOf("a");
        if (primeiroA>0 && ultimooA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimooA);
        }else {
            System.out.println("A letra não apareceu nesta frase!");
        }
    }

}
