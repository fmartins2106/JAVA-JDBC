package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Livros;

import java.util.ArrayList;

public class LivroTest01 {
    public static void main(String[] args) {
        ArrayList<Livros> livros = new ArrayList<Livros>();

        livros.add(new Livros("1984", "George Orwell",1984));
        livros.add(new Livros("Dom Casmurro", "Machado de Assis",1605));
        livros.add(new Livros("O Senhor dos Anéis", "J.R.R. Tolkien", 1954));

        for (Livros livro : livros){
            livro.exibirDetalhes();
        }


    }
}
