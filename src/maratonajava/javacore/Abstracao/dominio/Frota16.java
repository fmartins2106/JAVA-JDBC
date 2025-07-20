package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota16 {
    private List<Veiculo16> veiculo16s;

    public Frota16(){
        this.veiculo16s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo16.validacaoPlaca(placa);
                Veiculo16.validandoPlacasDuplicadas(placa);
                return placa;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo16.validacaoAnoDeFabricacao(anoFabricacao);
                return anoFabricacao;
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
                Veiculo16.validacaoCor(cor);
                return Veiculo16.formatoNome(cor);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorDeMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:");
                double valorDeMercado = Double.parseDouble(scanner.nextLine());
                Veiculo16.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo16 veiculo16){
        veiculo16s.add(veiculo16);
    }

    public void listarVeiculosCadastrados(){
        if (veiculo16s.isEmpty()){
            System.out.println("Lista vazia. Nenhum veiculo foi cadastrado.");
        }else {
            for (Veiculo16 veiculo16 : veiculo16s) {
                System.out.println("____________________________");
                veiculo16.exibirDetalhes();
                System.out.println("____________________________");
            }
        }
    }

    public Optional<Veiculo16> pesquisaPorNumeroPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo16.validacaoPlaca(placa);
            if (veiculo16s == null || veiculo16s.isEmpty()){
                System.out.println("Lista vazia. Nenhum veiculo foi encontrado.");
                return Optional.empty();
            }
            Optional<Veiculo16> placaEncontrada = veiculo16s.stream().filter(veiculo16 -> veiculo16.getPlaca().equalsIgnoreCase(placa)).findFirst();
            if (placaEncontrada.isPresent()){
                return placaEncontrada;
            }
            System.out.println("Placa não encontrada.");
            return Optional.empty();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorPlaca(Scanner scanner){
        Optional<Veiculo16> veiculo16Optional = pesquisaPorNumeroPlaca(scanner);
        if (veiculo16Optional.isPresent()){
            Veiculo16 veiculo16 = veiculo16Optional.get();
            System.out.println("____________________________");
            veiculo16.exibirDetalhes();
            System.out.println("____________________________");
        }
    }
    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo16> veiculo16Optional = pesquisaPorNumeroPlaca(scanner);
        if (veiculo16Optional.isPresent()){
            Veiculo16 veiculo16 = veiculo16Optional.get();
            veiculo16.setPlaca(validandoPlaca(scanner));
            veiculo16.setAnoFabricacao(validandoAnoFabricacao(scanner));
            veiculo16.setCor(validandoCor(scanner));
            veiculo16.setValorDeMercado(validandoValorDeMercado(scanner));
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo16> veiculo16Optional = pesquisaPorNumeroPlaca(scanner);
        if (veiculo16Optional.isPresent()){
            Veiculo16 veiculo16 = veiculo16Optional.get();
            System.out.println("____________________________");
            veiculo16.registrarPagamento();
            System.out.println("____________________________");
        }
    }

    public void historicoPagamentoIPVA(Scanner scanner){
        Optional<Veiculo16> veiculo16Optional = pesquisaPorNumeroPlaca(scanner);
        if (veiculo16Optional.isPresent()){
            Veiculo16 veiculo16 = veiculo16Optional.get();
            System.out.println("____________________________");
            veiculo16.exibirHistoricoPagamento();
            System.out.println("____________________________");
        }
    }

    public void excluirDados(Scanner scanner){
        Optional<Veiculo16> veiculo16Optional = pesquisaPorNumeroPlaca(scanner);
        if (veiculo16Optional.isPresent()){
            Veiculo16 veiculo16 = veiculo16Optional.get();
            veiculo16s.remove(veiculo16);
            Veiculo16.placasCadastradas.remove(veiculo16.getPlaca());
            System.out.println("Dados removidos com sucesso.");
        }
    }
}
