package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa03 {
    public List<Funcionario03> funcionario03s;

    public Empresa03(){
        this.funcionario03s = new ArrayList<>();
    }

    public void addPessoas(Funcionario03 funcionario03){
        funcionario03s.add(funcionario03);
    }

    public static String validandoNome(Scanner scanner, Empresa03 empresa03){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa03.validandoString(nome)){
                return Funcionario03.formatoNome(nome);
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa03 empresa03){
        while (true){
            System.out.print("Categoria:");
            String departamento = scanner.nextLine().trim();
            if (empresa03.validandoString(departamento)){
                return Funcionario03.formatoNome(departamento);
            }
        }
    }

    private static final int IDADE_MINIMA = 18;
    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade =Integer.parseInt(scanner.nextLine());
                if (idade < IDADE_MINIMA){
                    System.out.println("Idade mínima aceita é 18 anos.");
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public boolean validandoString(String palavras){
        if (palavras.isEmpty() || !palavras.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println("Campo "+palavras+" não pode ser vazio ou conter caracteres.");
            return false;
        }
        return true;
    }

    public void listarFuncionarios(){
        if (funcionario03s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario03s.forEach(System.out::println);
        }
    }

    public void pesquisaNome(Scanner scanner){
        if (funcionario03s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Digite o nome:");
            String nome = validandoNome(scanner,this );
            Funcionario03 funcionario03 = funcionario03s.stream().filter(p -> p.getNome().equals(nome)).findFirst().orElse(null);
            if (funcionario03 != null){
                System.out.println("_____________________________________________");
                System.out.println("Nome:"+funcionario03.getNome());
                System.out.println("Categoria:"+funcionario03.getDepartamento());
                System.out.println("Idade:"+funcionario03.getIdade());
                System.out.println("_____________________________________________");
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public List<Funcionario03> getFuncionario03s() {
        return funcionario03s;
    }

    public void setFuncionario03s(List<Funcionario03> funcionario03s) {
        this.funcionario03s = funcionario03s;
    }
}
