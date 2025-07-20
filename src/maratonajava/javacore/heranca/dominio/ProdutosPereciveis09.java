package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ProdutosPereciveis09 extends Produto09{
    private LocalDate dataValidade;

    public ProdutosPereciveis09(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, LocalDate dataValidade) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean isValido(){
        return LocalDate.now().isBefore(dataValidade);
    }

    public static ProdutosPereciveis09 validandoDataValidade(Scanner scanner,int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedo ){
        LocalDate dataValidade;
        while (true){
            try {
                System.out.print("Data de validade:");
                String inputData = scanner.nextLine().trim();
                dataValidade = LocalDate.parse(inputData,DateTimeFormatter.ISO_LOCAL_DATE);
                break;
            }catch (DateTimeParseException e){
                System.out.println("Digite data no formato AAAA-MM-DD");
            }
        }
        return new ProdutosPereciveis09(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedo,dataValidade);
    }

    @Override
    public String toString(){
        return super.toString()+String.format("|Data validade: "+dataValidade);
    }

}

