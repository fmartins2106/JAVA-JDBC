package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota14 frota14 = new Frota14();
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Histórico pagamento IPVA.");
                System.out.println("[4] Pesquisa dados por placa.");
                System.out.println("[5] Excluir dados veiculo.");
                System.out.println("[6] Alterar dados veiculo.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota14);
                        break;
                    case 2:
                        frota14.listarVeiculos();
                        break;
                    case 3:
                        frota14.historicoPagamentoIPVA(scanner);
                        break;
                    case 4:
                        frota14.exibirPesquisaPOrPlaca(scanner);
                        break;
                    case 5:
                        frota14.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota14.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota14.registrarPagamentoIPVA(scanner);
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

    public static void cadastroVeiculo(Scanner scanner, Frota14 frota14){
        System.out.print("Digite o tipo de veiculo -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhao")){
            System.out.println("Digite apenas carro, moto ou caminhão.");
            return;
        }
        String placa = Frota14.validandoPlaca(scanner);
        int anoFabricacao = Frota14.anoDeFabricacao(scanner);
        String cor = Frota14.validandoCor(scanner);
        double valorDeMercado = Frota14.validandoValorDeMercado(scanner);
        Veiculo14 veiculo14 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo14 = new Carro14(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo14 = new Moto14(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo14 = new Caminhao14(placa,anoFabricacao,cor,valorDeMercado);
                break;
        }
        frota14.addVeiculo(veiculo14);
    }
}
