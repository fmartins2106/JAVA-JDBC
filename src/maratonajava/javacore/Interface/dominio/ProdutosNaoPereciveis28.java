package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CategoriaProdutoInvalido28;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia28;

public class ProdutosNaoPereciveis28 extends ProdutoBase28{
    private int mesesGarantia;
    private String categoria;

    public ProdutosNaoPereciveis28(String nome, double valor, int quantidade, int estoqueMinimo, int mesesGarantia, String categoria) {
        super(nome, valor, quantidade, estoqueMinimo);
        setMesesGarantia(mesesGarantia);
        setCategoria(categoria);
    }

    public static void validacaoMesesGarantia(int mesesGarantia){
        if (mesesGarantia < MesesGarantia28.GARANTIA_MINIMA){
            throw new MesesGarantia28();
        }
    }

    public static void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new CategoriaProdutoInvalido28();
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
        return "ProdutosNaoPereciveis28{" +
                "mesesGarantia=" + mesesGarantia +
                ", categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", estoqueMinimo=" + estoqueMinimo +
                '}';
    }
}
