package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito11;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall11;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos11;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia11;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SistemaDePagamento11 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos11 processarPagamentos11 = new ProcessarPagamentos11();
        CartaoDeCredito11 cartaoDeCredito11 = new CartaoDeCredito11(5000);
        Paypall11 paypall11 = new Paypall11(300);
        Transferencia11 transferencia11 = new Transferencia11(500);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consultar saldo.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println("< Finalizando programa >");
                return;
            }
            if (opcao == 4){
                exibirSaldo(processarPagamentos11,cartaoDeCredito11,paypall11,transferencia11);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Opção inválida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    ProcessarPagamentos11.autorizarPagamentos(cartaoDeCredito11,valor);
                    break;
                case 2:
                    ProcessarPagamentos11.autorizarPagamentos(paypall11,valor);
                    break;
                case 3:
                    ProcessarPagamentos11.autorizarPagamentos(transferencia11,valor);
                    break;
            }
        }
    }

    private static int capturarOpcao(){
        while (true){
            try {
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine().replace(",","."));
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirSaldo(ProcessarPagamentos11 processarPagamentos11, CartaoDeCredito11 cartaoDeCredito11, Paypall11 paypall11, Transferencia11 transferencia11){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo transferência.");
        System.out.println("[4] Sair.");
        System.out.print("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos11.consultarSaldo(cartaoDeCredito11);
                break;
            case 2:
                processarPagamentos11.consultarSaldo(paypall11);
                break;
            case 3:
                processarPagamentos11.consultarSaldo(transferencia11);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
