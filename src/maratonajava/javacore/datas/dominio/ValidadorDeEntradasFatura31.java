
package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException31;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException31;
import academy.devdojo.maratonajava.javacore.excessoes.DataValidadePerecivel31;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura31 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número fatura:");
                String numeroFatura = scanner.nextLine().trim();
                Fatura31.validacaoNumeroFatura(numeroFatura);
                return numeroFatura;
            }catch (NumeroFaturaException31 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorFatura(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura31.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro, digite um valor de fatura válido.");
            }catch (ValorFaturaException31 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de vencimento (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate  dataVencimento = LocalDate.parse(entrada,formatter);
                return dataVencimento;
            }catch (DateTimeException e){
                System.out.println("Erro, data de validade inválida. Digite uma data no formato DD/MM/AAAA");
            }catch (DataValidadePerecivel31 e){
                System.out.println(e.getMessage());
            }
        }
    }

}
