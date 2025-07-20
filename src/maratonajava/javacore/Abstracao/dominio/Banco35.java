package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco35 {
    private List<Conta35> conta35s;

    public Banco35(){
        this.conta35s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente35.validacaoNome(nome);
                return Cliente35.formatoString(nome);
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
                Cliente35.validacaoCpf(cpf);
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
                Conta35.validacaoNumeroConta(numeroConta);
                Conta35.validacaoContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta35.TipoConta35 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o tipo de conta -> [1]Conta corrente [2]Conta poupança:");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Conta35.TipoConta35.CORRENTE;
                    case 2:
                        return Conta35.TipoConta35.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta35 conta35){
        conta35s.add(conta35);
    }

    public void listarContasCadastradas(){
        if (conta35s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma conta foi cadastrada.");
            return;
        }
        conta35s.forEach(System.out::println);
    }

    public Optional<Conta35> pesquisaPorNumeroConta(Scanner scanner){
        try {
            System.out.print("Número de conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            Conta35.validacaoNumeroConta(numeroConta);
            if (conta35s.isEmpty()){
                System.out.println("Nenhuma conta foi cadastrada. Verifique.");
                return Optional.empty();
            }
            Optional<Conta35> contaEncontrada = conta35s.stream().filter(conta35 ->  conta35.numeroConta == numeroConta).findFirst();
            if (contaEncontrada.isPresent()){
                return contaEncontrada;
            }
            System.out.println("Conta não foi encontrada.");
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
        Optional<Conta35> conta35Optional = pesquisaPorNumeroConta(scanner);
        if (conta35Optional.isPresent()){
            Conta35 conta35 = conta35Optional.get();
            try {
                System.out.print("Valor do depósito:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta35.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void sacar(Scanner scanner){
        Optional<Conta35> conta35Optional = pesquisaPorNumeroConta(scanner);
        if (conta35Optional.isPresent()){
            Conta35 conta35 = conta35Optional.get();
            try {
                System.out.print("Valor do saque:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta35.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void bloquearConta(Scanner scanner){
        Optional<Conta35> conta35Optional = pesquisaPorNumeroConta(scanner);
        if (conta35Optional.isPresent()){
            Conta35 conta35 = conta35Optional.get();
            conta35.bloquearConta();
        }
    }

    public void desbloquearConta(Scanner scanner){
        Optional<Conta35> conta35Optional = pesquisaPorNumeroConta(scanner);
        if (conta35Optional.isPresent()){
            Conta35 conta35 = conta35Optional.get();
            conta35.desbloquearConta();
        }
    }

    public void cancelarConta(Scanner scanner){
        Optional<Conta35> conta35Optional = pesquisaPorNumeroConta(scanner);
        if (conta35Optional.isPresent()){
            Conta35 conta35 = conta35Optional.get();
            conta35.cancelarConta();
        }
    }
}
