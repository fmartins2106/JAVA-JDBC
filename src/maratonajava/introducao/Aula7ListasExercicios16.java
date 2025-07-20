package academy.devdojo.maratonajava.introducao;

import java.util.*;
import java.time.*;

public class Aula7ListasExercicios16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();



//        7verificando Dados Jogadores
        verificandoDadosJogadores2(scanner);

//        6calculando a média dos alunos
        calculandoMediaAlunos(scanner);

//        5jogos mega sena
        jogosMegaSena(scanner,random);

//        4verificando numeros pares e impars
        verificandoNumerosParesImpares(scanner);

//        3verificando dados jogadores
        verificandoDadosJogadores(scanner);

//        2situação aluno
        situacaoAluno(scanner);

//        1sorteio jogadores
        rankingJogadores(scanner, random);
        scanner.close();
    }
    public static void verificandoDadosJogadores2(Scanner scanner){
        ArrayList<Map<String,Object>> lista = new ArrayList<>();
        while (true){
            Map<String,Object> jogador = new LinkedHashMap<>();
            String nome;
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo não pode ficar vázio, tente novamente.");
                }else {
                    if (!nome.matches("^[a-zA-Z]+(\\s+[a-zA-Z\\s]+)+$")){
                        System.out.println("Digite seu nome completo usando somente letras e espaços vázios entre os nomes.");
                    }else {
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
                        System.out.println("Digite um número maior ou igual a 1.");
                    }else {
                        jogador.put("Partida(s)",partidas);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número inteiro, maior ou igual a 1.");
                }
            }
            ArrayList<Integer> totalGols = new ArrayList<>();
            for (int i=0;i<partidas;i++){
                while (true){
                    try {
                        System.out.print("Quantos gol(s) na partida "+(i+1)+"?:");
                        int gols = Integer.parseInt(scanner.nextLine());
                        if (gols<=-1){
                            System.out.println("Digite apenas números positivos.");
                        }else {
                            totalGols.add(gols);
                            jogador.put("Gol(s)",totalGols);
                            jogador.put("TotalGols", totalGols.stream().mapToInt(Integer::intValue).sum());
                            break;
                        }
                    }catch (NumberFormatException erro){
                        System.out.println("Digite apenas números positivos.");
                    }
                }
            }
            lista.add(jogador);
            String cadastrarNovoJogador;
            do {
                System.out.print("Quer cadastrar outro jogador?(sim/não):");
                cadastrarNovoJogador = scanner.nextLine().trim().toLowerCase();
            }while (!cadastrarNovoJogador.equals("não") && !cadastrarNovoJogador.equals("sim"));
            if (cadastrarNovoJogador.equals("não")){
                for (Map<String,Object> dados : lista){
                    for (Map.Entry<String,Object> entry : dados.entrySet()){
                        System.out.println(entry.getKey()+": "+entry.getValue());
                    }
                    ArrayList<Integer> golsJogador = (ArrayList<Integer>) dados.get("Gol(s)");
                    for (int t=0;t<golsJogador.size();t++){
                        System.out.println(">>>>Na partida "+(t+1)+" fez:"+golsJogador.get(t)+" Gol(s)");
                    }
                }
                break;
            }
        }
    }


    public static void calculandoMediaAlunos(Scanner scanner){
        ArrayList<Aluno> lista = new ArrayList<>();
        while (true){
            String nome="";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Nome não pode ser vázio, tente novamente.");
                }else {
                    if (!nome.matches("^[a-zA-Z]+(\\s+[a-zA-Z\\s]+)+$")){
                        System.out.println("Digite um nome compatível.");
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
                    System.out.println("Digite uma nota entre 0 e 10.");
                }
            }
            float nota2 =0;
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
        for (int n=0;n<37;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-25s %-10s\n","No","Nome","Média");
        for (int n=0;n<37;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            Aluno aluno = lista.get(i);
            System.out.printf("%-4d %-25s %-10.2f\n",i,aluno.getNome(),aluno.getMedia());
        }
        for (int n=0;n<37;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar.):");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>Finalizando...");
                break;
            }else {
                if (opc<lista.size()){
                    Aluno aluno = lista.get(opc);
                    System.out.println("As notas de "+aluno.getnota1()+" foram: "+aluno.getnota1()+" e "+aluno.getNota2());
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
        public float getnota1(){
            return nota1;
        }
        public float getNota2() {
            return nota2;
        }
        public float getMedia() {
            return media;
        }
    }



    public static void jogosMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant=0;
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
            System.out.println((n+1)+"º jogo:"+jogos.get(n));
        }
    }


    public static void verificandoNumerosParesImpares(Scanner scanner){
        ArrayList<Integer> lista = obtendonumeros(scanner);
        ArrayList<Integer> listaPares = filtroPares(lista);
        ArrayList<Integer> listaImpares = filtroImpares(lista);
        System.out.println("A lista:"+lista);
        System.out.println("A lista de impares:"+listaImpares);
        System.out.println("A lista de pares:"+listaPares);
    }
    public static ArrayList<Integer> obtendonumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            System.out.print("Digite um número:");
            if (scanner.hasNextInt()){
                int numeros = scanner.nextInt();
                if (numeros<=-1){
                    System.out.println("Digite apenas números positivos.");
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("Número repetido, tente novamente.");
                        continue;
                    }else {
                        lista.add(numeros);
                    }
                    scanner.nextLine();
                    String addNovoNumero;
                    while (true){
                        System.out.print("Quer adicionar outro número?(sim/não):");
                        addNovoNumero = scanner.nextLine().trim().toLowerCase();
                        if (addNovoNumero.equals("não") || addNovoNumero.equals("sim")){
                            break;
                        }else {
                            System.out.println("Digite apenas sim ou não.");
                        }
                    }
                    if (addNovoNumero.equals("não")){
                        break;
                    }
                }
            }else {
                System.out.println("Digite um número inteiro e positivo.");
                scanner.next();
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtroPares(ArrayList<Integer> lista){
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (int numero: lista){
            if (numero%2==0){
                listaPares.add(numero);
            }
        }
        return listaPares;
    }
    public static ArrayList<Integer> filtroImpares(ArrayList<Integer> lista){
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (int numero : lista){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }


    public static void verificandoDadosJogadores(Scanner scanner){
        ArrayList<Map<String,Object>> lista = new ArrayList<>();
        while (true){
            Map<String,Object> jogador = new LinkedHashMap<>();
            String nome;
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo não pode ficar vázio, tente novamente.");
                }else {
                    if (!nome.matches("^[a-zA-Z\\s]+(\\s+[a-zA-Z]+)+$")){
                        System.out.println("Digite um nome verdadeiro.");
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
                    System.out.print("Quantas partidas?:");
                    partidas = Integer.parseInt(scanner.nextLine());
                    if (partidas<=0){
                        System.out.println("Digite um número maior que 0.");
                    }else {
                        jogador.put("Partidas",partidas);
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número maior que 0.");
                }
            }
            ArrayList<Integer> totalGols = new ArrayList<>();
            for (int n=0;n<partidas;n++){
                while (true){
                    System.out.print("Quantos gols na "+(n+1)+"º partida?:");
                    if (scanner.hasNextInt()){
                        int gols = scanner.nextInt();
                        if (gols<=-1){
                            System.out.println("Digite um número positivo.");
                        }else {
                            totalGols.add(gols);
                            break;
                        }
                    }else {
                        System.out.println("Digite um número inteiro positivo.");
                        scanner.next();
                    }
                }
            }
            scanner.nextLine();
            jogador.put("Gols",totalGols);
            jogador.put("Total Gols",totalGols.stream().mapToInt(Integer::intValue).sum());
            lista.add(jogador);
            String cadastrar;
            while (true){
                System.out.print("Quer cadastrar outro jogador?(sim/não):");
                cadastrar = scanner.nextLine().trim().toLowerCase();
                if (cadastrar.equals("sim") || cadastrar.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (cadastrar.equals("não")){
                for (Map<String,Object> dado : lista){
                    for (int n=0;n<22;n++){
                        System.out.print("=");
                    }
                    System.out.println();
                    for (Map.Entry<String,Object> entry : dado.entrySet()){
                        System.out.println(entry.getKey()+": "+entry.getValue());
                    }
                    Object golsObject = dado.get("Gols");
                    if (golsObject instanceof ArrayList<?>) {
                        ArrayList<Integer> golsJogador = (ArrayList<Integer>) golsObject;
                        for (int i=0;i<golsJogador.size();i++){
                            System.out.println(">>>Na partida "+(i+1)+" fez "+golsJogador.get(i));
                        }
                    } else {
                        System.out.println("O valor associado à chave 'Gols' não é uma lista de gols.");
                    }
                }
                break;
            }
        }
    }


    public static void situacaoAluno(Scanner scanner){
        ArrayList<Map<String,Object>> lista = new ArrayList<>();
        while (true){
            Map<String,Object> aluno = new LinkedHashMap<>();
            String nome="";
            while (true){
                System.out.print("Nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Campo nome não pode ficar vázio, tente novamente.");
                }else {
                    if (!nome.matches("^[a-zA-Z\\s]+(\\s+[a-zA-Z]+)+$")){
                        System.out.println("Digite apenas nomes e espaços vázios se necessário.");
                    }else {
                        nome  = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
                        aluno.put("Nome",nome);
                        break;
                    }
                }
            }
            ArrayList<Float> notas = new ArrayList<>();
            for (int i=0;i<2;i++){
                float nota=0;
                while (true){
                    try {
                        System.out.print("Digite a "+(i+1)+"º nota:");
                        nota = Float.parseFloat(scanner.nextLine());
                        if (nota<=-1 || nota>=11){
                            System.out.println("Digite uma nota entre 0 e 10.");
                        }else {
                            notas.add(nota);
                            aluno.put("Notas",notas);
                            break;
                        }
                    }catch (NumberFormatException erro){
                        System.out.println("Digite uma nota entre 0 e 10.");
                    }
                }
            }
            float soma=0;
            for (float nota : notas){
                soma+=nota;
            }
            float media =soma/notas.size();
            aluno.put("Média",media);
            if (media>=7){
                aluno.put("Situação","Aprovado(a)");
            } else if (media>=5 && media<=6.9) {
                aluno.put("Situação","Em recuperação");
            }else {
                aluno.put("Situação","Reprovado(a)");
            }
            lista.add(aluno);
            String addNotasAluno;
            while (true){
                System.out.print("Quer adicionar notas de outro aluno?(sim/não):");
                addNotasAluno = scanner.nextLine().trim().toLowerCase();
                if (addNotasAluno.equals("sim") || addNotasAluno.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (addNotasAluno.equals("não")){
                for (Map<String,Object> dados : lista){
                    for (int n=0;n<22;n++){
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


    public static void rankingJogadores(Scanner scanner, Random random){
        Map<String,Integer> jogador = new LinkedHashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10)+1);
        System.out.println("===Sorteio Jogadores===");
        for (Map.Entry<String,Integer> entry : jogador.entrySet()){
            System.out.println(entry.getKey()+": tirou "+entry.getValue());
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
            System.out.println((i+1)+"º lugar: "+entry.getKey()+" com "+entry.getValue());
        }
    }
}
