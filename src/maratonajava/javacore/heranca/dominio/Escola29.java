package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.*;

public class Escola29 {
    private List<Pessoa29> pessoa29s;

    public Escola29(){
        this.pessoa29s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa29.validacaoNome(nome);
                return Pessoa29.formatoNome(nome);
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
                Pessoa29.validandoCpf(cpf);
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
                Pessoa29.validandoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite uma idade válida.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoMatricala(Scanner scanner){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                Aluno29.validacaoMatricula(matricula);
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
                    System.out.print("Digite a"+(i+1)+"ª nota:");
                    notas[i] = Integer.parseInt(scanner.nextLine());
                    Aluno29.validancaoNotas(notas);
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
                Professor29.validaacaoDisciplina(disciplina);
                return Pessoa29.formatoNome(disciplina);
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
                Professor29.validacaoSalario(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoas(Pessoa29 pessoa29){
        pessoa29s.add(pessoa29);
    }

    public void listarPessoasCadastradas(){
        if (pessoa29s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma pessoa foi cadastrada.");
        }else {
            pessoa29s.forEach(System.out::println);
        }
    }

    public Optional<Pessoa29> pesquisaPorNome(Scanner scanner){
        String nome = validandoNome(scanner);
        if (pessoa29s.isEmpty()){
            System.out.println("Lista vazia. Nenhuma pessoa foi cadastrada.");
            return Optional.empty();
        }
        Optional<Pessoa29> nomeEncontrado = pessoa29s.stream().filter(pessoa29 -> pessoa29.getNome().equalsIgnoreCase(nome)).findFirst();
        if (nomeEncontrado.isPresent()){
            return nomeEncontrado;
        }
        System.out.println("Nome não encontrado.");
        return Optional.empty();
    }

    public void exibirPesquisaPorNome(Scanner scanner){
        Optional<Pessoa29> pessoa29Optional = pesquisaPorNome(scanner);
        if (pessoa29Optional.isPresent()){
            Pessoa29 pessoa29 = pessoa29Optional.get();
            System.out.println("Nome:"+pessoa29.getNome());
            System.out.println("CPF:"+pessoa29.getCpf());
            System.out.println("Idade:"+pessoa29.getIdade());
            if (pessoa29 instanceof Aluno29){
                Aluno29 aluno29 = (Aluno29) pessoa29;
                System.out.println("Matricula:"+aluno29.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno29.getNotas()));
                System.out.println("Média:"+aluno29.getMedia());
                System.out.println("Situação:"+aluno29.getSituacaoAluno29().getDescricao());
            }
            if (pessoa29 instanceof Professor29){
                Professor29 professor29 = (Professor29) pessoa29;
                System.out.println("Disciplina:"+professor29.getDisciplina());
                System.out.println("Salário:R$"+professor29.getSalario());
            }
        }
    }

    public void excluirDados(Scanner scanner){
        Optional<Pessoa29> pessoa29Optional = pesquisaPorNome(scanner);
        if (pessoa29Optional.isPresent()){
            Pessoa29 pessoa29 = pessoa29Optional.get();
            pessoa29s.remove(pessoa29);
            if (pessoa29 instanceof Aluno29){
                Aluno29.matriculasCadastradas.remove(((Aluno29) pessoa29).getMatricula());
            }
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosPessoa(Scanner scanner){
        Optional<Pessoa29> pessoa29Optional = pesquisaPorNome(scanner);
        if (pessoa29Optional.isPresent()){
            Pessoa29 pessoa29 = pessoa29Optional.get();
            pessoa29.setNome(validandoNome(scanner));
            pessoa29.setCpf(validandoCpf(scanner));
            pessoa29.setIdade(validandoIdade(scanner));
            if (pessoa29 instanceof Aluno29){
                ((Aluno29) pessoa29).setNotas(validandoNotas(scanner));
            }
            if (pessoa29 instanceof  Professor29){
                ((Professor29) pessoa29).setDisciplina(validandoDisciplina(scanner));
                ((Professor29) pessoa29).setSalario(validandoSalario(scanner));
            }
        }
    }
}
