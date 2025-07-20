package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.*;

public class Banco26 {
    private List<Conta26> conta26s;

    public Banco26(){
        this.conta26s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente26.validacaoNome(nome);
                return Cliente26.formatoString(nome);
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
                Cliente26.validacaoCpf(cpf);
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
                Conta26.validacaoNumeroConta(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para número de conta.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta26.TipoConta26 validandoTipoConta26(Scanner scanner){
        while (true){
            try {
                System.out.println("Digite [1] Conta Corrente | [2] Conta Poupança.");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                if (tipoConta == 1){
                    return Conta26.TipoConta26.CORRENTE;
                }else if (tipoConta == 2){
                    return Conta26.TipoConta26.POUPANÇA;
                }else {
                    System.out.println("Digite apenas 1 para Conta corrente ou 2 para Conta poupança.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void addConta(Conta26 conta26){
        conta26s.add(conta26);
    }

    public void listaContas(){
        if (conta26s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma conta foi cadastrada.");
        }else {
            conta26s.forEach(System.out::println);
        }
    }

    public Optional<Conta26> pesquisaPorNumeroConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            if (conta26s == null || conta26s.isEmpty()){
                System.out.println("Lista vazia. Nenhuma conta foi cadastrada até o momento.");
                return Optional.empty();
            }
            Optional<Conta26> contaEncontrada = conta26s.stream().filter(p -> p.getNumeroConta() == numeroConta).findFirst();
            if (!contaEncontrada.isPresent()){
                System.out.println("Conta não cadastrada. Verifique!");
                return Optional.empty();
            }
            return contaEncontrada;
        }catch (NumberFormatException e){
            System.out.println("Digite um número de conta válido.");
            return Optional.empty();
        }
    }

    public void validandoDeposito(Scanner scanner){
        Optional<Conta26> conta26Optional = pesquisaPorNumeroConta(scanner);
        if (conta26Optional.isPresent()){
            Conta26 conta26 = conta26Optional.get();
            try {
                System.out.print("Valor do depósito:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta26.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void validandoSaque(Scanner scanner){
        Optional<Conta26> conta26Optional = pesquisaPorNumeroConta(scanner);
        if (conta26Optional.isPresent()){
            Conta26 conta26 = conta26Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta26.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para saque.");
            }
        }
    }

    public void bloquearConta(Scanner scanner){
        Optional<Conta26> conta26Optional = pesquisaPorNumeroConta(scanner);
        if (conta26Optional.isPresent()){
            Conta26 conta26 = conta26Optional.get();
            conta26.bloquearConta();
        }
    }

    public void desbloquearConta(Scanner scanner){
        Optional<Conta26> conta26Optional = pesquisaPorNumeroConta(scanner);
        if (conta26Optional.isPresent()){
            Conta26 conta26 = conta26Optional.get();
            conta26.desbloquearConta();
        }
    }

    public void cancelarConta(Scanner scanner){
        Optional<Conta26> conta26Optional = pesquisaPorNumeroConta(scanner);
        if (conta26Optional.isPresent()){
            Conta26 conta26 = conta26Optional.get();
            conta26.cancelarConta();
        }
    }
}
