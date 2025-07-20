package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa15 {
    private List<Funcionario15> funcionario15s;

    public Empresa15(){
        this.funcionario15s = new ArrayList<>();
    }

    private boolean validacaoNome(String nome){
        if (nome == null || nome.isEmpty() || !nome.matches("[\\p{L}]+( [\\p{L}]+)+$")){
            System.out.println(Funcionario15.MensagensEValidacao.ERRO_NOME.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoCpf(String cpf){
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")){
            return false;
        }
        if (cpf.chars().distinct().count() == 1){
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma+=(cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >=  10) ? 0: digito1;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma+=(cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0: digito2;

        return (cpf.charAt(9) - '0') == digito1 && (cpf.charAt(10) - '0') == digito2;
    }

    private boolean validacaoIdade(int idade){
        if (idade < Funcionario15.IDADE_MINIMA){
            System.out.println(Funcionario15.MensagensEValidacao.ERRO_IDADE.getDescricao());
            return false;
        }
        return true;
    }

    private boolean validacaoDepartamento(String departamento){
        if (departamento == null || departamento.isEmpty() || !departamento.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
            System.out.println(Funcionario15.MensagensEValidacao.ERRO_DEPARTAMENTO.getDescricao());
            return false;
        }
        return true;
    }

    public static String validandoNome(Scanner scanner, Empresa15 empresa15){
        while (true){
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            if (empresa15.validacaoNome(nome)){
                return Funcionario15.formatoNome(nome);
            }
        }
    }

    public static String validandoCpf(Scanner scanner, Empresa15 empresa15){
        while (true){
            System.out.print("CPF:");
            String cpf = scanner.nextLine().trim();
            if (empresa15.validacaoCpf(cpf)){
                return cpf;
            }
        }
    }

    public static int validandoIdade(Scanner scanner, Empresa15 empresa15){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                if (empresa15.validacaoIdade(idade)){
                    return idade;
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner, Empresa15 empresa15){
        while (true){
            System.out.print("Departamento:");
            String departamento = scanner.nextLine().trim();
            if (empresa15.validacaoDepartamento(departamento)){
                return Funcionario15.formatoNome(departamento);
            }
        }
    }

    public void addFuncionarios(Funcionario15 funcionario15){
        funcionario15s.add(funcionario15);
    }

    public void listaFuncionarios(){
        if (funcionario15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            funcionario15s.forEach(System.out::println);
        }
    }

    public Funcionario15 pesquisaPorNome(Scanner scanner, Empresa15 empresa15){
        Funcionario15 funcionario15 = null;
        if (funcionario15s.isEmpty()){
            System.out.println("Lista vazia.");
            return null;
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            funcionario15 = funcionario15s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario15 != null){
                System.out.println("Nome:"+funcionario15.getNome());
                System.out.println("CPF:"+funcionario15.getCpf());
                System.out.println("Idade:"+funcionario15.getIdade());
                System.out.println("Departamento:"+funcionario15.getDepartamento());
                if (funcionario15 instanceof Gerente15){
                    Gerente15 gerente15 = (Gerente15) funcionario15;
                    System.out.println("Cargo gestão:"+gerente15.getCargoGestao());
                    System.out.println("Salário:R$"+gerente15.getSalario());
                }
                if (funcionario15 instanceof Assistente15){
                    Assistente15 assistente15 = (Assistente15) funcionario15;
                    System.out.println("Cargo:"+assistente15.getCargo());
                    System.out.println("Salário:R$"+assistente15.getSalario());
                }
            }else {
                System.out.println("Nome não encontrado");
                return null;
            }
        }
        return funcionario15;
    }

    public void excluirCadastro(Scanner scanner, Empresa15 empresa15){
        if (funcionario15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            Funcionario15 funcionario15 = pesquisaPorNome(scanner,empresa15);
            funcionario15s.remove(funcionario15);
            System.out.println("Cadastro removido com sucesso.");
        }
    }

    public void alterarCadastro(Scanner scanner, Empresa15 empresa15){
        if (funcionario15s.isEmpty()){
            System.out.println("Lista vazia.");
        }else {
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim();
            Funcionario15 funcionario15 = funcionario15s.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
            if (funcionario15 != null){
                funcionario15.setNome(validandoNome(scanner,empresa15));
                funcionario15.setCpf(validandoCpf(scanner,empresa15));
                funcionario15.setIdade(validandoIdade(scanner,empresa15));
                funcionario15.setDepartamento(validandoDepartamento(scanner, empresa15));
                if (funcionario15 instanceof Gerente15){
                    Gerente15 gerente15 = (Gerente15) funcionario15;
                    gerente15.setCargoGestao(Gerente15.validandoCargoGestao(scanner));
                    gerente15.setSalario(Gerente15.validandoSalario(scanner));
                }
                if (funcionario15 instanceof Assistente15){
                    Assistente15 assistente15 = (Assistente15) funcionario15;
                    assistente15.setCargo(Assistente15.validandoCargoGeral(scanner));
                    assistente15.setSalario(Assistente15.validandoSalarioGeral(scanner));
                }
            }else {
                System.out.println("Nome não encontrado.");
            }
        }
    }

    public List<Funcionario15> getFuncionario15s() {
        return funcionario15s;
    }
}
