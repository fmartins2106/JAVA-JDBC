package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.*;

public class Escola18 {
    private List<Pessoa18> pessoa18s;

    public Escola18(){
        this.pessoa18s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa18.MensagensValidacaoPessoas18.ERRO_NOME.getDescricao());
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

        int soma = 0;
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
        if (idade < Pessoa18.IDADE_MINIMA){
            System.out.println(Pessoa18.MensagensValidacaoPessoas18.ERRO_IDADE.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoMatricula(int matricula){
        if (matricula < Aluno18.MENOR_MATRICULA){
            System.out.println(Pessoa18.MensagensValidacaoPessoas18.ERRO_MATRICULA);
            return false;
        }
        return true;
    }

    private boolean validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < Aluno18.MENOR_NOTA || nota > Aluno18.MAIOR_NOTA){
                System.out.println(Pessoa18.MensagensValidacaoPessoas18.ERRO_NOTAS.getDescricao());
                return false;
            }
        }
        return true;
    }

    private boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Pessoa18.MensagensValidacaoPessoas18.ERRO_DISCIPLINA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoSalarioProfessor(double salario){
        if (salario < Professor18.SALARIO_MINIMO_PROF){
            System.out.println(Pessoa18.MensagensValidacaoPessoas18.ERRO_SALARIO_PROFESSOR.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola18 escola18){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola18.validacaoNome(nome)){
                return Pessoa18.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner,Escola18 escola18){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (escola18.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Escola18 escola18){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (escola18.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static int validandoMatricula(Scanner scanner, Escola18 escola18){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (escola18.getPessoa18s().stream().anyMatch(p -> p instanceof Aluno18 && ((Aluno18)p).getMatricula() == matricula)){
                    System.out.println("Matricula já cadastrada, tente outro número.");
                    continue;
                }
                if (escola18.validacaoMatricula(matricula)){
                    return matricula;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número de matrícula válido.");
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner, Escola18 escola18){
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(i+1)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (escola18.validacaoNotas(notas)){
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Digite uma nota válida.");
                }
            }
        }
        return notas;
    }


    public static String validandoDisciplina(Scanner scanner, Escola18 escola18){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola18.validacaoDisciplina(disciplina)){
                return Pessoa18.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalarioProfessor(Scanner scanner, Escola18 escola18){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (escola18.validacaoSalarioProfessor(salario)){
                    return salario;
                }
            }catch (NumberFormatException w){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void addPessoas(Pessoa18 pessoa18){
        pessoa18s.add(pessoa18);
    }

    public void listaPessoas(){
        if (pessoa18s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa18s.forEach(System.out::println);
        }
    }

    private Optional<Pessoa18> pesquisaPorNome(Scanner scanner, Escola18 escola18){
        if (pessoa18s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa18 pessoa18 = pessoa18s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            return Optional.ofNullable(pessoa18);
        }
    }

    public void  exibirDadosPesquisa(Scanner scanner, Escola18 escola18){
        Optional<Pessoa18> pessoa18Optional =pesquisaPorNome(scanner,escola18);
        if (pessoa18Optional.isPresent()){
            Pessoa18 pessoa18 = pessoa18Optional.get();
            System.out.println("Nome:"+pessoa18.getNome());
            System.out.println("CPF:"+pessoa18.getCpf());
            System.out.println("Idade:"+pessoa18.getIdade());
            if (pessoa18 instanceof Aluno18){
                Aluno18 aluno18 = (Aluno18) pessoa18;
                System.out.println("Matrícula:"+aluno18.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno18.getNotas()));
                System.out.println("Média:"+aluno18.getMedia());
                System.out.println("Situação:"+aluno18.getSituacaoAluno18().getDescricao());
            }
            if (pessoa18 instanceof Professor18){
                Professor18 professor18 = (Professor18) pessoa18;
                System.out.println("Disciplina:"+professor18.getDisciplina());
                System.out.println("Salário:"+professor18.getSalario());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void excluirDadosPessoa(Scanner scanner, Escola18 escola18){
        Optional<Pessoa18> pessoa18Optional = pesquisaPorNome(scanner,escola18);
        if (pessoa18Optional.isPresent()){
            Pessoa18 pessoa18 = pessoa18Optional.get();
            pessoa18s.remove(pessoa18);
            System.out.println("Dados removidos com sucesso.");
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void alterarDadosPessoa(Scanner scanner, Escola18 escola18){
        Optional<Pessoa18> pessoa18Optional = pesquisaPorNome(scanner, escola18);
        if (pessoa18Optional.isPresent()){
            Pessoa18 pessoa18 = pessoa18Optional.get();
            pessoa18.setNome(validandoNome(scanner, escola18));
            pessoa18.setCpf(validandoCpf(scanner,escola18));
            pessoa18.setIdade(validandoIdade(scanner,escola18));
            if (pessoa18 instanceof Aluno18){
                Aluno18 aluno18 = (Aluno18) pessoa18;
                aluno18.setNotas(validandoNotas(scanner,escola18));
            }
            if (pessoa18 instanceof Professor18){
                Professor18 professor18 = (Professor18) pessoa18;
                professor18.setDisciplina(validandoDisciplina(scanner, escola18));
                professor18.setSalario(validandoSalarioProfessor(scanner, escola18));
            }
        }
    }

    public List<Pessoa18> getPessoa18s() {
        return pessoa18s;
    }
}
