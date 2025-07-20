
package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException32;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException32;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException32;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura32 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número da fatura:");
                String numero = scanner.nextLine().trim();
                Fatura32.validacaoNumeroFatura(numero);
                return numero;
            }catch (NumeroFaturaException32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorFatura(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura32.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Digite data de validade (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                Fatura32.validacaoDataVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data no formato DD/MM/AAAA");
            }catch (DataVencimentoFaturaException32 e){
                System.out.println(e.getMessage());
            }
        }
    }





}
