package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco27 {
    private List<Conta27> conta27s;

    public Banco27(){
        this.conta27s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente27.validacanoNome(nome);
                return Cliente27.formatoNome(nome);
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
                Cliente27.validacaoCpf(cpf);
                return cpf;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Número de conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                Conta27.validacaoNumeroConta(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta27.TipoConta27 validandoTipoConta27(Scanner scanner){
        while (true){
            try {
                System.out.println("Digite uma das opções abaixo:");
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupança.");
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao == 1){
                    return Conta27.TipoConta27.CORRENTE;
                } else if (opcao == 2) {
                    return Conta27.TipoConta27.POUPANÇA;
                }else {
                    System.out.println("Erro. Digite 1 para Conta corrente ou 2 para conta poupança.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válido.");
            }
        }
    }

    public void addConta(Conta27 conta27){
        conta27s.add(conta27);
    }

    public void listarContas(){
        if (conta27s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma conta cadastrada até o momento.");
        }else {
            conta27s.forEach(System.out::println);
        }
    }

    public Optional<Conta27> pesquisaPorNome(Scanner scanner){
        if (conta27s == null ||conta27s.isEmpty()){
            System.out.println("Nenhuma nome foi cadastrado. Lista vazia.");
            return Optional.empty();
        }else {
            try {
                System.out.print("Número conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                Optional<Conta27> numeroContaEncontrado = conta27s.stream().filter(p -> p.getNumeroConta() == numeroConta).findFirst();
                if (!numeroContaEncontrado.isPresent()){
                    System.out.println("Conta não encontrada.");
                    return Optional.empty();
                }else {
                    return numeroContaEncontrado;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
                return Optional.empty();
            }
        }
    }

    public void validandoDeposito(Scanner scanner){
        Optional<Conta27> conta27Optional = pesquisaPorNome(scanner);
        if (conta27Optional.isPresent()){
            Conta27 conta27 = conta27Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta27.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void validandoSaque(Scanner scanner){
        Optional<Conta27> conta27Optional = pesquisaPorNome(scanner);
        if (conta27Optional.isPresent()){
            Conta27 conta27 = conta27Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta27.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void alterarDadosConta(Scanner scanner, String acao){
        Optional<Conta27> conta27Optional = pesquisaPorNome(scanner);
        if (conta27Optional.isPresent()){
            Conta27 conta27 = conta27Optional.get();
            if (acao.equalsIgnoreCase("bloquear")){
                conta27.bloquearConta();
            } else if (acao.equalsIgnoreCase("desbloquear")) {
                conta27.desbloquearConta();
            }else {
                conta27.contaCancelada();
            }
        }
    }
}
