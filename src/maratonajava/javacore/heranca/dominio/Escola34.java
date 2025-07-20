package academy.devdojo.maratonajava.javacore.heranca.dominio;

import academy.devdojo.maratonajava.javacore.excessoes.*;

import java.util.*;

public class Escola34 {
    private List<Pessoa34> pessoa34s;

    public Escola34(){
        this.pessoa34s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Pessoa34.validacaoNome(nome);
                return Pessoa34.formatoString(nome);
            }catch (NomePessoaInvalido34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Pessoa34.validacaoCpf(cpf);
                return cpf;
            }catch (CpfPessoaInvalido34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine().trim());
                Pessoa34.validandoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um número válido para idade.");
            }catch (IdadePessoaInvalida34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int valindandoMatricula(Scanner scanner){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine().trim());
                Aluno34.validacaoMatricula(matricula);
                Aluno34.validacaoMatriculaDuplicada(matricula);
                return matricula;
            }catch (NumberFormatException e){
                System.out.println("Digite um número de matrícula válido.");
            }catch (AlunoMatriculaInvalida34 | AlunoMatriculaDuplicada34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner){
        double[] notas = new double[4];
        while (true){
            try {
                for (int i = 0; i < notas.length; i++) {
                    System.out.print("Digite a "+(i+1)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine().trim());
                    Aluno34.validacaoNotas(notas);
                }
                return notas;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite uma nota válida.");
            }catch (AlunoNotasInvalidas34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoDisciplina(Scanner scanner){
        while (true){
            try {
                System.out.print("Disciplina:");
                String disciplina = scanner.nextLine().trim();
                Professor34.validacaoDisciplina(disciplina);
                return Pessoa34.formatoString(disciplina);
            }catch (ProfessorDisciplinaInvalida34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static double validandoSalarioProfessor(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine().trim());
                Professor34.validacaoSalarioProfessor(salario);
                return salario;
            }catch (NumberFormatException e){
                System.out.println("Erro. Digite um valor válido para salário.");
            }catch (ProfessorSalarioInvalido34 e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addCadastro(Pessoa34 pessoa34){
        pessoa34s.add(pessoa34);
        System.out.println("Cadastro efetuado com sucesso.");
    }

    public void listarPessoasCadastradas(){
        if (pessoa34s.isEmpty()){
            System.out.println("Nenhuma pessoa foi cadastrada.");
            return;
        }
        pessoa34s.forEach(System.out::println);
    }

    public void listarDadosAluno(){
        for (Pessoa34 pessoa34 : pessoa34s) {
            if (pessoa34 instanceof Aluno34){
                Aluno34 aluno34 = (Aluno34) pessoa34;
                System.out.println("________________________________________________________");
                System.out.println("Nome:"+aluno34.getNome());
                System.out.println("CPF:"+aluno34.getCpf());
                System.out.println("Idade:"+aluno34.getIdade());
                System.out.println("Matrícula:"+aluno34.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno34.getNotas()));
                System.out.println("Média:"+aluno34.getMedia());
                System.out.println("Situação aluno:"+aluno34.getSituacaoAluno34().getDescricao());
                System.out.println("________________________________________________________");
            }else {
                System.out.println("Nenhum aluno foi cadastrado.");
            }

        }
    }

    public void listarDadosProfessor(){
        for (Pessoa34 pessoa34 : pessoa34s) {
            if (pessoa34 instanceof Professor34){
                Professor34 professor34 = (Professor34) pessoa34;
                System.out.println("________________________________________________________");
                System.out.println("Nome:"+professor34.getNome());
                System.out.println("CPF:"+professor34.getCpf());
                System.out.println("Idade:"+professor34.getIdade());
                System.out.println("Disciplina:"+professor34.getDisciplina());
                System.out.println("Salário:R$"+professor34.getSalario());
                System.out.println("________________________________________________________");
            }else {
                System.out.println("Nenhum professor foi cadastrado.");
            }

        }
    }

    public Optional<Pessoa34> pesquisaPorNome(Scanner scanner){
        try {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa34.validacaoNome(nome);
            if (pessoa34s.isEmpty()){
                System.out.println("Nenhuma pessoa foi cadastrada.");
                return Optional.empty();
            }
            Optional<Pessoa34> nomeEncontrado = pessoa34s.stream().filter(pessoa34 -> pessoa34.getNome().equalsIgnoreCase(nome)).findFirst();
            if (nomeEncontrado.isPresent()){
                return nomeEncontrado;
            }
            System.out.println("Nenhum nome foi encontrado.");
            return Optional.empty();
        }catch (NomePessoaInvalido34 e){
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public void exibirDadosPequisaNome(Scanner scanner){
        Optional<Pessoa34> pessoa34Optional = pesquisaPorNome(scanner);
        if (pessoa34Optional.isPresent()){
            Pessoa34 pessoa34 = pessoa34Optional.get();
            System.out.println("Nome:"+pessoa34.getNome());
            System.out.println("CPF:"+pessoa34.getCpf());
            System.out.println("Idade:"+pessoa34.getIdade());
            if (pessoa34 instanceof Aluno34){
                Aluno34 aluno34 = (Aluno34) pessoa34;
                System.out.println("Matrícula:"+aluno34.getMatricula());
                System.out.println("Notas:"+Arrays.toString(aluno34.getNotas()));
                System.out.println("Média:"+aluno34.getMedia());
                System.out.println("Situação:"+aluno34.getSituacaoAluno34().getDescricao());
            }
            if (pessoa34 instanceof Professor34){
                Professor34 professor34 = (Professor34) pessoa34;
                System.out.println("Disciplina:"+professor34.getDisciplina());
                System.out.println("Salário:R$"+professor34.getSalario());
            }
        }
    }

    public void excluirDadosPessoa(Scanner scanner){
        Optional<Pessoa34> pessoa34Optional = pesquisaPorNome(scanner);
        if (pessoa34Optional.isPresent()){
            Pessoa34 pessoa34 = pessoa34Optional.get();
            Iterator<Pessoa34> pessoa34Iterator = pessoa34s.listIterator();;
            while (pessoa34Iterator.hasNext()){
                Pessoa34 pessoa = pessoa34Iterator.next();
                if (pessoa.equals(pessoa34)){
                    pessoa34Iterator.remove();
                    System.out.println("Dados removidos com sucesso.");
                }
            }
        }
    }

//    public void excluirPessoaSistema(){
//        Optional<Pessoa34> pessoa34Optional = pesquisaPorNome(new Scanner(System.in));
//        if (pessoa34Optional.isPresent()){
//            pessoa34s.removeIf(pessoa34 -> pessoa34.equals(pessoa34Optional.get()));
//            System.out.println("Produto removido com sucesso.");
//            return;
//        }
//        System.out.println("Produto não encontrado.");
//    }

    public void alterarDados(Scanner scanner){
        Optional<Pessoa34> pessoa34Optional = pesquisaPorNome(scanner);
        if (pessoa34Optional.isPresent()){
            Pessoa34 pessoa34 = pessoa34Optional.get();
            pessoa34.setNome(validandoNome(scanner));
            pessoa34.setCpf(validandoCpf(scanner));
            pessoa34.setIdade(validandoIdade(scanner));
            if (pessoa34 instanceof Aluno34){
                Aluno34 aluno34 = (Aluno34) pessoa34;
                aluno34.setNotas(validandoNotas(scanner));
            }
            if (pessoa34 instanceof Professor34){
                Professor34 professor34 = (Professor34) pessoa34;
                professor34.setDisciplina(validandoDisciplina(scanner));
                professor34.setSalario(validandoSalarioProfessor(scanner));
            }
        }
    }


}
