package academy.devdojo.maratonajava.javacore.Aintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Aintroducaometodos.dominio.Calculadora;

public class CalculadoraTest02 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.multiplicarDoisNumeros(2,2);

        double calculando = calculadora.dividindoDoisNumeros(30,3);
        System.out.println(calculando);

        System.out.println("____________________________-");
        calculadora.dividindoDoisNumeros2(84,2);
    }
}
