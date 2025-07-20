package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel22;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel22 extends ProdutoBase22{
    private LocalDate dataValidade;

    public ProdutoPerecivel22(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataValidade) {
        super(nome, preco, quantidade, estoqueMinimo);
        setDataValidade(dataValidade);
    }

    public static void validacaoDataValidade(LocalDate dataValidade){
        if (dataValidade == null /*|| dataValidade.isBefore(LocalDate.now())*/){
            throw new DataValidadePerecivel22();
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
        return "ProdutoPerecivel22{" +
                "dataValidade=" + dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", estoqueMinimo=" + estoqueMinimo +
                '}';
    }
}
