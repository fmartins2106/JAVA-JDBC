package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.ClienteCPF40;
import academy.devdojo.maratonajava.javacore.excessoes.ClienteNome40;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaDuplicada40;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaInvalida40;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco40 {
    private List<Conta40> conta40s;

    public Banco40(){
        this.conta40s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o nome:");
                String nome = scanner.nextLine().trim();
                Cliente40.validacaoNome(nome);
                return Cliente40.formatoNome(nome);
            }catch (ClienteNome40 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Cliente40.validacaoCpf(cpf);
                return cpf;
            }catch (ClienteCPF40 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine().trim());
                Conta40.validacaoNumeroConta(numeroConta);
                Conta40.validacaoNumeroContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (NumeroContaInvalida40 | NumeroContaDuplicada40 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta40.TipoConta40 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite o tipo de conta -> [1]Conta corrente. [2]Conta poupança.");
                int tipoConta = Integer.parseInt(scanner.nextLine().trim());
                switch (tipoConta){
                    case 1:
                        return Conta40.TipoConta40.CORRENTE;
                    case 2:
                        return Conta40.TipoConta40.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta40 conta40){
        conta40s.add(conta40);
    }

    public void listarContas(){
        if (conta40s.isEmpty()){
            System.out.println("Conta inválida.");
            return;
        }
        conta40s.forEach(System.out::println);
    }

    public Optional<Conta40> pesquisaNumeroConta(Scanner scanner){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine().trim());
            Conta40.validacaoNumeroConta(numeroConta);
            if (conta40s.isEmpty()){
                System.out.println("Nenhuma conta foi cadastrada.");
                return Optional.empty();
            }
            Optional<Conta40> numeroContaEncontrada = conta40s.stream().filter(conta40 -> conta40.numeroConta == numeroConta).findFirst();
            if (numeroContaEncontrada.isPresent()){
                return numeroContaEncontrada;
            }
            System.out.println("Número de conta não encontrada.");
            return Optional.empty();
        }catch (NumberFormatException e){
            System.out.println("Número de conta inválido.");
            return Optional.empty();
        }catch (NumeroContaInvalida40 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void realizarDeposito(Scanner scanner){
        Optional<Conta40> conta40Optional = pesquisaNumeroConta(scanner);
        if (conta40Optional.isPresent()){
            Conta40 conta40 = conta40Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta40.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void realizarSaque(Scanner scanner){
        Optional<Conta40> conta40Optional = pesquisaNumeroConta(scanner);
        if (conta40Optional.isPresent()){
            Conta40 conta40 = conta40Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta40.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void bloquearConta(Scanner scanner){
        Optional<Conta40> conta40Optional = pesquisaNumeroConta(scanner);
        if (conta40Optional.isPresent()){
            Conta40 conta40 = conta40Optional.get();
            conta40.bloquearConta();
        }
    }

    public void desbloquearConta(Scanner scanner){
        Optional<Conta40> conta40Optional = pesquisaNumeroConta(scanner);
        if (conta40Optional.isPresent()){
            Conta40 conta40 = conta40Optional.get();
            conta40.desbloquearConta();
        }
    }

    public void cancelarConta(Scanner scanner){
        Optional<Conta40> conta40Optional = pesquisaNumeroConta(scanner);
        if (conta40Optional.isPresent()){
            Conta40 conta40 = conta40Optional.get();
            conta40.cancelarConta();
        }
    }
}
