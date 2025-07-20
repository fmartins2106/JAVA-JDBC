package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ProdutosPereciveis04 extends Produto04{
    private LocalDate dataValidade;

    public ProdutosPereciveis04(int codigo, String nome, String categoria, double precoCompra, double precoVenda, int quantidade, String fornecedor, LocalDate dataValidade) {
        super(codigo, nome, categoria, precoCompra, precoVenda, quantidade, fornecedor);
        this.dataValidade = dataValidade;
    }

    public LocalDate getDavaValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        if (dataValidade.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Data de validade não pode ser menor que data atual.");
        }
        this.dataValidade = dataValidade;
    }

    public boolean isValido(){
        return (LocalDate.now().isBefore(dataValidade));
    }

    public static ProdutosPereciveis04 validandoProdutosPereciveis(Scanner scanner, int codigo, String nome, String categoria, double precoCompra, double precoVenda, int quantidade, String fornecedor){
        LocalDate dataValidade = null;
        while (true){
            try {
                System.out.print("Digite a data de validade (AAAA-MM-DD):");
                String inputDate = scanner.nextLine().trim();
                dataValidade = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
                if (dataValidade.isBefore(LocalDate.now())){
                    System.out.println("Data de validade não pode ser menor que data atual.");
                    continue;
                }
                break;
            }catch (DateTimeParseException e){
                System.out.println("Digite uma data válida válido.");
            }
        }
        return new ProdutosPereciveis04(codigo,nome,categoria,precoCompra,precoVenda,quantidade,fornecedor,dataValidade);
    }

    @Override
    public String toString(){
        return super.toString()+" |Data válidade: %s" + dataValidade;
    }

}
