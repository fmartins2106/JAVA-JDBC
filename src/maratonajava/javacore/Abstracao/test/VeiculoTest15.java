package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota15 frota15 = new Frota15();
        while (true){
            try {
                System.out.println("[1] Cadastro Veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Histórico pagamento IPVA.");
                System.out.println("[4] Pesquisa por placa.");
                System.out.println("[5] Excluir dados veiculo.");
                System.out.println("[6] Alterar dados veiculo.");
                System.out.println("[7] Registrar pagamento veiculo.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota15);
                        break;
                    case 2:
                        frota15.listarVeiculosCadastrado();
                        break;
                    case 3:
                        frota15.validandoExibirHistoricoPagamentoIPVA(scanner);
                        break;
                    case 4:
                        frota15.exibirPesquisaPorPlaca(scanner);
                        break;
                    case 5:
                        frota15.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota15.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota15.validandoRegistroPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota15 frota15){
        System.out.println("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas uma das opções -> carro, moto ou caminhão.");
            return;
        }
        String placa = Frota15.validandoPlaca(scanner);
        int anoFabricacao = Frota15.validandoAnoDeFabricacao(scanner);
        String cor = Frota15.validandoCor(scanner);
        double valorDeMercado = Frota15.validandoValorDeMercado(scanner);
        Veiculo15 veiculo15 = null;
        switch (tipoVeiculo.toLowerCase()){
            case "carro":
                veiculo15 = new Carro15(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo15 = new Moto15(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo15 = new Caminhao15(placa,anoFabricacao,cor,valorDeMercado);
        }
        frota15.addVeiculo(veiculo15);
        System.out.println("Veiculo cadastro com sucesso.");
    }
}
