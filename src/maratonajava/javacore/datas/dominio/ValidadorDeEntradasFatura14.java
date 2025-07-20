package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException14;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException14;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException14;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura14 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número da fatura:");
                String numero = scanner.nextLine().trim();
                Fatura14.validacaoNumeroFatura(numero);
                return numero;
            }catch (NumeroFaturaException14 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorFatura(){
        while (true){
            try {
                System.out.print("Valor da fatura:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura14.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException14 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de vencimento:");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                Fatura14.validacaoVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Data inválida.");
            }catch (DataVencimentoFaturaException14 e){
                System.out.println(e.getMessage());
            }
        }
    }

}
