package academy.devdojo.maratonajava.introducao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Aula5ExercicioExtraSorteios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Vamos verificar se você tomou uma multa de transito!");
        System.out.print("Digite a velocidade que você estava:");
        float velocidade = scanner.nextFloat();
        float multa1 = velocidade+(velocidade*.50f);
        float multa2 = velocidade+(velocidade*.90f);
        float multa3 = velocidade+(velocidade*1.5f);
        if (velocidade <=80){
            System.out.println("Você é um bom motorista, anda dentro do limite de velocidade.");
        } else if (velocidade >=81 && velocidade <=90){
            System.out.println("você estava a " +velocidade+"Km/h e tomou uma multa de R$"+String.format("%.2f",multa1));
        } else if (velocidade >=91 && velocidade<=120){
            System.out.println("Você estava a " +velocidade+"km/h e tomou uma multa de R$"+String.format("%.2f",multa2));
        }else {
            System.out.println("Você estava a " +velocidade+"Km/h e tomou uma multa de R$"+String.format("%.2f",multa3));
        }



        // sortear somente uma pessoa
        System.out.println("Vamos sortear um aluno");
        System.out.print("Digite o primeiro nome:");
        String aa1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String aa2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String aa3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String aa4 = scanner.nextLine();
        ArrayList<String> nlista = new ArrayList<>();
        nlista.add(aa1);
        nlista.add(aa2);
        nlista.add(aa3);
        nlista.add(aa4);
        int ssorteio = random.nextInt(nlista.size());
        String ssorte = nlista.get(ssorteio);
        System.out.printf("O sortudo foi:%s%n", ssorte);





        //sortear sequencia de pessoas aleatorio.
        System.out.println("Vamos Sortear a ordem deh apresentação!");
        System.out.print("Digite o primeiro nome:");
        String n1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String n2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String n3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String n4 = scanner.nextLine();
        ArrayList<String> lista = new ArrayList<>();
        Collections.addAll(lista,n1,n2,n3,n4);
        Collections.shuffle(lista);
        System.out.println("A sequencia de apresentação ficou:"+lista);



        System.out.print("Digite o primeiro nome:");
        String al1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String al2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String al3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String al4 = scanner.nextLine();
        ArrayList<String> mlista = new ArrayList<>();
        mlista.add(al1);
        mlista.add(al2);
        mlista.add(al3);
        mlista.add(al4);
        int sorte = random.nextInt(mlista.size());
        String sortesua = mlista.get(sorte);
        System.out.println("O grande sortudo foi:"+sortesua);





        System.out.println("Vamos fazer seu cadastro e calcular o seu IMC:");
        System.out.print("Digite o seu nome:");
        String nome = scanner.nextLine();
        System.out.print("Digite a sua idade:");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite a cidade de nascimento:");
        String cidade = scanner.nextLine();
        System.out.print("Digite o seu peso:");
        float peso = scanner.nextFloat();
        System.out.print("Digite a sua altura:");
        float altura = scanner.nextFloat();
        float imc = peso/(altura*2);
        System.out.println("Vamos ao resultado !!!!");
        System.out.println("_____________________________________________");
        System.out.printf("O seu nome é: %s%n",nome);
        System.out.printf("Sua idade é: %d%n",idade);
        System.out.printf("Sua cidade é: %s%n",cidade);
        System.out.printf("A sua altura:%.2f%n",altura);
        System.out.printf("O peso:%.2fKg%n",peso);
        System.out.printf("Seu IMC é:%.2f%n",imc);
        System.out.println("_____________________________________________");





        System.out.print("Digite o primeiro nome:");
        String a1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String a2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String a3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String a4 = scanner.nextLine();
        ArrayList<String> lst = new ArrayList<>();
        lst.add(a1);
        lst.add(a2);
        lst.add(a3);
        lst.add(a4);
        int sorteio2 = random.nextInt(lst.size());
        String sortudo = lst.get(sorteio2);
        System.out.println("O grande sortudo foi:"+sortudo);





        System.out.println("Vamos agora sortear somente 1 pessoa.");
        System.out.print("Digite o primeiro nome:");
        String p1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String p2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String p3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String p4 = scanner.nextLine();
        ArrayList<String> lista2 = new ArrayList<>();
        lista2.add(p1);
        lista2.add(p2);
        lista2.add(p3);
        lista2.add(p4);
        int sorteio = random.nextInt(lista2.size());
        String sorteado = lista2.get(sorteio);
        System.out.println("O grande sortudo foi:"+sorteado);



        System.out.println("Vamos Sortear a ordem deh apresentação!");
        System.out.print("Digite o primeiro nome:");
        String nn1 = scanner.nextLine();
        System.out.print("Digite o segundo nome:");
        String nn2 = scanner.nextLine();
        System.out.print("Digite o terceiro nome:");
        String nn3 = scanner.nextLine();
        System.out.print("Digite o quarto nome:");
        String nn4 = scanner.nextLine();
        ArrayList<String> alista = new ArrayList<>();
        Collections.addAll(alista,nn1,nn2,nn3,nn4);
        Collections.shuffle(alista);
        System.out.println("A sequencia de apresentação ficou:"+lista);

        System.out.println("Fazer a tabuada!");
        System.out.print("Digite um número inteiro:");
        int tabuada = scanner.nextInt();
        for (int i = 0; i <= 10; i += 1) {
            System.out.printf("%d x %d = %d%n", tabuada, i, tabuada * i);
        }
        scanner.close();
    }

}
