package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco05 {
    private List<Conta05>conta05s;

    public Banco05(){
        this.conta05s = new ArrayList<>();
    }

    public boolean validandoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente05.Mensagens.ERR0_NOME.getDescricao());
            return false;
        }
        return true;
    }

    public boolean validandoCpf(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}")){
            return false;
        }
        if (cpf.chars().distinct().count() == 1){
            return false;
        }

        int soma = 0;
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
        if (numeroContaStr.length() != Conta05.TOTAL_DIGITOS_CONTAS){
            System.out.println(Cliente05.Mensagens.ERRO_CONTA_DIGITOS.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner,Banco05 banco05){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco05.validandoNome(nome)){
                return Cliente05.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco05 banco05){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco05.validandoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner, Banco05 banco05){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco05.validacaoNumeroConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException e){
                System.out.println(Cliente05.Mensagens.ERRO_CONTA_DIGITOS.getDescricao());
            }
        }
    }

    public static Cliente05.Tipo validandoTipoConta(Scanner scanner, Banco05 banco05){
        while (true){
            int opcao=0;
            try {
                System.out.println("TIPOS DE CONTA.");
                System.out.println("[1] Conta Corrente.");
                System.out.println("[2] Conta Poupança.");
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente05.Tipo.CORRENTE;
                    case 2:
                        return Cliente05.Tipo.POUPANCA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addContas(Conta05 conta05){
        conta05s.add(conta05);
    }

    public void listaContas(){
        if (conta05s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta05s.forEach(System.out::println);
        }
    }

    public void realizadoDepositos(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta05 conta05 : conta05s){
                if (conta05.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor a depositar:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta05.depositar(valor);
                    }catch (NumberFormatException e){
                        System.out.println("Valor inválido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Número de conta inválido, tente novamente.");
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
            for (Conta05 conta05 : conta05s){
                if (conta05.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Quanto gostaria de sacar?:R$");
                        double saque = Double.parseDouble(scanner.nextLine());
                        if ( saque < conta05.getSaldo()){
                            conta05.saque(saque);
                            return;
                        }else {
                            System.out.println("Saque não pode ser maior que saldo.");
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

    public void alterandoDadosConta(Scanner scanner, String acao){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta05 conta05 : conta05s){
                if (conta05.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    if (acao.equals("bloquear")){
                        conta05.bloquearConta();
                    }else {
                        conta05.encerrarConta();
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Número de conta não encontrada.");
        }
    }

    public void desbloquearConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta05 conta05 : conta05s){
                if (conta05.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta05.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Número de conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Número de conta não encontrado.");
        }
    }

    public List<Conta05> getConta05s() {
        return conta05s;
    }
}
