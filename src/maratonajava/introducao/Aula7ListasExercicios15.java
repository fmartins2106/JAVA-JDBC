package academy.devdojo.maratonajava.introducao;



import java.util.*;
import java.time.*;

public class Aula7ListasExercicios15 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

//        verificando aposentadoria
        verificandoAposentadoria(scanner);

//        verificando gols por partida
        verificandoGolsPorPartida(scanner);

//        verificando notas alunos
        verificandoNotasALunos(scanner);

//        jogos MegaSena
        jogosMegaSena(scanner,random);

//        verificando lista de pares e impares
        verificandoParesImpares(scanner);

//        situação aluno
        situacaoAluno(scanner);

//        verificando ranking dos jogadores.
        SorteandoERankingJogadores(scanner,random);
        scanner.close();
    }

    public static void jogosMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant=0;
        while (true){
            System.out.print("Quantos jogos?:");
            if (scanner.hasNextInt()){
                quant = scanner.nextInt();
                if (quant<=0){
                    System.out.println("Digite um número maior que 1.");
                }else {
                    break;
                }
            }else {
                System.out.println("Digite um número maior que 1.");
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
        for (int i=0;i<jogos.size();i++){
            System.out.println((i+1)+"º jogo:"+jogos.get(i));
        }
    }

    public static void verificandoParesImpares(Scanner scanner){
        ArrayList<Integer> lista = obtendoNumeros(scanner);
        ArrayList<Integer> listaPar = filtroPar(lista);
        ArrayList<Integer> listaImpar = filtroImpar(lista);
        System.out.println("A lista:"+lista);
        System.out.println("A lista de pares:"+listaPar);
        System.out.println("A lista de impar:"+listaImpar);
    }
    public static ArrayList<Integer> obtendoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        int numeros = 0;
        while (true){
            System.out.print("Digite um número:");
            if (scanner.hasNextInt()){
                numeros = scanner.nextInt();
                if (numeros<=-1){
                    System.out.println("Erro, digite apenas números positivos.");
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("Número repetido, tente novamente.");
                        continue;
                    }else {
                        lista.add(numeros);
                    }
                    scanner.nextLine();
                    String addNovoNumero;
                    do {
                        System.out.print("Quer adicionar outro número?(sim/não):");
                        addNovoNumero = scanner.nextLine().trim().toLowerCase();
                    }while (!addNovoNumero.equals("não") && !addNovoNumero.equals("sim"));
                    if (addNovoNumero.equals("não")){
                        break;
                    }
                }
            }else {
                System.out.println("Digite um número válido.");
                scanner.next();
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtroPar(ArrayList<Integer> lista){
        ArrayList<Integer> listaPar = new ArrayList<>();
        for (int numero : lista){
            if (numero%2==0){
                listaPar.add(numero);
            }
        }
        return listaPar;
    }
    public static ArrayList<Integer> filtroImpar(ArrayList<Integer> lista){
        ArrayList<Integer> listaImpar = new ArrayList<>();
        for (int numero : lista){
            if (numero%2!=0){
                listaImpar.add(numero);
            }
        }
        return listaImpar;
    }

    public static void verificandoNotasALunos(Scanner scanner){
        ArrayList<Aluno> alunos = new ArrayList<>();
        while (true){
            String nome;
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo nome não pode ser vázio, tente novamente.");
                }else {
                    if (nome.matches("[a-zA-Z-`´^~\\n]")){
                        System.out.println("Nome pode conter somente letras e espaços. Tente novamente.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        break;
                    }
                }
            }
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
                    System.out.println("Digit uma nota entre 0 e 10.");
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
                    System.out.println("Digite uma nota entre 0 e 10.");
                }
            }
            float media = (nota2+nota1)/2;
            alunos.add(new Aluno(nome,nota1,nota2,media));
            String cadastroAluno;
            while (true){
                System.out.print("Quer cadastrar outro aluno?(sim/não):");
                cadastroAluno = scanner.nextLine().trim().toLowerCase();
                if (cadastroAluno.equals("sim") || cadastroAluno.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (cadastroAluno.equals("não")){
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
        for (int i=0;i< alunos.size();i++){
            Aluno dados = alunos.get(i);
            System.out.printf("%-4d %-10s %-8.2f%n",i,dados.getNome(),dados.getMedia());
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            try {
                System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar.)");
                int opc = Integer.parseInt(scanner.nextLine());
                if (opc==999){
                    System.out.println(">>>Finalizando o programa...");
                    break;
                }else {
                    if (opc< alunos.size()){
                        Aluno dados = alunos.get(opc);
                        System.out.println("As notas de "+dados.getNome()+" foram:"+dados.getNota1()+" e "+dados.getNota2());
                    }
                }
            } catch (NumberFormatException erro){
                System.out.println("Digite um número compatível.");
            }
        }
    }
    static class Aluno {
        private String nome;
        private float nota1;
        private float nota2;
        private float media;

        public Aluno(String nome, float nota1,float nota2, float media){
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
        public float getNota2(){
            return nota2;
        }
        public float getMedia(){
            return media;
        }
    }




    public static void verificandoGolsPorPartida(Scanner scanner){
        ArrayList<Map<String,Object>> jogadores = new ArrayList<>();
        while (true){
            Map<String,Object> jogador = new LinkedHashMap<>();
            String nome;
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo nome não pode ser vázio. Tente novamente.");
                }else {
                    if (!nome.matches("[a-zA-Z\\s]+")){
                        System.out.println("Digite apenas letras e espaços vázios se necessário. Tente novamente.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        jogador.put("Nome",nome);
                        break;
                    }
                }
            }
            int quant=0;
            while (true){
                try {
                    System.out.print("Quantas partidas?:");
                    quant = Integer.parseInt(scanner.nextLine());
                    if (quant<=-1){
                        System.out.println("Digite um número positivo.");
                    }else {
                        jogador.put("Partidas",quant);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número inteiro positivo.");
                }
            }
            List<Integer> totalGols = new ArrayList<>();
            for (int i=0;i<quant;i++){
                while (true){
                    try {
                        System.out.print("Quantos gol(s) na "+(i+1)+"ª partida?:");
                        int gols = Integer.parseInt(scanner.nextLine());
                        if (gols<=-1){
                            System.out.println("Digite um número positivo.");
                        }else {
                            totalGols.add(gols);
                            jogador.put("Gol(s)",totalGols);
                            jogador.put("Total Gols",totalGols.stream().mapToInt(Integer::intValue).sum());
                            break;
                        }
                    }catch (NumberFormatException erro){
                        System.out.println("Digite um valor válido.");
                    }
                }
            }
            jogadores.add(jogador);
            String addNovaPessoa;
            do {
                System.out.print("Quer adicionar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("não") && !addNovaPessoa.equals("sim"));
            if (addNovaPessoa.equals("não")){
                for (Map<String, Object> dados : jogadores){
                    for (int i=0;i<30;i++){
                        System.out.print("=");
                    }
                    System.out.println();
                    for (Map.Entry<String,Object> entry : dados.entrySet()){
                        System.out.println(entry.getKey()+": "+entry.getValue());
                    }
                    ArrayList<Integer> golsJogador = (ArrayList<Integer>) dados.get("Gol(s)");
                    for (int g=0;g<golsJogador.size();g++){
                        System.out.println(">>>Na partida "+(g+1)+", foram feitos "+ golsJogador.get(g)+" gol(s)");
                    }
                }

                break;
            }


        }
    }


    public static void verificandoAposentadoria(Scanner scanner){
        ArrayList<Map<String,Object>> pessoas = new ArrayList<>();
        int anoAtual = Year.now().getValue();
        while (true){
            Map<String,Object> pessoa = new LinkedHashMap<>();
            String nome;
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo não pode ser vázio, tente novamente.");
                }else {
                    if (!nome.matches("[a-zA-Z\\s]+")){
                        System.out.println("Digite um nome contendo somente letras e espaços vázios.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        pessoa.put("Nome",nome);
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
                        System.out.println("ERRO.Verifique se a data está correta. Tente novamente.");
                    }else {
                        pessoa.put("Ano Nascimento",anoNascimento);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número compatível.");
                }
            }
            int ctps=0;
            while (true){
                try {
                    System.out.print("Digite o número da CTPS(Digite 0 se não tiver.):");
                    ctps = Integer.parseInt(scanner.nextLine());
                    if (ctps<=0){
                        System.out.println("Não tem CTPS.");
                        pessoa.put("Não tem CTPS","");
                        break;
                    }else {
                        pessoa.put("CTPS",ctps);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            if (ctps>=1){
                int anoContratacao=0;
                while (true){
                    try {
                        System.out.print("Digite o ano de contratação:");
                        anoContratacao = Integer.parseInt(scanner.nextLine());
                        if (anoContratacao<anoNascimento+16){
                            System.out.println("ERRO. Ano de contratação não pode ser menor que o ano em que você completa 16 anos.");
                        }else {
                            pessoa.put("Ano de Contratação", anoContratacao);
                            break;
                        }
                    }catch (NumberFormatException erro){
                        System.out.println("Digite um valor válido.");
                    }
                }
                float salario=0;
                while (true){
                    try {
                        System.out.print("Digite o salário:R$");
                        salario = Float.parseFloat(scanner.nextLine());
                        if (salario<=1450){
                            System.out.println("ERRO. salário não pode ser menor que salário minimo.");
                        }else {
                            pessoa.put("Salário",salario);
                            break;
                        }
                    }catch (NumberFormatException erro){
                        System.out.println("Digite um salário válido.");
                    }
                }
                int anoAposentadoria= anoContratacao+35;
                pessoa.put("Ano Aposentadoria",anoAposentadoria);
                if (anoAposentadoria>=anoAtual){
                    int anosParaAposentar = anoAposentadoria-anoAtual;
                    pessoa.put("Anos para se aposentar",anosParaAposentar);
                }else {
                    int anosAposentado = anoAtual-anoAposentadoria;
                    pessoa.put("Anos aposentado",anosAposentado);
                }
            }
            pessoas.add(pessoa);
            String cadastrarPessoa;
            while (true){
                System.out.print("Quer cadastrar outra pessoa?(sim/não):");
                cadastrarPessoa = scanner.nextLine().trim().toLowerCase();
                if (cadastrarPessoa.equals("sim") || cadastrarPessoa.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (cadastrarPessoa.equals("não")){
                System.out.println(pessoa);
                System.out.println(pessoas);
                for (Map<String,Object> dados : pessoas){
                    for (int n=0;n<30;n++){
                        System.out.print("=");
                    }
                    System.out.println();
                    for (Map.Entry<String,Object> entry : dados.entrySet()){
                        System.out.println(entry.getKey()+": "+entry.getValue());
                    }
                }
                break;
            }
        }
    }


    public static void situacaoAluno(Scanner scanner){
        ArrayList<Map<String,Object>> alunos = new ArrayList<>();
        while (true){
            Map<String,Object> aluno = new LinkedHashMap<>();
            String nome ="";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo não pode fica vázio, tente novamente.");
                }else {
                    if (!nome.matches("[a-zA-Z\\s]+")){
                        System.out.println("Campo aceita somente letras e espaços vázios. Tente novamente.");
                    }else {
                        nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        aluno.put("Nome:",nome);
                        break;
                    }
                }
            }
            float media =0;
            while (true){
                try {
                    System.out.print("Média:");
                    media = Float.parseFloat(scanner.nextLine());
                    if (media<=-1 || media>=11){
                        System.out.println("Digite uma média entre 1 e 10.");
                    }else {
                        aluno.put("Média",media);
                        if (media>=7){
                            aluno.put("Situação","APROVADO(A)");
                        } else if (media>=5 && media<=6.9) {
                            aluno.put("Situação","EM RECUPERAÇÃO");
                        }else{
                            aluno.put("Situação","REPROVADO(A)");
                        }
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite uma média válida.");
                }
            }
            alunos.add(aluno);
            String addNovoAluno;
            while (true){
                System.out.print("Quer adicionar outro aluno?(sim/não):");
                addNovoAluno = scanner.nextLine().trim().toLowerCase();
                if (addNovoAluno.equals("sim") || addNovoAluno.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (addNovoAluno.equals("não")){
                for (Map<String,Object> dados : alunos){
                    for (int n=0;n<30;n++){
                        System.out.print("=");
                    }
                    System.out.println();
                    for (Map.Entry<String,Object> entry : dados.entrySet()){
                        System.out.println(entry.getKey()+": "+entry.getValue());
                    }
                }
                break;
            }
        }
    }

    public static void SorteandoERankingJogadores(Scanner scanner, Random random){
        Map<String,Integer> jogador = new LinkedHashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10)+1);
        System.out.println("===Sorteio Jogadores===");
        for (Map.Entry<String,Integer> entry: jogador.entrySet()){
            System.out.println(entry.getKey()+" tirou "+entry.getValue());
            try {
                Thread.sleep(400);
            }catch (InterruptedException erro){
                erro.printStackTrace();
            }
        }
        List<Map.Entry<String,Integer>> ranking  = new ArrayList<>(jogador.entrySet());
        ranking.sort((entry1,entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        System.out.println("====Ranking Jogadores====");
        for (int i=0;i<ranking.size();i++){
            Map.Entry<String,Integer> entry =  ranking.get(i);
            System.out.println((i+1)+"º lugar:"+entry.getKey()+" com "+entry.getValue());
        }


    }

}
