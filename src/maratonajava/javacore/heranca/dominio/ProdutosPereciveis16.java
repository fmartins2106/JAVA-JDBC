package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ProdutosPereciveis16 extends Produto16{
    private LocalDate dataValidade;

    public ProdutosPereciveis16(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, LocalDate dataValidade) {
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
        return LocalDate.now().isAfter(dataValidade);
    }

    public static LocalDate validandoDataValidade(Scanner scanner){
        LocalDate dataValidade;
        while (true){
            try {
                System.out.print("Data de validade (AAA-MM-DD):");
                String inputDate = scanner.nextLine().trim();
                dataValidade = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
                return dataValidade;
            }catch (DateTimeParseException e){
                System.out.println("Digite uma data válida no formato AAAA-MM-DD.");
            }
        }
    }

    public static ProdutosPereciveis16 validandoDadosProdutosPereciveis(Scanner scanner,int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor){
        LocalDate dataValidade = validandoDataValidade(scanner);
        return new ProdutosPereciveis16(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,dataValidade);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Data validade: "+dataValidade);
    }
}
