package academy.devdojo.maratonajava.javacore.heranca.dominio;


import academy.devdojo.maratonajava.javacore.heranca.test.Funcionario05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa05 {
    List<Funcionario05>funcionario05s;

    public Empresa05(){
        this.funcionario05s = new ArrayList<>();
    }

    public void addFuncionarios(Funcionario05 funcionario05){
        funcionario05s.add(funcionario05);
    }

    public static final String MENSANGEM_ERRO = "Campo não pode ser vazio ou conter caracteres.";
    public boolean validandoStrings(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(MENSANGEM_ERRO);
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner,Empresa05 empresa05){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa05.validandoStrings(nome)){
                return Funcionario05.formatoNome(nome);
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa05 empresa05){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa05.validandoStrings(departamento)){
                return Funcionario05.formatoNome(departamento);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < Funcionario05.IDADE_MINIMA){
                    System.out.println(Funcionario05.MENSAGEM_VALIDAAO_IDADE);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listandoFuncionarios(){
        if (funcionario05s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario05s.forEach(System.out::println);
        }
    }

    public void pesquisaFuncionario(Scanner scanner){
        if (funcionario05s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Funcionario05 funcionario5 = funcionario05s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario5 !=null){
                System.out.println("________________________________");
                System.out.println("Nome:"+funcionario5.getNome());
                System.out.println("Departamento:"+funcionario5.getDepartamento());
                System.out.println("Idade:"+funcionario5.getIdade());
                System.out.println("________________________________");
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public void excluirFuncionario(Scanner scanner){
        if (funcionario05s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Funcionario05 funcionario05 = funcionario05s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario05 !=null){
                funcionario05s.remove(funcionario05);
                System.out.println("Funcionário excluido com sucesso.");
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public List<Funcionario05> getFuncionario05s() {
        return funcionario05s;
    }

    public void setFuncionario05s(List<Funcionario05> funcionario05s) {
        this.funcionario05s = funcionario05s;
    }
}
