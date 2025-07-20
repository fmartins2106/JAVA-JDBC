package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco01 {
    private List<Conta01> conta01s;

    public Banco01(){
        this.conta01s = new ArrayList<>();
    }

    public void addConta(Conta01 conta01){
        conta01s.add(conta01);
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente01.MensagemValidacao.ERRO_NOME.getDescricao());
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

        int soma=0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma=0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private boolean validacaoNumeroDaConta(int conta){
        if (conta  < Conta01.NUMERO_CONTA){
            System.out.println(Cliente01.MensagemValidacao.ERRO_NUMERO_CONTA.getDescricao());
            return false;
        }
        String numeroStr = String.valueOf(conta);
        if (numeroStr.length() != 6){
            System.out.println(Cliente01.MensagemValidacao.ERRO_NUMERO_CONTA.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Banco01 banco01){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco01.validacaoNome(nome)){
                return Cliente01.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco01 banco01){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco01.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoConta(Scanner scanner, Banco01 banco01){
        while (true){
            try {
                System.out.print("Conta:");
                int conta = Integer.parseInt(scanner.nextLine());
                if (banco01.validacaoNumeroDaConta(conta)){
                    return conta;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static Cliente01.TipoDeConta validandoTipoDeConta(Scanner scanner){
        while (true){
            try {
                System.out.println("TIPO DE CONTA.");
                System.out.println("[1] CORRENTE.");
                System.out.println("[2] POUPANÇA.");
                System.out.println("Digite uma das opções acima:");
                int tipoConta = Integer.parseInt(scanner.nextLine());
                switch (tipoConta){
                    case 1:
                        return Cliente01.TipoDeConta.CORRENTE;
                    case 2:
                        return Cliente01.TipoDeConta.POUPANCA;
                    default:
                        System.out.println("Erro. Digite 1 para conta correta e 2 para conta poupança.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaContas(Scanner scanner){
        if (conta01s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            for (Conta01 conta : conta01s){
                System.out.println(conta);
            }
        }
    }

    public void realizarDeposito(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
                for (Conta01 conta01 : conta01s){
                    if (conta01.getNumeroConta() == numeroConta ){
                        System.out.print("Valor do depósito:R$");
                        double valorDeposito = Double.parseDouble(scanner.nextLine());
                        conta01.depositar(valorDeposito);
                        return ;
                    }
                }
                System.out.println("Conta não encontrada.");
            }catch (NumberFormatException e){
            System.out.println("Conta não encontrada.");
        }
    }

    public void realizarSaque(Scanner scanner){
        System.out.print("Número da conta:");
        int numeroConta = Integer.parseInt(scanner.nextLine());
        for (Conta01 conta01 : conta01s){
            if (conta01.getNumeroConta() == numeroConta){
                System.out.println("Digite o valor do saque:R$");
                double valor = Double.parseDouble(scanner.nextLine());
                conta01.saca(valor);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void alterarDadosConta(Scanner scanner, String acao){
        System.out.print("Número da conta:");
        int numeroConta = Integer.parseInt(scanner.nextLine());
        for (Conta01 conta01 : conta01s){
            if (conta01.getNumeroConta() == numeroConta){
                if (acao.equals("bloquear") ){
                    conta01.bloquearConta();
                } else if (acao.equals("encerrar")) {
                    conta01.encerrarConta();
                }
                return;
            }
        }
        System.out.println("Conta nã encontrada.");
    }

    public void desbloquearConta(Scanner scanner){
        try {
            System.out.println("Número da conta");
             int numeroConta  =Integer.parseInt(scanner.nextLine());
             boolean contaEncontrada = false;
             for (Conta01 conta01 : conta01s){
                 if (conta01.getNumeroConta() == numeroConta ){
                     conta01.desbloquearConta();
                     return;
                 }
             }
             if (!contaEncontrada){
                 System.out.println("Conta não encontrada.");
             }
        }catch (NumberFormatException e){
            System.out.println("Conta não encontrada.");
        }
    }
}
