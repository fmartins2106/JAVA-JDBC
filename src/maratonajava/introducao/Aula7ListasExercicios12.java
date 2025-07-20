package academy.devdojo.maratonajava.introducao;


import java.util.*;
import java.time.*;
public class Aula7ListasExercicios12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        verificando peso e imc das pessoas
        verificandoPesoPessoasImc(scanner);

//        jogo jo ke po
        jogoJoKePo(scanner,random);

        //        verificando aposentadoria
        verificandoAposentadoria2(scanner);

//        verificando a media do aluno
        verificandoAlunoAprovadoReprovado3(scanner);

//        sorteando oordenando
        rankingJogadores5(scanner,random);

//        verificandos e aluno está aprovado.
        verificandoAlunoAprovadoReprovado2(scanner);

//        verificando aposentadoria
        verificandoAposentadoria(scanner);

//        verificando se o aluno está aprovado ou reprovado.
        verifiacandoAlunoAprovadoReprovado(scanner);

//        verificando jogadores e ordenando ranking
        rankingJogadores4(scanner, random);

//        verificando jogadores  e ranking
        rankingJogadores3(scanner, random);

//        matriz
        calculandoMatriz2(scanner);

//        verificando jogadores e ranking
        rankingJogadores2(scanner,random);

// verificando dados pessoas
        verificandoDadosPessoas(scanner);

//        verificando maior e menor de idade
        verificandoMaiorMenorIdade(scanner);

//        verificando peso
        verificandoPesoPessoas(scanner);

//        verificando a media de alunos
        verificandoMediaAlunos(scanner);

//        verificando idade maior e menor
        listaMaiorMenorIdade(scanner);

//        jogos mega semana
        jogosMegaSena(scanner, random);

//        verificando numeros pares e impares
        separandoParesImpares(scanner);

// calculando matriz
        calculandoMatriz(scanner);

//        sorteio orde dos jogadores
        rankingJogadores(scanner,random);
        scanner.close();
    }

    public static void verificandoPesoPessoasImc(Scanner scanner){
        ArrayList<CadastroPessoas> lista = new ArrayList<>();
        while (true){
            String nome = "";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Digite seu nome!");
                }else {
                    if (!nome.matches("[a-zA-Z\\s]+")){
                        System.out.println("Digite apenas letras e espaços, tente novamente.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        break;
                    }
                }
            }
            int idade =0;
            while (true){
                try {
                    System.out.print("Idade:");
                    idade = Integer.parseInt(scanner.nextLine());
                    if (idade<=0){
                        System.out.println("ERRO.Digite um número maior que 1.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número válido.");
                }
            }
            float peso = 0;
            while (true){
                try {
                    System.out.print("Peso:");
                    peso = Float.parseFloat(scanner.nextLine());
                    if (peso<=0){
                        System.out.println("Digite um peso maior que 1.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número válido.");
                }
            }
            float altura =0;
            while (true){
                try {
                    System.out.print("Altura:");
                    altura = Float.parseFloat(scanner.nextLine());
                    if (altura<=0){
                        System.out.println("Digite altura maior que 1.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número válido.");
                }
            }
            float imc = peso/(altura*2);
            lista.add(new CadastroPessoas(nome,idade,peso,altura,imc));
            String novaPessoa;
            do {
                System.out.print("Quer cadastrar outra pessoa?(sim/não):");
                novaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!novaPessoa.equals("sim") && !novaPessoa.equals("não"));
            if (novaPessoa.equals("não")){
                break;
            }
        }
        for (int n=0;n<50;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-10s %-8s %-8s %-8s %-8s\n","No","Nome","Idade","Peso","Altura","imc");
        for (int n=0;n<50;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            CadastroPessoas pessoas = lista.get(i);
            System.out.printf("%-4d %-10s %-8d %-8.2f %-8.2f %-8.2f\n",i, pessoas.getNome(),pessoas.getIdade(),pessoas.getPeso(),pessoas.getAltura(),pessoas.getImc());
        }
        for (int n=0;n<50;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer avaliar IMC de qual pessoa?(Digite 999 para parar):");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>Finalizando...");
                break;
            }else {
                if (opc<lista.size()){
                    CadastroPessoas pessoas = lista.get(opc);
                        if (pessoas.getImc()<=20){
                            System.out.println(pessoas.getNome()+", seu IMC: "+String.format("%.2f", pessoas.getImc())+" | Está baixo, você precisa se alimentar direito, procure um médico.");
                        }else if (pessoas.getImc()>=21 && pessoas.getImc()<=25){
                            System.out.println(pessoas.getNome()+", seu IMC:"+String.format("%.2f",pessoas.getImc())+" | Você está com peso ideal, Parabéns!!!");
                        }else {
                            System.out.println(pessoas.getNome()+", seu IMC:"+String.format("%.2f",pessoas.getImc())+" | Você está acima do peso, procure um médico.");
                        }
                }
            }
        }
    }
    static class CadastroPessoas{
        private String nome;
        private int idade;
        private float peso;
        private float altura;
        private float imc;

        public CadastroPessoas(String nome,int idade,float peso, float altura, float imc){
            this.nome = nome;
            this.idade = idade;
            this.peso = peso;
            this.altura = altura;
            this.imc = imc;
        }
        public String getNome() {
            return nome;
        }
        public int getIdade() {
            return idade;
        }
        public float getPeso() {
            return peso;
        }
        public float getAltura() {
            return altura;
        }
        public float getImc() {
            return imc;
        }
    }


    public static void jogoJoKePo(Scanner scanner, Random random){
        int jogador = 0;
        while (true){
            int computador = random.nextInt(3)+1;
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            while (true){
                System.out.print("Digite uma da opções acima:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    if (jogador<=-1 || jogador>=4){
                        System.out.println("Digite uma opção entre 1 e 3.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("ERRO.Digite um valor válido.");
                    scanner.next();
                }
            }
            System.out.println("Processando...");
            try {
                Thread.sleep(300);
            }catch (InterruptedException erro){
                erro.printStackTrace();
            }
            System.out.println("Computador:"+computador);
            if (jogador==computador){
                System.out.println("Jogador:"+jogoPedraPapelTesoura(jogador)+" | Computador:"+jogoPedraPapelTesoura(computador)+" |Deu empate.");
            } else if (jogador==1 && computador==3 || jogador==2 && computador==1 || jogador==3 && computador==2) {
                System.out.println("Jogador:"+jogoPedraPapelTesoura(jogador)+" | Computador:"+jogoPedraPapelTesoura(computador)+" |Você venceu!!!");
            }else {
                System.out.println("Jogador:"+jogoPedraPapelTesoura(jogador)+" |Computador:"+jogoPedraPapelTesoura(computador)+" | Você perdeu!!!");
            }
            scanner.nextLine();
            String jogarNovamente;
            do {
                System.out.print("Quer jogar novamente?(sim/não):");
                jogarNovamente = scanner.nextLine().trim().toLowerCase();
            }while (!jogarNovamente.equals("sim") && !jogarNovamente.equals("não"));
            if (jogarNovamente.equals("não")){
                break;
            }
        }
    }
    public static String jogoPedraPapelTesoura(int escolha){
        switch (escolha){
            case 1: return "PEDRA";
            case 2: return "PAPEL";
            case 3: return "TESOURA";
        }
        return "";
    }


    public static void verificandoAlunoAprovadoReprovado3(Scanner scanner){
        List<Map<String,Object>> lista = new ArrayList<>();
        while (true){
            Map<String,Object> pessoa = new LinkedHashMap<>();
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            pessoa.put("Nome", nome);
            float media =0;
            while (true){
                try {
                    System.out.print("Media:");
                    media = scanner.nextFloat();
                    if (media<=-1){
                        System.out.println("Digite um número positivo.");
                    }else {
                        pessoa.put("Média", media);
                        if (media>=7){
                            pessoa.put("Situação", "Aprovado(a)");
                        } else if (media>=5 && media<=6.9) {
                            pessoa.put("Situação","Em recuperação");
                        }else {
                            pessoa.put("Situação","Reprovado(a)");
                        }
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            lista.add(pessoa);
            scanner.nextLine();
            String addNovoAluno;
            do {
                System.out.print("Quer adicionar outro aluno?(sim/não):");
                addNovoAluno = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoAluno.equals("não") && !addNovoAluno.equals("sim"));
            if (addNovoAluno.equals("não")){
                for (Map<String,Object> dadosAlunos : lista){
                    for (Map.Entry<String,Object> entry : dadosAlunos.entrySet()){
                        System.out.println(entry.getKey()+": "+entry.getValue());
                    }
                }
                break;
            }
        }
    }


    public static void rankingJogadores5(Scanner scanner, Random random){
        Map<String, Integer> jogador = new LinkedHashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10)+1);
        System.out.println("===Sorteio Jogadores===");
        for (Map.Entry<String,Integer> entry: jogador.entrySet()){
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


    public static void verificandoAposentadoria2(Scanner scanner){
        Map<String,Object> pessoas = new LinkedHashMap<>();
        System.out.print("Nome:");
        String nome = scanner.nextLine().trim();
        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
        pessoas.put("Nome",nome);
        System.out.print("Ano de nascimento:");
        int anoNascimento = scanner.nextInt();
        pessoas.put("Ano Nascimento",anoNascimento);
        int anoAtual = Year.now().getValue();
        int idade =  anoAtual-anoNascimento;
        pessoas.put("Idade",idade);
        System.out.print("Nº CTPS:");
        int ctps = scanner.nextInt();
        pessoas.put("CTPS",ctps);
        if (ctps!=0){
            System.out.print("Ano de contratação:");
            int anoContratacao = scanner.nextInt();
            pessoas.put("Ano Contratação:",anoContratacao);
            System.out.print("Salário:R$");
            float salario = scanner.nextInt();
            pessoas.put("Salário",salario);
            int anoAposentadoria = 35+anoContratacao;
            pessoas.put("Ano Aposentadoria",anoAposentadoria);
            int anosParaAposentadoria = anoAposentadoria-anoAtual;
            pessoas.put("Quantos anos faltam para se aposentar?",anosParaAposentadoria);
        }else {
            System.out.println(">>>Você não trabalhou, portanto não tem direito a aposentadoria.");
        }
        for (int n=0;n<100;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println(pessoas);
        for (int n=0;n<100;n++){
            System.out.print("=");
        }
        System.out.println();
        for (Map.Entry<String,Object> entry : pessoas.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }



    public static void verificandoAlunoAprovadoReprovado2(Scanner scanner){
        List<Map<String,Object>> alunos = new ArrayList<>();
        String nome;
        while (true){
            Map<String, Object> aluno = new LinkedHashMap<>();
            System.out.print("Nome:");
            nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            aluno.put("Nome",nome);
            float media=0;
            while (true){
                try {
                    System.out.print("Média:");
                    media = Float.parseFloat(scanner.nextLine());
                    if (media>=0 && media<=10){
                        aluno.put("Média",media);
                        if (media>=7){
                            aluno.put("Situação","APROVADO(A)");
                        } else if (media>=5 && media<=6.9) {
                            aluno.put("Situação","EM RECUPERAÇÃO");
                        }else {
                            aluno.put("Situação","REPROVADO(A)");
                        }
                        break;
                    }else {
                        System.out.println("Digite uma média válida.");
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            alunos.add(aluno);
            String addNovaAluno;
            do {
                System.out.print("Quer adicionar outro aluno na lista?:");
                addNovaAluno = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaAluno.equals("não") && !addNovaAluno.equals("sim"));
            if (addNovaAluno.equals("não")){
                for (Map<String,Object> dadosAluno : alunos){
                    for (Map.Entry<String,Object> entry : dadosAluno.entrySet()){
                        System.out.println(entry.getKey()+" : "+entry.getValue());
                    }
                }
                break;
            }
        }
    }


    public static void verificandoAposentadoria(Scanner scanner){
        Map<String,Object> dados = new LinkedHashMap<>();
        int anoAtual = Year.now().getValue();
        String nome;
        System.out.print("Digite o seu nome:");
        nome = scanner.nextLine().trim();
        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
        dados.put("Nome",nome);
        System.out.print("Digite o ano de nascimento:");
        int ano = scanner.nextInt();
        dados.put("Ano",ano);
        int idade = anoAtual-ano;
        dados.put("Idade",idade);
        System.out.print("Número da CTPS:");
        int ctps = scanner.nextInt();
        dados.put("CTPS:",ctps);
        if (ctps!=0){
            System.out.print("Ano da contratação:");
            int anoContratacao = scanner.nextInt();
            dados.put("Ano Contratação",anoContratacao);
            System.out.print("Salário:");
            float salario = scanner.nextFloat();
            dados.put("Salário", salario);
            int anoAposentadoria = anoContratacao+35;
            dados.put("Ano Aposentadoria",anoAposentadoria);
            int anosParaAposentar = anoAposentadoria-anoAtual;
            dados.put("Quantos Anos faltam para se aposentar?:",anosParaAposentar);
        }
        for (int n=0;n<30;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println(dados);
        for (int n=0;n<30;n++){
            System.out.print("=");
        }
        System.out.println();
        for (Map.Entry<String,Object> entry : dados.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }


    public static void verifiacandoAlunoAprovadoReprovado(Scanner scanner){
        Map<String,Object> aluno = new HashMap<>();
        System.out.print("Nome Aluno:");
        String nome = scanner.nextLine().trim();
        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
        aluno.put("Nome",nome);
        System.out.print("Digite a média de "+nome+":");
        float media = scanner.nextFloat();
        aluno.put("Média",media);
        if (media>=7){
            aluno.put("situação", "aprovado(a)");
        } else if (media>=5 && media<=6.9) {
            aluno.put("situação", "em recuperação!");
        }else {
            aluno.put("situação", "reprovado(a)");
        }
        for (int n=0;n<30;n++){
            System.out.print("=");
        }
        System.out.println();
        for (Map.Entry<String,Object> entry : aluno.entrySet()){
            System.out.println(entry.getKey()+ ": "+entry.getValue());
        }
        for (int n=0;n<30;n++){
            System.out.print("=");
        }
        System.out.println();
    }

    public static void rankingJogadores4(Scanner scanner, Random random){
        Map<String,Integer> jogador = new LinkedHashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10)+1);
        System.out.println("===Sorteio jogadores===");
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
            Map.Entry<String, Integer> entry = ranking.get(n);
            System.out.println((n+1)+ "º lugar: "+entry.getKey()+" com: "+entry.getValue());
        }
    }

    public static void rankingJogadores3(Scanner scanner, Random random){
        Map<String, Integer> jogador = new LinkedHashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10)+1);
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
        for (int i=0;i<ranking.size();i++){
            Map.Entry<String,Integer> entry = ranking.get(i);
            System.out.println((i+1)+"º lugar: "+entry.getKey()+" com: "+entry.getValue());
        }
    }



    public static void calculandoMatriz2(Scanner scanner){
        int[][] matriz= new int[3][3];
        int somap=0, somac3 = 0, maiorL2=Integer.MIN_VALUE;
        for (int l=0;l<matriz.length;l++){
            for (int c=0;c< matriz.length;c++){
                System.out.print("Digite um valor para posição:["+l+"]["+c+"]:");
                matriz[l][c]= scanner.nextInt();
            }
        }
        for (int l=0;l<matriz.length;l++){
            for (int c=0;c< matriz.length;c++){
                System.out.printf("[ %d ]",matriz[l][c]);
                if (matriz[l][c]%2==0){
                    somap+=matriz[l][c];
                }
            }
            System.out.println();
        }
        for (int c=0;c<matriz.length;c++){
            somac3+=matriz[c][2];
        }
        for (int l=0;l< matriz.length;l++){
            if (matriz[1][l]>maiorL2){
                maiorL2=matriz[1][l];
            }
        }
        System.out.println("A soma dos pares:"+somap);
        System.out.println("A soma da coluna 3:"+somac3);
        System.out.println("O maior da linha 2:"+maiorL2);
    }

    public static void rankingJogadores2(Scanner scanner, Random random){
        Map<String, Integer> jogador = new HashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10)+1);
        System.out.println("===Sorteio Jogadores===");
        for (Map.Entry<String, Integer> entry : jogador.entrySet()){
            System.out.println(entry.getKey()+" tirou: "+entry.getValue());
            try {
                Thread.sleep(300);
            }catch (InterruptedException erro){
                erro.printStackTrace();
            }
        }
        List<Map.Entry<String, Integer>> ranking = new ArrayList<>(jogador.entrySet());
        ranking.sort((entry1,entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        System.out.println("===Ranking Jogadores===");
        for (int i=0;i<ranking.size();i++){
            Map.Entry<String,Integer> entry = ranking.get(i);
                System.out.println((i+1)+" ficou: "+entry.getKey()+" com "+ entry.getValue());
        }
    }

    public static void verificandoDadosPessoas(Scanner scanner){
        ArrayList<PessoasLista> lista = new ArrayList<>();
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            int idade = 0;
            while (true){
                try {
                    System.out.print("Idade:");
                    idade = Integer.parseInt(scanner.nextLine());
                    if (idade<=0){
                        System.out.println("Digite uma idade válida.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            float peso=0;
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
            float altura=0;
            while (true){
                try {
                    System.out.print("Altura:");
                    altura = Float.parseFloat(scanner.nextLine());
                    if (altura<=0){
                        System.out.println("Digite um valor válido.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            float imc = peso/(altura*2);
            lista.add(new PessoasLista(nome,idade,peso,altura,imc));
            String cadastrarNovaPessoa;
            do {
                System.out.print("Quer cadastrar outra pessoa?(sim/não):");
                cadastrarNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!cadastrarNovaPessoa.equals("não") && !cadastrarNovaPessoa.equals("sim"));
            if (cadastrarNovaPessoa.equals("não")){
                break;
            }
        }
        for (int n=0;n<50;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-10s %-8s %-8s %-8s %-8s %n","No","Nome","Idade","Peso","Altura","IMC");
        for (int n=0;n<50;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i< lista.size();i++){
            PessoasLista pessoas = lista.get(i);
            System.out.printf("%-4d %-10s %-8d %-8.2f %-8.2f %-8.2f\n",i,pessoas.getNome(),pessoas.getIdade(),pessoas.getPeso(),pessoas.getAltura(),pessoas.getImc());
        }
        for (int n=0;n<50;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer avaliar o IMC de qual pessoa?(Digite 999 para parar.)");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>Finalizando o programa...");
                break;
            }else {
                if (opc<lista.size()){
                    PessoasLista pessoas = lista.get(opc);
                    if (pessoas.getImc()<20){
                        System.out.println(pessoas.getNome()+", Seu IMC é:"+String.format("%.2f",pessoas.getImc())+" | Está muito abaixo do normal, procure um médico.");
                    } else if (pessoas.getImc()>=21 && pessoas.getImc()<=25) {
                        System.out.println(pessoas.getNome()+", Seu IMC é:"+String.format("%.2f",pessoas.getImc())+" | Está no valor idade. Parabens!!!");
                    }else {
                        System.out.println(pessoas.getNome()+", Seu IMC é:"+String.format("%.2f",pessoas.getImc())+" | Está acima do ideal, procure um médico.");
                    }
                }
            }
        }
    }
    static class PessoasLista{
        private String nome;
        private int idade;
        private float peso;
        private float altura;
        private float imc;

        public PessoasLista(String nome,int idade,float peso, float altura, float imc){
            this.nome = nome;
            this.idade = idade;
            this.peso = peso;
            this.altura = altura;
            this.imc = imc;
        }
        public String getNome() {
            return nome;
        }
        public int getIdade() {
            return idade;
        }
        public float getPeso() {
            return peso;
        }
        public float getAltura() {
            return altura;
        }
        public float getImc() {
            return imc;
        }
    }


    public static void verificandoMaiorMenorIdade(Scanner scanner){
        ArrayList<Pessoas> lista = new ArrayList<>();
        int totalMaiorIdade =0, totalMenorIdade=0;
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            System.out.print("Cidade:");
            String cidade = scanner.nextLine().trim();
            cidade = cidade.substring(0,1).toUpperCase()+cidade.substring(1).toLowerCase();
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
                    System.out.println("Digite um valor válido.");
                }
            }
            lista.add(new Pessoas(nome,cidade,idade));
            String addNovaPessoa;
            do {
                System.out.print("Quer adicionar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("não") && !addNovaPessoa.equals("sim"));
            if (addNovaPessoa.equals("não")){
                for (Pessoas dados : lista){
                    if (dados.idade>=18){
                        totalMaiorIdade++;
                        System.out.println(dados.nome+", mora em:"+dados.cidade+", é maior de idade.");
                    }else {
                        totalMenorIdade++;
                        System.out.println(dados.nome+", mora em:"+dados.cidade+", é menor de idade.");
                    }
                }
                System.out.println("Total maior de idade:"+totalMaiorIdade+" | Total menor de idade:"+totalMenorIdade);
                break;
            }
        }
    }
    static class Pessoas{
        private String nome;
        private String cidade;
        private int idade;

        public Pessoas(String nome, String cidade, int idade){
            this.nome = nome;
            this.cidade = cidade;
            this.idade = idade;
        }
    }

    public static void verificandoPesoPessoas(Scanner scanner){
         ArrayList<Pessoa> lista = new ArrayList<>();
        float maiorPeso= Float.NEGATIVE_INFINITY, menorPeso=Float.POSITIVE_INFINITY;
         while (true){
             System.out.print("Nome:");
             String nome = scanner.nextLine().trim();
             nome =  nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
             float peso =0;
             while (true){
                 try {
                     System.out.print("Qual o peso:");
                     peso = Float.parseFloat(scanner.nextLine());
                     if (peso<=0){
                         System.out.println("Digite um peso verdadeiro.");
                     }else {
                         break;
                     }
                 }catch (NumberFormatException erro){
                     System.out.println("Digite um peso verdadeiro.");
                 }
             }
             if (peso>maiorPeso){
                 maiorPeso = peso;
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
                 for (Pessoa dados : lista){
                     if (dados.peso==maiorPeso){
                         System.out.println("O maior peso da lista:"+dados.nome+" | Peso:"+dados.peso);
                     }
                     if (dados.peso==menorPeso){
                         System.out.println("O menor peso da lista:"+dados.nome+" | Peso:"+dados.peso);
                     }
                 }
                 break;
             }
         }

    }
    static class Pessoa{
        private String nome;
        private float peso;

        public Pessoa(String nome, float peso){
            this.nome = nome;
            this.peso = peso;
        }
    }


    public static void verificandoMediaAlunos(Scanner scanner){
        ArrayList<Aluno> lista = new ArrayList<>();
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
                        System.out.println("Digite uma nota entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.print("Digite um valor válido.");
                }
            }
            float nota2=0;
            while (true){
                try {
                    System.out.print("Digite a segunda nota:");
                    nota2 = Float.parseFloat(scanner.nextLine());
                    if (nota2<=-1 || nota2>=11){
                        System.out.println("Digite uma nota entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            float media = (nota2+nota1)/2;
            lista.add(new Aluno(nome, nota1, nota2, media));
            String addNovoAluno;
            do {
                System.out.print("Quer calcular a média de outro aluno?(sim/não):");
                addNovoAluno = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoAluno.equals("sim") && !addNovoAluno.equals("não"));
            if (addNovoAluno.equals("não")){
                break;
            }
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-10s %-8s%n", "No", "Nome","Média");
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
            System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar.)");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>Finalizando...");
                break;
            }else {
                if (opc<lista.size()){
                    Aluno dadosAluno = lista.get(opc);
                    System.out.println("As notas de "+dadosAluno.getNome()+", foram:"+ dadosAluno.getNota1()+" e "+dadosAluno.getNota2());
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
        int maiorIdade=0, menorIdade=0;
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
        for (List<Object> dado : lista){
            String nome = (String)dado.get(0);
            int idade = (int)dado.get(1);
            if (idade>=18){
                maiorIdade++;
                System.out.println(nome+", é maior de idade.");
            }else {
                menorIdade++;
                System.out.println(nome+", é menor de idade.");
            }
        }
        System.out.println("Total de pessoas maiores de idade:"+maiorIdade+" | Total de pessoas menores de idade:"+menorIdade);
    }


    public static void jogosMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            try {
                System.out.print("Quantos jogos?:");
                quant = Integer.parseInt(scanner.nextLine());
                if (quant<=0){
                    System.out.println("Digite um valor maior que 0.");
                }else {
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número inteiro.");
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
            System.out.println("jogo "+(i+1)+":"+jogos.get(i));
        }
    }

    public static void separandoParesImpares(Scanner scanner){
        ArrayList<Integer> lista = obtendoNumeros(scanner);
        ArrayList<Integer> listaPares = filtroPar(lista);
        ArrayList<Integer> listaImpares = filtroImpar(lista);
        System.out.println("A lista:"+lista);
        System.out.println("A lista de pares:"+listaPares);
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
                        System.out.println("Número repetido, tente outro.");
                        continue;
                    }else {
                        lista.add(numeros);
                    }
                    String addNovoNumero;
                    do {
                        System.out.print("Quer adicionar outro número?:");
                        addNovoNumero = scanner.nextLine().trim().toLowerCase();
                    }while (!addNovoNumero.equals("não") && !addNovoNumero.equals("sim"));
                    if (addNovoNumero.equals("não")){
                        break;
                    }
                }
            } catch (NumberFormatException erro){
                System.out.println("Digite um número válido.");
            }
        }
        return lista;
    }

    public static ArrayList<Integer> filtroPar(ArrayList<Integer> numeros){
        ArrayList<Integer> listaPar = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2==0){
                listaPar.add(numero);
            }
        }
        return listaPar;
    }
    public static ArrayList<Integer> filtroImpar(ArrayList<Integer> numeros){
        ArrayList<Integer> listaImpar = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2!=0){
                listaImpar.add(numero);
            }
        }
        return listaImpar;
    }

    public static void calculandoMatriz(Scanner scanner){
        int somap=0, somac3=0, maiorl2 = Integer.MIN_VALUE;
        int[][] matriz = new int[3][3];
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.print("Digite um número para posição: ["+l+"]["+c+"]:");
                matriz[l][c] = scanner.nextInt();
            }
        }
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.printf("[ %d ]", matriz[l][c]);
                if (matriz[l][c] %2==0){
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
        System.out.println("A soma dos números pares da matriz:"+somap);
        System.out.println("A soma da coluna C3:"+somac3);
        System.out.println("O maior número da linha 2:"+maiorl2);

    }


    public static void rankingJogadores(Scanner scanner, Random random){
        Map<String, Integer> jogador = new HashMap<>();
        jogador.put("Jogador 1",random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10)+1);
        System.out.println("===Sorteio Jogadores===");
        for (Map.Entry<String, Integer> entry : jogador.entrySet()){
            System.out.println(entry.getKey()+" tirou:"+entry.getValue());
            try {
                Thread.sleep(300);
            }catch (InterruptedException erro){
                erro.printStackTrace();
            }
        }
        List<Map.Entry<String,Integer>> ranking = new ArrayList<>(jogador.entrySet());
        ranking.sort((entry1,entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        System.out.println("===RANKING JOGADORES===");
        for (int i=0;i<ranking.size();i++){
            Map.Entry<String, Integer> entry = ranking.get(i);
            System.out.println((i+1)+ " posição:"+entry.getKey()+" com "+entry.getValue());

        }
    }

}
