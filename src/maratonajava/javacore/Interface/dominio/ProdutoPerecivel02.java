package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel02 extends ProdutoBase02{
    private LocalDate dataValidade;

    public ProdutoPerecivel02(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataValidade) {
        super(nome, preco, quantidade, estoqueMinimo);
        setDataValidade(dataValidade);
    }

    public static void validacaoDataValidade(LocalDate dataValidade){
        if (dataValidade == null || dataValidade.isBefore(LocalDate.now())){
            throw new DataValidadePerecivel02();
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

    public boolean estaProximoVencimento(int dias){
        return dataValidade.isBefore(LocalDate.now().plusDays(dias));
    }

    @Override
    public void verificarEstoqueMinimo() {
        super.verificarEstoqueMinimo();
        if (estaProximoVencimento(5)){
            System.out.println("Atenção produto"+nome+" está próximo do vencimento:"+dataValidade);
        }
    }

    @Override
    public String toString() {
        return super.toString()+" |Data validade:"+dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public double calcularValorTotal() {
        return super.calcularValorTotal();
    }


}
