package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Empresa08 {
    private List<Funcionario08> funcionario08s;

    public Empresa08(){
        this.funcionario08s = new ArrayList<>();
    }

    public void addFuncionarios(Funcionario08 funcionario08){
        funcionario08s.add(funcionario08);
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("^[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Funcionario08.MENSAGEM_ERRO_NOME);
            return false;
        }
        return true;
    }

    private boolean validacaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Funcionario08.MENSAGEM_ERRO_DEPARTAMENTO);
            return false;
        }
        return true;
    }


    public static String validandoNome(Scanner scanner, Empresa08 empresa08){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa08.validacaoNome(nome)){
                return Funcionario08.formatoNomes(nome);
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa08 empresa08){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa08.validacaoDepartamento(departamento)){
                return Funcionario08.formatoNomes(departamento);
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (idade < Funcionario08.IDADE_MINIMA){
                    System.out.println(Funcionario08.MENSAGEM_ERRO_IDADE_MINIMA);
                    continue;
                }
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public void listaFuncionarios(){
        if (funcionario08s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario08s.forEach(System.out::println);
        }
    }

    public Funcionario08 pesquisaFuncionario(Scanner scanner){
        Funcionario08 funcionario08 = null;
        if (funcionario08s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Digite o nome:");
            String nome = scanner.nextLine().trim();
            funcionario08 = funcionario08s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario08 != null){
                System.out.println("____________________________________");
                System.out.println("Nome:"+funcionario08.getNome());
                System.out.println("Idade:"+funcionario08.getIdade());
                System.out.println("Departamento:"+funcionario08.getDepartamento());
                if (funcionario08 instanceof Gerente08){
                    Gerente08 gerente08 = (Gerente08) funcionario08;
                    gerente08.setCargoGestao(Gerente08.validandoCargoGestao(scanner));
                    gerente08.setSalario(Gerente08.validandoSalarioCargoGestao(scanner));
                }
                if (funcionario08 instanceof Assistente08){
                    Assistente08 assistente08 = (Assistente08) funcionario08;
                    assistente08.setCargoGeral(Assistente08.validandoCargoGeral(scanner));
                    assistente08.setSalario(Assistente08.validandoSalarioGeral(scanner));
                }
                System.out.println("Dados atualizados com sucesso.");
                System.out.println("____________________________________");
            }else {
                System.out.println("Nome não encontrado!!!");
                return null;
            }
        }
        return funcionario08;
    }

    public void excluindoDodosFuncionario(Scanner scanner){
        if (funcionario08s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Funcionario08 funcionario08 = pesquisaFuncionario(scanner);
            if (funcionario08 != null){
                funcionario08s.remove(funcionario08);
                System.out.println("Dados funcionário removido com sucesso.");
            }else {
                System.out.println("Funcionário não encontrado.");
            }
        }
    }

    public void alterarDadosFuncionario(Scanner scanner, Empresa08 empresa08){
        if (funcionario08s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Funcionario08 funcionario08 = funcionario08s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario08 !=null){
                funcionario08.setNome(validandoNome(scanner,empresa08));
                funcionario08.setDepartamento(validandoDepartamento(scanner,empresa08));
                funcionario08.setIdade(validandoIdade(scanner));
                if (funcionario08 instanceof Gerente08){
                    Gerente08 gerente08 = (Gerente08) funcionario08;
                    gerente08.setCargoGestao(Gerente08.validandoCargoGestao(scanner));
                    gerente08.setSalario(Gerente08.validandoSalarioCargoGestao(scanner));
                }
                if (funcionario08 instanceof Assistente08){
                    Assistente08 assistente08 = (Assistente08) funcionario08;
                    assistente08.setCargoGeral(Assistente08.validandoCargoGeral(scanner));
                    assistente08.setSalario(Assistente08.validandoSalarioGeral(scanner));
                }
                System.out.println("Dados atualizados com sucesso.");
            }else {
                System.out.println("Funcionário não encontrado.");
            }
        }
    }



}
