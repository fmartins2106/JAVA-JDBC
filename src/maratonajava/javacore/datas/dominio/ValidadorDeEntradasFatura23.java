package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException23;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException23;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException23;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura23 {
    public static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumero(){
        while (true){
            try {
                System.out.print("Número da fatura:");
                String numeroFatura = scanner.nextLine().trim();
                Fatura23.validacaoNumeroFatura(numeroFatura);
                return numeroFatura;
            }catch (NumeroFaturaException23 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura23.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido para o campo valor.");
            }catch (ValorFaturaException23 e){
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
                Fatura23.validacaoDataVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida no formato: DD/MM/AAAA");
            }catch (DataVencimentoFaturaException23 e){
                System.out.println(e.getMessage());
            }
        }
    }

}
