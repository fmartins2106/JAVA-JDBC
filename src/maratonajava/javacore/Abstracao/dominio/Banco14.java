package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco14 {
    private List<Conta14> conta14s;

    public Banco14(){
        this.conta14s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente14.MensagensErroCliente14.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoCpf(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}")){
            return false;
        }
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma =0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private boolean validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != Conta14.DIGITOS_CONTA) {
            System.out.println(Cliente14.MensagensErroCliente14.VALIDACAO_DIGITOS_CONTA.getDescricao());
            return false;
        }
        return true;
    }

    public static String validacaoNome(Scanner scanner, Banco14 banco14){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco14.validacaoNome(nome)){
                return Cliente14.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco14 banco14){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco14.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner, Banco14 banco14){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco14.validacaoNumeroConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException e){
                System.out.println("Número de conta inválido.");
            }
        }
    }
    
    public static Cliente14.TipoConta14 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupança.");
                System.out.print("Escolha uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente14.TipoConta14.CORRENTE;
                    case 2:
                        return Cliente14.TipoConta14.POUPANCA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void validacaoDeposito(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta14 conta14 : conta14s){
                if (conta14.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do depósito:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta14.depositar(valor);
                    }catch (NumberFormatException e){
                        System.out.println("Valor inválido, verifique.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Digite um valor válido.");
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
            for (Conta14 conta14 :conta14s){
                if (conta14.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do saque:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta14.sacar(valor);
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

    public void alterarConta(Scanner scanner, String acao){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta14 conta14 : conta14s){
                if (conta14.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    if (acao.equals("bloquear")){
                        conta14.bloquearConta();
                    }else {
                        conta14.encerrarConta();
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Número inválido.");
        }
    }

    public void desbloquearConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta14 conta14 : conta14s){
                if (conta14.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta14.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Número de conta não encontrado.");
            }
        }catch (NumberFormatException e){
            System.out.println("Número de conta inválido.");
        }
    }

    public void addConta(Conta14 conta14){
        conta14s.add(conta14);
    }

    public void listaConta(){
        if (conta14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta14s.forEach(System.out::println);
        }
    }

    public List<Conta14> getConta14s() {
        return conta14s;
    }
}
