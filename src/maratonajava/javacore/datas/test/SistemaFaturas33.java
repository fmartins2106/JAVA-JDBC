
package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas33 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura33> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;
    private static final CalculadoraMulta33 calculadoraMulta33 = new MultaFixadaPorDia33(1);
    private static final CalculadoraMulta33 calculadoraMulta34 = new MultaPercentualPorDia33(1);
    public static void main(String[] args) {

        opcoesIdioma();
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
            metodoOpcoes(opcao);
        }while (opcao != 3);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void metodoOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroFatura();
                break;
            case 2:
                listarFaturas(calculadoraMulta33,calculadoraMulta34);
                break;
            case 3:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }

    private static void listarFaturas(CalculadoraMulta33 calculadoraMulta33, CalculadoraMulta33 calculadoraMulta34){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhuma fatura foi cadastrada.");
            return;
        }
        for (Fatura33 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta33.calcular(faturasCadastrada)+calculadoraMulta34.calcular(faturasCadastrada);
            faturasCadastrada.exibirFatura(bundle,multa);
        }
    }

    private static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura33.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura33.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura33.validandoDataVencimento();
        Fatura33 fatura33 = new Fatura33(numero,valor,vencimento);
        faturasCadastradas.add(fatura33);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura33.sugestaoDeVencimentoFatura());
    }

    private static void opcoesIdioma(){
        String tipoIdioma = "";
        do {
            System.out.print("Idioma [en - pt]:");
            tipoIdioma = scanner.nextLine().trim();
            bundle = Mensagens33.carregarIdiomas(tipoIdioma);
        }while (!tipoIdioma.equalsIgnoreCase("en") && !tipoIdioma.equalsIgnoreCase("pt"));
    }
    private static void exibirMenu(){
        System.out.println("\n"+bundle.getString("menu.opcao"));
        System.out.println("[1] -"+bundle.getString("menu.1"));
        System.out.println("[2] -"+bundle.getString("menu.2"));
        System.out.println("[3] -"+bundle.getString("menu.3"));
    }

}
