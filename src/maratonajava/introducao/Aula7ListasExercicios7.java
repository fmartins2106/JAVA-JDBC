package academy.devdojo.maratonajava.introducao;


import java.util.*;

public class Aula7ListasExercicios7 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        avaliando tabela do campeonato brasileiro
        tabelaCampeonatoBrasileiro(scanner);

//        verificando frase
        verificandoLetraA(scanner);

        //        verificando jogos lotofacil
        jogosLotofacil2(scanner,random);

//        verificando maior e menor de idade metodo2
        verificandoMaiorMenorIdade3(scanner);

//        verificando dados pessoas, maior e menor de idade
        verificandoMaiorMenorIdade2(scanner);

//        verificando expressão
        verificandoUmaExpressao(scanner);

//        verificando maior e menor peso;
        verificandoMaiorMenorPeso(scanner);

//        verificando numeros pares e impares da lista
        verificandoParesImparesLista(scanner);

//        analisando lista e posições
        analisandoListaPosicoes(scanner);

//        verificando lista com maior e menor de idade:
        verificandoMaiorMenorDeIdade(scanner);

//        verificando jogos mega sena
        jogosMegaSena(scanner,random);

//verificação maior e menor peso da lista.
//        verificandoMaiorMenorPeso(scanner);

//        verificação média alunos
        verifiandoMediaAlunos(scanner);

        scanner.close();
    }

    public static void tabelaCampeonatoBrasileiro(Scanner scanner){
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
        System.out.println("A tabela:"+Arrays.toString(times));
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os 5 primeiros da lista:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
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
                posicaoFlamengo= i+1;
            }
        }
        System.out.println("O flamengo está na posição:"+posicaoFlamengo);
        for (int n=0;n<250;n++){
            System.out.print("=");
        }
        System.out.println();

    }

    public static void verificandoLetraA(Scanner scanner){
        int contagem=0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (char letras: frase.toCharArray()){
            if ("a".indexOf(letras)!=-1){
                contagem++;
            }
        }
        System.out.println("Na frase:"+frase+", a letra A apareceu:"+contagem);
    }

    public static void jogosLotofacil2(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant=0;
        while (true){
            try {
                System.out.print("Digite quantos jogos você quer?:");
                quant = Integer.parseInt(scanner.nextLine());
                if (quant<=0){
                    System.out.println("Digite um número maior que 1.");
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
        for (int i=0;i<jogos.size();i++){
            System.out.println("jogo"+(i+1)+":"+jogos.get(i));
        }

    }

    public static void verificandoMaiorMenorIdade3(Scanner scanner){
        ArrayList<Pessoas> lista = new ArrayList<>();
        while (true){
            System.out.print("Nome:");
            String nomePessoa = scanner.nextLine().trim();
            nomePessoa = nomePessoa.substring(0,1).toUpperCase()+nomePessoa.substring(1).toLowerCase();
            int idadePessoa=0;
            while (true){
                System.out.print("Idade:");
                if (scanner.hasNextInt()){
                    idadePessoa = scanner.nextInt();
                    if (idadePessoa<=0){
                        System.out.println("Digite um valor válido.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Digite um número real.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            lista.add(new Pessoas(nomePessoa,idadePessoa));
            String addNovaPessoa;
            do {
                System.out.print("Quer adicionar nova pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("sim") && !addNovaPessoa.equals("não"));
            if (addNovaPessoa.equals("não")){
                break;
            }
        }
        int totalMaior = 0, totalMenor=0;
        for (Pessoas dados : lista){
            if (dados.idadePessoa>=18){
                System.out.println(dados.nomePessoa+", é maior de idade.");
                totalMaior++;
            }else {
                System.out.println(dados.nomePessoa+", é menor de idade.");
                totalMenor++;
            }
        }
        System.out.println("Total maior de idade:"+totalMaior);
        System.out.println("Total menor de idade:"+totalMenor);
    }


    static class Pessoas{
        private String nomePessoa;
        private int idadePessoa;

        public Pessoas(String nomePessoa, int idadePessoa){
            this.nomePessoa = nomePessoa;
            this.idadePessoa = idadePessoa;
        }
    }

    public static void verificandoMaiorMenorIdade2(Scanner scanner){
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
        int maiorIdade=0, menorIdade=0;
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

    public static void verificandoUmaExpressao(Scanner scanner){
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



    static class Pessoa{
        private String nome;
        private float peso;

        public Pessoa(String nome, float peso){
            this.nome = nome;
            this.peso = peso;
        }
    }

    public static void verificandoMaiorMenorPeso(Scanner scanner){
        ArrayList<Pessoa> lista = new ArrayList<>();
        float maiorPeso = Float.NEGATIVE_INFINITY, menorPeso=Float.POSITIVE_INFINITY;
        while (true){
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim().toLowerCase();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            float peso = 0;
            while (true){
                System.out.print("Digite o seu peso:");
                if (scanner.hasNextFloat()){
                    peso = scanner.nextFloat();
                    if (peso<=0){
                        System.out.println("Digite um peso quoerente.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Digite um peso válido.");
                    scanner.next();
                }
            }
            if (peso>maiorPeso){
                maiorPeso=peso;
            }
            if (peso<menorPeso){
                menorPeso=peso;
            }
            scanner.nextLine();
            lista.add(new Pessoa(nome,peso));
            String addNovaPessoa;
            do {
                System.out.print("Quer adiconar outra pessoa?(sim/não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("sim") && !addNovaPessoa.equals("não"));
            if (addNovaPessoa.equals("não")){
                for (Pessoa pessoa : lista){
                    if (pessoa.peso==maiorPeso){
                        System.out.println("O maior peso cadastrado foi:"+pessoa.nome+" | Peso:"+maiorPeso);
                    }
                }
                for (Pessoa pessoa: lista){
                    if (pessoa.peso==menorPeso){
                        System.out.println("O menor peso cadastrado foi:"+pessoa.nome+" | Peso:"+menorPeso);
                    }
                }
                break;
            }
        }
    }


    public static void verificandoParesImparesLista(Scanner scanner){
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
            System.out.print("Digite um número:");
            if (scanner.hasNextInt()){
                numeros = scanner.nextInt();
                if (numeros<=-1){
                    System.out.println("Digite um número positivo.");
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
                        continue;
                    }else {
                        lista.add(numeros);
                    }
                    scanner.nextLine();
                    String addNumeros;
                    do {
                        System.out.print("Quer adicionar outro número?(sim/não):");
                        addNumeros = scanner.nextLine().trim().toLowerCase();
                    }while (!addNumeros.equals("não") && !addNumeros.equals("sim"));
                    if (addNumeros.equals("não")){
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
    public static ArrayList<Integer> filtroPares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2==0){
                listaPares.add(numero);
            }
        }
        return listaPares;
    }
    public static ArrayList<Integer> filtroImpares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }

    public static void analisandoListaPosicoes(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            while (true){
                try {
                    System.out.print("Digite um número:");
                    int numeros = scanner.nextInt();
                    if (numeros<=-1){
                        System.out.println("Digite um número positivo.");
                        continue;
                    }else {
                        if (lista.contains(numeros)){
                            System.out.println("ERRO.Número repetido, tente outro.");
                            continue;
                        }else {
                            if (lista.isEmpty() || numeros>= lista.get(lista.size()-1)){
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
                    System.out.println("Digite um número válido.");
                }
            }
            scanner.nextLine();
            String addNovoNumero;
            do {
                System.out.print("Quer adicionar um número?(sim/não):");
                addNovoNumero = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoNumero.equals("sim") && !addNovoNumero.equals("não"));
            if (addNovoNumero.equals("não")){
                System.out.println("lista:"+lista);
                break;

            }
        }
    }


    public static void verificandoMaiorMenorDeIdade(Scanner scanner){
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
        int maiorIdade =0, menorIdade = 0;
        for (List<Object> pessoa : lista){
            String nome = (String) pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>=18){
                System.out.println(nome+", é maior de idade.");
                maiorIdade++;
            }else {
                System.out.println(nome+", é menor de idade.");
                menorIdade++;
            }
        }
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
        for (int i=0;i<jogos.size();i++){
            System.out.println("jogo"+(i+1)+":"+jogos.get(i));
        }
    }

//    public static void verificandoMaiorMenorPeso(Scanner scanner){
//        ArrayList<Pessoa> lista = new ArrayList<>();
//        float maiorPeso = Float.NEGATIVE_INFINITY, menorPeso = Float.POSITIVE_INFINITY;
//        while (true){
//            System.out.print("Digite o nome:");
//            String nome = scanner.nextLine().trim();
//            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
//            float peso=0;
//            while (true){
//                try {
//                    System.out.print("Digite o peso:");
//                    peso = Float.parseFloat(scanner.nextLine());
//                    if (peso<=0){
//                        System.out.println("Digite um peso válido.");
//                    }else {
//                        break;
//                    }
//                }catch (NumberFormatException erro){
//                    System.out.println("Digite um número válido.");
//                }
//            }
//            if (peso>maiorPeso){
//                maiorPeso=peso;
//            }
//            if (peso<menorPeso){
//                menorPeso=peso;
//            }
//            lista.add(new Pessoa(nome, peso));
//            String addNovaPessoa;
//            do {
//                System.out.print("Quer adicionar outra pessoa?(sim/não):");
//                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
//            }while (!addNovaPessoa.equals("sim") && !addNovaPessoa.equals("não"));
//            if (addNovaPessoa.equals("não")){
//                break;
//            }
//        }
//        System.out.println("No total você cadastro:"+lista.size()+" pessoas.");
//        for ( Pessoa nome : lista){
//            if (nome.peso==maiorPeso){
//                System.out.println("O maior peso da lista é:"+nome.nome+"|"+maiorPeso+"Kg");
//            }
//        }
//        for (Pessoa nome: lista){
//            if (nome.peso == menorPeso){
//                System.out.println("O menor peso da lista é:"+nome.nome+" |"+menorPeso+"Kg");
//            }
//        }
//    }
//
//
//
//    static class Pessoa{
//        private String nome;
//        private float peso;
//
//        public Pessoa(String nome, float peso){
//            this.nome = nome;
//            this.peso = peso;
//        }
//    }


    public static void verifiandoMediaAlunos(Scanner scanner){
        ArrayList<Aluno> lista = new ArrayList<>();
        while (true){
            System.out.print("Digite o nome:");
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
                    System.out.println("Digite um valor real.");
                }
            }
            float nota2 = 0;
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
                    System.out.println("Digite um valor real.");
                }
            }
            float media = (nota1+nota2)/2;
            lista.add(new Aluno(nome,nota1,nota2,media));
            String calcularOutraMedia;
            do {
                System.out.print("Quer calcular outra media?(sim/não):");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }while (!calcularOutraMedia.equals("não")  && !calcularOutraMedia.equals("sim"));
            if (calcularOutraMedia.equals("não")){
                break;
            }
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-10s %-8s\n","No", "Nome","Média");
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            Aluno aluno = lista.get(i);
            System.out.printf("%-4s %-10s %-8.2f\n",i,aluno.getNome(),aluno.getMedia());
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer ver notas de qual aluno?(Digite 999 para parar.)");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println("Finalizando o programa...");
                break;
            }else {
                if (opc<lista.size()){
                    Aluno aluno = lista.get(opc);
                    System.out.println("As notas de "+aluno.getNome()+", foram: "+aluno.getNota1()+" e "+aluno.getNota2()+".");
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


}
