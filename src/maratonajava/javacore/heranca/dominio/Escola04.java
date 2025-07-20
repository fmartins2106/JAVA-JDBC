package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escola04 {
    private List<Pessoa04> pessoa04s;

    public Escola04(){
        this.pessoa04s = new ArrayList<>();
    }

    public void addPessoas(Pessoa04 pessoa04){
        pessoa04s.add(pessoa04);
    }

    private static boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa04.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola04 escola04){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (Escola04.validacaoNome(nome)){
                return Pessoa04.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < Pessoa04.IDADE_MINIMA){
                    System.out.println(Pessoa04.MENSAGEM_ERR0_IDADE_MINIMA);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while ( true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine();
            if (isCpfValido(cpf)){
                return cpf;
            }else {
                System.out.println(Pessoa04.MENSAGEM_ERRO_CPF);
            }
        }
    }
    

    public static boolean isCpfValido(String cpf){
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
        int digito1 = 11  - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2  = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public static int validandoMatricula(Scanner scanner, List<Pessoa04> pessoa04s){
        while (true){
            try {
                System.out.print("Matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (matricula < Aluno04.MENOR_NUMERO_MATRICULA){
                    System.out.println(Aluno04.MENSAGEM_ERRO_MATRICULA);
                    continue;
                }
                boolean matriculaExiste = pessoa04s.stream().anyMatch(p -> p instanceof Aluno04 && ((Aluno04)p).getMatricula()== matricula);
                if (matriculaExiste){
                    System.out.println("Matricula já existe. Tente novamente.");
                }
                return matricula;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner){
        double[] notas = new double[4];
        while (true){
            try {
                for (int i = 0; i < notas.length; i++) {
                    while (true){
                        System.out.print("Digite a "+(i+1)+"ª nota:");
                        notas[i] = Double.parseDouble(scanner.nextLine());
                        if (notas[i] < Aluno04.MENOR_NOTA || notas[i] > Aluno04.MAIOR_NOTA){
                            System.out.println(Aluno04.MENSAGEM_ERRO_NOTA);
                        }else {
                            break;
                        }
                    }
                }
                return notas;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    private boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Professor04.MENSAGEM_ERRO_DISCIPLINA);
            return false;
        }
        return true;
    }

    public static String validandoDisciplina(Scanner scanner, Escola04 escola04){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola04.validacaoDisciplina(disciplina)){
                return Pessoa04.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalarioProfessor(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < Professor04.SALARIO_MINIMO_PROFESSOR){
                    System.out.println(Professor04.MENSAGEM_ERRO_SALARIO_PROF);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listarPessoas(){
        if (pessoa04s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa04s.forEach(System.out::println);
        }
    }

    public Pessoa04 pesquisaNome(Scanner scanner){
        Pessoa04 pessoa04 = null;
        if (pessoa04s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome");
            String nome = scanner.nextLine().trim();
            pessoa04 = pessoa04s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa04 !=null){
                System.out.println("____________________________");
                System.out.println("Nome:"+pessoa04.getNome());
                System.out.println("Idade:"+pessoa04.getIdade());
                System.out.println("CPF:"+pessoa04.getCpf());
                if (pessoa04 instanceof Aluno04){
                    Aluno04 aluno04 = (Aluno04) pessoa04;
                    System.out.println("Matricula:"+aluno04.getMatricula());
                    System.out.println("Média:"+aluno04.getMedia());
                }
                if (pessoa04 instanceof Professor04){
                    Professor04 professor04 = (Professor04) pessoa04;
                    System.out.println("Disciplina:"+professor04.getDisciplina());
                    System.out.println("Salário:R$"+professor04.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado, tente novamente.");
                return null;
            }
        }
        return pessoa04;
    }

    public void excluirDados(Scanner scanner){
        if (pessoa04s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa04 pessoa04 = pesquisaNome(scanner);
            pessoa04s.remove(pessoa04);
            System.out.println("Dados removidos com sucesso");
        }
    }

    public void alterandoDados(Scanner scanner, Escola04 escola04){
        if (pessoa04s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome");
            String nome = scanner.nextLine().trim();
            Pessoa04 pessoa04 = pessoa04s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa04 != null){
                pessoa04.setNome(validandoNome(scanner,escola04));
                pessoa04.setIdade(validandoIdade(scanner));
                pessoa04.setCpf(validandoCpf(scanner));
                if (pessoa04 instanceof Aluno04){
                    Aluno04 aluno04 = (Aluno04) pessoa04;
                    aluno04.setMatricula(validandoMatricula(scanner,escola04.getPessoa04s()));
                    aluno04.setNotas(validandoNotas(scanner));
                }
                if (pessoa04 instanceof Professor04){
                    Professor04 professor04 = (Professor04) pessoa04;
                    professor04.setDisciplina(validandoDisciplina(scanner,escola04));
                    professor04.setSalario(validandoSalarioProfessor(scanner));
                }
            }else {
                System.out.println("Nome não encontrado. Tente novamente.");
            }
        }
    }

    public List<Pessoa04> getPessoa04s() {
        return pessoa04s;
    }

    public void setPessoa04s(List<Pessoa04> pessoa04s) {
        this.pessoa04s = pessoa04s;
    }
}
