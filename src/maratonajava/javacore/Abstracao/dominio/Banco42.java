package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CpfCliente42;
import academy.devdojo.maratonajava.javacore.excessoes.NomeCliente42;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaDuplicada42;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaInvalida42;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco42 {
    private static Scanner scanner = new Scanner(System.in);
    private List<Conta42> conta42s;

    public Banco42(){
        this.conta42s = new ArrayList<>();
    }

    public static String validandoNome(){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente42.validacaoNome(nome);
                return Cliente42.formatoString(nome);
            }catch (NomeCliente42 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Cliente42.validacaoCpf(cpf);
                return cpf;
            }catch (CpfCliente42 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoConta(){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine().trim());
                Conta42.validacaoNumeroConta(numeroConta);
                Conta42.validacaoContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite números válidos.");
            }catch (NumeroContaDuplicada42 | NumeroContaInvalida42 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta42.TipoConta42 validandoTipoConta(){
        while (true){
            try {
                System.out.print("Tipo da conta -> [1]Conta corrente. | [2]Conta poupança.");
                int tipoConta = Integer.parseInt(scanner.nextLine().trim());
                switch (tipoConta){
                    case 1:
                        return Conta42.TipoConta42.CORRENTE;
                    case 2:
                        return Conta42.TipoConta42.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma opção válida.");
            }
        }
    }

    public void addContaSistema(Conta42 conta42){
        conta42s.add(conta42);
        System.out.println("Conta casdastrada com sucesso.");
    }

    public void listarContasCadastradas(){
        if (conta42s.isEmpty()){
            System.out.println("Nenhum conta foi cadastrada.");
            return;
        }
        conta42s.forEach(System.out::println);
    }

    public Optional<Conta42> pesquisaPorNumeroConta(){
        if (conta42s.isEmpty()){
            System.out.println("Nenhuma conta foi cadastrada.");
            return Optional.empty();
        }
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine().trim());
            Conta42.validacaoNumeroConta(numeroConta);
            Optional<Conta42> conta42 = conta42s.stream().filter(conta43 -> conta43.numeroConta == numeroConta).findFirst();
            if (conta42.isPresent()){
                return conta42;
            }
            System.out.println("Número de conta não encontrada.");
            return Optional.empty();
        }catch (NumberFormatException e){
            System.out.println("Erro. Número de conta inválida.");
            return Optional.empty();
        }
    }

    public void depositar(){
        Optional<Conta42> conta42 = pesquisaPorNumeroConta();
        if (conta42.isPresent()){
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta42.get().depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido.");
            }
        }
    }

    public void sacar(){
        Optional<Conta42> conta42 = pesquisaPorNumeroConta();
        if (conta42.isPresent()){
            try {
                System.out.print("Saque:R$");
                double saque = Double.parseDouble(scanner.nextLine().trim());
                conta42.get().sacar(saque);
            }catch (NumberFormatException e){
                System.out.println("Erro. Valor inválido.");
            }
        }
    }
    public void alterarConta(String acao){
        Optional<Conta42> conta42 = pesquisaPorNumeroConta();
        if (conta42.isPresent()){
            if (acao.equalsIgnoreCase("bloquear")){
                conta42.get().bloquearConta();
            } else if (acao.equalsIgnoreCase("desbloquear")) {
                conta42.get().desbloquearConta();
            }else {
                conta42.get().cancelarConta();
            }
        }
    }


}
