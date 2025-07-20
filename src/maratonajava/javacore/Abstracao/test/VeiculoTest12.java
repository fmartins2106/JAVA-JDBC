package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota12 frota12 = new Frota12();
        while (true){
            try {
                System.out.println("[1] Cadastro veiculo.");
                System.out.println("[2] Lista de veiculos cadastrados.");
                System.out.println("[3] Pesquisa por placa.");
                System.out.println("[4] Mostrar histórico pagamento IPVA.");
                System.out.println("[5] Excluir dados.");
                System.out.println("[6] Alterar dados veiculo.");
                System.out.println("[7] Registrar pagamento.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota12);
                        break;
                    case 2:
                        frota12.listarVeiculos();
                        break;
                    case 3:
                        frota12.pesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota12.mostrarHistoricoPagamento(scanner);
                        break;
                    case 5:
                        frota12.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota12.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota12.registrarPagamentoIPVA(scanner);
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

    public static void cadastroVeiculo(Scanner scanner, Frota12 frota12){
        System.out.print("Digite uma das opções: carro, moto ou caminhão.:-->");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas carro, moto ou caminhão.");
            return;
        }
        String placa = Frota12.validandoPlaca(scanner);
        int anoFabricacao = Frota12.validandoAnoFabricacao(scanner);
        String cor = Frota12.validandoCor(scanner);
        double valorDeMercado = Frota12.validandoValorDeMercado(scanner);
        Veiculo12 veiculo12 = null;
        switch (tipoVeiculo.toLowerCase()){
            case "carro":
                veiculo12 = new Carro12(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo12 = new Moto12(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo12 = new Caminhao12(placa,anoFabricacao,cor,valorDeMercado);
                break;
        }
        frota12.addVeiculo(veiculo12);
    }


}
