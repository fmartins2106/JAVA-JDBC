package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco04 {
    private List<Conta04>conta04s;

    public Banco04(){
        this.conta04s = new ArrayList<>();
    }

    public boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente04.ValidacaoDescricao.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
    }

    public boolean validacaoCpf(String cpf){
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
        digito1= (digito1 >= 10) ? 0: digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public boolean validacaoConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != Conta04.DIGITOS_NUMERO_CONTA){
            System.out.println(Cliente04.ValidacaoDescricao.ERRO_CONTA.getDescricao());
            return false;
        }
        return true;
    }


    public static String validandoNome(Scanner scanner, Banco04 banco04){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco04.validacaoNome(nome)){
                return Cliente04.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco04 banco04){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco04.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner, Banco04 banco04){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco04.validacaoConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException e){
                System.out.println(Cliente04.ValidacaoDescricao.ERRO_CONTA.getDescricao());
            }
        }
    }

    public static Cliente04.TipoConta validandoTipoConta(Scanner scanner){
        while (true){
            int opcao=0;
            try {
                System.out.println("Escolha o tipo de conta.");
                System.out.println("[1] Conta Corrente.");
                System.out.println("[2] Conta Poupança.");
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    return Cliente04.TipoConta.CORRENTE;
                case 2:
                    return Cliente04.TipoConta.POUPANCA;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void listaContas(){
        if (conta04s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta04s.forEach(System.out::println);
        }
    }

    public void realizarDeposito(Scanner scanner){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta04 conta04: conta04s){
                if (conta04.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do depósito:R$");
                        double deposito = Double.parseDouble(scanner.nextLine());
                        conta04.depositar(deposito);
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Número de conta não encontrado.");
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
            for (Conta04 conta04 : conta04s){
                if (conta04.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do saque:R$");
                        double saque = Double.parseDouble(scanner.nextLine());
                        if (saque <= conta04.getSaldo()){
                            conta04.saque(saque);
                            return;
                        }else {
                            System.out.println("Saldo insuficiente.");
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
            System.out.println("Digite um valor válido.");
        }
    }

    public void alterarDadosConta(Scanner scanner, String acao){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEnccontrada = false;
            for (Conta04 conta04 : conta04s){
                if (conta04.getNumeroConta() == numeroConta){
                    contaEnccontrada = true;
                    if (acao.equals("bloquear")){
                        conta04.bloquearConta();
                    }else {
                        conta04.encerrarConta();
                    }
                }
            }
            if (!contaEnccontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public void desbloquearConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta04 conta04 : conta04s){
                if (conta04.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta04.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public void addDadosConta(Conta04 conta04){
        conta04s.add(conta04);
    }

    public List<Conta04> getConta04s() {
        return conta04s;
    }

}
