package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SistemaDePagamento28 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito28 cartaoDeCredito28 = new CartaoDeCredito28(3000);
        Paypall28 paypall28 = new Paypall28(3000);
        Transferencia28 transferencia28 = new Transferencia28(3000);
        ProcessarPagamentos28 processarPagamentos28 = new ProcessarPagamentos28();
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Payapall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consultar saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                return;
            }
            if (opcao ==  4){
                exibirConsultaSaldo(scanner,cartaoDeCredito28,paypall28,transferencia28,processarPagamentos28);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Opção inválida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos28.realizarPagamentos(cartaoDeCredito28,valor);
                    break;
                case 2:
                    processarPagamentos28.realizarPagamentos(paypall28,valor);
                    break;
                case 3:
                    processarPagamentos28.realizarPagamentos(transferencia28,valor);
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
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirConsultaSaldo(Scanner scanner,CartaoDeCredito28 cartaoDeCredito28, Paypall28 paypall28, Transferencia28 transferencia28, ProcessarPagamentos28 processarPagamentos28){
        System.out.println("[1] Consulta Limite cartão.");
        System.out.println("[2] Consulta Paypall.");
        System.out.println("[3] Consulta Transferência.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos28.consultarPagamento(cartaoDeCredito28);
                break;
            case 2:
                processarPagamentos28.consultarPagamento(paypall28);
                break;
            case 3:
                processarPagamentos28.consultarPagamento(transferencia28);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
