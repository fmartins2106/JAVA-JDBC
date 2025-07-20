package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco13 {
    private List<Conta13> conta13s;

    public Banco13(){
        this.conta13s = new ArrayList<>();
    }

    public boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente13.MensagensValidacaoCliente13.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
    }

    public boolean validacaoCpf(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}")){
            return false;
        }
        if (cpf.chars().distinct().count() == 1 ){
            return false;
        }
        int soma =0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >=  10) ? 0: digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') ==digito2;
    }

    public boolean validacaoConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != Conta13.PADRAO_DIGITOS_CONTA){
            System.out.println(Cliente13.MensagensValidacaoCliente13.PADRAO_DIGITOS_CONTA.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Banco13 banco13){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco13.validacaoNome(nome)){
                return Cliente13.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner,Banco13 banco13){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco13.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner, Banco13 banco13){
        while (true){
            try {
                System.out.print("Número conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco13.validacaoConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }
        }
    }

    public static Cliente13.TipoConta13 validacaoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupança.");
                System.out.print("Digite uma das opções acima:");
                int opcaoConta = Integer.parseInt(scanner.nextLine());
                switch (opcaoConta){
                    case 1:
                        return Cliente13.TipoConta13.CORRENTE;
                    case 2:
                        return Cliente13.TipoConta13.POUPANCA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void deposito(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta13 conta13 : conta13s){
                if (conta13.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do depósito:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta13.depositar(valor);
                    }catch (NumberFormatException e){
                        System.out.println("Valor inválido.");
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

    public void saque(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta13 conta13 : conta13s){
                if (conta13.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do saque:R$");
                        double saque = Double.parseDouble(scanner.nextLine());
                        conta13.sacar(saque);
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
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

    public void alterarStatusConta(Scanner scanner, String acao){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta13 conta13 : conta13s){
                if (conta13.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    if (acao.equals("bloquear")){
                        conta13.bloquearConta();
                    }else {
                        conta13.encerrarConta();
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
            for (Conta13 conta13 : conta13s){
                if (conta13.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta13.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Número de contra inválido.");
        }
    }

    public void addConta(Conta13 conta13){
        conta13s.add(conta13);
    }

    public void listaConta(){
        if (conta13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta13s.forEach(System.out::println);
        }
    }

}
