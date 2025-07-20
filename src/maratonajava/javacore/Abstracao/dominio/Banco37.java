package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.ClienteCPF37;
import academy.devdojo.maratonajava.javacore.excessoes.ClienteNome37;
import academy.devdojo.maratonajava.javacore.excessoes.NumercContaDuplicada37;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaInvalida37;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco37 {
    private List<Conta37> conta37s;

    public Banco37(){
        this.conta37s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente37.validacaoNome(nome);
                return Cliente37.formatoNome(nome);
            }catch (ClienteNome37 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Cliente37.validacaoCpf(cpf);
                return cpf;
            }catch (ClienteCPF37 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Número conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine().trim());
                Conta37.validacaoNumeroConta(numeroConta);
                Conta37.validacaoContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (NumeroContaInvalida37 | NumercContaDuplicada37 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta37.TipoConta37 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite uma das opções: [1]Conta corrente | [2]Conta poupança.");
                int tipoConta = Integer.parseInt(scanner.nextLine().trim());
                switch (tipoConta){
                    case 1:
                        return Conta37.TipoConta37.CORRENTE;
                    case 2:
                        return Conta37.TipoConta37.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta37 conta37){
        conta37s.add(conta37);
    }

    public void listarContasCadastradas(){
        if (conta37s.isEmpty()){
            System.out.println("Nenhuma conta foi cadastrada.");
            return;
        }
        conta37s.forEach(System.out::println);
    }

    public Optional<Conta37> pesquisaPorNumeroConta(Scanner scanner){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine().trim());
            Conta37.validacaoNumeroConta(numeroConta);
            if (conta37s.isEmpty()){
                System.out.println("Nenhuma conta foi cadastrada.");
                return Optional.empty();
            }
            Optional<Conta37> numeroDeContaEncontrada = conta37s.stream().filter(conta37 -> conta37.numeroConta == numeroConta).findFirst();
            if (numeroDeContaEncontrada.isPresent()){
                return numeroDeContaEncontrada;
            }
            System.out.println("Número de conta não encontrada.");
            return Optional.empty();
        }catch (NumeroContaInvalida37 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void depositar(Scanner scanner){
        Optional<Conta37> conta37Optional = pesquisaPorNumeroConta(scanner);
        if (conta37Optional.isPresent()){
            Conta37 conta37 = conta37Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta37.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void sacar(Scanner scanner){
        Optional<Conta37> conta37Optional = pesquisaPorNumeroConta(scanner);
        if (conta37Optional.isPresent()){
            Conta37 conta37 = conta37Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta37.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void alterarStatusConta(Scanner scanner, String acao){
        Optional<Conta37> conta37Optional = pesquisaPorNumeroConta(scanner);
        if (conta37Optional.isPresent()){
            Conta37 conta37 = conta37Optional.get();
            if (acao.equals("bloquear")){
                conta37.bloquearConta();
            } else if (acao.equals("desbloquear")) {
                conta37.desbloquearConta();
            }else {
                conta37.cancelarConta();
            }
        }
    }
}
