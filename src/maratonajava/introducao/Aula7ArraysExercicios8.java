package academy.devdojo.maratonajava.introducao;




import java.util.*;
import java.util.Collections;

public class Aula7ArraysExercicios8 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


//        jogo pedra, papel e tesoura
        jogoPedraPapelTesoura(scanner, random);


        //        lista com posição dos números
        listaPosicaoNumeros(scanner);

        //        jogo advinhação
        jogoDaAdvinhacao(scanner,random);


        //        calculando a media
        calculandoMedia(scanner);

//        verificando um arrayNumeros
        verificandoArrayNumeros(scanner);

//invertendo a lista
        invertendoALista(scanner);

//        tabela brasileirao
        verificandoTabelaBrasileirao(scanner);

//        maior, menor e media, posicao do maior e menor em um array
        manipulandoUmArray(scanner);

//        verificando expressão
        verificandoExpressao(scanner);

//        adicionando na lista e posicionando
        posicionandoNaLista(scanner);


//        calculando a media
        calculandoMediaNotas(scanner);

//        tabela Brasileirão
        anaisandoTabelaBrasileirao(scanner);

//     lista invertida
        listaInvertida(scanner);

// analisando Numeros de um Array
        analisandoNumerosArray(scanner);


//        outra forma de encontrar letras
        verificandoFraseModo2(scanner);

        //verificando a frase
        analisandoFrase(scanner);

//        posicao numeros na lista
        posicaoNumerosNaLista(scanner);

//        verificando a tabela do brasileirao
        tabelaDoBrasileirao();

//        avaliando expressao
        avaliandoExpressao(scanner);

        //        INVERTENDO LISTA
        invertendoLista (scanner);



//        verificando uma expressão
        verificandoUmaExpressao(scanner);

//        jogo Advinhação
        jogoAdvinhacao(scanner,random);



        //        verificar o maior, menor, media e quantidade de numeros de um array
        verificandoArray(scanner);

//        analisando tabela do brasileirao
        tabelaBrasileirao();

//        analisando nome
        analisandoNome(scanner);

//letra A metodo 2 de separar;
        separandoletraA(scanner);

//        verificando as vogais das palavras
        vogaisPalavrasa(scanner);

//      verificando letra A na frase
        separandoLetraAnaFrase(scanner);
        scanner.close();
    }


    public static void verificandoArrayNumeros(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        int soma = 0, posMaior = 0, posMenor=0;
        for (int n=0;n<arrayNumeros.length;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número:");
                if (scanner.hasNext()){
                    arrayNumeros[n] = scanner.nextInt();
                    boolean numeroRepedido = false;
                    for (int i=0;i<n;i++){
                        if (arrayNumeros[i]==arrayNumeros[n]){
                            numeroRepedido =true;
                            break;
                        }
                    }
                    if (numeroRepedido){
                        System.out.println("NÚMERO REPETIDO, Digite outro número.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Digite um número válido!!!");
                    scanner.next();
                }
            }
            if (arrayNumeros[n]>0){
                soma+=arrayNumeros[n];
            }
            if (arrayNumeros[n]>maiorNumero){
                maiorNumero=arrayNumeros[n];
                posMaior = n;
            }
            if (arrayNumeros[n]<menorNumero)
                menorNumero=arrayNumeros[n];
            posMenor = n;
        }
        float media = (float) soma/ arrayNumeros.length;
        System.out.println("O maior da lista:"+maiorNumero+" | Está na posição:"+posMaior);
        System.out.println("O menor da lista:"+menorNumero+" | está na posição:"+posMenor);
        System.out.println("A média:"+String.format("%.2f",media));
    }

    public static void invertendoALista(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i=0;i<6;i++){
            while (true){
                System.out.print("Digite o "+(i+1)+"º número:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (!lista.contains(numeros)){
                        lista.add(numeros);
                        break;
                    }else {
                        System.out.println("Número repetido, digite outro.");
                    }
                }else {
                    System.out.println("ERRO! Digite um número verdadeiro.");
                }
            }
        }
        Collections.sort(lista);
        Collections.reverse(lista);
        System.out.println("A lista em ordem contrário é:"+lista);
    }


    public static void verificandoTabelaBrasileirao(Scanner scanner){
        String[] times = {
                "Botafogo", "Palmeiras", "Internacional", "Fortaleza", "Flamengo",
                "São Paulo", "Bahia", "Corinthians", "Cruzeiro", "Vasco da Gama",
                "Atlético-MG", "EC Vitória", "Juventude", "Grêmio", "Athletico-PR",
                "Fluminense", "Criciúma", "Bragantino", "Cuiabá", "Atlético-GO"
        };
        for (int n=0;n<200;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("A tabela do brasileira:"+Arrays.toString(times));
        for (int n=0;n<200;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiros colocados:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int n=0;n<200;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os quatro últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4,times.length)));
        for (int n=0;n<200;n++){
            System.out.print("=");
        }
        System.out.println();
        String[] tabelaOrdenada = times.clone();
        Arrays.sort(tabelaOrdenada);
        System.out.println("A tabela em ordem alfabética:"+Arrays.toString(tabelaOrdenada));
        for (int n=0;n<200;n++){
            System.out.print("=");
        }
        System.out.println();
        int posicaoBragantino = 0;
        for (int i=0;i< times.length;i++){
            if (times[i].equals("Bragantino")){
                posicaoBragantino = i+1;
            }
        }
        System.out.println("O Bragantino está na posição:"+posicaoBragantino);
        for (int n=0;n<200;n++){
            System.out.print("=");
        }
        System.out.println();
    }

    public static void manipulandoUmArray(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        int soma = 0, posMaior = 0, posMenor = 0;
        for (int n=0;n<arrayNumeros.length;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número:");
                if (scanner.hasNextInt()){
                    arrayNumeros[n] = scanner.nextInt();
                    boolean numeroRepetido = false;
                    for (int i=0;i<n;i++){
                        if (arrayNumeros[i]==arrayNumeros[n]){
                            numeroRepetido=true;
                            break;
                        }
                    } if (numeroRepetido){
                        System.out.println("Digite um número inédito.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("ERRO! Digite um número válido.");
                }
            }
            if (arrayNumeros[n]>0){
                soma+=arrayNumeros[n];
            }
            if (arrayNumeros[n]> maiorNumero){
                maiorNumero=arrayNumeros[n];
                posMaior = n;
            }
            if (arrayNumeros[n]<menorNumero){
                menorNumero=arrayNumeros[n];
                posMenor= n;
            }
        }
        float media = (float) soma/ arrayNumeros.length;
        System.out.println("O maior Número foi:"+maiorNumero+" e está na posição:"+posMaior);
        System.out.println("O menor número foi:"+menorNumero+" e está na posição:"+posMenor);
        System.out.println("A média:"+String.format("%.2f",media));
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
            System.out.println("Sua expressão está correta!");
        }else {
            System.out.println("Sua expressão está incorreta.");
        }
    }

    public static void posicionandoNaLista(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int n=0;n<6;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (!lista.contains(numeros)){
                        if (lista.isEmpty() || numeros>= lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos=0;
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
                    }else {
                        System.out.println("Essse número já foi adicionado na lista.");
                    }
                }else {
                    System.out.println("ERRO! Digite um número real.");
                }
            }
        }
        System.out.println("A sua lista ficou assim:"+lista);
    }

    public static void jogoPedraPapelTesoura(Scanner scanner, Random random)throws InterruptedException{
        while (true){
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            int jogador = 0;
            while (true){
                System.out.print("Digite uma das opções acima:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=3){
                        break;
                    }else {
                        System.out.println("Digite uma opção válida.");
                    }
                }else {
                    System.out.println("Digite apenas Números!!!");
                    scanner.next();
                }
            }
            System.out.println(">>>PROCESSANDO.....");
            Thread.sleep(600);
            int computador = random.nextInt(3)+1;
            System.out.println("Computador:"+computador);
            if (jogador==computador){
                System.out.println("Jogador:"+PedraPepelTesoura(jogador)+" | Computador:"+PedraPepelTesoura(computador)+" |Resultado:DEU EMPATE!!!");
            } else if (jogador==1 && computador==3 || jogador==2 && computador==1 || jogador==3 && computador==2){
                System.out.println("Jogador:"+PedraPepelTesoura(jogador)+" | Computador:"+PedraPepelTesoura(computador)+" | Resultado: VOCÊ VENCEU!!!!");
            }else {
                System.out.println("Jogador:"+PedraPepelTesoura(jogador)+" | Computador:"+PedraPepelTesoura(computador)+" | Resultado: VOCÊ PERDEU!!!");
            }
            for (int i=0;i<200;i++){
                System.out.print("=");
            }
            System.out.println();
            String jogarNovamente;
            scanner.nextLine();
            do {
                System.out.print("Quer jogar novamente?(sim/não):");
                jogarNovamente = scanner.nextLine().trim().toLowerCase();
            }while (!jogarNovamente.equals("não") && !jogarNovamente.equals("sim"));
            if (jogarNovamente.equals("não")){
                System.out.println("Finalizando o programa...");
                break;
            }
        }
    }
    public static String PedraPepelTesoura(int escolha){
        switch (escolha){
            case 1: return "PEDRA";
            case 2: return "PAPEL";
            case 3: return "TESOURA";
        }
        return"";
    }


    public static void jogoDaAdvinhacao(Scanner scanner, Random random) throws InterruptedException{
        int computador= random.nextInt(10)+1;
        int jogador = 0;
        int contJogadas = 0;
        while (true){
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=10){
                        contJogadas++;
                        break;
                    }else {
                        System.out.println("Digite um número válido de 1 a 10.");
                    }
                }else {
                    System.out.println("ERRO! Digite um número válido!!!");
                    scanner.next();
                }
            }

            System.out.println("PROCESSANDO....");
            Thread.sleep(700);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digite um número maior.");
                }else {
                    System.out.println("Digite um número menor.");
                }
            }else {
                System.out.println("Você acertou!!! Parabéns!!!");
                System.out.println("Você precisou de:"+contJogadas+" tentativas para acertar");
                scanner.nextLine();
                String continuar;
                do {
                    System.out.print("Quer continuar?(sim/não):");
                    continuar = scanner.nextLine().trim().toLowerCase();
                }while (!continuar.equals("sim") && !continuar.equals("não"));
                if (continuar.equals("não")){
                    System.out.println(">>>>Finalizando o programa....");
                    break;
                }else {
                    contJogadas=0;
                }
            }
        }

    }

    public static void calculandoMediaNotas(Scanner scanner){
        float soma = 0;
        int contNumeros =0;
        while (true){
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextFloat()){
                    float notas = scanner.nextFloat();
                    if (notas>=1 && notas<=10){
                        soma+=notas;
                        contNumeros++;
                    }else {
                        System.out.println("ERRO! Digite uma nota entre 1 e 10.");
                        continue;
                    }
                }else {
                    System.out.println("Digite um número válido!!!");
                    scanner.next();
                    continue;
                }
                scanner.nextLine();
                String outroNumero;
                do {
                    System.out.print("Quer adicionar outra nota?(sim/não):");
                    outroNumero = scanner.nextLine().trim().toLowerCase();
                }while (!outroNumero.equals("não") && !outroNumero.equals("sim"));
                if (outroNumero.equals("não")){
                    float media = soma/contNumeros;
                    System.out.println("A média:"+media);
                    break;
                }
            }
            String outraMedia;
            do {
                System.out.print("Quer adicionar outra média?(sim/não):");
                outraMedia = scanner.nextLine().trim().toLowerCase();
            }while (!outraMedia.equals("sim")  && !outraMedia.equals("não"));
            if (outraMedia.equals("não")){
                System.out.println("Finalizando o programa...");
                break;
            }
        }
    }

    public static void anaisandoTabelaBrasileirao(Scanner scanner){
        String[] times ={
                "Botafogo", "Palmeiras", "Internacional", "Fortaleza", "Flamengo",
                "São Paulo", "Bahia", "Corinthians", "Cruzeiro", "Vasco da Gama",
                "Atlético-MG", "EC Vitória", "Juventude", "Grêmio", "Athletico-PR",
                "Fluminense", "Criciúma", "Bragantino", "Cuiabá", "Atlético-GO"
        };
        for (int n=0;n<200;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("A tabela do brasileirão:"+Arrays.toString(times));
        for (int n=0;n<200;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiros da tabela:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int n=0;n<200;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os quatro últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4,times.length)));
        for (int n=0;n<200;n++){
            System.out.print("=");
        }
        System.out.println();
        String[] tabelaOrdenada = times.clone();
        Arrays.sort(tabelaOrdenada);
        System.out.println("A tabela em ordem alfabética:"+Arrays.toString(tabelaOrdenada));
        for (int n=0;n<200;n++){
            System.out.print("=");
        }
        System.out.println();
        int posicaoBragantino = 0;
        for (int p=0;p<times.length;p++){
            if (times[p].equals("Bragantino")){
                posicaoBragantino=p+1;
            }
        }
        System.out.println("A posição do bragantino:"+posicaoBragantino);
        for (int n=0;n<200;n++){
            System.out.print("=");
        }
        System.out.println();
    }

    public static void listaInvertida(Scanner scanner){
        ArrayList<Integer> lista =new ArrayList<>();
        while (true){
            int numero = 0;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numero = scanner.nextInt();
                    if (!lista.contains(numero)){
                        lista.add(numero);
                    }else {
                        System.out.println("Erro! Número já adcionado na lista, tente outro.");
                        continue;
                    }
                    break;
                }else {
                    System.out.println("ERRO! Digite um número verdadeiro.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            String continuar;
            do {
                System.out.print("Quer continuar?(sim/não):");
                continuar = scanner.nextLine().toLowerCase().trim();
            }while (!continuar.equals("sim") && !continuar.equals("não"));
            if (continuar.equals("não")){
                Collections.sort(lista, Collections.reverseOrder());
                System.out.println("A lista invertida ficou:"+lista);
                break;
            }
        }
    }

    public static void analisandoNumerosArray(Scanner scanner){
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        int soma = 0, cont=0, posMaior = 0, posMenor=0;
        int[] arrayNumero = new int[6];
        for (int i=0;i<arrayNumero.length;i++){
            while (true){
                System.out.print("Digite o "+(i+1)+"º número:");
                if (scanner.hasNextInt()){
                    int numero = scanner.nextInt();
                    boolean numeroRepetido = false;
                    for (int r=0;r<i;r++){
                        if (arrayNumero[r]==numero){
                            numeroRepetido = true;
                            break;
                        }
                    }
                    if (numeroRepetido){
                        System.out.println("ERRO! Digite um número inédito.");
                    }else {
                        arrayNumero[i]=numero;
                        break;
                    }
                }else {
                    System.out.println("ERRO! Digite um número válido.");
                    scanner.next();
                }
            }
            if (arrayNumero[i]>0){
                soma+=arrayNumero[i];
                cont++;
            }
            if (arrayNumero[i]>maiorNumero){
                maiorNumero=arrayNumero[i];
                posMaior = i;
            }
            if (arrayNumero[i]< menorNumero){
                menorNumero=arrayNumero[i];
                posMenor=i;
            }

        }
        float media = (float) soma/cont;
        System.out.println("A média:"+String.format("%.2f",media));
        System.out.println("Maior da Lista:"+maiorNumero+" na posição:"+posMaior);
        System.out.println("Menor da lista:"+menorNumero+" nao posição:"+posMenor);
    }


    public static void verificandoFraseModo2(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (char letra : frase.toCharArray()){
            if ("a".indexOf(letra)!=-1){
                contagem++;
            }
        }
        System.out.println("Na frase:"+frase+" a letra A apareceu:"+contagem+" vezes");
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
        System.out.println("Na frase:"+frase+" a letra A apareceu:"+contagem);
        int primeiroA = frase.indexOf("a");
        int ultimoA = frase.lastIndexOf("a");
        if (primeiroA>0 && ultimoA >0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu na frase!");
        }
    }


    public static void posicaoNumerosNaLista(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int n=0;n<6;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número da lista:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (!lista.contains(numeros)){
                        if (lista.isEmpty() || numeros >= lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista!!!");
                        }else {
                            int pos=0;
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
                    }else {
                        System.out.println("Este número já foi adicionado na lista.");
                    }
                }else {
                    System.out.println("Digite um número válido!!!");
                    scanner.next();
                }
            }
        }
        System.out.println("A lista:"+lista);
    }


    public static void tabelaDoBrasileirao(){
        String[] times = {
                "Botafogo", "Palmeiras", "Internacional", "Fortaleza", "Flamengo",
                "São Paulo", "Bahia", "Corinthians", "Cruzeiro", "Vasco da Gama",
                "Atlético-MG", "EC Vitória", "Juventude", "Grêmio", "Athletico-PR",
                "Fluminense", "Criciúma", "Bragantino", "Cuiabá", "Atlético-GO"
        };
        for (int i=0;i<200;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.print("A tabela do brasileirão:"+Arrays.toString(times));
        for (int i=0;i<200;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiras colocados:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int i=0;i<200;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os 4 últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4,times.length)));
        for (int i=0;i<200;i++){
            System.out.print("=");
        }
        System.out.println();
        String[] timesOrdenados = times.clone();
        Arrays.sort(timesOrdenados);
        System.out.println("A lista de times em ordem alfabética:"+Arrays.toString(timesOrdenados));
        for (int i=0;i<200;i++){
            System.out.print("=");
        }
        System.out.println();
        for (int p=0;p<times.length;p++){
            if (times[p].equals("Bragantino")){
                System.out.println("O Bragantino está na posição:"+(p+1));
                break;
            }
        }
    }

    public static void avaliandoExpressao(Scanner scanner){
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
                        System.out.println("Sua expressão está incorreta!");
                        return;
                    }
                }
            }
        }
        if (pilhaParenteses.isEmpty()){
            System.out.println("Sua expressão está correta.");
        }else {
            System.out.println("Sua exoressão está incorreta.");
        }
    }


    public static void invertendoLista(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            int numero = 0;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numero = scanner.nextInt();
                     lista.add(numero);
                     break;
                }else {
                    System.out.println("Digite um número válido!!!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            String continuar;
            do {
                System.out.print("Quer adicionar outro número?(sim/não):");
                continuar = scanner.nextLine().trim().toLowerCase();
            }while (!continuar.equals("sim") && !continuar.equals("não"));
            if (continuar.equals("não")){
                break;
            }
        }
        Collections.sort(lista,Collections.reverseOrder());
        System.out.print("A lista ao contrário ficou:"+lista);

    }


    public static void listaPosicaoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int n=0;n<6;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (!lista.contains(numeros)){
                        if (lista.isEmpty() || numeros >= lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista!!!");
                        }else {
                            int pos = 0;
                            while (pos < lista.size()) {
                                if (numeros <= lista.get(pos)) {
                                    lista.add(pos, numeros);
                                    System.out.println("Adicionado na posição:" + pos);
                                    break;
                                }
                                pos++;
                            }
                        }
                        break;
                    }else {
                        System.out.println("ERRO! Número já adicionado na lista, tente outro!");
                    }
                }else {
                    System.out.println("Digite um número verdadeiro.");
                    scanner.next();
                }
            }
        }
        System.out.println("A lista:"+lista);
    }


    public static void verificandoUmaExpressao(Scanner scanner){
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
                        System.out.println("ERRO! Apenas número de 1 a 10.");
                    }
                }else {
                    System.out.println("Digite um número válido.");
                }
            }
            System.out.println("PROCESSANDO....");
            Thread.sleep(700);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digite um número maior!");
                }else {
                    System.out.println("Digite um número menor!");
                }
            }else {
                System.out.println("VOCÊ ACERTOU!!!");
                System.out.println("Você precisou de:"+contTentativas+" tentativas para acertar.");
                System.out.print("Quer jogar novamente?(sim/não):");
                String jogarNovamente = scanner.nextLine().trim().toLowerCase();
                while (!jogarNovamente.equals("não") && ! jogarNovamente.equals("sim")){
                    System.out.print("Digite apenas sim ou não:");
                    jogarNovamente = scanner.nextLine().trim().toLowerCase();
                }
                if (jogarNovamente.equals("não")){
                    System.out.println(">>>Finalizando o programa;;;");
                    break;
                }else {
                    contTentativas=0;
                }
            }
        }
    }

    public static void calculandoMedia(Scanner scanner){
        while (true){
            float soma =0;
            int contNotas = 0;
            while (true){
                System.out.print("Digite uma nota:");
                if (scanner.hasNextFloat()){
                    float notas = scanner.nextFloat();
                    if (notas>=1 && notas<=10){
                        soma+=notas;
                        contNotas++;
                    }else {
                        System.out.println("ERRO!Digite um número de 1 a 10.");
                        continue;
                    }
                }else {
                    System.out.println("Digite um número válido.");
                    scanner.next();
                    continue;
                }
                scanner.nextLine();
                System.out.print("Quer adicionar outra Nota?(sim/não):");
                String adicionarOutraNota = scanner.nextLine().trim().toLowerCase();
                while (!adicionarOutraNota.equals("não") && !adicionarOutraNota.equals("sim")){
                    System.out.print("Digite apenas sim ou não:");
                    adicionarOutraNota = scanner.nextLine().trim().toLowerCase();
                }
                if (adicionarOutraNota.equals("não")){
                    float media = soma/contNotas;
                    System.out.println("A sua média:"+String.format("%.2f",media));
                    break;
                }
            }
            System.out.print("Quer calcular outra média?(sim/não):");
            String outraMedia = scanner.nextLine().trim().toLowerCase();
            while (!outraMedia.equals("sim") && !outraMedia.equals("não")){
                System.out.print("Digite apenas sim ou não:");
                outraMedia = scanner.nextLine().trim().toLowerCase();
            }
            if (outraMedia.equals("não")){
                System.out.println(">>>Finalizando o programa...");
                break;
            }
        }
    }


    public static void verificandoArray(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        int soma = 0;
        int contNumeros = 0, posMaior = 0, posMenor =0;
        for (int i=0;i<arrayNumeros.length;i++){
            while (true){
                System.out.print("Digite o "+(i+1)+"º número:");
                if (scanner.hasNextInt()){
                    arrayNumeros[i] = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO! Digite um número real..");
                    scanner.next();
                }
            }
            if (arrayNumeros[i]>0){
                soma+=arrayNumeros[i];
                contNumeros++;
            }
            if (arrayNumeros[i]>maiorNumero){
                maiorNumero = arrayNumeros[i];
                posMaior = i;
            }
            if (arrayNumeros[i]< menorNumero){
                menorNumero = arrayNumeros[i];
                posMenor = i;
            }

        }
        float media = (float) soma/contNumeros;
        System.out.println("A soma dos números digitados:"+soma);
        System.out.println("A média:"+String.format("%.2f",media));
        System.out.println("O maior da lista:"+maiorNumero+" na posição:"+posMaior);
        System.out.println("O menor da lista:"+menorNumero+" na posição:"+posMenor);
    }


    public static void tabelaBrasileirao(){
        String[] times = {
                "Botafogo", "Flamengo", "Palmeiras", "São Paulo", "Atlético Mineiro",
                "Internacional", "Grêmio", "Santos", "Athletico Paranaense", "Fortaleza",
                "Ceará", "Vasco da Gama", "Bahia", "Goiás", "Cruzeiro", "Bragantino",
                "Coritiba", "Atlético Goianiense", "Fluminense", "Chapecoense"
        };
        for (int i=0;i<150;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("A tabela do brasileirão:"+ Arrays.toString(times));
        for (int i=0;i<150;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiros da tabela:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int i=0;i<150;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os quatro últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4, times.length)));
        for (int i=0;i<150;i++){
            System.out.print("=");
        }
        System.out.println();
        String[] timesOrdenados = times.clone();
        Arrays.sort(timesOrdenados);
        System.out.println("Os times em ordem altabética:"+Arrays.toString(timesOrdenados));
        for (int i=0;i<150;i++){
            System.out.print("=");
        }
        System.out.println();
        int posicaoChapecoase =0;
        for(int p=0;p<times.length;p++){
            times[p].indexOf("Chapecoense");
            posicaoChapecoase=p+1;
        }
        System.out.println("A chapecoense está na posição: "+posicaoChapecoase);
    }



    public static void analisandoNome(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto =scanner.nextLine();
        String[] arrayNome = nomeCompleto.split(" ");
        System.out.println("O seu primeiro nome é:"+arrayNome[0]);
        System.out.println("O seu último nome:"+arrayNome[arrayNome.length-1]);
        System.out.println("O segu nome completo em letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("O seu nome completo em letras maiusculas:"+nomeCompleto.toUpperCase());
        System.out.println("Seu primeiro nome tem:"+arrayNome[0].length()+" letras.");
        System.out.println("O seu último nome tem:"+arrayNome[arrayNome.length-1].length()+" letras");
        System.out.println("Seu nome completo tem:"+nomeCompleto.replace(" ","").length());
    }

    public static void separandoletraA(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (char letras : frase.toCharArray()){
            if ("a".indexOf(Character.toLowerCase(letras))!=-1){
                contagem++;
            }
        }
        System.out.println("Na frase:"+frase+" a letra A apareceu:"+contagem+" vezes.");
    }

    public static void vogaisPalavrasa(Scanner scanner){
        String[] arrayNomes = {"maria","joana","fernando","marta","pedro"};
        for (String nome : arrayNomes){
            System.out.print("\nNa palavra:"+nome+" temos as vogais:");
            for (char letras : nome.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(letras))!=-1){
                    System.out.print(letras+" ");
                }
            }
        }
    }


    public static void separandoLetraAnaFrase(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (int i=0;i<frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu:"+contagem+" vezes na frase.");
        int primeiroA = frase.indexOf("a");
        int ultimoA = frase.lastIndexOf("a");
        if (primeiroA >0 && ultimoA>0){
            System.out.println("Apareceu primeiro na posição:"+primeiroA);
            System.out.println("Apareceu por último na posição:"+ultimoA);
        } else {
            System.out.println("Não tivemos letra A na frase.");
        }
    }

}
