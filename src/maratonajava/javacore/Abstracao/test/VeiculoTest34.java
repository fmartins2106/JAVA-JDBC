package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota34 frota34 = new Frota34();
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Mostrar histórico pagamento.");
                System.out.println("[4] Excluir dados veiculo.");
                System.out.println("[5] Alterar dados veiculo.");
                System.out.println("[6] Pesquisa por placa.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota34);
                        break;
                    case 2:
                        frota34.listarVeiculosCadastrados();
                        break;
                    case 3:
                        frota34.mostrarHistoricoPagamentoIPVA(scanner);
                        break;
                    case 4:
                        frota34.excluirDadosVeiculo(scanner);
                        break;
                    case 5:
                        frota34.alterarDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota34.exibirDadosPesquisa(scanner);
                        break;
                    case 7:
                        frota34.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota34 frota34){
        System.out.print("Digite uma das opções a seguir -> carro, moto, caminhão:");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida: carro, moto ou caminhão.");
            return;
        }
        String placa = Frota34.validandoPlaca(scanner);
        int anoFabricacao = Frota34.validandoAnoFabricacao(scanner);
        String cor = Frota34.validandoCor(scanner);
        double valorMercado = Frota34.validandoValorMercado(scanner);
        Veiculo34 veiculo34 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo34 = new Carro34(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo34 = new Moto34(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo34 = new Caminhao34(placa,anoFabricacao,cor,valorMercado);
        }
        frota34.addVeiculo(veiculo34);
    }
}
