package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.*;

import java.util.Scanner;

public class SistemaDePagamento35 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito35 cartaoDeCredito35 = new CartaoDeCredito35(3000);
        Paypall35 paypall35 = new Paypall35(3000);
        Transferencia35 transferencia35 = new Transferencia35(3000);
        ProcessarPagamentos35 processarPagamentos35 = new ProcessarPagamentos35();
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>>Finalizar pedido.");
                return;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos35,cartaoDeCredito35,paypall35,transferencia35);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Digite uma opção válida.");
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos35.realizarPagamentos(cartaoDeCredito35,valor);
                    break;
                case 2:
                    processarPagamentos35.realizarPagamentos(paypall35,valor);
                    break;
                case 3:
                    processarPagamentos35.realizarPagamentos(transferencia35,valor);
                    break;
            }
        }
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void exibirConsultaSaldo(ProcessarPagamentos35 processarPagamentos35, CartaoDeCredito35 cartaoDeCredito35, Paypall35 paypall35,Transferencia35 transferencia35){
        System.out.println("[1] Consulta Limite cartão.");
        System.out.println("[2] Consulta saldo Paypall.");
        System.out.println("[3] Consulta saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos35.consultarSaldo(cartaoDeCredito35);
                break;
            case 2:
                processarPagamentos35.consultarSaldo(paypall35);
                break;
            case 3:
                processarPagamentos35.consultarSaldo(transferencia35);
                break;
        }
    }
}
