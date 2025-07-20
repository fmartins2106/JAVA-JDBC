package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito33;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall33;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos33;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia33;

import java.util.Scanner;

public class SistemaDePagamento33 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito33 cartaoDeCredito33 = new CartaoDeCredito33(3000);
        Paypall33 paypall33 = new Paypall33(3000);
        Transferencia33 transferencia33 = new Transferencia33(3000);
        ProcessarPagamentos33 processarPagamentos33 = new ProcessarPagamentos33();
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consultar saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando sistema.");
                return;
            }
            if (opcao == 4){
                exibirSaldo(processarPagamentos33,cartaoDeCredito33,paypall33,transferencia33);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos33.realizarPagamento(cartaoDeCredito33,valor);
                    break;
                case 2:
                    processarPagamentos33.realizarPagamento(paypall33,valor);
                    break;
                case 3:
                    processarPagamentos33.realizarPagamento(transferencia33,valor);
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
                System.out.println("Digite uma opção válida");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Digite o valor:R$");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirSaldo(ProcessarPagamentos33 processarPagamentos33, CartaoDeCredito33 cartaoDeCredito33, Paypall33 paypall33, Transferencia33 transferencia33){
        System.out.println("[1] Limite cartão.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        int opcao  = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos33.consultarSaldo(cartaoDeCredito33);
                break;
            case 2:
                processarPagamentos33.consultarSaldo(paypall33);
                break;
            case 3:
                processarPagamentos33.consultarSaldo(transferencia33);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }


}
