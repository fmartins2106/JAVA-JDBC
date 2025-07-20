package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente13;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa13;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente13;

import java.util.Scanner;

public class FuncionarioTest13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa13 empresa13 = new Empresa13();
        while (true){
            System.out.println("[1] Cadastro funcionário.");
            System.out.println("[2] Lista de funcionários.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Excluir dados.");
            System.out.println("[5] Alterar dados.");
            System.out.println("[6] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    cadastroFuncionario(scanner,empresa13);
                    break;
                case 2:
                    empresa13.listaFuncionarios();
                    break;
                case 3:
                    empresa13.pesquisaPorNome(scanner,empresa13);
                    break;
                case 4:
                    empresa13.excluirDados(scanner,empresa13);
                    break;
                case 5:
                    empresa13.alterarDadosFuncionario(scanner,empresa13);
                    break;
                case 6:
                    System.out.println(">>>Finalizando Programa...");
                    return;
                default:
                    System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void cadastroFuncionario(Scanner scanner, Empresa13 empresa13){
        String nome = Empresa13.validandoNome(scanner,empresa13);
        String cpf = Empresa13.validandoCpf(scanner,empresa13);
        int idade = Empresa13.validandoIdade(scanner,empresa13);
        String departamento = Empresa13.validandoDepartamento(scanner,empresa13);
        if (cargoGestaOuAssistente(scanner)){
            Gerente13 gerente13 = Gerente13.validandoDadosGestao(scanner,nome,cpf,idade,departamento);
            empresa13.addFuncionarios(gerente13);
        }else {
            Assistente13 assistente13 = Assistente13.validacaoDadosGeral(scanner,nome,cpf,idade,departamento);
            empresa13.addFuncionarios(assistente13);
        }
    }

    public static boolean cargoGestaOuAssistente(Scanner scanner){
        String eCargoGestao="";
        do {
            System.out.print("É cargo de gestão?(sim/não):");
            eCargoGestao = scanner.nextLine().trim();
        }while (!eCargoGestao.equalsIgnoreCase("sim") && !eCargoGestao.equalsIgnoreCase("não"));
        return (eCargoGestao.equalsIgnoreCase("sim"));
    }
}
