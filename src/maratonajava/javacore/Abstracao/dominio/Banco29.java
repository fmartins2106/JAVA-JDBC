package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco29 {
    private List<Conta29> conta29s;

    public Banco29(){
        this.conta29s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente29.validacaoNome(nome);
                return Cliente29.formatoNome(nome);
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
                Cliente29.validacaoCpf(cpf);
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
                Conta29.validaacaoNumeroConta(numeroConta);
                Conta29.validandoNumeroDeContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido para conta.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta29.TipoConta29 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite [1] Conta corrente ou [2] Conta poupança.");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Conta29.TipoConta29.CORRENTE;
                    case 2:
                        return Conta29.TipoConta29.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addContas(Conta29 conta29){
        conta29s.add(conta29);
    }

    public void listarContasCadastradas(){
        if (conta29s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma conta foi cadastrada.");
        }else {
            conta29s.forEach(System.out::println);
        }
    }

    public Optional<Conta29> pesquisaNumeroConta(Scanner scanner){
        try {
            System.out.print("Numero conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            Conta29.validaacaoNumeroConta(numeroConta);
            if (conta29s == null || conta29s.isEmpty()){
                System.out.println("Nenhum número de conta foi cadastrado.");
                return Optional.empty();
            }
            Optional<Conta29> contaEncontrada = conta29s.stream().filter(conta29 -> conta29.getNumeroConta() == numeroConta).findFirst();
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

    public void validandoDeposito(Scanner scanner){
        Optional<Conta29> conta29Optional = pesquisaNumeroConta(scanner);
        if (conta29Optional.isPresent()){
            Conta29 conta29 = conta29Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta29.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void validandoSaque(Scanner scanner){
        Optional<Conta29> conta29Optional = pesquisaNumeroConta(scanner);
        if (conta29Optional.isPresent()){
            Conta29 conta29 = conta29Optional.get();
            try {
                System.out.print("Valor:");
                double valor = Double.parseDouble(scanner.nextLine());
                conta29.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void bloquearConta(Scanner scanner){
        Optional<Conta29> conta29Optional = pesquisaNumeroConta(scanner);
        if (conta29Optional.isPresent()){
            Conta29 conta29 = conta29Optional.get();
            conta29.bloquearConta();
        }
    }

    public void desbloquearConta(Scanner scanner){
        Optional<Conta29> conta29Optional = pesquisaNumeroConta(scanner);
        if (conta29Optional.isPresent()){
            Conta29 conta29 = conta29Optional.get();
            conta29.desbloquearConta();
        }
    }

    public void cancelarConta(Scanner scanner){
        Optional<Conta29> conta29Optional = pesquisaNumeroConta(scanner);
        if (conta29Optional.isPresent()){
            Conta29 conta29 = conta29Optional.get();
            conta29.cancelarConta();
        }
    }

}
