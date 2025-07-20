package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota04 {
    private List<Veiculo04> veiculo04s;

    public Frota04(){
        this.veiculo04s = new ArrayList<>();
    }

    public static String validandoPlacas(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo04.validacaoPlaca(placa);
                return placa;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo04.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para ano de fabricação;");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(Scanner scanner){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine().trim();
                Veiculo04.validacaoCor(cor);
                return Veiculo04.formatoNome(cor);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorDeMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorDeMercado = Double.parseDouble(scanner.nextLine());
                Veiculo04.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para o valor de mercado.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculos(Veiculo04 veiculo04){
        veiculo04s.add(veiculo04);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo04s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (Veiculo04 veiculo04 : veiculo04s){
                System.out.println("_______________________");
                veiculo04.exibirDetalhes();
                System.out.println("_______________________");
            }
        }
    }

    public void exibirHistoricoIPVA(Scanner scanner){
        String placa = validandoPlacas(scanner);
        for (Veiculo04 veiculo04 : veiculo04s){
            if (veiculo04.toString().contains(placa)){
                veiculo04.mostrarHistoricoIPVA();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void pesquisaPorPlaca(Scanner scanner){
        String placa = validandoPlacas(scanner);
        boolean placaEncontrada = false;
        for (Veiculo04 veiculo04 : veiculo04s){
            if (veiculo04.toString().contains(placa)){
                veiculo04.exibirDetalhes();
                placaEncontrada = true;
            }
        }
        if (!placaEncontrada){
            System.out.println("Placa não encontrada.");
        }
    }

    public void excluirVeiculo(Scanner scanner){
        String placa = validandoPlacas(scanner);
        for (Veiculo04 veiculo04 : veiculo04s){
            if (veiculo04.toString().contains(placa)){
                veiculo04s.remove(veiculo04);
                System.out.println("Veículo removido com sucesso.");
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void alterarDadosVeiculos(Scanner scanner){
        String placa = validandoPlacas(scanner);
        for (Veiculo04 veiculo04 : veiculo04s){
            if (veiculo04.toString().contains(placa)){
                veiculo04.setPlaca(validandoPlacas(scanner));
                veiculo04.setAnoFabricacao(validandoAnoFabricacao(scanner));
                veiculo04.setCor(validandoCor(scanner));
                veiculo04.setValorMercado(validandoValorDeMercado(scanner));
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        String placa = validandoPlacas(scanner);
        for (Veiculo04 veiculo04 : veiculo04s){
            if (veiculo04.getPlaca().equalsIgnoreCase(placa)){
                veiculo04.registrarPagamentoIPVA();
                System.out.println("Pagamento de IPVA registrado com sucesso.");
                return;
            }
        }
        System.out.println("Número de placa não encontrada.");
    }

}
