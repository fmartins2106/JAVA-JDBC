package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota01 {
    private List<Veiculo01> veiculo01s;

    public Frota01(){
        this.veiculo01s = new ArrayList<>();
    }

    public static String validandoPlaca(Scanner scanner){
        while (true){
            try {
                System.out.print("Placa:");
                String placa = scanner.nextLine().trim();
                Veiculo01.validacaoPlaca(placa);
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
                Veiculo01.validacaoAnoFabricacao(anoFabricacao);
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
                Veiculo01.validacaoCor(cor);
                return Veiculo01.formatoNome(cor);
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
                Veiculo01.validacaoValorDeMercado(valorDeMercado);
                return valorDeMercado;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addVeiculos(Veiculo01 veiculo01){
        veiculo01s.add(veiculo01);
    }

    public void listaVeiculosCadastrado(){
        if (veiculo01s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (Veiculo01 veiculo01 : veiculo01s){
                veiculo01.exibirDetalhes();
                System.out.println("__________________________________");
            }
        }
    }

    public void exibirHistoricoIPVA(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo01 veiculo01 : veiculo01s){
            if (veiculo01.toString().contains(placa)){
                veiculo01.mostrarHistoricoIPVA();
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }


    public void pesquisaPorPlaca(Scanner scanner){
        String placa = validandoPlaca(scanner);
        boolean placaEncontrada = false;
        for (Veiculo01 veiculo01 : veiculo01s){
            if (veiculo01.toString().contains(placa)){
                placaEncontrada = true;
                veiculo01.exibirDetalhes();
            }
        }
        if (!placaEncontrada){
            System.out.println("Placa não encontrada.");
        }
    }

    public void excluirDadosVeiculo(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo01 veiculo01 : veiculo01s){
            if (veiculo01.toString().contains(placa)){
                veiculo01s.remove(veiculo01);
                System.out.println("Dados excluidos com sucesso.");
                return;
            }
        }
        System.out.println("Placa não encontrada.");
    }

    public void alterarDadosVeiculos(Scanner scanner){
        String placa = validandoPlaca(scanner);
        for (Veiculo01 veiculo01 : veiculo01s){
            if (veiculo01.toString().contains(placa)){
                veiculo01.setPlaca(validandoPlaca(scanner));
                veiculo01.setAnoFabricacao(validandoAnoFabricacao(scanner));
                veiculo01.setCor(validandoCor(scanner));
            }
        }
    }
    public void registrarPagamentoIPVA(Scanner scanner, Frota01 frota01) {
        String placa = Frota01.validandoPlaca(scanner);  // Solicita a placa
        for (Veiculo01 veiculo : frota01.getVeiculo01s()) {
            if (veiculo.toString().contains(placa)) {  // Verifica se a placa corresponde a algum veículo
                veiculo.registrarPagamentoIPVA();  // Registra o pagamento do IPVA
                System.out.println("Pagamento de IPVA registrado com sucesso!");
                return;  // Se o pagamento for registrado, sai do método
            }
        }
        System.out.println("Veículo não encontrado.");  // Se não encontrar o veículo com a placa fornecida
    }

    public List<Veiculo01> getVeiculo01s() {
        return veiculo01s;
    }
}
