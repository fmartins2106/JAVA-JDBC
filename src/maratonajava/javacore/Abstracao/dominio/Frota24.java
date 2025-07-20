package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota24 {
    private List<Veiculo24> veiculo24s;

    public Frota24(){
        this.veiculo24s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo24.validacaoPlaca(placa);
                Veiculo24.validacaoPlacaDuplicada(placa);
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
                Veiculo24.validacaoAnoFabricacao(anoFabricacao);
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
                Veiculo24.validacaoCor(cor);
                return cor;
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
                Veiculo24.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo24 veiculo24){
        veiculo24s.add(veiculo24);
    }

    public void listarVeiculos(){
        if (veiculo24s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
        }else{
            for (Veiculo24 veiculo24 : veiculo24s) {
                System.out.println("___________________________");
                veiculo24.exibirDetalhes();
                System.out.println("___________________________");
            }
        }
    }

    public Optional<Veiculo24> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            if (veiculo24s.isEmpty()){
                System.out.println("Lista vazia. Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo24> placaEncontrada = veiculo24s.stream().filter(veiculo24 -> veiculo24.placa.equalsIgnoreCase(placa)).findFirst();
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
        Optional<Veiculo24> veiculo24Optional = pesquisaPorPlaca(scanner);
        if (veiculo24Optional.isPresent()){
            Veiculo24 veiculo24 = veiculo24Optional.get();
            System.out.println("____________________________________________");
            veiculo24.exibirDetalhes();
            System.out.println("____________________________________________");
        }
    }


    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo24> veiculo24Optional = pesquisaPorPlaca(scanner);
        if (veiculo24Optional.isPresent()){
            Veiculo24 veiculo24 = veiculo24Optional.get();
            veiculo24.registrarPagamentoIPVA();
        }
    }

    public void historicoPagamentoIPVA(Scanner scanner){
        Optional<Veiculo24> veiculo24Optional = pesquisaPorPlaca(scanner);
        if (veiculo24Optional.isPresent()){
            Veiculo24 veiculo24 = veiculo24Optional.get();
            veiculo24.mostrarHistoricoIPVA();
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo24> veiculo24Optional = pesquisaPorPlaca(scanner);
        if (veiculo24Optional.isPresent()){
            Veiculo24 veiculo24 = veiculo24Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor mercado. \n[5]Sair. ");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        veiculo24.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo24.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo24.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo24.setValorMercado(validandoValorMercado(scanner));
                        break;
                    case 5:
                    return;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo24> veiculo24Optional = pesquisaPorPlaca(scanner);
        if (veiculo24Optional.isPresent()){
            Veiculo24 veiculo24 = veiculo24Optional.get();
            veiculo24s.remove(veiculo24);
            Veiculo24.placasCadastradas.remove(veiculo24.placa);
            System.out.println("Dados removidos com sucesso.");
        }
    }
}
