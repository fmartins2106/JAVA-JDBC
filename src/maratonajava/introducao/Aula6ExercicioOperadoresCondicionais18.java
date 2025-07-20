package academy.devdojo.maratonajava.introducao;


import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;


public class Aula6ExercicioOperadoresCondicionais18 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner =new Scanner(System.in);
        Random random = new Random();

        //        jogo JoKenPo
        jogoJoKenPo(scanner,random);

        //analisando opções de pagamento
        analisandoOpcoesDePagamento(scanner);


        //        analisando a compra
        analisandoCompras(scanner);


        //        jogo par ou impar
        jogoParOuImpar(scanner, random);

        //        analisando números
        analisandoNumeros(scanner);




        //        maior numero da lista
        maiorNumeroDaLista(scanner);


//        cadastro de pessoas
        cadastroDePessoas(scanner);




//        maior e menor valor 2
        maiorEMenorValor2(scanner);

// maior e menor valor
        maiorEMenorValor(scanner);

//        maior numero da lista
        maiorNumeroDaLista2(scanner);

//     menor número da lista
        menorNumeroDaLista(scanner);


 //        menor numero da lista
        menorNumeroDaLista2(scanner);



//        tabuada
        tabuada(scanner);

//        caixa eletronico
        caixaEletronico(scanner);
        scanner.close();

    }

    public static void maiorEMenorValor2(Scanner scanner){
        System.out.println("Vamos verificar o maior e o menor valor!");
        int menorValor = Integer.MAX_VALUE, maiorValor = Integer.MIN_VALUE;
        for (int n=0;n<5;n++){
            int numero = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numero = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Valor Inválidos!");
                    scanner.next();
                }
            }
            if (numero>maiorValor){
                maiorValor=numero;
            }
            if (numero<menorValor){
                menorValor=numero;
            }
        }
        System.out.println("O maior valor:"+maiorValor);
        System.out.println("O menor valor:"+menorValor);
    }

    public static void maiorEMenorValor(Scanner scanner){
        int maiorValor = Integer.MIN_VALUE, menorValor = Integer.MAX_VALUE;
        for (int n=0;n<5;n++){
            int numero = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numero = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Valor inválido!");
                    scanner.next();
                }
            }
            if (numero>maiorValor){
                maiorValor=numero;
            }
            if (numero<menorValor){
                menorValor=numero;
            }
        }
        System.out.println("O maior número:"+maiorValor);
        System.out.println("O menor número:"+menorValor);
    }

    public static void maiorNumeroDaLista2(Scanner scanner){
        int maiorNumeroDaLista = Integer.MIN_VALUE;
        for (int n=0;n<3;n++){
            int numero = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numero = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um número inteiro!");
                    scanner.next();
                }
            }
            if (numero>maiorNumeroDaLista){
                maiorNumeroDaLista=numero;
            }
        }
        System.out.println("Maior número da lista:"+maiorNumeroDaLista);
    }


    public static void menorNumeroDaLista(Scanner scanner) {
        int menorNumeroDaLista = Integer.MAX_VALUE;
        for (int n=0;n<3;n++){
            int numero = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numero = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite  um número válido");
                    scanner.next();
                }
            }
            if (numero<menorNumeroDaLista){
                menorNumeroDaLista=numero;
            }
        }
        System.out.println("O menor número da lista:"+menorNumeroDaLista);
    }


//    public static void jogoJoKenPo2(Scanner scanner, Random random) throws InterruptedException {
//        System.out.println("Vamos jogar Jo Ken Po");
//        while (true) {
//            System.out.println("[ 1 ] PEDRA");
//            System.out.println("[ 2 ] PAPEL");
//            System.out.println("[ 3 ] TESOURA");
//            System.out.print("Digite uma das opções acima: ");
//
//            int jogador = scanner.nextInt();
//            scanner.nextLine(); // Limpa o buffer de entrada
//
//            // Validação de entrada
//            if (jogador <= 0 || jogador >= 4) {
//                System.out.println("Opção inválida. Tente novamente.");
//                continue; // Volta ao início do loop sem executar o resto do código
//            }
//
//            // Escolha do computador
//            int computador = random.nextInt(3) + 1;
//
//            // Simulação "Jo Ken Po"
//            System.out.println("JO");
//            Thread.sleep(1000);
//            System.out.println("KEN");
//            Thread.sleep(1000);
//            System.out.println("PO");
//            Thread.sleep(1000);
//
//            // Determina o resultado
//            if (jogador == computador) {
//                System.out.println("Empate! Você e o computador escolheram " + traduzirEscolha(jogador) + ".");
//            } else if ((jogador == 1 && computador == 3) ||
//                    (jogador == 2 && computador == 1) ||
//                    (jogador == 3 && computador == 2)) {
//                System.out.println("Você venceu! Você escolheu " + traduzirEscolha(jogador) +
//                        " e o computador escolheu " + traduzirEscolha(computador) + ".");
//            } else {
//                System.out.println("Você perdeu! Você escolheu " + traduzirEscolha(jogador) +
//                        " e o computador escolheu " + traduzirEscolha(computador) + ".");
//            }
//
//            // Perguntar se deseja continuar
//            System.out.print("Quer continuar? [S/N]: ");
//            String continuar = scanner.nextLine().trim().toLowerCase();
//
//            while (!continuar.equals("s") && !continuar.equals("n")) {
//                System.out.print("Entrada inválida. Digite apenas S ou N: ");
//                continuar = scanner.nextLine().trim().toLowerCase();
//            }
//
//            if (continuar.equals("n")) {
//                System.out.println("Encerrando o jogo. Obrigado por jogar!");
//                break; // Sai do loop e encerra o método
//            }
//        }
//    }
//
//    // Método auxiliar para traduzir escolhas
//    public static String traduzirEscolha(int escolha) {
//        switch (escolha) {
//            case 1: return "PEDRA";
//            case 2: return "PAPEL";
//            case 3: return "TESOURA";
//            default: return "DESCONHECIDO";
//        }
//    }





    public static void jogoJoKenPo(Scanner scanner, Random random) throws InterruptedException{
        System.out.println("Vamos jogar Jo Ken Po");
        while (true){
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            System.out.print("Digite uma das opções acima:");
            int jogador = scanner.nextInt();
            scanner.nextLine();
            if (jogador<=0 || jogador>=4){
                System.out.println("Digite uma opção válida");
                continue;
            }
            int computador = random.nextInt(3)+1;
            System.out.println("JO");
            Thread.sleep(100);
            System.out.println("KEN");
            Thread.sleep(100);
            System.out.println("PO!!!");
            Thread.sleep(100);
            System.out.println("Computador="+computador);
            if (jogador==computador){
                System.out.println("VOCÊ escolheu "+jogador+" e computador escolheu "+computador+" DEU EMPATE!!!");
            } else if (jogador==1 && computador==3 || jogador==2 && computador==1 || jogador==3 && computador==2) {
                System.out.println("VOCÊ escolheu "+jogador+" e computador escolheu "+computador+" VOCÊ VENCEU!!!");
            } else {
                System.out.println("VOCÊ escolheu "+jogador+" e computador escolheu "+computador+" VOCÊ PERDEU!!!");
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                System.out.println("Encerrando o jogo!!!");
                break;
            }
        }
    }




    public static void menorNumeroDaLista2 (Scanner scanner) {
        int menorNumero = Integer.MAX_VALUE;
        for (int n=0;n<3;n++){
            int numero=-1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numero = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            if (numero<menorNumero){
                menorNumero=numero;
            }
        }
        System.out.println("Menor número:"+menorNumero);
    }

    public static void maiorNumeroDaLista(Scanner scanner){
        int maiorNumero = Integer.MIN_VALUE;
        for (int n=0;n<3;n++){
            int numerosLista =-1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numerosLista = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            if (numerosLista>maiorNumero){
                maiorNumero=numerosLista;
            }
        }
        System.out.println("O maior número da lista:"+maiorNumero);
    }



    public static void jogoParOuImpar(Scanner scanner, Random random){
        System.out.println("Jogo Par ou Impar");
        while (true){
            int jogador=-1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Valor Inválido, tente novamente!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Digite P para PAR ou I para IMPAR:");
            char parOuImpar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (parOuImpar != 'p' && parOuImpar != 'i') {
                System.out.print("Digite apenas P ou I:");
                parOuImpar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (parOuImpar=='p' || parOuImpar=='i'){
                int computador = random.nextInt(10)+1;
                System.out.println("Computador:"+computador);
                int resultado = computador+jogador;
                if (resultado%2==0 && parOuImpar=='p'){
                    System.out.printf("Você escolheu: %s=Par, digitou:%d e computador:%d =%d -  VOCÊ VENCEU!!!%n",parOuImpar,jogador,computador,resultado);
                }else if (resultado%2==0 && parOuImpar=='i'){
                    System.out.printf("Você escolheu:%s=IMPAR, digitou:%d e computador:%d =%d - VOCÊ PERDEU!!!%n",parOuImpar,jogador,computador,resultado);
                } else if (resultado%2!=0 && parOuImpar=='i'){
                    System.out.printf("Você escolheu:%s=IMPAR, digitou:%d e computador:%d = %d - VOCÊ VENCEU!!!%n",parOuImpar,jogador,computador,resultado);
                } else if (resultado%2!=0 && parOuImpar=='p') {
                    System.out.printf("Você escolheu:%s=PAR, digitou:%d e computador:%d = %d - VOCÊ PERDEU!!!%n",parOuImpar,jogador,computador,resultado);
                }
                System.out.print("Quer continuar?[S/N]:");
                String continuar = scanner.nextLine().trim().toLowerCase();
                while (!continuar.equals("n") && !continuar.equals("s")){
                    System.out.print("Digite apenas S ou N:");
                    continuar = scanner.nextLine().trim().toLowerCase();
                }
                if (continuar.equals("n")){
                    break;
                }
            }

        }
    }



    public static void analisandoNumeros(Scanner scanner){
        System.out.println("Analisando Números");
        int soma = 0, cont = 0, menorValor = Integer.MAX_VALUE, maiorValor = Integer.MIN_VALUE;
        while (true){
            System.out.print("Digite um número:");
            int numeros = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().toLowerCase().trim();
            }
            if (numeros>0){
                soma+=numeros;
                cont++;

            }
            float media = (float) soma/cont;
            if (numeros>maiorValor){
                maiorValor=numeros;
            }
            if (numeros<menorValor){
                menorValor=numeros;
            }
            if (continuar.equals("n")){
                System.out.printf("Total de números:%d e a média:%.2f%n",soma,media);
                System.out.printf("Maior número:%d e menor número:%d%n",maiorValor,menorValor);
            }


        }
    }


    public static void cadastroDePessoas(Scanner scanner){
        System.out.println("Vamos cadastrar pessoas!");
        int maioresDeIdade = 0;
        int homens = 0;
        int mulheresMenos20 = 0;
        while (true){
            System.out.print("Digite o nome:");
            String nomePessoa = scanner.nextLine();
            System.out.print("Idade:");
            int idadePessoa = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o sexo [f/m]:");
            String sexoPessoa = scanner.nextLine().trim().toLowerCase();
            while (!sexoPessoa.equals("f") && !sexoPessoa.equals("m")){
                System.out.print("ERRO! Digite apenas F ou M:");
                sexoPessoa = scanner.nextLine().trim().toLowerCase();
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")){
                System.out.print("Digite somente S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (idadePessoa>=18){
                maioresDeIdade++;
            }
            if (sexoPessoa.equals("m")){
                homens++;
            }
            if (sexoPessoa.equals("f") && idadePessoa<=20){
                mulheresMenos20++;
            }
            if (continuar.equals("n")){
                System.out.printf("Maiores de idade:%d%n",maioresDeIdade);
                System.out.printf("Homens:%d%n",homens);
                System.out.printf("Mulheres menos 20 anos:%d%n",mulheresMenos20);
                break;
            }
        }


    }


    public static void analisandoCompras(Scanner scanner){
        System.out.println("Vamos analisar compras!");
        float totalCompra = 0;
        int produtoMaisMil = 0;
        double menorValorProduto = Double.POSITIVE_INFINITY;
        String nomeMenorProduto = "";
        while (true){
            System.out.print("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine();
            System.out.print("Digite o valor do produto:");
            int valorProduto = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='s' && continuar!='n'){
                System.out.print("ERRO!Digite S ou N!!!:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (valorProduto>0){
                totalCompra+=valorProduto;
            }
            if (valorProduto>=1000){
                produtoMaisMil++;
            }
            if (valorProduto<menorValorProduto){
                menorValorProduto=valorProduto;
                nomeMenorProduto=nomeProduto;
            }
            if (continuar=='n'){
                System.out.printf("O total da compra:R$%.2f%n",totalCompra);
                System.out.printf("Produtos acima de R$1000: %d%n",produtoMaisMil);
                System.out.printf("Menor produto:%s, valor R$%.2f%n", nomeMenorProduto,menorValorProduto);
                break;
            }
        }
    }




    public static void analisandoOpcoesDePagamento(Scanner scanner){
        System.out.println("Analisando opções de pagamento!");
        while (true){
            System.out.println("Vamos as opções!");
            System.out.println("[ 1 ] À VISTA - Dinheiro ou cheque com 10% de desconto");
            System.out.println("[ 2 ] À VISTA - No cartão de débito com 5% de desconto.");
            System.out.println("[ 3 ] PARCELADO - 2x no cartão de crédito.");
            System.out.println("[ 4 ] PARCELADO - 3x no cartão de crédito.");
            System.out.println("[ 5 ] SAIR");
            System.out.print("Digite uma das opções acima:");
            int opcoesDePagamento = scanner.nextInt();
            if (opcoesDePagamento<=-1 || opcoesDePagamento>=6){
                System.out.println("ERRO! Digite uma opção válida!");
                return;
            }
            if (opcoesDePagamento==5){
                System.out.println("Finalizando o programa!");
                break;
            }else {
                System.out.print("Digite o valor do produto:R$");
                float valorProduto = scanner.nextFloat();
                if (valorProduto>0){
                    if (opcoesDePagamento==1){
                        float opcao1 = valorProduto-(valorProduto*0.10f);
                        System.out.printf("Valor do produto com desconto de 10%% à vista é:R$%.2f%n",opcao1);
                    } else if (opcoesDePagamento==2) {
                        float opcao2 = valorProduto-(valorProduto*0.05f);
                        System.out.printf("Valor do produto com desconto de 5%% à vista é:R$%.2f%n",opcao2);
                    } else if (opcoesDePagamento==3) {
                        float opcao3 = valorProduto;
                        float opcao3Parcela = valorProduto/2;
                        System.out.printf("Valor do produto em 2x de R$%.2f com valor total de R$%.2f%n",opcao3Parcela,opcao3);
                    } else if (opcoesDePagamento==4) {
                        float opcao4 = valorProduto+(valorProduto*0.20f);
                        float opcao4Parcela = opcao4/3;
                        System.out.printf("Valor do produto em 3x de R$%.2f com valor total de R$%.2f%n",opcao4Parcela,opcao4);
                    }
                }
            }
        }
    }



    public static void tabuada(Scanner scanner) {
        System.out.println("Vamos calcular a tabuada!");
        while (true) {
            System.out.print("Digite um número:");
            int tabuada = scanner.nextInt();
            if (tabuada <= -1) {
                System.out.println("FINALIZANDO...");
                break;
            } else {
                for (int t = 0; t <= 10; t++) {
                    System.out.printf("%d x %d = %d%n", tabuada, t, tabuada * t);
                }
            }
        }
    }




    public static void caixaEletronico(Scanner scanner){
        System.out.println("Vamos simular um caixa eletronico!");
        System.out.print("Quanto quer sacar?:R$");
        int saque = scanner.nextInt();
        int valor = saque;
        int totalced = 0;
        int ced = 50;
        while (true){
            if (valor>=ced){
                valor-=ced;
                totalced++;
            }else {
                if (totalced>0){
                    System.out.printf("Total de %d cédulas de R$%d%n",totalced,ced);
                } if (ced==50){
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


