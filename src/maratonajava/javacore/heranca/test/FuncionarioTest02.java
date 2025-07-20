package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente02;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa02;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Funcionario01;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente02;

import java.util.Scanner;

public class FuncionarioTest02 {
    public static void main(String[] args) {
        Empresa02 empresa02 = new Empresa02();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("[1] Cadastrar funcionário.");
            System.out.println("[2] Listar funcionário.");
            System.out.println("[3] Pesquisa por nome.");
            System.out.println("[4] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite uma opção válida.");
            }
            switch (opcao){
                case 1:
                    cadastrandoFuncionario(scanner,empresa02);
                    break;
                case 2:
                    empresa02.listarProdutos(scanner, empresa02.getFuncionario02s());
                    break;
                case 3:
                    empresa02.buscaFuncionariosNome(scanner,empresa02.getFuncionario02s());
                    break;
                case 4:
                    System.out.println("Digite um valor válido.");
                    return;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        }
    }

    public static void cadastrandoFuncionario(Scanner scanner,Empresa02 empresa02){
        String nome = Empresa02.validandoNome(scanner,empresa02);
        String departamento = Empresa02.validandoDepartamento(scanner,empresa02);
        int idade = Empresa02.validandoIdade(scanner);
        String escolhandoFuncao="";
        do {
            System.out.print("Qual a função?(Gerente ou Assistente07):");
            escolhandoFuncao = scanner.nextLine().trim();
        }while (!escolhandoFuncao.equals("gerente") && !escolhandoFuncao.equals("assistente"));
        if ("gerente".equals(escolhandoFuncao)){
            String nivelGestao="";
            while (true){
                System.out.print("Nivel de gestão:");
                nivelGestao = scanner.nextLine().trim();
                if (nivelGestao.isEmpty() || !nivelGestao.matches("^[\\p{L}]+( [\\p{L}]+)*$")){
                    System.out.println("Campo não aceita caracteres ou espaço vazio.");
                }else {
                    Funcionario01.formatoNome(nivelGestao);
                    break;
                }
            }
            double salario=0;
            while (true){
                try {
                    System.out.print("Digite o salário:R$");
                    salario = Double.parseDouble(scanner.nextLine());
                    if (salario < 5000){
                        System.out.println("Salário de gerente não pode ser menor que R$5.000,00");
                    }else {
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
            empresa02.addFuncionarios(new Gerente02(nome,departamento,idade,nivelGestao,salario));
        }else {
            if ("assistente".equals(escolhandoFuncao)){
                int horasTrabalhadas = 0;
                while (true){
                    try {
                        System.out.print("Hora trabalhada:");
                        horasTrabalhadas = Integer.parseInt(scanner.nextLine());
                        if (horasTrabalhadas < 0){
                            System.out.println("Horas não podem ser negativas.");
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
                        System.out.print("Salário:R$");
                        salarioAssistente = Double.parseDouble(scanner.nextLine());
                        if (salarioAssistente < 2000){
                            System.out.println("Salário de assistente não pode ser menor que R$2.000");
                            continue;
                        }
                        break;
                    }catch (NumberFormatException e){
                        System.out.println("Digite um valor válido.");
                    }
                }
                empresa02.addFuncionarios(new Assistente02(nome,departamento,idade,horasTrabalhadas,salarioAssistente));
            }
        }

    }
}
