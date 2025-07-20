package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.util.Scanner;

public class SistemaDePagamento23 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos23 processarPagamentos23 = new ProcessarPagamentos23();
        CartaoDeCredito23 cartaoDeCredito23 = new CartaoDeCredito23(3000);
        Paypall23 paypall23 = new Paypall23(2000);
        Transferencia23 transferencia23 = new Transferencia23(500);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transferência.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                return;
            }
            if (opcao == 4){
                exibirSaldo(processarPagamentos23,cartaoDeCredito23,paypall23,transferencia23);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos23.realizarPagamentos(cartaoDeCredito23,valor);
                    break;
                case 2:
                    processarPagamentos23.realizarPagamentos(paypall23,valor);
                    break;
                case 3:
                    processarPagamentos23.realizarPagamentos(transferencia23,valor);
                    break;
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

    public static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibirSaldo(ProcessarPagamentos23 processarPagamentos23, CartaoDeCredito23 cartaoDeCredito23, Paypall23 paypall23, Transferencia23 transferencia23){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos23.consultarSaldo(cartaoDeCredito23);
                break;
            case 2:
                processarPagamentos23.consultarSaldo(paypall23);
                break;
            case 3:
                processarPagamentos23.consultarSaldo(transferencia23);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
