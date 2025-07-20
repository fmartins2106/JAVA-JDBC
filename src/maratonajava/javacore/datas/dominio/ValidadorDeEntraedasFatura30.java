package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException30;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException30;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException30;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class ValidadorDeEntraedasFatura30 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número fatura:");
                String numero = scanner.nextLine().trim();
                Fatura30.validacaoNumero(numero);
                return numero;
            }catch (NumeroFaturaException30 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorFatura(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura30.validacaoValor(valor);
                return valor;
            }catch (NumeroFaturaException30 e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException30 e){
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
                Fatura30.validacaoDataVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data no formato DD/MM/AAAA");
            }catch (DataVencimentoFaturaException30 e){
                System.out.println(e.getMessage());
            }
        }
    }


}
