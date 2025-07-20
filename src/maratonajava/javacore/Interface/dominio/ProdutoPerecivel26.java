package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel26;

import java.time.LocalDate;

public class ProdutoPerecivel26 extends ProdutoBase26{
    private LocalDate dataValidade;

    public ProdutoPerecivel26(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataValidade) {
        super(nome, preco, quantidade, estoqueMinimo);
        this.dataValidade = dataValidade;
    }

    public static void validacaoDataValidade(LocalDate dataValidade){
        if (dataValidade == null /*|| dataValidade.isBefore(LocalDate.now())*/){
            throw new DataValidadePerecivel26();
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
        return "ProdutoPerecivel26{" +
                "dataValidade=" + dataValidade +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", estoqueMinimo=" + estoqueMinimo +
                '}';
    }
}
