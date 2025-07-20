package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.*;

public class Banco22 {
    private List<Conta22> conta22s;

    public Banco22(){
        this.conta22s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente22.validacaoNome(nome);
                return Cliente22.formatoString(nome);
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
                Cliente22.validacaoCpf(cpf);
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
                Conta22.validacaoNumeroConta(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public Cliente22.TipoConta22 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupaça.");
                System.out.println("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente22.TipoConta22.CORRENTE;
                    case 2:
                        return Cliente22.TipoConta22.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (IllegalArgumentException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta22 conta22){
        conta22s.add(conta22);
    }

    public void listaContas(){
        if (conta22s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta22s.forEach(System.out::println);
        }
    }

    private Optional<Conta22> pesquisaPorNumeroConta(Scanner scanner){
        if (conta22s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            int numeroConta = validandoNumeroConta(scanner);
            Conta22 conta22 = conta22s.stream().filter(p -> Objects.equals(p.getNumeroConta(),numeroConta)).findFirst().orElse(null);
            return Optional.ofNullable(conta22);
        }
    }

    public void validandoDeposito(Scanner scanner){
        Optional<Conta22> conta22Optional = pesquisaPorNumeroConta(scanner);
        if (conta22Optional.isPresent()){
            Conta22 conta22 = conta22Optional.get();
            try {
                System.out.println("Valor do depósito:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta22.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }else {
            System.out.println("Número de conta não encontrado.");
        }
    }

    public void validandoSaque(Scanner scanner){
        Optional<Conta22> conta22Optional = pesquisaPorNumeroConta(scanner);
        if (conta22Optional.isPresent()){
            Conta22 conta22 = conta22Optional.get();
            try {
                System.out.println("Valor do saque:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta22.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }else {
            System.out.println("Número de conta não encontrado.");
        }
    }

    public void validandoBloqueioConta(Scanner scanner){
        Optional<Conta22> conta22Optional = pesquisaPorNumeroConta(scanner);
        if (conta22Optional.isPresent()){
            Conta22 conta22 = conta22Optional.get();
            conta22.bloquearConta();
        }else {
            System.out.println("Número de conta não encontrado.");
        }
    }

    public void validandoDesbloqueioConta(Scanner scanner){
        Optional<Conta22> conta22Optional = pesquisaPorNumeroConta(scanner);
        if (conta22Optional.isPresent()){
            Conta22 conta22 = conta22Optional.get();
            conta22.desbloquearConta();
        }else {
            System.out.println("Número de conta não encontrado.");
        }
    }

    public void validandoCancelamentoConta(Scanner scanner){
        Optional<Conta22> conta22Optional = pesquisaPorNumeroConta(scanner);
        if (conta22Optional.isPresent()){
            Conta22 conta22 = conta22Optional.get();
            conta22.cancelarConta();
        }else {
            System.out.println("Digite um valor válido.");
        }
    }

}



