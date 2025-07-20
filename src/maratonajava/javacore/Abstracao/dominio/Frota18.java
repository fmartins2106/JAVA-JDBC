package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota18 {
    private List<Veiculo18> veiculo18s;

    public Frota18(){
        this.veiculo18s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo18.validacaoPlaca(placa);
                Veiculo18.validacaoPlacaDuplicada(placa);
                return placa.toUpperCase();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoDeFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoDeFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo18.validacaoAnoFabricacao(anoDeFabricacao);
                return anoDeFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
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
                Veiculo18.validandoCor(cor);
                return Veiculo18.formatoString(cor);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorDeMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:");
                double valorDeMercado = Double.parseDouble(scanner.nextLine());
                Veiculo18.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo18 veiculo18){
        veiculo18s.add(veiculo18);
    }

    public void listarVeiculosCadastrados(){
        if (veiculo18s.isEmpty()){
            System.out.println("Lista vazia. Nenhum veiculo foi cadastrado.");
        }else {
            for (Veiculo18 veiculo18 : veiculo18s) {
                System.out.println("____________________________");
                veiculo18.exibirDetalhes();
                System.out.println("____________________________");
            }
        }
    }

    public Optional<Veiculo18> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo18.validacaoPlaca(placa);
            if (veiculo18s == null || veiculo18s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo18> placaEncontrada = veiculo18s.stream().filter(veiculo18 -> veiculo18.getPlaca().equalsIgnoreCase(placa)).findFirst();
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

    public void registraPagamentos(Scanner scanner){
        Optional<Veiculo18> veiculo18Optional = pesquisaPorPlaca(scanner);
        if (veiculo18Optional.isPresent()){
            Veiculo18 veiculo18 = veiculo18Optional.get();
            veiculo18.registroPagamentoIPVA();
        }
    }

    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo18> veiculo18Optional = pesquisaPorPlaca(scanner);
        if (veiculo18Optional.isPresent()){
            Veiculo18 veiculo18 = veiculo18Optional.get();
            veiculo18.mostrarHistoricoIPVA();
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo18> veiculo18Optional = pesquisaPorPlaca(scanner);
        if (veiculo18Optional.isPresent()){
            Veiculo18 veiculo18 = veiculo18Optional.get();
            veiculo18s.remove(veiculo18);
            Veiculo18.placasCadastradas.remove(veiculo18.getPlaca());
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void exibirPesquisaPorPlaca(Scanner scanner){
        Optional<Veiculo18> veiculo18Optional = pesquisaPorPlaca(scanner);
        if (veiculo18Optional.isPresent()){
            Veiculo18 veiculo18 = veiculo18Optional.get();
            System.out.println("_______________________________");
            veiculo18.exibirDetalhes();
            System.out.println("_______________________________");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo18> veiculo18Optional = pesquisaPorPlaca(scanner);
        if (veiculo18Optional.isPresent()){
            Veiculo18 veiculo18 = veiculo18Optional.get();
            System.out.print("Qual das opções abaixo gostaria de alterar?:");
            System.out.println("[1]Placa. \n[2]Ano de fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Cancelar.");
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao){
                case 1:
                    veiculo18.setPlaca(validandoPlaca(scanner));
                    break;
                case 2:
                    veiculo18.setAnoFabricacao(validandoAnoDeFabricacao(scanner));
                    break;
                case 3:
                    veiculo18.setCor(validandoCor(scanner));
                    break;
                case 4:
                    veiculo18.setValorDeMercado(validandoValorDeMercado(scanner));
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }
}
