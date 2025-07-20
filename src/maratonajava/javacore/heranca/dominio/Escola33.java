package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.*;

public class Escola33 {
    private List<Pessoa33> pessoa33s;

    public Escola33(){
        this.pessoa33s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa33.validacaoNome(nome);
                return Pessoa33.formatoNome(nome);
            }catch (PessoaNomeInvalido33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Pessoa33.validacaoCpf(cpf);
                return cpf;
            }catch (CpfPessoaInvalido33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine().trim());
                Pessoa33.validacaoIdade(idade);
                return idade;
            }catch (IdadePessoaInvalida33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner){
        double[] notas = new double[4];
        while (true){
            try {
                for (int i = 0; i < notas.length; i++) {
                    System.out.print("Digite a "+(i+1)+"º nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine().trim());
                    Aluno33.validacaoNotas(notas);
                }
                return notas;
            }catch (NumberFormatException e){
                System.out.println("Digite uma nota válida.");
            }
        }
    }

    public static int validandoMatricula(Scanner scanner){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine().trim());
                Aluno33.validacaoMatricula(matricula);
                Aluno33.validacaoMatriculaDuoplicada(matricula);
                return matricula;
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }catch (AlunoMatriculaDuplicada33 | AlunoMatriculaInvalida33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoDisciplina(Scanner scanner){
        while (true){
            try {
                System.out.print("Disciplina:");
                String disciplina = scanner.nextLine().trim();
                Professor33.validacaoDisciplina(disciplina);
                return Professor33.formatoNome(disciplina);
            }catch (ProfessorDisciplinaInvalida33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine().trim());
                Professor33.validacaoSalario(salario);
                return salario;
            }catch (ProfessorSalarioInvalido33 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoas(Pessoa33 pessoa33){
        pessoa33s.add(pessoa33);
    }

    public void listarPessoasCadastradas(){
        if (pessoa33s.isEmpty()){
            System.out.println("Nenhuma pessoa foi cadastrada.");
            return;
        }
        pessoa33s.forEach(System.out::println);
    }

    public void listarAlunos(){
        System.out.println("Alunos cadastrados:");
        for (Pessoa33 pessoa33 : pessoa33s) {
            if (pessoa33 instanceof Aluno33){
                Aluno33 aluno33 = (Aluno33) pessoa33;
                System.out.println("___________________________________________________________________");
                System.out.println("Nome:"+aluno33.getNome());
                System.out.println("CPF:"+aluno33.getCpf());
                System.out.println("Idade:"+aluno33.getIdade());
                System.out.println("Matrícula:"+aluno33.getMatricula());
                System.out.println("Média:"+aluno33.getMedia());
                System.out.println("Situação:"+aluno33.getSituacaoAluno33().getDescricao());
                System.out.println("___________________________________________________________________");
            }else {
                System.out.println("Nenhum aluno cadastro.");
            }
        }
    }

    public void listarProfessores(){
        System.out.println("Professores cadastrados:");
        for (Pessoa33 pessoa33 : pessoa33s) {
            if (pessoa33 instanceof Professor33){
                Professor33 professor33 = (Professor33) pessoa33;
                System.out.println("___________________________________________________________________");
                System.out.println("Nome:"+professor33.getNome());
                System.out.println("CPF:"+professor33.getCpf());
                System.out.println("Idade:"+professor33.getIdade());
                System.out.println("Disciplina:"+professor33.getDisciplina());
                System.out.println("Salário:R$"+professor33.getSalario());
                System.out.println("___________________________________________________________________");
                return;
            }
            System.out.println("Nenhum professor foi cadastrado.");
        }
    }

    public Optional<Pessoa33> pesquisaPorNome(Scanner scanner){
        try {
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            Pessoa33.validacaoNome(nome);
            if (pessoa33s.isEmpty()){
                System.out.println("Nenhum cadastro foi realizado.");
                return Optional.empty();
            }
            Optional<Pessoa33> nomeEncontrado = pessoa33s.stream().filter(pessoa33 -> pessoa33.getNome().equalsIgnoreCase(nome)).findFirst();
            if (nomeEncontrado.isPresent()){
                return nomeEncontrado;
            }
            System.out.println("Nome não encontrado.");
            return Optional.empty();
        }catch (PessoaNomeInvalido33 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorNome(Scanner scanner){
        Optional<Pessoa33> pessoa33Optional = pesquisaPorNome(scanner);
        if (pessoa33Optional.isPresent()){
            Pessoa33 pessoa33 = pessoa33Optional.get();
            if (pessoa33 instanceof Aluno33){
                Aluno33 aluno33 = (Aluno33) pessoa33;
                System.out.println("Nome:"+aluno33.getNome());
                System.out.println("CPF:"+aluno33.getCpf());
                System.out.println("Idade:"+aluno33.getIdade());
                System.out.println("Matrícula:"+aluno33.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno33.getNotas()));
                System.out.println("Média:"+aluno33.getMedia());
                System.out.println("Situação:"+aluno33.getSituacaoAluno33().getDescricao());
            }
            if (pessoa33 instanceof Professor33){
                Professor33 professor33 = (Professor33) pessoa33;
                System.out.println("Nome:"+professor33.getNome());
                System.out.println("CPF:"+professor33.getCpf());
                System.out.println("Idade:"+professor33.getIdade());
                System.out.println("Disciplina:"+professor33.getDisciplina());
                System.out.println("Salário:R$"+professor33.getSalario());
            }
        }
    }

    public void excluirDados(Scanner scanner){
        Optional<Pessoa33> pessoa33Optional = pesquisaPorNome(scanner);
        if (pessoa33Optional.isPresent()){
            Pessoa33 pessoa33 = pessoa33Optional.get();
            Iterator<Pessoa33> iterator = pessoa33s.iterator();
            while (iterator.hasNext()){
                Pessoa33 pessoa = iterator.next();
                if (pessoa.equals(pessoa33)){
                    iterator.remove();
                    System.out.println("Dados removidos com sucesso.");
                }
            }
        }
    }

    public void alterarDados(Scanner scanner){
        Optional<Pessoa33> pessoa33Optional = pesquisaPorNome(scanner);
        if (pessoa33Optional.isPresent()){
            Pessoa33 pessoa33 = pessoa33Optional.get();
            if (pessoa33 instanceof Aluno33){
                Aluno33 aluno33 = (Aluno33) pessoa33;
                aluno33.setNome(validandoNome(scanner));
                aluno33.setCpf(validandoCpf(scanner));
                aluno33.setIdade(validandoIdade(scanner));
                aluno33.setNotas(validandoNotas(scanner));
            }
            if (pessoa33 instanceof Professor33){
                Professor33 professor33  = (Professor33) pessoa33;
                professor33.setNome(validandoNome(scanner));
                professor33.setCpf(validandoCpf(scanner));
                professor33.setIdade(validandoIdade(scanner));
                professor33.setDisciplina(validandoDisciplina(scanner));
                professor33.setSalario(validandoSalario(scanner));
            }
        }
    }
}
