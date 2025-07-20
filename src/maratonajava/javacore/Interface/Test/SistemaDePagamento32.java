package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito32;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall32;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos32;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia32;

import java.util.Scanner;

public class SistemaDePagamento32 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito32 cartaoDeCredito32 = new CartaoDeCredito32(4000);
        Paypall32 paypall32 = new Paypall32(300);
        Transferencia32 transferencia32 = new Transferencia32(3000);
        ProcessarPagamentos32 processarPagamentos32 = new ProcessarPagamentos32();
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transferência bancária.");
            System.out.println("[4] Consultar saldo/limite.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpca();
            if (opcao == 5){
                System.out.println(">>>Finalizando sistema.");
                return;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos32,cartaoDeCredito32,paypall32,transferencia32);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos32.realizarPagamento(cartaoDeCredito32,valor);
                    break;
                case 2:
                    processarPagamentos32.realizarPagamento(paypall32,valor);
                    break;
                case 3:
                    processarPagamentos32.realizarPagamento(transferencia32,valor);
                    break;
            }
        }
    }

    public static int capturarOpca(){
        while (true){
            try {
                System.out.print("Digite uma das opções:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válido.");
            }
        }
    }

    public static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirConsultaSaldo(ProcessarPagamentos32 processarPagamentos32, CartaoDeCredito32 cartaoDeCredito32, Paypall32 paypall32, Transferencia32 transferencia32){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo Paypall.");
        System.out.println("[3] Transferência.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpca();
        switch (opcao){
            case 1:
                processarPagamentos32.consultarSaldo(cartaoDeCredito32);
                break;
            case 2:
                processarPagamentos32.consultarSaldo(paypall32);
                break;
            case 3:
                processarPagamentos32.consultarSaldo(transferencia32);
                break;
            case 4:
                return;
            default:
                System.out.println(">>>Digite uma opção válida.");
        }
    }

}
