package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco02 {
    private List<Conta02>conta02s;

    public Banco02(){
        this.conta02s = new ArrayList<>();
    }

    public void addConta(Conta02 conta02){
        conta02s.add(conta02);
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente02.MensagemValidacao.ERRO_NOME);
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
        int soma=0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10  - i);
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

    private boolean validacaoNumeroConta(int conta){
        if (conta < Conta02.NUMERO_CONTA){
            System.out.println(Cliente02.MensagemValidacao.ERRO_NUMERO_CONTA);
            return false;
        }
        String numeroStr = String.valueOf(conta);
        if (numeroStr.length() != Conta02.NUMERO_CONTA){
            System.out.println(Cliente02.MensagemValidacao.ERRO_NUMERO_CONTA);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Banco02 banco02){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco02.validacaoNome(nome)){
                return Cliente02.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco02 banco02){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco02.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoConta(Scanner scanner, Banco02 banco02){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco02.validacaoNumeroConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException e){
                System.out.println("Número da conta inválida.");
            }
        }
    }

    public static Cliente02.TipoConta validandoTipoDeConta(Scanner scanner){
        while (true){
            System.out.println("TIPO DE CONTA.");
            System.out.println("[1] CONTA CORRENTE.");
            System.out.println("[2] CONTA POUPANÇA.");
            try {
                System.out.print("Digite o número da conta:");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Cliente02.TipoConta.CORRENTE;
                    case 2:
                        return Cliente02.TipoConta.POUPANCA;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaContas(Scanner scanner){
        if (conta02s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta02s.forEach(System.out::println);
        }
    }

    public void  realizarDeposito(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta02 conta02 : conta02s){
                if (conta02.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Digite o valor do depósito:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta02.depositar(valor);
                        return;
                    }catch (NumberFormatException e){
                        System.out.println("Valor inválidoo.");
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

    public void realizarSaque(Scanner scanner){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            for (Conta02 conta02 : conta02s){
                if (conta02.getNumeroConta() == numeroConta){
                    try {
                        System.out.println("Digite o valor do saque:R$");
                        double saque = Double.parseDouble(scanner.nextLine());
                        if (saque <= conta02.saldo){
                            conta02.validacaoSaque(saque);
                            return;
                        }else {
                            System.out.println("Valor de saque não pode ser maior que saldo conta.");
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido para sacar.");
                    }
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public void  alterarDadosConta(Scanner scanner, String acao){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            for (Conta02 conta02 : conta02s){
                if (conta02.getNumeroConta() == numeroConta){
                    if (acao.equals("bloquear")){
                        conta02.bloquearConta();
                    }else {
                        conta02.encerrarConta();
                    }
                    return;
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Conta não encontrada.");
        }
    }

    public void desbloquearConta(Scanner scanner){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta02 conta02 : conta02s){
                if (conta02.getNumeroConta() == numeroConta){
                    conta02.desbloquearConta();
                    return;
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e ){
            System.out.println("Conta não encontrada.");
        }
    }
}
