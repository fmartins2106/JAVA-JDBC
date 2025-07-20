package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota19 {
    private List<Veiculo19> veiculo19s;

    public Frota19(){
        this.veiculo19s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo19.validacaoPlaca(placa);
                Veiculo19.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoDeFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano de Fabricação:");
                int anoDeFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo19.validacaoAnoDeFabricacao(anoDeFabricacao);
                return anoDeFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor para ano de nascimento válido.");
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
                Veiculo19.validacaoCor(cor);
                return Veiculo19.formatoString(cor);
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
                Veiculo19.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo19 veiculo19){
        veiculo19s.add(veiculo19);
    }

    public void listaVeiculos(){
        if (veiculo19s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
        }else {
            for (Veiculo19 veiculo19 : veiculo19s) {
                System.out.println("_______________________________");
                veiculo19.exibirDetalhes();
                System.out.println("_______________________________");
            }
        }
    }

    public Optional<Veiculo19> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo19.validacaoPlaca(placa);
            if (veiculo19s == null || veiculo19s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrada.");
                return Optional.empty();
            }
            Optional<Veiculo19> placaEncontrada = veiculo19s.stream().filter(veiculo19 -> veiculo19.getPlaca().equalsIgnoreCase(placa)).findFirst();
            if (placaEncontrada.isPresent()){
                return placaEncontrada;
            }
            System.out.println("Placa não encontrado.");
            return Optional.empty();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo19> veiculo19Optional = pesquisaPorPlaca(scanner);
        if (veiculo19Optional.isPresent()){
            Veiculo19 veiculo19 = veiculo19Optional.get();
            veiculo19.registrarPagamentoIPVA();
        }
    }

    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo19> veiculo19Optional = pesquisaPorPlaca(scanner);
        if (veiculo19Optional.isPresent()){
            Veiculo19 veiculo19 = veiculo19Optional.get();
            veiculo19.mostrarHistoricoPagamentoIPVA();
        }
    }

    public void exibirPesquisaPlaca(Scanner scanner){
        Optional<Veiculo19> veiculo19Optional = pesquisaPorPlaca(scanner);
        if (veiculo19Optional.isPresent()){
            Veiculo19 veiculo19 = veiculo19Optional.get();
            System.out.println("___________________________________");
            veiculo19.exibirDetalhes();
            System.out.println("___________________________________");
        }
    }

    public void excluirVeiculo(Scanner scanner){
        Optional<Veiculo19> veiculo19Optional = pesquisaPorPlaca(scanner);
        if (veiculo19Optional.isPresent()){
            Veiculo19 veiculo19 = veiculo19Optional.get();
            veiculo19s.remove(veiculo19);
            Veiculo19.placasCadastradas.remove(veiculo19.getPlaca());
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo19> veiculo19Optional = pesquisaPorPlaca(scanner);
        if (veiculo19Optional.isPresent()){
            Veiculo19 veiculo19 = veiculo19Optional.get();
            try {
                System.out.print("Digite uma das opções abaixo:");
                System.out.println("\n[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Cancelar.");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        veiculo19.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo19.setAnoFabricacao(validandoAnoDeFabricacao(scanner));
                        break;
                    case 3:
                        veiculo19.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo19.setValorDeMercado(validandoValorDeMercado(scanner));
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

