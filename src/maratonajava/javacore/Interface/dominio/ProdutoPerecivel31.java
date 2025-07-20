
package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel31;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel31 extends ProdutoBase31{
    private LocalDate dataValidade;

    public ProdutoPerecivel31(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataValidade) {
        super(nome, preco, quantidade, estoqueMinimo);
        setDataValidade(dataValidade);
    }

    public static void validacaoDataValidade(LocalDate dataValidade){
        if (dataValidade == null /*|| dataValidade.isBefore(LocalDate.now())*/){
            throw new DataValidadePerecivel31();
        }
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean estaVencido(){
        return this.dataValidade.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Data de validade:"+dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
