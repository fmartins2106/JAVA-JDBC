package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota26 frota26 = new Frota26();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Pesquisa por placa.");
            System.out.println("[4] Histórico pagamento IPVA.");
            System.out.println("[5] Excluir dados veiculo.");
            System.out.println("[6] Registrar pagamento IPVA.");
            System.out.println("[7] Alterar dados veiculo.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota26);
                        break;
                    case 2:
                        frota26.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota26.exibirPesquisaPlaca(scanner);
                        break;
                    case 4:
                        frota26.mostrarHistoricoIPVA(scanner);
                        break;
                    case 5:
                        frota26.excluirDados(scanner);
                        break;
                    case 6:
                        frota26.registrarPagamentoIPVA(scanner);
                        break;
                    case 7:
                        frota26.alterarDadosVeiculo(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizado programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota26 frota26){
        System.out.print("Digite uma das opções a seguir: carro, moto ou caminhão -> ");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida: carro, moto ou caminhão.");
            return;
        }
        String placa = Frota26.validandoPlaca(scanner);
        int anoFabricacao = Frota26.validandoAnoFabricacao(scanner);
        String cor = Frota26.validandoCor(scanner);
        double valorMercado = Frota26.validandoValorMercado( scanner);
        Veiculo26 veiculo26 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo26 = new Carro26(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo26 = new Moto26(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo26 = new Caminhao26(placa,anoFabricacao,cor,valorMercado);
                break;
        }
        frota26.addVeiculo(veiculo26);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

}
