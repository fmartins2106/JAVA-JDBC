package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ProdutosPereciveis14 extends Produto14{
    private LocalDate dataValidade;

    public ProdutosPereciveis14(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, LocalDate dataValidade) {
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

    public static LocalDate validacaoDataValidade(Scanner scanner){
        LocalDate dataValidade;
        while (true){
            try {
                System.out.print("Data de validade(AAA-MM-DD):");
                String inputDate = scanner.nextLine().trim();
                dataValidade = LocalDate.parse(inputDate,DateTimeFormatter.ISO_LOCAL_DATE);
                break;
            }catch (DateTimeParseException e){
                System.out.println("Digite uma data no formato AAA-MM-DD");
            }
        }
        return dataValidade;
    }

    public static ProdutosPereciveis14 validandoDataValidade(Scanner scanner,int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor){
        LocalDate dataValidade = validacaoDataValidade(scanner);
        return new ProdutosPereciveis14(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,dataValidade);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Data de validade: "+dataValidade);
    }
}
