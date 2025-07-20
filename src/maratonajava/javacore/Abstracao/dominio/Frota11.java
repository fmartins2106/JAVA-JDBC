package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota11 {
    private List<Veiculo11>veiculo11s;

    public Frota11(){
        this.veiculo11s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo11.validacaoPlaca(placa);
                return placa;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoAnoFabricacao(Scanner scanner){
        while (true){
            try {
                System.out.print("Ano fabricacao:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo11.validacaoAnoFabricacao(anoFabricacao);
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
                Veiculo11.validacaoCor(cor);
                return Veiculo11.formatoString(cor);
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
                Veiculo11.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para valor de mercado.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo11 veiculo11){
        veiculo11s.add(veiculo11);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo11s.isEmpty()){
            System.out.println("Lista vazia, nenhum veiculo foi cadastrado.");
        }else {
            for (Veiculo11 veiculo11 : veiculo11s) {
                System.out.println("__________________________");
                veiculo11.exibirDetalhes();
                System.out.println("__________________________");
            }
        }
    }

    public void pesquisaDadosVeiculoPorPlaca(Scanner scanner){
         System.out.print("Placa:");
         String placa = scanner.nextLine().trim();
         if (placa.isEmpty()){
             System.out.println("Digite uma placa no formato AAA0000 ou AAA0A00.");
             return;
         }
         if (veiculo11s == null || veiculo11s.isEmpty()){
             System.out.println("Nenhum veiculo cadastrado.");
             return;
         }
         boolean placaEncontrada = false;
        for (Veiculo11 veiculo11 : veiculo11s) {
            if (veiculo11.getPlaca().equalsIgnoreCase(placa)){
                placaEncontrada = true;
                veiculo11.exibirDetalhes();
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
        if (veiculo11s == null || veiculo11s.isEmpty()){
            System.out.println("Nenhum veiculo cadastrado.");
            return;
        }
        for (Veiculo11 veiculo11 : veiculo11s) {
            if (veiculo11.getPlaca().equalsIgnoreCase(placa)){
                veiculo11.mostrarHistoricoIPVA();
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
        if (veiculo11s == null || veiculo11s.isEmpty()){
            System.out.println("Lista vazia. Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo11 veiculo11 : veiculo11s) {
            if (veiculo11.getPlaca().equalsIgnoreCase(placa)){
                veiculo11.registrarPagamentoIPVA();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void excluiirDadosVeiculos(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite uma placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo11s == null || veiculo11s.isEmpty()){
            System.out.println("Nenhum veiculo foi cadastrado.");
            return;
        }
        for (Veiculo11 veiculo11 : veiculo11s) {
            if (veiculo11.getPlaca().equalsIgnoreCase(placa)){
                veiculo11s.remove(veiculo11);
                System.out.println("Dados removidos com sucesso.");
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void alterarDadosVeiculo(Scanner scanner){
        System.out.print("Placa:");
        String placa = scanner.nextLine().trim();
        if (placa.isEmpty()){
            System.out.println("Digite placa no formato AAA0000 ou AAA0A00.");
            return;
        }
        if (veiculo11s == null || veiculo11s.isEmpty()){
            System.out.println("Lista vazia, nenhum veiculo cadastrado.");
            return;
        }
        for (Veiculo11 veiculo11 : veiculo11s) {
            if (veiculo11.getPlaca().equalsIgnoreCase(placa)){
                veiculo11.setPlaca(validandoPlaca(scanner));
                veiculo11.setAnoFabricacao(validandoAnoFabricacao(scanner));
                veiculo11.setCor(validandoCor(scanner));
                veiculo11.setValorDeMercado(validandoValorDeMercado(scanner));
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

}
