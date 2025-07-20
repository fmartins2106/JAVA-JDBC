package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente11;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa11;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente11;

import java.util.Scanner;

public class FuncionarioTest11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa11 empresa11 = new Empresa11();
        while (true){
            System.out.println("[1] Cadastro funcionário.");
            System.out.println("[2] Lista funcionário.");
            System.out.println("[3] Pesquisa Funcionário.");
            System.out.println("[4] Excluir dados funcionário.");
            System.out.println("[5] Alterar dados funcionários.");
            System.out.println("[6] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroFuncionario(scanner,empresa11);
                    break;
                case 2:
                    empresa11.listaFuncionarios();
                    break;
                case 3:
                    empresa11.pesquisaFuncionario(scanner,empresa11);
                    break;
                case 4:
                    empresa11.excluirDadosFuncionario(scanner,empresa11);
                    break;
                case 5:
                    empresa11.alterarDadosFuncionario(scanner,empresa11);
                    break;
                case 6:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroFuncionario(Scanner scanner, Empresa11 empresa11){
        String nome = Empresa11.validandoNome(scanner,empresa11);
        String departamento = Empresa11.validandoDepartamento(scanner,empresa11);
        int idade = Empresa11.validandoIdade(scanner,empresa11);
        if (gestaoOuAssistente(scanner)){
            Gerente11 gerente11 = Gerente11.validandoDadosGestao(scanner,nome,departamento,idade);
            empresa11.addFuncionario(gerente11);
        }else {
            Assistente11 assistente11 = Assistente11.cadastroAssistente(scanner,nome,departamento,idade);
            empresa11.addFuncionario(assistente11);
        }
    }

    public static boolean gestaoOuAssistente(Scanner scanner){
        String cargoGestaoOuAssistente ="";
        do {
            System.out.print("É cargo de gestão?(sim/não):");
            cargoGestaoOuAssistente = scanner.nextLine().trim();
        }while (!cargoGestaoOuAssistente.equalsIgnoreCase("sim") && !cargoGestaoOuAssistente.equalsIgnoreCase("não"));
        return (cargoGestaoOuAssistente.equalsIgnoreCase("sim"));
    }
}
