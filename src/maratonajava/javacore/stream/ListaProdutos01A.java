package academy.devdojo.maratonajava.javacore.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListaProdutos01A {

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


        Map<Categoria,List<ProdutoStrema01>> produtosCategoria = new HashMap<>();
        List<ProdutoStrema01> eletronico = new ArrayList<>();
        List<ProdutoStrema01> alimento = new ArrayList<>();
        List<ProdutoStrema01> vestuario = new ArrayList<>();
        List<ProdutoStrema01> eletrodomestico = new ArrayList<>();

        for (ProdutoStrema01 produtoStrema01 : produtosLoja) {
            switch (produtoStrema01.getCategoria()){
                case ALIMENTO -> alimento.add(produtoStrema01);
                case VESTUARIO -> vestuario.add(produtoStrema01);
                case ELETRONICO -> eletronico.add(produtoStrema01);
                case ELETRODOMESTICO -> eletrodomestico.add(produtoStrema01);
            }
        }

        produtosCategoria.put(Categoria.ALIMENTO,alimento);
        produtosCategoria.put(Categoria.ELETRODOMESTICO,eletrodomestico);
        produtosCategoria.put(Categoria.ELETRONICO,eletronico);
        produtosCategoria.put(Categoria.VESTUARIO,vestuario);

        System.out.println(produtosCategoria);


    }
    public static Map<Categoria, List<ProdutoStrema01>> agruparPorCategoria(List<ProdutoStrema01> produtos) {
        return produtos.stream()
                .collect(Collectors.groupingBy(ProdutoStrema01::getCategoria));
    }






}
