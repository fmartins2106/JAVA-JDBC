package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota30 frota30 = new Frota30();
        while (true){
            System.out.println("[1] Cadastro de veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Mostrar histórico IPVA.");
            System.out.println("[4] Pesquisa por placa.");
            System.out.println("[5] Excluir dados veiculos.");
            System.out.println("[6] Registrar pagamento IPVA.");
            System.out.println("[7] Alterar dados veiculo.");
            System.out.println("[8] Sair.");
            System.out.print("Digite uma das opções acima:");
            int opcao = Integer.parseInt(scanner.nextLine().trim());
            switch (opcao){
                case 1:
                    cadastroVeiculo(scanner,new Frota30());
                    break;
                case 2:
                    frota30.listarVeiculosCadastrados();
                    break;
                case 3:
                    frota30.mostrarHistoricoPagamento(scanner);
                    break;
                case 4:
                    frota30.exibirDadosVeiculo(scanner);
                    break;
                case 5:
                    frota30.excluirDadosVeiculo(scanner);
                    break;
                case 6:
                    frota30.registrarPagamento(scanner);
                    break;
                case 7:
                    frota30.alterarDadosVeiculo(scanner);
                    break;
                case 8:
                    System.out.println(">>>Finalizando programa.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota30 frota30){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro")  && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida (carro, moto ou caminhão).");
        }
        String placa = Frota30.validandoPlaca(scanner);
        int anoFabricacao = Frota30.validandoAnoFabricacao(scanner);
        String cor = Frota30.validandoCor(scanner);
        double valorMercado = Frota30.validandoValorMercado(scanner);
        Veiculo30 veiculo30 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo30 = new Carro30(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo30 = new Moto30(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo30 = new Caminhao30(placa,anoFabricacao,cor,valorMercado);
        }
        frota30.addVeiculo(veiculo30);
    }
}
