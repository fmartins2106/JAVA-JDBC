package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Escola14 {
    private List<Pessoa14> pessoa14s;

    public Escola14(){
        this.pessoa14s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa14.MensagensValidacoes.ERRO_NOME.getDescricao());
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

    private boolean validacaoIdade(int idade){
        if (idade < Pessoa14.IDADE_MINIMA){
            System.out.println(Pessoa14.MensagensValidacoes.ERRO_IDADE.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola14 escola14){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine();
            if (escola14.validacaoNome(nome)){
                return Pessoa14.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Escola14 escola14){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine();
            if (escola14.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Escola14 escola14){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (escola14.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido. Tente novamente.");
            }
        }
    }

    private boolean validacaoMatricula(int matricula){
        if (matricula < Aluno14.NUMERO_MINIMO_MATRICULA){
            System.out.println(Pessoa14.MensagensValidacoes.NUMERO_MINIMO_MATRICULA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < Aluno14.NOTA_MINIMA || nota > Aluno14.NOTA_MAXIMA){
                System.out.println(Pessoa14.MensagensValidacoes.ERRO_NOTAS.getDescricao());
                return false;
            }
        }
        return true;
    }

    public static int validandoMatricula(Scanner scanner, Escola14 escola14){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (escola14.validacaoMatricula(matricula)){
                    boolean matriculaExiste = escola14.getPessoa14s().stream().anyMatch(p -> p instanceof Aluno14 && ((Aluno14)p).getMatricula() == matricula);
                    if (matriculaExiste){
                        System.out.println("Matrícula já cadastrada, tente novamente.");
                    }else {
                        return matricula;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número de matrícula válido.");
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner, Escola14 escola14){
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digita a "+(i+1)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (escola14.validacaoNotas(notas)){
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Digite uma nota válida.");
                }
            }
        }
        return notas;
    }

    private boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Pessoa14.MensagensValidacoes.ERRO_DISCIPLINA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoSalario(double salario){
        if (salario < Professor14.SALARIO_MINIMO_PROF){
            System.out.println(Pessoa14.MensagensValidacoes.ERRO_SALARIO_MINIMO_PROF.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoDisciplina(Scanner scanners, Escola14 escola14){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanners.nextLine();
            if (escola14.validacaoDisciplina(disciplina)){
                return disciplina;
            }
        }
    }

    public static double validandoSalario(Scanner scanner, Escola14 escola14){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (escola14.validacaoSalario(salario)){
                    return salario;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void addPessoas(Pessoa14 pessoa14){
        pessoa14s.add(pessoa14);
    }

    public void listarPessoas(){
        if (pessoa14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa14s.forEach(System.out::println);
        }
    }

    public Pessoa14 pesquisaPorNome(Scanner scanner, Escola14 escola14){
        Pessoa14 pessoa14 = null;
        if (pessoa14s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            pessoa14 = pessoa14s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa14 !=null){
                System.out.println("Nome:"+pessoa14.getNome());
                System.out.println("CPF:"+pessoa14.getCpf());
                System.out.println("Idade:"+pessoa14.getIdade());
                if (pessoa14 instanceof Aluno14){
                    Aluno14 aluno14 = (Aluno14) pessoa14;
                    System.out.println("Matrícula:"+aluno14.getMatricula());
                    System.out.println("Notas:"+ Arrays.toString(aluno14.getNotas()));
                    System.out.println("Média:"+aluno14.getMedia());
                }
                if (pessoa14 instanceof Professor14){
                    Professor14 professor14 = (Professor14) pessoa14;
                    System.out.println("Disciplina:"+professor14.getDisciplina());
                    System.out.println("Salário:R$"+professor14.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado.");
                return null;
            }
        }
        return pessoa14;
    }

    public void excluirDados(Scanner scanner, Escola14 escola14){
        if (pessoa14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa14 pessoa14 = pesquisaPorNome(scanner,escola14);
            pessoa14s.remove(pessoa14);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDados(Scanner scanner, Escola14 escola14){
        if (pessoa14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa14 pessoa14 = pessoa14s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa14 != null){
                pessoa14.setNome(validandoNome(scanner,escola14));
                pessoa14.setCpf(validandoCpf(scanner,escola14));
                pessoa14.setIdade(validandoIdade(scanner,escola14));
                if (pessoa14 instanceof Aluno14){
                    Aluno14 aluno14 = (Aluno14) pessoa14;
                    aluno14.setMatricula(validandoMatricula(scanner,escola14));
                    aluno14.setNotas(validandoNotas(scanner,escola14));
                }
                if (pessoa14 instanceof Professor14){
                    Professor14 professor14 = (Professor14) pessoa14;
                    professor14.setDisciplina(validandoDisciplina(scanner,escola14));
                    professor14.setSalario(validandoSalario(scanner,escola14));
                }
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public List<Pessoa14> getPessoa14s() {
        return pessoa14s;
    }
}
