package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas24 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura24> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta24 calculadoraMulta24 = new MultaPercentualPorDia24(0.005);
        System.out.print("Idiomas [pt - en]:");
        bundle = Mensagens24.carregar(scanner.nextLine());
        int opcao = 0;
        do {
            System.out.println("\n"+bundle.getString("menu.opcao"));
            System.out.println("[1] "+bundle.getString("menu.1"));
            System.out.println("[2] "+bundle.getString("menu.2"));
            System.out.println("[3] "+bundle.getString("menu.3"));
            opcao = Integer.parseInt(scanner.nextLine().trim());
            switch (opcao){
                case 1:
                    cadastroFatura();
                    break;
                case 2:
                    listarFaturasCadastradas(calculadoraMulta24);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void cadastroFatura(){
        String numeroFatura = ValidadorDeEntradasFatura24.validacaoNumeroFatura();
        double valorFatura = ValidadorDeEntradasFatura24.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura24.validandoDataVencimento();

        Fatura24 fatura24 = new Fatura24(numeroFatura,valorFatura,vencimento);
        faturasCadastradas.add(fatura24);

        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura24.sugerirProximoVencimentoFatura());
    }

    private static void listarFaturasCadastradas(CalculadoraMulta24 calculadoraMulta24){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura24 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta24.calcular(faturasCadastrada);
            faturasCadastrada.exibirDadosFatura(bundle,multa);
        }
    }

}
