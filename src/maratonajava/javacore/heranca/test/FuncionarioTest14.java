package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente14;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa14;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente14;

import java.util.Scanner;

public class FuncionarioTest14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa14 empresa14 = new Empresa14();
        while (true){
            System.out.println("[1] Cadastro de funcionário.");
            System.out.println("[2] Lista de funcionários.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Excluir dados.");
            System.out.println("[5] Alterar dados.");
            System.out.println("[6] Sair.");
            int opcao =0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    cadastroFuncionario(scanner,empresa14);
                    break;
                case 2:
                    empresa14.listaFuncionarios();
                    break;
                case 3:
                    empresa14.pesquisaPorNome(scanner,empresa14);
                    break;
                case 4:
                    empresa14.excluirDados(scanner,empresa14);
                    break;
                case 5:
                    empresa14.alterandoDados(scanner,empresa14);
                    break;
                case 6:
                    System.out.println(">>>Finalizando programa...");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroFuncionario(Scanner scanner, Empresa14 empresa14){
        String nome = Empresa14.validandoNome(scanner,empresa14);
        int idade = Empresa14.validandoIdade(scanner,empresa14);
        String cpf = Empresa14.validandoCpf(scanner,empresa14);
        String departamento = Empresa14.validandoDepartamento(scanner,empresa14);
        if (eCargoGesta(scanner)){
            Gerente14 gerente14 = Gerente14.validandoDadosGerencia(scanner,nome,idade,cpf,departamento);
            empresa14.addFuncionariosLista(gerente14);
        }else {
            Assistente14 assistente14 = Assistente14.validandoDadoCargoGeral(scanner,nome,idade,cpf,departamento);
            empresa14.addFuncionariosLista(assistente14);
        }
    }

    public static boolean eCargoGesta(Scanner scanner){
        String possuiCargoGestao = "";
        do {
            System.out.print("É cargo de gestão?(sim/não):");
            possuiCargoGestao = scanner.nextLine().trim();
        }while (!possuiCargoGestao.equalsIgnoreCase("sim") && !possuiCargoGestao.equalsIgnoreCase("não"));
        return (possuiCargoGestao.equalsIgnoreCase("sim"));
    }

}
