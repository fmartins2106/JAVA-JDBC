package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Escola07 {
    private List<Pessoa07> pessoa07s;

    public Escola07(){
        this.pessoa07s = new ArrayList<>();
    }

    public void addPessoas (Pessoa07 pessoa07){
        pessoa07s.add(pessoa07);
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println("Campo nome não pode ser vazio ou conter caracteres. Digite nome completo.");
            return false;
        }
        return true;
    }

    private boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Professor07.MENSAGEM_ERRO_DISCIPLINA);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola07 escola07){
        while (true){
            System.out.print("Nome");
            String nome = scanner.nextLine().trim();
            if (escola07.validacaoNome(nome)){
                return Pessoa07.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < Pessoa07.IDADE_MINIMA){
                    System.out.println(Pessoa07.MENSAGEM_ERRO_IDADE);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Escola07 escola07){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (escola07.isCpfValido(cpf)){
                return cpf;
            }else {
                System.out.println("CPF inválido, tente novamente.");
            }
        }
    }

    public boolean isCpfValido(String cpf){
        if (cpf == null || cpf.isEmpty() || !cpf.matches("\\d{11}")){
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

    public static int validandoMatricula(Scanner scanner, List<Pessoa07> pessoa07s){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (matricula < Aluno07.MENOR_MATRICULA){
                    System.out.println(Aluno07.MENSAGEM_ERRO_MATRICULA);
                    continue;
                }
                boolean matriculaExiste = pessoa07s.stream().anyMatch(p -> p instanceof Aluno07 && ((Aluno07)p).getMatricula() == matricula);
                if (matriculaExiste){
                    System.out.println("Matricula á cadastrada, tente novamente.");
                }else {
                    return matricula;
                }
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
                        System.out.print("Digite a "+(i+1)+"º nota:");
                        notas[i] = Double.parseDouble(scanner.nextLine());
                        if (notas[i] < Aluno07.MENOR_NOTA || notas[i] > Aluno07.MAIOR_NOTA){
                            System.out.println(Aluno07.MENSAGEM_ERRO_NOTA);
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

    public static String validandoDisciplina(Scanner scanner, Escola07 escola07){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola07.validacaoDisciplina(disciplina)){
                return Pessoa07.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < Professor07.SALARIO_MINIMO_PROFESSOR){
                    System.out.println(Professor07.MENSAGEM_ERRO_SALARIO_MINIMO);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listarPessoas(){
        if (pessoa07s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa07s.forEach(System.out::println);
        }
    }

    public Pessoa07 pesquisaPorNome(Scanner scanner){
        Pessoa07 pessoa07;
        if (pessoa07s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Digite nome:");
            String nome = scanner.nextLine().trim();
            pessoa07 = pessoa07s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa07 != null){
                System.out.println("Nome:"+pessoa07.getNome());
                System.out.println("Idade:"+pessoa07.getIdade());
                System.out.println("CPF:"+pessoa07.getCpf());
                if (pessoa07 instanceof Aluno07){
                    Aluno07 aluno07 = (Aluno07) pessoa07;
                    System.out.println("Matricula:"+aluno07.getMatricula());
                    System.out.println("Notas:"+ Arrays.toString(aluno07.getNotas()));
                    System.out.println("Média:"+aluno07.getMedia());
                }
                if (pessoa07 instanceof Professor07){
                    Professor07 professor07 = (Professor07) pessoa07;
                    System.out.println("Disciplina:"+professor07.getDisciplina());
                    System.out.println("Salário:R$"+professor07.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado.");
                return null;
            }
        }
        return pessoa07;
    }

    public void excluindoCadastro(Scanner scanner){
        if (pessoa07s.isEmpty()){
            System.out.println("Lista vazia.");
        }else{
            Pessoa07 pessoa07 = pesquisaPorNome(scanner);
            pessoa07s.remove(pessoa07);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosPessoa(Scanner scanner, Escola07 escola07){
        if (pessoa07s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa07 pessoa07 = pessoa07s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa07 != null){
                pessoa07.setNome(validandoNome(scanner,escola07));
                pessoa07.setIdade(validandoIdade(scanner));
                pessoa07.setCpf(validandoCpf(scanner,escola07));
                if (pessoa07 instanceof Aluno07){
                    Aluno07 aluno07 = (Aluno07) pessoa07;
                    aluno07.setMatricula(validandoMatricula(scanner,escola07.getPessoa07s()));
                    aluno07.setNotas(validandoNotas(scanner));
                }
                if (pessoa07 instanceof Professor07){
                    Professor07 professor07 = (Professor07) pessoa07;
                    professor07.setDisciplina(validandoDisciplina(scanner,escola07));
                    professor07.setSalario(validandoSalario(scanner));
                }
            }else {
                System.out.println("Nome não encontrado. Tente novamente.");
            }
        }
    }

    public List<Pessoa07> getPessoa07s() {
        return pessoa07s;
    }

    public void setPessoa07s(List<Pessoa07> pessoa07s) {
        this.pessoa07s = pessoa07s;
    }
}
