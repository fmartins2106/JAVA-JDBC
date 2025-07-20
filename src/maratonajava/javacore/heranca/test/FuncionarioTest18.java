package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente18;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa18;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente18;

import java.util.Scanner;

public class FuncionarioTest18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa18 empresa18 = new Empresa18();
        while (true){
            System.out.println("[1] Cadastro funcionário.");
            System.out.println("[2] Lista de funcionários.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Excluir dados funcionários.");
            System.out.println("[5] Alterar dados funcionários.");
            System.out.println("[6] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                int opcao =  Integer.parseInt(scanner.nextLine());
                switch (opcao){
                    case 1:
                        cadastroFuncionario(scanner,empresa18);
                        break;
                    case 2:
                        empresa18.listaFuncionarios();
                        break;
                    case 3:
                        empresa18.exibindoDadosPesquisa(scanner,empresa18);
                        break;
                    case 4:
                        empresa18.excluindoDadosPesquisa(scanner,empresa18);
                        break;
                    case 5:
                        empresa18.alterandoDadosFuncionarios(scanner,empresa18);
                        break;
                    case 6:
                        System.out.println(">>>Finalizando programa...");
                        return;
                    default:
                        System.out.println("Digite um valor válido.");
                }
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido.");
            }
        }
    }

    public static void cadastroFuncionario(Scanner scanner, Empresa18 empresa18){
        String nome = Empresa18.validandoNome(scanner);
        String cpf = Empresa18.validandoCpf(scanner);
        int idade = Empresa18.validandoIdade(scanner);
        String departamento = Empresa18.validandoDepartamento(scanner);
        if (temCargoGestao(scanner)){
            Gerente18 gerente18 = Gerente18.validandoDadosGerente(scanner,nome,cpf,idade,departamento);
            empresa18.addFuncionarios(gerente18);
        }else {
            Assistente18 assistente18 = Assistente18.validandoDadosAssistente(scanner,nome,cpf,idade,departamento);
            empresa18.addFuncionarios(assistente18);
        }
        System.out.println("Dados cadstrados com sucesso.");
    }

    public static boolean temCargoGestao(Scanner scanner){
        String cargoGestao;
        do {
            System.out.print("Tem cargo gestão?(sim/não):");
            cargoGestao = scanner.nextLine().trim();
        }while (!cargoGestao.equalsIgnoreCase("sim") && !cargoGestao.equalsIgnoreCase("não"));
        return (cargoGestao.equalsIgnoreCase("sim"));
    }


}
