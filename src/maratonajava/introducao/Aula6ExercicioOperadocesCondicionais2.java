package academy.devdojo.maratonajava.introducao;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Aula6ExercicioOperadocesCondicionais2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Vamos calcular as notas dos juizes e fazer a médio excluindo a menor e a maior nota
        ArrayList<Float> jLista = new ArrayList<>();
        System.out.println("Vamos calculas as notas dos juizes!");
        for (int j=0; j<6;j++){
            System.out.print("Digite a nota do "+(j+1)+"º juiz:");
            float notaJuiz = scanner.nextFloat();
            jLista.add(notaJuiz);
        }
        float maiorJuiz = Collections.max(jLista);
        float menorJuiz = Collections.min(jLista);
        jLista.remove(menorJuiz);
        jLista.remove(maiorJuiz);
        float soma = 0;
        for (float notaJuiz : jLista){
            soma+=notaJuiz;
        }
        float media = soma/ jLista.size();
        System.out.println("A média das notas dois juizes é:"+String.format("%.2f",media));


//        vamos comparar os números e veridicar o menor da lista
        System.out.println("Vamos verificar a lista e definir o menor número!");
        System.out.print("Digite quantos elementos você quer adicionar na lista:");
        int xLista = scanner.nextInt();
        if (xLista==0){
            System.out.println("Digite um número positivo para iniciar o programa.");
            return;
        }
        int menorNumero = Integer.MAX_VALUE;
        for (int x=0; x<xLista; x++){
            System.out.print("Digite o "+(x+1)+"º número da lista");
            int numLista = scanner.nextInt();
            if (numLista<menorNumero){
                menorNumero=numLista;
            }
        }
        System.out.println("O menor número digitado foi:"+menorNumero);





//        vamos comparar o número e verificar o maior da lista
        System.out.println("Vamos verificar a lista e definir o maior");
        System.out.print("Digite quanto elementos você quer adicionar na lista:");
        int numerosLista1 = scanner.nextInt();
        if (numerosLista1==0){
            System.out.println("Digite um número positivo!");
            return;
        }
        int numeroMaior = Integer.MIN_VALUE;
        for (int l=0; l<numerosLista1; l++){
           System.out.print("Digite o "+(l+1)+"º número da lista:");
           int osNumeros = scanner.nextInt();
           if (osNumeros>numeroMaior){
               numeroMaior = osNumeros;
            }
        }
        System.out.println("O maior número é:"+numeroMaior);

//        vamos fazer um lista e colocar em ordem crescente
        System.out.println("Vamos fazer uma lista e ordenar por ordem crescente.");
        ArrayList<Integer> alista = new ArrayList<>();
        System.out.print("Digite quantos números você quer adicionar na lista:");
        int nElementos = scanner.nextInt();
        if (nElementos==0){
            return;
        }
        for (int e=0 ;e<nElementos; e++){
            System.out.print("Digite o "+(e+1)+"º número da lista:");
            int numerosLista = scanner.nextInt();
            alista.add(numerosLista);
        }
        Collections.sort(alista);
        System.out.println("A lista em ordem crescente ficou:"+alista);

        ArrayList<Float> lista = new ArrayList<>();
//        exercicio maior e menor peso da lista
        System.out.println("Vamos verificar o maior e o menor peso da lista!");
        for (int i=1;i<=4;i++){
            System.out.print("Digite o "+i+"º peso da lista:");
            float peso = scanner.nextInt();
            lista.add(peso);

        }
        float maior = Collections.max(lista);
        float menor = Collections.min(lista);
        System.out.println("O maior da lista foi:"+String.format("%.2f",maior));
        System.out.println("O menor da lista foi:"+String.format("%.2f",menor));




//        exercicio tabuada
        System.out.println("Vamos calcular uma tabuada");
        System.out.print("Digite um número:");
        int tabuada = scanner.nextInt();
        System.out.println("______________________");
        for (int i=0;i<=10;i++){
            System.out.printf("%d x %d = %d%n",tabuada,i,tabuada*i);
        }
        System.out.println("______________________");


//        Exercicio para verificar quem é de maior ou menor de idade na lista
        int contMaior = 0;
        int contMenor = 0;
        System.out.println("Vamos verificar quantas pessoas são de maior ou de menor de idade");
        for (int i=1; i<=4;i++){
            System.out.print("Em que ano a "+i+"º pessoa nasceu:");
            int anoNascimento = scanner.nextInt();
            int anoAtual = java.time.Year.now().getValue();
            int idade = anoAtual-anoNascimento;
            if (idade>=18){
                contMaior++;
            }else{
                contMenor++;
            }
        }
        System.out.println("Tivemos "+contMaior+" pessoas maiores de idade");
        System.out.println("Tivemos "+contMenor+" pessoas menores de idade");
    }
}
