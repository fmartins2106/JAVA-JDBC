package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas27 {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Fatura27> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta27 calculadoraMulta27 = new MultaPercentualPorDia27(0.05);
        validacaoIdioma();
        int opcao = 0;
        do {
            exibirMenu();
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
                    listarFaturasCadastradas(calculadoraMulta27);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Opção inválida.");
            }
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    private static ResourceBundle validacaoIdioma(){
        while (true){
            System.out.print("Idiomas [pt | en]:");
            String idiomas = scanner.nextLine().trim();
            if (idiomas.equalsIgnoreCase("en") || idiomas.equalsIgnoreCase("pt")){
                return bundle = Mensagens27.carregar(idiomas);
            }
            System.out.println("Idioma inválido.");
        }
    }

    private static void exibirMenu(){
        System.out.println("\n"+bundle.getString("menu.opcao"));
        System.out.println("[1] "+bundle.getString("menu.1"));
        System.out.println("[2] "+bundle.getString("menu.2"));
        System.out.println("[3] "+bundle.getString("menu.3"));
    }

    private static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura27.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura27.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura27.validandoDataVencimento();
        Fatura27 fatura27 = new Fatura27(numero,valor,vencimento);
        faturasCadastradas.add(fatura27);
    }

    private static void listarFaturasCadastradas(CalculadoraMulta27 calculadoraMulta27){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhum fatura cadastrada.");
            return;
        }
        for (Fatura27 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta27.calcular(faturasCadastrada);
            faturasCadastrada.exibirResumoFatura(bundle,multa);
        }
    }


}
