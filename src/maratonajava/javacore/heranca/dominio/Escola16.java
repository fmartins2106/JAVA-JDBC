package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Escola16 {
    private List<Pessoa16> pessoa16s;

    public Escola16(){
        this.pessoa16s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa16.MensagensValidacaoPessoas16.ERRO_NOME.getDescricao());
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
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0:digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private boolean validacaoIdade(int idade){
        if (idade < Pessoa16.MENOR_IDADE){
            System.out.println(Pessoa16.MensagensValidacaoPessoas16.ERRO_IDADE.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoMatricula(int matricula){
        if (matricula < Aluno16.MENOR_NUMERO_MATRICULA){
            System.out.println(Pessoa16.MensagensValidacaoPessoas16.ERRO_MATRICULA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < Aluno16.NOTA_MINIMA || nota > Aluno16.NOTA_MAXIMA){
                System.out.println(Pessoa16.MensagensValidacaoPessoas16.ERRO_NOTAS.getDescricao());
                return false;
            }
        }
        return true;
    }

    private boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Pessoa16.MensagensValidacaoPessoas16.ERRO_DISCIPLINA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoSalarioProfessor(double salario){
        if (salario < Professor16.SALARIO_MINIMO_PROFESSOR){
            System.out.println(Pessoa16.MensagensValidacaoPessoas16.ERRO_SALARIO_PROF.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola16 escola16){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola16.validacaoNome(nome)){
                return Pessoa16.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Escola16 escola16){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (escola16.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Escola16 escola16){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (escola16.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma data válida.");
            }
        }
    }

    public static int validandoMatricula(Scanner scanner, Escola16 escola16){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (escola16.getPessoa16s().stream().anyMatch(p -> p instanceof Aluno16 && ((Aluno16) p).getMatricula() == matricula)){
                    System.out.println("Matrícula já cadastrada, tente outro número de matrícula.");
                    continue;
                }
                return matricula;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner, Escola16 escola16){
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(i+1)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (escola16.validacaoNotas(notas)){
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Digite uma nota válida.");
                }
            }
        }
        return notas;
    }

    public static String validandoDisciplina(Scanner scanner, Escola16 escola16){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola16.validacaoDisciplina(disciplina)){
                return Pessoa16.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalario(Scanner scanner, Escola16 escola16){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (escola16.validacaoSalarioProfessor(salario)){
                    return salario;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void addPessoa(Pessoa16 pessoa16){
        pessoa16s.add(pessoa16);
    }

    public void listaPessoa(){
        if (pessoa16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa16s.forEach(System.out::println);
        }
    }

    public Pessoa16 pesquisaPorNome(Scanner scanner, Escola16 escola16){
        Pessoa16 pessoa16 = null;
        if (pessoa16s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else{
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            pessoa16 = pessoa16s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa16 != null){
                System.out.println("Nome:"+pessoa16.getNome());
                System.out.println("CPF:"+pessoa16.getCpf());
                System.out.println("Idade:"+pessoa16.getIdade());
                if (pessoa16 instanceof Aluno16){
                    Aluno16 aluno16 =(Aluno16) pessoa16;
                    System.out.println("Matrícula:"+aluno16.getMatricula());
                    System.out.println("Notas:"+ Arrays.toString(aluno16.getNotas()));
                    System.out.println("Média:"+aluno16.getMedia());
                    System.out.println("Situação:"+aluno16.getSituacaoAluno16());
                }
                if (pessoa16 instanceof Professor16){
                    Professor16 professor16 = (Professor16) pessoa16;
                    System.out.println("Disciplina:"+professor16.getDisciplina());
                    System.out.println("Salário:R$"+professor16.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado.");
                return null;
            }
        }
        return pessoa16;
    }

    public void excluirDados(Scanner scanner, Escola16 escola16){
        if (pessoa16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa16 pessoa16 = pesquisaPorNome(scanner,escola16);
            pessoa16s.remove(pessoa16);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDados(Scanner scanner, Escola16 escola16){
        if (pessoa16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa16 pessoa16 = pessoa16s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa16 != null){
                pessoa16.setNome(validandoNome(scanner,escola16));
                pessoa16.setCpf(validandoCpf(scanner,escola16));
                System.out.println(validandoIdade(scanner,escola16));
                if (pessoa16 instanceof Aluno16){
                    Aluno16 aluno16 = (Aluno16) pessoa16;
                    aluno16.setMatricula(validandoMatricula(scanner,escola16));
                    aluno16.setNotas(validandoNotas(scanner,escola16));
                }
                if (pessoa16 instanceof Professor16){
                    Professor16 professor16 = (Professor16) pessoa16;
                    professor16.setDisciplina(validandoDisciplina(scanner,escola16));
                    professor16.setSalario(validandoSalario(scanner,escola16));
                }
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public List<Pessoa16> getPessoa16s() {
        return pessoa16s;
    }
}
