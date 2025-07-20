package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota21 frota21 = new Frota21();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Pesquisa por placa.");
            System.out.println("[4] Histórico IPVA.");
            System.out.println("[5] Excluir dados.");
            System.out.println("[6] Alterar dados.");
            System.out.println("[7] Registro pagamento IPVA.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota21);
                        break;
                    case 2:
                        frota21.listaVeiculos();
                        break;
                    case 3:
                        frota21.exibirDetalhesPesquisaPlaca(scanner);
                        break;
                    case 4:
                        frota21.mostrarHistoricoIPVA(scanner);
                        break;
                    case 5:
                        frota21.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota21.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota21.registrarHistoricoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println("<<<Finalizando programa>>>");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota21 frota21){
        System.out.print("Digite uma das opções a seguir: carro, moto ou caminhão ->");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas uma das opções -> carro, moto ou caminhão.");
            return;
        }
        String placa = Frota21.validandoPlaca(scanner);
        int anoFabricacao = Frota21.validandoAnoFabricacao(scanner);
        String cor = Frota21.validandoCor(scanner);
        double valorMercado = Frota21.validandoValorMercado(scanner);
        Veiculo21 veiculo21 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo21 = new Carro21(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo21 = new Moto21(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo21 = new Caminhao21(placa,anoFabricacao,cor,valorMercado);
                break;
        }
        frota21.addVeiculo(veiculo21);
    }
}
