package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente16;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa16;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente16;

import java.util.Scanner;

public class FuncionarioTest16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa16 empresa16 = new Empresa16();
        while (true){
            System.out.println("[1] Cadastro de funcionário.");
            System.out.println("[2] Lista de funcionário.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Excluir dados.");
            System.out.println("[5] Alterar dados.");
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
                    cadastroFuncionarios(scanner,empresa16);
                    break;
                case 2:
                    empresa16.listaFuncionarios();
                    break;
                case 3:
                    empresa16.pesquisaPorNome(scanner,empresa16);
                    break;
                case 4:
                    empresa16.excluindoDados(scanner,empresa16);
                    break;
                case 5:
                    empresa16.alterarDados(scanner,empresa16);
                    break;
                case 6:
                    System.out.println(">>Finalizando programa.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }
    public static void cadastroFuncionarios(Scanner scanner, Empresa16 empresa16){
        String nome = Empresa16.validandoNome(scanner,empresa16);
        String cpf = Empresa16.validandoCpf(scanner,empresa16);
        int idade = Empresa16.validandoIdade(scanner,empresa16);
        String departamento = Empresa16.validandoDepartamento(scanner,empresa16);
        if (eCargoGestao(scanner)) {
            Gerente16 gerente16 = Gerente16.validandoDadosGerencia(scanner,nome,cpf,idade,departamento);
            empresa16.addFuncionarios(gerente16);
        }else {
            Assistente16 assistente16 = Assistente16.validadosAssistente(scanner,nome,cpf,idade,departamento);
            empresa16.addFuncionarios(assistente16);
        }
    }

    public static boolean eCargoGestao(Scanner scanner){
        String temCargoGestao ="";
        do {
            System.out.print("Tem cargo de gestão?(sim/não):");
            temCargoGestao = scanner.nextLine().trim();
        }while (!temCargoGestao.equalsIgnoreCase("sim") && !temCargoGestao.equalsIgnoreCase("não"));
        return (temCargoGestao.equalsIgnoreCase("sim"));
    }

}
