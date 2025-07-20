package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito27;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall27;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos27;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia27;

import java.util.Scanner;

public class SistemaDePagamento27 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ProcessarPagamentos27 processarPagamentos27 = new ProcessarPagamentos27();
        CartaoDeCredito27 cartaoDeCredito27 = new CartaoDeCredito27(4000);
        Paypall27 paypall27 = new Paypall27(4000);
        Transferencia27 transferencia27 = new Transferencia27(3000);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transferência bancária.");
            System.out.println("[4] Consulta de saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                return;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos27,cartaoDeCredito27,paypall27,transferencia27);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos27.realizarPagamento(cartaoDeCredito27,valor);
                    break;
                case 2:
                    processarPagamentos27.realizarPagamento(paypall27,valor);
                    break;
                case 3:
                    processarPagamentos27.realizarPagamento(transferencia27,valor);
                    break;
            }
        }
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void exibirConsultaSaldo(ProcessarPagamentos27 processarPagamentos27, CartaoDeCredito27 cartaoDeCredito27, Paypall27 paypall27, Transferencia27 transferencia27){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos27.consultarSaldo(cartaoDeCredito27);
                break;
            case 2:
                processarPagamentos27.consultarSaldo(paypall27);
                break;
            case 3:
                processarPagamentos27.consultarSaldo(transferencia27);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
