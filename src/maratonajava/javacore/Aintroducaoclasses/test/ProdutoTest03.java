package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto03;

import java.util.*;

public class ProdutoTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto03> produto03s = new ArrayList<>();

        while (true){
            String nome = "";
            while (true){
                System.out.print("Digite o nome:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Nome não pode ser vazio, tente novamente.");
                }else {
                    if (!nome.matches("^[\\p{L}]+(\\s[\\p{L}]+)*$")){
                        System.out.println("ERRO. Digite a descrição completa do produto.");
                    }else {
                        break;
                    }
                }
            }
            double preco =0;
            while (true){
                try {
                    System.out.print("Digite o valor do produto:R$");
                    preco = Double.parseDouble(scanner.nextLine());
                    if (preco<=0){
                        System.out.println("ERRO. Preço precisa ser maior que 0.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            int quantidade =0;
            while (true){
                System.out.print("Digite a quantidade:");
                if (scanner.hasNextInt()){
                    quantidade = scanner.nextInt();
                    if (quantidade<=0){
                        System.out.println("Quantidade não pode ser menor que zero, tente novamente.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Digite um valor válido.");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();
            Produto03 produto03 =new Produto03(nome,preco,quantidade);
            produto03s.add(produto03);
            String addNovoProduto="";
            do {
                System.out.print("Quer adicionar outro produto?(sim/não):");
                addNovoProduto = scanner.nextLine().trim().toLowerCase();
            }while (!addNovoProduto.equals("não") && !addNovoProduto.equals("sim"));
            if (addNovoProduto.equals("não")){
                for (Produto03 produto : produto03s){
                    produto.motrandoResultadosProdutos();
                }
                break;
            }

        }
    }
}
