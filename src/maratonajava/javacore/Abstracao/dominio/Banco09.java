package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco09 {
    private List<Conta09>conta09s;

    public Banco09(){
        this.conta09s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente09.ErroMensagens.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")){
            return false;
        }
        if (cpf.chars().distinct().count() == 11){
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

    public boolean validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != Conta09.DIGITOS_CONTA){
            System.out.println(Cliente09.ErroMensagens.ERRO_CONTA.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Banco09 banco09){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco09.validacaoNome(nome)){
                return Cliente09.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco09 banco09){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco09.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner, Banco09 banco09){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco09.validacaoNumeroConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Cliente09.TipoContas validandoTipoDeConta(Scanner scanner, Banco09 banco09){
        while (true){
            int opcao=0;
            try {
                System.out.println("Tipo de conta.");
                System.out.println("[1] Conta Corrente.");
                System.out.println("[2] Conta poupança.");
                System.out.print("Escolha uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente09.TipoContas.CORRENTE;
                    case 2:
                        return Cliente09.TipoContas.POUPANCA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addContas(Conta09 conta09){
        conta09s.add(conta09);
    }

    public void listaContas(){
        if (conta09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta09s.forEach(System.out::println);
        }
    }

    public void realizarDeposito(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta09 conta09 : conta09s){
                if (conta09.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do depósito:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        if (valor > Conta09.SALDO_MINIMO){
                            conta09.deposistar(valor);
                        }else {
                            System.out.println("Valor inválido.");
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Valor de depósito inválido.");
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

    public void realizarSaque(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta09 conta09: conta09s){
                if (conta09.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do saque:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        if (valor <= conta09.getSaldo()){
                            conta09.saque(valor);
                        }else {
                            System.out.println("Valor de saque inválido. Consulte seu saldo.");
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Valor de conta inválido.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public void alterarDados(Scanner scanner, String acao){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta09 conta09 : conta09s){
                if (conta09.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    if (acao.equals("bloquear")){
                        conta09.bloquear();
                    }else {
                        conta09.encerrarConta();
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
            for (Conta09 conta09: conta09s){
                if (conta09.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta09.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Número de conta inválido.");
        }
    }

    public List<Conta09> getConta09s() {
        return conta09s;
    }
}
