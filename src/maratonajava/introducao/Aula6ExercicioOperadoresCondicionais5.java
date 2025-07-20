package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.time.LocalDate;

public class Aula6ExercicioOperadoresCondicionais5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);






        ArrayList<Float> jList = new ArrayList<>();
        System.out.println("Vamos calcular as notas dos 6 juizes!");
        for (int j=0;j<6;j++){
            System.out.print("Digite a nota do "+(j+1)+"º juiz:");
            float notas = scanner.nextFloat();
            jList.add(notas);
        }
        float maiorDaLista = Collections.max(jList);
        float menorDaLista = Collections.min(jList);
        jList.remove(maiorDaLista);
        jList.remove(menorDaLista);
        float soma = 0;
        for (float notas : jList){
            soma+=notas;
        }
        float media = soma/ jList.size();
        System.out.println("A média das notas ficou em:"+String.format("%.2f",media));


        int A = 10;
        int B = 20;
        System.out.println("Vamos trocar os valores das variáveis");
        System.out.println("Valores antes da troca:");

        System.out.println("O valor de A é igual:"+A);
        System.out.println("O valor de B é igual:"+B);

        System.out.println("Valores após a troca:");
        int valor = A;
        A = B;
        B = valor;
        System.out.println("O valor de A é igual:"+A);
        System.out.println("O valor de B é igual:"+B);






        System.out.println("Vamos montar uma lista e ordernar por ordem crescente");
        ArrayList<Integer> yourlist = new ArrayList<>();
        System.out.print("Digite quantos números você quer inserir na lista:");
        int numerosDaLista = scanner.nextInt();
        for (int b=0; b<numerosDaLista; b++){
            System.out.print("Digite o "+(b+1)+"º número da lista:");
            int numeros = scanner.nextInt();
            yourlist.add(numeros);
        }
        Collections.sort(yourlist);
        System.out.println("A lista em ordem crescente ficou:"+yourlist);




        ArrayList<Integer> mylist = new ArrayList<>();
        System.out.println("Vamos verificar o maior e o menor da lista");
        System.out.print("Quantas números você quer adicionar na lista?:");
        int people = scanner.nextInt();
        for (int z=0; z<people; z++){
            System.out.print("Digite o "+(z+1)+"º número da lista:");
            int numbers = scanner.nextInt();
            mylist.add(numbers);
        }
        int maiorNumero = Collections.max(mylist);
        int menorNumero = Collections.min(mylist);
        System.out.println("O maior número da lista é:"+maiorNumero);
        System.out.println("O menor número da lista é:"+menorNumero);

        System.out.println("Vamos verificar quantas pessoas maior e menor de idade foram cadastradas");
        ArrayList<Integer> pessoasLista = new ArrayList<>();
        int maiorIdade = 0;
        int menorIdade = 0;
        System.out.print("Quantas pessoas você quer cadastrar:");
        int pessoas = scanner.nextInt();
        for (int p=0; p<pessoas; p++){
            System.out.print("Digite a data de nascimento da "+(p+1)+"º pessoa:");
            int anoNascimento = scanner.nextInt();
            pessoasLista.add(anoNascimento);
            int anoAtual = LocalDate.now().getYear();
            int idade = anoAtual-anoNascimento;
            if (idade>=18){
                maiorIdade++;
            }else{
                menorIdade++;
            }
        }
        System.out.println("Foram cadastradas: "+maiorIdade+" pessoa(s) maior(es) de idade");
        System.out.println("Foram cadastradas: "+menorIdade+" pessoa(s) menor(es) de idade");

        System.out.println("Vamos verifica o menor número da lista!");
        System.out.print("Digite quantos números você quer adicionar na lista:");
        int numero = scanner.nextInt();
        int menorLista = Integer.MAX_VALUE;
        for (int i=0; i<numero; i++){
            System.out.print("Digite o "+(i+1)+"º da lista:");
            int numerosLista = scanner.nextInt();
            if (numerosLista<menorLista){
                menorLista=numerosLista;
            }
        }
        System.out.println("O menor número da lista é:"+menorLista);
        scanner.close();
    }
}
