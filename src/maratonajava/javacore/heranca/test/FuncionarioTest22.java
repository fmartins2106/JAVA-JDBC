package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente22;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa22;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente22;

import java.util.Scanner;

public class FuncionarioTest22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa22 empresa22 = new Empresa22();
        while (true){
            try {
                System.out.println("[1] Cadastro funcionário.");
                System.out.println("[2] Lista de funcionários.");
                System.out.println("[3] Pesquisa por nome.");
                System.out.println("[4] Excluir dados.");
                System.out.println("[5] Alterar dados.");
                System.out.println("[6] Sair.");
                System.out.print("Digite uma das opções acima.");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroFuncinario(scanner,empresa22);
                        break;
                    case 2:
                        empresa22.listarFuncionarios();
                        break;
                    case 3:
                        empresa22.exibirDadosPesquisaNome(scanner);
                        break;
                    case 4:
                        empresa22.excluirDados(scanner);
                        break;
                    case 5:
                        empresa22.alterarDadosFuncionario(scanner);
                        break;
                    case 6:
                        System.out.println(">>>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroFuncinario(Scanner scanner, Empresa22 empresa22){
        String nome = Empresa22.validandoNome(scanner);
        String cpf = Empresa22.validandoCpf(scanner);
        int idade = Empresa22.validandoIdade(scanner);
        String departamento = Empresa22.validandoDepartamento(scanner);
        if (temCargoGestao(scanner)){
            Gerente22 gerente22 = Gerente22.validandoDadosGerencia(scanner,nome,cpf,idade,departamento);
            empresa22.addFuncionario(gerente22);
        }else {
            Assistente22 assistente22 = Assistente22.validandoDadosAssistente(scanner,nome,cpf,idade,departamento);
            empresa22.addFuncionario(assistente22);
        }
    }

    private static boolean temCargoGestao(Scanner scanner){
        String cargoGestao = "";
        do {
            System.out.print("Tem cargo de gestão ?(sim/não):");
            cargoGestao = scanner.nextLine().trim();
        }while (!cargoGestao.equalsIgnoreCase("sim") && !cargoGestao.equalsIgnoreCase("não"));
        return (cargoGestao.equalsIgnoreCase("sim"));
    }
}
