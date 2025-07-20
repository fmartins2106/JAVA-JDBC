package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Empresa10;
import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Funcionario10;

import java.util.*;

public class FuncionarioTest10 {
    public static void main(String[] args) {
        Empresa10 empresa10 = new Empresa10();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("[1] Cadastrar funcionário.");
            System.out.println("[2] Listar funcionários.");
            System.out.println("[3] Pesquisa funcionário por nome.");
            System.out.println("[4] Alterar cadastro.");
            System.out.println("[5] Excluir cadastro.");
            System.out.println("[6] Lista ordenada pelo salário.");
            System.out.println("[7] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Valor inválido.");
            }
            switch (opcao){
                case 1:
                    String nome = Empresa10.validandoNome(scanner);
                    double valor = Empresa10.validandoSalario(scanner);
                    String cargo = Empresa10.validandoCargo(scanner);
                    Funcionario10 funcionario10 = new Funcionario10(nome,valor,cargo);
                    empresa10.addFuncionario(funcionario10);
                    break;

                case 2:
                    empresa10.tabelaFuncionario(empresa10.getFuncionario10s());
                    break;

                case 3:
                    empresa10.pesquisaFuncionarioNome(scanner);
                    break;

                case 4:
                    empresa10.alterarDadosFuncionario(scanner);
                    break;

                case 5:
                    empresa10.excluirAluno(scanner);
                    break;

                case 6:
                    empresa10.listaMaiorSalario();
                    break;

                case 7:
                    System.out.println(">>>Finalizando o programa...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
