package academy.devdojo.maratonajava.introducao;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aula5ExerciciosDiversos3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Vamos sortear a sequencia da apresentação:");
        System.out.print("Digite o primeiro nome:");
        String nome1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String nome2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String nome3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String nome4 = scanner.nextLine();
        ArrayList<String> llista = new ArrayList<>();
        Collections.addAll(llista, nome1,nome2,nome3,nome4);
        Collections.shuffle(llista);
        System.out.printf("A ordem de apresentação ficou:%s%n",llista);


        System.out.println("Vamos calcular uma tabuada!");
        System.out.print("Digite um número inteiro:");
        int tabu = scanner.nextInt();
        for (int i=0; i<=10; i++) {
            System.out.printf("%d x %d = %d%n" ,tabu, i, tabu*i);

        }




        //Escolher uma pessoa da lista

        System.out.print("Digite o nome do primeiro aluno:");
        String aln1 = scanner.nextLine();
        System.out.print("Digite o nome do segundo aluno:");
        String aln2 = scanner.nextLine();
        System.out.print("Digite o nome do terceiro aluno:");
        String aln3 = scanner.nextLine();
        System.out.print("Digite o nome do quarto aluno:");
        String aln4 = scanner.nextLine();
        ArrayList<String> alista = new ArrayList<>(); //Criar a lista e armazenas na lista
        alista.add(aln1);
        alista.add(aln2);
        alista.add(aln3);
        alista.add(aln4);
        int sortindex = random.nextInt(alista.size()); // Sorteia um índice aleatório
        String sorteando = alista.get(sortindex);  // Exibir o aluno sorteado
        System.out.println("O aluno sorteado foi:"+sorteando);




        //Escolher uma pessoa da lista
        System.out.println("Vamos sortear uma pessoa:");
        System.out.print("Digite o primeiro nome:");
        String pp1 = scanner.nextLine();
        System.out.print("Digite o nome da segunda pessoa:");
        String pp2 = scanner.nextLine();
        System.out.print("Digite o nome da terceira pessoa:");
        String pp3 = scanner.nextLine();
        System.out.print("Digite o nome da quarta pessoa:");
        String pp4 = scanner.nextLine();
        List<String> aluno = new ArrayList<>();
        aluno.add(pp1);
        aluno.add(pp2);
        aluno.add(pp3);
        aluno.add(pp4);
        int indiceSorteado = random.nextInt(aluno.size());
        String alunoSorteado = aluno.get(indiceSorteado);
        System.out.println("A pessoa sorteada foi: "+alunoSorteado);



        System.out.println("Vamos sortear a sequencia de apresentação:");
        System.out.print("Digite o nome do primeiro aluno:");
        String al1 = scanner.nextLine();
        System.out.print("Digite o nome do segundo aluno:");
        String al2 = scanner.nextLine();
        System.out.print("Digite o nome do terceiro aluno:");
        String al3 = scanner.nextLine();
        System.out.print("Digite o nome do quarto aluno:");
        String al4 = scanner.nextLine();
        List<String> lista = new ArrayList<>();
        Collections.addAll(lista, al1,al2,al3,al4);
        Collections.shuffle(lista);
        System.out.printf("A sequencia de apresenteção ficou:"+lista);


        System.out.println("Vamos sortear a ordem de apresentação:");
        System.out.print("Digite o primeiro nome:");
        String a1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String a2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String a3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String a4 = scanner.nextLine();
        List<String> lista2 = new ArrayList<>();
        Collections.addAll(lista2, a1,a2,a3,a4);
        Collections.shuffle(lista2);
        System.out.println("A sequencia de apresentação ficou:"+lista2);


        //Sorteio apresentação
        System.out.println("Vamos sortear a ordem de apresentação!");
        System.out.print("Digite o primeiro nome:");
        String pessoa1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String pessoa2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String pessoa3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String pessoa4 = scanner.nextLine();
        List<String> lst = new ArrayList<>();
        Collections.addAll(lst, pessoa1,pessoa2, pessoa3,pessoa4);
        Collections.shuffle(lst);
        System.out.println("A ordem de apresentação ficou:"+lst);



        //sorteio apresentação
        System.out.println("Sorteio apresentação!");
        System.out.print("Digite o nome da primeira pessoa:");
        String p1 = scanner.nextLine();
        System.out.print("Digite o nome da segunda pessoa:");
        String p2 = scanner.nextLine();
        System.out.print("Digite o nome da terceira pessoa:");
        String p3 = scanner.nextLine();
        System.out.print("Digite o nome da quarta pessoa:");
        String p4 = scanner.nextLine();
        List<String> lsta = new ArrayList<>();
        Collections.addAll(lst,p1,p2,p3,p4);
        Collections.shuffle(lsta);
        System.out.println("A sequencia  de apresenteção ficou:"+lst);



        //calculo aluguel de um carro
        System.out.println("Vamos calcular o valor de aluguel de um carro");
        System.out.print("Quantos dias ficou com o carro alugado:");
        int dias = scanner.nextInt();
        System.out.print("Quantos km rodou com o carro:");
        int km = scanner.nextInt();
        float diaria = (dias*60)+(km*.15f);
        System.out.printf("O valor total a ser pago pelos %d dias de aluguel do carro é: R$%.2f%n", dias, diaria);



        //tabuada
        System.out.print("Digite um número inteiro:");
        int tabuada1 = scanner.nextInt();
        System.out.println("___________");
        for (int i=0; i<=10;i++){
            System.out.printf("%d x %d = %d%n", tabuada1,i,tabuada1*i);
        }
        System.out.println("___________");

        // Desconto de um produto;
        System.out.println("Vamos calcular o desconto de um produto!");
        System.out.print("Digite o valor de um produto:");
        float produto = scanner.nextFloat();
        System.out.print("Digite o desconto em %:");
        float desconto = scanner.nextFloat();
        float valor_final = produto-(produto*(desconto/100));
        System.out.printf("Com desconto de %.2f%%, o valor do produto é igual=%.2f%n",desconto,valor_final);

        // Conversão dolar em reais
        System.out.println("Vamos converter reais em dolar!");
        System.out.print("Digite o valor em R$ a ser convertido.:R$");
        float reais = scanner.nextFloat();
        System.out.print("Digite o a taxa de câmbio:R$");
        float taxa = scanner.nextFloat();
        float conversao = reais/taxa;
        System.out.printf("R$%.2f convertido para dolar a taxa de R$%.2f é igual U$$%.2f%n",reais, taxa,conversao);

        //aumento no salário
        System.out.print("Digite o seu salário:");
        float salario = scanner.nextFloat();
        System.out.print("Digite o aumento em %:");
        float aumento = scanner.nextFloat();
        float salario_aumento = salario+(salario*(aumento/100));
        System.out.printf("Seu salário de R$%.2f com aumento de %.2f%% é igual: R$%.2f%n", salario, aumento, salario_aumento);


        // calculo metros em cm e mm
        System.out.println("Conversão metros em cm e mm");
        System.out.print("Digite um valor em metros:");
        float metros = scanner.nextFloat();
        float cm = metros*100;
        float mm = metros*1000;
        System.out.printf("%f metros é igual a %.2fcm e %.2fmm %n",metros, cm, mm);

        //média notas
        System.out.println("Vamos calcular a média das suas notas!");
        System.out.print("Digite a primeira nota:");
        float nota1 = scanner.nextFloat();
        System.out.print("Digite a segunda nota:");
        float nota2 = scanner.nextFloat();
        float media = (nota2+nota1)/2;
        System.out.printf("A média das suas notas é:%.2f%n",media);

        // antecessor e sucessor
        System.out.print("Digite um número:");
        int num = scanner.nextInt();
        int ant = num-1;
        int suc = num+1;
        System.out.printf("Você digitou %d e seu antecessor é:%d e seu sucessor é:%d%n", num, ant,suc);

        //exercicio dobro, tiplo e raiz quadrada
        System.out.print("Digite um número inteiro:");
        int numero = scanner.nextInt();
        int dobro = numero*2;
        int triplo = numero*3;
        double raizq = Math.sqrt(numero);
        System.out.printf("Você digitou %d, o dobro é:%d, o triplo:%d e a raiz quadrada é:%.2f%n",numero, dobro,triplo,raizq);

        // calculo area
        System.out.println("Vamos calcular a área");
        System.out.print("Digite a largura:");
        float largura = scanner.nextFloat();
        System.out.print("Digite o comprimento:");
        float comprimento = scanner.nextFloat();
        float area = largura*comprimento;
        System.out.printf("A área de %.2f x %.2f = %.2fm²%n",largura,comprimento,area);

        // Exercicio Tabuada
        System.out.println("Vmso Calcular a tabada!");
        System.out.print("Digite um número inteiro:");
        int tabuada = scanner.nextInt();
        for (int i=0; i<=10; i++){
            System.out.printf("%d x %d = %d%n", tabuada,i,tabuada*i);
        }
        scanner.close();
    }
}
