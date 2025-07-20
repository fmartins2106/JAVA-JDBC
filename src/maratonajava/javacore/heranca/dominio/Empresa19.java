package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Empresa19 {
    private List<Funcionario19> funcionario19s;

    public Empresa19(){
        this.funcionario19s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Funcionario19.validacaoNome(nome);
                return Funcionario19.formatoNome(nome);
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
                Funcionario19.validacaoCpf(cpf);
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
                Funcionario19.validacaoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido para idade.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner){
        while (true){
            try {
                System.out.print("Departamento:");
                String departamento = scanner.nextLine().trim();
                Funcionario19.validacaoDepartamento(departamento);
                return Funcionario19.formatoNome(departamento);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addFuncionario(Funcionario19 funcionario19){
        funcionario19s.add(funcionario19);
    }

    public void listaFuncionarios(){
        if (funcionario19s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario19s.forEach(System.out::println);
        }
    }

    public Optional<Funcionario19> pesquisaPorNome(Scanner scanner){
        if (funcionario19s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Funcionario19 funcionario19 = funcionario19s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            return Optional.ofNullable(funcionario19);
        }
    }

    public void exibindoDadosPesquisa(Scanner scanner){
        Optional<Funcionario19> funcionario19Optional = pesquisaPorNome(scanner);
        if (funcionario19Optional.isPresent()){
            Funcionario19 funcionario19 = funcionario19Optional.get();
            System.out.println("Nome:"+funcionario19.getNome());
            System.out.println("CPF:"+funcionario19.getCpf());
            System.out.println("Idade:"+funcionario19.getIdade());
            System.out.println("Departamento:"+funcionario19.getDepartamento());
            if (funcionario19 instanceof Gerente19){
                Gerente19 gerente19 = (Gerente19) funcionario19;
                System.out.println("Cargo gestão:"+gerente19.getCargoGestao());
                System.out.println("Salário:R$"+gerente19.getSalario());
            }
            if (funcionario19 instanceof Assistente19){
                Assistente19 assistente19 = (Assistente19) funcionario19;
                System.out.println("Cargo:"+assistente19.getCargo());
                System.out.println("Salário:R$"+assistente19.getSalario());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void excluirDadosFuncionario(Scanner scanner){
        Optional<Funcionario19> funcionario19Optional = pesquisaPorNome(scanner);
        if (funcionario19Optional.isPresent()){
            Funcionario19 funcionario19 = funcionario19Optional.get();
            funcionario19s.remove(funcionario19);
            System.out.println("Dados removidos com sucesso.");
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void alterarDadosFuncionarios(Scanner scanner){
        Optional<Funcionario19> funcionario19Optional = pesquisaPorNome(scanner);
        if (funcionario19Optional.isPresent()){
            Funcionario19 funcionario19 = funcionario19Optional.get();
            funcionario19.setNome(validandoNome(scanner));
            funcionario19.setCpf(validandoCpf(scanner));
            funcionario19.setIdade(validandoIdade(scanner));
            funcionario19.setDepartamento(validandoDepartamento(scanner));
            if (funcionario19 instanceof Gerente19){
                Gerente19 gerente19 = (Gerente19) funcionario19;
                gerente19.setCargoGestao(Gerente19.validandoCargoGestao(scanner));
                gerente19.setSalario(Gerente19.validandoSalarioCargoGestao(scanner));
            }
            if (funcionario19 instanceof Assistente19){
                Assistente19 assistente19 = (Assistente19) funcionario19;
                assistente19.setCargo(Assistente19.validandoCargoGeral(scanner));
                assistente19.setSalario(Assistente19.validandoSalarioGeral(scanner));
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

}
