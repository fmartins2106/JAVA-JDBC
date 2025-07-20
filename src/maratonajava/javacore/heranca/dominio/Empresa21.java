package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Empresa21 {
    private List<Funcionario21> funcionario21s;

    public Empresa21(){
        this.funcionario21s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Funcionario21.validacaoNome(nome);
                return Funcionario21.formatoNome(nome);
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
                Funcionario21.validacaoCpf(cpf);
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
                Funcionario21.validacaoIdade(idade);
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
                Funcionario21.validacaoDepartamento(departamento);
                return Funcionario21.formatoNome(departamento);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addFuncionario(Funcionario21 funcionario21){
        funcionario21s.add(funcionario21);
    }

    public void listaFuncionarios(){
        if (funcionario21s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario21s.forEach(System.out::println);
        }
    }

    public Optional<Funcionario21> pesquisaPorNome(Scanner scanner){
        if (funcionario21s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            String nome = validandoNome(scanner);
            Funcionario21 funcionario21 = funcionario21s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            return Optional.ofNullable(funcionario21);
        }
    }


    public void ExibidadosPesquisaNome(Scanner scanner){
        Optional<Funcionario21> funcionario21Optional = pesquisaPorNome(scanner);
        if (funcionario21Optional.isPresent()){
            Funcionario21 funcionario21 = funcionario21Optional.get();
            System.out.println("Nome:"+funcionario21.getNome());
            System.out.println("CPF:"+funcionario21.getCpf());
            System.out.println("Idade:"+funcionario21.getIdade());
            System.out.println("Departamento:"+funcionario21.getDepartamento());
            if (funcionario21 instanceof Gerente21){
                Gerente21 gerente21 = (Gerente21) funcionario21;
                System.out.println("Cargo gestão:"+gerente21.getCargoGestao());
                System.out.println("Salário:R$"+gerente21.getSalario());
            }
            if (funcionario21 instanceof Assistente21){
                Assistente21 assistente21 = (Assistente21) funcionario21;
                System.out.println("Cargo:"+assistente21.getCargo());
                System.out.println("Salário:R$"+assistente21.getSalario());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void excluirDadosFuncionario(Scanner scanner){
        Optional<Funcionario21> funcionario21Optional = pesquisaPorNome(scanner);
        if (funcionario21Optional.isPresent()){
            Funcionario21 funcionario21 = funcionario21Optional.get();
            funcionario21s.remove(funcionario21);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosFuncionario(Scanner scanner){
        Optional<Funcionario21> funcionario21Optional = pesquisaPorNome(scanner);
        if (funcionario21Optional.isPresent()){
            Funcionario21 funcionario21 = funcionario21Optional.get();
            funcionario21.setNome(validandoNome(scanner));
            funcionario21.setCpf(validandoCpf(scanner));
            funcionario21.setIdade(validandoIdade(scanner));
            funcionario21.setDepartamento(validandoDepartamento(scanner));
            if (funcionario21 instanceof Gerente21){
                Gerente21 gerente21 = (Gerente21) funcionario21;
                gerente21.setCargoGestao(Gerente21.validandoCargoGestao(scanner));
                gerente21.setSalario(Gerente21.validandoSalarioGestao(scanner));
            }
            if (funcionario21 instanceof Assistente21){
                Assistente21 assistente21 = (Assistente21) funcionario21;
                assistente21.setCargo(Assistente21.validandoCargo(scanner));
                assistente21.setSalario(Assistente21.validandoSalario(scanner));
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

}
