package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas17 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura17> faturas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta17 calculadoraMulta17 = new MultaPercentualPorDia17(2.00);
        System.out.print("Idiomas [en | pt]:");
        bundle = Mensagens17.carregar(scanner.nextLine());
        int opcao = 0;
        do {
            System.out.println("\n"+bundle.getString("menu.opcao"));
            System.out.println("1 - "+bundle.getString("menu.1"));
            System.out.println("2 - "+bundle.getString("menu.2"));
            System.out.println("3 - "+bundle.getString("menu.3"));
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
                    listarFaturas(calculadoraMulta17);
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
        String numero = ValidadorDeEntradasFatura17.validandoNumero();
        double preco = ValidadorDeEntradasFatura17.validandoValor();
        LocalDate vencimento = ValidadorDeEntradasFatura17.validandoDataVencimento();
        Fatura17 fatura17 = new Fatura17(numero,preco,vencimento);
        faturas.add(fatura17);
        System.out.println("Fatura cadastrada com sucesso.");
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura17.sugerirNovoVencimento());
    }

    public static void listarFaturas(CalculadoraMulta17 calculadoraMulta17){
        if (faturas.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura17 fatura : faturas) {
            double multa = calculadoraMulta17.calcular(fatura);
            fatura.exibirResumo(bundle,multa);
        }
    }
}
