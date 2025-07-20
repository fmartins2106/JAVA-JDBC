package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota04 frota04 = new Frota04();
        while (true){
            try {
                System.out.println("[1] Cadastro de véiculo.");
                System.out.println("[2] Lista de veículos cadastrados.");
                System.out.println("[3] Exibir histórico IPVA.");
                System.out.println("[4] Pesquisa veículo por placa.");
                System.out.println("[5] Excluir veículo.");
                System.out.println("[6] Alterar dados veículo.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota04);
                        break;
                    case 2:
                        frota04.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota04.exibirHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota04.pesquisaPorPlaca(scanner);
                        break;
                    case 5:
                        frota04.excluirVeiculo(scanner);
                        break;
                    case 6:
                        frota04.alterarDadosVeiculos(scanner);
                        break;
                    case 7:
                        frota04.registrarPagamentoIPVA(scanner);
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

    public static void cadastroVeiculo(Scanner scanner, Frota04 frota04){
        System.out.print("Digite o tipo de veículo (carro, moto, caminhão):");
        String tipo = scanner.nextLine().trim();
        if (!tipo.equalsIgnoreCase("carro") && !tipo.equalsIgnoreCase("moto") && !tipo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas, carro, moto ou caminhão.");
            return;
        }
        String placa = Frota04.validandoPlacas(scanner);
        int anoFabricacao = Frota04.validandoAnoFabricacao(scanner);
        String cor = Frota04.validandoCor(scanner);
        double valorMercado = Frota04.validandoValorDeMercado(scanner);
        Veiculo04 veiculo04 = null;
        switch (tipo.toLowerCase()){
            case "carro":
                veiculo04 = new Carro04(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo04 = new Moto04(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo04 = new Caminhao04(placa,anoFabricacao,cor,valorMercado);
                break;
        }
        frota04.addVeiculos(veiculo04);
    }
}
