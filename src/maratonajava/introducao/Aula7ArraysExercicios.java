package academy.devdojo.maratonajava.introducao;

import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;


public class Aula7ArraysExercicios {
    public static void main(String[] args) {

//        lista objetos
        listaDeObjetos();
//                separando vogais dos nomes
        separandoVogais();

    }

    public static void listaDeObjetos(){
        List<Object> listagem = Arrays.asList(
                "lápis",1.75,
                "boracha", 1.00,
                "caneta", 2.22,
                "caderno",10.55
        );
        System.out.println(repeat("-",40));
        System.out.printf("%27s%n", "lista de preços");
        System.out.println(repeat("-",40));
        Iterator<Object> iterator = listagem.iterator();
        while (iterator.hasNext()){
            String nome = (String) iterator.next();
            Double preco = (Double) iterator.next();
            System.out.printf("%-30s R$%.2f%n",nome, preco);
        }
        System.out.println(repeat("-",40));


    }

    // Método para repetir uma string um número específico de vezes
    public static String repeat(String str, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(str);
        }
        return builder.toString();
    }



    public static void separandoVogais(){
        String[] palavras = {"maria","pedro","joão","paulo","josé","daisy"};
        for (String nome : palavras){
            System.out.print("\nNa palavra "+nome+" temos: ");
            for (char letra: nome.toCharArray()){   // Verifica cada letra dentro de cada nome no Array".
                if ("aeiou".indexOf(Character.toLowerCase(letra))!=-1){ // verifica cada caracter dentro dos nomes, se for diferente de -1, então é aeiou
                    System.out.print(letra+" "); //espaço para imprimir as vogais.
                }
            }
        }
    }
}

//List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
//
//Iterator<Integer> iterator = numeros.iterator();
//while (iterator.hasNext()) {
//Integer numero = iterator.next();
//    if (numero % 2 == 0) {
//        iterator.remove();  // Remove números pares
//    }
//            }
//
//            System.out.println(numeros);  // Exibe a lista após remoção

//
//List<Integer> numeros = Arrays.asList(10, 20, 30, 40);


//Iterator<Integer> iterator = numeros.iterator();
//int soma = 0;
//while (iterator.hasNext()) {
//soma += iterator.next();  // Soma cada número
//}
//        System.out.println("A soma dos números é: " + soma);
//
//List<Integer> numeros = Arrays.asList(10, 15, 20, 25, 30);


//Iterator<Integer> iterator = numeros.iterator();
//while (iterator.hasNext()) {
//Integer numero = iterator.next();
//    if (numero <= 20) {
//        iterator.remove();  // Remove números menores ou iguais a 20
//    }
//            }
//
//            System.out.println(numeros);  // Exibe a lista após filtragem
