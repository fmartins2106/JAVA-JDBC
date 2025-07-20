package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.*;

public class Escola26 {
    private List<Pessoa26> pessoa26s;

    public Escola26(){
        this.pessoa26s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa26.validacaoNome(nome);
                return Pessoa26.formatoNome(nome);
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
                Pessoa26.validacaoCpf(cpf);
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
                Pessoa26.validacaoIdade(idade);
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
                Aluno26.validacaoMatricula(matricula);
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
                    Aluno26.validacaoNotas(notas);
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
                System.out.println("Disciplina:");
                String disciplina = scanner.nextLine().trim();
                Professor26.validacaoDisciplina(disciplina);
                return Pessoa26.formatoNome(disciplina);
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.println("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                Professor26.validacaoSalarioProfessor(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor de salário válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoa(Pessoa26 pessoa26){
        pessoa26s.add(pessoa26);
    }

    public void listaPessoasCadastradas(){
        if (pessoa26s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma pessoa foi cadastrada.");
        }else {
            pessoa26s.forEach(System.out::println);
        }
    }

    public Optional<Pessoa26> pesquisaPorNome(Scanner scanner){
        if (pessoa26s.isEmpty()){
            System.out.println("Nenhuma pessoa foi cadastrada até o momento. Lista vazia.");
            return Optional.empty();
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Optional<Pessoa26> pessoaEncontrada = pessoa26s.stream().filter(pessoa26 -> pessoa26.getNome().equalsIgnoreCase(nome)).findFirst();
            if (!pessoaEncontrada.isPresent()){
                System.out.println("Nome não encontrado.");
                return Optional.empty();
            }else {
                return pessoaEncontrada;
            }
        }
    }

    public void exibirDetalhesPesquisa(Scanner scanner){
        Optional<Pessoa26> pessoa26Optional = pesquisaPorNome(scanner);
        if (pessoa26Optional.isPresent()){
            Pessoa26 pessoa26 = pessoa26Optional.get();
            System.out.println("________________________________________");
            System.out.println("Nome:"+pessoa26.getNome());
            System.out.println("CPF:"+pessoa26.getCpf());
            System.out.println("Idade:"+pessoa26.getIdade());
            if (pessoa26 instanceof Aluno26){
                Aluno26 aluno26 = (Aluno26) pessoa26;
                System.out.println("Matrícula:"+aluno26.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno26.getNotas()));
                System.out.println("Média:"+aluno26.getMedia());
                System.out.println("Situação:"+aluno26.getSituacaoAluno26().getDescricao());
            }
            if (pessoa26 instanceof Professor26){
                Professor26 professor26 = (Professor26) pessoa26;
                System.out.println("Disciplina:"+professor26.getDisciplina());
                System.out.println("Salário:R$"+professor26.getSalario());
            }
            System.out.println("________________________________________");
        }
    }

    public void excluirDados(Scanner scanner){
        Optional<Pessoa26> pessoa26Optional = pesquisaPorNome(scanner);
        if (pessoa26Optional.isPresent()){
            Pessoa26 pessoa26 = pessoa26Optional.get();
            pessoa26s.remove(pessoa26);
            if (pessoa26 instanceof Aluno26){
                Aluno26 aluno26 = (Aluno26) pessoa26;
                int matricula = aluno26.getMatricula();
                Aluno26.matriculaCadastrada.remove(matricula);
            }
            System.out.println("Dados removidos com sucesso");
        }
    }

    public void alterarDados(Scanner scanner){
        Optional<Pessoa26> pessoa26Optional = pesquisaPorNome(scanner);
        if (pessoa26Optional.isPresent()){
            Pessoa26 pessoa26 = pessoa26Optional.get();
            pessoa26.setNome(validandoNome(scanner));
            pessoa26.setCpf(validandoCpf(scanner));
            pessoa26.setIdade(validandoIdade(scanner));
            if (pessoa26 instanceof Aluno26){
                Aluno26 aluno26 = (Aluno26) pessoa26;
                aluno26.setNotas(validandoNotas(scanner));
            }
            if (pessoa26 instanceof Professor26){
                Professor26 professor26 = (Professor26) pessoa26;
                professor26.setDisciplina(validandoDisciplina(scanner));
                professor26.setSalario(validandoSalario(scanner));
            }
        }
    }

}
