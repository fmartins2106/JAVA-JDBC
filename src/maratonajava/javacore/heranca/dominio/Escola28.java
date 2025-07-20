package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.*;

public class Escola28 {
    private List<Pessoa28> pessoa28s;

    public Escola28(){
        this.pessoa28s =  new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa28.validacaoNome(nome);
                return Pessoa28.formatoNome(nome);
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
                Pessoa28.validacaoCpf(cpf);
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
                Pessoa28.validacaoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite uma idade válida.");
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
                Aluno28.validacaoMatricula(matricula);
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
                    Aluno28.validacaoNotas(notas);
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
                Professor28.validacaoDisciplina(disciplina);
                return Pessoa28.formatoNome(disciplina);
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
                Professor28.validacaoSalario(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoa(Pessoa28 pessoa28){
        pessoa28s.add(pessoa28);
    }

    public void listaPessoasCasdastradas(){
        if (pessoa28s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma pessoa foi cadastrada.");
        }else {
            pessoa28s.forEach(System.out::println);
        }
    }

    public Optional<Pessoa28> pesquisaPorNome(Scanner scanner){
        String nome = validandoNome(scanner);
        if (pessoa28s == null || pessoa28s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma pessoa foi cadastrada.");
            return Optional.empty();
        }
        Optional<Pessoa28> nomeEncontrado = pessoa28s.stream().filter(pessoa28 -> pessoa28.getNome().equalsIgnoreCase(nome)).findFirst();
        if (nomeEncontrado.isPresent()){
            return nomeEncontrado;
        }
        System.out.println("Nome não encontrado.");
        return Optional.empty();
    }

    public void exibirDadosPesquisa(Scanner scanner){
        Optional<Pessoa28> pessoa28Optional = pesquisaPorNome(scanner);
        if (pessoa28Optional.isPresent()){
            Pessoa28 pessoa28 = pessoa28Optional.get();
            System.out.println("Nome:"+pessoa28.getNome());
            System.out.println("CPF:"+pessoa28.getCpf());
            System.out.println("Idade:"+pessoa28.getIdade());
            if (pessoa28 instanceof Aluno28){
                Aluno28 aluno28 = (Aluno28) pessoa28;
                System.out.println("Matricula:"+aluno28.getMatricula());
                System.out.println("Notas:"+Arrays.toString(aluno28.getNotas()));
                System.out.println("Média:"+aluno28.getMedia());
                System.out.println("Situação:"+aluno28.getSituacaoAluno28().getDescricao());
            }
            if (pessoa28 instanceof Professor28){
                Professor28 professor28 = (Professor28) pessoa28;
                System.out.println("Disciplina:"+professor28.getDisciplina());
                System.out.println("Salário:R$"+professor28.getSalario());
            }
        }
    }

    public void excluirDadosPessoa(Scanner scanner){
        Optional<Pessoa28> pessoa28Optional = pesquisaPorNome(scanner);
        if (pessoa28Optional.isPresent()){
            Pessoa28 pessoa28 = pessoa28Optional.get();
            pessoa28s.remove(pessoa28);
            if (pessoa28 instanceof Aluno28){
                Aluno28 aluno28 = (Aluno28) pessoa28;
                Aluno28.matriculasCadastradas.remove(aluno28.getMatricula());
            }
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosPessoa(Scanner scanner){
        Optional<Pessoa28> pessoa28Optional = pesquisaPorNome(scanner);
        if (pessoa28Optional.isPresent()){
            Pessoa28 pessoa28 = pessoa28Optional.get();
            pessoa28.setNome(validandoNome(scanner));
            pessoa28.setCpf(validandoCpf(scanner));
            pessoa28.setIdade(validandoIdade(scanner));
            if (pessoa28 instanceof Aluno28){
                Aluno28 aluno28 = (Aluno28) pessoa28;
                aluno28.setNotas(validandoNotas(scanner));
            }
            if (pessoa28 instanceof Professor28){
                Professor28 professor28 = (Professor28) pessoa28;
                professor28.setDisciplina(validandoDisciplina(scanner));
                professor28.setSalario(validandoSalario(scanner));
            }
        }
    }
}
