package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SistemaDePagamento02 {
    private static final DecimalFormat df =  new DecimalFormat("0.00");
    private static final Scanner scanner  = new Scanner(System.in);
    public static void main(String[] args) {
        ProcessarPagamentos02 processarPagamentos02 = new ProcessarPagamentos02();
        CartaoDeCredito02 cartaoDeCredito02 = new CartaoDeCredito02(5000);
        Paypall02 paypall02 = new Paypall02(300);
        Transferencia02 transferencia02 = new Transferencia02(500);
        while (true){
            System.out.println("=====Sistema de pagamento=====");
            System.out.println("[1] Pagamento cartão de crédito.");
            System.out.println("[2] Pagar com Paypall.");
            System.out.println("[3] Pagar com transferência bancária.");
            System.out.println("[4] Consulta saldo/limite.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println("Saindo do sistema.");
                break;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos02,cartaoDeCredito02,paypall02,transferencia02);
                continue;
            }
            double valor = capturarValor();
            if (valor <=0){
                System.out.println("Valor inválido. Digite um valor maior que zero.");
                continue;
            }
            switch (opcao){
                case 1:
                    processarPagamentos02.realizarPagamento(cartaoDeCredito02,valor);
                    break;
                case 2:
                    processarPagamentos02.realizarPagamento(paypall02,valor);
                    break;
                case 3:
                    processarPagamentos02.realizarPagamento(transferencia02,valor);
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
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
            System.out.println("Digite um valor para pagamento:");
            try {
                return Double.parseDouble(scanner.nextLine().replace(",","."));
            }catch (NumberFormatException e){
                System.out.println("Entrada inválida. Digite um valor válido.");
            }
        }
    }

    private static void exibirConsultaSaldo(ProcessarPagamentos02 processarPagamentos02, CartaoDeCredito02 cartaoDeCredito02, Paypall02 paypall02, Transferencia02 transferencia02){
        System.out.println("[1] Cartão de crédito.");
        System.out.println("[2] Paypall.");
        System.out.println("[3] Saldo em conta.");
        System.out.println("[4] Sair.");
        System.out.println("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos02.consultarSaldo(cartaoDeCredito02);
                break;
            case 2:
                processarPagamentos02.consultarSaldo(paypall02);
                break;
            case 3:
                processarPagamentos02.consultarSaldo(transferencia02);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
