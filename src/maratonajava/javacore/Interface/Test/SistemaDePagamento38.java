package academy.devdojo.maratonajava.javacore.Interface.Test;

import academy.devdojo.maratonajava.javacore.Interface.dominio.CartaoDeCredito38;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Paypall38;
import academy.devdojo.maratonajava.javacore.Interface.dominio.ProcessarPagamentos38;
import academy.devdojo.maratonajava.javacore.Interface.dominio.Transferencia38;

import java.util.Scanner;

public class SistemaDePagamento38 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CartaoDeCredito38 cartaoDeCredito38 = new CartaoDeCredito38(3000);
        Paypall38 paypall38 = new Paypall38(3000);
        Transferencia38 transferencia38 = new Transferencia38(3000);
        ProcessarPagamentos38 processarPagamentos38 = new ProcessarPagamentos38();
        while (true){
            System.out.println("[1] Pagamento com cartão de crédito.");
            System.out.println("[2] Pagamento com Paypall.");
            System.out.println("[3] Pagamento com transferência bancária.");
            System.out.println("[4] Consulta saldo.");
            System.out.println("[5] Sair.");
            int opcao = getOpcao();
            if (opcao == 5){
                System.out.println(">>>>Finalizando sistema.");
                return;
            }
            if (opcao == 4){
                consultaSaldo(processarPagamentos38,cartaoDeCredito38,paypall38,transferencia38);
                continue;
            }
            if (opcao < 0 || opcao > 5){
                System.out.println("Erro. Digite uma opção válida.");
                continue;
            }
            double valor = getValor();
            switch (opcao){
                case 1:
                    processarPagamentos38.realizarPagamento(cartaoDeCredito38,valor);
                    break;
                case 2:
                    processarPagamentos38.realizarPagamento(paypall38,valor);
                    break;
                case 3:
                    processarPagamentos38.realizarPagamento(transferencia38,valor);
                    break;
            }
        }
    }

    private static int getOpcao(){
        while (true){
            try {
                System.out.print("Digite a opção:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static double getValor(){
        while (true){
            try {
                System.out.print("Valor:R$");
                return Double.parseDouble(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }
    }

    public static void consultaSaldo(ProcessarPagamentos38 processarPagamentos38,CartaoDeCredito38 cartaoDeCredito38, Paypall38 paypall38, Transferencia38 transferencia38){
        System.out.println("[1] Consulta limite cartão de crédito.");
        System.out.println("[2] Consulta saldo Paypall.");
        System.out.println("[3] Consulta saldo conta.");
        System.out.println("[4] Sair.");
        int opcao = getOpcao();
        switch (opcao){
            case 1:
                processarPagamentos38.consultarSaldo(cartaoDeCredito38);
                break;
            case 2:
                processarPagamentos38.consultarSaldo(paypall38);
                break;
            case 3:
                processarPagamentos38.consultarSaldo(transferencia38);
                break;
            case 4:
                return;
            default:
                System.out.println("Digite uma opção válida.");
        }
    }


}
