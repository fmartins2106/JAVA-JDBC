package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota09 {
    private List<Veiculo09> veiculo09s;

    public Frota09(){
        this.veiculo09s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo09.validacaoPlaca(placa);
                return placa.toUpperCase();
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoDeFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo09.validacaoAnoFabricacao(anoFabricacao);
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
                Veiculo09.validacaoCor(cor);
                return Veiculo09.formatoString(cor);
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
                Veiculo09.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculos(Veiculo09 veiculo09){
        veiculo09s.add(veiculo09);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (Veiculo09 veiculo09 : veiculo09s){
                System.out.println("___________________");
                veiculo09.exibirDetalhes();
                System.out.println("___________________");
            }
        }
    }

    public void pesquisaPorPlaca(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (veiculo09s == null || veiculo09s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
        }else{
            for (Veiculo09 veiculo09 : veiculo09s){
                if (veiculo09 != null && veiculo09.toString().contains(placa)){
                    veiculo09.exibirDetalhes();
                    return;
                }
            }
            System.out.println("Veiculo não encontrado.");
        }
    }

    public void exibirHistoricoIPVA(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (veiculo09s == null || veiculo09s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
        }else{
            for (Veiculo09 veiculo09 : veiculo09s) {
                if (veiculo09 != null && veiculo09.toString().contains(placa)){
                    veiculo09.mostrarHistoricoIPVA();
                    return;
                }
            }
            System.out.println("Placa não encontrada.");
        }
    }

    public void excluirVeiculoCadastrado(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (veiculo09s == null || veiculo09s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
        }else{
            for (Veiculo09 veiculo09 : veiculo09s) {
                if (veiculo09 != null && veiculo09.toString().contains(placa)){
                    veiculo09s.remove(veiculo09);
                    System.out.println("Dados removidos com sucesso.");
                    return;
                }
            }
            System.out.println("Placa não encontrada.");
        }
    }

    public void alterarDadosVeiculo(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (veiculo09s == null || veiculo09s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
        }else{
            for (Veiculo09 veiculo09 : veiculo09s) {
                if (veiculo09 != null && veiculo09.toString().contains(placa)){
                    veiculo09.setPlaca(validandoPlaca(scanner));
                    veiculo09.setAnoFabricacao(validandoAnoDeFabricacao(scanner));
                    veiculo09.setCor(validandoCor(scanner));
                    veiculo09.setValorDeMercado(validandoValorDeMercado(scanner));
                    return;
                }
            }
            System.out.println("Placa não encontrada.");
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (veiculo09s == null || veiculo09s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
        }else {
            for (Veiculo09 veiculo09 : veiculo09s) {
                if (veiculo09 != null && veiculo09.getPlaca().equalsIgnoreCase(placa)){
                    veiculo09.registrarPagamentoIPVA();
                    return;
                }
            }
            System.out.println("Placa não encontrada.");
        }
    }

}
