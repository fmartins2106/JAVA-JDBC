package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel25;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel25 extends ProdutoBase25{
    private LocalDate dataValidade;

    public ProdutoPerecivel25(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataValidade) {
        super(nome, preco, quantidade, estoqueMinimo);
        this.dataValidade = dataValidade;
    }

    public static void validacaoValidade(LocalDate dataValidade){
        if (dataValidade == null /*|| dataVencimento.isBefore(LocalDate.now())*/){
            throw new DataValidadePerecivel25();
        }
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        validacaoValidade(dataValidade);
        this.dataValidade = dataValidade;
    }

    public boolean estaVencido(){
        return dataValidade.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Data de validade:"+this.dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
