package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota07 {
    private List<Veiculo07> veiculo07s;

    public Frota07(){
        this.veiculo07s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo07.validacaoPlaca(placa);
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
                Veiculo07.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para ano.");
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
                Veiculo07.validacaoCor(cor);
                return Veiculo07.formatoString(cor);
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
                Veiculo07.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo07 veiculo07){
        veiculo07s.add(veiculo07);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo07s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (Veiculo07 veiculo07 : veiculo07s){
                System.out.println("___________________");
                veiculo07.exibirDetalhes();
                System.out.println("___________________");
            }
        }
    }

    public void exibirHistoricoIPVA(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo07 veiculo07 : veiculo07s){
            if (veiculo07.toString().contains(placa)){
                veiculo07.mostrarHistoricoIPVA();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void pesquisaPorPlaca(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo07 veiculo07 : veiculo07s){
            if (veiculo07.toString().contains(placa)){
                veiculo07.exibirDetalhes();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void excluirDados(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo07 veiculo07 : veiculo07s){
            if (veiculo07.toString().contains(placa)){
                veiculo07s.remove(veiculo07);
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void alterarDadosVeiculo(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo07 veiculo07 : veiculo07s){
            if (veiculo07.toString().contains(placa)){
                veiculo07.setPlaca(validandoPlaca(scanner));
                veiculo07.setAnoFabricacao(validandoAnoFabricacao(scanner));
                veiculo07.setCor(validandoCor(scanner));
                veiculo07.setValorDeMercado(validandoValorDeMercado(scanner));
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo07 veiculo07 : veiculo07s){
            if (veiculo07.toString().contains(placa)){
                veiculo07.registrarPagamentoIPVA();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }
}
