package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException04;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException04;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException04;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura04 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número da fatura:");
                String numeroFatura = scanner.nextLine().trim();
                Fatura04.validacaoNumeroFatura(numeroFatura);
                return numeroFatura;
            }catch (NumeroFaturaException04 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorFatura(){
        while (true){
            try {
                System.out.print("Valor da fatura:R$");
                double valorFatura = Double.parseDouble(scanner.nextLine().trim());
                Fatura04.validacaoValorFatura(valorFatura);
                return valorFatura;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException04 e){
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
                Fatura04.validacaoDataVencimento(dataVencimento);
                return dataVencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (DataVencimentoFaturaException04 e){
                System.out.println(e.getMessage());
            }
        }
    }



}
