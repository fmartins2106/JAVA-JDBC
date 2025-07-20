package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException21;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException21;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException21;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura21 {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número fatura:");
                String numero = scanner.nextLine().trim();
                Fatura21.validacaoNumeroFatura(numero);
                return numero;
            }catch (NumeroFaturaException21 e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static double validandoValorFatura(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura21.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException21 e){
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
                Fatura21.validacaoVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Data inválida. Digite uma data no formato:DD/MM/AAAA");
            }catch (DataVencimentoFaturaException21 e){
                System.out.println(e.getMessage());
            }
        }
    }

    
}
