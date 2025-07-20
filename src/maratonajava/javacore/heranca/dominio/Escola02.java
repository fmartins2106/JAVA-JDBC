package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escola02 {
    private List<Pessoa02> pessoa02s;

    public Escola02(){
        this.pessoa02s = new ArrayList<>();
    }

    public void addProdutos(Pessoa02 pessoa02){
        pessoa02s.add(pessoa02);
    }

    public boolean validandoParametrosNome(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Pessoa02.MENSAGEM_CONDICOES_NOME);
            return false;
        }
        return true;
    }

    public boolean validandoParametrosDisciplina(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Professor02.MENSAGEM_VALIDANDO_DISCIPLINA);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Escola02 escola02){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (escola02.validandoParametrosNome(nome)){
                return Pessoa02.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < Pessoa02.IDADE_MINIMA){
                    System.out.println(Pessoa02.MENSAGEM_IDADE_MINIMA);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println(Pessoa02.MENSAGEM_IDADE_MINIMA);
            }
        }
    }

    public static int validandoMatricula(Scanner scanner, List<Pessoa02> pessoa02s){
        while (true){
            try {
                System.out.print("Matrícula:");
                int matricula = Integer.parseInt(scanner.nextLine());
                if (matricula < Aluno02.MENOR_MATRICULA){
                    System.out.println(Aluno02.MENSAGEM_MINIMO_MATRICULA);
                    continue;
                }
                boolean matriculaExiste = pessoa02s.stream().anyMatch(p -> p instanceof Aluno02 && ((Aluno02)p).getMatricula()== matricula);
                if (matriculaExiste){
                    System.out.println("Matricula já existe, tente outro.");
                    continue;
                }
                return matricula;
            }catch (NumberFormatException e){
                System.out.println(Aluno02.MENSAGEM_MINIMO_MATRICULA);
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (isCpfValido(cpf)){
                return cpf;
            }else {
                System.out.println(Pessoa02.MENSAGEM_CPF_INVALIDO);
            }
        }
    }

    public static boolean isCpfValido(String cpf){
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
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma =0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11- i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public static String validandoDisciplina(Scanner scanner, Escola02 escola02){
        while (true){
            System.out.print("Disciplina:");
            String disciplina = scanner.nextLine().trim();
            if (escola02.validandoParametrosDisciplina(disciplina)){
                return Pessoa02.formatoNome(disciplina);
            }
        }
    }

    public static double validandoSalario(Scanner scanner){
        while (true){
            try {
                System.out.print("Salário:R$");
                double salario = Double.parseDouble(scanner.nextLine());
                if (salario < Professor02.SALARIO_MINIMO_PROFESSOR){
                    System.out.println(Professor02.MENSAGEM_SALARIO_MINIMO_PROFESSOR);
                    continue;
                }
                return salario;
            }catch (NumberFormatException e){
                System.out.println(Professor02.MENSAGEM_SALARIO_MINIMO_PROFESSOR);
            }
        }
    }

    public void listaRegistro(){
        if (pessoa02s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            pessoa02s.forEach(System.out::println);
        }
    }

    public Pessoa02 pesquisaPorNome(Scanner scanner){
        if (pessoa02s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Pessoa02 pessoa02 = pessoa02s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (pessoa02 != null){
                System.out.println("_______________________________");
                System.out.println("Nome:"+pessoa02.getNome());
                System.out.println("Idade:"+pessoa02.getIdade());
                System.out.println("CPF:"+pessoa02.getcpf());
                System.out.println("_______________________________");
            }else {
                System.out.println("Nome inválido, tente novamente.");
            }
            return pessoa02;
        }
    }

    public static double[] validandoNotas(Scanner scanner){
        double[] notas = new double[4];
        while (true){
            try {
                for (int i = 0; i < 4; i++) {
                    System.out.print("Digite a "+(i+1)+"º nota:");
                    notas[i] = Double.parseDouble(scanner.nextLine());
                    if (notas[i] < 0 || notas[i] >10){
                        System.out.println("Notas não podem ser menores que 0 ou maior que 10.");
                        i--;
                    }
                }
                return notas;
            }catch (NumberFormatException e){
                System.out.println("Nota inválida. Tente novamente.");
            }
        }
    }




    public List<Pessoa02> getPessoa02s() {
        return pessoa02s;
    }

    public void setPessoa02s(List<Pessoa02> pessoa02s) {
        this.pessoa02s = pessoa02s;
    }

    public void excluirPessoa(Scanner scanner){
        if (pessoa02s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Pessoa02 pessoa02 = pesquisaPorNome(scanner);
            if (pessoa02 != null){
                pessoa02s.remove(pessoa02);
                System.out.println("Cadastro removido com sucesso.");
            }else {
                System.out.println("Pessoa não encontrada.");
            }
        }



    }



}
