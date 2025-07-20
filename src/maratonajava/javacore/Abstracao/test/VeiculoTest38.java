package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota38 frota38 = new Frota38();
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Pesquisa por placa.");
                System.out.println("[4] Mostrar histórico IPVA.");
                System.out.println("[5] Excluir dados veiculo.");
                System.out.println("[6] Alterar dados veiculo.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota38);
                        break;
                    case 2:
                        frota38.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota38.exibirPesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota38.mostrarHistoricoIPVA(scanner,"mostrar");
                        break;
                    case 5:
                        frota38.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota38.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota38.mostrarHistoricoIPVA(scanner,"registrar");
                        break;
                    case 8:
                        System.out.println(">>>>>>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota38 frota38){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().toLowerCase().trim();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Opção inválida. Digite uma das opções: carro, moto ou caminhão.");
            return;
        }
        String placa = Frota38.validandoPlaca(scanner);
        int anoFabricacao = Frota38.valindandoAnoFabricacao(scanner);
        String cor = Frota38.validandoCor(scanner);
        double valorMercado = Frota38.validandoValorMercado(scanner);
        Veiculo38 veiculo38 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo38 = new Carro38(placa,anoFabricacao,cor,valorMercado);
            case "moto":
                veiculo38 = new Moto38(placa,anoFabricacao,cor,valorMercado);
            case "caminhão":
                veiculo38 = new Caminhao38(placa,anoFabricacao,cor,valorMercado);
        }
        frota38.addVeiculoSistema(veiculo38);
    }
}
