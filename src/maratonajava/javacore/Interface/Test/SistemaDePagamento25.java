package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.util.Scanner;

public class SistemaDePagamento25 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito25 cartaoDeCredito25 = new CartaoDeCredito25(2000);
        Paypall25 paypall25 = new Paypall25(10000);
        Transferencia25 transferencia25 = new Transferencia25(2399);
        ProcessarPagamentos25 processarPagamentos25 = new ProcessarPagamentos25();
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com Transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando pedido.");
                return;
            }
            if (opcao == 4){
                exibirSaldo(processarPagamentos25,cartaoDeCredito25,transferencia25,paypall25);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos25.realizarPagamentos(cartaoDeCredito25,valor);
                    break;
                case 2:
                    processarPagamentos25.realizarPagamentos(paypall25,valor);
                    break;
                case 3:
                    processarPagamentos25.realizarPagamentos(transferencia25,valor);
            }
        }
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Digite um valor:R$");
                return Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirSaldo(ProcessarPagamentos25 processarPagamentos25, CartaoDeCredito25 cartaoDeCredito25,Transferencia25 transferencia25,Paypall25 paypall25){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos25.consultarSaldo(cartaoDeCredito25);
                break;
            case 2:
                processarPagamentos25.consultarSaldo(paypall25);
                break;
            case 3:
                processarPagamentos25.consultarSaldo(transferencia25);
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

}
