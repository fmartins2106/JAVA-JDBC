package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota08 {
    private List<Veiculo08> veiculo08s;

    public Frota08(){
        this.veiculo08s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo08.validacaoPlaca(placa);
                return placa.toUpperCase();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano Fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo08.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
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
                Veiculo08.validacaoCor(cor);
                return Veiculo08.formatoString(cor);
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
                Veiculo08.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo08 veiculo08){
        veiculo08s.add(veiculo08);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo08s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (Veiculo08 veiculo08 : veiculo08s){
                System.out.println("_______________________");
                veiculo08.exibirDetalhes();
                System.out.println("_______________________");
            }
        }
    }

    public void pesquisaPorPlaca(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo08 veiculo08 : veiculo08s){
            if (veiculo08.toString().contains(placa)){
                veiculo08.exibirDetalhes();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void exibibirHistoricoIPVA(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo08 veiculo08 : veiculo08s){
            if (veiculo08.toString().contains(placa)){
                veiculo08.mostrarHistoricoIPVA();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void excluirDadosVeiculo(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo08 veiculo08 : veiculo08s){
            if (veiculo08.toString().contains(placa)){
                veiculo08s.remove(veiculo08);
                System.out.println("Dados removidos com sucesso.");
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void alterarDadosVeiculo(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo08 veiculo08 : veiculo08s){
            if (veiculo08.toString().contains(placa)){
                veiculo08.setPlaca(validandoPlaca(scanner));
                veiculo08.setAnoFabricacao(validandoAnoFabricacao(scanner));
                veiculo08.setCor(validandoCor(scanner));
                veiculo08.setValorDeMercado(validandoValorDeMercado(scanner));
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo08 veiculo08 : veiculo08s){
            if (veiculo08.toString().contains(placa)){
                veiculo08.registrarPagamentoIPVA();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }
}
