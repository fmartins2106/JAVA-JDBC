package academy.devdojo.maratonajava.introducao;


import java.util.*;

public class Aula7ListasExercicios2 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //        jogo da advinhação
        jogoAdvinhacao(scanner,random);

//        calculando média
        calculandoMediaNotas(scanner);



//        jogo pedra, papel e tesoura
        jogoPedraPapelTesoura(scanner, random);

//        lista com pares e impares
        listComParesImpares(scanner);

//        jogos loteria
        jogosLoteriaMegaSena(scanner, random);

//        lista,maior e menor de idade
        listaMaiorMenorDeIdade(scanner);

        //lista reversa
        listaReversa2(scanner);

//        ARRAY NUMEROS
        arrayNumeros(scanner);

//        analisando a expressão
        analisandoAExpressao(scanner);

//        analisando lista
        analisandoPosicaoLista(scanner);

//        verificando pares e impares da lista
        verificandoParesEImparesLista(scanner);

//        jogo da mega sena
            jogoMegaSena2(scanner,random);

//        avaliando nome, idade
        avaliandoNomeIdade(scanner);

//        verificando idade novamente
        verificandoIdade3(scanner);

//        lista reversa
        listaReversa(scanner);

//        jogo mega sena
        jogoMegaSena(scanner,random);

//        verificando idade
        verificandoIdade2(scanner);

//        separando numeros pares e impares
        separandoNumerosParesEImpares3(scanner);

//        sorteio lotofacil
                sorteioLotofacil(scanner,random);

//        verificando idade
        verificandoIdade(scanner);

//        jogos
        jogosLotofacil(scanner, random);

//        separando numeros pares e impares
        separandoNumerosParesEImpares2(scanner);


//        jogo sorteio megasena
        sorteioMegaSena(scanner,random);

//        separando numeros pares e impares
        separandoParesImpares(scanner);
        scanner.close();
    }

    public static void calculandoMediaNotas(Scanner scanner){
        float soma = 0;
        int contNumeros = 0;
        while (true){
            while (true){
                try {
                    System.out.print("Digite uma nota?:");
                    float notas = Float.parseFloat(scanner.nextLine());
                    if (notas<=0 || notas>=11){
                        System.out.println("ERRO.Digite um valor entre 1 e 10.");
                    }else {
                        soma+=notas;
                        contNumeros++;
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            String adicionarOutraNota;
            do {
                System.out.print("Quer adicionar outra nota(sim/não):");
                adicionarOutraNota = scanner.nextLine().trim().toLowerCase();
            }while (!adicionarOutraNota.equals("sim") && !adicionarOutraNota.equals("não"));
            if (adicionarOutraNota.equals("não")){
                float media = soma/contNumeros;
                System.out.println("A média:"+String.format("%.2f",media));
                String calcularOutraMedia;
                do {
                    System.out.print("Quer calcular outra média?(sim//não):");
                    calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
                }while (!calcularOutraMedia.equals("não") && !calcularOutraMedia.equals("sim"));
                if (calcularOutraMedia.equals("não")){
                    System.out.println(">>>>Finalizando o programa....");
                    break;
                }else {
                    contNumeros=0;
                    soma=0;
                }
            }
        }
    }

    public static void jogoAdvinhacao(Scanner scanner,Random random) throws InterruptedException{
        int jogador = 0;
        int contTentativas=0;
        int computador = random.nextInt(10)+1;
        while (true){
            while (true){
                try {
                    System.out.print("Digite um número:");
                    jogador = Integer.parseInt(scanner.nextLine());
                    if (jogador<=0 || jogador>=11){
                        System.out.println("Digite um número de 1 a 10.");
                    }else {
                        contTentativas++;
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real.");
                }
            }
            System.out.println("Processando....");
            Thread.sleep(500);
            if (jogador!=computador){
                if (jogador<computador){
                    System.out.println("Digite um número maior.");
                }else {
                    System.out.println("Digite um número menor.");
                }
            }else {
                System.out.println("Computador:"+computador);
                System.out.println("VOCÊ ACERTOU!!!");
                System.out.println("Você precisou de:"+contTentativas+" tentativa(s) para acertar.");
                String jogarNovamente;
                do {
                    System.out.print("Quer jogar novamente?(sim//não):");
                    jogarNovamente = scanner.nextLine().trim().toLowerCase();
                }while (!jogarNovamente.equals("sim") && !jogarNovamente.equals("não"));
                if (jogarNovamente.equals("não")){
                    System.out.println("Finalizando jogo...");
                    break;
                }else {
                    computador = random.nextInt(10)+1;
                    contTentativas=0;
                }
            }
        }
    }


    public static void jogoPedraPapelTesoura(Scanner scanner, Random random) throws InterruptedException{
        while (true){
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            int jogador = 0;
            while (true){
                try {
                    System.out.print("Digite uma das opções acima:");
                    jogador = Integer.parseInt(scanner.nextLine());
                    if (jogador<=0 || jogador>=4){
                        System.out.println("ERRO. Digite um número real.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("ERRO, digite um número real.");
                }
            }
            System.out.println("PROCESSANDO....");
            int computador = random.nextInt(3)+1;
            System.out.println("Computador:"+computador);
            if (jogador==computador){
                System.out.println("JOGADOR:"+parOuImpar(jogador)+" | COMPUTADOR:"+parOuImpar(computador)+" | RESULTADO: EMPATE!!!");
            }else if (jogador==1 && computador==3 || jogador==2 && computador==1 || jogador==3 && computador==2){
                System.out.println("JOGADOR:"+parOuImpar(jogador)+" | COMPUTADOR:"+parOuImpar(computador)+" | RESULTADO: VOCÊ VENCEU!!!");
            }else {
                System.out.println("JOGADOR:"+parOuImpar(jogador)+" | COMPUTADOR:"+parOuImpar(computador)+" | RESULTADO: VOCÊ PERDEU!!!");
            }
            String jogarNovamente;
            do {
                System.out.print("Quer jogar novamente?(sim/não):");
                jogarNovamente = scanner.nextLine().trim().toLowerCase();
            }while (!jogarNovamente.equals("sim") && !jogarNovamente.equals("não"));
            if (jogarNovamente.equals("não")){
                System.out.println(">>>Finalizando jogo...");
                break;
            }

        }
    }
    public static String parOuImpar(int escolha){
        switch (escolha){
            case 1: return "PEDRA";
            case 2: return "PAPEL";
            case 3: return "TESOURA";
        }
        return "";
    }

    public static void listComParesImpares(Scanner scanner){
        ArrayList<Integer> listaNumeros = obtendoNumeros(scanner);
        ArrayList<Integer> listaDePares = filtroPar(listaNumeros);
        ArrayList<Integer> listaDeImpares = fitroImpar(listaNumeros);
        System.out.println("Lista:"+listaNumeros);
        System.out.println("lista De Pares:"+listaDePares);
        System.out.println("Lista De Impares:"+listaDeImpares);
    }
    public static ArrayList<Integer> obtendoNumeros(Scanner scanner){
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (listaNumeros.contains(numeros)){
                    System.out.println("Número já consta na lista, tente outro.");
                }else {
                    listaNumeros.add(numeros);
                }
                String adicionarOutroNumero;
                System.out.print("Quer adicionar outro número?(sim/não):");
                adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                while (!adicionarOutroNumero.equals("não") && !adicionarOutroNumero.equals("sim")){
                    System.out.print("Digite apenas sim ou não:");
                    adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                }
                if (adicionarOutroNumero.equals("não")){
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite um número real.");
            }
        }
        return listaNumeros;
    }
    public static ArrayList<Integer> filtroPar(ArrayList<Integer>numeros){
        ArrayList<Integer> listaDePares = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2==0){
                listaDePares.add(numero);
            }
        }
        return listaDePares;
    }
    public static ArrayList<Integer> fitroImpar(ArrayList<Integer> numeros){
        ArrayList<Integer> listaDeImpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaDeImpares.add(numero);
            }
        }
        return listaDeImpares;
    }


    public static void jogosLoteriaMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            System.out.print("Quantos jogos desejas?:");
            if (scanner.hasNextInt()){
                quant = scanner.nextInt();
                break;
            }else {
                System.out.println("ERRO. Digite um número válido.");
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
            System.out.println("jogo"+(i+1)+":"+jogos.get(i));
        }

    }


    public static void listaMaiorMenorDeIdade(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        List<Object> dados;
        int totalMaior = 0, totalMenor=0;
        for (int c=0;c<3;c++){
            dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            System.out.print("Idade:");
            dados.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(new ArrayList<>(dados));
        }
        System.out.println(lista);
        for (List<Object> pessoa: lista){
            String nome = (String)pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>=21){
                System.out.println(nome+", é maior de idade.");
                totalMaior++;
            }else {
                System.out.println(nome+", é menor de idade.");
                totalMenor++;
            }
        }
        System.out.println("Total maior de idade:"+totalMaior+" | Total menor de idade:"+totalMenor);
    }


    public static void listaReversa2(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (lista.contains(numeros)){
                    System.out.println("ERRO. Número repetido, tente outro.");
                    continue;
                }else {
                    lista.add(numeros);
                }
                String adicionarOutroNumero;
                do {
                    System.out.print("Quer adicionar outro número?:");
                    adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarOutroNumero.equals("sim") && !adicionarOutroNumero.equals("não"));
                if (adicionarOutroNumero.equals("não")){
                    Collections.sort(lista,Collections.reverseOrder());
                    System.out.println("A lista descrecente:"+lista);
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO.Digite um número real.");
            }
        }
    }


    public static void arrayNumeros(Scanner scanner){
        int[] arrayNumeros = new int[6];
        int numeroMaior = Integer.MIN_VALUE,numeroMenor = Integer.MAX_VALUE;
        int posMaior = 0, posMenor=0;
        for (int i=0;i<arrayNumeros.length;i++){
            while (true){
                try {
                    System.out.print("Digite o "+(i+1)+"º número da lista:");
                    arrayNumeros[i] = Integer.parseInt(scanner.nextLine());
                    boolean numeroRepetido = false;
                    for (int n=0;n<i;n++){
                        if (arrayNumeros[i]==arrayNumeros[n]){
                            numeroRepetido = true;
                            break;
                        }
                    }
                    if (numeroRepetido){
                        System.out.println("ERRO. Número repetido, tente outro número.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("ERRO. Digite um número real.");
                }
            }
            if (arrayNumeros[i]>numeroMaior){
                numeroMaior=arrayNumeros[i];
                posMaior=i;
            }
            if (arrayNumeros[i]<numeroMenor){
                numeroMenor=arrayNumeros[i];
                posMenor=i;
            }
        }
        System.out.println("O maior da lista:"+numeroMaior+" | Está na posição:"+posMaior);
        System.out.println("O menor da lista:"+numeroMenor+" | Está na posição:"+posMenor);
    }

    public static void analisandoAExpressao(Scanner scanner) {
        Stack<Character> pilhaParenteses = new Stack<>();
        System.out.print("Digite uma expressão:");
        String expressao = scanner.nextLine().trim();
        for (char parenteses : expressao.toCharArray()) {
            if (parenteses == '(') {
                pilhaParenteses.push(parenteses);
            } else {
                if (parenteses == ')') {
                    if (!pilhaParenteses.isEmpty()) {
                        pilhaParenteses.pop();
                    } else {
                        System.out.println("Sua expressão está incorreta.");
                    }
                }
            }
        }
        if (pilhaParenteses.isEmpty()) {
            System.out.println("Sua expressão está correta.");
        } else {
            System.out.println("Sua expressão está incorreta.");
        }
    }

    public static void analisandoPosicaoLista(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i=0;i<6;i++){
            while (true){
                try {
                    System.out.print("Digite o "+(i+1)+"º número:");
                    int numero = Integer.parseInt(scanner.nextLine());
                    if (lista.contains(numero)){
                        System.out.println("Número já cadastrado, tente outro!");
                        continue;
                    }else {
                        if (lista.isEmpty() || numero >= lista.get(lista.size()-1)){
                            lista.add(numero);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos=0;
                            while (pos<lista.size()){
                                if (numero<= lista.get(pos)){
                                    lista.add(pos, numero);
                                    System.out.println("Adicionado na posição:"+pos);
                                    break;
                                }
                                pos++;
                            }
                        }
                    }
                    break;
                }catch (NumberFormatException erro){
                    System.out.println("ERRO. Digit eum número verdadeiro.");
                }
            }
        }
        System.out.println("A lista:"+lista);
    }

    public static void verificandoParesEImparesLista(Scanner scanner){
        ArrayList<Integer> lista = addNumer(scanner);
        ArrayList<Integer> Pares = lPares(lista);
        ArrayList<Integer>Impares = lImpares(lista);
        System.out.println("A lista:"+lista);
        System.out.println("Pares:"+Pares);
        System.out.println("Impares:"+Impares);
    }
    public static ArrayList<Integer> addNumer(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (lista.contains(numeros)){
                    System.out.println("ERRO.Número repetido, tente outro.");
                    continue;
                }else {
                    lista.add(numeros);
                }
                String adicionarNumero;
                do {
                    System.out.print("Quer adicionar outro número?:");
                    adicionarNumero = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarNumero.equals("não") && !adicionarNumero.equals("sim"));
                if (adicionarNumero.equals("não")){
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Erro.Digite um número real.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer> lPares(ArrayList<Integer> numeros){
        ArrayList<Integer> lPares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2==0){
                lPares.add(numero);
            }
        }
        return lPares;
    }
    public static ArrayList<Integer> lImpares(ArrayList<Integer> numeros){
        ArrayList<Integer> Impares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                Impares.add(numero);
            }
        }
        return Impares;
    }


    public static void jogoMegaSena2(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            try {
                System.out.print("Quantos jogos?:");
                quant = Integer.parseInt(scanner.nextLine());
                if (quant<=0){
                    System.out.println("ERRO, digite um número válido.");
                }else {
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO, Digite um valor válido.");
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
        for (int c=0;c<jogos.size();c++){
            System.out.println("jogo:"+(c+1)+":"+jogos.get(c));
        }
    }


    public static void avaliandoNomeIdade(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        List<Object>dados;
        int contMaior=0, contMenor=0;
        for (int c=0;c<3;c++){
            dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            System.out.print("Idade:");
            dados.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(new ArrayList<>(dados));
        }
        System.out.println(lista);
        for (List<Object>pessoa: lista){
            String nome = (String)pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>=18){
                System.out.println(nome+", é maior de idade. ");
                contMaior++;
            }else {
                System.out.println(nome+", é menor de idade.");
                contMenor++;
            }
        }
        System.out.println("Total de maiores de idade:"+contMaior+" | Total de menores de idade:"+contMenor);
    }




    public static void verificandoIdade3(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        List<Object>dados;
        int totalMaior=0, totalMenor=0;
        for (int c=0;c<3;c++){
            dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            System.out.print("Idade:");
            dados.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(new ArrayList<>(dados));
        }
        System.out.println(lista);
        for (List<Object>pessoa: lista){
            String nome = (String)pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>=21){
                System.out.println(nome+", é maior de idade.");
                totalMaior++;
            }else {
                System.out.println(nome+", é menor de idade.");
                totalMenor++;
            }
        }
        System.out.println("Total maior de idade:"+totalMaior+" | Total menor de idade:"+totalMenor);
    }


    public static void listaReversa(Scanner scanner){
        ArrayList<Float> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                float numeros = Float.parseFloat(scanner.nextLine());
                if (lista.contains(numeros)){
                    System.out.println("ERRO.Número repetido, tente outro.");
                    continue;
                }else {
                    lista.add(numeros);
                }
                String adicionarNumeros;
                do {
                    System.out.print("Quer adicionar outro número?:");
                    adicionarNumeros = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarNumeros.equals("não") && !adicionarNumeros.equals("sim"));
                if (adicionarNumeros.equals("não")){
                    Collections.sort(lista,Collections.reverseOrder());
                    System.out.println("Sua lista na decrescente:"+lista);
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("Erro,digite um número real.");
            }
        }
    }

    public static void jogoMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            try {
                System.out.print("Quantos jogos?:");
                quant = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException erro){
                System.out.println("Erro, digite um número real.");
            }
        }
        for (int total=0;total<quant;total++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<6){
                int jogo = random.nextInt(60)+1;
                lista.add(jogo);
            }
            ArrayList<Integer> jogolist = new ArrayList<>(lista);
            Collections.sort(jogolist);
            jogos.add(jogolist);
        }
        for (int i=0;i<jogos.size();i++){
            System.out.println("jogo"+(i+1)+":"+jogos.get(i));
        }
    }

    public static void verificandoIdade2(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        List<Object>dados;
        int totalMaior = 0, totalMenor=0;
        for (int n=0;n<3;n++){
            dados = new ArrayList<>();
            System.out.print("Nome:");
            dados.add(scanner.nextLine());
            System.out.print("Idade:");
            dados.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(new ArrayList<>(dados));
        }
        System.out.println(lista);
        for (List<Object> pessoa: lista){
            String nome = (String)pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>=21){
                System.out.println(nome+", é maior de idade.");
                totalMaior++;
            }else {
                System.out.println(nome+",é menor de idade.");
                totalMenor++;
            }
        }
        System.out.println("Total de maiores de idade:"+totalMaior+" | Total de menores de idade:"+totalMenor);
    }

    public static void separandoNumerosParesEImpares3(Scanner scanner){
        ArrayList<Integer> lista = addNumeros(scanner);
        ArrayList<Integer> listaPares = filtroDePar(lista);
        ArrayList<Integer> listaImpares = filtroDeImpar(lista);
        System.out.println("Lista:"+lista);
        System.out.println("lista números pares:"+listaPares);
        System.out.println("Lista números impares:"+listaImpares);
    }
    public static ArrayList<Integer> addNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (lista.contains(numeros)){
                    System.out.println("ERRO, número repetido, tente outro.");
                    continue;
                }else{
                    lista.add(numeros);
                }
                String adicionarMaisNumeros;
                do {
                    System.out.print("Quer adicionar um número?:");
                    adicionarMaisNumeros = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarMaisNumeros.equals("não") && !adicionarMaisNumeros.equals("sim"));
                if (adicionarMaisNumeros.equals("não")){
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO. Digite um número válido.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtroDePar(ArrayList<Integer>numeros){
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2==0){
                listaPares.add(numero);
            }
        }
        return listaPares;
    }
    public static ArrayList<Integer> filtroDeImpar(ArrayList<Integer>numeros){
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }

    public static void sorteioLotofacil(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant = 0;
        while (true){
            try {
                System.out.print("Quantos jogos?:");
                quant = Integer.parseInt(scanner.nextLine());
                break;
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
        for (int c=0;c<jogos.size();c++){
            System.out.println("jogo"+(c+1)+":"+jogos.get(c));
        }
    }

    public static void verificandoIdade(Scanner scanner){
        List<List<Object>> lista = new ArrayList<>();
        List<Object>dado;
        int contMaior=0, contMenor=0;
        for (int c=0;c<3;c++){
            dado= new ArrayList<>();
            System.out.print("Nome:");
            dado.add(scanner.nextLine());
            System.out.print("Idade:");
            dado.add(scanner.nextInt());
            scanner.nextLine();
            lista.add(new ArrayList<>(dado));
        }
        System.out.println(lista);
        for (List<Object>pessoa:lista){
            String nome = (String)pessoa.get(0);
            int idade = (int)pessoa.get(1);
            if (idade>=21){
                System.out.println(nome+", é de maior de idade.");
                contMaior++;
            }else {
                System.out.println(nome+", é de menor de idade.");
                contMenor++;
            }
        }
        System.out.println("Total de maiores de idade:"+contMaior+" | Total de menores de idade:"+contMenor);
    }

    public static void jogosLotofacil(Scanner scanner,Random random){
        ArrayList<ArrayList<Integer>> jogos= new ArrayList<>();
        int quant =0;
        while (true){
            System.out.print("Quantos jogos?:");
            if (scanner.hasNextInt()){
                quant = scanner.nextInt();
                break;
            }else {
                System.out.println("ERRO, digite um número real.");
                scanner.next();
            }
        }
        scanner.nextLine();
        for (int n=0;n<quant;n++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<6){
                int jogo = random.nextInt(60)+1;
                lista.add(jogo);
            }
            ArrayList<Integer> jogolist = new ArrayList<>(lista);
            Collections.sort(jogolist);
            jogos.add(jogolist);
        }
        for (int i=0;i<jogos.size();i++){
            System.out.println("jogo:"+(i+1)+":"+jogos.get(i));
        }
    }



    public static void separandoNumerosParesEImpares2(Scanner scanner){
        ArrayList<Integer> lista = adicionandoNumeros(scanner);
        ArrayList<Integer> pares = filtroPares(lista);
        ArrayList<Integer> impares = filtroImpares(lista);
        System.out.println("lista:"+lista);
        System.out.println("Números pares:"+pares);
        System.out.println("Números impares:"+impares);
    }
    public static ArrayList<Integer> adicionandoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        int numeros=0;
        while (true){
            try {
                System.out.print("Digite um número:");
                numeros = Integer.parseInt(scanner.nextLine());
                if (lista.contains(numeros)){
                    System.out.println("ERRO. Número já inserido. Tente outro.");
                    continue;
                }else {
                    lista.add(numeros);
                }
                String adicionarOutroNumero;
                do {
                    System.out.print("Quer adicionar outro número?(sim/não):");
                    adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarOutroNumero.equals("sim") && !adicionarOutroNumero.equals("não"));
                if (adicionarOutroNumero.equals("não")){
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO, digite um número real.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtroPares(ArrayList<Integer>numeros){
        ArrayList<Integer> pares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2==0){
                pares.add(numero);
            }
        }
        return pares;
    }
    public static ArrayList<Integer> filtroImpares(ArrayList<Integer> numeros){
        ArrayList<Integer> impares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                impares.add(numero);
            }
        }
        return impares;
    }


    public static void sorteioMegaSena(Scanner scanner,Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant=0;
        while (true){
            try {
                System.out.print("Quantos jogos você quer?:");
                quant = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException erro){
                System.out.println("ERRO, digite um número válido.");
            }
        }
        for (int total=0;total<quant;total++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<6){
                int sorteio = random.nextInt(60)+1;
                lista.add(sorteio);
            }
            ArrayList<Integer> jogolist = new ArrayList<>(lista);
            Collections.sort(jogolist);
            jogos.add(jogolist);

        }
        for (int n=0;n<jogos.size();n++){
            System.out.println("jogo"+(n+1)+":"+jogos.get(n));
        }

    }



    public static void separandoParesImpares(Scanner scanner){
        ArrayList<Integer> lista = obterNumeros(scanner);
        ArrayList<Integer> listaPares = filtrarPares(lista);
        ArrayList<Integer> listaImpares = filtrarImpares(lista);
        System.out.println("A lista:"+lista);
        System.out.println("A lista de números pares:"+listaPares);
        System.out.println("A lista de números impares:"+listaImpares);

    }
    public static ArrayList<Integer>obterNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (lista.contains(numeros)){
                    System.out.println("ERRO, número repetido, tente outro.");
                    continue;
                }else {
                    lista.add(numeros);
                }
                String AdicionarNumero;
                do {
                    System.out.print("Quer adicionar outro número?:");
                    AdicionarNumero = scanner.nextLine().trim().toLowerCase();
                }while (!AdicionarNumero.equals("sim") && !AdicionarNumero.equals("não"));
                if (AdicionarNumero.equals("não")){
                    break;
                }

            }catch (NumberFormatException erro){
                System.out.println("ERRO, digite um número real.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer> filtrarPares(ArrayList<Integer>numeros){
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2==0){
                listaPares.add(numero);
            }
        }
        return listaPares;
    }
    public static ArrayList<Integer> filtrarImpares(ArrayList<Integer>numeros){
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }


}
