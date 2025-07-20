package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.util.Scanner;

public class SistemaDePagamento39 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito39 cartaoDeCredito39 = new CartaoDeCredito39(3000);
        Paypall39 paypall39 = new Paypall39(3000);
        Transferencia39 transferencia39 = new Transferencia39(3000);
        ProcessarPagamentos39 processarPagamentos39 = new ProcessarPagamentos39();
        while (true){
            try {
                System.out.println("[1] Pagamento com cartão de crédito.");
                System.out.println("[2] Pagamento com Paypall.");
                System.out.println("[3] Trasferêcia bancária.");
                System.out.println("[4] Consulta saldo.");
                System.out.println("[5] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                if (opcao == 5){
                    System.out.println(">>>>Finalizando pedido.");
                    return;
                }
                if (opcao == 4){
                    exibirConsultaSaldo(processarPagamentos39,cartaoDeCredito39,paypall39,transferencia39);
                    continue;
                }
                if (opcao < 0 || opcao > 5){
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
                }
                double valor = capturarValor();
                switch (opcao){
                    case 1:
                        processarPagamentos39.realizarPagamento(cartaoDeCredito39,valor);
                        break;
                    case 2:
                        processarPagamentos39.realizarPagamento(paypall39,valor);
                        break;
                    case 3:
                        processarPagamentos39.realizarPagamento(transferencia39,valor);
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirConsultaSaldo(ProcessarPagamentos39 processarPagamentos39, CartaoDeCredito39 cartaoDeCredito39, Paypall39 paypall39, Transferencia39 transferencia39){
        System.out.println("[1] Consulta limite cartão.");
        System.out.println("[2] Consulta saldo Paypall.");
        System.out.println("[3] Consulta transferência bancária.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos39.consultarSaldo(cartaoDeCredito39);
                break;
            case 2:
                processarPagamentos39.consultarSaldo(paypall39);
                break;
            case 3:
                processarPagamentos39.consultarSaldo(transferencia39);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida. Tente novamente.");
        }
    }

}
