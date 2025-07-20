
package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas32 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura32> fatura32 = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta32 calculadoraMulta32 = new MultaPercentualPorDia32(1);
        CalculadoraMulta32 calculadoraMulta33 = new MultaPercentualPorDia32(1);
        int opcao = 0;
        idioma();
        do {
            exibirMenu();
            opcao = capturarOpcao();
            manipularOpcao(opcao,calculadoraMulta32,calculadoraMulta33);
        }while (opcao != 3);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void manipularOpcao(int opcao, CalculadoraMulta32 calculadoraMulta32,CalculadoraMulta32 calculadoraMulta33){
        switch (opcao){
            case 1:
                cadastroFatura();
                break;
            case 2:
                listarFaturas(calculadoraMulta32,calculadoraMulta33);
                break;
            case 3:
                break;
            default:
                System.out.println("Erro. Digite uma opção válida.");
        }
    }


    private static void listarFaturas(CalculadoraMulta32 calculadoraMulta32, CalculadoraMulta32 calculadoraMulta33){
        if (fatura32.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura32 fatura321 : fatura32) {
            double multa = calculadoraMulta32.calcular(fatura321) + calculadoraMulta33.calcular(fatura321);
            fatura321.exibirResumoFatura(bundle,multa);
        }
    }

    private static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura32.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura32.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura32.validandoDataVencimento();
        Fatura32 fatura33 = new Fatura32(numero,valor,vencimento);
        fatura32.add(fatura33);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura33.sugestaoVencimentoFatura());
    }

    private static int capturarOpcao(){
        while (true){
            try {
                System.out.print("Digite uma das opções acima:");
                return Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido.");
            }
        }
    }

    private static void idioma(){
        String idioma = "";
        do {
            System.out.print("Idioma [pt - en]:");
            idioma = scanner.nextLine().trim();
            bundle = Mensagens32.carregar(idioma);
        }while (!idioma.equalsIgnoreCase("en") && !idioma.equalsIgnoreCase("pt"));
    }


    private static void exibirMenu(){
        System.out.println("\n"+bundle.getString("menu.opcao"));
        System.out.println("[1] -"+bundle.getString("menu.1"));
        System.out.println("[2] -"+bundle.getString("menu.2"));
        System.out.println("[3] -"+bundle.getString("menu.3"));
    }

}
