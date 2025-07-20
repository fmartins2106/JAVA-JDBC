package academy.devdojo.maratonajava.javacore.Aintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Aintroducaometodos.dominio.Funcionarios;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Funcionarios funcionario = new Funcionarios();
        funcionario.nome = "Fernando";
        funcionario.idade = 21;
        funcionario.salarios = new double[]{2000,2300,1800};

        funcionario.imprimir();
    }
}
