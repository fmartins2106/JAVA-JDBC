package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco32 {
    private List<Conta32> conta32s;

    public Banco32(){
        this.conta32s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente32.validacaoNome(nome);
                return Cliente32.formatoString(nome);
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
                Cliente32.validacaoCpf(cpf);
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
                Conta32.validacaoNumeroConta(numeroConta);
                Conta32.validacaoContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta32.TipoConta32 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Digite [1]Conta corrente ou [2]Conta poupança.");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Conta32.TipoConta32.CORRENTE;
                    case 2:
                        return Conta32.TipoConta32.POUPANÇA;
                    default:
                        System.out.println("Digite apenas 1 ou 2.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta32 conta32){
        conta32s.add(conta32);
    }

    public void listarContas(){
        if (conta32s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma conta foi cadastrada.");
        }else {
            conta32s.forEach(System.out::println);
        }
    }

    public Optional<Conta32> pesquisaPorNumeroConta(Scanner scanner){
        try {
            System.out.print("Número conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            Conta32.validacaoNumeroConta(numeroConta);
            if (conta32s.isEmpty()){
                System.out.println("Lista vazia, nenhuma conta foi cadastrada.");
                return Optional.empty();
            }
            Optional<Conta32> contaCadastrada = conta32s.stream().filter(conta32 -> conta32.numeroConta == numeroConta).findFirst();
            if (contaCadastrada.isPresent()){
                return contaCadastrada;
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
        Optional<Conta32> conta32Optional = pesquisaPorNumeroConta(scanner);
        if (conta32Optional.isPresent()){
            Conta32 conta32 = conta32Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta32.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void validandoSaque(Scanner scanner){
        Optional<Conta32> conta32Optional = pesquisaPorNumeroConta(scanner);
        if (conta32Optional.isPresent()){
            Conta32 conta32 = conta32Optional.get();
            try {
                System.out.print("Valor:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta32.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void excluirDadosConta(Scanner scanner){
        Optional<Conta32> conta32Optional = pesquisaPorNumeroConta(scanner);
        if (conta32Optional.isPresent()){
            Conta32 conta32 = conta32Optional.get();
            conta32s.remove(conta32);
            Conta32.contasCadastradas.remove(conta32.numeroConta);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void cancelarConta(Scanner scanner){
        Optional<Conta32> conta32Optional = pesquisaPorNumeroConta(scanner);
        if (conta32Optional.isPresent()){
            Conta32 conta32 = conta32Optional.get();
            conta32.cancelarConta();
        }
    }

    public void alterarConta(Scanner scanner, String acao){
        Optional<Conta32> conta32Optional = pesquisaPorNumeroConta(scanner);
        if (conta32Optional.isPresent()){
            Conta32 conta32 = conta32Optional.get();
            if (acao.equalsIgnoreCase("bloquear")){
                conta32.bloquearConta();
            }else {
                conta32.desbloquearConta();
            }
        }
    }
}
