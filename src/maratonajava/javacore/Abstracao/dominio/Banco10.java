package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco10 {
    private List<Conta10> conta10s;

    public Banco10() {
        this.conta10s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome) {
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")) {
            System.out.println(Cliente10.ErrosValidados.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validandoCpf(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false;
        }
        if (cpf.chars().distinct().count() == 1) {
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0 : digito1;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0 : digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private boolean validacaoNumeroConta(int numeroConta) {
        if (numeroConta < Conta10.DIGITOS_PADRAO_CONTA) {
            System.out.println(Cliente10.ErrosValidados.ERRO_NUMERO_CONTA.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Banco10 banco10) {
        while (true) {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco10.validacaoNome(nome)) {
                return Cliente10.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco10 banco10) {
        while (true) {
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco10.validandoCpf(cpf)) {
                return cpf;
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner, Banco10 banco10) {
        while (true) {
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco10.validacaoNumeroConta(numeroConta)) {
                    return numeroConta;
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número de conta válido.");
            }
        }
    }

    public static Cliente10.TipoConta10 validandoTipoConta(Scanner scanner) {
        while (true) {
            int opcao = 0;
            try {
                System.out.println("TIPOS DE CONTA.");
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupança.");
                System.out.print("Escolha uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opçõa válida.");
            }
            switch (opcao) {
                case 1:
                    return Cliente10.TipoConta10.CORRENTE;
                case 2:
                    return Cliente10.TipoConta10.POUPANCA;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addContas(Conta10 conta10) {
        this.conta10s.add(conta10);
    }

    public void listaContas() {
        if (conta10s.isEmpty()) {
            System.out.println("lista vazia.");
        } else {
            conta10s.forEach(System.out::println);
        }
    }

    public void depositar(Scanner scanner, Banco10 banco10){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            if (validacaoNumeroConta(numeroConta)){
                for (Conta10 conta10 : conta10s){
                    if (conta10.getNumeroConta() == numeroConta){
                        contaEncontrada = true;
                        try {
                            System.out.print("Valor do depósito:");
                            double valor = Double.parseDouble(scanner.nextLine());
                            conta10.deposito(valor);
                        }catch (NumberFormatException e){
                            System.out.println("Digite um valor válido.");
                        }
                    }
                }
                if (!contaEncontrada){
                    System.out.println("Conta não cadastrada.");
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public void realizarTransferencia(Scanner scanner, Banco10 banco10){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta10 conta10 : conta10s){
                if (conta10.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    Banco10.validandoNumeroConta(scanner,banco10);
                    try {
                        System.out.print("Valor da transferência:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta10.transferencia(valor);
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um número válido.");
        }
    }

    public void alterarDados(Scanner scanner, String acao){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta10 conta10 : conta10s){
                if (conta10.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    if (acao.equals("bloquear")){
                        conta10.bloquearConta();
                    }else {
                        conta10.encerrarConta();
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
            for (Conta10 conta10 : conta10s){
                if (conta10.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta10.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e ){
            System.out.println("Número de conta inválido.");
        }
    }

    public List<Conta10> getConta10s() {
        return conta10s;
    }
}

