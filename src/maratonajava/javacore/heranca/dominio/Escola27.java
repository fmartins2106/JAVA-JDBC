package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.*;

public class Escola27 {
    private List<Pessoa27> pessoa27s;

    public Escola27(){
        this.pessoa27s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa27.validacaoNome(nome);
                return Pessoa27.formatoNome(nome);
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
                Pessoa27.validacaoCpf(cpf);
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
                Pessoa27.validacaoIdade(idade);
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
                Aluno27.validacaoMatricula(matricula);
                return matricula;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de matrícula válido.");
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
                    notas[i] = Integer.parseInt(scanner.nextLine());
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
                Professor27.validancaoDisciplina(disciplina);
                return Pessoa27.formatoNome(disciplina);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoSalarioProfessor(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                Professor27.validacaoSalario(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoa(Pessoa27 pessoa27){
        pessoa27s.add(pessoa27);
    }

    public void listarPessoas(){
        if (pessoa27s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma pessoa foi cadastrada.");
        }else {
            pessoa27s.forEach(System.out::println);
        }
    }

    public Optional<Pessoa27> pesquisaPorNome(Scanner scanner){
        String nome = validandoNome(scanner);
        if (pessoa27s == null || pessoa27s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma pessoa foi cadastrada.");
            return Optional.empty();
        }
        Optional<Pessoa27> nomeEncontrado = pessoa27s.stream().filter(pessoa27 -> pessoa27.getNome().equalsIgnoreCase(nome)).findFirst();
        if (nomeEncontrado.isPresent()){
            return nomeEncontrado;
        }
        System.out.println("Nome não encontrado.");
        return Optional.empty();
    }

    public void exibirDadosPesquisaPorNome(Scanner scanner){
        Optional<Pessoa27> pessoa27Optional = pesquisaPorNome(scanner);
        if (pessoa27Optional.isPresent()){
            Pessoa27 pessoa27 = pessoa27Optional.get();
            System.out.println("__________________________________");
            System.out.println("Nome:"+pessoa27.getNome());
            System.out.println("CPF:"+pessoa27.getCpf());
            System.out.println("Idade:"+pessoa27.getIdade());
            if (pessoa27 instanceof Aluno27){
                Aluno27 aluno27 = (Aluno27) pessoa27;
                System.out.println("Matrícula:"+aluno27.getNumeroMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno27.getNotas()));
                System.out.println("Média:"+aluno27.getMedia());
                System.out.println("Situação:"+aluno27.getSituacaoAluno27().getDescricao());
            }
            if (pessoa27 instanceof Professor27){
                Professor27 professor27 = (Professor27) pessoa27;
                System.out.println("Disciplina:"+professor27.getDisciplina());
                System.out.println("Salário:R$"+professor27.getSalario());
            }
        }
    }

    public void excluirDados(Scanner scanner){
        Optional<Pessoa27> pessoa27Optional = pesquisaPorNome(scanner);
        if (pessoa27Optional.isPresent()){
            Pessoa27 pessoa27 = pessoa27Optional.get();
            pessoa27s.remove(pessoa27);
            if (pessoa27 instanceof Aluno27){
                Aluno27 aluno27 = (Aluno27) pessoa27;
                Aluno27.matriculasCadastradas.remove(aluno27.getNumeroMatricula());
            }
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosPessoa(Scanner scanner){
        Optional<Pessoa27> pessoa27Optional = pesquisaPorNome(scanner);
        if (pessoa27Optional.isPresent()){
            Pessoa27 pessoa27 = pessoa27Optional.get();
            pessoa27.setNome(validandoNome(scanner));
            pessoa27.setCpf(validandoCpf(scanner));
            pessoa27.setIdade(validandoIdade(scanner));
            if (pessoa27 instanceof Aluno27){
                Aluno27 aluno27 = (Aluno27) pessoa27;
                aluno27.setNotas(validandoNotas(scanner));
            }
            if (pessoa27 instanceof Professor27){
                Professor27 professor27 = (Professor27) pessoa27;
                professor27.setDisciplina(validandoDisciplina(scanner));
                professor27.setSalario(validandoSalarioProfessor(scanner));
            }
        }
    }
}
