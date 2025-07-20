package academy.devdojo.maratonajava.introducao;


import java.util.*;

public class Aula7ArraysExercicios9 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        //        calculando media
        calculandoMediaNotas(scanner);

        //        jogo pedra, papel e tesoura
        jogoPedraPapelTesoura(scanner,random);

//        jogo do Adivinha
        jogoDoAdvinha(scanner,random);



//        lista invertida
        listaInvertida(scanner);




//        verificando uma expressão
        verificandoExpressao(scanner);

        //        verificando o maior e o menor, media de um array
        verificandoNumerosArray(scanner);

        //        analisando a frase
        analisandoFrase(scanner);

//        analisando frase
        contandoLetraA(scanner);

//        manipulando um array
        manipulandoArrayNumeros(scanner);

        // posicionamento na lista
        adicionandoLista(scanner);


//        manipulando um array
        manipulandoArray(scanner);




//        verificando numeros e posições
        verificandoNumerosEposicoes(scanner);

//        analisandoExpressao
        analisandoExpressao(scanner);



//        analisando a tabela do brasileirão
        tabelaBrasileirao();

//        verificando nome
        verificandoNome(scanner);

//        verificando frase, metodo 2
        verificandoAmetodoDois(scanner);

//      verificando as vogais de uma arrray
        verificandoArray();


        scanner.close();
    }

    public static void contandoLetraA(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (char letras : frase.toCharArray()){
            if ("a".indexOf(letras)!=-1){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu:"+contagem+" vezes.");
    }


    public static void manipulandoArrayNumeros(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int soma = 0, contNumeros = 0, posMaior=0, posMenor=0;
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        for (int n=0;n<arrayNumeros.length;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número:");
                if (scanner.hasNextInt()){
                    arrayNumeros[n] = scanner.nextInt();
                    boolean numeroRepetido = false;
                    for (int i=0;i<n;i++){
                        if (arrayNumeros[n]==arrayNumeros[i]){
                            numeroRepetido =true;
                            break;
                        }
                    }
                    if (numeroRepetido){
                        System.out.println("ERRO!Número repetido, digite outro!!!");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("ERRO!Digite um número válido.");
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
        float media = (float) soma/contNumeros;
        System.out.println("A média:"+String.format("%.2f",media));
        System.out.println("O maior da lista:"+maiorNumero+" | Está na posição:"+posMaior);
        System.out.println("O menor da lista:"+menorNumero+" | Está na posição:"+posMenor);
    }

    public static void adicionandoLista(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int n=0;n<6;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número da lista:");
                if (scanner.hasNextInt()){
                    int numero = scanner.nextInt();
                    if (lista.contains(numero)){
                        System.out.println("ERRO!Número já adicionado na lista, tente outro.");
                        continue;
                    }else {
                        if (lista.isEmpty() || numero >= lista.get(lista.size()-1)){
                            lista.add(numero);
                            System.out.println("Adicionado no final da lista");
                        }else {
                            int pos = 0;
                            while (pos< lista.size()){
                                if (numero <= lista.get(pos)){
                                    lista.add(pos, numero);
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
        System.out.println("sua lista:"+lista);
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

    public static void manipulandoArray(Scanner scanner){
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        int soma = 0, contNumeros = 0, posMaior = 0, posMenor = 0;
        int[] arrayNumeros = new int[6];
        for (int n=0;n<arrayNumeros.length;n++){
            while (true) {
                System.out.print("Digite o " + (n + 1) + "º número:");
                if (scanner.hasNextInt()) {
                    arrayNumeros[n] = scanner.nextInt();
                    boolean numeroRepetido = false;
                    for (int i = 0; i < n; i++) {
                        if (arrayNumeros[n] == arrayNumeros[i]) {
                            numeroRepetido = true;
                            break;
                        }
                    }
                    if (numeroRepetido) {
                        System.out.println("ERRO! NUMERO REPETIDO...");
                    } else {
                        break;
                    }
                }else {
                    System.out.println("ERRO. Digite um número válido.");
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
        float media = (float) soma/contNumeros;
        System.out.println("A média:"+String.format("%.2f",media));
        System.out.println("Maior número:"+maiorNumero+" na posição:"+posMaior);
        System.out.println("Menor número:"+menorNumero+" na posição:"+posMenor);
    }

    public static void jogoPedraPapelTesoura(Scanner scanner, Random random) throws InterruptedException{
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
                        System.out.println("ERRO! Digite uma das opções acima.");
                    }
                }else {
                    System.out.println("ERRO! Digite uma das opções acima.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.println(">>>PROCESSANDO....");
            Thread.sleep(600);
            int computador = random.nextInt(3)+1;
            System.out.println("Computador:"+computador);
            if (jogador==computador){
                System.out.println("Jogador:"+jogoJoKenPo(jogador)+" | Computador:"+jogoJoKenPo(computador)+" | Resultado: EMPATE!!!");
            } else if (jogador==1 && computador==3 ||
                        jogador==2 && computador==1 ||
                        jogador==3 && computador==2) {
                System.out.println("Jogador:"+jogoJoKenPo(jogador)+" | Computador:"+jogoJoKenPo(computador)+" | Resultado: VOCÊ VENCEU!!!");
            }else {
                System.out.println("jogador:"+jogoJoKenPo(jogador)+" | Computador:;"+jogoJoKenPo(computador)+" | Resultado: VOCÊ PERDEU!!!");
            }
            String continuar;
            do {
                System.out.print("Quer continuar?(sim/não):");
                continuar = scanner.nextLine().trim().toLowerCase();
            }while (!continuar.equals("sim") && !continuar.equals("não"));
            if (continuar.equals("não")){
                System.out.println(">>>Finalizando o jogo....");
                break;
            }
        }
    }
    public static String jogoJoKenPo(int escolha){
        switch (escolha){
            case 1: return "PEDRA";
            case 2: return "PAPEL";
            case 3: return "TESOURA";
        }
        return "";
    }


    public static void listaInvertida(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (lista.contains(numeros)){
                        System.out.println("ERRO! Número já incerrido.");

                    }else {
                        lista.add(numeros);
                        break;
                    }
                }else {
                    System.out.println("Digite um número válido!!!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            String adicionarOutrNumero;
            do {
                System.out.print("Quer adicionar outro número?(sim/não):");
                adicionarOutrNumero = scanner.nextLine().trim().toLowerCase();
            }while (!adicionarOutrNumero.equals("não") && !adicionarOutrNumero.equals("sim"));
            if (adicionarOutrNumero.equals("não")){
                System.out.println(">>>Finalizando a lista.");
                Collections.sort(lista);
                Collections.reverse(lista);
                System.out.println("A lista ao contrário:"+lista);
                break;
            }
        }
    }


    public static void verificandoNumerosEposicoes(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i=0;i<6;i++){
            while (true){
                System.out.print("Digite o "+(i+1)+"º número:");
                if (scanner.hasNextInt()){
                    int numero = scanner.nextInt();
                    if (lista.contains(numero)){
                        System.out.println("ERRO! Número já consta na lista. Digite outro.");
                        continue;
                    }else {
                        if (lista.isEmpty() || numero >= lista.get(lista.size()-1)){
                            lista.add(numero);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos=0;
                            while (pos< lista.size()){
                                if (numero <= lista.get(pos)){
                                    lista.add(pos,numero);
                                    System.out.println("Adicionado na posição:"+pos);
                                    break;
                                }
                                pos++;
                            }
                        }
                    }
                    break;
                }else {
                    System.out.println("Digite um número válido.");
                }
            }
        }
        System.out.println("A lista ficou:"+lista);
    }

    public static void analisandoExpressao(Scanner scanner){
        Stack<Character> pilhaParenteses =new Stack<>();
        System.out.print("Digite uma expressão:");
        String expressao = scanner.nextLine().trim().toLowerCase();
        for(char parenteses : expressao.toCharArray()){
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

    public static void jogoDoAdvinha(Scanner scanner, Random random) throws InterruptedException{
        int jogador = 0;
        int contTentativas=0;
        int computador = random.nextInt(10)+1;
        while (true){
            while (true){
                System.out.print("Digite um número de 1 a 10:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador>=1 && jogador<=10){
                        contTentativas++;
                        break;
                    }else {
                        System.out.println("ERRO!!!Digite um número entre 1 e 10.");
                    }
                }else {
                    System.out.println("Digite um número válido.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.println("PROCESSANDO....");
            Thread.sleep(600);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digite um número maior.");
                }else {
                    System.out.println("Digite um número menor.");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("Você acertou!!!");
                System.out.println("Você precisou de: "+contTentativas+" tentativas parar acertas.");
                String continuar;
                do {
                    System.out.print("Quer continuar?(sim/não):");
                    continuar = scanner.nextLine().trim().toLowerCase();
                }while (!continuar.equals("sim") && !continuar.equals("não"));
                if (continuar.equals("não")){
                    System.out.println(">>>>Finalizando o programa...");
                    break;
                }else {
                    contTentativas=0;
                }
            }
        }
    }

    public static void calculandoMediaNotas(Scanner scanner){
        float soma = 0; int contNotas=0;
        while (true){
            while (true){
                System.out.print("Digite uma nota:");
                if (scanner.hasNextFloat()){
                    float notas = scanner.nextFloat();
                    if (notas>=1 && notas<=10){
                        contNotas++;
                        soma+=notas;
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
                String continuar;
                do {
                    System.out.print("Quer continuar?(sim/não):");
                    continuar = scanner.nextLine().trim().toLowerCase();
                }while (!continuar.equals("não") && !continuar.equals("sim"));
                if (continuar.equals("não")){
                    break;
                }
            }
            float media = soma/contNotas;
            System.out.println("A média:"+String.format("%.2f",media));
            String calcularOutraMedia;
            do {
                System.out.print("Quer calcular outra média:");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }while (!calcularOutraMedia.equals("sim") && !calcularOutraMedia.equals("não"));
            if (calcularOutraMedia.equals("não")){
                System.out.println(">>>Finalizando o programa...");
                break;
            }
        }
    }


    public static void verificandoNumerosArray(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        int posMaior = 0, posMenor = 0, soma=0, contNumeros=0;
        for (int i=0;i<arrayNumeros.length;i++){
            while (true){
                System.out.print("Digite o "+(i+1)+"º número:");
                if (scanner.hasNextInt()){
                    arrayNumeros[i] = scanner.nextInt();
                    boolean numeroRepetido = false;
                    for (int r=0;r<i;r++){
                        if (arrayNumeros[i]==arrayNumeros[r]){
                            numeroRepetido =true;
                            break;
                        }
                    }
                    if (numeroRepetido){
                        System.out.println("NÚMERO REPETIDO, Digite outro número.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("ERRO! Digite um número verdadeiro.");
                    scanner.next();
                }
            }
            if (arrayNumeros[i]>0){
                soma+=arrayNumeros[i];
                contNumeros++;
            }
            if (arrayNumeros[i]> maiorNumero){
                maiorNumero=arrayNumeros[i];
                posMaior= i;
            }
            if (arrayNumeros[i]<menorNumero){
                menorNumero= arrayNumeros[i];
                posMenor= i;
            }
        }
        float media = (float) soma/contNumeros;
        System.out.println("A média:"+String.format("%.2f",media));
        System.out.println("O maior da lista:"+maiorNumero+" e está na posição:"+posMaior);
        System.out.println("O menor da lista:"+menorNumero+" e está na posição:"+posMenor);
    }

    public static void tabelaBrasileirao(){
        String[] times ={
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
        System.out.println("Os cinco primeiros da tabela:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os 4 últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4, times.length)));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        String[] tabelaInvertida = times.clone();
        Arrays.sort(tabelaInvertida);
        System.out.println("A tabela em ordem alfabética:"+Arrays.toString(tabelaInvertida));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        int posicaoBragantino =0;
        for (int p=0;p<times.length;p++){
            if (times[p].equals("Bragantino")){
                posicaoBragantino = p+1;
            }
        }
        System.out.println("O Bragantino está na posição:"+posicaoBragantino);
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();

    }

    public static void verificandoNome(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine().trim().toLowerCase();
        String[] arrayNome = nomeCompleto.split(" ");
        System.out.println("O seu primeiro nome:"+arrayNome[0]);
        System.out.println("O seu último nome:"+arrayNome[arrayNome.length-1]);
        System.out.println("O seu nome completo em letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("O seu nome completo em letras maiusculas:"+nomeCompleto.toUpperCase());
        System.out.println("O seu primeiro nome tem:"+arrayNome[0].length());
        System.out.println("O seu último nome tem:"+arrayNome[arrayNome.length-1].length());
        System.out.println("O seu nome completo tem:"+nomeCompleto.replace(" ","").length());
    }


    public static void verificandoAmetodoDois(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (char letras : frase.toCharArray()){
            if ("a".indexOf(letras)!=-1){
                contagem++;
                System.out.println("A letra A apareceu:"+contagem+" vezes");
            }
        }
    }


    public static void verificandoArray(){
        String[] arrayNomes = {"maria","pedro","joana","fernando","marta"};
        for (String nomes : arrayNomes){
            System.out.print("\nNo nome:"+nomes+" as vogais são:");
            for (char letras : nomes.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(letras))!=-1){
                    System.out.print(letras+" ");
                }
            }
        }
    }


    public static void analisandoFrase(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (int i=0;i<frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu na frase:"+contagem+" vezes.");
        int primeiroA = frase.indexOf("a");
        int ultimoA = frase.lastIndexOf("a");
        if (primeiroA>0 && ultimoA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
            System.out.println("O último A apareceu pela última vez na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu na frase!");
        }
    }

}
