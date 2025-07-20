package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota39 frota39 = new Frota39();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Mostrar histórico de pagamento de IPVA.");
            System.out.println("[4] Pesquisa por placa.");
            System.out.println("[5] Registrar pagamento IPVA.");
            System.out.println("[6] Excluir dados veiculo.");
            System.out.println("[7] Alterar dados.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digiteu uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota39);
                        break;
                    case 2:
                        frota39.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota39.mostrarHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota39.exibirPesquisaPorPlaca(scanner);
                        break;
                    case 5:
                        frota39.registrarPagamentoIPVA(scanner);
                        break;
                    case 6:
                        frota39.excluirDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota39.alterarDadosVeiculo(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota39 frota39){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().toLowerCase().trim();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida. Carro moto ou caminhão.");
            return;
        }
        String placa = Frota39.validandoPlaca(scanner);
        int anoFabricacao = Frota39.validandoAnoFabricacao(scanner);
        String cor = Frota39.validandoCor(scanner);
        double valorMercado = Frota39.validandoValorMercado(scanner);
        Veiculo39 veiculo39 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo39 = new Carro39(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo39 = new Moto39(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo39 = new Caminhao39(placa,anoFabricacao,cor,valorMercado);
                break;
        }
        frota39.addVeiculoSistema(veiculo39);
    }

}
