package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito07;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall07;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos07;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia07;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SistemaDePagamento07 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        ProcessarPagamentos07 processarPagamentos07 = new ProcessarPagamentos07();
        CartaoDeCredito07 cartaoDeCredito07 = new CartaoDeCredito07(4000);
        Paypall07 paypall07 = new Paypall07(3000);
        Transferencia07 transferencia07 = new Transferencia07(4000);

        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagmaneto com conta bancária.");
            System.out.println("[4] Consultar saldo.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizar opção.");
                break;
            }
            if (opcao < 1 || opcao > 4) {
                System.out.println("Digite uma opção válida.");
                continue;
            }
            if ( opcao == 4){
                exibirConsultaSaldo(processarPagamentos07,cartaoDeCredito07,paypall07,transferencia07);
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos07.realizarPagamentos(cartaoDeCredito07,valor);
                    break;
                case 2:
                    processarPagamentos07.realizarPagamentos(paypall07,valor);
                    break;
                case 3:
                    processarPagamentos07.realizarPagamentos(transferencia07,valor);
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

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Digite um valor para pagamento:");
                return Double.parseDouble(scanner.nextLine().replace(",","."));
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirConsultaSaldo(ProcessarPagamentos07 processarPagamentos07, CartaoDeCredito07 cartaoDeCredito07,Paypall07 paypall07, Transferencia07 transferencia07){
        System.out.println("[1] Saldo cartão de crédito.");
        System.out.println("[2] Saldo Paypall.");
        System.out.println("[3] Saldo transferência.");
        System.out.println("[4] Sair.");
        System.out.print("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos07.consultarSaldo(cartaoDeCredito07);
                break;
            case 2:
                processarPagamentos07.consultarSaldo(paypall07);
                break;
            case 3:
                processarPagamentos07.consultarSaldo(transferencia07);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}


