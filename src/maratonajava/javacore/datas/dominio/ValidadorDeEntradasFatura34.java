package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException34;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException34;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException34;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura34 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número da fatura:");
                String numeroFatura = scanner.nextLine().trim();
                Fatura34.validacaoNumeroFatura(numeroFatura);
                return numeroFatura;
            }catch (NumeroFaturaException34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorFatura(){
        while (true){
            try {
                System.out.print("Valor da fatura:R$");
                double valorFatura = Double.parseDouble(scanner.nextLine().trim());
                Fatura34.validacaoValorFatura(valorFatura);
                return valorFatura;
            }catch (ValorFaturaException34 e){
                System.out.println(e.getMessage());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    public static LocalDate validandoDataVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de vencimento (DD/MM/AAAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                Fatura34.validacaoDataVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida.");
            }catch (DataVencimentoFaturaException34 e){
                System.out.println(e.getMessage());
            }
        }
    }

}
