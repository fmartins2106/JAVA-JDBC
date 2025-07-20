package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota11 frota11 = new Frota11();
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Pesquisa por nome.");
                System.out.println("[4] Histórico pagamento IPVA.");
                System.out.println("[5] Excluir dados veiculo.");
                System.out.println("[6] Alterar dados veiculo.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota11);
                        break;
                    case 2:
                        frota11.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota11.pesquisaDadosVeiculoPorPlaca(scanner);
                        break;
                    case 4:
                        frota11.exibirHistoricoIPVA(scanner);
                        break;
                    case 5:
                        frota11.excluiirDadosVeiculos(scanner);
                        break;
                    case 6:
                        frota11.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota11.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota11 frota11){
        System.out.print("Digite uma das opções: carro, moto ou caminhão:->");
        String tipoVeiculo = scanner.nextLine().trim();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas carro, moto ou caminhão.");
            return;
        }
        String placa = Frota11.validandoPlaca(scanner);
        int anoFabricacao = Frota11.validandoAnoFabricacao(scanner);
        String cor = Frota11.validandoCor(scanner);
        double valorDeMercado = Frota11.validandoValorDeMercado(scanner);
        Veiculo11 veiculo11 = null;
        switch (tipoVeiculo.toLowerCase()){
            case "carro":
                veiculo11 = new Carro11(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo11 = new Moto11(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhao":
                veiculo11 = new Caminhao11(placa,anoFabricacao,cor,valorDeMercado);
        }
        frota11.addVeiculo(veiculo11);
    }
}
