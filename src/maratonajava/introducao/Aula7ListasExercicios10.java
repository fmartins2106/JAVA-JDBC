package academy.devdojo.maratonajava.introducao;


import java.util.*;

public class Aula7ListasExercicios10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //colocando pares e impares em uma lista composta
        listaParesImparesEmListaComposta(scanner);

//        verificando maior e menor peso da lista;
        verificandoMaiorMenorPesoLista(scanner);

//        calculando media notas
        calculandoMediaNotas(scanner);

//        verifiacando maior, menor idade;
        verificandoMaiorMenorIdade(scanner);

//        verificando jogos Mega Sena
        jogosMegaSena(scanner, random);

//        verificando pares e impares da lista
        verificandoParesImpares(scanner);
        scanner.close();
    }

    public static void listaParesImparesEmListaComposta(Scanner scanner){
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
                            System.out.print("Quer add novo número?(sim/não)");
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
                System.out.println("Digite um número real.");
            }
        }
    }

    public static void verificandoMaiorMenorPesoLista(Scanner scanner){
        ArrayList<Pessoa> lista = new ArrayList<>();
        float maiorPeso = Float.NEGATIVE_INFINITY, menorPeso = Float.POSITIVE_INFINITY;

        while (true){
            System.out.print("Nome:");
            String nomePessoa = scanner.nextLine().trim().toLowerCase();
            nomePessoa = nomePessoa.substring(0,1).toUpperCase()+nomePessoa.substring(1).toLowerCase();
            float pesoPessoa;
            while (true){
                try {
                    System.out.print("Digite o peso:");
                    pesoPessoa = Float.parseFloat(scanner.nextLine());
                    if (pesoPessoa<=-1){
                        System.out.println("Digite apenas números positivos.");
                    }else{
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            if (pesoPessoa>maiorPeso){
                maiorPeso = pesoPessoa;
            }
            if (pesoPessoa<menorPeso){
                menorPeso = pesoPessoa;
            }
            lista.add(new Pessoa(nomePessoa,pesoPessoa));
            String addNovaPessoa;
            do {
                System.out.print("Quer adicionar outra pessoa?(sim-não):");
                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addNovaPessoa.equals("sim") && !addNovaPessoa.equals("não"));
            if (addNovaPessoa.equals("não")){
                for (Pessoa dados : lista){
                    if (dados.pesoPessoa==maiorPeso){
                        System.out.println("O maior peso da lista:"+dados.nomePessoa+" | Peso:"+maiorPeso);
                    }
                }
                for (Pessoa dados : lista){
                    if (dados.pesoPessoa==menorPeso){
                        System.out.println("O menor peso da lista:"+dados.nomePessoa+" | Peso:"+menorPeso);
                    }
                }
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


    public static void calculandoMediaNotas(Scanner scanner){
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
                        System.out.println("ERRO.Digite uma nota entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            float nota2=0;
            while (true){
                try {
                    System.out.print("Digite a segunda nota:");
                    nota2 = Float.parseFloat(scanner.nextLine());
                    if (nota2<=-1 || nota2>=11){
                        System.out.println("ERRO.Digite uma nota entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            float media = (nota1+nota2)/2;
            lista.add(new Aluno(nome,nota1,nota2,media));
            String addNumeroAluno;
            do {
                System.out.print("Quer adicionar outro aluno?(sim/não):");
                addNumeroAluno = scanner.nextLine().trim().toLowerCase();
            }while (!addNumeroAluno.equals("sim") && !addNumeroAluno.equals("não"));
            if (addNumeroAluno.equals("não")){
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
            System.out.printf("%-4s %-10s %-8.2f\n",i,aluno.getNome(),aluno.getMedia());
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.print("Quer ver a nota de qual aluno?(Digite 999 para parar.)");
            int opc = scanner.nextInt();
            if (opc==999){
                System.out.println(">>>Finalizando...");
                break;
            }else {
                if (opc<lista.size()){
                    Aluno aluno = lista.get(opc);
                    System.out.println("As notas de "+ aluno.getNome()+", foram:"+aluno.getNota1()+" e "+aluno.getNota2());
                }
            }
        }


    }
    static class Aluno {
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
        ;
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
            quant = Integer.parseInt(scanner.nextLine());
            if (quant<=-1){
                System.out.println("Digite apenas números positivos.");
            }else {
                break;
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
            System.out.println("jogo"+(n+1)+":"+jogos.get(n));
        }

    }



    public static void verificandoParesImpares(Scanner scanner){
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
                        System.out.println("Número repetido.Tente outro.");
                        continue;
                    }else {
                        lista.add(numeros);
                    }
                    String addNumeros;
                    do {
                        System.out.print("Quer adicionar outro número?(sim/não):");
                        addNumeros = scanner.nextLine().trim().toLowerCase();
                    }while (!addNumeros.equals("sim") && !addNumeros.equals("não"));
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


}
