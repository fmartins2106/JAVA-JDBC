package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel14 extends ProdutoBase14{
    private LocalDate dataValidade;

    public ProdutoPerecivel14(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataValidade) {
        super(nome, preco, quantidade, estoqueMinimo);
        setDataValidade(dataValidade);
        this.dataValidade = dataValidade;
    }

    public static void validacaoDataValidade(LocalDate dataValidade){
        if (dataValidade == null  ){
            throw new DataValidadePerecivel14();
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
        return super.toString()+String.format(" |Data validade:"+dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
