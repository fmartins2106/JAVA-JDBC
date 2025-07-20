package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.*;
import java.util.stream.Collectors;

public class Stream03 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<Produto19> produto19s;

    public Stream03(){
        this.produto19s = new ArrayList<>();
    }

    private void excluirProdutoSistema(String nome){
        boolean produtoEncontrado = produto19s.removeIf(produto19 -> produto19.getNome().equalsIgnoreCase(nome));
        if (produtoEncontrado){
            System.out.println(produtoEncontrado);
            return;
        }
        System.out.println("Nenhum produto foi encontrado com nome"+nome);
    }

    private void listarProduto(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.forEach(System.out::println);
    }

    private void buscarPorCodigo(int codigo){
        List<Produto19> produtoEncontrado = produto19s.stream().filter(produto19 -> produto19.getCodigo() == codigo)
                .collect(Collectors.toList());
        if (produtoEncontrado.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        System.out.println(produtoEncontrado);
    }

    private void buscarPorNome(String nome){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        Optional<Produto19> produtoEncontrado = produto19s.stream().filter(produto19 -> produto19.getNome().equalsIgnoreCase(nome)).findFirst();
        if (produtoEncontrado.isPresent()){
            System.out.println(produtoEncontrado);
            return;
        }
        System.out.println("Produto não encontrado com nome:"+nome);
    }

    private void listarSomenteNomes(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().map(Produto19::getNome)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private void listarPorOrdemAlfabetica(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        produto19s.stream().sorted(Comparator.comparing(Produto19::getNome))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private void produtosMaior100Unidade(){
        if (produto19s.isEmpty()){
            System.out.println("Nenhum produto foi encontrado.");
            return;
        }
        List<Produto19> produtoEncontrado = produto19s.stream().filter(produto19 -> produto19.getQuantidade() > 100)
                .collect(Collectors.toList());
        if (produtoEncontrado.isEmpty()){
            System.out.println("Nenhum produto foi encontrado");
            return;
        }
        System.out.println(produtoEncontrado);
    }

    private void produtosQuantidadeMenor100(){ // retorna todos os dados do objeto
        List<Produto19> produtoEncontrado = produto19s.stream()
                .filter(produto19 -> produto19.getQuantidade() <= 100)
                .collect(Collectors.toList());
        if (produtoEncontrado.isEmpty()){
            System.out.println("Nenhum produto foi encontrado");
            return;
        }
        System.out.println(produtoEncontrado);
    }

//__________________________________________________________________________________________________________________
//    Conteúdo novo

    private void listarQuantidadeMenor100(){ // retorna somente o nome dos produtos
        List<String> produtoEncontrado = produto19s.stream()
                .sorted(Comparator.comparing(Produto19::getNome)) // ordena por nome.
                .filter(produto19 -> produto19.getQuantidade() <= 100) // filtro de regra
                .limit(99) // se eu tiver 150 produtos com estoque menor que 100, ele vai trazer somente 99
                .map(Produto19::getNome) // mostra somente o nome.
                .collect(Collectors.toList()); //criação da lista para materialização das informações geradas pelo stream
        System.out.println(produtoEncontrado);
        if (produtoEncontrado.isEmpty()){
            System.out.println("Nenhum produto foi encontrado");
            return;
        }
        System.out.println(produtoEncontrado);
    }

    private void contarElementos(){
        long contar = produto19s.stream()
                .distinct() //Remove duplicatas, ou seja, garante que cada produto seja contado uma única vez
                .filter(produto19 -> produto19.getValor() <= 4) //Filtra para ficar só os produtos cujo valor é menor ou igual a 4
                .count(); //Conta quantos produtos sobraram após o filtro
        System.out.println(contar);
    }

    //    Pesquisa sobre flatMap
//    Pesquisar sobre reduce


    private void pesquisasPreco(){
        boolean TemMaiorQue9= produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 9);
        boolean temMaiorQue0 = produto19s.stream().anyMatch(produto19 -> produto19.getValor() > 0);
        boolean nenhumMenorQue0 =produto19s.stream().noneMatch(produto19 -> produto19.getValor() < 0);

        produto19s.stream().filter(produto19 -> produto19.getValor() > 3)
                .findFirst()
                .ifPresent(System.out::println); // filtra e traz somente o primeiro valor maior que 3.

        produto19s.stream().filter(produto19 -> produto19.getValor() > 3)  // Filtra produtos com valor > 3
                .max(Comparator.comparing(Produto19::getValor)) // Busca o produto com o maior valor dentro do filtro
                .ifPresent(System.out::println); // retorna primeiro valor maior que 3
    }

    private void somarPrecos(){
        double somaValores = produto19s.stream()
                .mapToDouble(Produto19::getValor) // Pega só os valores (double) dos produtos
                .filter(valor -> valor < 3) // Filtra valores menores que 3
                .sum();                  // Soma todos esses valores filtrados
    }




}
