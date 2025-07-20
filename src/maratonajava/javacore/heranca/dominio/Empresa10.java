package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa10 {
    private List<Funcionario10> funcionario10s;

    public Empresa10(){
        this.funcionario10s = new ArrayList<>();
    }

    public void addPessoas(Funcionario10 funcionario10){
        funcionario10s.add(funcionario10);
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Funcionario10.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }


    private boolean validacaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Funcionario10.MENSAGEM_ERRO_DEPARTAMENTO);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Empresa10 empresa10){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa10.validacaoNome(nome)){
                return Funcionario10.formatoNome(nome);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < Funcionario10.IDADE_MINIMA){
                    System.out.println(Funcionario10.MENSAGEM_ERRO_IDADE);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa10 empresa10){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa10.validacaoDepartamento(departamento)){
                return Funcionario10.formatoNome(departamento);
            }
        }
    }

    public void listaFuncionarios(){
        if (funcionario10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario10s.forEach(System.out::println);
        }
    }

    public Funcionario10 pesquisaFuncionario(Scanner scanner){
        Funcionario10 funcionario10;
        if (funcionario10s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            funcionario10 = funcionario10s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario10 != null){
                System.out.println("Nome:"+funcionario10.getNome());
                System.out.println("Idade:"+funcionario10.getIdade());
                System.out.println("Departamento:"+funcionario10.getDepartamento());
                if (funcionario10 instanceof Gerente10){
                    Gerente10 gerente10 = (Gerente10) funcionario10;
                    System.out.println("Cargo gestão:"+gerente10.getCargoGestao());
                    System.out.println("Salário:R$"+gerente10.getSalario());
                }
                if (funcionario10 instanceof Assistente10){
                    Assistente10 assistente10 = (Assistente10) funcionario10;
                    System.out.println("Cargo:"+assistente10.getCargo());
                    System.out.println("Salário:R$"+assistente10.getSalario());
                }
            }else {
                System.out.println("Funcionário não encontrado.");
                return null;
            }
        }
        return funcionario10;
    }

    public void excluindoFuncionario(Scanner scanner){
        if (funcionario10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Funcionario10 funcionario10 = pesquisaFuncionario(scanner);
            funcionario10s.remove(funcionario10);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterandoDadosFuncionarios(Scanner scanner, Empresa10 empresa10){
        if (funcionario10s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Funcionario10 funcionario10 = funcionario10s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario10 != null){
                funcionario10.setNome(validandoNome(scanner,empresa10));
                funcionario10.setDepartamento(validandoDepartamento(scanner,empresa10));
                funcionario10.setIdade(validandoIdade(scanner));
                if (funcionario10 instanceof Gerente10){
                    Gerente10 gerente10 = (Gerente10) funcionario10;
                    gerente10.setCargoGestao(Gerente10.validandoCargoGestao(scanner));
                    gerente10.setSalario(Gerente10.validandoSalario(scanner));
                }
                if (funcionario10 instanceof Assistente10){
                    Assistente10 assistente10 = (Assistente10) funcionario10;
                    assistente10.setCargo(Assistente10.validandoCargo(scanner));
                    assistente10.setSalario(Assistente10.validandoSalario(scanner));
                }
            }
        }
    }

    public List<Funcionario10> getFuncionario10s() {
        return funcionario10s;
    }

    public void setFuncionario10s(List<Funcionario10> funcionario10s) {
        this.funcionario10s = funcionario10s;
    }
}
