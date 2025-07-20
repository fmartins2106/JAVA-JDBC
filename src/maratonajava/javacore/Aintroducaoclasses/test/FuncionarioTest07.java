package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Funcionario07;

import java.util.*;

public class FuncionarioTest07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario07> funcionario07s = new ArrayList<>();

        while (true){
            int opcao =0;
            System.out.println("[ 1 ] Cadastrar funcionário.");
            System.out.println("[ 2 ] Relatório funcionário cadastrado.");
            System.out.println("[ 3 ] Alterar dados funcionário.");
            System.out.println("[ 4 ] Sair.");
            try {
                System.out.print("Digite uma das opções acima:");
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao< 0 || opcao >4){
                    System.out.println("ERRO. Digite uma opção válida. Tente novamente.");
                    continue;
                }
            }catch (NumberFormatException erro){
                System.out.println(erro.getMessage());
            }
            switch (opcao){
                case 1:
                    String nome = Funcionario07.verificandoNome(scanner);
                    double salario = Funcionario07.validandoSalario(scanner);
                    String cargo = Funcionario07.validandoCargo(scanner);
                    Funcionario07 funcionario = new Funcionario07(nome,salario,cargo);
                    funcionario07s.add(funcionario);
                    break;

                case 2:
                    if (funcionario07s.isEmpty()){
                        System.out.println("Lista vazia. Cadastre um funcionário. Tente novamente.");
                    }else {
                        for (int i = 0; i < funcionario07s.size(); i++) {
                            Funcionario07 funcionario07 = funcionario07s.get(i);
                            funcionario07.exbindoRelatorioFuncionarios(i, funcionario07s.size());
                        }
                    }
                    break;

                case 3:
                    if (funcionario07s.isEmpty()){
                        System.out.println("ERRO. Lista vazia, cadastre um  funcionario.");
                    }else {
                        while (true){
                            try {
                                System.out.print("Digite a matricula do funcionário:");
                                int matricula = Integer.parseInt(scanner.nextLine());
                                if (matricula <0 || matricula>= funcionario07s.size()){
                                    System.out.println("ERRO. Digite um número de matricula válido. Tente novamente.");
                                }else {
                                    Funcionario07 funcionarios = funcionario07s.get(matricula);
                                    String novoNome = Funcionario07.verificandoNome(scanner);
                                    funcionarios.setNome(novoNome);
                                    double novoSalario = Funcionario07.validandoSalario(scanner);
                                    funcionarios.setSalario(novoSalario);
                                    String novoCargo = Funcionario07.validandoCargo(scanner);
                                    funcionarios.setCargo(novoCargo);
                                    break;
                                }
                            }catch (NumberFormatException e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println(">>>Finalizando programa...");
                    return;

                default:
                    System.out.println("ERRO. Digite uma opção válida. Tente novamente.");
            }
        }
    }
}
