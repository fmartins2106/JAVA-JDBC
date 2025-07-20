package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CategoriaProdutoInvalido03;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia03;

public class ProdutosNaoPereciveis03 extends ProdutoBase03{
    private int mesesGarantia;
    private String categoria;

    public ProdutosNaoPereciveis03(String nome, double preco, int quantidade, int estoqueMinimo, int mesesGarantia, String categoria) {
        super(nome, preco, quantidade, estoqueMinimo);
        setMesesGarantia(mesesGarantia);
        setCategoria(categoria);
    }

    public static void validacaoMesesGarantia(int mesesGarantia){
        if (mesesGarantia < MesesGarantia03.MESES_GARANTIA){
            throw new MesesGarantia03();
        }
    }

    public static void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^[\\p{L}0-9]+( [\\p{L}0-9]+)*$")){
            throw new CategoriaProdutoInvalido03();
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
        return super.toString()+String.format(" |Garantia: %d |Categoria: %s.",mesesGarantia,categoria);
    }
}
