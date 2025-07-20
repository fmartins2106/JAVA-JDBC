package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito36;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall36;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos36;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia36;

import java.util.Scanner;

public class SistemaDePagamento36 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        CartaoDeCredito36 cartaoDeCredito36 = new CartaoDeCredito36(3000);
        Paypall36 paypall36 = new Paypall36(3000);
        Transferencia36 transferencia36 = new Transferencia36(4000);
        ProcessarPagamentos36 processarPagamentos36 = new ProcessarPagamentos36();
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println(">>>>Finalizando sistema.");
                return;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos36,cartaoDeCredito36,paypall36,transferencia36);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos36.realizarPagamento(cartaoDeCredito36,valor);
                    break;
                case 2:
                    processarPagamentos36.realizarPagamento(paypall36,valor);
                    break;
                case 3:
                    processarPagamentos36.realizarPagamento(transferencia36,valor);
                    break;
            }
        }
    }

    public static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro: Digite um número válido.");
            }
        }
    }

    public static double capturarValor(){
        while (true){
            try {
                System.out.print("Valor:");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro: Digite um valor válido.");
            }
        }
    }

    public static void exibirConsultaSaldo(ProcessarPagamentos36 processarPagamentos36,CartaoDeCredito36 cartaoDeCredito36,Paypall36 paypall36, Transferencia36 transferencia36){
        System.out.println("[1] Consulta limite cartão.");
        System.out.println("[2] Consulta saldo Payapall.");
        System.out.println("[3] Consulta saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos36.consultarSaldo(cartaoDeCredito36);
                break;
            case 2:
                processarPagamentos36.consultarSaldo(paypall36);
                break;
            case 3:
                processarPagamentos36.consultarSaldo(transferencia36);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
