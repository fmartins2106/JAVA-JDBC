package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Escola10 {
    private List<Pessoa10> pessoa10s;

    public Escola10(){
        this.pessoa10s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa10.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    public boolean validacaoIdade(int idade){
        if (idade < Pessoa10.IDADE_MINIMA){
            System.out.println(Pessoa10.MENSAGEM_ERR0_IDADE);
            return false;
        }
        return true;
    }

    public boolean isCpfValido(String cpf){
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

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public static String validandoNome(Scanner scanner, Escola10 escola10){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola10.validacaoNome(nome)){
                return Pessoa10.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Escola10 escola10){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (escola10.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Escola10 escola10){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (escola10.isCpfValido(cpf)){
                return cpf;
            }
        }
    }

    public boolean validacaoMatricula(int matricula){
        if (matricula < Aluno10.MENOR_MATRICULA){
            System.out.println(Aluno10.MENSAGEM_ERRO_MATRICULA);
            return false;
        }
        return true;
    }

    public boolean validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < Aluno10.MENOR_NOTA || nota > Aluno10.MAIOR_NOTA){
                return false;
            }
        }
        return true;
    }

    public static int validandoMatricula(Scanner scanner, Escola10 escola10){
        while (true){
            try {
                System.out.print("Matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (escola10.validacaoMatricula(matricula)){
                    boolean matriculaExiste = escola10.getPessoa10s().stream().anyMatch(p -> p instanceof Aluno10 && ((Aluno10)p).getMatricula() == matricula);
                    if (matriculaExiste){
                        System.out.println("Matricula já cadastrada. Tente novamente.");
                    }else {
                        return matricula;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner, Escola10 escola10){
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(i+1)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (escola10.validacaoNotas(notas)){
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
        }
        return notas;
    }

    public boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Professor10.MENSAGEM_ERRO_DISCIPLINA);
            return false;
        }
        return true;
    }

    public boolean validacaoSalario(double salario){
        if (salario < Professor10.SALARIO_MINIMO_PROF){
            System.out.println(Professor10.MENSAGEM_ERR0_SALARIO);
            return false;
        }
        return true;
    }

    public static String validandoDisciplina(Scanner scanner, Escola10 escola10){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola10.validacaoDisciplina(disciplina)){
                return Pessoa10.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalario(Scanner scanner, Escola10 escola10){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (escola10.validacaoSalario(salario)){
                    return salario;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaPessoas(){
        if (pessoa10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa10s.forEach(System.out::println);
        }
    }

    public Pessoa10 pesquisaPorNome(Scanner scanner, Escola10 escola10){
        Pessoa10 pessoa10;
        if (pessoa10s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            pessoa10 = pessoa10s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa10 != null){
                System.out.println("______________________________________");
                System.out.println("Nome:"+pessoa10.getNome());
                System.out.println("Idade:"+pessoa10.getIdade());
                System.out.println("CPF:"+pessoa10.getCpf());
                if (pessoa10 instanceof Aluno10){
                    Aluno10 aluno10 = (Aluno10) pessoa10;
                    System.out.println("Matricula:"+aluno10.getMatricula());
                    System.out.println("Notas:"+ Arrays.toString(aluno10.getNotas()));
                    System.out.println("Média:"+aluno10.getMedia());
                }
                if (pessoa10 instanceof Professor10){
                    Professor10 professor10 = (Professor10) pessoa10;
                    System.out.println("Disciplina:"+professor10.getDisciplina());
                    System.out.println("Salário"+professor10.getSalario());
                }
                System.out.println("______________________________________");
            }else {
                System.out.println("Nome não encontrado. Tente novamente.");
                return null;
            }
        }
        return pessoa10;
    }

    public void excluirDados(Scanner scanner, Escola10 escola10){
        if (pessoa10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa10 pessoa10 = pesquisaPorNome(scanner,escola10);
            pessoa10s.remove(pessoa10);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterandoDados(Scanner scanner, Escola10 escola10){
        if (pessoa10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa10 pessoa10 = pessoa10s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa10 != null){
                System.out.println("__________________________");
                pessoa10.setNome(validandoNome(scanner,escola10));
                pessoa10.setIdade(validandoIdade(scanner,escola10));
                pessoa10.setCpf(validandoCpf(scanner,escola10));
                if (pessoa10 instanceof Aluno10){
                    Aluno10 aluno10 = (Aluno10) pessoa10;
                    aluno10.setMatricula(validandoMatricula(scanner,escola10));
                    aluno10.setNotas(validandoNotas(scanner,escola10));
                }
                if (pessoa10 instanceof Professor10){
                    Professor10 professor10 = (Professor10) pessoa10;
                    professor10.setDisciplina(validandoDisciplina(scanner,escola10));
                    professor10.setSalario(validandoSalario(scanner,escola10));
                }
                System.out.println("__________________________");
            }
        }
    }

    public void addPessoas(Pessoa10 pessoa10){
        pessoa10s.add(pessoa10);
    }

    public List<Pessoa10> getPessoa10s() {
        return pessoa10s;
    }

    public void setPessoa10s(List<Pessoa10> pessoa10s) {
        this.pessoa10s = pessoa10s;
    }
}
