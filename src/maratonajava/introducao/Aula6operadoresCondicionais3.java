package academy.devdojo.maratonajava.introducao;

import javax.xml.transform.Source;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

public class Aula6operadoresCondicionais3 {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    //exercicio alistamento militar
        System.out.println("Vamos verificar o seu alistamento militar");
        System.out.print("Digite o seu nome:");
        String nnome2 = scanner.nextLine();
        System.out.print("Digite o ano de nascimento:");
        int anoN = scanner.nextInt();
        int ano_atual = LocalDate.now().getYear();
        int idadeSoldado = ano_atual-anoN;
        if (idadeSoldado<=17){
            int alistamento = 18-idadeSoldado;
            System.out.println(nnome2+", você tem "+idadeSoldado+" anos e faltam "+alistamento+" anos para você se alistar");
        } else if (idadeSoldado==18) {
            System.out.println(nnome2+", você tem "+idadeSoldado+" anos e você precisa comparecer a junta de seviço militar");
        }else if (idadeSoldado>=19){
            int alistamento1 = idadeSoldado-18;
            System.out.println(nnome2+", você tem "+idadeSoldado+" anos e já se passaram "+alistamento1+" anos de você se alistar.");
        }


        //Exercicio verificando a categoria
        System.out.println("Vamos verificar a sua categoria!");
        System.out.print("Digite o seu nome:");
        String nome = scanner.nextLine();
        System.out.print("Digite o ano de nascimento:");
        int anoNascimento = scanner.nextInt();
        int anoAtual = LocalDate.now().getYear();
        int idade = anoAtual-anoNascimento;
        if (idade<=9){
            System.out.println(nome+", você tem "+idade+ " anos e está na categoria Mirin");
        } else if (idade>=10 && idade<=14) {
            System.out.println(nome+", você tem "+idade+" anos e está na categoria Infantil");
        } else if (idade>=15 && idade<=19) {
            System.out.println(nome+", você tem "+idade+" anos e está na categoria Junior ");
        } else if (idade==20) {
            System.out.println(nome+", você tem "+idade+" anos e você está na categoria Senior");
        } else if (idade>=21) {
            System.out.println(nome+", você tem "+idade+" anos e você está na categoria Master");
        }


        //Exercicio maior e menor número da lista
        System.out.println("Vamos descobrir o maior e o menor número da lista");
        System.out.print("Digite o primeiro número:");
        int primeiro = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int segundo = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int terceiro = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int quarto = scanner.nextInt();
        ArrayList<Integer> yourlist = new ArrayList<>();
        Collections.addAll(yourlist,primeiro,segundo,terceiro,quarto);
        int maior = Collections.max(yourlist);
        int menor  = Collections.min(yourlist);
        System.out.println("O maior número da lista é:"+maior+" e o menor número da lista é:"+menor);



    //exercicio par definir número par ou impar
        System.out.println("Vamos verificar se um número é par ou impar");
        System.out.print("Digite o primeiro número:");
        int nn1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int nn2 = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int nn3 = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int nn4 = scanner.nextInt();
        ArrayList<Integer> numLista = new ArrayList<>();
        Collections.addAll(numLista,nn1,nn2,nn3,nn4);
        for (int numero : numLista){
            if (numero%2==0){
                System.out.println(numero+" : Esse número é par");
            }else{
                System.out.println(numero+" : Esse número é impar");
            }
        }


    // Exercicio tabudaa
        System.out.println("Vamos fazer uma tabuada");
        System.out.print("Digite um número:");
        int tabuada = scanner.nextInt();
        for (int i=0;i<=10;i++){
            System.out.printf("%d x %d = %d%n",tabuada,i,tabuada*i);
        }


    //Calculo eleitores
        System.out.println("Vamos fazer contagem dos votos.");
        System.out.print("Digite o total de votos:");
        float totalVotos = scanner.nextFloat();
        System.out.print("Digite o total de votos válidos:");
        float votosValidos = scanner.nextFloat();
        System.out.print("Digite o total de votos nulos:");
        float votosNulos = scanner.nextFloat();
        System.out.print("Digite o total de votos em branco:");
        float votosEmBranco = scanner.nextFloat();
        if (totalVotos<(votosEmBranco+votosNulos+votosValidos)){
            System.out.println("Votoso totais não pode ser menor que soma de votos válidos, nulos e branco");
        } else{
            float totalVotosValidos = ((votosValidos/totalVotos)*100);
            System.out.println("o total de votos válidos é:"+String.format("%.2f",totalVotosValidos)+"%");
            float totalVotosNulos = (votosNulos/totalVotos)*100;
            System.out.println("O total de votos nulos é:"+String.format("%.2f",totalVotosNulos)+"%");
            float totalVotosBrancos = (votosEmBranco/totalVotos)*100;
            System.out.println("O total de votos em branco é:"+String.format("%.2f",totalVotosBrancos)+"%");
            float pessoasNvotaram = (((totalVotos-(votosNulos+votosEmBranco+votosValidos))/totalVotos)*100);
            System.out.println("O total de pessoas que não compareceram a votação é:"+String.format("%.2f",pessoasNvotaram)+"%");
        }

            


        //calculando imposto salário
        System.out.println("Vamos verificar o imposto sobre seu salário");
        System.out.print("Digite o seu salário:");
        float salario = scanner.nextFloat();
        if (salario<=499.99f){
            float faixa1 = (salario*.05f);
            System.out.println("Seu salário é R$"+String.format("%.2f",salario)+" e o imposto é igual R$"+String.format("%.2f",faixa1));
        }else if (salario>=500f && salario<=999.99f){
            float faixa2 = (salario*.10f);
            System.out.println("Seu salário é R$"+String.format("%.2f",salario)+" e o imposto é igual R$"+String.format("%.2f",faixa2));
        }else  if (salario>=1000 && salario<=1499.99){
            float faixa3 = (salario*.15f);
            System.out.println("Seu salário é R$"+String.format("%.2f",salario)+" e o imposto é igual R$"+String.format("%.2f",faixa3));
        }else if (salario>=1500 && salario<=1999.99){
            float faixa4 = (salario*.20f);
            System.out.println("Seu salário é R$"+String.format("%.2f",salario)+" e o imposto é igual R$"+String.format("%.2f",faixa4));
        } else if (salario>=2000) {
            float faixa5 = (salario*.25f);
            System.out.println("Seu salário é R$"+String.format("%.2f",salario)+" e o imposto é igual R$"+String.format("%.2f",faixa5));

        }


        // vamos sortear umm número agora
        System.out.println("Digite vamos sortear um número.");
        System.out.print("Digite o primeiro número:");
        int n1 = scanner.nextInt();
        System.out.print("Digite o segundo número:");
        int n2 = scanner.nextInt();
        System.out.print("Digite o terceiro número:");
        int n3 = scanner.nextInt();
        System.out.print("Digite o quarto número:");
        int n4 = scanner.nextInt();
        ArrayList<Integer> mylist = new ArrayList<>();
        Collections.addAll(mylist, n1,n2,n3,n4);
        Random random1 = new Random();
        int sorteandoNumero = random1.nextInt(mylist.size());
        int sorteioNumero = mylist.get(sorteandoNumero);
        System.out.println("O número sorteado foi:"+sorteioNumero);

    // sorteio de um aluno
        System.out.println("Vamos sortear um aluno ");
        System.out.print("Digite o primeiro nome:");
        String a1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String a2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String a3 = scanner.nextLine();
        System.out.print("Digite o quartno nome:");
        String a4 = scanner.nextLine();
        ArrayList<String> mlista = new ArrayList<>();
        mlista.add(a1);
        mlista.add(a2);
        mlista.add(a3);
        mlista.add(a4);
        Random random = new Random();
        int sorteio = random.nextInt(mlista.size());
        String sortudo = mlista.get(sorteio);
        System.out.println("O grande sortudo de hoje foi:"+sortudo);



    // sorteio de sequencia de apresentação
    System.out.println("Vamos sortear a sequencia de apresentação");
    System.out.print("Digite o primeiro nome:");
    String nome1 = scanner.nextLine();
    System.out.print("Digite o segundo nome:");
    String nome2 = scanner.nextLine();
    System.out.print("Digite o terceiro nome:");
    String nome3 = scanner.nextLine();
    System.out.print("Digite o quarto nome:");
    String nome4 = scanner.nextLine();
    ArrayList<String> lista = new ArrayList<>();
    Collections.addAll(lista, nome1,nome2,nome3,nome4);
    Collections.shuffle(lista);
    System.out.println("A sequencia de apresentação ficou:"+lista);
    scanner.close();
    }
}
