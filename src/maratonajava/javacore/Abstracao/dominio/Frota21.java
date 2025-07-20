package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota21 {
    private List<Veiculo21> veiculo21s;

    public Frota21(){
        this.veiculo21s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo21.validacaoPlaca(placa);
                Veiculo21.validacaoPlacasDuplicadas(placa);
                return placa.toUpperCase();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage() );
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo21.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido para ano.");
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
                Veiculo21.validacaoCor(cor);
                return Veiculo21.formatoString(cor);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorDeMercado = Double.parseDouble(scanner.nextLine());
                Veiculo21.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo21 veiculo21){
        veiculo21s.add(veiculo21);
    }

    public void listaVeiculos(){
        if (veiculo21s.isEmpty()){
            System.out.println("Lista vazia, nenhum veiculo foi cadastrado.");
        }else {
            for (Veiculo21 veiculo21 : veiculo21s) {
                System.out.println("_______________________________");
                veiculo21.exibirDetalhes();
                System.out.println("_______________________________");
            }
        }
    }

    public Optional<Veiculo21> pesquisaPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo21.validacaoPlaca(placa);
            if (veiculo21s.isEmpty()){
                System.out.println("Lista vazia. Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo21> placaEncontrada = veiculo21s.stream().filter(veiculo21 -> veiculo21.getPlaca().equalsIgnoreCase(placa)).findFirst();
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

    public void exibirDetalhesPesquisaPlaca(Scanner scanner){
        Optional<Veiculo21> veiculo21Optional = pesquisaPlaca(scanner);
        if (veiculo21Optional.isPresent()){
            Veiculo21 veiculo21 = veiculo21Optional.get();
            System.out.println("____________________________");
            veiculo21.exibirDetalhes();
            System.out.println("____________________________");
        }
    }


    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo21> veiculo21Optional = pesquisaPlaca(scanner);
        if (veiculo21Optional.isPresent()){
            Veiculo21 veiculo21 = veiculo21Optional.get();
            veiculo21.mostrarHistoricoIPVA();
        }
    }

    public void registrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo21> veiculo21Optional = pesquisaPlaca(scanner);
        if (veiculo21Optional.isPresent()){
            Veiculo21 veiculo21 = veiculo21Optional.get();
            veiculo21.registrarPagamentoIPVA();
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo21> veiculo21Optional = pesquisaPlaca(scanner);
        if (veiculo21Optional.isPresent()){
            Veiculo21 veiculo21 = veiculo21Optional.get();
            veiculo21s.remove(veiculo21);
            Veiculo21.placasCadastras.remove(veiculo21.placa);
            System.out.println("Dados excluidos com sucesso.");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo21> veiculo21Optional = pesquisaPlaca(scanner);
        if (veiculo21Optional.isPresent()){
            Veiculo21 veiculo21 = veiculo21Optional.get();
            try {
                System.out.println("\n[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima.");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        veiculo21.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo21.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo21.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo21.setValorDeMercado(validandoValorMercado(scanner));
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
