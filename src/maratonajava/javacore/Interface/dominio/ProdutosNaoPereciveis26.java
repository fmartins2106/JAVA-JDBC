package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CategoriaProdutoInvalido26;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia25;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia26;

public class ProdutosNaoPereciveis26 extends ProdutoBase26{
    private int mesesGarantia;
    private String categoria;

    public ProdutosNaoPereciveis26(String nome, double preco, int quantidade, int estoqueMinimo, int mesesGarantia, String categoria) {
        super(nome, preco, quantidade, estoqueMinimo);
        setMesesGarantia(mesesGarantia);
        setCategoria(categoria);
    }

    public static void validacaoMesesGarantia(int mesesGarantia){
        if (mesesGarantia < MesesGarantia26.GARANTIA_MINIMA){
            throw new MesesGarantia26();
        }
    }

    public static void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new CategoriaProdutoInvalido26();
        }
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia) {
        validacaoMesesGarantia(mesesGarantia);
        this.mesesGarantia = mesesGarantia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        validacaoCategoria(categoria);
        this.categoria = formatoString(categoria);
    }

    @Override
    public String toString() {
        return "ProdutosNaoPereciveis26{" +
                "mesesGarantia=" + mesesGarantia +
                ", categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", estoqueMinimo=" + estoqueMinimo +
                '}';
    }
}
