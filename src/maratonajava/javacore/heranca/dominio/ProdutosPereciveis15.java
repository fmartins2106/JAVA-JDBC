package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ProdutosPereciveis15 extends Produto15{
    private LocalDate dataValidade;

    public ProdutosPereciveis15(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String formecedor, LocalDate dataValidade) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, formecedor);
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean isVencido(){
        return LocalDate.now().isAfter(dataValidade);
    }


    public static LocalDate validandoDataValidade(Scanner scanner){
        LocalDate dataValidade;
        while (true){
            try {
                System.out.print("Data de validade AAAA-MM-DD:");
                String inputData = scanner.nextLine().trim();
                dataValidade = LocalDate.parse(inputData, DateTimeFormatter.ISO_LOCAL_DATE);
                return dataValidade;
            }catch (DateTimeParseException e){
                System.out.println("Digite uma data válida no formato AAAA-MM-DD.");
            }
        }
    }

    public static ProdutosPereciveis15 validandoDadosProdutosPereciveis(Scanner scanner,int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String formecedor){
        LocalDate dataValidade = validandoDataValidade(scanner);
        return new ProdutosPereciveis15(codigo, nome,categoria,quantidade,precoCompra,precoVenda,formecedor,dataValidade);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Data válidade: "+dataValidade);
    }
}
