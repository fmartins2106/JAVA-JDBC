package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.time.LocalDate;

public class Aula6ExercicioOperadoresCondicionais17 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //        jogo Pedra, Papel e Tesoura
        jogoJoKenPo(scanner,random);

//        verificar maior número
        maiorNumero(scanner);


//        jogo par ou impar
        jogoParOuImpar(scanner,random);


        //        analisando os números digitados
        analisandoNumerosDigitados(scanner);

        //        cadastrar pessoas
        cadastroDePessoas(scanner);

        //        analisando compra
        analisandoCompra(scanner);


        //        opções de pagamento
        opcoesDePagamento(scanner);




//        números impares
        numersoImpares(scanner);

//        vamos verificar o menor número
        menorNumero(scanner);

//        tabuada
        calcularTabuada(scanner);

//        caixa eletronico
        caixaEletronico(scanner);
        scanner.close();
    }

    public static void jogoJoKenPo(Scanner scanner, Random random) throws InterruptedException{
        System.out.println("Vamos jogar Jo Ken Po");
        while (true){
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            System.out.print("Digite uma das opções acima:");
            int jogador = scanner.nextInt();
            if (jogador<=0 || jogador>=4){
                System.out.println("ERRO! Digite um número inválido!!!");
                return;
            }else {
                int computador = random.nextInt(3)+1;
                System.out.println("JO");
                Thread.sleep(1000);
                System.out.println("KEN");
                Thread.sleep(1000);
                System.out.println("PO");
                Thread.sleep(1000);
                System.out.println("Computador:"+computador);
                if (jogador == computador){
                    System.out.println("Você jogou "+jogador+" e computador jogou "+computador+" DEU EMPATE!!!");
                }else if (jogador==1 && computador==3 || jogador==2 && computador==1 || jogador==3 && computador==2){
                    System.out.println("Você jogou "+jogador+" e computador jogou "+computador+" VOCÊ VENCEU!!!");
                }else {
                    System.out.println("Você jogou "+jogador+" e computador jogou "+computador+" VOCÊ PERDEU!!!");
                }
            }
            break;
        }
    }

    public static void numersoImpares(Scanner scanner){
        System.out.println("Vamos somar e contar números impares de 1 a 30");
        int somaImpar = 0;
        int contImpar = 0;
        for (int impar=1;impar<=30;impar+=2){
            System.out.println(impar);
            somaImpar+=impar;
            contImpar++;
        }
        System.out.println("De 1 a 30, temos "+contImpar+" números impares, somados tem o valor de:"+somaImpar);
    }



    public static void menorNumero(Scanner scanner) throws InterruptedException{
        System.out.println("Vamos verificar o menor número:");
        int menorNumero = Integer.MAX_VALUE;
        for (int n=0;n<3;n++){
            int numerosDaLista = -1;
            while (true){
                System.out.printf("Digite o %dºnúmero da lista:",n+1);
                if (scanner.hasNextInt()){
                    numerosDaLista = scanner.nextInt();
                    scanner.nextLine();
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            if (numerosDaLista<menorNumero){
                menorNumero=numerosDaLista;
            }
        }
        System.out.println("O menor número da lista é:"+menorNumero);

    }



    public static void maiorNumero(Scanner scanner) throws InterruptedException {
        System.out.println("Vamos verificar o maior número!");
        int maiorNumero = Integer.MIN_VALUE;
        for (int n=0;n<3;n++){
            int numero=-1;
            while (true){
                System.out.printf("Digite o %dº número da lista:",n+1);
                if (scanner.hasNextInt()){
                    numero  = scanner.nextInt();
                    scanner.nextLine();
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            if (numero>maiorNumero){
                maiorNumero=numero;
            }
        }
        System.out.println("O maior número foi:"+maiorNumero);
    }



    public static void jogoParOuImpar(Scanner scanner, Random random) throws InterruptedException {
        System.out.println("Vamos jogar Par ou Impar");
        while (true){
            int jogador = -1; // Atribui um valor inicial para a variável 'jogador'
            while (true){ // Um loop infinito que vai rodar até o usuário fornecer um número válido
                System.out.print("Digite um número:");  // Pede para o usuário digitar um número
                if (scanner.hasNextInt()){  // Verifica se o próximo valor inserido pelo usuário é um número inteiro
                    jogador = scanner.nextInt();  // Se for um número inteiro, armazena esse valor na variável 'jogador'
                    break; // Sai do loop porque agora temos uma entrada válida
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();   // Lê a entrada errada (para limpar o buffer de entrada), já que o 'hasNextInt' não consome o valor
                }
            }
            scanner.nextLine();
            System.out.print("Digite P para Para ou I para impar:");
            String ParOuImpar = scanner.nextLine().trim().toLowerCase();
            while (!ParOuImpar.equals("p") && !ParOuImpar.equals("i")){
                System.out.print("ERRO! Digite apenas P ou I:");
                ParOuImpar = scanner.nextLine().trim().toLowerCase();
            }
            int computador = random.nextInt(10)+1;
            System.out.println("Computador:"+computador);
            int resultado = jogador+computador;
            if (resultado%2==0 && ParOuImpar.equals("p")){
                System.out.printf("Você escolheu %s=PAR e digitou:%d e computador:%d = total %d. VOCÊ VENCEU!!!%n",ParOuImpar,jogador,computador,resultado);
            } else if (resultado % 2 ==0 && ParOuImpar.equals("i")) {
                System.out.printf("Você escolheu %s=IMPAR e digitou:%d e computador:%d = total %d. VOCÊ PERDEU!!!%n",ParOuImpar,jogador,computador,resultado);
            } else if (resultado % 2 !=0 && ParOuImpar.equals("i")) {
                System.out.printf("Você escolheu %s=IMPAR e digitou:%d e computador:%d = total %d. VOCÊ VENCEU!!!%n",ParOuImpar,jogador,computador,resultado);
            } else if (resultado % 2 !=0 && ParOuImpar.equals("p")) {
                System.out.printf("Você escolheu %s=PAR e digitou:%d e computador:%d = total %d. VOCÊ PERDEU!!!%n",ParOuImpar,jogador,computador,resultado);
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")){
                System.out.print("ERRO!Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                System.out.println("FINALIZANDO...");
                break;
            }

        }

    }


    public static void analisandoNumerosDigitados(Scanner scanner){
        System.out.println("Vamos analisar os números!");
        int soma = 0, quant = 0;
        int menorValor = Integer.MAX_VALUE, maiorValor = Integer.MIN_VALUE;
        while (true){
            System.out.print("Digite um número:");
            int numero = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")){
                System.out.print("ERRO! Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (numero>0){
                quant++;
                soma+=numero;
            }
            if (numero>maiorValor){
                maiorValor=numero;
            }
            if (numero<menorValor){
                menorValor=numero;
            }
            float mediaNumero = (float) soma/quant;
            if (continuar.equals("n")){
                System.out.printf("Total de números:%d e a média:%.2f%n",soma, mediaNumero);
                System.out.printf("Maior valor:%d e menor valor:%d%n",maiorValor,menorValor);
                break;
            }
        }
    }

    public static void cadastroDePessoas(Scanner scanner){
        System.out.println("Vamos fazer cadastro de pessoas!");
        int pessoasMaioresDeIdade = 0;
        int homensCadastrados = 0;
        int mulheresMais20 = 0;
        while (true){
            System.out.print("Digite o nome:");
            String nomePessoa = scanner.nextLine();
            System.out.print("Digite a idade:");
            int idadePessoa = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o sexo[F/M]:");
            char sexoPessoa = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (sexoPessoa !='f' && sexoPessoa !='m'){
                System.out.print("ERRO! Digite F ou M para sexo:");
                sexoPessoa = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            System.out.print("Quer continuar?[S//N]:");
            char continuarCadastro = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuarCadastro !='s'  && continuarCadastro !='n'){
                System.out.print("ERRO! Digite apenas S ou N:");
                continuarCadastro = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (idadePessoa>=18){
                pessoasMaioresDeIdade++;
            }
            if (sexoPessoa=='m'){
                homensCadastrados++;
            }
            if (sexoPessoa=='f' && idadePessoa<=20){
                mulheresMais20++;
            }
            if (continuarCadastro=='n'){
                System.out.printf("Maiores de idade:%d%n",pessoasMaioresDeIdade);
                System.out.printf("Homens:%d%n",homensCadastrados);
                System.out.printf("Mulheres menos 20 anos:%d%n",mulheresMais20);
                break;
            }
        }
    }


    public static void analisandoCompra(Scanner scanner){
        float totalCompra = 0;
        int produtosMaisMil = 0;
        double menorValorDeProduto = Double.POSITIVE_INFINITY;
        String nomeMenorValorProduto = "";
        while (true){
            System.out.print("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine();
            System.out.print("Digite o valor do produto:R$");
            float valorProduto = scanner.nextFloat();
            scanner.nextLine();
            System.out.print("Quer adicionar outro produto?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s")  && !continuar.equals("n")){
                System.out.print("ERRO! Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (valorProduto>0){
                totalCompra+=valorProduto;
            }
            if (valorProduto>=1000){
                produtosMaisMil++;
            }
            if (valorProduto<menorValorDeProduto){
                menorValorDeProduto=valorProduto;
                nomeMenorValorProduto=nomeProduto;
            }
            if (continuar.equals("n")){
                System.out.printf("O total da compra:R$%.2f%n",totalCompra);
                System.out.printf("Produto acima de R$1000:%d%n",produtosMaisMil);
                System.out.printf("Menor produto:%s com valor de R$%.2f%n",nomeMenorValorProduto,menorValorDeProduto);
                break;
            }
        }
    }


    public static void opcoesDePagamento(Scanner scanner){
        System.out.println("Vamos ver as opções de pagamento");
        while (true){
            System.out.print("Digite o valor do produto:R$");
            float valorProduto = scanner.nextFloat();
            System.out.println("Vamos as opções!");
            System.out.println("[ 1 ] À VISTA - Dinheiro ou cheque com 10%% de desconto.");
            System.out.println("[ 2 ] À VISTA - No cartão de débito com 5%% de desconto.");
            System.out.println("[ 3 ] PARCELADO - 2x no cartão de crédito.");
            System.out.println("[ 4 ] PARCELADO - 3x no cartão de crédito.");
            System.out.println("[ 5 ] SAIR");
            System.out.print("Digite uma das opções acima:");
            int opcoesDePagamento = scanner.nextInt();
            if (opcoesDePagamento<=0 || opcoesDePagamento>=6){
                System.out.println("VALOR INVÁLIDO. Digite um número de 1 a 5.");
            }else {
                if (opcoesDePagamento==1){
                    float opcao1 = valorProduto-(valorProduto*0.10f);
                    System.out.printf("Valor do produto com desconto de 10%% a vista é:R$%.2f%n",opcao1);
                } else if (opcoesDePagamento==2) {
                    float opcao2 = valorProduto-(valorProduto*0.05f);
                    System.out.printf("Valor do produto com desconto de 5%% a vista é:R$%.2f%n",opcao2);
                }else if (opcoesDePagamento==3){
                    float opcao3 = valorProduto/2;
                    System.out.printf("Valor do produto em 2 x de R$%.2f no cartão de crédito:R$%.2f%n",opcao3,valorProduto);
                } else if (opcoesDePagamento==4) {
                    float opcao4valor20Juros = valorProduto+(valorProduto*0.20f);
                    float opcao4 = opcao4valor20Juros/3;
                    System.out.printf("Valor do produto em 3x de R$%.2f no cartão de crédito:R$%.2f%n",opcao4,opcao4valor20Juros);
                }else {
                    System.out.println("FINALIZANDO PROGRAMA....");
                    break;
                }
            }
        }
    }

    public static void calcularTabuada(Scanner scanner){
        System.out.println("Vamos calcular tabuadas");
        while (true){
            System.out.print("Digite um número(-1 para parar):");
            int tabuada = scanner.nextInt();
            if (tabuada<=-1){
                System.out.println("FINALIZANDO....");
                break;
            }else {
                for (int t=0;t<=10;t++){
                    System.out.printf("%d x %d = %d%n",tabuada,t,tabuada*t);
                }
            }
        }
    }


    public static void caixaEletronico(Scanner scanner) {
        System.out.println("Vamos fazer um programa que simula um caixa eletrônico");
        System.out.print("Digite quanto quer sacar:R$");
        int saque = scanner.nextInt();
        int valor= saque;
        int totalced = 0;
        int ced = 50;
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
