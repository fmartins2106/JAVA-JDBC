package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco15 {
    private List<Conta15> conta15s;

    public Banco15(){
        this.conta15s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente15.MensagensErroCliente15.ERRO_NOME.getDescricao());
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

        int soma = 0;
        for (int i = 0; i < 9; i++) {
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
        if (numeroContaStr.length() != Conta15.DIGITOS_CONTA){
            System.out.println(Cliente15.MensagensErroCliente15.DIGITOS_CONTA.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Banco15 banco15){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco15.validacaoNome(nome)){
                return Cliente15.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco15 banco15){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco15.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner, Banco15 banco15){
        while (true){
            try {
                System.out.print("Número conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco15.validacaoNumeroConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
        }
    }

    public static Cliente15.TipoConta15 validandoTipoConta(Scanner scanner, Banco15 banco15){
        while (true){
            try {
                System.out.println("TIPOS DE CONTA.");
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupança.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente15.TipoConta15.CORRENTE;
                    case 2:
                        return Cliente15.TipoConta15.POUPANCA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addContas(Conta15 conta15){
        conta15s.add(conta15);
    }

    public void listaContas(){
        if (conta15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta15s.forEach(System.out::println);
        }
    }

    public void depositar(Scanner scanner, Banco15 banco15){
        int numeroConta = Banco15.validandoNumeroConta(scanner,banco15);
        boolean contaEncontrada = false;
        for (Conta15 conta15 : conta15s){
            if (conta15.getNumeroConta() == numeroConta){
                contaEncontrada = true;
                try {
                    System.out.print("Valor do depósito:R$");
                    double valor = Double.parseDouble(scanner.nextLine());
                    conta15.deposito(valor);
                }catch (NumberFormatException e){
                    System.out.println("Valor inválido.");
                }
            }
        }
        if (!contaEncontrada){
            System.out.println("Conta não encontrada.");
        }
    }

    public void saque(Scanner scanner, Banco15 banco15){
        int numeroConta = Banco15.validandoNumeroConta(scanner,banco15);
        boolean contaEncontrada = false;
        for (Conta15 conta15 : conta15s){
            if (conta15.getNumeroConta() == numeroConta){
                contaEncontrada = true;
                try {
                    System.out.print("Valor do saque:R$");
                    double valor = Double.parseDouble(scanner.nextLine());
                    conta15.sacar(valor);
                }catch (NumberFormatException e){
                    System.out.println("Valor inválido.");
                }
            }
        }
        if (!contaEncontrada){
            System.out.println("Conta não encontrada.");
        }
    }

    public void alterarConta(Scanner scanner, Banco15 banco15, String acao){
        int numeroConta = Banco15.validandoNumeroConta(scanner,banco15);
        boolean contaEncontrada = false;
        for (Conta15 conta15 : conta15s){
            if (conta15.getNumeroConta() == numeroConta){
                contaEncontrada = true;
                if (acao.equals("bloquear")){
                    conta15.bloquearConta();
                }else {
                    conta15.cancelarConta();
                }
            }
        }
        if (!contaEncontrada){
            System.out.println("Conta não encontrada.");
        }
    }

    public void desbloquearConta(Scanner scanner, Banco15 banco15){
        int numeroConta = Banco15.validandoNumeroConta(scanner,banco15);
        boolean contaEncontrada = false;
        for (Conta15 conta15 : conta15s){
            if (conta15.getNumeroConta() == numeroConta){
                contaEncontrada = true;
                conta15.desbloquearConta();
            }
        }
        if (!contaEncontrada){
            System.out.println("Conta não encontrada.");
        }
    }



}
