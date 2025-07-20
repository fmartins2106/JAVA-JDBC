package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.time.LocalDate;

public class ProdutosPereciveis01 extends Produto01{
    private LocalDate dataValidade;

    public ProdutosPereciveis01(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, LocalDate dataValidade) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean isValido(){
        return LocalDate.now().isBefore(dataValidade);
    }

    @Override
    public String toString(){
        return super.toString()+ " |Data de validade: " + dataValidade + "|Válido:"+isValido();
    }
}
