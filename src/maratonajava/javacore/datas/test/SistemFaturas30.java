package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemFaturas30 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura30> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;
    private static final CalculadoraMulta30 calculadoraMultaPorDia30 = new MultaFixadaPorDia30(0.05);
    private static final CalculadoraMulta30 calculadoraMultaPecentual30 = new MultaPercentualPorDia30(1);

    public static void main(String[] args) {

        opcaoIdiomas();
        int opcao = 0;
        do {
            exibirMenu();
            opcao = capturarOpcao();
            escolhaOpcoes(opcao);
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válida.");
            }
        }
    }

    private static void opcaoIdiomas(){
        String idioma = "";
        do {
            System.out.print("Digite o idioma [en | pt]:");
            idioma = scanner.nextLine().trim();
            bundle = Mensagens30.carregar(idioma);
        }while (!idioma.equalsIgnoreCase("en") && !idioma.equalsIgnoreCase("pt"));
    }

    private static void escolhaOpcoes(int opcao){
        switch (opcao){
            case 1:
                cadastroFatura();
                break;
            case 2:
                listarFaturasCadastradas(calculadoraMultaPorDia30,calculadoraMultaPecentual30);
                break;
            case 3:
                break;
            default:
                System.out.println("Erro, nenhuma opção válida.");
        }
    }


    private static void exibirMenu(){
        System.out.println("\n"+bundle.getString("menu.opcao"));
        System.out.println("[1] -"+bundle.getString("menu.1"));
        System.out.println("[2] -"+bundle.getString("menu.2"));
        System.out.println("[3] -"+bundle.getString("menu.3"));
    }

    private static void cadastroFatura(){
        String numero = ValidadorDeEntraedasFatura30.validandoNumeroFatura();
        double valor = ValidadorDeEntraedasFatura30.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntraedasFatura30.validandoDataVencimento();
        Fatura30 fatura30 = new Fatura30(numero,valor,vencimento);
        faturasCadastradas.add(fatura30);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura30.sugerirVencimentoProximaFatura());
    }

    private static void listarFaturasCadastradas(CalculadoraMulta30 calculadoraMultaPorDia30, CalculadoraMulta30 calculadoraMultaPecentual30  ){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhuma fatura foi cadastrada.");
            return;
        }
        for (Fatura30 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMultaPorDia30.calcular(faturasCadastrada) + calculadoraMultaPecentual30.calcular(faturasCadastrada);
            faturasCadastrada.exibirDadosFatura(bundle,multa);
        }
    }

}
