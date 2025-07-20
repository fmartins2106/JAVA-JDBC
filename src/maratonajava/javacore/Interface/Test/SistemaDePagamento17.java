package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.util.Scanner;

public class SistemaDePagamento17 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos17 processarPagamentos17 = new ProcessarPagamentos17();
        CartaoDeCredito17 cartaoDeCredito17 = new CartaoDeCredito17(5000);
        Paypall17 paypall17 = new Paypall17(4000);
        Transferencia17 transferencia17 = new Transferencia17(3000);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transfêrencia.");
            System.out.println("[4] Consulta de saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println("<Finalizando programa>");
                return;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos17,cartaoDeCredito17,paypall17,transferencia17);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Opção inválida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos17.realizarPagamento(cartaoDeCredito17,valor);
                    break;
                case 2:
                    processarPagamentos17.realizarPagamento(paypall17,valor);
                    break;
                case 3:
                    processarPagamentos17.realizarPagamento(transferencia17,valor);
                    break;
            }
        }
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma opção:");
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

    private static void exibirConsultaSaldo(ProcessarPagamentos17 processarPagamentos17, CartaoDeCredito17 cartaoDeCredito17, Paypall17 paypall17,Transferencia17 transferencia17){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos17.consultarSaldo(cartaoDeCredito17);
                break;
            case 2:
                processarPagamentos17.consultarSaldo(paypall17);
                break;
            case 3:
                processarPagamentos17.consultarSaldo(transferencia17);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
