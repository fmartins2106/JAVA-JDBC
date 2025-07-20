package academy.devdojo.maratonajava.introducao;



import java.util.*;


public class Aula7ListasExercicios11 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

//    verificando sorteio e ordem de jogadores;
        rankingJogadores3(scanner,random);

//    verificando matriz
        calculandoMatriz3(scanner);

//    sorteio e ordem de jogadores
        rankingJogadores2(scanner, random);

//    verificando expressao
        verificandoExpressa(scanner);

//    sorteio e ordem de jogadores
        rankingJogadores(scanner,random);

//    verificando matriz
        verificandoMatriz(scanner);

//    verificando a idade tipo2
        verificandoIdadeMaiorMenor2(scanner);

//    calculando matriz2
        calculandoMatriz2(scanner);

//    calculando uma matriz
        calculandoMatriz(scanner);

//    par e impar de forma diferente
        listandoParImpar(scanner);

//    verifiando maior e menor peso da lista
    verificandoMaiorMenorPeso(scanner);

//    verificando notas alunos
        calculandoMediaAlunos(scanner);

//    verificando idade, maior menor.
        verificandoIdadeMaiorMenor(scanner);

//    jogos mega sena
        jogosMegaSena(scanner, random);

//    verificando pares e impares da lista
        verificandoParesImparesLista(scanner);
    scanner.close();
    }

    public static void rankingJogadores3(Scanner scanner, Random random){
        Map<String, Integer> jogador = new HashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10)+1);
        System.out.println("====Ranking Sorteio====");
        for (Map.Entry<String, Integer> entry : jogador.entrySet()){
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
            Map.Entry<String, Integer> entry = ranking.get(i);
            System.out.println((i+1)+" ficou "+entry.getKey()+" com "+entry.getValue());
        }
    }

    public static void calculandoMatriz3(Scanner scanner){
        int maiorl2 =Integer.MIN_VALUE, somap=0, somac3=0;
        int[][] matriz = new int[3][3];
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.print("Digite um valor para posição:["+l+"]["+c+"]");
                matriz[l][c] = scanner.nextInt();
            }
        }
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.printf("[ %1d ]",matriz[l][c]);
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
        System.out.println("A soma dos números pares:"+somap);
        System.out.println("A soma dos numeros da coluna C3:"+somac3);
        System.out.println("O maior número da linha 2:"+maiorl2);

    }



    public static void rankingJogadores2(Scanner scanner, Random random){
        Map<String, Integer> jogador = new HashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10)+1);
        System.out.println("====Ranking Jogadores====");
        for (Map.Entry<String, Integer> entry : jogador.entrySet()){
            System.out.println(entry.getKey()+" tirou:"+entry.getValue());
            try {
                Thread.sleep(300);
            }catch (InterruptedException erro){
                erro.printStackTrace();
            }
        }
        List<Map.Entry<String, Integer>> ranking = new ArrayList<>(jogador.entrySet());
        ranking.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        System.out.println("====Ranking Jogadores====");
        for (int i=0;i<ranking.size();i++){
            Map.Entry<String, Integer> entry = ranking.get(i);
            System.out.println((i+1)+" posição: "+entry.getKey()+" com "+entry.getValue());
        }

    }


    public static void verificandoExpressa(Scanner scanner){
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

    public static void rankingJogadores(Scanner scanner, Random random){
        Map<String, Integer> jogador = new HashMap<>();
        jogador.put("Jogador 1", random.nextInt(10)+1);
        jogador.put("Jogador 2", random.nextInt(10)+1);
        jogador.put("Jogador 3", random.nextInt(10)+1);
        jogador.put("Jogador 4", random.nextInt(10+1));
        jogador.put("Jogador 5", random.nextInt(10)+1);
        System.out.println("====Valores sorteados====");
        for (Map.Entry<String, Integer> entry : jogador.entrySet()){
            System.out.println(entry.getKey()+" tirou "+entry.getValue()+" no dado.");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<Map.Entry<String,Integer>> ranking = new ArrayList<>(jogador.entrySet());
        ranking.sort((entry1,entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        System.out.println("===Ranking Jogadores===");
        for (int i=0;i<ranking.size();i++){
            Map.Entry<String, Integer>entry = ranking.get(i);
            System.out.println((i+1)+" Lugar:"+entry.getKey()+" com "+entry.getValue());
        }
        for (int n=0;n<26;n++){
            System.out.print("=");
        }
        System.out.println();
    }


    public static void verificandoMatriz(Scanner scanner){
        int somap=0,somac3=0,maiorl2= Integer.MIN_VALUE;
        int[][] matriz = new int[3][3];
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.print("Digite um valor para posição:["+l+"]["+c+"]:");
                matriz[l][c] = scanner.nextInt();
            }
        }
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.printf("[ %1d ]",matriz[l][c]);
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

    public static void verificandoIdadeMaiorMenor2(Scanner scanner){
        ArrayList<Pessoas> lista = new ArrayList<>();
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            int idade =0;
            while (true){
                try {
                    System.out.print("Digite a sua idade:");
                    idade = Integer.parseInt(scanner.nextLine());
                    if (idade<=-1){
                        System.out.println("Digite um número positivo.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            float peso;
            while (true){
                try {
                    System.out.print("Digite o seu peso:");
                    peso = Float.parseFloat(scanner.nextLine());
                    if (peso<=-1){
                        System.out.println("Digite um peso positivo.");
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
                    if (altura<=0 || altura>=2.50f){
                        System.out.println("Digite um valor válido.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            float imc = peso/(altura*2);
            lista.add(new Pessoas(nome, idade,peso,altura,imc));
            String addNovaPessoa;
            do {
                System.out.print("Quer adicionar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("sim") && !addNovaPessoa.equals("não"));
            if (addNovaPessoa.equals("não")){
                break;
            }
        }
        for (int n=0;n<50;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-10s %-8s %-8s %-8s %-8s%n","No","Nome","Idade","Peso","Altura","IMC");
        for (int n=0;n<50;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            Pessoas pessoa = lista.get(i);
            System.out.printf("%-4d %-10s %-8d %-8.2f %-8.2f %-8.2f%n",i,pessoa.getNome(),pessoa.getIdade(),pessoa.getPeso(),pessoa.getAltura(),pessoa.getImc());
        }
        for (int n=0;n<50;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Analisar o IMC de qual pessoa(Digite 999 para parar.):");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>Finalizando o programa...");
                break;
            }else {
                if (opc<lista.size()){
                    Pessoas pessoa = lista.get(opc);
                    if (pessoa.getImc()<=19){
                        System.out.println("O IMC de:"+pessoa.getNome()+", é "+String.format("%.2f",pessoa.getImc())+"| Está muito baixo procure um médico.");
                    }else if (pessoa.getImc()>=20 && pessoa.getImc()<=25){
                        System.out.println("O IMC de:"+pessoa.getNome()+", é "+String.format("%.2f",pessoa.getImc())+" | Está ideal. Parabéns!!!");
                    }else {
                        System.out.println("O IMC de:"+pessoa.getNome()+", é "+String.format("%.2f",pessoa.getImc())+" | Está acima do ideal. Procure um médico.");
                    }
                }
            }
        }




    }
    static class Pessoas{
        private String nome;
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


    public static void calculandoMatriz2(Scanner scanner){
        int somap = 0, somac3=0, maiorl2= Integer.MIN_VALUE;
        int[][] matriz = new int[3][3];
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.print("Digite um valor para posição: ["+l+"]["+c+"]");
                matriz[l][c] = scanner.nextInt();
            }
        }
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.printf("[%1d]",matriz[l][c]);
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
        System.out.println("A soma da coluna 3:"+somac3);
        System.out.println("O maior da linha 2:"+maiorl2);
    }


    public static void calculandoMatriz(Scanner scanner){
        int somap=0, soma3=0, maiorl2 = Integer.MIN_VALUE;
        int[][] matriz = new int[3][3];
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.print("Digite um valor para: ["+l+"]["+c+"]:");
                matriz[l][c] = scanner.nextInt();
            }
        }
        for (int l=0;l<3;l++){
            for (int c=0;c<3;c++){
                System.out.printf("[%1d]",matriz[l][c]);
                if (matriz[l][c]%2==0){
                    somap+=matriz[l][c];
                }
            }
            System.out.println();
        }
        for (int c=0;c<3;c++){
            soma3+= matriz[c][2];
        }
        for (int l=0;l<3;l++){
            if (l==0 || matriz[1][l]>maiorl2){
                maiorl2=matriz[1][l];
            }
        }
        System.out.println("A soma dos valores pares:"+somap);
        System.out.println("A soma dos valores da terceira coluna:"+soma3);
        System.out.println("O maior valor da segunda linha:"+maiorl2);
    }

    public static void listandoParImpar(Scanner scanner){
        ArrayList<ArrayList<Integer>> lista = new ArrayList<>();
        lista.add(new ArrayList<>());
        lista.add(new ArrayList<>());
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (numeros<=-1){
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
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número inteiro.");
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

    public static void verificandoMaiorMenorPeso(Scanner scanner){
        ArrayList<Pessoa> lista = new ArrayList<>();
        float maiorPeso=Float.NEGATIVE_INFINITY, menorPeso=Float.POSITIVE_INFINITY;
        while (true){
            System.out.print("Digite o nome:");
            String nomePessoa = scanner.nextLine().trim();
            nomePessoa = nomePessoa.substring(0,1).toUpperCase()+nomePessoa.substring(1).toLowerCase();
            float pesoPessoa = 0;
            while (true){
                try {
                    System.out.print("Peso:");
                    pesoPessoa = Float.parseFloat(scanner.nextLine());
                    if (pesoPessoa<=0){
                        System.out.println("Digite um peso maior que 0.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            if (pesoPessoa>maiorPeso){
                maiorPeso=pesoPessoa;
            }
            if (pesoPessoa<menorPeso){
                menorPeso=pesoPessoa;
            }
            lista.add(new Pessoa(nomePessoa,pesoPessoa));
            String addNovaPessoa;
            do {
                System.out.print("Quer cadastrar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("sim") && !addNovaPessoa.equals("não"));
            if (addNovaPessoa.equals("não")){
                break;
            }
        }
        for (Pessoa dados : lista){
            if (dados.pesoPessoa==maiorPeso){
                System.out.println("O maior peso da lista:"+dados.nomePessoa+" | Peso:"+maiorPeso);
            }
            if (dados.pesoPessoa==menorPeso){
                System.out.println("O maior peso da lista:"+dados.nomePessoa+" | Peso:"+menorPeso);
            }
        }
    }


    public static void calculandoMediaAlunos(Scanner scanner){
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
                    System.out.println("Digite uma nota entre 0 e 10.");
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
            String calcularNovaMedia;
            do {
                System.out.print("Quer calcular média outro aluno?(sim/não):");
                calcularNovaMedia = scanner.nextLine().trim().toLowerCase();
            }while (!calcularNovaMedia.equals("não") && !calcularNovaMedia.equals("sim"));
            if (calcularNovaMedia.equals("não")){
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
            System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar.)");
            int opc  = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>Finalizando o programa...");
                break;
            }else {
                if (opc<lista.size()){
                    Aluno aluno = lista.get(opc);
                    System.out.println("As notas de "+aluno.getNome()+", foram:"+aluno.getNota1()+" e "+aluno.getNota2());
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


    public static void verificandoIdadeMaiorMenor(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        int totalMaior=0,totalMenor=0;
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
        for (List<Object> dados : lista){
            String nome = (String)dados.get(0);
            int idade = (int)dados.get(1);
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


    public static void jogosMegaSena(Scanner scanner, Random random){
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
                System.out.println("Digite um número intero maior que 1.");
            }
        }
        for (int total=0;total<quant;total++){
            Set<Integer> lista =new HashSet<>();
            while (lista.size()<6){
                int jogo = random.nextInt(60)+1;
                lista.add(jogo);
            }
            ArrayList<Integer> jogoList = new ArrayList<>(lista);
            Collections.sort(jogoList);
            jogos.add(jogoList);
        }
        for (int i=0;i<jogos.size();i++){
            System.out.println("jogo"+(i+1)+":"+jogos.get(i));
        }
    }

    public static void verificandoParesImparesLista(Scanner scanner){
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
                        System.out.println("Números repetido.Tente outro.");
                        continue;
                    }else {
                        lista.add(numeros);
                    }
                    String addNumeros;
                    do {
                        System.out.print("Quer adicionar outro número?(sim/não):");
                        addNumeros = scanner.nextLine().trim().toLowerCase();
                    }while (!addNumeros.equals("não") && !addNumeros.equals("sim"));
                    if (addNumeros.equals("não")){
                        break;
                    }
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO.Digite um número real.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtroPar(ArrayList<Integer> numeros){
        ArrayList<Integer> listaPar = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2==0){
                listaPar.add(numero);
            }
        }
        return listaPar;
    }
    public static ArrayList<Integer> filtroImpar(ArrayList<Integer> numeros){
        ArrayList<Integer> listaImpar = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaImpar.add(numero);
            }
        }
        return listaImpar;
    }

}
