package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito03;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall03;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos03;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SistemaDePagamento03 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        ProcessarPagamentos03 processarPagamentos03 = new ProcessarPagamentos03();
        CartaoDeCredito03 cartaoDeCredito03 = new CartaoDeCredito03(5000);
        Paypall03 paypall03 = new Paypall03(3000);
        Transferencia03 transferencia03 = new Transferencia03(500);
        while (true){
            System.out.println("=======Sistema de pagamento=======");
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagar com Paypall.");
            System.out.println("[3] Pagar com transferência bancária.");
            System.out.println("[4] Consultar saldo/limite.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                break;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos03,cartaoDeCredito03,paypall03,transferencia03);
                continue;
            }
            double valor = capturarValor();
            if (valor <=0){
                System.out.println("Valor inválido, digite um valor maior que zero.");
                continue;
            }
            switch (opcao){
                case 1:
                    processarPagamentos03.realizarPagamento(cartaoDeCredito03,valor);
                    break;
                case 2:
                    processarPagamentos03.realizarPagamento(paypall03,valor);
                    break;
                case 3:
                    processarPagamentos03.realizarPagamento(transferencia03,valor);
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
                System.out.println("Digite um valor válido.");
            }
        }
    }

    private static void exibirConsultaSaldo(ProcessarPagamentos03 processarPagamentos03, CartaoDeCredito03 cartaoDeCredito03, Paypall03 paypall03, Transferencia03 transferencia03){
        System.out.println("[1] Cartão de crédito.");
        System.out.println("[2] Paypall.");
        System.out.println("[3] Transferência.");
        System.out.println("[4] Sair.");
        System.out.print("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos03.consultarSaldo(cartaoDeCredito03);
                break;
            case 2:
                processarPagamentos03.consultarSaldo(paypall03);
                break;
            case 3:
                processarPagamentos03.consultarSaldo(transferencia03);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
