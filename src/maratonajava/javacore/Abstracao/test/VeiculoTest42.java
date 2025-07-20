package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest42 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Frota42 frota42 = new Frota42();

    public static void main(String[] args) {
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Pesquisa por placa.");
                System.out.println("[4] Excluir veiculo.");
                System.out.println("[5] Alterar dados veiculo.");
                System.out.println("[6] Registrar Pagamento IPVA.");
                System.out.println("[7] Mostrar histórico IPVA.");
                System.out.println("[8] Sair. ");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo();
                        break;
                    case 2:
                        frota42.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota42.exibirPesquisaPorPlaca();
                        break;
                    case 4:
                        frota42.excluirVeiculo();
                        break;
                    case 5:
                        frota42.alterarDadosVeiculo();
                        break;
                    case 6:
                        frota42.registrarPagamentoIPVA();
                        break;
                    case 7:
                        frota42.mostrarHistoricoIPVA();
                        break;
                    case 8:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Erro. Valor inválido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().toLowerCase().trim();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Opção inválida. tente novamente.");
            return;
        }
        String placa = Frota42.validandoPlaca();
        int anoFabricacao = Frota42.validandoAnoFabricacao();
        String cor = Frota42.validandoCor();
        double valorMercado = Frota42.validandoValorMercado();
        Veiculo42 veiculo42 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo42 = new Carro42(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo42 = new Moto42(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo42 = new Caminhao42(placa,anoFabricacao,cor,valorMercado);
                break;
        }
        frota42.addVeiculoSistema(veiculo42);
    }

}
