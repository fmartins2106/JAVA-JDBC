package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas22 {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Fatura22> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta22 calculadoraMulta22 = new MultaPercentualPorDia22(1.5);
        System.out.println("Idiomas [pt | en]:");
        bundle = Mensagens22.carregar(scanner.nextLine());
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
                System.out.println(e.getMessage());
            }
            switch (opcao){
                case 1:
                    cadastroFatura();
                    break;
                case 2:
                    listarFaturas(calculadoraMulta22);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 3);
        System.out.println(">>Finalizando sistema.");
    }

    private static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura22.validandoNumeroFatura();
        double preco = ValidadorDeEntradasFatura22.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura22.validandoDataVencimento();
        Fatura22 fatura22 = new Fatura22(numero,preco,vencimento);

        faturasCadastradas.add(fatura22);
        System.out.println("Fatura cadastrada com sucesso.");
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura22.sugerirNovaDataVencimento());
    }

    private static void listarFaturas(CalculadoraMulta22 calculadoraMulta22){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura22 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta22.calcular(faturasCadastrada);
            faturasCadastrada.exibirDadosFatura(bundle,multa);
        }
    }

}
