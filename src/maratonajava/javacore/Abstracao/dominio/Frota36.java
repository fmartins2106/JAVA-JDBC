package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.*;

public class Frota36 {
    private List<Veiculo36> veiculo36s;

    public Frota36(){
        this.veiculo36s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo36.validacaoPlaca(placa);
                Veiculo36.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaDuplicadaException36 | PlacaInvalidaException36 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo36.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (AnoFabricacaoException36 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(Scanner scanner){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo36.validacaoCor(cor);
                return cor;
            }catch (CorInvalidaException36 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo36.validacaoValorDeMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }catch (ValorMercadoInvalidoException36 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo36 veiculo36){
        veiculo36s.add(veiculo36);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public void listarVeiculos(){
        if (veiculo36s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo36 veiculo36 : veiculo36s) {
            System.out.println("_________________________________");
            veiculo36.exibirDados();
            System.out.println("_________________________________");
        }
    }


    public Optional<Veiculo36> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo36.validacaoPlaca(placa);
            if (veiculo36s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo36> placaEncontrada = veiculo36s.stream().filter(veiculo36 -> veiculo36.placa.equalsIgnoreCase(placa)).findFirst();
            if (placaEncontrada.isPresent()){
                return placaEncontrada;
            }
            System.out.println("Nenhuma placa foi encontrada.");
            return Optional.empty();
        }catch (PlacaInvalidaException36 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorPlaca(Scanner scanner){
        Optional<Veiculo36> veiculo36Optional = pesquisaPorPlaca(scanner);
        if (veiculo36Optional.isPresent()){
            Veiculo36 veiculo36 = veiculo36Optional.get();
            System.out.println("________________________________");
            veiculo36.exibirDados();
            System.out.println("________________________________");
        }
    }

    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo36> veiculo36Optional = pesquisaPorPlaca(scanner);
        if (veiculo36Optional.isPresent()){
            Veiculo36 veiculo36 = veiculo36Optional.get();
            veiculo36.mostrarHistoricoIPVA();
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo36> veiculo36Optional = pesquisaPorPlaca(scanner);
        if (veiculo36Optional.isPresent()){
            Veiculo36 veiculo36 = veiculo36Optional.get();
            veiculo36.registrarPagamentoIPVA();
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo36> veiculo36Optional = pesquisaPorPlaca(scanner);
        if (veiculo36Optional.isPresent()){
            Veiculo36 veiculo36 = veiculo36Optional.get();
            Iterator<Veiculo36> veiculo36Iterator = veiculo36s.iterator();
            while (veiculo36Iterator.hasNext()){
                Veiculo36 veiculo = veiculo36Iterator.next();
                if (veiculo.equals(veiculo36)){
                    veiculo36Iterator.remove();
                    Veiculo36.placasCadastradas.remove(veiculo36.placa);
                    System.out.println("Dados removido com sucesso.");
                }
            }
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo36> veiculo36Optional = pesquisaPorPlaca(scanner);
        if (veiculo36Optional.isPresent()){
            Veiculo36 veiculo36 = veiculo36Optional.get();
            try {
                System.out.print("[1]Placa. \n[2]Ano de fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo36.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo36.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo36.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo36.setValorMercado(validandoValorMercado(scanner));
                        break;
                    case 5:
                        return;
                    default:
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

}
