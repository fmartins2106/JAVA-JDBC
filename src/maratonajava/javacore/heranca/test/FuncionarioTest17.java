package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente17;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa17;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente17;

import java.util.Scanner;

public class FuncionarioTest17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa17 empresa17 = new Empresa17();
        while (true){
            System.out.println("[1] Cadastro de funcionário.");
            System.out.println("[2] Lista de funcionário.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Excluir dados.");
            System.out.println("[5] Alterar dados.");
            System.out.println("[6] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroFuncionario(scanner,empresa17);
                        break;
                    case 2:
                        empresa17.listaFuncionario();
                        break;
                    case 3:
                        empresa17.pesquisaPorNome(scanner,empresa17);
                        break;
                    case 4:
                        empresa17.excluirDadosFuncionario(scanner,empresa17);
                        break;
                    case 5:
                        empresa17.alterarDados(scanner,empresa17);
                        break;
                    case 6:
                        System.out.println(">>>Finalizando programa.");
                        return;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroFuncionario(Scanner scanner, Empresa17 empresa17){
        String nome = Empresa17.validandoNome(scanner,empresa17);
        String cpf = Empresa17.validandoCpf(scanner,empresa17);
        int idade = Empresa17.validandoIdade(scanner,empresa17);
        String departamento = Empresa17.validandoDepartamento(scanner,empresa17);
        if (CargoGestao(scanner)){
            Gerente17 gerente17 = Gerente17.validandoDadosGestao(scanner,nome,cpf,idade,departamento);
            empresa17.addFuncionario(gerente17);
        }else {
            Assistente17 assistente17 = Assistente17.validandoDadosGeral(scanner,nome,cpf,idade,departamento);
            empresa17.addFuncionario(assistente17);
        }
    }

    private static boolean CargoGestao(Scanner scanner){
        String temCargoGestao="";
        do {
            System.out.print("É cargo de gestão?(sim/não):");
            temCargoGestao = scanner.nextLine().trim();
        }while (!temCargoGestao.equalsIgnoreCase("sim") && !temCargoGestao.equalsIgnoreCase("não"));
        return (temCargoGestao.equalsIgnoreCase("sim"));
    }




}
