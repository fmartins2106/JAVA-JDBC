package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException09;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFatura09;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException09;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura09 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número da fatura:");
                String numero = scanner.nextLine().trim();
                Fatura09.validacaoNumeroFatura(numero);
                return numero;
            }catch (NumeroFatura09 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura09.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException09 e){
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
                LocalDate dataVencimento = LocalDate.parse(entrada,formatter);
                Fatura09.validacaoVencimento(dataVencimento);
                return dataVencimento;
            }catch (DateTimeException e){
                System.out.println("Erro, digite uma data válida.");
            }catch (DataVencimentoFaturaException09 e){
                System.out.println(e.getMessage());
            }
        }
    }

}
