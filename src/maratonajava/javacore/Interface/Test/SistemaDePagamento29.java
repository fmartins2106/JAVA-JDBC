package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito29;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall29;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos29;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia29;

import java.util.Scanner;

public class SistemaDePagamento29 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito29 cartaoDeCredito29 = new CartaoDeCredito29(4000);
        Paypall29 paypall29 = new Paypall29(3000);
        Transferencia29 transferencia29 = new Transferencia29(1000);
        ProcessarPagamentos29 processarPagamentos29 = new ProcessarPagamentos29();
        while (true){
            try {
                System.out.println("[1] Pagamento com cartão de crédito.");
                System.out.println("[2] Pagamento com Paypall.");
                System.out.println("[3] Pagamento com transferência bancária.");
                System.out.println("[4] Consultar saldo.");
                System.out.println("[5] Sair.");
                int opcao = capturarOpcao();
                if (opcao == 5){
                    System.out.println(">>>Finalizando programa.");
                    return;
                }
                if (opcao == 4){
                    exibirConsultaSaldo(scanner,cartaoDeCredito29,paypall29,transferencia29,processarPagamentos29);
                    continue;
                }
                if (opcao < 0 || opcao > 5){
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
                }
                double valor = capturarValor();
                switch (opcao){
                    case 1:
                        processarPagamentos29.realizarPagamento(cartaoDeCredito29,valor);
                        break;
                    case 2:
                        processarPagamentos29.realizarPagamento(paypall29,valor);
                        break;
                    case 3:
                        processarPagamentos29.realizarPagamento(transferencia29,valor);
                        break;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void exibirConsultaSaldo(Scanner scanner, CartaoDeCredito29 cartaoDeCredito29, Paypall29 paypall29, Transferencia29 transferencia29,ProcessarPagamentos29 processarPagamentos29){
        System.out.println("[1] Consulta limite cartão.");
        System.out.println("[2] Consulta saldo Paypall.");
        System.out.println("[3] Consulta saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos29.consultarSaldo(cartaoDeCredito29);
                break;
            case 2:
                processarPagamentos29.consultarSaldo(paypall29);
                break;
            case 3:
                processarPagamentos29.consultarSaldo(transferencia29);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
