package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota30 {
    private List<Veiculo30> veiculo30s;

    public Frota30(){
        this.veiculo30s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo30.validacaoPlaca(placa);
                Veiculo30.validandoPlacasDuplicadas(placa);
                return placa;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano fabrocação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo30.validacaoAnoFabricacao(anoFabricacao);
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
                Veiculo30.validacaoCor(cor);
                return Veiculo30.formatoString(cor);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo30.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo30 veiculo30){
        veiculo30s.add(veiculo30);
    }

    public void listarVeiculosCadastrados(){
        if (veiculo30s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo30 veiculo30 : veiculo30s) {
            System.out.println("_____________________________________________");
            veiculo30.exibirDetalhes();
            System.out.println("_____________________________________________");
        }
    }


    public Optional<Veiculo30> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo30.validacaoPlaca(placa);
            if (veiculo30s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo30> placaEncontrada = veiculo30s.stream().filter(veiculo30 -> veiculo30.placa.equalsIgnoreCase(placa)).findFirst();
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

    public void exibirDadosVeiculo(Scanner scanner){
        Optional<Veiculo30> veiculo30Optional = pesquisaPorPlaca(scanner);
        if (veiculo30Optional.isPresent()){
            Veiculo30 veiculo30 = veiculo30Optional.get();
            System.out.println("______________________________________");
            veiculo30.exibirDetalhes();
            System.out.println("______________________________________");
        }
    }


    public void registrarPagamento(Scanner scanner){
        Optional<Veiculo30> veiculo30Optional = pesquisaPorPlaca(scanner);
        if (veiculo30Optional.isPresent()){
            Veiculo30 veiculo30 = veiculo30Optional.get();
            veiculo30.registrarPagamentoIPVA();
        }
    }

    public void mostrarHistoricoPagamento(Scanner scanner){
        Optional<Veiculo30> veiculo30Optional = pesquisaPorPlaca(scanner);
        if (veiculo30Optional.isPresent()){
            Veiculo30 veiculo30 = veiculo30Optional.get();
            veiculo30.mostrarHistoricoPagamentoIPVA();
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo30> veiculo30Optional = pesquisaPorPlaca(scanner);
        if (veiculo30Optional.isPresent()){
            Veiculo30 veiculo30 = veiculo30Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo30.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo30.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo30.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo30.setValorMercado(validandoValorMercado(scanner));
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo30> veiculo30Optional = pesquisaPorPlaca(scanner);
        if (veiculo30Optional.isPresent()){
            Veiculo30 veiculo30 = veiculo30Optional.get();
            veiculo30s.remove(veiculo30);
            Veiculo30.placasCadastradas.remove(veiculo30.placa);
            System.out.println("Dados removidos com sucesso.");
        }
    }

}
