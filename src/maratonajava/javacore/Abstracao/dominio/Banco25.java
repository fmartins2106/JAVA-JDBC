package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco25 {
    private List<Conta25> conta25s;

    public Banco25(){
        this.conta25s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine();
                Cliente25.validacaoNome(nome);
                return Cliente25.formatoString(nome);
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
                Cliente25.validacaoCpf(cpf);
                return cpf;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                Conta25.validacaoNumeroConta(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta25.TipoConta25 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite [1] Conta corrente | [2] Conta poupaça.");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Conta25.TipoConta25.CORRENTE;
                    case 2:
                        return Conta25.TipoConta25.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida para definir o tipo de conta.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addConta(Conta25 conta25){
        conta25s.add(conta25);
    }

    public void listarContas(){
        if (conta25s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta25s.forEach(System.out::println);
        }
    }

    public Optional<Conta25> pesquisaPOrNumeroConta(Scanner scanner){
        try {
            System.out.print("Numero conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            if (conta25s == null || conta25s.isEmpty()){
                System.out.println("Lista vazia, nenhuma conta cadastrada.");
                return Optional.empty();
            }
            Optional<Conta25> contaEncontrada = conta25s.stream().filter(p -> p.getNumeroConta() == numeroConta).findFirst();
            if (!contaEncontrada.isPresent()){
                System.out.println("Conta não encontrada.");
            }
            return contaEncontrada;
        }catch (NumberFormatException e){
            System.out.println("Digite um número de conta válida.");
            return Optional.empty();
        }
    }

    public void validandoDeposito(Scanner scanner){
        Optional<Conta25> conta25Optional = pesquisaPOrNumeroConta(scanner);
        if (conta25Optional.isPresent()){
            Conta25 conta25 = conta25Optional.get();
            try {
                System.out.print("Digite o valor do depósito:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta25.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para depósito.");
            }
        }
    }

    public void validandoSaque(Scanner scanner){
        Optional<Conta25> conta25Optional = pesquisaPOrNumeroConta(scanner);
        if (conta25Optional.isPresent()){
            Conta25 conta25 = conta25Optional.get();
            try {
                System.out.print("Valor do saque:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta25.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para saque.");
            }
        }
    }

    public void AlterandoStatusConta(Scanner scanner, String acao){
        Optional<Conta25> conta25Optional = pesquisaPOrNumeroConta(scanner);
        if (conta25Optional.isPresent()){
            Conta25 conta25 = conta25Optional.get();
            if (acao.equalsIgnoreCase("bloquear")){
                conta25.bloquearConta();
            } else if (acao.equalsIgnoreCase("desbloquear")) {
                conta25.desbloquearConta();
            }else {
                conta25.cancelarConta();
            }
        }
    }
}
