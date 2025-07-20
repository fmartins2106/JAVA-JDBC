package academy.devdojo.maratonajava.introducao;


import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.time.LocalDate;


public class Aula6ExercicioOperadoresCondicionais15 {
    public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

        //    jogo Jokenpo
        jogoJoKenPo(scanner,random);



        //    Numeros impares: soma e contagem
        somaEcontagemNumerosImpares(scanner);

//    Verificar o maior número
        maiorNumero(scanner);


        //    jogo par Ou impar
        jogoParOuImpar(scanner,random);


        //    analise de numeros digitado
        analiseDeNumeros(scanner);

        //    cadastro de pessoas
        cadastroDePessoas(scanner);

        // total compras e analise dos itens
        analisandoAcompra(scanner);

//    opções de pagamento!
        opcoesDePagamento(scanner);

//    fazendo tabuada
        tabuada(scanner);


        //caixa eletronico
        caixaEletronico(scanner);




        //    Verificar o maior número
        maiorNumero(scanner);




//    fazendo tabuada
        tabuada(scanner);





        scanner.close();

    }

    public static void opcoesDePagamento(Scanner scanner){
        System.out.println("Vamos verificar as opções de pagamento!");
        System.out.print("Digite o valor do produto:R$");
        float valorProdutoComprado = scanner.nextFloat();
        while (true){
            System.out.println("vamos as opções!");
            System.out.println("[ 1 ] À VISTA - Dinheiro ou cheque com 10%% de desconto.");
            System.out.println("[ 2 ] À VISTA - No cartão de débito com 5%% de desconto.");
            System.out.println("[ 3 ] PARCELADO - 2x no cartão de crédito.");
            System.out.println("[ 4 ] PARCELADO - Até 3x no cartão de crédito.");
            System.out.println("[ 5 ] SAIR");
            System.out.print("Digite uma das opções acima:");
            int opcoesDePagamento = scanner.nextInt();
            if (opcoesDePagamento == 5) { // Opção para sair do loop
                System.out.println("Obrigado por utilizar nosso sistema. Até logo!");
                break;
            }
            if (opcoesDePagamento <1 || opcoesDePagamento >=6){
                System.out.println("Opções inválida, tente novamente!!!");
                continue;
            }
            if (opcoesDePagamento==1){
                float opcao1 = valorProdutoComprado-(valorProdutoComprado*0.10f);
                System.out.printf("À vista com desconto de 10%%:R$%.2f%n",opcao1);
            } else if (opcoesDePagamento==2) {
                float opcao2 = valorProdutoComprado-(valorProdutoComprado*0.05f);
                System.out.printf("À vista com desconto de 5%%:R$%.2f%n",opcao2);
            }else if (opcoesDePagamento==3){
                float opcao3 = valorProdutoComprado;
                float parcelamento2x = valorProdutoComprado/2;
                System.out.printf("Valor em até 2xno cartão de crédito com parcelas de R$%.2f - valor total:R$%.2f%n",parcelamento2x,opcao3);
            } else if (opcoesDePagamento==4) {
                float opcao4 = valorProdutoComprado+(valorProdutoComprado*0.20f);
                float parcelamento3x = opcao4/3;
                System.out.printf("Valor em até 3x no no cartão de crédito com parcelas de R$%.2f -  valor total:R$%.2f%n",parcelamento3x,opcao4);
            }
        }
    }

    public static void jogoJoKenPo (Scanner scanner, Random random) throws InterruptedException {
        System.out.println("Vamos Jogar JO KEN PO!!!");
        System.out.println("[ 1 ] PEDRA");
        System.out.println("[ 2 ] PAPEL");
        System.out.println("[ 3 ] TEOSURA");
        System.out.print("Escolha uma das opções acima:");
        int jogador = scanner.nextInt();
        if (jogador < 1 || jogador >= 4) {
            System.out.println("OPÇÃO INVÁLIDA, jogue novamente!");
            return;
        } else {
            System.out.println("JO");
            Thread.sleep(1000);
            System.out.println("KEN");
            Thread.sleep(1000);
            System.out.println("PO!!!");
            Thread.sleep(1000);
            int computador = random.nextInt(3) + 1;
            if (jogador == computador) {
                System.out.println("Você escolheu " + jogador + " e computador" + computador + " DEU EMPATE!!!");
            } else if (jogador == 1 && computador == 3 || jogador == 2 && computador == 1 || jogador == 3 && computador == 2) {
                System.out.println("Você escolheu " + jogador + " e computador" + computador + " VOCÊ VENCEU!!!");
            } else {
                System.out.println("Você escolheu " + jogador + " e computador" + computador + " VOCÊ PERDEU!!!");
            }

        }

    }

    public static void somaEcontagemNumerosImpares(Scanner scanner){
        System.out.println("Vamos somar e contar os números impares");
        int contImpar = 0;
        int somaImpar = 0;
        for (int impar=1; impar<30; impar+=2){
            System.out.println(impar);
            if (impar%2!=0){
                contImpar++;
                somaImpar+=impar;
            }
        }
        System.out.println("De 1 a 30 tem:"+contImpar+" números impares");
        System.out.println("Somados:"+somaImpar);
    }




    public static void maiorNumero(Scanner scanner){
        int maiorNumeroInformado = Integer.MIN_VALUE;
        for (int n=0; n<3; n++){
            System.out.print("Digite o "+(n+1)+" número:");
            int numerosDigitados = scanner.nextInt();
            if (numerosDigitados>maiorNumeroInformado){
                maiorNumeroInformado = numerosDigitados;
            }
        }
        System.out.println("O maior número foi:"+maiorNumeroInformado);
    }

    public static void tabuada(Scanner scanner){
        System.out.println("Vamos calcular tabuadas!");
        while (true){
            System.out.print("Digite um número(-1 para parar):");
            int tabuada = scanner.nextInt();
            if (tabuada<=-1){
                System.out.println("FINALIZANDO....");
                break;
            }else {
                for (int i=0; i<=10; i++){
                    System.out.printf("%d x %d = %d%n", tabuada,i,tabuada*i);
                }
            }
        }

    }

    public static void analiseDeNumeros(Scanner scanner){
        System.out.println("Vamos analisar os números!");
        int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE, soma = 0, cont = 0;
        while (true){
            System.out.print("Digite um número:");
            int numeros = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.println("ERRO, Digite S ou N para continuar ou não!");
                System.out.print("Quer continuar?[S/N]:");
                continuar = scanner.nextLine().toLowerCase().trim();
            }
            if (numeros>0){
                soma+=numeros;
                cont++;
            }
            if (numeros>maior){
                maior = numeros;
            }
            if (numeros<menor){
                menor = numeros;
            }
            float media = (float) soma/cont;
            if (continuar.equals("n")){
                System.out.println("Total de números:"+cont+" e a média:"+String.format("%.2f",media));
                System.out.println("Maior valor:"+maior+" e menor valor:"+menor);
                break;
            }
        }

    }


    public static void jogoParOuImpar(Scanner scanner, Random random){
        System.out.println("Vamos jogar Par ou impar");
        while (true){
            System.out.print("Digite um número:");
            int jogador = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Escolhar P para par ou I para impar:");
            int computador = random.nextInt(10)+1;
            char parOuImpar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (parOuImpar !='p'  && parOuImpar !='i'){
                System.out.println("ERRO, digite P ou i !");
                System.out.print("Quer par ou impar?:");
                parOuImpar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            int resultado = jogador+computador;
            if (resultado%2==0 && parOuImpar=='p'){
                System.out.printf("Você escolheu %s=Par, digitou %d e computador %d = %d, você GANHOU!!!%n",parOuImpar,jogador,computador,resultado);
            } else if (resultado %2==0 && parOuImpar=='i') {
                System.out.printf("Você escolheu %s=Impar, digitou %d e computador %d = %d, Você PERDEU!!!%n", parOuImpar,jogador,computador,resultado);
            } else if (resultado %2 !=0 && parOuImpar=='i') {
                System.out.printf("Você escolheu %s=Impar, digitou %d e computador %d = %d, você GANHOU!!!%n",parOuImpar,jogador,computador,resultado);
            } else if (resultado %2 !=0 && parOuImpar=='p') {
                System.out.printf("Você escolheu %s=Par, digitou %d e computador %d = %d, você PERDEU !!!%n",parOuImpar,jogador,computador,resultado);

            }
            System.out.print("Quer continuar?[S/N]:");
            char continuarJogo = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuarJogo !='s' && continuarJogo !='n'){
                System.out.print("Erro, digite S ou N para continuar. Quer continuar?:");
                continuarJogo = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (continuarJogo =='n'){
                break;
            }
        }

    }


    public static void cadastroDePessoas(Scanner scanner){
        System.out.println("Vamos cadastrar pessoas!");
        int pessoasMaioresDeIdade = 0;
        int homensCadastrados = 0;
        int mnulhresMenos20 = 0;
        while (true){
            System.out.print("Digite o nome:");
            String nomeCadastrado = scanner.nextLine();
            System.out.print("Digite a idade:");
            int idadeCadastro = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o sexo[f/m]:");
            char sexoPessoa = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (sexoPessoa !='f' && sexoPessoa!='m'){
                System.out.println("ERRO! Digite F ou M para definir o sexo!");
                System.out.print("Sexo?:");
                sexoPessoa = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            System.out.print("Quer continuar?[S/N]:");
            char continuarCadastro = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuarCadastro !='s' && continuarCadastro!='n'){
                System.out.println("ERRO! Digite S para sim ou N para não!");
                System.out.print("Quer continuar?:");
                continuarCadastro = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (idadeCadastro>=18){
                pessoasMaioresDeIdade++;
            }
            if (sexoPessoa=='m'){
                homensCadastrados++;
            }
            if (sexoPessoa=='f' && idadeCadastro<=20){
                mnulhresMenos20++;
            }
            if (continuarCadastro=='n'){
                System.out.printf("Pessoas maiores de idade:%d%n",pessoasMaioresDeIdade);
                System.out.printf("Homens:%d%n",homensCadastrados);
                System.out.printf("Mulheres menos 20 anos:%d%n",mnulhresMenos20);
                break;
            }

        }
    }


    public static void analisandoAcompra(Scanner scanner){
        System.out.println("Vamos analisar as compras!");
        float totalCompra = 0;
        int acimaDeMil = 0;
        double menorValorProduto = Double.POSITIVE_INFINITY;
        String NomeProdutoMenorValor = "";
        while (true){
            System.out.print("Digite o nome do protudo:");
            String nomeProduto = scanner.nextLine();
            System.out.print("Digite o valor do produto:R$");
            float valor = scanner.nextFloat();
            scanner.nextLine();
            System.out.print("Quer adicionar outro produto?[S/N]:");
            String novoProduto = scanner.nextLine().trim().toLowerCase();
            while (!novoProduto.equals("s") && !novoProduto.equals("n")){
                System.out.print("ERRO! Digite S ou N:");
                novoProduto = scanner.nextLine().trim().toLowerCase();
            }
            if (valor>0){
                totalCompra+=valor;
            }
            if (valor>=1000){
                acimaDeMil++;
            }
            if (valor< menorValorProduto){
                menorValorProduto=valor;
                NomeProdutoMenorValor = nomeProduto;
            }
            if (novoProduto.equals("n")){
                System.out.printf("O total da compra:R$%.2f%n",totalCompra );
                System.out.printf("Produtos acima de R$1000: %d%n",acimaDeMil);
                System.out.printf("Menor produto:%s, valor:R$%.2f%n",NomeProdutoMenorValor,menorValorProduto);
                break;
            }
        }

    }



    public static void caixaEletronico(Scanner scanner){
        System.out.println("Vamos simular um caixa eletronico!");
        System.out.print("Quanto quer sacar?R$");
        int sacar = scanner.nextInt();
        int valor = sacar;
        int ced = 50;
        int totalced=0;
        while (true){
            if (sacar>=ced){
                sacar-=ced;
                totalced++;
            }else {
                if (totalced>0){
                    System.out.printf("Total de %d cédulas de R$%d%n",totalced,ced);
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
                    if (valor<=0) {
                        break;
                    }
                }
            }
        }
    }
}
