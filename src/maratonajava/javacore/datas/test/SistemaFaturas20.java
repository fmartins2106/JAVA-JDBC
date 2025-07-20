package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas20 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura20> faturasCadastradas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        CalculadoraMulta20 calculadoraMulta20 = new MultaPercentualPorDia20(1.0);
        System.out.println("Idiomas [pt | en]:");
        bundle = Mensagens20.carregar(scanner.nextLine());
        int opcao = 0;
        do {
            System.out.println("\n"+bundle.getString("menu.opcao"));
            System.out.println("[1] "+bundle.getString("menu.1"));
            System.out.println("[2] "+bundle.getString("menu.2"));
            System.out.println("[3] "+bundle.getString("menu.3"));
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e){
                System.out.println("Erro, digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroFatura();
                    break;
                case 2:
                    listarFaturas(calculadoraMulta20);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }while (opcao != 3);
        System.out.println(">>>>Finalizando sistema.");
    }

    public static void cadastroFatura(){
        String numero = ValidadorDeEntradasFatura20.validandoNumeroFatura();
        double preco = ValidadorDeEntradasFatura20.validandoValor();
        LocalDate validade = ValidadorDeEntradasFatura20.validandoDataVencimento();
        Fatura20 fatura20 = new Fatura20(numero,preco,validade);
        faturasCadastradas.add(fatura20);
        System.out.println("Fatura cadastrada com sucesso.");
        Fatura20.sugestaoVencimentoProximaFatura();
    }

    public static void listarFaturas(CalculadoraMulta20 calculadoraMulta20){
        if (faturasCadastradas.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura20 faturasCadastrada : faturasCadastradas) {
            double multa = calculadoraMulta20.calcular(faturasCadastrada);
            faturasCadastrada.exibirResumoFatura(bundle,multa);
        }
    }



}
