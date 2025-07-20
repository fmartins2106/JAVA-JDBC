package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Funcionario;

import java.util.*;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//          exericicios POO funcionarios salario
        funcionariosSalarios(scanner);
    }
    public static void funcionariosSalarios(Scanner scanner){
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        System.out.println("Quanto funcionários você deseja cadastrar?:");
        int quant = scanner.nextInt();
        scanner.nextLine();
        for (int n=0;n<quant;n++){
            System.out.println("Cadastro do "+(n+1)+"º funcionário:");
            System.out.print("Nome:");
            String nome = scanner.nextLine().trim().toLowerCase();
            System.out.print("Salário:");
            double salario = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Cargo:");
            String cargo = scanner.nextLine().trim().toLowerCase();


            Funcionario funcionario = new Funcionario(nome,salario,cargo);
            funcionarios.add(funcionario);

        }
        System.out.print("Digite o percentual do aumento:");
        double percentual = scanner.nextDouble();

        for (Funcionario funcionario : funcionarios){
            funcionario.AumentarSalario(percentual);
        }
        for (Funcionario funcionario : funcionarios){
            funcionario.exibirInformacoes();
        }
        System.out.println("Alterando dados do funcionário.");
        System.out.print("Digite a matricula do funcionário:");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index >=0 && index < funcionarios.size()){
            Funcionario funcionario = funcionarios.get(index);

            System.out.print("Digite o nome nome:");
            String novoNome = scanner.nextLine().trim().toLowerCase();
            funcionario.setNome(novoNome);
            System.out.print("Digite o novo cargo:");
            String novoCargo = scanner.nextLine().trim().toLowerCase();
            funcionario.setCargo(novoCargo);
            System.out.print("Novo salário:");
            double novoSalario = scanner.nextDouble();
            funcionario.setSalario(novoSalario);

            funcionario.exibirInformacoes();
        }else {
            System.out.println("Indice inválido. Tente novamente.");
        }
    }
}
