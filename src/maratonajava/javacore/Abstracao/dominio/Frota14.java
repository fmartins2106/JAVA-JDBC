package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota14 {
    private List<Veiculo14> veiculo14s;

    public Frota14(){
        this.veiculo14s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo14.validacaoPlaca(placa);
                return placa;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int anoDeFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoDeFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo14.validacaoAnoFabricacao(anoDeFabricacao);
                return anoDeFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(Scanner scanner){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo14.validacaoCor(cor);
                return Veiculo14.formatoString(cor);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorDeMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorDeMercado = Double.parseDouble(scanner.nextLine());
                Veiculo14.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void addVeiculo(Veiculo14 veiculo14){
        veiculo14s.add(veiculo14);
    }

    public void listarVeiculos(){
        if (veiculo14s.isEmpty()){
            System.out.println("Lista vazia, nenhum veiculo foi cadastrado.");
        }else {
            for (Veiculo14 veiculo14 : veiculo14s) {
                System.out.println("_________________________________");
                veiculo14.exibirDetalhes();
                System.out.println("_________________________________");
            }
        }
    }

    public Optional<Veiculo14> pesquisaPorPlaca(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite uma placa no formato AAA0000 ou AAA0A00.");
            return Optional.empty();
        }
        if (veiculo14s == null || veiculo14s.isEmpty()){
            System.out.println("Lista vazia. Nenhum veiculo foi cadastrado.");
            return Optional.empty();
        }
        Optional<Veiculo14> placaEncontrada = veiculo14s.stream().filter(veiculo14 -> veiculo14.getPlaca().equalsIgnoreCase(placa)).findFirst();
        if (placaEncontrada.isPresent()){
            return placaEncontrada;
        }
        System.out.println("Placa não encontrada.");
        return Optional.empty();
    }

    public void exibirPesquisaPOrPlaca(Scanner scanner){
        Optional<Veiculo14> veiculo14Optional = pesquisaPorPlaca(scanner);
        if (veiculo14Optional.isPresent()){
            Veiculo14 veiculo14 = veiculo14Optional.get();
            veiculo14.exibirDetalhes();
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo14> veiculo14Optional = pesquisaPorPlaca(scanner);
        if (veiculo14Optional.isPresent()){
            Veiculo14 veiculo14 = veiculo14Optional.get();
            veiculo14s.remove(veiculo14);
            Veiculo14.placasCadastradas.remove(veiculo14.getPlaca());
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo14> veiculo14Optional = pesquisaPorPlaca(scanner);
        if (veiculo14Optional.isPresent()){
            Veiculo14 veiculo14 = veiculo14Optional.get();
            veiculo14.registrarPagamentoIPVA();
        }
    }

    public void historicoPagamentoIPVA(Scanner scanner){
        Optional<Veiculo14> veiculo14Optional = pesquisaPorPlaca(scanner);
        if (veiculo14Optional.isPresent()){
            Veiculo14 veiculo14 = veiculo14Optional.get();
            veiculo14.mostrarHistoricoPagamentoIPVA();
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo14> veiculo14Optional = pesquisaPorPlaca(scanner);
        if (veiculo14Optional.isPresent()){
            Veiculo14 veiculo14 = veiculo14Optional.get();
            veiculo14.setPlaca(validandoPlaca(scanner));
            veiculo14.setAnoFabricacao(anoDeFabricacao(scanner));
            veiculo14.setCor(validandoCor(scanner));
            veiculo14.setValorDeMercado(validandoValorDeMercado(scanner));
        }
    }
}
