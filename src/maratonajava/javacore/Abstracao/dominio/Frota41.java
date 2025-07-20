package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.*;

public class Frota41 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Veiculo41> veiculo41s;

    public Frota41(){
        this.veiculo41s = new ArrayList<>();
    }

    public static String validandoPlaca(){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo41.validacaoPlaca(placa);
                Veiculo41.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaDuplicadaException41 | PlacaInvalidaException41 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo41.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um  ano válido.");
            }catch (AnoFabricacaoException41 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo41.validacaoCor(cor);
                return Veiculo41.formatoCor(cor);
            }catch (CorInvalidaException41 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo41.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorMercadoInvalidoException41 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo41 veiculo41){
        veiculo41s.add(veiculo41);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public void listarVeiculosCadastrados(){
        if (veiculo41s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo41 veiculo41 : veiculo41s) {
            System.out.println("_____________________________________");
            veiculo41.exibirDados();
            System.out.println("_____________________________________");
        }
    }

    public Optional<Veiculo41> pesquisaPorPlaca(){
        if (veiculo41s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return Optional.empty();
        }
        try {
            System.out.print("Placa:");
            String placa = scanner.nextLine().trim();
            Veiculo41.validacaoPlaca(placa);
            Optional<Veiculo41> placaEncontrada =  veiculo41s.stream().filter(veiculo41 -> veiculo41.placa.equalsIgnoreCase(placa)).findFirst();
            if (placaEncontrada.isPresent()){
                return placaEncontrada;
            }
            System.out.println("Placa não encontrada.");
            return Optional.empty();
        }catch (PlacaInvalidaException41 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorPlaca(){
        Optional<Veiculo41> veiculo41Optional = pesquisaPorPlaca();
        if (veiculo41Optional.isPresent()){
            Veiculo41 veiculo41 = veiculo41Optional.get();
            System.out.println("_________________________________________________");
            veiculo41.exibirDados();
            System.out.println("_________________________________________________");
            return;
        }
        System.out.println("Veiculo não encontrado.");
    }

    public void excluirDadosVeiculo(){
        Optional<Veiculo41> veiculo41Optional = pesquisaPorPlaca();
        if (veiculo41Optional.isPresent()){
            Iterator<Veiculo41> iterator = veiculo41s.iterator();
            while (iterator.hasNext()){
                Veiculo41 veiculo41 = iterator.next();
                if (veiculo41.equals(veiculo41Optional.get())){
                    iterator.remove();
                    Veiculo41.placasCadastradas.remove(veiculo41Optional.get().placa);
                    System.out.println("Dados removidos com sucesso.");
                    return;
                }
            }
        }else {
            System.out.println("Nenhuma placa foi encontrada.");
        }
    }

    public void alterarDados(){
        Optional<Veiculo41> veiculo41Optional = pesquisaPorPlaca();
        if (veiculo41Optional.isPresent()){
            Veiculo41 veiculo41 = veiculo41Optional.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo41.setPlaca(validandoPlaca());
                        break;
                    case 2:
                        veiculo41.setAnoFabricacao(validandoAnoFabricacao());
                        break;
                    case 3:
                        veiculo41.setCor(validandoCor());
                        break;
                    case 4:
                        veiculo41.setValorMercado(validandoValorMercado());
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Erro. Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válido.");
            }

        }
    }

    public void mostrarHistoricoPagamentoIPVA(){
        Optional<Veiculo41> veiculo41Optional = pesquisaPorPlaca();
        if (veiculo41Optional.isPresent()){
            Veiculo41 veiculo41 = veiculo41Optional.get();
            veiculo41.mostrarHistoricoIPVA();
        }
    }

    public void registrarPagamentoIPVA(){
        Optional<Veiculo41> veiculo41Optional = pesquisaPorPlaca();
        if (veiculo41Optional.isPresent()){
            Veiculo41 veiculo41 = veiculo41Optional.get();
            veiculo41.registrarPagamentoIPVA();
        }
    }






}
