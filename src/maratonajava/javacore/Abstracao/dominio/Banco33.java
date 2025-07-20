package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco33 {
    private List<Conta33> conta33s;

    public Banco33(){
        this.conta33s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente33.validacaoNome(nome);
                return Cliente33.formatoNome(nome);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validadoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Cliente33.validacaoCpf(cpf);
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
                Conta33.validacaoNumeroConta(numeroConta);
                Conta33.validacaoContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta33.TipoConta33 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite [1]Conta corrente ou [2]Conta poupança.");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Conta33.TipoConta33.CORRENTE;
                    case 2:
                        return Conta33.TipoConta33.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta33 conta33){
        conta33s.add(conta33);
    }

    public void listarContasCadastradas(){
        if (conta33s.isEmpty()){
            System.out.println("Nenhuma conta foi cadastrada.");
        }else {
            conta33s.forEach(System.out::println);
        }
    }

    public Optional<Conta33> pesquisaNumeroConta(Scanner scanner){
        try {
            System.out.print("Número conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            Conta33.validacaoNumeroConta(numeroConta);
            if (conta33s.isEmpty()){
                System.out.println("Lista vazia. Nenhuma conta foi cadastrada.");
                return Optional.empty();
            }
            Optional<Conta33> contaEncontrada = conta33s.stream().filter(conta33 ->  conta33.numeroConta == numeroConta).findFirst();
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
        Optional<Conta33> conta33Optional = pesquisaNumeroConta(scanner);
        if (conta33Optional.isPresent()){
            Conta33 conta33 = conta33Optional.get();
            try {
                System.out.print("Digite o valor do depósito:R$");
                double valor = (Double.parseDouble(scanner.nextLine()));
                conta33.depositarValor(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void sacar(Scanner scanner){
        Optional<Conta33> conta33Optional = pesquisaNumeroConta(scanner);
        if (conta33Optional.isPresent()){
            Conta33 conta33 = conta33Optional.get();
            try {
                System.out.print("Valor dos saque:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta33.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void bloquearConta(Scanner scanner){
        Optional<Conta33> conta33Optional = pesquisaNumeroConta(scanner);
        if (conta33Optional.isPresent()){
            Conta33 conta33 = conta33Optional.get();
            conta33.bloquearConta();
        }
    }

    public void desbloquearConta(Scanner scanner){
        Optional<Conta33> conta33Optional = pesquisaNumeroConta(scanner);
        if (conta33Optional.isPresent()){
            Conta33 conta33 = conta33Optional.get();
            conta33.desbloquearConta();
        }
    }

    public void cancelarConta(Scanner scanner){
        Optional<Conta33> conta33Optional = pesquisaNumeroConta(scanner);
        if (conta33Optional.isPresent()){
            Conta33 conta33 = conta33Optional.get();
            conta33.cancelarConta();
        }
    }
}
