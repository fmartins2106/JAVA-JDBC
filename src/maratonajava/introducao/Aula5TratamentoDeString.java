package academy.devdojo.maratonajava.introducao;



import java.util.*;
import java.time.LocalDate;


public class Aula5TratamentoDeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        analisando nome
        analisandoNome(scanner);

//verificanto tipos de pagamento
        verificandoTiposDePagamento(scanner);

//        verificando a letra A
        verificandoAletraA(scanner);

// verificando nome
        nome(scanner);

//        variações do nome
        variacoesDoNome(scanner);

//        contando letras nome
        contandoLetrasNome(scanner);

//        manipulando nome
        opcoesNome(scanner);

        //        verificando letras de uma frase
        verificandoLetrasDeUmaFrase(scanner);

//        avaliando nome
        avaliandoOseuNome(scanner);


//apresentando nome e sobrenome
        apresentandoNomeEsobrenome(scanner);

//        contagem de letras3
        contagemLetras(scanner);

        // contagem de letras 2
        contagemLetraA(scanner);

//        verificando o nome
        verificandoNome(scanner);

//        avaliando nome
        avaliandoNome(scanner);

        //analisando frases
    analisandoFrase(scanner);


//      nome e sobre nome2
        nomeSobrenome(scanner);

        // Apresentação do nome e sobrenome
        nomeEsobrenome(scanner);


        //        contagem de letras
        contagemA(scanner);
        scanner.close();
    }

    public static void analisandoNome(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine().trim();
        String[] lista = nomeCompleto.split(" ");
        System.out.println("Seu nome com letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("Seu nome com letras maiusculas:"+nomeCompleto.toUpperCase());
        System.out.println("Seu primeiro nome tem:"+lista[0].length()+" letras.");
        System.out.println("Seu último nome tem:"+lista[lista.length-1].length()+" letras");
        System.out.println("Seu nome completo tem:"+nomeCompleto.replace(" ", "").length());
    }


    public static void verificandoTiposDePagamento(Scanner scanner){
        System.out.println("Analisando opções de pagamento.");
        while (true){
            System.out.println("[ 1 ] À VISTA - Dinheiro com 10% de desconto.");
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
                }else {
                    System.out.println("ERRO! VALOR INVÁLIDO, TENTE NOVAMENTE:");
                    scanner.next();
                }
            }
            if (opcaoDePagamento<=0 || opcaoDePagamento>=6){
                System.out.println("Digite um número de 1 a 5!!!");
                continue;
            }
            if (opcaoDePagamento==5){
                System.out.println(">>>>FINALIZANDO O PROGRAMA....");
                break;
            }else {
                float valorProduto = -1;
                while (true){
                    System.out.print("Digite o valor do produto:");
                    if (scanner.hasNextFloat()){
                        valorProduto = scanner.nextFloat();
                        break;
                    }else {
                        System.out.println("Digite um valor válido!!!");
                        scanner.next();
                    }
                }
                if (opcaoDePagamento==1){
                    float opcao1 = valorProduto-(valorProduto*0.10f);
                    System.out.println(opcoesDePagamento(1)+":R$"+opcao1);
                }else if (opcaoDePagamento==2){
                    float opcao2 = valorProduto-(valorProduto*.05f);
                    System.out.println(opcoesDePagamento(2)+":R$"+opcao2);
                } else if (opcaoDePagamento==3) {
                    float opcao3= valorProduto;
                    float parcela2x = opcao3/2;
                    System.out.println(opcoesDePagamento(3)+"R$:"+opcao3+"| 2 parcelas de :R$"+parcela2x);
                } else if (opcaoDePagamento==4) {
                    float opcao4 = valorProduto+(valorProduto*0.20f);
                    float parcela3x = opcao4/3;
                    System.out.println(opcoesDePagamento(4)+"R$:"+opcao4+"| 3 parcelas de :R$"+parcela3x);
                }
            }
        }
    }

    public static String opcoesDePagamento(int escolha){
        switch (escolha){
            case 1: return "Dinheiro ou cheque com 10% de desconto";
            case 2: return "No cartão de débito com 5% de desconto";
            case 3: return "Valor da etiqueta em 2x no cartão de crédito";
            case 4: return "3x no cartão de crédito com acrescimo de 20% de juros.";
        }
        return "";
    }


    public static void verificandoAletraA(Scanner scanner){
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        int contagem=0;
        for (int i=0;i<frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu:"+contagem+"x");
        int primeira = frase.indexOf('a');
        if (primeira>=0){
            System.out.println("A letra A apareceu na frase pela primeira vez na posição:"+primeira);
        }else {
            System.out.println("Letra A não apareceu na frase!");
        }
        int ultima = frase.lastIndexOf('a');
        if (ultima>=0){
            System.out.println("A letra A apareceu na frase pela última vez na posição:"+ultima);
        }else {
            System.out.println("A letra A não apareceu na frase.");
        }
    }



    public static void nome(Scanner scanner){
        System.out.print("Digite o seu nome:");
        String nomeCompleto = scanner.nextLine().trim().toUpperCase();
        String[] lista = nomeCompleto.split(" ");
        System.out.println("Seu primeiro nome:"+lista[0]);
        System.out.println("Seu segundo nome:"+lista[lista.length-1]);
    }

    public static void variacoesDoNome (Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine().trim();
        System.out.println("Seu nome em letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("Seu nome em letras maiusculas:"+nomeCompleto.toUpperCase());
        String[] lista = nomeCompleto.split(" ");
        System.out.println("Quantidade de letras do primeiro nome:"+lista[0].length());
        System.out.println("Quantidade total de letras do seu nome:"+nomeCompleto.replace(" ","").length());
    }


    public static void contandoLetrasNome(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine().trim().toUpperCase();
        nomeCompleto = capitalizeWords(nomeCompleto);
        System.out.println("Nome completo (iniciais maiusculas):"+nomeCompleto);
        System.out.println("Seu nome em letras minusculas:"+nomeCompleto.toLowerCase());
        System.out.println("Seu nome em letras maiusculas:"+nomeCompleto.toUpperCase());
        String[] lista = nomeCompleto.split(" ");
        System.out.println("Quantidade de letras no seu nome:"+nomeCompleto.replace(" ","").length());
        System.out.println("O seu primeiro nome é "+lista[0]+" e tem "+lista[0].length()+" letras");

    }

    // Função para capitalizar as palavras
    public static String capitalizeWords(String nomeCompleto) {
        String[] words = nomeCompleto.toLowerCase().split(" "); // Divide as palavras e converte para minúsculo
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) { // Garante que a palavra não está vazia
                result.append(Character.toUpperCase(word.charAt(0))) // Primeira letra maiúscula
                        .append(word.substring(1)) // Resto da palavra
                        .append(" "); // Adiciona espaço
            }
        }

        return result.toString().trim(); // Remove espaço extra no final
    }

    public static void opcoesNome(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nome = scanner.nextLine().trim().toUpperCase();
        String[] lista = nome.split(" ");
        System.out.println("Seu nome completo:"+nome);
        System.out.println("Seu primeiro nome:"+lista[0]);
        System.out.println("Seu último nome:"+lista[lista.length-1]);
    }

    public static void verificandoLetrasDeUmaFrase(Scanner scanner){
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim();
        int cont = 0;
        for (int i=0;i<frase.length();i++){
            if (frase.charAt(i)=='a'){
                cont++;
            }
        }
        System.out.println("A letra A apareceu:"+cont+"x");
        int primeiraPosicao = frase.indexOf('a');
        if (primeiraPosicao>=0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiraPosicao);
        }
        int ultimaPosicao = frase.lastIndexOf('a');
        if (ultimaPosicao>=0){
            System.out.println("A letra A apareceu pela última vez na posição:"+ultimaPosicao);
        }
    }


    public static void avaliandoOseuNome(Scanner scanner){
        // Remover espaços extras

        System.out.print("Digite o seu nome:");
        String nome = scanner.nextLine().trim();
        System.out.println("Seu nome em letras maiusculas:"+nome.toUpperCase());
        System.out.println("Seu nome em letras minusculas:"+nome.toLowerCase());
        System.out.println("Quantidade de letras do seu nome:"+nome.replace(" ","").length());
        String[] lista = nome.split(" ");
        System.out.println("O seu primeiro nome é:"+nome+" e tem "+lista[0].length()+" letras");
    }


    public static void apresentandoNomeEsobrenome(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nomeCompleto = scanner.nextLine().trim().toUpperCase();
        System.out.println("Seu nome completo:"+nomeCompleto);
        String[] lista = nomeCompleto.split(" ");
        System.out.println("Seu primeiro nome:"+lista[0]);
        System.out.println("Último nome:"+lista[lista.length-1]);
    }

    public static void contagemLetras(Scanner scanner){
        System.out.println("Vamos contar a letra A na frase");
        System.out.print("Digite uma frase:");
        int contagem = 0;
        String frase = scanner.nextLine().trim();
        for (int i=0;i<frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A apareceu: "+contagem+"x");
        int primeiraVez = frase.indexOf('a');
        if (primeiraVez>=0){
            System.out.println("A letra A apareceu pela primeira vez na posição:"+primeiraVez);
        }else {
            System.out.println("A tem letra A na frase");
        }
        int ultimaVez = frase.lastIndexOf('a');
        if (ultimaVez>=0){
            System.out.println("A letra A apareceu pela ultima vez na posição:"+ultimaVez);
        }
    }

    public static void verificandoNome(Scanner scanner){
        System.out.println("Digite o seu nome:");
        String nomePessoa = scanner.nextLine().trim();
        System.out.println("Nome em letras maiusculas:"+nomePessoa.toUpperCase());
        System.out.println("Nome letras minusculas:"+nomePessoa.toLowerCase());
        String[] lista = nomePessoa.split(" ");
        System.out.println("A quantidade de letras do seu nome:"+nomePessoa.replace(" ","").length());
        System.out.println("O seu primeiro nome é "+lista[0]+" e tem "+lista[0].length()+" letras");
    }



    public static void avaliandoNome(Scanner scanner){
        System.out.print("Digite o seu nome:");
        String nome = scanner.nextLine().trim().toUpperCase();
        String[] lista = nome.split(" ");
        System.out.println("O seu nome completo:"+nome);
        System.out.println("O seu primeiro nome:"+lista[0]);
        System.out.println("O seu segundo nome:"+lista[lista.length-1]);
    }

    public static void analisandoFrase(Scanner scanner){
        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        int contagem = 0;
        for( int i=0;i<frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A, apareceu "+contagem+"x");
        int apareceuPrimeiro = frase.indexOf('a');
        if (apareceuPrimeiro>=0){
            System.out.println("A letra A, apareceu primeiro na posição:"+apareceuPrimeiro);
        }else {
            System.out.println("A letra A não apareceu na frase");
        }
        int apareceuUltimo = frase.lastIndexOf('a');
        if (apareceuUltimo>=0){
            System.out.println("A letra A apareceu pela última vez na posição:"+apareceuUltimo);
        }

    }

    public static void nomeSobrenome(Scanner scanner){
        System.out.print("Digite o seu nome:");
        String nome = scanner.nextLine().trim().toUpperCase();
        String[] nome1 = nome.split(" ");
        System.out.println("Digite o nome completo:"+nome);
        System.out.println("O seu primeiro nome:"+nome1[0]);
        System.out.println("O seu segundo nome:"+nome1[nome1.length-1]);
    }

    public static void nomeEsobrenome(Scanner scanner){
        System.out.print("Digite o seu nome completo:");
        String nome = scanner.nextLine().trim().toUpperCase();
        String[] nome1 = nome.split(" ");
        System.out.println("Prazer em te conhecer:"+nome+"!");
        System.out.println("O seu primeiro nome é:"+nome1[0]+"!");
        System.out.println("O segu segundo nome é:"+nome1[nome1.length-1]+"!");
    }


    public static void contagemLetraA(Scanner scanner) {
        System.out.println("Digite uma frase:");
        String frase = scanner.nextLine().trim().toLowerCase();
        int contagem = 0;
        for (int i=0;i<frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("Letra A, apareceu:"+contagem+"x");
        int primeiraAparicao = frase.indexOf('a');
        if (primeiraAparicao>=0){
            System.out.println("A letra A, apareceu pela primeira vez na posição:"+primeiraAparicao);
        }else {
            System.out.println("A letra A não apareceu na frase!");
        }
        int ultimaAparicao = frase.lastIndexOf('a');
        if (ultimaAparicao>=0){
            System.out.println("A última aparição da letra A, foi na posição:"+ultimaAparicao);
        }else {
            System.out.println("A letra A não apareceu na frase!");
        }
    }

    public static void contagemA(Scanner scanner){

        System.out.print("Digite uma frase:");
        String frase = scanner.nextLine().toLowerCase().trim();
        int contagem = 0;
        for (int i=0; i < frase.length();i++){
            if (frase.charAt(i)=='a'){
                contagem++;
            }
        }
        System.out.println("A letra A, apareceu "+contagem+"x na frase.");
        int primeiraPosicao = frase.indexOf('a');
        if (primeiraPosicao>=0){
            System.out.println("A primeira letra A apareceu na posição:"+(primeiraPosicao+1));
        }else {
            System.out.println("A letra A não foi encontrada na frase!");
        }
        int ultimaPosicao = frase.lastIndexOf('a');
        if (ultimaPosicao>=0){
            System.out.println("A letra A apareceu pela última vez, na posição:"+(ultimaPosicao+1));
        }else {
            System.out.println("A letra A não foi encontrada na frase!");
        }
    }
}
