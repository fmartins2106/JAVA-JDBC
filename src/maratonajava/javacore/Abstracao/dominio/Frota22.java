package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota22 {
    private List<Veiculo22> veiculo22s;

    public Frota22(){
        this.veiculo22s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo22.validacaoPlaca(placa);
                Veiculo22.validacaoPlacasDuplicadas(placa);
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
                Veiculo22.validacaoAnoFabricao(anoFabricacao);
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
                Veiculo22.validacaoCor(cor);
                return Veiculo22.formatoString(cor);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine());
                Veiculo22.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo22 veiculo22){
        veiculo22s.add(veiculo22);
    }

    public void listaVeiculosCadastrado(){
        if (veiculo22s.isEmpty()){
            System.out.println("Lista vazia, nenhum veiculo foi cadastrado.");
        }else {
            for (Veiculo22 veiculo22 : veiculo22s) {
                System.out.println("______________________________________");
                veiculo22.exibirDetalhes();
                System.out.println("______________________________________");
            }
        }
    }

    public Optional<Veiculo22> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine();
            Veiculo22.validacaoPlaca(placa);
            if (veiculo22s.isEmpty()){
                System.out.println("Lista vazia. Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo22> placaEncontrada = veiculo22s.stream().filter(veiculo22 -> veiculo22.placa.equalsIgnoreCase(placa)).findFirst();
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

    public void registraPagamento(Scanner scanner){
        Optional<Veiculo22> veiculo22Optional = pesquisaPorPlaca(scanner);
        if (veiculo22Optional.isPresent()){
            Veiculo22 veiculo22 = veiculo22Optional.get();
            veiculo22.registrarPagamentoIPVA();
        }
    }

    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo22> veiculo22Optional = pesquisaPorPlaca(scanner);
        if (veiculo22Optional.isPresent()){
            Veiculo22 veiculo22 = veiculo22Optional.get();
            veiculo22.mostrarHistoricoPagamentoIPVA();
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo22> veiculo22Optional = pesquisaPorPlaca(scanner);
        if (veiculo22Optional.isPresent()){
            Veiculo22 veiculo22 = veiculo22Optional.get();
            veiculo22s.remove(veiculo22);
            Veiculo22.placasCadastradas.remove(veiculo22.placa);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo22> veiculo22Optional = pesquisaPorPlaca(scanner);
        if (veiculo22Optional.isPresent()){
            Veiculo22 veiculo22 = veiculo22Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor: \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        veiculo22.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo22.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo22.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo22.setValorDeMercado(validandoValorMercado(scanner));
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

    public void exibirDadosPesquisaPlaca(Scanner scanner){
        Optional<Veiculo22> veiculo22Optional = pesquisaPorPlaca(scanner);
        if (veiculo22Optional.isPresent()){
            Veiculo22 veiculo22 = veiculo22Optional.get();
            System.out.println("___________________");
            veiculo22.exibirDetalhes();
            System.out.println("___________________");
        }
    }
}
