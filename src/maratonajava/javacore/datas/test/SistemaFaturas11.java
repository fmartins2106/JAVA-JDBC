package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas11 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura11> fatura = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        System.out.println("Idiomas [pt/en]:");
        bundle = Mensagens11.carregar(scanner.nextLine());

        CalculadoraMulta11 calculadoraMulta11 = new MultaPercentualPorDia11(2.00);
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
                    cadastrarFatura();
                    break;
                case 2:
                    listarFaturas(calculadoraMulta11);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro, digite uma opção válida.");
            }
        }while ( opcao != 3);
        System.out.println(">>>>Finalizando sistema.");
    }

    private static void cadastrarFatura(){
        String numero = ValidadorDeEntradasFatura11.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura11.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura11.validandoDataVencimento();

        Fatura11 fatura11 = new Fatura11(numero,valor,vencimento);

        fatura.add(fatura11);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura11.sugerirNovoVencimento());
    }

    public static void listarFaturas(CalculadoraMulta11 calculadoraMulta11){
        if (fatura.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura11 fatura11 : fatura) {
            double multa = calculadoraMulta11.calcular(fatura11);
            fatura11.exibirResumo(bundle,multa);
        }
    }




}
