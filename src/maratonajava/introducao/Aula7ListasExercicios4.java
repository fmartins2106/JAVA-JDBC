package academy.devdojo.maratonajava.introducao;


import java.util.*;


public class Aula7ListasExercicios4 {
    public static void main(String[] args) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

// notas alunos
        mediaNotasAlunos(scanner);

//        listas pares e impares
        listaParesImpares(scanner);

//        jogo Pedra, Papel e Tesoura
        jogoPedraPapelTesoura(scanner, random);

//        jogo lotofacil
        jogoLotoFacil(scanner, random);

//        jogo lotofacil
        listaPessoas(scanner);

//        analisando array
        analisandoArrayNumero(scanner);

//        calculando media
        calculandoMedia(scanner);

//        montando lista e posições
        listaPosicoes(scanner);

// analisando frase metodo2
        analisandoFraseMetodo2(scanner);

//        caixa eletronico
        caixaEletronico2(scanner);

//        lista de números pares e impares
        listaNumerosParesImpares(scanner);

//        verificando a frase
        verificandoALetraA(scanner);

//        analisando informações das pessoas
        analisandoIdade(scanner);

//        jogo mega sena
        jogoMegaSena(scanner,random);


//        tabela brasileirão
        tabelBrasileirao(scanner);

        scanner.close();
    }

    public static void mediaNotasAlunos(Scanner scanner){
        ArrayList<Aluno> lista = new ArrayList<>();
        while (true){
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            int nota1 = 0;
            while (true){
                try {
                    System.out.print("Digite a primeira nota:");
                    nota1 = Integer.parseInt(scanner.nextLine());
                    if (nota1<=-1 || nota1>=11){
                        System.out.println("Digite uma nota entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            int nota2=0;
            while (true){
                try {
                    System.out.print("Digite a segunda nota:");
                    nota2 = Integer.parseInt(scanner.nextLine());
                    if (nota2<=-1 || nota2>=11){
                        System.out.println("Digite uma nota entre  e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            float media = (float) (nota1+nota2)/2;
            lista.add(new Aluno(nome, nota1,nota2,media));
            String adicionarOutraMedia;
            System.out.print("Quer adicionar notas de outro aluno?(sim/não):");
            adicionarOutraMedia = scanner.nextLine().trim().toLowerCase();
            while (!adicionarOutraMedia.equals("não") && !adicionarOutraMedia.equals("sim")){
                System.out.print("Digite apenas sim ou não:");
                adicionarOutraMedia = scanner.nextLine().trim().toLowerCase();
            }
            if (adicionarOutraMedia.equals("não")){
                break;
            }
        }
        for (int n=0;n<23;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-10s %-8s\n","No", "Nome", "Média");
        for (int n=0;n<23;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            Aluno aluno = lista.get(i);
            System.out.printf("%-4d %-10s %-8.2f\n",i,aluno.getNome(), aluno.getMedia());
        }
        for (int n=0;n<23;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer ver as notas de qual aluno?(digita 999 para parar.):");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println("Finalizando...");
                break;
            }else{
                if (opc < lista.size()){
                    Aluno aluno = lista.get(opc);
                    System.out.printf("Notas de %s foram: %.2f %.2f%n", aluno.getNome(),aluno.getNota1(),aluno.getNota2());
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
        public float getNota1() {
            return nota1;
        }
        public float getNota2() {
            return nota2;
        }
        public float getMedia() {
            return media;
        }
    }


    public static void listaParesImpares(Scanner scanner){
        ArrayList<Integer> listas = adicionandoNumeros(scanner);
        ArrayList<Integer> listaPares = filtrandoPares(listas);
        ArrayList<Integer> listaImpares = filtrandoImpares(listas);
        System.out.println("A lista:"+listas);
        System.out.println("Lista de pares:"+listaPares);
        System.out.println("lista de impares:"+listaImpares);
    }
    public static ArrayList<Integer> adicionandoNumeros(Scanner scanner){
        ArrayList<Integer> listas = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (listas.contains(numeros)){
                    System.out.println("Número repetido, tente outro.");
                }else {
                    if (numeros>=0){
                        listas.add(numeros);
                    }else {
                        System.out.println("ERRO.Digite um número positivo.");
                    }
                    String adicionarOutroNumero;
                    do {
                        System.out.print("Quer adicionar outro número?(sim/não):");
                        adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                    }while (!adicionarOutroNumero.equals("não") && !adicionarOutroNumero.equals("sim"));
                    if (adicionarOutroNumero.equals("não")){
                        break;
                    }
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO,Digite um número real.");
            }
        }
        return listas;
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
    public static ArrayList<Integer> filtrandoImpares(ArrayList<Integer>numeros){
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }

    public static void jogoPedraPapelTesoura(Scanner scanner, Random random) throws InterruptedException{
        int jogador = 0;
        while (true){
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            while (true){
                try {
                    System.out.print("Digite uma das opções acima:");
                    jogador = Integer.parseInt(scanner.nextLine());
                    if (jogador<=0 || jogador>=4){
                        System.out.println("ERRO.Digite um número de 1 a 3...");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("ERRO.Digite um número real.");
                }
            }
            System.out.println("PROCESSANDO...");
            Thread.sleep(500);
            int computador = random.nextInt(3)+1;
            if (jogador==computador){
                System.out.println("JOGADOR:"+jogoJoKenPo(jogador)+" | COMPUTADOR:"+jogoJoKenPo(computador)+" | RESULTADO: EMPATE!!!");
            } else if (jogador==1 && computador==3 || jogador==2 &&computador==1 || jogador==3 && computador==2) {
                System.out.println("JOGADOR:"+jogoJoKenPo(jogador)+" | COMPUTADOR:"+jogoJoKenPo(computador)+" | RESULTADO: VOCÊ VENCEU!!!");
            }else {
                System.out.println("JOGADOR:"+jogoJoKenPo(jogador)+" | COMPUTADOR:"+jogoJoKenPo(computador)+" | RESULTADO: VOCÊ PERDEU!!!");
            }
            String jogarNovamente;
            do {
                System.out.print("Quer jogar novamente?(sim/não):");
                jogarNovamente = scanner.nextLine().trim().toLowerCase();
            }while (!jogarNovamente.equals("sim") && !jogarNovamente.equals("não"));
            if (jogarNovamente.equals("não")){
                System.out.println(">>>Finalizando o jogo...");
                break;
            }else {
                computador=random.nextInt(3)+1;

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

    public static void jogoLotoFacil(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            System.out.print("Quantos jogos vocÊ quer?:");
            if (scanner.hasNextInt()){
                quant = scanner.nextInt();
                if (quant<=-1){
                    System.out.println("Digite um número positivo.");
                }else {
                    break;
                }
            }else {
                System.out.println("ERRO.Digite um número real.");
                scanner.next();
            }
        }
        scanner.nextLine();
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
            System.out.println("joog"+(i+1)+":"+jogos.get(i));
        }
    }

    public static void listaPessoas(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        List<Object> dados;
        for (int c=0;c<3;c++){
            dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            System.out.print("Idade:");
            dados.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(dados);
        }
        System.out.println(lista);
        for (List<Object>pessoas:lista){
            String nome = (String)pessoas.get(0);
            int idade = (int)pessoas.get(1);
            if (idade>=18){
                System.out.println(nome+", é maior de idade.");
            }else {
                System.out.println(nome+", é menor de idade.");
            }
        }

    }

    public static void analisandoArrayNumero(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        int pMaior = 0, pMenor = 0;
        for (int n=0;n<arrayNumeros.length;n++){
            while (true){
                try {
                    System.out.print("Digite o "+(n+1)+"º número da lista:");
                    arrayNumeros[n] = Integer.parseInt(scanner.nextLine());
                    if (arrayNumeros[n]<=-1){
                        System.out.println("ERRO.Digite um número positivo.");
                    }else {
                        boolean numeroRepetido=false;
                        for (int r=0;r<n;r++){
                            if (arrayNumeros[n]==arrayNumeros[r]){
                                numeroRepetido=true;
                                break;
                            }
                        }
                        if (numeroRepetido){
                            System.out.println("ERRO.Número repetido.");
                        }else {
                            break;
                        }
                    }
                }catch (NumberFormatException erro){
                    System.out.println("ERRO.Digite um número real.");
                }
            }
            if (arrayNumeros[n]>maiorNumero){
                maiorNumero=arrayNumeros[n];
                pMaior = n;
            }
            if (arrayNumeros[n]<menorNumero){
                menorNumero=arrayNumeros[n];
                pMenor=n;
            }
        }
        System.out.println("O maior da lista:"+maiorNumero+" | Está na posição:"+pMaior);
        System.out.println("O menor da lista:"+menorNumero+" | Está na posição:"+pMenor);
    }

    public static void calculandoMedia(Scanner scanner){
        float numeros = 0, soma=0; int contNumeros=0;
        while (true){
            while (true){
                try {
                    System.out.print("Digite um número entre 1 e 10:");
                    numeros = Float.parseFloat(scanner.nextLine());
                    if (numeros<=0 || numeros>=11){
                        System.out.println("Digite um número entre 1 e 10.");
                        continue;
                    }else {
                        soma+=numeros;
                        contNumeros++;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                    continue;
                }
                String adicionarOutroNumero;
                do {
                    System.out.print("Quer adicionar outro número?(sim/não):");
                    adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarOutroNumero.equals("não") && !adicionarOutroNumero.equals("sim"));
                if (adicionarOutroNumero.equals("não")){
                    float media = soma/contNumeros;
                    System.out.println("A média:"+ String.format("%.2f",media));
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
            }else {
                soma = 0;
                contNumeros = 0;
            }
        }
    }


    public static void listaPosicoes(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int n=0;n<6;n++){
            while (true){
                try {
                    System.out.print("Digite o"+(n+1)+"º número:");
                    int numeros = Integer.parseInt(scanner.nextLine());
                    if (numeros<=-1){
                        System.out.println("ERRO.Digite um número positivo.");
                        continue;
                    }else {
                        if (lista.contains(numeros)){
                            System.out.println("Número já cadastrado, tente outro...");
                            continue;
                        }else {
                            if (lista.isEmpty() || numeros>=lista.get(lista.size()-1)){
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
                    }
                    break;
                }catch (NumberFormatException erro){
                    System.out.println("ERRO. Digite um número real.");
                }
            }
        }
        System.out.println("lista:"+lista);
    }

    public static void analisandoFraseMetodo2(Scanner scanner){
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        int contagem=0;
        for (char letras: frase.toCharArray()){
            if ("a".indexOf(letras)!=-1){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu na frase:"+frase+" | "+contagem+" vezes.");
    }


    public static void caixaEletronico2(Scanner scanner){
        System.out.print("Quanto quer sacar?:R$");
        int saque = scanner.nextInt();
        int valor= saque;
        int totalced = 0;
        int ced = 50;
        while (true){
            if (valor>=ced){
                valor-=ced;
                totalced++;
            }else {
                if (totalced>0){
                    System.out.printf("total de %d cédulas de %d%n",totalced, ced);
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


    public static void verificandoALetraA(Scanner scanner){
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        int contagem = 0;
        for (int n=0;n<frase.length();n++){
            if (frase.charAt(n)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu na frase:"+frase+" | " +contagem+" vezes.");
        int primeiroA = frase.indexOf("a");
        int ultimoA = frase.lastIndexOf("a");
        if (primeiroA>0 && ultimoA>0){
            System.out.println("O primeiro A apareceu na posição:"+primeiroA);
            System.out.println("O último A apareceu na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu na frase.");
        }
    }

    public static void analisandoIdade(Scanner scanner){
        List<List<Object>> lista =new ArrayList<>();
        List<Object> dados;
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
        for (List<Object> pessoa: lista){
            String nome = (String)pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>=18){
                System.out.println(nome+", é maior de idade.");
            }else {
                System.out.println(nome+", é menor de idade.");
            }
        }
    }

    public static void jogoMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            System.out.print("Quantos jogos você quer?:");
            if (scanner.hasNextInt()){
                quant = scanner.nextInt();
                if (quant<=-1){
                    System.out.println("ERRO, Digite um número positivo.");
                }else {
                    break;
                }
            }else {
                System.out.println("ERRO,digite um valor real.");
                scanner.next();
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
        for (int j=0;j<jogos.size();j++){
            System.out.println("jogo:"+(j+1)+":"+jogos.get(j));
        }
    }

    public static void listaNumerosParesImpares(Scanner scanner){
        ArrayList<Integer> lista = obtendoNumeros(scanner);
        ArrayList<Integer> listaPares = filtroPares(lista);
        ArrayList<Integer> listaImpares = filtroImpares(lista);
        System.out.println("A lista:"+lista);
        System.out.println("A lista de pares:"+listaPares);
        System.out.println("A lista de impares:"+listaImpares);
    }
    public static ArrayList<Integer> obtendoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        int numeros = 0;
        while (true){
            try {
                System.out.print("Digite um número:");
                numeros = Integer.parseInt(scanner.nextLine());
                if (numeros<=-1){
                    System.out.println("ERRO.Digite um número positivo.");
                    continue;
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("ERRO.Número já adicionado, tente outro.");
                        continue;
                    }else {
                        lista.add(numeros);
                    }
                }
                String adicionarNumeros;
                do {
                    System.out.print("Quer adicionar outro número?(sim/não):");
                    adicionarNumeros = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarNumeros.equals("não") && !adicionarNumeros.equals("sim"));
                if (adicionarNumeros.equals("não")){
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO, Digite um número real.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtroPares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (int numero : numeros){
             if ((numero%2==0)){
                 listaPares.add(numero);
             }
        }
        return listaPares;
    }
    public static ArrayList<Integer> filtroImpares(ArrayList<Integer>numeros){
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }





    public static void tabelBrasileirao(Scanner scanner){
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
        System.out.println("A classificação do brasileirão:"+Arrays.toString(times));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiras da tabela:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os quatro últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4,times.length)));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        String[] tabelaOrdenada  = times.clone();
        Arrays.sort(tabelaOrdenada);
        System.out.println("A tabela por ordem alfabética:"+Arrays.toString(tabelaOrdenada));
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
        System.out.println("O Bragantino está na posição:"+posicaoBragantino);
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
    }


}
