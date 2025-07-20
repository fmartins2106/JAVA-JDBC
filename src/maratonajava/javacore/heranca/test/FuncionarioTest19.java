package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente19;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa19;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente19;

import java.util.Scanner;

public class FuncionarioTest19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa19 empresa19 = new Empresa19();
        while (true){
            System.out.println("[1] Cadastro funcionário.");
            System.out.println("[2] Lista de funcionários.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] excluir dados.");
            System.out.println("[5] Alterar dados.");
            System.out.println("[6] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroFuncionario(scanner,empresa19);
                        break;
                    case 2:
                        empresa19.listaFuncionarios();
                        break;
                    case 3:
                        empresa19.exibindoDadosPesquisa(scanner);
                        break;
                    case 4:
                        empresa19.excluirDadosFuncionario(scanner);
                        break;
                    case 5:
                        empresa19.alterarDadosFuncionarios(scanner);
                        break;
                    case 6:
                        System.out.println(">>>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static void cadastroFuncionario(Scanner scanner, Empresa19 empresa19){
        String nome = Empresa19.validandoNome(scanner);
        String cpf = Empresa19.validandoCpf(scanner);
        int idade = Empresa19.validandoIdade(scanner);
        String departamento = Empresa19.validandoDepartamento(scanner);
        if (temCargoGestao(scanner)){
            Gerente19 gerente19 = Gerente19.validandoDadosGerencia(scanner,nome,cpf,idade,departamento);
            empresa19.addFuncionario(gerente19);
        }else {
            Assistente19 assistente19 = Assistente19.validandoDadosCargoGeral(scanner,nome,cpf,idade,departamento);
            empresa19.addFuncionario(assistente19);
        }
    }

    public static boolean temCargoGestao(Scanner scanner){
        String CargoGestao = "";
        do {
            System.out.print("Tem cargo de gestão(sim/não)?:");
            CargoGestao = scanner.nextLine().trim();
        }while (!CargoGestao.equalsIgnoreCase("sim") && !CargoGestao.equalsIgnoreCase("não"));
        return (CargoGestao.equalsIgnoreCase("sim"));
    }
}
