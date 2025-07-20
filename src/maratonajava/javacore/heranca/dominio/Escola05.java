package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Escola05 {
    private List<Pessoa05> pessoa05s;

    public Escola05(){
        this.pessoa05s = new ArrayList<>();
    }

    public void addPessoas(Pessoa05 pessoa05){
        pessoa05s.add(pessoa05);
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa05.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    private boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Professor05.MENSAGEM_ERRO_DISCIPLINA);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola05 escola05){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola05.validacaoNome(nome)){
                return Pessoa05.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade =Integer.parseInt(scanner.nextLine());
                if (idade < Pessoa05.IDADE_MINIMA){
                    System.out.println(Pessoa05.MENSAGEM_ERRO_IDADE_MINIMA);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
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

        int soma = 0;
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

    public static String validandoCpf(Scanner scanner){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine();
            if (isCpfValido(cpf)){
                return cpf;
            }else {
                System.out.println(Pessoa05.MENSAGEM_ERRO_CPF);
            }
        }
    }

    public static int validandoMatricula(Scanner scanner, List<Pessoa05> pessoa05s){
        while (true){
            try {
                System.out.print("Matricula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (matricula < Aluno05.MENOR_NUM_MATRICULA){
                    System.out.println(Aluno05.MENSAGEM_ERRO_MATRICULA);
                    continue;
                }
                boolean matriculaExiste = pessoa05s.stream().anyMatch(p -> p instanceof Aluno05 && ((Aluno05)p).getMatricula()==matricula);
                if (matriculaExiste){
                    System.out.println("Matricula já existente, tente outro número.");
                }else {
                    return matricula;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double[] validandonotas(Scanner scanner){
        double[] notas = new double[4];
        while (true){
            try {
                for (int i = 0; i < notas.length; i++) {
                    while (true){
                        System.out.print("Digite a "+(i+1)+"ª nota:");
                        notas[i] = Double.parseDouble(scanner.nextLine());
                        if (notas[i] < Aluno05.MENOR_NOTA || notas[i] > Aluno05.MAIOR_NOTA){
                            System.out.println(Aluno05.MENSAGEM_ERRO_NOTA);
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


    public static String validandoDisciplina(Scanner scanner, Escola05 escola05){
        while (true){
            System.out.print("Disciplina:");
            String disciplina  = scanner.nextLine().trim();
            if (escola05.validacaoDisciplina(disciplina)){
                return Pessoa05.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < Professor05.SALARIO_MINIMO_PROF){
                    System.out.println(Professor05.MENSAGEM_ERRO_SALARIO_PROF);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaPessoas(){
        if (pessoa05s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa05s.forEach(System.out::println);
        }
    }

    public Pessoa05 pesquisaPorNome(Scanner scanner){
        Pessoa05 pessoa05;
        if (pessoa05s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            pessoa05 = pessoa05s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa05 != null){
                System.out.println("______________________________");
                System.out.println("Nome:"+pessoa05.getNome());
                System.out.println("Idade:"+pessoa05.getIdade());
                System.out.println("CPF:"+pessoa05.getCpf());
                if (pessoa05 instanceof Aluno05 ){
                    Aluno05 aluno05 = (Aluno05) pessoa05;
                    System.out.println("Matricula:"+aluno05.getMatricula());
                    System.out.println("Notas:"+ Arrays.toString(aluno05.getNotas()));
                    System.out.println("Média:"+aluno05.getMedia());
                }
                if (pessoa05 instanceof Professor05){
                    Professor05 professor05 = (Professor05) pessoa05;
                    System.out.println("Disciplina:"+professor05.getDisciplina());
                    System.out.println("Salário:R$"+professor05.getSalario());
                }
                System.out.println("______________________________");
            }else {
                System.out.println("Cadastro não encontrado");
                return null;
            }
        }
        return pessoa05;
    }

    public void excluirDados(Scanner scanner){
        if (pessoa05s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa05 pessoa05 = pesquisaPorNome(scanner);
            if (pessoa05 != null){
                pessoa05s.remove(pessoa05);
                System.out.println("Dados removidos com sucesso.");
            }else {
                System.out.println("Dados não encontrado.");
            }
        }
    }

    public void alterarDados(Scanner scanner, Escola05 escola05){
        if (pessoa05s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa05 pessoa05 = pessoa05s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa05 != null){
                System.out.println("___________________________");
                pessoa05.setNome(validandoNome(scanner,escola05));
                pessoa05.setIdade(validandoIdade(scanner));
                pessoa05.setCpf(validandoCpf(scanner));
                if (pessoa05 instanceof Aluno05){
                    Aluno05 aluno05 = (Aluno05) pessoa05;
                    aluno05.setMatricula(validandoMatricula(scanner,escola05.getPessoa05s()));
                    aluno05.setNotas(validandonotas(scanner));
                }
                if (pessoa05 instanceof Professor05){
                    Professor05 professor05 = (Professor05) pessoa05;
                    professor05.setDisciplina(validandoDisciplina(scanner,escola05));
                    professor05.setSalario(validandoSalario(scanner));
                    System.out.println("___________________________");
                }
            }else {
                System.out.println("Cadastro não encontrado.");
            }
        }
    }

    public List<Pessoa05> getPessoa05s() {
        return pessoa05s;
    }

    public void setPessoa05s(List<Pessoa05> pessoa05s) {
        this.pessoa05s = pessoa05s;
    }
}
