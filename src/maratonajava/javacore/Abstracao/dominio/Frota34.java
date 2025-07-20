package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.*;

public class Frota34 {
    private List<Veiculo34> veiculo34s;

    public Frota34(){
        this.veiculo34s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo34.validacaoPlaca(placa);
                Veiculo34.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaInvalidaException34 | PlacaDuplicadaException34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo34.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um ano válido.");
            }catch (AnoFabricacaoException34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(Scanner scanner){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo34.validacaoCor(cor);
                return Veiculo34.formatoString(cor);
            }catch (CorInvalidaException34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo34.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (ValorMercadoInvalidoException34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo34 veiculo34){
        veiculo34s.add(veiculo34);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public void listarVeiculosCadastrados(){
        if (veiculo34s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo34 veiculo34 : veiculo34s) {
            System.out.println("_____________________________________");
            veiculo34.exibirDados();
            System.out.println("_____________________________________");
        }
    }

    public Optional<Veiculo34> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo34.validacaoPlaca(placa);
            if (veiculo34s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo34> placaEncontrada = veiculo34s.stream().filter(veiculo34 -> veiculo34.placa.equalsIgnoreCase(placa)).findFirst();
            if (placaEncontrada.isPresent()){
                return placaEncontrada;
            }
            System.out.println("Placa não encontrada.");
            return Optional.empty();
        }catch (PlacaInvalidaException34 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirDadosPesquisa(Scanner scanner){
        Optional<Veiculo34> veiculo34Optional = pesquisaPorPlaca(scanner);
        if (veiculo34s.isEmpty()){
            System.out.println("Nenhuma veiculo foi cadastrado.");
            return;
        }
        for (Veiculo34 veiculo34 : veiculo34s) {
            System.out.println("________________________________________");
            veiculo34.exibirDados();
            System.out.println("________________________________________");
        }

    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo34> veiculo34Optional = pesquisaPorPlaca(scanner);
        if (veiculo34Optional.isPresent()){
            Veiculo34 veiculo34 = veiculo34Optional.get();
            Iterator<Veiculo34> veiculo = veiculo34s.iterator();
            while (veiculo.hasNext()){
                Veiculo34 veiculo35 = veiculo.next();
                if (veiculo35.equals(veiculo34)){
                    veiculo.remove();
                    Veiculo34.placasCadastradas.remove(veiculo34.placa);
                    System.out.println("Dados removidos com sucesso.");
                }
            }
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo34> veiculo34Optional = pesquisaPorPlaca(scanner);
        if (veiculo34Optional.isPresent()){
            Veiculo34 veiculo34 = veiculo34Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor De Mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo34.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo34.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo34.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo34.setValorMercado(validandoValorMercado(scanner));
                        break;
                    case 5:
                        System.out.println(">>>>>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo34> veiculo34Optional = pesquisaPorPlaca(scanner);
        if (veiculo34Optional.isPresent()){
            Veiculo34 veiculo34 = veiculo34Optional.get();
            veiculo34.registrarPagamentoIPVA();
        }
    }

    public void mostrarHistoricoPagamentoIPVA(Scanner scanner){
        Optional<Veiculo34> veiculo34Optional = pesquisaPorPlaca(scanner);
        if (veiculo34Optional.isPresent()){
            Veiculo34 veiculo34 = veiculo34Optional.get();
            veiculo34.mostrarHistoricoIPVA();
        }
    }

}
