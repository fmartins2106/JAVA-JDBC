package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito45;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall45;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos45;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia45;

import java.util.Scanner;

public class SistemaDePagamento45 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CartaoDeCredito45 cartaoDeCredito45 = new CartaoDeCredito45(3400);
    private static final Paypall45 paypall45 = new Paypall45(4500);
    private static final Transferencia45 transferencia45 = new Transferencia45(3000);
    private static final ProcessarPagamentos45 processarPagamentoso45 = new ProcessarPagamentos45();

    public static void main(String[] args) {
        int opcao = 0;
        while (true){
            exibirMenu();
            opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>Finalizando sistema.");
                return;
            }
            if (opcao == 4){
                listarSaldo();
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Opção inválida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentoso45.realizarPagamento(cartaoDeCredito45,valor);
                    break;
                case 2:
                    processarPagamentoso45.realizarPagamento(paypall45,valor);
                    break;
                case 3:
                    processarPagamentoso45.realizarPagamento(transferencia45,valor);
                    break;
            }
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Pagamento com cartão de crédito.");
        System.out.println("[2] Pagamento com Paypall.");
        System.out.println("[3] Pagamneto com Transferência bancária.");
        System.out.println("[4] Consulta saldo.");
        System.out.println("[5] Sair.");
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    public static void listarSaldo(){
        System.out.println("[1] Consulta limite cartão de crédito.");
        System.out.println("[2] Consutal saldo Paypall.");
        System.out.println("[3] Consulta saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentoso45.consultaSaldo(cartaoDeCredito45);
                break;
            case 2:
                processarPagamentoso45.consultaSaldo(paypall45);
                break;
            case 3:
                processarPagamentoso45.consultaSaldo(transferencia45);
                break;
            case 4:
                return;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }


}
