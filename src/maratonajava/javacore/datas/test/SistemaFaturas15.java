package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas15 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura15> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta15 calculadoraMulta15 = new MultaFixadaPorDia15(2.00);
        System.out.print("Idiomas [en | pt]:");
        bundle = Mensagens15.carregar(scanner.nextLine());
        int opcao = 0;
        do {
            System.out.println("\n"+bundle.getString("menu.opcao"));
            System.out.println("1 - "+ bundle.getString("menu.1"));
            System.out.println("2 - "+ bundle.getString("menu.2"));
            System.out.println("3 - "+ bundle.getString("menu.3"));
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastrarFatura();
                    break;
                case 2:
                  listarFaturas(calculadoraMulta15);
                  break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    public static void cadastrarFatura(){
        String numero = ValidadorDeEntradasFatura15.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura15.validandoValor();
        LocalDate vencimento = ValidadorDeEntradasFatura15.validandoVencimento();

        Fatura15 fatura15 = new Fatura15(numero,valor,vencimento);
        faturasCadastradas.add(fatura15);

        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura15.sugerirNovoVencimento());
    }

    public static void listarFaturas(CalculadoraMulta15 calculadoraMulta15){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhuma fatura registrada.");
            return;
        }
        for (Fatura15 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta15.calcular(faturasCadastrada);
            faturasCadastrada.exibirResumo(bundle,multa);
        }
    }

}
