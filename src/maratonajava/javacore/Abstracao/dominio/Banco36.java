package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco36 {
    private List<Conta36> conta36s;

    public Banco36(){
        this.conta36s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente36.validacaoNome(nome);
                return Cliente36.formatoNome(nome);
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
                Cliente36.validacaoCpf(cpf);
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
                int numeroConta = Integer.parseInt(scanner.nextLine().trim());
                Conta36.validacaoNumeroConta(numeroConta);
                Conta36.validacaoContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite uma sequência de número válidos.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta36.TipoConta36 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite uma das opções -> [1]Conta corrente | [2]Conta poupança.");
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                switch (opcao){
                    case 1:
                        return Conta36.TipoConta36.CORRENTE;
                    case 2:
                        return Conta36.TipoConta36.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta36 conta36){
        conta36s.add(conta36);
    }

    public void listarContas(){
        if (conta36s.isEmpty()){
            System.out.println("Nenhuma conta foi cadastrada.");
            return;
        }
        conta36s.forEach(System.out::println);
    }

    public Optional<Conta36> pesquisaNumeroConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine().trim());
            Conta36.validacaoNumeroConta(numeroConta);
            if (conta36s.isEmpty()){
                System.out.println("Nenhuma conta foi cadastrada.");
                return Optional.empty();
            }
            Optional<Conta36> contaEncontrada = conta36s.stream().filter(conta36 -> conta36.numeroConta == numeroConta).findFirst();
            if (contaEncontrada.isPresent()){
                return contaEncontrada;
            }
            System.out.println("Conta não encontrada.");
            return Optional.empty();
        }catch (NumberFormatException e){
            System.out.println("Digite um número de conta válido.");
            return Optional.empty();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void depositar(Scanner scanner){
        Optional<Conta36> conta36Optional = pesquisaNumeroConta(scanner);
        if (conta36Optional.isPresent()){
            Conta36 conta36 = conta36Optional.get();
            try {
                System.out.print("Valor do depósito:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta36.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void sacar(Scanner scanner){
        Optional<Conta36> conta36Optional = pesquisaNumeroConta(scanner);
        if (conta36Optional.isPresent()){
            Conta36 conta36 = conta36Optional.get();
            try {
                System.out.print("Valor do saque:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta36.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void alterarDadosConta(Scanner scanner, String acao){
        Optional<Conta36> conta36Optional = pesquisaNumeroConta(scanner);
        if (conta36Optional.isPresent()){
            Conta36 conta36 = conta36Optional.get();
            if (acao.equalsIgnoreCase("bloquear")){
                conta36.bloquearConta();
            }else if (acao.equalsIgnoreCase("desbloquear")){
                conta36.desbloquearConta();
            }else {
                conta36.cancelarConta();
            }
        }
    }
}
