package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel09;

import java.time.LocalDate;

public class ProdutoPerecivel09 extends ProdutoBase09{
    private LocalDate dataValidade;

    public ProdutoPerecivel09(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataValidade) {
        super(nome, preco, quantidade, estoqueMinimo);
        setDataValidade(dataValidade);
    }

    public static void validacaoDataValidade(LocalDate dataValidade){
        if (dataValidade == null || dataValidade.isBefore(LocalDate.now())){
            throw new DataValidadePerecivel09();
        }
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        validacaoDataValidade(dataValidade);
        this.dataValidade = dataValidade;
    }

    public boolean estaVencido(){
        return dataValidade.isBefore(LocalDate.now());
    }

}

