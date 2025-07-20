package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito06;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall06;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos06;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia06;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SistemaDePagamento06 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        ProcessarPagamentos06 processarPagamentos06 = new ProcessarPagamentos06();
        CartaoDeCredito06 cartaoDeCredito06 = new CartaoDeCredito06(5000);
        Paypall06 paypall06 = new Paypall06(500);
        Transferencia06 transferencia06 = new Transferencia06(1000);
        while (true){
            System.out.println("=======Opções de pagamento=======");
            System.out.println("[1] Cartão de crédito.");
            System.out.println("[2] Paypall.");
            System.out.println("[3] Transferência.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizar programa.");
                break;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos06,cartaoDeCredito06,paypall06,transferencia06);
                continue;
            }
            double valor = capturarValor();
            if (valor <= 0){
                System.out.println("Digite um valor maior que zero.");
            }
            switch (opcao){
                case 1:
                    processarPagamentos06.realizarPagamentos(cartaoDeCredito06,valor);
                    break;
                case 2:
                    processarPagamentos06.realizarPagamentos(paypall06,valor);
                    break;
                case 3:
                    processarPagamentos06.realizarPagamentos(transferencia06,valor);
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
            System.out.print("Digite um valor para pagamento:");
            try {
                return Double.parseDouble(scanner.nextLine().replace(",","."));
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirConsultaSaldo(ProcessarPagamentos06 processarPagamentos06, CartaoDeCredito06 cartaoDeCredito06, Paypall06 paypall06, Transferencia06 transferencia06){
        System.out.println("[1] Saldo cartão de crédito.");
        System.out.println("[2] Saldo Paypall.");
        System.out.println("[3] Saldo transferência.");
        System.out.println("[4] Sair.");
        System.out.print("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos06.consultarSaldo(cartaoDeCredito06);
                break;
            case 2:
                processarPagamentos06.consultarSaldo(paypall06);
                break;
            case 3:
                processarPagamentos06.consultarSaldo(transferencia06);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
