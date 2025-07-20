package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest41 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Frota41 frota41 = new Frota41();

    public static void main(String[] args) {
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Mostrar histórico de pagamento.");
                System.out.println("[4] Excluir dados veiculo.");
                System.out.println("[5] Pesquisa por placa.");
                System.out.println("[6] Registrar pagamento IPVA.");
                System.out.println("[7] Alterar dados veiculo.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo();
                        break;
                    case 2:
                        frota41.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota41.mostrarHistoricoPagamentoIPVA();
                        break;
                    case 4:
                        frota41.excluirDadosVeiculo();
                        break;
                    case 5:
                        frota41.exibirPesquisaPorPlaca();
                        break;
                    case 6:
                        frota41.registrarPagamentoIPVA();
                        break;
                    case 7:
                        frota41.alterarDados();
                        break;
                    case 8:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Opção invalida. Tente novamente.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido.");
            }
        }
    }

    public static void cadastroVeiculo(){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Erro. Digite uma opção válida. Carro, moto ou caminhão.");
            return;
        }
        String placa = Frota41.validandoPlaca();
        int anoFabricacao = Frota41.validandoAnoFabricacao();
        String cor = Frota41.validandoCor();
        double valorMercado = Frota41.validandoValorMercado();
        Veiculo41 veiculo41 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo41 = new Carro41(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo41 = new Moto41(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo41 = new Caminhao41(placa,anoFabricacao,cor,valorMercado);
        }
        frota41.addVeiculoSistema(veiculo41);
    }
}
