package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito04;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall04;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos04;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia04;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SistemaDePagamento04 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        ProcessarPagamentos04 processarPagamentos04 = new ProcessarPagamentos04();
        CartaoDeCredito04 cartaoDeCredito04 = new CartaoDeCredito04(5000);
        Paypall04 paypall04 = new Paypall04(3000);
        Transferencia04 transferencia04 = new Transferencia04(500);
        while (true){
            System.out.println("=======Sistema de pagamento=======");
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência.");
            System.out.println("[4] Consutarl saldo/limite.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                break;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos04, cartaoDeCredito04,paypall04,transferencia04);
                continue;
            }
            double valor = capturarValor();
            if (valor <= 0){
                System.out.println("Valor inválido, digite um valor maior que zero.");
                continue;
            }
            switch (opcao){
                case 1:
                    processarPagamentos04.realizarPagamentos(cartaoDeCredito04,valor);
                    break;
                case 2:
                    processarPagamentos04.realizarPagamentos(paypall04,valor);
                    break;
                case 3:
                    processarPagamentos04.realizarPagamentos(transferencia04,valor);
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

    private static void exibirConsultaSaldo(ProcessarPagamentos04 processarPagamentos04, CartaoDeCredito04 cartaoDeCredito04, Paypall04 paypall04, Transferencia04 transferencia04){
        System.out.println("[1] Cartão de crédito.");
        System.out.println("[2] Paypall.");
        System.out.println("[3] Transferência.");
        System.out.println("[4] Sair.");
        System.out.println("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos04.consultarSaldo(cartaoDeCredito04);
                break;
            case 2:
                processarPagamentos04.consultarSaldo(paypall04);
                break;
            case 3:
                processarPagamentos04.consultarSaldo(transferencia04);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
