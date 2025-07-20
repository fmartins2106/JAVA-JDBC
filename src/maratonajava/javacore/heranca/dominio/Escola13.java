package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Escola13 {
    private List<Pessoa13> pessoa13s;

    public Escola13(){
        this.pessoa13s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa13.MensagensDeErros.ERRO_NOME.getDescricao());
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
        digito1 = (digito1>= 10) ? 0: digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private boolean validacaoIdade(int idade){
        if (idade < Pessoa13.MENOR_IDADE){
            System.out.println(Pessoa13.MensagensDeErros.ERRO_IDADE.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner,Escola13 escola13){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola13.validacaoNome(nome)){
                return Pessoa13.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Escola13 escola13){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (escola13.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Escola13 escola13){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (escola13.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    private boolean validacaoMatricula(int matricula){
        if (matricula < Aluno13.MENOR_NUMERO_MATRICULA){
            System.out.println(Pessoa13.MensagensDeErros.ERRO_MATRICULA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < Aluno13.MENOR_NOTA || nota > Aluno13.MAIOR_NOTA){
                System.out.println(Pessoa13.MensagensDeErros.ERRO_NOTAS.getDescricao());
                return false;
            }
        }
        return true;
    }

    public static int validandoMatricula(Scanner scanner, Escola13 escola13){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (escola13.validacaoMatricula(matricula)){
                    boolean matricualExiste = escola13.getPessoa13s().stream().anyMatch(p -> p instanceof Aluno13 && ((Aluno13)p).getMatricula() == matricula);
                    if (matricualExiste){
                        System.out.println("Matrícula já cadastrada, tente outro número.");
                    }else {
                        return matricula;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um numero de matrícula válido.");
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner, Escola13 escola13){
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(i+1)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (escola13.validacaoNotas(notas)){
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
        }
        return notas;
    }

    private boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Pessoa13.MensagensDeErros.ERRO_DISCIPLINA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoSalario(double salario){
        if (salario < Professor13.SALARIO_MINIMO_PROF){
            System.out.println(Pessoa13.MensagensDeErros.ERRO_SALARIO.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoDisciplina(Scanner scanner, Escola13 escola13){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola13.validacaoDisciplina(disciplina)){
                return Pessoa13.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalario(Scanner scanner, Escola13 escola13){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (escola13.validacaoSalario(salario)){
                    return salario;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void addPessoas(Pessoa13 pessoa13){
        pessoa13s.add(pessoa13);
    }

    public void listaPessoas(){
        if (pessoa13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa13s.forEach(System.out::println);
        }
    }

    public Pessoa13 pesquisaPorNome(Scanner scanner, Escola13 escola13) {
        Pessoa13 pessoa13 = null;
        if (pessoa13s.isEmpty()) {
            System.out.println("Lista vazia.");
            return null;
        } else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            pessoa13 = pessoa13s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa13 != null) {
                System.out.println("Nome:" + pessoa13.getNome());
                System.out.println("CPF:" + pessoa13.getCpf());
                System.out.println("Idade:" + pessoa13.getIdade());
                if (pessoa13 instanceof Aluno13) {
                    Aluno13 aluno13 = (Aluno13) pessoa13;
                    System.out.println("Matrícula:" + aluno13.getMatricula());
                    System.out.println("Notas:" + Arrays.toString(aluno13.getNotas()));
                    System.out.println("Média:" + aluno13.getMedia());
                }
                if (pessoa13 instanceof Professor13) {
                    Professor13 professor13 = (Professor13) pessoa13;
                    System.out.println("Disciplina:" + professor13.getDisciplina());
                    System.out.println("Salário:R$" + professor13.getSalario());

                }
            }else {
                System.out.println("Nome não encontrado.");
                return null;
            }
        }
        return pessoa13;
    }

    public void excluindoDados(Scanner scanner, Escola13 escola13){
        if (pessoa13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa13 pessoa13 = pesquisaPorNome(scanner,escola13);
            pessoa13s.remove(pessoa13);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDados(Scanner scanner, Escola13 escola13){
        if (pessoa13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa13 pessoa13 = pessoa13s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa13 != null){
                pessoa13.setNome(validandoNome(scanner,escola13));
                pessoa13.setCpf(validandoCpf(scanner,escola13));
                pessoa13.setIdade(validandoIdade(scanner,escola13));
                if (pessoa13 instanceof Aluno13){
                    Aluno13 aluno13 = (Aluno13) pessoa13;
                    aluno13.setMatricula(validandoMatricula(scanner,escola13));
                    aluno13.setNotas(validandoNotas(scanner,escola13));
                }
                if (pessoa13 instanceof Professor13){
                    Professor13 professor13 = (Professor13) pessoa13;
                    professor13.setDisciplina(validandoDisciplina(scanner,escola13));
                    professor13.setSalario(validandoSalario(scanner,escola13));
                }
            }else {
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public List<Pessoa13> getPessoa13s() {
        return pessoa13s;
    }

}
