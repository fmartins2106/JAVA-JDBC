package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest37 {
    public static void main(String[] args) {
        Frota37 frota37 = new Frota37();
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Listar veiculos cadastrados.");
                System.out.println("[3] Pesquisa por placa.");
                System.out.println("[4] Alterar dados veiculo.");
                System.out.println("[5] Excluir dados veiculo.");
                System.out.println("[6] Mostrar histórico IPVA.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota37);
                        break;
                    case 2:
                        frota37.listarVeiculos();
                        break;
                    case 3:
                        frota37.exibirDadosPesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota37.alterarDadoVeiclo(scanner);
                        break;
                    case 5:
                        frota37.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota37.mostrarHistoricoPagamentoIPVA(scanner);
                        break;
                    case 7:
                        frota37.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota37 frota37){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida. Carro, moto ou caminhão.");
            return;
        }
        String placa = Frota37.validandoPlaca(scanner);
        int anoFabricacao = Frota37.validandoAnoFabricacao(scanner);
        String cor = Frota37.validandoCor(scanner);
        double valorMercado = Frota37.validandoValorMercado(scanner);
        Veiculo37 veiculo37 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo37 = new Carro37(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo37 = new Moto37(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo37 = new Caminhao37(placa,anoFabricacao,cor,valorMercado);
        }
        frota37.addVeiculoSistema(veiculo37);
    }

}
