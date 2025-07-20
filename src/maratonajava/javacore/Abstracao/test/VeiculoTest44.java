package academy.devdojo.maratonajava.javacore.Abstracao.test;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.*;

import java.util.Scanner;

public class VeiculoTest44 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Frota44 frota44 = new Frota44();

    public static void main(String[] args) {
        int opcao = 0;
        do {
            exibirMenu();
            opcao = capturarOpcao();
            metodoOpcoes(opcao);
        }while (opcao != 8);
        System.out.println(">>>Finalizando sistema.");
    }

    private static int capturarOpcao(){
       while (true){
           try {
               System.out.print("Digite uma das opções acima:");
               return Integer.parseInt(scanner.nextLine().trim());
           }catch (NumberFormatException e){
               System.out.println("Erro. Digite uma opção válida.");
           }
       }
    }

    private static void exibirMenu(){
        System.out.println("[1] Cadastro veiculo.");
        System.out.println("[2] Lista de veiculos cadastrados.");
        System.out.println("[3] Mostrar histórico pagamento IPVA.");
        System.out.println("[4] Excluir dados veiculo.");
        System.out.println("[5] Alterar dados veiculo.");
        System.out.println("[6] Registrar pagamento IPVA.");
        System.out.println("[7] Pesquisa por placa.");
        System.out.println("[8] Sair.");
    }

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroVeiculo();
                break;
            case 2:
                frota44.listarProdutosCadastrados();
                break;
            case 3:
                frota44.mostrarHistoricoIPVA();
                break;
            case 4:
                frota44.excluirVeiculoSistema();
                break;
            case 5:
                frota44.alterarDadosVeiculo();
                break;
            case 6:
                frota44.registrarPagamentoIPVA();
                break;
            case 7:
                frota44.exibirPesquisaPorPlaca();
                break;
            case 8:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");

        }
    }

    private static void cadastroVeiculo() {
        System.out.print("Digite o tipo do veiculo -> carro, moto ou caminhão:");
        String tipoVeiculo = scanner.nextLine().toLowerCase();
        if (!tipoVeiculo.equalsIgnoreCase("carro") && !tipoVeiculo.equalsIgnoreCase("moto") && !tipoVeiculo.equalsIgnoreCase("caminhão")){
            System.out.println("Digite uma opção válida: carro, moto ou caminhão. Tente novamente.");
            return;
        }
        String placa = Frota44.validandoPlaca();
        int anoFabricacao = Frota44.validandoAnoFabricacao();
        String cor = Frota44.validandoCor();
        double valor = Frota44.validandoValorMercado();
        Veiculo44 veiculo44 = null;
        switch (tipoVeiculo){
            case "carro":
                veiculo44 = new Carro44(placa,anoFabricacao,cor,valor);
                break;
            case "moto":
                veiculo44 = new Moto44(placa,anoFabricacao,cor,valor);
                break;
            case "caminhão":
                veiculo44 = new Caminhao44(placa,anoFabricacao,cor,valor);
        }
        frota44.addVeiculoSistema(veiculo44);
    }

}
