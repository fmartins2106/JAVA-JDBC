package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistete20;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa20;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente20;

import java.util.Scanner;

public class FuncionarioTest20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa20 empresa20 = new Empresa20();
        while (true){
            System.out.println("[1] Cadastro funcionário.");
            System.out.println("[2] Lista funcionário.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Excluir dados.");
            System.out.println("[5] Alterar dados.");
            System.out.println("[6] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroFuncionarios(scanner,empresa20);
                        break;
                    case 2:
                        empresa20.listaFuncionarios();
                        break;
                    case 3:
                        empresa20.exibirDadosPesquisa(scanner);
                        break;
                    case 4:
                        empresa20.excluirDados(scanner);
                        break;
                    case 5:
                        empresa20.alterarDadosFucionario(scanner);
                        break;
                    case 6:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um opção válida.");
            }
        }
    }

    public static void cadastroFuncionarios(Scanner scanner, Empresa20 empresa20){
        String nome = Empresa20.validandoNome(scanner);
        String cpf = Empresa20.validandoCpf(scanner);
        int idade = Empresa20.validandoIdade(scanner);
        String departamento = Empresa20.validandoDepartamento(scanner);
        if (temCargoGestao(scanner)){
            Gerente20 gerente20 = Gerente20.validandoDadosCargoGestao(scanner,nome,cpf,idade,departamento);
            empresa20.addFuncionario(gerente20);
        }else {
            Assistete20 assistete20 = Assistete20.validandoDadosAssistente(scanner,nome,cpf,idade,departamento);
            empresa20.addFuncionario(assistete20);
        }
    }

    public static boolean temCargoGestao(Scanner scanner){
        String cargoGestao = "";
        do {
            System.out.print("Tem cargo de gestão?(sim/não):");
            cargoGestao = scanner.nextLine().trim();
        }while (!cargoGestao.equalsIgnoreCase("sim") && !cargoGestao.equalsIgnoreCase("não"));
        return (cargoGestao.equalsIgnoreCase("sim"));
    }
}
