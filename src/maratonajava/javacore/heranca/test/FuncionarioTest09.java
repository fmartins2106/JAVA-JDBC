package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente09;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa09;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente09;

import java.util.Scanner;

public class FuncionarioTest09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa09 empresa09 = new Empresa09();
        while (true){
            System.out.println("[1] Cadastro de pessoas.");
            System.out.println("[2] Listar funcionarios.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Excluir funcionarios.");
            System.out.println("[5] Alterar dados.");
            System.out.println("[6] Sair.");
            int opcao=0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroFuncionario(scanner,empresa09);
                    break;
                case 2:
                    empresa09.listaFuncionarios();
                    break;
                case 3:
                    empresa09.pesquisaFuncionarios(scanner);
                    break;
                case 4:
                    empresa09.excluirDadosFuncionario(scanner);
                    break;
                case 5:
                    empresa09.alterarDadosFuncionarios(scanner,empresa09);
                    break;
                case 6:
                    System.out.println("Finalizando o programa.");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroFuncionario(Scanner scanner, Empresa09 empresa09){
        String nome = Empresa09.validandoNome(scanner,empresa09);
        String departamento = Empresa09.validandoDepartamento(scanner,empresa09);
        int idade = Empresa09.validandoIdade(scanner);
        if (gestaoOuAssistente(scanner)){
            Gerente09 gerente09 = Gerente09.validacaoDadosGestao(scanner,nome,departamento,idade);
            empresa09.addPessoas(gerente09);
        }else {
            Assistente09 assistente09 = Assistente09.validandoDadosAssistente(scanner,nome,departamento,idade);
            empresa09.addPessoas(assistente09);
        }
    }

    private static boolean gestaoOuAssistente(Scanner scanner){
        String cargoGestaoOuAssistente="";
        do {
            System.out.print("É cargo de gestão ou assistente?(sim/não):");
            cargoGestaoOuAssistente = scanner.nextLine().trim();
        }while (!cargoGestaoOuAssistente.equalsIgnoreCase("sim")  && !cargoGestaoOuAssistente.equalsIgnoreCase("não"));
        return cargoGestaoOuAssistente.equalsIgnoreCase("sim");
    }
}
