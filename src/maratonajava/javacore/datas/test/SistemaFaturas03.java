package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas03 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura03> fatura03 = new ArrayList<>();
    private static ResourceBundle bundle;
    public static void main(String[] args) {
        System.out.print("Idiomas [pt/en]:");
        bundle = Mensagens03.carregar(scanner.nextLine());

        CalculadoraMulta03 calculadoraMulta03 = new MultaPercentualPorDia03(2.00);
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
                    listarFaturas(calculadoraMulta03);
                    break;
                case 3:
                    System.out.println("Hora atual:"+LocalDate.now());
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }while (opcao != 4);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void cadastrarFatura(){
        String numero = ValidadorDeEntradasFatura03.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura03.validandoValor();
        LocalDate validade = ValidadorDeEntradasFatura03.validandoDataValidade();
        Fatura03 fatura4 = new Fatura03(numero,valor,validade);
        fatura03.add(fatura4);

        System.out.println("Vencimento sugerido para próxima fatura:"+fatura4.sugeriroNovoVencimento());
    }

    private static void listarFaturas(CalculadoraMulta03 calculadoraMulta03){
        if (fatura03.isEmpty()){
            System.out.println("Nenhuma fatura encontrada.");
            return;
        }
        for (Fatura03 fatura031 : fatura03) {
            double multa = calculadoraMulta03.calcular(fatura031);
            fatura031.exibirResumo(bundle,multa);
        }
    }

}
