package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Escola09 {
    private List<Pessoa09> pessoa09s;

    public Escola09(){
        this.pessoa09s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Pessoa09.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    private boolean validacaoIdade(int idade){
        if (idade < Pessoa09.IDADE_MINIMA){
            System.out.println(Pessoa09.MENSAGEM_ERRO_IDADE);
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
        digito1 = (digito1 >= 11) ? 0: digito1;

        soma=0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public static String validandoNome(Scanner scanner, Escola09 escola09){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola09.validacaoNome(nome)){
                return Pessoa09.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner,Escola09 escola09){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (escola09.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Escola09 escola09){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (escola09.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    private boolean validacaoMatricula(int matricula){
        if (matricula < Aluno09.MENOR_MATRICULA){
            System.out.println(Aluno09.MENSAGEM_ERRO_MATRICULA);
            return false;
        }
        return true;
    }

    private boolean validacaoNotas(double nota){
        if (nota < Aluno09.MENOR_NOTA || nota > Aluno09.MAIOR_NOTA){
            System.out.println(Aluno09.MENSAGEM_ERRO_NOTA);
            return false;
        }
        return true;
    }

    public static int validandoMatricula(Scanner scanner, Escola09 escola09){
        while (true){
            try {
                System.out.print("Matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (escola09.validacaoMatricula(matricula)){
                    boolean matriculaExiste = escola09.getPessoa09s().stream().anyMatch(p -> p instanceof Aluno09 && (((Aluno09) p).getMatricula() == matricula));
                    if (matriculaExiste){
                        System.out.println("Matricula já cadastrada, tente outro número.");
                    }else {
                        return matricula;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner, Escola09 escola09){
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            try {
                while (true){
                    System.out.print("Digite a "+(i+1)+"º nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (escola09.validacaoNotas(notas[i])){
                        break;
                    }else {
                        System.out.println("Numero inválido, tente novamente.");
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
        return notas;
    }

    public boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Professor08.MENSAGEM_ERRO_DISCIPLINA);
            return false;
        }
        return true;
    }

    public boolean validacaoSalarioProfessor(double salario){
        if (salario <Professor09.SALARIO_PROFESSOR){
            System.out.println(Professor09.MENSAGEM_ERRO_SALARIO_PROF);
            return false;
        }
        return true;
    }

    public static String validandoDisciplina(Scanner scanner, Escola09 escola09){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola09.validacaoDisciplina(disciplina)){
                return Pessoa09.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalarioProfessor(Scanner scanner, Escola09 escola09){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (escola09.validacaoSalarioProfessor(salario)){
                    return salario;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaPessoas(){
        if (pessoa09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa09s.forEach(System.out::println);
        }
    }

    public Pessoa09 pesquisaPorNome(Scanner scanner, Escola09 escola09){
        Pessoa09 pessoa09;
        if (pessoa09s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            pessoa09 = pessoa09s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa09 != null){
                System.out.println("_________________________________________");
                System.out.println("Nome:"+pessoa09.getNome());
                System.out.println("Idade:"+pessoa09.getIdade());
                System.out.println("CPF:"+pessoa09.getCpf());
                if (pessoa09 instanceof Aluno09){
                    Aluno09 aluno09 = (Aluno09) pessoa09;
                    System.out.println("Matricula:"+aluno09.getMatricula());
                    System.out.println("Notas:"+ Arrays.toString(aluno09.getNotas()));
                    System.out.println("Média:"+aluno09.getMedia());
                }
                if (pessoa09 instanceof Professor09){
                    Professor09 professor09 = (Professor09) pessoa09;
                    System.out.println("Disciplina:"+professor09.getDisciplina());
                    System.out.println("Salário:R$"+professor09.getSalario());
                }
                System.out.println("_________________________________________");
            }else {
                System.out.println("Nome não encontrado, tente novamente.");
            }
        }
        return pessoa09;
    }

    public void excluirDados(Scanner scanner, Escola09 escola09){
        if (pessoa09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa09 pessoa09 = pesquisaPorNome(scanner, escola09);
            pessoa09s.remove(pessoa09);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterandoDadosPessoa(Scanner scanner,Escola09 escola09){
        Pessoa09 pessoa09;
        if (pessoa09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            pessoa09 = pessoa09s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa09 != null){
                pessoa09.setNome(validandoNome(scanner,escola09));
                pessoa09.setIdade(validandoIdade(scanner,escola09));
                pessoa09.setCpf(validandoCpf(scanner,escola09));
                if (pessoa09 instanceof Aluno09){
                    Aluno09 aluno09 = (Aluno09) pessoa09;
                    aluno09.setMatricula(validandoMatricula(scanner,escola09));
                    aluno09.setNotas(validandoNotas(scanner,escola09));
                }
                if (pessoa09 instanceof Professor09){
                    Professor09 professor09 = (Professor09) pessoa09;
                    professor09.setDisciplina(validandoDisciplina(scanner,escola09));
                    professor09.setSalario(validandoSalarioProfessor(scanner,escola09));
                }
            }else {
                System.out.println("Nome não encontrado, tente novamente.");
            }
        }
    }

    public void addPessoas(Pessoa09 pessoa09){
        pessoa09s.add(pessoa09);
    }

    public List<Pessoa09> getPessoa09s() {
        return pessoa09s;
    }

    public void setPessoa09s(List<Pessoa09> pessoa09s) {
        this.pessoa09s = pessoa09s;
    }
}
