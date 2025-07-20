package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.*;

public class Frota37 {

    private List<Veiculo37> veiculo37s;

    public Frota37(){
        this.veiculo37s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo37.validacaoPlaca(placa);
                Veiculo37.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaInvalidaException37 | PlacaDuplicadaException37 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo37.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um ano válido.");
            }catch (AnoFabricacaoException37 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(Scanner scanner){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo37.validacaoCor(cor);
                return Veiculo37.formatoString(cor);
            }catch (CorInvalidaException37 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo37.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (ValorMercadoInvalidoException37 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo37 veiculo37){
        veiculo37s.add(veiculo37);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public void listarVeiculos(){
        if (veiculo37s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo37 veiculo37 : veiculo37s) {
            System.out.println("____________________________________");
            veiculo37.exibirDados();
            System.out.println("____________________________________");
        }
    }

    public Optional<Veiculo37> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo37.validacaoPlaca(placa);
            if (veiculo37s.isEmpty()){
                System.out.println("Nenhuma placa foi cadastrada.");
                return Optional.empty();
            }
            Optional<Veiculo37> placaEncontrada = veiculo37s.stream().filter(veiculo37 -> veiculo37.placa.equalsIgnoreCase(placa)).findFirst();
            if (placaEncontrada.isPresent()){
                return placaEncontrada;
            }
            System.out.println("Nenhuma placa foi encontrada.");
            return Optional.empty();
        }catch (PlacaInvalidaException37 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }


    public void exibirDadosPesquisaPorPlaca(Scanner scanner){
        Optional<Veiculo37> veiculo37Optional = pesquisaPorPlaca(scanner);
        if (veiculo37Optional.isPresent()){
            Veiculo37 veiculo37 = veiculo37Optional.get();
            System.out.println("_______________________________________");
            veiculo37.exibirDados();
            System.out.println("_______________________________________");
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo37> veiculo37Optional = pesquisaPorPlaca(scanner);
        if (veiculo37Optional.isPresent()){
            Veiculo37 veiculo37 = veiculo37Optional.get();
            Iterator<Veiculo37> veiculo37Iterator = veiculo37s.iterator();
            while (veiculo37Iterator.hasNext()){
                Veiculo37 veiculo = veiculo37Iterator.next();
                if (veiculo.equals(veiculo37)){
                    veiculo37Iterator.remove();
                    Veiculo37.placasDuplicadas.remove(veiculo37.placa);
                    System.out.println("Dados removidos com sucesso.");
                }
            }
        }
    }

    public void alterarDadoVeiclo(Scanner scanner){
        Optional<Veiculo37> veiculo37Optional = pesquisaPorPlaca(scanner);
        if (veiculo37Optional.isPresent()){
            Veiculo37 veiculo37 = veiculo37Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano de fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo37.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo37.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo37.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo37.setValorMercado(validandoValorMercado(scanner));
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo37> veiculo37Optional = pesquisaPorPlaca(scanner);
        if (veiculo37Optional.isPresent()){
            Veiculo37 veiculo37 = veiculo37Optional.get();
            veiculo37.registrarHistoricoPagamentoIPVA();
        }
    }

    public void mostrarHistoricoPagamentoIPVA(Scanner scanner){
        Optional<Veiculo37> veiculo37Optional = pesquisaPorPlaca(scanner);
        if (veiculo37Optional.isPresent()){
            Veiculo37 veiculo37 = veiculo37Optional.get();
            veiculo37.mostrarHistoricoIPVA();
        }
    }

}
