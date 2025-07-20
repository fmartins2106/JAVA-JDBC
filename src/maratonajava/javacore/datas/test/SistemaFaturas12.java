package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas12 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura12> faturas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        System.out.println("Idiomas [en/pt]:");
        bundle = Mensagens12.carregar(scanner.nextLine());

        CalculadoraMulta12 calculadoraMulta12 = new MultaFixadaPorDia12(2.00);

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
                    listarFaturas(calculadoraMulta12);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Digite uma opçã válida.");
            }
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura12.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura12.validandoValor();
        LocalDate vencimento = ValidadorDeEntradasFatura12.validandoVencimento();

        Fatura12 fatura12 = new Fatura12(numero,valor,vencimento);
        faturas.add(fatura12);

        System.out.println("Sugestão de vencimento para próxima fatura."+fatura12.sugirirNovoVencimento());
    }

    public static void listarFaturas(CalculadoraMulta12 calculadoraMulta12){
        if (faturas.isEmpty()){
            System.out.println("Nenhum fatura cadastrada.");
            return;
        }
        for (Fatura12 fatura : faturas) {
            double multa = calculadoraMulta12.calcular(fatura);
            fatura.exibirResumo(bundle,multa);
        }
    }


}
