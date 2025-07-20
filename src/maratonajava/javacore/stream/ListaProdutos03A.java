package academy.devdojo.maratonajava.javacore.stream;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Produto19;

import java.util.*;
import java.util.stream.Collectors;

public class ListaProdutos03A {
    private static List<ProdutoStream03> produtosLoja = new ArrayList<>(List.of(
            new ProdutoStream03("Arroz branco 1kg",222,2.32,Categoria03.ALIMENTO),
            new ProdutoStream03("Chaleira Eletrica",100,120.23,Categoria03.ELETRODOMESTICO),
            new ProdutoStream03("Feijão Carioca 1kg",222,5.32,Categoria03.ALIMENTO),
            new ProdutoStream03("Iphone",442,3.455,Categoria03.ELETRONICO),
            new ProdutoStream03("Trigo 1kg",222,3.32,Categoria03.ALIMENTO),
            new ProdutoStream03("Camisa branca basica",522,60.32,Categoria03.VESTUARIO),
            new ProdutoStream03("Liquidificador",322,122.52,Categoria03.ELETRODOMESTICO),
            new ProdutoStream03("Calça Jeans Masculina",2222,90.32,Categoria03.VESTUARIO),
            new ProdutoStream03("Macarrão 500gr",222,2.12,Categoria03.ALIMENTO)
    ));

    // Metodo que separa os produtos e retorna um Map com a categoria como chave
    public static Map<Categoria03,List<ProdutoStream03>> agruparPorCategoria(){
        Map<Categoria03,List<ProdutoStream03>> produtosPorCategoria = new HashMap<>();// cria o Map de agrupamento

        for (ProdutoStream03 produtoStream03 : produtosLoja) {// percorre cada produto na lista
           produtosPorCategoria.computeIfAbsent(produtoStream03.getCategoria03(),k-> new ArrayList<>()) // se não existir a chave, cria nova lista
                   .add(produtoStream03);// adiciona o produto na lista da categoria correspondente
        }
        return produtosPorCategoria;// retorna o map com os produtos agrupados
    }

    // Metodo que imprime os produtos agruapdos por categoria
    public static void exibirProdutosAgrupados(Map<Categoria03,List<ProdutoStream03>> agrupados){
        for (Map.Entry<Categoria03,List<ProdutoStream03>> entry : agrupados.entrySet()){ // percorre cada categoria no map
            System.out.println("Categoria:"+entry.getKey()); // imprime o nome da categoria
            for (ProdutoStream03 p: entry.getValue()){  // percorre a lista de produtos da categoria
                System.out.println(" - "+p.getNome()); // imprime o nome do produto

            }
        }
    }

    //    processar o agrupamento
    public static void processarAgrupamento(){
        Map<Categoria03,List<ProdutoStream03>> agrupados = agruparPorCategoria();  // chama o método de agrupamento
        exibirProdutosAgrupados(agrupados);  // exibe os produtos agrupados
    }

    // Versão alternativa usando Stream (estilo profissional)
    public static Map<Categoria03, List<ProdutoStream03>> AgruparPorCategoriaComStream() {
        return produtosLoja.stream()
                .collect(Collectors.groupingBy(ProdutoStream03::getCategoria03));
    }


}
