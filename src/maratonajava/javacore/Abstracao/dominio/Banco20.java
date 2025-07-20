package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco20 {
    private List<Conta20> conta20s;

    public Banco20(){
        this.conta20s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente20.validacaoNome(nome);
                return Cliente20.formatoNome(nome);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Cliente20.validacaoCpf(cpf);
                return cpf;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Número conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                Conta20.validacaoNumeroConta(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Cliente20.TipoConta20 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("====Tipos de conta====");
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupança.");
                System.out.println("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente20.TipoConta20.CORRENTE;
                    case 2:
                        return Cliente20.TipoConta20.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public Optional<Conta20> pesquisaNumeroConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            return conta20s.stream().filter(conta -> conta.getNumeroConta() == numeroConta).findFirst();
        }catch (NumberFormatException e){
            System.out.println("Digite um número de conta válido.");
            return Optional.empty();
        }
    }

    public void validandoDepositoConta(Scanner scanner) {
        Optional<Conta20> conta20Optional = pesquisaNumeroConta(scanner);
        if (conta20Optional.isPresent()) {
            Conta20 conta20 = conta20Optional.get();
            try {
                System.out.print("Valor do depósito:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta20.depositar(valor);
            } catch (NumberFormatException e) {
                System.out.println("Digite um valor válido.");
            }
        }else {
            System.out.println("Número de conta não encontrado.");
        }
    }

    public void validandoSaqueConta(Scanner scanner){
        Optional<Conta20> conta20Optional = pesquisaNumeroConta(scanner);
        if (conta20Optional.isPresent()){
            Conta20 conta20 = conta20Optional.get();
            try {
                System.out.print("Digite o valor do saque:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta20.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void alterarDados(Scanner scanner, String acao){
        Optional<Conta20> conta20Optional = pesquisaNumeroConta(scanner);
        if (conta20Optional.isPresent()){
            Conta20 conta20 = conta20Optional.get();
            if (acao.equals("bloquear")){
                conta20.bloquearConta();
            }else {
                conta20.cancelarConta();
            }
        }else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void validandoDesbloqueioConta(Scanner scanner){
        Optional<Conta20> conta20Optional = pesquisaNumeroConta(scanner);
        if (conta20Optional.isPresent()){
            Conta20 conta20 = conta20Optional.get();
            conta20.desbloqueioConta();
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void addConta(Conta20 conta20){
        conta20s.add(conta20);
    }

    public void listarConta(){
        if (conta20s.isEmpty()){
            System.out.println("Conta vazia.");
        }else {
            conta20s.forEach(System.out::println);
        }
    }

}
