package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota08 frota08 = new Frota08();
        while (true){
            try {
                System.out.println("[1] Cadastro veículo.");
                System.out.println("[2] Lista de veículos cadastrados.");
                System.out.println("[3] Pesquisa por placa.");
                System.out.println("[4] Exibir histórico IPVA.");
                System.out.println("[5] Excluir veículo.");
                System.out.println("[6] Alterar dados veículos.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota08);
                        break;
                    case 2:
                        frota08.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota08.pesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota08.exibibirHistoricoIPVA(scanner);
                        break;
                    case 5:
                        frota08.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota08.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota08.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota08 frota08){
        System.out.println("Digite o tipo de veículo (carro, moto, caminhão):");
        String tipo = scanner.nextLine().trim();
        if (!tipo.equalsIgnoreCase("carro") && !tipo.equalsIgnoreCase("moto") && !tipo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas carro, moto ou caminhão");
            return;
        }
        String placa = Frota08.validandoPlaca(scanner);
        int anoFabricacao = Frota08.validandoAnoFabricacao(scanner);
        String cor = Frota08.validandoCor(scanner);
        double valorDeMercado = Frota08.validandoValorDeMercado(scanner);
        Veiculo08 veiculo08 = null;
        switch (tipo.toLowerCase()){
            case "carro":
                veiculo08 = new Carro08(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo08 = new Moto08(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo08 = new Caminhao08(placa,anoFabricacao,cor,valorDeMercado);
        }
        frota08.addVeiculo(veiculo08);
    }

}
