package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco18 {
    private List<Conta18> conta18s;

    public Banco18(){
        this.conta18s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente18.validacaoNome(nome);
                return Cliente18.formatoNome(nome);
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
                Cliente18.validacaoCpf(cpf);
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
                Conta18.validacaoNumeroConta(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Cliente18.TipoConta18 validandoTipoConta(Scanner scanner){
        while (true){
            System.out.println("[1] Conta corrente.");
            System.out.println("[2] Conta poupança.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente18.TipoConta18.CORRENTE;
                    case 2:
                        return Cliente18.TipoConta18.POUPANCA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addConta(Conta18 conta18){
        conta18s.add(conta18);
    }

    public void listarContas(){
        if (conta18s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta18s.forEach(System.out::println);
        }
    }

    public void depositar(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta18 conta18 : conta18s){
                if (conta18.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do depósito:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta18.deposito(valor);
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido para depósito.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Número de conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Número de conta não encontrado.");
        }
    }

    public void sacar(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta18 conta18 : conta18s){
                if (conta18.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do saque:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta18.sacar(valor);
                    }catch (NumberFormatException e){
                        System.out.println("Valor para saque inválido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public void alterarConta(Scanner scanner, String acao){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta18 conta18 : conta18s){
                if (conta18.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    if (acao.equalsIgnoreCase("bloquear")){
                        conta18.bloquearConta();
                    }else {
                        conta18.cancelamentoConta();
                    }
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um número de conta válido.");
        }
    }

    public void desbloquearConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta18 conta18 : conta18s){
                if (conta18.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta18.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

}
