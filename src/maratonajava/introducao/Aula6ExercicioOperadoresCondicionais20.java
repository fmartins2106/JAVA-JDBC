package academy.devdojo.maratonajava.introducao;



import java.time.LocalDate;
import java.util.*;

public class Aula6ExercicioOperadoresCondicionais20 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


//        jogo Jo Ken Po
        jogoPedraPepelTesoura(scanner, random);


        //        cadastro de pessoas
        casdastroDePessoas(scanner);

//        analisand opcoes De Pagamento
        opcaesDePagamento(scanner);

//        notas juizes
        notasDosJouizes(scanner);

//        maior e menor da lista
        verificandoOmaiorEmenorDaLista(scanner);

//        sorteando um número
        sorteioNumero(scanner,random);

//        sorteando nomes
        sorteandoNomes(scanner,random);

//        tabuada
        calculoTabuada(scanner);

//        caixaEletronico
        caixaEletronico(scanner);

//        vamos sortear a sequeência de apresentação
        sequenciaApresentacao(scanner);

//        vamos sortear um nome
        sorteioNome(scanner,random);

//        sorteando um número
        sorteandoNumero(scanner,random);


//        analisando valores
        maiorEmenorValorDaLista(scanner);


//        vamos analisar compras
        analisandoCompras(scanner);

        // programa caixa eletrônico
        programCaixaEletronico(scanner);

//        calculo tabuada
        calculandoAtabuada(scanner);

//        calcular as notas dos juizes
        notasJuizes(scanner);

//       maior e o menor da lista
        maiorEmenorDaLista(scanner);

//        tabuada
        tabuada(scanner);

//        jogo Pedra, PAPEL E TESOURA
            jogoPedraPapelEtesoura(scanner,random);
//        JOGO par ou impar
        jogoParOuImpar(scanner, random);



//        analisando opções de pagamento
        analisandoOpcoesDePagamento(scanner);

//        maior e menor valor da lista
        maiorEmenorValor(scanner);

//        caixa eletronico
        simulandoCaixaEletronico(scanner);
        scanner.close();
    }

    public static void notasDosJouizes(Scanner scanner){
        double maiorNota = Double.NEGATIVE_INFINITY, menorNota = Double.POSITIVE_INFINITY;
        float soma = 0;
        float cont = 0;
        ArrayList<Float> listaNotas = new ArrayList<>();
        for (int n=0;n<6;n++){
            float notas = -1;
            while (true){
                System.out.print("Digite a "+(n+1)+"º nota:");
                if (scanner.hasNextFloat()){
                    notas = scanner.nextFloat();
                    listaNotas.add(notas);
                    break;
                }else{
                    System.out.println("Digite um valor válido!");
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
        listaNotas.remove((float) (maiorNota));
        listaNotas.remove((float)(menorNota));
        for (float notas: listaNotas){
            soma+=notas;
            cont++;
        }
        double media = soma/cont;
        System.out.println("A média das notas:"+media);
    }

    public static void verificandoOmaiorEmenorDaLista(Scanner scanner){
        int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE;
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
                    System.out.println("ERRO!!! Digite um valor válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Quer adicionar outro número?[s/n]:");
            String adicionar = scanner.nextLine().trim().toLowerCase();
            while (!adicionar.equals("s") && !adicionar.equals("n")){
                System.out.print("Digite apenas S ou N:");
                adicionar = scanner.nextLine().trim().toLowerCase();
            }
            if (numero > maior){
                maior =numero;
            }
            if (numero<menor){
                menor=numero;
            }
            if (adicionar.equals("n")){
                System.out.println("O maior número da lista:"+maior);
                System.out.println("O menor número da lista:"+menor);
                break;
            }
        }
    }



    public static void sorteioNumero(Scanner scanner, Random random){
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
                    System.out.println("Digite um númer válido.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Quer adicionar outr número[S/N]?:");
            char adicionar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (adicionar!='s' && adicionar!='n'){
                System.out.print("Digite apenas S ou N:");
                adicionar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (adicionar=='n'){
                int sorteio = random.nextInt(lista.size());
                int sorteado = lista.get(sorteio);
                System.out.println("O número sorteado foi:"+sorteado);
                break;
            }
        }
    }

    public static void sorteandoNomes(Scanner scanner, Random random){
        System.out.println("Vamos sortear um nome");
        ArrayList<String> listaNomes = new ArrayList<>();
        while (true){
            System.out.print("Digite um nome:");
            String nome = scanner.nextLine().trim().toUpperCase();
            listaNomes.add(nome);
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                int sortear = random.nextInt(listaNomes.size());
                String sorteado = listaNomes.get(sortear);
                System.out.println("O grande sortudo foi:"+sorteado);
            }
        }
    }


    public static void calculoTabuada(Scanner scanner){
        System.out.println("Vamos calcular tabuadas");
        while (true){
            int tabuada = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    tabuada = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Número inválido!");
                    scanner.next();
                }
            }
            if (tabuada<=-1){
                System.out.println(">>>>>Finalizando o programa<<<<<");
            }else {
                for (int t=0;t<=10;t++){
                    System.out.printf("%d x %d = %d%n",tabuada,t,tabuada*t);
                }
            }

        }
    }

    public static void caixaEletronico(Scanner scanner){
        System.out.println("Vamos simular um caixa eletronico");
        System.out.print("Quanto quer sacar?:R$");
        int saque = scanner.nextInt();
        int valor = saque;
        int ced = 50;
        int totalced = 0;
        while (true){
            if (valor>=ced){
                valor-=ced;
                totalced++;
            }else {
                if (totalced>0){
                    System.out.printf("Total de %d cédulas de %d%n",totalced,ced);
                }
                if (ced==50){
                    ced=20;
                } else if (ced==20) {
                    ced=10;
                } else if (ced==10) {
                    ced=5;
                }else if (ced==5){
                    ced=1;
                }
                totalced=0;
                if (valor<=0){
                    break;
                }
            }
        }
    }

    public static void sequenciaApresentacao(Scanner scanner){
        System.out.println("Vamos sortear a sequência de apresentação!");
        ArrayList<String> lista = new ArrayList<>();
        while (true){
            System.out.print("Digite o nome:");
            String nome  = scanner.nextLine().trim().toUpperCase();
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            lista.add(nome);
            Collections.shuffle(lista);
            if (continuar.equals("n")){
                System.out.println("A sequência de apresentação ficou:"+lista);
                break;
            }

        }
    }


    public static void sorteioNome(Scanner scanner, Random random){
        ArrayList<String> listaNomes = new ArrayList<>();
        while (true){
            System.out.print("Digite um nome:");
            String nomes = scanner.nextLine().toUpperCase().trim();
            listaNomes.add(nomes);
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().toLowerCase().trim();
            }
            if (continuar.equals("n")){
                int sorteioPessoas = random.nextInt(listaNomes.size());
                String sorteado = listaNomes.get(sorteioPessoas);
                System.out.println("A pessoa sorteada foi:"+sorteado);
                break;
            }
        }
    }

    public static void sorteandoNumero(Scanner scanner, Random random){
        System.out.println("Vamos sortear um número!");
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
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar !='s' && continuar !='n'){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (continuar=='n'){
                int sorteio = random.nextInt(lista.size());
                int nSorteado = lista.get(sorteio);
                System.out.println("O número sorteado foi:"+nSorteado);
                break;
            }
        }
    }




    public static void maiorEmenorValorDaLista(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        int maiorLista = Integer.MIN_VALUE, menorLista = Integer.MAX_VALUE;
        while (true){
            int numero = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numero = scanner.nextInt();
                    lista.add(numero);
                    break;
                }else {
                    System.out.println("Digite um número válido!!!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (numero>maiorLista){
                maiorLista=numero;
            }
            if (numero<menorLista){
                menorLista=numero;
            }
            if (continuar.equals("n")){
                System.out.println("O maior da lista"+maiorLista);
                System.out.println("O menor da lista:"+menorLista);
                break;
            }



        }


    }

    public static void jogoPedraPepelTesoura(Scanner scanner, Random random) throws InterruptedException{
        System.out.println("Vamos jogar Pedra, Papel e Tesoura!");
        while (true) {
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            int jogador = -1;
            while (true) {
                System.out.print("Digite uma das opções acima:");
                if (scanner.hasNextInt()) {
                    jogador = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            if (jogador <= 0 || jogador >= 4) {
                System.out.println("Digite uma opção válida!!!");
                continue;
            }
            scanner.nextLine();
            System.out.println("JO");
            Thread.sleep(500);
            System.out.println("KEN");
            Thread.sleep(500);
            System.out.println("PO!!!");
            Thread.sleep(500);
            int computador = random.nextInt(3) + 1;
            System.out.println("Computador:" + computador);
            if (jogador == computador) {
                System.out.println("Você escolheu " + jogador + " e computador " + computador + " DEU EMPARTE!!!");
            } else if (jogador == 1 && computador == 3 || jogador == 2 && computador == 1 || jogador == 3 && computador == 2){
                System.out.println("Você escolheu " + jogador + "e computador " + computador + " VOCÊ VENCEU!!!");
            } else{
                System.out.println("Você escolheu " + jogador + " e computador " + computador + " VOCÊ PERDEU!!!");
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")) {
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")) {
                System.out.println(">>>>Finalizando o programa!<<<<");
                break;
            }

        }
    }

    public static void opcaesDePagamento(Scanner scanner){
        System.out.println("Vamos analisar as opções de pagamento!");
        while (true){
            System.out.println("[ 1 ] À VISTA - Dinheiro ou cheque com 10% de desconto. ");
            System.out.println("[ 2 ] À VISTA - No cartão de débito com 5% de desconto.");
            System.out.println("[ 3 ] PARCELADO - 2x no cartão de crédito.");
            System.out.println("[ 4 ] PARCELADO - 3x no cartão de crédito.");
            System.out.println("[ 5 ] SAIR.");
            int opcaoDePagamento = -1;
            while (true){
                System.out.print("Digite uma das opções acima:");
                if (scanner.hasNextInt()){
                    opcaoDePagamento = scanner.nextInt();
                    break;
                }else{
                    System.out.println("Digite um valor válido!");
                    scanner.next();
                }
            }
            if (opcaoDePagamento<=0 || opcaoDePagamento>=6){
                System.out.println("Digite uma opção válida !!!");
                continue;
            }
            if (opcaoDePagamento==5){
                System.out.println(">>>Finalisando o programa<<<");
                break;
            }else {
                System.out.print("Digite o valor do produto:R$");
                float valorProduto = scanner.nextFloat();
                if (opcaoDePagamento==1){
                    float opcao1 = valorProduto-(valorProduto*0.10f);
                    System.out.printf("À vista com 10%% de desconto, o valor final fica:R$%.2f%n",opcao1);
                }else if (opcaoDePagamento==2){
                    float opcao2 = valorProduto-(valorProduto*.05f);
                    System.out.printf("À vista com 5%% de desconto, o valor final fica:R$%.2f%n",opcao2);
                } else if (opcaoDePagamento==3) {
                    float opcao3 = valorProduto;
                    float valor2x = valorProduto/2;
                    System.out.printf("Parcelado em 2x de R$%.2f - valor total:R$%.2f%n",valor2x,opcao3);
                } else if (opcaoDePagamento==4) {
                    float opcao4 = valorProduto+(valorProduto*0.20f);
                    float valor3x = opcao4/3;
                    System.out.printf("Parcelado em 3x de R$%.2f - valor total:R$%.2f%n",valor3x,opcao4);
                }
            }
        }

    }



    public static void analisandoCompras(Scanner scanner){
        System.out.println("Vamos analisar as compras!");
        double totalCompra = 0, menorValorCompra = Double.POSITIVE_INFINITY;
        String nomeMenorValorCompra = "";
        int valorAcimaMil = 0;
        while (true){
            System.out.print("Nome produto:");
            String nomeProduto = scanner.nextLine();
            System.out.print("Digite o valor do produto:R$");
            float valorProduto = scanner.nextFloat();
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='s' && continuar!='n'){
                System.out.print("ERRO! Digite apenas S ou N!:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (valorProduto>0){
                totalCompra+=valorProduto;
                valorAcimaMil++;
            }
            if (valorProduto<menorValorCompra){
                menorValorCompra=valorProduto;
                nomeMenorValorCompra=nomeProduto;
            }
            if (continuar=='n'){
                System.out.println("Total da compra:"+totalCompra);
                System.out.println("Produtos acima R$1000:"+valorAcimaMil);
                System.out.printf("Produto menor valor:%s - R$%.2f%n",nomeMenorValorCompra,menorValorCompra);
                break;
            }
        }
    }

    public static void programCaixaEletronico(Scanner scanner){
        System.out.println("Simulador de caixa eletrônico");
        System.out.print("Quanto quer sacar?:R$");
        int saque = scanner.nextInt();
        int valor = saque;
        int ced = 50;
        int totalced = 0;
        while (true){
            if (valor>=ced){
                valor-=ced;
                totalced++;
            }else {
                if (totalced>=0){
                    System.out.printf("Total de %d cédulas de R$%d%n",totalced,ced);
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

    public static void calculandoAtabuada(Scanner scanner){
        System.out.println("Vamos calcular tabuadas");
        while (true){
            int tabuada = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    tabuada = scanner.nextInt();
                    break;
                }else{
                    System.out.println("Digite um valor válido!");
                    scanner.next();
                }
            }
            if (tabuada<=-1){
                System.out.println(">>>Finalizando o programa<<<<<");
                break;
            }else {
                for (int t=0;t<=10;t++){
                    System.out.printf("%d x %d = %d%n",tabuada,t,tabuada*t);
                }
            }
        }
    }

    public static void notasJuizes(Scanner scanner){
        System.out.println("Vamos calcular as notas dos juizes!");
        ArrayList<Float> listaNotasJuizes = new ArrayList<>();
        for (int n=0;n<6;n++){
            float notas = -1;
            while (true){
                System.out.print("Digite o "+(n+1)+"º número:");
                if (scanner.hasNextFloat()){
                    notas = scanner.nextFloat();
                    listaNotasJuizes.add(notas);
                    break;
                }else {
                    System.out.println("Digite um valor válido!");
                    scanner.next();
                }
            }
        }
        float maiorNumero = Collections.max(listaNotasJuizes);
        float menorNumero = Collections.min(listaNotasJuizes);
        listaNotasJuizes.remove(maiorNumero);
        listaNotasJuizes.remove(menorNumero);
        float soma = 0;
        for (float nota : listaNotasJuizes){
            soma+=nota;
        }
        float mediaNotas = soma/ listaNotasJuizes.size();
        System.out.println("Sua média final foi:"+ String.format("%.2f",mediaNotas));
    }

    public static void maiorEmenorDaLista(Scanner scanner){
        ArrayList<Integer> lista =new ArrayList<>();
        int maiorLista = Integer.MIN_VALUE, menorLista = Integer.MAX_VALUE;
        System.out.println("Vamos verificar o maior e o menor da lista!");
        while (true){
            int numerosLista = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numerosLista = scanner.nextInt();
                    lista.add(numerosLista);
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();
            System.out.print("Quer continuar ?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            for (int numero: lista){
                if (numero>maiorLista){
                    maiorLista=numero;
                }
                if (numero<menorLista){
                    menorLista=numero;
                }
            }
            if (continuar.equals("n")){
                System.out.println("Maior número da lista:"+maiorLista);
                System.out.println("Menor número da lista:"+menorLista);
                break;
            }
        }
    }


    public static void tabuada(Scanner scanner){
        System.out.println("Vamos calcular tabuadas!");
        while (true){
            int tabuada = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    tabuada = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO! Digite um número inteiro!");
                    scanner.next();
                }
            }
            if (tabuada<=-1){
                break;
            }else {
                for (int t=0;t<=10;t++){
                    System.out.printf("%d x %d = %d%n",tabuada,t,tabuada*t);
                }
            }
        }
    }

    public static void jogoPedraPapelEtesoura(Scanner scanner, Random random) throws InterruptedException{
        System.out.println("vamos jogar Jo, Ken, Po!!!");
        while (true){
            int jogador = -1;
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            while (true){
                System.out.print("Digite uma das opções acima:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
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
                System.out.printf("Você escolheu:%d e computador:%d, DEU EMPATE!!!%n",jogador,computador);
            } else if (jogador==1 && computador==3 || jogador==2 && computador==1 || jogador==3 && computador==2) {
                System.out.printf("Você escolheu:%d e computador:%d, VOCÊ VENCEU!!!%n",jogador,computador);
            }else {
                System.out.printf("Você escolheu:%d e computador:%d, VOCÊ PERDEU!!!%n",jogador,computador);
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                System.out.println(">>>> finalizando o programa<<<<");
                break;
            }
        }
    }

    public static void jogoParOuImpar(Scanner scanner, Random random){
        System.out.println("Vamos jogar par ou impar!");
        while (true){
            int jogador = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Digigte P para PAR ou I para IMPAR:");
            String parOuImpar = scanner.nextLine().trim().toLowerCase();
            while (!parOuImpar.equals("p") && !parOuImpar.equals("i")){
                System.out.print("Digite apenas P ou I:");
                parOuImpar = scanner.nextLine().trim().toLowerCase();
            }
            int computador = random.nextInt(10)+1;
            System.out.println("Computador = "+computador);
            int resultado = jogador+computador;
            if (resultado%2==0 && parOuImpar.equals("p")){
                System.out.printf("Você escolheu %s=PAR, digitou:%d e computador:%d - total:%d- VOCÊ VENCEU!!!%n",parOuImpar,jogador, computador,resultado);
            } else if (resultado%2==0 && parOuImpar.equals("i")) {
                System.out.printf("Você escolheu %s=IMPAR, digitou:%d e computador:%d - total:%d- VOCÊ PERDEU!!!%n",parOuImpar,jogador,computador,resultado);
            } else if (resultado%2!=0 && parOuImpar.equals("p")) {
                System.out.printf("Você escolheu %s=PAR, digitou:%d e computador:%d - total:%d- VOCÊ PERDEU!!!%n",parOuImpar,jogador,computador,resultado);
            } else if (resultado%2!=0 && parOuImpar.equals("i")) {
                System.out.printf("Você escolheu %s=IMPAR, digitou:%d e computador:%d - total:%d - VOCÊ VENCEU!!!%n",parOuImpar,jogador,computador,resultado);
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                System.out.println(">>>>>Finalizando o programa!!!");
                break;
            }
        }


    }

    public static void casdastroDePessoas(Scanner scanner){
        System.out.println("Vamos cadastrar pessoas!");
        int maiorDeIdade = 0, homens = 0, mulheresmais20 = 0;
        while (true){
            System.out.print("Nome:");
            String nomePessoa = scanner.nextLine();
            System.out.print("Digite a idade:");
            int idade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o sexo:");
            char sexoPessoa = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (sexoPessoa!='f' && sexoPessoa!='m'){
                System.out.print("Digite apenas F ou M:");
                sexoPessoa = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (idade>=18){
                maiorDeIdade++;
            }
            if (sexoPessoa=='m'){
                homens++;
            }
            if (sexoPessoa=='f' && idade<=20){
                mulheresmais20++;
            }
            System.out.print("Quer continuar?[S/N]:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='s' && continuar!='n'){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (continuar=='n'){
                System.out.println("Maiores de idade:"+maiorDeIdade);
                System.out.println("Homens:"+homens);
                System.out.println("Mulheres menos 20 anos:"+mulheresmais20);
                System.out.println(">>>>Finalizando o cadastro....");
                break;
            }
        }
    }


    public static void analisandoOpcoesDePagamento(Scanner scanner){
        while (true){
            int opcaoDeCompra = -1;
            System.out.println("Analisando as opções de pagamento");
            System.out.println("Vamos as opções !");
            System.out.println("[ 1 ] À VISTA - Dinheiro ou cheque com 10% de desconto.");
            System.out.println("[ 2 ] À VISTA - No cartão de débito com 5% de desconto.");
            System.out.println("[ 3 ] PARCELADO - 2x no cartão de crédito.");
            System.out.println("[ 4 ] PARCELADO - 3x no cartão de crédito. ");
            System.out.println("[ 5 ] SAIR.");
            while (true){
                System.out.print("Digite uma das opções acima:");
                if (scanner.hasNextInt()){
                    opcaoDeCompra = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um valor válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            if (opcaoDeCompra==5){
                System.out.println(">>>>Finalizando programa...");
                break;
            }else {
                System.out.print("Digite o valor do produto:R$");
                int valorProduto = scanner.nextInt();
                if (opcaoDeCompra==1){
                    float opcao1 = valorProduto-(valorProduto*0.10f);
                    System.out.printf("Valor do produto à vista no dinheiro com desconto de 10%%:R$%.2f%n",opcao1);
                }else if (opcaoDeCompra==2){
                    float opcao2 = valorProduto-(valorProduto*0.05f);
                    System.out.printf("Valor do produto à vista no cartão de débito com 5%% de desconto:R$%.2f%n",opcao2);
                } else if (opcaoDeCompra==3) {
                    float opcao3 = valorProduto;
                    float parcela2x = opcao3/2;
                    System.out.printf("Valor do produto parcelado em 2x de %.2f no cartão de crédito, total:R$%.2f%n",parcela2x,opcao3);
                }else if (opcaoDeCompra==4){
                    float opcao4 = valorProduto+(valorProduto*0.20f);
                    float parcela3x = opcao4/3;
                    System.out.printf("Valor do produto parcelado em 3x de %.2f no cartão de crédito, total:R$%.2f%n",parcela3x,opcao4);
                }

            }

        }

    }


    public static void maiorEmenorValor(Scanner scanner){
        ArrayList<Integer> lista = new ArrayList<>();
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        System.out.println("Vamos verificar o maior e o menor da lista!");
        for (int n=0;n<5;n++){
            int numero = -1;
            while (true){
                System.out.print("Digite o "+(n+1)+"º número da lista:");
                if (scanner.hasNextInt()){
                    numero = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            if (numero>maiorNumero){
                maiorNumero=numero;
            }
            if (numero < menorNumero) {
                menorNumero=numero;
            }
        }
        System.out.println("Maior número da lista:"+maiorNumero);
        System.out.println("Menor número da lista:"+menorNumero);
    }


    public static void simulandoCaixaEletronico(Scanner scanner){
        System.out.println("Vamos simular um caixa eletrônico");
        System.out.print("Quanto gostaria de sacar?:R$");
        int saque = scanner.nextInt();
        int valor = saque;
        int ced = 50;
        int totalced= 0;
        while (true){
            if (valor>=ced){
                valor-=ced;
                totalced++;
            }else {
                if (totalced>0){
                    System.out.printf("Total de %d cédulas de %d%n",totalced,ced);
                }if (ced==50){
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
