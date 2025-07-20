package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito20;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall20;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos20;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia20;

import java.util.Scanner;

public class SistemaDePagamento20 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos20 processarPagamentos20 = new ProcessarPagamentos20();
        CartaoDeCredito20 cartaoDeCredito20 = new CartaoDeCredito20(3998);
        Paypall20 paypall20 = new Paypall20(3999);
        Transferencia20 transferencia20 = new Transferencia20(2000);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                return;
            }
            if (opcao == 4){
                exibirSaldoDisponivel(processarPagamentos20,cartaoDeCredito20,paypall20,transferencia20);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida entre 1 e 5.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos20.realizarPagamentos(cartaoDeCredito20,valor);
                    break;
                case 2:
                    processarPagamentos20.realizarPagamentos(paypall20,valor);
                    break;
                case 3:
                    processarPagamentos20.realizarPagamentos(transferencia20,valor);
            }
        }
    }



    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    private static void exibirSaldoDisponivel(ProcessarPagamentos20 processarPagamentos20,CartaoDeCredito20 cartaoDeCredito20, Paypall20 paypall20, Transferencia20 transferencia20){
        System.out.println("[1] Limite disponível cartão de crédito.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo Transferência bancária.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos20.consultarSaldo(cartaoDeCredito20);
                break;
            case 2:
                processarPagamentos20.consultarSaldo(paypall20);
                break;
            case 3:
                processarPagamentos20.consultarSaldo(transferencia20);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
