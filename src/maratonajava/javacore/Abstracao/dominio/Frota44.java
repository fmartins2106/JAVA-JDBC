package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota44 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<Veiculo44> veiculo44s;

    public Frota44() {
        this.veiculo44s = new ArrayList<>();
    }

    public static String validandoPlaca() {
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo44.validacaoPlaca(placa);
                Veiculo44.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaDuplicadaException44 | PlacaInvalidaException44 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao() {
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo44.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }catch (AnoFabricacaoException44 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor() {
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo44.validacaoCor(cor);
                return Veiculo44.formatoString(cor);
            }catch (CorInvalidaException44 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado() {
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Veiculo44.validacaoValorMercado(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorMercadoInvalidoException44 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo44 veiculo44) {
        veiculo44s.add(veiculo44);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public void listarProdutosCadastrados() {
        if (veiculo44s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
            return;
        }
        for (Veiculo44 veiculo44 : veiculo44s) {
            System.out.println("_________________________________________");
            veiculo44.exibirInfo();
            System.out.println("_________________________________________");
        }
    }

    public Optional<Veiculo44> pesquisaPorPlaca() {
        if (veiculo44s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
            return Optional.empty();
        }
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo44.validacaoPlaca(placa);
            Optional<Veiculo44> veiculo44 = veiculo44s.stream().filter(veiculo45 -> veiculo45.placa.equalsIgnoreCase(placa)).findFirst();
            if (veiculo44.isPresent()){
                return veiculo44;
            }
            System.out.println("Nenhum veiculo foi encontrado.");
            return Optional.empty();
        }catch (PlacaInvalidaException44 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorPlaca() {
        pesquisaPorPlaca().ifPresent(Veiculo44::exibirInfo);
    }

    public void excluirVeiculoSistema() {
        pesquisaPorPlaca().ifPresent(veiculo44 -> { veiculo44s.remove(veiculo44);
            System.out.println("Dados removidos com sucesso.");});
    }

    public void alterarDadosVeiculo () {
        Optional<Veiculo44> veiculo44Opt = pesquisaPorPlaca();
        if (veiculo44Opt.isPresent()) {
            Veiculo44 veiculo44 = veiculo44Opt.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano de fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao) {
                    case 1:
                        veiculo44.setPlaca(validandoPlaca());
                        break;
                    case 2:
                        veiculo44.setAnoFabricacao(validandoAnoFabricacao());
                        break;
                    case 3:
                        veiculo44.setCor(validandoCor());
                        break;
                    case 4:
                        veiculo44.setValorMercado(validandoValorMercado());
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Erro. Digite uma opção válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public void mostrarHistoricoIPVA(){
        pesquisaPorPlaca().ifPresent(Veiculo44::mostrarHistoricoIPVA);
    }

    public void registrarPagamentoIPVA() {
        pesquisaPorPlaca().ifPresent(Veiculo44::registrarPagamentoIPVA);
    }
}
