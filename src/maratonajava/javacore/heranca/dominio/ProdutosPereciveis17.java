package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ProdutosPereciveis17 extends Produto17{
    private LocalDate dataValidade;

    public ProdutosPereciveis17(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, LocalDate dataValidade) {
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

    public static LocalDate validandoDataDeValidade(Scanner scanner){
        while (true){
            try {
                System.out.print("Data de validade (AAAA-MM-DD):");
                String inputData = scanner.nextLine().trim();
                LocalDate dataValidade = LocalDate.parse(inputData, DateTimeFormatter.ISO_LOCAL_DATE);
                return dataValidade;
            }catch (DateTimeParseException e){
                System.out.println("Digite uma data válida no formato AAAA-MM-DD:");
            }
        }
    }


    public static ProdutosPereciveis17 validandoDataValidade(Scanner scanner,int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor ){
        LocalDate dataValidade = validandoDataDeValidade(scanner);

        return new ProdutosPereciveis17(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,dataValidade);
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" |Data de validade: %s",dataValidade);
    }
}
