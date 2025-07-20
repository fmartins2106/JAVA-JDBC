package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota29 {
    private List<Veiculo29> veiculo29s;

    public Frota29(){
        this.veiculo29s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo29.validacaoPlaca(placa);
                Veiculo29.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo29.validacaoAnoFabricacao(anoFabricacao);
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
                Veiculo29.validacaoCor(cor);
                return Veiculo29.formatoString(cor);
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
                Veiculo29.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo29 veiculo29){
        veiculo29s.add(veiculo29);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo29s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo29 veiculo29 : veiculo29s) {
            System.out.println("_______________________________________________");
            veiculo29.exibirDetalhes();
            System.out.println("_______________________________________________");
        }
    }

    public Optional<Veiculo29> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo29.validacaoPlaca(placa);
            if (veiculo29s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo29> placaEncontrada = veiculo29s.stream().filter(veiculo29 -> veiculo29.placa.equalsIgnoreCase(placa)).findFirst();
            if (placaEncontrada.isPresent()){
                return placaEncontrada;
            }
            System.out.println("Nenhum placa foi encontrada.");
            return Optional.empty();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirPesquisaNome(Scanner scanner){
        Optional<Veiculo29> veiculo29Optional = pesquisaPorPlaca(scanner);
        if (veiculo29Optional.isPresent()){
            Veiculo29 veiculo29 = veiculo29Optional.get();
            System.out.println("_____________________________________");
            veiculo29.exibirDetalhes();
            System.out.println("_____________________________________");
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo29> veiculo29Optional = pesquisaPorPlaca(scanner);
        if (veiculo29Optional.isPresent()){
            Veiculo29 veiculo29 = veiculo29Optional.get();
            veiculo29s.remove(veiculo29);
            Veiculo29.placasDuplicadas.remove(veiculo29.placa);
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo29> veiculo29Optional = pesquisaPorPlaca(scanner);
        if (veiculo29Optional.isPresent()){
            Veiculo29 veiculo29 = veiculo29Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo29.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo29.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo29.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo29.setValorMercado(validandoValorMercado(scanner));
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
        Optional<Veiculo29> veiculo29Optional = pesquisaPorPlaca(scanner);
        if (veiculo29Optional.isPresent()){
            Veiculo29 veiculo29 = veiculo29Optional.get();
            veiculo29.registrarPagamentoIPVA();
        }
    }

    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo29> veiculo29Optional = pesquisaPorPlaca(scanner);
        if (veiculo29Optional.isPresent()){
            Veiculo29 veiculo29 = veiculo29Optional.get();
            veiculo29.mostrarHistoricoPagamentoIPVA();
        }
    }

}
