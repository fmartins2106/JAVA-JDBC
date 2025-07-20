package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota31 {
    private List<Veiculo31> veiculo31s;

    public Frota31(){
        this.veiculo31s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo31.validacaoPlaca(placa);
                Veiculo31.validacaoPlacaDuplicada(placa);
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
                Veiculo31.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para ano.");
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
                Veiculo31.validacaoCor(cor);
                return Veiculo31.formatoString(cor);
            }catch (IllegalArgumentException e){
                System.out.println("Digite uma cor válida.");
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Veiculo31.validacaoValorMercado(valor);
                return valor;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo31 veiculo31){
        veiculo31s.add(veiculo31);
    }

    public void listarVeiculosCadastrados(){
        if (veiculo31s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo31 veiculo31 : veiculo31s) {
            System.out.println("________________________________________");
            veiculo31.exibirDetalhes();
            System.out.println("________________________________________");
        }
    }

    public Optional<Veiculo31> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo31.validacaoPlaca(placa);
            if (veiculo31s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo31> placaEncontrada = veiculo31s.stream().filter(veiculo31 -> veiculo31.placa.equalsIgnoreCase(placa)).findFirst();
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
        Optional<Veiculo31> veiculo31Optional = pesquisaPorPlaca(scanner);
        if (veiculo31Optional.isPresent()){
            Veiculo31 veiculo31 = veiculo31Optional.get();
            System.out.println("________________________________________");
            veiculo31.exibirDetalhes();
            System.out.println("________________________________________");
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo31> veiculo31Optional = pesquisaPorPlaca(scanner);
        if (veiculo31Optional.isPresent()){
            Veiculo31 veiculo31 = veiculo31Optional.get();
            veiculo31.registrarPagamento();
        }
    }

    public void mostrarHistoricoPagamentoIPVA(Scanner scanner){
        Optional<Veiculo31> veiculo31Optional = pesquisaPorPlaca(scanner);
        if (veiculo31Optional.isPresent()){
            Veiculo31 veiculo31 = veiculo31Optional.get();
            veiculo31.mostrarHistoricoPagamentoIPVA();
        }
    }

    public void excluirDados(Scanner scanner){
        Optional<Veiculo31> veiculo31Optional = pesquisaPorPlaca(scanner);
        if (veiculo31Optional.isPresent()){
            Veiculo31 veiculo31 = veiculo31Optional.get();
            veiculo31s.remove(veiculo31);
            Veiculo31.placasCadastradas.remove(veiculo31.placa);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo31> veiculo31Optional = pesquisaPorPlaca(scanner);
        if (veiculo31Optional.isPresent()){
            Veiculo31 veiculo31 = veiculo31Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo31.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo31.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo31.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo31.setValorMercado(validandoValorMercado(scanner));
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
