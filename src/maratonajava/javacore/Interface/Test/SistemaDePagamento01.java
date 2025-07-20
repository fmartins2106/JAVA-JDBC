package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SistemaDePagamento01 {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ProcessarPagamentos01 processar = new ProcessarPagamentos01();
        CartaoDeCredito01 cartaoDeCredito01 = new CartaoDeCredito01(5000);
        Paypall01 paypall01 = new Paypall01(2000);
        Transferencia01 transferencia01 = new Transferencia01(2000);
        while (true){
            System.out.println("=====Sistema de pagamento=====");
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagar com Paypal.");
            System.out.println("[3] Pagar com transferência bancária.");
            System.out.println("[4] Consultar saldo/limite.");
            System.out.println("[5] Sair.");
            System.out.print("Escolha uma das opções acima:");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println("Saindo do sistema.");
                break;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processar,cartaoDeCredito01,paypall01,transferencia01);
                continue;
            }
            double valor = capturarValor();
            if (valor <=0){
                System.out.println("Valor inválido. Digite um valor maior que zero.");
                continue;
            }
            switch (opcao){
                case 1:
                    processar.realizarPagamentos(cartaoDeCredito01,valor);
                    break;
                case 2:
                    processar.realizarPagamentos(paypall01,valor);
                    break;
                case 3:
                    processar.realizarPagamentos(transferencia01,valor);
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
                System.out.println("Entrada inválida. Digite um número válido.");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            System.out.println("Digite o valor do pagamento:");
            try {
                return Double.parseDouble(scanner.nextLine().replace(",","."));
            }catch (NumberFormatException e){
                System.out.println("Entrada inválida. Digite um valor válido.");
            }
        }
    }

    private static void exibirConsultaSaldo(ProcessarPagamentos01 processarPagamentos01, CartaoDeCredito01 cartaoDeCredito01, Paypall01 paypall01,Transferencia01 transferencia01){
        System.out.println("[1] Cartão de crédito.");
        System.out.println("[2] Paypal.");
        System.out.println("[3] Saldo para transferência.");
        System.out.println("[4] Sair.");
        System.out.print("Escolha uma opção:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos01.consultarSaldo(cartaoDeCredito01);
                break;
            case 2:
                processarPagamentos01.consultarSaldo(paypall01);
                break;
            case 3:
                processarPagamentos01.consultarSaldo(transferencia01);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }

}
