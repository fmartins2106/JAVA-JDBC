package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota05 {
    private List<Veiculo05> veiculo05s;

    public Frota05(){
        this.veiculo05s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo05.validacaoPlaca(placa);
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
                Veiculo05.validacaoAno(anoFabricacao);
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
                Veiculo05.validacaoCor(cor);
                return Veiculo05.formatoString(cor);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoValorDeMercado(Scanner scanner){
        while (true){
            try {
                System.out.print("Valor de mercado:");
                double valorDeMercado = Double.parseDouble(scanner.nextLine());
                Veiculo05.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo05 veiculo05){
        veiculo05s.add(veiculo05);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo05s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (Veiculo05 veiculo05 : veiculo05s){
                System.out.println("__________________________");
                veiculo05.exibirDetalhes();
                System.out.println("__________________________");
            }
        }
    }

    public void exibirHistoricoIPVA(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo05 veiculo05 : veiculo05s){
            if (veiculo05.toString().contains(placa)){
                veiculo05.mostrarHistoricoIPVA();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void pesquisaPorPlaca(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo05 veiculo05 : veiculo05s){
            if (veiculo05.toString().contains(placa)){
                veiculo05.exibirDetalhes();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void excluirDados(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo05 veiculo05 : veiculo05s){
            if (veiculo05.toString().contains(placa)){
                veiculo05s.remove(veiculo05);
                System.out.println("Dados removidos com sucesso.");
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void alterarDadoVeiculos(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo05 veiculo05 : veiculo05s){
            if (veiculo05.toString().contains(placa)){
                veiculo05.setPlaca(validandoPlaca(scanner));
                veiculo05.setAno(validandoAnoFabricacao(scanner));
                veiculo05.setCor(validandoCor(scanner));
                veiculo05.setValorDeMercado(validandoValorDeMercado(scanner));
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo05 veiculo05 : veiculo05s){
            if (veiculo05.getPlaca().equalsIgnoreCase(placa)){
                veiculo05.registrarPagamentoIPVA();
                System.out.println("Pagamento de IPVA registrado com sucesso.");
                return;
            }
        }
        System.out.println("Placa não encontrado.");
    }


}







