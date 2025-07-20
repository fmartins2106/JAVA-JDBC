package academy.devdojo.maratonajava.introducao;





import java.util.*;
import java.util.List;

public class Aula7ListasExercicios8 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        calculando medias alunos
        calculandoMediaAlunos(scanner);

//        jogo advinha
        jogoAdvinha(scanner, random);

//        array de numeros
        arrayNumeros(scanner);

//        jogo lotofacil
        jogoLotoFacil(scanner, random);

//        verificando a tabela do brasileirao
        analisandoTabelaBrasileirao(scanner);

//        verificando maior e menor de idade

        verificandoListaMaiorMenor(scanner);

//        verificando a lista e posição numeros
        verificandoListaPosicaoNumeros(scanner);

//        verificando expressão
        verificandoExpressao(scanner);

//        verificando peso das pessoas;2
        verificandoPesoPessoas(scanner);

//        verificando média alunos.
        verificandoMediaAlunos(scanner);

//        verificando maior e menor de idade
        listaMaiorMenorIdade(scanner);

//        lista de pares e impares
        verificandoParesImparesDaLista(scanner);

//        jogos mega sena
        jogosMegaSena(scanner,random);
        scanner.close();
    }

    public static void calculandoMediaAlunos(Scanner scanner){
        float soma=0;
        int contNumeros=0;
        while (true){
            while (true){
                try {
                    System.out.print("Digite uma nota:");
                    float nota = Float.parseFloat(scanner.nextLine());
                    if (nota<=-1 || nota>=11){
                        System.out.println("Digite uma nota válida entre 0 e 10.");
                        continue;
                    }else {
                        soma+=nota;
                        contNumeros++;
                    }
                    String addNovoNota;
                    do {
                        System.out.print("Quer adicionar uma nova nota?(sim/não):");
                        addNovoNota = scanner.nextLine().trim().toLowerCase();
                    }while (!addNovoNota.equals("não") && !addNovoNota.equals("sim"));
                    if (addNovoNota.equals("não")){
                        float media = soma/contNumeros;
                        System.out.println("A média:"+media);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite uma nota válida.");
                }
            }
            String calcularOutraMedia;
            do {
                System.out.print("Quer calcular outra média?(sim/não):");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }while (!calcularOutraMedia.equals("não") && !calcularOutraMedia.equals("sim"));
            if (calcularOutraMedia.equals("não")){
                System.out.println("Finalizando programa....");
                break;
            }else {
                soma=0;
                contNumeros=0;
            }
        }
    }


    public static void jogoAdvinha(Scanner scanner, Random random) throws InterruptedException{
        int jogador=0;
        int contTentativas=0;
        int computador = random.nextInt(10)+1;
        while (true){
            while (true){
                System.out.print("Digite um número de 1 a 10:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador<=0 || jogador>=11){
                        System.out.println("ERRO.Digite apenas números de 1 a 10.");
                    }else {
                        contTentativas++;
                        break;
                    }
                }else {
                    System.out.println("Digite um número válido.");
                    scanner.next();
                }
            }
            System.out.println("Processando....");
            Thread.sleep(600);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digige um número maior");
                }else {
                    System.out.println("Digite um número menor.");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("Você acertou!!!");
                System.out.println("Você precisou de:"+contTentativas+" tentativas para acertar.");
                scanner.nextLine();
                String jogarNovamente;
                do {
                    System.out.print("Quer jogar novamente?(sim/não):");
                    jogarNovamente = scanner.nextLine().trim().toLowerCase();
                }while (!jogarNovamente.equals("não") && !jogarNovamente.equals("sim"));
                if (jogarNovamente.equals("não")){
                    System.out.println("finalizando....");
                    break;
                }else {
                    computador = random.nextInt(10)+1;
                    contTentativas=0;
                }
            }

        }
    }


    public static void arrayNumeros(Scanner scanner){
        int[] listaNumeros = new int[6];
        int maiorLista = Integer.MIN_VALUE, menorLista = Integer.MAX_VALUE;
        int soma = 0, contNumeros=0;
        for (int n=0;n<listaNumeros.length;n++){
            while (true){
                try {
                    System.out.print("Digite o "+(n+1)+"º número:");
                    listaNumeros[n]  =Integer.parseInt(scanner.nextLine());
                    if (listaNumeros[n]<=-1){
                        System.out.println("Digite apenas números positivos.");
                    }else {
                        boolean numeroRepetido = false;
                        for (int i=0;i<n;i++){
                            if (listaNumeros[i]==listaNumeros[n]){
                                numeroRepetido =true;
                                break;
                            }
                        }
                        if (numeroRepetido){
                            System.out.println("Número repetido, tente outro.");
                        }else {
                            soma+=listaNumeros[n];
                            contNumeros++;
                            break;
                        }
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            if (listaNumeros[n]>maiorLista){
                maiorLista=listaNumeros[n];
            }
            if (listaNumeros[n]<menorLista){
                menorLista=listaNumeros[n];
            }
        }
        float media = (float) soma/listaNumeros.length;
        System.out.println("O maior da lista:"+maiorLista);
        System.out.println("O menor da lista:"+menorLista);
        System.out.println("A média:"+String.format("%.2f", media));
    }


    public static void jogoLotoFacil(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            try {
                System.out.print("Quantos jogos?:");
                quant = Integer.parseInt(scanner.nextLine());
                if (quant<=0){
                    System.out.println("Digite um número maior que zero.");
                }else {
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número válido.");
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
        for (int n=0;n<jogos.size();n++){
            System.out.println("jogo"+(n+1)+":"+jogos.get(n));
        }
    }

    public static void analisandoTabelaBrasileirao(Scanner scanner){
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
        System.out.println("Os 5 primeiras da tabela:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
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
        int posicaoFlamengo = 0;
        for (int i=0;i<times.length;i++){
            if (times[i].equals("Flamengo")){
                posicaoFlamengo=i+1;
                System.out.println("Flamengo está na posição:"+posicaoFlamengo);
            }
        }
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
    }

    public static void verificandoListaMaiorMenor(Scanner scanner){
        ArrayList<Pessoa> lista = new ArrayList<>();
        int totalMaior = 0, totalMenor=0;
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            int idade = 0;
            while (true){
                System.out.print("Idade:");
                if (scanner.hasNextInt()){
                    idade = scanner.nextInt();
                    if (idade<=0){
                        System.out.println("Erro. Digite um número positivo.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Digite um número.");
                    scanner.next();
                }
            }
            lista.add(new Pessoa(nome,idade));
            scanner.nextLine();
            String addNovoCadastro;
            do {
                System.out.print("Quer adicionar uma nova pessoa?(sim/não):");
                addNovoCadastro = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoCadastro.equals("não") && !addNovoCadastro.equals("sim"));
            if (addNovoCadastro.equals("não")){
                break;
            }
        }
        for (Pessoa dados : lista){
            if (dados.idade>=18){
                System.out.println(dados.nome+", é maior de idade.");
                totalMaior++;
            }else {
                System.out.println(dados.nome+", é menor de idade.");
                totalMenor++;
            }
        }
        System.out.println("Total de pessoas maior de idade:"+totalMaior);
        System.out.println("Total de pessoas menor de idade:"+totalMenor);
    }
    static class Pessoa{
        private String nome;
        private int idade;

        public Pessoa(String nome, int idade){
            this.nome = nome;
            this.idade = idade;
        }
    }


    public static void verificandoListaPosicaoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (numeros<=-1){
                    System.out.println("Digite apenas números positivos.");
                    continue;
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
                        continue;
                    }else {
                        if (lista.isEmpty() || numeros>= lista.get(lista.size()-1)){
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
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número válido.");
            }
            String addNovoNumero;
            do {
                System.out.print("Quer adicionar outro número?(sim/não):");
                addNovoNumero = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoNumero.equals("não") && !addNovoNumero.equals("sim"));
            if (addNovoNumero.equals("não")){
                break;
            }
        }
        System.out.println("A lista:"+lista);
    }

    public static void verificandoExpressao(Scanner scanner){
        Stack<Character> listaParenteses = new Stack<>();
        System.out.print("Digite uma expressão:");
        String expressao = scanner.nextLine().trim();
        for (char parenteses : expressao.toCharArray()){
            if (parenteses=='('){
                listaParenteses.push(parenteses);
            }else {
                if (parenteses==')'){
                    if (!listaParenteses.isEmpty()){
                        listaParenteses.pop();
                    }else {
                        System.out.println("Sua expressão está incorreta.");
                        return;
                    }
                }
            }
        }
        if (listaParenteses.isEmpty()){
            System.out.println("Sua expressão está correta.");
        }else {
            System.out.println("Sua expressão está incorreta.");
        }
    }

    static class Pessoas{
        private String nomePessoa;
        private float pesoPessoa;

        public Pessoas(String nomePessoa, float pesoPessoa){
            this.nomePessoa = nomePessoa;
            this.pesoPessoa = pesoPessoa;
        }
    }
    public static void verificandoPesoPessoas(Scanner scanner){
        ArrayList<Pessoas> lista = new ArrayList<>();
        float maiorPeso = Float.NEGATIVE_INFINITY, menorPeso = Float.POSITIVE_INFINITY;
        while (true){
            System.out.print("Nome:");
            String nomePessoa = scanner.nextLine().trim();
            nomePessoa = nomePessoa.substring(0,1).toUpperCase()+nomePessoa.substring(1).toLowerCase();
            float pesoPessoa=0;
            while (true){
                System.out.print("Peso:");
                if (scanner.hasNextFloat()){
                    pesoPessoa = scanner.nextFloat();
                    if (pesoPessoa<=0){
                        System.out.println("Digite um peso válido.");
                    }else {
                        break;
                    }
                }else {
                    System.out.print("Digite um peso válido.");
                    scanner.next();
                }
            }
            lista.add(new Pessoas(nomePessoa,pesoPessoa));
            if (pesoPessoa>maiorPeso){
                maiorPeso=pesoPessoa;
            }
            if (pesoPessoa<menorPeso){
                menorPeso=pesoPessoa;
            }
            scanner.nextLine();
            String addNovaPessoa;
            do {
                System.out.print("Quer adicionar nova pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("não") && !addNovaPessoa.equals("sim"));
            if (addNovaPessoa.equals("não")){
                break;
            }
        }
        for (Pessoas dados: lista){
            if (dados.pesoPessoa==maiorPeso){
                System.out.println("O maior peso registrado foi:"+dados.nomePessoa+" |"+dados.pesoPessoa+"Kg");
            }
            if (dados.pesoPessoa==menorPeso){
                System.out.println("O menor peso registrado foi:"+dados.nomePessoa+" |"+dados.pesoPessoa+"Kg");
            }
        }
    }

    public static void verificandoMediaAlunos(Scanner scanner){
        ArrayList<Aluno> lista =new ArrayList<>();
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            float nota1=0;
            while (true){
                try {
                    System.out.print("Digite a primeira nota:");
                    nota1 = Float.parseFloat(scanner.nextLine());
                    if (nota1<=-1 || nota1>=11){
                        System.out.println("Digite uma nota entre 1 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número válido.");
                }
            }
            float nota2 = 0;
            while (true){
                try {
                    System.out.print("Digite a segunda nota:");
                    nota2 = Float.parseFloat(scanner.nextLine());
                    if (nota2<=-1 || nota2>=11){
                        System.out.println("Digite uma nota entre 1 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número válido.");
                }
            }
            float media = (nota1+nota2)/2;
            lista.add(new Aluno(nome,nota1,nota2,media));
            String calcularOutraMedia;
            do {
                System.out.print("Quer calcular outra média?(sim/não):");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }while (!calcularOutraMedia.equals("não") && !calcularOutraMedia.equals("sim"));
            if (calcularOutraMedia.equals("não")){
                break;
            }
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-10s %-8s\n", "No","NOME", "MÉDIA");
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            Aluno aluno = lista.get(i);
            System.out.printf("%-4d %-10s %-8.2f%n",i,aluno.getNome(), aluno.getMedia());
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar):");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>Finalizando o programa...");
                break;
            }else {
                if (opc<lista.size()){
                    Aluno aluno = lista.get(opc);
                    System.out.println("As notas de "+aluno.getNome()+" foram:"+aluno.getNota1()+" e "+aluno.getNota2());
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


    public static void listaMaiorMenorIdade(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        int totalMaior = 0, totalMenor=0;
        for (int n=0;n<3;n++){
            List<Object> dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            System.out.print("Idade:");
            dados.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(dados);
        }
        System.out.println(lista);
        for (List<Object>pessoa: lista){
            String nome = (String)pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>=18){
                System.out.println(nome+", é maior de idade.");
                totalMaior++;
            }else {
                System.out.println(nome+", é menor de idade.");
                totalMenor++;
            }
        }
        System.out.println("Total maior de idade:"+totalMaior+" | Total menor de idade:"+totalMenor);
    }



    public static void verificandoParesImparesDaLista(Scanner scanner){
        ArrayList<Integer> lista = obtendoNumeros(scanner);
        ArrayList<Integer> listaPares = filtroPares(lista);
        ArrayList<Integer> listaImpares = filtroImpares(lista);
        System.out.println("A lista:"+lista);
        System.out.println("A lista de Pares:"+listaPares);
        System.out.println("A lista de impares:"+listaImpares);
    }
    public static ArrayList<Integer> obtendoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
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
                    String addNumeros;
                    do {
                        System.out.print("Quer adicionar outro número?:");
                        addNumeros = scanner.nextLine().trim().toLowerCase();
                    }while (!addNumeros.equals("sim") && !addNumeros.equals("não"));
                    if (addNumeros.equals("não")){
                        break;
                    }
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número válido.");
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
        for (int numero:numeros){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }


    public static void jogosMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos =new ArrayList<>();
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
                System.out.print("Digite um número válido.");
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
