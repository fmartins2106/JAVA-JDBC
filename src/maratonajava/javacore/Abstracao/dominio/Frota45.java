package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota45 {
    private static final Scanner scanner = new Scanner(System.in);

    private List<Veiculo45> veiculo45s;

    public Frota45(){
        this.veiculo45s = new ArrayList<>();
    }

    public static String validandoPlaca(){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo45.validacaoPlaca(placa);
                Veiculo45.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaDuplicadaException45 | PlacaInvalidaException45 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo45.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um ano válido.");
            }catch (AnoFabricacaoException45 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo45.validacaoCor(cor);
                return Veiculo45.formatoString(cor);
            }catch (CorInvalidaException45 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo45.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorMercadoriaException45 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo45 veiculo45){
        veiculo45s.add(veiculo45);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public void listarVeiculosCadastrados(){
        if (veiculo45s.isEmpty()){
            System.out.println("Erro. Nenhum veiculo cadastrado.");
            return;
        }
        for (Veiculo45 veiculo45 : veiculo45s) {
            System.out.println("__________________________________________");
            veiculo45.exibirInfo();
            System.out.println("__________________________________________");
        }
    }

    public Optional<Veiculo45> pesquisaPorPlaca(){
        if (veiculo45s.isEmpty()){
            System.out.println("Nenhum veículo cadastrado.");
            return Optional.empty();
        }
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo45.validacaoPlaca(placa);
            Optional<Veiculo45> veiculo45 = veiculo45s.stream().filter(veiculo -> veiculo.getPlaca().equalsIgnoreCase(placa)).findFirst();
            if (veiculo45.isPresent()){
                return veiculo45;
            }
            System.out.println("Placa não encontrada.");
            return Optional.empty();
        }catch (PlacaInvalidaException45 e){
            System.out.println("Placa inválida. Tente novamente.");
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorPlaca(){
        pesquisaPorPlaca().ifPresent(Veiculo45::exibirInfo);
    }

    public void excluirVeiculoSistema(){
        pesquisaPorPlaca().ifPresent(veiculo45 -> veiculo45s.remove(veiculo45));
    }

    public void alterarDadosVeiculo(){
        Optional<Veiculo45> veiculo45Optional = pesquisaPorPlaca();
        if (veiculo45Optional.isPresent()){
            try {
                System.out.println("[1]Placa. \n[2]Ano de fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo45Optional.get().setPlaca(validandoPlaca());
                        break;
                    case 2:
                        veiculo45Optional.get().setAnoFabricacao(validandoAnoFabricacao());
                        break;
                    case 3:
                        veiculo45Optional.get().setCor(validandoCor());
                        break;
                    case 4:
                        veiculo45Optional.get().setValorMercado(validandoValorMercado());
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Erro. Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public void mostrarHistoricoIPVA(){
        pesquisaPorPlaca().ifPresent(Veiculo45::mostrarHistoricoIPVA);
    }

    public void registrarPagamentoIPVA(){
        pesquisaPorPlaca().ifPresent(Veiculo45::registrarPagamentoIPVA);
    }

    public List<Veiculo45> getVeiculo45s() {
        return veiculo45s;
    }
}
