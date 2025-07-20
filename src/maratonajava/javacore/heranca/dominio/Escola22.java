package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Professor;

import java.util.*;

public class Escola22 {
    private List<Pessoa22> pessoa22s;

    public Escola22(){
        this.pessoa22s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa22.validacaoNome(nome);
                return Pessoa22.formatoNome(nome);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine();
                Pessoa22.validacaoCpf(cpf);
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
                Pessoa22.validacaoIdade(idade);
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
                Aluno22.validacaoMatricula(matricula);
                return matricula;
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
                    Aluno22.validacaoNotas(notas);
                    break;
                }catch (NumberFormatException e){
                    System.out.print("Digite uma nota válida.");
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
                Professor22.validacaoDisciplina(disciplina);
                return Pessoa22.formatoNome(disciplina);
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
                Professor22.validacaoSalarioProfessor(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido para salário.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoas(Pessoa22 pessoa22){
        pessoa22s.add(pessoa22);
    }

    public void listaPessoas(){
        if (pessoa22s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa22s.forEach(System.out::println);
        }
    }

    private Optional<Pessoa22> pesquisaNome(Scanner scanner){
        if (pessoa22s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa22 pessoa22 = pessoa22s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            return Optional.ofNullable(pessoa22);
        }
    }

    public void exibirDadosPesquisaNome(Scanner scanner){
        Optional<Pessoa22> pessoa22Optional = pesquisaNome(scanner);
        if (pessoa22Optional.isPresent()){
            Pessoa22 pessoa22 = pessoa22Optional.get();
            System.out.println("Nome:"+pessoa22.getNome());
            System.out.println("CPF:"+pessoa22.getCpf());
            System.out.println("Idade:"+pessoa22.getIdade());
            if (pessoa22 instanceof Aluno22){
                Aluno22 aluno22 = (Aluno22) pessoa22;
                System.out.println("Matrícula:"+aluno22.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno22.getNotas()));
                System.out.println("Média:"+aluno22.getMedia());
                System.out.println("Situação:"+aluno22.getSituacaoAluno22().getDescricao());
            }
            if (pessoa22 instanceof Professor22){
                Professor22 professor22 = (Professor22) pessoa22;
                System.out.println("Disciplina:"+professor22.getDisciplina());
                System.out.println("Salário:R$"+professor22.getSalario());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void excluirDadosPessoa(Scanner scanner){
        Optional<Pessoa22> pessoa22Optional = pesquisaNome(scanner);
        if (pessoa22Optional.isPresent()){
            Pessoa22 pessoa22 = pessoa22Optional.get();
            pessoa22s.remove(pessoa22);
            System.out.println("Dados removidos com sucesso.");
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void alterarDadosPessoa(Scanner scanner){
        Optional<Pessoa22> pessoa22Optional = pesquisaNome(scanner);
        if (pessoa22Optional.isPresent()){
            Pessoa22 pessoa22 = pessoa22Optional.get();
            pessoa22.setNome(validandoNome(scanner));
            pessoa22.setCpf(validandoCpf(scanner));
            pessoa22.setIdade(validandoIdade(scanner));
            if (pessoa22 instanceof Aluno22){
                Aluno22 aluno22 = (Aluno22) pessoa22;
                aluno22.setMatricula(validandoMatricula(scanner));
                aluno22.setNotas(validandoNotas(scanner));
            }
            if (pessoa22 instanceof Professor22){
                Professor22 professor22 = (Professor22) pessoa22;
                professor22.setDisciplina(validandoDisciplina(scanner));
                professor22.setSalario(validandoSalario(scanner));
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

}
