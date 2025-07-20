package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.*;

public class Escola20{
    private List<Pessoa20>pessoa20s;

    public Escola20(){
        this.pessoa20s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa20.validacaoNome(nome);
                return Pessoa20.formatoNome(nome);
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
                Pessoa20.validacaoCpf(cpf);
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
                Pessoa20.validaacaoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor valido.");
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
                Aluno20.validacaoMatricula(matricula);
                return matricula;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de matrícula valido.");
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
                    Aluno20.validacaoNotas(notas);
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
        while (true) {
            try {
                System.out.print("Disciplina:");
                String disciplina = scanner.nextLine();
                Professor20.validacaoDisciplina(disciplina);
                return Pessoa20.formatoNome(disciplina);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoSalarioProfessor(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                Professor20.validacaoSalarioProf(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor de salário válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoas(Pessoa20 pessoa20){
        pessoa20s.add(pessoa20);
    }

    public void listaPessoas(){
        if (pessoa20s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa20s.forEach(System.out::println);
        }
    }

    private Optional<Pessoa20> pesquisaPorNome(Scanner scanner){
        if (pessoa20s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            String nome = validandoNome(scanner);
            Pessoa20 pessoa20 = pessoa20s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            return Optional.ofNullable(pessoa20);
        }
    }

    public void exibirDadosPesquisa(Scanner scanner){
        Optional<Pessoa20> pessoa20Optional = pesquisaPorNome(scanner);
        if (pessoa20Optional.isPresent()){
            Pessoa20 pessoa20 =pessoa20Optional.get();
            System.out.println("Nome:"+pessoa20.getNome());
            System.out.println("CPF:"+pessoa20.getCpf());
            System.out.println("Idade:"+pessoa20.getIdade());
            if (pessoa20 instanceof Aluno20){
                Aluno20 aluno20 = (Aluno20) pessoa20;
                System.out.println("Matrícula:"+aluno20.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno20.getNotas()));
                System.out.println("Média:"+aluno20.getMedia());
                System.out.println("Situação:"+aluno20.getSituacaoAluno20().getDescricao());
            }
            if (pessoa20 instanceof Professor20){
                Professor20 professor20 = (Professor20) pessoa20;
                System.out.println("Disciplina:"+professor20.getDisciplina());
                System.out.println("Salário:"+professor20.getSalario());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void excluindoDadosPessoa(Scanner scanner){
        Optional<Pessoa20> pessoa20Optional = pesquisaPorNome(scanner);
        if (pessoa20Optional.isPresent()){
            Pessoa20 pessoa20 = pessoa20Optional.get();
            pessoa20s.remove(pessoa20);
            System.out.println("Dados removidos com sucesso.");
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void alterandoDadosPessoa(Scanner scanner){
        Optional<Pessoa20> pessoa20Optional = pesquisaPorNome(scanner);
        if (pessoa20Optional.isPresent()){
            Pessoa20 pessoa20 = pessoa20Optional.get();
            pessoa20.setNome(validandoNome(scanner));
            pessoa20.setCpf(validandoCpf(scanner));
            pessoa20.setIdade(validandoIdade(scanner));
            if (pessoa20 instanceof Aluno20){
                Aluno20 aluno20 = (Aluno20) pessoa20;
                aluno20.setMatricula(validandoMatricula(scanner));
                aluno20.setNotas(validandoNotas(scanner));
            }
            if (pessoa20 instanceof Professor20){
                Professor20 professor20 = (Professor20) pessoa20;
                professor20.setDisciplina(validandoDisciplina(scanner));
                professor20.setSalario(validandoSalarioProfessor(scanner));
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

}
