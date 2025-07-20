package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.*;

public class Escola32 {
    private List<Pessoa32> pessoa32s;

    public Escola32(){
        this.pessoa32s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa32.validacaoNome(nome);
                return Pessoa32.formatoNome(nome);
            }catch (PessoaNomeInvalido32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Pessoa32.validacaoCpf(cpf);
                return cpf;
            }catch (PessoaCpfInvalido32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine().trim());
                Pessoa32.validacaoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válida.");
            }catch (PessoaIdadeInvalida32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMatricula(Scanner scanner){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine().trim());
                Aluno32.validacaoMatricula(matricula);
                Aluno32.validacaoMatriculaDuplicada(matricula);
                return matricula;
            }catch (NumberFormatException e){
                System.out.println("Digite uma matrícula válida.");
            }catch (AlunoMatriculaInvalida32 | AlunoMatriculaDuplicada32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner){
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(1+i)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine().trim());
                    Aluno32.validacaoNotas(notas);
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite uma nota válida.");
                }catch (AlunoNotasInvalidas32 e){
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
                Professor32.validacaoDisciplina(disciplina);
                return Pessoa32.formatoNome(disciplina);
            }catch (ProfessorDisciplinaInvalida32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine().trim());
                Professor32.validacaoSalario(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um salário válido.");
            }catch (ProfessorSalarioInvalido32 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoa(Pessoa32 pessoa32){
        pessoa32s.add(pessoa32);
    }

    public void listarPessoas(){
        if (pessoa32s.isEmpty()){
            System.out.println("Nenhuma pessoa foi cadastrada.");
            return;
        }
        pessoa32s.forEach(System.out::println);
    }

    public Optional<Pessoa32> pesquisaPorNome(Scanner scanner){
        try {
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            Pessoa32.validacaoNome(nome);
            if (pessoa32s.isEmpty()){
                System.out.println("Nenhuma pessoa foi cadastrada.");
                return Optional.empty();
            }
            Optional<Pessoa32> nomeEncontrado = pessoa32s.stream().filter(pessoa32 -> pessoa32.getNome().equalsIgnoreCase(nome)).findFirst();
            if (nomeEncontrado.isPresent()){
                return nomeEncontrado;
            }
            System.out.println("Nenhum nome foi encontrado.");
            return Optional.empty();
        }catch (PessoaNomeInvalido32 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorNome(Scanner scanner){
        Optional<Pessoa32> pessoa32Optional = pesquisaPorNome(scanner);
        if (pessoa32Optional.isPresent()){
            Pessoa32 pessoa32 = pessoa32Optional.get();
            System.out.println("Nome:"+pessoa32.getNome());
            System.out.println("CPF:"+pessoa32.getCpf());
            System.out.println("Idade:"+pessoa32.getIdade());
            if (pessoa32 instanceof Aluno32){
                Aluno32 aluno32 = (Aluno32) pessoa32;
                System.out.println("Matrícula:"+aluno32.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno32.getNotas()));
                System.out.println("Média:"+aluno32.getMedia());
                System.out.println("Situação:"+aluno32.getSituacaoAluno32().getDescricao());
            }
            if (pessoa32 instanceof Professor32){
                Professor32 professor32 = (Professor32) pessoa32;
                System.out.println("Disciplina:"+professor32.getDisciplina());
                System.out.println("Salário:R$"+professor32.getSalario());
            }
        }
    }

    public void excluirDadosPessoa(Scanner scanners){
        Optional<Pessoa32> pessoa32Optional = pesquisaPorNome(scanners);
        if (pessoa32Optional.isPresent()){
            Pessoa32 pessoa32 = pessoa32Optional.get();
            pessoa32s.remove(pessoa32);
            if (pessoa32 instanceof Aluno32){
                Aluno32.matriculasCadastradas.remove(((Aluno32) pessoa32).getMatricula());
            }
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosPessoa(Scanner scanner){
        Optional<Pessoa32> pessoa32Optional = pesquisaPorNome(scanner);
        if (pessoa32Optional.isPresent()){
            Pessoa32 pessoa32 = pessoa32Optional.get();
            pessoa32.setNome(validandoNome(scanner));
            pessoa32.setCpf(validandoCpf(scanner));
            pessoa32.setIdade(validandoIdade(scanner));
            if (pessoa32 instanceof Aluno32){
                Aluno32 aluno32 = (Aluno32) pessoa32;
                aluno32.setNotas(validandoNotas(scanner));
            }
            if (pessoa32 instanceof Professor32){
                Professor32 professor32 = (Professor32) pessoa32;
                professor32.setDisciplina(validandoDisciplina(scanner));
                professor32.setSalario(validandoSalario(scanner));
            }
        }
    }

}
