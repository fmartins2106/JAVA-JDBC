package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;


import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto08;


import java.util.*;

public class ProdutoTest08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto08> produto08s = new ArrayList<>();
        while (true){
            int opcao=0;
            System.out.println("[ 1 ] Cadastrar produto.");
            System.out.println("[ 2 ] Relatório produtos cadastrados.");
            System.out.println("[ 3 ] Relatório ordenado por preço.");
            System.out.println("[ 4 ] Alterar produto cadastrado.");
            System.out.println("[ 5 ] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao<=0 || opcao>=6){
                    System.out.println("ERRO. Digite uma opção válida. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException erro){
                System.out.println("Digite uma opção válida. Tente novamente.");
            }
            switch (opcao){
                case 1:
                    System.out.println("Cadastro de produto.");
                    String nome = Produto08.validandoNome(scanner);
                    double valor = Produto08.validandoValor(scanner);
                    String categoria = Produto08.validandoCategoria(scanner);
                    Produto08 produto08 = new Produto08(nome,valor,categoria);
                    produto08s.add(produto08);
                    break;

                case 2:
                    if (produto08s.isEmpty()){
                        System.out.println("Campo não pode ficar vazio. Tente novamente.");
                    }else {
                        for (int i = 0; i < produto08s.size(); i++) {
                            Produto08 produtos = produto08s.get(i);
                            produtos.exibindoRelatorio(i, produto08s.size());
                        }
                    }
                    break;

                case 3:
                    if (produto08s.isEmpty()){
                        System.out.println("Campo não pode ficar vazio. Tente novamente.");
                    }else {
                        ArrayList<Produto08> cloneList = new ArrayList<>();
                        for (Produto08 produtos : produto08s){
                            cloneList.add(produtos.clone());
                        }
                        Collections.sort(cloneList, Comparator.comparingDouble(Produto08::getValor));
                        for (int i = 0; i < cloneList.size(); i++) {
                            Produto08 produto = cloneList.get(i);
                            produto.exibindoRelatorio(i,cloneList.size());
                        }
                    }
                    break;

                case 4:
                    if (produto08s.isEmpty()){
                        System.out.println("Lista vazia, tente novamente.");
                    }else {
                        System.out.println("Alterando cadastro produto.");
                        while (true){
                            try {
                                System.out.print("Digite o número do cadastro:");
                                int cadastro = Integer.parseInt(scanner.nextLine());
                                if (cadastro<0 || cadastro>= produto08s.size()){
                                    System.out.println("ERRO. Digite um número de cadastro válido. Tente novamente.");
                                }else {
                                    Produto08 trocaDadosProduto = produto08s.get(cadastro);
                                    String novoNome = Produto08.validandoNome(scanner);
                                    trocaDadosProduto.setNome(novoNome);
                                    double novoValor = Produto08.validandoValor(scanner);
                                    trocaDadosProduto.setValor(novoValor);
                                    String novoCategoria = Produto08.validandoCategoria(scanner);
                                    trocaDadosProduto.setCategoria(novoCategoria);
                                    break;
                                }
                            }catch (NumberFormatException erro){
                                System.out.println("Erro. Digite um cadastro válido. Tente novamente.");
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println(">>>Finalizando o programa...");
                    return;

                default:
                    System.out.println("ERRO. Cadastro não encontrado. Tente novamente.");

            }
        }
    }
}
