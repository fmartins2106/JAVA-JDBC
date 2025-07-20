package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota12 {
    private List<Veiculo12> veiculo12s;

    public Frota12(){
        this.veiculo12s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo12.validacaoPlaca(placa);
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
                Veiculo12.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para ano de fabricação.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCor(Scanner scanner){
        while (true){
            try {
                System.out.print("Cor:");
                String cor = scanner.nextLine();
                Veiculo12.validacaoCor(cor);
                return Veiculo12.formatoString(cor);
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
                Veiculo12.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para valor de mercado.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo12 veiculo12){
        veiculo12s.add(veiculo12);
    }

    public void listarVeiculos(){
        if (veiculo12s.isEmpty()){
            System.out.println("Lista vazia. Nenhum veiculo cadastrado.");
        }else {
            for (Veiculo12 veiculo12 : veiculo12s) {
                System.out.println("__________________________");
                veiculo12.exibirDetalhes();
                System.out.println("__________________________");
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
        if (veiculo12s == null || veiculo12s.isEmpty()){
            System.out.println("Nenhm veiculo cadastrado.");
            return;
        }
        for (Veiculo12 veiculo12 : veiculo12s) {
            if (veiculo12.getPlaca().equalsIgnoreCase(placa)){
                veiculo12.exibirDetalhes();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void excluirDadosVeiculo(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite uma placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo12s == null || veiculo12s.isEmpty()){
            System.out.println("Nenhum veiculo foi encontrado.");
            return;
        }
        for (Veiculo12 veiculo12 : veiculo12s) {
            if (veiculo12.getPlaca().equalsIgnoreCase(placa)){
                veiculo12s.remove(veiculo12);
                System.out.println("Dados veiculo removido com sucesso.");
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite uma placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo12s == null || veiculo12s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
            return;
        }
        for (Veiculo12 veiculo12 : veiculo12s) {
            if (veiculo12.getPlaca().equalsIgnoreCase(placa)){
                veiculo12.registrarPagamentoIPVA();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void mostrarHistoricoPagamento(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite uma placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo12s == null || veiculo12s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo12 veiculo12 : veiculo12s) {
            if (veiculo12.getPlaca().equalsIgnoreCase(placa)){
                veiculo12.mostrarHistoricoIPVA();
                return;
            }
        }
        System.out.println("Digite um número de placa válido.");
    }

    public void alterarDadosVeiculo(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite uma placa no formato AAA0000 ou AAAOAOO.");
            return;
        }
        if (veiculo12s ==null || veiculo12s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo12 veiculo12 : veiculo12s) {
            if (veiculo12.getPlaca().equalsIgnoreCase(placa)){
                veiculo12.setPlaca(validandoPlaca(scanner));
                veiculo12.setAnoFabricacao(validandoAnoFabricacao(scanner));
                veiculo12.setCor(validandoCor(scanner));
                veiculo12.setValorDeMercado(validandoValorDeMercado(scanner));
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

}


