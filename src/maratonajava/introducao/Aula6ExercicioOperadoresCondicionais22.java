package academy.devdojo.maratonajava.introducao;







import java.util.*;
import java.time.LocalDate;


public class Aula6ExercicioOperadoresCondicionais22 {
    public static void main(String[] args) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        jogo par ou impar
        jogoParImpar(scanner,random);

// verificando opções de comida
        opcoesDeComida(scanner);

//        avaliando notas
        avalindoNotas(scanner);

//        verificando o seu nome
        verificandoNome(scanner);


//        analisando as vogais da palavras
        vogaisPalavras();

//        frase com letra A
        fraseLetraA(scanner);

//        verificando notas Juizes, colocando no Arrays
        notaCompeticaoJuizes(scanner);

//        letras A na frase
        letrasAnaFrase(scanner);

//analisando nome
        analisandoNome(scanner);

//        verificando quantas Letras A tem na frase
        analisandoFrase(scanner);

//        analisando vogais das palavras
        analisandoVogais();

        // jogo par ou impar
        jogoParOuImpar(scanner, random);

//        analisando compras
        analisandoCompras(scanner);

//        jogo pedra, papel e tesoura
        jogoPedraPapelTesoura(scanner, random);

//        analisando os numeros
        analisandoNumeros(scanner);

//        cadastro pessoas
        cadastroPessoas(scanner);

//        analisando pagamentos
        analisandoPagamentos(scanner);

//analisando a maior e a menor nota
        maiorEmenorNota(scanner);

//        sorteando sequencia de apresentação
        sequenciaApresentacao(scanner);

//        sorteando uma pessoa
        sorteandoPessoa(scanner,random);

//        sorteando numeros
        sorteandoNumeros(scanner, random);

//        analisando notas juizes, eliminar a maior e a menor nota, e fazer média
        notasJuizes(scanner);

//        tabuada
        calculandoTabuada(scanner);

//        caixa eletronico
        caixaEletronico(scanner);

        scanner.close();
    }

    public static void jogoParImpar(Scanner scanner, Random random) throws InterruptedException{
        while (true){
            int jogador = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    break;
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();
            System.out.print("Digite P para PAR ou I para IMPAR:");
            String parOuImpar = scanner.nextLine().toLowerCase().trim();
            while (!parOuImpar.equals("p") && !parOuImpar.equals("i")){
                System.out.print("Digite apenas P ou I:");
                parOuImpar = scanner.nextLine().trim().toLowerCase();
            }
            int computador = random.nextInt(10)+1;
            System.out.println("PROCESSANDO....");
            Thread.sleep(1000);
            System.out.println("Computador:"+computador);
            int resultado = jogador+computador;
            if (resultado%2==0 && parOuImpar.equals("p")){
                System.out.println("JOGADOR escolheu: "+resultadoParImpar(parOuImpar)+" e Digitou:"+jogador+" | computado:"+computador+" | resultado:"+resultado+"| VOCÊ VENCEU!!!");
            }else if (resultado%2==0 && parOuImpar.equals("i")){
                System.out.println("JOGADOR escolheu: "+resultadoParImpar(parOuImpar)+" e Digitou:"+jogador+" | computador:"+computador+" | resultado:"+resultado+" | VOCÊ PERDEU!!!");
            }else if (resultado%2!=0 && parOuImpar.equals("p")){
                System.out.println("JOGADOR escolheu:"+resultadoParImpar(parOuImpar)+" e Digitou:"+jogador+" | computador:"+computador+" | resultado:"+resultado+" | VOCê PERDEU!!!");
            } else if (resultado%2!=0 && parOuImpar.equals("i")) {
                System.out.println("JOGADOR escolheu:"+resultadoParImpar(parOuImpar)+" e Digitou:"+jogador+" | computador:"+computador+" | resultado:;"+resultado+" | VOCÊ VENCEU!!!");
            }
            System.out.print("Quer continuar?");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                System.out.println(">>>>FINALIZANDO O JOGO....");
                break;
            }
        }
    }
    public static String resultadoParImpar(String escolha){
        switch(escolha){
            case "p": return "PAR";
            case "I": return "IMPAR";
        }
        return "";
    }



    public static void opcoesDeComida(Scanner scanner) {
        while (true) {
            System.out.println("Escolha uma das opções abaixo");
            System.out.println("[ 1 ] - fastfood");
            System.out.println("[ 2 ] - comida brasileira");
            System.out.println("[ 3 ] - comida orienta");
            int opcoes = 0;
            while (true) {
                System.out.print("Digite aqui uma das opções acima:");
                if (scanner.hasNextInt()) {
                    opcoes = scanner.nextInt();
                    break;
                } else {
                    System.out.println("ERRO! Digite um número válido!");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();
            if (opcoes==1){
                System.out.println(comidasDoMundo(opcoes));
            } else if (opcoes==2) {
                System.out.println(comidasDoMundo(opcoes));
            }else if (opcoes==3){
                System.out.println(comidasDoMundo(opcoes));
            }else {
                System.out.println("Opção inválida!!!");
            }
            System.out.print("Quer continuar?:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='n' && continuar!='s'){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (continuar=='n'){
                break;
            }

        }
    }
    public static String comidasDoMundo(int escolha){
        switch (escolha){
            case 1: return "FastFood não é saudavel, tente comer melhor!";
            case 2: return "Comida brasileira é a melhor opção!";
            case 3: return "Comida oriental é saudável, mas tome cuidado com o preparo de comidas cruas.";
            default:return "Opção inválida!!!";
        }
    }



    public static void avalindoNotas(Scanner scanner){
        float[] notasJuizes  = new float[6];
        for (int n=0;n<6;n++){
            System.out.print("Digite a "+(n+1)+"º nota:");
            notasJuizes[n] = scanner.nextFloat();
        }
        System.out.println("A primeira nota foi"+notasJuizes[0]);
        System.out.println("A terceira nota foi:"+notasJuizes[2]);
        System.out.println("A sexta nota foi:"+notasJuizes[5]);
        System.out.println("todas a notas:"+Arrays.toString(notasJuizes));
        System.out.println("Lista em ordem crescente:"+Arrays.toString(notasJuizes));



    }

    public static void verificandoNome(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine().trim();
        String[] nome = nomeCompleto.split(" ");
        System.out.println("Seu primeiro nome:"+nome[0]);
        System.out.println("Seu último nome:"+nome[nome.length-1]);
        System.out.println("Seu nome em letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("Seu nome em letras maiusculas:"+nomeCompleto.toUpperCase());
        System.out.println("Seu primeiro nome tem:"+nome[0].length()+" letras");
        System.out.println("Seu último nome tem:"+nome[nome.length-1].length()+" letras");
        System.out.println("Seu nome completo tem:"+nomeCompleto.replace(" ","").length());
    }


    public static void vogaisPalavras(){
        String[] listaFrutas = {"banana","cacau","laranja","pera","uva","tangerina"};
        for (String fruta : listaFrutas){
            System.out.print("\nNa palavra: "+fruta+" temos as vogais:");
            for (char vogais : fruta.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(vogais))!=-1){
                    System.out.print(vogais+" ");
                }
            }
        }
    }


    public static void fraseLetraA(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim();
        for (int n=0;n<frase.length();n++){
            if (frase.charAt(n)=='a'){
                contagem++;
            }
        }
        System.out.println("Na frase:"+frase+" a letra A apareceu:"+contagem+"x");
        int primeiroA = frase.indexOf("a");
        if (primeiroA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
        }else {
            System.out.println("Não teve letra A nesta frase!");
        }
        int ultimoA = frase.lastIndexOf("a");
        if (ultimoA>0){
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
        }else {
            System.out.println("Não teve letra A nesta frase!");
        }
    }

    public static void notaCompeticaoJuizes(Scanner scanner){
        float[] arraysNotas = new float[6];
        for (int n=0;n<6;n++){
            while (true){
                System.out.print("Digite a "+(n+1)+"º nota dos juizes:");
                if (scanner.hasNextFloat()){
                    arraysNotas[n] = scanner.nextFloat();
                    break;
                }else {
                    System.out.println("ERRO!!! Digite um valor verdadeiro!");
                    scanner.nextLine();
                }
            }

        }
        System.out.println("A nota do primeiro juiz foi:"+arraysNotas[0]);
        System.out.println("A nota do último juiz foi:"+arraysNotas[arraysNotas.length-1]);
        System.out.println("As notas dos juizes foram:"+Arrays.toString(arraysNotas));


    }

    public static void letrasAnaFrase(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        for (int n=0;n<frase.length();n++){
            if (frase.charAt(n)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A aparceu na frase "+frase+":"+contagem+"x");
        int primeiroA = frase.indexOf("a");
        if (primeiroA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
        }else {
            System.out.println("A letra não apareceu na frase!");
        }
        int ultimoA = frase.lastIndexOf("a");
        if (ultimoA>0){
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu na frase!");
        }
    }

    public static void analisandoNome (Scanner scanner){
        System.out.print("Digite o seu nome:");
        String nome = scanner.nextLine().trim();
        String[] arrayNome = nome.split(" ");
        System.out.println("Seu nome em letras minusculas"+nome.toLowerCase());
        System.out.println("Seu nome em letras maiusculas:"+nome.toUpperCase());
        System.out.println("Seu primeiro nome:"+arrayNome[0]);
        System.out.println("Seu último nome:"+arrayNome[arrayNome.length-1]);
        System.out.println("Seu primeiro nome tem:"+arrayNome[0].length()+" letras");
        System.out.println("Seu último nome tem:"+arrayNome[arrayNome.length-1].length()+" letras");
        System.out.println("Seu nome total tem:"+nome.replace(" ","").length()+" letras");
    }

    public static void analisandoFrase(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim();
        for (int n=0;n<frase.length();n++){
            if (frase.charAt(n)=='a'){
                contagem++;
            }
        }
        System.out.println("Na frase:"+frase+", temos:"+contagem+" vezes");
        int primeiroA = frase.indexOf("a");
        if (primeiroA>0){
            System.out.println("A letra A apareceu na frase na posição:"+primeiroA);
        }else{
            System.out.println("A letra A não apareceu na frase!");
        }
        int ultimoA = frase.lastIndexOf("a");
        if (ultimoA>0){
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu na frase!");
        }
    }


    public static void analisandoVogais (){
        System.out.println("Vamos analisar as vogais!");
        String[] listaNomes = {"maria","joana","fernando","pedro","ana"};
        for (String nome : listaNomes){
            System.out.print("\nNo nome "+nome+" temos as vogais:");
            for (char letras : nome.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(letras))!=-1){
                    System.out.print(letras+" ");
                }
            }
        }
    }

    public static void jogoParOuImpar(Scanner scanner, Random random) throws InterruptedException{
        System.out.println("Vamos Jogar Par ou Impar!");
        while (true){
            int jogador = 0;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO! Digite um valor válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Digete P para PAR e I para IMPAR:");
            String parOuImpar = scanner.nextLine().trim().toLowerCase();
            while (!parOuImpar.equals("p") && !parOuImpar.equals("i")){
                System.out.print("Digite apenas P ou I:");
                parOuImpar = scanner.nextLine().trim().toLowerCase();
            }
            System.out.println("PROCESSANDO....");
            Thread.sleep(1000);
            int computado = random.nextInt(10)+1;
            System.out.println("Computador:"+computado);
            int resultado = computado+jogador;
            if (parOuImpar.equals("p") && resultado%2==0){
                System.out.println("Jogador:"+parImpar(String.valueOf(parOuImpar))+", jogou:"+jogador+" e computador:"+computado+ " | resultado:"+resultado+" | VOCÊ VENCEU!!!");
            } else if (parOuImpar.equals("p") && resultado%2!=0) {
                System.out.println("Jogador:"+parImpar(String.valueOf(parOuImpar))+", jogou:"+jogador+" e computador:"+computado+" | resultado:"+resultado+" | VOCÊ PERDEU!!!");
            } else if (parOuImpar.equals("i") && resultado%2!=0) {
                System.out.println("Jogador:"+parImpar(String.valueOf(parOuImpar))+", jogou:"+jogador+" e computador:"+computado+" | resultado:"+resultado+" | VOCÊ VENCEU!!!");
            }else if (parOuImpar.equals("i") && resultado%2==0){
                System.out.println("Jogador:"+parImpar(String.valueOf(parOuImpar))+", jogou:"+jogador+" e computador:"+computado+" | resultado:"+resultado+" | VOCÊ PERDEU!!!");
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                System.out.println("FINALIZANDO O PROGRAMA....");
                break;
            }


        }

    }

    public static String parImpar (String escolha){
        switch (escolha){
            case "p": return "PAR";
            case "i": return "IMPAR";
        }
        return "";
    }

    public static void analisandoCompras(Scanner scanner){
        System.out.println("Vamos analisar compras!");
        float totalCompras = 0, produtosMaisMil = 0, menorValor = Float.POSITIVE_INFINITY;
        String nomeProdutoMenorValor = "";
        while (true){
            System.out.print("Digite o nome do produto:");
            String nomeProduto = scanner.nextLine().trim().toUpperCase();
            float valorProduto = 0;
            while (true){
                System.out.print("Valor do produto:R$");
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
            while (continuar!='n' && continuar!='s'){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (valorProduto>0){
                totalCompras+=valorProduto;
            }
            if (valorProduto>=1000){
                produtosMaisMil++;
            }
            if (valorProduto<menorValor){
                menorValor=valorProduto;
                nomeProdutoMenorValor=nomeProduto;
            }
            if (continuar=='n'){
                System.out.println("Total da compra:"+String.format("%.2f",totalCompras));
                System.out.println("Produtos com valor acima de R$1000:"+produtosMaisMil);
                System.out.println("Produto com menor valor:"+nomeProdutoMenorValor+"|R$"+menorValor);
            }

        }

    }

    public static void jogoPedraPapelTesoura(Scanner scanner, Random random) throws InterruptedException{
        System.out.println("Vamos jogar Pedra, Papel e tesoura");
        while (true){
            System.out.println("[ 1 ] PEDRA");
            System.out.println("[ 2 ] PAPEL");
            System.out.println("[ 3 ] TESOURA");
            int jogador = 0;
            while (true){
                System.out.print("Digite uma das opções acima:");
                if (scanner.hasNextInt()){
                    jogador = scanner.nextInt();
                    break;
                }else{
                    System.out.println("ERRO! Digite uma opção válida!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            if (jogador<=0 || jogador>=4){
                System.out.println("Digite uma opção válida!");
                continue;
            }
            System.out.println("PROCESSANDO....");
            Thread.sleep(1000);
            int computador = random.nextInt(3)+1;
            System.out.println("Computador:"+computador);
            if (jogador==computador){
                System.out.println("Jogador:"+jogoJoKenPo(jogador)+" e computado:"+jogoJoKenPo(computador)+" - DEU EMPATE!!!");
            } else if (jogador == 1 && computador == 3 ||
                       jogador==2 && computador == 1 ||
                       jogador==3 && computador ==2){
                System.out.println("Jogador:"+jogoJoKenPo(jogador)+" e computador:"+jogoJoKenPo(computador)+" -VOCÊ VENCEU!!!");
            }else {
                System.out.println("Jogador:"+jogoJoKenPo(jogador)+" e computador:"+jogoJoKenPo(computador)+" - VOCÊ PERDEU!!!");
            }
            System.out.print("Quer continuar?[S/N]:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='n' && continuar!='s'){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (continuar=='n'){
                System.out.println(">>>Finalizando o progorama!!!");
                break;
            }
        }
    }

    public static String jogoJoKenPo (int escolha){
        switch (escolha){
            case 1: return "PEDRA";
            case 2: return "PAPEL";
            case 3: return "TESOURA";
        }
        return "";
    }


    public static void analisandoNumeros(Scanner scanner){
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        System.out.println("Vamos analisar os números!");
        int soma = 0, maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        while (true){
            int numeros = -1;
            while (true){
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()){
                    numeros = scanner.nextInt();
                    listaNumeros.add(numeros);
                    break;
                }else {
                    System.out.println("ERRO! Digite um valor válido.");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='n' && continuar!='s'){
                System.out.print("Digite um valor válido, apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (numeros>0){
                soma+=numeros;
            }
            if (numeros>maiorNumero){
                maiorNumero=numeros;
            }
            if (numeros<menorNumero){
                menorNumero=numeros;
            }
            float media = (float) soma/listaNumeros.size();
            if (continuar=='n'){
                System.out.println("________________________________");
                System.out.println("A soma dos números:"+soma);
                System.out.println("A média dos números:"+media);
                System.out.println("O maior número:"+maiorNumero);
                System.out.println("O menor números:"+menorNumero);
                System.out.println("________________________________");
                break;
            }
        }

    }


    public static void cadastroPessoas(Scanner scanner){
        System.out.println("Vamos cadastrar pessos");
        int pessoasMaioresIdade = 0, homensCadastrados = 0, mulheresMenos20 = 0;
        while (true){
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            int idadePessoa = -1;
            while (true){
                System.out.print("Digite a sua idade:");
                if (scanner.hasNextInt()){
                    idadePessoa = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO!Digite um valor válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Digite o sexo[M/F]:");
            String sexoPessoa = scanner.nextLine().trim().toLowerCase();
            while (!sexoPessoa.equals("m") && !sexoPessoa.equals("f")){
                System.out.print("Digite apenas M ou F");
                sexoPessoa = scanner.nextLine().trim().toLowerCase();
            }
            System.out.print("Quer continuar?[S/N]:");
            char continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            while (continuar!='s' && continuar!='n'){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase().charAt(0);
            }
            if (idadePessoa>=18){
                pessoasMaioresIdade++;
            }
            if (sexoPessoa.equals("m")){
                homensCadastrados++;
            }
            if (idadePessoa<=20 && sexoPessoa.equals("f")){
                mulheresMenos20++;
            }
            if (continuar=='n'){
                System.out.println("Quantidade de pessoas maiores de idade:"+pessoasMaioresIdade);
                System.out.println("Quantidade de homens cadastrados:"+homensCadastrados);
                System.out.println("Quantidade de mulheres com menos de 20 anos:"+mulheresMenos20);
            }
        }
    }


    public static void maiorEmenorNota(Scanner scanner){
        ArrayList<Float> listaNotas = new ArrayList<>();
        float maiorNota = Float.NEGATIVE_INFINITY, menorNota = Float.POSITIVE_INFINITY;
        for (int n=0;n<6;n++){
            float nota = -1;
            while (true){
                System.out.print("Digite a "+(n+1)+"º nota:");
                if (scanner.hasNextFloat()){
                    nota = scanner.nextFloat();
                    break;
                }else {
                    System.out.println("Digite um valor válido!");
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
        System.out.println("A maior nota:"+String.format("%.2f",maiorNota));
        System.out.println("A menor nota:"+String.format("%.2f",menorNota));
    }

    public static void analisandoPagamentos(Scanner scanner){
        while (true){
            System.out.println("Vamos verificar as opções de pagamento!");
            System.out.println("[ 1 ] À VISTA - Dinheiro com 10% de desconto.");
            System.out.println("[ 2 ] À VISTA - cartão de débito");
            System.out.println("[ 3 ] PARCELAD0 - valor a vista em 2x no cartão de crédito");
            System.out.println("[ 4 ] PARCELADO - valor com 20% de jutos em 3x no cartão de crédito");
            System.out.println("[ 5 ] SAIR.");
            int opcaoDePagamento=-1;
            while (true){
                System.out.print("Digite uma das opções acima:");
                if (scanner.hasNextInt()){
                    opcaoDePagamento= scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO!Digite um valor válido!");
                    scanner.next();
                }
            }
            if (opcaoDePagamento<=0 || opcaoDePagamento>=6){
                System.out.println("ERRO!Digite um valor válido!");
                continue;
            }
            if (opcaoDePagamento==5){
                System.out.println(">>>>>Finalizando o sistema...");
                break;
            }else {
                System.out.print("Digite o valor do produto:");
                float valorProduto = scanner.nextFloat();
                if (opcaoDePagamento==1){
                    float opcao1 = valorProduto-(valorProduto*0.10f);
                    System.out.println(opcoesPagamento(1)+"R$"+opcao1);
                }else if (opcaoDePagamento==2){
                    float opcao2 = valorProduto-(valorProduto*0.05f);
                    System.out.println(opcoesPagamento(2)+"R$"+opcao2);
                } else if (opcaoDePagamento==3) {
                    float opcao3 = valorProduto;
                    float parcela2x = valorProduto/2;
                    System.out.println("total R$"+opcao3+" | "+opcoesPagamento(3)+"parcelas de R$"+parcela2x);
                } else if (opcaoDePagamento==4) {
                    float opcao4 = valorProduto+(valorProduto*0.20f);
                    float parcela3x = opcao4/3;
                    System.out.println("total R$"+opcao4+" | "+opcoesPagamento(4)+" parcelas de R$"+parcela3x);
                }

            }

        }

    }

    public static String opcoesPagamento (int escolha){
        switch (escolha){
            case 1: return "À vista no dinheiro com 10% de desconto o valor fica:";
            case 2: return "À vista no cartão de débito com 5% de desconto:";
            case 3: return "Parcelado em 2x no cartão de crédito:";
            case 4: return "Parcelado em 3x no cartão de crédito:";
        }
        return "";
    }



    public static void sequenciaApresentacao(Scanner scanner){
        System.out.println("Vamos verificar a sequência de apresentação!");
        ArrayList<String> listaApresentacao = new ArrayList<>();
        while (true){
            System.out.print("Digite um nome:");
            String nomePessoa = scanner.nextLine().trim().toUpperCase();
            listaApresentacao.add(nomePessoa);
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && !continuar.equals("s")){
                System.out.print("Digite aoenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                if (!listaApresentacao.isEmpty()){
                    Collections.shuffle(listaApresentacao);
                    System.out.println("A sequência de apresentação ficou:"+listaApresentacao);
                }
                break;
            }
        }
    }

    public static void sorteandoPessoa(Scanner scanner, Random random){
        System.out.println("Vamos sortear pessoas!");
        ArrayList<String> listaPessoas = new ArrayList<>();
        while (true){
            System.out.print("Digite o nome:");
            String nomePessoa = scanner.nextLine().trim();
            listaPessoas.add(nomePessoa);
            System.out.print("Quer continuar?´[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("n") && ! continuar.equals("s")){
                System.out.print("Digite um valor válido, apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                if (!listaPessoas.isEmpty()){
                    int sorteio = random.nextInt(listaPessoas.size());
                    String sortudo = listaPessoas.get(sorteio);
                    System.out.println("O grande sortudo foi:"+sortudo);
                }
                break;
            }
        }
    }

    public static void sorteandoNumeros(Scanner scanner, Random random) {
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        while (true) {
            int numeros = -1;
            while (true) {
                System.out.print("Digite um número:");
                if (scanner.hasNextInt()) {
                    numeros = scanner.nextInt();
                    listaNumeros.add(numeros);
                    break;
                } else {
                    System.out.println("ERRO! Digite um número válido!");
                    scanner.next();
                }
            }
            scanner.nextLine();
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")) {
                System.out.print("ERRO! Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")) {
                if (!listaNumeros.isEmpty()){
                    int sorteio = random.nextInt(listaNumeros.size());
                    int sorteado = listaNumeros.get(sorteio);
                    System.out.println("O grande sorteado foi:" + sorteado);
                }else {
                    System.out.println("Nenhum número foi sorteado!");
                }
                break;
            }
        }
    }

        public static void notasJuizes (Scanner scanner){
            ArrayList<Float> listaNotaJuizes = new ArrayList<>();
            float maiorNota = Float.NEGATIVE_INFINITY, menorNota = Float.POSITIVE_INFINITY;
            float soma = 0;
            for (int j = 0; j < 6; j++) {
                float notaJuiz = -1;
                while (true) {
                    System.out.print("Digite a " + (j + 1) + "º nota:");
                    if (scanner.hasNextFloat()) {
                        notaJuiz = scanner.nextInt();
                        listaNotaJuizes.add(notaJuiz);
                        break;
                    } else {
                        System.out.println("ERRO! Digite um valor válido!");
                        scanner.next();
                    }
                }
                if (notaJuiz > maiorNota) {
                    maiorNota = notaJuiz;
                }
                if (notaJuiz < menorNota) {
                    menorNota = notaJuiz;
                }
            }
            listaNotaJuizes.remove(maiorNota);
            listaNotaJuizes.remove(menorNota);
            for (float nota : listaNotaJuizes) {
                soma += nota;
            }
            float media = soma / listaNotaJuizes.size();
            System.out.println("A média final ficou:" + String.format("%.2f", media));
        }


        public static void calculandoTabuada (Scanner scanner){
            System.out.println("Vamos calcular tabuadas!");
            while (true) {
                int tabuada = -1;
                while (true) {
                    System.out.print("Digite um número(>= -1 para PARAR.):");
                    if (scanner.hasNextInt()) {
                        tabuada = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("ERR0!!! Digite um valor válido!");
                        scanner.next();
                    }
                }
                if (tabuada <= -1) {
                    System.out.println(">>>>Finalizando o programa...");
                    break;
                } else {
                    for (int i = 0; i <= 10; i++) {
                        System.out.printf("%d x %d = %d%n", tabuada, i, tabuada * i);
                    }
                }
            }
        }


        public static void caixaEletronico (Scanner scanner){
            System.out.print("Quanto gostaria de sacar?:R$");
            int saque = scanner.nextInt();
            int valor = saque;
            int totalced = 0;
            int ced = 50;
            while (true) {
                if (valor >= ced) {
                    valor -= ced;
                    totalced++;
                } else {
                    if (totalced > 0) {
                        System.out.printf("Total de %d cédulas de R$%d%n", totalced, ced);
                    }
                    if (ced == 50) {
                        ced = 20;
                    } else if (ced == 20) {
                        ced = 10;
                    } else if (ced == 10) {
                        ced = 5;
                    } else if (ced == 5) {
                        ced = 1;
                    }
                    totalced = 0;
                    if (valor <= 0) {
                        break;
                    }
                }
            }
        }
    }



