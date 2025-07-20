package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.*;

public class Escola21 {
    private List<Pessoa21> pessoa21s;

    public Escola21(){
        this.pessoa21s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa21.validacaoNome(nome);
                return Pessoa21.formatoNome(nome);
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
                Pessoa21.validacaoCpf(cpf);
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
                Pessoa21.validacaoIdade(idade);
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
                System.out.print("Número matrícula:");
                int numeroMatricula = Integer.parseInt(scanner.nextLine());
                Aluno21.validacaoMatricula(numeroMatricula);
                return numeroMatricula;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
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
                    Aluno21.validacaoNotas(notas);
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um número válido.");
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return notas;
    }

    public static String validandoDisciplin(Scanner scanner){
        while (true){
            try {
                System.out.print("Disciplina:");
                String disciplina = scanner.nextLine();
                Professor21.validacaoDisciplina(disciplina);
                return Pessoa21.formatoNome(disciplina);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validacaoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                Professor21.validacaoSalarioProfessor(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoas(Pessoa21 pessoa21){
        pessoa21s.add(pessoa21);
    }

    public void listaPessoas(){
        if (pessoa21s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa21s.forEach(System.out::println);
        }
    }

    private Optional<Pessoa21> pesquisaPorNome(Scanner scanner){
        if (pessoa21s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa21 pessoa21 = pessoa21s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            return Optional.ofNullable(pessoa21);
        }
    }

    public void exibirDadosPesquisa(Scanner scanner){
        Optional<Pessoa21> pessoa21Optional = pesquisaPorNome(scanner);
        if (pessoa21Optional.isPresent()){
            Pessoa21 pessoa21 = pessoa21Optional.get();
            System.out.println("Nome:"+pessoa21.getNome());
            System.out.println("CPF:"+pessoa21.getCpf());
            System.out.println("Idade:"+pessoa21.getIdade());
            if (pessoa21 instanceof Aluno21){
                Aluno21 aluno21 = (Aluno21) pessoa21;
                System.out.println("Matrícula:"+aluno21.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno21.getNotas()));
                System.out.println("Média:"+aluno21.getMedia());
                System.out.println("Situação:"+aluno21.getSituacaAluno21());
            }
            if (pessoa21 instanceof Professor21){
                Professor21 professor21 = (Professor21) pessoa21;
                System.out.println("Disciplina:"+professor21.getDisciplina());
                System.out.println("Salário:R$"+professor21.getSalario());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void excluirDadosPessoas(Scanner scanner){
        Optional<Pessoa21> pessoa21Optional = pesquisaPorNome(scanner);
        if (pessoa21Optional.isPresent()){
            Pessoa21 pessoa21 = pessoa21Optional.get();
            pessoa21s.remove(pessoa21);
            System.out.println("Dados removidos com sucesso.");
        }else {
            System.out.println("Digite um valor válido.");
        }
    }

    public void alterardadosPessoa(Scanner scanner){
        Optional<Pessoa21> pessoa21Optional = pesquisaPorNome(scanner);
        if (pessoa21Optional.isPresent()){
            Pessoa21 pessoa21 = pessoa21Optional.get();
            pessoa21.setNome(validandoNome(scanner));
            pessoa21.setCpf(validandoCpf(scanner));
            pessoa21.setIdade(validandoIdade(scanner));
            if (pessoa21 instanceof Aluno21){
                Aluno21 aluno21 = (Aluno21) pessoa21;
                aluno21.setNotas(validandoNotas(scanner));
            }
            if (pessoa21 instanceof Professor21){
                Professor21 professor21 = (Professor21) pessoa21;
                professor21.setDisciplina(validandoDisciplin(scanner));
                professor21.setSalario(validacaoSalario(scanner));
            }
        }
    }
}
