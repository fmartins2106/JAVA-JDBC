package academy.devdojo.maratonajava.introducao;




import java.util.*;

public class Aula7ListasExercicios6 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();



        //        verificando maior e menor peso da lista
        verificandoMaiorMenorPesoLista3(scanner);

// verificando numeros pares e impares da lista
        verificandoNumerosParesImparesLista(scanner);

//        verificando cadastro pessoas
        verificandocadastroPessoasPorIdade(scanner);

//        jogos da lotofacil
        jogosLotofacil(scanner,random);

//        verificando maior e menor peso da lista
//        verificandoMaiorMenorPesoLista2(scanner);

//verificando o maior e menor peso da lista
//        verificandoMaiorMenorPesoLista(scanner);

//        calculando media alunos 5
        calculandoMediaAlunos5(scanner);


//        verificando numeros pares e impares
        verifiacandoParesImpares(scanner);

//        verificando a lista quem é maior e menor de idade
        listaMaiorMenorIdade(scanner);

//        jogos da mega sena
        jogosMegaSena2(scanner,random);

////        calculando media alunos4
//        calculandoMediaAluno4(scanner);

//        verificando expressão
        verificandoUmaExpressao(scanner);

//        verificando media alunos;
        verificandoMedia(scanner);

//        verificando array de números
        arrayNumeros(scanner);

////        calculando media alunos
//        calculandoMediaAlunos3(scanner);

//        posição numeros lista
        posicaoNumerosLista(scanner);

//        verificando jogos mega sena
        jogosMegaSena(scanner,random);

//        verificando media alunos2
//        calculandoMediaAluno2(scanner);

//        verificando numeros pares e impares
        verificcandoNumerosParesImpares(scanner);


//verificando maior e menor de idade da lista
        verificandoMaiorMenorDeIdade(scanner);

//        verificando média dos alunos.
//        verificandoMediaAlunos(scanner);
        scanner.close();
    }

    static class Pessoa{
        private String nome;
        private float peso;

        public Pessoa(String nome, float peso){
            this.nome = nome;
            this.peso = peso;
        }
    }
    public static void verificandoMaiorMenorPesoLista3(Scanner scanner){
        ArrayList<Pessoa> lista = new ArrayList<>();
        float maiorNumero = Float.NEGATIVE_INFINITY, menorNumero = Float.POSITIVE_INFINITY;
        while (true){
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
            float peso=0;
            while (true){
                try {
                    System.out.print("Digite o peso:");
                    peso = Float.parseFloat(scanner.nextLine());
                    if (peso<=0){
                        System.out.println("Digite um valor positivo.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor real.");
                }
            }
            if (peso>maiorNumero){
                maiorNumero=peso;
            }
            if (peso<menorNumero){
                menorNumero=peso;
            }
            lista.add(new Pessoa(nome,peso));
            String addOutraPessoa;
            do {
                System.out.print("Quer adicionar outra pessoa?(sim/não):");
                addOutraPessoa = scanner.nextLine().trim().toLowerCase();
            }while (!addOutraPessoa.equals("sim") && !addOutraPessoa.equals("não"));
            if (addOutraPessoa.equals("não")){
                break;
            }
        }
        for (Pessoa nome : lista){
            if (nome.peso==maiorNumero){
                System.out.println("O maior peso foi de "+nome.nome+"|"+maiorNumero+"Kg");
            }
        }
        for (Pessoa nome : lista){
            if (nome.peso==menorNumero){
                System.out.println("O menor peso foi de "+nome.nome+"|"+menorNumero+"Kg");
            }
        }

    }

    public static void verificandoNumerosParesImparesLista(Scanner scanner){
        ArrayList<Integer> listas = obterNumeros(scanner);
        ArrayList<Integer> listaPares = filtroNumeroPares(listas);
        ArrayList<Integer> listaImpares = filtrandoNumerosImpares(listas);
        System.out.println("A lista:"+listas);
        System.out.println("lista de pares:"+listaPares);
        System.out.println("Lista de Impares:"+listaImpares);
    }
    public static ArrayList<Integer> obterNumeros(Scanner scanner){
        ArrayList<Integer> listas = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = scanner.nextInt();
                if (numeros<=0){
                    System.out.println("Digite um número positivo.");
                }else {
                    if (listas.contains(numeros)){
                        System.out.println("ERRO.Número já adicionado, tente outro.");
                        continue;
                    }else {
                        listas.add(numeros);
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
            }catch (NumberFormatException erro){
                System.out.println("Digite um número real.");
            }
        }
        return listas;
    }
    public static ArrayList<Integer> filtroNumeroPares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2==0){
                listaPares.add(numero);
            }
        }
        return listaPares;
    }
    public static ArrayList<Integer> filtrandoNumerosImpares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }


    public static void verificandocadastroPessoasPorIdade(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        int totalMaior=0, totalMenor=0;
        for (int n=0;n<4;n++){
            List<Object> dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            System.out.print("Idade:");
            dados.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(dados);
        }
        System.out.println(lista);
        for (List<Object> pessoa: lista){
            String nome = (String)pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>18){
                System.out.println(nome+", é maior de idade.");
                totalMaior++;
            }else {
                System.out.println(nome+", é menor de idade.");
                totalMenor++;
            }
        }
        System.out.println("Total de "+totalMaior+" maiores de idade.");
        System.out.println("Total de "+totalMenor+" menores de idade.");

    }

    public static void jogosLotofacil(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant =0;
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
                System.out.println("Digite um valor real.");
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

//    static class Pessoa{
//        private String nome;
//        private float peso;
//
//        public Pessoa(String nome, float peso){
//            this.nome = nome;
//            this.peso = peso;
//        }
//    }
//    public static void verificandoMaiorMenorPesoLista2(Scanner scanner){
//        ArrayList<Pessoa> lista = new ArrayList<>();
//        float menorPeso = Float.POSITIVE_INFINITY, maiorPeso = Float.NEGATIVE_INFINITY;
//        while (true){
//            System.out.print("Nome:");
//            String nome = scanner.nextLine().trim();
//            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
//            float peso=0;
//            while (true){
//                try {
//                    System.out.print("Digite o peso:");
//                    peso = Float.parseFloat(scanner.nextLine());
//                    if (peso<=0){
//                        System.out.println("Digite uma peso positivo.");
//                    }else {
//                        break;
//                    }
//                }catch (NumberFormatException erro){
//                    System.out.println("Digite um valor válido.");
//                }
//            }
//            if (peso>maiorPeso){
//                maiorPeso=peso;
//            }
//            if (peso<menorPeso){
//                menorPeso=peso;
//            }
//            lista.add(new Pessoa(nome, peso));
//            String cadastraOutraPessoa;
//            do {
//                System.out.print("Quer cadastrar outra pessoa?(sim/não):");
//                cadastraOutraPessoa = scanner.nextLine().trim().toLowerCase();
//            }while (!cadastraOutraPessoa.equals("não") && !cadastraOutraPessoa.equals("sim"));
//            if (cadastraOutraPessoa.equals("não")){
//                break;
//            }
//        }
//        System.out.println("Foram cadastrados no total: "+lista.size()+" pessoas.");
//        for (Pessoa nome : lista){
//            if (nome.peso==maiorPeso){
//                System.out.println("O maior peso:"+nome.nome+" = "+maiorPeso+"Kg");
//            }
//        }
//        for (Pessoa nome: lista){
//            if (nome.peso==menorPeso){
//                System.out.println("O menor peso: "+nome.nome+" = "+menorPeso+"Kg");
//            }
//        }
//    }


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
        public float getNota1(){
            return nota1;
        }

        public float getNota2() {
            return nota2;
        }

        public float getMedia() {
            return media;
        }
    }
    public static void calculandoMediaAlunos5(Scanner scanner){
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
                        System.out.println("ERRO.Digite uma nota entre 0 e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            float nota2 = 0;
            while (true){
                try {
                    System.out.print("Digite o segundo número:");
                    nota2 = Float.parseFloat(scanner.nextLine());
                    if (nota2<=-1 || nota2>=11){
                        System.out.println("ERRO.Digit euma nota entre o e 10.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            float media = (nota1+nota2)/2;
            lista.add(new Aluno(nome,nota1,nota2,media));
            String calcularMediaOutroAluno;
            do {
                System.out.print("Quer adicionar média de outro aluno?(sim-não):");
                calcularMediaOutroAluno = scanner.nextLine().trim();
            }while (!calcularMediaOutroAluno.equals("sim") && !calcularMediaOutroAluno.equals("não"));
            if (calcularMediaOutroAluno.equals("não")){
                break;
            }
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        System.out.printf("%-4s %-10s %-8s\n","No", "Nome", "Média");
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        for (int i=0;i<lista.size();i++){
            Aluno aluno = lista.get(i);
            System.out.printf("%-4d %-10s %-8.2f\n",i, aluno.getNome(), aluno.getMedia());
        }
        for (int n=0;n<22;n++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            for (int n=0;n<80;n++){
                System.out.print("=");
            }
            System.out.println();
            System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar.)");
            int notas  = scanner.nextInt();
            if (notas==999){
                System.out.println("Finalizando o programa...");
                break;
            }else {
                if (notas<lista.size()){
                    Aluno aluno = lista.get(notas);
                    System.out.printf("As notas de %s, foram: %.2f e %.2f\n",aluno.getNome(),aluno.getNota1(),aluno.getNota2());
                    for (int n=0;n<80;n++){
                        System.out.print("=");
                    }
                    System.out.println();
                }
            }
        }
    }




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

//    public static void verificandoMaiorMenorPesoLista(Scanner scanner){
//        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
//        float maiorPeso= Float.NEGATIVE_INFINITY, menorPeso = Float.POSITIVE_INFINITY;
//        while (true){
////            scanner.nextLine();
//            System.out.print("Nome:");
//            String nome = scanner.nextLine().trim();
//            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
//            float peso=0;
//            while (true){
//                System.out.print("Peso:");
//                if (scanner.hasNextFloat()){
//                    peso = scanner.nextFloat();
//                    if (peso<=0){
//                        System.out.println("Digite um número positivo.");
//                    }else {
//                        break;
//                    }
//                }else {
//                    System.out.println("Digite um peso válido.");
//                    scanner.next();
//                }
//            }
//            scanner.nextLine();
//            if (peso>maiorPeso){
//                maiorPeso=peso;
//            }
//            if (peso<menorPeso){
//                menorPeso=peso;
//            }
//            listaPessoas.add(new Pessoa(nome,peso));
//            String addNovaPessoa;
//            do {
//                System.out.print("Quer adicionar outra pessoa?(sim/não):");
//                addNovaPessoa = scanner.nextLine().trim().toLowerCase();
//            }while (!addNovaPessoa.equals("não") && !addNovaPessoa.equals("sim"));
//            if (addNovaPessoa.equals("não")){
//                break;
//            }
//        }
//        System.out.println("Ao todo você cadastrou:"+ listaPessoas.size());
//        System.out.println("O maior peso da lista foi:"+maiorPeso);
//        for (Pessoa nome : listaPessoas){
//            if (nome.peso==maiorPeso){
//                System.out.println(nome.nome);
//            }
//        }
//        System.out.println("O menor peso da lista foi:"+menorPeso);
//        for (Pessoa nome: listaPessoas){
//            if (nome.peso==menorPeso){
//                System.out.println(nome.nome);
//            }
//        }
//     }

    public static void verifiacandoParesImpares(Scanner scanner){
        ArrayList<Integer> listaNumeros = addNumeros(scanner);
        ArrayList<Integer> listaPares = filtroPares(listaNumeros);
        ArrayList<Integer> listaImpares = filtroImpares(listaNumeros);
        System.out.println("A lista:"+listaNumeros);
        System.out.println("Lista de pares:"+listaPares);
        System.out.println("Lista de impares:"+listaImpares);
    }
    public static ArrayList<Integer> addNumeros(Scanner scanner){
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros= Integer.parseInt(scanner.nextLine());
                if (numeros<=-1){
                    System.out.println("Digite apenas números positivos.");
                }else {
                    if (listaNumeros.contains(numeros)){
                        System.out.println("ERRO.Número repetido, tente outro.");
                        continue;
                    }else {
                        listaNumeros.add(numeros);
                    }
                    String addNumerosLista;
                    do {
                        System.out.print("Quer adicionar outro número na lista?(sim-não):");
                        addNumerosLista = scanner.nextLine().trim().toLowerCase();
                    }while (!addNumerosLista.equals("sim") && !addNumerosLista.equals("não"));
                    if (addNumerosLista.equals("não")){
                        break;
                    }
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número real positivo.");
            }
        }
        return listaNumeros;
    }
    public static ArrayList<Integer> filtroPares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (int numero: numeros){
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

    public static void listaMaiorMenorIdade(Scanner scanner){
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
        for (List<Object> pessoas: lista){
            String nome = (String)pessoas.get(0);
            int idade = (int)pessoas.get(1);
            if (idade>=18){
                System.out.println(nome+", é maior de idade.");
                totalMaior++;
            }else {
                System.out.println(nome+", é menor de idade.");
                totalMenor++;
            }
        }
        System.out.println("Total de pessoas maiores de idade:"+totalMaior+" | Total de pessoas menores de idade:"+totalMenor);
    }

    public static void jogosMegaSena2(Scanner scanner, Random random){
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
                System.out.print("Digite um número real.");
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

//    public static void calculandoMediaAluno4(Scanner scanner){
//        ArrayList<Aluno> lista = new ArrayList<>();
//        while (true){
//            System.out.print("Nome do aluno:");
//            String nome = scanner.nextLine().trim();
//            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
//            float nota1=0;
//            while (true){
//                try {
//                    System.out.print("Digite a primeira nota:");
//                    nota1 = Float.parseFloat(scanner.nextLine());
//                    if (nota1<=-1 || nota1>=11){
//                        System.out.println("Digite uma nota entre 0 e 10.");
//                    }else {
//                        break;
//                    }
//                }catch (NumberFormatException erro){
//                    System.out.println("Digite um númro real.");
//                }
//            }
//            float nota2=0;
//            while (true){
//                try {
//                    System.out.print("Digite a segunda nota:");
//                    nota2 = Float.parseFloat(scanner.nextLine());
//                    if (nota2<=-1 || nota2>=11){
//                        System.out.println("Digite uma nota entre 0 e 10.");
//                    }else {
//                        break;
//                    }
//                }catch (NumberFormatException erro){
//                    System.out.println("Digite um número real.");
//                }
//            }
//            float media= (nota1+nota2)/2;
//            lista.add(new Aluno(nome,nota1,nota2,media));
//            String calcularOutraMedia;
//            do {
//                System.out.print("Quer calcular outra média?(sim/não):");
//                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
//            }while (!calcularOutraMedia.equals("não") && !calcularOutraMedia.equals("sim"));
//            if (calcularOutraMedia.equals("não")){
//                break;
//            }
//        }
//        for (int n=0;n<22;n++){
//            System.out.print("=");
//        }
//        System.out.println();
//        System.out.printf("%-4s %-10s %-8s%n","No", "Nome","Média");
//        for (int n=0;n<22;n++){
//            System.out.print("=");
//        }
//        System.out.println();
//        for (int i=0;i<lista.size();i++){
//            Aluno aluno = lista.get(i);
//            System.out.printf("%-4s %-10s %-8.2f%n",i, aluno.getNome(),aluno.getMedia());
//        }
//        for (int n=0;n<22;n++){
//            System.out.print("=");
//        }
//        System.out.println();
//        while (true){
//            System.out.print("Quer ver as notas de qual aluno?(Digite 999 para parar.):");
//            int notas = scanner.nextInt();
//            if (notas==999){
//                System.out.println(">>>Finalizando o programa...");
//                break;
//            }else {
//                if (notas<lista.size()){
//                   Aluno aluno = lista.get(notas);
//                    System.out.printf("As notas de %s, foram: %.2f e %.2f%n",aluno.getNome(),aluno.getNota1(),aluno.getNota2());
//                }
//            }
//        }
//    }
//    static class Aluno{
//        private String nome;
//        private float nota1;
//        private float nota2;
//        private float media;
//
//        public Aluno(String nome, float nota1, float nota2, float media){
//            this.nome = nome;
//            this.nota1 = nota1;
//            this.nota2 = nota2;
//            this.media = media;
//        }
//        public String getNome() {
//            return nome;
//        }
//        public float getNota1(){
//            return nota1;
//        }
//        public float getNota2() {
//            return nota2;
//        }
//        public float getMedia() {
//            return media;
//        }
//    }



    public static void verificandoUmaExpressao(Scanner scanner){
        Stack<Character> pilhaParenteses = new Stack<>();
        System.out.print("Digite uma expressão:");
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

    public static void verificandoMedia(Scanner scanner){
        float soma=0, contNumeros=0;
        while (true){
            while (true){
                try {
                    System.out.print("Digite uma nota?:");
                    float notas = Float.parseFloat(scanner.nextLine());
                    if (notas<=-1 || notas>=11){
                        System.out.println("Digite uma nota entre 0 e 10.");
                    }else {
                        soma+=notas;
                        contNumeros++;
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite uma nota válida.");
                }
            }
            String addNota;
            do {
                System.out.print("Quer adicionar outra nota?(sim/não):");
                addNota = scanner.nextLine().trim().toLowerCase();
            }while (!addNota.equals("não") && !addNota.equals("sim"));
            if (addNota.equals("não")){
                float media = soma/contNumeros;
                System.out.println("A média:"+media);
                String calcularOutraMedia;
                do {
                    System.out.print("Quer calcular outra média?(sim/não):");
                    calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
                }while (!calcularOutraMedia.equals("sim") && !calcularOutraMedia.equals("não"));
                if (calcularOutraMedia.equals("não")){
                    System.out.println(">>>>Finalizando programa...");
                    break;
                }else {
                    soma=0;
                    contNumeros=0;
                }
            }
        }
    }

    public static void arrayNumeros(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE, pMaior=0, pMenor=0;
        for (int n=0;n<arrayNumeros.length;n++){
            while (true){
                System.out.print("Digite o "+(n+1)+"º número da lista:");
                if (scanner.hasNextInt()){
                    arrayNumeros[n]=scanner.nextInt();
                    if (arrayNumeros[n]<=-1){
                        System.out.println("Digite um número positivo.");
                    }else {
                        boolean numeroRepetido = false;
                        for (int i=0;i<n;i++){
                            if (arrayNumeros[n]==arrayNumeros[i]){
                                numeroRepetido = true;
                                break;
                            }
                        }
                        if (numeroRepetido){
                            System.out.println("ERRO.Número repetido, tente outro.");
                        }else {
                            break;
                        }
                    }
                }else {
                    System.out.println("ERRO.Digite um número real.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            if (arrayNumeros[n]>maiorNumero){
                maiorNumero=arrayNumeros[n];
                pMaior=n;
            }
            if (arrayNumeros[n]<menorNumero){
                menorNumero=arrayNumeros[n];
                pMenor=n;
            }
        }
        System.out.println("O maior da lista:"+maiorNumero+" | Está na posição:"+pMaior);
        System.out.println("O menor da lista:"+menorNumero+" | Está na posição:"+pMenor);

    }

//    public static void calculandoMediaAlunos3(Scanner scanner){
//        ArrayList<Aluno> lista = new ArrayList<>();
//        String nome;
//        while (true){
//            System.out.print("Digite o nome:");
//            nome = scanner.nextLine().trim();
//            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
//            float nota1=0;
//            while (true){
//                try {
//                    System.out.print("Digite a primeira nota:");
//                    nota1 = Float.parseFloat(scanner.nextLine());
//                    if (nota1<=-1 || nota1>=11){
//                        System.out.println("Digite uma nota entre 0 e 10.");
//                    }else {
//                        break;
//                    }
//                }catch (NumberFormatException erro){
//                    System.out.println("Digite uma nota válida.");
//                }
//            }
//            float nota2=0;
//            while (true){
//                try {
//                    System.out.print("Digite a segunda nota:");
//                    nota2 = Integer.parseInt(scanner.nextLine());
//                    if (nota2<=-1 || nota2>=11){
//                        System.out.println("Digite uma nota entre 0 e 10.");
//                    }else {
//                        break;
//                    }
//                }catch (NumberFormatException erro){
//                    System.out.println("Digite uma nota válida.");
//                }
//            }
//            float media = (nota1+nota2)/2;
//            lista.add(new Aluno(nome, nota1,nota2,media));
//            String calcularMediaOutroAluno;
//            do {
//                System.out.print("Quer calcular média de outro aluno?(sim/não):");
//                calcularMediaOutroAluno = scanner.nextLine().trim().toLowerCase();
//            }while (!calcularMediaOutroAluno.equals("sim") && !calcularMediaOutroAluno.equals("não"));
//            if (calcularMediaOutroAluno.equals("não")){
//                break;
//            }
//        }
//        for (int n=0;n<22;n++){
//            System.out.print("=");
//        }
//        System.out.println();
//        System.out.printf("%-4s %-10s %-8s\n", "No","Nome","Média");
//        for (int n=0;n<22;n++){
//            System.out.print("=");
//        }
//        System.out.println();
//        for (int i=0;i<lista.size();i++){
//            Aluno aluno = lista.get(i);
//            System.out.printf("%-4s %-10s %-8.2f\n",i, aluno.getNome(),aluno.getMedia());
//        }
//        for (int n=0;n<22;n++){
//            System.out.print("=");
//        }
//        System.out.println();
//        while (true){
//            System.out.print("Quer ver as notas de qual aluno?(digite 999 para parar.):");
//            int notas = scanner.nextInt();
//            if (notas==999){
//                System.out.println("Finalizando o programa...");
//                break;
//            }else {
//                for (int n=0;n<22;n++){
//                    System.out.print("=");
//                }
//                System.out.println();
//                if (notas<lista.size()){
//                    Aluno aluno = lista.get(notas);
//                    System.out.printf("Notas de %s foram: %.2f e %.2f.\n", aluno.getNome(), aluno.getNota1(),aluno.getNota2());
//                    for (int n=0;n<22;n++){
//                        System.out.print("=");
//                    }
//                    System.out.println();
//                }
//            }
//        }
//    }
//
//    static class Aluno{
//        private String nome;
//        private float nota1;
//        private float nota2;
//        private float media;
//
//        public Aluno(String nome, float nota1, float nota2, float media){
//            this.nome = nome;
//            this.nota1 = nota1;
//            this.nota2 = nota2;
//            this.media = media;
//        }
//        public String getNome() {
//            return nome;
//        }
//        public float getNota1() {
//            return nota1;
//        }
//        public float getNota2(){
//            return nota2;
//        }
//        public float getMedia(){
//            return media;
//        }
//    }


    public static void posicaoNumerosLista(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (numeros<=-1){
                        System.out.println("Digite um número real.");
                    }else {
                        if (lista.contains(numeros)){
                            System.out.println("Número já consta na lista, tente outro.");
                        }else {
                            if (lista.isEmpty() || numeros>= lista.get(lista.size()-1)){
                                lista.add(numeros);
                                System.out.println("Adicionado no final da lista.");
                            }else {
                                int pos =0;
                                while (pos<lista.size()){
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
                }else {
                    System.out.println("Digite um número real.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            String adicionarNumeros;
            do {
                System.out.print("Quer adicionar outro número?(sim/não):");
                adicionarNumeros = scanner.nextLine().trim().toLowerCase();
            }while (!adicionarNumeros.equals("sim") && !adicionarNumeros.equals("não"));
            if (adicionarNumeros.equals("não")){
                System.out.println("A lista:"+lista);
                break;
            }
        }
    }


//    public static void calculandoMediaAluno2(Scanner scanner){
//        ArrayList<Aluno> lista = new ArrayList<Aluno>();
//        while (true){
//            System.out.print("Digite o nome:");
//            String nome = scanner.nextLine().trim();
//            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
//            float nota1=0;
//            while (true){
//                try {
//                    System.out.print("Digite a primeira nota:");
//                    nota1 = Float.parseFloat(scanner.nextLine());
//                    if (nota1<=-1 || nota1>=11){
//                        System.out.println("Digite um número entre 0 e 10.");
//                    }else {
//                        break;
//                    }
//                }catch (NumberFormatException erro){
//                    System.out.println("Digite um número real.");
//                }
//            }
//            float nota2=0;
//            while (true){
//                try {
//                    System.out.print("Digite o segundo número:");
//                    nota2 = Float.parseFloat(scanner.nextLine());
//                    if (nota2<=-1 || nota2>=11){
//                        System.out.println("Digite um número entre 0 e 10.");
//                    }else {
//                        break;
//                    }
//                }catch (NumberFormatException erro){
//                    System.out.println("Digite um número real.");
//                }
//            }
//            float media = (nota1+nota2)/2;
//            lista.add(new Aluno(nome,nota1,nota2,media));
//            String calcularOutraMedia;
//            do {
//                System.out.print("Quer calcular outra média?(sim/não):");
//                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
//            }while (!calcularOutraMedia.equals("sim") && !calcularOutraMedia.equals("não"));
//            if (calcularOutraMedia.equals("não")){
//                break;
//            }
//        }
//        for (int n=0;n<22;n++){
//            System.out.print("=");
//        }
//        System.out.println();
//        System.out.printf("%-4s %-10s %-8s\n","No","Nome","Média");
//        for (int n=0;n<22;n++){
//            System.out.print("=");
//        }
//        System.out.println();
//        for (int i=0;i<lista.size();i++){
//            Aluno aluno = lista.get(i);
//            System.out.printf("%-4d %-10s %-8.2f\n", i, aluno.getNome(), aluno.getMedia());
//        }
//        for (int n=0;n<22;n++){
//            System.out.print("=");
//        }
//        System.out.println();
//        while (true){
//            System.out.print("Quer ver nota de qual aluno?(Digite 999 para parar.):");
//            int opc = scanner.nextInt();
//            if (opc==999){
//                break;
//            }else {
//                if (opc<lista.size()){
//                    Aluno aluno = lista.get(opc);
//                    System.out.printf("As notas de %s foram: %.2f e %.2f%n",aluno.getNome(),aluno.getNota1(),aluno.getNota2());
//                }
//            }
//        }
//    }
//    static class Aluno{
//        private String nome;
//        private float nota1;
//        private float nota2;
//        private float media;
//
//        public Aluno(String nome, float nota1,float nota2, float media){
//            this.nome = nome;
//            this.nota1 = nota1;
//            this.nota2 = nota2;
//            this.media = media;
//        }
//        public String getNome() {
//            return nome;
//        }
//        public float getNota1(){
//            return nota1;
//        }
//        public float getNota2() {
//            return nota2;
//        }
//        public float getMedia() {
//            return media;
//        }
//    }


    public static void verificcandoNumerosParesImpares(Scanner scanner){
        ArrayList<Integer> lista = obtendoNumeros(scanner);
        ArrayList<Integer> listaPares = filtrandoPares(lista);
        ArrayList<Integer> listaImpares = filtrandoImpares(lista);
        System.out.println("A Lista:"+lista);
        System.out.println("lista de pares:"+listaPares);
        System.out.println("Lista de impares:"+listaImpares);
    }
    public static ArrayList<Integer> obtendoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite o um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (numeros<=-1){
                    System.out.println("Digite um número positivo.");
                }else {
                    if (lista.contains(numeros)){
                        System.out.println("ERRO.Número já adicionado, tente outro.");
                    }else {
                        lista.add(numeros);
                    }
                    String adicionarNumeros;
                    do {
                        System.out.print("Quer adicionar mais números?(sim/não):");
                        adicionarNumeros = scanner.nextLine().trim().toLowerCase();
                    }while (!adicionarNumeros.equals("não") && !adicionarNumeros.equals("sim"));
                    if (adicionarNumeros.equals("não")){
                        break;
                    }
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número real.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtrandoPares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2==0){
                listaPares.add(numero);
            }
        }
        return listaPares;
    }
    public static ArrayList<Integer> filtrandoImpares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }
    public static void jogosMegaSena(Scanner scanner,Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            try {
                System.out.print("Quantos jogos?:");
                quant = Integer.parseInt(scanner.nextLine());
                if (quant<=0){
                    System.out.println("Digite um número maior que 1.");
                }else{
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

    public static void verificandoMaiorMenorDeIdade(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        List<Object> dados;
        int maiorIdade=0, menorIdade=0;
        for (int n=0;n<3;n++){
            dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            System.out.print("Idade:");
            dados.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(dados);
        }
        System.out.println(lista);
        for (List<Object>pessoas : lista){
            String nome = (String)pessoas.get(0);
            int idade = (int) pessoas.get(1);
            if (idade>=18){
                System.out.println(nome+", é maior de idade.");
                maiorIdade++;
            }else {
                System.out.println(nome+", é menor de idade.");
                menorIdade++;
            }
        }
        System.out.println("Total de maiores de idade:"+maiorIdade+" | Total de menor de idade:"+menorIdade);
    }

//    public static void verificandoMediaAlunos(Scanner scanner){
//        ArrayList<Aluno> lista = new ArrayList<>();
//        while (true){
//            System.out.print("Digite o nome:");
//            String nome = scanner.nextLine().trim();
//            nome = nome.substring(0,1).toUpperCase()+nome.substring(1).toLowerCase();
//            float nota1 = 0;
//            while (true){
//                try {
//                    System.out.print("Digite a primeira nota:");
//                    nota1 = Float.parseFloat(scanner.nextLine());
//                    if (nota1<=-1 || nota1>=11){
//                        System.out.println("ERRO.Digite uma nota entre 0 e 10");
//                    }else {
//                        break;
//                    }
//                }catch (NumberFormatException erro){
//                    System.out.println("ERRO.Digite um valor válido.");
//                }
//            }
//            float nota2 =0;
//            while (true){
//                try {
//                    System.out.print("Digite a segunda nota:");
//                    nota2 = Float.parseFloat(scanner.nextLine());
//                    if (nota2<=-1 || nota2>=11){
//                        System.out.println("ERRO.Digite uma nota entre 00 e 10.");
//                    }else {
//                        break;
//                    }
//                }catch (NumberFormatException erro){
//                    System.out.println("ERRO.Digite um valor válido.");
//                }
//            }
//            float media = (nota1+nota2)/2;
//            lista.add(new Aluno(nome, nota1,nota2,media));
//            String calcularOutraMedia;
//            System.out.print("Quer calcular outra média?(sim/não):");
//            calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
//            while (!calcularOutraMedia.equals("não") && !calcularOutraMedia.equals("sim")){
//                System.out.print("Digite apenas sim ou não:");
//                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
//            }
//            if (calcularOutraMedia.equals("não")){
//                break;
//            }
//        }
//        for (int n=0;n<23;n++){
//            System.out.print("=");
//        }
//        System.out.println();
//        System.out.printf("%-4s %-10s %-8s%n", "No","Nome","Média");
//        for (int n=0;n<23;n++){
//            System.out.print("=");
//        }
//        System.out.println();
//        for (int i=0;i<lista.size();i++){
//            Aluno aluno = lista.get(i);
//            System.out.printf("%-4d %-10s %-8.2f\n",i,aluno.getNome(),aluno.getMedia());
//        }
//        for (int n=0;n<23;n++){
//            System.out.print("=");
//        }
//        System.out.println();
//        while (true){
//            System.out.print("Quer ver a nota de qual aluno?(digite 999 para parar):");
//            int opc = scanner.nextInt();
//            if (opc==999){
//                System.out.println(">>>>>>Finalizando o programa...");
//                break;
//            }else {
//                if (opc<lista.size()){
//                    Aluno aluno = lista.get(opc);
//                    System.out.printf("As notas de %s foram: %.2f e %.2f%n",aluno.getNome(), aluno.getNota1(),aluno.getNota2());
//                }
//            }
//        }
//    }
//    static class Aluno{
//        private String nome;
//        private float nota1;
//        private float nota2;
//        private float media;
//
//        public Aluno(String nome, float nota1, float nota2, float media){
//            this.nome = nome;
//            this.nota1 = nota1;
//            this.nota2 = nota2;
//            this.media = media;
//        }
//        public String getNome() {
//            return nome;
//        }
//        public float getNota1(){
//            return nota1;
//        }
//        public float getNota2() {
//            return nota2;
//        }
//        public float getMedia() {
//            return media;
//        }
//    }


}
