package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException16;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException16;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException16;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura16 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validacaoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número:");
                String numero = scanner.nextLine().trim();
                Fatura16.validacaoNumeroFatura(numero);
                return numero;
            }catch (NumeroFaturaException16 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                 Fatura16.validacaoValorFatura(valor);
                 return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido.");
            }catch (ValorFaturaException16 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Vencimento (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                Fatura16.validacaoVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida.");
            }catch (DataVencimentoFaturaException16 e){
                System.out.println(e.getMessage());
            }
        }
    }

}
