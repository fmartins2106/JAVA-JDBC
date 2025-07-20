package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota02 {
    private List<Veiculo02> veiculo02s;

    public Frota02(){
        this.veiculo02s = new ArrayList<>();
    }

    public static String validandoPlacas(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo02.validacaoPlacas(placa);
                return placa.toUpperCase();
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
                Veiculo02.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido para o ano de fabricação.");
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
                Veiculo02.validacaoCor(cor);
                return Veiculo02.formatoNome(cor);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorDeMercador(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:R$");
                double valorMercado = Double.parseDouble(scanner.nextLine());
                Veiculo02.validacaoValorDeMercado(valorMercado);
                return valorMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para valor de mercado.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo02 veiculo02){
        veiculo02s.add(veiculo02);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo02s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (Veiculo02 veiculo02 : veiculo02s){
                veiculo02.exibirDetalhes();
            }
            System.out.println("______________________________");
        }
    }

    public void exibirHistoricoIPVA(Scanner scanner){
        String placa = validandoPlacas(scanner);
        for (Veiculo02 veiculo02 : veiculo02s){
            if (veiculo02.toString().contains(placa));
            veiculo02.mostrarHistoricoIPVA();
            return;
        }
        System.out.println("Placa não encontrada.");
    }

    public void pesquisaPorPlacas(Scanner scanner){
        String placa = validandoPlacas(scanner);
        boolean placaEncontrada = false;
        for (Veiculo02 veiculo02 : veiculo02s){
            if (veiculo02.toString().contains(placa)){
                placaEncontrada = true;
                veiculo02.exibirDetalhes();
            }
        }
        if (!placaEncontrada){
            System.out.println("Placa não encontrada.");
        }
    }

    public void excluirVeiculos(Scanner scanner){
        String placa = validandoPlacas(scanner);
        for (Veiculo02 veiculo02 : veiculo02s){
            if (veiculo02.toString().contains(placa)){
                veiculo02s.remove(veiculo02);
                System.out.println("Veículo removido com sucesso.");
                return;
            }
        }
        System.out.println("Número de placa não encontrado.");
    }

    public void alterarDadosDoVeiculo(Scanner scanner){
        String placa = validandoPlacas(scanner);
        for (Veiculo02 veiculo02 : veiculo02s){
            if (veiculo02.toString().contains(placa)){
                veiculo02.setPlaca(validandoPlacas(scanner));
                veiculo02.setCor(validandoCor(scanner));
                veiculo02.setValorDeMercado(validandoValorDeMercador(scanner));
                return;
            }
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        String placa = validandoPlacas(scanner);
        for (Veiculo02 veiculo02 : veiculo02s){
            if (veiculo02.toString().contains(placa)){
                veiculo02.registrarPagamentoIPVA();
                System.out.println("Pagamento de IPVA registrado com sucesso.");
                return;
            }
        }
        System.out.println("Veículo não encontrado.");
    }
}
