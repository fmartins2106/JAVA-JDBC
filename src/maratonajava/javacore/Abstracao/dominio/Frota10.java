package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota10 {
    private List<Veiculo10> veiculo10s;

    public Frota10(){
        this.veiculo10s = new ArrayList<>();
    }

    public static String validandoFormatoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo10.validacaoPlaca(placa);
                return placa;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano de fabricação:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo10.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
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
                Veiculo10.validacaoCor(cor);
                return Veiculo10.formatoString(cor);
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
                Veiculo10.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para valor de mercado.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo10 veiculo10){
        veiculo10s.add(veiculo10);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (Veiculo10 veiculo10 : veiculo10s) {
                System.out.println("___________________________");
                veiculo10.exibirDetalhes();
                System.out.println("___________________________");
            }
        }
    }

    public void pesquisaPorPlaca(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite uma placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo10s == null || veiculo10s.isEmpty()){
            System.out.println("Nenhum veículo cadastrado.");
            return;
        }
        boolean placaEncontrada = false;
        for (Veiculo10 veiculo10 : veiculo10s){
            if (veiculo10.getPlaca().equalsIgnoreCase(placa)){
                placaEncontrada = true;
                veiculo10.exibirDetalhes();
            }
        }
        if (!placaEncontrada){
            System.out.println("Placa não encontrada.");
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite uma placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo10s == null || veiculo10s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
            return;
        }
        boolean placaEncontrada = false;
        for (Veiculo10 veiculo10 : veiculo10s) {
            if (veiculo10.toString().contains(placa)){veiculo10s.remove(veiculo10);
                placaEncontrada = true;
                System.out.println("Dados removido coms sucesso.");

            }
        }
        if (!placaEncontrada){
            System.out.println("Placa não encontrada.");
        }
    }

    public void alterarDados(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite uma placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo10s == null || veiculo10s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
            return;
        }
        boolean placaEncontrada = false;
        for (Veiculo10 veiculo10 : veiculo10s) {
            if (veiculo10.getPlaca().equalsIgnoreCase(placa)){
                placaEncontrada = true;
                veiculo10.setPlaca(validandoFormatoPlaca(scanner));
                veiculo10.setAnoFabricacao(validandoAnoFabricacao(scanner));
                veiculo10.setCor(validandoCor(scanner));
                veiculo10.setValorDeMercado(validandoValorDeMercado(scanner));
            }
        }
        if (!placaEncontrada){
            System.out.println("Placa não encontrada.");
        }
    }

    public void exibirHistoricoIPVA(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite uma placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo10s == null || veiculo10s.isEmpty()){
            System.out.println("Nenhum veiculo foi encontrado.");
            return;
        }
        boolean placaEncontrada = false;
        for (Veiculo10 veiculo10 : veiculo10s) {
            if (veiculo10.toString().contains(placa)){
                placaEncontrada = true;
                veiculo10.mostrarHistoricoIPVA();
            }
        }
        if (!placaEncontrada){
            System.out.println("Placa não encontrada.");
        }
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite uma placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo10s == null || veiculo10s.isEmpty()){
            System.out.println("Nenhum veículo foi encontrado.");
            return;
        }
        boolean placaEncontrada = false;
        for (Veiculo10 veiculo10 : veiculo10s) {
            if (veiculo10.toString().contains(placa)){
                placaEncontrada = true;
                veiculo10.registrarPagamentoIPVA();
            }
        }
        if (!placaEncontrada){
            System.out.println("Placa não encontrada.");
        }

    }
}
