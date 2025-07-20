package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito15;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall15;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos15;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia15;

import java.util.Scanner;

public class SistemaDePagamento15 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos15 processarPagamentos15 = new ProcessarPagamentos15();
        CartaoDeCredito15 cartaoDeCredito15 = new CartaoDeCredito15(4000);
        Paypall15 paypall15 = new Paypall15(3000);
        Transferencia15 transferencia15 = new Transferencia15(5000);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consulta de saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa...");
                return;
            }
            if (opcao == 4){
                exibirSaldo(processarPagamentos15,cartaoDeCredito15,paypall15,transferencia15);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos15.realizarPagamento(cartaoDeCredito15,valor);
                    break;
                case 2:
                    processarPagamentos15.realizarPagamento(paypall15,valor);
                    break;
                case 3:
                    processarPagamentos15.realizarPagamento(transferencia15,valor);
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
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

    public static void exibirSaldo(ProcessarPagamentos15 processarPagamentos15, CartaoDeCredito15 cartaoDeCredito15, Paypall15 paypall15, Transferencia15 transferencia15) {
        System.out.println("[1] Saldo cartão de crédito.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Voltar para o menu principal.");
        System.out.print("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao) {
            case 1:
                processarPagamentos15.consultarSaldo(cartaoDeCredito15);
                break;
            case 2:
                processarPagamentos15.consultarSaldo(paypall15);
                break;
            case 3:
                processarPagamentos15.consultarSaldo(transferencia15);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
