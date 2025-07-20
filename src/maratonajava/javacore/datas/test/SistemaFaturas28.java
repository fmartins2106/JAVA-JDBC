package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas28 {
    private static final Scanner scanner = new Scanner(System.in);
    private  static final List<Fatura28> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta28 calculadoraMulta28 = new MultaPercentualPorDia28(0.007);
        validandoIdioma();
        int opcao = 0;
        do {
            exibirMenu();
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                       cadastroFatura();
                       break;
                    case 2:
                        listarFaturasCadastradas(calculadoraMulta28);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Erro. Nenhum fatura cadastrada.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido.");
            }
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void validandoIdioma(){
        String idioma = "";
        do {
            System.out.print("Digite o idioma [en | pt]:");
            idioma = scanner.nextLine().trim();
            bundle = Mensagens28.carregar(idioma);
        }while (!idioma.equalsIgnoreCase("en") && !idioma.equalsIgnoreCase("pt"));
    }

    private static void exibirMenu(){
        System.out.println("\n"+bundle.getString("fatura.opcao"));
        System.out.println("[1] -"+bundle.getString("menu.1"));
        System.out.println("[2] -"+bundle.getString("menu.2"));
        System.out.println("[3] -"+bundle.getString("menu.3"));
    }

    private static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura28.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura28.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura28.validandoDataValidade();
        Fatura28 fatura28 = new Fatura28(numero,valor,vencimento);
        faturasCadastradas.add(fatura28);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura28.sugestaoVencimentoProximaFatura());
    }

    private static void listarFaturasCadastradas(CalculadoraMulta28 calculadoraMulta28){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhuma fatura foi cadastrada.");
            return;
        }
        for (Fatura28 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta28.calcular(faturasCadastrada);
            faturasCadastrada.exibirResumoFatura(bundle,multa);
        }
    }


}
