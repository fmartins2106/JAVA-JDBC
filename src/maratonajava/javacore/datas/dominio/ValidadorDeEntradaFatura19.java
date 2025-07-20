package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException19;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException19;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException19;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradaFatura19 {
    private static Scanner scanner = new Scanner(System.in);

    public static String validandoNumero(){
        while (true){
            try {
                System.out.print("Número:");
                String numero = scanner.nextLine().trim();
                Fatura19.validacaoNumeroFatura(numero);
                return numero;
            }catch (NumeroFaturaException19 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura19.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException19 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de vencimento (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida.");
            }catch (DataVencimentoFaturaException19 e){
                System.out.println(e.getMessage());
            }
        }
    }
}
