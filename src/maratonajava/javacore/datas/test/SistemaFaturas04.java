package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas04 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura04> faturas04 = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        System.out.print("Idiomas [pt/en]:");
        bundle = Mensagens04.carregar(scanner.nextLine());

        CalculadoraMulta04 calculadoraMulta04 = new MultaPercentualPorDia04(2.0);
        int opcao = 0;
        do {
            System.out.println("\n"+ bundle.getString("menu.opcao"));
            System.out.println("1 - " +bundle.getString("menu.1"));
            System.out.println("2 - "+bundle.getString("menu.2"));
            System.out.println("3 - "+bundle.getString("menu.3"));
            System.out.println("4 = "+bundle.getString("menu.4"));
            opcao = Integer.parseInt(scanner.nextLine().trim());
            switch (opcao){
                case 1:
                    cadastrarFatura();
                    break;
                case 2:
                    listarFaturas(calculadoraMulta04);
                    break;
                case 3:
                    System.out.println("Hora atual:"+ LocalTime.now());
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");

            }
        }while (opcao != 4);
        System.out.println(">>>Sistema encerrado.");
    }

    private static void cadastrarFatura(){
        String numero = ValidadorDeEntradasFatura04.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura04.validandoValorFatura();
        LocalDate dataVencimento = ValidadorDeEntradasFatura04.validandoDataVencimento();

        Fatura04 fatura04 = new Fatura04(numero,valor,dataVencimento);
        faturas04.add(fatura04);
        System.out.println("Vencimento sugerido para próxima fatura:"+fatura04.sugerirNovoVencimento());
    }

    private static void listarFaturas(CalculadoraMulta04 calculadoraMulta04){
        if (faturas04.isEmpty()){
            System.out.println("Nenhuma fatura encontrada.");
            return;
        }
        for (Fatura04 fatura04 : faturas04) {
            double multa = calculadoraMulta04.calcular(fatura04);
            fatura04.exibirResumo(bundle,multa);
        }
    }

}
