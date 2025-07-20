package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListaProdutos03B {
    private static List<ProdutoStream03> produtosLoja = new ArrayList<>(List.of(
            new ProdutoStream03("Chaleira Eletrica", 100, 120.23, Categoria03.ELETRONICO),
            new ProdutoStream03("Arroz branco 1kg", 222, 2.32, Categoria03.ALIMENTO),
            new ProdutoStream03("Feijão Carioca 1kg", 222, 5.32, Categoria03.ALIMENTO),
            new ProdutoStream03("Trigo 1kg", 222, 3.32, Categoria03.ALIMENTO),
            new ProdutoStream03("Iphone", 442, 3.455, Categoria03.ELETRONICO),
            new ProdutoStream03("Camisa branca basica", 522, 60.32, Categoria03.VESTUARIO),
            new ProdutoStream03("Calça Jeans Masculina", 2222, 90.32, Categoria03.VESTUARIO),
            new ProdutoStream03("Liquidificador", 322, 122.52, Categoria03.ELETRODOMESTICO),
            new ProdutoStream03("Macarrão 500gr", 222, 2.12, Categoria03.ALIMENTO)
    ));

    public static Promocao03 getPromocao(ProdutoStream03 produtoStream03){
        return produtoStream03.getPreco() < 5 ? Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL;
    }

    public static Map<Promocao03,List<ProdutoStream03>> agruparPorPromocao(List<ProdutoStream03> produtos){
        return produtos.stream().collect(
                Collectors.groupingBy(produtoStream03 -> produtoStream03.getPreco() < 5 ?
                        Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL));
    }


     public static Map<Categoria03,Map<Promocao03,List<ProdutoStream03>>> agruparPorCategoriaEPromocao(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,
                        Collectors.groupingBy(produtoStream03 -> produtoStream03.getPreco() < 6 ?
                                Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL)));
     }

     public static Map<Categoria03,Long> contandoProdutosCategoria(List<ProdutoStream03> produtos){
        return produtos.stream().collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,
                Collectors.counting()));
     }
//    ________________________________________________________________________________________________________________

    public static Map<Categoria03,List<ProdutoStream03>> produtosPorCategoria(){
        return produtosLoja.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03));
    }

    public static Map<Promocao03,List<ProdutoStream03>> produtosPorPromocao(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(produtoStream03 -> produtoStream03.getPreco() < 5 ?
                        Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL));
    }

    public static Map<Categoria03,Map<Promocao03,List<ProdutoStream03>>> agruparProdutoCategoriaPromocao(List<ProdutoStream03> produto){
        return produto.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,
                        Collectors.groupingBy(produtoStream03 -> produtoStream03.getPreco() < 5 ?
                                Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL)));
    }

    public static Map<Categoria03,Long> contarProdutosPorCategoria(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,Collectors.counting()));
    }

    public static Map<Categoria03,Optional<ProdutoStream03>> maisCaroPorCategoriaComOptional2(List<ProdutoStream03> produtos){
       return produtos.stream()
               .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03
               ,Collectors.maxBy(Comparator.comparing(ProdutoStream03::getPreco))));
    }

    public static Map<Categoria03, DoubleSummaryStatistics> estatisticasProCategoria(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03
                ,Collectors.summarizingDouble(ProdutoStream03::getPreco)));
    }

    public static Map<Categoria03,Map<Promocao03,List<ProdutoStream03>>> agruparPorMetodoAuxilar2(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03
                ,Collectors.groupingBy(ListaProdutos03B::getPromocao)));
    }





     //________________________________________________________________________________________________________
     public static Map<Categoria03, Optional<ProdutoStream03>> maisCaroPorCategoriaComOptional(List<ProdutoStream03> produtos){
        return produtos.stream().collect(Collectors.groupingBy(
                ProdutoStream03::getCategoria03
                ,Collectors.maxBy(Comparator.comparing(ProdutoStream03::getPreco))));
     }


    public static Map<Categoria03,ProdutoStream03> maisCaroPorCategoria(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.toMap(
                        ProdutoStream03::getCategoria03,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(ProdutoStream03::getPreco))
                ));
    }

    public static Map<Categoria03,DoubleSummaryStatistics> estatisticasPorCategoria(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,
                        Collectors.summarizingDouble(ProdutoStream03::getPreco)));
    }

    public static Map<Categoria03,Map<Promocao03,List<ProdutoStream03>>> agruparPorMetodoAuxilar(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03
                        ,Collectors.groupingBy(ListaProdutos03B::getPromocao)));
    }

    public static Map<Categoria03,LinkedHashSet<Promocao03>> promocoesPorCategoria(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,
                        Collectors.mapping(ListaProdutos03B::getPromocao,
                        Collectors.toCollection(LinkedHashSet::new))));
    }

    // Método público e estático que retorna um Map agrupando promoções por categoria.
// A chave do Map é uma Categoria03, e o valor é um LinkedHashSet de Promocao03.
// Ele recebe como entrada uma lista de ProdutoStream03.
    public static Map<Categoria03, LinkedHashSet<Promocao03>> promocoesPorCategoria2(List<ProdutoStream03> produtos) {

        // Inicia um stream sobre a lista de produtos
        return produtos.stream()

                // Coleta (agrupa) os elementos do stream em um Map,
                // onde a chave é obtida usando o método getCategoria03 de cada produto
                .collect(Collectors.groupingBy(
                        ProdutoStream03::getCategoria03, // função que extrai a chave do agrupamento

                        // Para os valores agrupados por categoria, aplicamos um mapeamento:
                        // transformamos cada produto na sua promoção (getPromocao)
                        Collectors.mapping(
                                ListaProdutos03B::getPromocao, // função que extrai a promoção do produto

                                // E coletamos essas promoções em um LinkedHashSet (mantém a ordem e evita duplicatas)
                                Collectors.toCollection(LinkedHashSet::new)
                        )
                ));
    }


    //    _________________________________________________________ Método Main ________________________________________
    public static void main(String[] args) {

        System.out.println(promocoesPorCategoria(produtosLoja));

        System.out.println(agruparPorMetodoAuxilar(produtosLoja));
        maisCaroPorCategoriaComOptional2(produtosLoja).forEach((categoria03, produtoStream03) -> {
            produtoStream03.ifPresentOrElse(produtoStream4 ->
                    System.out.println("Categoria:"+categoria03
                            +" |Produtos:"+produtoStream4.getNome()
                            +" |Preço:R$"+produtoStream4.getPreco()), () -> System.out.println("Produtos não encontrados."));
        });


        for (ProdutoStream03 produtoStream03 : produtosLoja) {
            System.out.println(getPromocao(produtoStream03));
        }

        System.out.println("______________________________________________________________");
        agruparPorPromocao(produtosLoja).forEach((promocao03, produto) -> {
            System.out.println("Preço:"+promocao03.toString());
            produto.forEach(p-> System.out.println(" -Nome:"+p.getNome()+" |R$:"+p.getPreco()));
        });
        System.out.println("_________________________________________________");

        agruparPorCategoriaEPromocao(produtosLoja).forEach((categoria03, mapaPromocao) -> {
            System.out.println("Categoria:"+categoria03); mapaPromocao.forEach((promocao03, produtos) -> {
                System.out.println("Preço:"+promocao03);
                produtos.forEach(p -> System.out.println(" -"+p.getNome()+" |R$"+p.getPreco()));
            });
        });

//        opção 1
        contandoProdutosCategoria(produtosLoja).forEach((categoria03, aLong) ->
            System.out.println("Categoria:"+categoria03+" |Quantidade:"+aLong)
        );

//        opção 2
        System.out.println("_________________________________________________");
        System.out.println("Agrupamento:"+contandoProdutosCategoria(produtosLoja));
        System.out.println("_________________________________________________");

        maisCaroPorCategoria(produtosLoja).forEach((categoria03, produtoStream03) ->
                System.out.println("Categoria:"+categoria03+" |Nome:"+produtoStream03.getNome()+ "|Preço:R$"+produtoStream03.getPreco()));



        System.out.println("_______________________________");
        System.out.println(maisCaroPorCategoriaComOptional(produtosLoja));
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println(maisCaroPorCategoria(produtosLoja));

        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println(estatisticasPorCategoria(produtosLoja));

        estatisticasPorCategoria(produtosLoja).forEach((categoria03, doubleSummaryStatistics) -> {
            System.out.println("Produto:"+categoria03+" |Média:"+doubleSummaryStatistics.getAverage()) ;
        });
    }


}
