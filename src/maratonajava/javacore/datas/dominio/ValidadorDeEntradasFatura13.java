package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException13;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException13;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException13;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura13 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validacaoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número fatura:");
                String numero = scanner.nextLine().trim();
                Fatura13.validacaoNumeroFatura(numero);
                return numero;
            }catch (NumeroFaturaException13 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validacaoValorFatura(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura13.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException13 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validacaoVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de vencimento (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                Fatura13.validacaoDataVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida.");
            }catch (DataVencimentoFaturaException13 e){
                System.out.println(e.getMessage());
            }
        }
    }

}
