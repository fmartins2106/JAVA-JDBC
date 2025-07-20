package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota06 {
    private List<Veiculo06> veiculo06s;

    public Frota06(){
        this.veiculo06s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo06.validacaoPlaca(placa);
                return placa;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int anoFabricacao = Integer.parseInt(scanner.nextLine());
                Veiculo06.validacaoAnoFabricacao(anoFabricacao);
                return anoFabricacao;
            }catch (NumberFormatException e){
                System.out.println("Digite um ano válido.");
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
                Veiculo06.validacaoCor(cor);
                return Veiculo06.formatoString(cor);
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
                Veiculo06.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculo(Veiculo06 veiculo06){
        veiculo06s.add(veiculo06);
    }

    public void listaVeiculosCadastrados(){
        if (veiculo06s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (Veiculo06 veiculo06 : veiculo06s){
                System.out.println("___________________________");
                veiculo06.exibirDetalhes();
                System.out.println("___________________________");
            }
        }
    }

    public void exibirHistoricoIPVA(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo06 veiculo06 : veiculo06s){
            if (veiculo06.toString().contains(placa)){
                veiculo06.mostrarHistoricoIPVA();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void pesquisaPorPlaca(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo06 veiculo06 : veiculo06s){
            if (veiculo06.toString().contains(placa)){
                veiculo06.exibirDetalhes();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void excluirDados(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo06 veiculo06 : veiculo06s){
            if (veiculo06.toString().contains(placa)){
                veiculo06s.remove(veiculo06);
                System.out.println("Dados removidos com sucesso.");
                return;
            }
        }
        System.out.println("Número de placa não encontrado.");
    }

    public void alterarDadosVeiculo(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo06 veiculo06 : veiculo06s){
            if (veiculo06.toString().contains(placa)){
                veiculo06.setPlaca(validandoPlaca(scanner));
                veiculo06.setAno(validandoIdade(scanner));
                veiculo06.setCor(validandoCor(scanner));
                veiculo06.setValorDeMercado(validandoValorDeMercado(scanner));
            }
        }
        System.out.println("Número de placa não encontrado.");
    }

    public void registrarPagamentoIPVA(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo06 veiculo06 : veiculo06s){
            if (veiculo06.toString().contains(placa)){
                veiculo06.registrarPagamentoIPVA();
                System.out.println("Pagamento de IPVA registrado com sucesso.");
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }
}
