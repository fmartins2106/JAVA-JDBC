package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SistemaDePagamento05 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        ProcessarPagamentos05 processarPagamentos05 = new ProcessarPagamentos05();
        CartaoDeCredito05 cartaoDeCredito05 = new CartaoDeCredito05(3000);
        Paypall05 paypall05 = new Paypall05(300);
        Transferencia05 transferencia05 = new Transferencia05(3000);
        while (true){
            System.out.println("[1] Cartão de crédito.");
            System.out.println("[2] Paypall.");
            System.out.println("[3] Transferência.");
            System.out.println("[4] Consultar saldo.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa...");
                break;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos05,cartaoDeCredito05,paypall05,transferencia05);
                continue;
            }
            double valor = capturarValor();
            if (valor <= 0){
                System.out.println("Valor inválido. Digite um valor maior que zero.");
            }
            switch (opcao){
                case 1:
                    processarPagamentos05.realizarPagamentos(cartaoDeCredito05,valor);
                    break;
                case 2:
                    processarPagamentos05.realizarPagamentos(paypall05,valor);
                    break;
                case 3:
                    processarPagamentos05.realizarPagamentos(transferencia05,valor);
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
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static double capturarValor(){
        while (true){
            System.out.println("Digite um valor para pagamento.");
            try {
                return Double.parseDouble(scanner.nextLine().replace(",","."));
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirConsultaSaldo(ProcessarPagamentos05 processarPagamentos05, CartaoDeCredito05 cartaoDeCredito05, Paypall05 paypall05, Transferencia05 transferencia05){
        System.out.println("[1] Cartão de crédito.");
        System.out.println("[2] Paypall.");
        System.out.println("[3] Tranferência.");
        System.out.println("[4] Sair.");
        System.out.print("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos05.consultarSaldo(cartaoDeCredito05);
                break;
            case 2:
                processarPagamentos05.consultarSaldo(paypall05);
                break;
            case 3:
                processarPagamentos05.consultarSaldo(transferencia05);
                break;
            case 4: ;
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
