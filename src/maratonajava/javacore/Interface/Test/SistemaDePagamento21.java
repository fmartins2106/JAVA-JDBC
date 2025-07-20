package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.util.Scanner;

public class SistemaDePagamento21 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos21 processarPagamentos21 = new ProcessarPagamentos21();
        CartaoDeCredito21 cartaoDeCredito21 = new CartaoDeCredito21(3999);
        Paypall21 paypall21 = new Paypall21(2999);
        Transferencia21 transferencia21 = new Transferencia21(3000);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                return;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos21,cartaoDeCredito21,paypall21,transferencia21);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos21.realizarPagamento(cartaoDeCredito21,valor);
                    break;
                case 2:
                    processarPagamentos21.realizarPagamento(paypall21,valor);
                    break;
                case 3:
                    processarPagamentos21.realizarPagamento(transferencia21,valor);
                    break;
            }
        }
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    private static void exibirConsultaSaldo(ProcessarPagamentos21 processarPagamentos21,CartaoDeCredito21 cartaoDeCredito21,Paypall21 paypall21,Transferencia21 transferencia21){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos21.consultarSaldo(cartaoDeCredito21);
                break;
            case 2:
                processarPagamentos21.consultarSaldo(paypall21);
                break;
            case 3:
                processarPagamentos21.consultarSaldo(transferencia21);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
