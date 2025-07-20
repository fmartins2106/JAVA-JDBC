package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.*;

public class Frota39 {
    private List<Veiculo39> veiculo39s;

    public Frota39(){
        this.veiculo39s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo39.validacaoPlaca(placa);
                Veiculo39.validacaoPlacaDuplicada(placa);
                return placa;
            }catch (PlacaInvalidaoException39 | PlacaDuplicadaException39 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine().trim());
                Veiculo39.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido para ano.");
            }catch (AnoFabricacaoException39 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(Scanner scanner){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo39.validacaoCor(cor);
                return Veiculo39.formatoString(cor);
            }catch (CorInvalidaException39 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine().trim());
                Veiculo39.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }catch (ValorMercadoInvalidoException39 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculoSistema(Veiculo39 veiculo39){
        veiculo39s.add(veiculo39);
        System.out.println("Veiculo adicionado no sistema.");
    }

    public void listarVeiculosCadastrados(){
        if (veiculo39s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo39 veiculo39 : veiculo39s) {
            System.out.println("________________________________________");
            veiculo39.exibirDados();
            System.out.println("________________________________________");
        }
    }

    public Optional<Veiculo39> pesquisaPorPlaca(Scanner scanner){
        if (veiculo39s.isEmpty()){
            System.out.println("Nenhuma placa foi cadastrada.");
            return Optional.empty();
        }
        try {
            System.out.print("Digite a placa:");
            String placa = scanner.nextLine().trim();
            Veiculo39.validacaoPlaca(placa);
            Optional<Veiculo39> placaEncontrada = veiculo39s.stream().filter(veiculo39 -> veiculo39.placa.equalsIgnoreCase(placa)).findFirst();
            if (placaEncontrada.isPresent()){
                return placaEncontrada;
            }
            System.out.println("Nenhuma placa foi encontrada.");
            return Optional.empty();
        }catch (PlacaInvalidaoException39 e){
            System.out.println("Digite uma placa válida no formato AAA0000 ou AAA0A00.");
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorPlaca(Scanner scanner){
        Optional<Veiculo39> veiculo39Optional = pesquisaPorPlaca(scanner);
        if (veiculo39Optional.isPresent()){
            Veiculo39 veiculo39 = veiculo39Optional.get();
            System.out.println("____________________________________");
            veiculo39.exibirDados();
            System.out.println("____________________________________");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        Optional<Veiculo39> veiculo39 = pesquisaPorPlaca(scanner);
        if (veiculo39.isPresent()){
            Veiculo39 veiculo40 = veiculo39.get();
            try {
                System.out.println("[1]Placa. \n[2]Ano fabricação. \n[3]Cor. \n[4]Valor de mercado. \n[5]Sair.");
                System.out.print("Digite uma das opçõe acima:");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        veiculo40.setPlaca(validandoPlaca(scanner));
                        break;
                    case 2:
                        veiculo40.setAnoFabricacao(validandoAnoFabricacao(scanner));
                        break;
                    case 3:
                        veiculo40.setCor(validandoCor(scanner));
                        break;
                    case 4:
                        veiculo40.setValorMercado(validandoValorMercado(scanner));
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Erro. Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public void mostrarHistoricoIPVA(Scanner scanner){
        Optional<Veiculo39> veiculo39Optional = pesquisaPorPlaca(scanner);
        if (veiculo39Optional.isPresent()){
            Veiculo39 veiculo39 = veiculo39Optional.get();
            veiculo39.mostrarHistoricoIPVA();
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        Optional<Veiculo39> veiculo39Optional = pesquisaPorPlaca(scanner);
        if (veiculo39Optional.isPresent()){
            Veiculo39 veiculo39 = veiculo39Optional.get();
            veiculo39.registrarPagamento();
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        Optional<Veiculo39> veiculo39Optional = pesquisaPorPlaca(scanner);
        if (veiculo39Optional.isPresent()){
            Veiculo39 veiculo39 = veiculo39Optional.get();
            Iterator<Veiculo39> iterator = veiculo39s.iterator();
            while (iterator.hasNext()){
                Veiculo39 veiculo = iterator.next();
                if (veiculo.equals(veiculo39)){
                    iterator.remove();
                    Veiculo39.placasCadastradas.remove(veiculo39.placa);
                    System.out.println("Veiculo removido com sucesso.");
                }
            }
        }
    }

}
