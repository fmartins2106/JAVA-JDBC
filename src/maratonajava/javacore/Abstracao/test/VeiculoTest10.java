package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota10 frota10 = new Frota10();
        while (true){
            System.out.println("[1] Cadastro veiculo.");
            System.out.println("[2] Lista de veiculos cadastrados.");
            System.out.println("[3] Pesquisa por placa.");
            System.out.println("[3] Histórico pagamento IPVA.");
            System.out.println("[4] Pesquisa por placa.");
            System.out.println("[5] Excluir dados veiculo.");
            System.out.println("[6] Alterar dados veiculo");
            System.out.println("[7] Registrar pagamento IPVA.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota10);
                        break;
                    case 2:
                        frota10.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota10.exibirHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota10.pesquisaPorPlaca(scanner);
                        break;
                    case 5:
                        frota10.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota10.alterarDados(scanner);
                        break;
                    case 7:
                        frota10.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota10 frota10){
        System.out.print("Digite o tipo de veiculo (carro, moto ou caminhão.):");
        String tipoVeiculo = scanner.nextLine().trim();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite apenas carro, moto ou caminhão.");
            return;
        }
        String placa = Frota10.validandoFormatoPlaca(scanner);
        int anoFabricacao = Frota10.validandoAnoFabricacao(scanner);
        String cor = Frota10.validandoCor(scanner);
        double valorDeMercado = Frota10.validandoValorDeMercado(scanner);
        Veiculo10 veiculo10 = null;
        switch (tipoVeiculo.toLowerCase()){
            case "carro":
                veiculo10 = new Carro10(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo10 = new Moto10(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo10 = new Caminhao10(placa,anoFabricacao,cor,valorDeMercado);
                break;
        }
        frota10.addVeiculo(veiculo10);
    }
}
