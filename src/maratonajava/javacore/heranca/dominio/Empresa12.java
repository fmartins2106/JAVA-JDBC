package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa12 {
    private List<Funcionario12> funcionario12s;

    public Empresa12(){
        this.funcionario12s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Funcionario12.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    private boolean validacaoIdade(int idade){
        if (idade <Funcionario12.IDADE_MINIMA){
            System.out.println(Funcionario12.MENSAGEM_ERRO_IDADE_MINIMA);
            return false;
        }
        return true;
    }


    private boolean isCpfValido(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}")){
            return false;
        }
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma=0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11  - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma=0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private boolean validacaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Funcionario12.MENSAGEM_ERRO_DEPARTAMENTO);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Empresa12 empresa12){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa12.validacaoNome(nome)){
                return Funcionario12.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Empresa12 empresa12){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (empresa12.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Empresa12 empresa12){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (empresa12.isCpfValido(cpf)){
                return cpf;
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa12 empresa12){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa12.validacaoDepartamento(departamento)){
                return Funcionario12.formatoNome(departamento);
            }
        }
    }

    public void listaFuncionarios(){
        if (funcionario12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario12s.forEach(System.out::println);
        }
    }

    public Funcionario12 pesquisaPorNome(Scanner scanner, Empresa12 empresa12){
        Funcionario12 funcionario12;
        if (funcionario12s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            funcionario12 = funcionario12s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario12 !=null){
                System.out.println("__________________________________");
                System.out.println("Nome:"+funcionario12.getNome());
                System.out.println("Idade:"+funcionario12.getIdade());
                System.out.println("CPF:"+funcionario12.getCpf());
                System.out.println("Departamento:"+funcionario12.getDepartamento());
                if (funcionario12 instanceof Gerente12){
                    Gerente12 gerente12 = (Gerente12) funcionario12;
                    System.out.println("Cargo gestão:"+gerente12.getCargoGestao());
                    System.out.println("Salário:"+gerente12.getSalario());
                }
                if (funcionario12 instanceof Assistente12){
                    Assistente12 assistente12 = (Assistente12) funcionario12;
                    System.out.println("Cargo:"+assistente12.getCargo());
                    System.out.println("Salário:"+assistente12.getSalario());
                }
                System.out.println("__________________________________");
            }else {
                System.out.println("Nome não encontrado, tente novamente.");
                return null;
            }
        }
        return funcionario12;
    }

    public void excluirDados(Scanner scanner, Empresa12 empresa12){
        if (funcionario12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Funcionario12 funcionario12 = pesquisaPorNome(scanner,empresa12);
            funcionario12s.remove(funcionario12);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterandoDados(Scanner scanner, Empresa12 empresa12){
        Funcionario12 funcionario12;
        if (funcionario12s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            funcionario12 = funcionario12s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario12 != null){
                System.out.println("__________________________________");
                funcionario12.setNome(validandoNome(scanner,empresa12));
                funcionario12.setIdade(validandoIdade(scanner,empresa12));
                funcionario12.setCpf(validandoCpf(scanner,empresa12));
                funcionario12.setDepartamento(validandoDepartamento(scanner,empresa12));
                if (funcionario12 instanceof Gerente12){
                    Gerente12 gerente12 = (Gerente12) funcionario12;
                    gerente12.setCargoGestao(Gerente12.validandoCargoGestao(scanner));
                    gerente12.setSalario(Gerente12.validandoSalario(scanner));
                }
                if (funcionario12 instanceof Assistente12){
                    Assistente12 assistente12 = (Assistente12) funcionario12;
                    assistente12.setCargo(Assistente12.validandoCargo(scanner));
                    assistente12.setSalario(Assistente12.validandoSalarioGeral(scanner));
                }
            }else {
                System.out.println("Nome não encontrado. Tente novamente.");
            }
        }
    }

    public void addFuncionarios(Funcionario12 funcionario12){
        funcionario12s.add(funcionario12);
    }
}
