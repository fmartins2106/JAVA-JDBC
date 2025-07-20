package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProdutosPereciveis12 extends Produto12 {
    private LocalDate dataValidade;

    public ProdutosPereciveis12(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, LocalDate dataValidade) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        setDataValidade(dataValidade);
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

    public static ProdutosPereciveis12 validandoData(Scanner scanner,int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor ){
        LocalDate  dataValidade;
        while (true){
            try {
                System.out.print("Data de válidade:");
                String inputData = scanner.nextLine().trim();
                dataValidade = LocalDate.parse(inputData, DateTimeFormatter.ISO_LOCAL_DATE);
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        return new ProdutosPereciveis12(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,dataValidade);
    }

    @Override
    public String toString() {
        return super.toString()+String.format("|Data de Validade: "+dataValidade);
    }
}
