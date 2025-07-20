package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto02;

import java.util.*;

public class ProdutoTest02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Produto02> produto02s = new ArrayList<>();

        while (true){
            String nome;
            while (true){
                System.out.print("Nome do produto:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("ERRO. campo não pode ser vazio, tente novamente.");
                }else {
                    if (!nome.matches("^[\\p{L}]+(\\s[\\p{L}]+)+$")){
                        System.out.println("ERRO. Digite o seu nome completo.");
                    }else {
                        break;
                    }
                }
            }
            double preco=0;
            while (true){
                try {
                    System.out.print("Digite o preço:R$");
                    preco = Double.parseDouble(scanner.nextLine());
                    if (preco<=0){
                        System.out.println("Digite um valor maior que zero.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido.");
                }
            }
            int quantidade = 0;
            while (true){
                System.out.print("Digite a quantidade:");
                if (scanner.hasNextInt()){
                    quantidade = scanner.nextInt();
                    if (quantidade<=-1){
                        System.out.println("ERRO, valor precisa ser positivo.");
                    }else {
                        break;
                    }
                }else {
                    System.out.println("Digite um valor válido positivo.");
                    scanner.nextLine();
                }
            }
            Produto02 produto02 = new Produto02(nome,preco,quantidade);
            produto02s.add(produto02);
            scanner.nextLine();
            String cadastrarOutroProduto;
            do {
                System.out.print("Quer cadastrar outro produto?:");
                cadastrarOutroProduto = scanner.nextLine().trim().toLowerCase();
            }while (!cadastrarOutroProduto.equals("não") && !cadastrarOutroProduto.equals("sim"));
            if (cadastrarOutroProduto.equals("não")){
                for (Produto02 produto : produto02s){
                    produto.mostrandoResultados();
                }
                break;
            }
        }
    }
}
