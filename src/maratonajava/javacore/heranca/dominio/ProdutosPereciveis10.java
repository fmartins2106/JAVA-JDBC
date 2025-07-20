package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProdutosPereciveis10 extends Produto10 {
    private LocalDate dataValidade;

    public ProdutosPereciveis10(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, LocalDate dataValidade) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean isValido() {
        return LocalDate.now().isBefore(dataValidade);
    }

    public static ProdutosPereciveis10 validandoProdutosPereciveis(Scanner scanner, int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor) {
        LocalDate dataValidade;
        while (true) {
            try {
                System.out.print("Data de validade:");
                String inputDate = scanner.nextLine().trim();
                dataValidade = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido.");
            }
        }
        return new ProdutosPereciveis10(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor, dataValidade);
    }

    @Override
    public String toString() {
        return super.toString()+String.format("|Data validade: "+dataValidade);
    }
}

