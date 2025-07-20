package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas02 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura02> fatura02 = new ArrayList<>();
    private static ResourceBundle bundle;
    public static void main(String[] args) {
        System.out.print("Idiomas [pt/en]:");
        bundle = Mensagens02.carregar(scanner.nextLine());

        CalculadoraMulta02 calculadoraMulta02 = new MultaPercentualPorDia02(2.00);
        int opcao = 0;
        do {
            System.out.println("\n" + bundle.getString("menu.opcao"));
            System.out.println("1 -"+ bundle.getString("menu.1"));
            System.out.println("2 -"+ bundle.getString("menu.2"));
            System.out.println("3 -"+ bundle.getString("menu.3"));
            System.out.println("4 -"+ bundle.getString("menu.4"));
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
                    listarFaturas(calculadoraMulta02);
                    break;
                case 3:
                    System.out.println("Data hora atual:"+LocalDate.now());
                    break;

            }
        }while (opcao != 4);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void cadastrarFatura(){
        String numeroFatura = ValidadorDeEntradasFatura02.validandoNumeroFatura();
        double valorFatura = ValidadorDeEntradasFatura02.validandoValorFatura();
        LocalDate vencimentoFatura = ValidadorDeEntradasFatura02.validandoVencimento();

        Fatura02 fatura = new Fatura02(numeroFatura,valorFatura,vencimentoFatura);
        fatura02.add(fatura);

        System.out.println("Vencimento sugerido para próxima fatura:"+fatura.SugerirNovoVencimento());
    }

    private static void listarFaturas(CalculadoraMulta02 calculadoraMulta02){
        if (fatura02.isEmpty()){
            System.out.println("Nenhuma fatura foi cadastrada.");
            return;
        }
        for (Fatura02 fatura021 : fatura02) {
            double multa = calculadoraMulta02.calcular(fatura021);
            fatura021.exibirResumo(bundle,multa);
        }
    }

}
