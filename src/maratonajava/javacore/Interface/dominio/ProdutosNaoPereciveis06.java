package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CategoriaProdutoInvalido06;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia06;

public class ProdutosNaoPereciveis06 extends ProdutoBase06{
    private int mesesGarantia;
    private String categoria;

    public ProdutosNaoPereciveis06(String nome, double preco, int quantidade, int estoqueMinimo, int mesesGarantia, String categoria) {
        super(nome, preco, quantidade, estoqueMinimo);
        setMesesGarantia(mesesGarantia);
        setCategoria(categoria);
    }

    public static void validacaoMesesGarantia(int mesesGarantia){
        if (mesesGarantia < MesesGarantia06.MENOR_GARANTIA){
            throw new MesesGarantia06();
        }
    }

    public static void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new CategoriaProdutoInvalido06();
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
        return super.toString()+String.format(" |Meses garantia: %d |Categoria: %s.",mesesGarantia,categoria);
    }
}
