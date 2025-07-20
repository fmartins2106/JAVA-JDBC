package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota26 {
    private List<Veiculo26> veiculo26s;

    public Frota26(){
        this.veiculo26s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo26.validacaoPlaca(placa);
                Veiculo26.validacaoPlacaDuplicada(placa);
                return placa.toUpperCase();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo26.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
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
                Veiculo26.validacaoCor(cor);
                return Veiculo26.formatoString(cor);
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
                Veiculo26.validacaoValorDeMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo26 veiculo26){
        veiculo26s.add(veiculo26);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo26s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo26 veiculo26 : veiculo26s) {
            System.out.println("__________________________");
            veiculo26.exibirDetalhes();
            System.out.println("__________________________");
        }
    }

    public Optional<Veiculo26> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo26.validacaoPlaca(placa);
            if (veiculo26s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo26> placaEncontrada = veiculo26s.stream().filter(veiculo26 -> veiculo26.placa.equalsIgnoreCase(placa)).findFirst();
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

    public void exibirPesquisaPlaca(Scanner scanner){
        Optional<Veiculo26> veiculo26Optional = pesquisaPorPlaca(scanner);
        if (veiculo26Optional.isPresent()){
            Veiculo26 veiculo26 = veiculo26Optional.get();
            System.out.println("______________________________");
            veiculo26.exibirDetalhes();
            System.out.println("______________________________");
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo26> veiculo26Optional = pesquisaPorPlaca(scanner);
        if (veiculo26Optional.isPresent()){
            Veiculo26 veiculo26 = veiculo26Optional.get();
            veiculo26.registrarPagamentoIPVA();
        }
    }

    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo26> veiculo26Optional = pesquisaPorPlaca(scanner);
        if (veiculo26Optional.isPresent()){
            Veiculo26 veiculo26 = veiculo26Optional.get();
            veiculo26.mostrarHistoricoPagamentoIPVA();
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo26> veiculo26Optional = pesquisaPorPlaca(scanner);
        if (veiculo26Optional.isPresent()){
            Veiculo26 veiculo26 = veiculo26Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        veiculo26.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo26.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo26.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo26.setValorMercado(validandoValorMercado(scanner));
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

    public void excluirDados(Scanner scanner){
        Optional<Veiculo26> veiculo26Optional = pesquisaPorPlaca(scanner);
        if (veiculo26Optional.isPresent()){
            Veiculo26 veiculo26 = veiculo26Optional.get();
            veiculo26s.remove(veiculo26);
            Veiculo26.placasCadastradas.remove(veiculo26.placa);
            System.out.println("Dados removidos com sucesso.");
        }
    }
}
