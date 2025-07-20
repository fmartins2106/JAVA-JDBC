package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente12;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa12;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente12;

import java.util.Scanner;

public class FuncionarioTest12 {
    public static void main(String[] args) {
        Empresa12 empresa12 = new Empresa12();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastro de funcionário.");
            System.out.println("[2] Lista de funcionário.");
            System.out.println("[3] Pesquisa Funcionário.");
            System.out.println("[4] Excluir dados.");
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
                    cadastroFuncionario(scanner,empresa12);
                    break;
                case 2:
                    empresa12.listaFuncionarios();
                    break;
                case 3:
                    empresa12.pesquisaPorNome(scanner,empresa12);
                case 4:
                    empresa12.excluirDados(scanner,empresa12);
                    break;
                case 5:
                    empresa12.alterandoDados(scanner,empresa12);
                    break;
                case 6:
                    System.out.println(">>>Finalizando programa....");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroFuncionario(Scanner scanner, Empresa12 empresa12){
        String nome = Empresa12.validandoNome(scanner,empresa12);
        int idade = Empresa12.validandoIdade(scanner,empresa12);
        String cpf = Empresa12.validandoCpf(scanner,empresa12);
        String departamento = Empresa12.validandoDepartamento(scanner,empresa12);
        if (eCargoGestao(scanner)){
            Gerente12 gerente12 = Gerente12.cadastrandoDadosGestao(scanner,nome,idade,cpf,departamento);
            empresa12.addFuncionarios(gerente12);
        }else {
            Assistente12 assistente12 = Assistente12.validandoDadosCargos(scanner,nome,idade,cpf,departamento);
            empresa12.addFuncionarios(assistente12);
        }
    }

    public static boolean eCargoGestao(Scanner scanner){
        String eCargoGestaoOuNao="";
        do {
            System.out.print("É cargo de gestão?(sim/não):");
            eCargoGestaoOuNao = scanner.nextLine().trim();
        }while (!eCargoGestaoOuNao.equalsIgnoreCase("sim") && !eCargoGestaoOuNao.equalsIgnoreCase("não"));
        return (eCargoGestaoOuNao.equalsIgnoreCase("sim"));
    }
}
