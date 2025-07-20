package academy.devdojo.maratonajava.javacore.Aintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Aintroducaometodos.dominio.Estudante;
import academy.devdojo.maratonajava.javacore.Aintroducaometodos.dominio.ImpressoraEstudante;

public class EstudanteTest01 {
    public static void main(String[] args) {
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();
        ImpressoraEstudante impressora = new ImpressoraEstudante();

        estudante01.nome = "Maria";
        estudante01.idade = 15;
        estudante01.sexo ='m';

        estudante02.nome = "Fernando";
        estudante02.idade = 14;
        estudante02.sexo ='m';

        impressora.imprime(estudante01);
        impressora.imprime(estudante02);
    }

}
