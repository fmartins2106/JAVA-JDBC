package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.*;

public class Banco28 {
    private List<Conta28> conta28s;

    public Banco28(){
        this.conta28s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente28.validacaoNome(nome);
                return Cliente28.formatoNome(nome);
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
                Cliente28.validacaoCpf(cpf);
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
                Conta28.validacaoDigitosNumeroConta(numeroConta);
                Conta28.validacaoContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta28.TipoConta28 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite [1] Conta corrente | [2] Conta poupança:");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Conta28.TipoConta28.CORRENTE;
                    case 2:
                        return Conta28.TipoConta28.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta28 conta28){
        conta28s.add(conta28);
    }

    public void listarContasCadastradas(){
        if (conta28s.isEmpty()){
            System.out.println("Conta vazia. Nenhuma conta foi cadastrada.");
        }else {
            conta28s.forEach(System.out::println);
        }
    }

    public Optional<Conta28> pesquisaPorNumeroDeConta(Scanner scanner){
        try {
            System.out.print("Número da conta.");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            Conta28.validacaoDigitosNumeroConta(numeroConta);
            if (conta28s == null || conta28s.isEmpty()){
                System.out.println("Lista vazia. Nenhuma conta foi cadastrada.");
                return Optional.empty();
            }
            Optional<Conta28> contaEncontrada = conta28s.stream().filter(conta28 -> conta28.getNumeroConta() == numeroConta).findFirst();
            if (contaEncontrada.isPresent()){
                return contaEncontrada;
            }
            System.out.println("Conta não encontrada.");
            return Optional.empty();
        }catch (NumberFormatException e){
            System.out.println("Digite um número de conta válido.");
            return Optional.empty();
        }
    }

    public void validandoDeposito(Scanner scanner){
        Optional<Conta28> conta28Optional = pesquisaPorNumeroDeConta(scanner);
        if (conta28Optional.isPresent()){
            Conta28 conta28 = conta28Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta28.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para depósito.");
            }
        }
    }

    public void validandoSaque(Scanner scanner){
        Optional<Conta28> conta28Optional = pesquisaPorNumeroDeConta(scanner);
        if (conta28Optional.isPresent()){
            Conta28 conta28 = conta28Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta28.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para saque.");
            }
        }
    }

    public void exibirDadosPesquisaNumeroConta(Scanner scanner){
        Optional<Conta28> conta28Optional = pesquisaPorNumeroDeConta(scanner);
        if (conta28Optional.isPresent()){
            Conta28 conta28 = conta28Optional.get();
            System.out.println("Nome:"+conta28.getCliente28().getNome());
            System.out.println("CPF:"+conta28.getCliente28().getCpf());
            System.out.println("Número de conta:"+conta28.getNumeroConta());
            System.out.println("Saldo:"+conta28.getSaldo());
            System.out.println("Tipo conta:"+conta28.getTipoConta28());
            System.out.println("Status conta:"+conta28.getStatusConta28());
        }
    }

    public void alterarStatusConta(Scanner scanner, String acao){
        Optional<Conta28> conta28Optional = pesquisaPorNumeroDeConta(scanner);
        if (conta28Optional.isPresent()){
            Conta28 conta28 = conta28Optional.get();
            if (acao.equalsIgnoreCase("bloquear")){
                conta28.bloquearConta();
            } else if (acao.equalsIgnoreCase("desbloquear")) {
                conta28.desbloqueada();
            }else {
                conta28.cancelarConta();;
            }
        }
    }

}
