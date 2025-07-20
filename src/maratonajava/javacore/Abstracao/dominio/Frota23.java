package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota23 {
    private List<Veiculo23> veiculo23s;

    public Frota23(){
        this.veiculo23s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo23.validacaoPlaca(placa);
                Veiculo23.validacaoPlacasDuplicadas(placa);
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
                int anoFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo23.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para ano de fabricação.");
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
                Veiculo23.validacaoCor(cor);
                return Veiculo23.formatoString(cor);
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
                Veiculo23.validacaoValorDeMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo23 veiculo23){
        veiculo23s.add(veiculo23);
    }

    public void listarVeiculoCadastrado(){
        if (veiculo23s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
        }else {
            for (Veiculo23 veiculo23 : veiculo23s) {
                System.out.println("________________________");
                veiculo23.exibirDetalhes();
                System.out.println("________________________");
            }
        }
    }

    public Optional<Veiculo23> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo23.validacaoPlaca(placa);
            if (veiculo23s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo23> placaEncontrada = veiculo23s.stream().filter(veiculo23 -> veiculo23.placa.equalsIgnoreCase(placa)).findFirst();
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
        Optional<Veiculo23> veiculo23Optional = pesquisaPorPlaca(scanner);
        if (veiculo23Optional.isPresent()){
            Veiculo23 veiculo23 = veiculo23Optional.get();
            veiculo23.registrarPagamentoIPVA();
        }
    }

    public void historicoPagamentoIPVA(Scanner scanner){
        Optional<Veiculo23> veiculo23Optional = pesquisaPorPlaca(scanner);
        if (veiculo23Optional.isPresent()){
            Veiculo23 veiculo23 = veiculo23Optional.get();
            veiculo23.mostrarHistoricoIPVA();
        }
    }

    public void exibirPesquisaPlaca(Scanner scanner){
        Optional<Veiculo23> veiculo23Optional = pesquisaPorPlaca(scanner);
        if (veiculo23Optional.isPresent()){
            Veiculo23 veiculo23 = veiculo23Optional.get();
            System.out.println("__________________________");
            veiculo23.exibirDetalhes();
            System.out.println("__________________________");
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo23> veiculo23Optional = pesquisaPorPlaca(scanner);
        if (veiculo23Optional.isPresent()){
            Veiculo23 veiculo23 = veiculo23Optional.get();
            veiculo23s.remove(veiculo23);
            Veiculo23.placasCadastradas.remove(veiculo23.placa);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo23> veiculo23Optional = pesquisaPorPlaca(scanner);
        if (veiculo23Optional.isPresent()){
            Veiculo23 veiculo23 = veiculo23Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        veiculo23.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo23.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo23.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo23.setValorMercado(validandoValorMercado(scanner));
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }
}
