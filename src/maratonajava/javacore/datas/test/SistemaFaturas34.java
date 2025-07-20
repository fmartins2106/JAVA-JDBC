package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas34 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura34> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;
    private static final CalculadoraMulta34 calculadoraMulta34 = new MultaPercentualPorDia34(1);
    private static final CalculadoraMulta34 getCalculadoraMulta34 = new MultaFixadaPorDia34(1);
    public static void main(String[] args) {
        escolherIdima();
        int opcao = 0;
        do {
            exibirMenu();
            opcao = capturarOpcao();
            switch (opcao){
                case 1:
                    cadastroFatura();
                    break;
                case 2:
                    listarFaturasCadastradas(calculadoraMulta34,getCalculadoraMulta34);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void escolherIdima(){
        String idioma = "";
        do {
            System.out.print("Escolha o idioma [en | pt]:");
            idioma = scanner.nextLine().trim();
            bundle = Mensagens34.carregar(idioma);
        }while (!idioma.equalsIgnoreCase("en") && !idioma.equalsIgnoreCase("pt"));
    }

    private static void listarFaturasCadastradas(CalculadoraMulta34 calculadoraMulta34, CalculadoraMulta34 calculadoraMulta35){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhuma fatura foi cadastrada.");
            return;
        }
        for (Fatura34 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta35.calcular(faturasCadastrada) + calculadoraMulta34.calcular(faturasCadastrada);
            faturasCadastrada.exibirDadosFatura(bundle,multa);
        }
    }

    private static void cadastroFatura(){
        String numeroFatura = ValidadorDeEntradasFatura34.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura34.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura34.validandoDataVencimento();
        Fatura34 fatura34 = new Fatura34(numeroFatura,valor,vencimento);
        faturasCadastradas.add(fatura34);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura34.sugerirProximaDataVencimentoFatura());
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opçõa válida.");
            }
        }
    }

    private static void exibirMenu(){
        System.out.println("\n"+bundle.getString("menu.opcao"));
        System.out.println("[1] -"+bundle.getString("menu.1"));
        System.out.println("[2] -"+bundle.getString("menu.2"));
        System.out.println("[3] -"+bundle.getString("menu.3"));
    }


}
