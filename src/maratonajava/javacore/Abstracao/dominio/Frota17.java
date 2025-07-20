package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota17 {
    private List<Veiculo17> veiculo17s;

    public Frota17(){
        this.veiculo17s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo17.validacaoPlaca(placa);
                Veiculo17.validacaoPlacasCadastradas(placa);
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
                int anoDeFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo17.validacaoAnoDeFabricacao(anoDeFabricacao);
                return anoDeFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um ano válido.");
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
                Veiculo17.validacaoCor(cor);
                return Veiculo17.formatoNome(cor);
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
                Veiculo17.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo17 veiculo17){
        veiculo17s.add(veiculo17);
    }

    public void listarVeiculosCadastrados(){
        if (veiculo17s.isEmpty()){
            System.out.println("Lista vazia. Nenhum veiculo cadastrado até o momento.");
        }else {
            for (Veiculo17 veiculo17 : veiculo17s) {
                System.out.println("________________________________");
                veiculo17.exibirDetalhes();
                System.out.println("________________________________");
            }
        }
    }

    public Optional<Veiculo17> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo17.validacaoPlaca(placa);
            if (veiculo17s ==  null || veiculo17s.isEmpty()){
                System.out.println("Nenhum veiculo cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo17> placaEncontrada = veiculo17s.stream().filter(veiculo17 -> veiculo17.getPlaca().equalsIgnoreCase(placa)).findFirst();
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

    public void registroPagamentoIPVA(Scanner scanner){
        Optional<Veiculo17> veiculo17Optional = pesquisaPorPlaca(scanner);
        if (veiculo17Optional.isPresent()){
            Veiculo17 veiculo17 = veiculo17Optional.get();
            veiculo17.registrarPagamentoIPVA();
        }
    }

    public void historicoPagamentoIPVA(Scanner scanner){
        Optional<Veiculo17> veiculo17Optional = pesquisaPorPlaca(scanner);
        if (veiculo17Optional.isPresent()){
            Veiculo17 veiculo17 = veiculo17Optional.get();
            veiculo17.historicoPagamentoIPVA();
        }
    }

    public void exibirPesquisaPorPlaca(Scanner scanner){
        Optional<Veiculo17> veiculo17Optional = pesquisaPorPlaca(scanner);
        if (veiculo17Optional.isPresent()){
            Veiculo17 veiculo17 = veiculo17Optional.get();
            System.out.println("__________________________");
            veiculo17.exibirDetalhes();
            System.out.println("__________________________");
        }
    }

    public void excluirCadastroVeiculo(Scanner scanner){
        Optional<Veiculo17> veiculo17Optional = pesquisaPorPlaca(scanner);
        if (veiculo17Optional.isPresent()){
            Veiculo17 veiculo17 = veiculo17Optional.get();
            veiculo17s.remove(veiculo17);
            Veiculo17.placasCadastradas.remove(veiculo17.getPlaca());
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo17> veiculo17Optional = pesquisaPorPlaca(scanner);
        if (veiculo17Optional.isPresent()){
            Veiculo17 veiculo17 = veiculo17Optional.get();
            try {
                System.out.print("O que desejas alterar?:");
                System.out.println("[1]Placa. \n[2]Ano de fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Cancelar.");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        veiculo17.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo17.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo17.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo17.setValorDeMercado(validandoValorDeMercado(scanner));
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");

                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }
}
