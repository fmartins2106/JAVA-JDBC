package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito41;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall41;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos41;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia41;

import java.util.Scanner;

public class SistemaDePagamento41 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CartaoDeCredito41 cartaoCredito41 = new CartaoDeCredito41(2000);
    private static final Paypall41 paypall41 = new Paypall41(3000);
    private static final Transferencia41 transferencia = new Transferencia41(2000);
    private static final ProcessarPagamentos41 processarPagamento41 = new ProcessarPagamentos41();

    public static void main(String[] args) {
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                if (opcao == 5){
                    System.out.println(">>>Finalizando sistema.");
                    return;
                }
                if (opcao == 4){
                    exibirSaldo();
                    continue;
                }
                if (opcao < 0 || opcao > 5){
                    System.out.println("Opção inválida, tente novamente.");
                    continue;
                }
                double valor = capturarValor();
                switch (opcao){
                    case 1:
                        processarPagamento41.realizarPagamentos(cartaoCredito41,valor);
                        break;
                    case 2:
                        processarPagamento41.realizarPagamentos(paypall41,valor);
                        break;
                    case 3:
                        processarPagamento41.realizarPagamentos(transferencia,valor);
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
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

    private static void exibirSaldo(){
        System.out.println("[1] Limite cartão.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo conta corrente.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamento41.consultarSaldo(cartaoCredito41);
                break;
            case 2:
                processarPagamento41.consultarSaldo(paypall41);
                break;
            case 3:
                processarPagamento41.consultarSaldo(transferencia);
                break;
            case 4:
                return;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

}
