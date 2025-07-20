package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente21;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa21;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente21;

import java.util.Scanner;

public class FuncionarioTest21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa21 empresa21 = new Empresa21();
        while (true){
            try {
                System.out.println("[1] Cadastro funcionário.");
                System.out.println("[2] Lista de funcionários cadastrados.");
                System.out.println("[3] Exibir dados pesquisa por nome.");
                System.out.println("[4] Excluir dados pesquisa.");
                System.out.println("[5] Alterar dados pesquisa.");
                System.out.println("[6] Sair.");
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroFuncionario(scanner,empresa21);
                        break;
                    case 2:
                        empresa21.listaFuncionarios();
                        break;
                    case 3:
                        empresa21.ExibidadosPesquisaNome(scanner);
                        break;
                    case 4:
                        empresa21.excluirDadosFuncionario(scanner);
                        break;
                    case 5:
                        empresa21.alterarDadosFuncionario(scanner);
                        break;
                    case 6:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroFuncionario(Scanner scanner, Empresa21 empresa21){
        String nome = Empresa21.validandoNome(scanner);
        String cpf = Empresa21.validandoCpf(scanner);
        int idade = Empresa21.validandoIdade(scanner);
        String departamento = Empresa21.validandoDepartamento(scanner);
        if (temCargoGestao(scanner)){
            Gerente21 gerente21 = Gerente21.validandoDadosGerencia(scanner,nome,cpf,idade,departamento);
            empresa21.addFuncionario(gerente21);
        }else {
            Assistente21 assistente21 = Assistente21.validandoDadosAssistente(scanner,nome,cpf,idade,departamento);
            empresa21.addFuncionario(assistente21);
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
