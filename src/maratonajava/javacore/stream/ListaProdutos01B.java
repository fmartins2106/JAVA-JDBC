package academy.devdojo.maratonajava.javacore.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListaProdutos01B {
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

    public static void main(String[] args) {
//        Agrupa todos os produtos em duas listas com base no preço — se estão em promoção ou não.
        Map<Promocao01,List<ProdutoStrema01>> colecao = produtosLoja.stream()
                .collect(Collectors.groupingBy(produtoStrema01 -> {
                    return produtoStrema01.getPreco() < 6 ? Promocao01.PROMOCAO : Promocao01.PRECO_NORMAL;
                }));
        System.out.println(colecao);

//        Agrupa os produtos primeiro por categoria, depois por promoção dentro de cada categoria.
        Map<Categoria,Map<Promocao01,List<ProdutoStrema01>>> colecao2 = produtosLoja.stream()
                .collect(Collectors.groupingBy(ProdutoStrema01::getCategoria,
                        Collectors.groupingBy(produtoStrema01 -> produtoStrema01.getPreco() < 6 ? Promocao01.PROMOCAO : Promocao01.PRECO_NORMAL)));
        System.out.println(colecao2);

//        Conta quantos produtos há em cada categoria.
        Map<Categoria,Long> colecao3 = produtosLoja.stream()
                .collect(Collectors.groupingBy(ProdutoStrema01::getCategoria,Collectors.counting()));
        System.out.println(colecao3);

//         Categoria → Optional<Produto mais caro>.
        Map<Categoria, Optional<ProdutoStrema01>> colecao5 = produtosLoja.stream()
                .collect(Collectors.groupingBy(ProdutoStrema01::getCategoria,Collectors
                        .maxBy(Comparator.comparing(ProdutoStrema01::getPreco))));
        System.out.println(colecao5);

//        Também encontra o produto mais caro por categoria, mas resolve conflitos com maxBy diretamente, sem usar Optional.
        Map<Categoria, ProdutoStrema01> colecao6 = produtosLoja.stream()
                .collect(Collectors.toMap(ProdutoStrema01::getCategoria, Function.identity(),
                                BinaryOperator.maxBy(Comparator.comparing(ProdutoStrema01::getPreco))));
        System.out.println(colecao6);

//      Gera estatísticas como média, soma, min, max e count dos preços por categoria.
        Map<Categoria,DoubleSummaryStatistics> colecao7 = produtosLoja.stream()
                .collect(Collectors.groupingBy(ProdutoStrema01::getCategoria,Collectors.summarizingDouble(ProdutoStrema01::getPreco)));
        System.out.println(colecao7);

//        Mesmo objetivo da colecao2, mas usa o método getPromocao01() como encapsulamento da lógica de preço.
        Map<Categoria,Map<Promocao01,List<ProdutoStrema01>>> colecao8 = produtosLoja.stream()
                .collect(Collectors.groupingBy(
                        ProdutoStrema01::getCategoria,
                        Collectors.groupingBy(ListaProdutos01B::getPromocao01,Collectors.toList())
                ));
        System.out.println(colecao8);;


//        Retorna quais promoções existem em cada categoria, sem repetir e mantendo a ordem de inserção.
        Map<Categoria,LinkedHashSet<Promocao01>> colecao9 = produtosLoja.stream()
                .collect(Collectors.groupingBy(
                        ProdutoStrema01::getCategoria,
                        Collectors.mapping(ListaProdutos01B::getPromocao01,Collectors.toCollection(LinkedHashSet::new))));
        System.out.println(colecao9);;


    }


//    Encapsula a regra de promoção com base no preço para reutilização no código.
    private static Promocao01 getPromocao01(ProdutoStrema01 produtoStrema01){
        return produtoStrema01.getPreco() < 6 ? Promocao01.PROMOCAO : Promocao01.PRECO_NORMAL;
    }




}
