package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frota05 frota05 = new Frota05();
        while (true){
            try {
                System.out.println("[1] Cadastro de veículo.");
                System.out.println("[2] Listagem de veículos cadastrados.");
                System.out.println("[3] Exibir histórico IPVA.");
                System.out.println("[4] Pesquisa veículo por placa.");
                System.out.println("[5] Excluir veículo.");
                System.out.println("[6] Alterar dados veículo.");
                System.out.println("[7] Registrar pagamento IPVA.");
                System.out.println("[8] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroVeiculo(scanner,frota05);
                        break;
                    case 2:
                        frota05.listaVeiculosCadastrados();
                        break;
                    case 3:
                        frota05.exibirHistoricoIPVA(scanner);
                        break;
                    case 4:
                        frota05.pesquisaPorPlaca(scanner);
                        break;
                    case 5:
                        frota05.excluirDados(scanner);
                        break;
                    case 6:
                        frota05.alterarDadoVeiculos(scanner);
                        break;
                    case 7:
                        frota05.registrarPagamentoIPVA(scanner);
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

    public static void cadastroVeiculo(Scanner scanner, Frota05 frota05){
        System.out.print("Digite uma das opções(carro, moto, caminhão):");
        String opcao = scanner.nextLine().trim();
        if (!opcao.equalsIgnoreCase("carro") && !opcao.equalsIgnoreCase("moto") && !opcao.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida (carro, moto ou caminhão).");
            return;
        }
        String placa = Frota05.validandoPlaca(scanner);
        int ano = Frota05.validandoAnoFabricacao(scanner);
        String cor = Frota05.validandoCor(scanner);
        double valorDeMercado = Frota05.validandoValorDeMercado(scanner);
        Veiculo05 veiculo05 = null;
        switch (opcao.toLowerCase()){
            case "carro":
                veiculo05 = new Carro05(placa,ano,cor,valorDeMercado);
                break;
            case "moto":
                veiculo05 = new Moto05(placa,ano,cor,valorDeMercado);
                break;
            case "caminhão":
                veiculo05 = new Caminhao05(placa,ano,cor,valorDeMercado);
                break;
        }
        frota05.addVeiculo(veiculo05);
        System.out.println("Veículo cadastrado com sucesso.");
    }


}
