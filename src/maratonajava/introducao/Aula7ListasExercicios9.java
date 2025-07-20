package academy.devdojo.maratonajava.introducao;



import java.util.*;



public class Aula7ListasExercicios9 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //colocando pares e impares em uma lista composta
        listaParesImparesEmListaComposta2(scanner);

//        verificando letra A frase
        verificandoFraseComLetraA(scanner);

//        jogo pedra, papel, tesoura
        jogoPedraPapelTesoura(scanner, random);

//        calculando media notas
        calculandoMediaNotas(scanner);

//colocando pares e impares em uma lista composta
        listaParesImparesEmListaComposta(scanner);

//        avaliando tabela do brasileirão
        tabelaBrasileirao(scanner);

//        verificando maior e menor de idade
        maiorMenorIdade(scanner);


//        verificando uma expressão
        verificandoUmaExpressao(scanner);

//        verificando lista e posições
        listaPosicaoNumeros(scanner);

//        verificando peso das pessoas cadastradas
        pesoPessoasCadastradas(scanner);

//        verificando média alunos.
        verificandoMediaAlunos(scanner);

//        verificando maior e menor de idade da lista
        verificandoMaiorMenorIdade(scanner);

//        verificando jogos megasena
        verificandoJogosMegaSena(scanner,random);

//            verificando os numeros pares e impares da lista
        verificandoParesImparesLista(scanner);
        scanner.close();
    }

    public static void listaParesImparesEmListaComposta2(Scanner scanner){
        ArrayList<ArrayList<Integer>> lista = new ArrayList<>();
        lista.add(new ArrayList<>());
        lista.add(new ArrayList<>());
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (numeros<=0){
                    System.out.println("Digite um número positivo.");
                }else {
                    if (lista.get(0).contains(numeros) || lista.get(1).contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
                    }else {
                        if (numeros%2==0){
                            lista.get(0).add(numeros);
                        }else {
                            lista.get(1).add(numeros);
                        }
                        String addNumeros;
                        do {
                            System.out.print("Quer adicionar outro número?(sim/não):");
                            addNumeros = scanner.nextLine().trim().toLowerCase();
                        }while (!addNumeros.equals("sim") && !addNumeros.equals("não"));
                        if (addNumeros.equals("não")){
                            System.out.println("A lista de números pares:"+lista.get(0));
                            System.out.println("A lista de números impares:"+lista.get(1));
                            break;
                        }
                    }
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número real.");
            }
        }
    }

    public static void verificandoFraseComLetraA(Scanner scanner){
        int contagem=0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine();
        for (char letras : frase.toCharArray()){
            if ("a".indexOf(letras)!=-1){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu:"+contagem+" vezes na frase:"+frase);
        int primeiroA = frase.indexOf("a"), ultimoA=frase.lastIndexOf("a");
        if (primeiroA>0 || ultimoA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu não frase.");
        }
    }

    public static void jogoPedraPapelTesoura(Scanner scanner,Random random) throws InterruptedException{
        int computador = random.nextInt(3)+1;
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
                        System.out.println("Digite uma opção válida.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            System.out.println("Processando..");
            Thread.sleep(600);
            System.out.println("Computador:"+computador);
            if (jogador==computador){
                System.out.println("JOGADOR:"+jogoJoKenPo(jogador)+" | COMPUTADOR:"+jogoJoKenPo(computador)+" | RESULTADO:EMPATE!!!");
            } else if (jogador==1 && computador==3 ||
                        jogador==2 && computador==1 ||
                        jogador==3 && computador==2) {
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
                break;
            }else {
                computador = random.nextInt(3)+1;
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

    public static void calculandoMediaNotas(Scanner scanner){
        float notas = 0, soma=0;
        int contNotas = 0;
        while (true){
            while (true){
                System.out.print("Digite uma nota:");
                if (scanner.hasNextFloat()){
                    notas = scanner.nextFloat();
                    if (notas<=-1 || notas>=11){
                        System.out.println("Digite um valor válido entre o e 10.");
                    }else {
                        soma+=notas;
                        contNotas++;
                        break;
                    }
                }else {
                    System.out.println("Digite um número válido.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            String addNovaNota;
            do {
                System.out.print("Quer adicionar uma nota nota?(sim/não):");
                addNovaNota = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaNota.equals("sim") && !addNovaNota.equals("não"));
            if (addNovaNota.equals("não")){
                float media = soma/contNotas;
                System.out.println("A média:"+String.format("%.2f",media));
                String calcularNovaMedia;
                do {
                    System.out.print("Quer calcular outra média?(sim/não):");
                    calcularNovaMedia = scanner.nextLine().trim().toLowerCase();
                }while (!calcularNovaMedia.equals("sim") && !calcularNovaMedia.equals("não"));
                if (calcularNovaMedia.equals("não")){
                    System.out.println(">>>Finalizando....");
                    break;
                }else {
                    soma=0;
                    contNotas=0;
                }
            }
        }
    }
    public static void listaParesImparesEmListaComposta(Scanner scanner){
        ArrayList<ArrayList<Integer>> lista = new ArrayList<>();
        lista.add(new ArrayList<>());
        lista.add(new ArrayList<>());
        while (true){
            System.out.print("Digite um número:");
            if (scanner.hasNextInt()){
                int numeros = scanner.nextInt();
                if (numeros<=-1){
                    System.out.println("Digite um número positivo.");
                }else {
                    if (lista.get(0).contains(numeros) || lista.get(1).contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
                        continue;
                    }else {
                        if (numeros%2==0){
                            lista.get(0).add(numeros);
                        }else {
                            lista.get(1).add(numeros);
                        }
                    }
                    scanner.nextLine();
                    String addNovoNumero;
                    do {
                        System.out.print("Quer adicionar outro número?(sim/não):");
                        addNovoNumero = scanner.nextLine().trim().toLowerCase();
                    }while (!addNovoNumero.equals("não") && !addNovoNumero.equals("sim"));
                    if (addNovoNumero.equals("não")){
                        System.out.println("A lista de pares:"+lista.get(0));
                        System.out.println("A lista de impares:"+lista.get(1));
                        break;
                    }
                }
            }else {
                System.out.println("Digite um número real.");
                scanner.next();
            }
        }
    }


    public static void tabelaBrasileirao(Scanner scanner){
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
        System.out.println("A tabela do brasileirão:"+Arrays.toString(times));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiros da tabela:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os quatro últimos da tabela:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4,times.length)));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        String[] tabelaOrdenada = times.clone();
        Arrays.sort(tabelaOrdenada);
        System.out.println("A tabela em ordem alfabética:"+Arrays.toString(tabelaOrdenada));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        int posicaoSaoPaulo = 0;
        for (int i=0;i< times.length;i++){
            if (times[i].equals("São Paulo")){
                posicaoSaoPaulo=i+1;
            }
        }
        System.out.println("A posição do São Paulo:"+posicaoSaoPaulo);
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
    }


    static class Pessoas{
        private String nomeDaPessoa;
        private int idadeDaPessoa;

        public Pessoas( String nomeDaPessoa, int idadeDaPessoa){
            this.nomeDaPessoa = nomeDaPessoa;
            this.idadeDaPessoa = idadeDaPessoa;
        }

    }

    public static void maiorMenorIdade(Scanner scanner){
        ArrayList<Pessoas> lista = new ArrayList<>();
        int totalMaior = 0, totalMenor=0;
        String nomeDaPessoa;
        while (true){
            System.out.print("Nome:");
            nomeDaPessoa = scanner.nextLine().trim();
            nomeDaPessoa =nomeDaPessoa.substring(0,1).toUpperCase()+nomeDaPessoa.substring(1).toLowerCase();
            int idadeDaPessoa=0;
            while (true){
                try {
                    System.out.print("Digite sua idade:");
                    idadeDaPessoa = Integer.parseInt(scanner.nextLine());
                   if (idadeDaPessoa<=0){
                        System.out.println("Digite um valor válido.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            lista.add(new Pessoas(nomeDaPessoa,idadeDaPessoa));
            String addNovaPessoa;
            do {
                System.out.print("Quer adicionar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("não") && !addNovaPessoa.equals("sim"));
            if (addNovaPessoa.equals("não")){
                break;
            }
        }
        for (Pessoas dados : lista){
            if (dados.idadeDaPessoa>=18){
                totalMaior++;
                System.out.println(dados.nomeDaPessoa+", é maior de idade.");
            }
        }
        for (Pessoas dados : lista){
            if (dados.idadeDaPessoa<=17){
                totalMenor++;
                System.out.println(dados.nomeDaPessoa+", é menor de idade.");
            }
        }
        System.out.println("Total maior de idade:"+totalMaior);
        System.out.println("Total menor de idade:"+totalMenor);
    }

    public static void verificandoUmaExpressao(Scanner scanner){
        Stack<Character> pilhaParenteses = new Stack<>();
        System.out.print("Digite uma expressão:");
        String expressao = scanner.nextLine();
        for (char paresenteses : expressao.toCharArray()){
            if (paresenteses=='('){
                pilhaParenteses.push(paresenteses);
            }else {
                if (paresenteses==')'){
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

    public static void listaPosicaoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (numeros<=-1){
                    System.out.println("Digite um número positivo.");
                    continue;
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("Número repetido, tente outro número.");
                        continue;
                    }else {
                        if (lista.isEmpty() || numeros>= lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos=0;
                            while (pos < lista.size()){
                                if (numeros <=lista.get(pos)){
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
                System.out.println("Digite um valor real.");
            }
            String addNovoNumero;
            do {
                System.out.print("Quer adicionar outro número?(sim/não):");
                addNovoNumero = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoNumero.equals("não") && !addNovoNumero.equals("sim"));
            if (addNovoNumero.equals("não")){
                System.out.println("A lista:"+lista);
                break;
            }
        }

    }


    static class Pessoa{
        private String nomePessoa;
        private float pesoPessoa;

        public Pessoa(String nomePessoa, float pesoPessoa){
            this.nomePessoa = nomePessoa;
            this.pesoPessoa = pesoPessoa;
        }
    }

    public static void pesoPessoasCadastradas(Scanner scanner){
        ArrayList<Pessoa> lista = new ArrayList<>();
        float maiorPeso = Float.NEGATIVE_INFINITY, menorPeso=Float.POSITIVE_INFINITY;
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            float peso = 0;
            while (true){
                try {
                    System.out.print("Digite o peso:");
                    peso = Float.parseFloat(scanner.nextLine());
                    if (peso<=0){
                        System.out.println("Digite um valor válido.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            if (peso>maiorPeso){
                maiorPeso=peso;
            }
            if (peso<menorPeso){
                menorPeso=peso;
            }
            lista.add(new Pessoa(nome, peso));
            String cadastrarNovaPessoa;
            do {
                System.out.print("Quer cadastrar uma nova pessoa?(sim/não):");
                cadastrarNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!cadastrarNovaPessoa.equals("não") && !cadastrarNovaPessoa.equals("sim"));
            if (cadastrarNovaPessoa.equals("não")){
                break;
            }
        }
        for (Pessoa dados : lista){
            if (dados.pesoPessoa==maiorPeso){
                System.out.println("O maior peso da lista:"+dados.nomePessoa+" | Peso:"+maiorPeso);
            }
            if (dados.pesoPessoa==menorPeso){
                System.out.println("O menor peso da lista:"+dados.nomePessoa+" | Peso:"+menorPeso);
            }
        }
    }

    public static void verificandoMediaAlunos(Scanner scanner){
        ArrayList<Aluno> lista = new ArrayList<>();
        while (true){
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            float nota1 = 0;
            while (true){
                try {
                    System.out.print("Digite a primeira nota:");
                    nota1 = Float.parseFloat(scanner.nextLine());
                    if (nota1<=-1 || nota1>=11){
                        System.out.println("Digite uma nota entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número entre 0 e 10.");
                }
            }
            float nota2=0;
            while (true){
                try {
                    System.out.print("Digite a segunda nota:");
                    nota2 = Float.parseFloat(scanner.nextLine());
                    if (nota2<=-1 || nota2>=11){
                        System.out.println("Digite um número entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número entre 0 e 10.");
                }
            }
            float media = (nota1+nota2)/2;
            lista.add(new Aluno(nome,nota1,nota2,media));
            String cadastrarOutroAluno;
            do {
                System.out.print("Quer cadastrar outro aluno?(sim/não):");
                cadastrarOutroAluno = scanner.nextLine().trim().toLowerCase();
            }while (!cadastrarOutroAluno.equals("sim") && !cadastrarOutroAluno.equals("não"));
            if (cadastrarOutroAluno.equals("não")){
                break;
            }
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-10s %-8s\n","No","Nome","Média");
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            Aluno aluno = lista.get(i);
            System.out.printf("%-4d %-10s %-8.2f\n",i,aluno.getNome(),aluno.getMedia());
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Ver notas qual aluno?(Digite 999 para parar.)");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>Finalizando programa...");
                break;
            }else {
                if (opc<lista.size()){
                    Aluno aluno =lista.get(opc);
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

    public static void verificandoMaiorMenorIdade(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        int totalMaior=0, totalMenor=0;
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
        for (List<Object> dado : lista){
            String nome = (String)dado.get(0);
            int idade = (int)dado.get(1);
            if (idade>=18){
                System.out.println(nome+", é maior de idade.");
                totalMaior++;
            }else {
                System.out.println(nome+", é menor de idade.");
                totalMenor++;
            }
        }
    }


    public static void verificandoJogosMegaSena(Scanner scanner, Random random){
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
        for (int n=0;n<jogos.size();n++){
            System.out.println("jogo "+(n+1)+":"+jogos.get(n));
        }
    }


    public static void verificandoParesImparesLista(Scanner scanner){
        ArrayList<Integer> lista = obtendoNumeros(scanner);
        ArrayList<Integer> listaPares = filtroPar(lista);
        ArrayList<Integer> listaImpares = filtroImpar(lista);
        System.out.println("A lista:"+lista);
        System.out.println("A lista de pares:"+listaPares);
        System.out.println("A lista impares:"+listaImpares);
    }
    public static ArrayList<Integer> obtendoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (numeros<=-1){
                    System.out.println("Digite apenas números positivos.");
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
                        continue;
                    }else {
                        lista.add(numeros);
                    }
                    String addNumeros;
                    do {
                        System.out.print("Quer adicinar mais um número?(sim/não):");
                        addNumeros = scanner.nextLine().trim().toLowerCase();
                    }while (!addNumeros.equals("não")  && !addNumeros.equals("sim"));
                    if (addNumeros.equals("não")){
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
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2==0){
                listaPares.add(numero);
            }
        }
        return listaPares;
    }
    public static ArrayList<Integer> filtroImpar(ArrayList<Integer>numeros){
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }
}
