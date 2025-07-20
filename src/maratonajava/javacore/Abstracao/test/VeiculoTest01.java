package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota01 frota01 = new Frota01();
        while (true){
            System.out.println("[1] Cadastro veículo.");
            System.out.println("[2] Exibir dados veículos cadastrado.");
            System.out.println("[3] Exibir histórico IPVA.");
            System.out.println("[4] Pesquisa veículo por placa.");
            System.out.println("[5] Excluir veículo.");
            System.out.println("[6] Alterar dados veículo.");
            System.out.println("[7] Registrar pagamento IPVA.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma opção válida:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota01);
                        break;
                    case 2:
                        frota01.listaVeiculosCadastrado();
                        break;
                    case 3:
                        frota01.exibirHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota01.pesquisaPorPlaca(scanner);
                        break;
                    case 5:
                        frota01.excluirDadosVeiculo(scanner);
                        break;
                    case 6:
                        frota01.alterarDadosVeiculos(scanner);
                        break;
                    case 7:
                        frota01.registrarPagamentoIPVA(scanner,frota01);
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
    public static void cadastroVeiculo(Scanner scanner, Frota01 frota01){
        System.out.print("Tipo do veículo(Caminhão, carro, moto):");
        String tipo = scanner.nextLine().trim();
        if (!tipo.equalsIgnoreCase("carro") && !tipo.equalsIgnoreCase("moto") && !tipo.equalsIgnoreCase("caminhão")){
            System.out.println("ERRO: Tipo veículo deve ser carro, moto ou caminhão.");
            return;
        }
        String placa = Frota01.validandoPlaca(scanner);
        int anoFabricacao = Frota01.validandoAnoFabricacao(scanner);
        String cor = Frota01.validandoCor(scanner);
        double valor = Frota01.validandoValorDeMercado(scanner);
        Veiculo01 veiculo01 = null;
        switch (tipo.toLowerCase()){
            case "carro":
                veiculo01 = new Carro01(placa,anoFabricacao,cor,valor);
                break;
            case "moto":
                veiculo01 = new Moto01(placa,anoFabricacao,cor,valor);
                break;
            case "caminhão":
                veiculo01 = new Caminhao01(placa,anoFabricacao,cor,valor);
                break;
            default:
                System.out.println("Tipo de veiculo inválido.");
                return;
        }
        frota01.addVeiculos(veiculo01);
    }
}



