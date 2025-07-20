package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel27;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel27 extends ProdutoBase27{
    private LocalDate dataVencimento;

    public ProdutoPerecivel27(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataVencimento) {
        super(nome, preco, quantidade, estoqueMinimo);
        setDataVencimento(dataVencimento);
    }

    public static void validacaoDataVencimento(LocalDate dataVencimento){
        if (dataVencimento == null /*|| dataVencimento.isBefore(LocalDate.now())*/){
            throw new DataValidadePerecivel27();
        }
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        validacaoDataVencimento(dataVencimento);
        this.dataVencimento = dataVencimento;
    }

    public boolean estaVencido(){
        return dataVencimento.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "ProdutoPerecivel27{" +
                "dataVencimento=" + dataVencimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", estoqueMinimo=" + estoqueMinimo +
                '}';
    }
}
