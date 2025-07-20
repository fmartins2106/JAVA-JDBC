package academy.devdojo.maratonajava.introducao;


import java.util.*;


public class Aula7ArraysExercicios3 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        calculando a media das notas
        calculandoMediaNotas(scanner);

//        verificando times
        tabelaBrasileirao();

        // analisando seu nome
        analisandoSeuNome(scanner);



        //        verificando vogais de palavras
        vogaisPalavras();


        //        analisando frase com letra A
        fraseComLetraA(scanner);
        scanner.close();

//        programa devolução de livros
        devolucaodeLivros(scanner);

//        cadastrousuario
        cadastroUsuario(scanner);



//        soma pedidos duplos
        somaPedidosDuplos(scanner);

//        analisando as vogais
        analisandoVogais(scanner);



//        tabuada
        calculandoTabuada(scanner);

//        CAIXA ELETRONICO
        caixaEletronico(scanner);

//        exercicio par ou impar
        jogoParOuImpar(scanner,random);

//arrays de numero, indetificar o maior, menor, e posições
        arraysNumeros(scanner);





    }

    public static void devolucaodeLivros (Scanner scanner){
        for (int i=0;i<50;i++){
            System.out.print("=");
        }
        System.out.println();
        while (true){
            System.out.println("[ 1 ] Emprestar um livro.");
            System.out.println("[ 2 ] Devolver livro.");
            System.out.println("[ 3 ] Sair do sistema.");
            System.out.print("Digite uma das opções acima:");
            int opcoes = scanner.nextInt();
            scanner.nextLine();
            if (opcoes==3){
                System.out.println(">>>>Finalizando o programa...");
                break;
            } else if (opcoes==2) {
                System.out.print("Digite o nome do livro:");
                String Devolver = scanner.nextLine().trim().trim();
                if (!Devolver.isEmpty()){
                    System.out.println("Livro Devolvido com sucesso!");
                }else {
                    continue;
                }
            }else if (opcoes==1){
                System.out.println("[ 1 ] O Senhor dos Anéis");
                System.out.println("[ 2 ] Harry Potter e a Pedra Filosofal");
                System.out.println("[ 3 ] A Game of Thrones");
                System.out.println("[ 3 ] 1984");
                System.out.print("Escolha um dos livrod disponíveis: ");
                int livros = scanner.nextInt();
                if (livros>0){
                    System.out.println("LIVRO EMPRESTADO COM SUCESSO.");
                    break;
                }
            }
        }
    }

    public static void cadastroUsuario(Scanner scanner){
        while (true){
            System.out.print("Digite o seu nome:");
            String nomeUsuario = scanner.nextLine().trim().toUpperCase();
            System.out.print("Digite o e-mail:");
            String emailUsuario = scanner.nextLine().trim().toLowerCase();
            while (!emailUsuario.contains("@") && !emailUsuario.contains(".")){
                System.out.print("Digite um e-mail válido!:");
                emailUsuario = scanner.nextLine().trim().toLowerCase();
            }
            System.out.println("Cadastro realizado com sucesso!");
            System.out.println("Nome:"+nomeUsuario);
            System.out.println("E-mail:"+emailUsuario);
            System.out.print("Quer cadastar outro usuário?:");
            String novoCadastroUsuario = scanner.nextLine().trim().toLowerCase();
            while (!novoCadastroUsuario.equals("sim") || !novoCadastroUsuario.equals("não")){
                System.out.print("Digite apenas sim ou não:");
                novoCadastroUsuario = scanner.nextLine().trim().toLowerCase();
            }
            if (novoCadastroUsuario.equals("não")){
                System.out.println(">>>Finalizando programa");
                break;
            }

        }
    }

    public static void calculandoMediaNotas (Scanner scanner){
        while (true){
            double somaNotas = 0;
            int numeroNotas = 0;
            while (true){
                System.out.print("Digite uma nota de 0 a 10:");
                if (scanner.hasNextInt()){
                    double notas = scanner.nextDouble();
                    if (notas>=0 && notas<=10){
                        somaNotas+=notas;
                        numeroNotas++;
                    }else {
                        System.out.println("ERRO! Nota inválida!!!");
                        continue;
                    }
                }else {
                    System.out.println("Digite um número válido!");
                    scanner.nextInt();
                    continue;
                }
                scanner.nextLine();
                System.out.print("Quer adicionar mais notas?:");
                String maisNotas = scanner.nextLine().trim().toLowerCase();
                while (!maisNotas.equals("sim") && !maisNotas.equals("não")){
                    System.out.print("Digite apenas sim ou não");
                    maisNotas = scanner.nextLine().trim().toLowerCase();
                }
                if (maisNotas.equals("não")){
                    break;
                }
            }
            if (numeroNotas>0){
                double media = somaNotas/numeroNotas;
                System.out.println("A média das notas é:"+media);
            }else {
                System.out.println("Nenhuma nota foi adicionada!");
            }
            System.out.print("Deseja calcular outra média?");
            String calcularOutraMedia = scanner.nextLine().toLowerCase().trim();
            while (!calcularOutraMedia.equals("sim") && !calcularOutraMedia.equals("não")){
                System.out.print("Digite apenas sim ou não:");
                calcularOutraMedia = scanner.nextLine().trim().toLowerCase();
            }
            if (calcularOutraMedia.equals("não")){
                System.out.println(">>>finalizando");
                break;
            }
        }
    }

    public static void somaPedidosDuplos(Scanner scanner){
        while (true){
            int primeiroPedido = -1;
            while (true){
                System.out.print("Digite o primeiro número:");
                if (scanner.hasNextInt()){
                    primeiroPedido = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO!Digite um valor válido:");
                    scanner.nextInt();
                }
            }
            int segundoPedido = -1;
            while (true){
                System.out.print("Digite o segundo número:");
                if (scanner.hasNextInt()){
                    segundoPedido = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO!Digite um valor válido!");
                    scanner.nextInt();
                }
            }
            int soma = primeiroPedido+segundoPedido;
            System.out.println("A soma é:"+soma);
            System.out.print("Você deseja fazer outra soma?:");
            String outraSoma = scanner.nextLine().trim().toLowerCase();
            while (!outraSoma.equals("não") && !outraSoma.equals("sim")){
                System.out.print("Digite apenas sim ou não:");
                outraSoma = scanner.nextLine().trim().toLowerCase();
            }
            if (outraSoma.equals("não")){
                System.out.println(">>>Finalizando o programa...");
                break;
            }
        }
    }


    public static void analisandoVogais(Scanner scanner){
        String[] arraysFrutas = {"abacaxi","tangerina","laranja","banana","morango"};
        for (String frutas : arraysFrutas){
            System.out.print("\nNa palavra "+frutas+" temos as vogais:");
            for (char vogais : frutas.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(vogais))!=-1){
                    System.out.print(vogais+" ");
                }
            }

        }
    }

    public static void tabelaBrasileirao(){
        String[] times = {
                "Botafogo", "Flamengo", "Palmeiras", "São Paulo", "Atlético Mineiro",
                "Internacional", "Grêmio", "Santos", "Athletico Paranaense", "Fortaleza",
                "Ceará", "Vasco da Gama", "Bahia", "Goiás", "Cruzeiro", "Bragantino",
                "Coritiba", "Atlético Goianiense", "Fluminense", "Chapecoense"
        };
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("A classificação dos times:");
        System.out.println(Arrays.toString(times)); // Exibindo a classificação dos times
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os cinco primeiros da lista:"+Arrays.toString(Arrays.copyOfRange(times, 0,5)));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        System.out.println("Os últimos 4 da lista:"+Arrays.toString(Arrays.copyOfRange(times, times.length-4, times.length)));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();
        String[] timesOrdenados = times.clone();
        Arrays.sort(timesOrdenados);
        System.out.println("Os times em ordem alfabetica:"+Arrays.toString(timesOrdenados));
        for (int i=0;i<90;i++){
            System.out.print("=");
        }
        System.out.println();

        int posicaoChapecoense = -1;
        for (int i=0;i<times.length;i++){
            if (times[i].equals("Chapecoense")){
                posicaoChapecoense = i+1;
                break;
            }
        }
        System.out.println("A posição da chapecoense:"+posicaoChapecoense+"º");
        for (int i=0;i<90;i++){
            System.out.print("=");
        }

    }

    public static void verificaoNumerosArrays (Scanner scanner){
        int[] arraysNumeros = new int[6];
        int soma = 0, maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        for (int n=0;n<arraysNumeros.length;n++){
            System.out.print("Digite o "+(1+n)+"º número da lista:");
            arraysNumeros[n] = scanner.nextInt();
            if (arraysNumeros[n]>0){
                soma+=arraysNumeros[n];
            }
            if (arraysNumeros[n]>maiorNumero){
                maiorNumero=arraysNumeros[n];
            }
            if (arraysNumeros[n]<menorNumero){
                menorNumero=arraysNumeros[n];
            }
        }
        float media = (float) soma/ Arrays.stream(arraysNumeros).count();
        System.out.println("A soma dos números:"+soma);
        System.out.println("A média:"+media);
        System.out.println("O maior número:"+maiorNumero);
        System.out.println("O menor número:"+menorNumero);
    }


    public static void calculandoTabuada(Scanner scanner){
        while (true){
            int tabuada = -1;
            while (true){
                System.out.print("Digite um número(-1 para parar):");
                if (scanner.hasNextInt()){
                    tabuada = scanner.nextInt();
                    break;
                }else {
                    System.out.println("ERRO!!! Digite um valor válido!");
                    scanner.nextInt();
                }
            }
            if (tabuada<=-1){
                System.out.println(">>>Finalizando o programa...");
                break;
            }else {
                for (int i=0;i<=10;i++){
                    System.out.printf("%d x %d = %d%n",tabuada,i,tabuada*i);
                }
            }
        }
    }


    public static void caixaEletronico(Scanner scanner){
        System.out.print("Quanto quer sacar?:R$");
        int saque  = scanner.nextInt();
        int valor = saque;
        int ced = 50;
        int totalced = 0;
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
                }else if (ced==20) {
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

    public static void jogoParOuImpar(Scanner scanner, Random random) throws InterruptedException{
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
            System.out.print("Digite P para Par ou I para Impar:");
            String escolherParOuImpar = scanner.nextLine().trim().toLowerCase();
            while (!escolherParOuImpar.equals("p") && !escolherParOuImpar.equals("i")){
                System.out.print("Digite apenas P ou I:");
                escolherParOuImpar = scanner.nextLine().trim().toLowerCase();
            }
            System.out.println("PROCESSANDO....");
            Thread.sleep(1000);
            int computador = random.nextInt(10)+1;
            System.out.println("Computador:"+computador);
            int resultado = jogador+computador;
            if (escolherParOuImpar.equals("p") && resultado%2==0){
                System.out.println("Jogador escolheu: "+traduzirParOuImpar(escolherParOuImpar)+" | Digitou:"+jogador+" | Computador:"+computador+" | Resultado:"+resultado+" | VOCÊ VENCEU!!!");
            } else if (escolherParOuImpar.equals("p") && resultado%2!=0) {
                System.out.println("Jogador escolheu: "+traduzirParOuImpar(escolherParOuImpar)+" | Digitou:"+jogador+" | Computador:"+computador+" | Resultado:"+resultado+" | VOCÊ PERDEU!!!");
            } else if (escolherParOuImpar.equals("i") && resultado%2==0) {
                System.out.println("Jogador escolheu: "+traduzirParOuImpar(escolherParOuImpar)+" | Digitou:"+jogador+" | Computador:"+computador+" | Resultado:"+resultado+" | VOCÊ PERDEU!!!");
            } else if (escolherParOuImpar.equals("i") && resultado%2!=0) {
                System.out.println("Jogador escolheu: "+traduzirParOuImpar(escolherParOuImpar)+" | Digitou:"+jogador+" | Computador:"+computador+" | Resultado:"+resultado+" | VOCÊ VENCEU!!!");
            }
            System.out.print("Quer continuar?[S/N]:");
            String continuar = scanner.nextLine().trim().toLowerCase();
            while (!continuar.equals("s") && !continuar.equals("n")){
                System.out.print("Digite apenas S ou N:");
                continuar = scanner.nextLine().trim().toLowerCase();
            }
            if (continuar.equals("n")){
                System.out.println(">>>Finalizando programa....");
                break;
            }

        }
    }
    public static String traduzirParOuImpar(String escolha){
        switch (escolha){
            case "p": return "PAR";
            case "I": return "IMPAR";
        }
        return "";
    }

    public static void arraysNumeros(Scanner scanner){
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        int posMaior = 0, posMenor = 0;
        int[] arrayNumeros = new int[6];
        for (int n=0;n<arrayNumeros.length;n++){
            System.out.print("Digite o "+(n+1)+"º número da lista:");
            int numeros = scanner.nextInt();
            arrayNumeros[n] = numeros;
            if (numeros>maiorNumero){
                maiorNumero=numeros;
                posMaior=n;
            }
            if (numeros<menorNumero){
                menorNumero=numeros;
                posMenor=n;
            }

        }
        System.out.println("O maior número foi:"+maiorNumero+" e está na posição:"+posMaior);
        System.out.println("O menor número foi:"+menorNumero+" e está na posição:"+posMenor);
    }

    public static void vogaisPalavras(){
        String[] arrayFrutas = {"banana","laranja","pera","abacaxi","morango","uva","cereja"};
        for (String frutas : arrayFrutas){
            System.out.print("\nNa palavra "+frutas+" temos as vogais:");
            for (char vogais : frutas.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(vogais))!=-1){
                    System.out.print(vogais+" ");
                }
            }
        }
    }

    public static void analisandoSeuNome(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine().trim();
        String[] arrayNome = nomeCompleto.split(" ");
        System.out.println("O seu primeiro nome:"+arrayNome[0]);
        System.out.println("O seu último nome:"+arrayNome[arrayNome.length-1]);
        System.out.println("O seu nome em letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("O seu nome em letras maiusculas:"+nomeCompleto.toUpperCase());
        System.out.println("O seu primeiro nome tem:"+arrayNome[0].length()+" letras");
        System.out.println("O seu último nome tem:"+arrayNome[arrayNome.length-1].length());
        System.out.println("O seu nome completo tem:"+nomeCompleto.replace(" ","").length()+" letras.");
    }

    public static void fraseComLetraA(Scanner scanner){
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine();
        for (int i=0;i<frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("Na frase "+frase+" a letra A apareceu:"+contagem+"x");
        int primeiroA = frase.indexOf("a");
        if (primeiroA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
        }else {
            System.out.println("A letra A não apareceu neta frase.");
        }
        int ultimoA = frase.lastIndexOf("a");
        if (ultimoA>0){
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu na frase.");
        }
    }
}
