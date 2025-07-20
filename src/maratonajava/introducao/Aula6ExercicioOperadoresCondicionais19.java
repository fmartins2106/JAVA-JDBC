package academy.devdojo.maratonajava.introducao;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.time.LocalDate;
import java.util.logging.SocketHandler;

public class Aula6ExercicioOperadoresCondicionais19 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();



        //        jogo Pedra, Papel e Tesoura
        jogoJoKenPo(scanner,random);

        //        analisando opções de pagamento
        opcoesDePagamento(scanner);

//        analisando compras
        analisandoCompras(scanner);

        //        tabuada!
        calculandoTabuada(scanner);

        //        jogo par ou impar
        jogoParOuImpar(scanner,random);

        //        cadastro de pessoas
        cadastroDePessoas(scanner);

//        sorteio de um número
        sorteioUmNumero(scanner, random);

//        VERIFICANDO O MAIOR E O MENOR DA LISTA
        maiorEoMenorDaLista(scanner);

//        verificar maior Número
        maiorNumeroDaLista(scanner);

//        analisando números
        analisandoNumeros(scanner);

//        calculo maior e menor da lista
        maiorEmenorDaLista(scanner);

//        tabuada
        tabuada(scanner);

//        caixa eletronico
        caixaEletronico(scanner);

    }

    public static void sorteioUmNumero(Scanner scanner, Random random){
        ArrayList<Integer> lista = new ArrayList<>();
        System.out.println("Vamos sortear um número");
        while (true){
            int quantNumeros = -1;
            System.out.print("Quantos números você quer adicionar na lista?:");
            if (scanner.hasNextInt()){
                quantNumeros = scanner.nextInt();
                scanner.nextLine();
                if(quantNumeros<=0){
                    System.out.println("Digite um número maior que zero!");
                    continue;
                }
            }else {
                System.out.println("Digite um valor válido!!!");
                scanner.next();
                continue;
            }
            for (int n=0;n<quantNumeros;n++){
                int numerosDigitados = -1;
                while (true){
                    System.out.print("Digite o "+(n+1)+"º número da lista:");
                    if (scanner.hasNextInt()){
                        numerosDigitados = scanner.nextInt();
                        scanner.nextLine();
                        lista.add(numerosDigitados);
                        break;
                    }else {
                        System.out.println("Digite um número válido!");
                        scanner.next();
                    }
                }
            }
            int sorteandoNumero = random.nextInt(lista.size());
            int numeroSorteado = lista.get(sorteandoNumero);
            System.out.println("O número sorteado foi:"+numeroSorteado);

            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N!:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                System.out.println("Finalizando...");
                break;
            }
        }

    }

    public static void maiorEoMenorDaLista(Scanner scanner){
        int maiorValor = Integer.MIN_VALUE, menorValor = Integer.MAX_VALUE;
        for (int c=0;c<5;c++){
            int valorDigitado = -1;
            while (true){
                System.out.print("Digite o "+(c+1)+"º valor da lista:");
                if (scanner.hasNextInt()){
                    valorDigitado = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO! Digite um valor válido!!!");
                    scanner.next();
                }
            }
            if (valorDigitado>maiorValor){
                maiorValor=valorDigitado;
            }
            if (valorDigitado<menorValor){
                menorValor=valorDigitado;
            }
        }
        System.out.println("O maior da lista:"+maiorValor);
        System.out.println("O menor da lista:"+menorValor);
    }

    public static void calculandoTabuada(Scanner scanner){
        System.out.println("Vamos calcular tabuadas!");
        while (true){
            int tabuada = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    tabuada = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            if (tabuada<=-1){
                System.out.println("FINALIZANDO O PROGRAMA....");
                break;
            }else {
                for (int n=0;n<=10;n++){
                    System.out.printf("%d x %d = %d%n",tabuada,n,tabuada*n);
                }
            }
        }
    }



    public static void jogoJoKenPo(Scanner scanner, Random random) throws InterruptedException{
        while (true){
            int jogador = -1;
            System.out.println("vamos Jogor Jo Ken Po!!!");
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            while (true){
                System.out.print("Digite uma das opcões acima:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            if (jogador<=0 || jogador>=4){
                System.out.println("Digite um valor de 1 a 3!");
                continue;
            }
            System.out.println("JO");
            Thread.sleep(500);
            System.out.println("KEN");
            Thread.sleep(500);
            System.out.println("PO!!!");
            Thread.sleep(500);
            int computador = random.nextInt(3)+1;
            System.out.println("Computador:"+computador);
            if (jogador==computador){
                System.out.println("Você escolheu "+ jogador + " e computador escolheu "+computador+" DEU EMPATE!!!");
            } else if (jogador==1 && computador==3 || jogador==2 && computador==1 || jogador==3 && computador==2) {
                System.out.println("Você escolheu "+jogador+" e computador escolheu "+computador+" VOCÊ VENCEU!!!");
            }else {
                System.out.println("Você escolheu "+jogador+" e computador escolheu "+computador+" VOCÊ PERDEU!!!");
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                System.out.println(">>>>>>Finalizando Jogo...");
                break;
            }

        }

    }

    public static void maiorNumeroDaLista(Scanner scanner){
        System.out.println("Vamos verificar o maior número da lista!");
        int maiorNumero = Integer.MIN_VALUE;
        for (int n=0;n<5;n++){
            int numero = -1;
            while (true){
                System.out.print("Digite o "+(n+1)+"º número:");
                if (scanner.hasNextInt()){
                    numero= scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO!Digite um número válido!");
                    scanner.next();
                }
            }
            if (numero>maiorNumero){
                maiorNumero=numero;
            }
        }
        System.out.println("Maior número da lista:"+maiorNumero);
    }


    public static void jogoParOuImpar(Scanner scanner, Random random){
        System.out.println("Vamos Jogar Par ou Impar:");
        while (true){
            int jogador = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Valor incorreto! Digite novamente!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Digite P para Par ou I para impar:");
            char  parOuImpar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (parOuImpar!='p' && parOuImpar!='i'){
                System.out.print("Digite apenas P ou I!:");
                parOuImpar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            int computador = random.nextInt(10)+1;
            System.out.println("Computador="+computador);
            int resultado = jogador+computador;
            if (parOuImpar=='p' && resultado%2==0){
                System.out.printf("Você escolheu:%s=Par, digitou:%d e computador:%d - total:%d, você VENCEU!!!%n",parOuImpar,jogador,computador,resultado);
            }else if (parOuImpar=='p' && resultado%2!=0){
                System.out.printf("Você escolheu:%s=Par, digitou:%d e computador:%d - total:%d, você PERDEU!!!%n",parOuImpar,jogador,computador,resultado);
            } else if (parOuImpar=='i' && resultado%2==0) {
                System.out.printf("Você escolheu:%s=Impar, digitou:%d e computador:%d - total:%d, você PERDEU!!!%n",parOuImpar,jogador,computador,resultado);
            } else if (parOuImpar=='i' && resultado%2!=0) {
                System.out.printf("Você escolheu:%s=Impar, digitou:%d e computador:%d - total:%d, você VENCEU!!!");
            }
            System.out.print("Quer continuar?[S/N]:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='n' && continuar!='s'){
                System.out.print("ERRO! Digite S ou N para validar!:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);

            }
            if (continuar=='n'){
                System.out.println("FINALIZANDO PROGRAMA....");
                break;
            }
        }
    }


    public static void analisandoNumeros(Scanner scanner){
        System.out.println("Vamos analisar os números!");
        int soma = 0, cont = 0, maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        while (true){
            int numeros =-1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numeros = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um valor válido!");
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
            if (numeros>0){
                soma+=numeros;
                cont++;
            }
            if (numeros>maiorNumero){
                maiorNumero=numeros;
            }
            if (numeros<menorNumero){
                menorNumero=numeros;
            }
            float media = (float) soma/cont;
            if (continuar=='n'){
                System.out.println("Total de números:"+cont);
                System.out.println("Média:"+String.format("%.2f",media));
                System.out.println("Maior número:"+maiorNumero+" Menor número:"+menorNumero);
                break;
            }
        }


    }

    public static void cadastroDePessoas(Scanner scanner){
        System.out.println("Vamos cadastras pessoas");
        int maioresDeIdade=0, homens=0, mulheresMenos20 = 0;
        while (true){
            System.out.print("Digite o nome:");
            String nomePessoa = scanner.nextLine();
            System.out.print("Digite idade:");
            int idadePessoa = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Sexo?[f/m]:");
            String sexoPessoa = scanner.nextLine().trim().toLowerCase();
            while (!sexoPessoa.equals("f") && !sexoPessoa.equals("m")){
                System.out.print("Digite apenas F ou M:");
                sexoPessoa = scanner.nextLine().trim().toLowerCase();
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (idadePessoa>=18){
                maioresDeIdade++;
            }
            if (sexoPessoa.equals("m")){
                homens++;
            }
            if (idadePessoa<=20 && sexoPessoa.equals("f")){
                mulheresMenos20++;
            }
            if (continuar.equals("n")){
                System.out.println("Maior de idade:"+maioresDeIdade);
                System.out.println("Homens:"+homens);
                System.out.println("Mulhres menos 20 anos:"+mulheresMenos20);
                break;
            }
        }
    }

    public static void analisandoCompras(Scanner scanner){
        System.out.println("Vamos analisar as compras");
        double totalCompra = 0;
        int compraMaisMil = 0;
        double menorValor = Double.POSITIVE_INFINITY;
        String nomeMenorValor = "";
        while (true){
            System.out.print("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine();
            System.out.print("Digite o valor do produto:R$");
            double valorProduto = scanner.nextFloat();
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='s' && continuar!='n'){
                System.out.println("ERRO,Digite apenas S ou N!!");
                System.out.print("Quer continuar?:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (valorProduto>0){
                totalCompra+=valorProduto;

            }
            if (valorProduto>=1000){
                compraMaisMil++;
            }
            if (valorProduto<menorValor){
                menorValor=valorProduto;
                nomeMenorValor=nomeProduto;
            }
            if (continuar=='n'){
                System.out.println("Total da compra:R$"+String.format("%.2f",totalCompra));
                System.out.println("Compras acima de R$1000: "+compraMaisMil);
                System.out.println("Menor valor da compra foi: "+nomeMenorValor+" com valor de:R$"+String.format("%.2f",menorValor));
                break;
            }
        }
    }

    public static void opcoesDePagamento(Scanner scanner){
        System.out.println("Analisando as opções de pagamento!");
        while (true){
            System.out.println("Vamos as opções!");
            System.out.println("[ 1 ] À VISTA = Dinheiro oi cheque com 10% de desconto.");
            System.out.println("[ 2 ] À VISTA = No cartão de débito com 5% de desconto.");
            System.out.println("[ 3 ] PARCELADO = 2x no cartão de crédito.");
            System.out.println("[ 4 ] PARCELADO = 3x no cartão de crédito com 20% de juros.");
            System.out.println("[ 5 ] SAIR.");
            System.out.print("Digite uma das opções acima:");
            int opcoesDePagamento = scanner.nextInt();
            if (opcoesDePagamento<=0 || opcoesDePagamento>=6){
                System.out.println("ERRO! Digite um valor válidos!!!");
                continue;
            }
            if (opcoesDePagamento==5) {
                System.out.println("FINALIZANDO....");
                System.out.println(">>>>Volte sempre");
                break;
            }else {
                System.out.print("Digite o valor do produto:R$");
                float valorProduto = scanner.nextFloat();
                if (opcoesDePagamento==1){
                    float opcao1 = valorProduto-(valorProduto*0.10f);
                    System.out.println("Valor a vista com 10% de desconto:R$"+opcao1);
                } else if (opcoesDePagamento==2) {
                    float opcao2 = valorProduto-(valorProduto*0.05f);
                    System.out.print("Valor à vista com 5% de desconto:R$"+opcao2);
                }else if (opcoesDePagamento==3){
                    float opcao3 = valorProduto;
                    float parcelaOpcao3 = valorProduto/2;
                    System.out.println("Valor em 2x de R$:"+parcelaOpcao3+" - valor total de R$:"+opcao3);
                } else if (opcoesDePagamento==4) {
                    float opcao4 = valorProduto+(valorProduto*0.20f);
                    float parcelaOpcao4 = opcao4/3;
                    System.out.println("Valor em 3x de R$:"+parcelaOpcao4+" - valor total de R$:"+opcao4);
                }
            }
        }
    }

    public static void maiorEmenorDaLista(Scanner scanner){
        System.out.println("Vamos verificar o maior e o menor da lista!");
        int maiorLista = Integer.MIN_VALUE, menorLista = Integer.MAX_VALUE;
        for (int n=0;n<6;n++){
            int numeros = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numeros = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Valores errado!!!");
                    scanner.next();
                }
            }
            if (numeros>maiorLista){
                maiorLista=numeros;
            }
            if (numeros<menorLista){
                menorLista=numeros;
            }
        }
        System.out.println("O maior da lista:"+maiorLista);
        System.out.println("O menor da lista:"+menorLista);
    }

    public static void tabuada(Scanner scanner){
        System.out.println("Vamos calcular tabuadas!");
        while (true){
            System.out.print("Digite um número:");
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

    public static void caixaEletronico(Scanner scanner){
        System.out.println("Vamos simular um caixa eletrônico");
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



}
