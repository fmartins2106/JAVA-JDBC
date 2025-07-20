package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota16 frota16 = new Frota16();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Pesquisa por placa.");
            System.out.println("[4] Excluir dados veiculo.");
            System.out.println("[5] Alterar dados veiculo.");
            System.out.println("[6] Histórico pagamento IPVA.");
            System.out.println("[7] Registrar pagamento IPVA.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota16);
                        break;
                    case 2:
                        frota16.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota16.exibirPesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota16.excluirDados(scanner);
                        break;
                    case 5:
                        frota16.alterarDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota16.historicoPagamentoIPVA(scanner);
                        break;
                    case 7:
                        frota16.registrarPagamentoIPVA(scanner);
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

    public static void cadastroVeiculo(Scanner scanner, Frota16 frota16){
        System.out.print("Digite uma das opções a seguir: carro, moto ou caminhão -> ");
        String tipoVeiculo = scanner.nextLine().trim();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma das opções -> carro, moto ou caminhão.");
            return;
        }
        String placa = Frota16.validandoPlaca(scanner);
        int anoFabricacao = Frota16.validandoAnoFabricacao(scanner);
        String cor = Frota16.validandoCor(scanner);
        double valorDeMercado = Frota16.validandoValorDeMercado(scanner);
        Veiculo16 veiculo16 = null;
        switch (tipoVeiculo.toLowerCase()){
            case "carro":
                veiculo16 = new Carro16(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo16 = new Moto16(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo16 = new Caminhao16(placa,anoFabricacao,cor,valorDeMercado);
                break;
        }
        frota16.addVeiculo(veiculo16);
    }
}
