package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco34 {
    private List<Conta34> conta34s;

    public Banco34(){
        this.conta34s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente34.validacaoNome(nome);
                return Cliente34.formatoNome(nome);
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
                Cliente34.validacaoCpf(cpf);
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
                Conta34.validacaoNumeroConta(numeroConta);
                Conta34.validacaoNumeroContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta34.TipoConta34 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite uma das opções -> [1]Conta corrente | [2]Conta poupança.");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Conta34.TipoConta34.CORRENTE;
                    case 2:
                        return Conta34.TipoConta34.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta34 conta34){
        conta34s.add(conta34);
    }

    public void listarContas(){
        if (conta34s.isEmpty()){
            System.out.println("Nenhuma conta foi cadastrada.");
            return;
        }
        conta34s.forEach(System.out::println);
    }

    public Optional<Conta34> pesquisaNumeroConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            Conta34.validacaoNumeroConta(numeroConta);
            if (conta34s.isEmpty()){
                System.out.println("Nenhuma conta foi cadastrada.");
                return Optional.empty();
            }
            Optional<Conta34> contaEncontrada = conta34s.stream().filter(conta34 -> conta34.numeroConta == numeroConta).findFirst();
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
        Optional<Conta34> conta34Optional = pesquisaNumeroConta(scanner);
        if (conta34Optional.isPresent()){
            Conta34 conta34 = conta34Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta34.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void sacar(Scanner scanner){
        Optional<Conta34> conta34Optional = pesquisaNumeroConta(scanner);
        if (conta34Optional.isPresent()){
            Conta34 conta34 = conta34Optional.get();
            try {
                System.out.print("Sacar:R$");
                double sacar = Double.parseDouble(scanner.nextLine());
                conta34.sacar(sacar);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void alterarStatusConta(Scanner scanner, String acao){
        Optional<Conta34> conta34Optional = pesquisaNumeroConta(scanner);
        if (conta34Optional.isPresent()){
            Conta34 conta34 = conta34Optional.get();
            if (acao.equalsIgnoreCase("bloquear")){
                conta34.bloquearConta();
            }else if (acao.equalsIgnoreCase("desbloquear")){
                conta34.desbloquearConta();
            }else {
                conta34.cancelarConta();
            }
        }
    }
}
