package academy.devdojo.maratonajava.javacore.heranca.dominio;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Escola11 {
    private List<Pessoa11> pessoa11s;

    public Escola11(){
        this.pessoa11s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome ==  null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa11.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    private boolean isCpfValido(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}")){
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

        soma=0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;

    }

    private boolean validacaoIdade(int idade){
        if (idade < Pessoa11.IDADE_MINIMA){
            System.out.println(Pessoa11.MENSAGEM_ERRO_IDADE);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola11 escola11){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine();
            if (escola11.validacaoNome(nome)){
                return Pessoa11.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Escola11 escola11){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (escola11.isCpfValido(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Escola11 escola11){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (escola11.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println(Pessoa11.MENSAGEM_ERRO_IDADE);
            }
        }
    }

    private boolean validacaoMatricula(int matricula){
        if (matricula < Aluno11.MENOR_NUMERO_MATRICULA){
            System.out.println(Aluno11.MENSAGEM_ERRO_MATRICULA);
            return false;
        }
        return true;
    }

    private boolean validancaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < Aluno11.MENOR_NOTA || nota > Aluno11.MAIOR_NOTA){
                System.out.println(Aluno11.MENSAGEM_ERRO_NOTA);
                return false;
            }
        }
        return true;
    }

    public static int validandoMatricula(Scanner scanner, Escola11 escola11){
        while (true){
            try {
                System.out.print("Matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (escola11.validacaoMatricula(matricula)){
                    boolean matriculExiste = escola11.pessoa11s.stream().anyMatch(p -> p instanceof Aluno11 && ((Aluno11) p).getMatricula() == matricula);
                    if (matriculExiste){
                        System.out.println("Matricula já cadastrada, tente novamente.");
                    }
                    return matricula;
                }
            }catch (NumberFormatException e){
                System.out.println("Número inválido, tente novamente.");
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner, Escola11 escola11){
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(1+i)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (escola11.validancaoNotas(notas)){
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Digite uma nota válida.");
                }
            }
        }
        return notas;
    }

    public boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Professor11.MENSAGEM_ERRO_DISCIPLINA);
            return false;
        }
        return true;
    }

    public boolean validacaoSalario(double salario){
        if (salario < Professor11.SALARIO_MINIMO_PROF){
            System.out.println(Professor11.MENSAGEM_ERRO_SALARIO);
            return false;
        }
        return true;
    }

    public static String validandoDisciplina(Scanner scanner, Escola11 escola11){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola11.validacaoDisciplina(disciplina)){
                return Pessoa11.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalario(Scanner scanner,Escola11 escola11){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (escola11.validacaoSalario(salario)){
                    return salario;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaPessoas(){
        if (pessoa11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa11s.forEach(System.out::println);
        }
    }

    public Pessoa11 pesquisaPorNome(Scanner scanner, Escola11 escola11){
        Pessoa11 pessoa11 = null;
        if (pessoa11s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            pessoa11 = pessoa11s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa11 != null){
                System.out.println("Nome:"+pessoa11.getNome());
                System.out.println("CPF:"+pessoa11.getCpf());
                System.out.println("Idade:"+pessoa11.getIdade());
                if (pessoa11 instanceof Aluno11){
                    Aluno11 aluno11 = (Aluno11) pessoa11;
                    System.out.println("Matricula:"+((Aluno11) pessoa11).getMatricula());
                    System.out.println("Notas:"+ Arrays.toString(((Aluno11) pessoa11).getNotas()));
                }
                if (pessoa11 instanceof Professor11){
                    Professor11 professor11 = (Professor11) pessoa11;
                    System.out.println("Disciplina:"+((Professor11) pessoa11).getDisciplina());
                    System.out.println("Salário:R$"+((Professor11) pessoa11).getSalario());
                }
            }else {
                System.out.println("Nome não encontrado.");
                return null;
            }
        }
        return pessoa11;
    }

    public void excluirDados(Scanner scanner, Escola11 escola11){
        if (pessoa11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa11 pessoa11 = pesquisaPorNome(scanner,escola11);
            pessoa11s.remove(pessoa11);
            System.out.println("Dados removidos com sucesso.");
        }
    }
    public void alterandoDados(Scanner scanner, Escola11 escola11){
        if (pessoa11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa11 pessoa11 = pessoa11s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa11 != null){
                pessoa11.setNome(validandoNome(scanner,escola11));
                pessoa11.setCpf(validandoCpf(scanner,escola11));
                pessoa11.setIdade(validandoIdade(scanner,escola11));
                if (pessoa11 instanceof Aluno11){
                    Aluno11 aluno11 = (Aluno11) pessoa11;
                    ((Aluno11) pessoa11).setMatricula(validandoMatricula(scanner,escola11));
                    ((Aluno11) pessoa11).setNotas(validandoNotas(scanner,escola11));
                }
                if (pessoa11 instanceof Professor11){
                    Professor11 professor11 = (Professor11) pessoa11;
                    ((Professor11) pessoa11).setDisciplina(validandoDisciplina(scanner,escola11));
                    ((Professor11) pessoa11).setSalario(validandoSalario(scanner,escola11));
                }
            }else {
                System.out.println("Salário inválido.");
            }
        }
    }

    public void addPessoas(Pessoa11 pessoa11){
        pessoa11s.add(pessoa11);
    }

}
