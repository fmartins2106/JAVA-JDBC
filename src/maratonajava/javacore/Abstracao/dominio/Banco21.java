package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco21 {
    private List<Conta21> conta21s;

    public Banco21(){
        this.conta21s = new ArrayList<>();
    }

    public static String validacaoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente21.validacaoNome(nome);
                return Cliente21.formatoNome(nome);
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
                Cliente21.validacaoCpf(cpf);
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
                Conta21.validacaoNumeroConta(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Cliente21.TipoConta21 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupança.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente21.TipoConta21.CORRENTE;
                    case 2:
                        return Cliente21.TipoConta21.POUPANÇA;
                    default:
                        System.out.println("Digite uma das opções acima.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta21 conta21){
        conta21s.add(conta21);
    }

    public void listaContasCadastradas(){
        if (conta21s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta21s.forEach(System.out::println);
        }
    }

    public Optional<Conta21> pesquisaNumeroConta(Scanner scanner){
        try {
            if (conta21s.isEmpty()){
                System.out.println("Lista vazia.");
                return Optional.empty();
            }else {
                System.out.print("Número conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                return conta21s.stream().filter(p -> p.getNumeroConta() == numeroConta).findFirst();
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um número de conta válido.");
            return Optional.empty();
        }
    }


    public void validandoDeposito(Scanner scanner){
        Optional<Conta21> conta21Optional = pesquisaNumeroConta(scanner);
        if (conta21Optional.isPresent()){
            Conta21 conta21 = conta21Optional.get();
            try {
                System.out.print("Valor do depósito:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta21.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para depósito.");
            }
        }else {
            System.out.println("Número de conta não encontrado.");
        }
    }

    public void validandoSaque(Scanner scanner){
        Optional<Conta21> conta21Optional = pesquisaNumeroConta(scanner);
        if (conta21Optional.isPresent()){
            Conta21 conta21 = conta21Optional.get();
            try {
                System.out.print("Valor do saque:R$");
                double saque = Double.parseDouble(scanner.nextLine());
                conta21.sacar(saque);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para saque.");
            }
        }else {
            System.out.println("Número de conta não encontrado.");
        }
    }

    public void validandoAlteracaoStatusConta(Scanner scanner, String acao){
        Optional<Conta21> conta21Optional = pesquisaNumeroConta(scanner);
        if (conta21Optional.isPresent()){
            Conta21 conta21 = conta21Optional.get();
            if (acao.equals("bloquear")){
                conta21.bloquearConta();
            }else {
                conta21.cancelarConta();
            }
        }else {
            System.out.println("Número de conta não encontrado.");
        }
    }

    public void validandoDesbloqueioConta(Scanner scanner){
        Optional<Conta21> conta21Optional = pesquisaNumeroConta(scanner);
        if (conta21Optional.isPresent()){
            Conta21 conta21 = conta21Optional.get();
            conta21.desbloquearConta();
        }else {
            System.out.println("Número de conta não encontrado.");
        }
    }



}
