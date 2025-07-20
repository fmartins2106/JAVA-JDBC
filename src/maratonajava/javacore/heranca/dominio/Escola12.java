package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Escola12 {
    private List<Pessoa12> pessoa12s;

    public Escola12(){
        this.pessoa12s = new ArrayList<>();
    }

    public boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa12.validationMessage.ERRO_NOME);
            return false;
        }
        return true;
    }

    public boolean validacaoCpf(String cpf){
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

        soma=0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public boolean validacaoIdade(int idade){
        if (idade < Pessoa12.IDADE_MINIMA){
            System.out.println(Pessoa12.validationMessage.ERRO_IDADE);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola12 escola12){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola12.validacaoNome(nome)){
                return Pessoa12.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Escola12 escola12){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (escola12.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Escola12 escola12){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (escola12.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public boolean validacaoMatricula(int matricula){
        if (matricula < Aluno12.MENOR_MATRICULA){
            System.out.println(Pessoa12.validationMessage.ERRO_MATRICULA);
            return false;
        }
        return true;
    }

    public boolean validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < Aluno12.NOTA_MINIMA || nota > Aluno12.NOTA_MAXIMA){
                return false;
            }
        }
        return true;
    }

    public static int validandoMatricula(Scanner scanner, Escola12 escola12){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (escola12.validacaoMatricula(matricula)){
                    boolean matriculaExiste = escola12.getPessoa12s().stream().anyMatch(p -> p instanceof Aluno12 && ((Aluno12)p).getMatricula()== matricula);
                    if (matriculaExiste){
                        System.out.println(Pessoa12.validationMessage.ERRO_MATRICULA);
                    }else {
                        return matricula;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner, Escola12 escola12){
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(1+i)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (escola12.validacaoNotas(notas)){
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
            System.out.println(Pessoa12.validationMessage.ERRO_DISCIPLINA);
            return false;
        }
        return true;
    }

    private boolean validacaoSalario(double salario){
        if (salario < Professor12.SALARIO_MINIMO_PROF){
            System.out.println(Pessoa12.validationMessage.ERRO_SALARIO);
            return false;
        }
        return true;
    }

    public static String validandoDisciplina(Scanner scanner, Escola12 escola12){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola12.validacaoDisciplina(disciplina)){
                return Pessoa12.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalario(Scanner scanner, Escola12 escola12){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (escola12.validacaoSalario(salario)){
                    return salario;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void addPessoas(Pessoa12 pessoa12){
        pessoa12s.add(pessoa12);
    }

    public void listaPessoas(){
        if (pessoa12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa12s.forEach(System.out::println);
        }
    }

    public Pessoa12 pesquisaNome(Scanner scanner, Escola12 escola12){
        Pessoa12 pessoa12 = null;
        if (pessoa12s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            pessoa12 = pessoa12s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa12 != null){
                System.out.println("___________________________________");
                System.out.println("Nome:"+pessoa12.getNome());
                System.out.println("CPF:"+pessoa12.getCpf());
                System.out.println("Idade:"+pessoa12.getIdade());
                if (pessoa12 instanceof Aluno12){
                    Aluno12 aluno12 = (Aluno12) pessoa12;
                    System.out.println("Matrícula:"+((Aluno12) pessoa12).getMatricula());
                    System.out.println("Notas:"+ Arrays.toString(((Aluno12) pessoa12).getNotas()));
                    System.out.println("Média:"+((Aluno12) pessoa12).getMedia());
                }
                if (pessoa12 instanceof Professor12){
                    Professor12 professor12 = (Professor12) pessoa12;
                    System.out.println("Disciplina:"+professor12.getDisciplina());
                    System.out.println("Salário:"+professor12.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado.");
                return null;
            }
        }
        return pessoa12;
    }

    public void  excluirPessoa(Scanner scanner, Escola12 escola12){
        if (pessoa12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa12 pessoa12 = pesquisaNome(scanner,escola12);
            pessoa12s.remove(pessoa12);
            System.out.println("Dados excluidos com sucesso.");
        }
    }

    public void alterandoDados(Scanner scanner, Escola12 escola12){
        if (pessoa12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa12 pessoa12 = pessoa12s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa12 != null){
                pessoa12.setNome(validandoNome(scanner,escola12));
                pessoa12.setCpf(validandoCpf(scanner,escola12));
                pessoa12.setIdade(validandoIdade(scanner,escola12));
                if (pessoa12 instanceof Aluno12){
                    Aluno12 aluno12 = (Aluno12) pessoa12;
                    ((Aluno12) pessoa12).setMatricula(validandoMatricula(scanner,escola12));
                    ((Aluno12) pessoa12).setNotas(validandoNotas(scanner,escola12));
                }
                if (pessoa12 instanceof Professor12){
                    Professor12 professor12 = (Professor12) pessoa12;
                    professor12.setDisciplina(validandoDisciplina(scanner,escola12));
                    ((Professor12) pessoa12).setSalario(validandoSalario(scanner,escola12));
                }
            }
        }
    }


    public List<Pessoa12> getPessoa12s() {
        return pessoa12s;
    }

    public void setPessoa12s(List<Pessoa12> pessoa12s) {
        this.pessoa12s = pessoa12s;
    }
}
