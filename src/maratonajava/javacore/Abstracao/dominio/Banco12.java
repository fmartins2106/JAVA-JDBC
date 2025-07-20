package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco12 {
    private List<Conta12> conta12s;

    public Banco12(){
        this.conta12s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente11.MensagensValidacao11.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")){
            return false;
        }
        if (cpf.chars().distinct().count() == 1){
            return false;
        }

        int soma =0;
        for (int i = 0; i <9 ; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 -i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private boolean validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != Conta12.DIGITOS_CONTA){
            System.out.println(Cliente12.ValidanacaoErrosCliente12.ERRO_DIGITOS_CONTA.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Banco12 banco12){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco12.validacaoNome(nome)){
                return Cliente12.formatoNomes(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco12 banco12){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco12.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner, Banco12 banco12){
        while (true){
            try {
                System.out.print("Número conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco12.validacaoNumeroConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Cliente12.TipoConta12 validandoTipoConta(Scanner scanner){
        while (true){
            System.out.println("[1] Conta corrente.");
            System.out.println("[2] Conta poupança.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente12.TipoConta12.CORRENTE;
                    case 2:
                        return Cliente12.TipoConta12.POUPANCA;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta12 conta12){
        conta12s.add(conta12);
    }

    public void listaConta(){
        if (conta12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta12s.forEach(System.out::println);
        }
    }

    public void depositar(Scanner scanner, Banco12 banco12){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta12 conta12 : conta12s){
                if (conta12.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do depósito:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta12.deposito(valor);
                    }catch (NumberFormatException e){
                        System.out.println("Valor inválido.");
                    }
                }
                if (!contaEncontrada){
                    System.out.println("Conta não encontrada.");
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public void saque(Scanner scanner, Banco12 banco12){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta12 conta12 : conta12s){
                if (conta12.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do saque:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta12.sacar(valor);
                    }catch (NumberFormatException e){
                        System.out.println("Valor inválido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um número de conta válido.");
        }
    }

    public void alterarConta(Scanner scanner, String acao){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta12 conta12 : conta12s){
                if (conta12.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    if (acao.equals("bloquear")){
                        conta12.bloquearConta();
                    }else {
                        conta12.encerrarConta();
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Número de conta inválido.");
        }
    }

    public void desbloquearConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta12 conta12 : conta12s){
                if (conta12.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta12.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public List<Conta12> getConta12s() {
        return conta12s;
    }
}
