package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota28 frota28 = new Frota28();
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Mostrar histórico pagamento IPVA.");
                System.out.println("[4] Excluir dados veiculo.");
                System.out.println("[5] Pesquisa por placa.");
                System.out.println("[6] Alterar dados veiculo. ");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota28);
                        break;
                    case 2:
                        frota28.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota28.mostrarHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota28.excluirDadosVeiculo(scanner);
                        break;
                    case 5:
                        frota28.exibirPesquisaNome(scanner);
                        break;
                    case 6:
                        frota28.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota28.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>>Finalizando o programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota28 frota28){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas uma das opções: carro, moto ou caminhão.");
            return;
        }
        String placa = Frota28.validandoPlaca(scanner);
        int anoFabricacao = Frota28.validandoAnoFabricacao(scanner);
        String cor = Frota28.validandoCor(scanner);
        double valorDeMercado = Frota28.validandoValorDeMercado(scanner);
        Veiculo28 veiculo28 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo28 = new Carro28(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo28 = new Moto28(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo28 = new Caminhao28(placa,anoFabricacao,cor,valorDeMercado);
                break;
        }
        frota28.addVeiculo(veiculo28);
    }

}
