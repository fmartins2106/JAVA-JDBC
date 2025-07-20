package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel04;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel04 extends ProdutoBase04{
    private LocalDate dataValidade;

    public ProdutoPerecivel04(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataValidade) {
        super(nome, preco, quantidade, estoqueMinimo);
        this.dataValidade = dataValidade;
    }

    public static void validacaoDataValidade(LocalDate dataValidade){
        if (dataValidade == null || dataValidade.isBefore(LocalDate.now())){
            throw new DataValidadePerecivel04();
        }
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        validacaoDataValidade(dataValidade);
        this.dataValidade = dataValidade;
    }

    public boolean estaVecido(){
        return dataValidade.isBefore(LocalDate.now());
    }

    public boolean estaProximoVencimento(int dias){
        return dataValidade.isBefore(LocalDate.now().plusDays(dias));
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Data de validade:"+dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
