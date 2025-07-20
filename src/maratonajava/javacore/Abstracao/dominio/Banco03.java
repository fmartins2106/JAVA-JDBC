package academy.devdojo.maratonajava.javacore.Abstracao.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco03 {
    private List<Conta03> conta03s;

    public Banco03(){
        this.conta03s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Cliente03.MensagensErro.ERRO_NOME.getDescricao());
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
        if (numeroContaStr.length() != Conta03.DIGITOS_CONTA){
            System.out.println(Cliente03.MensagensErro.ERRO_CONTA);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner,Banco03 banco03){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (banco03.validacaoNome(nome)){
                return Cliente03.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Banco03 banco03){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (banco03.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoNumeroConta(Scanner scanner, Banco03 banco03){
        while (true){
            try {
                System.out.print("Número da conta:");
                int numeroConta = Integer.parseInt(scanner.nextLine());
                if (banco03.validacaoNumeroConta(numeroConta)){
                    return numeroConta;
                }
            }catch (NumberFormatException e){
                System.out.println(Cliente03.MensagensErro.ERRO_CONTA.getDescricao());
            }
        }
    }

    public static Cliente03.TipoConta validandoTipoConta(Scanner scanner){
        while (true){
            System.out.println("Tipo de conta.");
            System.out.println("[1] Conta corrente.");
            System.out.println("[2] Conta poupança.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    return Cliente03.TipoConta.CORRENTE;
                case 2:
                    return Cliente03.TipoConta.POUPANCA;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    public void listarContas(Scanner scanner){
        if (conta03s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            conta03s.forEach(System.out::println);
        }
    }

    public void realizarDeposito(Scanner scanner){
        try {
            System.out.print("Número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta03 conta03 : conta03s){
                if (conta03.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Digite o valor do depositoR$:");
                        double valor = Double.parseDouble(scanner.nextLine());
                        conta03.depositar(valor);
                        return;
                    }catch (NumberFormatException e){
                        System.out.println("Valor inválido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Número de conta não encontrado.");
            }
        }catch (NumberFormatException e){
            System.out.println("Número de conta não encontrado.");
        }
    }

    public void realisarSaque(Scanner scanner){
        try{
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta03 conta03 : conta03s){
                if (conta03.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    try {
                        System.out.print("Quanto quer sacar?:R$");
                        double saque = Double.parseDouble(scanner.nextLine());
                        if (saque <= conta03.getSaldo()){
                            conta03.saque(saque);
                            return;
                        }else {
                            System.out.println("Valor do saque não pode ser maior que saldo.");
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Valor inválido.");
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Conta não encontrada.");
        }
    }

    public void alterarDadosConta(Scanner scanner, String acao){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta03 conta03 : conta03s){
                if (conta03.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    if (acao.equals("bloquear")){
                        conta03.bloquearConta();
                    }else {
                        conta03.encerrarConta();
                    }
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite um númer de conta válido.");
        }
    }

    public void desbloquearConta(Scanner scanner){
        try {
            System.out.print("Digite o número da conta:");
            int numeroConta = Integer.parseInt(scanner.nextLine());
            boolean contaEncontrada = false;
            for (Conta03 conta03 : conta03s){
                if (conta03.getNumeroConta() == numeroConta){
                    contaEncontrada = true;
                    conta03.desbloquearConta();
                }
            }
            if (!contaEncontrada){
                System.out.println("Conta não encontrada.");
            }
        }catch (NumberFormatException e){
            System.out.println("Digite uma conta válida.");
        }
    }

    public void addContas(Conta03 conta03){
        conta03s.add(conta03);
    }

    public List<Conta03> getConta03s() {
        return conta03s;
    }

    public void setConta03s(List<Conta03> conta03s) {
        this.conta03s = conta03s;
    }
}
