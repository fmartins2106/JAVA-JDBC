package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa01 {
    List<Funcionario01> funcionario01s;

    public Empresa01(){
        this.funcionario01s = new ArrayList<>();
    }

    public void adicionarFuncionarios(Funcionario01 funcionario01){
        funcionario01s.add(funcionario01);
    }

    public boolean validacaoString(String palavra){
        if (palavra == null || palavra.isEmpty() || !palavra.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println("Digite descrição completa sem adição de caracteres.");
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Empresa01 empresa01){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa01.validacaoString(nome)){
                return Funcionario01.formatoNome(nome);
            }
        }
    }
    private static final int IDADE_MINIMA=18;
    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < IDADE_MINIMA){
                    System.out.println("Idade não pode ser menor que 18.");
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite uma idade válida.");
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa01 empresa01){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa01.validacaoString(departamento)){
                return Funcionario01.formatoNome(departamento);
            }
        }
    }

    public void listarFuncionarios(){
        if (funcionario01s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario01s.forEach(System.out::println);
        }
    }

    public void buscaNomeFuncionario(Scanner scanner, List<Funcionario01> funcionario01s){
        if (funcionario01s.isEmpty()){
        System.out.println("Lista vazia.");
        }else {
            String nome = validandoNome(scanner,this);
            Funcionario01 funcionario01 = funcionario01s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario01 != null){
                System.out.println("Nome:"+funcionario01.getNome());
                System.out.println("Idade:"+funcionario01.getIdade());
                System.out.println("Departamento:"+funcionario01.getDepartamento());
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public List<Funcionario01> getFuncionario01s() {
        return funcionario01s;
    }

    public void setFuncionario01s(List<Funcionario01> funcionario01s) {
        this.funcionario01s = funcionario01s;
    }
}
