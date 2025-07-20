package academy.devdojo.maratonajava.javacore.heranca.test;

import academy.devdojo.maratonajava.javacore.heranca.dominio.Assistente03;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Empresa03;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Funcionario03;
import academy.devdojo.maratonajava.javacore.heranca.dominio.Gerente03;

import java.util.Scanner;

public class FuncionarioTest03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa03 empresa03 = new Empresa03();
        while (true){
            System.out.println("[1] Cadastrar funcionário.");
            System.out.println("[2] Lista de funcionários.");
            System.out.println("[3] Pesquisa de funcionários.");
            System.out.println("[4] Sair.");
            int opcao = 0;
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Digite um valor válido.");
            }
            switch (opcao){
                case 1:
                    CadastroFuncionario(scanner,empresa03);
                    break;
                case 2:
                    empresa03.listarFuncionarios();
                    break;
                case 3:
                    empresa03.pesquisaNome(scanner);
                    break;
                case 4:
                    System.out.println(">>>Finalizando programa.");
                    return;
                default:
                    System.out.println("Erro, digite uma opção válida.");
            }
        }
    }
    public static void CadastroFuncionario(Scanner scanner, Empresa03 empresa03){
        String nome = Empresa03.validandoNome(scanner,empresa03);
        String departamento = Empresa03.validandoDepartamento(scanner,empresa03);
        int idade = Empresa03.validandoIdade(scanner);
        String cargo = "";
        do {
            System.out.print("É Cargo de liderança ou assistente?:");
            cargo = scanner.nextLine().trim().toLowerCase();
        }while (!cargo.equals("liderança") && !cargo.equals("assistente"));
        if (cargo.equals("liderança")){
            String cargoGestao = "";
            while (true){
                System.out.print("Qual cargo de gestão?:");
                cargoGestao = scanner.nextLine().trim();
                if (empresa03.validandoString(cargoGestao)){
                    Funcionario03.formatoNome(cargoGestao);
                    break;
                }
            }
            double salario=0;
            while (true){
                try {
                    System.out.print("Salário:R$");
                    salario = Double.parseDouble(scanner.nextLine());
                    if (salario < 5000){
                        System.out.println("Salário não pode ser menor que R$5000");
                        continue;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
            empresa03.addPessoas(new Gerente03(nome,departamento,idade,cargoGestao,salario));
        }else {
            int horaTrabalhada=0;
            while (true){
                try {
                    System.out.print("Quantas horas trabalhada?:");
                    horaTrabalhada = Integer.parseInt(scanner.nextLine());
                    if (horaTrabalhada < 0){
                        System.out.println("Hora deve ser maior que zero.");
                        continue;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
            double salario;
            while (true){
                try {
                    System.out.print("Salário:");
                    salario = Double.parseDouble(scanner.nextLine());
                    if (salario < 2000){
                        System.out.println("Salário de assistente não pode ser menor que R$10.000");
                        continue;
                    }
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Digite um valor válido.");
                }
            }
            empresa03.addPessoas(new Assistente03(nome,departamento,idade,horaTrabalhada,salario));
        }
    }


}
