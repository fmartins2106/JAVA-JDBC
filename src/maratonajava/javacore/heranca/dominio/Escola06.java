package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Escola06 {
    private List<Pessoa06> pessoa06s;

    public Escola06(){
        this.pessoa06s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa06.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    private boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Professor06.MENSAGEM_ERRO_DISCIPLINA);
            return false;
        }
        return true;
    }


    public static String validandoNome(Scanner scanner, Escola06 escola06){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola06.validacaoNome(nome)){
                return Pessoa06.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < Pessoa06.IDADE_MINIMA){
                    System.out.println(Pessoa06.MENSAGEM_ERRO_IDADE_MINIMA);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite uma idade válida.");
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
                System.out.println(Pessoa06.MENSAGEM_ERRO_CPF);
            }
        }
    }


    public static boolean isCpfValido(String cpf){
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

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public static int validandoMatricula(Scanner scanner, List<Pessoa06> pessoa06s){
        while (true){
            try {
                System.out.print("Matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (matricula < Aluno06.MENOR_MATRICULA){
                    System.out.println(Aluno06.MENSAGEM_ERRO_MATRICULA);
                    continue;
                }
                boolean matriculaExiste = pessoa06s.stream().anyMatch(p -> p instanceof Aluno06 && ((Aluno06)p).getMatricula()==matricula);
                if (matriculaExiste){
                    System.out.println("Matríicula existente, tente novamente.");
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
                        System.out.print("Digite a "+(i+1)+"ª nota:");
                        notas[i] = Double.parseDouble(scanner.nextLine());
                        if (notas[i] < Aluno06.MENOR_MATRICULA || notas[i] > Aluno06.MAIOR_NOTA){
                            System.out.println(Aluno06.MENSAGEM_ERRO_NOTA);
                        }else {
                            break;
                        }
                    }
                }
                return notas;
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
        }
    }

    public static String validandoDisciplina(Scanner scanner, Escola06 escola06){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine();
            if (escola06.validacaoDisciplina(disciplina)){
                return Pessoa06.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < Professor06.MENOR_SALARIO_PROF){
                    System.out.println(Professor06.MENSAGEM_ERRO_SALARIO_PROF);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaPessoas(){
        if (pessoa06s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa06s.forEach(System.out::println);
        }
    }

    public Pessoa06 pesquisaPorPessoa(Scanner scanner){
        Pessoa06 pessoa06;
        if (pessoa06s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            pessoa06 = pessoa06s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa06 !=null){
                System.out.println("__________________________________");
                System.out.println("Nome:"+pessoa06.getNome());
                System.out.println("Idade:"+pessoa06.getIdade());
                System.out.println("CPF:"+pessoa06.getCpf());
                if (pessoa06 instanceof Aluno06){
                    Aluno06 aluno06 = (Aluno06) pessoa06;
                    System.out.println("Matricula:"+aluno06.getMatricula());
                    System.out.println("Notas:"+ Arrays.toString(aluno06.getNotas()));
                    System.out.println("Média:"+aluno06.getMedia());
                }
                if (pessoa06 instanceof Professor06){
                    Professor06 professor06 = (Professor06) pessoa06;
                    System.out.println("Disciplina:"+professor06.getDisciplina());
                    System.out.println("Salário:R$"+professor06.getSalario());
                }
                System.out.println("__________________________________");
            }else {
                System.out.println("Pessoa não cadastrada.");
                return null;
            }
        }
        return pessoa06;
    }

    public void excluirPessoa(Scanner scanner){
        if (pessoa06s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa06 pessoa06 = pesquisaPorPessoa(scanner);
            pessoa06s.remove(pessoa06);
            System.out.println("Dados excluidos com sucesso.");
        }
    }

    public void alterandoDados(Scanner scanner, Escola06 escola06){
        if (pessoa06s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa06 pessoa06 = pessoa06s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa06 != null){
                pessoa06.setNome(validandoNome(scanner,escola06));
                pessoa06.setIdade(validandoIdade(scanner));
                pessoa06.setCpf(validandoCpf(scanner));
                if (pessoa06 instanceof Aluno06){
                    Aluno06 aluno06 = (Aluno06) pessoa06;
                    aluno06.setMatricula(validandoMatricula(scanner,escola06.getPessoa06s()));
                    aluno06.setNotas(validandoNotas(scanner));
                }
                if (pessoa06 instanceof Professor06){
                    Professor06 professor06 = (Professor06) pessoa06;
                    professor06.setDisciplina(validandoDisciplina(scanner,escola06));
                    professor06.setSalario(validandoSalario(scanner));
                }
            }else {
                System.out.println("Nome não cadastrado.");
            }
        }
    }

    public void addPessoas(Pessoa06 pessoa06){
        pessoa06s.add(pessoa06);
    }

    public List<Pessoa06> getPessoa06s() {
        return pessoa06s;
    }

    public void setPessoa06s(List<Pessoa06> pessoa06s) {
        this.pessoa06s = pessoa06s;
    }
}
