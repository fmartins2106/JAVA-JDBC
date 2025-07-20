package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.util.Scanner;

public class SistemaDePagamento14 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos14 processarPagamentos14 = new ProcessarPagamentos14();
        CartaoDeCredito14 cartaoDeCredito14 = new CartaoDeCredito14(5000);
        Paypall14 paypall14 = new Paypall14(4000);
        Transferencia14 transferencia14 = new Transferencia14(1000);
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
                exibirResultadoSaldo(processarPagamentos14,cartaoDeCredito14,paypall14,transferencia14);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    ProcessarPagamentos14.realizarPagamento(cartaoDeCredito14,valor);
                    break;
                case 2:
                    ProcessarPagamentos14.realizarPagamento(paypall14,valor);
                    break;
                case 3:
                    ProcessarPagamentos14.realizarPagamento(transferencia14,valor);
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

    public static void exibirResultadoSaldo(ProcessarPagamentos14 processarPagamentos14, CartaoDeCredito14 cartaoDeCredito14, Paypall14 paypall14, Transferencia14 transferencia14){
        System.out.println("[1] Saldo cartão de crédito.");
        System.out.println("[2] Saldo Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        System.out.print("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos14.consultarSaldo(cartaoDeCredito14);
                break;
            case 2:
                processarPagamentos14.consultarSaldo(paypall14);
                break;
            case 3:
                processarPagamentos14.consultarSaldo(transferencia14);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
