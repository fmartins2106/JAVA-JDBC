package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.ClienteCPF38;
import academy.devdojo.maratonajava.javacore.excessoes.ClienteNome38;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaDuplicada38;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaInvalida38;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco38 {
    private List<Conta38> conta38s;

    public Banco38(){
        this.conta38s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente38.validacaoNome(nome);
                return Cliente38.formatoNome(nome);
            }catch (ClienteNome38 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Cliente38.validacaoCpf(cpf);
                return cpf;
            }catch (ClienteCPF38 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Número conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine().trim());
                Conta38.validacaoNumeroConta(numeroConta);
                Conta38.validacaoContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }catch (NumeroContaInvalida38 | NumeroContaDuplicada38 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta38.TipoConta38 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite uma das opções: [1]Conta corrente. [2]Conta poupança.");
                int tipoConta = Integer.parseInt(scanner.nextLine().trim());
                switch (tipoConta){
                    case 1:
                        return Conta38.TipoConta38.CORRENTE;
                    case 2:
                        return Conta38.TipoConta38.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta38 conta38){
        conta38s.add(conta38);
    }

    public void listarContasCadastradas(){
        if (conta38s.isEmpty()){
            System.out.println("Nenhuma conta foi cadastrada.");
            return;
        }
        conta38s.forEach(System.out::println);
    }

    public Optional<Conta38> pesquisaPorNumeroConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine().trim());
            Conta38.validacaoNumeroConta(numeroConta);
            if (conta38s.isEmpty()){
                System.out.println("Nenhuma conta foi encontrada.");
                return Optional.empty();
            }
            Optional<Conta38> contaEncontrada = conta38s.stream().filter(conta38 -> conta38.numeroConta == numeroConta).findFirst();
            if (contaEncontrada.isPresent()){
                return contaEncontrada;
            }
            System.out.println("Conta não encontrada.");
            return Optional.empty();
        }catch (NumberFormatException e){
            System.out.println("Digite um número de conta válido.");
            return Optional.empty();
        }catch (NumeroContaInvalida38 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void depositar(Scanner scanner){
        Optional<Conta38> conta38Optional = pesquisaPorNumeroConta(scanner);
        if (conta38Optional.isPresent()){
            Conta38 conta38 = conta38Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta38.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void sacar(Scanner scanner){
        Optional<Conta38> conta38Optional = pesquisaPorNumeroConta(scanner);
        if (conta38Optional.isPresent()){
            Conta38 conta38 = conta38Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta38.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void bloquearConta(Scanner scanner){
        Optional<Conta38> conta38Optional = pesquisaPorNumeroConta(scanner);
        if (conta38Optional.isPresent()){
            Conta38 conta38 = conta38Optional.get();
            conta38.bloquearConta();
        }
    }

    public void desbloquearConta(Scanner scanner){
        Optional<Conta38> conta38Optional = pesquisaPorNumeroConta(scanner);
        if (conta38Optional.isPresent()){
            Conta38 conta38 = conta38Optional.get();
            conta38.desbloquearConta();
        }
    }

    public void cancelarConta(Scanner scanner){
        Optional<Conta38> conta38Optional = pesquisaPorNumeroConta(scanner);
        if (conta38Optional.isPresent()){
            Conta38 conta38 = conta38Optional.get();
            conta38.cancelarConta();
        }
    }


}
