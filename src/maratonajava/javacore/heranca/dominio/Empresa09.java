package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa09 {
    private List<Funcionario09> funcionario09s;

    public Empresa09(){
        this.funcionario09s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Funcionario09.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Empresa09 empresa09){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa09.validacaoNome(nome)){
                return Funcionario09.formatoNome(nome);
            }
        }
    }

    public boolean validacaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Funcionario09.MENSAGEM_ERRO_DEPARTAMENTO);
            return false;
        }
        return true;
    }

    public static String validandoDepartamento(Scanner scanner, Empresa09 empresa09){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa09.validacaoDepartamento(departamento)){
                return Funcionario09.formatoNome(departamento);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade <Funcionario09.IDADE_MINIMA){
                    System.out.println(Funcionario09.MENSAGEM_ERRO_IDADE);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite  um valor válido.");
            }
        }
    }

    public void listaFuncionarios(){
        if (funcionario09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario09s.forEach(System.out::println);
        }
    }

    public Funcionario09 pesquisaFuncionarios(Scanner scanner){
        Funcionario09 funcionario09;
        if (funcionario09s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            funcionario09 = funcionario09s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario09 != null){
                System.out.println("_______________________________");
                System.out.println("Nome:"+funcionario09.getNome());
                System.out.println("Departamento:"+funcionario09.getDepartamento());
                System.out.println("Idade:"+funcionario09.getIdade());
                if (funcionario09 instanceof Gerente09){
                    Gerente09 gerente09 = (Gerente09) funcionario09;
                    System.out.println("Cargo Gestão:"+gerente09.getCargoGestao());
                    System.out.println("Salário:R$"+gerente09.getSalario());
                }
                if (funcionario09 instanceof Assistente09){
                    Assistente09 assistente09 = (Assistente09) funcionario09;
                    System.out.println("Cargo:"+assistente09.getCargoGeral());
                    System.out.println("Salário:R$"+assistente09.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado. Tente novamente.");
                return null;
            }

        }
        return funcionario09;
    }

    public void excluirDadosFuncionario(Scanner scanner){
        if (funcionario09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Funcionario09 funcionario09 = pesquisaFuncionarios(scanner);
            funcionario09s.remove(funcionario09);
            System.out.println("Dados removidos com sucesso.");
        }
    }

    public void alterarDadosFuncionarios(Scanner scanner, Empresa09 empresa09){
        if (funcionario09s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Funcionario09 funcionario09 = funcionario09s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario09 !=null){
                funcionario09.setNome(validandoNome(scanner,empresa09));
                funcionario09.setDepartamento(validandoDepartamento(scanner,empresa09));
                funcionario09.setIdade(validandoIdade(scanner));
                if (funcionario09 instanceof Gerente09){
                    Gerente09 gerente09 = (Gerente09) funcionario09;
                    gerente09.setCargoGestao(Gerente09.validandoCargoGestao(scanner));
                    gerente09.setSalario(Gerente09.validandoSalarioGestao(scanner));
                }
                if (funcionario09 instanceof Assistente09){
                    Assistente09 assistente09 = (Assistente09) funcionario09;
                    assistente09.setCargoGeral(Assistente09.validacaoCargo(scanner));
                    assistente09.setSalario(Assistente09.vvalidacaoSalario(scanner));
                }
            }else {
                System.out.println("Nome não encontrado. Tente novamente.");
            }
        }
    }

    public void addPessoas(Funcionario09 funcionario09){
        funcionario09s.add(funcionario09);
    }
}
