package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente10;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa10;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente10;

import java.util.Scanner;

public class FuncionarioTest10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa10 empresa10 = new Empresa10();
        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastro de funcionário.");
            System.out.println("[2] Lista de funcionarios.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Excluir dados.");
            System.out.println("[5] Alterar dados.");
            System.out.println("[6] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastroPessoas(scanner,empresa10);
                    break;
                case 2:
                    empresa10.listaFuncionarios();
                    break;
                case 3:
                    empresa10.pesquisaFuncionario(scanner);
                    break;
                case 4:
                    empresa10.excluindoFuncionario(scanner);
                    break;
                case 5:
                    empresa10.alterandoDadosFuncionarios(scanner,empresa10);
                    break;
                case 6:
                    System.out.println(">>>Finalizando o programa.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroPessoas(Scanner scanner, Empresa10 empresa10){
        String nome = Empresa10.validandoNome(scanner,empresa10);
        int idade = Empresa10.validandoIdade(scanner);
        String departamento = Empresa10.validandoDepartamento(scanner,empresa10);
        if (gestaoOuAssistente(scanner)){
            Gerente10 gerente10 = Gerente10.validandoDadosGestao(scanner,nome,idade,departamento);
            empresa10.addPessoas(gerente10);
        }else {
            Assistente10 assistente10 = Assistente10.validandoDadosAssistente(scanner,nome,idade,departamento);
            empresa10.addPessoas(assistente10);
        }
    }

    public static boolean gestaoOuAssistente(Scanner scanner){
        String cargoGestaoOuAssistente="";
        do {
            System.out.print("é cargo de gestão ou de assistente?(sim/não):");
            cargoGestaoOuAssistente = scanner.nextLine().trim();
        }while (!cargoGestaoOuAssistente.equalsIgnoreCase("sim") && !cargoGestaoOuAssistente.equalsIgnoreCase("não"));
        return (cargoGestaoOuAssistente.equalsIgnoreCase("sim"));
    }


}
