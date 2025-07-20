package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente06;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa06;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente06;

import java.util.Scanner;

public class FuncionarioTest06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa06 empresa06 = new Empresa06();
        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastro funcionário.");
            System.out.println("[2] Lista funcionário.");
            System.out.println("[3] Pesquisa funcionário.");
            System.out.println("[4] Excluir funcionário.");
            System.out.println("[5] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroFuncionario(scanner, empresa06);
                    break;
                case 2:
                    empresa06.listaFuncionarios();
                    break;
                case 3:
                    empresa06.pesquisaDeFuncionario(scanner);
                    break;
                case 4:
                    empresa06.excluirFuncionario(scanner);
                    break;
                case 5:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Lista inválida.");
            }
        }
    }

    public static void cadastroFuncionario(Scanner scanner, Empresa06 empresa06){
        String nome = Empresa06.validandoNome(scanner,empresa06);
        String departamento = Empresa06.validandoDepartamento(scanner,empresa06);
        int idade = Empresa06.validandoIdade(scanner);
        String cargo = "";
        do {
            System.out.print("É cargo de gestão ou assistente?(Gestão/Assistente07):");
            cargo = scanner.nextLine().trim().toLowerCase();
        }while (!cargo.equalsIgnoreCase("gestão") && !cargo.equalsIgnoreCase("Assistente07"));
        if (cargo.equalsIgnoreCase("gestão")){
            empresa06.addFuncionarios(Gerente06.validandoDadosGerencia(scanner,nome,departamento,idade));
        }else {
            empresa06.addFuncionarios(Assistente06.validandoDadosAssistente(scanner,nome,departamento,idade));
        }
    }


}
