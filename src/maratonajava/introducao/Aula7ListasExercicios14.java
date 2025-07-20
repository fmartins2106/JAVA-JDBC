package academy.devdojo.maratonajava.introducao;



import java.time.*;
import java.util.*;

public class Aula7ListasExercicios14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        //        verificando gosls e partidas
        verificandoGoslPartidas2(scanner);

        //        verificando dados aposentadoria
        verificandoAposentadoria(scanner);



//        verificando gosl e partidas
        verificandoGolsPartidas(scanner);



//        verificando lista com posições
        verificandoListaPosicoes(scanner);

//        verificar situação do aluno
        verificandoSituacaoAluno(scanner);

//        verificando sorteio e ranking
        rankingJogadores(scanner,random);

//        verificando maior e menor de idade
        verificandoMaiorMenorIdadeMetodo2(scanner);

//        verificando notas e medias dos alunos
        verificandoNotasMediasAlunos(scanner);

//        verificando maior e menor de idade
        verificandoMaiorMenorIdade(scanner);

//        sorteando jogos mega sena
        jogosMegaSena(scanner,random);

//        verificando numeros pares e impares
        verificandoNumerosParesImpares(scanner);
        scanner.close();
    }

    public static void verificandoGoslPartidas2(Scanner scanner){
        Map<String,Object> jogador = new LinkedHashMap<>();
        ArrayList<Integer> lista = new ArrayList<>();
        String nome="";
        while (true){
            System.out.print("Nome:");
            nome = scanner.nextLine().trim();
            if (nome.isEmpty()){
                System.out.println("Campo não pode fica vázio, tente novamente.");
            }else {
                if (!nome.matches("[a-zA-Z\\n]+")){
                    System.out.println("Digite apenas letras e espaços vázios.");
                }else {
                    nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                    jogador.put("Nome",nome);
                    break;
                }
            }
        }
        int partidas=0;
        while (true){
            try {
                System.out.print("Quantas partidas jogou?:");
                partidas = Integer.parseInt(scanner.nextLine());
                if (partidas<=0){
                    System.out.println("Digite um número igual ou maior que 1.");
                }else {
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um valor válido.");
            }
        }
        for (int c=0;c<partidas;c++){
            while (true){
                try {
                    System.out.print("Quantos gold na "+(c+1)+"º partida?:");
                    int gols = Integer.parseInt(scanner.nextLine());
                    if (gols<=-1){
                        System.out.println("Digite um valor positivo.");
                    }else{
                        lista.add(gols);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor positivo.");
                }
            }
        }
        jogador.put("Gols",lista);
        jogador.put("Total de Gols",lista.stream().mapToInt(Integer::intValue).sum());
        System.out.println(jogador);
        for (int n=0;n<40;n++){
            System.out.print("=");
        }
        System.out.println();
        for (Map.Entry<String,Object> entry : jogador.entrySet()){
            System.out.println("No campo:"+entry.getKey()+" tem o valor:"+entry.getValue());
        }
        for (int n=0;n<40;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int k=0;k<lista.size();k++){
            System.out.println("Na partida "+(k+1)+" fez "+lista.get(k)+" Gols.");
        }
    }


    public static void verificandoGolsPartidas(Scanner scanner){
        List<Map<String,Object>> jogadores = new ArrayList<>();
        while (true){
            Map<String,Object> jogador = new LinkedHashMap<>();
            String nome="";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo não pode ser vázio, tente novamente.");
                }else {
                    if (!nome.matches("[a-zA-Z\\s]+")){
                        System.out.println("Campo aceita somente letras e espaços vázios.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        jogador.put("Nome",nome);
                        break;
                    }
                }
            }
            int gols = 0;
            int totalGols=0;
            for (int n=0;n<2;n++){
                while (true){
                    try {
                        System.out.print("Quantos gols na "+(n+1)+" partida:");
                        gols = Integer.parseInt(scanner.nextLine());
                        if (gols<=0){
                            System.out.println("Digite um valor positivo.");
                        }else {
                            jogador.put("Partida"+(n+1), gols);
                            totalGols+=gols;
                            break;
                        }
                    }catch (NumberFormatException erro){
                        System.out.println("Digite um valor inteiro e positivo.");
                    }
                }
            }
            jogador.put("Total Gols",totalGols);
            jogadores.add(jogador);
            String addNovoJogador;
            do {
                System.out.print("Quer adicionar outro jogador?(sim/não):");
                addNovoJogador = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoJogador.equals("não") && !addNovoJogador.equals("sim"));
            if (addNovoJogador.equals("não")){
                for (Map<String,Object> dado : jogadores){
                    for (Map.Entry<String,Object> entry : dado.entrySet()){
                        System.out.println(entry.getKey()+": "+entry.getValue());
                    }
                }
                break;

            }
        }
    }


    public static void verificandoAposentadoria(Scanner scanner){
        List<Map<String,Object>> lista =  new ArrayList<>();
        int anoAtual = Year.now().getValue();
        while (true){
            Map<String,Object> dados = new LinkedHashMap<>();
            String nome = "";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim().toLowerCase();
                if (nome.isEmpty()){
                    System.out.println("Campo não pode ficar vázio, tente novamente.");
                }else {
                    if (!nome.matches("[a-zA-Z\\s]+")){
                        System.out.println("Diginas apenas letras e espaços.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        dados.put("Nome",nome);
                        break;
                    }
                }
            }
            int anoNascimento=0;
            while (true){
                try {
                    System.out.print("Ano de nascimento:");
                    anoNascimento = Integer.parseInt(scanner.nextLine());
                    if (anoNascimento<=1900 || anoNascimento>=anoAtual){
                        System.out.println("ERRO.digite um ano compatível.");
                    }else {
                        dados.put("Ano nascimento", anoNascimento);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número compatível.");
                }
            }
            int ctps = 0;
            while (true){
                try {
                    System.out.print("Digite o nº da CTPS:");
                    ctps = Integer.parseInt(scanner.nextLine());
                    if (ctps<=0){
                        System.out.println("Você não tem ctps.");
                        dados.put("Não tem CTPS","sem aposentadoria");
                        break;
                    }else {
                        dados.put("CTPS",ctps);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número compatível, tente novamente.");
                }
            }
            if (ctps>=1){
                int anoContratacao=0;
                while (true){
                    try {
                        System.out.print("Digite o ano da contratação:");
                        anoContratacao = Integer.parseInt(scanner.nextLine());
                        if (anoContratacao<=anoNascimento+16){
                            System.out.println("Ano de contratação não pode ser menor que o ano que você completou 16 anos.");
                        }else {
                            dados.put("Ano contratação",anoContratacao);
                            break;
                        }
                    }catch (NumberFormatException erro){
                        System.out.println("Digite um valor compatível.");
                    }
                }
                float salario=0;
                while (true){
                    try {
                        System.out.print("Seu salário:R$");
                        salario = Float.parseFloat(scanner.nextLine());
                        if (salario<=1450){
                            System.out.println("ERRO.Salário deve ser maio ou igual salário mínimo.");
                        }else {
                            dados.put("Salário",salario);
                            break;
                        }
                    }catch (NumberFormatException erro){
                        System.out.println("Digite um valor compatível.");
                    }
                }
                int anoAposentadoria= anoContratacao+35;
                dados.put("Ano aposentadoria",anoAposentadoria);
                if (anoAposentadoria>=anoAtual){
                    int anosAposentar = anoAposentadoria-anoAtual;
                    dados.put("Anos para se apodentar",anosAposentar);
                }else {
                    int anosAposentado = anoAtual-anoAposentadoria;
                    dados.put("Anos aposentado",anosAposentado);
                }

            }
            lista.add(dados);
            String cadastrar;
            while (true){
                System.out.print("Quer cadastrar outra pessoa?(sim/não):");
                cadastrar = scanner.nextLine().trim().toLowerCase();
                if (cadastrar.equals("sim") || cadastrar.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (cadastrar.equals("não")){
                for (Map<String,Object> dado : lista){
                    for (int n=0;n<30;n++){
                        System.out.print("=");
                    }
                    System.out.println();
                    for (Map.Entry<String,Object> entry : dado.entrySet()){
                        System.out.println(entry.getKey()+": "+entry.getValue());
                    }
                }
                break;
            }
        }

    }


    public static void verificandoListaPosicoes(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            System.out.print("Digite um número:");
            if (scanner.hasNextInt()){
                int numeros = scanner.nextInt();
                if (numeros<=-1){
                    System.out.println("Digite um número positivo.");
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
                    }else {
                        if (lista.isEmpty() || numeros >= lista.get(lista.size()-1)){
                            lista.add(numeros);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos=0;
                            while (pos<lista.size()){
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
                scanner.nextLine();
                String addNovoNumero;
                while (true){
                    System.out.print("Quer adicionar outro número?(sim/não):");
                    addNovoNumero = scanner.nextLine().trim().toLowerCase();
                    if (addNovoNumero.equals("sim") || addNovoNumero.equals("não")){
                        break;
                    }else {
                        System.out.println("Digite apenas sim ou não.");
                    }
                }
                if (addNovoNumero.equals("não")){
                    System.out.println("A lista:"+lista);
                    break;
                }
            }else {
                System.out.println("Digite um número positivo e inteiro.");
                scanner.next();
            }
        }
    }


    public static void verificandoSituacaoAluno(Scanner scanner){
        List<Map<String, Object>> lista = new ArrayList<>();
        while (true){
            Map<String,Object> aluno = new LinkedHashMap<>();
            String nome = "";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo não pode ficar vazio, tente novamente.");
                }else {
                    if (!nome.matches("[a-zA-Z\\s]+")){
                        System.out.println("Digite apenas letras e espaços vazios. Tente novamente.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        aluno.put("Nome",nome);
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
                        System.out.println("Média inválida. Tente novamente.");
                    }else {
                        if (media>=7){
                            aluno.put("Situação","Aprovado(a)!");
                        } else if (media>=5 && media<=6.9) {
                            aluno.put("Situação","Em recuperação.");
                        }else {
                            aluno.put("Situação","Reprovado(a).");
                        }
                        aluno.put("Média",media);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Média inválida. Tente novamente.");
                }
            }
            lista.add(aluno);
            String addNovoAluno;
            do {
                System.out.print("Quer adicionar outro aluno?(sim/não):");
                addNovoAluno = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoAluno.equals("não") && !addNovoAluno.equals("sim"));
            if (addNovoAluno.equals("não")){
                for (Map<String,Object> alunos : lista){
                    for(Map.Entry<String,Object> entry : alunos.entrySet()){
                        System.out.println(entry.getKey()+" : "+entry.getValue());
                    }
                    for (int n=0;n<50;n++){
                        System.out.print("=");
                    }
                    System.out.println();
                }
                break;
            }
        }

    }


    public static void rankingJogadores(Scanner scanner, Random random){
        Map<String,Integer> jogador = new LinkedHashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10)+1);
        System.out.println("===Sorteio Jogadores===");
        for (Map.Entry<String,Integer> entry : jogador.entrySet()){
            System.out.println(entry.getKey()+", tirou: "+entry.getValue());
            try {
                Thread.sleep(400);
            }catch (InterruptedException erro){
                erro.printStackTrace();
            }
        }
        List<Map.Entry<String,Integer>> ranking = new ArrayList<>(jogador.entrySet());
        ranking.sort((entry1,entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        System.out.println("====Ranking Jogadores====");
        for (int i=0;i<ranking.size();i++){
            System.out.println((i+1)+"º lugar: "+ranking.get(i));
//            Map.Entry<String,Integer> entry = ranking.get(i);
//            System.out.println((i+1)+"º lugar: "+entry.getKey()+" com "+entry.getValue());
        }
    }

    public static void verificandoMaiorMenorIdadeMetodo2(Scanner scanner){
        ArrayList<Pessoa> lista = new ArrayList<>();
        while (true){
            String nome="";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Não permitido campo vazio. Tente novamente.");
                }else {
                    if (!nome.matches("[a-zA-Z\\s]+")){
                        System.out.println("Digite apenas letras.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        break;
                    }
                }
            }
            int idade=0;
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
                    System.out.println("Digite uma idade compativel.");
                }
            }
            lista.add(new Pessoa(nome,idade));
            int totalMaior=0, totalMenor=0;
            String addNovaPessoa;
            do {
                System.out.print("Quer adicionar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("não") && !addNovaPessoa.equals("sim"));
            if (addNovaPessoa.equals("não")){
                for (Pessoa dados : lista){
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
    static class Pessoa{
        private String nome;
        private int idade;

        public Pessoa(String nome, int idade){
            this.nome = nome;
            this.idade = idade;
        }
    }

    public static void verificandoNotasMediasAlunos(Scanner scanner){
        ArrayList<Aluno> lista = new ArrayList<>();
        while (true){
            String nome="";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo não pode ficar vazio, tente novamente.");
                }else {
                    if (!nome.matches("[a-zA-Z\\s]+")){
                        System.out.println("Digite um nome com apenas letras e espaços.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        break;
                    }
                }
            }
            float nota1 = 0;
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
                    System.out.println("Digite uma nota entre 1 e 10.");
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
                    System.out.println("Digite uma nota entre 1 e 10.");
                }
            }
            float media = (nota1+nota2)/2;
            lista.add(new Aluno(nome,nota1,nota2,media));
            String addNovaPessoa;
            do {
                System.out.print("Quer adicionar outro aluno?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("sim") && !addNovaPessoa.equals("não"));
            if (addNovaPessoa.equals("não")){
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
            Aluno dados = lista.get(i);
            System.out.printf("%-4d %-10s %-8.2f\n",i,dados.getNome(),dados.getMedia());
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar.)");
            int opc = scanner.nextInt();
            if (opc==999){
                break;
            }else {
                if (opc<lista.size()){
                    Aluno dados = lista.get(opc);
                    System.out.println("As notas de "+dados.getNome()+", foram:"+dados.getNota1()+" e "+dados.getNota2());
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
            this.nome= nome;
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
        while (true){
            List<Object> dados = new ArrayList<>();
            while (true){
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo não pode ser vázio, tente novamente.");
                }else {
                    if (!nome.matches("[a-zA-Z\\s]+")){
                        System.out.println("Digite apenas letras e espaços. Tente novamente.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        dados.add(nome);
                        break;
                    }
                }
            }
            while (true){
                try {
                    System.out.print("Idade:");
                   int  idade = Integer.parseInt(scanner.nextLine());
                    if (idade<=0){
                        System.out.println("ERRO. Tente novamente.");
                    }else {
                        dados.add(idade);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            lista.add(dados);
            String addNovaPessoa;
            do {
                System.out.print("Quer adicionar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("não") && !addNovaPessoa.equals("sim"));
            if (addNovaPessoa.equals("não")){
                int totalMaior=0, totalMenor=0;
                for (List<Object> pessoa : lista){
                    String nome = (String)pessoa.get(0);
                    int idade = (int)pessoa.get(1);
                    if (idade>=18){
                        totalMaior++;
                        System.out.println(nome+", é maior de idade");
                    }else {
                        totalMenor++;
                        System.out.println(nome+", é menor de idade.");
                    }
                }
                System.out.println(lista);
                System.out.println("Total maior de idade:"+totalMaior+" | Total menor de idade:"+totalMenor);
                break;
            }
        }
    }

    public static void jogosMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            try {
                System.out.print("Quantos jogos você quer?:");
                quant = Integer.parseInt(scanner.nextLine());
                if (quant<=0){
                    System.out.println("Digite um número maior que 1.");
                }else {
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número inteiro maior que 1.");
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
            System.out.println((n+1)+"º jogo:"+jogos.get(n));
        }
    }


    public static void verificandoNumerosParesImpares(Scanner scanner){
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
        for (int numeros: lista){
            if (numeros%2==0){
                listaPar.add(numeros);
            }
        }
        return listaPar;
    }
    public static ArrayList<Integer> filtroImpar(ArrayList<Integer> lista){
        ArrayList<Integer> listaImpar = new ArrayList<>();
        for (int numeros : lista){
            if (numeros%2!=0){
                listaImpar.add(numeros);
            }
        }
        return listaImpar;
    }



}
