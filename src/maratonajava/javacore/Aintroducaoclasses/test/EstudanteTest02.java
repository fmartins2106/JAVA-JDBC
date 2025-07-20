package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Estudante;

public class EstudanteTest02 {
    public static void main(String[] args) {
        Estudante estudante = new Estudante();
        Estudante estudante2 =new Estudante();

        estudante.nome = "Fernando";
        System.out.println("nome:"+estudante.nome);

        System.out.println("_________________");

        estudante2.nome ="Joana";
        System.out.println("Nome:"+estudante2.nome);
    }
}
