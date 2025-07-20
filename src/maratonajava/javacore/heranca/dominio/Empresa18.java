package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Empresa18 {
    private List<Funcionario18> funcionario18s;

    public Empresa18(){
        this.funcionario18s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            try {
                Funcionario18.validacaoNome(nome);
                return Funcionario18.formatoNome(nome);
            }catch (IllegalArgumentException e){
                System.out.println(Funcionario18.MensagensValidacaoFuncionario18.ERRO_NOME.getDescricao());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            try {
                Funcionario18.validacaoCpf(cpf);
                return cpf;
            }catch (IllegalArgumentException e){
                System.out.println(Funcionario18.MensagensValidacaoFuncionario18.ERRO_CPF.getDescricao());
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                Funcionario18.validacaoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println(Funcionario18.MensagensValidacaoFuncionario18.ERRO_IDADE.getDescricao());
            }catch (IllegalArgumentException e){
                System.out.println(Funcionario18.MensagensValidacaoFuncionario18.ERRO_IDADE.getDescricao());
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner){
        while (true){
            try {
                System.out.print("Departamento:");
                String departamento = scanner.nextLine().trim();
                Funcionario18.validacaoDepartamento(departamento);
                return Funcionario18.formatoNome(departamento);
            }catch (IllegalArgumentException e){
                System.out.println(Funcionario18.MensagensValidacaoFuncionario18.ERRO_DEPARTAMENTO.getDescricao());
            }
        }
    }

    public void addFuncionarios(Funcionario18 funcionario18){
        funcionario18s.add(funcionario18);
    }

    public void listaFuncionarios(){
        if (funcionario18s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario18s.forEach(System.out::println);
        }
    }

    private Optional<Funcionario18> pesquisaPorNome(Scanner scanner, Empresa18 empresa18){
        if (funcionario18s.isEmpty()){
            System.out.println("Lista vazia.");
            return Optional.empty();
        }else {
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            Funcionario18 funcionario18 = funcionario18s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            return Optional.ofNullable(funcionario18);
        }
    }

    public void exibindoDadosPesquisa(Scanner scanner, Empresa18 empresa18){
        Optional<Funcionario18> funcionario18Optional = pesquisaPorNome(scanner,empresa18);
        if (funcionario18Optional.isPresent()){
            Funcionario18 funcionario18 = funcionario18Optional.get();
            System.out.println("Nome:"+funcionario18.getNome());
            System.out.println("CPF:"+funcionario18.getCpf());
            System.out.println("Idade:"+funcionario18.getIdade());
            System.out.println("Departamento:"+funcionario18.getDepartamento());
            if (funcionario18 instanceof Gerente18){
                Gerente18 gerente18 = (Gerente18) funcionario18;
                System.out.println("Cargo gestão:"+gerente18.getCargoGestao());
                System.out.println("Salário:R$"+gerente18.getSalario());
            }
            if (funcionario18 instanceof Assistente18){
                Assistente18 assistente18 = (Assistente18) funcionario18;
                System.out.println("Cargo:"+assistente18.getCargo());
                System.out.println("Salário:"+assistente18.getSalario());
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public void excluindoDadosPesquisa(Scanner scanner, Empresa18 empresa18){
        Optional<Funcionario18> funcionario18Optional = pesquisaPorNome(scanner,empresa18);
        if (funcionario18Optional.isPresent()){
            Funcionario18 funcionario18 = funcionario18Optional.get();
            funcionario18s.remove(funcionario18);
            System.out.println("Dados funcionário removidos com sucesso.");
        }
    }

    public void alterandoDadosFuncionarios(Scanner scanner, Empresa18 empresa18){
        Optional<Funcionario18> funcionario18Optional = pesquisaPorNome(scanner,empresa18);
        if (funcionario18Optional.isPresent()){
            Funcionario18 funcionario18 = funcionario18Optional.get();
            funcionario18.setNome(validandoNome(scanner));
            funcionario18.setCpf(validandoCpf(scanner));
            funcionario18.setIdade(validandoIdade(scanner));
            funcionario18.setDepartamento(validandoDepartamento(scanner));
            if (funcionario18 instanceof Gerente18){
                Gerente18 gerente18 = (Gerente18) funcionario18;
                gerente18.setCargoGestao(Gerente18.validandoCargoGestao(scanner));
                gerente18.setSalario(Gerente18.validandoSalario(scanner));
            }
            if (funcionario18 instanceof Assistente18){
                Assistente18 assistente18 = (Assistente18) funcionario18;
                assistente18.setCargo(Assistente18.validandoCargoGeral(scanner));
                assistente18.setSalario(Assistente18.validandoSalarioGeral(scanner));
            }
        }else {
            System.out.println("Nome não encontrado.");
        }
    }

    public List<Funcionario18> getFuncionario18s() {
        return funcionario18s;
    }
}
