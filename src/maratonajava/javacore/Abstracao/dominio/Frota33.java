package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.*;

public class Frota33 {
    List<Veiculo33> veiculo33s;

    public Frota33(){
        this.veiculo33s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo33.validacaoPlaca(placa);
                Veiculo33.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaInvalidaException33 | PlacaDuplicadaException33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo33.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para ano de fabricação.");
            }catch (AnoFabricacaoException33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(Scanner scanner){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo33.validacaoCor(cor);
                return Veiculo33.formatoString(cor);
            }catch (CorInvalidaException33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo33.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (ValorMercadoInvalidoExcepiton33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo33 veiculo33){
        veiculo33s.add(veiculo33);
    }

    public void listarVeiculosCadastrados(){
        if (veiculo33s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo33 veiculo33 : veiculo33s) {
            System.out.println("______________________________________");
            veiculo33.exibirDetalhes();
            System.out.println("______________________________________");
        }
    }

    public Optional<Veiculo33> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo33.validacaoPlaca(placa);
            if (veiculo33s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo33> placaEncontrada = veiculo33s.stream().filter(veiculo33 -> veiculo33.placa.equalsIgnoreCase(placa)).findFirst();
            if (placaEncontrada.isPresent()){
                return placaEncontrada;
            }
            System.out.println("Placa não encontrada.");
            return Optional.empty();
        }catch (PlacaInvalidaException33 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirDadosPesquisaVeiculo(Scanner scanner){
        Optional<Veiculo33> veiculo33Optional = pesquisaPorPlaca(scanner);
        if (veiculo33Optional.isPresent()){
            Veiculo33 veiculo33 = veiculo33Optional.get();
            System.out.println("_____________________________");
            veiculo33.exibirDetalhes();
            System.out.println("_____________________________");
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo33> veiculo33Optional = pesquisaPorPlaca(scanner);
        if (veiculo33Optional.isPresent()){
            Veiculo33 veiculo33 = veiculo33Optional.get();
            veiculo33.registrarPagamentoIPVA();
        }
    }

    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo33> veiculo33Optional = pesquisaPorPlaca(scanner);
        if (veiculo33Optional.isPresent()){
            Veiculo33 veiculo33 = veiculo33Optional.get();
            veiculo33.mostrarHistoricoPagamentoIPVA();
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo33> veiculo33Optional = pesquisaPorPlaca(scanner);
        if (veiculo33Optional.isPresent()){
            Veiculo33 veiculo33 = veiculo33Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo33.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo33.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo33.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo33.setValorMercado(validandoValorMercado(scanner));
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

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo33> veiculo33Optional = pesquisaPorPlaca(scanner);
        if (veiculo33Optional.isPresent()){
            Veiculo33 veiculo33 = veiculo33Optional.get();
            Iterator<Veiculo33> iterator = veiculo33s.iterator();
            while (iterator.hasNext()){
                Veiculo33 veiculo = iterator.next();
                if (veiculo.equals(veiculo33)){
                    iterator.remove();
                    Veiculo33.placasCadastradas.remove(veiculo33.placa);
                    System.out.println("Dados removidos com sucesso.");
                }
            }
        }
    }



}
