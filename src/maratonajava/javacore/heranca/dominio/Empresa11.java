package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa11 {
    private List<Funcionario11> funcionario11s;

    public Empresa11(){
        this.funcionario11s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Funcionario11.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    private boolean validacaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Funcionario11.MENSAGEM_ERRO_DEPARTAMENTO);
            return false;
        }
        return true;
    }

    private boolean validacaoIdade(int idade){
        if (idade < Funcionario11.MENOR_IDADE){
            System.out.println(Funcionario11.MENSAGEM_ERRO_IDADE);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Empresa11 empresa11){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa11.validacaoNome(nome)){
                return Funcionario11.formatoNome(nome);
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa11 empresa11){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa11.validacaoDepartamento(departamento)){
                return Funcionario11.formatoNome(departamento);
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Empresa11 empresa11){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (empresa11.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma idade válida.");
            }
        }
    }


    public void listaFuncionarios(){
        if (funcionario11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario11s.forEach(System.out::println);
        }
    }

    public Funcionario11 pesquisaFuncionario(Scanner scanner, Empresa11 empresa11){
        Funcionario11 funcionario11;
        if (funcionario11s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            funcionario11 = funcionario11s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario11 != null){
                System.out.println("__________________________");
                System.out.println("Nome:"+funcionario11.getNome());
                System.out.println("Departamento:"+funcionario11.getDepartamento());
                System.out.println("Idade:"+funcionario11.getIdade());
                if (funcionario11 instanceof Gerente11){
                    Gerente11 gerente11 = (Gerente11) funcionario11;
                    System.out.println("Cargo gestão:"+gerente11.getCargoGestao());
                    System.out.println("Salário:R$"+gerente11.getSalario());
                }
                if (funcionario11 instanceof Assistente11){
                    Assistente11 assistente11 = (Assistente11) funcionario11;
                    System.out.println("Cargo:"+assistente11.getCargo());
                    System.out.println("Salário:R$"+assistente11.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado.");
                return null;
            }
        }
        return funcionario11;
    }

    public void excluirDadosFuncionario(Scanner scanner, Empresa11 empresa11){
        if (funcionario11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Funcionario11 funcionario11 = pesquisaFuncionario(scanner,empresa11);
            funcionario11s.remove(funcionario11);
            System.out.println("Dados excluidos com sucesso.");
        }
    }

    public void alterarDadosFuncionario(Scanner scanner,Empresa11 empresa11){
        if (funcionario11s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Funcionario11 funcionario11 = funcionario11s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario11 !=null){
                funcionario11.setNome(validandoNome(scanner,empresa11));
                funcionario11.setDepartamento(validandoDepartamento(scanner,empresa11));
                funcionario11.setIdade(validandoIdade(scanner,empresa11));
                if (funcionario11 instanceof Gerente11){
                    Gerente11 gerente11 = (Gerente11) funcionario11;
                    gerente11.setCargoGestao(Gerente11.validandoCargoGestao(scanner));
                    gerente11.setSalario(Gerente11.validandoSalarioProfessor(scanner));
                }
                if (funcionario11 instanceof Assistente11){
                    Assistente11 assistente11 = (Assistente11) funcionario11;
                    assistente11.setCargo(Assistente11.validandoCargo(scanner));
                    assistente11.setSalario(Assistente11.validandoSalario(scanner));
                }
            }else {
                System.out.println("Nome não encontrado, tente novamente.");
            }
        }
    }

    public List<Funcionario11> getFuncionario11s() {
        return funcionario11s;
    }

    public void setFuncionario11s(List<Funcionario11> funcionario11s) {
        this.funcionario11s = funcionario11s;
    }

    public void addFuncionario(Funcionario11 funcionario11){
        funcionario11s.add(funcionario11);
    }

}
