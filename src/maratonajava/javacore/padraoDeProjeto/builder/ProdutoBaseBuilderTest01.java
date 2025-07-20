package academy.devdojo.maratonajava.javacore.padraoDeProjeto.builder;

public class ProdutoBaseBuilderTest01 {
    public static void main(String[] args) {

        ProdutoBaseBuilder01 produto01 = ProdutoBaseBuilder01.ProdutoBuilder01
                .aProdutoBaseBuilder01()
                .nome("Fernando")
                .preco(2.23)
                .quantidade(233)
                .estoqueMinimo(300)
                .build();
        System.out.println(produto01);
    }
}
