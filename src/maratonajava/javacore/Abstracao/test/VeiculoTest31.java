package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota31 frota31 = new Frota31();
        while (true){
            System.out.println("[1] Cadastrar veiculo.");
            System.out.println("[2] Listar veiculos cadastrados.");
            System.out.println("[3] Mostrar histórico pagamento IPVA.");
            System.out.println("[4] Pesquisa por placa.");
            System.out.println("[5] Excluir dados veiculo.");
            System.out.println("[6] Alterar dados veiculo.");
            System.out.println("[7] Registrar pagamento IPVA.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota31);
                        break;
                    case 2:
                        frota31.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota31.mostrarHistoricoPagamentoIPVA(scanner);
                        break;
                    case 4:
                        frota31.exibirPesquisaPorPlaca(scanner);
                        break;
                    case 5:
                        frota31.excluirDados(scanner);
                        break;
                    case 6:
                        frota31.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota31.registrarPagamentoIPVA(scanner);
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

    public static void cadastroVeiculo(Scanner scanner, Frota31 frota31){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida: Carro, moto ou caminhão.");
            return;
        }
        String placa = Frota31.validandoPlaca(scanner);
        int anoFabricacao = Frota31.validandoAnoFabricacao(scanner);
        String cor = Frota31.validandoCor(scanner);
        double valorMercado = Frota31.validandoValorMercado(scanner);
        Veiculo31 veiculo31 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo31 = new Carro31(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo31 = new Moto31(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo31 = new Caminhao31(placa,anoFabricacao,cor,valorMercado);
                break;
        }
        frota31.addVeiculo(veiculo31);
    }

}
