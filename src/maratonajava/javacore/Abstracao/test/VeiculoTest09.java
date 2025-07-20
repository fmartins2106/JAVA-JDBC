package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota09 frota09 = new Frota09();
        while (true){
            try {
                System.out.println("[1] Cadastro veículo.");
                System.out.println("[2] Lista de veículos cadastrados.");
                System.out.println("[3] Exibir histórico pagamento IPVA.");
                System.out.println("[4] Pesquisa por placa.");
                System.out.println("[5] Excluir dados veículo.");
                System.out.println("[6] Alterar dados veículo.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota09);
                        break;
                    case 2:
                        frota09.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota09.exibirHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota09.pesquisaPorPlaca(scanner);
                        break;
                    case 5:
                        frota09.excluirVeiculoCadastrado(scanner);
                        break;
                    case 6:
                        frota09.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota09.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota09 frota09){
        System.out.println("Digite uma das opções (Carro, moto ou caminhão):");
        String tipoVeiculo = scanner.nextLine().trim();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas carro, moto ou caminhão.");
            return;
        }
        String placa = Frota09.validandoPlaca(scanner);
        int anoFabricacao = Frota09.validandoAnoDeFabricacao(scanner);
        String cor = Frota09.validandoCor(scanner);
        double valorDeMercado = Frota09.validandoValorDeMercado(scanner);
        Veiculo09 veiculo09 = null;
        switch (tipoVeiculo.toLowerCase()){
            case "carro":
                veiculo09 = new Carro09(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo09 = new Moto09(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo09  = new Caminhao09(placa,anoFabricacao,cor,valorDeMercado);
        }
        frota09.addVeiculos(veiculo09);
    }
}

