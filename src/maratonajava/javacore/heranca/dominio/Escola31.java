package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.Abstracao.dominio.Conta35;

import java.util.*;

public class Escola31 {
    private List<Pessoa31> pessoa31s;

    public Escola31(){
        this.pessoa31s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa31.validacaoNome(nome);
                return Pessoa31.formatoNome(nome);
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
                Pessoa31.validacaoCpf(cpf);
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
                int idade = Integer.parseInt(scanner.nextLine().trim());
                Pessoa31.validandoIdade(idade);
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
                System.out.print("Matricula:");
                int matricula = Integer.parseInt(scanner.nextLine().trim());
                Aluno31.validacaoMatricula(matricula);
                Aluno31.validacaoMatriculaDuplicada(matricula);
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
                    notas[i] = Double.parseDouble(scanner.nextLine().trim());
                    Aluno31.validacaoNotas(notas);
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
                Professor31.validacaoDisciplina(disciplina);
                return Pessoa31.formatoNome(disciplina);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine().trim());
                Professor31.validacaoSalario(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um salário válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoa(Pessoa31 pessoa31){
        pessoa31s.add(pessoa31);
    }

    public void listarPessoasCadastradas(){
        if (pessoa31s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma pessoa foi cadastrada");
            return;
        }
        pessoa31s.forEach(System.out::println);
    }

    public Optional<Pessoa31> pesquisaPorNome(Scanner scanner){
        String nome = validandoNome(scanner);
        if (pessoa31s.isEmpty()){
            System.out.println("Nenhuma pessoa foi cadastrada.");
            return Optional.empty();
        }
        Optional<Pessoa31> nomeEncontrado = pessoa31s.stream().filter(pessoa31 ->  pessoa31.getNome().equalsIgnoreCase(nome)).findFirst();
        if (nomeEncontrado.isPresent()){
            return nomeEncontrado;
        }
        System.out.println("Nome não encontrado. Tente novamente.");
        return Optional.empty();
    }

    public void exibirDadosPesquisaNome(Scanner scanner){
        Optional<Pessoa31> pessoa31Optional = pesquisaPorNome(scanner);
        if (pessoa31Optional.isPresent()){
            Pessoa31 pessoa31 = pessoa31Optional.get();
            System.out.println("Nome:"+pessoa31.getNome());
            System.out.println("CPF:"+pessoa31.getCpf());
            System.out.println("Idade:"+pessoa31.getIdade());
            if (pessoa31 instanceof Aluno31){
                Aluno31 aluno31 = (Aluno31) pessoa31;
                System.out.println("Matrícula:"+aluno31.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno31.getNotas()));
                System.out.println("Média:"+aluno31.getMedia());
                System.out.println("Situação:"+aluno31.getSituacaoAluno31().getDescricao());
            }
            if (pessoa31 instanceof Professor31){
                Professor31 professor31 = (Professor31) pessoa31;
                System.out.println("Disciplina:"+professor31.getDisciplina());
                System.out.println("Salário:R$"+professor31.getSalario());
            }
        }
    }

    public void excluirDados(Scanner scanner){
        Optional<Pessoa31> pessoa31Optional = pesquisaPorNome(scanner);
        if (pessoa31Optional.isPresent()){
            Pessoa31 pessoa31 = pessoa31Optional.get();
            pessoa31s.remove(pessoa31);
            if (pessoa31 instanceof Aluno31){
                Aluno31.matriculasCadastradas.remove(((Aluno31) pessoa31).getMatricula());
            }
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosPessoa(Scanner scanner){
        Optional<Pessoa31> pessoa31Optional = pesquisaPorNome(scanner);
        if (pessoa31Optional.isPresent()){
            Pessoa31 pessoa31 = pessoa31Optional.get();
            pessoa31.setNome(validandoNome(scanner));
            pessoa31.setCpf(validandoCpf(scanner));
            pessoa31.setIdade(validandoIdade(scanner));
            if (pessoa31 instanceof Aluno31){
                Aluno31 aluno31 = (Aluno31) pessoa31;
                aluno31.setNotas(validandoNotas(scanner));
            }
            if (pessoa31 instanceof Professor31){
                Professor31 professor31 = (Professor31) pessoa31;
                professor31.setDisciplina(validandoDisciplina(scanner));
                professor31.setSalario(validandoSalario(scanner));
            }
        }
    }

}
