package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota32 {
    private List<Veiculo32> veiculo32s;

    public Frota32(){
        this.veiculo32s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo32.validacaoPlaca(placa);
                Veiculo32.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaInvalidaException32 | PlacaDuplicadaException32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo32.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (AnoFabricacaoException32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(Scanner scanner){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo32.validacaoCor(cor);
                return Veiculo32.formatoStrint(cor);
            }catch (CorInvalidaException32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo32.validacaoValorDeMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (ValorMercadoException32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo32 veiculo32){
        veiculo32s.add(veiculo32);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public void listarVeiculosCadastrados(){
        if (veiculo32s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo32 veiculo32 : veiculo32s) {
            System.out.println("______________________________");
            veiculo32.exibirDetalhes();
            System.out.println("______________________________");
        }
    }

    public Optional<Veiculo32> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo32.validacaoPlaca(placa);
            if (veiculo32s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo32> placaEncontrada = veiculo32s.stream().filter(veiculo32 -> veiculo32.placa.equalsIgnoreCase(placa)).findFirst();
            if (placaEncontrada.isPresent()){
                return placaEncontrada;
            }
            System.out.println("Placa não encontrada.");
            return Optional.empty();
        }catch (PlacaInvalidaException32 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorPlaca(Scanner scanner){
        Optional<Veiculo32> veiculo32Optional = pesquisaPorPlaca(scanner);
        if (veiculo32Optional.isPresent()){
            Veiculo32 veiculo32 = veiculo32Optional.get();
            System.out.println("_____________________________");
            veiculo32.exibirDetalhes();
            System.out.println("_____________________________");
        }
    }

    public void excluirDadoVeiculo(Scanner scanner){
        Optional<Veiculo32> veiculo32Optional = pesquisaPorPlaca(scanner);
        if (veiculo32Optional.isPresent()){
            Veiculo32 veiculo32 = veiculo32Optional.get();
            veiculo32s.remove(veiculo32);
            Veiculo32.placasCadastras.remove(veiculo32.placa);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo32> veiculo32Optional = pesquisaPorPlaca(scanner);
        if (veiculo32Optional.isPresent()){
            Veiculo32 veiculo32 = veiculo32Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opccao = Integer.parseInt(scanner.nextLine().trim());
                switch (opccao){
                    case 1:
                        veiculo32.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo32.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo32.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo32.setValorMercado(validandoValorMercado(scanner));
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

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo32> veiculo32Optional = pesquisaPorPlaca(scanner);
        if (veiculo32Optional.isPresent()){
            Veiculo32 veiculo32 = veiculo32Optional.get();
            veiculo32.registarPagamentoIPVA();
        }
    }

    public void mostrarHistoricoPagamentoIPVA(Scanner scanner){
        Optional<Veiculo32> veiculo32Optional = pesquisaPorPlaca(scanner);
        if (veiculo32Optional.isPresent()){
            Veiculo32 veiculo32 = veiculo32Optional.get();
            veiculo32.mostrarHistoricoIPVA();
        }
    }
}
