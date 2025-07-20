package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota27 {
    private List<Veiculo27> veiculo27s;

    public Frota27(){
        this.veiculo27s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo27.validacaoPlaca(placa);
                Veiculo27.validacaoPlacaDuplicada(placa);
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
                Veiculo27.validacaoAnoFabricacao(anoFabricacao);
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
                Veiculo27.validacaoCor(cor);
                return Veiculo27.formatoString(cor);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo27.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo27 veiculo27){
        veiculo27s.add(veiculo27);
    }

    public void listarVeiculos(){
        if (veiculo27s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo27 veiculo27 : veiculo27s) {
            System.out.println("____________________________");
            veiculo27.exibirDetalhes();
            System.out.println("____________________________");
        }
    }

    public Optional<Veiculo27> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo27.validacaoPlaca(placa);
            if (veiculo27s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo27> placaEncontrada = veiculo27s.stream().filter(veiculo27 -> veiculo27.placa.equalsIgnoreCase(placa)).findFirst();
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
        Optional<Veiculo27> veiculo27Optional = pesquisaPorPlaca(scanner);
        if (veiculo27Optional.isPresent()){
            Veiculo27 veiculo27 = veiculo27Optional.get();
            System.out.println("__________________________________");
            veiculo27.exibirDetalhes();
            System.out.println("__________________________________");
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo27> veiculo27Optional = pesquisaPorPlaca(scanner);
        if (veiculo27Optional.isPresent()){
            Veiculo27 veiculo27 = veiculo27Optional.get();
            veiculo27.registrarPagamentoIPVA();
        }
    }

    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo27> veiculo27Optional = pesquisaPorPlaca(scanner);
        if (veiculo27Optional.isPresent()){
            Veiculo27 veiculo27 = veiculo27Optional.get();
            veiculo27.mostrarHistoricoPagamentoIPVA();
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo27> veiculo27Optional = pesquisaPorPlaca(scanner);
        if (veiculo27Optional.isPresent()){
            Veiculo27 veiculo27 = veiculo27Optional.get();
            veiculo27s.remove(veiculo27);
            Veiculo27.placasCadastradas.remove(veiculo27.placa);
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo27> veiculo27Optional = pesquisaPorPlaca(scanner);
        if (veiculo27Optional.isPresent()){
            Veiculo27 veiculo27 = veiculo27Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo27.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo27.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo27.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo27.setValorMercado(validandoValorMercado(scanner));
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
