package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CategoriaProdutoInvalida01;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia01;

public class ProdutosNaoPereciveis01 extends ProdutoBase01 {
    private int mesesGarantia;
    private String categoria;

    public ProdutosNaoPereciveis01(String nome, double preco, int quantidade, int estoqueMinimo, int mesesGarantia, String categoria) {
        super(nome, preco, quantidade, estoqueMinimo);
        setMesesGarantia(mesesGarantia);
        setCategoria(categoria);
    }

    public static void validacaoMesesGarantia(int mesesGarantia){
        if (mesesGarantia < MesesGarantia01.MIMIMO_MESES_GARANTIA){
            throw new MesesGarantia01();
        }
    }

    public static void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new CategoriaProdutoInvalida01();
        }
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia) {
        this.mesesGarantia = mesesGarantia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Garantia: %d |Categoria: %s",mesesGarantia,categoria);
    }
}
