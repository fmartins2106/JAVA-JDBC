package academy.devdojo.maratonajava.introducao;



import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDate;


public class Aula6ExercicioOperadoresCondicionais21 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner =new Scanner(System.in);
        Random random = new Random();

        //        jogo Jo Ken Po
        jogoJoKenPo(scanner,random);

        //        sorteando nos pessoas
        sorteandoNomePessoa(scanner, random);

//        jogo do par ou impar
        jogoParOuImpar(scanner,random);

        //        analisando compras
        analisandoCompras(scanner);


       //        analisando números
        analisandoNumeros(scanner);

// fazendo cadastro
        fazendoCadastro(scanner);

// opcoes de pagamento
        opcoesDePagamento(scanner);

//        analisando maior e menor nota
        analisandoMaiorEmenorNota(scanner);


        // sorteio de sequência de apresentação
        sequenciaApresentacao(scanner);



        //        sorteando um número
        sorteandoUmNumero(scanner, random);

        // notas juizes
        notasJuizes(scanner);


//        sorteando um número:
        sorteandoNumeroDaLista(scanner,random);

//        notas juizes
        verificandoNotasJuizes(scanner);

//        verificando as frase
        verificandoFrases(scanner);

// verificando nomes, separando o primeiro e o ultimo.
        separandoNomes(scanner);


// nome e suas variações
        nomeEsuasVariacoes(scanner);

//        analisando nomes
        primeiroEsegundoNome(scanner);

// analisando a frase
        quantasletrasAnaFrase(scanner);




//        jogo pedra, papel e tesoura
        jogoPedrPapelTesoura(scanner,random);


//        vefificando as notas do juizes
        analisandoNotasJuizes(scanner);

//        tabuada
        tabuada(scanner);

//        caixa eletronico
        caixaEletronico(scanner);
        scanner.close();
    }

    public static void jogoJoKenPo(Scanner scanner, Random random) throws InterruptedException{
        while (true){
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            int jogador = -1;
            while (true){
                System.out.print("Digite uma das opções acima:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO! Digite um valor válido!");
                    scanner.next();
                }
            }
            if (jogador<=0 || jogador>=4){
                System.out.println("ERRO!!! DIGITE UMA OPÇÃO VÁLIDA!");
                continue;
            }
            int computador = random.nextInt(3)+1;
            System.out.println("Processando....");
            Thread.sleep(1000);
            System.out.println("Computador:"+computador);
            if (jogador==computador){
                System.out.println("Você escolheu "+JoKenPo(jogador)+" e computador "+JoKenPo(computador)+" DEU EMPATE!!!");
            } else if (jogador == 1 && computador == 3 ||
                       jogador==2 && computador==1 ||
                       jogador==3 && computador==2) {
                System.out.println("Você escolheu "+JoKenPo(jogador)+" e computador "+JoKenPo(computador)+" VOCÊ VENCEU!!!");
            }else {
                System.out.println("Você escolheu " + JoKenPo(jogador) + " e computador " + JoKenPo(computador) + " VOCÊ PERDEU!!!");
            }
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='s' && continuar!='n'){
                System.out.print("Digite um valor válido:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (continuar=='n'){
                System.out.println(">>>>FINALIZANDO O PROGRAMA....");
                break;
            }
        }
    }


    public static String JoKenPo(int choose){
        switch (choose){
            case 1: return "PEDRA";
            case 2: return "PAPEL";
            case 3: return "TESOURA";
        }
        return "";
    }


    public static void sorteandoNumeroDaLista(Scanner scanner, Random random){
        System.out.println("Vamos sortear um número da lista!");
        ArrayList<Integer> listNumeros = new ArrayList<>();
        while (true){
            int numero = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numero = scanner.nextInt();
                    listNumeros.add(numero);
                    break;
                }else {
                    System.out.println("ERRO!Digite um valor válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Quer continuar?");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                int sorteio = random.nextInt(listNumeros.size());
                int sorteado = listNumeros.get(sorteio);
                System.out.println("O sorteado foi:"+sorteado);
                break;
            }
        }
    }


    public static void verificandoNotasJuizes(Scanner scanner){
        ArrayList<Float> listaNotasJuizes = new ArrayList<>();
        float soma = 0;
        System.out.println("Vamos fazer a média das suas notas!");
        float menorNota = Float.POSITIVE_INFINITY, maiorNota = Float.NEGATIVE_INFINITY;
        for (int n=0;n<6;n++){
            float notaJuiz = -1;
            while (true){
                System.out.print("Digite a "+(n+1)+"º nota:");
                if (scanner.hasNextFloat()){
                    notaJuiz = scanner.nextFloat();
                    listaNotasJuizes.add(notaJuiz);
                    break;
                }else {
                    System.out.println("ERRO! Digite um valor válido!");
                    scanner.next();
                }
            }
            if (notaJuiz>maiorNota){
                maiorNota=notaJuiz;
            }
            if (notaJuiz<menorNota){
                menorNota=notaJuiz;
            }
        }
        listaNotasJuizes.remove(maiorNota);
        listaNotasJuizes.remove(menorNota);
        for (float nota : listaNotasJuizes){
             soma+=nota;

        }
        float media = soma/listaNotasJuizes.size();
        System.out.println("A sua nota final ficou:"+String.format("%.2f",media));

    }



    public static void verificandoFrases(Scanner scanner){
        int contagem=0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (int i=0;i<frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu na frase:"+contagem+" vezes");
        int primeiroA = frase.indexOf("a");
        if (primeiroA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição: "+primeiroA);
        }else {
            System.out.println("A letra A não apareceu na frase!");
        }
        int ultimoA = frase.lastIndexOf("a");
        if (ultimoA>0){
            System.out.println("A letra A apareceu pela ultima vez na posição: "+ultimoA);
        }else {
            System.out.println("A letra A não apareceu na frase.");
        }
    }


    public static void separandoNomes(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine().trim().toUpperCase();
        String[] lista = nomeCompleto.split(" ");
        System.out.println("O seu nome completo:"+nomeCompleto);
        System.out.println("O seu primeiro nome:"+lista[0]);
        System.out.println("O seu segundo nome:"+lista[lista.length-1]);
    }


    public static void analisandoCompras(Scanner scanner){
        System.out.println("Vamos analisar compras");
        float totalCompra = 0, maisMil = 0;
        float menorValor = Float.POSITIVE_INFINITY;
        String nomeMenorValor = "";
        while (true){
            System.out.print("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine().trim();
            float valorProduto = -1;
            while(true){
                System.out.print("Digite o valor do produto:R$");
                if (scanner.hasNextFloat()){
                    valorProduto = scanner.nextFloat();
                    break;
                }else {
                    System.out.println("ERRO! Digite um valor válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='s' && continuar!='n'){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (valorProduto>0){
                totalCompra+=valorProduto;
            }
            if (valorProduto>=1000){
                maisMil++;
            }
            if (valorProduto<menorValor){
                menorValor=valorProduto;
                nomeMenorValor=nomeProduto;
            }
            if (continuar=='n'){
                System.out.println("Total da compra:"+totalCompra);
                System.out.println("Produtos acima de R$1000:"+maisMil);
                System.out.println("Produto com menor valor:"+nomeMenorValor+", valor:R$"+menorValor);
                break;
            }
        }
    }


    public static void jogoParOuImpar(Scanner scanner, Random random){
        System.out.println("Vamos jogar PAR ou IMPAR!");
        while (true){
            int jogador = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO! Digite um número válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Digite P para PAR ou I para IMPAR:");
            char parOuImpar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (parOuImpar!='p' && parOuImpar!='i'){
                System.out.print("Digite apenas P ou I:");
                parOuImpar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            int computador = random.nextInt(10)+1;
            System.out.println("Computador:"+computador);
            int resultado = computador+jogador;
            if (parOuImpar=='p' && resultado%2==0){
                System.out.println("Voce escolheu "+traduzirLetras(String.valueOf(parOuImpar))+", jogou:"+jogador+" e computador:"+computador+" - resultado:"+resultado+" VOCÊ VENCEU!!!");
            }else if (parOuImpar=='p' && resultado%2!=0){
                System.out.println("Você escolheu "+traduzirLetras(String.valueOf(parOuImpar))+", jogou:"+jogador+" e computador:"+computador+" - resultado:"+resultado+" VOCÊ PERDEU!!!");
            } else if (parOuImpar=='i' && resultado%2==0) {
                System.out.println("Você escolheu "+traduzirLetras(String.valueOf(parOuImpar))+", jogou:"+jogador+" e computador:"+computador+" - resultado:"+resultado+" VOCÊ PERDEU!!!");
            }else if (parOuImpar=='i' && resultado%2!=0){
                System.out.println("Você escolheu "+traduzirLetras(String.valueOf(parOuImpar))+", jogou:"+jogador+" e computador:"+computador+" - resultado:"+resultado+" VOCê VENCEU!!!");
            }
            System.out.print("Quer continuar?[S/N]:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='s' && continuar!='n'){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (continuar=='n'){
                System.out.println(">>>>>>>Finalizando o jogo....");
                break;
            }
        }
    }

    public static String traduzirLetras(String escolha){
        switch (escolha){
            case "p": return "PAR";
            case "i": return "IMPAR";
        }
        return "";
    }

    public static void analisandoNumeros(Scanner scanner){
        System.out.println("analisando números!");
        int contNumeros = 0, somaNumeros=0, maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        while (true){
            int numeros = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numeros = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO! Digiteum número válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while(!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (numeros>0){
                somaNumeros+=numeros;
                contNumeros++;
            }
            if (numeros>maiorNumero){
                maiorNumero=numeros;
            }
            if (numeros<menorNumero){
                menorNumero=numeros;
            }
            float media = (float) somaNumeros/contNumeros;
            if (continuar.equals("n")){
                System.out.println("Soma número digitados:"+somaNumeros+" e a média: "+media);
                System.out.println("Maior número:"+maiorNumero+" e o menor numero:"+menorNumero);
                break;
            }
        }
    }


    public static void jogoPedrPapelTesoura(Scanner scanner, Random random) throws InterruptedException{
        System.out.println("Vamos jogar Pedra, Papel e Tesoura!");
        while (true){
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            int jogador = -1;
            while (true){
                System.out.print("Digite uma das opções acima:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO! Digite uma opção válida!");
                    scanner.next();
                }
            }
            if (jogador<=0 || jogador>=4){
                System.out.println("Digite uma opção válida!");
                continue;
            }else {
                scanner.nextLine();
                System.out.println("JO");
                Thread.sleep(500);
                System.out.println("KEN");
                Thread.sleep(500);
                System.out.println("PO!!!");
                Thread.sleep(500);
                int computador = random.nextInt(3)+1;
                System.out.println("Computador:"+computador);
                if (jogador==computador){
                    System.out.println("Você escolheu "+traduzirEscolha(jogador)+ " e computador escolheu "+ traduzirEscolha(computador) +" DEU EMPATE!!!");
                } else if (jogador==1 && computador==3 || jogador==2 && computador==1 || jogador==3 && computador==2) {
                    System.out.println("Você escolheu "+traduzirEscolha(jogador)+" e computador escolheu "+traduzirEscolha(computador)+" VOCÊ VENCEU!!!");
                }else {
                    System.out.println("Você escolheu "+traduzirEscolha(jogador)+" e computadoe escolheu "+traduzirEscolha(computador)+" VOCÊ PERDEU!!!");
                }
            }
            System.out.print("Quer continuar?[S/N]:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='s' && continuar!='n'){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (continuar=='n'){
                System.out.println(">>>>Finalizando o programa!");
                break;
            }
        }
    }
    public static String traduzirEscolha(int escolha){
        switch (escolha){
            case 1:return "PEDRA";
            case 2:return "PAPEL";
            case 3:return "TESOURA";
        }
        return "";
    }

    public static void fazendoCadastro(Scanner scanner){
        int maiorDeIdade = 0, conthomens = 0, mulheresMenos20 = 0;
        System.out.println("Vamos fazer cadastro!");
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            int idade = -1;
            while (true){
                System.out.print("Idade:");
                if (scanner.hasNextInt()){
                    idade = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO! Digite um valor válido.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Digite o sexo[F/M]:");
            char sexo = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (sexo!='f' && sexo!='m'){
                System.out.print("ERRO! Digite apenas F ou M:");
                sexo = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (idade>=18){
                maiorDeIdade++;
            }
            if (sexo=='m'){
                conthomens++;
            }
            if (sexo=='f' && idade<=20){
                mulheresMenos20++;
            }
            if (continuar.equals("n")){
                System.out.println("Quantidade de pessoas maiores de idade:"+maiorDeIdade);
                System.out.println("Quantidade de homens cadastrados:"+conthomens);
                System.out.println("Quantidade de mulheres com menos de 20 anos:"+mulheresMenos20);
                break;
            }


        }



    }

    public static void analisandoNotasJuizes(Scanner scanner){
        System.out.println("Vamos analisar as notas dos juizes!");
        ArrayList<Float> listaNotas = new ArrayList<>();
        float maiorNota = Float.NEGATIVE_INFINITY, menorNota = Float.POSITIVE_INFINITY;
        float soma = 0;
        for (int n=0;n<6;n++){
            float nota = -1;
            while (true){
                System.out.print("Digite a "+(n+1)+"º nota:");
                if (scanner.hasNextFloat()){
                    nota = scanner.nextFloat();
                    listaNotas.add(nota);
                    break;
                }else {
                    System.out.println("ERRO! Digite um valor válido!");
                    scanner.next();
                }
            }
            if (nota>maiorNota){
                maiorNota=nota;
            }
            if (nota<menorNota){
                menorNota=nota;
            }
        }
        listaNotas.remove(maiorNota);
        listaNotas.remove(menorNota);
        for (float nota: listaNotas){
            soma+=nota;
        }
        float media = soma/listaNotas.size();
        System.out.println("A média das notas:"+String.format("%.2f",media));

    }


    public static void opcoesDePagamento(Scanner scanner){
        while (true){
            System.out.println("Analisando opções de pagamento.");
            System.out.println("[ 1 ] À VISTA - Dinheiro com 10% de desconto.");
            System.out.println("[ 2 ] À VISTA - No cartão de débito com 5% de desconto.");
            System.out.println("[ 3 ] PARCELADO - 2x no cartão de crédito.");
            System.out.println("[ 4 ] PARCELADO - 3X no cartão de crédito.");
            System.out.println("[ 5 ] SAIR.");
            int opcaoDePagamento = -1;
            while (true){
                System.out.print("Digite uma das opções acima:");
                if (scanner.hasNextInt()){
                    opcaoDePagamento = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO! Digite uma opção válida!");
                }
            }
            if (opcaoDePagamento<=0 || opcaoDePagamento>=6){
                System.out.println("ERRO! Digite um valor válido.");
            }
            if (opcaoDePagamento==5){
                System.out.println(">>>>Finalizando o programa...");
                break;
            }else {
                System.out.print("Digite o valor do produto:R$");
                float valorProduto = scanner.nextFloat();
                if (opcaoDePagamento==1){
                    float opcao1 = valorProduto-(valorProduto*0.10f);
                    System.out.println("Valor do produto com 10% de desconto:"+opcao1);
                } else if (opcaoDePagamento==2) {
                    float opcao2 = valorProduto-(valorProduto*0.05f);
                    System.out.println("Valos do produto com 5% de desconto:"+opcao2);
                } else if (opcaoDePagamento==3) {
                    float opcao3 = valorProduto;
                    float parcela2x = opcao3/2;
                    System.out.println("Valor do produto:R$"+opcao3+" em 2x de R$"+parcela2x);
                }else if (opcaoDePagamento==4){
                    float opcao4 = valorProduto+(valorProduto*0.20f);
                    float parcela3x = opcao4/3;
                    System.out.println("Valor do produto R$"+opcao4+" com 20% de jutos em 3x de:"+parcela3x);
                }
            }
        }
    }


    public static void analisandoMaiorEmenorNota(Scanner scanner){
        System.out.println("Analisando a maior e a menor nota!");
        ArrayList<Float> listaNotas = new ArrayList<>();
        float maiorNota = Float.NEGATIVE_INFINITY, menorNota = Float.POSITIVE_INFINITY;
        for (int i=0;i<6;i++){
            float notas = -1;
            while (true){
                System.out.print("Digite a "+(i+1)+"º nota:");
                if (scanner.hasNextFloat()){
                    notas = scanner.nextFloat();
                    listaNotas.add(notas);
                    break;
                }else {
                    System.out.println("ERRO!Digite um valor válido.");
                    scanner.next();
                }
            }
            if (notas>maiorNota){
                maiorNota=notas;
            }
            if (notas<menorNota){
                menorNota=notas;
            }
        }
        System.out.println("A maior nota foi"+maiorNota);
        System.out.println("A menor nota foi:"+menorNota);
    }


    public static void sequenciaApresentacao(Scanner scanner){
        System.out.println("Vamos sortear a sequência de apresentação!");
        ArrayList<String> listaApresentacao = new ArrayList<>();
        while (true){
            System.out.print("Nome:");
            String nomePessoa = scanner.nextLine().toUpperCase().trim();
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            listaApresentacao.add(nomePessoa);
            if (continuar.equals("n")){
                Collections.shuffle(listaApresentacao);
                System.out.println("A sequência de apresentação:"+listaApresentacao);
                break;
            }
        }
    }

    public static void sorteandoNomePessoa(Scanner scanner, Random random){
        ArrayList<String> listaNome = new ArrayList<>();
        System.out.println("Vamos sortear uma pessoa!");
        while (true){
            System.out.print("Digite o nome:");
            String nomePessoa = scanner.nextLine().trim().toUpperCase();
            listaNome.add(nomePessoa);
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                int sorteio = random.nextInt(listaNome.size());
                String nomeSorteado = listaNome.get(sorteio);
                System.out.println("O grande sortudo foi:"+nomeSorteado);
                break;
            }
        }

    }

    public static void sorteandoUmNumero(Scanner scanner, Random random){
        ArrayList<Integer> lista = new ArrayList<>();
        while (true){
            int numero = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numero = scanner.nextInt();
                    lista.add(numero);
                    break;
                }else {
                    System.out.println("ERRO! Digite um número válido.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                int sorteio = random.nextInt(lista.size());
                int nSorteado = lista.get(sorteio);
                System.out.println("O grande sortudo foi:"+nSorteado);
                break;
            }
        }
    }


    public static void notasJuizes(Scanner scanner){
        ArrayList<Float> listaNotaJuizes = new ArrayList<>();
        float maiorNota = Float.NEGATIVE_INFINITY, menorNota = Float.POSITIVE_INFINITY;
        float soma = 0;
        for (int i=0; i<6; i++){
            float notas = -1;
            while (true){
                System.out.print("Digite a "+(i+1)+"º nota:");
                if (scanner.hasNextFloat()){
                    notas = scanner.nextFloat();
                    listaNotaJuizes.add(notas);
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            if (notas>maiorNota){
                maiorNota=notas;
            }
            if (notas<menorNota){
                menorNota=notas;

            }
        }
        listaNotaJuizes.remove(maiorNota);
        listaNotaJuizes.remove(menorNota);
        for (float nota: listaNotaJuizes){
            soma+=nota;
        }
        float media = (float) soma/listaNotaJuizes.size();
        System.out.println("A média é:"+String.format("%.2f",media));
    }


    public static void nomeEsuasVariacoes (Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine().trim();
        System.out.println("Seu nome em letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("Seu nome em letras maiusculas:"+nomeCompleto.toUpperCase());
        String[] letras = nomeCompleto.split(" ");
        System.out.println("Quantidade de letras do primeiro nome:"+letras[0].length());
        System.out.println("Quantidade de letras do seu nome completo:"+nomeCompleto.replace(" ","").length());
        System.out.println("Quantidade de letras do seu ultimo nome:"+letras[letras.length-1].length());
    }

    public static void primeiroEsegundoNome(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine().trim().toUpperCase();
        String[] lista = nomeCompleto.split(" ");
        System.out.println("Seu nome completo:"+nomeCompleto);
        System.out.println("Seu primeiro nome:"+lista[0]);
        System.out.println("Seu segundo nome:"+lista[lista.length-1]);
    }

    public static void quantasletrasAnaFrase(Scanner scanner){
        int contagem=0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim();
        for (int a=0;a<frase.length();a++){
            if (frase.charAt(a)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu na frase:"+contagem);
        int primeiraVez = frase.indexOf('a');
        if (primeiraVez>0){
            System.out.printf("A letra A apareceu na frase pela primiera vez na posição:%d%n",primeiraVez);
        }else {
            System.out.println("A letra A não apareceu na frase.");
        }

        int ultimaVez = frase.lastIndexOf('a');
        if (ultimaVez>0){
            System.out.printf("A letra A apareceu na frase pela ultima vez na posição:%d%n",ultimaVez);
        }else {
            System.out.println("A letra A não apareceu na frase.");
        }

    }


    public static void tabuada(Scanner scanner){
        while (true){
            int tabuada=-1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    tabuada = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO!!!Digite um número válido!");
                    scanner.next();
                }
            }
            if (tabuada<=-1){
                System.out.println(">>>>>FINALIZANDO PROGRAMA...");
                break;
            }else {
                for (int t=0;t<=10;t++){
                    System.out.printf("%d x %d= %d%n",tabuada,t,tabuada*t);
                }
            }
        }

    }

    public static void caixaEletronico(Scanner scanner){
        System.out.print("Digite quanto quer sacar?:R$");
        int sacar  = scanner.nextInt();
        int valor = sacar;
        int ced = 50;
        int totalced = 0;
        while (true){
            if (valor>=ced){
                valor-=ced;
                totalced++;
            }else {
                if (totalced>0){
                    System.out.printf("Total de %d cédulas de R$%d%n",totalced, ced);
                }
                if (ced==50){
                    ced=20;
                } else if (ced==20) {
                    ced=10;
                } else if (ced==10) {
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


}
