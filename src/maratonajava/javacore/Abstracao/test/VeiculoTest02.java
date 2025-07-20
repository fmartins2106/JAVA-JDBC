package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota02 frota02 = new Frota02();
        while (true){
            System.out.println("[1] Cadastro veículo.");
            System.out.println("[2] Lista de veículos.");
            System.out.println("[3] Exibir histórico IPVA.");
            System.out.println("[4] Pesquisa veículo por placa.");
            System.out.println("[5] Excluir veículo.");
            System.out.println("[6] Alterar dados veículos.");
            System.out.println("[7] Registrar pagamento IPVA.");
            System.out.println("[8] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota02);
                        break;
                    case 2:
                        frota02.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota02.exibirHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota02.pesquisaPorPlacas(scanner);
                        break;
                    case 5:
                        frota02.excluirVeiculos(scanner);
                        break;
                    case 6:
                        frota02.alterarDadosDoVeiculo(scanner);
                        break;
                    case 7:
                        frota02.registrarPagamentoIPVA(scanner);
                        break;
                    case 8:
                        System.out.println(">>>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroVeiculo(Scanner scanner, Frota02 frota02){
        System.out.print("Tipo do veículo(Carro, moto, caminhão):");
        String tipo = scanner.nextLine().trim();
        if (!tipo.equalsIgnoreCase("carro") && !tipo.equalsIgnoreCase("moto") && !tipo.equalsIgnoreCase("caminhão")){
            System.out.println("Erro, tipo de veículo deve ser carro, moto, ou caminhão.");
            return;
        }
        String placa = Frota02.validandoPlacas(scanner);
        int anoFabricacao =Frota02.validandoAnoFabricacao(scanner);
        String cor = Frota02.validandoCor(scanner);
        double valorDeMercado = Frota02.validandoValorDeMercador(scanner);
        Veiculo02 veiculo02 = null;
        switch (tipo.toLowerCase()){
            case "carro":
                veiculo02 = new Carro02(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "moto":
                veiculo02 = new Moto2(placa,anoFabricacao,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo02 = new Caminhao2(placa,anoFabricacao,cor,valorDeMercado);
                break;
            default:
                System.out.println("Digite uma opção válida.");
                return;
        }
        frota02.addVeiculo(veiculo02);
    }
}
