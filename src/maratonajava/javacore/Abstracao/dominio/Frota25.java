package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Frota25 {
    private List<Veiculo25> veiculo25s;

    public Frota25(){
        this.veiculo25s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo25.validacaoPlaca(placa);
                Veiculo25.validacaoPlacasDuplicadas(placa);
                return placa.toUpperCase();
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
                Veiculo25.validacaoAnoFabricacao(anoFabricacao);
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
                Veiculo25.validacaoCor(cor);
                return Veiculo25.formatoString(cor);
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
                Veiculo25.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo25 veiculo25){
        veiculo25s.add(veiculo25);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo25s.isEmpty()){
            System.out.println("Lista vazia, nenhum veiculo foi cadastrado.");
        }else {
            for (Veiculo25 veiculo25 : veiculo25s) {
                System.out.println("________________");
                veiculo25.exibirResultados();
                System.out.println("________________");
            }
        }
    }

    public Optional<Veiculo25> pesquisaPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine();
            Veiculo25.validacaoPlaca(placa);
            if (veiculo25s.isEmpty()){
                System.out.println("Lista vazia, nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo25> placaEncontrada = veiculo25s.stream().filter(veiculo25 -> veiculo25.placa.equalsIgnoreCase(placa)).findFirst();
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
        Optional<Veiculo25> veiculo25Optional = pesquisaPlaca(scanner);
        if (veiculo25Optional.isPresent()){
            Veiculo25 veiculo25 = veiculo25Optional.get();
            System.out.println("________________________");
            veiculo25.exibirResultados();
            System.out.println("________________________");
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo25> veiculo25Optional = pesquisaPlaca(scanner);
        if (veiculo25Optional.isPresent()){
            Veiculo25 veiculo25 = veiculo25Optional.get();
            veiculo25.registrarPagamentoIPVA();
        }
    }

    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo25> veiculo25Optional = pesquisaPlaca(scanner);
        if (veiculo25Optional.isPresent()){
            Veiculo25 veiculo25 = veiculo25Optional.get();
            veiculo25.mostrarHistoricoIPVA();
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo25> veiculo25Optional = pesquisaPlaca(scanner);
        if (veiculo25Optional.isPresent()){
            Veiculo25 veiculo25 = veiculo25Optional.get();
            veiculo25s.remove(veiculo25);
            Veiculo25.placasCadastras.remove(veiculo25.placa);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo25> veiculo25Optional = pesquisaPlaca(scanner);
        if (veiculo25Optional.isPresent()){
            Veiculo25 veiculo25 = veiculo25Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        veiculo25.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo25.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo25.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo25.setValorMercado(validandoValorMercado(scanner));
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Digige uma das opções acima.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }
}
