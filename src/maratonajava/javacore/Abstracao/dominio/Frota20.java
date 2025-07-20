package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota20 {
    private List<Veiculo20> veiculo20s;

    public Frota20(){
        this.veiculo20s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo20.validacaoPlaca(placa);
                Veiculo20.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoDeFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo20.validacaoAnoFabricacao(anoFabricacao);
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
                Veiculo20.validacaoCor(cor);
                return Veiculo20.formatoString(cor);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorDeMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorDeMercado = Double.parseDouble(scanner.nextLine());
                Veiculo20.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo20 veiculo20){
        veiculo20s.add(veiculo20);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo20s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (Veiculo20 veiculo20 : veiculo20s) {
                System.out.println("___________________________________________");
                veiculo20.exibirDetalhes();
                System.out.println("___________________________________________");
            }
        }
    }

    public Optional<Veiculo20> pesquisaPorNome(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo20.validacaoPlaca(placa);
            if (veiculo20s.isEmpty()){
                System.out.println("Lista vazia. Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo20> placaEncontra = veiculo20s.stream().filter(veiculo20 -> veiculo20.getPlaca().equalsIgnoreCase(placa)).findFirst();
            if (placaEncontra.isPresent()){
                return placaEncontra;
            }
            System.out.println("Placa não encontrada.");
            return Optional.empty();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo20> veiculo20Optional = pesquisaPorNome(scanner);
        if (veiculo20Optional.isPresent()){
            Veiculo20 veiculo20 = veiculo20Optional.get();
            veiculo20.registrarPagamentoIPVA();
        }
    }

    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo20> veiculo20Optional = pesquisaPorNome(scanner);
        if (veiculo20Optional.isPresent()){
            Veiculo20 veiculo20 = veiculo20Optional.get();
            veiculo20.mostrarHistoricoIPVA();
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo20> veiculo20Optional = pesquisaPorNome(scanner);
        if (veiculo20Optional.isPresent()){
            Veiculo20 veiculo20 = veiculo20Optional.get();
            veiculo20s.remove(veiculo20);
            Veiculo20.placasCadastradas.remove(veiculo20.getPlaca());
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo20> veiculo20Optional = pesquisaPorNome(scanner);
        if (veiculo20Optional.isPresent()){
            Veiculo20 veiculo20 = veiculo20Optional.get();
            try {
                System.out.println("____________________________________________________");
                System.out.println("[1]Placa. \n[2]Ano de fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções que gostaria de alterar:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        veiculo20.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo20.setAnoFabricacao(validandoAnoDeFabricacao(scanner));
                        break;
                    case 3:
                        veiculo20.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo20.setValorDeMercado(validandoValorDeMercado(scanner));
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

    public void exibirPesquisaPorPlaca(Scanner scanner){
        Optional<Veiculo20> veiculo20Optional = pesquisaPorNome(scanner);
        if (veiculo20Optional.isPresent()){
            Veiculo20 veiculo20 = veiculo20Optional.get();
            System.out.println("________________________________");
            veiculo20.exibirDetalhes();
            System.out.println("________________________________");
        }
    }

}



