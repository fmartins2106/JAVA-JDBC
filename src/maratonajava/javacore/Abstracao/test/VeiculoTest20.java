package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota20 frota20 = new Frota20();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos.");
            System.out.println("[3] Pesquisa por placa.");
            System.out.println("[4] Histórico IPVA.");
            System.out.println("[5] Excluir dados veiculo.");
            System.out.println("[6] Registrar pagamento IPVA.");
            System.out.println("[7] Alterar dados veiculo.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota20);
                        break;
                    case 2:
                        frota20.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota20.exibirPesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota20.mostrarHistoricoIPVA(scanner);
                        break;
                    case 5:
                        frota20.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota20.registrarPagamentoIPVA(scanner);
                        break;
                    case 7:
                        frota20.alterarDadosVeiculo(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota20 frota20){
        System.out.print("Digite uma das opções a seguir: carro, moto ou caminhão ->");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas uma das opções. Carro, moto ou caminhão !");
            return;
        }
        String placa = Frota20.validandoPlaca(scanner);
        int anoFabricacao = Frota20.validandoAnoDeFabricacao(scanner);
        String cor = Frota20.validandoCor(scanner);
        double valorDeMercado = Frota20.validandoValorDeMercado(scanner);
        Veiculo20 veiculo20 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo20 = new Carro20(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo20 = new Moto20(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo20 = new Caminhao20(placa,anoFabricacao,cor,valorDeMercado);
                break;
        }
        frota20.addVeiculo(veiculo20);
        System.out.println("Veiculo cadastrado com sucesso.");
    }
}
