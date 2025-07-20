package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Escola15 {
    private List<Pessoa15> pessoa15s;

    public Escola15(){
        this.pessoa15s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa15.ErroPrevisto.ERRO_NOME.getDescricao());
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
        if (idade < Pessoa15.IDADE_MINIMA){
            System.out.println(Pessoa15.ErroPrevisto.ERRO_IDADE.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola15 escola15){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola15.validacaoNome(nome)){
                return Pessoa15.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Escola15 escola15){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (escola15.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Escola15 escola15){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (escola15.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Idade não válida.");
            }
        }
    }

    private boolean validacaoMatricula(int matricula){
        if (matricula < Aluno15.MENOR_MATRICULA){
            System.out.println(Pessoa15.ErroPrevisto.ERRO_MATRICULA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < Aluno15.MENOR_NOTA || nota > Aluno15.MAIOR_NOTA){
                System.out.println(Pessoa15.ErroPrevisto.ERRO_NOTAS.getDescricao());
                return false;
            }
        }
        return true;
    }

    public static int validandoMatricula(Scanner scanner, Escola15 escola15){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                boolean matriculaExiste = escola15.getPessoa15s().stream().anyMatch(p -> p instanceof Aluno15 && ((Aluno15)p).getMatricula() == matricula);
                if (matriculaExiste){
                    System.out.println("Matrícula já cadastrada, tente novamente.");
                }else {
                    if (escola15.validacaoMatricula(matricula)){
                        return matricula;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner, Escola15 escola15){
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(i+1)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (escola15.validacaoNotas(notas)){
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Nota inválida.");
                }
            }
        }
        return notas;
    }

    private boolean validandoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Pessoa15.ErroPrevisto.ERRO_DISCIPLINA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoSalario(double salario){
        if (salario < Professor15.SALARIO_PROFESSOR){
            System.out.println(Pessoa15.ErroPrevisto.ERRO_SALARIO.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoDisciplina(Scanner scanner, Escola15 escola15){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola15.validandoDisciplina(disciplina)){
                return Pessoa15.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalario(Scanner scanner, Escola15 escola15){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (escola15.validacaoSalario(salario)){
                    return salario;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void addPessoas(Pessoa15 pessoa15){
        pessoa15s.add(pessoa15);
    }

    public void listaPessoas(){
        if (pessoa15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa15s.forEach(System.out::println);
        }
    }

    public Pessoa15 pesquisaPorNome(Scanner scanner, Escola15 escola15){
        Pessoa15 pessoa15 = null;
        if (pessoa15s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine();
            pessoa15 = pessoa15s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa15 != null){
                System.out.println("Nome:"+pessoa15.getNome());
                System.out.println("CPF:"+pessoa15.getCpf());
                System.out.println("Idade:"+pessoa15.getIdade());
                if (pessoa15 instanceof Aluno15){
                    Aluno15 aluno15 = (Aluno15) pessoa15;
                    System.out.println("Matrícula:"+aluno15.getMatricula());
                    System.out.println("Notas:"+ Arrays.toString(aluno15.getNotas()));
                    System.out.println("Média:"+aluno15.getMedia());
                    System.out.println("Situação:"+aluno15.getSituacaoNotas());
                }
                if (pessoa15 instanceof Professor15){
                    Professor15 professor15 = (Professor15) pessoa15;
                    System.out.println("Disciplina:"+professor15.getDisciplina());
                    System.out.println("Salário:R$"+professor15.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado.");
                return null;
            }
        }
        return pessoa15;
    }

    public void excluirDados(Scanner scanner, Escola15 escola15){
        if (pessoa15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa15 pessoa15 = pesquisaPorNome(scanner,escola15);
            pessoa15s.remove(pessoa15);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDados(Scanner scanner, Escola15 escola15){
        if (pessoa15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa15 pessoa15 = pessoa15s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa15 != null){
                pessoa15.setNome(validandoNome(scanner,escola15));
                pessoa15.setCpf(validandoCpf(scanner,escola15));
                pessoa15.setIdade(validandoIdade(scanner,escola15));
                if (pessoa15 instanceof Aluno15){
                    Aluno15 aluno15 = (Aluno15) pessoa15;
                    aluno15.setNotas(validandoNotas(scanner,escola15));
                }
                if (pessoa15 instanceof Professor15){
                    Professor15 professor15 = (Professor15) pessoa15;
                    professor15.setDisciplina(validandoDisciplina(scanner,escola15));
                    professor15.setSalario(validandoSalario(scanner,escola15));
                }
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public List<Pessoa15> getPessoa15s() {
        return pessoa15s;
    }
}

