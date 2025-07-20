package academy.devdojo.maratonajava.javacore.heranca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Empresa22 {
    private List<Funcionario22> funcionario22s;

    public Empresa22(){
        this.funcionario22s = new ArrayList<>();
    }

    public static String validandoNome(Scanner scanner){
        while (true){
            try {
                System.out.print("Nome:");
                String nome = scanner.nextLine().trim();
                Funcionario22.validacaoNome(nome);
                return Funcionario22.formatoNome(nome);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoCpf(Scanner scanner){
        while (true){
            try {
                System.out.print("CPF:");
                String cpf = scanner.nextLine().trim();
                Funcionario22.validacaoCpf(cpf);
                return cpf;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validandoIdade(Scanner scanner){
        while (true){
            try {
                System.out.print("Idade:");
                int idade = Integer.parseInt(scanner.nextLine());
                Funcionario22.validacaoIdade(idade);
                return idade;
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validandoDepartamento(Scanner scanner){
        while (true){
            try {
                System.out.print("Departamento:");
                String departamento = scanner.nextLine().trim();
                Funcionario22.validacaoDepartamento(departamento);
                return Funcionario22.formatoNome(departamento);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void addFuncionario(Funcionario22 funcionario22){
        funcionario22s.add(funcionario22);
    }

    public void listarFuncionarios(){
        if (funcionario22s.isEmpty()){
            System.out.println("Lista vazia.Nenhum funcionário foi cadastrado.");
        }else {
            funcionario22s.forEach(System.out::println);
        }
    }

    public Optional<Funcionario22> pesquisaPorNome(Scanner scanner){
        String nome = validandoNome(scanner);
        if (funcionario22s == null || funcionario22s.isEmpty()){
            System.out.println("Lista vazia, nenhum funcionário foi cadastrado.");
            return Optional.empty();
        }
        Optional<Funcionario22> nomeEncontrado = funcionario22s.stream().filter(funcionario22 -> funcionario22.getNome().equalsIgnoreCase(nome)).findFirst();
        if (nomeEncontrado.isPresent()){
            return nomeEncontrado;
        }
        System.out.println("Nome não encontrado.");
        return Optional.empty();
    }

    public void exibirDadosPesquisaNome(Scanner scanner){
        Optional<Funcionario22> funcionario22Optional = pesquisaPorNome(scanner);
        if (funcionario22Optional.isPresent()){
            Funcionario22 funcionario22 = funcionario22Optional.get();
            System.out.println("_______________________________________");
            System.out.println("Nome:"+funcionario22.getNome());
            System.out.println("CPF:"+funcionario22.getCpf());
            System.out.println("Idade:"+funcionario22.getIdade());
            System.out.println("Departamento:"+funcionario22.getDepartamento());
            if (funcionario22 instanceof Gerente22){
                Gerente22 gerente22 = (Gerente22) funcionario22;
                System.out.println("Cargo gestão:"+gerente22.getCargoGestao());
                System.out.println("Salário:R$"+gerente22.getSalario());
            }
            if (funcionario22 instanceof Assistente22){
                Assistente22 assistente22 = (Assistente22) funcionario22;
                System.out.println("Cargo:"+assistente22.getCargoGeral());
                System.out.println("Salário:R$"+assistente22.getSalario());
            }
        }
    }

    public void excluirDados(Scanner scanner){
        Optional<Funcionario22> funcionario22Optional = pesquisaPorNome(scanner);
        if (funcionario22Optional.isPresent()){
            Funcionario22 funcionario22 = funcionario22Optional.get();
            funcionario22s.remove(funcionario22);
            System.out.println("Dados removidos com sucesso.");
        }
    }

//    public void excluirDados(Scanner scanner){
//        Optional<Funcionario22> funcionario22Optional = pesquisaPorNome(scanner);
//        if (funcionario22Optional.isPresent()){
//            funcionario22s.removeIf(funcionario22 -> funcionario22Optional.get().equals(funcionario22));
//            System.out.println("Dados do funcionário removido com sucesso.");
//            return;
//        }
//        System.out.println("Dados do funcionário não encontrado.");
//    }


    public void alterarDadosFuncionario(Scanner scanner){
        Optional<Funcionario22> funcionario22Optional = pesquisaPorNome(scanner);
        if (funcionario22Optional.isPresent()){
            Funcionario22 funcionario22 = funcionario22Optional.get();
            try {
                System.out.println("Digite uma das opções para alterar: \n[1]Nome. \n[2]CPF. \n[3]Idade. " +
                        "\n[4]Departamento. \n[5]Cargo. \n[6]Salário. \n[7]Sair.");
                System.out.println("--->>>>:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        funcionario22.setNome(validandoNome(scanner));
                        break;
                    case 2:
                        funcionario22.setCpf(validandoCpf(scanner));
                        break;
                    case 3:
                        funcionario22.setIdade(validandoIdade(scanner));
                        break;
                    case 4:
                        funcionario22.setDepartamento(validandoDepartamento(scanner));
                        break;
                    case 5:
                        if (funcionario22 instanceof Gerente22){
                            Gerente22 gerente22 = (Gerente22) funcionario22;
                            gerente22.setCargoGestao(Gerente22.validandoCargoGestao(scanner));
                        }
                        if (funcionario22 instanceof  Assistente22){
                            Assistente22 assistente22 = (Assistente22) funcionario22;
                            assistente22.setCargoGeral(Assistente22.validandoCargoGeral(scanner));
                        }
                        break;
                    case 6:
                        if (funcionario22 instanceof Gerente22){
                            Gerente22 gerente22 = (Gerente22) funcionario22;
                            gerente22.setSalario(Gerente22.validandoSalarioGestao(scanner));
                        }
                        if (funcionario22 instanceof  Assistente22){
                            Assistente22 assistente22 = (Assistente22) funcionario22;
                            assistente22.setSalario(Assistente22.validandoSalarioGeral(scanner));
                        }
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }
}
