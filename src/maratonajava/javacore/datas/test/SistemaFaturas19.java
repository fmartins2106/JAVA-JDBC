package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas19 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura19> faturas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta19 calculadoraMulta19 = new MultaPercentualPorDia19(1.5);
        System.out.print("Idiomas [en | pt]:");
        bundle = Mensagens19.carregar(scanner.nextLine());
        int opcao = 0;
        do {
            System.out.println("\n"+ bundle.getString("menu.opcao"));
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
                    listarFaturas(calculadoraMulta19);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 3);
        System.out.println(">>>>Finalizando sistema.");
    }

    public static void cadastroFatura(){
        String numero = ValidadorDeEntradaFatura19.validandoNumero();
        double valor = ValidadorDeEntradaFatura19.validandoValor();
        LocalDate vencimento = ValidadorDeEntradaFatura19.validandoVencimento();

        Fatura19 fatura19 = new Fatura19(numero,valor,vencimento);

        faturas.add(fatura19);
        System.out.println("Fatura cadastrada com sucesso.");
    }

    public static void listarFaturas(CalculadoraMulta19 calculadoraMulta19){
        if (faturas.isEmpty()){
            System.out.println("Nenhuma fatura foi cadastrada.");
            return;
        }
        for (Fatura19 fatura : faturas) {
            double multa = calculadoraMulta19.calcular(fatura);
            fatura.exibirDadosFatura(bundle,multa);
        }
    }

}
