package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito31;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall31;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos31;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia31;

import java.util.Scanner;

public class SistemaDePagamento31 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito31 cartaoDeCredito31 = new CartaoDeCredito31(4000);
        Paypall31 paypall31 = new Paypall31(3290);
        Transferencia31 transferencia31 = new Transferencia31(3000);
        ProcessarPagamentos31 processarPagamentos31 = new ProcessarPagamentos31();
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
                exibirConsultaSaldo(processarPagamentos31,cartaoDeCredito31,paypall31,transferencia31);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos31.realizarPagamento(cartaoDeCredito31,valor);
                    break;
                case 2:
                    processarPagamentos31.realizarPagamento(paypall31,valor);
                    break;
                case 3:
                    processarPagamentos31.realizarPagamento(transferencia31,valor);
                    break;
            }
        }
    }

    public static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma opção válida:");
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
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirConsultaSaldo(ProcessarPagamentos31 processarPagamentos31, CartaoDeCredito31 cartaoDeCredito31, Paypall31 paypall31, Transferencia31 transferencia31){
        System.out.println("[1] Consulta Limite cartão de crédito.");
        System.out.println("[2] Consulta saldo Paypall.");
        System.out.println("[3] Consulta Transferência bancária.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos31.consultarPagamento(cartaoDeCredito31);
                break;
            case 2:
                processarPagamentos31.consultarPagamento(paypall31);
                break;
            case 3:
                processarPagamentos31.consultarPagamento(transferencia31);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válido.");
        }
    }

}
