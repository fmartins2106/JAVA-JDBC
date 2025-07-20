package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa06 {
    private List<Funcionario06> funcionario06s;

    public Empresa06(){
        this.funcionario06s = new ArrayList<>();
    }

    public void addFuncionarios(Funcionario06 funcionario06){
        funcionario06s.add(funcionario06);
    }

    public boolean validandoStringNome(String nome){
        if (nome == null || nome.isEmpty()  || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Funcionario06.MENSAGEM_NOME_PADRAO);
            return false;
        }
        return true;
    }

    public boolean validandoStringDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Funcionario06.MENSAGEM_NOME_PADRAO);
            return false;
        }
        return true;
    }


    public static String validandoNome(Scanner scanner, Empresa06 empresa06){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa06.validandoStringNome(nome)){
                return Funcionario06.formatoNome(nome);
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa06 empresa06){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa06.validandoStringDepartamento(departamento)){
                return Funcionario06.formatoNome(departamento);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < Funcionario06.IDADE_MINIMA){
                    System.out.println(Funcionario06.MENSAGEM_IDADE_MINIMA);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaFuncionarios(){
        if (funcionario06s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario06s.forEach(System.out::println);
        }
    }

    public Funcionario06 pesquisaDeFuncionario(Scanner scanner){
        Funcionario06 funcionario06 = null;
        if (funcionario06s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            while (true){
                System.out.print("Nome:");
                String nome  = scanner.nextLine().trim();
                if (validandoStringNome(nome)){
                    funcionario06 = funcionario06s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
                    if (funcionario06 != null){
                        System.out.println("_________________________________");
                        System.out.println("Nome:"+funcionario06.getNome());
                        System.out.println("Departamento:"+funcionario06.getDepartamento());
                        System.out.println("Idade:"+funcionario06.getIdade());
                        System.out.println("_________________________________");
                        break;
                    }else {
                        System.out.println("Nome não encontrado.");
                    }
                }
            }
        }
        return funcionario06;
    }

    public void excluirFuncionario(Scanner scanner){
        if (funcionario06s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Funcionario06 funcionario06 = pesquisaDeFuncionario(scanner);
            funcionario06s.remove(funcionario06);
            System.out.println("Dados removido com sucesso.");
        }
    }

    public List<Funcionario06> getFuncionario06s() {
        return funcionario06s;
    }

    public void setFuncionario06s(List<Funcionario06> funcionario06s) {
        this.funcionario06s = funcionario06s;
    }

}
