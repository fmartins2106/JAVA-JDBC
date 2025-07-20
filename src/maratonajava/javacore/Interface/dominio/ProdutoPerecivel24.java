package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel24;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel24 extends ProdutoBase24{
    private LocalDate validade;

    public ProdutoPerecivel24(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate validade) {
        super(nome, preco, quantidade, estoqueMinimo);
        setValidade(validade);
    }

    public static void validandoVencimento(LocalDate validade){
        if (validade == null /*|| vencimento.isBefore(LocalDate.now())*/){
            throw new DataValidadePerecivel24();
        }
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public boolean estaVencido(){
        return this.validade.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Data de validade:"+this.validade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
