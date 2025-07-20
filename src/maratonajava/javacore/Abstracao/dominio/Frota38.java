package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.*;

public class Frota38 {
    private List<Veiculo38> veiculo38s;

    public Frota38(){
        this.veiculo38s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo38.validacaoPlaca(placa);
                Veiculo38.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaInvalidaoException38 | PlacaDuplicadaException38 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int valindandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo38.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um ano válido.");
            }catch (AnoFabricacaoException38 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(Scanner scanner){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo38.validacaoCor(cor);
                return Veiculo38.formatoString(cor);
            }catch (CorInvalidaException38 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo38.validacaoValorDeMercado(valorMercado);
                return valorMercado;
            }catch (ValorMercadoInvalidoException38 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo38 veiculo38){
        veiculo38s.add(veiculo38);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public void listarVeiculosCadastrados(){
        if (veiculo38s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo38 veiculo38 : veiculo38s) {
            System.out.println("________________________________________");
            veiculo38.exibirDados();
            System.out.println("________________________________________");
        }
    }

    public Optional<Veiculo38> pesquisaPorPlaca(Scanner scanner){
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo38.validacaoPlaca(placa);
            if (veiculo38s.isEmpty()){
                System.out.println("Nenhum veiculo foi cadastrado.");
                return Optional.empty();
            }
            Optional<Veiculo38> placaEncontrada = veiculo38s.stream().filter(veiculo38 ->  veiculo38.placa.equalsIgnoreCase(placa)).findFirst();
            if (placaEncontrada.isPresent()){
                return placaEncontrada;
            }
            System.out.println("Nenhuma placa foi encontrada.");
            return Optional.empty();
        }catch (PlacaInvalidaoException38 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorPlaca(Scanner scanner){
        Optional<Veiculo38> veiculo38Optional = pesquisaPorPlaca(scanner);
        if (veiculo38Optional.isPresent()){
            Veiculo38 veiculo38 = veiculo38Optional.get();
            System.out.println("_____________________________________________");
            veiculo38.exibirDados();
            System.out.println("_____________________________________________");
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo38> veiculo38Optional = pesquisaPorPlaca(scanner);
        if (veiculo38Optional.isPresent()){
            Veiculo38 veiculo38 = veiculo38Optional.get();
            Iterator<Veiculo38> iterator = veiculo38s.iterator();
            while (iterator.hasNext()){
                Veiculo38 veiculo = iterator.next();
                if (veiculo.equals(veiculo38)){
                    iterator.remove();
                    Veiculo38.placasCadastradas.remove(veiculo.placa);
                    System.out.println("Dados removidos com sucesso.");
                }
            }
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo38> veiculo38Optional = pesquisaPorPlaca(scanner);
        if (veiculo38Optional.isPresent()){
            Veiculo38 veiculo38 = veiculo38Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano de fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo38.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo38.setAnoFabricacao(valindandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo38.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo38.setValorMercado(validandoValorMercado(scanner));
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

    public void mostrarHistoricoIPVA(Scanner scanner, String acao){
        Optional<Veiculo38> veiculo38Optional = pesquisaPorPlaca(scanner);
        if (veiculo38Optional.isPresent()){
            Veiculo38 veiculo38 = veiculo38Optional.get();
            if (acao.equalsIgnoreCase("mostrar")){
                veiculo38.mostrarHistoricoIPVA();
            }else {
                veiculo38.registrarPagamentoIPVA();
            }
        }
    }




}
