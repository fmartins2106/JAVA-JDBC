package academy.devdojo.maratonajava.javacore.Aintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Aintroducaometodos.dominio.Calculadora;

public class CalculadoraTest3 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int[] numeros ={1,2,3,4,5};
        calculadora.somarArray(numeros);
        calculadora.somaVarArgs(1,2,3,4,5,6);
    }
}
