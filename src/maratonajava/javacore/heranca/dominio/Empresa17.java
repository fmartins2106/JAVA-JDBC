package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa17 {
    private List<Funcionario17> funcionario17s;

    public Empresa17(){
        this.funcionario17s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Funcionario17.MensagensValidacaoFuncionario17.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")){
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
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') ==digito2;
    }

    private boolean validacaoIdade(int idade){
        if (idade < Funcionario17.IDADE_MINIMA){
            System.out.println(Funcionario17.MensagensValidacaoFuncionario17.ERRO_IDADE.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Funcionario17.MensagensValidacaoFuncionario17.ERRO_DEPARTAMENTO.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Empresa17 empresa17){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa17.validacaoNome(nome)){
                return Funcionario17.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Empresa17 empresa17){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (empresa17.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Empresa17 empresa17){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (empresa17.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa17 empresa17){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa17.validacaoDepartamento(departamento)){
                return Funcionario17.formatoNome(departamento);
            }
        }
    }

    public void addFuncionario(Funcionario17 funcionario17){
        funcionario17s.add(funcionario17);
    }

    public void listaFuncionario(){
        if (funcionario17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario17s.forEach(System.out::println);
        }
    }

    public Funcionario17 pesquisaPorNome(Scanner scanner, Empresa17 empresa17){
        Funcionario17 funcionario17 = null;
        if (funcionario17s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            funcionario17 = funcionario17s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario17 != null){
                System.out.println("Nome:"+funcionario17.getNome());
                System.out.println("CPF:"+funcionario17.getCpf());
                System.out.println("Idade:"+funcionario17.getIdade());
                System.out.println("Departamento:"+funcionario17.getDepartamento());
                if (funcionario17 instanceof Gerente17){
                    Gerente17 gerente17 = (Gerente17) funcionario17;
                    System.out.println("Cargo gestão:"+gerente17.getCargoGestao());
                    System.out.println("Salário:R$"+gerente17.getSalario());
                }
                if (funcionario17 instanceof Assistente17){
                    Assistente17 assistente17 = (Assistente17) funcionario17;
                    System.out.println("Cargo:"+assistente17.getCargo());
                    System.out.println("Salário:R$"+assistente17.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado.");
                return null;
            }
        }
        return funcionario17;
    }


    public void excluirDadosFuncionario(Scanner scanner, Empresa17 empresa17){
        if (funcionario17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Funcionario17 funcionario17 = pesquisaPorNome(scanner,empresa17);
            funcionario17s.remove(funcionario17);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDados(Scanner scanner, Empresa17 empresa17){
        if (funcionario17s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Funcionario17 funcionario17 = funcionario17s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario17 != null){
                funcionario17.setNome(Empresa17.validandoNome(scanner,empresa17));
                funcionario17.setCpf(Empresa17.validandoCpf(scanner,empresa17));
                funcionario17.setIdade(Empresa17.validandoIdade(scanner,empresa17));
                funcionario17.setDepartamento(Empresa17.validandoDepartamento(scanner,empresa17));
                if (funcionario17 instanceof Gerente17){
                    Gerente17 gerente17 = (Gerente17) funcionario17;
                    gerente17.setCargoGestao(Gerente17.validandoCargoGestao(scanner));
                    gerente17.setSalario(Gerente17.validandoSalarioGestao(scanner));
                }
                if (funcionario17 instanceof Assistente17){
                    Assistente17 assistente17 = (Assistente17) funcionario17;
                    assistente17.setCargo(Assistente17.validandoCargoGeral(scanner));
                    assistente17.setSalario(Assistente17.validandoSalarioGeral(scanner));
                }
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public List<Funcionario17> getFuncionario17s() {
        return funcionario17s;
    }
}
