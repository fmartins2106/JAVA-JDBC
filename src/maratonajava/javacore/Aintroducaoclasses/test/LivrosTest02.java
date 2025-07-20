package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Livros02;

import java.util.*;

public class LivrosTest02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Livros02> livros02s = new ArrayList<>();
        while (true){
            String titulo = "";
            while (true){
                System.out.print("Titulo:");
                titulo = scanner.nextLine().trim();
                if (titulo.isEmpty()){
                    System.out.println("Digite o nome do livro.");
                }else {
                    if (!titulo.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")){
                        System.out.println("Digite o titulo completo do livro.");
                    }else {
                        break;
                    }
                }
            }
            String autor="";
            while (true){
                System.out.print("Autor:");
                autor = scanner.nextLine().trim();
                if (autor.isEmpty()){
                    System.out.println("Campo não pode ficar vazio, tente novamente.");
                }else {
                    if (!autor.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")){
                        System.out.println("Digite o nome completo do autor.");
                    }else {
                        break;
                    }
                }
            }
            int ano = 0;
            int anoAtual = java.time.Year.now().getValue();
            while (true){
                try {
                    System.out.print("Ano de publicação:");
                    ano = Integer.parseInt(scanner.nextLine());
                    if (ano<=1800 || ano>=anoAtual){
                        System.out.println("Tente novamente, ano não pode ser menor que 1800 ou maior que ano atual.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um ano válido. Tente novamente.");
                }
            }
            double preco=0;
            while (true){
                try {
                    System.out.print("Digite o preço:R$");
                    preco = Double.parseDouble(scanner.nextLine());
                    if (preco<=0){
                        System.out.println("Preço não pode ser menor ou igual a zero. Tente novamente.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            Livros02 livros02 = new Livros02(titulo,autor,ano,preco);
            livros02s.add(livros02);
            String addNovoLivro;
            do {
                System.out.print("Quer adicionar outro livro?(sim/não):");
                addNovoLivro = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoLivro.equals("sim") && !addNovoLivro.equals("não"));
            if (addNovoLivro.equals("não")){
                for (Livros02 livro : livros02s){
                    livro.monstrandoDadosLivros();
                }
                break;
            }
        }
    }
}
