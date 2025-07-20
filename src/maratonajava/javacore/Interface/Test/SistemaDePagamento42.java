package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito42;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall42;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos42;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia42;

import java.util.Scanner;

public class SistemaDePagamento42 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CartaoDeCredito42 cartaoDeCredito42 = new CartaoDeCredito42(3000);
    private static final Paypall42 paypall = new Paypall42(3000);
    private static final Transferencia42 transferencia42 = new Transferencia42(3000);
    private static final ProcessarPagamentos42 processarPagamentos42 = new ProcessarPagamentos42();

    public static void main(String[] args) {
        while (true){
            try {
                System.out.println("[1] Pagamento com cartão de crédito.");
                System.out.println("[2] Pagamento com Paypall.");
                System.out.println("[3] Transferência bancária.");
                System.out.println("[4] Consulta saldo/limite.");
                System.out.println("[5] Sair.");
                int opcao = capturarOpcao();
                if (opcao == 5){
                    System.out.println(">>>>Finalizando sistema.");
                    return;
                }
                if (opcao == 4){
                    exibirSaldo();
                    continue;
                }
                if (opcao < 0 || opcao > 5){
                    System.out.println("Erro. valor inválido.");
                    continue;
                }
                double valor = capturarValor();
                switch (opcao){
                    case 1:
                        processarPagamentos42.realizarPagamento(cartaoDeCredito42,valor);
                        break;
                    case 2:
                        processarPagamentos42.realizarPagamento(paypall,valor);
                        break;
                    case 3:
                        processarPagamentos42.realizarPagamento(transferencia42,valor);
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    public static void exibirSaldo(){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo conta Paypall.");
        System.out.println("[3] Saldo conta corrente.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos42.consultarSaldo(cartaoDeCredito42);
                break;
            case 2:
                processarPagamentos42.consultarSaldo(paypall);
                break;
            case 3:
                processarPagamentos42.consultarSaldo(transferencia42);
                break;
            case 4:
                return;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }
}
