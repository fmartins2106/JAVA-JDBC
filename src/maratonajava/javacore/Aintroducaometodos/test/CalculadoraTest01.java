package academy.devdojo.maratonajava.javacore.Aintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Aintroducaometodos.dominio.Calculadora;

public class CalculadoraTest01 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.somaDoisNumeros();

        System.out.println(">>>Finalizando..");

        calculadora.subtraiDoisNumeros();

        double result = calculadora.dividindoDoisNumeros(10,2);
        System.out.println(result);
    }

}
