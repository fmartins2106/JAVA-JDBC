package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco08 {
    private List<Conta08>conta08s;

    public Banco08(){
        this.conta08s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente08.ErrorMessage.MENSAGEM_NOME.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11  || !cpf.matches("\\d{11}")){
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
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private boolean validandoNumeroConta(int numeroConta){
        if (numeroConta < Conta08.DIGITOS_MINIMO_CONTA){
            System.out.println(Cliente08.ErrorMessage.DIGITOS_MINIMO_CONTA.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Banco08 banco08){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco08.validacaoNome(nome)){
                return Cliente08.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco08 banco08){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco08.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner, Banco08 banco08){
        while (true){
            try {
                System.out.print("Número conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco08.validandoNumeroConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static Cliente08.TipoContaBanco validandoTipoDeConta(Scanner scanner, Banco08 banco08b ){
        while (true){
            int opcao = 0;
            try {
                System.out.print("Tipo de conta.");
                System.out.println("[1] Conta corrente.");
                System.out.println("[2] Conta poupança.");
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opão válida.");
            }
            switch (opcao){
                case 1:
                    return Cliente08.TipoContaBanco.CORRENTE;
                case 2:
                    return Cliente08.TipoContaBanco.POUPANCA;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public void addContas(Conta08 conta08){
        conta08s.add(conta08);
    }

    public void listaContas(){
        if (conta08s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta08s.forEach(System.out::println);
        }
    }

    public void realizarDeposito(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta08 conta08: conta08s){
                if (conta08.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do depósito:R$");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta08.depositar(valor);
                        System.out.println("deposito realizado com sucesso.");
                    }catch (NumberFormatException e){
                        System.out.println("Valor inválido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Valor inválido.");
        }
    }

    public void realisarSaque(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta08 conta08 : conta08s){
                if (conta08.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Valor do saque:R$");
                        double saque = Double.parseDouble(scanner.nextLine());
                        conta08.saque(saque);
                    }catch (NumberFormatException e){
                        System.out.println("Valor inválido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Número de conta não cadastrado.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public void alterarDados(Scanner scanner,String acao){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta08 conta08 : conta08s){
                if (conta08.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    if (acao.equals("bloquear")){
                        conta08.bloquear();
                    }else {
                        conta08.encerrarConta();
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
            boolean contaEncontrada = false;
            for (Conta08 conta08 : conta08s){
                if (conta08.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta08.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido.");
        }
    }

    public List<Conta08> getConta08s() {
        return conta08s;
    }
}
