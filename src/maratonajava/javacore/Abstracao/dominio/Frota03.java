package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota03 {
    private List<Veiculo03>veiculo03s;

    public Frota03(){
        this.veiculo03s = new ArrayList<>();
    }

    public static String validandoPlacas(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo03.validacaoPlacas(placa);
                return placa.toUpperCase();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Ano fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo03.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            } catch (NumberFormatException e) {
                System.out.println("Digite um ano válido.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(Scanner scanner){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine();
                Veiculo03.validacaoCor(cor);
                return cor;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorDeMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine());
                Veiculo03.validacaoValorMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo03 veiculo03){
        veiculo03s.add(veiculo03);
    }

    public void listaDeVeiculosCadastrados(){
        if (veiculo03s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.println("__________________________");
            for (Veiculo03 veiculo03 : veiculo03s){
                veiculo03.exibirDetalhes();
            }
            System.out.println("__________________________");
        }
    }

    public void exibirHistoricoIPVA(Scanner scanner){
        String placa = validandoPlacas(scanner);
        for (Veiculo03 veiculo03 : veiculo03s){
            if (veiculo03.toString().contains(placa)){
                veiculo03.mostrarHistoricoIPVA();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void pesquisaPorPlaca(Scanner scanner){
        String placa = validandoPlacas(scanner);
        boolean placaEncontrada = false;
        for (Veiculo03 veiculo03 : veiculo03s){
            if (veiculo03.toString().contains(placa)){
                placaEncontrada = true;
                veiculo03.exibirDetalhes();
            }
        }
        if (!placaEncontrada){
            System.out.println("Placa não encontrada.");
        }
    }

    public void excluirVeiculo(Scanner scanner){
        String placa = validandoPlacas(scanner);
        for (Veiculo03 veiculo03 : veiculo03s){
            if (veiculo03.getPlaca().equalsIgnoreCase(placa)){
                veiculo03s.remove(veiculo03);
                System.out.println("Veículo removido com sucesso.");
                return;
            }
        }
        System.out.println("Número de placa não encontrada.");
    }

    public void alterarDadosVeiculo(Scanner scanner){
        String placa = validandoPlacas(scanner);
        for (Veiculo03 veiculo03 : veiculo03s){
            if (veiculo03.toString().contains(placa)){
                veiculo03.setPlaca(validandoPlacas(scanner));
                veiculo03.setCor(validandoCor(scanner));
                veiculo03.setValorMercado(validandoValorDeMercado(scanner));
                veiculo03.setAnoFabricacao(validandoAnoFabricacao(scanner));
                return;
            }
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        String placa = validandoPlacas(scanner);
        for (Veiculo03 veiculo03 : veiculo03s){
            if (veiculo03.toString().contains(placa)){
                veiculo03.registrarPagamentoIPVA();
                System.out.println("Pagamento de IPVA registrado com sucesso.");
                return;
            }
        }
        System.out.println("Número de placa não encontrada.");
    }
}
