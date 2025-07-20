package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas29 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura29> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta29 calculadoraMulta29 = new MultaPercentualPorDia29(1);
        CalculadoraMulta29 calculadoraMulta30 = new MultaFixadaPorDia29(1);
        validandoIdioma();
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma da opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
            codigoOpcoes(opcao,calculadoraMulta29,calculadoraMulta30);
        }while(opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void exibirMenu(){
        System.out.println("\n"+bundle.getString("menu.opcao"));
        System.out.println("[1] - "+bundle.getString("menu.1"));
        System.out.println("[2] - "+bundle.getString("menu.2"));
        System.out.println("[3] - "+bundle.getString("menu.3"));
    }

    private static void codigoOpcoes(int opcao, CalculadoraMulta29 calculadoraMulta29, CalculadoraMulta29 calculadoraMulta30){
        switch (opcao){
            case 1:
                cadastroFatura();
                break;
            case 2:
                listarFaturasCadastradas(calculadoraMulta29,calculadoraMulta30);
                break;
            case 3:
                break;
            default:
                System.out.println("Erro. Digite um valor válido.");
        }
    }

    private static void validandoIdioma(){
        String idioma = "";
        do {
            System.out.print("Idiomas [en | br]:");
            idioma = scanner.nextLine().trim();
            bundle = Mensagens29.carregar(idioma);
        }while (!idioma.equalsIgnoreCase("en") && !idioma.equalsIgnoreCase("pt"));

    }

    private static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura29.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura29.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura29.validandoDataVencimento();
        Fatura29 fatura29 = new Fatura29(numero,valor,vencimento);
        faturasCadastradas.add(fatura29);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura29.sugerirNovaDataVencimento());
    }

    private static void listarFaturasCadastradas(CalculadoraMulta29 calculadoraMulta29,CalculadoraMulta29 calculadoraMulta30){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura29 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta29.calcular(faturasCadastrada) + calculadoraMulta30.calcular(faturasCadastrada);
            faturasCadastrada.exibirDadosFatura(bundle,multa);
        }
    }

}
