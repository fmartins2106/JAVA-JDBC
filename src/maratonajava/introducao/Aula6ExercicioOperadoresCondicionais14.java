package academy.devdojo.maratonajava.introducao;



import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.time.LocalDate;


public class Aula6ExercicioOperadoresCondicionais14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        vamos sortear a sequencia
        sortearSequencia(scanner);

//        vamos sortear um número
        sorteioNumero(scanner,random);

//        Calculo notas juizes
        NotasJuizes(scanner);

// soma numeros pares
        numerosPares(scanner);

//        tabuada usando o while
        tabuada(scanner);


// maior, menor quantidade e media dos numeros digitados
        numerosDigitados(scanner);

        //        jogo Par ou Impar
        jogoParOuImpar(scanner,random);


        // cadastro de pessoas
        cadastroDePessoas(scanner);


        //        analisar compras
        analisarCompras(scanner);


//        caixa eletronico
        simuladorCaixaEletronico(scanner);
        scanner.close();

    }

    public static void sortearSequencia(Scanner scanner){
        System.out.println("Vamos sortear a sequência de apresentação:");
        ArrayList<String> listaNomesPessoas = new ArrayList<>();
        System.out.print("Quantas pessoas vão participar do sorteio?:");
        int participacaoNoSorteio = scanner.nextInt();
        scanner.nextLine();
        for (int pessoa=0; pessoa<participacaoNoSorteio;pessoa++){
            System.out.print("Digite o nome da "+(pessoa+1)+"º pessoa:");
            String nomePessoasSorteio = scanner.nextLine().trim();
            nomePessoasSorteio = nomePessoasSorteio.substring(0,1).toUpperCase()+nomePessoasSorteio.substring(1).toLowerCase();
            listaNomesPessoas.add(nomePessoasSorteio);
        }
        Collections.shuffle(listaNomesPessoas);
        System.out.println("A sequeência de apresentação ficou:"+listaNomesPessoas);

    }

    public static void sorteioNumero(Scanner scanner,Random random){
        System.out.println("Vamos sortear um número!");
        ArrayList<Integer> listaSorteioNumero = new ArrayList<>();
        for (int n=0; n<6;n++){
            System.out.print("Digite o "+(n+1)+"º número:");
            int sorteioNumero = scanner.nextInt();
            listaSorteioNumero.add(sorteioNumero);
        }
        int sorteio = random.nextInt(listaSorteioNumero.size());
        int numeroSorteado = listaSorteioNumero.get(sorteio);
        System.out.println("O número sorteado foi:"+numeroSorteado);
    }


    public static void NotasJuizes(Scanner scanner){
        System.out.println("Vamos calcular as notas dos juizes!!");
        ArrayList<Float> listaNotasJuizes = new ArrayList<>();
        float somaNotasJuizes = 0;
        int totalNotasJuizes = 0;
        for (int j=0; j<6; j++){
            System.out.print("Digite o "+(j+1)+"º número:");
            float notasJuizes = scanner.nextInt();
            listaNotasJuizes.add(notasJuizes);
        }
        float maiorNumero = Collections.max(listaNotasJuizes);
        float menorNumero = Collections.min(listaNotasJuizes);
        listaNotasJuizes.remove(maiorNumero);
        listaNotasJuizes.remove(menorNumero);
        for (float notasJuizes : listaNotasJuizes){
            somaNotasJuizes+=notasJuizes;
            totalNotasJuizes++;
        }
        float mediaNotasJuizes = somaNotasJuizes/totalNotasJuizes;
        System.out.println("A sua suas notas tiviram média:"+mediaNotasJuizes);
    }


    public static void numerosPares(Scanner scanner){
        System.out.println("Vamos contar e somar os números pares!");
        int totalPar = 0;
        int somaPar = 0;
        for (int p=0; p<6; p++){
            System.out.print("Digite o "+(p+1)+"º número:");
            int numerosDaLista = scanner.nextInt();
            if (numerosDaLista %2==0){
                totalPar++;
                somaPar+=numerosDaLista;
            }
        }
        System.out.println("O total de número pares é: "+totalPar+" e a soma dos números pares é:"+somaPar);
    }

    public static void tabuada(Scanner scanner){
        while (true){
            System.out.print("Digite um número:");
            int tabuada = scanner.nextInt();
            if (tabuada<=-1){
                System.out.println("FINALIZANDO....");
                break;
            } else {
                for (int i=0; i<=10; i++){
                    System.out.printf("%d x %d = %d%n",tabuada,i,tabuada*i);
                }
            }
        }
    }

    public static void numerosDigitados(Scanner scanner){
        System.out.println("Vamos verificar os números!");
        int soma = 0, menorNumero = Integer.MAX_VALUE, maiorNumero = Integer.MIN_VALUE, cont = 0;
        while (true){
            System.out.print("Digite um número:");
            int numeros = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            String continuarLeitura = scanner.nextLine().trim().toLowerCase();
            while (!continuarLeitura.equals("s") && !continuarLeitura.equals("n")){
                System.out.print("ERRO, digite S ou N. Quer continuar?[S/N]:");
                continuarLeitura = scanner.nextLine().trim().toLowerCase();
            }
            if (numeros>0){
                soma+=numeros;
                cont++;
            }
            if (numeros>maiorNumero){
                maiorNumero=numeros;
            }
            if (numeros< menorNumero){
                menorNumero=numeros;
            }
            float media = soma/cont;
            if (continuarLeitura.equals("n")){
                System.out.println("Total de números:"+cont+" e média:"+String.format("%.2f",media));
                System.out.println("Maior valor:"+maiorNumero+" e o Menor valor:"+menorNumero);
                break;
            }
        }
    }


    public static void jogoParOuImpar(Scanner scanner, Random random) {
        System.out.println("Vamos fazer o jogo do Par ou Impar!");
        while (true) {
            System.out.print("Digite um número:");
            int jogador = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite P para par ou I para impar:");
            String parOuImpar = scanner.nextLine().trim().toLowerCase();
            while (!parOuImpar.equals("p") && !parOuImpar.equals("i")) {
                System.out.println("ERRO! digite P ou I !");
                System.out.print("Digite P para par ou I para impar:");
                parOuImpar = scanner.nextLine().trim().toLowerCase();
            }
            int computador = random.nextInt(10) + 1;
            int resultado = jogador + computador;
            if (resultado % 2 == 0 && parOuImpar.equals("p")) {
                System.out.printf("Você escolheu %s e digitou:%d, computador escolheu %d, total=%d, VOCÊ VENCEU!%n", parOuImpar, jogador, computador, resultado);
            } else if (resultado % 2 == 0 && parOuImpar.equals("i")) {
                System.out.printf("Você escolheu %s e digitou:%d, computador escolheu %d, total=%d, VOCÊ PERDEU!%n", parOuImpar, jogador, computador, resultado);
            } else if (resultado % 2 != 0 && parOuImpar.equals("i")) {
                System.out.printf("Você escolheu %s e digitou:%d, computador escolheu %d, total=%d, VOCÊ VENCEU!%n", parOuImpar, jogador, computador, resultado);
            } else if (resultado % 2 != 0 && parOuImpar.equals("p")) {
                System.out.printf("Você escolheu %s e digitou:%d, computador escolheu %d, total=%d, VOCÊ PERDEU!%n", parOuImpar, jogador, computador, resultado);
            }
            System.out.print("Quer jogar novamente?[S/N]:");
            String jogarNovamente = scanner.nextLine().trim().toLowerCase();
            while (!jogarNovamente.equals("s") && !jogarNovamente.equals("n")) {
                System.out.println("ERRO! Digite S ou N para continuar!");
                System.out.print("Digite S ou N:");
                jogarNovamente = scanner.nextLine();
            }
            if (jogarNovamente.equals("n")){
                break;
            }

        }
    }


    public static void cadastroDePessoas(Scanner scanner){
        System.out.println("Vamos cadastrar pessoas!");
        int Homens = 0;
        int mulheresMenos20 = 0;
        int maioresDe18 = 0;
        while (true){
            System.out.print("Digite o nome:");
            String nomePessoa = scanner.nextLine();
            System.out.print("Digite a idade:");
            int idadePessoa = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o sexo da pessoa[F/M]:");
            String sexoPessoa = scanner.nextLine().trim().toLowerCase();
            while (!sexoPessoa.equals("f") && !sexoPessoa.equals("m")){
                System.out.println("ERRO! Digite F ou M para o sexo.");
                System.out.print("Qual o sexo?:");
                sexoPessoa = scanner.nextLine().trim().toLowerCase();
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuarCadastro = scanner.nextLine().trim().toLowerCase();
            while (!continuarCadastro.equals("s") && !continuarCadastro.equals("n")){
                System.out.print("ERRO! Digite S ou N para continuar!, Quer continuar?:");
                continuarCadastro = scanner.nextLine().trim().toLowerCase();
            }
            if (idadePessoa>=18){
                maioresDe18++;
            }
            if (idadePessoa<=20 && sexoPessoa.equals("f")){
                mulheresMenos20++;
            }
            if (sexoPessoa.equals("m")){
                Homens++;
            }
            if (continuarCadastro.equals("n")){
                System.out.printf("Pessoas Maiores de idade:%d%n",maioresDe18);
                System.out.printf("Homens:%d%n",Homens);
                System.out.printf("Mulheres menos de 20:%d%n",mulheresMenos20);
                break;
            }
        }

    }


    public static void analisarCompras(Scanner scanner) {
        int totalCompra = 0;
        double menorProdutoComprado = Double.POSITIVE_INFINITY;
        String  nomeMenorProdutoComprado = "";
        int valorMaisMil = 0;
        System.out.println("Vamos analisar as compras.");
        while (true){
            System.out.print("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine();
            System.out.print("Digite o valor do produto:R$");
            double valorProduto = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Quer adicionar outro produto?[S/N]:");
            String adicionarProduto = scanner.nextLine().trim().toLowerCase();
            while (!adicionarProduto.equals("s") && !adicionarProduto.equals("n")){
                System.out.print("ERRO, Digite S ou N para continuar!. Quer continuar?:");
                adicionarProduto = scanner.nextLine().trim().toLowerCase();
            }
            if (valorProduto>0){
                totalCompra++;
            }
            if (valorProduto>=1000){
                valorMaisMil++;
            }
            if (valorProduto< menorProdutoComprado){
                menorProdutoComprado=valorProduto;
                nomeMenorProdutoComprado=nomeProduto;
            }
            if (adicionarProduto.equals("n")){
                System.out.printf("O total da compra:%d%n",totalCompra);
                System.out.printf("Produtos acima de R$1000: %d%n",valorMaisMil);
                System.out.printf("Menor produto:%s, valor:R$%.2f%n",nomeMenorProdutoComprado,menorProdutoComprado);
                break;
            }
        }



    }

    public static void simuladorCaixaEletronico(Scanner scanner) {
        System.out.println("Vamos simular um caixa eletrônico");
        System.out.print("Quanto quer sacar?:R$");
        int saque  = scanner.nextInt();
        int valor = saque;
        int ced = 50;
        int totalCed = 0;
        while (true){
            if (valor>=ced){
                valor-=ced;
                totalCed++;
            }else{
                System.out.printf("Total de %d cédulas de R$%d%n",totalCed,ced);
                if (ced==50){
                    ced=20;
                } else if (ced==20) {
                    ced=10;
                } else if (ced==10) {
                    ced=5;
                } else if (ced==5) {
                    ced=1;
                }
                totalCed=0;
                if (valor<=0){
                    break;
                }
            }
        }

    }

}
