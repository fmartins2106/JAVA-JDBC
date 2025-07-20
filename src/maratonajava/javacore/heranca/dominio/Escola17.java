package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.*;

public class Escola17 {
    private List<Pessoa17> pessoa17s;

    public Escola17(){
        this.pessoa17s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa17.MensagensErroPessoa17.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoCpf(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}")){
            return false;
        }
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma =0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 11) ? 0:digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private boolean validacaoIdade(int idade){
        if (idade < Pessoa17.IDADE_MINIMA){
            System.out.println(Pessoa17.MensagensErroPessoa17.ERRO_IDADE.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoMatricula(int matricula){
        if (matricula < Aluno17.MENOR_NUMERO_MATRICULA){
            System.out.println(Pessoa17.MensagensErroPessoa17.ERRO_MATRICULA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoNotas(double[] notas){
        for (double nota : notas){
            if (nota < Aluno17.MENOR_NOTA || nota > Aluno17.MAIOR_NOTA){
                System.out.println(Pessoa17.MensagensErroPessoa17.ERRO_NOTAS.getDescricao());
                return false;
            }
        }
        return true;
    }

    private boolean validacaoDisciplina(String disciplina){
        if (disciplina == null || disciplina.isEmpty() || !disciplina.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Pessoa17.MensagensErroPessoa17.ERRO_DISCIPLINA.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoSalario(double salario){
        if (salario < Professor17.SALARIO_MINIMO_PROFESSOR){
            System.out.println(Pessoa17.MensagensErroPessoa17.ERRO_SALARIO.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola17 escola17){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola17.validacaoNome(nome)){
                return Pessoa17.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Escola17 escola17){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (escola17.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Escola17 escola17){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (escola17.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Idade inválida.");
            }
        }
    }

    public static int validandoMatricula(Scanner scanner, Escola17 escola17){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (escola17.getPessoa17s().stream().anyMatch(pessoa17 -> pessoa17 instanceof Aluno17 && ((Aluno17)pessoa17).getMatricula() == matricula)){
                    System.out.println("Matricula já cadastrada, tente outro número de matrícula.");
                    continue;
                }
                if (escola17.validacaoMatricula(matricula)){
                    return matricula;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static double[] validandoNotas(Scanner scanner, Escola17 escola17){
        double[] notas = new double[4];
        for (int i = 0; i < notas.length; i++) {
            while (true){
                try {
                    System.out.print("Digite a "+(i+1)+"ª nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (escola17.validacaoNotas(notas)){
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
        }
        return notas;
    }

    public static String validandoDisciplina(Scanner scanner, Escola17 escola17){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola17.validacaoDisciplina(disciplina)){
                return Pessoa17.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalario(Scanner scanner, Escola17 escola17){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (escola17.validacaoSalario(salario)){
                    return salario;
                }
            }catch (NumberFormatException e){
                System.out.println("Valor de salãrio inválido.");
            }
        }
    }

    public void addPessoas(Pessoa17 pessoa17){
        pessoa17s.add(pessoa17);
    }

    public void listaPessoas(){
        if (pessoa17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa17s.forEach(System.out::println);
        }
    }

    public Optional<Pessoa17> pesquisaPorNome(Scanner scanner, Escola17 escola17){
        if (pessoa17s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa17 pessoa17 = pessoa17s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            return Optional.ofNullable(pessoa17);
        }
    }

    public void exibirDadosPesquisaFuncionario(Scanner scanner,Escola17 escola17){
        Optional<Pessoa17> pessoa17Opt = pesquisaPorNome(scanner,escola17);
        if (pessoa17Opt.isPresent()){
            Pessoa17 pessoa17 = pessoa17Opt.get();
            System.out.println("Nome:"+pessoa17.getNome());
            System.out.println("CPF:"+pessoa17.getCpf());
            System.out.println("Idade:"+pessoa17.getIdade());
            if (pessoa17 instanceof Aluno17){
                Aluno17 aluno17 = (Aluno17) pessoa17;
                System.out.println("Matrícula:"+aluno17.getMatricula());
                System.out.println("Notas:"+ Arrays.toString(aluno17.getNotas()));
                System.out.println("Média:"+aluno17.getMedia());
                System.out.println("Situação:"+aluno17.getSituacaoAluno17());
            }
            if (pessoa17 instanceof Professor17){
                Professor17 professor17 = (Professor17) pessoa17;
                System.out.println("Disciplina:"+professor17.getDisciplina());
                System.out.println("Salário:R$"+professor17.getSalario());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void excluirDadosPessoa(Scanner scanner,Escola17 escola17){
        Optional<Pessoa17> pessoa17Opt = pesquisaPorNome(scanner,escola17);
        if (pessoa17Opt.isPresent()){
            Pessoa17 pessoa17 = pessoa17Opt.get();
            pessoa17s.remove(pessoa17);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosPessoa(Scanner scanner, Escola17 escola17){
        Optional<Pessoa17> pessoa17Opt = pesquisaPorNome(scanner,escola17);
        if (pessoa17Opt.isPresent()){
            Pessoa17 pessoa17 = pessoa17Opt.get();
            pessoa17.setNome(Escola17.validandoNome(scanner,escola17));
            pessoa17.setCpf(Escola17.validandoCpf(scanner,escola17));
            pessoa17.setIdade(Escola17.validandoIdade(scanner,escola17));
            if (pessoa17 instanceof Aluno17){
                Aluno17 aluno17 = (Aluno17) pessoa17;
                aluno17.setNotas(Escola17.validandoNotas(scanner,escola17));
            }
            if (pessoa17 instanceof Professor17){
                Professor17 professor17 = (Professor17) pessoa17;
                professor17.setDisciplina(Escola17.validandoDisciplina(scanner,escola17));
                professor17.setSalario(Escola17.validandoSalario(scanner,escola17));
            }
        }else {
            System.out.println("Dados não encontrado.");
        }
    }

    public List<Pessoa17> getPessoa17s() {
        return pessoa17s;
    }
}
