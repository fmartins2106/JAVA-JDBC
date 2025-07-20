package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Escola08 {
    private List<Pessoa08> pessoa08s;

    public Escola08(){
        this.pessoa08s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa08.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    private boolean validacaoIdade(int idade){
        if (idade < Pessoa08.IDADE_MINIMA){
            System.out.println(Pessoa08.MENSAGEM_ERRO_IDADE_MINIMA);
            return false;
        }
        return true;
    }

    private boolean isCpfValido(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")){
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

    public static String validandoNome(Scanner scanner, Escola08 escola08){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola08.validacaoNome(nome)){
                return Pessoa08.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Escola08 escola08){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (escola08.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Escola08 escola08){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (escola08.isCpfValido(cpf)){
                return cpf;
            }else {
                System.out.println(Pessoa08.MENSAGEM_ERRO_CPF);
            }
        }
    }

    public boolean validacaoMatricula(int matricula){
        if (matricula < Aluno08.MENOR_MATRICULA){
            System.out.println(Aluno08.MENSAGEM_ERRO_MATRICULA);
            return false;
        }
        return true;
    }

    public static int validandoMatricula(Scanner scanner, Escola08 escola08){
        while (true){
            try {
                System.out.print("Matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (escola08.validacaoMatricula(matricula)){
                    boolean matriculaExiste = escola08.getPessoa08s().stream().anyMatch(p -> p instanceof Aluno08 && ((Aluno08)p).getMatricula() == matricula);
                    if (matriculaExiste){
                        System.out.println("Matriula já cadastrada, tente novamente.");
                    }else {
                        return matricula;
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma matrícula válida.");
            }
        }
    }

    public boolean validacaoNotas(double nota){
        if (nota < Aluno08.MENOR_NOTA || nota > Aluno08.MAIOR_NOTA){
            System.out.println(Aluno08.MENSAGEM_ERRO_NOTA);
            return false;
        }
        return true;
    }

    public static double[] validandoNotas(Scanner scanner, Escola08 escola08){
        double[] notas = new double[4];
        while (true){
            try {
                for (int i = 0; i < notas.length; i++) {
                    try {
                        while (true){
                            System.out.print("Digite a "+(i+1)+"ª nota:");
                            notas[i] = Integer.parseInt(scanner.nextLine());
                            if (escola08.validacaoNotas(notas[i])){
                                break;
                            }else {
                                System.out.println("Nota inválida, tente novamente.");
                            }
                        }
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
                    }
                }
                return notas;
            }catch (NumberFormatException e){
                System.out.println("Digite uma nota válida.");
            }
        }
    }

    private boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Professor08.MENSAGEM_ERRO_DISCIPLINA);
            return false;
        }
        return true;
    }

    public static String validacaoDisciplina(Scanner scanner, Escola08 escola08){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola08.validacaoDisciplina(disciplina)){
                return Pessoa08.formatoNome(disciplina);
            }
        }
    }

    private boolean validacaoSalario(double salario){
        if (salario <Professor08.MENOR_SALARIO){
            System.out.println(Professor08.MENSAGEM_ERRO_SALARIO);
            return false;
        }
        return true;
    }

    public static double validandoSalario(Scanner scanner, Escola08 escola08){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (escola08.validacaoSalario(salario)){
                    return salario;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void addPessoalista(Pessoa08 pessoa08){
        pessoa08s.add(pessoa08);
    }

    public void listaPessoasCadastradas(){
        if (pessoa08s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa08s.forEach(System.out::println);
        }
    }

    public Pessoa08 pesquisaPorNome(Scanner scanner, Escola08 escola08){
        Pessoa08 pessoa08;
        if (pessoa08s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine();
            pessoa08 = pessoa08s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa08 != null){
                System.out.println("Nome:"+pessoa08.getNome());
                System.out.println("Idade:"+pessoa08.getIdade());
                System.out.println("CPF:"+pessoa08.getCpf());
                if (pessoa08 instanceof Aluno08){
                    Aluno08 aluno08 = (Aluno08) pessoa08;
                    System.out.println("Matricula:"+aluno08.getMatricula());
                    System.out.println("Notas:"+ Arrays.toString(aluno08.getNotas()));
                    System.out.println("Média:"+aluno08.getMedia());
                }
                if (pessoa08 instanceof Professor08){
                    Professor08 professor08 = (Professor08) pessoa08;
                    System.out.println("Disciplina:"+professor08.getDisciplina());
                    System.out.println("Salário:R$"+professor08.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado, tente novamente.");
            }
        }
        return pessoa08;
    }

    public void excluirDadosPessoa(Scanner scanner, Escola08 escola08){
        if (pessoa08s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa08 pessoa08 = pesquisaPorNome(scanner,escola08);
            pessoa08s.remove(pessoa08);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDados(Scanner scanner,Escola08 escola08){
        if (pessoa08s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa08 pessoa08 = pessoa08s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa08 != null){
                pessoa08.setNome(validandoNome(scanner,escola08));
                pessoa08.setIdade(validandoIdade(scanner,escola08));
                pessoa08.setCpf(validandoCpf(scanner,escola08));
                if (pessoa08 instanceof Aluno08){
                    Aluno08 aluno08 = (Aluno08) pessoa08;
                    aluno08.setMatricula(validandoMatricula(scanner,escola08));
                    aluno08.setNotas(validandoNotas(scanner,escola08));
                }
                if (pessoa08 instanceof Professor08){
                    Professor08 professor08 = (Professor08) pessoa08;
                        professor08.setDisciplina(validacaoDisciplina(scanner,escola08));
                        professor08.setSalario(validandoSalario(scanner,escola08));
                }
            }else {
                System.out.println("Nome não encontrado. Digite novamente.");
            }
        }
    }

    public List<Pessoa08> getPessoa08s() {
        return pessoa08s;
    }

    public void setPessoa08s(List<Pessoa08> pessoa08s) {
        this.pessoa08s = pessoa08s;
    }
}
