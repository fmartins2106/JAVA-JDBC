package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.*;

public class Escola30 {
    private List<Pessoa30> pessoa30s;

    public Escola30(){
        this.pessoa30s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa30.validacaoNome(nome);
                return Pessoa30.formatoString(nome);
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
                Pessoa30.validacaoCpf(cpf);
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
                Pessoa30.validacaoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
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
                Aluno30.validacaoMatricula(matricula);
                Aluno30.validacaoMatriculaDuplicada(matricula);
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
                    System.out.print("Digite a "+(1+i)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    Aluno30.validacaoNotas(notas);
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
                String disciplina = scanner.nextLine();
                Professor30.validacaoDisciplina(disciplina);
                return Pessoa30.formatoString(disciplina);
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
                Professor30.validacaoSalario(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um salário válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoaSistema(Pessoa30 pessoa30){
        pessoa30s.add(pessoa30);
    }

    public void listarPessoasCadastradas(){
        if (pessoa30s.isEmpty()){
            System.out.println("Nenhuma pessoa foi cadastrada.");
            return;
        }
        pessoa30s.forEach(System.out::println);
    }

    public Optional<Pessoa30> pesquisaPorNome(Scanner scanner){
        try {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa30.validacaoNome(nome);
            if (pessoa30s.isEmpty()){
                System.out.println("Nenhuma pessoa foi cadastrada.");
                return Optional.empty();
            }
            Optional<Pessoa30> nomeEncontrado = pessoa30s.stream().filter(pessoa30 -> pessoa30.getNome().equalsIgnoreCase(nome)).findFirst();
            if (nomeEncontrado.isPresent()){
                return nomeEncontrado;
            }
            System.out.println("Nome não encontrado.");
            return Optional.empty();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirPesquisaPorNome(Scanner scanner){
        Optional<Pessoa30> pessoa30Optional = pesquisaPorNome(scanner);
        if (pessoa30Optional.isPresent()){
            Pessoa30 pessoa30 = pessoa30Optional.get();
            System.out.println("Nome:"+pessoa30.getNome());
            System.out.println("CPF:"+pessoa30.getCpf());
            System.out.println("Idade:"+pessoa30.getIdade());
            if (pessoa30 instanceof Aluno30){
                Aluno30 aluno30 = (Aluno30) pessoa30;
                System.out.println("Matrícula:"+aluno30.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno30.getNotas()));
                System.out.println("Média:"+aluno30.getMedia());
                System.out.println("Situação aluno:"+aluno30.getSituacaoAluno30().getDescricao());
            }
            if (pessoa30 instanceof Professor30){
                Professor30 professor30 = (Professor30) pessoa30;
                System.out.println("Disciplina:"+professor30.getDisciplina());
                System.out.println("Salário:R$"+professor30.getSalario());
            }
        }
    }

    public void excluirDadosPessoa(Scanner scanner){
        Optional<Pessoa30> pessoa30Optional = pesquisaPorNome(scanner);
        if (pessoa30Optional.isPresent()){
            Pessoa30 pessoa30 = pessoa30Optional.get();
            pessoa30s.remove(pessoa30);
            if (pessoa30 instanceof Aluno30){
                Aluno30.matriculasCadastradas.remove(((Aluno30) pessoa30).getMatricula());
            }
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosPessoa(Scanner scanner){
        Optional<Pessoa30> pessoa30Optional = pesquisaPorNome(scanner);
        if (pessoa30Optional.isPresent()){
            Pessoa30 pessoa30 = pessoa30Optional.get();
            pessoa30.setNome(validandoNome(scanner));
            pessoa30.setCpf(validandoCpf(scanner));
            pessoa30.setIdade(validandoIdade(scanner));
            if (pessoa30 instanceof Aluno30){
                Aluno30 aluno30 = (Aluno30) pessoa30;
                aluno30.setMatricula(validandoMatricula(scanner));
                aluno30.setNotas(validandoNotas(scanner));
            }
            if (pessoa30 instanceof Professor30){
                Professor30 professor30 = (Professor30) pessoa30;
                professor30.setDisciplina(validandoDisciplina(scanner));
                professor30.setSalario(validandoSalarioProfessor(scanner));
            }
        }
    }
}
