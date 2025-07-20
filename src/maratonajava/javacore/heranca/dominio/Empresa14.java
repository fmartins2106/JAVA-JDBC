package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa14 {
    private List<Funcionario14> funcionario14s;

    public Empresa14(){
        this.funcionario14s = new ArrayList<>();
    }

    public boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Funcionario14.MensagensDeValidacao.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
    }

    public boolean validacaoIdade(int idade){
        if (idade < Funcionario14.IDADE_MINIMA){
            System.out.println(Funcionario14.MensagensDeValidacao.ERRO_IDADE.getDescricao());
            return false;
        }
        return true;
    }

    public boolean validacaoCpf(String cpf){
        if (cpf == null || cpf.length() !=11 || !cpf.matches("\\d{11}")){
            return false;
        }
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma=0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 -i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0: digito1;

        soma=0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    public boolean validacaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Funcionario14.MensagensDeValidacao.ERRO_DEPARTAMENTO.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Empresa14 empresa14){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa14.validacaoNome(nome)){
                return Funcionario14.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Empresa14 empresa14){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (empresa14.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Empresa14 empresa14){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (empresa14.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static String validandoDepartamento(Scanner scanners, Empresa14 empresa14){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanners.nextLine().trim();
            if (empresa14.validacaoDepartamento(departamento)){
                return Funcionario14.formatoNome(departamento);
            }
        }
    }

    public void addFuncionariosLista(Funcionario14 funcionario14){
        funcionario14s.add(funcionario14);
    }

    public void listaFuncionarios(){
        if (funcionario14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario14s.forEach(System.out::println);
        }
    }

    public Funcionario14 pesquisaPorNome(Scanner scanner, Empresa14 empresa14){
        Funcionario14 funcionario14 = null;
        if (funcionario14s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            funcionario14 = funcionario14s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario14 != null){
                System.out.println("Nome:"+funcionario14.getNome());
                System.out.println("Idade:"+funcionario14.getIdade());
                System.out.println("Cpf:"+funcionario14.getCpf());
                System.out.println("Departamento:"+funcionario14.getDepartamento());
                if (funcionario14 instanceof Gerente14){
                    Gerente14 gerente14 = (Gerente14) funcionario14;
                    System.out.println("Cargo:"+gerente14.getCargoGestao());
                    System.out.println("Salário:R$ "+gerente14.getSalario());
                }
                if (funcionario14 instanceof Assistente14){
                    Assistente14 assistente14 = (Assistente14) funcionario14;
                    System.out.println("Cargo:"+assistente14.getCargo());
                    System.out.println("Salário:R$"+assistente14.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado.");
                return null;

            }
        }
        return funcionario14;
    }

    public void excluirDados(Scanner scanner, Empresa14 empresa14){
        if (funcionario14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Funcionario14 funcionario14 = pesquisaPorNome(scanner,empresa14);
            funcionario14s.remove(funcionario14);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterandoDados(Scanner scanner, Empresa14 empresa14){
        if (funcionario14s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Funcionario14 funcionario14 = funcionario14s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario14 != null){
                funcionario14.setNome(validandoNome(scanner,empresa14));
                funcionario14.setIdade(validandoIdade(scanner,empresa14));
                funcionario14.setCpf(validandoCpf(scanner,empresa14));
                funcionario14.setDepartamento(validandoDepartamento(scanner,empresa14));
                if (funcionario14 instanceof Gerente14){
                    Gerente14 gerente14 =(Gerente14) funcionario14;
                    gerente14.setCargoGestao(Gerente14.validandoCargoGestao(scanner));
                    gerente14.setSalario(Gerente14.validandoSalarioGestao(scanner));
                }
                if (funcionario14 instanceof Assistente14){
                    Assistente14 assistente14 = (Assistente14) funcionario14;
                    assistente14.setCargo(Assistente14.validandoCargo(scanner));
                    assistente14.setSalario(Assistente14.validandoSalario(scanner));
                }
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }
}
