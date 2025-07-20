package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Empresa09;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Funcionario09;

import java.util.*;

public class FuncionarioTest09 {
    public static void main(String[] args) {
        Empresa09 empresa09 = new Empresa09();

        Scanner scanner = new Scanner(System.in);

        while (true){
            int opcao=0;
            System.out.println("[1] Cadastrar funcionário.");
            System.out.println("[2] Lista de funcionários.");
            System.out.println("[3] Pesquisar funcionário por nome.");
            System.out.println("[4] Alterar dados funcionário.");
            System.out.println("[5] Excluir funcionários.");
            System.out.println("[6] Lista por salário.");
            System.out.println("[7] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    String nome = Empresa09.validandoNome(scanner);
                    double salario = Empresa09.validandoSalario(scanner);
                    String cargo = Empresa09.validandoCargo(scanner);
                    Funcionario09 funcionario09 = new Funcionario09(nome,salario,cargo);
                    empresa09.addLista(funcionario09);
                    break;

                case 2:
                    empresa09.tabelaFuncionariosCadastrados(empresa09.getFuncionarios09s());
                    break;

                case 3:
                    empresa09.pesquisaPorNome(scanner);
                    break;

                case 4:
                    empresa09.alterarDadosFuncionarios(scanner);
                    break;

                case 5:
                    empresa09.excluirFuncionario(scanner);
                    break;

                case 6:
                    empresa09.listaFuncionariosMaiorSalario();
                    break;
                case 7:
                    System.out.println(">>Finalizando o programa...");
                    return;

                default:
                    System.out.println("Digite uma opção válida. Tente novamente.");
            }
        }
    }
}
