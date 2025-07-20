package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente08;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa08;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente08;

import java.util.Scanner;

public class FuncionarioTest08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa08 empresa08 = new Empresa08();
        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastro funcionário.");
            System.out.println("[2] Lista de funcionários.");
            System.out.println("[3] Pesquisa Funcionário.");
            System.out.println("[4] Excluir funcionário.");
            System.out.println("[5] Alterando dados funcionários.");
            System.out.println("[6] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroFuncionarios(scanner,empresa08);
                    break;
                case 2:
                    empresa08.listaFuncionarios();
                    break;
                case 3:
                    empresa08.pesquisaFuncionario(scanner);
                    break;
                case 4:
                    empresa08.excluindoDodosFuncionario(scanner);
                    break;
                case 5:
                    empresa08.alterarDadosFuncionario(scanner,empresa08);
                    break;
                case 6:
                    System.out.println(">>>>Finalizando o programa...");
                    return;
                default:
                    System.out.println("Digite uma das opções acima.");
            }
        }
    }

    public static void cadastroFuncionarios(Scanner scanner, Empresa08 empresa08){
        String nome = Empresa08.validandoNome(scanner,empresa08);
        String departamento = Empresa08.validandoDepartamento(scanner,empresa08);
        int idade = Empresa08.validandoIdade(scanner);
        if (gestaoOuAssistente(scanner)){
            Gerente08 gerente08 = Gerente08.validandoDadosGerencia(scanner,nome,departamento,idade);
            empresa08.addFuncionarios(gerente08);
        }else {
            Assistente08 assistente08 = Assistente08.validacaoCargoGeral(scanner,nome,departamento,idade);
            empresa08.addFuncionarios(assistente08);
        }
    }

    private static boolean gestaoOuAssistente(Scanner scanner){
        String cargoGestaoOuAssistente = "";
        do {
            System.out.print("É cargo de gestão?(sim/não):");
            cargoGestaoOuAssistente = scanner.nextLine().trim().toLowerCase();
        }while (!cargoGestaoOuAssistente.equalsIgnoreCase("sim") && !cargoGestaoOuAssistente.equalsIgnoreCase("não"));
        return cargoGestaoOuAssistente.equalsIgnoreCase("sim");
    }



}
