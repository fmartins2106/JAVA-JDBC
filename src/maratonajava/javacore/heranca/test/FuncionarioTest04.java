package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente04;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa04;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Funcionario04;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente04;

import java.util.Scanner;

public class FuncionarioTest04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa04 empresa04 = new Empresa04();
        while (true){
            System.out.println("[1] Cadastro de funcionário.");
            System.out.println("[2] Lista de funcionário.");
            System.out.println("[3] Pesquia de funcionário.");
            System.out.println("[4] Sair. ");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    cadastrandoFuncionarios(scanner,empresa04);
                    break;
                case 2:
                    empresa04.listaProdutos();
                    break;
                case 3:
                    empresa04.pesquisaProdutos(scanner);
                    break;
                case 4:
                    System.out.println(">>>Finalizando o programa...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static final double SALARIO_GESTAO = 5000;
    public static void cadastrandoFuncionarios(Scanner scanner, Empresa04 empresa04){
        String nome = Empresa04.validandoNome(scanner,empresa04);
        String departamento = Empresa04.validandoDepartamento(scanner,empresa04);
        int idade = Empresa04.validandoIdade(scanner);
        String definindoCargo = "";
        do {
            System.out.print("Cartão de gestão ou assistente?(Gestão/Assistente07):");
            definindoCargo = scanner.nextLine().trim().toLowerCase();
        }while (!definindoCargo.equalsIgnoreCase("gestão") && !definindoCargo.equalsIgnoreCase("assistente"));
        if (definindoCargo.equalsIgnoreCase("gestão")){
            String cargoGestao ="";
            double salarioGestao=0;
            while (true){
                System.out.print("Cargo:");
                cargoGestao = scanner.nextLine().trim().toLowerCase();



                if (empresa04.validandoString(cargoGestao)){
                    Funcionario04.formatoNome(cargoGestao);
                }
                try {
                    System.out.print("Salário:R$");
                    salarioGestao = Double.parseDouble(scanner.nextLine());
                    if (salarioGestao < SALARIO_GESTAO){
                        System.out.println("Salário para cargo de gestão não pode ser menor que R$5.000");
                        continue;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
            empresa04.addFuncionarios(new Gerente04(nome,departamento,idade,cargoGestao,salarioGestao));
        }else {
            int horasTrabalhada=0;
            while (true){
                try {
                    System.out.print("Quantas horas trabalhada?:");
                    horasTrabalhada = Integer.parseInt(scanner.nextLine());
                    if (horasTrabalhada < Assistente04.HORAS_MINIMAS){
                        System.out.println("Horas não pode ser menor que zero.");
                        continue;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
            double salario = 0;
            while (true){
                try {
                    System.out.print("Salário:R$");
                    salario = Double.parseDouble(scanner.nextLine());
                    if (salario < Assistente04.SALARIO_ASSISTENTE){
                        System.out.println("Salário de assistente não pode ser menor que R$2.000");
                        continue;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
            empresa04.addFuncionarios(new Assistente04(nome,departamento,idade, horasTrabalhada ,salario));
        }
    }
}
