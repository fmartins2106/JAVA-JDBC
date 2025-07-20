package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException24;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException24;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException24;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura24 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validacaoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número fatura:");
                String numeroFatura = scanner.nextLine().trim();
                Fatura24.validacaoNumeroFatura(numeroFatura);
                return numeroFatura;
            }catch (NumeroFaturaException24 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorFatura(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura24.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para fatura.");
            }catch (ValorFaturaException24 e){
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
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                Fatura24.valdiacaoVencimentoFatura(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro, digite uma data válida no formato DD/MM/AAAA");
            }catch (DataVencimentoFaturaException24 e){
                System.out.println(e.getMessage());
            }
        }
    }

}
