package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CategoriaProdutoInvalido30;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia30;

public class ProdutosNaoPereciveis30 extends ProdutoBase30{
    private int mesesGarantia;
    private String categoria;

    public ProdutosNaoPereciveis30(String nome, double preco, int quantidadade, int estoqueMinimo, int mesesGarantia, String categoria) {
        super(nome, preco, quantidadade, estoqueMinimo);
        setMesesGarantia(mesesGarantia);
        setCategoria(categoria);
    }

    public static void validacaoMesesGarantia(int mesesGarantia){
        if (mesesGarantia < MesesGarantia30.GARANTIA_MINIMA){
            throw new MesesGarantia30();
        }
    }

    public static void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new CategoriaProdutoInvalido30();
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
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Meses garantia: %d |Categoria: %s",mesesGarantia,categoria);
    }
}
