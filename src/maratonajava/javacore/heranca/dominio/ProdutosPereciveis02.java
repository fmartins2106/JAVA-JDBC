package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProdutosPereciveis02 extends Produto02{
    private LocalDate dataVencimento;

    public ProdutosPereciveis02(int codigo, String nome, String categoria, int quantidade, double precoCompra, double precoVenda, String fornecedor, LocalDate dataVencimento) {
        super(codigo, nome, categoria, quantidade, precoCompra, precoVenda, fornecedor);
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        if (dataVencimento.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Data de vencimento deve ser uma data futura.");
        }
        this.dataVencimento = dataVencimento;
    }
    public boolean isValido(){
        return LocalDate.now().isBefore(dataVencimento);
    }

    public static ProdutosPereciveis02 validandoProdutosPereciveis2(Scanner scanner, int codigo, String nome, String categoria,
                                                                   int quantidade, double precoCompra, double precoVenda, String fornecedor){
        LocalDate dataVencimento = null;
        while (true){
            try {
                System.out.print("Digite data de validade (AAAA-MM-DD):");
                String inputData = scanner.nextLine().trim();
                dataVencimento = LocalDate.parse(inputData, DateTimeFormatter.ISO_LOCAL_DATE);
                break;
            }catch (NumberFormatException e){
                System.out.println("Digite uma data válida no formato AAAA-MM-DD.");
            }
        }
        return new ProdutosPereciveis02(codigo,nome,categoria,quantidade,precoCompra,precoVenda,fornecedor,dataVencimento);
    }

    @Override
    public String toString(){
        return super.toString()+" |Data vencimento: "+dataVencimento + " | Válido: "+isValido();
    }


}
