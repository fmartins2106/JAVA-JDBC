package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CategoriaProdutoInvalido27;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia27;

public class ProdutosNaoPereciveis27 extends ProdutoBase27{
    private int mesesGarantia;
    private String categoria;

    public ProdutosNaoPereciveis27(String nome, double preco, int quantidade, int estoqueMinimo, int mesesGarantia, String categoria) {
        super(nome, preco, quantidade, estoqueMinimo);
        setMesesGarantia(mesesGarantia);
        setCategoria(categoria);
    }

    public static void validacaoMeseGarantia(int mesesGarantia){
        if (mesesGarantia < MesesGarantia27.GARANTIA_MINIMA){
            throw new MesesGarantia27();
        }
    }

    public static void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new CategoriaProdutoInvalido27();
        }
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia) {
        validacaoMeseGarantia(mesesGarantia);
        this.mesesGarantia = mesesGarantia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        validacaoCategoria(categoria);
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ProdutosNaoPereciveis27{" +
                "mesesGarantia=" + mesesGarantia +
                ", categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", estoqueMinimo=" + estoqueMinimo +
                '}';
    }
}
