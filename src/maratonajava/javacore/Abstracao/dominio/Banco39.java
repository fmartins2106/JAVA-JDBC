package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.ClienteCPF39;
import academy.devdojo.maratonajava.javacore.excessoes.ClienteNome39;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaDuplicada39;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaInvalida39;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco39 {
    private List<Conta39> conta39s;

    public Banco39(){
        this.conta39s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente39.validacaoNome(nome);
                return Cliente39.formatoNome(nome);
            }catch (ClienteNome39 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Cliente39.validacaoCpf(cpf);
                return cpf;
            }catch (ClienteCPF39 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine().trim());
                Conta39.validacaoNumeroConta(numeroConta);
                Conta39.validacaoContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (NumeroContaInvalida39 | NumeroContaDuplicada39 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta39.TipoConta39 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o tipo de conta: [1]Conta corrente | [2]Conta poupança:");
                int tipoConta = Integer.parseInt(scanner.nextLine().trim());
                if (tipoConta == 1){
                    return Conta39.TipoConta39.CORRENTE;
                } else if (tipoConta == 2) {
                    return Conta39.TipoConta39.POUPANÇA;
                }else {
                    System.out.println("Opção inválida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public void addConta(Conta39 conta39){
        conta39s.add(conta39);
        System.out.println("Conta criada com sucesso.");
    }

    public void listarContasCadastradas(){
        if (conta39s.isEmpty()){
            System.out.println("Nenhuma conta foi cadastrada.");
            return;
        }
        conta39s.forEach(System.out::println);
    }

    public Optional<Conta39> pesquisaPorNumeroConta(Scanner scanner){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine().trim());
            Conta39.validacaoNumeroConta(numeroConta);
            if (conta39s.isEmpty()){
                System.out.println("Nenhuma conta foi cadastrada.");
                return Optional.empty();
            }
            Optional<Conta39> contaEncontrada = conta39s.stream().filter(conta39 -> conta39.numeroConta == numeroConta).findFirst();
            if (contaEncontrada.isPresent()){
                return contaEncontrada;
            }
            System.out.println("Nenhuma conta foi encontrada.");
            return Optional.empty();
        }catch (NumberFormatException e){
            System.out.println("Digite um número válido.");
            return Optional.empty();
        }catch (NumeroContaInvalida39 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void depositar(Scanner scanner){
        Optional<Conta39> conta39Optional = pesquisaPorNumeroConta(scanner);
        if (conta39Optional.isPresent()){
            Conta39 conta39 = conta39Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta39.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void sacar(Scanner scanner){
        Optional<Conta39> conta39Optional = pesquisaPorNumeroConta(scanner);
        if (conta39Optional.isPresent()){
            Conta39 conta39 = conta39Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta39.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void bloquearConta(Scanner scanner){
        Optional<Conta39> conta39Optional = pesquisaPorNumeroConta(scanner);
        if (conta39Optional.isPresent()){
            Conta39 conta39 = conta39Optional.get();
            conta39.bloquearConta();
        }
    }

    public void desbloquearConta(Scanner scanner){
        Optional<Conta39> conta39Optional = pesquisaPorNumeroConta(scanner);
        if (conta39Optional.isPresent()){
            Conta39 conta39 = conta39Optional.get();
            conta39.contaDesbloqueada();
        }
    }

    public void cancelarConta(Scanner scanner){
        Optional<Conta39> conta39Optional = pesquisaPorNumeroConta(scanner);
        if (conta39Optional.isPresent()){
            Conta39 conta39 = conta39Optional.get();
            conta39.contaCancelada();
        }
    }
}

