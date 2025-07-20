package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas25 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura25> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta25 calculadoraMulta25 = new MultaPercentualPorDia25(0.005);
        System.out.print("Idiomas [en | pt]:");
        bundle = Mensagens25.carregar(scanner.nextLine());
        int opcao = 0;
        do {
            System.out.println("\n"+ bundle.getString("menu.opcao"));
            System.out.println("[1] -"+bundle.getString("menu.1"));
            System.out.println("[2] -"+bundle.getString("menu.2"));
            System.out.println("[3] -"+bundle.getString("menu.3"));
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
                    listarFaturasCadastradas(calculadoraMulta25);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }

        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    public static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura25.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura25.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura25.validandoDataVencimento();

        Fatura25 fatura25 = new Fatura25(numero,valor,vencimento);
        faturasCadastradas.add(fatura25);
        System.out.println("Sugestão de vencimento para próxima fatura:R$"+fatura25.sugestaoProximoVencimento());
    }

    public static void listarFaturasCadastradas(CalculadoraMulta25 calculadoraMulta25){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura25 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta25.calcular(faturasCadastrada);
            faturasCadastrada.exibirDadosFatura(bundle,multa);
        }
    }

}
