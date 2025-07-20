package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Funcionario06;

import java.util.*;

public class FuncionarioTest06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario06>  funcionario06s =new ArrayList<>();

        while (true){
            int opcao=0;
            System.out.println(">>>Escolha uma das opções abaixo:");
            System.out.println("[ 1 ]- Cadastrar funcionário.");
            System.out.println("[ 2 ]- Listar Funcionários.");
            System.out.println("[ 3 ]- Filtrar Funcionário.");
            System.out.println("[ 4 ]- Sair.");
            System.out.print("Escolha uma opção:");
            if (scanner.hasNextInt()){
                opcao = scanner.nextInt();
                scanner.nextLine();
            }else {
                System.out.println("Opção inválita. Tente novamente.");
                scanner.nextLine();
                continue;
            }


            switch (opcao){
                case 1:
                    String nome = Funcionario06.validandoNome(scanner);
                    String cargo = Funcionario06.validandoCargo(scanner);
                    double salario = Funcionario06.verificandoSalario(scanner);
                    int experiencia = Funcionario06.validandoExperiencia(scanner);
                    Funcionario06 funcionario06 = new Funcionario06(nome,cargo,salario,experiencia);
                    funcionario06s.add(funcionario06);
                    System.out.println("Funcionario cadastrador com sucesso...");
                    break;

                case 2:
                    for (int i = 0; i < funcionario06s.size() ; i++) {
                        Funcionario06 funcionario = funcionario06s.get(i);
                        funcionario.exibindoResultados(i,funcionario06s.size());
                    }
                    break;

                case 3:
                    System.out.print("Filtrar cargo por:");
                    String filtroCargo = scanner.nextLine().trim();
                    System.out.println("\nFuncioario com cargo:"+filtroCargo);
                    boolean encontrado = false;
                    for (Funcionario06 funcionario : funcionario06s){
                        if (funcionario.getCargo().equalsIgnoreCase(filtroCargo)){
                            System.out.printf("%-15s Cargo:%-8s R$%-8.2f Experiência:%-2d anos\n",funcionario.getNome(),funcionario.getCargo(),funcionario.getSalario(),funcionario.getExperiencia());
                            encontrado =true;
                        }
                    }
                    if (!encontrado){
                        System.out.println("Nenhum funcionário foi encontrado, tente novamente.");
                    }
                    break;

                case 4:
                    System.out.println(">>>Finalizando o programa...");
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
