package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota06 frota06 = new Frota06();
        while (true){
            try {
                System.out.println("[1] Cadastro veículo.");
                System.out.println("[2] Lista de veículos cadastrados.");
                System.out.println("[3] Pesquisa por placa.");
                System.out.println("[4] Exibir histórico IPVA.");
                System.out.println("[5] Excluir veículo.");
                System.out.println("[6] Alterar dados veículo. ");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota06);
                        break;
                    case 2:
                        frota06.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota06.pesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota06.exibirHistoricoIPVA(scanner);
                        break;
                    case 5:
                        frota06.excluirDados(scanner);
                        break;
                    case 6:
                        frota06.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota06.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota06 frota06){
        System.out.println("Digite o tipo de veículo(carro, moto, caminhão):");
        String tipo = scanner.nextLine().trim();
        if (!tipo.equalsIgnoreCase("carro") && !tipo.equalsIgnoreCase("moto") && !tipo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida, carro, moto ou caminhão.");
            return;
        }
        String placa = Frota06.validandoPlaca(scanner);
        int anoFabricacao = Frota06.validandoIdade(scanner);
        String cor = Frota06.validandoCor(scanner);
        double valorDeMercado = Frota06.validandoValorDeMercado(scanner);
        Veiculo06 veiculo06 = null;
        switch (tipo.toLowerCase()){
            case "carro":
                veiculo06 = new Carro06(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo06 = new Moto06(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo06 = new Caminhao06(placa,anoFabricacao,cor,valorDeMercado);
                break;
        }
        frota06.addVeiculo(veiculo06);
        System.out.println("Veículo cadastrado com sucesso.");
    }
}
