package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito30;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall30;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos30;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia30;

import java.util.Scanner;

public class SistemaDePagamento30 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito30 cartaoDeCredito30 = new CartaoDeCredito30(3000);
        Paypall30 paypall30 = new Paypall30(2000);
        Transferencia30 transferencia30 = new Transferencia30(1000);
        ProcessarPagamentos30 processarPagamentos30 = new ProcessarPagamentos30();
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>>Finalizando sistema.");
                return;
            }
            if (opcao == 4){
                exibirConsultaSaldo(scanner,processarPagamentos30, cartaoDeCredito30,paypall30,transferencia30);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos30.realizarPagamento(cartaoDeCredito30,valor);
                    break;
                case 2:
                    processarPagamentos30.realizarPagamento(paypall30,valor);
                    break;
                case 3:
                    processarPagamentos30.realizarPagamento(transferencia30,valor);
                    break;
            }
        }
    }

    public static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void exibirConsultaSaldo(Scanner scanner, ProcessarPagamentos30 processarPagamentos30, CartaoDeCredito30 cartaoDeCredito30, Paypall30 paypall30, Transferencia30 transferencia30){
        System.out.println("[1] Consulta limite cartão de crédito.");
        System.out.println("[2] Consulta saldo conta Paypall.");
        System.out.println("[3] Consulta saldo conta corrente.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos30.consultarSaldo(cartaoDeCredito30);
                break;
            case 2:
                processarPagamentos30.consultarSaldo(paypall30);
                break;
            case 3:
                processarPagamentos30.consultarSaldo(transferencia30);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }

}
