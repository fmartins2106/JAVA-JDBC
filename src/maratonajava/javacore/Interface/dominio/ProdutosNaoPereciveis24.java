package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CategoriaProdutoInvalido24;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia23;
import academy.devdojo.maratonajava.javacore.excessoes.MesesGarantia24;

public class ProdutosNaoPereciveis24 extends ProdutoBase24{
    private int mesesGarantia;
    private String categoria;

    public ProdutosNaoPereciveis24(String nome, double preco, int quantidade, int estoqueMinimo, int mesesGarantia, String categoria) {
        super(nome, preco, quantidade, estoqueMinimo);
        setMesesGarantia(mesesGarantia);
        setCategoria(categoria);
    }

    public static void validacaoMesesGarantia(int mesesGarantia){
        if (mesesGarantia < MesesGarantia23.GARANTIA_MINIMA){
            throw new MesesGarantia24();
        }
    }

    public static void validacaoCategoria(String categoria){
        if (categoria == null || categoria.isEmpty() || !categoria.matches("^\\p{L}+( \\p{L}+)*$")){
            throw new CategoriaProdutoInvalido24();
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
        return super.toString()+String.format(" |Meses garantia: %d |Categoria: %s",this.mesesGarantia,this.categoria);
    }
}

