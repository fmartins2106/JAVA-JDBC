package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel30;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel30 extends ProdutoBase30 {
    private LocalDate dataValidade;

    public ProdutoPerecivel30(String nome, double preco, int quantidadade, int estoqueMinimo, LocalDate dataValidade) {
        super(nome, preco, quantidadade, estoqueMinimo);
        setDataValidade(dataValidade);
    }

    public static void validacaoDataValidade(LocalDate dataValidade){
        if (dataValidade == null /*|| dataValidade.isBefore(LocalDate.now())*/){
            throw new DataValidadePerecivel30();
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
