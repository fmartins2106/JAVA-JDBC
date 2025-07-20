package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escola01 {
    private List<Pessoa01> pessoa01s;

    public Escola01(){
        this.pessoa01s = new ArrayList<>();
    }

    public void addPessoa(Pessoa01 pessoa01){
        pessoa01s.add(pessoa01);
    }

    public void listarRegistros(){
        if (pessoa01s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa01s.forEach(System.out::println);
        }
    }

    public Pessoa01 buscarPorNome(Scanner scanner){
        if (pessoa01s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            Pessoa01 pessoa01 = pessoa01s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa01 !=null){
                System.out.println("__________________________________");
                System.out.println("Nome:"+pessoa01.getNome());
                System.out.println("CPF:"+pessoa01.getCpf());
                System.out.println("Idade:"+pessoa01.getIdade());
                System.out.println("__________________________________");
            }else {
                System.out.println("Nome não encontrado.");
            }
            return pessoa01;
        }
    }

    public void excluirPessoa(Scanner scanner){
        Pessoa01 pessoa01 = buscarPorNome(scanner);
        if (pessoa01 !=null){
            pessoa01s.remove(pessoa01);
            System.out.println("Registro removido com sucesso.");
        }else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    public static final String MENSAGEM_NOME_INVALIDO = "Campo nome não pode ser vazio ou conter caracteres. Digite nome completo.";
    public boolean validandoString(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(MENSAGEM_NOME_INVALIDO);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola01 escola01){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola01.validandoString(nome)){
                return Pessoa01.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < Aluno01.IDADE_MINIMA){
                    System.out.println(Aluno01.MENSAGEM_VALIDANDO_IDADE);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static int validandoMatricula(Scanner scanner){
        while (true){
            try {
                System.out.print("Matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (matricula < Aluno01.MINIMO_MATRICULA){
                    System.out.println(Aluno01.MENSAGEM_VALIDANDO_IDADE);
                    continue;
                }
                return matricula;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            System.out.print("Digite o CPF:");
            String cpf = scanner.nextLine().trim();
            if (isCpfValido(cpf)){
                return cpf;
            }else {
                System.out.println("CPF inválido, tente novamente.");
            }
        }
    }
    public static boolean isCpfValido(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false; // CPF deve ter 11 dígitos numéricos
        }

        // Verifica se todos os dígitos são iguais
        if (cpf.chars().distinct().count() == 1) {
            return false; // CPFs como "111.111.111-11" são inválidos
        }

        // Cálculo do primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0 : digito1;

        // Cálculo do segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0 : digito2;

        // Verifica se os dígitos verificadores estão corretos
        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public static String validandoDisciplina(Scanner scanner, Escola01 escola01){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine();
            if (escola01.validandoString(disciplina)){
                return disciplina;
            }
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < Professor01.SALARIO_MINIMO_PROFESSOR){
                    System.out.println(Professor01.MENSAGEM_SALARIO_MINIMO_PROFESSOR);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    




}
