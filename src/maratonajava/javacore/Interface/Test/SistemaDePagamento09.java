package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SistemaDePagamento09 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        ProcessarPagamentos09 processarPagamentos09 = new ProcessarPagamentos09();
        CartaoDeCredito09 cartaoDeCredito09 = new CartaoDeCredito09(4000);
        Paypall09 paypall09 = new Paypall09(3000);
        Transferencia09 transferencia09 = new Transferencia09(500);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                return;
            }
            if (opcao == 4){
                exibirResultadosSaldo(processarPagamentos09,cartaoDeCredito09,paypall09,transferencia09);
                continue;
            }
            if (opcao <= 0 || opcao >= 6){
                System.out.println("Opção inválida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos09.realizarPagamentos(cartaoDeCredito09,valor);
                    break;
                case 2:
                    processarPagamentos09.realizarPagamentos(paypall09,valor);
                    break;
                case 3:
                    processarPagamentos09.realizarPagamentos(transferencia09,valor);
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
            try {
                System.out.print("Digite um valor para pagamento:R$");
                return Double.parseDouble(scanner.nextLine().replace(",","."));
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para pagamento.");
            }
        }
    }

    public static void exibirResultadosSaldo(ProcessarPagamentos09 processarPagamentos09, CartaoDeCredito09 cartaoDeCredito09,Paypall09 paypall09, Transferencia09 transferencia09){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        System.out.print("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos09.consultarSaldo(cartaoDeCredito09);
                break;
            case 2:
                processarPagamentos09.consultarSaldo(paypall09);
                break;
            case 3:
                processarPagamentos09.consultarSaldo(transferencia09);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }

}
