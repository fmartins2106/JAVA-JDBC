package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco16 {
    private List<Conta16> conta16s;

    public Banco16(){
        this.conta16s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente16.validacaoNome(nome);
                return Cliente16.formatoNome(nome);
            }catch (IllegalArgumentException e){
                System.out.println(Cliente16.MensagensValidacaoCliente16.ERRO_NOME.getDescricao());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Cliente16.validacaoCpf(cpf);
                return cpf;
            }catch (IllegalArgumentException e){
                System.out.println(Cliente05.Mensagens.ERRO_CPF.getDescricao());
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                try {
                    Conta16.validacaoNumeroConta(numeroConta);
                    return numeroConta;
                }catch (IllegalArgumentException e){
                    System.out.println(Cliente16.MensagensValidacaoCliente16.ERRO_DIGITOS_CONTA.getDescricao());
                }
            }catch (NumberFormatException e){
                System.out.println(Cliente16.MensagensValidacaoCliente16.ERRO_DIGITOS_CONTA.getDescricao());
            }
        }
    }

    public static Cliente16.TipoContaCliente16 validandoTipoConta(Scanner scanner){
        while (true){
            System.out.println("[1] Conta corrente.");
            System.out.println("[2] Conta poupança.");
            try {
                System.out.print("Digite uma das opções acima:");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Cliente16.TipoContaCliente16.CORRENTE;
                    case 2:
                        return Cliente16.TipoContaCliente16.POUPANCA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addConta(Conta16 conta16){
        conta16s.add(conta16);
    }

    public void listarContas(){
        if (conta16s.isEmpty()){
            System.out.println("Conta vazia.");
        }else {
            conta16s.forEach(System.out::println);
        }
    }

    public void depositar(Scanner scanner){
        int numeroConta = Banco16.validandoNumeroConta(scanner);
        boolean contaEncontrada = false;
        for (Conta16 conta16 : conta16s){
            if (conta16.getNumeroConta() == numeroConta){
                contaEncontrada = true;
                try {
                    System.out.print("Digite o valor do deposito:R$");
                    double valor = Double.parseDouble(scanner.nextLine());
                    conta16.depositar(valor);
                }catch (NumberFormatException e){
                    System.out.println("Valor inválido para depósito.");
                }
            }
        }
        if (!contaEncontrada){
            System.out.println("Conta não encontrada.");
        }
    }

    public void sacar(Scanner scanner){
        int numeroConta = Banco16.validandoNumeroConta(scanner);
        boolean contaEncontrada = false;
        for (Conta16 conta16 : conta16s){
            if (conta16.getNumeroConta() == numeroConta){
                contaEncontrada = true;
                try {
                    System.out.print("Valor do saque:R$");
                    double valor = Double.parseDouble(scanner.nextLine());
                    conta16.sacar(valor);
                }catch (NumberFormatException e){
                    System.out.println("Valor inválido.");
                }
            }
        }
        if (!contaEncontrada){
            System.out.println("Conta não encontrada.");
        }
    }

    public void alterarStatusConta(Scanner scanner, String acao){
        int numeroConta = validandoNumeroConta(scanner);
        boolean contaEncontrada = false;
        for (Conta16 conta16 :conta16s){
            if (conta16.getNumeroConta() == numeroConta){
                contaEncontrada = true;
                if (acao.equalsIgnoreCase("bloquear")){
                    conta16.bloquearConta();
                }else {
                    conta16.encerrarConta();
                }
            }
        }
        if (!contaEncontrada){
            System.out.println("Conta não encontrada.");
        }
    }

    public void desbloquearConta(Scanner scanner){
        int numeroConta = validandoNumeroConta(scanner);
        boolean contaEncontrada = false;
        for (Conta16 conta16 : conta16s){
            if (conta16.getNumeroConta() == numeroConta){
                contaEncontrada = true;
                conta16.desbloquearConta();
            }
        }
        if (!contaEncontrada){
            System.out.println("Conta não encontrada.");
        }
    }

}
