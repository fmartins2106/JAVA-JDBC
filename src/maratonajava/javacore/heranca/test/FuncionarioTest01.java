package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente01;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa01;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Funcionario01;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente01;

import java.util.HashSet;
import java.util.Scanner;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa01 empresa01 = new Empresa01();
        while (true){
            int opcao = 0;
            System.out.println("[1] Cadastro de pessoas.");
            System.out.println("[2] Listar funcionários.");
            System.out.println("[3] Buscar funcionário por nome.");
            System.out.println("[4] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida");
            }
            switch (opcao){
                case 1:
                    cadastroFuncionario(scanner,empresa01);
                    break;
                case 2:
                    empresa01.listarFuncionarios();
                    break;
                case 3:
                    empresa01.buscaNomeFuncionario(scanner,empresa01.getFuncionario01s());
                    break;
                case 4:
                    System.out.println(">>>Finalizando o programa.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastroFuncionario(Scanner scanner, Empresa01 empresa01){
        String nome = Empresa01.validandoNome(scanner, empresa01);
        int idade = Empresa01.validandoIdade(scanner);
        String departamento = Empresa01.validandoDepartamento(scanner, empresa01);
        String validandoFuncao="";
        do {
            System.out.print("Funcionário é Gerente ou Assistente07?");
            validandoFuncao = scanner.nextLine().trim().toLowerCase();
        }while (!validandoFuncao.equalsIgnoreCase("gerente") && !validandoFuncao.equalsIgnoreCase("assistente"));
        if ("gerente".equalsIgnoreCase(validandoFuncao)){
            String nivelGestao="";
            while (true){
                System.out.print("Digite o nível de gestão:");
                nivelGestao = scanner.nextLine().trim().toLowerCase();
                if (nivelGestao.isEmpty() || !nivelGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                    System.out.println("Campo não pode ser vazio ou conter caracteres.");
                }else {
                    Funcionario01.formatoNome(nivelGestao);
                    break;
                }
            }
            double salario = 0;
            while (true){
                try {
                    System.out.print("Salário:R$");
                    salario = Double.parseDouble(scanner.nextLine());
                    if (salario < 5000){
                        System.out.println("Salário de gente não pode ser menor que R$5.000,00");
                        continue;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
            empresa01.adicionarFuncionarios(new Gerente01(nome,idade,departamento,nivelGestao,salario));
        }else {
            if ("assistente".equalsIgnoreCase(validandoFuncao)){
                int horasTrabalho=0;
                while (true){
                    try {
                        System.out.print("Número de horas trabalhadas:");
                        horasTrabalho = Integer.parseInt(scanner.nextLine());
                        if (horasTrabalho < 0){
                            System.out.println("Horas trabalhadas não podem ser menor que 0.");
                            continue;
                        }
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
                    }
                }
                double salarioAssistente=0;
                while (true){
                    try {
                        System.out.println("Digite o salário de assistente:");
                        salarioAssistente = Double.parseDouble(scanner.nextLine());
                        if (salarioAssistente < 2000){
                            System.out.println("Salário de assistente não pode ser menor que R$2.000,00");
                            continue;
                        }
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
                    }
                }
                empresa01.adicionarFuncionarios(new Assistente01(nome,idade,departamento,horasTrabalho,salarioAssistente));
            }
        }
    }
}
