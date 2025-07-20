package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas23 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura23> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta23 calculadoraMulta23 = new MultaPercentualPorDia23(0.5);
        System.out.print("Idiomas [en | pt]:");
        bundle = Mensagens23.carregar(scanner.nextLine());
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
                System.out.println("Erro. Digite um número válida de opção.");
            }
            switch (opcao){
                case 1:
                    cadastroFatura();
                    break;
                case 2:
                    listarFaturasCadastrada(calculadoraMulta23);
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
        String numero = ValidadorDeEntradasFatura23.validandoNumero();
        double valor = ValidadorDeEntradasFatura23.validandoValor();
        LocalDate vencimento = ValidadorDeEntradasFatura23.validandoDataVencimento();
        Fatura23 fatura23 = new Fatura23(numero,valor, vencimento);

        faturasCadastradas.add(fatura23);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura23.sugerirNovaDataVencimento());
    }

    private static void listarFaturasCadastrada(CalculadoraMulta23 calculadoraMulta23){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura23 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta23.calcular(faturasCadastrada);
            faturasCadastrada.exibirDadosFatura(bundle,multa);
        }
    }


}
