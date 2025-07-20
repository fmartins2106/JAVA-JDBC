package academy.devdojo.maratonajava.javacore.lambda;

import java.util.function.*;

public class LambdasBasicas {

    public static void main(String[] args) {
        System.out.println(ePar.test(10));                      // true
        saudacao.accept("Fernando");                            // Olá Fernando
        System.out.println(somar.apply(5, 7));                  // 12
        System.out.println(mensagem.get());                     // Seja bem-vindo!
        System.out.println(tamanhoString.apply("DevDojo"));     // 7
        tarefa.run();                                           // Executando Runnable!
    }

    // Predicate<T>: Usado para testar condições (retorna true ou false)
    // Exemplo: verificar se um número é par
    static Predicate<Integer> ePar = numero -> numero % 2 == 0;

    // Consumer<T>: Executa uma ação com um valor, sem retorno
    // Exemplo: imprimir uma saudação com o nome informado
    static Consumer<String> saudacao = nome -> System.out.println("Olá " + nome);

    // BiFunction<T,U,R>: Recebe dois valores e retorna um resultado
    // Exemplo: somar dois números inteiros
    static BiFunction<Integer, Integer, Integer> somar = (a, b) -> a + b;

    // Supplier<T>: Fornece um valor sem receber entrada
    // Exemplo: retornar uma mensagem padrão
    static Supplier<String> mensagem = () -> "Seja bem-vindo!";

    // Function<T,R>: Transforma um valor em outro
    // Exemplo: pegar o tamanho de uma string
    static Function<String, Integer> tamanhoString = s -> s.length();

    // Runnable: Executa um bloco de código sem entrada nem retorno
    // Exemplo: imprimir uma mensagem simples ao rodar
    static Runnable tarefa = () -> System.out.println("Executando Runnable!");

}
