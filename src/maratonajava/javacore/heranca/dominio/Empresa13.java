package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa13 {
    private List<Funcionario13> funcionario13s;

    public Empresa13(){
        this.funcionario13s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Funcionario13.MENSAGEM_ERRO_NOME);
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

    public boolean validacaoIdade(int idade){
        if (idade < Funcionario13.IDADE_MINIMA){
            System.out.println(Funcionario13.MENSAGEM_ERRO_IDADE);
            return false;
        }
        return true;
    }

    public boolean validacaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Funcionario13.MENSAGEM_ERRO_DEPARTAMENTO);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Empresa13 empresa13){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa13.validacaoNome(nome)){
                return Funcionario13.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Empresa13 empresa13){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (empresa13.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Empresa13 empresa13){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (empresa13.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa13 empresa13){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa13.validacaoDepartamento(departamento)){
                return Funcionario13.formatoNome(departamento);
            }
        }
    }

    public void listaFuncionarios(){
        if (funcionario13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario13s.forEach(System.out::println);
        }
    }

    public Funcionario13 pesquisaPorNome(Scanner scanner, Empresa13 empresa13){
        Funcionario13 funcionario13;
        if (funcionario13s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            funcionario13 = funcionario13s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario13 !=null){
                System.out.println("________________________________________-");
                System.out.println("Nome:"+funcionario13.getNome());
                System.out.println("CPF:"+funcionario13.getCpf());
                System.out.println("Idade:"+funcionario13.getIdade());
                System.out.println("Departamento:"+funcionario13.getDepartamento());
                if (funcionario13 instanceof Gerente13){
                    Gerente13 gerente13 = (Gerente13) funcionario13;
                    System.out.println("Cargo gestão:"+((Gerente13) funcionario13).getCargoGestao());
                    System.out.println("Salãrio:R$"+((Gerente13) funcionario13).getSalario());
                }
                if (funcionario13 instanceof Assistente13){
                    Assistente13 assistente13 = (Assistente13) funcionario13;
                    System.out.println("Cargo:"+((Assistente13) funcionario13).getCargo());
                    System.out.println("Salário:R$"+((Assistente13) funcionario13).getSalario());
                }
                System.out.println("________________________________________-");
            }else {
                System.out.println("Digite um valor válido.");
                return null;
            }
        }
        return funcionario13;
    }

    public void excluirDados(Scanner scanner, Empresa13 empresa13){
        if (funcionario13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Funcionario13 funcionario13 = pesquisaPorNome(scanner,empresa13);
            funcionario13s.remove(funcionario13);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosFuncionario(Scanner scanner, Empresa13 empresa13){
        Funcionario13 funcionario13;
        if (funcionario13s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            funcionario13 = funcionario13s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario13 != null){
                funcionario13.setNome(validandoNome(scanner,empresa13));
                funcionario13.setCpf(validandoCpf(scanner,empresa13));
                funcionario13.setIdade(validandoIdade(scanner,empresa13));
                funcionario13.setDepartamento(validandoDepartamento(scanner,empresa13));
                if (funcionario13 instanceof Gerente13){
                    Gerente13 gerente13 = (Gerente13) funcionario13;
                    ((Gerente13) funcionario13).setCargoGestao(Gerente13.validandoCargoGestao(scanner));
                    ((Gerente13) funcionario13).setSalario(Gerente13.validandoSalario(scanner));
                }
                if (funcionario13 instanceof Assistente13){
                    Assistente13 assistente13 = (Assistente13) funcionario13;
                    ((Assistente13) funcionario13).setCargo(Assistente13.validandoCargo(scanner));
                    ((Assistente13) funcionario13).setSalario(Gerente13.validandoSalario(scanner));
                }
                System.out.println("________________________________________-");
            }else {
                System.out.println("Nome inválido. Tente novamente.");
            }
        }
    }

    public void addFuncionarios(Funcionario13 funcionario13){
        funcionario13s.add(funcionario13);
    }


    public List<Funcionario13> getFuncionario13s() {
        return funcionario13s;
    }

    public void setFuncionario13s(List<Funcionario13> funcionario13s) {
        this.funcionario13s = funcionario13s;
    }
}
