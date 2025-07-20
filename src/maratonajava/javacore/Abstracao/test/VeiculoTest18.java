package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota18 frota18 = new Frota18();
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
                        cadastroVeiculo(scanner,frota18);
                        break;
                    case 2:
                        frota18.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota18.exibirPesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota18.mostrarHistoricoIPVA(scanner);
                        break;
                    case 5:
                        frota18.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota18.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota18.registraPagamentos(scanner);
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

    public static void cadastroVeiculo(Scanner scanner, Frota18 frota18){
        System.out.print("Digite uma das opções a seguir -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida.");
            return;
        }
        String placa = Frota18.validandoPlaca(scanner);
        int anoFabricacao = Frota18.validandoAnoDeFabricacao(scanner);
        String cor = Frota18.validandoCor(scanner);
        double valorDeMercado = Frota18.validandoValorDeMercado(scanner);
        Veiculo18 veiculo18 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo18 = new Carro18(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo18 = new Moto18(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo18 = new Caminhao18(placa,anoFabricacao,cor,valorDeMercado);
                break;
        }
        frota18.addVeiculo(veiculo18);
        System.out.println("Veiculo cadastrado com sucesso.");
    }
}
