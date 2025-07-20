
package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CategoriaProdutoInvalido31;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia31;

public class ProdutosNaoPereciveis31 extends ProdutoBase31{
    private int mesesGarantia;
    private String categoria;

    public ProdutosNaoPereciveis31(String nome, double preco, int quantidade, int estoqueMinimo, int mesesGarantia, String categoria) {
        super(nome, preco, quantidade, estoqueMinimo);
        setMesesGarantia(mesesGarantia);
        setCategoria(categoria);
    }

    public static void validacaoGarantia(int mesesGarantia){
        if (mesesGarantia < MesesGarantia31.GARANTIA_MINIMA){
            throw new MesesGarantia31();
        }
    }

    public static void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new CategoriaProdutoInvalido31();
        }
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia) {
        validacaoGarantia(mesesGarantia);
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
        return super.toString()+String.format(" |Meses garantia: %d |Categoria: %s",mesesGarantia,categoria);
    }
}
