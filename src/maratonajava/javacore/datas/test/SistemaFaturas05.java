package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas05 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura05> faturas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        System.out.print("Idiomas [pt/en]:");
        bundle = Mensagens05.carregar(scanner.nextLine());

        CalculadoraMulta05 calculadoraMulta05 = new MultaPercentualPorDia05(2.00);
        int opcao = 0;
        do {
            System.out.println("\n" + bundle.getString("menu.opcao"));
            System.out.println("1 -"+ bundle.getString("menu.1"));
            System.out.println("2 -"+ bundle.getString("menu.2"));
            System.out.println("3 -"+ bundle.getString("menu.3"));
            System.out.println("4 -"+ bundle.getString("menu.4"));
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastrarFatura();
                    break;
                case 2:
                    listarFaturas(calculadoraMulta05);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void cadastrarFatura(){
        String numero = ValidadorDeEntradasFatura05.validandoNumero();
        double valor = ValidadorDeEntradasFatura05.validandoValor();
        LocalDate vencimento = ValidadorDeEntradasFatura05.validandoDataVencimento();
        Fatura05 fatura05 = new Fatura05(numero,valor,vencimento);

        faturas.add(fatura05);
        System.out.println("Vencimento sugerido para p´róxima fatura:"+fatura05.sugerirNovoVencimento());
    }

    public static void listarFaturas(CalculadoraMulta05 calculadoraMulta05){
        if (faturas.isEmpty()){
            System.out.println("Nenhuma fatura encontrada.");
            return;
        }
        for (Fatura05 fatura : faturas) {
            double multa = calculadoraMulta05.calcular(fatura);
            fatura.exibirResumo(bundle, multa);
        }
    }

}

