package academy.devdojo.maratonajava.introducao;




import java.nio.channels.ScatteringByteChannel;
import java.util.*;

public class Aula7ArraysExercicios10 {
    public static void main(String[] args) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //        jogo pedra papel e tesoura
        jogoPedraPapelTesoura2(scanner,random);

        // jogo advinha 4
        jogoAdvinhacao4(scanner,random);

//        array numeros
        arrayNumeros(scanner);

        // calculando media
        calculandoMediaNotas(scanner);

        //analisando uma frase
        analisandoFraseLetraA(scanner);
        scanner.close();


//posição numeros
        posicaoNumeros(scanner);


//        verificando expressao
        verificandoExpressao(scanner);

//        jogo advinhação
        jogoAdvinhacao5(scanner,random);

//        calculando a media
        calculandoMedia2(scanner);



//        calculando media
        calculandoMedia(scanner);

//        verificando uma expressão
        verificandoUmaExpressao(scanner);

//        analisandoArray
        analisandoArray(scanner);


//        lista reversa
        listaReversa(scanner);

//        avaliando expressao
        avaliandoExpressao(scanner);

//        adicionando um número na posição correta
        numeroPosicaoCorreta(scanner);

//        jogo advinhação
        jogoAdvinhacao3(scanner, random);

//        calculando media
        calculandoMediaDasNotas(scanner);
        //        tabela brasileirão
        tabelBrasieirao2(scanner);

//        jogo advinhação
        jogoAdvinhacao2(scanner,random);

        // calculando notas
        calculandoNotas(scanner);

//        adicionando números na posição correta
        adicionandoNumerosPosicaoCorreta(scanner);

//        lista ao contrario
        listaReverse(scanner);

//        jogo pedra, papel, tesoura
        jogoPedraPapelTesoura(scanner,random);

// analisando expressao
        analisandoExpressao(scanner);

//        jogo advinhação
        jogoAdvinhacao(scanner,random);



//        manipulando números de  um array
        manipulandoNumeroArray(scanner);


//        analisando frase, metodo 2
        analisandoFraseLetraAMetodo2(scanner);

        // array nomes, separando as vogais
        arrayNomesSeparandoAsVogais();


    }

    public static void posicaoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int n=0;n<6;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (lista.contains(numeros)){
                        System.out.println("Esse número já foi digitado, tente outro");
                        continue;
                    }else {
                        if (lista.isEmpty() || numeros >= lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos=0;
                            while (pos < lista.size()){
                                if (numeros<= lista.get(pos)){
                                    lista.add(pos, numeros);
                                    System.out.println("Adicionado na posição:"+pos);
                                    break;
                                }
                                pos++;
                            }
                        }
                    }
                    break;
                }else {
                    System.out.println("Erro! Digite um número válido.");
                }
            }
        }
        System.out.println("A lista:"+lista);
    }

    public static void arrayNumeros(Scanner scanner){
        int[] arrayNumeros =new int[6];
        int maiorLista = Integer.MIN_VALUE, menorLista =Integer.MAX_VALUE;
        int posMaior = 0, posMenor=0;
        int soma=0, contNumeros=0;
        for (int i=0;i<arrayNumeros.length;i++){
            while (true){
                System.out.print("Digite o "+(i+1)+"º número:");
                if (scanner.hasNextInt()){
                    arrayNumeros[i] = scanner.nextInt();
                    boolean numeroRepetido = false;
                    for (int n=0;n<i;n++){
                        if (arrayNumeros[i]==arrayNumeros[n]){
                            numeroRepetido = true;
                            break;
                        }
                    }
                    if (numeroRepetido){
                        System.out.println("Número repetido, tente outro.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Digite um número real.");
                    scanner.next();
                }
            }
            if (arrayNumeros[i]>0){
                soma+=arrayNumeros[i];
                contNumeros++;
            }
            if (arrayNumeros[i] > maiorLista) {
                maiorLista=arrayNumeros[i];
                posMaior=i;
            }
            if (arrayNumeros[i]<menorLista){
                menorLista=arrayNumeros[i];
                posMenor=i;
            }
        }
        float media = soma/contNumeros;
        System.out.println("A lista ficou:"+ Arrays.toString(arrayNumeros));
        System.out.println("A média:"+String.format("%.2f",media));
        System.out.println("O maior da lista:"+maiorLista+" | Posição:"+posMaior);
        System.out.println("O menor da lista:"+menorLista+" | Posição:"+posMenor);
    }

    public static void verificandoExpressao(Scanner scanner){
        Stack<Character> pilhaParenteses = new Stack<>();
        System.out.print("Digite uma expressão:");
        String expressao = scanner.nextLine().trim().toLowerCase();
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

    public static void jogoAdvinhacao5(Scanner scanner, Random random) throws InterruptedException{
        int computador = random.nextInt(10)+1;
        int jogador = 0, contTentativas=0;
        while (true){
            while (true){
                System.out.print("Digite um número de 1 a 10:");
                if (scanner.hasNextFloat()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=10){
                        contTentativas++;
                        break;
                    }else {
                        System.out.println("ERRO! Digite um número de 1 a 10.");
                    }
                }else {
                    System.out.println("Digite um número verdadeiro.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.println("PROCESSANDO....");
            Thread.sleep(600);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Tente um número maior.");
                }else {
                    System.out.println("Tente um número menor.");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("Você acertou!!!");
                System.out.println("Você precisou de:"+(contTentativas)+" tentativas.");
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
                    computador = random.nextInt(10)+1;
                }
            }
        }
    }

    public static void calculandoMedia2(Scanner scanner){
        while (true){
            float soma =0, notas = 0;
            int conNotas = 0;
            while (true){
                System.out.print("Digite uma nota:");
                if (scanner.hasNextFloat()){
                    notas = scanner.nextFloat();
                    if (notas>=1 && notas<=10){
                        soma+=notas;
                        conNotas++;
                    }else {
                        System.out.println("ERRO! Digite uma nota entre 1 e 10.");
                        continue;
                    }
                }else {
                    System.out.println("ERRO! Digite um número válido.");
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
                    float media = soma/conNotas;
                    System.out.println("Média:"+String.format("%.2f",media));
                    break;
                }
            }
            String calcularOutraMedia;
            do {
                System.out.print("Quer calcular outra média?(sim/não):");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }while (!calcularOutraMedia.equals("sim") && !calcularOutraMedia.equals("não"));
            if (calcularOutraMedia.equals("não")){
                System.out.println(">>>>Finalizando...");
                break;
            }

        }
    }

    public static void jogoAdvinhacao4(Scanner scanner,Random random) throws InterruptedException{
        int conTentativas = 0;
        int computador = random.nextInt(10)+1;
        while (true){
            int jogador = 0;
            while (true){
                System.out.print("Digite um número de 1 a 10:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=10){
                        conTentativas++;
                        break;
                    }else {
                        System.out.println("ERRO! Digite um número de 1 a 10.");
                    }
                }else {
                    System.out.println("ERRO! Digite um número real.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.println("PROCESSANDO...");
            Thread.sleep(600);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digite um número maior.");
                }else {
                    System.out.println("Digite um número menor.");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("Você venceu!!!");
                System.out.println("Você precisou de:"+conTentativas+" tentativas.");
                String jogarNovamente;
                do {
                    System.out.print("Quer jogar novamente?(sim/não):");
                    jogarNovamente = scanner.nextLine().trim().toLowerCase();
                }while (!jogarNovamente.equals("sim") && !jogarNovamente.equals("não"));
                if (jogarNovamente.equals("não")){
                    break;
                }else {
                    conTentativas=0;
                    computador= random.nextInt(10)+1;
                }
            }

        }
    }


    public static void calculandoMedia(Scanner scanner){
        float somaNotas = 0; int contNotas = 0;
        while (true){
            while (true){
                System.out.print("Digite uma nota:");
                if (scanner.hasNextFloat()){
                    float notas = scanner.nextFloat();
                    if (notas>=1 && notas<=10){
                        somaNotas+=notas;
                        contNotas++;
                    }else {
                        System.out.println("ERRO! Digite uma nota de 1 a 10.");
                        continue;
                    }
                }else {
                    System.out.println("ERRO! Digite um número real!!!");
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
                    System.out.println("A média:"+media);
                    break;
                }
            }
            String adicionarOutraNota;
            do {
                System.out.print("Deseja calcular outra média?(sim/não):");
                adicionarOutraNota = scanner.nextLine().trim().toLowerCase();
            }while (!adicionarOutraNota.equals("sim") && !adicionarOutraNota.equals("não"));
            if (adicionarOutraNota.equals("não")){
                System.out.println("Finalizando programa....");
                break;
            }
        }
    }

    public static void verificandoUmaExpressao(Scanner scanner){
        Stack<Character> pilha = new Stack<>();
        System.out.print("Digite uma expressão:");
        String expressaoNumerica = scanner.nextLine().trim().toLowerCase();
        for (char parenteses : expressaoNumerica.toCharArray()){
            if (parenteses=='('){
                pilha.push(parenteses);
            }else {
                if (parenteses==')'){
                    if (!pilha.isEmpty()){
                        pilha.pop();
                    }else {
                        System.out.println("Sua expressão está incorreta.");
                        return;
                    }
                }
            }
        }
        if (pilha.isEmpty()){
            System.out.println("Sua expressão está correta.");
        }else {
            System.out.println("Sua expressão está incorreta.");
        }
    }

    public static void jogoPedraPapelTesoura2(Scanner scanner, Random random) throws InterruptedException{
        int jogador = 0;
        while (true){
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
                        System.out.println("ERRO! Digite um número válido.");
                    }
                }else{
                    System.out.println("Digite um número real.");
                    scanner.next();
                }
            }
            System.out.println("PROCESSANDO...");
            Thread.sleep(600);
            int computador = random.nextInt(3)+1;
            System.out.println("Computador:"+computador);
            if (jogador==computador){
                System.out.println("JOGADOR:"+jogoPedraPapelTesoura(jogador)+" | COMPUTADOR:"+jogoPedraPapelTesoura(computador)+" |RESULTADO: EMPATE!!!");
            }else if (jogador==1 && computador==3 || jogador==2 && computador==1 || jogador==3 && computador==2){
                System.out.println("JOGADOR:"+jogoPedraPapelTesoura(jogador)+" | COMPUTADOR:"+jogoPedraPapelTesoura(computador)+" | RESULTADO: VOCê VENCEU!!!");
            }else {
                System.out.println("JOGADOR:"+jogoPedraPapelTesoura(jogador)+" | COMPUTADOR:"+jogoPedraPapelTesoura(computador)+" | RESULTADO: VOCÊ PERDEU!!!");
            }
            String jogarNovamente;
            scanner.nextLine();
            do {
                System.out.print("Quer jogar novamente?(sim/não):");
                jogarNovamente = scanner.nextLine().trim().toLowerCase();
            }while (!jogarNovamente.equals("não") && !jogarNovamente.equals("sim"));
            if (jogarNovamente.equals("não")){
                System.out.println("Finalizando programa...");
                break;
            }
        }

    }
    public static String jogoPedraPapelTesoura(int escolhas){
        switch (escolhas){
            case 1: return "PEDRA";
            case 2: return "PAPEL";
            case 3: return "TESOURA";
        }
        return "";
    }

    public static void analisandoArray(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int contNumeros = 0, posMaior = 0, posMenor = 0, maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        float soma = 0;
        for (int n=0;n<arrayNumeros.length;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número:");
                if (scanner.hasNextInt()){
                    arrayNumeros[n] = scanner.nextInt();
                    boolean numeroRepetido = false;
                    for (int r=0;r<n;r++){
                        if (arrayNumeros[r]==arrayNumeros[n]){
                            numeroRepetido = true;
                            break;
                        }
                    }
                    if (numeroRepetido){
                        System.out.println("Número repetido, adicione outro.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("ERRO!Digite um número real.");
                    scanner.next();
                }
            }
            if (arrayNumeros[n]>0){
                soma+=arrayNumeros[n];
                contNumeros++;
            }
            if (arrayNumeros[n]>maiorNumero){
                maiorNumero=arrayNumeros[n];
                posMaior=n;
            }
            if (arrayNumeros[n]<menorNumero){
                menorNumero=arrayNumeros[n];
                posMenor=n;
            }
        }
        float media = soma/contNumeros;
        System.out.println("A média:"+media);
        System.out.println("O maior da lista:"+maiorNumero+" | posição:"+posMaior);
        System.out.println("O menor da lista:"+menorNumero+" | posição:"+posMenor);
    }

    public static void listaReversa(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            System.out.print("Digite um valor:");
            if (scanner.hasNextInt()){
                int numeros = scanner.nextInt();
                if (lista.contains(numeros)){
                    System.out.println("Esse número já foi adicionado na lista, tente outro!");
                    break;
                }else {
                    lista.add(numeros);
                }
            }else {
                System.out.println("ERRO!Digite um número válido.");
                scanner.next();
            }
            scanner.nextLine();
            String continuar;
            do {
                System.out.print("Quer adicionar outro número?(sim/não):");
                continuar= scanner.nextLine().trim().toLowerCase();
            }while (!continuar.equals("sim") && !continuar.equals("não"));
            if (continuar.equals("não")){
                System.out.println("Finalizando a lista...");
                Collections.sort(lista);
                Collections.reverse(lista);
                System.out.println("A lista em ordem reversa:"+lista);
                break;
            }

        }



    }

    public static void avaliandoExpressao(Scanner scanner){
        Stack<Character> pilha = new Stack<>();
        System.out.print("Digite uma expressão:");
        String expressao = scanner.nextLine().trim().toLowerCase();
        for (char parenteses : expressao.toCharArray()){
            if (parenteses=='('){
                pilha.push(parenteses);
            }else {
                if (parenteses==')'){
                    if (!pilha.isEmpty()){
                        pilha.pop();
                    }else {
                        System.out.println("Sua expressão está incorreta.");
                        return;
                    }
                }
            }
        }
        if (pilha.isEmpty()){
            System.out.println("Sua expressão está correta.");
        }else {
            System.out.println("Sua expressão está incorreta.");
        }
    }


    public static void numeroPosicaoCorreta(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i=0;i<6;i++){
            while (true){
                System.out.print("Digite o "+(i+1)+"º número da lista:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (lista.contains(numeros)){
                        System.out.println("ERRO! Número já cadastrado.");
                    }else {
                        if (lista.isEmpty() || numeros >= lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos = 0;
                            while (pos < lista.size()){
                                if (numeros <= lista.get(pos)){
                                    lista.add(pos, numeros);
                                    System.out.println("Adicionado na posição:"+pos);
                                    break;
                                }
                                pos++;
                            }
                        }
                    }
                    break;
                }else {
                    System.out.println("DIGITE UM NÚMERO VÁLIDO.");
                }
            }
        }
        System.out.println("A lista:"+lista);
    }

    public static void jogoAdvinhacao3(Scanner scanner, Random random) throws InterruptedException{
        int contTentativas=0;
        int computador = random.nextInt(10)+1;
        while (true){
            int jogador = 0;
            while (true){
                System.out.print("Digite um número de 1 a 10:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=10){
                        contTentativas++;
                        break;
                    }else {
                        System.out.println("Digite um número válido de 1 a 10.");
                    }
                }else {
                    System.out.println("ERRO! Digite um número válido.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.println("PROCESSANDO....");
            Thread.sleep(600);
            if (jogador!=computador){
                if (jogador< computador){
                    System.out.println("Digite um número maior.");
                }else {
                    System.out.println("Digite um número menor.");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("Você acertou!!!!");
                System.out.println("Você precisou de:"+contTentativas+" tentativas.");
                String continuar;
                do {
                    System.out.print("Quer continuar(sim/não)?:");
                    continuar = scanner.nextLine().trim().toLowerCase();
                }while (!continuar.equals("sim") && !continuar.equals("não"));
                if (continuar.equals("não")){
                    System.out.println("Finalizando...");
                    break;
                }else {
                    contTentativas=0;
                    computador = random.nextInt(10)+1;
                }
            }
        }

    }

    public static void calculandoMediaDasNotas(Scanner scanner){
        while (true){
            int contNotas = 0;
            float notas = 0;
            float somaNotas = 0;
            while (true){
                System.out.print("Digite uma nota:");
                if (scanner.hasNextFloat()){
                    notas = scanner.nextFloat();
                    if (notas>=1 && notas<=10){
                        somaNotas+=notas;
                        contNotas++;
                    }else {
                        System.out.println("Digite uma nota de 1 a 10!");
                        continue;
                    }
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                    continue;
                }
                scanner.nextLine();
                String adicionarOutraNota;
                do {
                    System.out.print("Quer adicionar outra nota?(sim/não):");
                    adicionarOutraNota = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarOutraNota.equals("não") && !adicionarOutraNota.equals("sim"));
                if (adicionarOutraNota.equals("não")){
                    float mediaNotas =  somaNotas/contNotas;
                    System.out.println("Média notas:"+String.format("%.2f",mediaNotas));
                    break;
                }
            }
            String calcularOutraMedia;
            do {
                System.out.print("Quer calcular outra média?(sim/não):");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }while (!calcularOutraMedia.equals("sim") && !calcularOutraMedia.equals("não"));
            if (calcularOutraMedia.equals("não")){
                System.out.println(">>>Finalizando....");
                break;
            }

        }
    }


    public static void tabelBrasieirao2(Scanner scanner){
        String[] times = {
                "Botafogo", "Palmeiras", "Internacional", "Fortaleza", "Flamengo",
                "São Paulo", "Bahia", "Corinthians", "Cruzeiro", "Vasco da Gama",
                "Atlético-MG", "EC Vitória", "Juventude", "Grêmio", "Athletico-PR",
                "Fluminense", "Criciúma", "Bragantino", "Cuiabá", "Atlético-GO"
        };
        for (int i=0;i<250;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.print("A tabela do brasileirão:"+Arrays.toString(times));
        for (int i=0;i<250;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiros da tabela:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int i=0;i<250;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os quantro últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4,times.length)));
        for (int i=0;i<250;i++){
            System.out.print("=");
        }
        System.out.println();
        String[] timesOrdenados = times.clone();
        Arrays.sort(timesOrdenados);
        System.out.println("A lista de times em ordem alfabética:"+Arrays.toString(timesOrdenados));
        for (int i=0;i<250;i++){
            System.out.print("=");
        }
        System.out.println();
        int posicaoBragantino = 0;
        for (int p=0;p<times.length;p++){
            if (times[p].equals("Bragantino")){
                posicaoBragantino = p+1;
            }
        }
        System.out.println("O bragantino está na posição:"+posicaoBragantino);
        for (int i=0;i<250;i++){
            System.out.print("=");
        }
        System.out.println();
    }

    public static void jogoAdvinhacao2(Scanner scanner, Random random) throws InterruptedException {
        int computador = random.nextInt(10)+1;
        int contTentativas=0;
        while (true){
            int jogador = 0;
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
                    System.out.println("ERRO! Digite um número válido.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.println("PROCESSANDO...");
            Thread.sleep(600);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digite um número maior.");
                }else {
                    System.out.println("Digite um número menor.");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("VOCÊ ACERTOU!!!");
                System.out.println("Você precisou de:"+contTentativas+" para acertar.");
                String novaJogada;
                do {
                    System.out.print("Quer jogar novamente?(sim/não):");
                    novaJogada = scanner.nextLine().trim().toLowerCase();
                }while (!novaJogada.equals("sim") && !novaJogada.equals("não"));
                if (novaJogada.equals("não")){
                    System.out.println("Finalizando o jogo.");
                    break;
                }else {
                    contTentativas=0;
                }
            }
        }
    }


    public static void calculandoNotas(Scanner scanner){
        while (true){
            float soma = 0;
            int contNotas = 0;
            while (true){
                System.out.print("Digite um nota:");
                if (scanner.hasNextFloat()){
                    float notas = scanner.nextFloat();
                    if (notas>=1 && notas<=10){
                        soma+=notas;
                        contNotas++;
                    }else {
                        System.out.println("Digite uma nota de 1 a 10.");
                        continue;
                    }
                }else {
                    System.out.println("ERRO!Digite um número válido.");
                    scanner.next();
                    continue;
                }
                scanner.nextLine();
                String continuar;
                do {
                    System.out.print("Quer adicionar outra nota?(sim/não):");
                    continuar = scanner.nextLine().trim().toLowerCase();
                }while (!continuar.equals("não") && !continuar.equals("sim"));
                if (continuar.equals("não")){
                    float media = soma/contNotas;
                    System.out.println("A média:"+String.format("%.2f",media));
                    break;
                }
            }
            System.out.print("Quer calcular outra média?(sim/não):");
            String calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            while (!calcularOutraMedia.equals("sim") && !calcularOutraMedia.equals("não")){
                System.out.print("Digite apenas sim ou não:");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }
            if (calcularOutraMedia.equals("não")){
                System.out.println(">>Finalizando o programa...");
                break;
            }


        }

    }

    public static void adicionandoNumerosPosicaoCorreta(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int n=0;n<6;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número da lista:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (lista.contains(numeros)){
                        System.out.println("Número já adicionado na lista.");
                        continue;
                    }else {
                        if (lista.isEmpty() || numeros >= lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos = 0;
                            while (pos < lista.size()){
                                if (numeros <= lista.get(pos)){
                                    lista.add(pos, numeros);
                                    System.out.println("Adicionado na posição:"+pos);
                                    break;
                                }
                                pos++;
                            }
                        }
                    }
                    break;
                }else {
                    System.out.println("ERRO!Digite um valor real.");
                    scanner.next();
                }
            }
        }
        System.out.println("A lista:"+lista);
    }



    public static void listaReverse(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            int numeros = 0;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numeros = scanner.nextInt();
                    if (lista.contains(numeros)){
                        System.out.println("ERRO! Número repetido, tente outro.");
                    }else {
                        lista.add(numeros);
                        break;
                    }
                }else {
                    System.out.println("Digite um número válido.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            String adicionarNumero;
            do {
                System.out.print("Quer adicionar outro número?(sim/não):");
                adicionarNumero = scanner.nextLine().trim().toLowerCase();
            }while (!adicionarNumero.equals("sim") && !adicionarNumero.equals("não"));
            if (adicionarNumero.equals("não")){
                if (numeros>0){
                    Collections.sort(lista);
                    Collections.reverse(lista);
                    System.out.println("A lista em ordem reversa:"+lista);
                    break;
                }
            }


        }
    }

    public static void jogoPedraPapelTesoura(Scanner scanner, Random random) throws InterruptedException{
       int jogador = 0;
        while (true){
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            while (true){
                System.out.print("Digite uma das opções acima:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=10){
                        break;
                    }else {
                        System.out.println("ERRO!Digite uma das opções acima.");
                    }
                }else{
                    System.out.println("ERRO!Digite apenas números válidos.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.println("PROCESSANDO...");
            int computador = random.nextInt(3)+1;
            System.out.println("computador:"+computador);
            if (jogador==computador){
                System.out.println("JOGADOR:"+jogoJoKePo(jogador)+" | COMPUTADOR:"+jogoJoKePo(computador)+" | RESULTADO: DEU EMPATE!!!");
            } else if (jogador==1 && computador==3 || jogador==2 && computador==1 || jogador==3 && computador==2) {
                System.out.println("JOGADOR:"+jogoJoKePo(jogador)+" | COMPUTADOR:"+jogoJoKePo(computador)+" | RESUTALDO: VOCÊ VENCEU!!!");
            }else {
                System.out.println("JOGADOR:"+jogoJoKePo(jogador)+" | COMPUTADOR:"+jogoJoKePo(computador)+" | RESULTADO: VOCÊ PERDEU!!!");
            }
            String continuar;
            do {
                System.out.print("Quer jogar novamente?(sim/não):");
                continuar = scanner.nextLine().trim().toLowerCase();
            }while (!continuar.equals("sim") && !continuar.equals("não"));
            if (continuar.equals("não")){
                System.out.println("Finalizando o jogo...");
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


    public static void analisandoExpressao(Scanner scanner){
        Stack<Character> pilhaParenteses = new Stack<>();
        System.out.print("Digite uma expressão:");
        String expressao = scanner.nextLine().trim().toLowerCase();
        for (char parenteses : expressao.toCharArray()){
            if (parenteses=='('){
                pilhaParenteses.push(parenteses);
            }else {
                if (parenteses==')'){
                    if (!pilhaParenteses.isEmpty()){
                        pilhaParenteses.pop();
                    }else {
                        System.out.println("Sua expressão está incorreta.");
                    }
                }
            }
        }
        if (pilhaParenteses.isEmpty()){
            System.out.println("Su expressão está correta.");
        }else {
            System.out.println("Sua expressão está incorreta.");
        }
    }


    public static void jogoAdvinhacao(Scanner scanner, Random random) throws InterruptedException{
        int computador = random.nextInt(10)+1;
        int contJogadas = 0;
        while (true){
            int jogador=0;
            while (true){
                System.out.print("Digite um número de 1 a 10:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=10){
                        contJogadas++;
                        break;
                    }else {
                        System.out.println("Digite um número de 1 a 10 para continuar.");
                    }
                }else {
                    System.out.println("Digite um número verdadeiro.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.println("PROCESSANDO...");
            Thread.sleep(600);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digite um número maior.");
                }else {
                    System.out.println("Digite um número menor.");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("VOCÊ ACERTOU!!!");
                System.out.println("Você precisou de:"+contJogadas+" para acertar.");
                String continuar;
                do {
                    System.out.print("Quer continuar?(sim//não):");
                    continuar = scanner.nextLine().trim().toLowerCase();
                }while (!continuar.equals("sim") && !continuar.equals("não"));
                if (continuar.equals("não")){
                    System.out.println("finalizando jogo...");
                    break;
                }else {
                    contJogadas=0;
                }
            }
        }
    }

    public static void calculandoMediaNotas(Scanner scanner){

        while (true){
            int contNotas =0; float somaNotas = 0;
            while (true){
                System.out.print("Digite uma nota:");
                if (scanner.hasNextFloat()){
                    float nota = scanner.nextFloat();
                    if (nota>=1 && nota<=10){
                        somaNotas+=nota;
                        contNotas++;
                    }else {
                        System.out.println("ERRO,digite uma nota entre 1 e 10.");
                        continue;
                    }
                }else {
                    System.out.println("ERRO, digite um número.");
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
                    System.out.println("Média:"+String.format("%.2f",media));
                    break;
                }
            }
            String calcularOutraMedia;
            do {
                System.out.print("Deseja calcular outra média?(sim/não):");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }while (!calcularOutraMedia.equals("sim") && !calcularOutraMedia.equals("não"));
            if (calcularOutraMedia.equals("não")){
                System.out.println(">>>Finalizando....");
                break;
            }
        }
    }

    public static void manipulandoNumeroArray(Scanner scanner){
        int[] arrayNumeros =new int[6];
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE, pMaior = 0, pMenor=0, soma=0, contNumeros=0;
        for (int n=0;n<arrayNumeros.length;n++){
            while (true){
                System.out.print("Digite "+(n+1)+"º número:");
                if (scanner.hasNextInt()){
                    arrayNumeros[n] = scanner.nextInt();
                    boolean numeroRepetido = false;
                    for (int i=0;i<n;i++){
                        if (arrayNumeros[i]==arrayNumeros[n]){
                            numeroRepetido = true;
                            break;
                        }
                    }
                    if (numeroRepetido){
                        System.out.println("ERRO! Número repetido, tente outro.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Digite um número válido.");
                    scanner.next();
                }
            }
            if (arrayNumeros[n]>0){
                soma+=arrayNumeros[n];
                contNumeros++;
            }
            if (arrayNumeros[n]>maiorNumero){
                    maiorNumero=arrayNumeros[n];
                    pMaior=n;
            }
            if (arrayNumeros[n]<menorNumero){
                menorNumero=arrayNumeros[n];
                pMenor=n;
            }
        }
        float media = (float) soma/contNumeros;
        System.out.println("A média:"+String.format("%.2f",media));
        System.out.println("O maior número:"+maiorNumero+" | posição:"+pMaior);
        System.out.println("O menor número:"+menorNumero+" | posição:"+pMenor);
    }

    public static void tabelBrasieirao(){
        String[] times = {
                "Botafogo", "Palmeiras", "Internacional", "Fortaleza", "Flamengo",
                "São Paulo", "Bahia", "Corinthians", "Cruzeiro", "Vasco da Gama",
                "Atlético-MG", "EC Vitória", "Juventude", "Grêmio", "Athletico-PR",
                "Fluminense", "Criciúma", "Bragantino", "Cuiabá", "Atlético-GO"
        };
        for (int i=0;i<250;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("A tabela do brasileirão:"+ Arrays.toString(times));
        for (int i=0;i<250;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiros da lista:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int i=0;i<250;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os quatro últimos da lista:"+Arrays.toString(Arrays.copyOfRange(times,times.length-4, times.length)));
        for (int i=0;i<250;i++){
            System.out.print("=");
        }
        System.out.println();
        String[] listaOrdenada = times.clone();
        Arrays.sort(listaOrdenada);
        System.out.println("A lista em ordem alfabética:"+Arrays.toString(listaOrdenada));
        for (int i=0;i<250;i++){
            System.out.print("=");
        }
        System.out.println();
        int posicaoBragatino = 0;
        for (int n=0;n<times.length;n++){
            if (times[n].equals("Bragantino")){
                posicaoBragatino = n+1;
            }
        }
        System.out.println("A posição do Bragantino:"+posicaoBragatino);
        for (int i=0;i<250;i++){
            System.out.print("=");
        }
        System.out.println();
    }

    public static void analisandoFraseLetraAMetodo2(Scanner scanner){
        int contagem=0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (char letras : frase.toCharArray()){
            if ("a".indexOf(letras)!=-1){
                contagem++;
            }
        }
    }

    public static void arrayNomesSeparandoAsVogais(){
        String[] arrayNomes = {"maria","pedro","jonas","fernando","ana","joana"};
        for (String nomes : arrayNomes){
            System.out.print("\nNo nome:"+nomes+" temos as vogais:");
            for (char letras : nomes.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(letras))!=-1){
                    System.out.print(letras+" ");
                }
            }
        }
    }


    public static void analisandoFraseLetraA(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine();
        for (int i=0;i< frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu:"+contagem+" vezes.");
        int primeiroA = frase.indexOf("a");
        int ultimoA = frase.lastIndexOf("a");
        if (primeiroA>0 && ultimoA>0){
            System.out.println("A letra A apareceu pela primera vez na posição:"+primeiroA);
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu na frase.");
        }
    }

}
