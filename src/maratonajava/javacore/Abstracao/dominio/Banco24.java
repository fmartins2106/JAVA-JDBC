package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco24 {
    private List<Conta24> conta24s;

    public Banco24(){
        this.conta24s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente24.validacaoNome(nome);
                return Cliente24.formatoString(nome);
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
                Cliente24.validacaoCpf(cpf);
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
                Conta24.validacaoNumeroConta(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Cliente24.TipoConta24 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite [1] Conta Corrente | [2] Conta Poupança.:");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Cliente24.TipoConta24.CORRENTE;
                    case 2:
                        return Cliente24.TipoConta24.POUPANÇA;
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addConta(Conta24 conta24){
        conta24s.add(conta24);
    }

    public void listaContasCadastradas(){
        if (conta24s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta24s.forEach(System.out::println);
        }
    }

    public Optional<Conta24> pesquisaPorNumeroConta(Scanner scanner){
        if (conta24s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            try {
                System.out.print("Número conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                return conta24s.stream().filter(p -> p.getNumeroConta() == numeroConta).findFirst();
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
                return Optional.empty();
            }
        }
    }

    public void validandoDeposito(Scanner scanner){
        Optional<Conta24> conta24Optional = pesquisaPorNumeroConta(scanner);
        if (conta24Optional.isPresent()){
            Conta24 conta24 = conta24Optional.get();
            try {
                System.out.print("Valor do depósito:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta24.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para depósito.");
            }
        }
    }

    public void validandoSaque(Scanner scanner){
        Optional<Conta24> conta24Optional = pesquisaPorNumeroConta(scanner);
        if (conta24Optional.isPresent()){
            Conta24 conta24 = conta24Optional.get();
            try {
                System.out.print("Valor do saque:");
                double valor = Double.parseDouble(scanner.nextLine());
                conta24.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void validandoAlterarConta(Scanner scanner, String acao){
        Optional<Conta24> conta24Optional = pesquisaPorNumeroConta(scanner);
        if (conta24Optional.isPresent()){
            Conta24 conta24 = conta24Optional.get();
            if (acao.equalsIgnoreCase("bloquear")){
                conta24.bloquearConta();
            } else if (acao.equalsIgnoreCase("desbloquear")) {
                conta24.desbloquearConta();
            }else {
                conta24.cancelamentoDeConta();
            }
        }
    }
}
