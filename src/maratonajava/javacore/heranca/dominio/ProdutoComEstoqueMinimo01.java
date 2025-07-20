package academy.devdojo.maratonajava.javacore.heranca.dominio;

public class ProdutoComEstoqueMinimo01 extends Produto01{
    private int estoqueMinimo;

    public ProdutoComEstoqueMinimo01(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, int estoqueMinimo) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        if (estoqueMinimo < 50){
            throw new IllegalArgumentException("Estoque mínimo não pode ser menor que 50.");
        }
        this.estoqueMinimo = estoqueMinimo;
    }

    @Override
    public String toString(){
        return super.toString()+ " | Estoque mínimo:"+estoqueMinimo;
    }
}
