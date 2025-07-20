package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco23 {
    private List<Conta23>conta23s;

    public Banco23(){
        this.conta23s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente23.validacaoNome(nome);
                return Cliente23.formatoString(nome);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Cliente23.validacaoCpf(cpf);
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
                Conta23.validacaoNumeroConta(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para o número de conta.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Cliente23.TipoConta23 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupança.");
                System.out.print("Digite uma das opções acima:");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Cliente23.TipoConta23.CORRENTE;
                    case 2:
                        return Cliente23.TipoConta23.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void addConta(Conta23 conta23){
        conta23s.add(conta23);
    }

    public void listarContas(){
        if (conta23s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta23s.forEach(System.out::println);
        }
    }

    public Optional<Conta23> pesquisaPorNumerConta(Scanner scanner){
        if (conta23s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            int numeroConta = validandoNumeroConta(scanner);
            Conta23 conta23 = conta23s.stream().filter(p -> p.getNumeroConta() == numeroConta).findFirst().orElse(null);
            return Optional.ofNullable(conta23);
        }
    }

    public void validandoDeposito(Scanner scanner){
        Optional<Conta23> conta23Optional = pesquisaPorNumerConta(scanner);
        if (conta23Optional.isPresent()){
            Conta23 conta23 = conta23Optional.get();
            try {
                System.out.print("Valor do depósito:");
                double valor = Double.parseDouble(scanner.nextLine());
                conta23.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para depósito.");
            }
        }else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void validandoSaque(Scanner scanner){
        Optional<Conta23> conta23Optional = pesquisaPorNumerConta(scanner);
        if (conta23Optional.isPresent()){
            Conta23 conta23 = conta23Optional.get();
            try {
                System.out.print("Valor do saque:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta23.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para saque.");
            }
        }else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void validandoContaBloqueada(Scanner scanner){
        Optional<Conta23> conta23Optional = pesquisaPorNumerConta(scanner);
        if (conta23Optional.isPresent()){
            Conta23 conta23 = conta23Optional.get();
            conta23.bloquearConta();
        }else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void desbloquearConta(Scanner scanner){
        Optional<Conta23> conta23Optional = pesquisaPorNumerConta(scanner);
        if (conta23Optional.isPresent()){
            Conta23 conta23 = conta23Optional.get();
            conta23.desbloquearConta();
        }else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void alterarConta(Scanner scanner, String acao){
        Optional<Conta23> conta23Optional = pesquisaPorNumerConta(scanner);
        if (conta23Optional.isPresent()){
            Conta23 conta23 = conta23Optional.get();
            if (acao.equalsIgnoreCase("bloquear")){
                conta23.bloquearConta();
            }else {
                conta23.cancelamentoConta();
            }
        }
    }

}
