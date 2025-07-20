package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.text.NumberFormat;
import java.util.*;

public class Escola25 {
    private List<Pessoa25> pessoa25s;

    public Escola25(){
        this.pessoa25s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa25.validacaoNome(nome);
                return Pessoa25.formatoString(nome);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Pessoa25.validacaoCpf(cpf);
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
                Pessoa25.validacaoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para idade.");
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
                Aluno25.validacaoMatricula(matricula);
                return matricula;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
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
                    Aluno25.validacaoNotas(notas);
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite uma nota válida.");
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
                Professor24.validacaoDisciplina(disciplina);
                return Pessoa25.formatoString(disciplina);
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
                Professor25.validacaoSalarioProfessor(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoas(Pessoa25 pessoa25){
        pessoa25s.add(pessoa25);
    }

    public void listarPessoasCadastradas(){
        if (pessoa25s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma pessoa cadastrada.");
        }else {
            pessoa25s.forEach(System.out::println);
        }
    }

    public Optional<Pessoa25> pesquisaPorNome(Scanner scanner){
        if (pessoa25s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma pessoa cadastrada.");
            return Optional.empty();
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            return pessoa25s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst();
        }
    }

    public void exibirDadosPesquisaNome(Scanner scanner){
        Optional<Pessoa25> pessoa25Optional = pesquisaPorNome(scanner);
        if (pessoa25Optional.isPresent()){
            Pessoa25 pessoa25 = pessoa25Optional.get();
            System.out.println("Nome:"+pessoa25.getNome());
            System.out.println("CPF:"+pessoa25.getCpf());
            System.out.println("Idade:"+pessoa25.getIdade());
            if (pessoa25 instanceof Aluno25){
                Aluno25 aluno25 = (Aluno25) pessoa25;
                System.out.println("Matrícula:"+aluno25.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno25.getNotas()));
                System.out.println("Média:"+aluno25.getMedia());
                System.out.println("Situação:"+aluno25.getSituacaoAluno25().getDescricao());
            }
            if (pessoa25 instanceof Professor25){
                Professor25 professor25 = (Professor25) pessoa25;
                System.out.println("Disciplina:"+professor25.getDisciplina());
                System.out.println("Salário:R$"+professor25.getDisciplina());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void excluirDados(Scanner scanner){
        Optional<Pessoa25> pessoa25Optional = pesquisaPorNome(scanner);
        if (pessoa25Optional.isPresent()){
            Pessoa25 pessoa25 = pessoa25Optional.get();
            pessoa25s.remove(pessoa25);
            System.out.println("Dados removidos com sucesso.");
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void alterarDados(Scanner scanner){
        Optional<Pessoa25> pessoa25Optional = pesquisaPorNome(scanner);
        if (pessoa25Optional.isPresent()){
            Pessoa25 pessoa25 = pessoa25Optional.get();
            pessoa25.setNome(validandoNome(scanner));
            pessoa25.setCpf(validandoCpf(scanner));
            pessoa25.setIdade(validandoIdade(scanner));
            if (pessoa25 instanceof Aluno25){
                Aluno25 aluno25 = (Aluno25) pessoa25;
                aluno25.setNotas(validandoNotas(scanner));
            }
            if (pessoa25 instanceof Professor25){
                Professor25 professor25 = (Professor25) pessoa25;
                professor25.setDisciplina(validandoDisciplina(scanner));
                professor25.setSalario(validandoSalario(scanner));
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

}
