package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito16;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall16;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos16;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia16;

import java.util.Scanner;

public class SistemaDePagamento16 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessarPagamentos16 processarPagamentos16 = new ProcessarPagamentos16();
        CartaoDeCredito16 cartaoDeCredito16 = new CartaoDeCredito16(5000);
        Paypall16 paypall16 = new Paypall16(4000);
        Transferencia16 transferencia16 = new Transferencia16(500);
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            int opcao = capturarOpcao();
            if (opcao == 5){
                System.out.println("<Finalizando programa>");
                return;
            }
            if (opcao == 4){
                exibirConsultaSaldo(processarPagamentos16,cartaoDeCredito16,paypall16,transferencia16);
                continue;
            }
            if (opcao < 1 || opcao > 5){
                System.out.println("Digite uma opção válida.");
                continue;
            }
            double valor = capturarValor();
            switch (opcao){
                case 1:
                    processarPagamentos16.exibirResultados(cartaoDeCredito16,valor);
                    break;
                case 2:
                    processarPagamentos16.exibirResultados(paypall16,valor);
                    break;
                case 3:
                    processarPagamentos16.exibirResultados(transferencia16,valor);
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

    public static void exibirConsultaSaldo(ProcessarPagamentos16 processarPagamentos16, CartaoDeCredito16 cartaoDeCredito16,Paypall16 paypall16, Transferencia16 transferencia16){
        System.out.println("[1] Limite cartão de crédito.");
        System.out.println("[2] Saldo Paypall.");
        System.out.println("[3] Tranferência bancária.");
        System.out.println("[4] Sair.");
        int opcao = capturarOpcao();
        switch (opcao){
            case 1:
                processarPagamentos16.consultarSaldo(cartaoDeCredito16);
                break;
            case 2:
                processarPagamentos16.consultarSaldo(paypall16);
                break;
            case 3:
                processarPagamentos16.consultarSaldo(transferencia16);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }
}
