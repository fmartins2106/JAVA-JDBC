package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota28 {
    private List<Veiculo28> veiculo28s;

    public Frota28(){
        this.veiculo28s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo28.validacaoPlaca(placa);
                Veiculo28.validacaoPlacasDuplicadas(placa);
                return placa;
            }catch (IllegalArgumentException e){
                System.out.println("Digite uma placa válida.");
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo28.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um ano válidio.");
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
                Veiculo28.validacaoCor(cor);
                return Veiculo28.formatoString(cor);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorDeMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo28.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo28 veiculo28){
        veiculo28s.add(veiculo28);
    }

    public void listarVeiculosCadastrados(){
        if (veiculo28s.isEmpty()){
            System.out.println("Lista vazia. Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo28 veiculo28 : veiculo28s) {
            System.out.println("_______________________________________________");
            veiculo28.exibirDetalhes();
            System.out.println("_______________________________________________");
        }
    }

    public Optional<Veiculo28> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo28.validacaoPlaca(placa);
            if (veiculo28s.isEmpty()){
                System.out.println("Lista vazia. Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo28> placaEncontrada = veiculo28s.stream().filter(veiculo28 -> veiculo28.placa.equalsIgnoreCase(placa)).findFirst();
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

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo28> veiculo28Optional = pesquisaPorPlaca(scanner);
        if (veiculo28Optional.isPresent()){
            Veiculo28 veiculo28 = veiculo28Optional.get();
            veiculo28.registrarPagamentoIPVA();
        }
    }

    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo28> veiculo28Optional = pesquisaPorPlaca(scanner);
        if (veiculo28Optional.isPresent()){
            Veiculo28 veiculo28 = veiculo28Optional.get();
            veiculo28.mostrarHistoricoPagamentoIPVA();
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo28> veiculo28Optional = pesquisaPorPlaca(scanner);
        if (veiculo28Optional.isPresent()){
            Veiculo28 veiculo28 = veiculo28Optional.get();
            veiculo28s.remove(veiculo28);
            Veiculo28.placasCadastradas.remove(veiculo28.placa);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo28> veiculo28Optional = pesquisaPorPlaca(scanner);
        if (veiculo28Optional.isPresent()){
            Veiculo28 veiculo28 = veiculo28Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado,. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo28.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo28.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo28.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo28.setValorMercado(validandoValorDeMercado(scanner));
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

    public void exibirPesquisaNome(Scanner scanner){
        Optional<Veiculo28> veiculo28Optional = pesquisaPorPlaca(scanner);
        if (veiculo28Optional.isPresent()){
            Veiculo28 veiculo28 = veiculo28Optional.get();
            veiculo28.exibirDetalhes();
        }
    }
}
