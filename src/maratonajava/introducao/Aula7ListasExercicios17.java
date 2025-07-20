package academy.devdojo.maratonajava.introducao;



import java.util.*;
import java.time.*;


public class Aula7ListasExercicios17 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Random random = new Random();

//        10verificando peso
        verificandoPesoPessoas(scanner);

//        9verificando uma expresão
        verificandoExpressao(scanner);

//        8verificando dados jogadores
        verificandoDadosJogadores(scanner);

//        situação aluno
        situacaoNotasAluno(scanner);

//        7adicionando numeros na lista
        adicionandoNumerosListaEPosicoes(scanner);

//        6verificando numeros impares e pares.
        verificandoNumerosImparesPares(scanner);

//        5verificandoNotasAlunos
        calculandoMediaAlunos(scanner);

//        4casdastrando pessoas
        cadastrandoPessoas(scanner);

//  jogos mega sena
        jogosMegaSena(scanner,random);

//        3verificando aposentadoria
        verificandoAposentadoria(scanner);

//        2sorteio e ranking sorteio
        sorteioRanking(scanner, random);

//        1verificando Dados Jogadores
        verificandoDadosJogadores2(scanner);
        scanner.close();
    }

    public static void verificandoPesoPessoas(Scanner scanner){
        ArrayList<Pessoas> lista = new ArrayList<>();
        while (true){
            String nome="";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo nome não pode ser vázio, tente novamente");
                }else {
                    if (!nome.matches("^[a-zA-Z\\s]+(\\s[a-zA-Z]+)+$")){
                        System.out.println("Digite seu nome completo.");
                    }else {
                        nome = verificandoNomePessoas(nome);
                        break;
                    }
                }
            }
            int idade = 0;
            while (true){
                System.out.print("Idade:");
                if (scanner.hasNextInt()){
                    idade = scanner.nextInt();
                    if (idade<=0){
                        System.out.println("Digite um valor igual ou maior que 1.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Digite um valor igual ou maior que 1.");
                    scanner.next();
                }
            }
            scanner.nextLine();
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
                    System.out.println("Digite um valor válido.");
                }
            }
            float altura=0;
            while (true){
                try {
                    System.out.print("Altura:");
                    altura = Float.parseFloat(scanner.nextLine());
                    if (altura<=0){
                        System.out.println("Digite um valor maior que 0.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            float imc = peso/(altura*2);
            lista.add(new Pessoas(nome,idade,peso,altura,imc));
            String addNovaPessoa="";
            while (true){
                System.out.print("Quer cadastrar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
                if (addNovaPessoa.equals("sim") || addNovaPessoa.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não");
                }
            }
            if (addNovaPessoa.equals("não")){
                break;
            }
        }
        for (int n=0;n<65;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-25s %-8s %-8s %-8s %-8s%n","No","Nome","Idade","Peso","Altura","IMC");
        for (int n=0;n<65;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            Pessoas pessoa = lista.get(i);
            System.out.printf("%-4d %-25s %-8d %-8.2f %-8.2f %-8.2f%n",i,pessoa.getNome(),pessoa.getIdade(),pessoa.getPeso(),pessoa.getAltura(),pessoa.getImc());
        }
        for (int n=0;n<65;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer analisar o IMC de qual participante?(Digite 999 para parar.):");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>>Finalizando o programa...");
                break;
            }else {
                if (opc<lista.size()){
                    Pessoas pessoa = lista.get(opc);
                    if (pessoa.getImc()<=20){
                        System.out.println(pessoa.getNome()+", seu IMC é:"+String.format("%.2f",pessoa.getImc())+" | Você precisa procurar um médico, seu IMC está abaixo do recomendado.");
                    } else if (pessoa.getImc()>=21 && pessoa.getImc()<=25) {
                        System.out.println(pessoa.getNome()+", seu IMC é:"+String.format("%.2f",pessoa.getImc())+" | Seu IMC está muito bom, parabéns!!!");
                    }else {
                        System.out.println(pessoa.getNome()+", seu IMC é:"+String.format("%.2f",pessoa.getImc())+" | Seu IMC está muito alto, procure um médico urgente!!!");
                    }
                }
            }
        }
    }
    static class Pessoas{
        private  String nome;
        private int idade;
        private float peso;
        private float altura;
        private float imc;

        public Pessoas(String nome, int idade, float peso, float altura, float imc){
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
        public float getPeso(){
            return peso;
        }
        public float getAltura(){
            return altura;
        }
        public float getImc(){
            return imc;
        }
    }
    public static String verificandoNomePessoas(String nome){
        String[] nomes = nome.toLowerCase().split("\\s");
        StringBuilder arrumandoNome = new StringBuilder();
        for (String nomePessoas : nomes){
            if (!nome.isEmpty()){
                arrumandoNome.append(nomePessoas.substring(0,1).toUpperCase()).append(nomePessoas.substring(1)).append(" ");
            }
        }
        return arrumandoNome.toString().trim();
    }

    public static void verificandoExpressao(Scanner scanner){
        Stack<Character> pilhaParenteses = new Stack<>();
        System.out.print("Digite sua expressão:");
        String expressao = scanner.nextLine().trim();
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

    public static void verificandoDadosJogadores(Scanner scanner){
        ArrayList<Map<String,Object>> lista = new ArrayList<>();
        while (true){
            Map<String,Object> jogador = new LinkedHashMap<>();
            String nome;
            while (true){
                System.out.print("Digite o nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Digite  seu nome completo.");
                }else {
                    if (!nome.matches("^[a-zA-Z\\s]+(\\s[a-zA-Z]+)+$")){
                        System.out.println("Digite o seu nome completo.");
                    }else {
                        nome = stringNome(nome);
                        jogador.put("Nome",nome);
                        break;
                    }
                }
            }
            int partidas=0;
            while (true){
                try {
                    System.out.print("Quantas partidas?:");
                    partidas = Integer.parseInt(scanner.nextLine());
                    if (partidas<=0){
                        System.out.println("Digite um valor maior que 1.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número maior que 1.");
                }
            }
            ArrayList<Integer> totalGols = new ArrayList<>();
            for (int g=0;g<partidas;g++){
                while (true){
                    try {
                        System.out.print("Quantos gol(s) na "+(g+1)+"º partida?:");
                        int gols = Integer.parseInt(scanner.nextLine());
                        if (gols<=-1){
                            System.out.println("Digite um número maior ou igual a 0.");
                        }else {
                            totalGols.add(gols);
                            jogador.put("Gol(s)",totalGols);
                            jogador.put("Total Gols",totalGols.stream().mapToInt(Integer::intValue).sum());
                            break;
                        }
                    }catch (NumberFormatException erro){
                        System.out.println("Digite um valor maior ou igual a 0.");
                    }
                }
            }
            lista.add(jogador);
            String addNovoJogador;
            while (true){
                System.out.print("Quer adicionar outro jogador?(sim/não):");
                addNovoJogador = scanner.nextLine().trim().toLowerCase();
                if (addNovoJogador.equals("sim") || addNovoJogador.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (addNovoJogador.equals("não")){
                for (Map<String,Object> dadosJogadores : lista){
                    for (int n=0;n<30;n++){
                        System.out.print("=");
                    }
                    System.out.println();
                    for (Map.Entry<String,Object> entry : dadosJogadores.entrySet()){
                        System.out.println(entry.getKey()+": "+entry.getValue());
                    }
                    ArrayList<Integer> golsPorPartida = (ArrayList<Integer>) dadosJogadores.get("Gol(s)");
                    for (int i=0;i< golsPorPartida.size();i++){
                        System.out.println(">>>Na partida "+(i+1)+", fez:"+golsPorPartida.get(i));
                    }
                }
                break;
            }
        }
    }
    public static String stringNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            if (!palavra.isEmpty()){
                nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
            }
        }
        return nomeFormatado.toString().trim();
    }



    public static void situacaoNotasAluno(Scanner scanner){
        ArrayList<Map<String,Object>> listaAlunos = new ArrayList<>();
        while (true){
            Map<String,Object> alunos = new LinkedHashMap<>();
            String nome="";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("ERRO.Campo não pode ficar vázio, tente outro vez.");
                }else {
                    if (!nome.matches("^[a-zA-Z\\s]+(\\s+[a-zA-Z]+)+$")){
                        System.out.println("Digite seu nome completo.");
                    }else {
                        alunos.put("Nome",nome);
                        break;
                    }
                }
            }
            while (true){
                try {
                    System.out.print("Média:");
                    float media = Float.parseFloat(scanner.nextLine());
                    if (media<=-1 || media>=11){
                        System.out.println("Digite uma média entre 1 e 10.");
                        continue;
                    }else {
                        if (media>=7){
                            alunos.put("Situação","Aprovado(a).");
                        }else if (media>=5 && media<=6.9){
                            alunos.put("Situação","Em recuperação.");
                        }else {
                            alunos.put("Situação","Reprovado(a)");
                        }
                    }
                    break;
                }catch (NumberFormatException erro){
                    System.out.println("Digite uma media entre 0 e 10.");
                }
            }
            listaAlunos.add(alunos);
            String addNovoAluno;
            do {
                System.out.print("Quer adicionar outro aluno?(sim/não)");
                addNovoAluno = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoAluno.equals("não") && !addNovoAluno.equals("sim"));
            if (addNovoAluno.equals("não")){
                break;
            }
        }
        for (Map<String,Object> dadosAlunos : listaAlunos){
            for (int n=0;n<50;n++){
                System.out.print("=");
            }
            System.out.println();
            for (Map.Entry<String,Object> entry : dadosAlunos.entrySet()){
                System.out.println(entry.getKey()+": "+entry.getValue());
            }
        }
    }
    public static String nomeAlunoFormatado(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            if (!palavra.isEmpty()){
                nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
            }
        }
        return nomeFormatado.toString().trim();
    }



    public static void adicionandoNumerosListaEPosicoes(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (numeros<=-1){
                    System.out.println("Digite um número repetido.");
                }else {
                    boolean numeroRepetido =false;
                    for (int numero : lista){
                        if (numero==numeros){
                            numeroRepetido=true;
                            break;
                        }
                    }
                    if (numeroRepetido){
                        System.out.println("Número repetido, tente outro.");
                    }else {
                        if (lista.isEmpty() || numeros>=lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos=0;
                            while (pos<lista.size()){
                                if (numeros<=lista.get(pos)){
                                    lista.add(pos, numeros);
                                    System.out.println("Adiionado na posição:"+pos);
                                    break;
                                }
                                pos++;
                            }
                        }
                    }

                }
                String addNovoNumero;
                do {
                    System.out.print("Quer adicioanar outro número?(sim/não):");
                    addNovoNumero = scanner.nextLine().trim().toLowerCase();
                }while (!addNovoNumero.equals("sim") && !addNovoNumero.equals("não"));
                if (addNovoNumero.equals("não")){
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número inteiro e positivo.");
            }
        }
        System.out.println("A lista:"+lista);
    }


    public static void verificandoNumerosImparesPares(Scanner scanner){
        ArrayList<Integer> lista = obtendoNumeros(scanner);
        ArrayList<Integer> listaPar = filtroPar(lista);
        ArrayList<Integer> listaImpar = filtroImpar(lista);
        System.out.println("A lista:"+lista);
        System.out.println("A lista de pares:"+listaPar);
        System.out.println("A lista de impares:"+listaImpar);
    }
    public static ArrayList<Integer> obtendoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            System.out.print("Digite um número:");
            if (scanner.hasNextInt()){
                int numeros = scanner.nextInt();
                if (numeros<=-1){
                    System.out.println("Digite apenas números positivos.");
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("ERRO.Número repetido, tente outro.");
                    }else {
                        lista.add(numeros);
                    }
                    scanner.nextLine();
                    String addNovNumero;
                    do {
                        System.out.print("Quer adicionar outro número?(sim/não):");
                        addNovNumero = scanner.nextLine().trim().toLowerCase();
                    }while (!addNovNumero.equals("sim") && !addNovNumero.equals("não"));
                    if (addNovNumero.equals("não")){
                        break;
                    }
                }
            }else {
                System.out.println("Digite um número inteiro e positivo.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtroPar(ArrayList<Integer> lista){
        ArrayList<Integer> listaPar = new ArrayList<>();
        for (int numeros : lista){
            if (numeros%2==0){
                listaPar.add(numeros);
            }
        }
        return listaPar;
    }
    public static ArrayList<Integer> filtroImpar(ArrayList<Integer> lista){
        ArrayList<Integer> listaImpar = new ArrayList<>();
        for (int numeros: lista){
            if (numeros%2!=0){
                listaImpar.add(numeros);
            }
        }
        return listaImpar;
    }

    public static void calculandoMediaAlunos(Scanner scanner){
        ArrayList<Aluno> lista = new ArrayList<>();
        while (true){
            String nome;
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("ERRO. Digite um nome nome.");
                }else {
                    if (!nome.matches("^[a-zA-Z\\s]+(\\s[a-zA-Z]+)+$")){
                        System.out.println("Digite nome completo.");
                    }else {
                        nome = nomeFormatado(nome);
                        break;
                    }
                }
            }
            float nota1=0;
            while (true){
                System.out.print("Digite a primeira nota:");
                if (scanner.hasNextFloat()){
                    nota1 = scanner.nextFloat();
                    if (nota1<=-1 || nota1>=11){
                        System.out.print("Digite uma nota entre 0 e 10.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Digite uma nota entre 0 e 10.");
                    scanner.next();
                }
            }
            float nota2=0;
            while (true){
                System.out.print("Digite a segunda nota:");
                if (scanner.hasNextFloat()){
                    nota2 = scanner.nextFloat();
                    if ( nota2<=-1 || nota2>=11){
                        System.out.print("Digite uma nota entre 0 e 10.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Digite uma nota entre 0 e 10.");;
                }
            }
            float media = (nota2+nota1)/2;
            lista.add(new Aluno(nome,nota1,nota2,media));
            scanner.nextLine();
            String addNovoAluno="";
            while (true){
                System.out.print("Quer adicionar outro aluno?(sim/não):");
                addNovoAluno = scanner.nextLine().trim().toLowerCase();
                if (addNovoAluno.equals("não") || addNovoAluno.equals("sim")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (addNovoAluno.equals("não")){
                break;
            }
        }
        for (int n=0;n<37;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-25s %-8s\n","No","Nome","Média");
        for (int n=0;n<37;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            Aluno  aluno = lista.get(i);
            System.out.printf("%-4d %-25s %-8.2f\n",i,aluno.getNome(),aluno.getMedia());
        }
        for (int n=0;n<37;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar.)");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>Finalizando o programa.");
                break;
            }else {
                if (opc<lista.size()){
                    Aluno aluno = lista.get(opc);
                    for (int n=0;n<62;n++){
                        System.out.print("=");
                    }
                    System.out.println();
                    System.out.println("As notas de "+aluno.getNome()+" foram: "+String.format("%.2f",aluno.getNota1())+" e "+String.format("%.2f",aluno.getNota2()));
                }
            }
        }
    }
    public static String nomeFormatado(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            if (!palavra.isEmpty()){
                nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
            }
        }
        return nomeFormatado.toString().trim();
    }

    static class Aluno{
        private String nome;
        private float nota1;
        private float nota2;
        private float media;

        public Aluno(String nome, float nota1, float nota2, float media){
            this.nome =nome;
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

        public float getNota2() {
            return nota2;
        }
        public float getMedia(){
            return media;
        }
    }


    public static void cadastrandoPessoas(Scanner scanner){
        ArrayList<Map<String,Object>> pessoas = new ArrayList<>();
        while (true){
            Map<String,Object> pessoa = new LinkedHashMap<>();
            String nome;
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("ERRO. Campo não pode ficar vázio, tente novamente.");
                }else {
                    if (!nome.matches("^[a-zA-Z\\s]+([a-zA-Z\\s]+)+$")){
                        System.out.println("Digite seu nome completo.");
                    }else {
                        nome = verificandoNome(nome);
                        pessoa.put("Nome",nome);
                        break;
                    }
                }
            }
            int soma=0;
            int idade =0;
            while (true){
                try {
                    System.out.print("Idade:");
                    idade = Integer.parseInt(scanner.nextLine());
                    if (idade<=0){
                        System.out.println("Digite um valor maior que 1.");
                    }else {
                        soma+=idade;
                        pessoa.put("Idade",idade);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número válido.");
                }
            }
            char sexo;
            while (true){
                System.out.print("Digite o sexo(m/f):");
                sexo = scanner.nextLine().trim().toLowerCase().charAt(0);
                if (sexo=='f' || sexo=='m'){
                    pessoa.put("Sexo",tipoSexo(String.valueOf(sexo)));
                    break;
                }else {
                    System.out.println("Digite M para masculino e F para feminino.");
                }
            }
            pessoas.add(new HashMap<>(pessoa));

            String cadastrarOutraPessoa;
            do {
                System.out.print("Quer cadastrar outra pessoa?(sim/não):");
                cadastrarOutraPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!cadastrarOutraPessoa.equals("sim") && !cadastrarOutraPessoa.equals("não"));
            if (cadastrarOutraPessoa.equals("não")){
                break;
            }
        }
        int somaIdades = pessoas.stream().mapToInt(p -> (int)p.get("Idade")).sum();
        float mediaIdade  = (float) somaIdades/pessoas.size();
        System.out.println("A lista contem:"+pessoas.size()+" pessoas cadastradas.");
        System.out.println("A média de idade das pessoas cadastradas:"+String.format("%.2f",mediaIdade));
        System.out.print("As mulheres cadastradas:");
        pessoas.stream().filter(p -> p.get("Sexo").equals("Feminino")).forEach(p -> System.out.print(p.get("Nome")+"; "));
        System.out.println();
        System.out.println("Lista de pessoas acima da média:");
        pessoas.stream().filter(p -> (int) p.get("Idade") >= mediaIdade).forEach(p -> System.out.println(p.get("Nome")+ ", "+p.get("Idade")));

    }
    public static String tipoSexo(String escolha){
        switch (escolha){
            case "f": return "Feminino";
            case "m": return "Masculino";
        }
        return "";
    }

    public static String verificandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder formatandoString = new StringBuilder();
        for (String palavra : palavras){
            if (!palavra.isEmpty()){
                formatandoString.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
            }
        }
        return formatandoString.toString().trim();
    }


    public static void jogosMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>>jogos = new ArrayList<>();
        int quant=0;
        while (true){
            try {
                System.out.print("Quantos jogos?:");
                quant = Integer.parseInt(scanner.nextLine());
                if (quant<=0){
                    System.out.println("Digite um valor maior ou igual a 1.");
                }else {
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um valor maior ou igual a 1.");
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
            System.out.println("jogo "+(i+1)+": "+jogos.get(i));
        }
    }


    public static void verificandoAposentadoria(Scanner scanner){
        ArrayList<Map<String,Object>> pessoas = new ArrayList<>();
        while (true){
            Map<String,Object> pessoa = new LinkedHashMap<>();
            String nome;
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo não pode ficar vázio, tente novamente.");
                }else {
                    if (!nome.matches("^[a-zA-Z\\s]+(\\s+[a-zA-Z]+)+$")){
                        System.out.println("Digite apenas letras e espaço vázio entre nome e sobre nome.");
                    }else {
                        nome = formantandoString(nome);
                        pessoa.put("Nome",nome);
                        break;
                    }
                }
            }
            int anoAtual = Year.now().getValue();
            int anoNascimento=0;
            while (true){
                try {
                    System.out.print("Ano de nascimento:");
                    anoNascimento = Integer.parseInt(scanner.nextLine());
                    if (anoNascimento<1900 || anoNascimento>=anoAtual){
                        System.out.println("Ano inválido. Tente novamente.");
                    }else {
                        pessoa.put("Ano nascimento",anoNascimento);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite uma data válida.");
                }
            }
            int ctps=0;
            while (true){
                try {
                    System.out.print("Digite sua CTPS(Digite zero se não tiver.):");
                    ctps = Integer.parseInt(scanner.nextLine());
                    if (ctps<=0){
                        System.out.println("Você não tem CTPS");
                        pessoa.put("Não tem CTPS","");
                        break;
                    }else {
                        pessoa.put("CTPS",ctps);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número válido.");
                }
            }
            if (ctps>=1){
                int anoContratacao=0;
                while (true){
                    try {
                        System.out.print("Ano de contratação:");
                        anoContratacao = Integer.parseInt(scanner.nextLine());
                        if (anoContratacao<=anoNascimento-16){
                            System.out.println("ERRO. Ano de contratação tem que ser maior que o ano que você completou 16 anos.");
                        }else {
                            pessoa.put("Ano Contratação",anoContratacao);
                            break;
                        }
                    }catch (NumberFormatException erro){
                        System.out.println("Digite uma data válida.");
                    }
                }
                float salario =0;
                while (true){
                    try {
                        System.out.print("Salário:R$");
                        salario = Float.parseFloat(scanner.nextLine());
                        if (salario<1450){
                            System.out.println("Salário precisa ser maior que o salário minimo atual. Tente novamente.");
                        }else {
                            pessoa.put("Salário",salario);
                            break;
                        }
                    }catch (NumberFormatException erro){
                        System.out.println("Digite um valor válido. Tente novamente.");
                    }
                }
                int anoAposentadoria = anoContratacao+35;
                pessoa.put("Ano aposentadoria",anoAposentadoria);
                if (anoAposentadoria>=anoAtual){
                    int anosParaAposentar = anoAposentadoria-anoAtual;
                    pessoa.put("Quantos anos faltam para aposentar",anosParaAposentar);
                }else {
                    int anosAposentado = anoAtual-anoAposentadoria;
                    pessoa.put("Anos que está aposentado",anosAposentado);
                }
            }
            pessoas.add(pessoa);
            String addNovaPessoa;
            while (true){
                System.out.print("Quer adicionar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
                if (addNovaPessoa.equals("sim") || addNovaPessoa.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (addNovaPessoa.equals("não")){
                for (Map<String,Object> dados : pessoas){
                    for (Map.Entry<String,Object> entry : dados.entrySet()){
                        System.out.println(entry.getKey()+": "+entry.getValue());
                    }
                    for (int n=0;n<22;n++){
                        System.out.print("=");
                    }
                    System.out.println();
                }
                break;
            }
        }
    }
    public static String formantandoString(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            if (!palavra.isEmpty()){
                nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
            }
        }
        return nomeFormatado.toString().trim();
    }


    public static void sorteioRanking(Scanner scanner, Random random){
        Map<String,Integer> jogadores = new LinkedHashMap<>();
        jogadores.put("Jogador 1", random.nextInt(10)+1);
        jogadores.put("Jogador 2", random.nextInt(10)+1);
        jogadores.put("Jogador 3", random.nextInt(10)+1);
        jogadores.put("Jogador 4", random.nextInt(10)+1);
        System.out.println("==Sorteio jogadores==");
        for (Map.Entry<String, Integer> entry : jogadores.entrySet()){
            System.out.println(entry.getKey()+": tirou -->>> "+entry.getValue());
            try {
                Thread.sleep(400);
            }catch (InterruptedException erro){
                erro.printStackTrace();
            }
        }
        List<Map.Entry<String,Integer>> ranking = new ArrayList<>(jogadores.entrySet());
        ranking.sort((entry1,entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        System.out.println("===Ranking jogadores===");
        for (int i=0;i<ranking.size();i++){
            Map.Entry<String,Integer> entry = ranking.get(i);
            System.out.println((i+1)+"º lugar: "+entry.getKey()+" com "+entry.getValue());
        }
    }

    public static void verificandoDadosJogadores2(Scanner scanner){
        ArrayList<Map<String,Object>> jogadores = new ArrayList<>();
        while (true){
            Map<String,Object> jogador = new LinkedHashMap<>();
            String nome;
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo não pode ficar vázio, tente novamente.");
                }else {
                    if (!nome.matches("^[a-zA-Z\\s]+(\\s[a-zA-Z]+)+$")){
                        System.out.println("Digite seu nome completo apenas com letras.");
                    }else {
                        nome = formatandoNome(nome);
                        jogador.put("Nome",nome);
                        break;
                    }
                }
            }
            int partidas =0;
            while (true){
                try {
                    System.out.print("Quantas partindas?:");
                    partidas = Integer.parseInt(scanner.nextLine());
                    if (partidas<=0){
                        System.out.println("Digite um número positivo maior que 1.");
                    }else {
                        jogador.put("Partidas",partidas);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número inteiro maior que 1.");
                }
            }
            ArrayList<Integer> totalGols = new ArrayList<>();
            for (int n=0;n<partidas;n++){
                while (true){
                    try {
                        System.out.print("Quantos gols na "+(n+1)+"º partida?:");
                        int gols = Integer.parseInt(scanner.nextLine());
                        if (gols<=-1){
                            System.out.println("Digite um valor maior que zero.");
                        }else {
                            totalGols.add(gols);
                            jogador.put("Gols",totalGols);
                            jogador.put("Total Gols",totalGols.stream().mapToInt(Integer::intValue).sum());
                            break;
                        }
                    }catch (NumberFormatException erro){
                        System.out.println("Digite um número intero maior que 1.");
                    }
                }
            }
            jogadores.add(jogador);
            String novoJogador;
            while (true){
                System.out.print("Quer cadastrar outro jogador?(sim/não):");
                novoJogador = scanner.nextLine().trim().toLowerCase();
                if (novoJogador.equals("sim") || novoJogador.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (novoJogador.equals("não")){
                for (Map<String,Object> todosJogadores : jogadores ){
                    for (Map.Entry<String,Object> entry : todosJogadores.entrySet()){
                        System.out.println(entry.getKey()+": "+entry.getValue());
                    }
                    ArrayList<Integer> dadosGols = (ArrayList<Integer>) todosJogadores.get("Gols");
                    for (int t=0;t<dadosGols.size();t++){
                        System.out.println(">>>Na partida "+(t+1)+" fez "+dadosGols.get(t)+" gol(s)");
                    }
                    for (int n=0;n<22;n++){
                        System.out.print("=");
                    }
                    System.out.println();
                }
                break;
            }
        }
    }
    public static String formatandoNome(String nome){
        String[] palavras = nome.toLowerCase().split("\\s+");
        StringBuilder nomeFormatado = new StringBuilder();
        for (String palavra : palavras){
            if (!palavra.isEmpty()){
                nomeFormatado.append(palavra.substring(0,1).toUpperCase()).append(palavra.substring(1)).append(" ");
            }
        }
        return nomeFormatado.toString().trim();
    }
}