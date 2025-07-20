package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota35 frota35 = new Frota35();
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Pesquisa por placa.");
                System.out.println("[4] mostrar histórico pagamento.");
                System.out.println("[5] Excluir dados veiculo.");
                System.out.println("[6] Alterar dados veiculo.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota35);
                        break;
                    case 2:
                        frota35.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota35.exibirPesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota35.mostrarHistoricoPagamento(scanner);
                        break;
                    case 5:
                        frota35.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota35.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota35.registrarPagamento(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota35 frota35){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida: carro, moto ou caminhão.");
            return;
        }
        String placa = Frota35.validandoPlaca(scanner);
        int anoFabricacao = Frota35.validandoAnoFabricacao(scanner);
        String cor = Frota35.validandoCor(scanner);
        double valorMercado = Frota35.validandoValorMercado(scanner);
        Veiculo35 veiculo35 = null;
        switch (tipoVeiculo.toLowerCase()){
            case "carro":
                veiculo35 = new Carro35(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo35 = new Moto35(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo35 = new Caminhao35(placa,anoFabricacao,cor,valorMercado);
                break;
        }
        frota35.addVeiculoSistema(veiculo35);
    }
}
