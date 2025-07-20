package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota24 frota24 = new Frota24();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Pesquisa por placa.");
            System.out.println("[4] Histórico pagamento IPVA.");
            System.out.println("[5] Excluir dados veiculo.");
            System.out.println("[6] Alterar dados veiculo.");
            System.out.println("[7] Registrar pagamento IPVA.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota24);
                        break;
                    case 2:
                        frota24.listarVeiculos();
                        break;
                    case 3:
                        frota24.exibirPesquisaPlaca(scanner);
                        break;
                    case 4:
                        frota24.historicoPagamentoIPVA(scanner);
                        break;
                    case 5:
                        frota24.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota24.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota24.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota24 frota24){
        System.out.print("Digite uma das opções a seguir: carro, moto ou caminhão ->");
        String opcao = scanner.nextLine().trim();
        if (!opcao.equalsIgnoreCase("carro") && !opcao.equalsIgnoreCase("moto") && !opcao.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida: carro, moto ou caminhão.");
            return;
        }
        String placa = Frota24.validandoPlaca(scanner);
        int anoFabricacao = Frota24.validandoAnoFabricacao(scanner);
        String cor = Frota24.validandoCor(scanner);
        double valorMercado = Frota24.validandoValorMercado(scanner);
        Veiculo24 veiculo24 = null;
        switch (opcao.toLowerCase()){
            case "carro":
                veiculo24 = new Carro24(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo24 = new Moto24(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo24 = new Caminhao24(placa,anoFabricacao,cor,valorMercado);
        }
        frota24.addVeiculo(veiculo24);
    }
}
