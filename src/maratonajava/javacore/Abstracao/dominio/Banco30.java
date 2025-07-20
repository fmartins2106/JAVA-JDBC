package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco30 {
    private List<Conta30> conta30s;

    public Banco30(){
        this.conta30s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente30.validacaoNome(nome);
                return Cliente30.formatoNome(nome);
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
                Cliente30.validacaoCpf(cpf);
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
                Conta30.validacaoNumeroConta(numeroConta);
                Conta30.validacaoContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta30.TipoConta30 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite [1] Conta corrente | [2] Conta poupança.");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Conta30.TipoConta30.CORRENTE;
                    case 2:
                        return Conta30.TipoConta30.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta30 conta30){
        conta30s.add(conta30);
    }

    public void listarConta(){
        if (conta30s.isEmpty()){
            System.out.println("Lista vazia, nenhuma conta foi cadastrada.");
        }else {
            conta30s.forEach(System.out::println);
        }
    }

    public Optional<Conta30> pesquisarComNumeroConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            Conta30.validacaoNumeroConta(numeroConta);
            if (conta30s == null || conta30s.isEmpty()){
                System.out.println("Lista vazia. Nenhuma conta foi cadastrada.");
                return Optional.empty();
            }
            Optional<Conta30> numeroContaEncontrada = conta30s.stream().filter(conta30 -> conta30.getNumeroConta()==numeroConta).findFirst();
            if (numeroContaEncontrada.isPresent()){
                return numeroContaEncontrada;
            }
            System.out.println("Número de conta não encontrada.");
            return Optional.empty();
        }catch (NumberFormatException e){
            System.out.println("Digite uma número de conta válido.");
            return Optional.empty();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void validandoDeposito(Scanner scanner){
        Optional<Conta30> conta30Optional = pesquisarComNumeroConta(scanner);
        if (conta30Optional.isPresent()){
            Conta30 conta30 = conta30Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta30.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void validandoSaque(Scanner scanner){
        Optional<Conta30> conta30Optional = pesquisarComNumeroConta(scanner);
        if (conta30Optional.isPresent()){
            Conta30 conta30 = conta30Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta30.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido");
            }
        }
    }

    public void alterandoStatusConta(Scanner scanner, String acao){
        Optional<Conta30> conta30Optional = pesquisarComNumeroConta(scanner);
        if (conta30Optional.isPresent()){
            Conta30 conta30 = conta30Optional.get();
            if (acao.equalsIgnoreCase("bloquear")){
                conta30.bloquearConta();
            } else if (acao.equalsIgnoreCase("desbloquear")) {
                conta30.desbloquearConta();
            }else {
                conta30.cancelarConta();
            }
        }
    }

}
