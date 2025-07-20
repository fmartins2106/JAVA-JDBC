package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito34;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall34;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos34;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia34;

import java.util.Scanner;

public class SistemaDePagamento34 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito34 cartaoDeCredito34 = new CartaoDeCredito34(3000);
        Paypall34 paypall34 = new Paypall34(3000);
        Transferencia34 transferencia34 = new Transferencia34(3000);
        ProcessarPagamentos34 processarPagamentos34 = new ProcessarPagamentos34();
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com conta corrente.");
            System.out.println("[4] Consultar saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>Finalizar pedido.");
                return;
            }
            if (opcao == 4){
                exibirSaldo(processarPagamentos34,cartaoDeCredito34,paypall34,transferencia34);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos34.realizarPagamentos(cartaoDeCredito34,valor);
                    break;
                case 2:
                    processarPagamentos34.realizarPagamentos(paypall34,valor);
                    break;
                case 3:
                    processarPagamentos34.realizarPagamentos(transferencia34,valor);
                    break;
            }
        }
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opçõesa acima:");
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
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirSaldo(ProcessarPagamentos34 processarPagamentos34, CartaoDeCredito34 cartaoDeCredito34, Paypall34 paypall34, Transferencia34 transferencia34){
        System.out.println("[1] Consulta limite cartão de crédito.");
        System.out.println("[2] Consulta saldo Paypall.");
        System.out.println("[3] Consulta conta bancária.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos34.consultarSaldo(cartaoDeCredito34);
                break;
            case 2:
                processarPagamentos34.consultarSaldo(paypall34);
                break;
            case 3:
                processarPagamentos34.consultarSaldo(transferencia34);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }

}
