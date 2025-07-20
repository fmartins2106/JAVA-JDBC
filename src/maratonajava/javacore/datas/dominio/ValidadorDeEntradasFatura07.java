package academy.devdojo.maratonajava.javacore.datas.dominio;

import academy.devdojo.maratonajava.javacore.datas.execessoes.DataVencimentoFaturaException07;
import academy.devdojo.maratonajava.javacore.datas.execessoes.NumeroFaturaException07;
import academy.devdojo.maratonajava.javacore.datas.execessoes.ValorFaturaException07;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ValidadorDeEntradasFatura07 {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validacaoNumeroFatura(){
        while (true){
            try {
                System.out.print("Número:");
                String numero = scanner.nextLine().trim();
                Fatura07.validacaoNumero(numero);
                return numero;
            }catch (NumeroFaturaException07 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validancaoValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Fatura07.validacaoValor(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorFaturaException07 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static LocalDate validandoDataVencimento(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print("Data de validade (DD/MM/AAAA):");
                String entrada = scanner.nextLine().trim();
                LocalDate validade = LocalDate.parse(entrada,formatter);
                Fatura07.validacaoDataVencimento(validade);
                return validade;
            }catch (DateTimeException e){
                System.out.println("Erro. Digite uma data válida.");
            }catch (DataVencimentoFaturaException07 e){
                System.out.println(e.getClass());
            }
        }
    }
}
