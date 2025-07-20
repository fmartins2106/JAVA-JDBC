package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota13 {
    private List<Veiculo13> veiculo13s;

    public Frota13(){
        this.veiculo13s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo13.validacaoPlaca(placa);
                return placa.toUpperCase();
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
                Veiculo13.validacaoAnoFabricacao(anoFabricacao);
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
                Veiculo13.validacaoCor(cor);
                return Veiculo13.formatoString(cor);
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
                Veiculo13.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculos(Veiculo13 veiculo13){
        veiculo13s.add(veiculo13);
    }

    public void listarVeiculos(){
        if (veiculo13s.isEmpty()){
            System.out.println("Lista vazia. Nenhum veiculo foi cadastrado.");
        }else {
            for (Veiculo13 veiculo13 : veiculo13s) {
                System.out.println("________________________");
                veiculo13.exibirDetalhes();
                System.out.println("________________________");
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
        if (veiculo13s ==  null || veiculo13s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado até o momento.");
            return;
        }
        for (Veiculo13 veiculo13 : veiculo13s) {
            if (veiculo13.getPlaca().equalsIgnoreCase(placa)){
                veiculo13.exibirDetalhes();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void alterarDadosVeiculo(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite uma placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo13s == null || veiculo13s.isEmpty()){
            System.out.println("Nenhum veiculo foi registrado.");
            return;
        }
        for (Veiculo13 veiculo13 : veiculo13s) {
            if (veiculo13.getPlaca().equalsIgnoreCase(placa)){
                Veiculo13.placasCadastradas.remove(placa);
                veiculo13.setPlaca(validandoPlaca(scanner));
                veiculo13.setAnoFabricacao(validandoAnoFabricacao(scanner));
                veiculo13.setCor(validandoCor(scanner));
                veiculo13.setValorDeMercado(validandoValorDeMercado(scanner));
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void excluirDadosVeiculo(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo13s == null || veiculo13s.isEmpty()){
            System.out.println("Nenhum número de placa foi encontrado.");
            return;
        }
        for (Veiculo13 veiculo13 : veiculo13s) {
            veiculo13s.remove(veiculo13);
            Veiculo13.placasCadastradas.remove(placa);
            System.out.println("Dadores removidos com sucesso.");
            return;
        }
        System.out.println("Placa não encontrada.");
    }

    public void historicoPagamentoIPVA(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite um número de placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo13s == null || veiculo13s.isEmpty()){
            System.out.println("Nenhuma placa foi encontrada.");
            return;
        }
        for (Veiculo13 veiculo13 : veiculo13s) {
            if (veiculo13.getPlaca().equalsIgnoreCase(placa)){
                veiculo13.mostrarHistoricoIPVA();
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
        if (veiculo13s == null || veiculo13s.isEmpty()){
            System.out.println("Nenhuma placa foi cadastrada.");
            return;
        }
        for (Veiculo13 veiculo13 : veiculo13s) {
            if (veiculo13.getPlaca().equalsIgnoreCase(placa)){
                veiculo13.registrarHistoricoIPVA();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }
}
