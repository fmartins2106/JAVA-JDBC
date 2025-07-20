package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota07 frota07 = new Frota07();
        while (true){
            try {
                System.out.println("[1] Cadastro de veículo.");
                System.out.println("[2] Lista de veículo cadastrado.");
                System.out.println("[3] Pesquisa por placa.");
                System.out.println("[4] Exibir histórico IPVA.");
                System.out.println("[5] Excluir veículo.");
                System.out.println("[6] Alterar dados veículo.");
                System.out.println("[7] Registra pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota07);
                        break;
                    case 2:
                        frota07.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota07.pesquisaPorPlaca(scanner);
                        break;
                    case 4:
                        frota07.exibirHistoricoIPVA(scanner);
                        break;
                    case 5:
                        frota07.excluirDados(scanner);
                        break;
                    case 6:
                        frota07.alterarDadosVeiculo(scanner);
                        break;
                    case 7:
                        frota07.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>Finalizando sistema...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota07 frota07){
        System.out.print("Digite uma das opções(carro, moto, caminhão):");
        String tipo = scanner.nextLine().trim();
        if (!tipo.equalsIgnoreCase("carro") && !tipo.equalsIgnoreCase("moto") && !tipo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma das opções: carro, moto ou caminhão");
            return;
        }
        String placa = Frota07.validandoPlaca(scanner);
        int anoFabricacao = Frota07.validandoAnoFabricacao(scanner);
        String cor = Frota07.validandoCor(scanner);
        double valorDeMercado = Frota07.validandoValorDeMercado(scanner);
        Veiculo07 veiculo07 = null;
        switch (tipo.toLowerCase()){
            case "carro":
                veiculo07 = new Carro07(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo07 = new Moto07(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo07 = new Caminhao07(placa,anoFabricacao,cor,valorDeMercado);
        }
        frota07.addVeiculo(veiculo07);
    }
}
