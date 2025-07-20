package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco19 {
    private List<Conta19> conta19s;

    public Banco19(){
        this.conta19s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Cliente19.validacaoNome(nome);
                return Cliente19.formatoNome(nome);
            }catch (IllegalArgumentException e ){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Cliente19.validacaoCpf(cpf);
                return cpf;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner){
        while (true){
            try {
                System.out.print("Número conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                Conta19.validacaoNumeroConta(numeroConta);
                return numeroConta;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static Cliente19.TipoConta19 validandoTipoConta(Scanner scanner){
        while (true){
            try {
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupança.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        return Cliente19.TipoConta19.CORRENTE;
                    case 2:
                        return Cliente19.TipoConta19.POUPANÇA;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void addConta(Conta19 conta19){
        conta19s.add(conta19);
    }

    public void listaContas(){
        if (conta19s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta19s.forEach(System.out::println);
        }
    }

    public void validandoDeposito(Scanner scanner){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta19 conta19 : conta19s){
                if (conta19.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do depósito:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta19.deposito(valor);
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
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

    public void validandoSaque(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta19 conta19 :  conta19s){
                if (conta19.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do saque:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta19.sacar(valor);
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Número de conta não encontrado.");
        }
    }

    public void alterarStatusConta(Scanner scanner, String acao){
        try {
            System.out.print("Número conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta19 conta19 : conta19s){
                if (conta19.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    if (acao.equalsIgnoreCase("bloquear")){
                        conta19.bloquearConta();
                    }else {
                        conta19.cancelamentoConta();
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

    public void desbloquearConta(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada =  false;
            for (Conta19 conta19 : conta19s){
                if (conta19.getNumeroConta() ==  numeroConta){
                    contaEncontrada = true;
                    conta19.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não enmcontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um número de conta válido.");
        }
    }


}
