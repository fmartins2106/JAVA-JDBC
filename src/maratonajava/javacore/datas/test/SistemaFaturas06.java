package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas06 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura06> faturas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        System.out.print("Idioma [pt/en]:");
        bundle = Mensagens06.carregar(scanner.nextLine());

        CalculadoraMulta06 calculadoraMulta06 = new MultaPercentualPorDia06(2.00);
        int opcao = 0;
        do {
            System.out.println("\n" + bundle.getString("menu.opcao"));
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
                    listarFaturas(calculadoraMulta06);
            }
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void cadastrarFatura(){
        String numero = ValidadorDeEntradasFatura06.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura06.validandoValor();
        LocalDate vencimento = ValidadorDeEntradasFatura06.validandoDataVencimento();

        Fatura06 fatura06 = new Fatura06(numero,valor,vencimento);
        faturas.add(fatura06);

        System.out.println("Vencimento sigerido para próxima fatura:"+fatura06.sugerirNovoVencimento());
    }

    private static void listarFaturas(CalculadoraMulta06 calculadoraMulta06){
        if (faturas.isEmpty()){
            System.out.println("Nenhuma fatura foi cadastrada.");
            return;
        }
        for (Fatura06 fatura : faturas) {
            double multa = calculadoraMulta06.calcular(fatura);
            fatura.exibirResumo(bundle, multa);
        }
    }
}
