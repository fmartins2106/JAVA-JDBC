package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota43 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Veiculo43> veiculo43s;

    public Frota43(){
        this.veiculo43s = new ArrayList<>();
    }

    public static String validandoPlaca(){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo43.validacaoPlaca(placa);
                Veiculo43.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaDuplicada43 | PlacaInvalidaException43 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo43.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um ano válido.");
            }catch (AnoFabricacaoException43 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo43.validacaoCor(cor);
                return Veiculo43.formatoString(cor);
            }catch (CorInvalidaException43 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(){
        while (true){
            try {
                System.out.print("Valor mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo43.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorMercadoException43 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo43 veiculo43){
        veiculo43s.add(veiculo43);
        System.out.println("veiculo cadastrado com sucesso.");
    }

    public void listarVeiculosCadastrados(){
        if (veiculo43s.isEmpty()){
            System.out.println("Erro. Nenhum veiculo cadastrado.");
            return;
        }
        for (Veiculo43 veiculo43 : veiculo43s) {
            System.out.println("_____________________________________________________");
            veiculo43.exibirDetalhes();
            System.out.println("_____________________________________________________");
        }
    }

    public Optional<Veiculo43> pesquisaPorPlaca(){
        if (veiculo43s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
            return Optional.empty();
        }
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        return veiculo43s.stream().filter(veiculo43 ->  veiculo43.placa.equalsIgnoreCase(placa)).findFirst();
    }

    public void exibirPesquisaPorPlaca(){
        Optional<Veiculo43> veiculo43 = pesquisaPorPlaca();
        if (veiculo43.isPresent()){
            veiculo43.get().mostrarHistoricoIPVA();
            return;
        }
        System.out.println("Placa não encontrada.");
    }

    public void alterarDadosVeiculo(){
        Optional<Veiculo43> veiculo43 = pesquisaPorPlaca();
        if (veiculo43.isPresent()){
            try {
                System.out.println("[1]Placa. \n[2]Ano de fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo43.get().setPlaca(validandoPlaca());
                        break;
                    case 2:
                        veiculo43.get().setAnoFabricacao(validandoAnoFabricacao());
                        break;
                    case 3:
                        veiculo43.get().setCor(validandoCor());
                        break;
                    case 4:
                        veiculo43.get().setValorMercado(validandoValorMercado());
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

    public void excluirVeiculo(){
        Optional<Veiculo43> veiculo43 = pesquisaPorPlaca();
        if (veiculo43.isPresent()){
            veiculo43s.remove(veiculo43.get());
            Veiculo43.placasCadastradas.remove(veiculo43.get().placa);
            return;
        }
        System.out.println("Nenhum veiculo encontrado.");
    }

    public void registrarPagamentoIPVA(){
        Optional<Veiculo43> veiculo43 = pesquisaPorPlaca();
        if (veiculo43.isPresent()){
            veiculo43.get().registrarPagamentoIPVA();
            return;
        }
        System.out.println("Placa não encontrada.");
    }

    public void mostrarHistoricoIPVA(){
        Optional<Veiculo43> veiculo43 = pesquisaPorPlaca();
        if (veiculo43.isPresent()){
            veiculo43.get().mostrarHistoricoIPVA();
            return;
        }
        System.out.println("Placa não encontrada.");
    }

}
