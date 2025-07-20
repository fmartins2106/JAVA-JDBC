package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota33 frota33 = new Frota33();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Mostrar histórico pagamento.");
            System.out.println("[5] Excluir dados veiculo.");
            System.out.println("[6] Registrar pagamento.");
            System.out.println("[7] Alterar dados veiculos.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota33);
                        break;
                    case 2:
                        frota33.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota33.exibirDadosPesquisaVeiculo(scanner);
                        break;
                    case 4:
                        frota33.mostrarHistoricoIPVA(scanner);
                        break;
                    case 5:
                        frota33.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota33.registrarPagamentoIPVA(scanner);
                        break;
                    case 7:
                        frota33.alterarDadosVeiculo(scanner);
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

    public static void cadastroVeiculo(Scanner scanner,Frota33 frota33){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida. Carro, moto ou caminhão.");
            return;
        }
        String placa = Frota33.validandoPlaca(scanner);
        int anoFabricacao = Frota33.validandoAnoFabricacao(scanner);
        String cor = Frota33.validandoCor(scanner);
        double valorMercado = Frota33.validandoValorMercado(scanner);
        Veiculo33 veiculo33 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo33 = new Carro33(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo33 = new Moto33(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo33 = new Caminhao33(placa,anoFabricacao,cor,valorMercado);
                break;
        }
        frota33.addVeiculoSistema(veiculo33);
    }

}

