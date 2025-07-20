package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel29;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel29 extends ProdutoBase29{
    private LocalDate dataValidade;

    public ProdutoPerecivel29(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataValidade) {
        super(nome, preco, quantidade, estoqueMinimo);
        this.dataValidade = dataValidade;
    }

    public static void validacaoDataValidade(LocalDate dataValidade){
        if (dataValidade == null /*|| dataValidade.isBefore(LocalDate.now()*/){
            throw new DataValidadePerecivel29();
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


    @Override
    public String toString() {
        return super.toString()+String.format(" |Data de validade:"+dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
