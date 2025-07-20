package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Livros03;


import java.util.*;

public class LivroTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Livros03> livros03s = new ArrayList<>();
        while (true){
            String titulo= "";
            while (true){
                System.out.print("Titulo:");
                titulo = scanner.nextLine().trim();
                if (titulo.isEmpty()){
                    System.out.println("Campo não pode ser vazio, tente novamente.");
                }else {
                    if (!titulo.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")){
                        System.out.println("Nome não pode conter caracteres. Tente novamente.");
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
                    System.out.println("Campo não pode fica vazio, tente novamente.");
                }else {
                    if (!autor.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")){
                        System.out.println("Digite o nome completo sem caracteres. Tente novamente.");
                    }else {
                        break;
                    }
                }
            }
            double valor =0;
            while (true){
                try {
                    System.out.print("Digite o valor:R$");
                    valor = Double.parseDouble(scanner.nextLine());
                    if (valor<=0){
                        System.out.println("Valor precisa ser maior que zero. Tente novamente.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido. Tente novamente.");
                }
            }
            Livros03 livros03 = new Livros03(titulo,autor,valor);
            livros03s.add(livros03);
            int desconto=0;
            while (true){
                try {
                    System.out.print("Desconto de quantos %?:");
                    desconto = Integer.parseInt(scanner.nextLine());
                    if (desconto<=0 || desconto>=101){
                        System.out.println("Digite um desconto válido, tente novamente.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            for (Livros03 livro : livros03s){
                livro.descontoLivros(desconto);
            }
            String addNovoLivro="";
            do {
                System.out.print("Quer adicionar outro número?(sim/não):");
                addNovoLivro = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoLivro.equals("não") && !addNovoLivro.equals("sim"));
            if (addNovoLivro.equals("não")){
                for (Livros03 livro : livros03s){
                    livro.mostrarResultadosLivros();
                }
                break;
            }

        }
    }
}
