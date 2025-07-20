package academy.devdojo.maratonajava.javacore.datas.test;

import academy.devdojo.maratonajava.javacore.datas.dominio.*;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SistemaFaturas01 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fatura01> faturas = new ArrayList<>();
    private static ResourceBundle bundle;

    public static void main(String[] args) {
        System.out.print("idioma [pt/en]:");
        bundle = Mensagens01.carregar(scanner.nextLine());

        CalculadoraMulta01 calculadora = new MultaPercentualPorDia01(2.0);
        int opcao = 0;
        do {
            System.out.println("\n"+bundle.getString("menu.opcao"));
            System.out.println("1 - "+bundle.getString("menu.1"));
            System.out.println("2 - "+bundle.getString("menu.2"));
            System.out.println("3 - "+bundle.getString("menu.3"));
            System.out.println("4 - "+bundle.getString("menu.4"));
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
                    listarFaturas(calculadora);
                    break;
                case 3:
                    System.out.println("Data hora atual:"+LocalDate.now());
                    break;
            }
        }while (opcao != 4);
        System.out.println(">>>Finalizando sistema.");
    }

    private static void cadastroFatura(){
        Instant inicio = Instant.now();
        String numeroFatura = ValidadorDeEntradasFatura01.validandoNumeroFatura();
        double valor = ValidadorDeEntradasFatura01.validandoValorFatura();
        LocalDate vencimento = ValidadorDeEntradasFatura01.validandoDataVencimento();

        Fatura01 fatura01 = new Fatura01(numeroFatura,valor,vencimento);
        faturas.add(fatura01);

        Instant fim = Instant.now();
        Duration duration = Duration.between(inicio,fim);
        System.out.println("Cadastro concluido  em"+duration.toMillis()+"ms");
        System.out.println("Vencimento sugerido para próxima fatura:"+fatura01.sugerirNovoVencimento());
    }

    private static void listarFaturas(CalculadoraMulta01 calculadoraMulta01){
        if (faturas.isEmpty()){
            System.out.println("Nenhuma fatura cadastrada.");
            return;
        }
        for (Fatura01 fatura : faturas) {
            double multa = calculadoraMulta01.calcularMulta(fatura);
            fatura.exibirResumo(bundle,multa);
        }
    }

    

}
