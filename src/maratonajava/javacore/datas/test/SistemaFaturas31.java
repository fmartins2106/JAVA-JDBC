
package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas31 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura31> fatura31 = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta31 calculadoraMulta31 = new MultaPercentualPorDia31(1);
        CalculadoraMulta31 calculadoraMulta32 = new MultaPorDia31(1);
        escolherIdioma();
        int opcao = 0;
        do {
            exibirMenu();
            opcao = getOpcao();
            metodoOpcoes(opcao,calculadoraMulta31,calculadoraMulta32);
        }while(opcao != 3);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void metodoOpcoes(int opcao, CalculadoraMulta31 calculadoraMulta32, CalculadoraMulta31 calculadoraMulta31){
        switch (opcao){
            case 1:
                cadastroFatura();
                break;
            case 2:
                listarFaturasCadastradas(calculadoraMulta31,calculadoraMulta32);
                break;
            case 3:
                break;
            default:
                System.out.println("Erro, digite uma opção válida.");
        }
    }

    private static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura31.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura31.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura31.validandoDataVencimento();
        Fatura31 fatura32 = new Fatura31(numero,valor,vencimento);
        fatura31.add(fatura32);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura32.sugestaoVencimentoProximaFatura());
    }

    private static void listarFaturasCadastradas(CalculadoraMulta31 calculadoraMulta31, CalculadoraMulta31 calculadoraMulta32){
        if (fatura31.isEmpty()){
            System.out.println("Nenhum fatura foi cadastrada");
            return;
        }
        for (Fatura31 fatura311 : fatura31) {
            double multa = calculadoraMulta31.calcular(fatura311) + calculadoraMulta31.calcular(fatura311);
            fatura311.exibirFatura(bundle,multa);
        }


    }

    private static int getOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro, digite um número válido.");
            }
        }
    }

    private static void escolherIdioma(){
        String idiomas = "";
        do {
            System.out.print("Idiomas [pt | en]:");
            idiomas = scanner.nextLine().trim();
            bundle = Mensagens31.carregar(idiomas);
        }while (!idiomas.equalsIgnoreCase("en") && !idiomas.equalsIgnoreCase("pt"));
    }

    private static void exibirMenu(){
        System.out.println("\n"+bundle.getString("menu.opcao"));
        System.out.println("[1] -"+bundle.getString("menu.1"));
        System.out.println("[2] -"+bundle.getString("menu.2"));
        System.out.println("[3] -"+bundle.getString("menu.3"));
    }

}
