package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota23 frota23 = new Frota23();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Histórico pagamento IPVA.");
            System.out.println("[4] Pesquisa por placa.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Registrar pagamento IPVA.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota23);
                        break;
                    case 2:
                        frota23.listarVeiculoCadastrado();
                        break;
                    case 3:
                        frota23.historicoPagamentoIPVA(scanner);
                        break;
                    case 4:
                        frota23.exibirPesquisaPlaca(scanner);
                        break;
                    case 5:
                        frota23.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota23.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota23.registroPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma das opções acima.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota23 frota23){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas uma das opções válidas: carro, moto ou caminhão.");
            return;
        }
        String placa = Frota23.validandoPlaca(scanner);
        int anoFabricacao = Frota23.validandoAnoFabricacao(scanner);
        String cor = Frota23.validandoCor(scanner);
        double valorMercado = Frota23.validandoValorMercado(scanner);
        Veiculo23 veiculo23 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo23 = new Carro23(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo23 = new Moto23(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo23 = new Caminhao23(placa,anoFabricacao,cor,valorMercado);
                break;
        }
        frota23.addVeiculoSistema(veiculo23);
    }
}
