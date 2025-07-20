package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CategoriaProdutoInvalido22;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia22;

public class ProdutosNaoPereciveis22 extends ProdutoBase22{
    private int mesesGarantia;
    private String categoria;

    public ProdutosNaoPereciveis22(String nome, double preco, int quantidade, int estoqueMinimo, int mesesGarantia, String categoria) {
        super(nome, preco, quantidade, estoqueMinimo);
        this.mesesGarantia = mesesGarantia;
        this.categoria = categoria;
    }

    public static void validacaoMesesGarantia(int mesesGarantia){
        if (mesesGarantia < MesesGarantia22.GARANTIA_MINIMA){
            throw new MesesGarantia22();
        }
    }

    public static void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new CategoriaProdutoInvalido22();
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
        return "ProdutosNaoPereciveis22{" +
                "mesesGarantia=" + mesesGarantia +
                ", categoria='" + categoria + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", estoqueMinimo=" + estoqueMinimo +
                '}';
    }
}
