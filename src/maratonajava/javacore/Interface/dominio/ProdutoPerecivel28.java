package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel28;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel28 extends ProdutoBase28{
    private LocalDate validade;

    public ProdutoPerecivel28(String nome, double valor, int quantidade, int estoqueMinimo, LocalDate validade) {
        super(nome, valor, quantidade, estoqueMinimo);
        setValidade(validade);
    }

    public static void validacaoValidade(LocalDate validade){
        if (validade == null /*|| validade.isBefore(LocalDate.now())*/){
            throw new DataValidadePerecivel28();
        }
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        validacaoValidade(validade);
        this.validade = validade;
    }

    public boolean estaVencido(){
        return this.validade.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "ProdutoPerecivel28{" +
                "validade=" + validade.format(DateTimeFormatter.ofPattern("dd/MM/yyyyy")) +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", estoqueMinimo=" + estoqueMinimo +
                '}';
    }
}
