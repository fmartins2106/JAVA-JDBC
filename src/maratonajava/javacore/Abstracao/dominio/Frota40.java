package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.*;

public class Frota40 {
    private static final Scanner scanner = new Scanner(System.in);
    private List<Veiculo40> veiculo40s;

    public Frota40(){
        this.veiculo40s = new ArrayList<>();
    }

    public void addVeiculoSistema(Veiculo40 veiculo40){
        veiculo40s.add(veiculo40);
        System.out.println("Veiculo cadastrado com sucesso.");
    }

    public static String validandoPlaca(){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo40.validacaoPlaca(placa);
                Veiculo40.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaInvalidaException40 | PlacaDuplicadaException40 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(){
        while (true){
            try {
                System.out.print("Ano fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo40.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um ano válido.");
            }catch (AnoFabricacaoException40 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo40.validacaoCorVeiculo(cor);
                return Veiculo40.formatoString(cor);
            }catch (CorInvalidaException40 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(){
        while (true){
            try {
                System.out.print("Valor mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo40.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor de mercado inválid.");
            }catch (ValorMercadoInvalidoException40 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void listarVeiculosCadastrados(){
        if (veiculo40s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo40 veiculo40 : veiculo40s) {
            System.out.println("______________________________________________");
            veiculo40.exibirInfo();
            System.out.println("______________________________________________");
        }
    }

    public Optional<Veiculo40> pesquisaPorPlaca(){
        if (veiculo40s.isEmpty()){
            System.out.println("Nenhuma placa foi cadastrada.");
            return Optional.empty();
        }
        System.out.print("Digite o número da placa:");
        String placa = scanner.nextLine().trim();
        return veiculo40s.stream().filter(veiculo40 -> veiculo40.placa.equalsIgnoreCase(placa)).findFirst();
    }

    public void excluirDados(){
        Optional<Veiculo40> placaEncontrada = pesquisaPorPlaca();
        if (placaEncontrada.isPresent()){
            Iterator<Veiculo40> iterator = veiculo40s.iterator();
            while (iterator.hasNext()){
                Veiculo40 veiculo = iterator.next();
                if (veiculo.placa.equals(placaEncontrada.get().placa)){
                    iterator.remove();
                    Veiculo40.placasCadastradas.remove(veiculo.placa);
                    System.out.println("Dados removidos com sucesso.");
                    return;
                }
            }
            System.out.println("Nenhum veiculo foi encontrado.");
        }else {
            System.out.println("Nenhum veiculo foi encontrado.");
        }
    }

    public void alterarDadosVeiculo(){
        Optional<Veiculo40> placaEncontrada = pesquisaPorPlaca();
        if (placaEncontrada.isPresent()){
            Veiculo40 veiculo40 = placaEncontrada.get();
            try {
                System.out.println("----ESCOLHA UMA DAS OPÇÕES PARA ALTERAR----");
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo40.setNome(validandoPlaca());
                        break;
                    case 2:
                        veiculo40.setAnoFabricacao(validandoAnoFabricacao());
                        break;
                    case 3:
                        veiculo40.setCor(validandoCor());
                        break;
                    case 4:
                        veiculo40.setValorMercado(validandoValorMercado());
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public void exibirPesquisaPorPlaca(){
        Optional<Veiculo40> placaEncontrada = pesquisaPorPlaca();
        if (placaEncontrada.isPresent()){
            Veiculo40 veiculo40 = placaEncontrada.get();
            System.out.println("_______________________________________");
            veiculo40.exibirInfo();
            System.out.println("_______________________________________");
            return;
        }
        System.out.println("Placa não encontrada.");
    }

    public void mostrarHistoricoPagamentoIPVA(){
        Optional<Veiculo40> veiculoEncontrado = pesquisaPorPlaca();
        if (veiculoEncontrado.isPresent()){
            Veiculo40 veiculo40 = veiculoEncontrado.get();
            veiculo40.mostrarHistoricoIPVA();
            return;
        }
        System.out.println("Placa não encontrada.");
    }

    public void registrarPagamentoIPVA(){
        Optional<Veiculo40> veiculoEncontrado = pesquisaPorPlaca();
        if (veiculoEncontrado.isPresent()){
            Veiculo40 veiculo40 = veiculoEncontrado.get();
            veiculo40.registrarPagamentoIPVA();
            return;
        }
        System.out.println("Placa não encontrada.");
    }

}
