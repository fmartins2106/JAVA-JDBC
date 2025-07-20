package academy.devdojo.maratonajava.introducao;






import java.net.SecureCacheResponse;
import java.net.Socket;
import java.util.Scanner;
import java.util.Arrays;


public class Aula7ArraysExercicios1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //        maior e menor número em uma arrys e imprimir a posição deles.
        arraysMaiorEmenorNumero(scanner);

//        numero de um arrays e vefificar



//        tipos de comida
        tiposDeComida(scanner);


//        analisando as vogais
        analisandoVogais();
//verificando opcoes
        escolhendoOpcoes(scanner);

//        analisando vogais dos nomes
        nomesEsuasVogais();

        // vamos analisar uma frase
        fraseLetraA(scanner);

// analisando o seu nome
        analisandoOSeuNome(scanner);

//        analisando letra A em uma frase();
        letraAemFrase(scanner);

//        verificando as vogais
        vogaisDosNomes();

//        analisando opções
        analisandoOpcoes(scanner);

//        analisando seu nome
        verificandoSeuNome(scanner);

//        verificar as vogais da lista
        vogaisNomes();

//        analisando uma frase e verificando se tem a letra A
        analisandoLetraA(scanner);

//        verificando opções de pagamento.
        verificandoOpcoesDePagamento(scanner);


//analisando uma frase
        analisandoFrase(scanner);


//        analisando SEU NOME
        analisandoSeuNome(scanner);

        //    analisando letras
        analisandoLetras();
        scanner.close();
    }

    public static void arraysMaiorEmenorNumero(Scanner scanner){
        int maiorNumero = Integer.MIN_VALUE, menorNumero = Integer.MAX_VALUE;
        int posMaior =-1, posMenor = -1;
        int[] arraysNumeros = new int[6];
        for (int n=0;n<arraysNumeros.length;n++) {
            System.out.print("Digite o " + (n + 1) + "º número da lista:");
            arraysNumeros[n] = scanner.nextInt();
        }
        for ( int i=0;i<arraysNumeros.length;i++){
            if (arraysNumeros[i]>maiorNumero){
                maiorNumero=arraysNumeros[i];
                posMaior=i;
            }
            if (arraysNumeros[i]<menorNumero){
                menorNumero=arraysNumeros[i];
                posMenor=i;
            }
        }
        System.out.println("O menor número foi:"+menorNumero+" e está na posição"+posMenor);
        System.out.println("O maior número foi:"+maiorNumero+" e está na posição"+posMaior);

    }

    public static void tiposDeComida(Scanner scanner){
        System.out.println("[ 1 ] - FASTFOOD");
        System.out.println("[ 2 ] - COMIDA BRASILEIRA");
        System.out.println("[ 3 ] - COMIDA ORIENTAL");
        System.out.print("Digite uma das opções acima:");
        int opcoes = scanner.nextInt();
       System.out.println(comidas(opcoes));
    }


    public static String comidas(int comida){
        switch (comida){
            case 1: return "Fast food é ideal quando você não tem muito tempo disponivel, mas tome cuidado, pois não é saudável!";
            case 2: return "Comida brasileira é exceçente escolha, muito saudável, com muitas opções de salada.";
            case 3: return "Também é uma excelente escolha, mas tome cuidado, pois muitos pratos são crus, necessita cuidado redobrado.";
            default:return "Opção inválida!!!";
        }
    }



    public static void analisandoVogais(){
        String[] listaNomes = {"maria","pedro","paula","fernando","ana"};
        for (String nomes : listaNomes){
            System.out.print("\nNo nome: "+nomes+" temos as vogais:");
            for (char letras : nomes.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(letras))!=-1){
                    System.out.print(letras+" ");
                }
            }
        }
    }


    public static void escolhendoOpcoes(Scanner scanner){
        System.out.println("Escolhendo opções!");
        System.out.println("[ 1 ] - Você gosta de fast food");
        System.out.println("[ 2 ] - Você gosta de comida oriental.");
        System.out.println("[ 3 ] - Você gosta de comida brasileira");
        System.out.print("Digite uma das opções acima:");
        int opcoes = scanner.nextInt();
        if (opcoes==1){
            System.out.println(escolhendo(1));
        } else if (opcoes==2) {
            System.out.println(escolhendo(2));
        } else if (opcoes==3) {
            System.out.println(escolhendo(3));
        }else {
            System.out.println("Opção inválida!!!");
        }
    }
    public static String escolhendo(int escolha){
        switch (escolha){
            case 1: return "Cuidado, sua sáude corre risco, tente se alimentar melhor!";
            case 2: return "Boa escolha, mas toque cuidade onde come, comidas cruas necessitam cuidado redobrado.";
            case 3: return "Parabéns, você escolheu a melhor opção, alimentação equilibrada é tudo!";
            default: return "Opção inválida,tente novamente!";
        }
    }




   public static void nomesEsuasVogais(){
       System.out.println("Analisando as vogais das palavras");
       String[] listaPalavras = {"comida","chocolate","pizza","mararrão","peixe"};
       for (String palavra : listaPalavras){
           System.out.print("\nNa palavra "+palavra+" temos as vogais:");
           for (char letras : palavra.toCharArray()){
               if ("aeiouâãàáéí".indexOf(Character.toLowerCase(letras))!=-1){
                   System.out.print(letras+" ");
               }
           }
       }
   }


    public static void fraseLetraA(Scanner scanner){
        System.out.println("\nAnalisando a letra A");
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim();
        for (int n=0;n<frase.length();n++){
            if (frase.charAt(n)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu na frase:"+contagem);
        int primeiroA = frase.indexOf("a");
        if (primeiroA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
        }else {
            System.out.println("Não tem letra A nesta frase");
        }
        int ultimoA = frase.lastIndexOf("a");
        if (ultimoA>0){
            System.out.println("A letra A apareceu pela última vez na posição."+ultimoA);
        }else {
            System.out.println("Não tem letra A nesta frase!");
        }


    }


    public static void analisandoOSeuNome(Scanner scanner){
        System.out.println("Analisando o seu nome em várias formas!");
        System.out.print("Digite o seu nome:");
        String nomeCompleto = scanner.nextLine().trim();
        String[] listaNome = nomeCompleto.split(" ");
        System.out.println("Seu nome em letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("O seu nome em letras maiusculas:"+nomeCompleto.toUpperCase());
        System.out.println("O seu primeiro nome:"+listaNome[0]);
        System.out.println("O seu último nome:"+listaNome[listaNome.length-1]);
        System.out.println("Seu primeiro nome tem:"+listaNome[0].length()+" letras");
        System.out.println("O seu último nome tem:"+listaNome[listaNome.length-1].length()+" letras");
    }

    public static void letraAemFrase(Scanner scanner) {
        System.out.println("Analisando letra A");
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim();
        for (int n = 0; n < frase.length(); n++) {
            if (frase.charAt(n) == 'a') {
                contagem++;
            }
        }
        System.out.println("A letra A aparceu na frase" + frase + ":" + contagem + "vezes");
        int primeiroA = frase.indexOf("a");
        if (primeiroA > 0) {
            System.out.println("A letra A apareceu pela primeira vez:" + primeiroA);
        } else {
            System.out.println("A letra A não apareceu nesta frase!");
        }
        int ultimoA = frase.lastIndexOf("a");
        if (ultimoA > 0) {
            System.out.println("A letra A apareceu pela última vez:" + ultimoA);
        } else {
            System.out.println("A letra A não apareceu nesta frase!");
        }
    }


    public static void vogaisDosNomes(){
        System.out.println("Vamos verificar as vogais de cada nome!");
        String[] listaNomes = {"maria","pedro","joana", "ana","fernando"};
        for (String nome : listaNomes){
            System.out.print("\nNo nome "+nome+" temos:");
            for (char letras : nome.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(letras))!=-1){
                    System.out.print(letras+" ");

                }
            }
        }
        System.out.println("\n_______________________________________________");
    }


    public static void analisandoOpcoes(Scanner scanner){
        System.out.println("Vamos verificar as opções!");
        System.out.println("[ 1 ] -Você gosta de ficar em casa finais de semana!");
        System.out.println("[ 2 ] -Você gosta de sair todos os finais de semana!");
        System.out.println("[ 3 ] -Você sai as vezes nos finais de semana!");
        System.out.print("Digite uma das opções acima:");
        int opcao = scanner.nextInt();
        if (opcao==1){
            System.out.println(opcaoEscolhida(1));
        } else if (opcao==2) {
            System.out.println(opcaoEscolhida(2));
        }else if (opcao==3){
            System.out.println(opcaoEscolhida(3));
        }else {
            System.out.println("Opção inválida!!!");
        }
    }

    public static String opcaoEscolhida(int escolha){
        switch (escolha){
            case 1: return "Você é uma pessoa caseira e gosta de aproveitar cada momento do seu lar.";
            case 2: return "Você é  uma pessoa que gosta de festa e estar sempre rodeada de amigos!";
            case 3: return "Você tem o melhor dos dois mundos, gosta de sair e também de ficar em casa.";
            default:return "Você digitou uma opção inválida!!! tente novamente!";
        }
    }


    public static void verificandoSeuNome(Scanner scanner){
        System.out.println("Verificando o seu nome!");
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine();
        String[] verificandoNome = nomeCompleto.split(" ");
        System.out.println("O seu nome letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("O seu nome com letras maiusculas:"+nomeCompleto.toUpperCase());
        System.out.println("O seu primeiro nome:"+verificandoNome[0]);
        System.out.println("O seu último nome:"+verificandoNome[verificandoNome.length-1]);
        System.out.println("O seu primeiro nome tem:"+verificandoNome[0].length()+" letras");
        System.out.println("O segu último nome tem:"+verificandoNome[verificandoNome.length-1].length()+" letras");
        System.out.println("__________________________");
    }


    public static void vogaisNomes(){
        System.out.println("Vamos separar as vogais dos nomes:");
        String[] pessoas = {"maria","fernando","ana","paulo","joana"};
        for (String nome : pessoas){
            System.out.print("\nNo nome "+nome+" temos:");
            for (char letras : nome.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(letras))!=-1){
                    System.out.print(letras+" ");
                }
            }
        }
    }

    public static void analisandoLetraA(Scanner scanner){
        System.out.println("\nVamos analisar se tem letra A nesta frase!");
        int contagem=0;
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine();
        for (int n=0;n<frase.length();n++){
            if (frase.charAt(n)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu "+contagem+"x na frase.");
        int primeiroA = frase.indexOf("a");
        if (primeiroA>0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiroA);
        }else {
            System.out.println("A letra A não apareceu na frase!");
        }
        int ultimoA = frase.lastIndexOf("a");
        if (ultimoA>0){
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu na frase!");
        }
    }


    public static void verificandoOpcoesDePagamento(Scanner scanner){
        System.out.println("Verificando opções de pagamento!");
        System.out.println("[ 1 ] - À VISTA");
        System.out.println("[ 2 ] - No cheque");
        System.out.println("[ 3 ] - Cartão de crédito");
        System.out.println("[ 4 ] - Crédito em 10x");
        System.out.print("Digite uma das opções de pagamento acima:");
        int opcaoPagamento = scanner.nextInt();
        if (opcaoPagamento==1){
            System.out.println(opcoesDePagamento(1));
        }else if (opcaoPagamento==2){
            System.out.println(opcoesDePagamento(2));
        } else if (opcaoPagamento==3) {
            System.out.println(opcoesDePagamento(3));
        } else if (opcaoPagamento==4){
            System.out.println(opcoesDePagamento(4));
        }else {
            System.out.println("opção inválida!!!");
            System.out.println(opcoesDePagamento(5));
        }
    }

    public static String opcoesDePagamento(int escolha){
        switch (escolha){
            case 1: return "Você escolheu pagamento a vista.";
            case 2: return "Você prefere pagamento no cheque";
            case 3: return "Pagamento no cartão de crédito";
            case 4: return "Parcelado no cartão de crédito em 10x.";
            default: return "Opção inválida!";
        }
    }

    public static void analisandoFrase(Scanner scanner){
        System.out.println("Vamos analisar uma frase e verificar quantos A tem na frase");
        int contagem = 0;
        System.out.print("Digite uma frase:");
        String frase  = scanner.nextLine().trim();
        scanner.nextLine();
        for (int n=0;n<frase.length();n++){
            if (frase.charAt(n)=='a'){
                contagem++;
            }
        }
        System.out.println("Total de A na frase:"+contagem);
        int primeirA = frase.indexOf("a");
        if (primeirA>0){
            System.out.println("O primeiro A apareceu na posição:"+primeirA);
        }else {
            System.out.println("Letra A não apareceu nesta frase!");
        }
        int ultimoA = frase.lastIndexOf("a");
        if (ultimoA>0){
            System.out.println("O último A apareceu na posição:"+ultimoA);
        }else {
            System.out.println("A letra A não apareceu nesta frase!");
        }

    }


    public static void analisandoSeuNome(Scanner scanner){
        System.out.println("Vamos analisar o seu nome!");
        System.out.print("Digite o seu nome:");
        String nome = scanner.nextLine().trim();
        String[] analisandoNome = nome.split(" ");
        System.out.println("Seu nome em letras minusculas:"+nome.toLowerCase());
        System.out.println("Seu nome em letras maiusculas:"+nome.toUpperCase());
        System.out.println("Seu primeiro nome:"+analisandoNome[0]);
        System.out.println("Seu último nome:"+analisandoNome[analisandoNome.length-1]);
        System.out.println("Seu primeiro nome tem:"+analisandoNome[0].length()+" letras");
        System.out.println("Seu último nome tem:"+analisandoNome[analisandoNome.length-1].length()+" letras");
        System.out.println("Seu nome completo tem:"+nome.replace(" ","").length()+" letras");



    }

    public static void analisandoLetras(){
        System.out.println("____________________________");
        System.out.println("Vamos verificar as vogais!");
        String[] listaNomes = {"fernando","maria","pedro","joana","ana"};
        for (String nome: listaNomes){
            System.out.print("\nNa palavra "+nome+" temos:");
            for (char letras : nome.toCharArray()){
                if ("aeiou".indexOf(Character.toLowerCase(letras))!=-1){
                    System.out.print(letras+" ");
                }
            }
        }
    }

}

