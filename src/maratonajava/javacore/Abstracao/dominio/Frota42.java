package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota42 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Veiculo42> veiculo42s;

    public Frota42(){
        this.veiculo42s = new ArrayList<>();
    }

    public static String validandoPlaca(){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo42.validacaoPlaca(placa);
                Veiculo42.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaInvalidaException42 | PlacaDuplicadaException42 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo42.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (AnoFabricacaoException42 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo42.validacaoCor(cor);
                return Veiculo42.formatoString(cor);
            }catch (CorInvalidaException42 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo42.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido.");
            }catch (ValorMercadoInvalidoException42 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo42 veiculo42){
        veiculo42s.add(veiculo42);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public void listarVeiculosCadastrados(){
        if (veiculo42s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo42 veiculo42 : veiculo42s) {
            System.out.println("________________________________________");
            veiculo42.exibirInfo();
            System.out.println("________________________________________");
        }
    }

    public Optional<Veiculo42> pesquisaPorPlaca(){
        if (veiculo42s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
            return Optional.empty();
        }
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo42.validacaoPlaca(placa);
            return veiculo42s.stream().filter(veiculo42 -> veiculo42.placa.equalsIgnoreCase(placa)).findFirst();
        }catch (PlacaInvalidaException42 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void excluirVeiculo(){
        Optional<Veiculo42> veiculo42 = pesquisaPorPlaca();
        if (veiculo42.isPresent()){
            veiculo42s.remove(veiculo42.get());
            System.out.println("Veiculo removido com sucesso.");
            return;
        }
        System.out.println("Nenhum veiculo foi encontrado.");
    }

    public void alterarDadosVeiculo(){
        Optional<Veiculo42> veiculo42 = pesquisaPorPlaca();
        if (veiculo42.isPresent()){
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo42.get().setPlaca(validandoPlaca());
                        break;
                    case 2:
                        veiculo42.get().setAnoFabricacao(validandoAnoFabricacao());
                        break;
                    case 3:
                        veiculo42.get().setCor(validandoCor());
                        break;
                    case 4:
                        veiculo42.get().setValorMercado(validandoValorMercado());
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
        Optional<Veiculo42> veiculo42 = pesquisaPorPlaca();
        if (veiculo42.isPresent()){
            veiculo42.get().mostrarHistoricoPagamentoIPVA();
            return;
        }
        System.out.println("Placa não encontrada.");
    }

    public void registrarPagamentoIPVA(){
        Optional<Veiculo42> veiculo42 = pesquisaPorPlaca();
        if (veiculo42.isPresent()){
            veiculo42.get().registrarPagamentoIPVA();
            return;
        }
        System.out.println("Placa não encontrada.");
    }

    public void exibirPesquisaPorPlaca(){
        Optional<Veiculo42> veiculo42 = pesquisaPorPlaca();
        if (veiculo42.isPresent()){
            veiculo42.get().exibirInfo();
            return;
        }
        System.out.println("Placa não encontrada.");
    }

}
