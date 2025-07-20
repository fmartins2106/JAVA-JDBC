package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.util.Scanner;

public class SistemaDePagamento13 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos13 processarPagamentos13 = new ProcessarPagamentos13();
        CartaoDeCredito13 cartaoDeCredito13 = new CartaoDeCredito13(5000);
        Paypall13 paypall13 = new Paypall13(500);
        Transferencia13 transferencia13 = new Transferencia13(1000);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa...");
                return;
            }
            if (opcao == 4){
                exibindoSaldo(processarPagamentos13,cartaoDeCredito13,paypall13,transferencia13);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    ProcessarPagamentos13.autorizarPagamentos(cartaoDeCredito13,valor);
                    break;
                case 2:
                    ProcessarPagamentos13.autorizarPagamentos(paypall13,valor);
                    break;
                case 3:
                    ProcessarPagamentos13.autorizarPagamentos(transferencia13,valor);
                    break;
            }
        }
    }

    public static int capturarOpcao(){
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
                System.out.print("Valor:");
                return Double.parseDouble(scanner.nextLine().replace(",","."));
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void exibindoSaldo(ProcessarPagamentos13 processarPagamentos13, CartaoDeCredito13 cartaoDeCredito13, Paypall13 paypall13, Transferencia13 transferencia13){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        System.out.print("Digite uma das opções acima:");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos13.consultarSaldo(cartaoDeCredito13);
                break;
            case 2:
                processarPagamentos13.consultarSaldo(paypall13);
                break;
            case 3:
                processarPagamentos13.consultarSaldo(transferencia13);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }

}
