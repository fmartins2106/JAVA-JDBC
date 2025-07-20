package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Empresa20 {
    private List<Funcionario20> funcionario20s;

    public Empresa20(){
        this.funcionario20s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Funcionario20.validacaoNome(nome);
                return Funcionario20.formatoNome(nome);
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
                Funcionario20.validacaoCpf(cpf);
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
                Funcionario20.validacaoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite uma idade válida.");
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
                Funcionario20.validacaoDepartamento(departamento);
                return Funcionario20.formatoNome(departamento);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addFuncionario(Funcionario20 funcionario20){
        funcionario20s.add(funcionario20);
    }

    public void listaFuncionarios(){
        if (funcionario20s.isEmpty()){
            System.out.println("Lista vazia.");
        }else{
            funcionario20s.forEach(System.out::println);
        }
    }

    public Optional<Funcionario20> pesquisaPorNome(Scanner scanner){
        if (funcionario20s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Funcionario20 funcionario20 = funcionario20s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            return Optional.ofNullable(funcionario20);
        }
    }

    public void exibirDadosPesquisa(Scanner scanner){
        Optional<Funcionario20> funcionario20Optional = pesquisaPorNome(scanner);
        if (funcionario20Optional.isPresent()){
            Funcionario20 funcionario20 = funcionario20Optional.get();
            System.out.println("Nome:"+funcionario20.getNome());
            System.out.println("CPF:"+funcionario20.getCpf());
            System.out.println("Idade:"+funcionario20.getIdade());
            System.out.println("Departamento:"+funcionario20.getDepartamento());
            if (funcionario20 instanceof Gerente20){
                Gerente20 gerente20 = (Gerente20) funcionario20;
                System.out.println("Cargo Gestão:"+gerente20.getCargoGestao());
                System.out.println("Salário:R$"+gerente20.getSalario());
            }
            if (funcionario20 instanceof Assistete20){
                Assistete20 assistete20 = (Assistete20) funcionario20;
                System.out.println("Cargo:"+assistete20.getCargo());
                System.out.println("Salário:R$"+assistete20.getSalario());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void excluirDados(Scanner scanner){
        Optional<Funcionario20> funcionario20Optional = pesquisaPorNome(scanner);
        if (funcionario20Optional.isPresent()){
            Funcionario20 funcionario20 = funcionario20Optional.get();
            funcionario20s.remove(funcionario20);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosFucionario(Scanner scanner){
        Optional<Funcionario20> funcionario20Optional = pesquisaPorNome(scanner);
        if (funcionario20Optional.isPresent()){
            Funcionario20 funcionario20 = funcionario20Optional.get();
            funcionario20.setNome(validandoNome(scanner));
            funcionario20.setCpf(validandoCpf(scanner));
            funcionario20.setIdade(validandoIdade(scanner));
            funcionario20.setDepartamento(validandoDepartamento(scanner));
            if (funcionario20 instanceof Gerente20){
                Gerente20 gerente20 = (Gerente20) funcionario20;
                gerente20.setCargoGestao(Gerente20.validandoCargoGestao(scanner));
                gerente20.setSalario(Gerente20.validandoSalarioCargoGestao(scanner));
            }
            if (funcionario20 instanceof Assistete20){
                Assistete20 assistete20 = (Assistete20) funcionario20;
                assistete20.setCargo(Assistete20.validandoCargo(scanner));
                assistete20.setSalario(Assistete20.validandoSalario(scanner));
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }
}
