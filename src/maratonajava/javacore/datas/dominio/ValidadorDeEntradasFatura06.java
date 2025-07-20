package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException06;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException06;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException06;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura06 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número da fatura:");
                String numero = scanner.nextLine().trim();
                Fatura06.validacaoNumeroFatura(numero);
                return numero;
            }catch (NumeroFaturaException06 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura06.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException06 e){
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
                Fatura06.validacaoDataVencimento(dataVencimento);
                return dataVencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Data inválida.");
            }catch (DataVencimentoFaturaException06 e){
                System.out.println(e.getMessage());
            }
        }
    }
}
