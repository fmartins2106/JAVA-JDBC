package academy.devdojo.maratonajava.javacore.padraoDeProjeto.builder;

public class ProdutosBaseBuilderTest02 {
    public static void main(String[] args) {

        ProdutoBaseBuilder02 produto02 = ProdutoBaseBuilder02.ProdutoBuilder02
                .aProdutoBaseBuilder02()
                .nome("Fernando")
                .preco(2.33)
                .quantidade(2322)
                .estoqueMinimo(2222)
                .build();
        System.out.println(produto02);

    }
}
