package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota27 frota27 = new Frota27();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Mostrar histórico pagamento.");
            System.out.println("[4] Excluir dados veiculo.");
            System.out.println("[5] Pesquisa por placa.");
            System.out.println("[6] Registrar pagamento IPVA.");
            System.out.println("[7] Alterar dados veiculo.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota27);
                        break;
                    case 2:
                        frota27.listarVeiculos();
                        break;
                    case 3:
                        frota27.mostrarHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota27.excluirDadosVeiculo(scanner);
                        break;
                    case 5:
                        frota27.exibirPesquisaPorPlaca(scanner);
                        break;
                    case 6:
                        frota27.registrarPagamentoIPVA(scanner);
                        break;
                    case 7:
                        frota27.alterarDadosVeiculo(scanner);
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

    public static void cadastroVeiculo(Scanner scanner, Frota27 frota27){
        System.out.print("Digite uma das opções a seguir: carro, moto ou caminhão ->");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas uma das três opções: carro, moto ou caminhão.");
            return;
        }
        String placa = Frota27.validandoPlaca(scanner);
        int anoFabricacao =Frota27.validandoAnoFabricacao(scanner);
        String cor = Frota27.validandoCor(scanner);
        double valorMercado =Frota27.validandoValorMercado(scanner);
        Veiculo27 veiculo27 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo27 = new Carro27(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo27 = new Moto27(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo27 = new Caminhao27(placa,anoFabricacao,cor,valorMercado);
        }

        frota27.addVeiculo(veiculo27);
    }
}
