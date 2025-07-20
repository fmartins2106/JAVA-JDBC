package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto;

public class ProdutoExercicio01 {
    public static void main(String[] args) {
        Produto produto01 = new Produto("Nootbook",3500.0);
        Produto produto02 = new Produto("Nootbook",3500.0);
        System.out.println("Comparando com ==: "+(produto01 == produto02));
        System.out.println("Comparando com equals():"+produto01.equals(produto02));
    }
}
