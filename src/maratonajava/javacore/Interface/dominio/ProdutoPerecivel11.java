package academy.devdojo.maratonajava.javacore.Interface.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel11 extends ProdutoBase11{
    private LocalDate dataValidade;

    public ProdutoPerecivel11(String nome, double preco, int quantidade, int estoqueMinimo, LocalDate dataValidade) {
        super(nome, preco, quantidade, estoqueMinimo);
        setDataValidade(dataValidade);
    }

    public static void validacaoDataValidade(LocalDate dataValidade){
        if (dataValidade == null || dataValidade.isBefore(LocalDate.now())){
            throw new DataValidadePerecivel11();
        }
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        validacaoDataValidade(dataValidade);
        this.dataValidade = dataValidade;
    }

    public void estaVencido(){
        if (dataValidade.isBefore(LocalDate.now())){
            System.out.println("Produto:"+nome+" está vencido. Verifique.");
            return;
        }
        System.out.println("Nenhum produto vencido.");
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Data validade: %s",dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
