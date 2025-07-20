package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota13 frota13 = new Frota13();
        while (true){
            System.out.println("[1] Cadastro de veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Pesquisa por placa.");
            System.out.println("[4] Historico pagamento IPVA.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Registrar pagamento IPVA.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota13);
                        break;
                    case 2:
                        frota13.listarVeiculos();
                        break;
                    case 3:
                        frota13.pesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota13.historicoPagamentoIPVA(scanner);
                        break;
                    case 5:
                        frota13.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota13.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota13.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida. ");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota13 frota13){
        System.out.print("Digite uma das opções --> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas carro, moto, ou caminhão.");
            return;
        }
        String placa = Frota13.validandoPlaca(scanner);
        int anoFabricacao = Frota13.validandoAnoFabricacao(scanner);
        String cor = Frota13.validandoCor(scanner);
        double valorDeMercado = Frota13.validandoValorDeMercado(scanner);
        Veiculo13 veiculo13 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo13 = new Carro13(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo13 = new Moto13(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo13 = new Caminhao13(placa,anoFabricacao,cor,valorDeMercado);
        }
        frota13.addVeiculos(veiculo13);
        System.out.println("Veiculo cadastrado com sucesso.");
    }
}
