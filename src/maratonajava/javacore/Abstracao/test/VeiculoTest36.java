package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota36 frota36 = new Frota36();
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Mostrar histórico pagamento.");
                System.out.println("[4] Exibir pesquisa por placa.");
                System.out.println("[5] Excluir dados pesquisa.");
                System.out.println("[6] Alterar dados veiculo.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota36);
                        break;
                    case 2:
                        frota36.listarVeiculos();
                        break;
                    case 3:
                        frota36.mostrarHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota36.exibirPesquisaPorPlaca(scanner);
                        break;
                    case 5:
                        frota36.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota36.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota36.registrarPagamentoIPVA(scanner);
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

    public static void cadastroVeiculo(Scanner scanner, Frota36 frota36){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida:carro, moto ou veiculo.");
            return;
        }
        String placa = Frota36.validandoPlaca(scanner);
        int anoFabricacao = Frota36.validandoAnoFabricacao(scanner);
        String cor = Frota36.validandoCor(scanner);
        double valorDeMercado = Frota36.validandoValorMercado(scanner);
        Veiculo36 veiculo36 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo36 = new Carro36(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo36 = new Moto36(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo36 = new Caminhao36(placa,anoFabricacao,cor,valorDeMercado);
                break;
        }
        frota36.addVeiculoSistema(veiculo36);
    }

}
