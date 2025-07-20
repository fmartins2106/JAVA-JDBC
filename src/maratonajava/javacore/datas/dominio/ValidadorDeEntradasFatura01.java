package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException01;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException01;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException01;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura01 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número da fatura:");
                String numeroFatura = scanner.nextLine().trim();
                Fatura01.validacaoNumeroFatura(numeroFatura);
                return numeroFatura;
            }catch (NumeroFaturaException01 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorFatura(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valorFatura = Double.parseDouble(scanner.nextLine().trim());
                Fatura01.validacaoValorFatura(valorFatura);
                return valorFatura;
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido.");
            }catch (ValorFaturaException01 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data vencimento:");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                Fatura01.validacaoDataVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Data ou hora inválida.");
            }catch (DataVencimentoFaturaException01 e){
                System.out.println(e.getMessage());
            }
        }
    }

}
