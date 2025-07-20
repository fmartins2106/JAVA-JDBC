package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest40 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Frota40 frota = new Frota40();

    public static void main(String[] args) {
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Listar veiculos.");
                System.out.println("[3] Mostrar histórico pagamentoIPVA.");
                System.out.println("[4] Excluir dados veiculo.");
                System.out.println("[5] Alterar dados veiculo.");
                System.out.println("[6] Registrar pagamento IPVA.");
                System.out.println("[7] Pesquisa por placa.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo();
                        break;
                    case 2:
                        frota.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota.mostrarHistoricoPagamentoIPVA();
                        break;
                    case 4:
                        frota.excluirDados();
                        break;
                    case 5:
                        frota.alterarDadosVeiculo();
                        break;
                    case 6:
                        frota.registrarPagamentoIPVA();
                        break;
                    case 7:
                        frota.exibirPesquisaPorPlaca();
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

    public static void cadastroVeiculo(){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Erro. Digite uma opção válida. Carro, moto ou caminhão.");
            return;
        }
        String placa = Frota40.validandoPlaca();
        int anoFabricacao = Frota40.validandoAnoFabricacao();
        String cor = Frota40.validandoCor();
        double valorMercado = Frota40.validandoValorMercado();
        Veiculo40 veiculo40 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo40 = new Carro40(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo40 = new Moto40(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo40 = new Caminhao40(placa,anoFabricacao,cor,valorMercado);
                break;
        }

        frota.addVeiculoSistema(veiculo40);
    }

}
