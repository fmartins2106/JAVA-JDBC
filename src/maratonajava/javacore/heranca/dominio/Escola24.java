package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.*;

public class Escola24 {
    private List<Pessoa24>pessoa24s;

    public Escola24(){
        this.pessoa24s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa24.validacaoNome(nome);
                return Pessoa24.formatoNome(nome);
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
                Pessoa24.validacaoCpf(cpf);
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
                Pessoa24.validacaoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido para idade.");
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
                Aluno24.validacaoMatricula(matricula);
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
                    Aluno24.validacaoNotas(notas);
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
                Professor24.validacaoDisciplina(disciplina);
                return disciplina;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoSalarioProfessor(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:");
                double salario = Double.parseDouble(scanner.nextLine());
                Professor24.validacaoSalarioProfessor(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um salário válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoa(Pessoa24 pessoa24){
        pessoa24s.add(pessoa24);
    }

    public void listaPessoas(){
        if (pessoa24s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa24s.forEach(System.out::println);
        }
    }

    public Optional<Pessoa24> pesquisaPorNome(Scanner scanner){
        if (pessoa24s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            String nome = validandoNome(scanner);
            Pessoa24 pessoa24 = pessoa24s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            return Optional.ofNullable(pessoa24);
        }
    }

    public void exibirDadosPesquisa(Scanner scanner){
        Optional<Pessoa24> pessoa24Optional = pesquisaPorNome(scanner);
        if (pessoa24Optional.isPresent()){
            Pessoa24 pessoa24 = pessoa24Optional.get();
            System.out.println("Nome:"+pessoa24.getNome());
            System.out.println("CPF:"+pessoa24.getCpf());
            System.out.println("Idade:"+pessoa24.getIdade());
            if (pessoa24 instanceof Aluno24){
                Aluno24 aluno24 = (Aluno24) pessoa24;
                System.out.println("Matrícula:"+aluno24.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno24.getNotas()));
                System.out.println("Média:"+aluno24.getMedia());
                System.out.println("Situação:"+aluno24.getSituacaoAluno24().getDescricao());
            }
            if (pessoa24 instanceof Professor24){
                Professor24 professor24 = (Professor24) pessoa24;
                System.out.println("Disciplina:"+professor24.getDisciplina());
                System.out.println("Salário:R$"+professor24.getSalario());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void excluirDadosPesquisa(Scanner scanner){
        Optional<Pessoa24> pessoa24Optional = pesquisaPorNome(scanner);
        if (pessoa24Optional.isPresent()){
            Pessoa24 pessoa24 = pessoa24Optional.get();
            pessoa24s.remove(pessoa24);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosPesquisa(Scanner scanner){
        Optional<Pessoa24> pessoa24Optional = pesquisaPorNome(scanner);
        if (pessoa24Optional.isPresent()){
            Pessoa24 pessoa24 = pessoa24Optional.get();
            pessoa24.setNome(validandoNome(scanner));
            pessoa24.setCpf(validandoCpf(scanner));
            pessoa24.setIdade(validandoIdade(scanner));
            if (pessoa24 instanceof Aluno24){
                Aluno24 aluno24 = (Aluno24) pessoa24;
                aluno24.setNotas(validandoNotas(scanner));
            }
            if (pessoa24 instanceof Professor24){
                Professor24 professor24 = (Professor24) pessoa24;
                professor24.setDisciplina(validandoDisciplina(scanner));
                professor24.setSalario(validandoSalarioProfessor(scanner));
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

}
