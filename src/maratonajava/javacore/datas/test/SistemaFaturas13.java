package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas13 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura13> faturas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta13 calculadoraMulta13 = new MultaPercentualPorDia13(2.00);
        System.out.println("Idiomas [en/pt]:");
        bundle = Mensagens13.carregar(scanner.nextLine());
        int opcao = 0;
        do {
            System.out.println("\n"+ bundle.getString("menu.opcao"));
            System.out.println("1 - "+ bundle.getString("menu.1"));
            System.out.println("2 - "+bundle.getString("menu.2"));
            System.out.println("3 - "+bundle.getString("menu.3"));
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
                    listarFaturasCadastradas(calculadoraMulta13);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro. Opção inválida.");
            }

        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void cadastrarFatura(){
        String numero = ValidadorDeEntradasFatura13.validacaoNumeroFatura();
        double valor = ValidadorDeEntradasFatura13.validacaoValorFatura();
        LocalDate vencimento  =ValidadorDeEntradasFatura13.validacaoVencimento();

        Fatura13 fatura13 = new Fatura13(numero,valor,vencimento);
        faturas.add(fatura13);
        System.out.println("Sugestão de vencimento para próxima fatura:"+fatura13.sugerirNovoVencimento());
    }

    private static void listarFaturasCadastradas(CalculadoraMulta13 calculadoraMulta13){
        if (faturas.isEmpty()){
            System.out.println("Nenhum fatura cadastrada.");
            return;
        }
        for (Fatura13 fatura : faturas) {
            double multa = calculadoraMulta13.calcular(fatura);
            fatura.exibirResumo(bundle,multa);
        }
    }
}
