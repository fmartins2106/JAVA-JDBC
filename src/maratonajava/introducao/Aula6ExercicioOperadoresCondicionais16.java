package academy.devdojo.maratonajava.introducao;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Aula6ExercicioOperadoresCondicionais16 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        somar e contar numeros impares
        System.out.println("Vamos somar e contar números impares!");
        int contImpar = 0, somaImpar = 0;
        for (int impar=1; impar<30;impar+=2){
            System.out.println(impar);
            if (impar % 2 !=0){
                contImpar++;
                somaImpar+=impar;
            }
        }
        System.out.println("Total de números impares de 1 a 29= "+contImpar);
        System.out.println("Soma dos números imopares de 1 a 29= "+somaImpar);

//        maior numero digitado
        maiorNumeroDigitado(scanner);

//        tabuada
        tabuada(scanner);

//        analisando números
        analisandoNumeros(scanner);

//      jogo par ou impar
        jogoParOuImpar(scanner,random);

//        cadastro de Pessoas
        cadastroPessoas(scanner);

//        analisando compras
        analisandoCompras(scanner);

//        caixa eletronico
        caixaEletronico(scanner);


//        opções de pagamento na loja.
        opcaoDePagamentoLoja(scanner);

//        Jogo Pedra Papel e tesousa
        jogoPedraPapelTesousa(scanner,random);
        scanner.close();

    }

    public static void maiorNumeroDigitado(Scanner scanner){
        System.out.println("Vamos verificar o maior número digitado!");
        int maiorNumeroDigitado = Integer.MIN_VALUE;
        for (int n=0;n<3;n++){
            System.out.print("Digite um o "+(n+1)+"º número:");
            int numeroDigitado = scanner.nextInt();
            if (numeroDigitado>maiorNumeroDigitado){
                maiorNumeroDigitado=numeroDigitado;
            }
        }
        System.out.println("O maior Número é:"+maiorNumeroDigitado);
    }

    public static void tabuada(Scanner scanner){
        System.out.println("Vamos fazer calcular tabuada!");
        while (true){
            System.out.print("Digite um número:");
            int tabuada = scanner.nextInt();
            if (tabuada<=-1){
                System.out.println("FINALIZANDO...");
                break;
            }else {
                for (int t=0;t<=10;t++){
                    System.out.printf("%d x %d = %d%n",tabuada,t,tabuada*t);
            }
        }
    }
}


    public static void analisandoNumeros(Scanner scanner){
        int soma = 0, quant = 0, maiorNumeroDaLista = Integer.MIN_VALUE, menorNumeroDaLista = Integer.MAX_VALUE;
        System.out.println("Vamos analisar números!");
        while (true){
            System.out.print("Digite um número:");
            int numerosDigitados = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]");
            char continuarDigitandoNumeros = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuarDigitandoNumeros!='s' && continuarDigitandoNumeros!='n'){
                System.out.println("ERRO!Digite S para continuar e N parar parar!");
                System.out.print("Quer continuar?:");
                continuarDigitandoNumeros = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (numerosDigitados>0){
                soma+=numerosDigitados;
                quant++;
            }
            if (numerosDigitados>maiorNumeroDaLista){
                maiorNumeroDaLista=numerosDigitados;
            }
            if (numerosDigitados<menorNumeroDaLista){
                menorNumeroDaLista=numerosDigitados;
            }
            float mediaNumeros = (float) soma/quant;
            if (continuarDigitandoNumeros=='n'){
                System.out.printf("Total de números digitados:%d e a média:%.2f%n",quant,mediaNumeros);
                System.out.printf("Maior valor:%d e menor valor:%d%n",maiorNumeroDaLista,menorNumeroDaLista);
                break;
            }
        }
    }


    public static void jogoParOuImpar(Scanner scanner, Random random){
        System.out.println("Vamos jogar Par ou Impar");
        while (true){
            System.out.print("Digite um número:");
            int jogadorParOuImpar  = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite P para PAR ou I para IMPAR:");
            String opcaoParOuImpar = scanner.nextLine().trim().toLowerCase();
            while (!opcaoParOuImpar.equals("p")  && !opcaoParOuImpar.equals("i")){
                System.out.print("ERRO!!! Digite P para par ou I para impar:");
                opcaoParOuImpar = scanner.nextLine().trim().toLowerCase();
            }
            int jogadaComputador = random.nextInt(10)+1;
            int resultadoJogo  = jogadorParOuImpar+jogadaComputador;
            if (resultadoJogo %2==0 && opcaoParOuImpar.equals("p")){
                System.out.printf("Você escolheu %s = PAR, digitou %d e computador %d, VOCÊ VENCEU!!!%n",opcaoParOuImpar,jogadorParOuImpar,jogadaComputador);
            } else if (resultadoJogo%2==0 && opcaoParOuImpar.equals("i")) {
                System.out.printf("Você escolheu %s = PAR, digitou %d e computador %d, VOCÊ PERDEU!!!%n",opcaoParOuImpar,jogadorParOuImpar,jogadaComputador);
            }else if (resultadoJogo%2!=0 && opcaoParOuImpar.equals("i")){
                System.out.printf("Você escolheu %s = PAR, digitou %d e computador %d, VOCÊ VENCEU!!!%n",opcaoParOuImpar,jogadorParOuImpar,jogadaComputador);
            } else if (resultadoJogo%2!=0 && opcaoParOuImpar.equals("p")) {
                System.out.printf("Você escolheu %s = PAR, digitou %d e computador %d, VOCÊ PERDUE!!!%n", opcaoParOuImpar,jogadorParOuImpar,jogadaComputador);
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuarJogando = scanner.nextLine().trim().toLowerCase();
            while (!continuarJogando.equals("n") && !continuarJogando.equals("s")){
                System.out.print("ERRO. Digite S para continuar ou N para parar:");
                continuarJogando = scanner.nextLine().trim().toLowerCase();
            }
            if (continuarJogando.equals("n")){
                System.out.println("FINALIZANDO...");
                break;
            }
        }
    }


    public static void cadastroPessoas(Scanner scanner){
        System.out.println("Vamos cadastrar pessoas!");
        int cadastroHomens = 0;
        int cadastroMulheres20 = 0;
        int cadastroMaiorDeIdade = 0;
        while (true){
            System.out.print("Digite o nome:");
            String nomeCadastroPessoa = scanner.nextLine();
            System.out.print("Digite a idade:");
            int idadeCadastroPessoa = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o sexo da pessoa:");
            String sexoCadastroPessoa = scanner.nextLine().trim().toLowerCase();
            while (!sexoCadastroPessoa.equals("m") && !sexoCadastroPessoa.equals("f")){
                System.out.print("Erro, digite M ou F para cadastrar o sexo:");
                sexoCadastroPessoa = scanner.nextLine().trim().toLowerCase();
            }
            System.out.print("Quer cadastrar mais pessoas?[S/N]:");
            String cadastrarMaisPessoas = scanner.nextLine().trim().toLowerCase();
            while (!cadastrarMaisPessoas.equals("s") && !cadastrarMaisPessoas.equals("n")){
                System.out.print("ERRO! Digite S ou N para continuar ou não:");
                cadastrarMaisPessoas = scanner.nextLine().trim().toLowerCase();
            }
            if (idadeCadastroPessoa>=18){
                cadastroMaiorDeIdade++;
            }
            if (sexoCadastroPessoa.equals("m")){
                cadastroHomens++;
            }
            if (sexoCadastroPessoa.equals("f") && idadeCadastroPessoa<=20){
                cadastroMulheres20++;
            }
            if (cadastrarMaisPessoas.equals("n")){
                System.out.println("Pessoas maiores de idade:"+cadastroMaiorDeIdade);
                System.out.println("Homens cadastrados:"+cadastroHomens);
                System.out.println("Mulheres menos de 20 anos:"+cadastroMulheres20);
                break;
            }
        }


    }





    public static void analisandoCompras(Scanner scanner){
        System.out.println("Vamos analisar a sua compra!");
        float totalCompra = 0;
        int produtoMaisMil = 0;
        double menorValorProduto = Double.POSITIVE_INFINITY;
        String nomeMenorValorProduto = "";
        while (true){
            System.out.print("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine();
            System.out.print("Digite o valor do produto:");
            float valorProduto = scanner.nextFloat();
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")){
                System.out.print("ERRO! Quer continuar?[S/N]:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (valorProduto>0){
                totalCompra+=valorProduto;
            }
            if (valorProduto>=1000){
                produtoMaisMil++;
            }
            if (valorProduto<menorValorProduto){
                menorValorProduto=valorProduto;
                nomeMenorValorProduto = nomeProduto;
            }
            if (continuar.equals("n")){
                System.out.println("O total da compra foi:R$"+totalCompra);
                System.out.println("Produtos acima de R$1000: "+produtoMaisMil);
                System.out.println("Menor produto foi:"+nomeMenorValorProduto+"  e o valor:R$"+menorValorProduto);
                break;
            }
        }

    }

    public static void caixaEletronico(Scanner scanner){
        System.out.println("Vamos simular um caixa eletronico");
        System.out.print("Digite o valor que quer sacar:R$");
        int saque = scanner.nextInt();
        int totalced = 0;
        int ced = 50;
        int valor = saque;
        while (true){
            if (valor>=ced){
                valor-=ced;
                totalced++;
            }else {
                if (totalced>0){
                    System.out.println("Total de "+totalced+" de R$"+ced);
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


    public static void opcaoDePagamentoLoja(Scanner scanner){
        System.out.println("Vamos verificar opções de pagamento!");
        System.out.print("Digite o valor do produto:");
        float valorProduto = scanner.nextFloat();
        System.out.println("Escolha uma das opções de pagamento abaixo:");
        System.out.println("[ 1 ] À VISTA - Dinheiro ou cheque com 10% de desconto");
        System.out.println("[ 2 ] À VISTA - no cartão de débito com 5% de desconto");
        System.out.println("[ 3 ] Em 2x no cartão de crédito");
        System.out.println("[ 4 ] Em 3x no cartão de crédito com 20% de juros.");
        System.out.println("________________________________________________________");
        System.out.print("Digite uma das opções acima!:");
        int opcaoPagamento = scanner.nextInt();
        if (opcaoPagamento<=4){
            if (opcaoPagamento==1){
                float produtoCom10Desconto = valorProduto-(valorProduto*.10f);
                System.out.printf("O valor do produto com desconto de 10%% é:R$%.2f%n",produtoCom10Desconto);
            } else if (opcaoPagamento==2) {
                float produtoCom5Desconto = valorProduto-(valorProduto*0.05f);
                System.out.printf("O valor do produto com desconto de 5%% é:R$%.2f%n",produtoCom5Desconto);
            } else if (opcaoPagamento==3) {
                float produto2xNoCartao = valorProduto;
                System.out.printf("O valor do produto com parcelamento até 2x no cartão de crédito:R$%.2f%n",produto2xNoCartao);
            } else if (opcaoPagamento==4) {
                float cartao3xComJuros = valorProduto+(valorProduto*0.20f);
                System.out.printf("O valor do produto com parcelamento em 3x no cartão de crédito com 20%% de juros:R$%.2f%n",cartao3xComJuros);
            }
        }else {
            System.out.println("Opção inválida, digite uma das opções acima!");
            return;
        }
        System.out.println("______________________________________________________");


    }



    public static void jogoPedraPapelTesousa (Scanner scanner, Random random) throws InterruptedException {
        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("[ 1 ] PEDRA");
        System.out.println("[ 2 ] PAPEL");
        System.out.println("[ 3 ] TESOURA");
        System.out.print("Digite aqui a opção escolhida:");
        int jogador = scanner.nextInt();
        if (jogador>=4){
            System.out.println("OPÇÃO INVÁLIDA, TENTE NOVAMENTE!!!");
        }else {
            System.out.println("JO");
            Thread.sleep(1000);
            System.out.println("KEN");
            Thread.sleep(1000);
            System.out.println("PO");
            Thread.sleep(1000);
            int computador= random.nextInt(3)+1;
            System.out.println("----------------------");
            if (jogador==1){
                if (computador==1){
                    System.out.println("Você jogou:"+jogador+" e computador:"+computador+" EMPATE!");
                }else if (computador==2){
                    System.out.println("Você jogou:"+jogador+" e computador:"+computador+" VOCÊ PERDEU!");
                }else if (computador==3){
                    System.out.println("Você jogou:"+jogador+" e computador:"+computador+" VOCÊ VENCEU!");
                }
            }
            if (jogador==2){
                if (computador==1){
                    System.out.println("Você jogou:"+jogador+" e computador:"+computador+" VOCÊ VENCEU!");
                } else if (computador==2) {
                    System.out.println("Você jogou"+jogador+" e computador:"+computador+" EMPATE!");
                } else if (computador==3) {
                    System.out.println("Você jogou"+jogador+" e computador:"+computador+" VOCÊ PERDEU!");
                }
            }
            if (jogador==3){
                if (computador==1){
                    System.out.println("Você jogou:"+jogador+" e computador:"+computador+"VOCÊ PERDEU!");
                }else if (computador==2){
                    System.out.println("Você jogou:"+jogador+" e computador:"+computador+" VOCÊ VENCEU!");
                } else if (computador==3) {
                    System.out.println("Você jogou:"+jogador+" e computador:"+computador+" EMPATE!");
                }
            }
        }

    }
}

//public static void jogoPedraPapelTesousa(Scanner scanner, Random random) throws InterruptedException {
//    System.out.println("Escolha uma das opções abaixo:");
//    System.out.println("[ 1 ] PEDRA");
//    System.out.println("[ 2 ] PAPEL");
//    System.out.println("[ 3 ] TESOURA");
//    System.out.print("Digite aqui a opção escolhida: ");
//
//    int jogador = scanner.nextInt();
//
//    // Verifica se a opção do jogador é válida
//    if (jogador < 1 || jogador > 3) {
//        System.out.println("OPÇÃO INVÁLIDA, TENTE NOVAMENTE!!!");
//    } else {
//        // Contagem regressiva
//        System.out.println("JO");
//        Thread.sleep(1000);
//        System.out.println("KEN");
//        Thread.sleep(1000);
//        System.out.println("PO");
//        Thread.sleep(1000);
//
//        // Escolha aleatória do computador
//        int computador = random.nextInt(3) + 1;
//
//        // Exibe as jogadas
//        String jogadaJogador = obterJogada(jogador);
//        String jogadaComputador = obterJogada(computador);
//
//        System.out.println("----------------------");
//        System.out.println("Você jogou: " + jogadaJogador);
//        System.out.println("O computador jogou: " + jogadaComputador);
//
//        // Verifica o vencedor
//        if (jogador == computador) {
//            System.out.println("EMPATE!");
//        } else if ((jogador == 1 && computador == 3) || (jogador == 2 && computador == 1) || (jogador == 3 && computador == 2)) {
//            System.out.println("VOCÊ VENCEU!");
//        } else {
//            System.out.println("VOCÊ PERDEU!");
//        }
//    }
//}
//
////// Método para mapear a jogada do número (1, 2, 3) para a string (PEDRA, PAPEL, TESOURA)
//public static String obterJogada(int escolha) {
//    switch (escolha) {
//        case 1: return "PEDRA";
//        case 2: return "PAPEL";
//        case 3: return "TESOURA";
//        default: return "Opção inválida";
//    }
//}
//}