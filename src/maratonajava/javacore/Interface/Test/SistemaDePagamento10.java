package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SistemaDePagamento10 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos10 processarPagamentos10 = new ProcessarPagamentos10();
        CartaoDeCredito10 cartaoDeCredito10 = new CartaoDeCredito10(4000);
        Paypall10 paypall10 = new Paypall10(500);
        Transferencia10 transferencia10 = new Transferencia10(5000);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consultar Saldo.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                return;
            }
            if (opcao == 4){
                exibirResultadosSaldo(processarPagamentos10,cartaoDeCredito10,paypall10,transferencia10);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos10.autorizarPagamentos(cartaoDeCredito10,valor);
                    break;
                case 2:
                    processarPagamentos10.autorizarPagamentos(paypall10,valor);
                    break;
                case 3:
                    processarPagamentos10.autorizarPagamentos(transferencia10,valor);
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
                System.out.print("Digite o valor:R$");
                return Double.parseDouble(scanner.nextLine().replace(",","."));
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirResultadosSaldo(ProcessarPagamentos10 processarPagamentos10, CartaoDeCredito10 cartaoDeCredito10, Paypall10 paypall10, Transferencia10 transferencia10){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo conta Payapall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        System.out.print("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos10.consultarSaldo(cartaoDeCredito10);
                break;
            case 2:
                processarPagamentos10.consultarSaldo(paypall10);
                break;
            case 3:
                processarPagamentos10.consultarSaldo(transferencia10);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
