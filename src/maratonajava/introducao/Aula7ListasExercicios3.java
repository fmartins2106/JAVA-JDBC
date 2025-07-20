package academy.devdojo.maratonajava.introducao;


import java.util.Collections;
import java.util.*;

public class Aula7ListasExercicios3 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        analisando media de alunos
        analisandoMediaAlunos(scanner);

        // jogo da advinhação
        jogoAdvinhacao(scanner,random);


        //        verificando a frase com letra A
        verificandoLetraAnaFrase2(scanner);

//        tabela brasileirao
        tabelaBrasileirao2(scanner);

//        lista reversa
        listaReversa(scanner);

//        verificando par e impares
        verificandoParImpar(scanner);

//        verificando idade, maior e menor
        verificandoIdade(scanner);

//        jogo da lotofacil
        jogoLotofacil(scanner,random);

//        arrayNumeros
        analisandoArrayNumeros(scanner);

//        tabela brasileirão
        tabelaBrasileirao(scanner);



// calculando media
        calculandoMedia(scanner);



//        verificando letra A na frase
        verificandoLetraANaFrase(scanner);

//        caixa eletronico
        caixaEletronico(scanner);

//        montando lista e posições
        listaComPosicoes(scanner);

//        verificando expressao
        verificandoExpressao(scanner);

//verificando idade
        listaMaiorMenorIdade(scanner);

//        jogo loteria
        jogoMegaSena(scanner,random);

        //    lista, pares, impares
        listaParesImpares(scanner);
        scanner.close();
    }

    public static void analisandoMediaAlunos(Scanner scanner){
        ArrayList<Aluno> lista = new ArrayList<>();
        while (true){
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            float nota1=0;
            while (true){
                try {
                    System.out.print("Digite a primeira nota:");
                    nota1 = Float.parseFloat(scanner.nextLine());
                    if (nota1<=-1 || nota1>=11){
                        System.out.println("ERRO.Digite uma nota entre 0 e 10");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            float nota2 = 0;
            while (true){
                try {
                    System.out.print("Digite a segunda nota:");
                    nota2 = Float.parseFloat(scanner.nextLine());
                    if (nota2<=-1 || nota2>=11){
                        System.out.println("ERRO.Digite um número entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            float media = (nota2+nota1)/2;
            lista.add(new Aluno(nome, nota1,nota2,media));
            String adicionarMediaOutroAluno;
            do {
                System.out.print("Quer adicionar notas de outro aluno?(sim/não):");
                adicionarMediaOutroAluno = scanner.nextLine().trim().toLowerCase();
            }while (!adicionarMediaOutroAluno.equals("sim") && !adicionarMediaOutroAluno.equals("não"));
            if (adicionarMediaOutroAluno.equals("não")){
                break;
            }
        }
        for (int n=0;n<25;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-10s %-8s\n", "No", "Nome", "Média");
        for (int n=0;n<25;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            Aluno aluno = lista.get(i);
            System.out.printf("%-4s %-10s %.2f\n",i,aluno.getNome(),aluno.getMedia());
        }
        for (int n=0;n<25;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer mostrar nota de qual aluno?(digite 999 para parar.)");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println("Finalizando o programa...");
                break;
            }else {
                if (opc < lista.size()){
                    Aluno aluno = lista.get(opc);
                    System.out.printf("As notas de %s são: %.2f e %.2f\n",aluno.getNome(), aluno.getNota1(), aluno.getNota2());
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

        public String getNome() {
            return nome;
        }
        public float getNota1(){
            return nota1;
        }
        public float getNota2() {
            return nota2;
        }
        public float getMedia(){
            return media;
        }
    }


    public static void tabelaBrasileirao2(Scanner scanner){
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
        System.out.println("A classificação:"+ Arrays.toString(times));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();System.out.println("Os 5 primeiros da tabela:"+ Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os 4 últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4,times.length)));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        String[] listaOrdenada = times.clone();
        Arrays.sort(listaOrdenada);
        System.out.println("A lista em ordem alfabética:"+Arrays.toString(listaOrdenada));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        int posicaoBragantino=0;
        for (int i=0;i<times.length;i++){
            if (times[i].equals("Bragantino")){
                posicaoBragantino =i+1;
            }
        }
        System.out.println("A posição do Bragantino!:"+posicaoBragantino);
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
    }


    public static void listaReversa(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            System.out.print("Digite um número:");
            if (scanner.hasNextInt()){
                int numeros = scanner.nextInt();
                if (lista.contains(numeros)){
                    System.out.println("ERRO,número repetido, tente outro...");
                }else {
                    lista.add(numeros);
                }
                scanner.nextLine();
                String adicionar;
                do {
                    System.out.print("Quer adicionar outro número?:");
                    adicionar = scanner.nextLine().trim().toLowerCase();
                }while (!adicionar.equals("não") && !adicionar.equals("sim"));
                if (adicionar.equals("não")){
                    break;
                }
            }else {
                System.out.println("ERRO.Digite um número válido.");
                scanner.next();
            }
        }
        Collections.sort(lista,Collections.reverseOrder());
        System.out.println("A lista em ordem reversa:"+lista);
    }

    public static void verificandoParImpar(Scanner scanner){
        ArrayList<Integer> listaNumeros = addNumero(scanner);
        ArrayList<Integer> listaDePares = filtrandoPares(listaNumeros);
        ArrayList<Integer> listaDeImpares = filtrandoImpares(listaNumeros);
        System.out.println("Lista:"+listaNumeros);
        System.out.println("Lista de pares:"+listaDePares);
        System.out.println("Lista de impares:"+listaDeImpares);
    }
    public static ArrayList<Integer> addNumero(Scanner scanner){
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        while (true){
            System.out.print("Digite um número:");
            if (scanner.hasNextInt()){
                int numeros = scanner.nextInt();
                if (numeros<=-1){
                    System.out.println("ERRO, Digite um número positivo.");
                    continue;
                }else {
                    if (listaNumeros.contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
                        continue;
                    }else {
                        listaNumeros.add(numeros);
                    }
                }
                scanner.nextLine();
                String adicionarOutroNumero;
                do {
                    System.out.print("Quer adicionar outro número?(sim/não):");
                    adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarOutroNumero.equals("não") && !adicionarOutroNumero.equals("sim"));
                if (adicionarOutroNumero.equals("não")){
                    break;
                }
            }else {
                System.out.println("ERRO.Digite um número real.");
                scanner.next();
            }

        }
        return listaNumeros;
    }
    public static ArrayList<Integer> filtrandoPares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaDePares = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2==0){
                listaDePares.add(numero);
            }
        }
        return listaDePares;
    }
    public static ArrayList<Integer> filtrandoImpares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaDeImpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaDeImpares.add(numero);
            }
        }
        return listaDeImpares;
    }


    public static void verificandoIdade(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        List<Object>dados;
        int contMaior = 0, contMenor=0;
        for (int n=0;n<3;n++){
            dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            System.out.print("Idade:");
            dados.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(new ArrayList<>(dados));
        }
        System.out.println(lista);
        for (List<Object>pessoa:lista){
            String nome = (String)pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>=18){
                contMaior++;
                System.out.println(nome+", é maior de idade.");
            }else {
                contMenor++;
                System.out.println(nome+", é menor de idade.");
            }
        }
        System.out.println("Temos total de:"+contMaior+" maior de idade | Total de:"+contMenor+" menor de idade.");

    }


    public static void jogoLotofacil(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant=0;
        while (true){
            try {
                System.out.print("Digite um número:");
                quant = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException erro){
                System.out.println("ERRO!Digite um valor válido.");
            }
        }
        for (int total=0;total<quant;total++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<15){
                int jogo = random.nextInt(25)+1;
                lista.add(jogo);
            }
            ArrayList<Integer> jogolist = new ArrayList<>(lista);
            Collections.sort(jogolist);
            jogos.add(jogolist);
        }
        for (int i=0;i<jogos.size();i++){
            System.out.println("jogo:"+(i+1)+":"+jogos.get(i));
        }
    }

    public static void analisandoArrayNumeros(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int nMaior = Integer.MIN_VALUE, nMenor = Integer.MAX_VALUE, posMaior = 0, posMenor=0;
        for(int n=0;n<arrayNumeros.length;n++){
            while (true){
                try {
                    System.out.print("Digite o "+(n+1)+"º número:");
                    arrayNumeros[n] = Integer.parseInt(scanner.nextLine());
                    boolean numeroRepetido = false;
                    for (int i=0;i<n;i++){
                        if (arrayNumeros[i]==arrayNumeros[n]){
                            numeroRepetido = true;
                            break;
                        }
                    }
                    if (numeroRepetido){
                        System.out.println("ERRO.Número repetido, tente outro.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("ERRO! Digite um número real.");
                }

            }
            if (arrayNumeros[n]>nMaior){
                nMaior=arrayNumeros[n];
                posMaior = n;
            }
            if (arrayNumeros[n]<nMenor){
                nMenor=arrayNumeros[n];
                posMenor = n;
            }

        }
        System.out.println("O maior da lista é:"+nMaior+" | Está na posição:"+posMaior);
        System.out.println("O menor da lista é:"+nMenor+" | Está na posição:"+posMenor);

    }


    public static void tabelaBrasileirao(Scanner scanner){
        String[] times = {
                "Botafogo", "Palmeiras", "Internacional", "Fortaleza", "Flamengo",
                "São Paulo", "Bahia", "Corinthians", "Cruzeiro", "Vasco da Gama",
                "Atlético-MG", "EC Vitória", "Juventude", "Grêmio", "Athletico-PR",
                "Fluminense", "Criciúma", "Bragantino", "Cuiabá", "Atlético-GO"
        };
        for (int l=0;l<250;l++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Tabela brasileirão:"+Arrays.toString(times));
        for (int l=0;l<250;l++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiros da tabela:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int l=0;l<250;l++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os quatro últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4, times.length)));
        for (int l=0;l<250;l++){
            System.out.print("=");
        }
        System.out.println();
        String[] listaOrdenada = times.clone();
        Arrays.sort(listaOrdenada);
        System.out.println("A lista em ordem alfabética:"+Arrays.toString(listaOrdenada));
        for (int l=0;l<250;l++) {
            System.out.print("=");
        }
        System.out.println();
        int posicaoBragantino = 0;
        for (int p=0;p<times.length;p++){
            if (times[p].equals("Bragantino")){
                posicaoBragantino = p+1;
            }
        }
        System.out.println("O Bragantino está na posição:"+posicaoBragantino);
    }

    public static void jogoAdvinhacao(Scanner scanner, Random random) throws InterruptedException{
        int computador = random.nextInt(10)+1;
        int jogador = 0, contTentativas=0;
        while (true){
            while (true){
                try {
                    System.out.print("Digite  um número de 1 a 10:");
                    jogador = Integer.parseInt(scanner.nextLine());
                    if (jogador<=0 || jogador>=11){
                        System.out.println("ERRO!Digite um número de 1 a 10.");
                    }else {
                        contTentativas++;
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("ERRO.Digite um número real.");
                }
            }
            System.out.println("PROCESSANDO....");
            Thread.sleep(500);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Tente um número maior...");
                }else {
                    System.out.println("Tente um número menor....");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("Você acertou!!!");
                System.out.println("Você precisou de "+contTentativas+" tentativas para acertar.");
                String jogarNovamente;
                do {
                    System.out.println("Quer jogar novamente?(sim/não):");
                    jogarNovamente = scanner.nextLine().trim().toLowerCase();
                }while (!jogarNovamente.equals("não") && !jogarNovamente.equals("sim"));
                if (jogarNovamente.equals("não")){
                    break;
                }else {
                    contTentativas=0;
                    computador = random.nextInt(10)+1;
                }
            }
        }
    }

    public static void calculandoMedia(Scanner scanner){
        int contNumeros = 0;
        float soma = 0;
        float numero = 0;
        while (true){
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextFloat()){
                    numero = scanner.nextFloat();
                    if (numero<=0 || numero>=11){
                        System.out.println("Digite um número de 1 a 10.");
                        continue;
                    }else {
                        soma+=numero;
                        contNumeros++;
                    }
                }else {
                    System.out.println("ERRO,digite um número real.");
                    continue;
                }
                scanner.nextLine();
                String adicionarOutroNumero;
                do {
                    System.out.print("Quer adicionar outro número?(sim/não):");
                    adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarOutroNumero.equals("sim") && !adicionarOutroNumero.equals("não"));
                if (adicionarOutroNumero.equals("não")){
                    float media = soma/contNumeros;
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
                break;
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


    public static void verificandoLetraANaFrase(Scanner scanner){
        System.out.print("Digite a letra A:");
        String frase = scanner.nextLine().trim().toLowerCase();
        int contagem = 0;
        for (int c=0;c<frase.length();c++){
            if (frase.charAt(c)=='a'){
                contagem++;
            }
        }
        System.out.println("Na frase:"+frase+", a letra A apareceu:"+contagem+" vezes.");
        int primeiroA = frase.indexOf("a");
        int ultimoA =frase.lastIndexOf("a");
        if (primeiroA>=0 && ultimoA>0){
            System.out.println("A letra A apareceu primeira primeira vez na posição:"+primeiroA);
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
        }else {
            System.out.println("A letra A  não apareceu na frase.");
        }
    }

    public static void caixaEletronico(Scanner scanner){
        System.out.print("Quanto quer sacar?:R$");
        int saque = scanner.nextInt();
        int total = saque;
        int totalced = 0;
        int ced=50;
        while (true){
            if (total>=ced){
                total-=ced;
                totalced++;
            }else {
                if (totalced>=0){
                    System.out.printf("Total de %d de %d%n",totalced,ced);
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
                if (total<=0){
                    break;
                }
            }
        }
    }

    public static void listaComPosicoes(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int n=0;n<6;n++){
            while (true){
                System.out.print("Digite "+(n+1)+"º número:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (lista.contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
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
                    System.out.println("ERRO. Digite um número real.");
                    scanner.next();
                }
            }
        }
        System.out.println("A lista:"+lista);
    }

    public static void verificandoExpressao(Scanner scanner){
        Stack<Character> pilhaParentes = new Stack<>();
        System.out.print("Digite a sua expressão:");
        String expressao = scanner.nextLine().trim().toLowerCase();
        for (char parenteses : expressao.toCharArray()){
            if (parenteses=='('){
                pilhaParentes.push(parenteses);
            }else {
                if (parenteses==')'){
                    if (!pilhaParentes.isEmpty()){
                        pilhaParentes.pop();
                    }else {
                        System.out.println("Sua expressão está incorreta.");
                    }
                }
            }
        }
        if (pilhaParentes.isEmpty()){
            System.out.println("Sua expressão está correta.");
        }else {
            System.out.println("Sua expressão está incorreta.");
        }
    }

    public static void listaMaiorMenorIdade(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        List<Object>dados;
        int totalMaior=0, totalMenor=0;
        for (int i=0;i<3;i++){
            dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            System.out.print("Idade:");
            dados.add(scanner.nextInt());
            lista.add(new ArrayList<>(dados));
        }
        System.out.println(lista);
        for (List<Object> pessoa: lista){
            String nome = (String)pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>=18){
                System.out.println(nome+", é de maior de idade.");
                totalMaior++;
            }else {
                System.out.println(nome+", é de menor de idade.");
                totalMenor++;
            }
        }
        System.out.println("");
    }



    public static void jogoMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            try {
                System.out.print("Quantos jogos você quer?:");
                quant = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException erro){
                System.out.println("ERRO.Digite um número real.");
            }
        }
        for (int total=0;total<quant;total++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<6){
                int jogo = random.nextInt(60)+1;
                lista.add(jogo);
            }
            ArrayList<Integer> jogoList = new ArrayList<>(lista);
            Collections.sort(jogoList);
            jogos.add(jogoList);
        }
        for (int i=0;i<jogos.size();i++){
            System.out.println("jogo:"+(i+1)+":"+jogos.get(i));
        }
    }



    public static void listaParesImpares(Scanner scanner){
        ArrayList<Integer> lista = obterNumeros(scanner);
        ArrayList<Integer> listaPares = filtroPares(lista);
        ArrayList<Integer> listaImpares = filtroImpares(lista);
        System.out.println("A lista:"+lista);
        System.out.println("Lista de pares:"+listaPares);
        System.out.println("lista de impares:"+listaImpares);
    }
    public static ArrayList<Integer> obterNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (lista.contains(numeros)){
                    System.out.println("ERRO.Número já digitado, tente outro.");
                    continue;
                }else {
                    lista.add(numeros);
                }
                String adicionarNumeros;
                do {
                    System.out.print("Quer adicionar outro número?(sim/não):");
                    adicionarNumeros = scanner.nextLine().trim().toLowerCase();
                }while ((!adicionarNumeros.equals("sim") && !adicionarNumeros.equals("não")));
                if (adicionarNumeros.equals("não")){
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO.Digite um número real.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtroPares(ArrayList<Integer>numeros){
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2==0){
                listaPares.add(numero);
            }
        }
        return listaPares;
    }
    public static ArrayList<Integer> filtroImpares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }



}
