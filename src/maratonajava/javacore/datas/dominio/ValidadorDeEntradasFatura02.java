package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException02;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException02;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura02 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número da fatura:");
                String numeroFatura = scanner.nextLine().trim();
                Fatura02.validacaoNumeroFatura(numeroFatura);
                return numeroFatura;
            }catch (NumeroFaturaException02 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorFatura(){
        while (true){
            try {
                System.out.print("Valor da fatura:R$");
                double valorFatura = Double.parseDouble(scanner.nextLine().trim());
                Fatura02.validacaoValorFatura(valorFatura);
                return valorFatura;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número de fatura válido.");
            }catch (ValorFaturaException02 e){
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
                LocalDate dataVencimento = LocalDate.parse(entrada,formatter);
                Fatura02.validacaoDataVencimento(dataVencimento);
                return dataVencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida.");
            }
        }
    }


}
