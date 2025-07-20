package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota22 frota22 = new Frota22();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Mostrar histórico pagamento.");
            System.out.println("[4] Pesquisa por placa.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Registrar Pagamento IPVA.");
            System.out.println("[7] Alterar dados veiculo.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota22);
                        break;
                    case 2:
                        frota22.listaVeiculosCadastrado();
                        break;
                    case 3:
                        frota22.mostrarHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota22.exibirDadosPesquisaPlaca(scanner);
                        break;
                    case 5:
                        frota22.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota22.registraPagamento(scanner);
                        break;
                    case 7:
                        frota22.alterarDadosVeiculo(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota22 frota22){
        System.out.print("Digite uma das opções a seguir: carro, moto ou caminhão ->");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas uma das opções: carro, moto ou caminhão.");
            return;
        }
        String placa = Frota22.validandoPlaca(scanner);
        int anoFabricacao = Frota22.validandoAnoFabricacao(scanner);
        String cor = Frota22.validandoCor(scanner);
        double valorMercado = Frota22.validandoValorMercado(scanner);
        Veiculo22 veiculo22 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo22 = new Carro22(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo22 = new Moto22(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo22 = new Caminhao22(placa,anoFabricacao,cor,valorMercado);
                break;
        }
        frota22.addVeiculo(veiculo22);
    }
}
