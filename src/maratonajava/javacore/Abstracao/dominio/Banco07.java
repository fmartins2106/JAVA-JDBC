package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco07 {
    private List<Conta07>conta07s;

    public Banco07(){
        this.conta07s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente07.ValidationDescription.MENSAGEM_ERRO_NOME.getDescricao());
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
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
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
        if (numeroContaStr.length() != Conta07.DIGITOS_MINIMO_CONTA){
            System.out.println(Cliente07.ValidationDescription.MENSAGEM_ERR0_CONTA.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner,Banco07 banco07){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco07.validacaoNome(nome)){
                return Cliente07.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco07 banco07){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco07.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner, Banco07 banco07){
        while (true){
            try {
                System.out.print("Número conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco07.validacaoNumeroConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException e){
                System.out.println(Cliente07.ValidationDescription.MENSAGEM_ERR0_CONTA.getDescricao());
            }
        }
    }

    public static Cliente07.TipoContas validandoTipoConta(Scanner scanner, Banco07 banco07){
        while (true){
            int opcao = 0;
            try {
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupança.");
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente07.TipoContas.CORRENTE;
                    case 2:
                        return Cliente07.TipoContas.POUPANCA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addContas(Conta07 conta07){
        conta07s.add(conta07);
    }

    public void listarContasCadastradas(){
        if (conta07s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta07s.forEach(System.out::println);
        }
    }

    public void realizarDeposito(Scanner scanner){
        try {
            System.out.print("Numero da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta07 conta07 : conta07s){
                if (conta07.getNumeroConta() == numeroConta){
                    contaEncontrada =true;
                    try {
                        System.out.print("Valor do depósito:R$");
                        double deposito = Double.parseDouble(scanner.nextLine());
                        conta07.depositar(deposito);
                        System.out.println("Valor depositado com sucesso.");
                    }catch (NumberFormatException e){
                        System.out.println("Valor inválido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrtada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public void realizarSaque(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta07 conta07 : conta07s){
                if (conta07.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do saque:R$");
                        double saque = Double.parseDouble(scanner.nextLine());
                        if (saque <= (conta07.getSaldo()-5)){
                            conta07.saque(saque);
                        }else {
                            System.out.println("Valor inválido.");
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
            System.out.println("Conta inválida.");
        }
    }

    public void alterarDados(Scanner scanner, String acao){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta07 conta07 : conta07s){
                if (conta07.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    if (acao.equals("bloquear")){
                        conta07.bloquear();
                    }else {
                        conta07.encerrarConta();
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

    public void desbloquear(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta07 conta07: conta07s){
                if ( conta07.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta07.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um número de conta válido.");
        }
    }

    public List<Conta07> getConta07s() {
        return conta07s;
    }
}
