package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa16 {
    private List<Funcionario16> funcionario16s;

    public Empresa16(){
        this.funcionario16s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Funcionario16.MensagensErro16.ERRO_NOME.getDescricao());
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

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private boolean validacaoIdade(int idade){
        if (idade < Funcionario16.IDADE_MINIMA){
            System.out.println(Funcionario16.MensagensErro16.ERRO_IDADE.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validancaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Funcionario16.MensagensErro16.ERRO_DEPARTAMENTO.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Empresa16 empresa16){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa16.validacaoNome(nome)){
                return Funcionario16.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Empresa16 empresa16){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine();
            if (empresa16.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoIdade(Scanner scanner,Empresa16 empresa16){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (empresa16.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Valor inválido, tente novamente.");
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa16 empresa16){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine();
            if (empresa16.validancaoDepartamento(departamento)){
                return Funcionario16.formatoNome(departamento);
            }
        }
    }

    public void addFuncionarios(Funcionario16 funcionario16){
        funcionario16s.add(funcionario16);
    }

    public void listaFuncionarios(){
        if (funcionario16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario16s.forEach(System.out::println);
        }
    }

    public Funcionario16 pesquisaPorNome(Scanner scannera, Empresa16 empresa16){
        Funcionario16 funcionario16 = null;
        if (funcionario16s.isEmpty()){
            System.out.println("lista vazia");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scannera.nextLine().trim();
            funcionario16 = funcionario16s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario16 != null){
                System.out.println("Nome:"+funcionario16.getNome());
                System.out.println("CPF:"+funcionario16.getCpf());
                System.out.println("Idade:"+funcionario16.getIdade());
                System.out.println("Departamento:"+funcionario16.getDepartamento());
                if (funcionario16 instanceof Gerente16){
                    Gerente16 gerente16 = (Gerente16) funcionario16;
                    System.out.println("Cargo gestão:"+gerente16.getCargoGestao());
                    System.out.println("Salário:"+gerente16.getSalario());
                }
                if (funcionario16 instanceof Assistente16){
                    Assistente16 assistente16 = (Assistente16) funcionario16;
                    System.out.println("Cargo:"+assistente16.getCargoGeral());
                    System.out.println("Salário:R$"+assistente16.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado.");
                return null;
            }
        }
        return funcionario16;
    }

    public void excluindoDados(Scanner scanner, Empresa16 empresa16){
        if (funcionario16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Funcionario16 funcionario16 = pesquisaPorNome(scanner,empresa16);
            funcionario16s.remove(funcionario16);
            System.out.println("Dados excluidos com sucesso.");
        }
    }

    public void alterarDados(Scanner scanner, Empresa16 empresa16){
        if (funcionario16s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Funcionario16 funcionario16 = funcionario16s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario16 != null){
                funcionario16.setNome(validandoNome(scanner,empresa16));
                funcionario16.setCpf(validandoCpf(scanner,empresa16));
                funcionario16.setIdade(validandoIdade(scanner,empresa16));
                funcionario16.setDepartamento(validandoDepartamento(scanner,empresa16));
                if (funcionario16 instanceof Gerente16){
                    Gerente16 gerente16 = (Gerente16) funcionario16;
                    gerente16.setCargoGestao(Gerente16.validandoCargoGestao(scanner));
                    gerente16.setSalario(Gerente16.validandoSalarioGestao(scanner));
                }
                if (funcionario16 instanceof Assistente16){
                    Assistente16 assistente16 = (Assistente16) funcionario16;
                    assistente16.setCargoGeral(Assistente16.validandoCargoGeral(scanner));
                    assistente16.setSalario(Assistente16.validandoSalarioGeral(scanner));
                }
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public List<Funcionario16> getFuncionario16s() {
        return funcionario16s;
    }
}
