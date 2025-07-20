package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Pessoas;

public class PessoasExercicio02 {
    public static void main(String[] args) {
        Pessoas pessoa01 = new Pessoas("Maria",39,"maria@hotmail.com");
        Pessoas pessoa02 = new Pessoas("Fernando",36,"fernando@gmail.com");

        pessoa02.apresentar();
        pessoa01.apresentar();

    }
}
