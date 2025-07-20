package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota32 frota32 = new Frota32();
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Pesquisa por placa.");
                System.out.println("[4] Mostrar histórico pagamento.");
                System.out.println("[5] Excluir dados veiculo.");
                System.out.println("[6] Alterar dados veiculo.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota32);
                        break;
                    case 2:
                        frota32.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota32.exibirPesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota32.mostrarHistoricoPagamentoIPVA(scanner);
                        break;
                    case 5:
                        frota32.excluirDadoVeiculo(scanner);
                        break;
                    case 6:
                        frota32.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota32.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válidia.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota32 frota32){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Opção inválida. Digite Carro, moto ou caminhão");
            return;
        }
        String placa = Frota32.validandoPlaca(scanner);
        int anoFabricacao = Frota32.validandoAnoFabricacao(scanner);
        String cor = Frota32.validandoCor(scanner);
        double valorMercado = Frota32.validandoValorMercado(scanner);
        Veiculo32 veiculo32 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo32 = new Carro32(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo32 = new Moto32(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo32 = new Caminhao32(placa,anoFabricacao,cor,valorMercado);
                break;
        }
        frota32.addVeiculo(veiculo32);
    }

}
