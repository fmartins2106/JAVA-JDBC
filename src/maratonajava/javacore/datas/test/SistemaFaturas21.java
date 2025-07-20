package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas21 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura21> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta21 calculadoraMulta21 = new MultaPercentualPorDia21(1.5);
        System.out.println("Idiomas [en | pt]:");
        bundle = Mensagens21.carregar(scanner.nextLine());
        int opcao = 0;
        do {
            System.out.println("\n"+bundle.getString("menu.opcao"));
            System.out.println("[1] "+bundle.getString("menu.1"));
            System.out.println("[2] "+bundle.getString("menu.2"));
            System.out.println("[3] "+bundle.getString("menu.3"));
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroFatura();
                    break;
                case 2:
                    listarFaturasCadastradas(calculadoraMulta21);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Digite um opção válida.");
            }
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    public static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura21.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura21.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura21.validandoDataVencimento();

        Fatura21 fatura21 = new Fatura21(numero,valor,vencimento);

        faturasCadastradas.add(fatura21);
        System.out.println("Fatura cadastrada com sucesso.");
    }

    public static void listarFaturasCadastradas(CalculadoraMulta21 calculadoraMulta21){
        if (faturasCadastradas.isEmpty()){
            System.out.println();
            return;
        }
        for (Fatura21 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta21.calcular(faturasCadastrada);
            faturasCadastrada.exibirResumoFatura(bundle,multa);
        }
    }


}
