package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente05;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa05;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente05;

import java.util.Scanner;

public class FuncionarioTest05 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        Empresa05 empresa05 = new Empresa05();
        Assistente05 assistente05=null;
        Gerente05 gerente05=null;
        Funcionario05 funcionario05= null;
        while (true){
            System.out.println("[1] Cadastro de funcionário;");
            System.out.println("[2] Lista de funcionários.");
            System.out.println("[3] Pesquisa de funcionários.");
            System.out.println("[4] Excluir funcionário.");
            System.out.println("[5] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    casdastrandoFuncionarios(scanner, assistente05, empresa05, gerente05, funcionario05);
                    break;
                case 2:
                    empresa05.listandoFuncionarios();
                    break;
                case 3:
                    empresa05.pesquisaFuncionario(scanner);
                    break;
                case 4:
                    empresa05.excluirFuncionario(scanner);
                    break;
                case 5:
                    System.out.println(">>>Finalizando o programa...");
                    return;
                default:
                    System.out.println("Opção invãlida.");
            }
        }
    }

    public static void casdastrandoFuncionarios(Scanner scanner, Assistente05 assistente05, Empresa05 empresa05 , Gerente05 gerente05, Funcionario05 funcionario05){
        String nome = Empresa05.validandoNome(scanner, empresa05);
        String departamento = Empresa05.validandoDepartamento(scanner, empresa05);
        int idade = Empresa05.validandoIdade(scanner);
        String cargo ="";
        do {
            System.out.print("Tipo de cargo (liderança ou assistente):");
            cargo = scanner.nextLine().trim().toLowerCase();
        }while (!cargo.equalsIgnoreCase("liderança") && !cargo.equalsIgnoreCase("assistente"));
        if (cargo.equalsIgnoreCase("liderança")){
            empresa05.addFuncionarios(Gerente05.validandoDadosCargoGestao(scanner,nome,departamento,idade));
        }else {
            if (cargo.equalsIgnoreCase("assistente")){
                empresa05.addFuncionarios(Assistente05.validandoAssistente(scanner,nome,departamento,idade));
            }
        }
    }
}
