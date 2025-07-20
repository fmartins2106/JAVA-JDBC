package academy.devdojo.maratonajava.javacore.Aintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Aintroducaometodos.dominio.ContaBancaria;

public class ContaBancariaExercicio01 {
    public static void main(String[] args) {
        ContaBancaria contaBancaria = new ContaBancaria();
        contaBancaria.setTitular("Ana");
        contaBancaria.setSaldo(5000.00);
        System.out.println(contaBancaria.getTitular());
        System.out.println(contaBancaria.getSaldo());
    }
}
