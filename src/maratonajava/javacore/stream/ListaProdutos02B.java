package academy.devdojo.maratonajava.javacore.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListaProdutos02B {
    private static List<ProdutoStrema01> produtosLoja = new ArrayList<>(List.of(
            new ProdutoStrema01("Chaleira Eletrica",100,120.23,Categoria.ELETRONICO),
            new ProdutoStrema01("Arroz branco 1kg",222,2.32,Categoria.ALIMENTO),
            new ProdutoStrema01("Feijão Carioca 1kg",222,5.32,Categoria.ALIMENTO),
            new ProdutoStrema01("Trigo 1kg",222,3.32,Categoria.ALIMENTO),
            new ProdutoStrema01("Iphone",442,3.455,Categoria.ELETRONICO),
            new ProdutoStrema01("Camisa branca basica",522,60.32,Categoria.VESTUARIO),
            new ProdutoStrema01("Calça Jeans Masculina",2222,90.32,Categoria.VESTUARIO),
            new ProdutoStrema01("Liquidificador",322,122.52,Categoria.ELETRODOMESTICO),
            new ProdutoStrema01("Macarrão 500gr",222,2.12,Categoria.ALIMENTO)
    ));




    //    Encapsula a regra de promoção com base no preço para reutilização no código.
    private static Promocao01 getPromocao02(ProdutoStrema01 produtoStrema01){
        return produtoStrema01.getPreco() < 6 ? Promocao01.PROMOCAO : Promocao01.PRECO_NORMAL;
    }


    //        Agrupa todos os produtos em duas listas com base no preço — se estão em promoção ou não.
    public static Map<Promocao01,List<ProdutoStrema01>> agruparPromocao(List<ProdutoStrema01> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(produtoStrema01
                        -> produtoStrema01.getPreco() < 6 ? Promocao01.PROMOCAO : Promocao01.PRECO_NORMAL));
    }

//    Agrupa os produtos primeiro por categoria, depois por promoção dentro de cada categoria.
    public static Map<Categoria,Map<Promocao01,List<ProdutoStrema01>>> agruparPorCategoriaEPromocao(List<ProdutoStrema01> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStrema01::getCategoria,
                        Collectors.groupingBy(produtoStrema01 -> produtoStrema01.getPreco() < 6 ? Promocao01.PROMOCAO : Promocao01.PRECO_NORMAL)));
    }

    //        Conta quantos produtos há em cada categoria.

    public static Map<Categoria,Long> contarProdutosPorCategoria(List<ProdutoStrema01> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStrema01::getCategoria,Collectors.counting()));
    }

    //         Categoria → Optional<Produto mais caro>.

    public static Map<Categoria, Optional<ProdutoStrema01>> maisCaroPorCategoriaComOptional(List<ProdutoStrema01> produtos){
        return produtos.stream().collect(Collectors.groupingBy(
                ProdutoStrema01::getCategoria,
                Collectors.maxBy(Comparator.comparing(ProdutoStrema01::getCategoria))));
    }

    //        Também encontra o produto mais caro por categoria, mas resolve conflitos com maxBy diretamente, sem usar Optional.
    public static Map<Categoria,ProdutoStrema01> maisCaroPorCategoria(List<ProdutoStrema01> produtos){
        return produtos.stream()
                .collect(Collectors.toMap(
                        ProdutoStrema01::getCategoria,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(ProdutoStrema01::getPreco)
                )));
    }

    //      Gera estatísticas como média, soma, min, max e count dos preços por categoria.
    public static Map<Categoria,DoubleSummaryStatistics> statisticasPorCategoria(List<ProdutoStrema01> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(
                        ProdutoStrema01::getCategoria,
                        Collectors.summarizingDouble(ProdutoStrema01::getPreco)
                ));
    }

//       Agrupar por categoria e promoção usando método auxiliar

    public static Map<Categoria,Map<Promocao01,List<ProdutoStrema01>>> agruparComMetodoAuxiliar(List<ProdutoStrema01> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(
                        ProdutoStrema01::getCategoria,
                        Collectors.groupingBy(ListaProdutos02B::getPromocao02)

                ));
    }

    //        Retorna quais promoções existem em cada categoria, sem repetir e mantendo a ordem de inserção.

    public static Map<Categoria,LinkedHashSet<Promocao01>> promocoesPorCategoria(List<ProdutoStrema01> produtos){
        return produtos.stream()
                .collect(Collectors.groupingBy(
                        ProdutoStrema01::getCategoria,
                        Collectors.mapping(
                                ListaProdutos02B::getPromocao02,
                                Collectors.toCollection(LinkedHashSet::new)
                        )
                ));
    }


}
