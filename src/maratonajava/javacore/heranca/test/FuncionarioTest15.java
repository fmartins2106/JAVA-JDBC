package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente15;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa15;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente15;

import java.util.Scanner;

public class FuncionarioTest15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa15 empresa15 = new Empresa15();
        while (true){
            System.out.println("[1] Cadastro funcionário.");
            System.out.println("[2] Lista de funcionários.");
            System.out.println("[3] Pesquisa funcionário.");
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
                    cadastroFuncionario(scanner,empresa15);
                    break;
                case 2:
                    empresa15.listaFuncionarios();
                    break;
                case 3:
                    empresa15.pesquisaPorNome(scanner,empresa15);
                    break;
                case 4:
                    empresa15.excluirCadastro(scanner,empresa15);
                    break;
                case 5:
                    empresa15.alterarCadastro(scanner,empresa15);
                    break;
                case 6:
                    System.out.println(">>>fINALIZANDO PROGRAMA COM SUCESSO.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroFuncionario(Scanner scanner, Empresa15 empresa15){
        String nome = Empresa15.validandoNome(scanner, empresa15);
        String cpf = Empresa15.validandoCpf(scanner, empresa15);
        int idade = Empresa15.validandoIdade(scanner,empresa15);
        String departamento = Empresa15.validandoDepartamento(scanner,empresa15);
        if (DefinindoCargo(scanner)){
            Gerente15 gerente15 = Gerente15.validandoDadosGestao(scanner,nome,idade,cpf,departamento);
            empresa15.addFuncionarios(gerente15);
        }else {
            Assistente15 assistente15 = Assistente15.validandoDadosCargoGeral(scanner,nome,idade,cpf,departamento);
            empresa15.addFuncionarios(assistente15);
        }
    }

    public static boolean DefinindoCargo(Scanner scanner){
        String temCargoGestao="";
        do {
            System.out.print("É cargo de gestão?(sim/não):");
            temCargoGestao = scanner.nextLine().trim().toLowerCase();
        }while (!temCargoGestao.equalsIgnoreCase("sim") && !temCargoGestao.equalsIgnoreCase("não"));
        return (temCargoGestao.equalsIgnoreCase("sim"));
    }


}
