package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas10 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura10> faturas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        System.out.print("Idioma [en/pt]:");
        bundle = Mensagens10.carregar(scanner.nextLine());

        CalculadoraMulta10 calculadoraMulta10 = new MultaPercentualPorDia10(2.00);
        int opcao = 0;
        do {
            System.out.println("\n"+ bundle.getString("menu.opcao"));
            System.out.println("1 - "+ bundle.getString("menu.1"));
            System.out.println("2 - "+ bundle.getString("menu.2"));
            System.out.println("3 - "+ bundle.getString("menu.3"));
            try {
                System.out.print("Digite uma das opçõe acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastrarFatura();
                    break;
                case 2:
                    listarFaturas(calculadoraMulta10);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 3);
        System.out.println(">>>>Finalizando sistema.");
    }

    public static void cadastrarFatura(){
        String nome = ValidadorDeEntradasFatura10.validandoNumero();
        double valor = ValidadorDeEntradasFatura10.validandoValor();
        LocalDate vencimento = ValidadorDeEntradasFatura10.validandoDataVencimento();

        Fatura10 fatura10 = new Fatura10(nome,valor,vencimento);

        faturas.add(fatura10);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura10.sugerirNovaDataVencimento());
    }

    private static void listarFaturas(CalculadoraMulta10 calculadoraMulta10){
        if (faturas.isEmpty()){
            System.out.println("Nenhuma fatura encontrada.");
            return;
        }
        for (Fatura10 fatura : faturas) {
            double multa = calculadoraMulta10.calcular(fatura);
            fatura.exibirResumo(bundle,multa);
        }
    }
}
