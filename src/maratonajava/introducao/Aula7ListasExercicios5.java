package academy.devdojo.maratonajava.introducao;



import java.util.*;

public class Aula7ListasExercicios5 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        idade maior e menor
        idadeMaioMenor(scanner);

//        jogos da lotofacil
        jogosDaLotoFacil(scanner, random);

//        verificando numeros pares e impares da lista
        verificandoParesImparesLista(scanner);



//        combinações de jogos megasena
        combinacoesJogosMegaSena(scanner,random);

//        analisando media alunos
        analisandoMediaAlunos(scanner);

        //        jogo do advinha
        jogoDoAdvinha(scanner,random);

//        lista reversa
        listaReversa(scanner);

//        tabela brasileirão
        tabelaDoBrasileirao(scanner);

//        montando lista de posições
        listaPosicoes(scanner);

//        verificando uma expressao
        verificandoUmaExpressao(scanner);

//        separando pares e impares da lista
        separandoParesImparesLista(scanner);

//        jogos da lotofacil
        jogosLotoFacil(scanner, random);

//        verificando maior e menor de idade.
        verificandoMaiorMenorIdade(scanner);

//        avaliando a expressão
        avaliandoExpressao(scanner);

//        adicionado numeros e posições
        listaNumerosEPosicoes(scanner);

//        caixa eletronico
        caixaEletronico(scanner);

//        tabela do brasileirão
        tabelbrasileirao(scanner);

//        analisando array numeros
        analisandoArrayNumeros(scanner);

//        verificando lista pares e impares
        verificandoListaParImpar(scanner);

//        verificando maior e menor de idade
        listaMaiorMenorDeidade(scanner);

//        jogos mega sena
        jogosMegaSena(scanner,random);
        scanner.close();
    }

    public static void jogosDaLotoFacil(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            System.out.print("Quantos jogos?:");
            if (scanner.hasNextInt()){
                quant = scanner.nextInt();
                if (quant<=-1){
                    System.out.println("Digite um número positivo.");
                }else {
                    break;
                }
            }else {
                System.out.println("Digite um número real.");
                scanner.nextInt();
            }
        }
        for (int total=0;total<quant;total++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<15){
                int jogo = random.nextInt(25)+1;
                lista.add(jogo);
            }
            ArrayList<Integer> jogoList= new ArrayList<>(lista);
            Collections.sort(jogoList);
            jogos.add(jogoList);
        }
        for (int n=0;n<jogos.size();n++){
            System.out.println("jogo"+(n+1)+":"+jogos.get(n));
        }
    }

    public static void verificandoParesImparesLista(Scanner scanner){
        ArrayList<Integer> lista = addNumerosLista(scanner);
        ArrayList<Integer> listaDePares = filtroPar(lista);
        ArrayList<Integer> listaDeImpares = filtroImpar(lista);
        System.out.println("A lista:"+lista);
        System.out.println("Lista de pares:"+listaDePares);
        System.out.println("A lista de impares:"+listaDeImpares);
    }
    public static ArrayList<Integer> addNumerosLista(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (numeros<=-1){
                    System.out.println("Digite um número positivo.");
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
                        continue;
                    }else {
                        lista.add(numeros);
                    }
                    String adicionarNumeros;
                    do {
                        System.out.print("Quer adicionar outro número?(sim/não):");
                        adicionarNumeros = scanner.nextLine().trim().toLowerCase();
                    }while (!adicionarNumeros.equals("não") && !adicionarNumeros.equals("sim"));
                    if (adicionarNumeros.equals("não")){
                        break;
                    }
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número real.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtroPar(ArrayList<Integer> numeros){
        ArrayList<Integer> listaDePares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2==0){
                listaDePares.add(numero);
            }
        }
        return listaDePares;
    }

    public static ArrayList<Integer> filtroImpar(ArrayList<Integer> numeros){
        ArrayList<Integer> listaDeImpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaDeImpares.add(numero);
            }
        }
        return listaDeImpares;
    }

    public static void idadeMaioMenor(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        List<Object>dados;
        for(int n=0;n<3;n++){
            dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            dados.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(dados);
        }
        System.out.println(lista);
        for (List<Object> pessoa: lista){
            String nome =(String)pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>=18){
                System.out.println(nome+", é maior de idade.");
            }else {
                System.out.println(nome+", é menor de idade.");
            }
        }
    }

    public static void combinacoesJogosMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            try {
                System.out.print("Quantos jogos?:");
                quant = scanner.nextInt();
                if (quant<=0){
                    System.out.println("Digite um número maior ou igual a 1.");
                }else {
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número real.");
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


    public static void analisandoMediaAlunos(Scanner scanner){
        ArrayList<Aluno> lista = new ArrayList<>();
        scanner.nextLine();
        while (true){
            System.out.print("Digite o nome do aluno:");
            String nome = scanner.nextLine().trim().toLowerCase();
            nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
            float nota1 = 0;
            while (true){
                try {
                    System.out.print("Digite a primeira nota:");
                    nota1 = Integer.parseInt(scanner.nextLine());
                    if (nota1<=-1 || nota1>=11){
                        System.out.println("ERRO.Digite uma nota entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite uma nota válida.");
                }
            }
            int nota2 = 0;
            while (true){
                try {
                    System.out.print("Digite a segunda nota:");
                    nota2 = Integer.parseInt(scanner.nextLine());
                    if (nota2<=-1 || nota2>=11){
                        System.out.println("Digite uma nota válida entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite uma válida.");
                }
            }
            float media = (nota1+nota2)/2;
            lista.add((new Aluno(nome,nota1,nota2,media)));
            String calcularOutraMedia;
            do {
                System.out.print("Quer calcular outra média?(sim/não:");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }while (!calcularOutraMedia.equals("sim") && !calcularOutraMedia.equals("não"));
            if (calcularOutraMedia.equals("não")){
                break;
            }
        }
        for (int n=0;n<23;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-10s %-8s\n", "No","Nome","Média");
        for (int n=0;n<23;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            Aluno aluno = lista.get(i);
            System.out.printf("%-4s %-10s %-8.2f%n", i, aluno.getNome(), aluno.getMedia());
        }
        for (int n=0;n<23;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer ver notas de qual aluno?(digite 999 para parar.)");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println("Finalizando o programa...");
                break;
            }else {
                if (opc <lista.size()){
                    Aluno aluno = lista.get(opc);
                    System.out.printf("As notas de %s foram: %.2f e %.2f%n",aluno.getNome(), aluno.getNota1(),aluno.getNota2());
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

    public static void listaReversa(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numero = Integer.parseInt(scanner.nextLine());
                if (numero<=-1){
                    System.out.println("Digite somente números positivos...");
                }else {
                    if (lista.contains(numero)){
                        System.out.println("ERRO.Número repetido, tente outro.");
                        continue;
                    }else {
                        lista.add(numero);
                    }
                    String adicionarNumeros;
                    do {
                        System.out.print("Quer adicionar outro número?(sim/não):");
                        adicionarNumeros = scanner.nextLine().trim().toLowerCase();
                    }while (!adicionarNumeros.equals("não") && !adicionarNumeros.equals("sim"));
                    if (adicionarNumeros.equals("não")){
                        System.out.println(">>>Finalizando programa...");
                        Collections.sort(lista, Collections.reverseOrder());
                        System.out.println("A lista em ordem decrescente:"+lista);
                        break;
                    }

                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO.Digite um número real.");
            }
        }
    }


    public static void tabelaDoBrasileirao(Scanner scanner){
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
        System.out.println("A classificação:"+Arrays.toString(times));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiros da lista:"+Arrays.toString(Arrays.copyOfRange(times,0,5)));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os quatro últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4, times.length)));
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
        int posicaoBragantino = 0;
        for (int p=0;p<times.length;p++){
            if (times[p].equals("Bragantino")){
                posicaoBragantino = p+1;
            }
        }
        System.out.println("O bragantino está na posição:"+posicaoBragantino);
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
    }


    public static void listaPosicoes(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        int numeros = 0;
        while (true){
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNext()){
                    numeros = scanner.nextInt();
                    if (lista.contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
                        continue;
                    }else {
                        if (lista.isEmpty() || numeros>= lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos = 0;
                            while (pos< lista.size()){
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
                    System.out.println("ERRO.Digite um número válido.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            String adicionarNumeros;
            do {
                System.out.print("Quer adicionar um número?(sim/não):");
                adicionarNumeros = scanner.nextLine().trim().toLowerCase();
            }while (!adicionarNumeros.equals("não")  && !adicionarNumeros.equals("sim"));
            if (adicionarNumeros.equals("não")){
                System.out.println("Finalizando programa....");
                System.out.println("Lista:"+lista);
                break;
            }
        }
    }


    public static void verificandoUmaExpressao(Scanner scanner){
        Stack<Character> pilhaParenteses = new Stack<>();
        System.out.print("Digite sua expresão:");
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
            System.out.println("Sua expressão está correta.");
        }else {
            System.out.println("Sua expressão está incorreta.");
        }
    }

    public static void separandoParesImparesLista(Scanner scanner){
        ArrayList<Integer> lista = addNumeros(scanner);
        ArrayList<Integer> listaPares = filtrandoPares(lista);
        ArrayList<Integer> listaImpares = filtrandoImpares(lista);
        System.out.println("A lista:"+lista);
        System.out.println("Lista Pares:"+listaPares);
        System.out.println("Lista Impares:"+listaImpares);
    }
    public static ArrayList<Integer> addNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (numeros<=-1){
                    System.out.println("Digite um número positivo.");
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("Erro. Número repetido. Tente outro.");
                        continue;
                    }else {
                        lista.add(numeros);
                    }
                    String adicionarNumeros;
                    do {
                        System.out.print("Quer adicionar outro número?(sim/não):");
                        adicionarNumeros = scanner.nextLine().trim().toLowerCase();
                    }while (!adicionarNumeros.equals("não") && !adicionarNumeros.equals("sim"));
                    if (adicionarNumeros.equals("não")){
                        break;
                    }
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO. Digite um número real.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtrandoPares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2==0){
                listaPares.add(numero);
            }
        }
        return listaPares;
    }
    public static ArrayList<Integer> filtrandoImpares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }



    public static void jogosLotoFacil(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            try {
                System.out.print("Quantos jogos?:");
                quant = Integer.parseInt(scanner.nextLine());
                if (quant<=0){
                    System.out.println("Digite um número maior que 1.");
                }else {
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO.Digite um número válido.");
            }
        }
        for (int total=0;total<quant;total++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<15){
                int jogo = random.nextInt(25)+1;
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


    public static void verificandoMaiorMenorIdade(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        List<Object>dados;
        int totalMaior = 0, totalMenor=0;
        for (int n=0;n<3;n++){
            dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            System.out.print("Idade:");
            dados.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(dados);
        }
        System.out.println(lista);
        for (List<Object> pessoas:lista){
            String nome = (String) pessoas.get(0);
            int idade = (int) pessoas.get(1);
            if (idade>=18){
                totalMaior++;
                System.out.println(nome+", é maior de idade.");
            }else {
                totalMenor++;
                System.out.println(nome+", é menor de idade.");
            }
        }
        System.out.println("Total de pessoas maiores de idade:"+totalMaior+" | Total de pessoas menores de idade:"+totalMenor);
    }

    public static void avaliandoExpressao(Scanner scanner){
        Stack<Character> pilhaParenteses = new Stack<>();
        System.out.print("Digite uma expressão:");
        String expressao = scanner.nextLine().trim().toLowerCase();
        for (char parenteses: expressao.toCharArray()){
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
        int jogador = 0, contTentativas=0;
        int computador = random.nextInt(10)+1;
        while (true){
            while (true){
                try {
                    System.out.print("Digite um número de 1 a 10:");
                    jogador = Integer.parseInt(scanner.nextLine());
                    if (jogador<=0 || jogador>=11){
                        System.out.println("ERRO.Digite um número de 1 a 10.");
                    }else {
                        contTentativas++;
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("ERRO.Digite um número real.");
                }
            }
            System.out.println("Processando....");
            Thread.sleep(700);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digite um número maior.");
                }else {
                    System.out.println("Digite um número menor.");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("VOCÊ ACERTOU!!!");
                System.out.println("Você precisou de "+contTentativas+" tentativas.");
                String jogarNovamente;
                do {
                    System.out.print("Quer jogar novamente?(sim/não):");
                    jogarNovamente = scanner.nextLine().trim().toLowerCase();
                }while (!jogarNovamente.equals("sim") && !jogarNovamente.equals("não"));
                if (jogarNovamente.equals("não")){
                    System.out.println("Finalizando o jogo...");
                    break;
                }else {
                    computador = random.nextInt(10)+1;
                    contTentativas=0;
                }
            }
        }

    }

    public static void listaNumerosEPosicoes(Scanner scanner) throws InterruptedException{
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            int numeros = 0;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numeros = scanner.nextInt();
                    if (lista.contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
                        continue;
                    }else {
                        if (lista.isEmpty() || numeros>= lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos = 0;
                            while (pos <lista.size()){
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
                    System.out.println("ERRO.Digite um número real.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            String adicionarNumero;
            do {
                System.out.print("Quer adicionar outro número?(sim/não):");
                adicionarNumero = scanner.nextLine().trim().toLowerCase();
            }while (!adicionarNumero.equals("não") && !adicionarNumero.equals("sim"));
            if (adicionarNumero.equals("não")){
                System.out.println("Finalizando a lista....");
                Thread.sleep(900);
                System.out.println("A lista:"+lista);
                break;
            }
        }
    }

    public static void caixaEletronico(Scanner scanner){
        System.out.print("Quanto quer sacar?:R$");
        int saque = scanner.nextInt();
        int valor = saque;
        int totalced = 0;
        int ced = 50;
        while (true){
            if (valor>=ced){
                valor-=ced;
                totalced++;
            }else {
                if (totalced>0){
                    System.out.printf("Total de %d cédulas de R$%d%n",totalced, ced);
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


    public static void tabelbrasileirao(Scanner scanner){
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
        System.out.println("A tabela:"+Arrays.toString(times));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os 5 primeiros da lista:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os 4 últimos da lista:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4, times.length)));
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
        int posicaoBragantino = 0;
        for (int p=0;p<times.length;p++){
            if (times[p].equals("Bragantino")){
                posicaoBragantino=p+1;
            }
        }
        System.out.println("O Bragantino está na posição:"+posicaoBragantino);
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
    }

    public static void analisandoArrayNumeros(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        int posMaior = 0, posMenor=0;
        for (int n=0;n<arrayNumeros.length;n++){
            while (true){
                try {
                    System.out.print("Digite o "+(n+1)+"º número:");
                    arrayNumeros[n]= Integer.parseInt(scanner.nextLine());
                    if (arrayNumeros[n]<-1){
                        System.out.println("Digite um número positivo.");
                    }else {
                        boolean numeroRepetido=false;
                        for (int i=0;i<n;i++){
                            if (arrayNumeros[n]==arrayNumeros[i]){
                                numeroRepetido = true;
                                break;
                            }
                        }
                        if (numeroRepetido){
                            System.out.println("ERRO. Número repetido, tente outro.");
                        }else {
                            break;
                        }
                    }
                }catch (NumberFormatException erro){
                    System.out.println("ERRO. Digite um número real.");
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
        }
        System.out.println("O maior da lista:"+maiorNumero+" | Está na posição:"+posMaior);
        System.out.println("O menor da lista:"+menorNumero+" | Está na posição:"+posMenor);

    }

    public static void verificandoListaParImpar(Scanner scanner){
        ArrayList<Integer> lista = obtendoNumeros(scanner);
        ArrayList<Integer> listaPares = filtroPares(lista);
        ArrayList<Integer> listaImpares = filtroImpares(lista);
        System.out.println("lista:"+lista);
        System.out.println("lista de pares:"+listaPares);
        System.out.println("lista de impares:"+listaImpares);
    }
    public static ArrayList<Integer> obtendoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite  um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (numeros<=-1){
                    System.out.println("Digite um número positivo.");
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("ERRO.Número repetido, tente outro.");
                        continue;
                    }else {
                        lista.add(numeros);
                    }
                    String adicionarNumero;
                    do {
                        System.out.print("Quer adicionar um número?(sim/não):");
                        adicionarNumero = scanner.nextLine().trim().toLowerCase();
                    }while (!adicionarNumero.equals("sim") && !adicionarNumero.equals("não"));
                    if (adicionarNumero.equals("não")){
                        System.out.println("finalizando...");
                        break;
                    }
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO.Digite um número real.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtroPares(ArrayList<Integer> numeros){
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



    public static void listaMaiorMenorDeidade(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        List<Object>dados;
        for (int n=0;n<3;n++){
            dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            System.out.print("Idade:");
            dados.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(dados);
        }
        System.out.println(lista);
        for (List<Object> pessoa : lista){
            String nome = (String)pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>=18){
                System.out.println(nome+", é maior de idade.");
            }else {
                System.out.println(nome+", é menor de idade.");
            }
        }
    }


    public static void jogosMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            try {
                System.out.print("Quantos jogos vocÊ gostaria?:");
                quant = Integer.parseInt(scanner.nextLine());
                if (quant<=0){
                    System.out.println("Digite um número maior que 1.");
                }else {
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número real.");
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





}
