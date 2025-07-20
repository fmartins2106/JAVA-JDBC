package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota29 frota29 = new Frota29();
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Mostrar histórico IPVA.");
                System.out.println("[4] Pesquisa por nome.");
                System.out.println("[5] Excluir dados.");
                System.out.println("[6] Alterar dados veiculo.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroConta(scanner,frota29);
                        break;
                    case 2:
                        frota29.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota29.mostrarHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota29.exibirPesquisaNome(scanner);
                        break;
                    case 5:
                        frota29.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota29.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota29.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>Finalizar programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroConta(Scanner scanner, Frota29 frota29){
        System.out.print("Digite uma das opções: carro, moto ou caminhão ->");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida. Carro, moto ou caminhão.");
            return;
        }
        String placa = Frota29.validandoPlaca(scanner);
        int anoFabricacao = Frota29.validandoAnoFabricacao(scanner);
        String cor = Frota29.validandoCor(scanner);
        double valorMercado = Frota29.validandoValorMercado(scanner);
        Veiculo29 veiculo29 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo29 = new Carro29(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo29 = new Moto29(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo29 = new Caminhao29(placa,anoFabricacao,cor,valorMercado);
                break;
        }
        frota29.addVeiculoSistema(veiculo29);
    }
}
