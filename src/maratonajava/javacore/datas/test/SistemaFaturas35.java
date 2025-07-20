package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas35 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura35> faturas35 = new ArrayList<>();
    private static ResourceBundle bundle;
    private static final CalculadoraMulta35 calculadoraMulta35 = new MultaFixadaPorDia35(1);
    private static  final CalculadoraMulta35 calculadoraMulta36 = new MultaPercentualPorDia(1);
    public static void main(String[] args) {
        int opcao = 0;
        escolherIdiomas();
        do {
            exibirMenu();
            opcao = capturarOpcao();
            escolhaOpcoes(opcao);
        }while (opcao != 3);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura35.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura35.validandoValor();
        LocalDate vencimento = ValidadorDeEntradasFatura35.validandoDataVencimento();
        Fatura35 fatura35 = new Fatura35(numero,valor,vencimento);
        faturas35.add(fatura35);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura35.sugestaoVencimentoProximaFatura());
    }

    private static void listarFaturasCadastradas(CalculadoraMulta35 calculadoraMulta35, CalculadoraMulta35 calculadoraMulta36){
        if (faturas35.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura35 fatura35 : faturas35) {
            double multa = calculadoraMulta35.calcular(fatura35) + calculadoraMulta36.calcular(fatura35);
            fatura35.exibirDadosFatura(bundle,multa);
        }
    }

    private static void escolhaOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroFatura();
                break;
            case 2:
                listarFaturasCadastradas(calculadoraMulta35,calculadoraMulta36);
                break;
            case 3:
                break;
            default:
                System.out.println("Err.Digite uma opção válida.");
        }
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.println("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    private static void exibirMenu(){
        System.out.println("\n"+bundle.getString("menu.opcao"));
        System.out.println("[1] "+bundle.getString("menu.1"));
        System.out.println("[2] "+bundle.getString("menu.2"));
        System.out.println("[3] "+bundle.getString("menu.3"));
    }

    private static void escolherIdiomas(){
        String idioma = "";
        do {
            System.out.println("Idiomas [pt - us]:");
            idioma = scanner.nextLine().trim();
            bundle = Mensagens35.idiomas(idioma);
        }while (!idioma.equalsIgnoreCase("en") && !idioma.equalsIgnoreCase("pt"));
    }
}
