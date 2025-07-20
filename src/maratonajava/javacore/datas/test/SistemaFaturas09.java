package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas09 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura09> faturas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        System.out.print("Idioma [en/pt]:");
        bundle = Mensagens09.carregar(scanner.nextLine());
        CalculadoraMulta09 calculadora09 = new MultaFixadaPorDiaMulta09(2.00);
        int opcao = 0;
        do {
            System.out.println("\n"+ bundle.getString("menu.opcao"));
            System.out.println("1 - "+bundle.getString("menu.1"));
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
                    listarFaturas(calculadora09);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erro, opção inválida.");
            }
        }while (opcao != 3);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void cadastrarFatura(){
        String numero = ValidadorDeEntradasFatura09.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura09.validandoValor();
        LocalDate dataVencimento = ValidadorDeEntradasFatura09.validandoDataVencimento();
        Fatura09 fatura09 = new Fatura09(numero,valor,dataVencimento);

        faturas.add(fatura09);
        System.out.println("Vencimento sugerido para próxima fatura:"+fatura09.sugerirNovoVencimento());
    }

    private static void listarFaturas(CalculadoraMulta09 calculadoraMulta09){
        if (faturas.isEmpty()){
            System.out.println("Nenhuma fatura encontrada.");
            return;
        }
        for (Fatura09 fatura : faturas) {
            double multa = calculadoraMulta09.calcular(fatura);
            fatura.exibirResumo(bundle,multa);
        }
    }

}
