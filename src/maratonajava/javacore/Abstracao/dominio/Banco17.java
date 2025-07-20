package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco17 {
    private List<Conta17>conta17s;

    public Banco17(){
        this.conta17s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente17.validacaoNome(nome);
                return Cliente17.formatoNome(nome);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Cliente17.validacaoCpf(cpf);
                return cpf;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                Conta17.validacaoConta(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de conta válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Cliente17.TipoConta17 validandoTipoConta(Scanner scanner){
        while (true){
            System.out.println("[1] Conta Corrente.");
            System.out.println("[2] Conta Poupança.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente17.TipoConta17.CORRENTE;
                    case 2:
                        return Cliente17.TipoConta17.POUPANCA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void addConta(Conta17 conta17){
        conta17s.add(conta17);
    }

    public void listarContas(){
        if (conta17s.isEmpty()){
            System.out.println("Conta vazia.");
        }else {
            conta17s.forEach(System.out::println);
        }
    }

    public void validandoDeposito(Scanner scanner){
        int numeroConta = validandoNumeroConta(scanner);
        boolean contaEncontrada = false;
        for (Conta17 conta17 : conta17s){
            if (conta17.getNumeroConta() == numeroConta){
                contaEncontrada = true;
                try {
                    System.out.print("Valor do depósito:R$");
                    double valor = Double.parseDouble(scanner.nextLine());
                    conta17.depositar(valor);
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
        }
        if (!contaEncontrada){
            System.out.println("Conta não encontrada.");
        }
    }

    public void validacaoSaque(Scanner scanner){
        int numeroConta = validandoNumeroConta(scanner);
        boolean contaEncontrada = false;
        for (Conta17 conta17 : conta17s){
            if (conta17.getNumeroConta() == numeroConta){
                contaEncontrada = true;
                try {
                    System.out.print("Digite um valor para saque:");
                    double valor = Double.parseDouble(scanner.nextLine());
                    conta17.sacar(valor);
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
        }
        if (!contaEncontrada){
            System.out.println("Número de conta não encontrada.");
        }
    }

    public void validandoBloqueioEcancelamento(Scanner scanner, String acao){
        int numeroConta = validandoNumeroConta(scanner);
        boolean contaEncontrada = false;
        for (Conta17 conta17 : conta17s){
            if (conta17.getNumeroConta() == numeroConta){
                contaEncontrada = true;
                if (acao.equalsIgnoreCase("bloquear")){
                    conta17.bloquearConta();
                }else {
                    conta17.cancelarConta();
                }
            }
        }
        if (!contaEncontrada){
            System.out.println("Conta não encontrada.");
        }
    }

    public void validandoDesbloqueiConta(Scanner scanner){
        int numeroConta = validandoNumeroConta(scanner);
        boolean contaEncontrada = false;
        for (Conta17 conta17 : conta17s){
            if (conta17.getNumeroConta() == numeroConta){
                contaEncontrada = true;
                conta17.desbloquearConta();
            }
        }
        if (!contaEncontrada){
            System.out.println("Conta não encontrada.");
        }
    }


}
