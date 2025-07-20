package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas08 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura08> faturas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        System.out.print("Idiomas [en/pt]:");
        bundle = Mensagens08.carregar(scanner.nextLine());

        CalculadoraMulta08 calculadoraMulta08 = new MultaPercentualPorDia08(2.00);
        int opcao = 0;
        do {
            System.out.println("\n"+ bundle.getString("menu.opcao"));
            System.out.println("1 - "+ bundle.getString("menu.1"));
            System.out.println("2 - "+ bundle.getString("menu.2"));
            System.out.println("3 - "+ bundle.getString("menu.3"));
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
                    listarFaturas(calculadoraMulta08);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Digite uma opção válida.");
            }
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void cadastroFatura(){
        String numero = ValidadorDeEntradaFatura08.validandoNumero();
        double valor = ValidadorDeEntradaFatura08.validandoValor();
        LocalDate vencimento = ValidadorDeEntradaFatura08.validandoVencimento();

        Fatura08 fatura08 = new Fatura08(numero,valor,vencimento);
        faturas.add(fatura08);

        System.out.println("Vencimento sugerido para próxima fatura:"+fatura08.sugerirNovoVencimento());
    }

    private static void listarFaturas(CalculadoraMulta08 calculadoraMulta08){
        if (faturas.isEmpty()){
            System.out.println("Nenhum fatura encontrada.");
            return;
        }
        for (Fatura08 fatura : faturas) {
            double multa = calculadoraMulta08.calcular(fatura);
            fatura.exibirResumo(bundle,multa);
        }
    }



}
