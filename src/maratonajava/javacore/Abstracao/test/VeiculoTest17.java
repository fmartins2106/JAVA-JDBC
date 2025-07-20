package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota17 frota17 = new Frota17();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Pesquisa por placa.");
            System.out.println("[4] histórico pagamento IPVA.");
            System.out.println("[5] Excluir dados veiculo.");
            System.out.println("[6] Alterar dados veiculo.");
            System.out.println("[7] Registro pagamento IPVA.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota17);
                        break;
                    case 2:
                        frota17.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota17.exibirPesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota17.historicoPagamentoIPVA(scanner);
                        break;
                    case 5:
                        frota17.excluirCadastroVeiculo(scanner);
                        break;
                    case 6:
                        frota17.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota17.registroPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota17 frota17){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas uma das opções -> carro, moto ou caminhão.");
            return;
        }
        String placa = Frota17.validandoPlaca(scanner);
        int anoFabricacao = Frota17.validandoAnoFabricacao(scanner);
        String cor = Frota17.validandoCor(scanner);
        double valorDeMercado = Frota17.validandoValorDeMercado(scanner);
        Veiculo17 veiculo17 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo17 = new Carro17(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo17 = new Moto17(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo17 = new Caminhao17(placa,anoFabricacao,cor,valorDeMercado);
                break;
        }
        frota17.addVeiculo(veiculo17);
        System.out.println("Veiculo cadastro com sucesso.");
    }
}
