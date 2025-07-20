package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException10;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException10;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException10;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura10 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumero(){
        while (true){
            try {
                System.out.print("Número:");
                String numero = scanner.nextLine().trim();
                Fatura10.validacaoNumeroFatura(numero);
                return numero;
            }catch (NumeroFaturaException10 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura10.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException10 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de vencimento (dd/mm/aaaa)");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                Fatura10.validacaoDataVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida.");
            }catch (DataVencimentoFaturaException10 e){
                System.out.println(e.getMessage());
            }
        }
    }
}
