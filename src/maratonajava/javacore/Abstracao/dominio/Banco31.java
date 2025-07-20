package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco31 {
    private List<Conta31> conta31s;

    public Banco31(){
        this.conta31s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente31.validacaoNome(nome);
                return Cliente31.formatoNome(nome);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine();
                Cliente31.validacaoCpf(cpf);
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
                Conta31.validacaoContaDuplicada(numeroConta);
                Conta31.validacaoNumeroConta(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta31.TipoConta31 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Escola tipo conta: [1] Conta corrente | [2] Conta poupança.");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Conta31.TipoConta31.CORRENTE;
                    case 2:
                        return Conta31.TipoConta31.POUPANÇA;
                    default:
                        System.out.println("Digite um valor válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta31 conta31){
        conta31s.add(conta31);
    }

    public void listarContasCadastradas(){
        if (conta31s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta31s.forEach(System.out::println);
        }
    }

    public Optional<Conta31> pesquisaNumeroConta(Scanner scanner){
        try {
            System.out.print("Número conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            Conta31.validacaoNumeroConta(numeroConta);
            if (conta31s.isEmpty()){
                System.out.println("Lista vazia. Nenhuma conta foi cadastrada.");
                return Optional.empty();
            }
            Optional<Conta31> contaEncontrada = conta31s.stream().filter(conta31 ->  conta31.getNumeroConta() == numeroConta).findFirst();
            if (contaEncontrada.isPresent()){
                return contaEncontrada;
            }
            System.out.println("Conta não encontrada.");
            return Optional.empty();
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
            return Optional.empty();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void validandoDeposito(Scanner scanner){
        Optional<Conta31> conta31Optional = pesquisaNumeroConta(scanner);
        if (conta31Optional.isPresent()){
            Conta31 conta31 = conta31Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta31.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void validandoSaque(Scanner scanner){
        Optional<Conta31> conta31Optional = pesquisaNumeroConta(scanner);
        if (conta31Optional.isPresent()){
            Conta31 conta31 = conta31Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta31.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void alterarConta(Scanner scanner, String acao){
        Optional<Conta31> conta31Optional = pesquisaNumeroConta(scanner);
        if (conta31Optional.isPresent()){
            Conta31 conta31 = conta31Optional.get();
            if (acao.equalsIgnoreCase("bloquear")){
                conta31.bloquearConta();
            } else if (acao.equalsIgnoreCase("desbloquear")) {
                conta31.desbloquearConta();
            }else {
                conta31.cancelarConta();
            }
        }
    }


}
