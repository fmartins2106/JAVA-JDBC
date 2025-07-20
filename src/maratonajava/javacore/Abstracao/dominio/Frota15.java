package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota15{
    private List<Veiculo15> veiculo15s;

    public Frota15(){
        this.veiculo15s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine();
                Veiculo15.validacaoPlaca(placa);
                Veiculo15.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoDeFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoDeFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo15.validacaoAnoFabricacao(anoDeFabricacao);
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
                Veiculo15.validacaoCor(cor);
                return Veiculo15.formatoNome(cor);
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
                Veiculo15.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo15 veiculo15){
        veiculo15s.add(veiculo15);
    }

    public void listarVeiculosCadastrado(){
        if (veiculo15s.isEmpty()){
            System.out.println("Lista vazia. Nenhum veiculo cadastrado.");
        }else {
            for (Veiculo15 veiculo15 : veiculo15s) {
                System.out.println("___________________________________");
                veiculo15.exibirDetalhes();
                System.out.println("___________________________________");
            }
        }
    }

    public Optional<Veiculo15> pesquisaPlacaVeiculo(Scanner scanner){
        try {
            System.out.print("Placa");
            String placa = scanner.nextLine().trim();
            Veiculo15.validacaoPlaca(placa);
            if (veiculo15s == null || veiculo15s.isEmpty()){
                System.out.println("Lista vazia. Nenhum veiculo cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo15> veiculo15 = veiculo15s.stream().filter(veiculo16 -> veiculo16.getPlaca().equalsIgnoreCase(placa)).findFirst();
            if (!veiculo15.isPresent()){
                System.out.println("Placa não encontrada.");
                return Optional.empty();
            }
            return veiculo15;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorPlaca(Scanner scanner){
        Optional<Veiculo15> veiculo15Optional = pesquisaPlacaVeiculo(scanner);
        if (veiculo15Optional.isPresent()){
            Veiculo15 veiculo15 = veiculo15Optional.get();
            System.out.println("_________________________");
            veiculo15.exibirDetalhes();
            System.out.println("_________________________");
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo15> veiculo15Optional = pesquisaPlacaVeiculo(scanner);
        if (veiculo15Optional.isPresent()){
            Veiculo15 veiculo15 = veiculo15Optional.get();
            veiculo15s.remove(veiculo15);
            Veiculo15.placasCadastradas.remove(veiculo15.getPlaca());
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo15> veiculo15Optional = pesquisaPlacaVeiculo(scanner);
        if (veiculo15Optional.isPresent()){
            Veiculo15 veiculo15 = veiculo15Optional.get();
            veiculo15.setPlaca(validandoPlaca(scanner));
            veiculo15.setAnoFabricacao(validandoAnoDeFabricacao(scanner));
            veiculo15.setCor(validandoCor(scanner));
            veiculo15.setValorDeMercado(validandoValorDeMercado(scanner));
        }
    }

    public void validandoExibirHistoricoPagamentoIPVA(Scanner scanner){
        Optional<Veiculo15> veiculo15Optional = pesquisaPlacaVeiculo(scanner);
        if (veiculo15Optional.isPresent()){
            Veiculo15 veiculo15 = veiculo15Optional.get();
            veiculo15.mostrarHistoricoPagamentoIPVA();
        }
    }

    public void validandoRegistroPagamentoIPVA(Scanner scanner){
        Optional<Veiculo15> veiculo15Optional = pesquisaPlacaVeiculo(scanner);
        if (veiculo15Optional.isPresent()){
            Veiculo15 veiculo15 = veiculo15Optional.get();
            veiculo15.registrarPagamentoIPVA();
        }
    }

}
