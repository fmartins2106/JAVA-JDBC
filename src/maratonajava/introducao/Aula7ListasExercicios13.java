package academy.devdojo.maratonajava.introducao;



import java.time.*;
import java.util.*;

public class Aula7ListasExercicios13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //        verificando aposentadoria
        verificandoAposentadoria(scanner);
// sorteio da lotofacil
        sorteioLotoFacil(scanner,random);

//        verificando a matriz
        verificandoMatriz(scanner);

//        verificando sorteio jogadores
        sorteioOrdemJogadores3(scanner,random);

//        jogo do advinha
        jogoAdvinha(scanner, random);

//        verificando expressao
        verificandoExpressao(scanner);

//        verificando posição dos numeros
        verificandoListaposicoesNumeros(scanner);

//        verificando situação dos alunos
        verificandoAprovacaoAluno2(scanner);

//        sorteio jogadores
        sorteioOrdemJogadores2(scanner, random);



//        verificando maior e menor de idade;
        verificandoMaiorMenorIdadeMetodo2(scanner);

//        verificando a media dos alunos;
        verificandoMediaAlunos(scanner);

//        verificando o peso das pessoas
        verificandoPesoPessoas(scanner);

//      verificando se aluno foi aprovado ou não
        verificandoAprovacaoAluno(scanner);

//        verificando maior e menor de idade
        verificandoMaiorMenorIdade(scanner);

//        jogos da mega sena
        jogosMegaSena(scanner,random);

//        verificando numeros pares e impares
        verificandoNumerosParesImpares(scanner);

//        calculando matriz
        calculandoMatriz(scanner);

//        sorteio ordem de jogadores
        sorteioOrdemJogadores(scanner, random);
        scanner.close();
    }

    public static void sorteioLotoFacil(Scanner scanner,Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant=0;
        while (true){
            try {
                System.out.print("Digite um número:");
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
            while (lista.size()<15){
                int jogo = random.nextInt(25)+1;
                lista.add(jogo);
            }
            ArrayList<Integer> jogoList = new ArrayList<>(lista);
            Collections.sort(jogoList);
            jogos.add(jogoList);
        }
        for (int n=0;n<jogos.size();n++){
            System.out.println((n+1)+"º jogo:"+jogos.get(n));
        }
    }



    public static void verificandoMatriz(Scanner scanner){
        int somap=0, somac3=0, maiorl2=0;
        int[][] matriz = new int[3][3];
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.print("Digite um número para posição:["+l+"]["+c+"]:");
                matriz[l][c] = scanner.nextInt();
            }
        }
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.printf("[ %d ]",matriz[l][c]);
                if (matriz[l][c]%2==0){
                    somap+=matriz[l][c];
                }
            }
            System.out.println();
        }
        for (int c=0;c<3;c++){
            somac3+=matriz[c][2];
        }
        for (int l=0;l<3;l++){
            if (matriz[1][l]>maiorl2){
                maiorl2=matriz[1][l];
            }
        }
        System.out.println("A soma dos números pares:"+somap);
        System.out.println("A soma da coluna C3:"+somac3);
        System.out.println("O maior número da linha 2:"+maiorl2);
    }

    public static void sorteioOrdemJogadores3(Scanner scanner, Random random){
        Map<String,Integer> jogador = new LinkedHashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10)+1);
        System.out.println("===Sorteio Jogadores===");
        for (Map.Entry<String,Integer> entry : jogador.entrySet()){
            System.out.println(entry.getKey()+ " tirou: "+entry.getValue());
            try {
                Thread.sleep(300);
            }catch (InterruptedException erro){
                erro.printStackTrace();
            }
        }
        List<Map.Entry<String,Integer>> ranking = new ArrayList<>(jogador.entrySet());
        ranking.sort((entry1,entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        System.out.println("====Ranking Jogadores====");
        for (int i=0;i<ranking.size();i++){
            Map.Entry<String,Integer> entry = ranking.get(i);
            System.out.println((i+1+"º lugar:"+entry.getKey()+" com "+entry.getValue()));
        }
    }

    public static void jogoAdvinha(Scanner scanner, Random random){
        int computador= random.nextInt(10)+1;
        int contTentativas = 0;
        while (true){
            int jogador = 0;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador<=0 || jogador>=11){
                        System.out.println("Digite um número entre 1 e 10.");
                    }else {
                        contTentativas++;
                        break;
                    }
                }else {
                    System.out.println("ERRO. Digite um número entre 1 e 10.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.println("Processando...");
            try {
                Thread.sleep(300);
            }catch (InterruptedException erro){
                erro.printStackTrace();
            }
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digite um número maior...");
                }else {
                    System.out.println("Digite um número menor...");
                }
            }else {
                System.out.println("computador:"+computador);
                System.out.println("Você acertou!!!");
                System.out.println("Você precisou de: "+contTentativas+" tentativas para acertar.");
                String jogarNovamente;
                do {
                    System.out.print("Quer jogar novamente?(sim/não):");
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


    public static void verificandoListaposicoesNumeros(Scanner scanner){
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
                    }else {
                        if (lista.isEmpty() || numeros>= lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos=0;
                            while (pos< lista.size()){
                                if (numeros <= lista.get(pos)){
                                    lista.add( pos, numeros);
                                    System.out.println("Adicionado na posição:"+pos);
                                    break;
                                }
                                pos++;
                            }
                        }
                    }
                }
                String addNovoNumero;
                do {
                    System.out.print("Quer adicionar outro número?(sim/não):");
                    addNovoNumero = scanner.nextLine().trim().toLowerCase();
                }while (!addNovoNumero.equals("sim")  && !addNovoNumero.equals("não"));
                if (addNovoNumero.equals("não")){
                    System.out.println("A lista:"+lista);
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número inteiro e positivo.");
            }
        }
    }


    public static void verificandoAprovacaoAluno2(Scanner scanner){
        ArrayList<Map<String,Object>> lista = new ArrayList<>();
        while (true){
            Map<String,Object> alunos = new LinkedHashMap<>();
            String nome ="";
            while (true){
                System.out.print("Digite o nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Erro. Digite um nome!!!");
                }else {
                    if (!nome.matches("[a-z-A-Z\\s]+")){
                        System.out.println("Nome aceita apenas letras e espaços. Tente novamente.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        alunos.put("Nome", nome);
                        break;
                    }
                }
            }
            float media=0;
            while (true){
                try {
                    System.out.print("Média:");
                    media = Float.parseFloat(scanner.nextLine());
                    if (media<=-1 || media>=11){
                        System.out.println("Digite uma média entre 0 e 10.");
                    }else {
                        alunos.put("Média", media);
                        if (media>=7){
                            alunos.put("Situação","aprovado(a)");
                        } else if (media>=5 && media<=6.9) {
                            alunos.put("Situação","em recuperação");
                        }else {
                            alunos.put("Situação","reprovado(a)");
                        }
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número válido.");
                }
            }
            lista.add(alunos);
            String addNovoAluno;
            do {
                System.out.print("Quer adicionar outro aluno?(sim/não):");
                addNovoAluno = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoAluno.equals("sim") && !addNovoAluno.equals("não"));
            if (addNovoAluno.equals("não")){
                break;
            }
        }
        for (Map<String,Object> dados : lista){
            for (Map.Entry<String,Object> entry : dados.entrySet()){
                System.out.println(entry.getKey()+": "+entry.getValue());
            }
            for (int n=0;n<22;n++){
                System.out.print("=");
            }
            System.out.println();
        }
    }

    public static void sorteioOrdemJogadores2(Scanner scanner,Random random){
        Map<String, Integer> jogador = new LinkedHashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("jogador 4", random.nextInt(10)+1);
        System.out.println("===Sorteio Jogadores===");
        for (Map.Entry<String,Integer> entry : jogador.entrySet()){
            System.out.println(entry.getKey()+" tirou: "+entry.getValue());
            try {
                Thread.sleep(300);
            }catch (InterruptedException erro){
                erro.printStackTrace();
            }
        }
        List<Map.Entry<String,Integer>> ranking = new ArrayList<>(jogador.entrySet());
        ranking.sort((entry1,entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        System.out.println("===Ranking Jogadores===");
        for (int n=0;n<ranking.size();n++){
            Map.Entry<String,Integer> entry = ranking.get(n);
            System.out.println((n+1)+"º lugar: "+entry.getKey()+" com "+entry.getValue());
        }
    }

    public static void verificandoAposentadoria(Scanner scanner){
        ArrayList<Map<String,Object>> lista = new ArrayList<>();
        while (true){
            Map<String,Object> dadosPessoas = new LinkedHashMap<>();
            String nome="";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Digite nome!!!");
                    continue;
                }
                if (!nome.matches("[a-zA-Z\\s]+")){
                    System.out.println("Só é permitido letras e espaços, tente novamente.");
                    continue;
                }
                nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                dadosPessoas.put("Nome",nome);
                break;
            }
            int anoAtual = Year.now().getValue();
            int anoNascimento=0;
            while (true){
                try {
                    System.out.print("Digite o ano de nascimento:");
                    anoNascimento = Integer.parseInt(scanner.nextLine());
                    if (anoNascimento<=1924 || anoNascimento>=anoAtual){
                        System.out.println("Digite um ano válido.");
                    }else {
                        dadosPessoas.put("Ano Nascimento",anoNascimento);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite uma data válida.");
                }
            }
            int ctps=0;
            while (true){
                try {
                    System.out.print("Digite o número da CTSP:");
                    ctps = Integer.parseInt(scanner.nextLine());
                    if (ctps>=1){
                        dadosPessoas.put("Nº CTPS",ctps);
                        int anoContratacao=0;
                        while (true){
                            try {
                                System.out.print("Ano de contratação:");
                                anoContratacao = Integer.parseInt(scanner.nextLine());
                                if (anoContratacao<=anoNascimento+16){
                                    System.out.println("Erro, verifique a data de contratação, precisa ser maior que o ano que você completoi 16 anos.");
                                }else {
                                    dadosPessoas.put("Ano de Contratação",anoContratacao);
                                    break;
                                }
                            }catch (NumberFormatException erro){
                                System.out.println("Digite um ano válido.");
                            }
                        }
                        float salario=0;
                        while (true){
                            try {
                                System.out.print("Digite o salário:R$");
                                salario = Float.parseFloat(scanner.nextLine());
                                if (salario<=1450){
                                    System.out.println("Salário minimo=R$ 1450 | Tente novamente.");
                                }else {
                                    dadosPessoas.put("Salário",salario);
                                    break;
                                }
                            }catch (NumberFormatException erro){
                                System.out.println("Digite um valor válido.");
                            }
                        }
                        int anoAposentadoria = anoContratacao+35;
                        dadosPessoas.put("Ano Aposentadoria",anoAposentadoria);
                        if (anoAposentadoria>=anoAtual){
                            int anosParaAposentar = anoAposentadoria-anoAtual;
                            dadosPessoas.put("Quantos anos faltam para você se aposentar?",anosParaAposentar);

                        }else {
                            int aposentou = anoAtual-anoAposentadoria;
                            dadosPessoas.put("Há quantos anos está aposentado(a)",aposentou);
                        }
                        break;
                    }else {
                        String semCTPS="";
                        dadosPessoas.put("Sem CTPS",semCTPS);
                        System.out.println("Você não tem CTPS, logo não poderá se aposentar.");
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor compativel.");
                }
            }
            lista.add(dadosPessoas);
            String addNovaPessoa;
            do {
                System.out.print("Quer cadastrar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("não") && !addNovaPessoa.equals("sim"));
            if (addNovaPessoa.equals("não")){
                for (int n=0;n<30;n++){
                    System.out.print("=");
                }
                System.out.println();
                for (Map<String,Object> dados : lista){
                    for (Map.Entry<String,Object> entry : dados.entrySet()){
                        System.out.println(entry.getKey()+": "+entry.getValue());
                    }
                    for (int n=0;n<30;n++){
                        System.out.print("=");
                    }
                    System.out.println();
                }
                break;
            }
        }
    }

    public static void verificandoMaiorMenorIdadeMetodo2(Scanner scanner){
        ArrayList<Pessoas> lista = new ArrayList<>();
        int totalMaior=0, totalMenor=0;
        while (true){
            String nome="";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Digite um nome válido.");
                }else {
                    if (!nome.matches("[a-zA-Z\\s]+")){
                        System.out.print("Nome só pode conter letras e espaços.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        break;
                    }
                }
            }
            int idade = 0;
            while (true){
                try {
                    System.out.print("Idade:");
                    idade = Integer.parseInt(scanner.nextLine());
                    if (idade<=0){
                        System.out.println("Digite um valor válido.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.print("Digite um valor válido.");
                }
            }
            lista.add(new Pessoas(nome, idade));
            String addNovaPessoa;
            do {
                System.out.print("Quer adicionar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("sim") && !addNovaPessoa.equals("não"));
            if (addNovaPessoa.equals("não")){
                for (Pessoas dados : lista){
                    if (dados.idade>=18){
                        totalMaior++;
                        System.out.println(dados.nome+", é maior de idade.");
                    }else {
                        totalMenor++;
                        System.out.println(dados.nome+", é menor de idade.");
                    }
                }
                System.out.println("Total maior de idade:"+totalMaior+" | Total menor de idade:"+totalMenor);
                break;
            }

        }
    }
    static class Pessoas{
        private String nome;
        private int idade;

        public Pessoas(String nome, int idade){
            this.nome = nome;
            this.idade = idade;
        }
    }

    public static void verificandoMediaAlunos(Scanner scanner){
        ArrayList<Aluno> lista = new ArrayList<>();
        while (true){
            String nome="";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("O nome não pode ser vázio, tente novamente.");
                    continue;
                }
                if (!nome.matches("[a-zA-Z\\s]+")){
                    System.out.println("O nome só pode conter letras e espaços, tente novamente.");
                    continue;
                }
                nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                break;
            }
            float nota1=0;
            while (true){
                try {
                    System.out.print("Primeira nota:");
                    nota1 = Float.parseFloat(scanner.nextLine());
                    if (nota1<=-1 || nota1>=11){
                        System.out.print("Digite uma nota válida entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("ERRO.Digite uma nota válida.");
                }
            }
            float nota2 = 0;
            while (true){
                try {
                    System.out.print("Segunda nota:");
                    nota2 = Float.parseFloat(scanner.nextLine());
                    if (nota2<=-1){
                        System.out.println("Digite uma nota válida entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            float media = (nota1+nota2)/2;
            lista.add(new Aluno(nome,nota1,nota2,media));
            String addNovoAluno;
            do {
                System.out.print("Quer adicionar outro aluno?(sim/não):");
                addNovoAluno = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoAluno.equals("não") && !addNovoAluno.equals("sim"));
            if (addNovoAluno.equals("não")){
                break;
            }
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-10s %-8s%n","No","Nome","Média");
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            Aluno dados = lista.get(i);
            System.out.printf("%-4d %-10s %-8.2f%n",i,dados.getNome(),dados.getMedia());
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar.):");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>Finalizando o programa...");
            }else {
                if (opc<lista.size()){
                    Aluno aluno = lista.get(opc);
                    System.out.println("As notas de "+aluno.getNome()+", foram: "+aluno.getNota1()+" e "+aluno.getNota2());
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

    public static void verificandoPesoPessoas(Scanner scanner){
        ArrayList<Pessoa> lista = new ArrayList<>();
        float maiorPeso = Float.NEGATIVE_INFINITY, menorPeso = Float.POSITIVE_INFINITY;
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            float peso=0;
            while (true){
                try {
                    System.out.print("Digite o peso:");
                    peso = Float.parseFloat(scanner.nextLine());
                    if (peso<=0){
                        System.out.println("Digite um valor compativel.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.print("Digite um peso válido.");
                }
            }
            if (peso>maiorPeso){
                maiorPeso=peso;
            }
            if (peso<menorPeso){
                menorPeso=peso;
            }
            lista.add(new Pessoa(nome,peso));
            String addNovaPessoa;
            do {
                System.out.print("Quer adicionar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("não") && !addNovaPessoa.equals("sim"));
            if (addNovaPessoa.equals("não")){
                break;
            }
        }
        for (Pessoa dados : lista){
            System.out.println(dados.nome+" |Peso:"+dados.peso);
        }
        for (Pessoa dados : lista){
            if (dados.peso==maiorPeso){
                System.out.println("O maior peso da lista:"+dados.nome+" | Peso:"+dados.peso);
            }
        }
        for (Pessoa dados : lista){
            if (dados.peso==menorPeso){
                System.out.println("O menor peso da lista:"+dados.nome+" | Peso:"+dados.peso);
            }
        }
    }
    static  class Pessoa{
        private String nome;
        private float peso;

        public Pessoa(String nome, float peso){
            this.nome = nome;
            this.peso = peso;
        }
    }

    public static void verificandoAprovacaoAluno(Scanner scanner){
        List<Map<String,Object>> lista = new ArrayList<>();
        while (true){
            Map<String,Object> dados = new LinkedHashMap<>();
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            dados.put("Nome", nome);
            while (true){
                System.out.print("Média:");
                if (scanner.hasNextFloat()){
                    float media = scanner.nextFloat();
                    if (media<=-1 || media>=11){
                        System.out.println("Digite uma média entre 0 e 10.");
                    }else {
                        dados.put("Média", media);
                        if (media>=7){
                            dados.put("Situação","APROVADO(A)");
                        } else if (media>=5 && media<=6.9) {
                            dados.put("Situação","EM RECUPERAÇÃO");
                        }else {
                            dados.put("Situação", "REPROVADO(A)");
                        }
                        break;
                    }
                }else {
                    System.out.print("Digite um número válido.");
                    scanner.next();
                }
            }
            lista.add(dados);
            scanner.nextLine();
            String addNovoALuno;
            do {
                System.out.print("Quer adicionar outro aluno?(sim/não):");
                addNovoALuno = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoALuno.equals("não") && !addNovoALuno.equals("sim"));
            if (addNovoALuno.equals("não")){
                break;
            }

        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        for (Map<String,Object> dado : lista){
            for (Map.Entry<String,Object> entry : dado.entrySet() ){
                System.out.println(entry.getValue());
            }
            for (int n=0;n<22;n++){
                System.out.print("=");
            }
            System.out.println();
        }

    }

    public static void verificandoMaiorMenorIdade(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
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
        int totalMaior=0, totalMenor=0;
        for (List<Object> dado : lista){
            String nome = (String)dado.get(0);
            int idade = (int)dado.get(1);
            if (idade>=18){
                totalMaior++;
                System.out.println(nome+", é maior de idade.");
            }else {
                totalMenor++;
                System.out.println(nome+", é menor de idade.");
            }
        }
        System.out.println("Total maior de idade:"+totalMaior+" | Total menor de idade:"+totalMenor);
    }


    public static void jogosMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            System.out.print("Quantos jogos?:");
            if (scanner.hasNextInt()){
                quant = scanner.nextInt();
                if (quant<=0){
                    System.out.println("Digite um número maio ou igual a 1.");
                }else {
                    break;
                }
            }else {
                System.out.println("Digite um número inteiro maior que 1.");
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
        for (int n=0;n<jogos.size();n++){
            System.out.println("Jogo "+(n+1)+": "+jogos.get(n));
        }
    }

    public static void verificandoNumerosParesImpares(Scanner scanner){
        ArrayList<Integer> lista = obtendoNumeros(scanner);
        ArrayList<Integer> listaPar = filtroPar(lista);
        ArrayList<Integer> listaImpar = filtroImpar(lista);
        System.out.println("A lista:"+lista);
        System.out.println("A lista de impares:"+listaImpar);
        System.out.println("A lista de pares:"+listaPar);
    }
    public static ArrayList<Integer> obtendoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (numeros<=-1){
                    System.out.println("Digit eum número positivo.");
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
                        continue;
                    }else {
                        lista.add(numeros);
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
            }catch (NumberFormatException erro){
                System.out.println("Digite um número inteiro positivo.");
            }
        }
        return lista;
    }

    public static ArrayList<Integer> filtroPar(ArrayList<Integer> lista){
        ArrayList<Integer> listaPar = new ArrayList<>();
        for (int numero: lista){
            if (numero%2==0){
                listaPar.add(numero);
            }
        }
        return listaPar;
    }
    public static ArrayList<Integer> filtroImpar(ArrayList<Integer> lista){
        ArrayList<Integer> listaImpar = new ArrayList<>();
        for (int numero: lista){
            if (numero%2!=0){
                listaImpar.add(numero);
            }
        }
        return listaImpar;
    }



    public static void calculandoMatriz(Scanner scanner){
        int[][] matriz = new int[3][3];
        int somap=0, somac3=0,maiorl2=Integer.MIN_VALUE;
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.print("Digite um número para a posição ["+l+"]["+c+"]:");
                matriz[l][c] = scanner.nextInt();
            }
        }
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.printf("[ %d ]",matriz[l][c]);
                if (matriz[l][c]%2==0){
                    somap+=matriz[l][c];
                }
            }
            System.out.println();
        }
        for (int c=0;c<3;c++){
            somac3+=matriz[c][2];
        }
        for (int l=0;l<3;l++){
            if (matriz[1][l]>maiorl2){
                maiorl2=matriz[1][l];
            }
        }
        System.out.println("A soma dos números pares:"+somap);
        System.out.println("A soma da coluna C3:"+somac3);
        System.out.println("O maior da linha 2:"+maiorl2);
    }



    public static void sorteioOrdemJogadores(Scanner scanner, Random random){
        Map<String,Integer> jogador = new LinkedHashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10)+1);
        System.out.println("===Sorteio Jogadores===");
        for (Map.Entry<String,Integer> entry : jogador.entrySet()){
            System.out.println(entry.getKey()+", tirou: "+entry.getValue());
            try {
                Thread.sleep(300);
            }catch (InterruptedException erro){
                erro.printStackTrace();
            }
        }
        List<Map.Entry<String,Integer>> ranking = new ArrayList<>(jogador.entrySet());
        ranking.sort((entry1,entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        System.out.println("===Ranking jogadores===");
        for (int n=0;n<ranking.size();n++){
            Map.Entry<String,Integer> entry = ranking.get(n);
            System.out.println((n+1)+"º lugar: "+entry.getKey()+" com "+entry.getValue());
        }
    }

}
