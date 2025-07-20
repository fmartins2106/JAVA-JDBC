package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.Banco33;
import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito22;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall22;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos22;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia22;

import java.util.Scanner;

public class SistemaDePagamento22 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos22 processarPagamentos22 = new ProcessarPagamentos22();
        CartaoDeCredito22 cartaoDeCredito22 = new CartaoDeCredito22(4003);
        Paypall22 paypall22 = new Paypall22(4000);
        Transferencia22 transferencia22 = new Transferencia22(3000);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Payapall.");
            System.out.println("[3] Pagamento com transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>>Finalizando programa.");
                return;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos22,cartaoDeCredito22,paypall22,transferencia22);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos22.realizarPagamentos(cartaoDeCredito22,valor);
                    break;
                case 2:
                    processarPagamentos22.realizarPagamentos(paypall22,valor);
                    break;
                case 3:
                    processarPagamentos22.realizarPagamentos(transferencia22,valor);
                    break;
            }
        }
    }

    public static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções:");
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static double capturarValor(){
        while (true){
            try {
                System.out.print("Digite um valor válido:");
                return Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirConsultaSaldo(ProcessarPagamentos22 processarPagamentos22, CartaoDeCredito22 cartaoDeCredito22, Paypall22 paypall22, Transferencia22 transferencia22){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos22.consultarSaldo(cartaoDeCredito22);
                break;
            case 2:
                processarPagamentos22.consultarSaldo(paypall22);
                break;
            case 3:
                processarPagamentos22.consultarSaldo(transferencia22);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }

}
