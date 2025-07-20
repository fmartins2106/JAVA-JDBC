package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota03 frota03 = new Frota03();
        while (true){
            System.out.println("[1] Cadastro veículo.");
            System.out.println("[2] Lista de veículos cadastrados.");
            System.out.println("[3] Exibir histórico IPVA.");
            System.out.println("[4] Pesquisa veículo por placa.");
            System.out.println("[5] Excluir veículo.");
            System.out.println("[6] Alterar dados veículos.");
            System.out.println("[7] Registrar pagamento IPVA.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota03);
                        break;
                    case 2:
                        frota03.listaDeVeiculosCadastrados();
                        break;
                    case 3:
                        frota03.exibirHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota03.pesquisaPorPlaca(scanner);
                        break;
                    case 5:
                        frota03.excluirVeiculo(scanner);
                        break;
                    case 6:
                        frota03.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota03.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma das opções acima.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota03 frota03){
        System.out.print("Tipo de veículo(carro, moto, caminhão):");
        String tipo = scanner.nextLine().trim();
        if (!tipo.equalsIgnoreCase("carro") && !tipo.equalsIgnoreCase("moto") && !tipo.equalsIgnoreCase("caminhão")){
            System.out.println("ERRO: tipo de veículo deve ser carro, moto ou caminhão. Tente novamente.");
            return;
        }
        String placa = Frota03.validandoPlacas(scanner);
        int anoFabricacao = Frota03.validandoAnoFabricacao(scanner);
        String cor = Frota03.validandoCor(scanner);
        double valorDeMercado = Frota03.validandoValorDeMercado(scanner);
        Veiculo03 veiculo03 = null;
        switch (tipo.toLowerCase()){
            case "carro":
                veiculo03 = new Carro03(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo03 = new Moto03(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo03 = new Caminhao03(placa,anoFabricacao,cor,valorDeMercado);
        }
        frota03.addVeiculo(veiculo03);
    }
}
