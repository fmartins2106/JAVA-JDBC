package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota19 frota19 = new Frota19();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos.");
            System.out.println("[3] Histórico pagamento IPVA.");
            System.out.println("[4] Pesquisa por placa.");
            System.out.println("[5] Alterar dados veiculo.");
            System.out.println("[6] Registrar pagamento veiculo.");
            System.out.println("[7] Excluir dados veiculo.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima.");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota19);
                        break;
                    case 2:
                        frota19.listaVeiculos();
                        break;
                    case 3:
                        frota19.mostrarHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota19.exibirPesquisaPlaca(scanner);
                        break;
                    case 5:
                        frota19.alterarDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota19.registrarPagamentoIPVA(scanner);
                        break;
                    case 7:
                        frota19.excluirVeiculo(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota19 frota19){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String opcao = scanner.nextLine().trim().toLowerCase();
        if (!opcao.equalsIgnoreCase("carro") && !opcao.equalsIgnoreCase("moto") && !opcao.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas uma das opções: carro, moto ou caminhão.");
            return;
        }
        String placa = Frota19.validandoPlaca(scanner);
        int anoFabricacao = Frota19.validandoAnoDeFabricacao(scanner);
        String cor = Frota19.validandoCor(scanner);
        double valorDeMercado = Frota19.validandoValorDeMercado(scanner);
        Veiculo19 veiculo19 = null;
        switch (opcao){
            case "carro":
                veiculo19 = new Carro19(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo19 = new Moto19(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo19 = new Caminhao19(placa,anoFabricacao,cor,valorDeMercado);
                break;
        }
        frota19.addVeiculo(veiculo19);
    }
}
