package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito26;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall26;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos26;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia26;

import java.util.Scanner;

public class SistemaDePagamento26 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito26 cartaoDeCredito26 = new CartaoDeCredito26(3000);
        Paypall26 paypall26 = new Paypall26(3000);
        Transferencia26 transferencia26 = new Transferencia26(2000);
        ProcessarPagamentos26 processarPagamentos26 = new ProcessarPagamentos26();
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consulta de saldo/limite.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando programa.");
                return;
            }
            if (opcao == 4){
                exibirSaldo(processarPagamentos26,cartaoDeCredito26,paypall26,transferencia26);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Digite uma opção válida.");
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos26.realizarPagamento(cartaoDeCredito26,valor);
                    break;
                case 2:
                    processarPagamentos26.realizarPagamento(paypall26,valor);
                    break;
                case 3:
                    processarPagamentos26.realizarPagamento(transferencia26,valor);
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

    public static void exibirSaldo(ProcessarPagamentos26 processarPagamentos26,CartaoDeCredito26 cartaoDeCredito26,Paypall26 paypall26, Transferencia26 transferencia26){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos26.consultarSaldo(cartaoDeCredito26);
                break;
            case 2:
                processarPagamentos26.consultarSaldo(paypall26);
                break;
            case 3:
                processarPagamentos26.consultarSaldo(transferencia26);
                break;
        }
    }
}
