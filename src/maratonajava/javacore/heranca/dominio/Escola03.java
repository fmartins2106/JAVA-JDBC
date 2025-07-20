package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escola03 {
    private List<Pessoa03> pessoa03s;

    public Escola03(){
        this.pessoa03s = new ArrayList<>();
    }

    public void addPessoas(Pessoa03 pessoa03){
        pessoa03s.add(pessoa03);
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa03.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    private boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Professor03.MENSAGEM_ERRO_DISCIPLINA);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola03 escola03){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola03.validacaoNome(nome)){
                return Pessoa03.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < Pessoa03.IDADE_MINIMA){
                    System.out.println(Pessoa03.MENSAGEM_ERRO_IDADE);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (isCpfValido(cpf)){
                return cpf;
            }else {
                System.out.println(Pessoa03.MENSAGE_ERRO_CPF);
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
            soma+=(cpf.charAt(i) - '0') * (10 -i);
        }
        int digito1 = 11 - ( soma % 11);
        digito1 = (digito1 >= 10 ) ? 0: digito1;
        soma = 0;

        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0')  == digito2;
    }

    public static int validandoMatricula(Scanner scanner, List<Pessoa03> pessoa03s){
        while (true){
            try {
                System.out.print("Matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (matricula < Aluno03.MENOR_MATRICULA){
                    System.out.println(Aluno03.MENSAGEM_ERRO_MATRICULA);
                    continue;
                }
                boolean matriculaExiste  = pessoa03s.stream().anyMatch(p -> p instanceof Aluno03 && ((Aluno03)p).getMatricula()==matricula);
                if (matriculaExiste){
                    System.out.println("Matricula já existe, tente outro.");
                    continue;
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
                    System.out.print("Digite a "+(i+1)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (notas[i] <0 || notas[i]>10){
                        System.out.println("Nota inválida. Digite uma nota entre 0 e 10.");
                        i--;
                    }
                }
                return notas;
            }catch (NumberFormatException e){
                System.out.println("Digite uma nota válida.");
            }
        }
    }

    public static String validandoDisciplina(Scanner scanner, Escola03 escola03){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola03.validacaoDisciplina(disciplina)){
                return Pessoa03.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < Professor03.SALARIO_MINIMO_PROFESSOR){
                    System.out.println(Professor03.MENSAGEM_SALARIO_MINIMO_PROFESSOR);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listarPessoas(){
        if (pessoa03s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa03s.forEach(System.out::println);
        }
    }

    public Pessoa03 pesquisaPorNome(Scanner scanner){
        Pessoa03 pessoa03 = null;
        if (pessoa03s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            pessoa03 = pessoa03s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa03 != null){
                System.out.println("_______________________________________");
                System.out.println("Nome:"+pessoa03.getNome());
                System.out.println("Idade:"+pessoa03.getIdade());
                System.out.println("CPF:"+pessoa03.getCpf());
                if (pessoa03 instanceof Aluno03){
                    Aluno03 aluno03 = (Aluno03) pessoa03;
                    System.out.println("Matricula:"+aluno03.getMatricula());
                    System.out.println("Média:"+aluno03.getMedia());
                }
                if (pessoa03 instanceof Professor03){
                    Professor03 professor03 = (Professor03) pessoa03;
                    System.out.println("Disciplina:"+professor03.getDisciplina());
                    System.out.println("Salário:R$"+professor03.getSalario());
                }
                System.out.println("_______________________________________");
            }else {
                System.out.println("Cadastro não encontrado.");
                return null;
            }
        }
        return pessoa03;
    }

    public void excluindoPessoa(Scanner scanner){
        if (pessoa03s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa03 pessoa03 = pesquisaPorNome(scanner);
            pessoa03s.remove(pessoa03);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterandoDados(Scanner scanner, Escola03 escola03){
        if (pessoa03s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa03 pessoa03 = pessoa03s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa03 != null){
                System.out.println("_______________________________");
                pessoa03.setNome(validandoNome(scanner,escola03));
                pessoa03.setIdade(validandoIdade(scanner));
                pessoa03.setCpf(validandoCpf(scanner));
                if (pessoa03 instanceof Aluno03){
                    Aluno03 aluno03 = (Aluno03) pessoa03;
                    aluno03.setMatricula(validandoMatricula(scanner,escola03.getPessoa03s()));
                    aluno03.setNota(validandoNotas(scanner));
                }
                if (pessoa03 instanceof Professor03){
                    Professor03 professor03 = (Professor03) pessoa03;
                    professor03.setDisciplina(validandoDisciplina(scanner,escola03));
                    professor03.setSalario(validandoSalario(scanner));
                }
            }else {
                System.out.println("Cadastro não encontrado.");
            }
        }
    }

    public List<Pessoa03> getPessoa03s() {
        return pessoa03s;
    }

    public void setPessoa03s(List<Pessoa03> pessoa03s) {
        this.pessoa03s = pessoa03s;
    }
}
