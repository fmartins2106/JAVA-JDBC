package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException22;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException22;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException22;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura22 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validandoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número fatura:");
                String numeroFatura = scanner.nextLine().trim();
                Fatura22.validacaoNumeroFatura(numeroFatura);
                return numeroFatura;
            }catch (NumeroFaturaException22 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorFatura(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura22.validacaoValorFatura(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (ValorFaturaException22 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Vencimento (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate vencimento = LocalDate.parse(entrada,formatter);
                Fatura22.validacaoVencimento(vencimento);
                return vencimento;
            }catch (DateTimeException e){
                System.out.println("Erro. Data inválida.");
            }catch (DataVencimentoFaturaException22 e){
                System.out.println(e.getMessage());
            }
        }
    }



}
