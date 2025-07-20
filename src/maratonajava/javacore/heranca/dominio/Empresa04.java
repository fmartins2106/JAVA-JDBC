package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa04 {
    private List<Funcionario04> funcionario04s;

    public Empresa04(){
        funcionario04s = new ArrayList<>();
    }

    public void addFuncionarios(Funcionario04 funcionario04){
        funcionario04s.add(funcionario04);
    }

    public static String validandoNome(Scanner scanner, Empresa04 empresa04){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa04.validandoString(nome)){
                return Funcionario04.formatoNome(nome);
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa04 empresa04){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa04.validandoString(departamento)){
                return Funcionario04.formatoNome(departamento);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < Funcionario04.IDADE_MINIMA){
                    System.out.println("Idade não pode ser menor que 18");
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.print("Digite uma idade válida.");
            }
        }
    }




    public boolean validandoString(String palavra){
        if (palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println("Campo "+palavra+" não pode ser vazio ou conter caracteres.");
            return false;
        }
        return true;
    }

    public void listaProdutos(){
        if (funcionario04s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario04s.forEach(System.out::println);
        }
    }

    public void pesquisaProdutos(Scanner scanner){
        if (funcionario04s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            String nome = validandoNome(scanner,this);
            if (validandoString(nome)){
                Funcionario04 funcionario04 = funcionario04s.stream().filter(p-> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
                if (funcionario04 !=null){
                    System.out.println("_______________________________________");
                    System.out.println("Nome:"+funcionario04.getNome());
                    System.out.println("Departamento:"+funcionario04.getDepartamento());
                    System.out.println("Idade:"+funcionario04.getIdade());
                    System.out.println("_______________________________________");
                }else {
                    System.out.println("Funcionário não encontrado.");
                }
            }
        }
    }

    public List<Funcionario04> getFuncionario04s() {
        return funcionario04s;
    }

    public void setFuncionario04s(List<Funcionario04> funcionario04s) {
        this.funcionario04s = funcionario04s;
    }
}
