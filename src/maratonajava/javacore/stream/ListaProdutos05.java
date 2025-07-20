package academy.devdojo.maratonajava.javacore.stream;

import java.util.*;
import java.util.stream.Collectors;

public class ListaProdutos05 {
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

    public static Map<Categoria03,List<ProdutoStream03>> produtosPorCategoria(){
        return produtosLoja.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03));
    }

    public static Map<Categoria03,Map<Promocao03,List<ProdutoStream03>>> produtosPorCategoriaPromocao(List<ProdutoStream03> produtos){
        return produtos.stream().collect(Collectors.groupingBy(ProdutoStream03::getCategoria03
        ,Collectors.groupingBy(produtoStream03 -> produtoStream03.getPreco() < 5 ?
                        Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL)));
    }

    public static Map<Promocao03,List<ProdutoStream03>> agruparProdutosPromocao(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors
                    .groupingBy(produtoStream03
                        -> produtoStream03.getPreco() < 5 ? Promocao03.PROMOCAO : Promocao03.PRECO_NORMAL));
    }

    public static Map<Categoria03,Long> contarProdutosPorCategoria(List<ProdutoStream03> produto){
        return produto.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03
                ,Collectors.counting()));
    }

    public static Map<Categoria03, Optional<ProdutoStream03>> produtosMaisCaroCategoria(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03
                ,Collectors.maxBy(Comparator.comparing(ProdutoStream03::getPreco))));
    }

    public static Map<Categoria03,DoubleSummaryStatistics> estatisticasCategoria(List<ProdutoStream03> proodutos){
        return proodutos.stream().collect(Collectors.groupingBy(ProdutoStream03::getCategoria03
        ,Collectors.summarizingDouble(ProdutoStream03::getPreco)));
    }

    public static Map<Categoria03,Map<Promocao03,List<ProdutoStream03>>> agruparPorMetodoAuxiliar(List<ProdutoStream03> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03,
                        Collectors.groupingBy(ListaProdutos05::getPromocao)));
    }



}
