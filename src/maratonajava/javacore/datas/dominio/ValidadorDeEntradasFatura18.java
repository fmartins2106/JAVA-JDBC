package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException18;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException18;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException18;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura18 {
    private static Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número fatura:");
                String numero = scanner.nextLine().trim();
                Fatura18.validacaoNumeroFatura(numero);
                return numero;
            }catch (NumeroFaturaException18 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura18.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException18 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataValidade(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de vencimento (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                Fatura18.validacaoVencimentoFatura(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Data inválida. Digite uma data no formato DD/MM/AAAA");
            }catch (DataVencimentoFaturaException18 e){
                System.out.println(e.getMessage());
            }
        }
    }
}
