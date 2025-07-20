package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.CpfCliente41;
import academy.devdojo.maratonajava.javacore.excessoes.NomeCliente41;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaDuplicada41;
import academy.devdojo.maratonajava.javacore.excessoes.NumeroContaInvalida41;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco41 {
    private List<Conta41> conta41s;

    public Banco41(){
        this.conta41s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente41.validacaoNome(nome);
                return Cliente41.formatoString(nome);
            }catch (NomeCliente41 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Cliente41.validacaoCpf(cpf);
                return cpf;
            }catch (CpfCliente41 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validacaoNumeroConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine().trim());
                Conta41.validacaoNumeroConta(numeroConta);
                Conta41.validacaoContaDuplicada(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (NumeroContaInvalida41 | NumeroContaDuplicada41 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Conta41.TipoConta41 validandoTipoConta41(Scanner scanner){
        while (true){
            try {
                System.out.print("Escolha o tipo de conta -> [1]Conta corrente |[2]Conta  Poupança.");
                int tipoConta = Integer.parseInt(scanner.nextLine().trim());
                switch (tipoConta){
                    case 1:
                        return Conta41.TipoConta41.CORRENTE;
                    case 2:
                        return Conta41.TipoConta41.POUPANÇA;
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addConta(Conta41 conta41){
        conta41s.add(conta41);
        System.out.println("Conta criada com sucesso.");
    }

    public void listarContas(){
        if (conta41s.isEmpty()){
            System.out.println("Nenhuma conta foi cadastrada.");
            return;
        }
        conta41s.forEach(System.out::println);
    }


    public Optional<Conta41> pesquisaPorNumeroConta(Scanner scanner){
        if (conta41s.isEmpty()){
            System.out.println("Nenhuma conta foi cadastrada.");
            return Optional.empty();
        }
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine().trim());
            Conta41.validacaoNumeroConta(numeroConta);
            Optional<Conta41> contaEncontrada = conta41s.stream().filter(conta41 -> conta41.numeroConta == numeroConta).findFirst();
            if (contaEncontrada.isPresent()){
                return contaEncontrada;
            }
            System.out.println("Nenhuma conta foi encontrada.");
            return Optional.empty();
        }catch (NumberFormatException e){
            System.out.println("Erro. Número inválido.");
            return Optional.empty();
        }catch (NumeroContaInvalida41 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void depositar(Scanner scanner){
        Optional<Conta41> conta41Optional = pesquisaPorNumeroConta(scanner);
        if (conta41Optional.isPresent()){
            Conta41 conta41 = conta41Optional.get();
            try {
                System.out.print("Digite o valor do depósito:");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta41.depositar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void sacar(Scanner scanner){
        Optional<Conta41> conta41Optional = pesquisaPorNumeroConta(scanner);
        if (conta41Optional.isPresent()){
            Conta41 conta41 = conta41Optional.get();
            try {
                System.out.print("Digite o número da conta:");
                double valor = Double.parseDouble(scanner.nextLine().trim());
                conta41.sacar(valor);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void cancelarConta(Scanner scanner){
        Optional<Conta41> conta41Optional = pesquisaPorNumeroConta(scanner);
        if (conta41Optional.isPresent()){
            Conta41 conta41 = conta41Optional.get();
            conta41.cancelarConta();
        }
    }

    public void alterarConta(Scanner scanner, String acao){
        Optional<Conta41> conta41Optional = pesquisaPorNumeroConta(scanner);
        if (conta41Optional.isPresent()){
            Conta41 conta41 = conta41Optional.get();
            if (acao.equalsIgnoreCase("bloquear")){
                conta41.bloquearConta();
                return;
            }
            conta41.desbloquearConta();
        }
    }
}

