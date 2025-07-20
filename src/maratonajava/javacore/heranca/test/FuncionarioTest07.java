package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente07;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa07;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente07;

import java.util.Scanner;

public class FuncionarioTest07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa07 empresa07 = new Empresa07();
        while (true){
            System.out.println("[1] Cadastro de funcionários.");
            System.out.println("[2] Lista de funcionários.");
            System.out.println("[3] Pesquisa funcionários.");
            System.out.println("[4] Excluir funcionários.");
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
                    cadastroFuncionario(scanner,empresa07);
                    break;
                case 2:
                    empresa07.listaDeFuncionarios();
                    break;
                case 3:
                    empresa07.pesquisaFuncionario(scanner);
                    break;
                case 4:
                    empresa07.excluirFuncionarios(scanner);
                    break;
                case 5:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("digite uma opção válida.");
            }
        }
    }
    public static void cadastroFuncionario(Scanner scanner, Empresa07 empresa07){
        String nome = Empresa07.validandoNome(scanner,empresa07);
        String departamento = Empresa07.validandoDepartamenot(scanner,empresa07);
        int idade = Empresa07.validandoIdade(scanner);
        String cargo ="";
        do {
            System.out.print("Cargo de gestão ou assistente?(Gestão/Assistente):");
            cargo = scanner.nextLine().trim().toLowerCase();
        }while (!cargo.equalsIgnoreCase("gestão") && !cargo.equalsIgnoreCase("assistente"));
        if (cargo.equalsIgnoreCase("gestão")){
            Gerente07 gerente07 = Gerente07.validandoCargoGestao(scanner,nome,departamento,idade);
            empresa07.addFuncionarios(gerente07);
        }else {
            Assistente07 assistente07 = Assistente07.validandoDadosAssistente(scanner,nome,departamento,idade);
            empresa07.addFuncionarios(assistente07);
        }
    }
}
