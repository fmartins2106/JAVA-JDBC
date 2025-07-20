package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.util.Scanner;

public class SistemaDePagamento08 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos08 processarPagamentos08 = new ProcessarPagamentos08();
        CartaoDeCredito08 cartaoDeCredito08 = new CartaoDeCredito08(5000);
        Paypall08 paypall08 = new Paypall08(3000);
        Transferencia08 transferencia08 = new Transferencia08(500);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                return;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }
            if (opcao == 4){
                exibirResultadosSaldo(processarPagamentos08,cartaoDeCredito08, paypall08,transferencia08);
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos08.realizarPagamentos(cartaoDeCredito08,valor);
                    break;
                case 2:
                    processarPagamentos08.realizarPagamentos(paypall08,valor);
                    break;
                case 3:
                    processarPagamentos08.realizarPagamentos(transferencia08,valor);
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
                System.out.println("Digite um valor válido.");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Digite um valor para pagamento:");
                return Double.parseDouble(scanner.nextLine().replace(",","."));
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirResultadosSaldo(ProcessarPagamentos08 processarPagamentos08, CartaoDeCredito08 cartaoDeCredito08, Paypall08 paypall08, Transferencia08 transferencia08){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo conta bancária.");
        System.out.println("[4] Sair.");
        System.out.print("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos08.consultarSaldo(cartaoDeCredito08);
                break;
            case 2:
                processarPagamentos08.consultarSaldo(paypall08);
                break;
            case 3:
                processarPagamentos08.consultarSaldo(transferencia08);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válido.");
        }
    }
}
