package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFatura26 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura26> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta26 calculadoraMulta26 = new MultaPercentualPorDia26(0.07);
        System.out.print("Idiomas [en - pt]:");
        bundle = Mensagens26.carregar(scanner.nextLine());
        int opcao = 0;
        do {
            System.out.println("\n"+bundle.getString("menu.opcao"));
            System.out.println("[1] -"+bundle.getString("menu.1"));
            System.out.println("[2] -"+bundle.getString("menu.2"));
            System.out.println("[3] -"+bundle.getString("menu.3"));
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }
            switch (opcao){
                case 1:
                    cadastroFatura();
                    break;
                case 2:
                    listarFaturasCadastradas(calculadoraMulta26);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }while (opcao != 3);
        System.out.println(">>>>Finalizando sistema.");
    }

    public static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura26.validandoNumeroFatura();
        double preco = ValidadorDeEntradasFatura26.validandoValor();
        LocalDate vencimento = ValidadorDeEntradasFatura26.validandoDataVencimento();
        Fatura26 fatura26 = new Fatura26(numero,preco,vencimento);
        faturasCadastradas.add(fatura26);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura26.sugestaoVencimentoProximaFatura());
    }

    public static void listarFaturasCadastradas(CalculadoraMulta26 calculadoraMulta26){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura26 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta26.calcular(faturasCadastrada);
            faturasCadastrada.exibirDadosFatura(bundle,multa);
        }
    }
}
