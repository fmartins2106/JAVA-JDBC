package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota25 frota25 = new Frota25();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos.");
            System.out.println("[3] Pesquisa por placa.");
            System.out.println("[4] Mostrar histórico pagamento IPVA.");
            System.out.println("[5] Excluir dados veiculo.");
            System.out.println("[6] Alterar dados veiculo.");
            System.out.println("[7] Registrar pagamento IPVA.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota25);
                        break;
                    case 2:
                        frota25.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota25.exibirPesquisaPlaca(scanner);
                        break;
                    case 4:
                        frota25.mostrarHistoricoIPVA(scanner);
                        break;
                    case 5:
                        frota25.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota25.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota25.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa.");
                    return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner,Frota25 frota25){
        System.out.print("Digite uma das opções: carro, moto ou caminhão ->");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas uma das opções: carro, moto ou caminhão");
            return;
        }
        String placa = Frota25.validandoPlaca(scanner);
        int anoFabricacao = Frota25.validandoAnoFabricacao(scanner);
        String cor = Frota25.validandoCor(scanner);
        double valorMercado = Frota25.validandoValorMercado(scanner);
        Veiculo25 veiculo25 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo25 = new

                        Carro25(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo25 = new Moto25(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo25 = new Caminhao25(placa,anoFabricacao,cor,valorMercado);
        }
        frota25.addVeiculo(veiculo25);
    }
}
