package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto04;


import java.util.*;

public class ProdutoTest04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Produto04> produto04s = new ArrayList<>();

        while (true){
            String nome ="";
            while (true){
                System.out.print("Nome do produto:");
                nome = scanner.nextLine().trim();
                if (nome.isEmpty()){
                    System.out.println("Nome não pode ser vazio, tente novamente.");
                }else {
                    if (!nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
                        System.out.println("Campo nome não pode conter caracteres, digite o nome completo.");
                    }else {
                        break;
                    }
                }
            }
            double valor=0;
            while (true){
                try {
                    System.out.print("Digite o valor:");
                    valor = Double.parseDouble(scanner.nextLine());
                    if (valor<=-1 || valor >=10000.01){
                        System.out.println("Vamos precisa ser igual ou maior que zero e menor que 10.000");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido. Tente novamente.");
                }
            }
            int quantidade = 0;
            while (true){
                try {
                    System.out.print("Digite a quantidade:");
                    quantidade = Integer.parseInt(scanner.nextLine());
                    if (quantidade<=-1){
                        System.out.println("Quantidade não pode ser negativa, tente novamente.");
                    }else {
                        break;
                    }
                }catch (NumberFormatException erro){
                    System.out.println("Digite um valor válido. Tente novamente.");
                }
            }
            Produto04 produto04 = new Produto04(nome,valor,quantidade);
            produto04s.add(produto04);
            String addNovProduto;
            while (true){
                System.out.print("Quer adicionar outro produto?(sim/não):");
                addNovProduto = scanner.nextLine().trim().toLowerCase();
                if (addNovProduto.equals("sim") || addNovProduto.equals("não")){
                    break;
                }else {
                    System.out.println("Digite apenas sim ou não.");
                }
            }
            if (addNovProduto.equals("não")){
                for (int i=0;i<produto04s.size();i++){
                    Produto04 produto = produto04s.get(i);
                    produto.resultadoEtoqueProdutos(i,produto04s.size());
                }
                break;
            }
        }
    }
}
