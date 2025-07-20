package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException35;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaDuplicadaException35;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException35;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException35;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class ValidadorDeEntradasFatura35 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.println("Número da fatura:");
                String numero = scanner.nextLine().trim();
                Fatura35.validacaoNumeroFatura(numero);
                Fatura35.validacaoFaturaDuplicada(numero);
                return numero;
            }catch (NumeroFaturaException35 | NumeroFaturaDuplicadaException35 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValor(){
        while (true){
            try {
                System.out.println("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura35.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException35 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.println("Data de vencimento no formato DD/MM/AAAA:");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                Fatura35.validacaoDataVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida no formato DD/MM/AAAA");
            }catch (DataVencimentoFaturaException35 e){
                System.out.println(e.getMessage());
            }
        }
    }

}
