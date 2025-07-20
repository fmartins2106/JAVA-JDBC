package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.*;

public class Escola19 {
    private List<Pessoa19> pessoa19s;

    public Escola19(){
        this.pessoa19s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine();
                Pessoa19.validacaoNome(nome);
                return Pessoa19.formatoNome(nome);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine();
                Pessoa19.validacaoCpf(cpf);
                return cpf;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                Pessoa19.validacaoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMatricula(Scanner scanner){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                Aluno19.validacaoMatricula(matricula);
                return matricula;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de matricula válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner){
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(i+1)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    Aluno19.validacaoNotas(notas);
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return notas;
    }

    public static String validandoDisciplina(Scanner scanner){
        while (true){
            try {
                System.out.print("Disciplina:");
                String disciplina = scanner.nextLine().trim();
                Professor19.validacaoDisciplina(disciplina);
                return Pessoa19.formatoNome(disciplina);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                Professor19.validacaoSalario(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor de salário válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoas(Pessoa19 pessoa19){
        pessoa19s.add(pessoa19);
    }

    public void listaPessoasCadastradas(){
        if (pessoa19s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa19s.forEach(System.out::println);
        }
    }

    public Optional<Pessoa19> pesquisaPorNome(Scanner scanner){
        if (pessoa19s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa19 pessoa19 = pessoa19s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            return Optional.ofNullable(pessoa19);
        }
    }

    public void exibirDadosPesquisa(Scanner scanner){
        Optional<Pessoa19> pessoa19Optional = pesquisaPorNome(scanner);
        if (pessoa19Optional.isPresent()){
            Pessoa19 pessoa19 = pessoa19Optional.get();
            System.out.println("Nome:"+pessoa19.getNome());
            System.out.println("CPF:"+pessoa19.getCpf());
            System.out.println("Idade:"+pessoa19.getIdade());
            if (pessoa19 instanceof  Aluno19){
                Aluno19 aluno19 = (Aluno19) pessoa19;
                System.out.println("Matrícula:"+aluno19.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno19.getNotas()));
                System.out.println("Média:"+aluno19.getMedia());
                System.out.println("Situação:"+aluno19.getSituacaoAluno19().getDescricao());
            }
            if (pessoa19 instanceof Professor19){
                Professor19 professor19 = (Professor19) pessoa19;
                System.out.println("Disciplina:"+professor19.getDisciplina());
                System.out.println("Salário:R$"+professor19.getSalario());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void excluirDados(Scanner scanner){
        Optional<Pessoa19> pessoa19Optional = pesquisaPorNome(scanner);
        if (pessoa19Optional.isPresent()){
            Pessoa19 pessoa19 = pessoa19Optional.get();
            pessoa19s.remove(pessoa19);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDados(Scanner scanner){
        Optional<Pessoa19> pessoa19Optional = pesquisaPorNome(scanner);
        if (pessoa19Optional.isPresent()){
            Pessoa19 pessoa19 = pessoa19Optional.get();
            pessoa19.setNome(validandoNome(scanner));
            pessoa19.setCpf(validandoCpf(scanner));
            pessoa19.setIdade(validandoIdade(scanner));
            if (pessoa19 instanceof Aluno19){
                Aluno19 aluno19 = (Aluno19) pessoa19;
                aluno19.setNotas(validandoNotas(scanner));
            }
            if (pessoa19 instanceof Professor19){
                Professor19 professor19 = (Professor19) pessoa19;
                professor19.setDisciplina(validandoDisciplina(scanner));
                professor19.setSalario(validandoSalario(scanner));
            }
        }else {
            System.out.println("Dados não encontrado.");
        }
    }

}
