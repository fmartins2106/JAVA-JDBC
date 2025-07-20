package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa07 {
    private List<Funcionario07>funcionario07s;

    public Empresa07(){
        this.funcionario07s = new ArrayList<>();
    }

    public void addFuncionarios(Funcionario07 funcionario07){
        funcionario07s.add(funcionario07);
    }

    public boolean validandoDadosNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Funcionario07.MENSAGEM_NOME_INVALIDO);
            return false;
        }
        return true;
    }

    public boolean validandoDadosDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Funcionario07.MENSAGEM_DEPARTAMENTO_INVALIDO);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Empresa07 empresa07){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa07.validandoDadosNome(nome)){
                return Funcionario07.formatoNome(nome);
            }
        }
    }

    public static String validandoDepartamenot(Scanner scanner, Empresa07 empresa07){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa07.validandoDadosDepartamento(departamento)){
                return Funcionario07.formatoNome(departamento);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < Funcionario07.IDADE_MINIMA){
                    System.out.println(Funcionario07.MENSAGEM_IDADE_INVALIDA);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaDeFuncionarios(){
        if (funcionario07s.isEmpty()){
            System.out.println("Lista vazia");
        }else {
            funcionario07s.forEach(System.out::println);
        }
    }

    public Funcionario07 pesquisaFuncionario(Scanner scanner){
        Funcionario07 funcionario07 = null;
        if (funcionario07s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            funcionario07 = funcionario07s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario07 != null){
                System.out.println("_______________________________________________");
                System.out.println("Nome:"+funcionario07.getNome());
                System.out.println("Departamento:"+funcionario07.getDepartamento());
                System.out.println("Idade:"+funcionario07.getIdade());
                System.out.println("_______________________________________________");
            }else {
                System.out.println("Funcionário não encontrado.");
                return null;
            }
        }
        return funcionario07;
    }

    public void excluirFuncionarios(Scanner scanner){
        if (funcionario07s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Funcionario07 funcionario07 = pesquisaFuncionario(scanner);
            if (funcionario07 !=null){
                funcionario07s.remove(funcionario07);
            }else {
                System.out.println("cadastro não encontrado, tente novamente.");
            }
        }
    }

    public List<Funcionario07> getFuncionario07s() {
        return funcionario07s;
    }

    public void setFuncionario07s(List<Funcionario07> funcionario07s) {
        this.funcionario07s = funcionario07s;
    }
}
