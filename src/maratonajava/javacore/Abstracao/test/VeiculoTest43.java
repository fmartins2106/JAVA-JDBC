package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest43 {
    private static Scanner scanner = new Scanner(System.in);
    private static Frota43 frota43 = new Frota43();

    public static void main(String[] args) {
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Excluir veiculo.");
                System.out.println("[4] Alterar dados veiculo.");
                System.out.println("[5] Registrar pagamento IPVA.");
                System.out.println("[6] Mostrar histórico IPVA.");
                System.out.println("[7] Pesquisa por placa.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo();
                        break;
                    case 2:
                        frota43.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota43.excluirVeiculo();
                        break;
                    case 4:
                        frota43.alterarDadosVeiculo();
                        break;
                    case 5:
                        frota43.registrarPagamentoIPVA();
                        break;
                    case 6:
                        frota43.mostrarHistoricoIPVA();
                        break;
                    case 7:
                        frota43.pesquisaPorPlaca();
                        break;
                    case 8:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Erro. Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static void cadastroVeiculo(){
        System.out.print("Digite o tipo de veiculo -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Erro. Opção inválida.");
            return;
        }
        String placa = Frota43.validandoPlaca();
        int anoFabricacao = Frota43.validandoAnoFabricacao();
        String cor = Frota43.validandoCor();
        double valorMercado = Frota43.validandoValorMercado();
        Veiculo43 veiculo43 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo43 = new Carro43(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo43 = new Moto43(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo43 = new Caminhao43(placa,anoFabricacao,cor,valorMercado);
        }
        frota43.addVeiculoSistema(veiculo43);
    }
}
