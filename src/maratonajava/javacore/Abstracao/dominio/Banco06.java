package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco06 {
    private List<Conta06> conta06s;

    public Banco06(){
        this.conta06s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente06.Validation.ERRO_NOME.getDescricao());
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
        int soma=0;
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
        if (numeroContaStr.length() != Conta06.DIGITOS_NUMERO_CONTA){
            System.out.println(Cliente06.Validation.ERRO_DIGITOS_CONTA.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Banco06 banco06){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco06.validacaoNome(nome)){
                return Cliente06.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco06 banco06){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco06.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoContaCorrente(Scanner scanner, Banco06 banco06){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco06.validacaoNumeroConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException e){
                System.out.println(Cliente06.Validation.ERRO_DIGITOS_CONTA.getDescricao());
            }
        }
    }

    public static Cliente06.TipoDaConta validandoTipoDaConta(Scanner scanner, Banco06 banco06){
        while (true){
            int opcao=0;
            try {
                System.out.println("Tipos de conta.");
                System.out.println("[1] Conta Corrente.");
                System.out.println("[2] Conta poupança.");
                System.out.print("Digite uma opção válida:");
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente06.TipoDaConta.CORRENTE;
                    case 2:
                        return Cliente06.TipoDaConta.POUPANCA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta06 conta06){
        conta06s.add(conta06);
    }

    public void listaContas() {
        if (conta06s.isEmpty()) {
            System.out.println("Lista vazia");
        } else {
            conta06s.forEach(System.out::println);
        }
    }

    public void realizarDeposito(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta06 conta06 : conta06s){
                if (conta06.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do depósito:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta06.depositar(valor);
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
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

    public void realizarSaque(Scanner scanner){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta06 conta06 : conta06s){
                if (conta06.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do saque:R$");
                        double saque = Double.parseDouble(scanner.nextLine());
                        if (saque <= conta06.getSaldo()){
                            conta06.saque(saque);
                            return;
                        }else {
                            System.out.println("Valor do saque não pode ser maior que saldo.");
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Fomato inválido. Tente novamente.");
        }
    }

    public void alterarDados(Scanner scanner, String acao){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontada = false;
            for (Conta06 conta06 : conta06s){
                if (conta06.getNumeroConta() == numeroConta){
                    contaEncontada = true;
                    if (acao.equals("bloquear")){
                        conta06.bloquearConta();
                    }else {
                        conta06.encerrarConta();
                    }
                }
            }
            if (!contaEncontada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public void desbloquearConta(Scanner scanner){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta06 conta06: conta06s){
                if (conta06.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta06.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public List<Conta06> getConta06s() {
        return conta06s;
    }
}

