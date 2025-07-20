package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito37;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall37;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos37;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia37;

import java.util.Scanner;

public class SistemaDePagamento37 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito37 cartaoDeCredito37 = new CartaoDeCredito37(3000);
        Paypall37 paypall37 = new Paypall37(2000);
        Transferencia37 transferencia37 = new Transferencia37(4000);
        ProcessarPagamentos37 processarPagamentos37 = new ProcessarPagamentos37();
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            int opcao = caputarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando sistema.");
                return;
            }
            if (opcao == 4){
                exibirSaldo(processarPagamentos37,cartaoDeCredito37,paypall37,transferencia37);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos37.realizarPagamento(cartaoDeCredito37,valor);
                    break;
                case 2:
                    processarPagamentos37.realizarPagamento(paypall37,valor);
                    break;
                case 3:
                    processarPagamentos37.realizarPagamento(transferencia37,valor);
                    break;
            }
        }
    }

    public static int caputarOpcao(){
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
                System.out.print("Valor:");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void exibirSaldo(ProcessarPagamentos37 processarPagamentos37, CartaoDeCredito37 cartaoDeCredito37, Paypall37 paypall37, Transferencia37 transferencia37){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo conta corrente.");
        System.out.println("[4] Sair.");
        int opcao = caputarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos37.consultarSaldo(cartaoDeCredito37);
                break;
            case 2:
                processarPagamentos37.consultarSaldo(paypall37);
                break;
            case 3:
                processarPagamentos37.consultarSaldo(transferencia37);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }


}
