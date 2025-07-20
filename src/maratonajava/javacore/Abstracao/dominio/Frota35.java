package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.*;

public class Frota35 {
    private List<Veiculo35> veiculo35s;

    public Frota35(){
        this.veiculo35s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo35.validacaoPlaca(placa);
                Veiculo35.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaDuplicadaException35 | PlacaInvalidaException35 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo35.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (AnoFabricacaoException35 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(Scanner scanner){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo35.validacaoCor(cor);
                return Veiculo35.formatoString(cor);
            }catch (CorInvalidaException35 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                Veiculo35.validacaoValorMercado(valor);
                return valor;
            }catch (ValorMercadoInvalidaException35 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo35 veiculo35){
        veiculo35s.add(veiculo35);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public void listarVeiculosCadastrados(){
        if (veiculo35s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo35 veiculo35 : veiculo35s) {
            System.out.println("________________________________________________");
            veiculo35.exibirDetalhes();
            System.out.println("________________________________________________");
        }
    }

    public Optional<Veiculo35> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Digite a Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo35.validacaoPlaca(placa);
            if (veiculo35s.isEmpty()){
                System.out.println("Placa não encontrada.");
                return Optional.empty();
            }
            Optional<Veiculo35> placaEncontrada = veiculo35s.stream().filter(veiculo35 -> veiculo35.placa.equalsIgnoreCase(placa)).findFirst();
            if (placaEncontrada.isPresent()){
                return placaEncontrada;
            }
            System.out.println("Placa não encontrada.");
            return Optional.empty();
        }catch (PlacaInvalidaException35 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorPlaca(Scanner scanner){
        Optional<Veiculo35> veiculo35Optional = pesquisaPorPlaca(scanner);
        if (veiculo35Optional.isPresent()){
            Veiculo35 veiculo35 = veiculo35Optional.get();
            System.out.println("______________________________________________");
            veiculo35.exibirDetalhes();
            System.out.println("______________________________________________");
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo35> veiculo35Optional = pesquisaPorPlaca(scanner);
        if (veiculo35Optional.isPresent()){
            Veiculo35 veiculo35 = veiculo35Optional.get();
            Iterator<Veiculo35> iterator = veiculo35s.iterator();
            while (iterator.hasNext()){
                Veiculo35 veiculo = iterator.next();
                if (veiculo.equals(veiculo35)){
                    iterator.remove();
                    Veiculo35.placasCadastradas.remove(veiculo35.placa);
                    System.out.println("Dados removidos com sucesso.");
                }
            }
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo35> veiculo35Optional = pesquisaPorPlaca(scanner);
        if (veiculo35Optional.isPresent()){
            Veiculo35 veiculo35 = veiculo35Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo35.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo35.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo35.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo35.setValorMercado(validandoValorMercado(scanner));
                        break;
                    case 5:
                        System.out.println(">>>Finalizando sistema.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void registrarPagamento(Scanner scanner){
        Optional<Veiculo35> veiculo35Optional = pesquisaPorPlaca(scanner);
        if (veiculo35Optional.isPresent()){
            Veiculo35 veiculo35 = veiculo35Optional.get();
            veiculo35.registrarPagamentoIPVA();
        }
    }

    public void  mostrarHistoricoPagamento(Scanner scanner){
        Optional<Veiculo35> veiculo35Optional = pesquisaPorPlaca(scanner);
        if (veiculo35Optional.isPresent()){
            Veiculo35 veiculo35 = veiculo35Optional.get();
            veiculo35.mostrarHistoricoIPVA();
        }
    }
}
