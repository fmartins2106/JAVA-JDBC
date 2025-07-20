package academy.devdojo.maratonajava.introducao;





import java.util.*;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Aula7ListasExercicios1 {
    public static void main(String[] args) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        // verificando lista, maior e menor.
        listaComIdades(scanner);

//        sorteiomegaSena
        sorteandoMegaSena(scanner,random);



//        sorteio lotofacil
        sorteioLotofacil(scanner,random);

//        sorteio mega sena
        sorteioMegaSena(scanner,random);

//        verificar lista com pares e impares
        verificandoListaParesImpares(scanner);

//        array numeros
        arrayNumeros(scanner);

        //        jogos loteria federal
        jogoQuina(scanner,random);

//        lista com posição
        listaDeclarandoPosicao(scanner);

//        jogo par ou impar
        jogoParOuImpar(scanner, random);

//        verificando expressão
        verificandoExpressao(scanner);

//        caixa eletronico
        caixaEletronico(scanner);

//        verificando lista
        verificandoListaNumeroCinco(scanner);

//        sorteio loteria federal
                sorteioloteriaFederal(scanner,random);

//        analisando lista
        verificandoListaComNumero5(scanner);

//        sorteio numeros lotofacil
        sorteioNumeroLotofacil(scanner, random);

//        lista separando por pares, impares
        listaSeparandoParesImpares(scanner);

//sorteio numeros mega semana
        sortearNumerosLoteria(scanner, random);

//        analisando lista
        analisandoListaComNumero5(scanner);

//        separando lista em pares e impares
        separandoParesEImpares(scanner);

//        analisando lista
        analisandoMedia(scanner);

//        analise lista, numero 5
        analistaListaComNumero5(scanner);

//        lista, separando por pares e impares
        listaNumerosParesImpares(scanner);

// lista, separando por pares e impares
        listaNumerosParesEImpares(scanner);


//listas, separando pares e impares2
        listaParOuImpar2(scanner);


//        listas, separando par e impar
        listaParOuImpar(scanner);
        scanner.close();
    }

    public static void sorteandoMegaSena(Scanner scanner,Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant=0;
        while (true){
            try {
                System.out.print("Digite um número:");
                quant = Integer.parseInt(scanner.nextLine());
                break;
            }catch (NumberFormatException erro){
                System.out.println("ERRO, Digite um número válido.");
            }
        }
        for (int total=0;total<quant;total++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<6){
                int jogo = random.nextInt(60)+1;
                lista.add(jogo);
            }
            ArrayList<Integer>jogoList = new ArrayList<>(lista);
            Collections.sort(jogoList);
            jogos.add(jogoList);
        }
        for (int i=0;i<jogos.size();i++){
            System.out.println("jogo"+(i+1)+":"+jogos.get(i));
        }

    }



    public static void listaComIdades(Scanner scanner){
        List<List<Object>> galera = new ArrayList<>();
        List<Object>dado;
        int totalMaior =0, totalMenor=0;
        for (int c=0;c<3;c++){
            dado = new ArrayList<>();
            System.out.print("Digite o seu nome:");
            dado.add(scanner.nextLine());
            System.out.println("Digite a sua idade:");
            dado.add(scanner.nextInt());
            scanner.nextLine();
            galera.add(new ArrayList<>(dado));
        }
        System.out.println(galera);
        for (List<Object>pessoa: galera){
            String nome = (String)pessoa.get(0);
            int idade = (int) pessoa.get(1);
            if (idade>=21){
                System.out.println(nome+" é maior de idade");
                totalMaior++;
            }else {
                System.out.println(nome+" é menor de idade.");
                totalMenor++;
            }
        }
        System.out.println("Temos "+totalMaior+" pessoas maiores de idade e "+totalMenor+" pessoas menores de idade.");
    }


    public static void sorteioLotofacil(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        int quant=0;
        while (true){
            System.out.print("Quantos jogos?:");
            if (scanner.hasNextInt()){
                quant = scanner.nextInt();
                break;
            }else {
                System.out.println("Digite um número válido.");
                scanner.next();
            }
        }
        for (int total=0;total<quant;total++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<15){
                int jogo = random.nextInt(25)+1;
                lista.add(jogo);
            }
            ArrayList<Integer> jogolist = new ArrayList<>(lista);
            Collections.sort(jogolist);
            jogos.add(jogolist);
        }
        for (int i=0;i<jogos.size();i++){
            System.out.println("Jogo:"+(i+1)+":"+jogos.get(i));
        }

    }




    public static void sorteioMegaSena(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        System.out.print("Quantos jogos?:");
        int quant = scanner.nextInt();
        for (int total=0;total<quant;total++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<6){
                int jogo = random.nextInt(61);
                lista.add(jogo);
            }
            ArrayList<Integer> jogolist = new ArrayList<>(lista);
            Collections.sort(jogolist);
            jogos.add(jogolist);
        }
        for (int i=0;i< jogos.size();i++){
            System.out.println("jogo:"+(i+1)+":"+jogos.get(i));
        }
    }


    public static void verificandoListaParesImpares(Scanner scanner){
        ArrayList<Integer> listaTotal = obtendoNumeros(scanner);
        ArrayList<Integer> listaDePares = filtroDosPares(listaTotal);
        ArrayList<Integer> listaDeImpares = filtroDosImpares(listaTotal);
        System.out.println("A lista:"+listaTotal);
        System.out.println("A lista de pares:"+listaDePares);
        System.out.println("A lista de impares:"+listaDeImpares);
    }
    public static ArrayList<Integer> obtendoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numeros = Integer.parseInt(scanner.nextLine());
                if (lista.contains(numeros)){
                    System.out.println("ERRO, número já cadastrado.");
                    continue;
                }else {
                    lista.add(numeros);
                }
                String adicionaOutroNumero;
                do {
                    System.out.print("Quer adicionar outro número?:");
                    adicionaOutroNumero = scanner.nextLine().trim().toLowerCase();
                }while (!adicionaOutroNumero.equals("sim") && !adicionaOutroNumero.equals("não"));
                if (adicionaOutroNumero.equals("não")){
                    break;
                }
            }catch (NumberFormatException erro){
                System.out.println("ERRO, digite um número real.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer>filtroDosPares(ArrayList<Integer>numeros){
        ArrayList<Integer> listaDePares = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2==0){
                listaDePares.add(numero);
            }
        }
        return listaDePares;
    }
    public static ArrayList<Integer>filtroDosImpares(ArrayList<Integer>numeros){
        ArrayList<Integer> listaDeImpares = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2!=0){
                listaDeImpares.add(numero);
            }
        }
        return listaDeImpares;
    }


    public static void arrayNumeros(Scanner scanner){
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE, posMaior =0, posMenor=0;
        int[] arrayNumeros = new int[6];
        for (int n=0;n<arrayNumeros.length;n++){
            while (true){
                try {
                    System.out.print("Digite o "+(n+1)+"º número:");
                    arrayNumeros[n] = Integer.parseInt(scanner.nextLine());
                    boolean nRepetido = false;
                    for (int i=0;i<n;i++){
                        if (arrayNumeros[n]==arrayNumeros[i]){
                            nRepetido = true;
                            break;
                        }
                    }
                    if (nRepetido){
                        System.out.println("ERRO, número já cadastrado, tente outro.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("ERRO, Digite um número válido.");
                }
            }
            if (arrayNumeros[n]>maiorNumero){
                maiorNumero=arrayNumeros[n];
                posMaior=n;
            }
            if (arrayNumeros[n]<menorNumero){
                menorNumero=arrayNumeros[n];
                posMenor=n;
            }
        }
        System.out.println("O maior número da lista:"+maiorNumero+", está na posição:"+posMaior);
        System.out.println("O menor número da lista:"+menorNumero+", está na posição:"+posMenor);
    }


    public static void jogoQuina(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        System.out.print("Quantos jogos?:");
        int quant = scanner.nextInt();
        for (int total=0;total<quant;total++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<6){
                int jogo = random.nextInt(81);
                lista.add(jogo);
            }
            ArrayList<Integer> jogoList = new ArrayList<>(lista);
            Collections.sort(jogoList);
            jogos.add(jogoList);

        }
        for (int i=0;i<jogos.size();i++){
            System.out.println("jogo:"+(i+1)+":"+jogos.get(i));
        }
    }


    public static void listaDeclarandoPosicao(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        for(int i=0;i<6;i++){
            while (true){
                System.out.print("Digite o "+(i+1)+"º número:");
                if (scanner.hasNextFloat()){
                    int numero = scanner.nextInt();
                    if (lista.contains(numero)){
                        System.out.println("ERRO, número repetido, tente outro.");
                        continue;
                    }else {
                        if (lista.isEmpty() || numero>= lista.get(lista.size()-1)){
                            lista.add(numero);
                            System.out.println("Adicionado no final da lista.");
                        }else {
                            int pos=0;
                            while (pos < lista.size()){
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
                }else {
                    System.out.println("Erro, digite um número real.");
                    scanner.next();
                }
            }
        }
        System.out.println("A lista:"+lista);
    }


    public static void jogoParOuImpar(Scanner scanner, Random random) throws InterruptedException{
        while (true){
            int jogador = 0;
            while (true){
                try {
                    System.out.print("Digite um número de 1 a 10:");
                    jogador = Integer.parseInt(scanner.nextLine());
                    if (jogador>=1 && jogador<=10){
                        break;
                    }else {
                        System.out.println("ERRO, digite um número de 1 a 10.");
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um número real de 1 a 10.");
                }
            }
            String escolhendoParOuImpar;
            do {
                System.out.print("Quer par ou impar?(Digite P para par e I para impar):");
                escolhendoParOuImpar = scanner.nextLine().trim().toLowerCase();
            }while (!escolhendoParOuImpar.equals("p") && !escolhendoParOuImpar.equals("i"));
            System.out.println("PROCESSANDO....");
            Thread.sleep(500);
            int computador=  random.nextInt(11);
            int resultado = jogador+computador;
            System.out.println("Computador:"+computador);
            if (escolhendoParOuImpar.equals("p") && resultado%2==0){
                System.out.println("VOCÊ Escolheu:"+JogoParImpar(escolhendoParOuImpar)+", jogou:"+jogador+", computador:"+computador+" RESULTADO:"+resultado+" VOCÊ VENCEU!!!");
            } else if (escolhendoParOuImpar.equals("p") && resultado%2!=0 ) {
                System.out.println("VOCÊ escolheu:"+JogoParImpar(escolhendoParOuImpar)+", jogou:"+jogador+", computador:"+computador+" RESULTADO:"+ resultado+" VOCÊ PERDEU!!!");
            } else if (escolhendoParOuImpar.equals("i") && resultado%2!=0) {
                System.out.println("VOCÊ escolheu:"+JogoParImpar(escolhendoParOuImpar)+", jogou:"+jogador+", computador:"+computador+" RESULTADO:"+resultado+" VOCÊ VENCEU!!!");
            } else if (escolhendoParOuImpar.equals("i") && resultado%2==0) {
                System.out.println("VOCÊ escolheu:"+JogoParImpar(escolhendoParOuImpar)+", jogou:"+jogador+", computador:"+computador+" RESULTADO:"+resultado+" VOCÊ PERDEU!!!");
            }
            String jogarNovamente;
            do {
                System.out.print("Quer jogar novamente?:");
                jogarNovamente = scanner.nextLine().trim().toLowerCase();
            }while (!jogarNovamente.equals("sim") && !jogarNovamente.equals("não"));
            if (jogarNovamente.equals("não")){
                System.out.println("finalizando o jogo...");
                break;
            }

        }
    }
    public static String JogoParImpar( String escolha){
        switch (escolha){
            case "p": return "PAR";
            case "i": return "IMPAR";
        }
        return "";
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
                        System.out.println("ERRO, Sua expressão está incorreta.");
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

    public static void caixaEletronico(Scanner scanner){
        System.out.print("Quanto quer sacar?:R$");
        int saque = scanner.nextInt();
        int valor = saque;
        int totalced = 0;
        int ced=50;
        while (true){
            if (valor>=ced){
                valor-=ced;
                totalced++;
            }else {
                if (totalced>0){
                    System.out.printf("Total de %d cédulas de %d%n",totalced, ced);
                }
                if (ced==50){
                    ced=20;
                } else if (ced==20) {
                    ced=10;
                }else if (ced==10){
                    ced=5;
                } else if (ced==5) {
                    ced=1;
                }
                totalced=0;
                if (valor<=0){
                    break;
                }
            }
        }
    }


    public static void verificandoListaNumeroCinco(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numero = Integer.parseInt(scanner.nextLine());
                if (lista.contains(numero)){
                    System.out.println("ERRO, número repetido, tente outro.");
                }else {
                    lista.add(numero);

                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número real.");
                continue;
            }
            String continuar;
            do {
                System.out.print("Quer adicionar outro número?:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }while (!continuar.equals("não") && !continuar.equals("sim"));
            if (continuar.equals("não")){
                System.out.println("Foram adicionados:"+lista.size()+" números.");
                Collections.sort(lista,Collections.reverseOrder());
                System.out.println("A lista em ordem decrescente:"+lista);
                System.out.println("O número cinco apareceu na posição:"+lista.indexOf(5));
                break;
            }

        }
    }

    public static void sorteioloteriaFederal(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        System.out.print("quantos jogos?:");
        int quant = scanner.nextInt();
        Set<Integer> lista = new HashSet<>();
        for (int total=0;total<quant;total++){
            while (lista.size()<5){
                int jogo = random.nextInt(100);
                lista.add(jogo);
            }
            ArrayList<Integer> jogoList = new ArrayList<>(lista);
            Collections.sort(jogoList);
            jogos.add(jogoList);
        }
        for (int i=0;i<jogos.size();i++){
            System.out.println("jogo"+(i+1)+":"+ jogos.get(i));
        }
    }

    public static void verificandoListaComNumero5(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            int numero=0;
            while (true){
                try {
                    System.out.print("Digite um número:");
                    numero = Integer.parseInt(scanner.nextLine());
                    if (lista.contains(numero)){
                        System.out.println("ERRO!Número já digitado, tente outro.");
                    }else {
                        lista.add(numero);
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Erro, digite um número real.");
                }
            }
            String adiconarOutroNumero;
            do {
                System.out.println("Quer adicioanar outro número?:");
                adiconarOutroNumero = scanner.nextLine().trim().toLowerCase();
            }while (!adiconarOutroNumero.equals("não") && !adiconarOutroNumero.equals("sim"));
            if (adiconarOutroNumero.equals("não")){
                System.out.println("Foram registrados:"+lista.size()+" números.");
                Collections.sort(lista, Collections.reverseOrder());
                System.out.println("A lista em ordem decrescente:"+lista);
                if (lista.contains(5)){
                    System.out.println("O número cinco apareceu na posição:"+lista.indexOf(5));
                }else {
                    System.out.println("O número cinco não apareceu na lista.");
                }

                break;
            }
        }
    }


    public static void sorteioNumeroLotofacil(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();
        System.out.print("Quantos jogos?:");
        int quant = scanner.nextInt();
        for (int total=0;total<quant;total++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<15){
                int jogo = random.nextInt(26);
                lista.add(jogo);
            }
            ArrayList<Integer> jogolist = new ArrayList<>(lista);
            Collections.sort(jogolist);
            jogos.add(jogolist);
        }
        for (int i=0;i<jogos.size();i++){
            System.out.println("Jogo:"+(i+1)+":"+jogos.get(i));
        }
    }


    public static void listaSeparandoParesImpares(Scanner scanner){
        ArrayList<Integer> lista = AdicaoNumero(scanner);
        ArrayList<Integer> listaNpares = filtroDePares(lista);
        ArrayList<Integer> listaNimpares = filtroDeImpares(lista);
        System.out.println("A lista:"+lista);
        System.out.println("A lista de pares:"+listaNpares);
        System.out.println("A lista de impares:"+listaNimpares);
    }
    public static ArrayList<Integer> AdicaoNumero(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numero = Integer.parseInt(scanner.nextLine());
                if (lista.contains(numero)){
                    System.out.println("Erro,número já adicionado, tente outro.");
                }else {
                    lista.add(numero);
                }
                String adicionarOutroNumero;
                do {
                    System.out.print("Quer adicionar outro número?:");
                    adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarOutroNumero.equals("não") && !adicionarOutroNumero.equals("sim"));
                if (adicionarOutroNumero.equals("não")){
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("Erro, digite um número válido.");
            }
        }
        return lista;
    }

    public static ArrayList<Integer> filtroDePares(ArrayList<Integer> numeros){
        ArrayList<Integer> listaNpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2==0){
                listaNpares.add(numero);
            }
        }
        return listaNpares;
    }

    public static ArrayList<Integer> filtroDeImpares(ArrayList<Integer>numeros){
        ArrayList<Integer> listaNimpares = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaNimpares.add(numero);
            }
        }
        return listaNimpares;
    }

    public static void sortearNumerosLoteria(Scanner scanner, Random random){
        ArrayList<ArrayList<Integer>> jogos = new ArrayList<>();;
        System.out.print("Quanto jogos você quer?:");
        int quant = scanner.nextInt();
        for (int total=1;total<=quant;total++){
            Set<Integer> lista = new HashSet<>();
            while (lista.size()<6){
                int jogo = random.nextInt(60)+1;
                lista.add(jogo);
            }
            ArrayList<Integer> jogolist = new ArrayList<>(lista);
            Collections.sort(jogolist);
            jogos.add(jogolist);
        }
        for (int i=0;i< jogos.size();i++){
            System.out.println("Jogo"+(i+1)+":"+jogos.get(i));
        }
    }

    public static void analisandoListaComNumero5(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            int numeros = 0;
            while (true){
                try {
                    System.out.print("Digite um número:");
                    numeros = Integer.parseInt(scanner.nextLine());
                    if (lista.contains(numeros)){
                        System.out.print("Número já adicionado, tente outro.");
                    }else {
                        lista.add(numeros);
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.print("ERRO!Digite um número válido.");
                }
            }
            String continuar;
            do {
                System.out.print("Quer adicionar outro número?(sim/não):");
                continuar = scanner.nextLine().trim().toLowerCase();
            }while (!continuar.equals("sim") && !continuar.equals("não"));
            if (continuar.equals("não")){
                System.out.println("Você digitou:"+lista.size()+" números.");
                Collections.sort(lista, Collections.reverseOrder());
                System.out.println("A lista em ordem decrescente:"+lista);
                if(lista.contains(5)){
                    System.out.println("O número cinco apareceu na posição:"+lista.indexOf(5));
                }else {
                    System.out.println("O cinco não apareceu na lista.");
                }
                break;
            }
        }
    }

    public static void separandoParesEImpares(Scanner scanner){
        ArrayList<Integer> lista = adicionarNumero(scanner);
        ArrayList<Integer> listaPares = filtroDePar(lista);
        ArrayList<Integer> listaImpares = filtroDeImpar(lista);
        System.out.println("A lista:"+lista);
        System.out.println("Os números pares:"+listaPares);
        System.out.println("Os números impares:"+listaImpares);
    }
    public static ArrayList<Integer> adicionarNumero(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                int numero = Integer.parseInt(scanner.nextLine());
                if (lista.contains(numero)){
                    System.out.print("Número já adicionado, tente outro.");
                }else {
                    lista.add(numero);
                }
                String adicionarOutroNumero;
                do {
                    System.out.print("Quer adicionar outro número?(sim/não):");
                    adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                }while (!adicionarOutroNumero.equals("não") && !adicionarOutroNumero.equals("sim"));
                if (adicionarOutroNumero.equals("não")){
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO, Digite um número válido.");
            }
        }
        return lista;
    }
    public static ArrayList<Integer>filtroDePar(ArrayList<Integer> numeros){
        ArrayList<Integer> listaPares = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2==0){
                listaPares.add(numero);
            }
        }
        return listaPares;
    }

    public static ArrayList<Integer> filtroDeImpar(ArrayList<Integer> numeros){
        ArrayList<Integer> listaImpares = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2!=0){
                listaImpares.add(numero);
            }
        }
        return listaImpares;
    }

    public static void analisandoMedia(Scanner scanner) {
        ArrayList<Aluno> lista = new ArrayList<>();
        while (true) {
            System.out.print("Digite uma seu nome:");
            String nome = scanner.nextLine().trim();
            nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();

            float nota1 = 0;
            while (true) {
                System.out.print("Digite a primeira nota:");
                if (scanner.hasNextFloat()) {
                    nota1 = scanner.nextFloat();
                    break;
                } else {
                    System.out.println("Digite um valor válido para nota 1.");
                    scanner.next();
                }
            }

            float nota2 = 0;
            while (true) {
                System.out.print("Digite a segunda nota:");
                if (scanner.hasNextFloat()) {
                    nota2 = scanner.nextFloat();
                    break;
                } else {
                    System.out.println("Digite um valor válido para a nota 2.");
                    scanner.next();
                }
            }

            float media = (nota1 + nota2) / 2;
            lista.add(new Aluno(nome, nota1, nota2, media));

            scanner.nextLine(); // Limpa o buffer de entrada

            String outraMedia;
            do {
                System.out.print("Quer Adicionar média de outro aluno?(sim//não):");
                outraMedia = scanner.nextLine().trim().toLowerCase();
            } while (!outraMedia.equals("sim") && !outraMedia.equals("não"));

            if (outraMedia.equals("não")) {
                break;
            }
        }

        System.out.println("===========================================");
        System.out.printf("%-4s %-10s %-8s\n", "No", "NOME", "MEDIA");  // Cabeçalho
        System.out.println("===========================================");
        for (int i = 0; i < lista.size(); i++) {
            Aluno aluno = lista.get(i);
            // Corrigir o formato: índice como inteiro (i), nome como string, e média como float
            System.out.printf("%-4d %-10s %-8.2f\n", i, aluno.getNome(), aluno.getMedia());  // Aqui o formato está correto
        }

        while (true) {
            System.out.print("Mostrar notas de qual aluno?(digite 999 para parar.):");
            int opc = scanner.nextInt();
            if (opc == 999) {
                System.out.print(">>>Finalizando o programa...");
                break;
            }
            if (opc >= 0 && opc < lista.size()) {
                Aluno aluno = lista.get(opc);
                // Aqui você está usando o formato correto para as notas, que são floats
                System.out.printf("Notas de %s são %.2f e %.2f\n", aluno.getNome(), aluno.getNota1(), aluno.getNota2());
            }
        }
        System.out.print(">>Finalizando programa...");
    }


    static class Aluno {
        private String nome;
        private float nota1;
        private float nota2;
        private float media;

        public Aluno(String nome, float nota1, float nota2, float media) {
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





    public static void analistaListaComNumero5(Scanner scanner){
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        while (true){
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    int numeros = scanner.nextInt();
                    if (listaNumeros.contains(numeros)){
                        System.out.println("Número repetido, tente outro.");
                    }else {
                        listaNumeros.add(numeros);
                        break;
                    }
                }else {
                    System.out.println("ERRO!Digite um número válido.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            String continuar;
            do {
                System.out.print("Quer continuar?(sim/não):");
                continuar = scanner.nextLine().trim().toLowerCase();
            }while (!continuar.equals("não") && !continuar.equals("sim"));
            if (continuar.equals("não")){
                System.out.println("Foram digitados:"+ listaNumeros.size()+" elementos.");
                Collections.sort(listaNumeros, Collections.reverseOrder());
                if (listaNumeros.contains(5)){
                    System.out.println("o 5 faz parte da lista na posição:"+ listaNumeros.indexOf(5));
                }else {
                    System.out.println("O 5 não faz parte da lista.");
                }
                break;
            }

        }
    }


    public static void listaNumerosParesImpares(Scanner scanner){
        ArrayList<Integer> lista = adicionandoNumeros(scanner);
        ArrayList<Integer> listaaPar = filtroPar(lista);
        ArrayList<Integer> listaImpar = filtroImpar(lista);
        System.out.print("A lista:"+lista);
        System.out.print("A lista de pares:"+listaaPar);
        System.out.println("A lista de Impares:"+listaImpar);
    }
    public static ArrayList<Integer>adicionandoNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                lista.add(Integer.parseInt(scanner.nextLine()));
                String resposta;
                while (true) {
                    System.out.print("Quer continuar? (sim/não): ");
                    resposta = scanner.nextLine().trim().toLowerCase();
                    if (resposta.equals("sim")) {
                        break;
                    } else if (resposta.equals("não")) {
                        return lista;
                    } else {
                        System.out.println("Resposta inválida, digite somente 'sim' ou 'não'.");
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Número inválido!. Tente outro.");
            }
        }
    }

    public static ArrayList<Integer> filtroPar(ArrayList<Integer> numeros){
        ArrayList<Integer> listaaPar =new ArrayList<>();
        for (int numero : numeros){
            if (numero%2==0){
                listaaPar.add(numero);
            }
        }
        return listaaPar;
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









    public static void listaNumerosParesEImpares(Scanner scanner){

        ArrayList<Integer> lista = ObterNumeros(scanner);
        ArrayList<Integer> listaPares = filtrarPar(lista);
        ArrayList<Integer> listaImpares = filtrarImpar(lista);
        System.out.println("A lista:"+lista);
        System.out.println("Lista ímpares:"+listaImpares);
        System.out.println("Lista pares:"+listaPares);
    }
    public static ArrayList<Integer>ObterNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                lista.add(Integer.parseInt(scanner.nextLine()));
                System.out.print("Quer adicionar outro número?(sim/não):");
                String adicionarOutroNumero = scanner.nextLine().trim().toLowerCase();
                if (adicionarOutroNumero.equals("não")){
                    break;
                }
            }catch (NumberFormatException e){
                System.out.println("ERRO!Digite outro número.");
            }
        }
        return lista;
    }

    public static ArrayList<Integer> filtrarPar(ArrayList<Integer> numeros){
        ArrayList<Integer> listaPar = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2==0){
                listaPar.add(numero);
            }
        }
        return listaPar;
    }

    public static ArrayList<Integer> filtrarImpar(ArrayList<Integer> numeros){
        ArrayList<Integer> listaImpar = new ArrayList<>();
        for (int numero: numeros){
            if (numero%2!=0){
                listaImpar.add(numero);
            }
        }
        return listaImpar;
    }


    public static void listaParOuImpar2(Scanner scanner){
        ArrayList<Integer> lista = obterNumeros(scanner);
        ArrayList<Integer> listaPar = filtrarPares(lista);
        ArrayList<Integer> listaImpar = filtrarImpares(lista);

        System.out.println("A lista de números:"+lista);
        System.out.println("A lista de números pares:"+listaPar);
        System.out.println("A lista de números impares:"+listaImpar);
    }
    public static ArrayList<Integer>obterNumeros(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            try {
                System.out.print("Digite um número:");
                lista.add(Integer.parseInt(scanner.nextLine()));
                String resposta;
                while (true) {
                    System.out.print("Quer continuar? (sim/não): ");
                    resposta = scanner.nextLine().trim().toLowerCase(); // Normaliza a entrada

                    if (resposta.equals("sim")) {
                        break; // Sai do loop e continua pedindo números
                    } else if (resposta.equals("não")) {
                        return lista; // Retorna a lista e encerra o método
                    } else {
                        System.out.println("Resposta inválida, digite somente 'sim' ou 'não'.");
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Número inválido!. Tente outro.");
            }
        }

    }
    public static ArrayList<Integer>filtrarPares(ArrayList<Integer>numeros){
        ArrayList<Integer> listaPar = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2==0){
                listaPar.add(numero);
            }
        }
        return listaPar;
    }

//    outro codigo
    public static ArrayList<Integer>filtrarImpares(ArrayList<Integer>numeros){
        ArrayList<Integer> listaImpar = new ArrayList<>();
        for (int numero : numeros){
            if (numero%2==0){
                listaImpar.add(numero);
            }
        }
        return listaImpar;
    }


    public static void listaParOuImpar(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listaPar = new ArrayList<>();
        ArrayList<Integer> listaImpar = new ArrayList<>();
        while (true){
            int numero = obterNumero(scanner);
            lista.add(numero);
            if (!desejaContinuar(scanner)){
                break;
            }
        }
        for (int num :lista){
            if (num%2==0){
                listaPar.add(num);
            }else {
                listaImpar.add(num);
            }
        }
        System.out.println("A lista completa:"+lista);
        System.out.println("A lista de Pares:"+listaPar);
        System.out.println("A lista de impares:"+listaImpar);
    }
    public static int obterNumero(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite um número:");
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Erro! Digite um número válido.");
            }
        }
    }
    public static boolean desejaContinuar(Scanner scanner){
        while (true){
            System.out.print("Deseja continuar?(sim/não):");
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("sim")){
                return true;
            } else if (resposta.equals("não")) {
                return false;
            }else {
                System.out.println("Resposta inválida, digite apenas sim ou não!!");
            }
        }
    }
}
