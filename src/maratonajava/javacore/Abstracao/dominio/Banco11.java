package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco11 {
    private List<Conta11>conta11s;

    public Banco11(){
        this.conta11s = new ArrayList<>();
    }

     private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente11.MensagensValidacao11.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
     }

     private boolean validacaoCpf(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}") || !isCpfValido(cpf)){
            System.out.println(Cliente11.MensagensValidacao11.ERRO_CPF.getDescricao());
            return false;
        }
        return true;
     }

     private boolean isCpfValido(String cpf){
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

     private boolean validacaoNumeroConta(int numeroConta){
        String numeroContaStr = String.valueOf(numeroConta);
        if (numeroContaStr.length() != Conta11.DIGITOS_NUMEROS_CONTA){
            System.out.println(Cliente11.MensagensValidacao11.ERRO_DIGITOS_CONTAS.getDescricao());
            return false;
        }
        return true;
     }

     public static String validandoNome(Scanner scanner, Banco11 banco11){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco11.validacaoNome(nome)){
                return Cliente11.formatoNome(nome);
            }
        }
     }

     public static String validandoCpf(Scanner scanner, Banco11 banco11){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco11.validacaoCpf(cpf)){
                return cpf;
            }
        }
     }

     public static int validandoConta(Scanner scanner, Banco11 banco11){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco11.validacaoNumeroConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException w){
                System.out.println("Digite um número de conta válido.");
            }
        }
     }

     public static Cliente11.TipoConta11 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.println("Escolha o tipo de conta.");
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupança.");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Cliente11.TipoConta11.CORRENTE;
                    case 2:
                        return Cliente11.TipoConta11.POUPANCA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
     }

     public void addContas(Conta11 conta11){
        conta11s.add(conta11);
     }

     public void listarConta(){
        if (conta11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else{
            conta11s.forEach(System.out::println);
        }
     }

     public void depositar(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta11 conta11 : conta11s){
                if (conta11.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Digite valor do depósito:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta11.deposito(valor);
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException w){
            System.out.println("Digite um valor válido.");
        }
     }

     public void sacar(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta11 conta11 : conta11s){
                if (conta11.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do saque:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta11.sacar(valor);
                    }catch (NumberFormatException w){
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
            for (Conta11 conta11 : conta11s){
                if (conta11.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    if (acao.equals("bloquear")){
                        conta11.bloquearConta();
                    }else {
                        conta11.encerrarConta();
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

     public void desbloquearConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta11 conta11 : conta11s){
                if (conta11.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta11.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um número de conta válido.");
        }
     }

    public List<Conta11> getConta11s() {
        return conta11s;
    }
}
