package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest45 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Frota45 frota45 = new Frota45();
    private static final RelatorioVeiculos45 relatorioVeiculos45 = new RelatorioVeiculos45();
    public static void main(String[] args) {
        while (true){
            exibirMenu();
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                metodoOpcoes(opcao);
            }catch (NumberFormatException e){
                System.out.println("Erro, digite um valor válido.");
            }
        }
    }

    private static void cadastroVeiculo(){
        System.out.print("Digite o tipo do veiculo -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().toLowerCase().trim();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Erro. Opção inválida, tente novamente.");
            return;
        }
        String placa = Frota45.validandoPlaca();
        int anoFabricacao = Frota45.validandoAnoFabricacao();
        String cor = Frota45.validandoCor();
        double valorMercado = Frota45.validandoValorMercado();
        Veiculo45 veiculo45 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo45 = new Carro45(placa,anoFabricacao,cor,valorMercado);
                break;
            case "moto":
                veiculo45 = new Moto45(placa,anoFabricacao,cor,valorMercado);
                break;
            case "caminhão":
                veiculo45 = new Caminhao45(placa,anoFabricacao,cor,valorMercado);
        }
        frota45.addVeiculoSistema(veiculo45);
    }

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroVeiculo();
                break;
            case 2:
                frota45.listarVeiculosCadastrados();
                break;
            case 3:
                frota45.mostrarHistoricoIPVA();
                break;
            case 4:
                frota45.exibirPesquisaPorPlaca();
                break;
            case 5:
                frota45.excluirVeiculoSistema();
                break;
            case 6:
                frota45.alterarDadosVeiculo();
                break;
            case 7:
                frota45.registrarPagamentoIPVA();
                break;
            case 8:
                relatorioVeiculos45.gerarRelatorio(frota45.getVeiculo45s());
                break;
            case 9:
                return;
            default:
                System.out.println("Nenhuma opção válida.");
        }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro veículo.");
        System.out.println("[2] Lista de veículos cadastrados.");
        System.out.println("[3] Mostrar histórico pagamento IPVA.");
        System.out.println("[4] Pesquisa por placa.");
        System.out.println("[5] Excluir veículo.");
        System.out.println("[6] Alterar dados veículo.");
        System.out.println("[7] Registrar pagamento IPVA.");
        System.out.println("[8] Exportar relatório veículos cadastrados.");
        System.out.println("[9] Sair.");
    }

}
