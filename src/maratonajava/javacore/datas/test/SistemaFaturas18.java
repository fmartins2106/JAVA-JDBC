package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas18 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura18> faturas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta18 calculadoraMulta18 = new MultaPercentualPorDia18(1.5);
        System.out.print("Idiomas [en | pt]:");
        bundle = Mensagens18.carregar(scanner.nextLine());
        int opcao = 0;
        do {
            System.out.println("\n" +bundle.getString("menu.opcao"));
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
                    listarFaturasCadastradas(calculadoraMulta18);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Valor inválido.");
            }
        }while (opcao != 3);
        System.out.println(">>>>Finalizando sistema.");
    }

    public static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura18.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura18.validandoValor();
        LocalDate vencimento = ValidadorDeEntradasFatura18.validandoDataValidade();

        Fatura18 fatura18 = new Fatura18(numero,valor,vencimento);

        faturas.add(fatura18);
        System.out.println("Fatura cadastrada com sucesso.");
    }

    public static void listarFaturasCadastradas(CalculadoraMulta18 calculadoraMulta18){
        if (faturas.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura18 fatura : faturas) {
            double multa  = calculadoraMulta18.calcular(fatura);
            fatura.exibirDadosFatura(bundle,multa);
        }
    }



}
