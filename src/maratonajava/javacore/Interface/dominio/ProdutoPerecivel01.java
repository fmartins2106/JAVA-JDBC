package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel01 extends ProdutoBase01{
    private LocalDate dataValidade;

    public ProdutoPerecivel01(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataValidade) {
        super(nome, preco, quantidade, estoqueMinimo);
        this.dataValidade = dataValidade;
    }

    public LocalDate validacaoDataValidade(LocalDate data){
        if (data == null || data.isBefore(LocalDate.now())){
            throw new DataValidadePerecivel01();
        }
        return data;
    }

    public boolean estaVencido(){
        return dataValidade.isBefore(LocalDate.now());
    }

    public boolean estarProximoDoVencimento(int dias){
        return dataValidade.isBefore(LocalDate.now().plusDays(dias));
    }

    @Override
    public void verificarEstoqueMinimo() {
        super.verificarEstoqueMinimo();
        if (estarProximoDoVencimento(5)){
            System.out.println("Atenção produto "+nome+" Está próximo do vencimento:"+dataValidade);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "|Data válidade:"+dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public double calcularValorTotal() {
        return 0;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}
