package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.*;

public class Escola23 {
    private List<Pessoa23> pessoa23s;

    public Escola23(){
        this.pessoa23s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa23.validacaoNome(nome);
                return Pessoa23.formatoString(nome);
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
                Pessoa23.validacaoCpf(cpf);
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
                Pessoa23.validacaoIdade(idade);
                return idade;
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
                Aluno23.validacaoMatricula(matricula);
                return matricula;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido para matrícula.");
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
                    Aluno23.validacaoNotas(notas);
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um número de nota válido.");
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
                System.out.print("Dicisciplina:");
                String disciplina = scanner.nextLine().trim();
                Professor23.validacaoDisciplina(disciplina);
                return Pessoa23.formatoString(disciplina);
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
                Professor23.validacaoSalario(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor de salário válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addPessoas(Pessoa23 pessoa23){
        pessoa23s.add(pessoa23);
    }

    public void listaDePessoas(){
        if (pessoa23s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa23s.forEach(System.out::println);
        }
    }


     private Optional<Pessoa23> pesquisaPorNome(Scanner scanner){
        if (pessoa23s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            String nome = validandoNome(scanner);
            Pessoa23 pessoa23 = pessoa23s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            return Optional.ofNullable(pessoa23);
        }
     }


     public void exibirDadosPesquisaPorNome(Scanner scanner){
        Optional<Pessoa23> pessoa23Optional = pesquisaPorNome(scanner);
        if (pessoa23Optional.isPresent()){
            Pessoa23 pessoa23 = pessoa23Optional.get();
            System.out.println("Nome:"+pessoa23.getNome());
            System.out.println("CPF:"+pessoa23.getCpf());
            System.out.println("Idade:"+pessoa23.getIdade());
            if (pessoa23 instanceof Aluno23){
                Aluno23 aluno23 = (Aluno23) pessoa23;
                System.out.println("Matrícula:"+aluno23.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno23.getNotas()));
                System.out.println("Média:"+aluno23.getMedia());
                System.out.println("Situação:"+aluno23.getSituacaoAluno23().getDescricao());
            }
            if (pessoa23 instanceof Professor23){
                Professor23 professor23 = (Professor23) pessoa23;
                System.out.println("Disciplina:"+professor23.getDisciplina());
                System.out.println("Salário:R$"+professor23.getSalario());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
     }

     public void excluindoDados(Scanner scanner){
        Optional<Pessoa23> pessoa23Optional = pesquisaPorNome(scanner);
        if (pessoa23Optional.isPresent()){
            Pessoa23 pessoa23 = pessoa23Optional.get();
            pessoa23s.remove(pessoa23);
            System.out.println("Dados removido com sucesso.");
        }else {
            System.out.println("Nome não encontrado.");
        }
     }

     public void alterarDados(Scanner scanner){
        Optional<Pessoa23> pessoa23Optional = pesquisaPorNome(scanner);
        if (pessoa23Optional.isPresent()){
            Pessoa23 pessoa23 = pessoa23Optional.get();
            pessoa23.setNome(validandoNome(scanner));
            pessoa23.setCpf(validandoCpf(scanner));
            pessoa23.setIdade(validandoIdade(scanner));
            if (pessoa23 instanceof Aluno23){
                Aluno23 aluno23 = (Aluno23) pessoa23;
                aluno23.setNotas(validandoNotas(scanner));
            }
            if (pessoa23 instanceof Professor23){
                Professor23 professor23 = (Professor23) pessoa23;
                professor23.setDisciplina(validandoDisciplina(scanner));
                professor23.setSalario(validandoSalario(scanner));
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
     }
}
