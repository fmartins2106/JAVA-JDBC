package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa02 {
    private List<Funcionario02> funcionario02s;

    public Empresa02(){
        this.funcionario02s = new ArrayList<>();
    }

    public void addFuncionarios(Funcionario02 funcionario02){
        funcionario02s.add(funcionario02);
    }

    public static String validandoNome(Scanner scanner, Empresa02 empresa02){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa02.validandoString(nome)){
                return Funcionario02.formatoNome(nome);
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa02 empresa02){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa02.validandoString(departamento)){
                return Funcionario02.formatoNome(departamento);
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
                System.out.println("Digite um valor válido.");
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

    public void listarProdutos(Scanner scanner, List<Funcionario02> funcionario02s){
        if (funcionario02s.isEmpty()){
            System.out.println("lista vazia.");
        }else {
            funcionario02s.forEach(System.out::println);
        }
    }

    public void buscaFuncionariosNome(Scanner scanner, List<Funcionario02>funcionario02s){
        if (funcionario02s.isEmpty()){
            System.out.println("lista vazia.");
        }else {
            String nome = validandoNome(scanner,this);
            Funcionario02 funcionario02 = funcionario02s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario02 !=null){
                System.out.println("________________________");
                System.out.println("Nome:"+funcionario02.getNome());
                System.out.println("Idade:"+funcionario02.getIdade());
                System.out.println("Departamento:"+funcionario02.getDepartamento());
                System.out.println("________________________");
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public List<Funcionario02> getFuncionario02s() {
        return funcionario02s;
    }

    public void setFuncionario02s(List<Funcionario02> funcionario02s) {
        this.funcionario02s = funcionario02s;
    }
}
